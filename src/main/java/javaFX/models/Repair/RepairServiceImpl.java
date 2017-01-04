package javaFX.models.Repair;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class RepairServiceImpl implements RepairService {

	private final RepairRepository repairRepository;

	@Override
	public List<Repair> findAllRepairs() {
		return repairRepository.findAll();
	}

	@Override
	public void deleteRepairBySerialnumber(String serialnumber) {
		List<Repair> matchingRepairs = findAllRepairs().stream().filter( repair -> repair.getSerialnumber().contentEquals(serialnumber)).collect(Collectors.toList());
		for (Repair repair : matchingRepairs) {
			repairRepository.delete(repair);
		}
	}
}
