package javaFX.models.DeviceLogin;

import javaFX.models.Student.Student;

import javax.transaction.Transactional;
import java.util.List;

public interface DeviceLoginService {

	List<DeviceLogin> findAll();

	@Transactional
	DeviceLogin save(DeviceLogin deviceLogin);


}
