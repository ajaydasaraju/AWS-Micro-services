package com.renal.nh.patient.exceptions;

/**
 * Definition of PatientNotFoundException
 * @author dasaraa
 *
 */
public class PatientNotFoundException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2572818239284658942L;
	private final long patientId;
	
	 /**
     * Constructor.
     *
     * @param patientId - the patientId to set
     */
    public PatientNotFoundException(long patientId) {
        this.patientId = patientId;
    }
	
	public PatientNotFoundException(long patientId,String reason){
		super(reason);
		this.patientId=patientId;
		
	}
	
	  /**
     * Returns the value of or reference to patientId.
     *
     * @return long containing the patientId
     */
    public long getPatientId() {
        return this.patientId;
    }
	
}
