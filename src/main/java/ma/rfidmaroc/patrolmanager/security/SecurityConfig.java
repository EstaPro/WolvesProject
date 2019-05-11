package ma.rfidmaroc.patrolmanager.security;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
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
		.roles("ADMIN");
		
		auth.inMemoryAuthentication()
		.withUser("resp")
		.password("1234")
		.roles("RESP");
		
//      l authentification avec Accès à la BD
//		auth.jdbcAuthentication()
//		.dataSource(dataSource)
//		.usersByUsernameQuery("select login as principal, password as credentials, active from utilisateur where login=?")
//		.authoritiesByUsernameQuery("SELECT login as principal, role_libelle as role "
//				+ "FROM utilisateur as u, roles as r, user_role as ur "
//				+ "WHERE ur.users_id_user = u.id_user AND ur.roles_id_role = r.id_role AND login=?")
//		.passwordEncoder(new Md5PasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/* Indiquer à SpringSecurity que l’authentification passe par un formulaire
		d’authentification avec username et password */
		http.formLogin().loginPage("/login");
		
		
		/* Toutes les requites HTTP avec URL /admin/* nécessitent d’être authentifié 
		avec un Utilisateur ayant le role ADMIN*/
		http.authorizeRequests().antMatchers("/admin/*").hasRole("ADMIN");
		
		
		//http.authorizeRequests().antMatchers("/pageAccueil").hasAnyRole("ADMIN", "RESP");
		/* Toutes les requites HTTP avec URL /resp/* nécessitent d’être authentifié avec 
		un utilisateur ayant le role ADMIN ou RESP */
		http.authorizeRequests().antMatchers("/resp/*").hasAnyRole("RESP");
		
		

		/* Si un Utilisateur tente d’accéder à une resource dont il n’a pas le droit, 
		il sera redirigué vers la page associée à l’action /403 */
		http.exceptionHandling().accessDeniedPage("/403");
	}

}
