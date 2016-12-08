package javaFX.models.Student;

import javaFX.models.Login.Login;
import org.springframework.data.jpa.repository.JpaRepository;

interface StudentRepository extends JpaRepository<Student, Long> {

}
