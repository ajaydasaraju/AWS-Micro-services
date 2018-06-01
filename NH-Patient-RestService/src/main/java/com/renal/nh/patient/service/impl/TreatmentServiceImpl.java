/**
 * 
 */
package com.renal.nh.patient.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renal.nh.patient.DTO.TreatmentDTO;
import com.renal.nh.patient.dao.PatientDAO;
import com.renal.nh.patient.dao.TreatmentDAO;
import com.renal.nh.patient.entity.Patient;
import com.renal.nh.patient.entity.Treatment;
import com.renal.nh.patient.service.TreatmentService;

/**
 * @author dasaraa
 *
 */
@Service
public class TreatmentServiceImpl implements TreatmentService{
	
	/**
	 * Instance of TreatmentDAO
	 */
	@Autowired
	private TreatmentDAO treatmentDAO;
	
	@Autowired
	private PatientDAO patientDAO;
	
	/**
	 * Instance of Logger
	 */
	private static final Logger LOGGER=LoggerFactory.getLogger(TreatmentServiceImpl.class);

	@Override
	public TreatmentDTO getTreatmentData(long treatmentId) {
		LOGGER.debug("get the Treatment datails by treatmentId - service starts : {} ", treatmentId,
				new Timestamp(System.currentTimeMillis()));
		TreatmentDTO treatmentDTO=null;
		Treatment treatment=null;
		try {
			treatment = treatmentDAO.getTreatmentData(treatmentId);
			if (treatment != null) {
				treatmentDTO = new TreatmentDTO(treatmentId,
						treatment.getBodyWeight(), treatment.getBp(),
						treatment.getComments(), treatment.getDrainEndTime(),
						treatment.getDrainStartTime(),
						treatment.getDrainVolume(), treatment.getFillEndTime(),
						treatment.getFillStartTime(),
						treatment.getFillVolume(), treatment.getFillEndTime(),
						treatment.getFillStartTime(),
						treatment.getSolutionUsed(),
						treatment.getTreatmentEndTime(),
						treatment.getTreatmentStartTime());
				if(treatment.getPatient()!=null){
					treatmentDTO.setPatient(treatment.getPatient().getPatientId());
				}
			}
		} catch (Exception e) {
			LOGGER.error("The error occured while geting the Treatment details by treatmentId", e);
		}
		LOGGER.debug("get the treatment details by treatmentId - service ends : {}",treatmentId,
				new Timestamp(System.currentTimeMillis()));
		return treatmentDTO;
	}

	@Override
	public List<TreatmentDTO> getpatientTreatmentData(long patientId) {
		LOGGER.debug("get the patients treatment details by patientId - service starts : {} ",patientId,
				new Timestamp(System.currentTimeMillis()));
		List<Treatment> treatments=null;
		List<TreatmentDTO> treatmentDTOs=null;
		try{
			treatments=treatmentDAO.getTreatmentsByPatientId(patientId);
			if(treatments!=null){
				treatmentDTOs=new ArrayList<TreatmentDTO>();
				for(Treatment treatment:treatments){
				TreatmentDTO	treatmentDTO = new TreatmentDTO(treatment.getTreatmentId(),
							treatment.getBodyWeight(), treatment.getBp(),
							treatment.getComments(), treatment.getDrainEndTime(),
							treatment.getDrainStartTime(),
							treatment.getDrainVolume(), treatment.getFillEndTime(),
							treatment.getFillStartTime(),
							treatment.getFillVolume(), treatment.getFillEndTime(),
							treatment.getFillStartTime(),
							treatment.getSolutionUsed(),
							treatment.getTreatmentEndTime(),
							treatment.getTreatmentStartTime());
					if(treatment.getPatient()!=null){
						treatmentDTO.setPatient(treatment.getPatient().getPatientId());
					}
					treatmentDTOs.add(treatmentDTO);
				}
				
			}
		}catch(Exception e){
			LOGGER.error("Error occurred while geting the patient treatment details by patientId",e);
		}
		LOGGER.debug("get the patient treatmnet details by patientId - service ends : {} ",patientId,
				new Timestamp(System.currentTimeMillis()));
		return treatmentDTOs;
	}

