/**
 * 
 */
package com.renal.nh.patient.service.impl;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renal.nh.patient.DTO.RoleDTO;
import com.renal.nh.patient.dao.LoginDAO;
import com.renal.nh.patient.entity.Role;
import com.renal.nh.patient.service.LoginService;

/**
 * @author dasaraa
 *
 */
@Service
public class LoginServiceImpl implements LoginService {

	/**
	 * Instance of PatientDAO
	 */
	@Autowired
	private LoginDAO loginDAO;

	/**
	 * 
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(LoginServiceImpl.class);

	@Override
	public RoleDTO GetRoleByActivationCode(long activationCode, String password) {
		LOGGER.info(
				"get the Role details by activationCode – Service Start : {} ",
				activationCode, new Timestamp(System.currentTimeMillis()));
		
		RoleDTO roleDTO=null;
		try {
            Role  role=loginDAO.GetRoleByActivationCode(activationCode, password);
            
            if(role!=null){
            	roleDTO=new RoleDTO();
            	roleDTO.setActivationCode(activationCode);
            	roleDTO.setUserRole(role.getUserRole());
            }
              
		} catch (Exception e) {
			LOGGER.error(
					"Error occurred while geting the Role by activationCode", e);
		}
		LOGGER.info(
				"get the Role details by activationCode – Service ends : {} ",
				activationCode, new Timestamp(System.currentTimeMillis()));
		return roleDTO;
	}

}
