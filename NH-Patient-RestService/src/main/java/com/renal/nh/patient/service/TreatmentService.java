/**
 * 
 */
package com.renal.nh.patient.service;

import java.util.List;

import com.renal.nh.patient.DTO.TreatmentDTO;
import com.renal.nh.patient.entity.Treatment;

/**
 * @author dasaraa
 *
 */
public interface TreatmentService {

	public TreatmentDTO getTreatmentData(long treatmentId);

	public List<TreatmentDTO> getpatientTreatmentData(long patientId);

	public List<TreatmentDTO> getpatientsTreatmentData(long patientId,
			String treatmentStartDate, String treatmentEndDate);

	public void persistTreatmentData(TreatmentDTO treatment);

	public void updateTreatmentData(Treatment treatment);

}