	@Override
	public List<TreatmentDTO> getpatientsTreatmentData(long patientId,
			String treatmentStartDate, String treatmentEndDate) {
		LOGGER.debug("get the patient treatment data by patientId - service starts: {}",patientId,
				new Timestamp(System.currentTimeMillis()));
		List<TreatmentDTO> treatmentDTOs=null;
		List<Treatment> treatments=null;
		try{
			treatments=treatmentDAO.getpatientsTreatmentData(patientId, treatmentStartDate, treatmentEndDate);
			if(treatments!=null){
				treatmentDTOs=new ArrayList<TreatmentDTO>();
				for(Treatment treatment:treatments){
				TreatmentDTO	treatmentDTO = new TreatmentDTO(treatment.getTreatmentId(),
							treatment.getBodyWeight(), treatment.getBp(),
							treatment.getComments(), treatment.getDrainEndTime(),
							treatment.getDrainStartTime(),
							treatment.getDrainVolume(), treatment.getFillEndTime(),
							treatment.getFillStartTime(),
							treatment.getFillVolume(), treatment.getFillEndTime(),
							treatment.getFillStartTime(),
							treatment.getSolutionUsed(),
							treatment.getTreatmentEndTime(),
							treatment.getTreatmentStartTime());
					if(treatment.getPatient()!=null){
						treatmentDTO.setPatient(treatment.getPatient().getPatientId());
					}
					treatmentDTOs.add(treatmentDTO);
				}
				
			}
			
		}catch(Exception e){
			LOGGER.error("Error occurred while geting the patient treatment data ",e);
		}
		LOGGER.debug("get the patient treatment data by patientId - service ends: {}",patientId,
				new Timestamp(System.currentTimeMillis()));
		return treatmentDTOs;
	}

	@Override
	public void persistTreatmentData(TreatmentDTO treatmentDTO) {
		LOGGER.info("Persist the Treatment Data by treatment - Service start : {}",new Timestamp(System.currentTimeMillis()));
		Treatment treatment=null;
		try{
			if(treatmentDTO!=null){
				treatment=new Treatment();
				treatment.setBodyWeight(treatmentDTO.getBodyWeight());
				treatment.setBp(treatmentDTO.getBp());
				treatment.setComments(treatmentDTO.getComments());
				treatment.setDrainEndTime(treatment.getDrainEndTime());
				treatment.setDrainStartTime(treatmentDTO.getDrainStartTime());
				treatment.setDrainVolume(treatmentDTO.getDrainVolume());
				treatment.setFillEndTime(treatmentDTO.getFillEndTime());
				treatment.setFillStartTime(treatmentDTO.getFillStartTime());
				treatment.setFillVolume(treatmentDTO.getFillVolume());
				treatment.setFlushEndTime(treatmentDTO.getFillEndTime());
				treatment.setFlushStartTime(treatmentDTO.getFlushStartTime());
				treatment.setSolutionUsed(treatmentDTO.getSolutionUsed());
				treatment.setTreatmentEndTime(treatmentDTO.getTreatmentEndTime());
				treatment.setTreatmentStartTime(treatmentDTO.getTreatmentStartTime());
				Patient patient=patientDAO.getPatientByPatientId(treatmentDTO.getPatient());
				if(patient!=null ){
					treatment.setPatient(patient);
				}
			}
			treatment.setCreateTs(new Timestamp(System.currentTimeMillis()));
			treatment.setUpdateTs(new Timestamp(System.currentTimeMillis()));
			this.treatmentDAO.persistTreatmentData(treatment);
			
		}catch(Exception e){
			LOGGER.error("The error occurred while persisting the Treatment Data",e);
		}
		LOGGER.info("Persist the Treatment Data by treatment - Service ends : {}",new Timestamp(System.currentTimeMillis()));
	}

	@Override
	public void updateTreatmentData(Treatment treatment) {
		LOGGER.info("Persist the Treatment Data by treatment - Service start : {}",new Timestamp(System.currentTimeMillis()));
		try{
			this.treatmentDAO.persistTreatmentData(treatment);
			
		}catch(Exception e){
			LOGGER.error("The error occurred while updating the Treatment Data",e);
		}
		LOGGER.info("Updating the Treatment Data by treatment - Service ends : {}",new Timestamp(System.currentTimeMillis()));
	}

}
