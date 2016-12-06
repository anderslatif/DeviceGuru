package javaFX.models.Repair;

import javaFX.models.Device.Device;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="repairs")
public class Repair {


	@Id
	@Column(name="ticketid")
	private int ticketID;

	@Column(name="status")
	private String status;

//	@OneToOne
//	@JoinColumn(name="email")
	@Column(name="owner")
	private String owner;

//	@OneToOne
//	@JoinColumn(name="serialnumber")
	@Column(name="device")
	private String device;


}
