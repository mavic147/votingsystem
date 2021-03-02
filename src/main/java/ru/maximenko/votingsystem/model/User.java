package ru.maximenko.votingsystem.model;

import java.util.Date;
import java.util.Set;

public class User extends AbstractBaseEntity {

    private String email;

    private String password;

    private Date registrationDate;

    private Set<Role> role;

    public User(Integer id, String email, String password, Date registrationDate, Set<Role> role) {
        super(id);
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }
}
