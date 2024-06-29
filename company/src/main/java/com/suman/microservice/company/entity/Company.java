package com.suman.microservice.company.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long companyId;
    private String companyName;
    private String companyDescription;

}
