package br.com.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User implements UserDetails, Serializable {

    private static final long serialVersionUID = 2353528370345499815L;

    @Id
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String username;

    @JsonIgnore
    @NotNull
    private String password;

    @NotNull
    @Email
    private String email;

    @JsonIgnore
    private Date lastPasswordReset;

    @NotNull
    private Boolean enabled;

    @NotNull
    private String roles;

    @NotNull
    private Date created;

    public User() { // Porqueeeee
    }

    public User(String name, String username, String password, String email, String roles) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles = roles;
        this.enabled = true;
        this.created = new Date();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void encryptPassword() {
        this.password = new BCryptPasswordEncoder().encode(this.password);
    }

    public String getEmail() {
        return email;
    }

    public Date getCreated() {
        return created;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Date getLastPasswordReset() {
        return lastPasswordReset;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                ", roles='" + roles + '\'' +
                ", created=" + created +
                '}';
    }
}
