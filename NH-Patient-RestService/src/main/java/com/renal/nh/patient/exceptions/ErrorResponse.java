
package com.renal.nh.patient.exceptions;


/**
 * Object of the ErrorResponse
 * @author dasaraa
 *
 */
public class ErrorResponse {

	/**
	 * 
	 */
	private String code;

	/**
	 * 
	 */
	private String reason;

	/**
	 * 
	 */
	public ErrorResponse() {
	}


	/**
	 * @param code
	 * @param reason
	 */
	public ErrorResponse(String code, String reason) {
		this.code = code;
		this.reason = reason;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason
	 *            the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}


}
