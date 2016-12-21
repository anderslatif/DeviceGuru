package javaFX.models.Student;

import javaFX.models.Login.Login;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentService {

	List<Student> findAll();

	List<Student> search(String firstName, String lastName, String schoolClass, String serialNumber, String email);

	@Transactional
	Student save(Student student);

	@Transactional
	void delete(Student student);

}
