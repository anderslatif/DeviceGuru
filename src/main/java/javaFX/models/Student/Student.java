package javaFX.models.Student;

import javax.persistence.*;

import javaFX.models.Device.Device;
import javaFX.models.DeviceLogin.DeviceLogin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="students")
public class Student {

	@Id
	@Column(name="email")
	private String email;

	@Column(name="firstname")
	private String firstName;

	@Column(name="lastname")
	private String lastName;

	@Column(name="class")
	private String schoolClass;  // class is a reserved keyword in Java

	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private DeviceLogin deviceLogin;

	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="device")
	private Device device;

}
