/**
 * 
 */
package com.renal.nh.patient.dao.impl;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.renal.nh.patient.dao.DeviceDAO;
import com.renal.nh.patient.entity.Device;

/**
 * @author dasaraa
 *
 */
@Repository
@Transactional
public class DeviceDAOImpl implements DeviceDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DeviceDAOImpl.class);

	@Override
	public Device getDeviceByDeviceId(long deviceId) {
		LOGGER.info("get the Device details by DeviceId – DB transaction Start : {} ", deviceId,
				new Timestamp(System.currentTimeMillis()));
		Device Device=null;
		try {
			Device = (Device) this.entityManager.find(Device.class, deviceId);

		}catch(DataAccessException e){
			LOGGER.error("The error occurred while geting the Device details by deviceId",e);
		}
			catch(Exception e){
			LOGGER.error("The error occurred while geting the Device details by deviceId",e);
		}
		LOGGER.info("get the Device details by DeviceId – DB transaction ends : {} ", deviceId,
				new Timestamp(System.currentTimeMillis()));
		return Device;
	}

	@Override
	public Device persistDeviceData(Device device) {
		LOGGER.info("Persisting the Device Info - DB Transaction start : {} ",new Timestamp(System.currentTimeMillis()));
		try{
			this.entityManager.persist(device);
		}catch(Exception e){
			LOGGER.error("The Error occurred while persisting the Device data :",e);
		}
		LOGGER.info("Persisting the Device Info - DB Transaction ends : {} ",new Timestamp(System.currentTimeMillis()));
		return device;
	}
	
	@Override
	public Device updateDeviceData(Device device) {
		LOGGER.info("update the Device Info - DB Transaction start : {} ",new Timestamp(System.currentTimeMillis()));
		try{
			this.entityManager.merge(device);
		}catch(Exception e){
			LOGGER.error("The Error occurred while updating the Device data :",e);
		}
		LOGGER.info("update the Device Info - DB Transaction ends : {} ",new Timestamp(System.currentTimeMillis()));
		return device;
	}

}
