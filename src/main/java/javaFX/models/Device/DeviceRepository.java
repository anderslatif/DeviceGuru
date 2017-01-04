package javaFX.models.Device;

import javaFX.models.DeviceLogin.DeviceLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

interface DeviceRepository extends JpaRepository<Device, Long> {

}
