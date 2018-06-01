/**
 * 
 */
package com.renal.nh.patient.service.impl;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renal.nh.patient.DTO.DeviceDTO;
import com.renal.nh.patient.dao.DeviceDAO;
import com.renal.nh.patient.dao.PatientDAO;
import com.renal.nh.patient.entity.Device;
import com.renal.nh.patient.entity.Patient;
import com.renal.nh.patient.entity.Person;
import com.renal.nh.patient.service.DeviceService;



/**
 * @author dasaraa
 *
 */
@Service
public class DeviceServiceImpl implements DeviceService {
	
	/**
	 *  Instance of DeviceDAO
	 */
	@Autowired
	private DeviceDAO deviceDAO;
	
	@Autowired
	private PatientDAO patientDAO;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DeviceServiceImpl.class);

	@Override
	public DeviceDTO getDeviceByDeviceId(long deviceId) {
		LOGGER.info("Get the Device details by deviceId - Service start : {} ", deviceId, new Timestamp(System.currentTimeMillis()));
		DeviceDTO  deviceDTO=null;
		Device device=null;
		try{
			device=deviceDAO.getDeviceByDeviceId(deviceId);
			if(device!=null){
				deviceDTO=new DeviceDTO(device.getDeviceId());
				Patient patient=device.getPatient();
				if(patient!=null ){
					deviceDTO.setPatientId(patient.getPatientId());
				Person person=patient.getPerson();
				if(person!=null){
					if(person.getFirstName()!=null && !person.getFirstName().isEmpty()){
						deviceDTO.setFirstName(person.getFirstName());
					}
					if(person.getLastName()!=null && !person.getLastName().isEmpty()){
						deviceDTO.setLastName(person.getLastName());
					}
					if(person.getMiddleName()!=null && !person.getMiddleName().isEmpty()){
						deviceDTO.setMiddleName(person.getMiddleName());
					}
				
			}
				}
			}
		}catch(Exception e){
			LOGGER.error("The error while geting the Device details by deviceId: ",e);
		}
		
		LOGGER.info("Get the Device details by deviceId - Service ends : {} ", deviceId, new Timestamp(System.currentTimeMillis()));
		return deviceDTO;
	}

	@Override
	public void persistDeviceData(DeviceDTO deviceDTO) {
		LOGGER.info("Persist the Device info by device - Service start : {} ",new Timestamp(System.currentTimeMillis()));
		Device device=null;
		try{
			if(deviceDTO!=null){
				device=new Device();
				Patient patient=patientDAO.getPatientByPatientId(deviceDTO.getPatientId());
				if(patient!=null){
					device.setPatient(patient);
				}
				device.setHotspotName(deviceDTO.getHotspotName());
				device.setHotspotPassword(deviceDTO.getHotspotPassword());
				device.setCreateTs(new Timestamp(System.currentTimeMillis()));
				device.setUpdateTs(new Timestamp(System.currentTimeMillis()));
			}
			
			deviceDAO.persistDeviceData(device);
			
		}catch(Exception e){
			LOGGER.error("The error occurred while persisting the device info :",e);
		}
		LOGGER.info("Persist the Device info by device - Service ends : {} ",new Timestamp(System.currentTimeMillis()));
	}

	@Override
	public void updateDeviceData(Device device) {
		LOGGER.info("Update the Device info by device - Service start : {} ",new Timestamp(System.currentTimeMillis()));
		try{
			deviceDAO.updateDeviceData(device);
			
		}catch(Exception e){
			LOGGER.error("The error occurred while update the device info :",e);
		}
		LOGGER.info("Update the Device info by device - Service ends : {} ",new Timestamp(System.currentTimeMillis()));		
	}

}
