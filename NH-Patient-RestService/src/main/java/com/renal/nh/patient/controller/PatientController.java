
package com.renal.nh.patient.controller;

import java.util.List;

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

import com.renal.nh.patient.DTO.PatientDTO;
import com.renal.nh.patient.service.PatientRestService;

/**
 * Rest controller for patients.
 * 
 * @author dasaraa
 *
 */
@RestController
public class PatientController {

	/**
	 * Instance of PatientRestService
	 */
	@Autowired
	PatientRestService patientService;
	
	private static final Logger LOGGER =LoggerFactory.getLogger(PatientController.class);
	
	/**
	 * @param patientId
	 * @return the Patient details
	 */
	@RequestMapping(value="/patients/{patientId}",method=RequestMethod.GET)
	public  ResponseEntity<PatientDTO> getPatient(@PathVariable("patientId") long patientId){
		LOGGER.debug("the getPatient method of  PatientController begins");
		PatientDTO patient=patientService.getPatientByPatientId(patientId);
		LOGGER.debug("the getPatient method PatientController ends");
		return new ResponseEntity<PatientDTO>(patient,HttpStatus.OK);
	}
	
	
	/**
	 * @param physicianId
	 * @return the list of Patient details
	 */
	@RequestMapping(value="/patientDetails/{physicianId}",method=RequestMethod.GET)
	public  ResponseEntity<List<PatientDTO>> getPatientsList(@PathVariable("physicianId") long physicianId){
		LOGGER.debug("the getPatientsList method of  PatientController begins");
		List<PatientDTO> patients=patientService.getPatientsByPhysicianId(physicianId);
		LOGGER.debug("the getPatientsList method PatientController ends");
		return new ResponseEntity<List<PatientDTO>>(patients,HttpStatus.OK);
	}
	
	@RequestMapping(value="/savePatient", method=RequestMethod.POST)
	public ResponseEntity<String> savePatientData(@RequestBody PatientDTO patientDTO){
		LOGGER.debug("The savePatientData method of PatientController begins");
		try{
		patientService.persistPatient(patientDTO);
		}catch(Exception e){
			LOGGER.error("The error occurred in savePatientData method of PatientController begins");
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		LOGGER.debug("The savePatientData method of PatientControllers ends");
		return  ResponseEntity.status(HttpStatus.CREATED).build();
		
	}

	
}
