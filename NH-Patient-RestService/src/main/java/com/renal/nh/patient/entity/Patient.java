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
 * The persistent class for the PATIENT database table.
 * 
 */
@Entity
@NamedQuery(name="Patient.findAll", query="SELECT p FROM Patient p")
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PATIENT_ID")
	private long patientId;

	@Column(name="CREATE_TS")
	private Timestamp createTs;

	@Column(name="UPDATE_TS")
	private Timestamp updateTs;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="PERSON_ID")
	private Person person;

	//bi-directional many-to-one association to Physician
	@ManyToOne
	@JoinColumn(name="PHYSICIAN_ID")
	private Physician physician;

	public Patient() {
	}

	public long getPatientId() {
		return this.patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public Timestamp getCreateTs() {
		return this.createTs;
	}

	public void setCreateTs(Timestamp createTs) {
		this.createTs = createTs;
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

	public Physician getPhysician() {
		return this.physician;
	}

	public void setPhysician(Physician physician) {
		this.physician = physician;
	}

}