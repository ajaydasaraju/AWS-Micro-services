/**
 * 
 */
package com.renal.nh.patient.service;

import java.util.List;

import com.renal.nh.patient.DTO.PhysicianDTO;
import com.renal.nh.patient.entity.Physician;



/**
 * @author dasaraa
 *
 */
public interface PhysicianService {
	
	/**
	 * @param physicianId
	 * @return the PhysicianInformation
	 */
	

	public PhysicianDTO getPhysicianByPhysicianId(long physicianId);

	/**
	 * @param PhysicianId
	 * @return the list of Physicians
	 */

	public List<PhysicianDTO> getPhysiciansByPhysicianId(long physicianId);

	/**
	 * @param physician
	 */
	public void persistPhysician(PhysicianDTO physician);

	/**
	 * @param physician
	 */
	public void updatePhysician(Physician physician);

}
