package javaFX.models.Student;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentService {

	List<Student> findAllStudents();

	@Transactional
	Student save(Student student);


}
