/**
 * 
 */
package com.renal.nh.patient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.renal.nh.patient.DTO.DeviceDTO;
import com.renal.nh.patient.service.DeviceService;

/**
 * @author dasaraa
 *
 */
@RestController
public class DeviceController {
	
	/**
	 * Instance of DeviceService
	 */
	@Autowired
	private DeviceService deviceService;
	
	private static final Logger LOGGER =LoggerFactory.getLogger(PatientController.class);
	
	/**
	 * @param deviceId
	 * @return the Device details
	 */
	@RequestMapping(value="/device/{deviceId}",method=RequestMethod.GET)
	public  ResponseEntity<DeviceDTO> getDevice(@PathVariable("deviceId") long deviceId){
		LOGGER.debug("the getDevice method of  DeviceController begins");
		DeviceDTO deviceDTO=deviceService.getDeviceByDeviceId(deviceId);
		LOGGER.debug("the getDevice method DeviceController ends");
		return new ResponseEntity<DeviceDTO>(deviceDTO,HttpStatus.OK);
	}
	
	@RequestMapping(value="/saveDeviceData", method=RequestMethod.POST)
	public ResponseEntity<String> saveDeviceData(@RequestBody DeviceDTO deviceDTO){
		LOGGER.debug("The saveDeviceData method of DeviceController begins");
		try{
			deviceService.persistDeviceData(deviceDTO);
		}catch(Exception e){
			LOGGER.error("The error occurred in saveDeviceData method of DeviceController begins");
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		LOGGER.debug("The saveDeviceData method of DeviceController ends");
		return  ResponseEntity.status(HttpStatus.CREATED).build();
		
	}


}
