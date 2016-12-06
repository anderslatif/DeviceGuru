package javaFX.models.Device;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="devices")
public class Device {

    @Id
    @Column(name="serialnumber")
    private String serialnumber;

    @Column(name="type")
    private String type;


}
