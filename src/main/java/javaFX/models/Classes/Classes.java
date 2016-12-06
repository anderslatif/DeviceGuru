package javaFX.models.Classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="classes")
public class Classes {

//    @OneToOne
//    @JoinColumn(name="class")
    @Id
    private String schoolClass;  // class is a reserved keyword in Java



}
