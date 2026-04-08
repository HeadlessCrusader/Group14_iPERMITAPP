package edu.mizzou.Group14_iPERMITAPP.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class EnvironmentalPermit {

    @Id
    private String permitID;

    private String permitName;
    private Double permitFee;
    private String description;
}