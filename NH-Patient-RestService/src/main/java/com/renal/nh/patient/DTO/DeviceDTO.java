/**
 * 
 */
package com.renal.nh.patient.DTO;

import java.io.Serializable;

/**
 * @author dasaraa
 *
 */
public class DeviceDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private long deviceId;


	/**
	 * 
	 */
	private String hotspotName;

	/**
	 * 
	 */
	private String hotspotPassword;
	
	/**
	 * 
	 */
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
	 * @param deviceId
	 */
	public DeviceDTO(long deviceId) {
		super();
		this.deviceId = deviceId;
	}


	/**
	 * @return the deviceId
	 */
	public long getDeviceId() {
		return deviceId;
	}

	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * @return the hotspotName
	 */
	public String getHotspotName() {
		return hotspotName;
	}

	/**
	 * @param hotspotName the hotspotName to set
	 */
	public void setHotspotName(String hotspotName) {
		this.hotspotName = hotspotName;
	}

	/**
	 * @return the hotspotPassword
	 */
	public String getHotspotPassword() {
		return hotspotPassword;
	}

	/**
	 * @param hotspotPassword the hotspotPassword to set
	 */
	public void setHotspotPassword(String hotspotPassword) {
		this.hotspotPassword = hotspotPassword;
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
}
