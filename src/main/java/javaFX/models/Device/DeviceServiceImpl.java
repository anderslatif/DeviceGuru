package javaFX.models.Device;

import javaFX.models.DeviceLogin.DeviceLogin;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class DeviceServiceImpl implements DeviceService {

	private final DeviceRepository deviceRepository;
	private final DeviceCustomRepository deviceCustomRepository;

	@PersistenceContext
	private EntityManager entityManager;

	public List<Device> findAll() {
		return deviceRepository.findAll();
	}

	@Transactional
	public Device save(Device device) {
		return deviceRepository.save(device);
	}

	@Override
	public void deleteDevice(Device device) {

		Query query = entityManager.createQuery("delete from Device where serialnumber = " + device.getSerialnumber());
		query.executeUpdate();

		/*		Query query = entityManager.createQuery("SET FOREIGN_KEY_CHECKS=0");
		query.executeUpdate();
		entityManager.remove(entityManager.contains(device) ? device : entityManager.merge(device));
		Query query1 = entityManager.createQuery("SET FOREIGN_KEY_CHECKS=1");
		query1.executeUpdate();*/
		//deviceRepository.delete(device);
	}




}
