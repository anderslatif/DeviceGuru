package javaFX.models.DeviceHistory;

import javaFX.models.Device.Device;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="devicehistory")
public class DeviceHistory {

	@Id
	@Column(name="email")
	private String email;

	@Column(name="serialnumber")
	private String serialnumber;

	@Temporal(TemporalType.DATE)
	@Column(name="startdate")
	private Date startdate;

	@Temporal(TemporalType.DATE)
	@Column(name="enddate")
	private Date enddate;



}
