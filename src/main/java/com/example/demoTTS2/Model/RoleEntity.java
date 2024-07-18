package com.example.demoTTS2.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.util.Objects;
@Getter
@Entity
@Table(name = "role", schema = "demo_ql", catalog = "")
public class RoleEntity {
    private int uif;
    private Byte addRole;
    private Byte deleteRole;
    private Byte editRole;
    private Byte queryCustomerRole;
    private Byte readSalaryRole;
    @Id
    private Long id;

    public void setUif(int uif) {
        this.uif = uif;
    }

    public void setAddRole(Byte addRole) {
        this.addRole = addRole;
    }

    public void setDeleteRole(Byte deleteRole) {
        this.deleteRole = deleteRole;
    }

    public void setEditRole(Byte editRole) {
        this.editRole = editRole;
    }

    public void setQueryCustomerRole(Byte queryCustomerRole) {
        this.queryCustomerRole = queryCustomerRole;
    }

    public void setReadSalaryRole(Byte readSalaryRole) {
        this.readSalaryRole = readSalaryRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return uif == that.uif && Objects.equals(addRole, that.addRole) && Objects.equals(deleteRole, that.deleteRole) && Objects.equals(editRole, that.editRole) && Objects.equals(queryCustomerRole, that.queryCustomerRole) && Objects.equals(readSalaryRole, that.readSalaryRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uif, addRole, deleteRole, editRole, queryCustomerRole, readSalaryRole);
    }



}
