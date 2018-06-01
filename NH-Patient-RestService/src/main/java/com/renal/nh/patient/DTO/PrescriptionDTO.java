/**
 * 
 */
package com.renal.nh.patient.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author dasaraa
 *
 */
public class PrescriptionDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 584414679645639878L;
	
	
	/**
	 * 
	 */
	private long prescriptionId;

	private Timestamp drainTime;

	private String exchangeType;

	private Timestamp fillTime;

	private Timestamp flushTime;

	private BigDecimal solutionVolume;

	private BigDecimal totalExchanges;
	
	private long patientId;
	
	
	/**
	 *  Default costructor of the PrescriptionDTO
	 */
	public PrescriptionDTO(){
		
	}

	/**
	 * @param prescriptionId
	 * @param drainTime
	 * @param exchangeType
	 * @param fillTime
	 * @param flushTime
	 * @param solutionVolume
	 * @param totalExchanges
	 * @param createTs
	 * @param updateTs
	 * @param patientId
	 */
	public PrescriptionDTO(long prescriptionId, Timestamp drainTime,
			String exchangeType, Timestamp fillTime, Timestamp flushTime,
			BigDecimal solutionVolume, BigDecimal totalExchanges) {
		this.prescriptionId = prescriptionId;
		this.drainTime = drainTime;
		this.exchangeType = exchangeType;
		this.fillTime = fillTime;
		this.flushTime = flushTime;
		this.solutionVolume = solutionVolume;
		this.totalExchanges = totalExchanges;
	}

	/**
	 * @return the prescriptionId
	 */
	public long getPrescriptionId() {
		return prescriptionId;
	}

	/**
	 * @param prescriptionId the prescriptionId to set
	 */
	public void setPrescriptionId(long prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	/**
	 * @return the drainTime
	 */
	public Timestamp getDrainTime() {
		return drainTime;
	}

	/**
	 * @param drainTime the drainTime to set
	 */
	public void setDrainTime(Timestamp drainTime) {
		this.drainTime = drainTime;
	}

	/**
	 * @return the exchangeType
	 */
	public String getExchangeType() {
		return exchangeType;
	}

	/**
	 * @param exchangeType the exchangeType to set
	 */
	public void setExchangeType(String exchangeType) {
		this.exchangeType = exchangeType;
	}

	/**
	 * @return the fillTime
	 */
	public Timestamp getFillTime() {
		return fillTime;
	}

	/**
	 * @param fillTime the fillTime to set
	 */
	public void setFillTime(Timestamp fillTime) {
		this.fillTime = fillTime;
	}

	/**
	 * @return the flushTime
	 */
	public Timestamp getFlushTime() {
		return flushTime;
	}

	/**
	 * @param flushTime the flushTime to set
	 */
	public void setFlushTime(Timestamp flushTime) {
		this.flushTime = flushTime;
	}

	/**
	 * @return the solutionVolume
	 */
	public BigDecimal getSolutionVolume() {
		return solutionVolume;
	}

	/**
	 * @param solutionVolume the solutionVolume to set
	 */
	public void setSolutionVolume(BigDecimal solutionVolume) {
		this.solutionVolume = solutionVolume;
	}

	/**
	 * @return the totalExchanges
	 */
	public BigDecimal getTotalExchanges() {
		return totalExchanges;
	}

	/**
	 * @param totalExchanges the totalExchanges to set
	 */
	public void setTotalExchanges(BigDecimal totalExchanges) {
		this.totalExchanges = totalExchanges;
	}

	/**
	 * @return the patientId
	 */
	public long getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
