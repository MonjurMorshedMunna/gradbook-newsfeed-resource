package com.gradbook.gradbooknewsfeedresource.models;

import javax.persistence.*;

@Entity
@Table(name="user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @OneToOne(fetch =  FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="role_id")
    private Long roleId;

    public UserRole(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
