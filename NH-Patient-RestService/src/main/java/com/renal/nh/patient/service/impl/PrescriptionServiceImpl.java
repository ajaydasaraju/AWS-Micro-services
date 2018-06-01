/**
 * 
 */
package com.renal.nh.patient.service.impl;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renal.nh.patient.DTO.PrescriptionDTO;
import com.renal.nh.patient.dao.PatientDAO;
import com.renal.nh.patient.dao.PrescriptionDAO;
import com.renal.nh.patient.entity.Patient;
import com.renal.nh.patient.entity.Prescription;
import com.renal.nh.patient.service.PrescriptionService;

/**
 * @author dasaraa
 *
 */
@Service
public class PrescriptionServiceImpl implements PrescriptionService {
	
	/**
	 *  Instance of PrescriptionDAO
	 */
	@Autowired
	private PrescriptionDAO prescriptionDAO;
	
	/**
	 *  Instance of PatientDAO
	 */
	@Autowired
	private PatientDAO patientDAO;
	
	/**
	 * Instance of  the Logger
	 */
	private static final Logger LOGGER=LoggerFactory.getLogger(PrescriptionServiceImpl.class);

	/**
	 * @param patientId
	 * @return the Prescription by PatientId
	 */
	@Override
	public PrescriptionDTO getPrescriptionByPatientId(Long patientId) {
		LOGGER.info("Get the patient Prescription by patientId method begins", new Timestamp(System.currentTimeMillis()));
		
		PrescriptionDTO prescriptionDTO=null;
		try{
			Prescription prescription=prescriptionDAO.getPrescriptionByPatientId(patientId);
			if(prescription!=null){
				prescriptionDTO=new PrescriptionDTO(prescription.getPrescriptionId(), prescription.getDrainTime(), prescription.getExchangeType(), prescription.getFillTime(), prescription.getFlushTime(), prescription.getSolutionVolume(), prescription.getTotalExchanges());
				prescriptionDTO.setPatientId(patientId);
			}
		}catch(Exception e){
			LOGGER.error("The error occurred while getting  the Prescription by patientId",e);
		}
		LOGGER.info("Get the patient Prescription by patientId method ends", new Timestamp(System.currentTimeMillis()));

		return prescriptionDTO;
	}
	
	/**
	 * @param prescription
	 *  save the patient prescription
	 */
	@Override
	public void savePrescription(PrescriptionDTO prescriptionDTO){
		LOGGER.info("Persist the Prescription Data by Prescription - Service start : {}",new Timestamp(System.currentTimeMillis()));
		try{
			if(prescriptionDTO!=null){
			 Prescription prescription=new Prescription();
			 prescription.setDrainTime(prescriptionDTO.getDrainTime());
			 prescription.setExchangeType(prescriptionDTO.getExchangeType());
			 prescription.setFillTime(prescriptionDTO.getFillTime());
			 prescription.setFlushTime(prescriptionDTO.getFlushTime());
			 prescription.setSolutionVolume(prescriptionDTO.getSolutionVolume());
			 prescription.setTotalExchanges(prescription.getTotalExchanges());
			 Patient patient=patientDAO.getPatientByPatientId(prescriptionDTO.getPatientId());
			 if(patient!=null){
				 prescription.setPatient(patient);
			 }
			 prescription.setPatient(patient);
			this.prescriptionDAO.savePrescription(prescription);
			}
			
		}catch(Exception e){
			LOGGER.error("The error occurred while updating the Prescription Data",e);
		}
		LOGGER.info("Updating the Prescription Data by Prescription - Service ends : {}",new Timestamp(System.currentTimeMillis()));
	}

}
