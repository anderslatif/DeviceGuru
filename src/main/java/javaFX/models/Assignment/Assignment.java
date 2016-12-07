package javaFX.models.Assignment;

import javax.persistence.*;

import javaFX.models.Login.Login;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude={"owner"})
@ToString(exclude={"owner"})
@Entity
@Table(name="assignments")
public class Assignment {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;

	@Column(name="assignment")
	private String assignment;

	@ManyToOne
	@JoinColumn(name="owner")
	private Login owner;



}
