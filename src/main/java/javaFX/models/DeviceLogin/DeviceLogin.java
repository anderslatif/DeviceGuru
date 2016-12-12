package javaFX.models.DeviceLogin;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="devicelogins")
public class DeviceLogin {

	@Id
	@Column(name="email")
	private String email;

	@Column(name="password")
	private String password;


}
