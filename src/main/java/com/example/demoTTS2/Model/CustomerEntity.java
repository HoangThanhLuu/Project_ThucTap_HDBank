package com.example.demoTTS2.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Objects;
@Entity
@Getter
@Setter
@Data
@Table(name = "customer", schema = "demo_ql", catalog = "")
public class CustomerEntity {
    @Id

    private int cif;
    private Integer empno;
    private String name;
    private String permanentaddress;
    private String temporaryaddress;
    private Date birthday;
    private String birthdayplace;
    private String gender;
    private Integer salary;


}
