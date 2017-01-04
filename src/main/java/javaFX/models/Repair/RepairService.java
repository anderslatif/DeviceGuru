package javaFX.models.Repair;

import javaFX.models.Student.Student;

import javax.transaction.Transactional;
import java.util.List;

public interface RepairService {

    List<Repair> findAllRepairs();

	@Transactional
	void deleteRepairBySerialnumber(String serialnumber);

}
