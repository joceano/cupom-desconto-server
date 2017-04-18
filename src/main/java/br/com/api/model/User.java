package br.com.api.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements UserDetails, Serializable {

    private static final long serialVersionUID = 2353528370345499815L;
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";

    @Id
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String username;

    @JsonIgnore
    @NotNull
    private String password;
    
    @JsonIgnore
    private Date lastPasswordReset;
    
    @NotNull
    private Boolean enabled;

    @NotNull
    private String roles;

    @NotNull
    private Date created;

    public User() {
    	//Método Construtor sem parâmetros
    }

    public User(String name, String username, String password, String roles) {
        this.name = name;
        this.username = username;
        this.password = password;
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

    public Date getCreated() {
        return created;
    }        

    public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;//AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
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

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", enabled=" + enabled +
                ", roles='" + roles + '\'' +
                ", created=" + created +
                '}';
    }	
}
