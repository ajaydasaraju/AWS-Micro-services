/**
 * 
 */
package com.renal.nh.patient.dao;

import com.renal.nh.patient.entity.Role;

/**
 * @author dasaraa
 *
 */
public interface LoginDAO {

	public Role GetRoleByActivationCode(long activationCode, String password);
}
