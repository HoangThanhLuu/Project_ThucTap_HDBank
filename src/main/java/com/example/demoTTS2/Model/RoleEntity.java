package com.example.demoTTS2.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;
@Entity
@Table(name = "role", schema = "demo_ql", catalog = "")
public class RoleEntity {
    @Id
    private int uif;
    private Byte addRole;
    private Byte deleteRole;
    private Byte editRole;
    private Byte queryCustomerRole;
    private Byte readSalaryRole;
    private String username;

    public int getUif() {
        return uif;
    }

    public void setUif(int uif) {
        this.uif = uif;
    }

    public Byte getAddRole() {
        return addRole;
    }

    public void setAddRole(Byte addRole) {
        this.addRole = addRole;
    }

    public Byte getDeleteRole() {
        return deleteRole;
    }

    public void setDeleteRole(Byte deleteRole) {
        this.deleteRole = deleteRole;
    }

    public Byte getEditRole() {
        return editRole;
    }

    public void setEditRole(Byte editRole) {
        this.editRole = editRole;
    }

    public Byte getQueryCustomerRole() {
        return queryCustomerRole;
    }

    public void setQueryCustomerRole(Byte queryCustomerRole) {
        this.queryCustomerRole = queryCustomerRole;
    }

    public Byte getReadSalaryRole() {
        return readSalaryRole;
    }

    public void setReadSalaryRole(Byte readSalaryRole) {
        this.readSalaryRole = readSalaryRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return uif == that.uif && Objects.equals(addRole, that.addRole) && Objects.equals(deleteRole, that.deleteRole) && Objects.equals(editRole, that.editRole) && Objects.equals(queryCustomerRole, that.queryCustomerRole) && Objects.equals(readSalaryRole, that.readSalaryRole) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uif, addRole, deleteRole, editRole, queryCustomerRole, readSalaryRole, username);
    }
}
