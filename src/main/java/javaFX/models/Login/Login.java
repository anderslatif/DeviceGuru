package javaFX.models.Login;

import javaFX.models.Assignment.Assignment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="logins")
public class Login {

    @Id
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

//    @OneToMany
    @Column
    private List<Assignment> assignments;



}
