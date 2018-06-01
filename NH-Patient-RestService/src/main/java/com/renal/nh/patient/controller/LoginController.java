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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.renal.nh.patient.DTO.RoleDTO;
import com.renal.nh.patient.service.LoginService;

/**
 * @author dasaraa
 *
 */
@RestController
public class LoginController {
	
	/**
	 *  Instance of loginService
	 */
	@Autowired
	private LoginService loginService;
	
	/**
	 * Instance of Logger
	 */
	private static final Logger LOGGER=LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="/role/{activationCode}/{password}",method=RequestMethod.GET)
	public ResponseEntity<RoleDTO> getRoleByActivationCode(@PathVariable("activationCode") Long activationCode,@PathVariable("password") String password){
		LOGGER.debug("the getRoleByActivationCode method of  LoginController begins");
		RoleDTO rolDto=null;
		try{
		 rolDto=loginService.GetRoleByActivationCode(activationCode, password);
		if(rolDto==null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		}catch(Exception e){
			LOGGER.info("Error occurred while getting the role by activationCode",e);
			return new ResponseEntity<RoleDTO>(HttpStatus.BAD_REQUEST); 
		}
		LOGGER.debug("the getRoleByActivationCode method of  LoginController ends");
		return new ResponseEntity<RoleDTO>(rolDto,HttpStatus.OK);
	}

}
