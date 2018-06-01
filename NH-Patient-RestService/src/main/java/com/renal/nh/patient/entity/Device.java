package com.renal.nh.patient.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the DEVICE database table.
 * 
 */
@Entity
@NamedQuery(name="Device.findAll", query="SELECT d FROM Device d")
public class Device implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DEVICE_ID")
	private long deviceId;

	@Column(name="CREATE_TS")
	private Timestamp createTs;

	@Column(name="HOTSPOT_NAME")
	private String hotspotName;

	@Column(name="HOTSPOT_PASSWORD")
	private String hotspotPassword;

	@Column(name="UPDATE_TS")
	private Timestamp updateTs;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="PATIENT_ID")
	private Patient patient;

	public Device() {
	}

	public long getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
	}

	public Timestamp getCreateTs() {
		return this.createTs;
	}

	public void setCreateTs(Timestamp createTs) {
		this.createTs = createTs;
	}

	public String getHotspotName() {
		return this.hotspotName;
	}

	public void setHotspotName(String hotspotName) {
		this.hotspotName = hotspotName;
	}

	public String getHotspotPassword() {
		return this.hotspotPassword;
	}

	public void setHotspotPassword(String hotspotPassword) {
		this.hotspotPassword = hotspotPassword;
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