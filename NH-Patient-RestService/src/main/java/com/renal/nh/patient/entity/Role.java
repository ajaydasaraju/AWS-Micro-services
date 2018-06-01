package com.renal.nh.patient.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

/**
 * The persistent class for the "ROLE" database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROLE_SEQ", sequenceName="ROLE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLE_SEQ")
	@Column(name="ROLE_ID", unique=true, nullable=false)
	private long roleId;

	@Column(name="ACTIVATION_CODE", nullable=false)
	private long activationCode;

	@Column(name="USER_ROLE", length=200)
	private String userRole;
	
	@Column(nullable=false, length=50)
	private String password;

	public Role() {
	}

	public long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getActivationCode() {
		return this.activationCode;
	}

	public void setActivationCode(long activationCode) {
		this.activationCode = activationCode;
	}

	public String getUserRole() {
		return this.userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}