package ajc.formation.soprasteria.appliSport.entities;

import ajc.formation.soprasteria.appliSport.entities.jsonviews.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;


@Entity
@Table(name = "comptes")
public class Compte implements UserDetails {

	@Id
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
		return Objects.equals(login, compte.login);
	}

	@Override
	public int hashCode() {
		return Objects.hash(login);
	}

}


