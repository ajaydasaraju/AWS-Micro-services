/**
 * 
 */
package com.renal.nh.patient.domain.time;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.datetime.DateFormatter;

/**
 * @author dasaraa
 *
 */
public class ClinicTime implements Serializable, Comparable<ClinicTime>  {

	private static final long serialVersionUID = 140428339671353342L;

	private static final String CLINIC_TIME_FORMAT = "dd-MM-yyyy";

	private static final Logger LOGGER = LoggerFactory.getLogger(ClinicTime.class);

	private static final int MILLIS_IN_HOUR = 3600000;

	private static final String GMT = "GMT";

	private static final int DATE_STRING_END = 10;

	private static final String ERROR_MESSAGE = "Error parsing the date String into clinic Time {}";

	private TimeZone timeZone;

	/**
	 * Represent a time in clinic time zone.
	 */
	private Calendar calendar;

	/**
	 * Constructor a ClinicTime instance with current date.
	 */
	public ClinicTime() {
		this(new Date());
	}

	/**
	 * Construct the date in the specified time zone to ClinicTimeZoneTime, use the calendar the keep the timeZone info
	 * as well as the timeStamp info.
	 * 
	 * @param aTimestamp a date object as timeStamp (GMT).
	 * @param clinicTimeZone the clinic time Zone.
	 */
	public ClinicTime(Date aTimestamp, TimeZone clinicTimeZone) {
		this.timeZone = clinicTimeZone;

		// Convert to the same clock time in GMT time zone
		this.calendar = Calendar.getInstance(this.timeZone);

		this.calendar.setTimeInMillis(aTimestamp.getTime());
	}

	/**
	 * Construct the date (a GMT timeStamp) to ClinicTimeZoneTime, retrieve the clinic Time Zone from the ThreadLocal
	 * ClinicTimeZoneHolder, use the calendar the keep the timeZone info as well as the timeStamp info.
	 * 
	 * @param aDateInGMTTimeZone aTimestamp a date object as timeStamp (GMT).
	 */
	public ClinicTime(Date aDateInGMTTimeZone) {
		this(aDateInGMTTimeZone, ClinicTimeZoneHolder.getClinicTimeZone());
	}

	/**
	 * Construct the Date String (in clinic Time Zone) to ClinicTimeZoneTime, retrieve the clinic Time Zone from the
	 * ThreadLocal ClinicTimeZoneHolder, use the default Locale.ENGLISH to parse the string to date. Will throw a
	 * runtime IllegalArgumentException if the format of the string is incorrect.
	 * 
	 * @param dateString the input date String (in clinic Time Zone)
	 * @param timePattern the Pattern to convert the string to date
	 */
	public ClinicTime(String dateString, String timePattern) {
		DateFormatter dateFormatter = new DateFormatter(timePattern);
		dateFormatter.setTimeZone(ClinicTimeZoneHolder.getClinicTimeZone());
		Date clinicDate;
		try {
			clinicDate = dateFormatter.parse(dateString, Locale.getDefault());
			this.timeZone = ClinicTimeZoneHolder.getClinicTimeZone();
			this.calendar = Calendar.getInstance(this.timeZone);
			this.calendar.setTimeInMillis(clinicDate.getTime());
		} catch (ParseException e) {
			LOGGER.trace(ERROR_MESSAGE, e);
			throw new IllegalArgumentException(ERROR_MESSAGE, e);
		}
	}

	/**
	 * Construct the ClinicTime for solve the error in daylight saving. In case a treatment time occurred during the
	 * daylight saving period e.g. 2016-03-13T02:30:05.235, this time cannot be converted to the clinic time zone time.
	 * The design to get the time zone offset according to the noon time on treatment start date, then add this offset
	 * to all the time sent in the treatment file.
	 * 
	 * 
	 * @param dateString date string from treatment file
	 * @param timePattern date string pattern
	 * @param treatmentStart treatment start date from treatment file
	 */
	public ClinicTime(String dateString, String timePattern, String treatmentStart) {
		// get clinic time zone
		this.timeZone = ClinicTimeZoneHolder.getClinicTimeZone();

		// construct the noon time in treatment start date
		String treatmentStartDateStr = treatmentStart.substring(0, DATE_STRING_END);
		treatmentStartDateStr = treatmentStartDateStr + " 12:00:00";
		try {
			// Get time offset by the noon of treatmentStartdate
			SimpleDateFormat startdf = new SimpleDateFormat(CLINIC_TIME_FORMAT);
			startdf.setTimeZone(this.timeZone);
			Date startDate = startdf.parse(treatmentStartDateStr);
			int timeOffSet = this.timeZone.getOffset(startDate.getTime());

			// get GMTDate of dateString
			DateFormatter dateFormatter = new DateFormatter(timePattern);
			dateFormatter.setTimeZone(TimeZone.getTimeZone(GMT));
			Date gmtTime = dateFormatter.parse(dateString, Locale.getDefault());

			// set gmtTime - timeOffset to get clinic time zone time.
			this.calendar = Calendar.getInstance(this.timeZone);
			this.calendar.setTimeInMillis(new Date(gmtTime.getTime() - timeOffSet).getTime());
		} catch (ParseException e) {
			LOGGER.trace(ERROR_MESSAGE, e);
			throw new IllegalArgumentException(ERROR_MESSAGE, e);
		}
	}

