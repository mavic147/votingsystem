package ru.maximenko.votingsystem.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends AbstractNamedEntity {

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotBlank
    @Size(max = 100)
    private String email;

    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 5, max = 100)
    private String password;

    @Column(name = "registered", nullable = false, columnDefinition = "timestamp default now()")
    @NotNull
    private Date registrationDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.JOIN)
    @JoinTable(name = "user_roles",
            joinColumns = {
                    @JoinColumn(name = "id_user", referencedColumnName = "id",
                            nullable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "id_role", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private Set<Role> roles;

    public User(User user) {
        this(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getRegistrationDate(), user.getRoles());
    }

    public User(Integer id, String name, String email, String password, Date registrationDate, Set<Role> roles) {
        super(id, name);
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
        this.roles = roles;
    }

    public User() {}

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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> role) {
        this.roles = CollectionUtils.isEmpty(roles) ? Collections.emptySet() : Set.copyOf(role);
    }
}
