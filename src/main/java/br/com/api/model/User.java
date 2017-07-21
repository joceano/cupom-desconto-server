package br.com.api.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String username;
        
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
    
    private String telefone;
    
    private String endereco;
    
    private Long numero;
    
    private String bairro;
    
    private String cep;	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cidade", referencedColumnName = "id")
    private Cidade cidade;

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

    public void setCreated(Date created) {
		this.created = created;
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
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
		this.password = password;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
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
