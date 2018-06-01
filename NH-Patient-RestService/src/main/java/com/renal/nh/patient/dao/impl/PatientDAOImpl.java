/**
 * 
 */
package com.renal.nh.patient.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.renal.nh.patient.dao.PatientDAO;
import com.renal.nh.patient.entity.Patient;
import com.renal.nh.patient.entity.Person;

/**
 * @author dasaraa
 *
 */
@Transactional
@Repository
public class PatientDAOImpl implements PatientDAO{

	@PersistenceContext
	EntityManager entityManager;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientDAOImpl.class);
	
	@Override
	public Patient getPatientByPatientId(long patientId) {
		LOGGER.info("get the patient details by patientId – DB transaction Start : {} ", patientId,
				new Timestamp(System.currentTimeMillis()));
		Patient patient=null;
		try {
			patient = (Patient) this.entityManager.find(Patient.class, patientId);

		}catch(DataAccessException e){
			LOGGER.error("The error occurred while geting the patient details by patientId",e);
		}
			catch(Exception e){
			LOGGER.error("The error occurred while geting the patient details by patientId",e);
		}
		LOGGER.info("get the patient details by patientId – DB transaction ends : {} ", patientId,
				new Timestamp(System.currentTimeMillis()));
		return patient;
	}
	
	@Override
	public Person getPersonByPersonId(long personId){
		LOGGER.info("get the person details by personId – DB transaction Start : {} ", personId,
				new Timestamp(System.currentTimeMillis()));
		Person person=null;
		try {
			person = (Person) this.entityManager.find(Person.class, personId);

		}catch(DataAccessException e){
			LOGGER.error("The error occurred while geting the Pserson details by personId",e);
		}
			catch(Exception e){
			LOGGER.error("The error occurred while geting the Pserson details by personId",e);
		}
		LOGGER.info("get the patient details by PsersonId – DB transaction ends : {} ", personId,
				new Timestamp(System.currentTimeMillis()));
		return person;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> getPatientsByPhysicianId(long physicianId){
		LOGGER.info("get the patient details by physicianId – DB transaction Start : {} ", physicianId,
				new Timestamp(System.currentTimeMillis()));
		List<Patient> patients=null;
		try {
			Query query=this.entityManager.createQuery("SELECT p FROM Patient p where p.physician.physicianId= :physicianId");
			query.setParameter("physicianId", physicianId);
			patients=query.getResultList();

		}catch(DataAccessException e){
			LOGGER.error("The error occurred while geting the patient details by physicianId",e);
		}
			catch(Exception e){
			LOGGER.error("The error occurred while geting the patient details by physicianId",e);
		}
		LOGGER.info("get the patient details by physicianId – DB transaction ends : {} ", physicianId,
				new Timestamp(System.currentTimeMillis()));
		return patients;
	}

	@Override
	public Patient persistPatient(Patient patient) {
		LOGGER.info("persistPatient by patient – DB transaction Start : {} ", patient,
				new Timestamp(System.currentTimeMillis()));
		try{
			this.entityManager.persist(patient);
		}catch(Exception e){
			LOGGER.error("The Error occured while persisting the Patient",e);
		}
		LOGGER.info("persistPatient by patient – DB transaction Ends : {} ", patient,
				new Timestamp(System.currentTimeMillis()));
		return patient;
	}

	@Override
	public Patient updatePatient(Patient patient) {
		LOGGER.info("persistPatient by patient – DB transaction Start : {} ", patient,
				new Timestamp(System.currentTimeMillis()));
		try{
			this.entityManager.merge(patient);
		}catch(Exception e){
			LOGGER.error("The Error occured while persisting the Patient",e);
		}
		LOGGER.info("persistPatient by patient – DB transaction Ends : {} ", patient,
				new Timestamp(System.currentTimeMillis()));
		return patient;
	}

}
