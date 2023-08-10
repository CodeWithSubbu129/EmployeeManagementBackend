package employeemanagement.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private Date dateOfBirth;
    @ElementCollection
    private List<String> vocals;
    @ElementCollection
    private List<String> instruments;
    private String paymentMode;
    private Date dateOfJoining;
    private String address;
    private Long mobileNr;
}
