package ajc.formation.soprasteria.appliSport.entities;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ajc.formation.soprasteria.appliSport.entities.jsonviews.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "comptes")
public class Compte implements UserDetails {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "compte_id")
	@JsonView(JsonViews.Simple.class)
	private Long id;
	@Column(name = "login", nullable = false, unique = true)
	@JsonView(JsonViews.Simple.class)
	private String login;
	@Column(name = "password", length = 255, nullable = false)
	private String password;
	@Column(name = "role", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	@JsonView(JsonViews.Simple.class)
	private Role role;
	@OneToOne(mappedBy = "compte")
	private Client client;
	@OneToOne(mappedBy = "compte")
	private Coach coach;
	
	
	
	public Compte() {
		
	}
	
	
	
	public Compte(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public Compte(String login, String password, Role role) {
		super();
		this.login = login;
		this.password = password;
		this.role = role;
	}




	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}




	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority(role.toString()));
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return login;
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
		return true;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Compte compte = (Compte) o;
		return Objects.equals(id, compte.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
