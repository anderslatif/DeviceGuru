package javaFX.models.Device;

import javaFX.models.DeviceLogin.DeviceLogin;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface DeviceService {

	List<Device> findAll();

	@Transactional
	Device save(Device device);

	@Transactional
	void deleteDevice(Device device);


}
