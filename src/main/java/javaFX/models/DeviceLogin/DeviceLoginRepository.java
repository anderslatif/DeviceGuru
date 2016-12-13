package javaFX.models.DeviceLogin;

import javaFX.models.Student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

interface DeviceLoginRepository extends JpaRepository<DeviceLogin, Long> {

}
