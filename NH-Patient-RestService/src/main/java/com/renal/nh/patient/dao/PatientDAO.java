/**
 * 
 */
package com.renal.nh.patient.dao;

import java.util.List;

import com.renal.nh.patient.entity.Patient;
import com.renal.nh.patient.entity.Person;


/**
 * @author dasaraa
 *
 */
public interface PatientDAO  {
	
	public Patient getPatientByPatientId(long patientId);
	
	public Person getPersonByPersonId(long personId);
	
	public List<Patient> getPatientsByPhysicianId(long physicianId);
	
	public Patient persistPatient(Patient patient);
	
	public Patient updatePatient(Patient patient);

}
