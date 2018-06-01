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
public class TreatmentDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private long treatmentId;
	/**
	 * 
	 */
	private BigDecimal bodyWeight;

	/**
	 * 
	 */
	private String bp;

	/**
	 * 
	 */
	private String comments;

	/**
	 * 
	 */
	private Timestamp drainEndTime;

	/**
	 * 
	 */
	private Timestamp drainStartTime;

	/**
	 * 
	 */
	private BigDecimal drainVolume;

	/**
	 * 
	 */
	private Timestamp fillEndTime;

	/**
	 * 
	 */
	private Timestamp fillStartTime;

	/**
	 * 
	 */
	private BigDecimal fillVolume;

	/**
	 * 
	 */
	private Timestamp flushEndTime;

	/**
	 * 
	 */
	private Timestamp flushStartTime;

	/**
	 * 
	 */
	private BigDecimal solutionUsed;

	/**
	 * 
	 */
	private Timestamp treatmentEndTime;

	/**
	 * 
	 */
	private Timestamp treatmentStartTime;


	/**
	 * 
	 */
	private long patientId;
	
	public TreatmentDTO(){
		
	}
	
	/**
	 * @param treatmentId
	 * @param bodyWeight
	 * @param bp
	 * @param comments
	 * @param createTs
	 * @param drainEndTime
	 * @param drainStartTime
	 * @param drainVolume
	 * @param fillEndTime
	 * @param fillStartTime
	 * @param fillVolume
	 * @param flushEndTime
	 * @param flushStartTime
	 * @param solutionUsed
	 * @param treatmentEndTime
	 * @param treatmentStartTime
	 * @param patientId
	 */
	public TreatmentDTO(long treatmentId, BigDecimal bodyWeight, String bp,
			String comments, Timestamp drainEndTime,
			Timestamp drainStartTime, BigDecimal drainVolume,
			Timestamp fillEndTime, Timestamp fillStartTime,
			BigDecimal fillVolume, Timestamp flushEndTime,
			Timestamp flushStartTime, BigDecimal solutionUsed,
			Timestamp treatmentEndTime, Timestamp treatmentStartTime) {
		super();
		this.treatmentId = treatmentId;
		this.bodyWeight = bodyWeight;
		this.bp = bp;
		this.comments = comments;
		this.drainEndTime = drainEndTime;
		this.drainStartTime = drainStartTime;
		this.drainVolume = drainVolume;
		this.fillEndTime = fillEndTime;
		this.fillStartTime = fillStartTime;
		this.fillVolume = fillVolume;
		this.flushEndTime = flushEndTime;
		this.flushStartTime = flushStartTime;
		this.solutionUsed = solutionUsed;
		this.treatmentEndTime = treatmentEndTime;
		this.treatmentStartTime = treatmentStartTime;
	}

	/**
	 * @return the treatmentId
	 */
	public long getTreatmentId() {
		return treatmentId;
	}

	/**
	 * @param treatmentId the treatmentId to set
	 */
	public void setTreatmentId(long treatmentId) {
		this.treatmentId = treatmentId;
	}

	/**
	 * @return the bodyWeight
	 */
	public BigDecimal getBodyWeight() {
		return bodyWeight;
	}

	/**
	 * @param bodyWeight the bodyWeight to set
	 */
	public void setBodyWeight(BigDecimal bodyWeight) {
		this.bodyWeight = bodyWeight;
	}

	/**
	 * @return the bp
	 */
	public String getBp() {
		return bp;
	}

	/**
	 * @param bp the bp to set
	 */
	public void setBp(String bp) {
		this.bp = bp;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the drainEndTime
	 */
	public Timestamp getDrainEndTime() {
		return drainEndTime;
	}

	/**
	 * @param drainEndTime the drainEndTime to set
	 */
	public void setDrainEndTime(Timestamp drainEndTime) {
		this.drainEndTime = drainEndTime;
	}

	/**
	 * @return the drainStartTime
	 */
	public Timestamp getDrainStartTime() {
		return drainStartTime;
	}

	/**
	 * @param drainStartTime the drainStartTime to set
	 */
	public void setDrainStartTime(Timestamp drainStartTime) {
		this.drainStartTime = drainStartTime;
	}

	/**
	 * @return the drainVolume
	 */
	public BigDecimal getDrainVolume() {
		return drainVolume;
	}

	/**
	 * @param drainVolume the drainVolume to set
	 */
	public void setDrainVolume(BigDecimal drainVolume) {
		this.drainVolume = drainVolume;
	}

	/**
	 * @return the fillEndTime
	 */
	public Timestamp getFillEndTime() {
		return fillEndTime;
	}

	/**
	 * @param fillEndTime the fillEndTime to set
	 */
	public void setFillEndTime(Timestamp fillEndTime) {
		this.fillEndTime = fillEndTime;
	}

	/**
	 * @return the fillStartTime
	 */
	public Timestamp getFillStartTime() {
		return fillStartTime;
	}

	/**
	 * @param fillStartTime the fillStartTime to set
	 */
	public void setFillStartTime(Timestamp fillStartTime) {
		this.fillStartTime = fillStartTime;
	}

	/**
	 * @return the fillVolume
	 */
	public BigDecimal getFillVolume() {
		return fillVolume;
	}

	/**
	 * @param fillVolume the fillVolume to set
	 */
	public void setFillVolume(BigDecimal fillVolume) {
		this.fillVolume = fillVolume;
	}

	/**
	 * @return the flushEndTime
	 */
	public Timestamp getFlushEndTime() {
		return flushEndTime;
	}

	/**
	 * @param flushEndTime the flushEndTime to set
	 */
	public void setFlushEndTime(Timestamp flushEndTime) {
		this.flushEndTime = flushEndTime;
	}

	/**
	 * @return the flushStartTime
	 */
	public Timestamp getFlushStartTime() {
		return flushStartTime;
	}

	/**
	 * @param flushStartTime the flushStartTime to set
	 */
	public void setFlushStartTime(Timestamp flushStartTime) {
		this.flushStartTime = flushStartTime;
	}

	/**
	 * @return the solutionUsed
	 */
	public BigDecimal getSolutionUsed() {
		return solutionUsed;
	}

	/**
	 * @param solutionUsed the solutionUsed to set
	 */
	public void setSolutionUsed(BigDecimal solutionUsed) {
		this.solutionUsed = solutionUsed;
	}

	/**
	 * @return the treatmentEndTime
	 */
	public Timestamp getTreatmentEndTime() {
		return treatmentEndTime;
	}

	/**
	 * @param treatmentEndTime the treatmentEndTime to set
	 */
	public void setTreatmentEndTime(Timestamp treatmentEndTime) {
		this.treatmentEndTime = treatmentEndTime;
	}

	/**
	 * @return the treatmentStartTime
	 */
	public Timestamp getTreatmentStartTime() {
		return treatmentStartTime;
	}

	/**
	 * @param treatmentStartTime the treatmentStartTime to set
	 */
	public void setTreatmentStartTime(Timestamp treatmentStartTime) {
		this.treatmentStartTime = treatmentStartTime;
	}

	/**
	 * @return the patientId
	 */
	public long getPatient() {
		return patientId;
	}

	/**
	 * @param patient the patient to set
	 */
	public void setPatient(long patientId) {
		this.patientId = patientId;
	}

}
