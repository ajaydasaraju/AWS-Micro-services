/**
 * 
 */
package com.renal.nh.patient.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.renal.nh.patient.dao.PrescriptionDAO;
import com.renal.nh.patient.entity.Prescription;

/**
 * @author dasaraa
 *
 */
@Transactional
@Repository
public class PrescriptionDAOImpl implements PrescriptionDAO{
	
	/**
	 *  Instance of the EntityManager
	 */
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Instance of the logger
	 */
	private static final Logger LOGGER=LoggerFactory.getLogger(PrescriptionDAOImpl.class);
	
	/**
	 * @param patientId
	 * @return the Prescription by PatientId
	 */
	@SuppressWarnings("unchecked")
	public Prescription getPrescriptionByPatientId(Long patientId){
		LOGGER.info("get the patient Prescription by patientId starts",new Timestamp(System.currentTimeMillis()));
		Prescription prescription=null;
		ArrayList<Prescription> list=null;
		try {
			Query query=entityManager.createQuery("SELECT p FROM Prescription p where p.patient.patientId= :patientId");
			query.setParameter("patientId", patientId);
			if(query.getResultList()!=null){
				list=(ArrayList<Prescription>) query.getResultList();
				if(list.size()>0){
					prescription=list.get(0);
				}
			}
		}catch(DataAccessException e){
			LOGGER.error("The error occurred while geting the Prescription details by patientId",e);
		}
			catch(Exception e){
			LOGGER.error("The error occurred while geting the Prescription details by patientId",e);
		}
		LOGGER.info("get the patient Prescription by patientId ends",new Timestamp(System.currentTimeMillis()));
		return prescription;
	}
	
	/**
	 * @param prescription
	 *  save the patient prescription
	 */
	@Override
	public void savePrescription(Prescription prescription){
		LOGGER.info("save the patient Prescription method begins", new Timestamp(System.currentTimeMillis()));
		try{
			prescription.setCreateTs(new Timestamp(System.currentTimeMillis()));
			prescription.setUpdateTs(new Timestamp(System.currentTimeMillis()));
			entityManager.persist(prescription);
		}catch(DataAccessException e){
			LOGGER.error("The error occurred while persisting the Prescription details by patientId",e);
		}catch (Exception e) {
			LOGGER.error("The error occurred while presisting the Prescription details by patientId",e);
			}
		LOGGER.info("save the patient Prescription method ends", new Timestamp(System.currentTimeMillis()));
	}

}
