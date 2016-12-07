package javaFX.models.Student;

import javaFX.models.Login.Login;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentService {

	List<Login> findAllStudents();

	@Transactional
	Login save(Login login);


}
