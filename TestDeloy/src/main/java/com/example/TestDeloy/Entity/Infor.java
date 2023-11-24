package com.example.TestDeloy.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Infors")
@Data
public class Infor implements Serializable {
    @Id
    private String fullname;
    @Temporal(TemporalType.DATE)
    @Column(name = "Birthday")
    private Date birthDay;
    private String gender;
}
