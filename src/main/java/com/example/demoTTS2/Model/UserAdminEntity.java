package com.example.demoTTS2.Model;

import lombok.Getter;

import java.util.Objects;

@Getter
public class UserAdminEntity {
    private int uaif;
    private String username;
    private String password;

    public void setUaif(int uaif) {
        this.uaif = uaif;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAdminEntity that = (UserAdminEntity) o;
        return uaif == that.uaif && Objects.equals(username, that.username) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uaif, username, password);
    }
}
