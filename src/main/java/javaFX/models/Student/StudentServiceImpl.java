package javaFX.models.Student;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;

	public List<Student> findAllStudents() {
		return studentRepository.findAll();
	}

	@Transactional
	public Student save(Student student) {
		return studentRepository.save(student);
	}
}
