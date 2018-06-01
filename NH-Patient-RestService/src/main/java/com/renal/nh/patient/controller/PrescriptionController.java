/**
 * 
 */
package com.renal.nh.patient.controller;

import java.sql.Timestamp;

import javax.websocket.server.PathParam;

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

import com.renal.nh.patient.DTO.PrescriptionDTO;
import com.renal.nh.patient.service.PrescriptionService;

/**
 * @author dasaraa
 *
 */
@RestController
public class PrescriptionController {
	
	/**
	 *  Instance of the PrescriptionService
	 */
	@Autowired
	private PrescriptionService prescriptionService;
	
	/**
	 *  Instance of the logger
	 */
	public static final Logger LOGGER=LoggerFactory.getLogger(PrescriptionController.class);
	
	
	/**
	 * @param pateintId
	 * 
	 * return the patient Prescription
	 */
	@RequestMapping(value="Prescription/{patientId}",method=RequestMethod.GET)
	public ResponseEntity<PrescriptionDTO> getPrescription(@PathVariable("patientId")Long patientId){
		LOGGER.info("get the patient Prescription by patientId starts",new Timestamp(System.currentTimeMillis()));
		PrescriptionDTO prescriptionDTO=null;
		try{
			prescriptionDTO=prescriptionService.getPrescriptionByPatientId(patientId);
		}catch(Exception e){
			return new ResponseEntity<PrescriptionDTO>(HttpStatus.BAD_REQUEST);
		}
		LOGGER.info("get patient Prescription  by patientId method ends",new Timestamp(System.currentTimeMillis()));
		return new ResponseEntity<PrescriptionDTO>(prescriptionDTO,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/savePrescription", method=RequestMethod.POST)
	public ResponseEntity<String> savePrescriptionData(@RequestBody PrescriptionDTO prescriptionDTO){
		LOGGER.debug("The savePrescriptionData method of PrescriptionController begins");
		try{
			prescriptionService.savePrescription(prescriptionDTO);
		}catch(Exception e){
			LOGGER.error("The error occurred in savePrescription method of PrescriptionController begins");
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		LOGGER.debug("The savePrescriptionDataData method of PrescriptionController ends");
		return  ResponseEntity.status(HttpStatus.CREATED).build();
		
	}

}
