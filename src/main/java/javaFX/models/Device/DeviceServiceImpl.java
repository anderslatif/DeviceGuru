package javaFX.models.Device;

import javaFX.models.DeviceLogin.DeviceLogin;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class DeviceServiceImpl implements DeviceService {

	private final DeviceRepository deviceRepository;

	public List<Device> findAll() {
		return deviceRepository.findAll();
	}

	@Transactional
	public Device save(Device device) {
		return deviceRepository.save(device);
	}
}
