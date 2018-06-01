
package com.renal.nh.patient.service;

import java.util.List;

import com.renal.nh.patient.DTO.PatientDTO;
import com.renal.nh.patient.entity.Patient;
import com.renal.nh.patient.entity.Person;

/**
 * 
 * Services for patients.
 *
 *
 */
public interface PatientRestService {

	/**
	 * @param patientId
	 * @return the PatientInformation
	 */

	public PatientDTO getPatientByPatientId(long patientId);

	/**
	 * @param personId
	 * @return the PersonInformation
	 */

	public Person getPersonByPersonId(long personId);

	/**
	 * @param PhysicianId
	 * @return the list of Patients
	 */

	public List<PatientDTO> getPatientsByPhysicianId(long physicianId);

	/**
	 * @param patient
	 */
	public void persistPatient(PatientDTO patient);

	/**
	 * @param patient
	 */
	public void updatePatient(Patient patient);

}
