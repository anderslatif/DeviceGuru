package javaFX.models.Student;

import javaFX.models.Login.Login;
import javaFX.models.Login.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;

	@Override
	public List<Login> findAllStudents() {
		return studentRepository.findAll();
	}

	@Transactional
	public Login save(Login login) {
		return studentRepository.save(login);
	}
}
