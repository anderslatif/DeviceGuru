package javaFX.models.DeviceHistory;

import javaFX.models.Student.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface DeviceHistoryCustomRepository extends Repository<DeviceHistory, Long> {

    List<DeviceHistory> findByEmail(String email);

}
