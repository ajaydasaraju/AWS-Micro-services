package com.renal.nh.patient.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the PRESCRIPTION database table.
 * 
 */
@Entity
@NamedQuery(name="Prescription.findAll", query="SELECT p FROM Prescription p")
public class Prescription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PRESCRIPTION_ID", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRESCRIPTION_SEQ")
	@SequenceGenerator(name="PRESCRIPTION_SEQ", sequenceName = "PRESCRIPTION_SEQ", allocationSize = 1 )
	private long prescriptionId;

	@Column(name="CREATE_TS")
	private Timestamp createTs;

	@Column(name="DRAIN_TIME")
	private Timestamp drainTime;

	@Column(name="EXCHANGE_TYPE", length=200)
	private String exchangeType;

	@Column(name="FILL_TIME")
	private Timestamp fillTime;

	@Column(name="FLUSH_TIME")
	private Timestamp flushTime;

	@Column(name="SOLUTION_VOLUME", precision=22)
	private BigDecimal solutionVolume;

	@Column(name="TOTAL_EXCHANGES", precision=22)
	private BigDecimal totalExchanges;

	@Column(name="UPDATE_TS")
	private Timestamp updateTs;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="PATIENT_ID", nullable=false)
	private Patient patient;

	public Prescription() {
	}

	public long getPrescriptionId() {
		return this.prescriptionId;
	}

	public void setPrescriptionId(long prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public Timestamp getCreateTs() {
		return this.createTs;
	}

	public void setCreateTs(Timestamp createTs) {
		this.createTs = createTs;
	}

	public Timestamp getDrainTime() {
		return this.drainTime;
	}

	public void setDrainTime(Timestamp drainTime) {
		this.drainTime = drainTime;
	}

	public String getExchangeType() {
		return this.exchangeType;
	}

	public void setExchangeType(String exchangeType) {
		this.exchangeType = exchangeType;
	}

	public Timestamp getFillTime() {
		return this.fillTime;
	}

	public void setFillTime(Timestamp fillTime) {
		this.fillTime = fillTime;
	}

	public Timestamp getFlushTime() {
		return this.flushTime;
	}

	public void setFlushTime(Timestamp flushTime) {
		this.flushTime = flushTime;
	}

	public BigDecimal getSolutionVolume() {
		return this.solutionVolume;
	}

	public void setSolutionVolume(BigDecimal solutionVolume) {
		this.solutionVolume = solutionVolume;
	}

	public BigDecimal getTotalExchanges() {
		return this.totalExchanges;
	}

	public void setTotalExchanges(BigDecimal totalExchanges) {
		this.totalExchanges = totalExchanges;
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