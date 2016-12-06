package javaFX.models.DeviceLogin;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="devicelogin")
public class DeviceLogin {

	@Id
	//@OneToOne
	@Column(name="email")
	private String email;

	@Column(name="firstname")
	private String firstName;


}
