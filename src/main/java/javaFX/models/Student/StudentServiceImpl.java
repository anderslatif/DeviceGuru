package javaFX.models.Student;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class StudentServiceImpl implements StudentService {

	@Autowired
	StudentSearchRepository studentSearchRepository;

	private final StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public List<Student> search(String firstName, String lastName, String schoolClass, String serialNumber, String email) {
		return studentSearchRepository.search(firstName, lastName, schoolClass, serialNumber, email);
	}


	@Transactional
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void delete(Student student) {
		studentRepository.delete(student);
	}
}
