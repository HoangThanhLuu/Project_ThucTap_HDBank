package com.example.demoTTS2.Model;

import lombok.Getter;

import java.util.Objects;

@Getter
public class UserEntity {
    private int uif;
    private String username;
    private String password;
    private String name;
    private String address;
    private Integer phone;

    public void setUif(int uif) {
        this.uif = uif;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return uif == that.uif && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uif, username, password, name, address, phone);
    }
}
