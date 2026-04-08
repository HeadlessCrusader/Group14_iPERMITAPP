package edu.mizzou.Group14_iPERMITAPP.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Decision {

    @Id
    private String id;

    private Date dateOfDecision;
    private String finalDecision; // approve / reject
    private String description;

    @ManyToOne
    @JoinColumn(name = "eo_id")
    private EO eo;

    @OneToOne
    @JoinColumn(name = "permit_request_id")
    private PermitRequest permitRequest;
}