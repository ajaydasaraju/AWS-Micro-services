/**
 * 
 */
package com.renal.nh.patient.DTO;

import java.io.Serializable;

/**
 * @author dasaraa
 *
 */
public class PhysicianDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private long physicianId;

	/**
	 * 
	 */
	private String medicalTitle;

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
	 * @param physicianId
	 */
	public PhysicianDTO(long physicianId) {
		super();
		this.physicianId = physicianId;
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

	/**
	 * @return the medicalTitle
	 */
	public String getMedicalTitle() {
		return medicalTitle;
	}

	/**
	 * @param medicalTitle the medicalTitle to set
	 */
	public void setMedicalTitle(String medicalTitle) {
		this.medicalTitle = medicalTitle;
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
	

}
