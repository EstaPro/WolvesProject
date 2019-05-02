package ma.rfidmaroc.patrolmanager;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.catalina.core.ApplicationContext;
import org.apache.tomcat.util.descriptor.web.ContextEnvironment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ma.rfidmaroc.patrolmanager.dao.UtilisateurRepository;
import ma.rfidmaroc.patrolmanager.entities.Utilisateur;

@SpringBootApplication
public class NfcPatrolManagerApplication {

	public static void main(String[] args) throws ParseException {
		ConfigurableApplicationContext ctx = SpringApplication.run(NfcPatrolManagerApplication.class, args);
		
		UtilisateurRepository utilisateurRepository = ctx.getBean(UtilisateurRepository.class);
		
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		//utilisateurRepository.save(new Utilisateur("ayou",df.parse("1997-01-01"), "h234", "email", "00000000000", "admin", "1234", true));
		
	}

}
