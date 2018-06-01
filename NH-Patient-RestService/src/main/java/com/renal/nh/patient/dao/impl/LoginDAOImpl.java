/**
 * 
 */
package com.renal.nh.patient.dao.impl;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.renal.nh.patient.dao.LoginDAO;
import com.renal.nh.patient.entity.Role;

/**
 * @author dasaraa
 *
 */
@Transactional
@Repository
public class LoginDAOImpl implements LoginDAO {

	/**
	 * Instance of entityManager
	 */
	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Instance off the logger
	 */
	public static final Logger LOOGER = LoggerFactory
			.getLogger(LoginDAOImpl.class);

	@Override
	public Role GetRoleByActivationCode(long activationCode, String password) {
		LOOGER.info(
				"Get the Role by activationCode - DB transaction Start : {}",
				activationCode, new Timestamp(System.currentTimeMillis()));
		Role role = null;
		try {
			Query query=this.entityManager.createQuery("SELECT p FROM Role p where p.activationCode= :activationCode and p.password= :password");
			query.setParameter("activationCode", activationCode);
			query.setParameter("password", password);
			role =  (Role) query.getSingleResult() ;
		} catch (Exception e) {
			LOOGER.error(
					"error occurred while getting the Role by activationCode",
					e);
		}
		LOOGER.info(
				"Get the Role by activationCode - DB transaction ends : {}",
				activationCode, new Timestamp(System.currentTimeMillis()));
		return role;
	}

}
