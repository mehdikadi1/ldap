package com.ensate.ldap.dao;


import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
@Table(name="privilege")
public class Privilege {

    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    public long id;
    public String privilege;

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.MERGE)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name="role_id")
    private Role role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Privilege{" +
                "id=" + id +
                ", privilege='" + privilege + '\'' +
                ", role=" + role +
                '}';
    }
}
