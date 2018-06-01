/**
 * 
 */
package com.renal.nh.patient.dao;

import java.util.List;

import com.renal.nh.patient.entity.Treatment;

/**
 * @author dasaraa
 *
 */
public interface TreatmentDAO {
	
	public Treatment getTreatmentData(long treatmentId) ;
	
	public List<Treatment> getTreatmentsByPatientId(long patientId) ;
	
	public List<Treatment> getpatientsTreatmentData(long patientId, String treatmentStartDate, String treatmentEndDate);
	
	public Treatment persistTreatmentData(Treatment treatment);
	
	public Treatment updateTreatmentData(Treatment treatment);
	
}
