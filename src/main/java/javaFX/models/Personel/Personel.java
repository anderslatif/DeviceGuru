package javaFX.models.Personel;

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
@Table(name="personel")
public class Personel {


//	@OneToOne
	@Id
	@Column(name="email")
	private String email;

	@Column(name="firstname")
	private String firstName;

	@Column(name="lastname")
	private String lastName;

	@Column(name="class")
	private String schoolClass;

	@OneToMany
	private List<Device> devices;



}
