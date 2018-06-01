/**
 * 
 */
package com.renal.nh.patient.domain.time;

import java.util.TimeZone;

/**
 * @author dasaraa
 *
 */
public class ClinicTimeZoneHolder {
	
	/**
	 * Default constructor
	 */
	private ClinicTimeZoneHolder() {
		// intentionally do nothing
	}

	/**
	 * Always set a new context instance to current thread before using this holder. This is essential to make sure
	 * context will not be cached by current thread, which may be reused by web server's thread-pool
	 */
	private static ThreadLocal<TimeZone> clinicTimeZone = new ThreadLocal<TimeZone>();

	/**
	 * Get the clincTimeZone.
	 * 
	 * @return the clinic timezone.
	 */
	public static TimeZone getClinicTimeZone() {
		return clinicTimeZone.get();
	}

	/**
	 * Assign aClinicTimeZone to clinicTimeZone.
	 * 
	 * @param aClinicTimeZone the clinic timezone.
	 */
	public static void setClinicTimeZone(TimeZone aClinicTimeZone) {
		clinicTimeZone.set(aClinicTimeZone);
	}


}
