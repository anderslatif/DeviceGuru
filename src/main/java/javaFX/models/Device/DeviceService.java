package javaFX.models.Device;

import javaFX.models.DeviceLogin.DeviceLogin;

import javax.transaction.Transactional;
import java.util.List;

public interface DeviceService {

	List<Device> findAll();

	@Transactional
	Device save(Device device);

	@Transactional
	void delete(Device device);

}
