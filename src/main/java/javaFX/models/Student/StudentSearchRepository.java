package javaFX.models.Student;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface StudentSearchRepository extends Repository<Student, Long> {

    @Query("select s from Student s where (?1 = s.firstName or ?1 = '') and (?2 = s.lastName or ?2 = '') " +
            "and (?3 = s.schoolClass or ?3 = '') and (?4 = s.device.serialnumber or ?4 = '')" +
            "and (?5 = s.deviceLogin.email or ?5 = '')")
    List<Student> search(String firstName, String lastName, String schoolClass, String serialNumber, String email);

}
