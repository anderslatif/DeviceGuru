package entityModels;

import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface EmployeeRepository extends Repository<Employee, Long> {

    List<Employee> findByLastName(String lastname);

}
