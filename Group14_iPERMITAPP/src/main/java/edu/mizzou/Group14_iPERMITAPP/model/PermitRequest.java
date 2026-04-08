package edu.mizzou.Group14_iPERMITAPP.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class PermitRequest {

    @Id
    private String requestNo;

    private Date dateOfRequest;
    private String activityDescription;
    private Date activityStartDate;
    private Date activityDuration;
    private Double permitFee;

    @ManyToOne
    @JoinColumn(name = "re_id")
    private RE re;

    @ManyToOne
    @JoinColumn(name = "permit_id")
    private EnvironmentalPermit environmentalPermit;
}