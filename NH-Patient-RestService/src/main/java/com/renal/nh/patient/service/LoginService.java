package com.renal.nh.patient.service;

import com.renal.nh.patient.DTO.RoleDTO;

public interface LoginService {
	
	public RoleDTO GetRoleByActivationCode(long activationCode,String password);

}
