package javaFX.models.Assignment;

import javax.persistence.*;

import javaFX.models.Login.Login;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="assignments")
public class Assignment {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;

	@Column(name="assignment")
	private String assignment;

	//@ManyToOne
//	@JoinColumn(name="owner")
	@Column
	private Login login;


}
