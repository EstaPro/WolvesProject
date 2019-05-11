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

import ma.rfidmaroc.patrolmanager.dao.AdministrateurRepository;
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
	
	
	
	@Autowired
	AdministrateurRepository administrateurRepository;
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
//		roles1.add(r2);
		roles2.add(r2);
		
		roles3.add(r3);

		Administrateur admin1 = new Administrateur("admin1", "rfidmaroc1", df.parse("1990-01-01"), "123456", "admin1@rfidmaroc.ma", "0612345678", 
		"admin", "1234", "Mat", true);
		Administrateur admin2 = new Administrateur("admin2", "rfidmaroc2", df.parse("1990-01-01"), "123456", "admin2@rfidmaroc.ma", "0612345678", 
		"admin", "1234", "Mat", true);
		Administrateur admin3 = new Administrateur("admin3", "rfidmaroc3", df.parse("1990-01-01"), "123456", "admin3@rfidmaroc.ma", "0612345678", 
		"admin", "1234", "Mat", true);
		Administrateur admin4 = new Administrateur("admin4", "rfidmaroc4", df.parse("1990-01-01"), "123456", "admin4@rfidmaroc.ma", "0612345678", 
		"admin", "1234", "Mat", true);
		
		admin1.setRoles(roles1);
		administrateurRepository.save(admin1);		
		admin2.setRoles(roles1);
		administrateurRepository.save(admin2);		
		admin3.setRoles(roles1);
		administrateurRepository.save(admin3);		
		admin4.setRoles(roles1);
		administrateurRepository.save(admin4);

		Responsable resp1 = new Responsable("resp1", "resp", df.parse("1994-01-01"), "h23456", "resp1@rfidmaroc.ma", "0612345678",
		"resp", "1234", "MAT123456", true);
		Responsable resp2 = new Responsable("resp2", "resp", df.parse("1994-01-01"), "h23456", "resp2@rfidmaroc.ma", "0612345678",
		"resp2", "1234", "MAT123456", true);
		Responsable resp3 = new Responsable("resp3", "resp", df.parse("1994-01-01"), "h23456", "ayoub@barouch.ma", "0612345678",
		"resp3", "1234", "MAT123456", true);
		
		resp1.setRoles(roles2);
		responsableRepository.save(resp1);		
		resp2.setRoles(roles2);
		responsableRepository.save(resp2);		
		resp3.setRoles(roles2);
		responsableRepository.save(resp3);
		

		Patrouilleur patr1 = new Patrouilleur("patr1", "patr", df.parse("1996-01-01"), "h23456", "0612345678",
		"patr", "1234", true );
		Patrouilleur patr2 = new Patrouilleur("patr2", "patr", df.parse("1996-01-01"), "h23456", "0612345678",
		"patr2", "1234", true );
		Patrouilleur patr3 = new Patrouilleur("patr3", "patr", df.parse("1996-01-01"), "h23456", "0612345678",
		"patr3", "1234", true );
		Patrouilleur patr4 = new Patrouilleur("patr4", "patr", df.parse("1996-01-01"), "h23456", "0612345678",
		"patr4", "1234", true );
		Patrouilleur patr5 = new Patrouilleur("patr5", "patr", df.parse("1996-01-01"), "h23456", "0612345678",
		"patr5", "1234", true );

		patr1.setRoles(roles3);
		patr2.setRoles(roles3);
		patr3.setRoles(roles3);
		patr4.setRoles(roles3);
		patr5.setRoles(roles3);
	

		patrouilleurRepository.save(patr1);
		patrouilleurRepository.save(patr2);
		patrouilleurRepository.save(patr3);
		patrouilleurRepository.save(patr4);
		patrouilleurRepository.save(patr5);
	}

}
