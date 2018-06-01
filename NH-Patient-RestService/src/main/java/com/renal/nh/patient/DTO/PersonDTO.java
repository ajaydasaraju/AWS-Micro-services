/**
 * 
 */
package com.renal.nh.patient.DTO;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author dasaraa
 *
 */
public class PersonDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private long personId;

	/**
	 * 
	 */
	private Timestamp createTs;

	/**
	 * 
	 */
	private Date dateOfBirth;

	/**
	 * 
	 */
	private String emailAddress;

	/**
	 * 
	 */
	private String firstName;

	/**
	 * 
	 */
	private String gender;

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
	private Timestamp updateTs;

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
	 * @return the createTs
	 */
	public Timestamp getCreateTs() {
		return createTs;
	}

	/**
	 * @param createTs the createTs to set
	 */
	public void setCreateTs(Timestamp createTs) {
		this.createTs = createTs;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
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
	 * @return the updateTs
	 */
	public Timestamp getUpdateTs() {
		return updateTs;
	}

	/**
	 * @param updateTs the updateTs to set
	 */
	public void setUpdateTs(Timestamp updateTs) {
		this.updateTs = updateTs;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
