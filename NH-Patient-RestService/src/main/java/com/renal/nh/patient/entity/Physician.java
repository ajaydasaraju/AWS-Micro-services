package com.renal.nh.patient.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the PHYSICIAN database table.
 * 
 */
@Entity
@NamedQuery(name="Physician.findAll", query="SELECT p FROM Physician p")
public class Physician implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PHYSICIAN_ID")
	private long physicianId;

	@Column(name="CREATE_TS")
	private Timestamp createTs;

	@Column(name="MEDICAL_TITLE")
	private String medicalTitle;

	@Column(name="UPDATE_TS")
	private Timestamp updateTs;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="PERSON_ID")
	private Person person;

	public Physician() {
	}

	public long getPhysicianId() {
		return this.physicianId;
	}

	public void setPhysicianId(long physicianId) {
		this.physicianId = physicianId;
	}

	public Timestamp getCreateTs() {
		return this.createTs;
	}

	public void setCreateTs(Timestamp createTs) {
		this.createTs = createTs;
	}

	public String getMedicalTitle() {
		return this.medicalTitle;
	}

	public void setMedicalTitle(String medicalTitle) {
		this.medicalTitle = medicalTitle;
	}

	public Timestamp getUpdateTs() {
		return this.updateTs;
	}

	public void setUpdateTs(Timestamp updateTs) {
		this.updateTs = updateTs;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}