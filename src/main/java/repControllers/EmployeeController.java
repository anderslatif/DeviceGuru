package repControllers;

import entityModels.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void returnAmount() {

        employeeRepository.findByLastName("Bauer");
    }

}
