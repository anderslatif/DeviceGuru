package javaFX.models.Assignment;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class AssignmentServiceImpl implements AssignmentService {

	private final AssignmentRepository assignmentRepository;

	public List<Assignment> findAllAssignments() {
		return assignmentRepository.findAll();
	}

	@Transactional
	public Assignment save(Assignment assignment) {
		return assignmentRepository.save(assignment);
	}
}
