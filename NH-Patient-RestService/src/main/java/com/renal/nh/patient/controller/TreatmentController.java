/**
 * 
 */
package com.renal.nh.patient.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.renal.nh.patient.DTO.TreatmentDTO;
import com.renal.nh.patient.service.TreatmentService;

/**
 * @author dasaraa
 *
 */
@RestController
public class TreatmentController {
	
	/**
	 *  Instance  of TreatmentService
	 */
	@Autowired
	private TreatmentService treatmentService;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(TreatmentController.class);
	
	@RequestMapping(value="/treatments/{treatmentId}",method=RequestMethod.GET)
	public ResponseEntity<TreatmentDTO> getTreatment(@PathVariable("treatmentId") long treatmentId){
		LOGGER.debug("the getTreatment method of  TreatmentController begins");
		TreatmentDTO treatmentDTO=treatmentService.getTreatmentData(treatmentId);
		LOGGER.debug("the getTreatment method of  TreatmentController ends");
		return new ResponseEntity<TreatmentDTO>(treatmentDTO,HttpStatus.OK);
	}
	
	@RequestMapping(value="/patientTreatments/{patientId}",method=RequestMethod.GET)
	public ResponseEntity<List<TreatmentDTO>> getPatientTreatmentData(@PathVariable("patientId") long patientId){
		LOGGER.debug("The getPatientTreatmentData method of TreatmentController begins");
		List<TreatmentDTO> treatmentDTOs=treatmentService.getpatientTreatmentData(patientId);
		LOGGER.debug("The getPatientTreatmentData method of TreatmentController begins");
		return new ResponseEntity<List<TreatmentDTO>>(treatmentDTOs,HttpStatus.OK);
	}
	
	@RequestMapping(value="/patientTreatment/{patientId}",method=RequestMethod.GET)
	public ResponseEntity<List<TreatmentDTO>> getPatientsTreatmentData(@PathVariable("patientId") long patientId,
			@RequestHeader(name="treatmentStartDate")String treatmentStartDate,@RequestHeader(name="treatmentEndDate")String  treatmentEndDate){
		LOGGER.debug("The getPatientTreatmentData method of TreatmentController begins");
		List<TreatmentDTO> treatmentDTOs=treatmentService.getpatientsTreatmentData(patientId, treatmentStartDate, treatmentEndDate);
		LOGGER.debug("The getPatientTreatmentData method of TreatmentController begins");
		return new ResponseEntity<List<TreatmentDTO>>(treatmentDTOs,HttpStatus.OK);
	}
	
	@RequestMapping(value="/saveTreatment", method=RequestMethod.POST)
	public ResponseEntity<String> saveTreamentData(@RequestBody TreatmentDTO treatmentDTO){
		LOGGER.debug("The saveTreamentData method of TreatmentController begins");
		try{
		treatmentService.persistTreatmentData(treatmentDTO);
		}catch(Exception e){
			LOGGER.error("The error occurred in saveTreatment method of TreatmentController begins");
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		LOGGER.debug("The saveTreamentData method of TreatmentController ends");
		return  ResponseEntity.status(HttpStatus.CREATED).build();
		
	}

}
