/**
 * 
 */
package com.renal.nh.patient.dao;

import com.renal.nh.patient.entity.Prescription;

/**
 * @author dasaraa
 *
 */
public interface PrescriptionDAO {
	
	/**
	 * @param patientId
	 * @return the Prescription by PatientId
	 */
	public Prescription getPrescriptionByPatientId(Long patientId);
	
	/**
	 * @param prescription
	 *  save the patient prescription
	 */
	public void savePrescription(Prescription prescription);

}
