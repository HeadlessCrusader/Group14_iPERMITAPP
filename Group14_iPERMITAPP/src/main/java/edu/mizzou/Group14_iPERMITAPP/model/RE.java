package edu.mizzou.Group14_iPERMITAPP.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class RE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contactPersonName;
    private String password;
    private Date createdDate;
    private String email;
    private String organizationName;
    private String organizationAddress;

    @OneToMany(mappedBy = "re", cascade = CascadeType.ALL)
    private List<RESite> sites;
}