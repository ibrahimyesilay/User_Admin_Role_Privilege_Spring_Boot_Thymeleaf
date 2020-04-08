package com.yesilay.stocktrace.model;


import javax.persistence.*;
import java.util.Collection;


@Entity(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="role_id", nullable = false)
    private int roleId;
    @Column(name="role_name", nullable = false, length = 25)
    private String roleName;

    @ManyToMany
    @JoinTable(
            name = "jointable_roles_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "role_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;

    public Roles() {
    }

    public Roles(int roleId) {
        this.roleId = roleId;
    }

    public Roles(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Roles(int roleId, String roleName, Collection<Privilege> privileges) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.privileges = privileges;
    }

    public Roles(String roleName, Collection<Privilege> privileges) {
        this.roleName= roleName;
        this.privileges=privileges;
    }

    public Roles(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", privileges=" + privileges +
                '}';
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Collection<Privilege> privileges) {
        this.privileges = privileges;
    }
}


