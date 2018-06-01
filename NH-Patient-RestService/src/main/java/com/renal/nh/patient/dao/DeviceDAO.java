/**
 * 
 */
package com.renal.nh.patient.dao;

import com.renal.nh.patient.entity.Device;

/**
 * @author dasaraa
 *
 */
public interface DeviceDAO {

	public Device getDeviceByDeviceId(long deviceId);
	
	public Device persistDeviceData(Device device);
	
	public Device updateDeviceData(Device device);
}
