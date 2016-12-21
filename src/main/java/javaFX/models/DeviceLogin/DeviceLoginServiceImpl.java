package javaFX.models.DeviceLogin;

import javaFX.models.Student.Student;
import javaFX.models.Student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class DeviceLoginServiceImpl implements DeviceLoginService {

	private final DeviceLoginRepository deviceLoginRepository;


	public List<DeviceLogin> findAll() {
		return deviceLoginRepository.findAll();
	}

	@Transactional
	public DeviceLogin save(DeviceLogin deviceLogin) {
		return deviceLoginRepository.save(deviceLogin);
	}

	public void delete(DeviceLogin deviceLogin) {
		deviceLoginRepository.delete(deviceLogin);
	}
}
