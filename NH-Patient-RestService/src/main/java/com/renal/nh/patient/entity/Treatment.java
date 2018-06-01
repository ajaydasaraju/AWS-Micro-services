package com.renal.nh.patient.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the TREATMENT database table.
 * 
 */
@Entity
@NamedQuery(name="Treatment.findAll", query="SELECT t FROM Treatment t")
public class Treatment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TREATMENT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private long treatmentId;

	@Column(name="BODY_WEIGHT")
	private BigDecimal bodyWeight;

	private String bp;

	private String comments;

	@Column(name="CREATE_TS")
	private Timestamp createTs;

	@Column(name="DRAIN_END_TIME")
	private Timestamp drainEndTime;

	@Column(name="DRAIN_START_TIME")
	private Timestamp drainStartTime;

	@Column(name="DRAIN_VOLUME")
	private BigDecimal drainVolume;

	@Column(name="FILL_END_TIME")
	private Timestamp fillEndTime;

	@Column(name="FILL_START_TIME")
	private Timestamp fillStartTime;

	@Column(name="FILL_VOLUME")
	private BigDecimal fillVolume;

	@Column(name="FLUSH_END_TIME")
	private Timestamp flushEndTime;

	@Column(name="FLUSH_START_TIME")
	private Timestamp flushStartTime;

	@Column(name="SOLUTION_USED")
	private BigDecimal solutionUsed;

	@Column(name="TREATMENT_END_TIME")
	private Timestamp treatmentEndTime;

	@Column(name="TREATMENT_START_TIME")
	private Timestamp treatmentStartTime;

	@Column(name="UPDATE_TS")
	private Timestamp updateTs;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="PATIENT_ID")
	private Patient patient;

	public Treatment() {
	}

	public long getTreatmentId() {
		return this.treatmentId;
	}

	public void setTreatmentId(long treatmentId) {
		this.treatmentId = treatmentId;
	}

	public BigDecimal getBodyWeight() {
		return this.bodyWeight;
	}

	public void setBodyWeight(BigDecimal bodyWeight) {
		this.bodyWeight = bodyWeight;
	}

	public String getBp() {
		return this.bp;
	}

	public void setBp(String bp) {
		this.bp = bp;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Timestamp getCreateTs() {
		return this.createTs;
	}

	public void setCreateTs(Timestamp createTs) {
		this.createTs = createTs;
	}

	public Timestamp getDrainEndTime() {
		return this.drainEndTime;
	}

	public void setDrainEndTime(Timestamp drainEndTime) {
		this.drainEndTime = drainEndTime;
	}

	public Timestamp getDrainStartTime() {
		return this.drainStartTime;
	}

	public void setDrainStartTime(Timestamp drainStartTime) {
		this.drainStartTime = drainStartTime;
	}

	public BigDecimal getDrainVolume() {
		return this.drainVolume;
	}

	public void setDrainVolume(BigDecimal drainVolume) {
		this.drainVolume = drainVolume;
	}

	public Timestamp getFillEndTime() {
		return this.fillEndTime;
	}

	public void setFillEndTime(Timestamp fillEndTime) {
		this.fillEndTime = fillEndTime;
	}

	public Timestamp getFillStartTime() {
		return this.fillStartTime;
	}

	public void setFillStartTime(Timestamp fillStartTime) {
		this.fillStartTime = fillStartTime;
	}

	public BigDecimal getFillVolume() {
		return this.fillVolume;
	}

	public void setFillVolume(BigDecimal fillVolume) {
		this.fillVolume = fillVolume;
	}

	public Timestamp getFlushEndTime() {
		return this.flushEndTime;
	}

	public void setFlushEndTime(Timestamp flushEndTime) {
		this.flushEndTime = flushEndTime;
	}

	public Timestamp getFlushStartTime() {
		return this.flushStartTime;
	}

	public void setFlushStartTime(Timestamp flushStartTime) {
		this.flushStartTime = flushStartTime;
	}

	public BigDecimal getSolutionUsed() {
		return this.solutionUsed;
	}

	public void setSolutionUsed(BigDecimal solutionUsed) {
		this.solutionUsed = solutionUsed;
	}

	public Timestamp getTreatmentEndTime() {
		return this.treatmentEndTime;
	}

	public void setTreatmentEndTime(Timestamp treatmentEndTime) {
		this.treatmentEndTime = treatmentEndTime;
	}

	public Timestamp getTreatmentStartTime() {
		return this.treatmentStartTime;
	}

	public void setTreatmentStartTime(Timestamp treatmentStartTime) {
		this.treatmentStartTime = treatmentStartTime;
	}

	public Timestamp getUpdateTs() {
		return this.updateTs;
	}

	public void setUpdateTs(Timestamp updateTs) {
		this.updateTs = updateTs;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}