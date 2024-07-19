package com.example.demoTTS2.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;
import java.util.Objects;
@Entity
@Table(name = "customer", schema = "demo_ql", catalog = "")
public class CustomerEntity {
    @Id
    private int cif;
    private Integer empNo;
    private String name;
    private String permanentAddress;
    private String temporaryAddress;
    private Integer birthday;
    private Date birthdayPlace;
    private String gender;
    private Integer salary;

    public int getCif() {
        return cif;
    }

    public void setCif(int cif) {
        this.cif = cif;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getTemporaryAddress() {
        return temporaryAddress;
    }

    public void setTemporaryAddress(String temporaryAddress) {
        this.temporaryAddress = temporaryAddress;
    }

    public Integer getBirthday() {
        return birthday;
    }

    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }

    public Date getBirthdayPlace() {
        return birthdayPlace;
    }

    public void setBirthdayPlace(Date birthdayPlace) {
        this.birthdayPlace = birthdayPlace;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return cif == that.cif && Objects.equals(empNo, that.empNo) && Objects.equals(name, that.name) && Objects.equals(permanentAddress, that.permanentAddress) && Objects.equals(temporaryAddress, that.temporaryAddress) && Objects.equals(birthday, that.birthday) && Objects.equals(birthdayPlace, that.birthdayPlace) && Objects.equals(gender, that.gender) && Objects.equals(salary, that.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cif, empNo, name, permanentAddress, temporaryAddress, birthday, birthdayPlace, gender, salary);
    }
}
