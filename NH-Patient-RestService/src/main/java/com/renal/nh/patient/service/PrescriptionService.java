/**
 * 
 */
package com.renal.nh.patient.service;

import com.renal.nh.patient.DTO.PrescriptionDTO;
import com.renal.nh.patient.entity.Prescription;

/**
 * @author dasaraa
 *
 */
public interface PrescriptionService {
	
	/**
	 * @param patientId
	 * @return the Prescription by PatientId
	 */
	public PrescriptionDTO getPrescriptionByPatientId(Long patientId);
	
	/**
	 * @param prescription
	 *  save the patient prescription
	 */
	public void savePrescription(PrescriptionDTO prescription);

}
