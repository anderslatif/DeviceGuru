package javaFX.models.Device;

import javaFX.models.DeviceLogin.DeviceLogin;
import org.springframework.data.jpa.repository.JpaRepository;

interface DeviceRepository extends JpaRepository<Device, Long> {

}
