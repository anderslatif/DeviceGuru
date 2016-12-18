package javaFX.models.Login;

import javaFX.models.Student.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface LoginSearchRepository extends Repository<Login, Long> {

    Login findByUsernameAndPassword(String username, String password);


}
