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

import com.renal.nh.patient.DTO.PhysicianDTO;
import com.renal.nh.patient.service.PhysicianService;

/**
 * @author dasaraa
 *
 */
public class PhysicianController {
	
	/**
	 * Instance of PhysicianRestService
	 */
	@Autowired
	PhysicianService physicianService;
	
	private static final Logger LOGGER =LoggerFactory.getLogger(PhysicianController.class);
	
	/**
	 * @param physicianId
	 * @return the Physician details
	 */
	@RequestMapping(value="/physicians/{physicianId}",method=RequestMethod.GET)
	public  ResponseEntity<PhysicianDTO> getPhysician(@PathVariable("physicianId") long physicianId){
		LOGGER.debug("the getPhysician method of  PhysicianController begins");
		PhysicianDTO Physician=physicianService.getPhysicianByPhysicianId(physicianId);
		LOGGER.debug("the getPhysician method PhysicianController ends");
		return new ResponseEntity<PhysicianDTO>(Physician,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/savePhysician", method=RequestMethod.POST)
	public ResponseEntity<String> savePhysicianData(@RequestBody PhysicianDTO physicianDTO){
		LOGGER.debug("The savePhysicianData method of PhysicianController begins");
		try{
		physicianService.persistPhysician(physicianDTO);
		}catch(Exception e){
			LOGGER.error("The error occurred in savePhysicianData method of PhysicianController begins");
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		LOGGER.debug("The savePhysicianData method of PhysicianControllers ends");
		return  ResponseEntity.status(HttpStatus.CREATED).build();
		
	}

	

}
