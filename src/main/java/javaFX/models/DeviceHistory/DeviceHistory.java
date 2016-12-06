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


//	@OneToOne
	@Id
	@Column(name="email")
	private String email;


//	@JoinColumn(name="serialnumber")
	@Column(name="device")
	private String device;

	//	@OneToMany
//	private List<Device> devices;


	@Temporal(TemporalType.DATE)
	@Column(name="startdate")
	private Date startdate;

	@Temporal(TemporalType.DATE)
	@Column(name="enddate")
	private Date enddate;

//	@OneToOne
	@Column(name="class")
	private String schoolClass;




}
