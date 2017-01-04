package javaFX.models.Device;

import javaFX.models.Student.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface DeviceCustomRepository extends Repository<Student, Long> {

    @Modifying
    @Query("DELETE FROM Device WHERE serialnumber = ?1")
    void deleteDevice(String serialnumber);

}
