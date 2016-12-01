package javaFX.models.Student;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="students")
public class Student {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name="firstname")
	private String firstName;

	@Column(name="lastname")
	private String lastName;


	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
