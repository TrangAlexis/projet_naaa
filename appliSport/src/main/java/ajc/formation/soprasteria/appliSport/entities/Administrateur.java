package ajc.formation.soprasteria.appliSport.entities;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class Administrateur extends Compte{
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
}