	/**
	 * Construct the Date String (in clinic Time Zone) to ClinicTimeZoneTime, retrieve the clinic Time Zone from the
	 * ThreadLocal ClinicTimeZoneHolder, use the default Locale.ENGLISH to parse the string to date. Will throw a
	 * runtime IllegalArgumentException if the format of the string is incorrect.
	 * 
	 * @param dateString the input date String (in clinic Time Zone)
	 * @param timePattern the Pattern to convert the string to date
	 * @param locale the locale of the clinic time.
	 */
	public ClinicTime(String dateString, String timePattern, Locale locale) {
		DateFormatter dateFormatter = new DateFormatter(timePattern);
		dateFormatter.setTimeZone(ClinicTimeZoneHolder.getClinicTimeZone());
		Date clinicDate;
		try {
			clinicDate = dateFormatter.parse(dateString, locale);
			this.timeZone = ClinicTimeZoneHolder.getClinicTimeZone();
			this.calendar = Calendar.getInstance(this.timeZone);
			this.calendar.setTimeInMillis(clinicDate.getTime());
		} catch (ParseException e) {
			LOGGER.trace(ERROR_MESSAGE, e);
			throw new IllegalArgumentException(ERROR_MESSAGE, e);
		}
	}

	/**
	 * Get the Date in UTC timeZone
	 * 
	 * @return the date in UTC timeZone
	 */
	public Date getTimeInUTC() {
		// Convert to the same clock time in UTC time zone
		return this.calendar.getTime();
	}

	/**
	 * truncate the clinic time zone.
	 * 
	 * @param field the field from <code>Calendar</code> or <code>SEMI_MONTH</code>
	 * 
	 *            <li>
	 *            Support parameters e.g. Calendar.DATE, Calendar.MONTH etc.</li>
	 * @return a new clinic time
	 */
	public ClinicTime truncateInClinicTimeZone(int field) {
		return new ClinicTime(DateUtils.truncate(this.calendar, field).getTime());
	}

	/**
	 * Get the copy of the clinic timeZone.
	 * 
	 * @return the timeZone
	 */
	public TimeZone getTimeZone() {
		return TimeZone.getTimeZone(this.timeZone.getID());
	}

	/**
	 * Add a certain amount to the clinic time. This method has to be used when trying to add some amount to current
	 * clinic time, instead of using DateUtils, 'cause the calendar's time zone of DateUtils is always the time zone of
	 * the environment rather than the time zone of a clinic, which will cause problem when add some amount to a date
	 * when day light saving is switched.
	 * 
	 * 
	 * @param field the calendar field, i.e., Calendar.Month, Calendar.DAY_OF_MONTH
	 * @param amount the amount to add to the calendar
	 * @return a new clinic time zone
	 */
	public ClinicTime add(int field, int amount) {
		Date timeInUTC = this.getTimeInUTC();

		Calendar c = Calendar.getInstance(ClinicTimeZoneHolder.getClinicTimeZone());
		c.setTime(timeInUTC);
		c.add(field, amount);

		return new ClinicTime(c.getTime());
	}

	/**
	 * The toString Method is to return the String, which contains Clinic TimeZone, Timestamp and Offset, in order to
	 * make it easier for debug and unit test {@inheritDoc}
	 */
	@Override
	public String toString() {
		DateFormatter dateFormatter = new DateFormatter(CLINIC_TIME_FORMAT);
		dateFormatter.setTimeZone(this.getTimeZone());
		StringBuilder builder = new StringBuilder();
		builder.append(this.getClass().getSimpleName()).append(" : [ Time in Clinic TimeZone = ")
				.append(dateFormatter.print(this.getTimeInUTC(), Locale.getDefault())).append(", TimeStamp=")
				.append(this.calendar.getTimeInMillis()).append(", ClinicTimeZone=").append(this.timeZone.getDisplayName())
				.append(", ClinicTimeZone OffSet=")
				.append(this.timeZone.getOffset(this.calendar.getTimeInMillis()) / MILLIS_IN_HOUR).append("]");
		return builder.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.calendar.hashCode();
		result = prime * result + this.timeZone.hashCode();
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		ClinicTime other = (ClinicTime) obj;
		if (!this.calendar.equals(other.calendar)) {
			return false;
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Null date always smaller than non-null date {@inheritDoc}
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(ClinicTime o) {
		return ComparatorUtils.nullLowComparator(null).compare(this.getTimeInUTC(), o.getTimeInUTC());
	}

}
