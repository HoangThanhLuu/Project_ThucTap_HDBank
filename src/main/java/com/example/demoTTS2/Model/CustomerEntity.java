package com.example.demoTTS2.Model;

import lombok.Getter;

import java.sql.Date;
import java.util.Objects;

@Getter
public class CustomerEntity {
    private int cif;
    private Integer empNo;
    private String name;
    private String permanentAddress;
    private String temporaryAddress;
    private Integer birthday;
    private Date birthdayPlace;
    private String gender;
    private Integer salary;

    public void setCif(int cif) {
        this.cif = cif;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public void setTemporaryAddress(String temporaryAddress) {
        this.temporaryAddress = temporaryAddress;
    }

    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }

    public void setBirthdayPlace(Date birthdayPlace) {
        this.birthdayPlace = birthdayPlace;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
