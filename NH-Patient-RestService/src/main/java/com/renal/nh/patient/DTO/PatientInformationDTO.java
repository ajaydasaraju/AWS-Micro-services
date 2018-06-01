

package com.renal.nh.patient.DTO;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * @author dasaraa
 *
 */
@Component
public class PatientInformationDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7897001565361299262L;

	// ------- Instance Variables (private) ------------------------------------

	private long patientId;

	private String firstName;

	private String lastName;

	/**
	 * 
	 */
	public PatientInformationDTO() {
	}

	/**
	 * @param patientId
	 * @param firstName
	 * @param lastName
	 */
	public PatientInformationDTO(long patientId, String firstName, String lastName) {
		super();
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @return the patientId
	 */
	public long getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId
	 *            the patientId to set
	 */
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
