package javaFX.models.DeviceHistory;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class DeviceHistoryServiceImpl implements DeviceHistoryService {

	private final DeviceHistoryRepository deviceHistoryRepository;

	@Override
	public List<DeviceHistory> findAll() {
		return deviceHistoryRepository.findAll();
	}

	@Override
	public void deleteDeviceHistoryBySerialnumber(String serialnumber) {
		List<DeviceHistory> matchingDeviceHistories = findAll().stream().filter( devhis -> devhis.getSerialnumber().contentEquals(serialnumber)).collect(Collectors.toList());
		for (DeviceHistory deviceHistory : matchingDeviceHistories) {
			deviceHistoryRepository.delete(deviceHistory);
		}
	}


}
