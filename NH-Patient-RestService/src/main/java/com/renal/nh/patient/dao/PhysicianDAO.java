/**
 * 
 */
package com.renal.nh.patient.dao;

import java.util.List;

import com.renal.nh.patient.entity.Physician;

/**
 * @author dasaraa
 *
 */
public interface PhysicianDAO {
	
public Physician getPhysicianByPhysicianId(long physicianId);
	
	
	public List<Physician> getPhysiciansByPhysicianId(long physicianId);
	
	public Physician persistPhysician(Physician physician);
	
	public Physician updatePhysician(Physician physician);

}
