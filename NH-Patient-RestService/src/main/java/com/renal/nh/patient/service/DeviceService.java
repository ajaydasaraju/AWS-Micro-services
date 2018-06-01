/**
 * 
 */
package com.renal.nh.patient.service;

import com.renal.nh.patient.DTO.DeviceDTO;
import com.renal.nh.patient.entity.Device;

/**
 * @author dasaraa
 *
 */
public interface DeviceService {
	
	public DeviceDTO getDeviceByDeviceId(long deviceId);
	
	public void persistDeviceData(DeviceDTO device);
	
	public void updateDeviceData(Device device);

}
