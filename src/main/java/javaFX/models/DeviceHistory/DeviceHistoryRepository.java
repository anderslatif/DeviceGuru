package javaFX.models.DeviceHistory;

import javaFX.models.Student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

interface DeviceHistoryRepository extends JpaRepository<DeviceHistory, Long> {

}
