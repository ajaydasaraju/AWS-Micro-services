
package com.renal.nh.patient.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renal.nh.patient.DTO.PatientDTO;
import com.renal.nh.patient.dao.PatientDAO;
import com.renal.nh.patient.dao.PhysicianDAO;
import com.renal.nh.patient.entity.Patient;
import com.renal.nh.patient.entity.Person;
import com.renal.nh.patient.entity.Physician;
import com.renal.nh.patient.service.PatientRestService;

/**
 * 
 * Implementation of the Patient Rest Service.
 *
 *
 */
@Service
public class PatientRestServiceImpl implements PatientRestService{
	
	/**
	 *  Instance of PatientDAO
	 */
	@Autowired
	private PatientDAO patientDAO;
	
	/**
	 *  Instance of PhysicianDAO
	 */
	@Autowired
	private PhysicianDAO physicianDAO;
	
	
	
	/**
	 * 
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientRestServiceImpl.class);

	/**
	 * @param patientId
	 * @return  PatientInformation
	 */
	
	@Override
	public PatientDTO getPatientByPatientId(long patientId){
		LOGGER.info("get the patient details by patientId – Service Start : {} ", patientId,
				new Timestamp(System.currentTimeMillis()));
		Patient patient=null;
		PatientDTO patientDTO=null;
		try {
			patient = (Patient) patientDAO.getPatientByPatientId(patientId);
			
			if(patient!=null){
				patientDTO=new PatientDTO(patientId);
				Person person=patient.getPerson();
				if(person!=null){
					if(person.getFirstName()!=null && !person.getFirstName().isEmpty()){
						patientDTO.setFirstName(person.getFirstName());
					}
					if(person.getLastName()!=null && !person.getLastName().isEmpty()){
						patientDTO.setLastName(person.getLastName());
					}
					if(person.getMiddleName()!=null && !person.getMiddleName().isEmpty()){
						patientDTO.setMiddleName(person.getMiddleName());
					}
				}
			}

		}
		catch(Exception e){
			LOGGER.error("The error occurred while geting the patient details by patientId",e);
		}
		LOGGER.info("get the patient details by patientId – Service ends : {} ", patientId,
				new Timestamp(System.currentTimeMillis()));
		return patientDTO;
	}
	
	
	/**
	 * @param personId
	 * @return  Persons Information
	 */
	
	@Override
	public Person getPersonByPersonId(long personId){
		LOGGER.info("get the Person details by PersonId – Service Start : {} ", personId,
				new Timestamp(System.currentTimeMillis()));
		Person person=null;
		try {
			person = (Person) patientDAO.getPersonByPersonId(personId);

		}
		catch(Exception e){
			LOGGER.error("The error occurred while geting the person details by personId",e);
		}
		LOGGER.info("get the person details by personId – Service ends : {} ", personId,
				new Timestamp(System.currentTimeMillis()));
		return person;
	}
	
	/**
	 * @param PhysicianId
	 * @return the list of Patients
	 */
	
	public List<PatientDTO> getPatientsByPhysicianId(long physicianId){
		LOGGER.info("get the Patient details by physicianId – Service Start : {} ", physicianId,
				new Timestamp(System.currentTimeMillis()));
		List<Patient> patients=null;
		List<PatientDTO> patientDetails=null;
		try{
			patients=patientDAO.getPatientsByPhysicianId(physicianId);
			if(patients!=null){
				patientDetails= new ArrayList<PatientDTO>();
				for(Patient patient:patients){
					PatientDTO patientDTO=new PatientDTO(patient.getPatientId());
					Person person=patient.getPerson();
					if(person!=null){
						if(person.getFirstName()!=null && !person.getFirstName().isEmpty()){
							patientDTO.setFirstName(person.getFirstName());
						}
						if(person.getLastName()!=null && !person.getLastName().isEmpty()){
							patientDTO.setLastName(person.getLastName());
						}
						if(person.getMiddleName()!=null && !person.getMiddleName().isEmpty()){
							patientDTO.setMiddleName(person.getMiddleName());
						}
					}
					patientDetails.add(patientDTO);
				}
			}
		}catch(Exception e){
			LOGGER.error("The error occurred while geting the patient details by physicianId",e);
		}
		LOGGER.info("get the patient details by physicianId – Service ends : {} ", physicianId,
				new Timestamp(System.currentTimeMillis()));
		
		
		return patientDetails;
	}


	@Override
	public void persistPatient(PatientDTO patientDTO) {
		LOGGER.info("Persist the Treatment Data by treatment – Service starts : {} ",
				new Timestamp(System.currentTimeMillis()));
		Patient patient=null;
		try{
			if(patientDTO!=null){
				patient=new Patient();
				Person person=patientDAO.getPersonByPersonId(patientDTO.getPersonId());
				if(person!=null){
					patient.setPerson(person);
				}
				Physician physician=physicianDAO.getPhysicianByPhysicianId(patientDTO.getPhysicianId());
				if(physician!=null){
					patient.setPhysician(physician);
				}
				patient.setCreateTs(new Timestamp(System.currentTimeMillis()));
				patient.setUpdateTs(new Timestamp(System.currentTimeMillis()));
			}
			patientDAO.persistPatient(patient);
		}catch(Exception e){
				LOGGER.error("The error occurred while persisting the patient details",e);
			}
			LOGGER.info("Persist the Treatment Data by treatment – Service ends : {} ",
					new Timestamp(System.currentTimeMillis()));
			
	}


	@Override
	public void updatePatient(Patient patient) {
		LOGGER.info("Update the Treatment Data by treatment – Service starts : {} ",
				new Timestamp(System.currentTimeMillis()));
		try{
			patientDAO.updatePatient(patient);
		}catch(Exception e){
				LOGGER.error("The error occurred while updating the patient details",e);
			}
			LOGGER.info("Update the Treatment Data by treatment – Service ends : {} ",
					new Timestamp(System.currentTimeMillis()));
	}
}
