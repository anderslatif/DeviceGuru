package javaFX.models.DeviceHistory;

import javax.transaction.Transactional;
import java.util.List;

public interface DeviceHistoryService {

	List<DeviceHistory> findAll();

	@Transactional
	void deleteDeviceHistoryBySerialnumber(String serialnumber);

}
