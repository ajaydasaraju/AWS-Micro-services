/**
 * 
 */
package com.renal.nh.patient.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renal.nh.patient.DTO.PhysicianDTO;
import com.renal.nh.patient.dao.PatientDAO;
import com.renal.nh.patient.dao.PhysicianDAO;
import com.renal.nh.patient.entity.Person;
import com.renal.nh.patient.entity.Physician;
import com.renal.nh.patient.service.PhysicianService;

/**
 * @author dasaraa
 *
 */
@Service
public class PhysicianServiceImpl implements PhysicianService{
	
	/**
	 * Instance of PhysicianDAO
	 */
	@Autowired
	private PhysicianDAO physicianDAO;
	
	/**
	 * Instance of PatientDAO
	 */
	@Autowired
	private PatientDAO patientDAO;
	
	
	/**
	 * Logger instance of PhysicianServiceImpl
	 */
	private static final Logger LOGGER=LoggerFactory.getLogger(PhysicianServiceImpl.class);

	@Override
	public PhysicianDTO getPhysicianByPhysicianId(long physicianId) {
		LOGGER.info("get the physician details by physicianId – Service Start : {} ", physicianId,
				new Timestamp(System.currentTimeMillis()));
		Physician physician=null;
		PhysicianDTO physicianDTO=null;
		try {
			physician = (Physician) physicianDAO.getPhysicianByPhysicianId(physicianId);
			
			if(physician!=null){
				physicianDTO=new PhysicianDTO(physicianId);
				Person person=physician.getPerson();
				if(person!=null){
					if(person.getFirstName()!=null && !person.getFirstName().isEmpty()){
						physicianDTO.setFirstName(person.getFirstName());
					}
					if(person.getLastName()!=null && !person.getLastName().isEmpty()){
						physicianDTO.setLastName(person.getLastName());
					}
					if(person.getMiddleName()!=null && !person.getMiddleName().isEmpty()){
						physicianDTO.setMiddleName(person.getMiddleName());
					}
					if(physician.getMedicalTitle()!=null && !physician.getMedicalTitle().isEmpty()){
						physicianDTO.setMedicalTitle(physician.getMedicalTitle());
					}
				}
			}

		}
		catch(Exception e){
			LOGGER.error("The error occurred while geting the physician details by physicianId",e);
		}
		LOGGER.info("get the physician details by physicianId – Service ends : {} ", physicianId,
				new Timestamp(System.currentTimeMillis()));
		return physicianDTO;
	}

	@Override
	public List<PhysicianDTO> getPhysiciansByPhysicianId(long physicianId) {
		LOGGER.info("get the physician details by physicianId – Service Start : {} ", physicianId,
				new Timestamp(System.currentTimeMillis()));
		List<Physician> physicians=null;
		List<PhysicianDTO> physicianDetails=null;
		try{
			physicians=physicianDAO.getPhysiciansByPhysicianId(physicianId);
			if(physicians!=null){
				physicianDetails= new ArrayList<PhysicianDTO>();
				for(Physician physician:physicians){
					PhysicianDTO physicianDTO=new PhysicianDTO(physician.getPhysicianId());
					Person person=physician.getPerson();
					if(person!=null){
						if(person.getFirstName()!=null && !person.getFirstName().isEmpty()){
							physicianDTO.setFirstName(person.getFirstName());
						}
						if(person.getLastName()!=null && !person.getLastName().isEmpty()){
							physicianDTO.setLastName(person.getLastName());
						}
						if(person.getMiddleName()!=null && !person.getMiddleName().isEmpty()){
							physicianDTO.setMiddleName(person.getMiddleName());
						}
					}
					physicianDetails.add(physicianDTO);
				}
			}
		}catch(Exception e){
			LOGGER.error("The error occurred while geting the physician details by physicianId",e);
		}
		LOGGER.info("get the physician details by physicianId – Service ends : {} ", physicianId,
				new Timestamp(System.currentTimeMillis()));
		
		
		return physicianDetails;
	}

	@Override
	public void persistPhysician(PhysicianDTO physicianDTO) {
		LOGGER.info("Persist the Treatment Data by treatment – Service starts : {} ",
				new Timestamp(System.currentTimeMillis()));
		Physician physician=null;
		try{
			if(physicianDTO!=null){
				physician=new Physician();
				Person person=patientDAO.getPersonByPersonId(physicianDTO.getPhysicianId());
				if(person!=null){
					physician.setPerson(person);
				}
				physician.setMedicalTitle(physicianDTO.getMedicalTitle());
				physician.setCreateTs(new Timestamp(System.currentTimeMillis()));
				physician.setUpdateTs(new Timestamp(System.currentTimeMillis()));
			}
			physicianDAO.persistPhysician(physician);
		}catch(Exception e){
				LOGGER.error("The error occurred while persisting the Physician details",e);
			}
			LOGGER.info("Persist the Treatment Data by treatment – Service ends : {} ",
					new Timestamp(System.currentTimeMillis()));
			
	}

	@Override
	public void updatePhysician(Physician physician) {
		LOGGER.info("Update the Treatment Data by treatment – Service starts : {} ",
				new Timestamp(System.currentTimeMillis()));
		try{
			physicianDAO.updatePhysician(physician);
		}catch(Exception e){
				LOGGER.error("The error occurred while update the Physician details",e);
			}
			LOGGER.info("update the Treatment Data by treatment – Service ends : {} ",
					new Timestamp(System.currentTimeMillis()));
	}

	

}
