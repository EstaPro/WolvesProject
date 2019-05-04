package ma.rfidmaroc.patrolmanager;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import ma.rfidmaroc.patrolmanager.dao.AdministrateurRepository;
import ma.rfidmaroc.patrolmanager.dao.PatrouilleurRepository;
import ma.rfidmaroc.patrolmanager.dao.ResponsableRepository;
import ma.rfidmaroc.patrolmanager.dao.RoleRepository;
import ma.rfidmaroc.patrolmanager.entities.Administrateur;
import ma.rfidmaroc.patrolmanager.entities.Patrouilleur;
import ma.rfidmaroc.patrolmanager.entities.Responsable;
import ma.rfidmaroc.patrolmanager.entities.Role;

@SpringBootApplication
public class NfcPatrolManagerApplication implements CommandLineRunner {
	
//	@Autowired
//	AdministrateurRepository adminRepository;
	@Autowired
	ResponsableRepository responsableRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PatrouilleurRepository patrouilleurRepository;
	
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) throws ParseException {
//		ConfigurableApplicationContext ctx = SpringApplication.run(NfcPatrolManagerApplication.class, args);
//		UtilisateurRepository utilisateurRepository = ctx.getBean(UtilisateurRepository.class);
		
		SpringApplication.run(NfcPatrolManagerApplication.class, args);
	
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Role r1 = roleRepository.save( new Role("ADMIN"));
		Role r2 = roleRepository.save(new Role("RESP"));
		Role r3 = roleRepository.save(new Role("PATR"));
		
		Collection<Role> roles1 =  new ArrayList<Role>();
		Collection<Role> roles2 =  new ArrayList<Role>();
		Collection<Role> roles3 =  new ArrayList<Role>();
		
		roles1.add(r1);
		roles1.add(r2);
		roles2.add(r2);
		roles3.add(r3);
		
//		Administrateur admin = new Administrateur("Barouch", "Ayoub", 
//				df.parse("1997-01-01"),
//				"h23456",
//				"0612345678",
//				"ayoub@barouch.ma",
//				"resp",
//				"1234",
//				"MAT123456",
//				true
//				);
//		
//		admin.setRoles(roles1);
//		adminRepository.save(admin);
		
		Responsable r = new Responsable("Barouch", "Ayoub", 
				df.parse("1997-01-01"),
				"h23456",
				"0612345678",
				"ayoub@barouch.ma",
				"resp",
				"1234",
				"MAT123456",
				true
				);
		
		r.setRoles(roles2);
		responsableRepository.save(r);
		
		
		Patrouilleur p = new Patrouilleur("Barouch", "Ayoub", 
				df.parse("1997-01-01"),
				"h23456",
				"0612345678",
				"resp",
				"1234",
				true
				);
	
		
		patrouilleurRepository.save(p);
		
		
	}

}
