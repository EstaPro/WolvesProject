package ma.rfidmaroc.patrolmanager.security;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("admin")
		.password("1234")
		.roles("RESP", "ADMIN");
		
		auth.inMemoryAuthentication()
		.withUser("resp")
		.password("1234")
		.roles("RESP");
		
//      l authentification avec Accès à la BD
//		auth.jdbcAuthentication()
//		.dataSource(dataSource)
//		.usersByUsernameQuery("select login as principal, password as credentials, active from utilisateur where login=?")
//		.authoritiesByUsernameQuery("select login as principal, role from users_roles");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login");
		
		http.authorizeRequests().antMatchers("/home").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/home").hasRole("RESP");
	}

}
