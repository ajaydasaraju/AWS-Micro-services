/**
 * 
 */
package com.renal.nh.patient.DTO;


/**
 * @author dasaraa
 *
 */
public class RoleDTO {
	
	/**
	 * 
	 */
	private long activationCode;
	
	/**
	 * 
	 */
	private String userRole;
	
	/**
	 * 
	 */
	private String password;
	
	public RoleDTO(){
		
	}

	/**
	 * @return the activationCode
	 */
	public long getActivationCode() {
		return activationCode;
	}

	/**
	 * @param activationCode the activationCode to set
	 */
	public void setActivationCode(long activationCode) {
		this.activationCode = activationCode;
	}

	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
