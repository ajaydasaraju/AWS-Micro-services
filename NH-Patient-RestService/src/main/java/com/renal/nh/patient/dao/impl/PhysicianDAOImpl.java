/**
 * 
 */
package com.renal.nh.patient.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.renal.nh.patient.dao.PhysicianDAO;
import com.renal.nh.patient.entity.Physician;
/**
 * @author dasaraas
 *
 */
@Repository
@Transactional
public class PhysicianDAOImpl implements PhysicianDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PhysicianDAOImpl.class);

	@Override
	public Physician getPhysicianByPhysicianId(long physicianId) {
		LOGGER.info("get the Physician details by PhysicianId – DB transaction Start : {} ", physicianId,
				new Timestamp(System.currentTimeMillis()));
		Physician Physician=null;
		try {
			Physician = (Physician) this.entityManager.find(Physician.class, physicianId);

		}catch(DataAccessException e){
			LOGGER.error("The error occurred while geting the Physician details by PhysicianId",e);
		}
			catch(Exception e){
			LOGGER.error("The error occurred while geting the Physician details by PhysicianId",e);
		}
		LOGGER.info("get the Physician details by PhysicianId – DB transaction ends : {} ", physicianId,
				new Timestamp(System.currentTimeMillis()));
		return Physician;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Physician> getPhysiciansByPhysicianId(long physicianId) {
		LOGGER.info("get the Physician details by physicianId – DB transaction Start : {} ", physicianId,
				new Timestamp(System.currentTimeMillis()));
		List<Physician> Physicians=null;
		try {
			Query query=this.entityManager.createQuery("SELECT p FROM Physician p where p.physicianId= :physicianId");
			query.setParameter("physicianId", physicianId);
			Physicians=query.getResultList();

		}catch(DataAccessException e){
			LOGGER.error("The error occurred while geting the Physician details by physicianId",e);
		}
			catch(Exception e){
			LOGGER.error("The error occurred while geting the Physician details by physicianId",e);
		}
		LOGGER.info("get the Physician details by physicianId – DB transaction ends : {} ", physicianId,
				new Timestamp(System.currentTimeMillis()));
		return Physicians;
	}

	@Override
	public Physician persistPhysician(Physician physician) {
		LOGGER.info("persist Physician by Physician – DB transaction Start : {} ",
				new Timestamp(System.currentTimeMillis()));
		try{
			this.entityManager.persist(physician);
		}catch(Exception e){
			LOGGER.error("The Error occured while persisting the Physician",e);
		}
		LOGGER.info("persist Physician by Physician – DB transaction Ends : {} ",
				new Timestamp(System.currentTimeMillis()));
		return physician;
	}

	@Override
	public Physician updatePhysician(Physician physician) {
		LOGGER.info("persist Physician by Physician – DB transaction Start : {} ",
				new Timestamp(System.currentTimeMillis()));
		try{
			this.entityManager.merge(physician);
		}catch(Exception e){
			LOGGER.error("The Error occured while persisting the Physician",e);
		}
		LOGGER.info("persist Physician by Physician – DB transaction Ends : {} ",
				new Timestamp(System.currentTimeMillis()));
		return physician;
	}

}
