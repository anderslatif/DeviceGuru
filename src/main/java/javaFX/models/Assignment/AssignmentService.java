package javaFX.models.Assignment;

import javax.transaction.Transactional;
import java.util.List;

public interface AssignmentService {

	List<Assignment> findAllAssignments();

	@Transactional
	Assignment save(Assignment assignment);


}
