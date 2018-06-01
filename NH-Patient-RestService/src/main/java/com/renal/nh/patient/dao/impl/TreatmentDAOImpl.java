/**
 * 
 */
package com.renal.nh.patient.dao.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.renal.nh.patient.dao.TreatmentDAO;
import com.renal.nh.patient.entity.Treatment;

/**
 * @author dasaraa
 *
 */
@Transactional
@Repository
public class TreatmentDAOImpl implements TreatmentDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TreatmentDAOImpl.class);

	@Override
	public Treatment getTreatmentData(long treatmentId) {
		LOGGER.info("get the Treatment details by treatmentId – DB transaction Start : {} ", treatmentId,
				new Timestamp(System.currentTimeMillis()));
		Treatment treatment=null;
		try {
			treatment = (Treatment) entityManager.find(Treatment.class, treatmentId);

		}catch(DataAccessException e){
			LOGGER.error("The error occurred while geting the Treatment details by treatmentId",e);
		}
			catch(Exception e){
			LOGGER.error("The error occurred while geting the Treatment details by treatmentId",e);
		}
		LOGGER.info("get the Treatment details by treatmentId – DB transaction ends : {} ", treatmentId,
				new Timestamp(System.currentTimeMillis()));
		return treatment;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Treatment> getTreatmentsByPatientId(long patientId) {
		LOGGER.info("get the Treatment details by patientId – DB transaction Start : {} ", patientId,
				new Timestamp(System.currentTimeMillis()));
		List<Treatment> treatments=null;
		try {
			Query query=entityManager.createQuery("SELECT t FROM Treatment t where t.patient.patientId= :patientId");
			query.setParameter("patientId", patientId);
			treatments=query.getResultList();
		}catch(DataAccessException e){
			LOGGER.error("The error occurred while geting the Treatment details by patientId",e);
		}
			catch(Exception e){
			LOGGER.error("The error occurred while geting the Treatment details by patientId",e);
		}
		LOGGER.info("get the Treatment details by patientId – DB transaction ends : {} ", patientId,
				new Timestamp(System.currentTimeMillis()));
		return treatments;
	}

	@SuppressWarnings({ "unchecked"})
	@Override
	public List<Treatment> getpatientsTreatmentData(long patientId,
			String treatmentStartTime, String treatmentEndTime) {
		LOGGER.info("get the Treatment details by patientId,treatmentStartDate,treatmentEndDate – DB transaction Start : {} ", patientId,
				new Timestamp(System.currentTimeMillis()));
		List<Treatment> treatments=null;
		try {
			 SimpleDateFormat dateFormat = new SimpleDateFormat(
			            "dd-MMM-yy");
			    Date parsedTimeStamp = dateFormat.parse(treatmentStartTime);
			    Timestamp timestamp = new Timestamp(parsedTimeStamp.getTime());
			    
			    Date parsedTimeStamp1 = dateFormat.parse(treatmentEndTime);
			    Timestamp timestamp1 = new Timestamp(parsedTimeStamp1.getTime());
			    Query query=entityManager.createQuery("SELECT t FROM Treatment t where t.patient.patientId= :patientId and t.treatmentStartTime between  :treatmentStartTime and :treatmentEndTime");
			query.setParameter("patientId", patientId);
			query.setParameter("treatmentStartTime",timestamp);
			query.setParameter("treatmentEndTime", timestamp1);
			treatments=query.getResultList();
		}catch(DataAccessException e){
			LOGGER.error("The error occurred while geting the Treatment details by patientId,treatmentStartDate,treatmentEndDate",e);
		}
			catch(Exception e){
			LOGGER.error("The error occurred while geting the Treatment details by patientId,treatmentStartDate,treatmentEndDate",e);
		}
		LOGGER.info("get the Treatment details by patientId,treatmentStartDate,treatmentEndDate – DB transaction ends : {} ", patientId,
				new Timestamp(System.currentTimeMillis()));
		return treatments;
	}

	@Override
	public Treatment persistTreatmentData(Treatment treatment) {
		LOGGER.info("Persist the Treatment Data by treatment - DB Transaction start : {}",new Timestamp(System.currentTimeMillis()));
		try{
			this.entityManager.persist(treatment);
			
		}catch(Exception e){
			LOGGER.error("The error occurred while persisting the Treatment Data",e);
		}
		LOGGER.info("Persist the Treatment Data by treatment - DB Transaction ends : {}",new Timestamp(System.currentTimeMillis()));
		return treatment;
	}

	@Override
	public Treatment updateTreatmentData(Treatment treatment) {
		LOGGER.info("Update the Treatment Data by treatment - DB Transaction start : {}",new Timestamp(System.currentTimeMillis()));
		try{
			this.entityManager.merge(treatment);
			
		}catch(Exception e){
			LOGGER.error("The error occurred while updating the Treatment Data",e);
		}
		LOGGER.info("Update the Treatment Data by treatment - DB Transaction ends : {}",new Timestamp(System.currentTimeMillis()));
		return treatment;
	}

}
