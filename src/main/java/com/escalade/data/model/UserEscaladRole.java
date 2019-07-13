package com.escalade.data.model;


import javax.persistence.*;

@Entity
@Table(name = "user_escalad_role")
public class UserEscaladRole {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "role_user_escalad_id")
    private int roleUserEscaladId;

    @Column(name = "role_name")
    private String roleName;

    public UserEscaladRole() {
    }

    public UserEscaladRole(String roleName) {
        this.roleName = roleName;
    }

    public int getRoleUserEscaladId() {
        return roleUserEscaladId;
    }

    public void setRoleUserEscaladId(int roleUserEscaladId) {
        this.roleUserEscaladId = roleUserEscaladId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
