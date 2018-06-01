

package com.renal.nh.patient.DTO;

import java.io.Serializable;

/**
 * @author dasaraa
 *
 */
public class PatientDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ------- Instance Variables (private) ------------------------------------

	private Long patientId;

	/**
	 * 
	 */
	private String firstName;

	/**
	 * 
	 */
	private String lastName;

	/**
	 * 
	 */
	private String middleName;
	
	/**
	 * 
	 */
	private long personId;
	
	/**
	 * 
	 */
	private long physicianId;

	
	/**
	 * @param patientId
	 */
	public PatientDTO(Long patientId) {
		super();
		this.patientId = patientId;
	}

	/**
	 * @return the patientId
	 */
	public Long getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}




	/**
	 * @param firstName the firstName to set
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
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}




	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the personId
	 */
	public long getPersonId() {
		return personId;
	}

	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(long personId) {
		this.personId = personId;
	}

	/**
	 * @return the physicianId
	 */
	public long getPhysicianId() {
		return physicianId;
	}

	/**
	 * @param physicianId the physicianId to set
	 */
	public void setPhysicianId(long physicianId) {
		this.physicianId = physicianId;
	}

	
}
