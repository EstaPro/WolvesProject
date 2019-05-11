package ma.rfidmaroc.patrolmanager.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.rfidmaroc.patrolmanager.dao.AdministrateurRepository;
import ma.rfidmaroc.patrolmanager.dao.PatrouilleurRepository;
import ma.rfidmaroc.patrolmanager.dao.ResponsableRepository;
import ma.rfidmaroc.patrolmanager.dao.RoleRepository;
import ma.rfidmaroc.patrolmanager.dao.UtilisateurRepository;
import ma.rfidmaroc.patrolmanager.entities.Administrateur;
import ma.rfidmaroc.patrolmanager.entities.Patrouilleur;
import ma.rfidmaroc.patrolmanager.entities.Responsable;
import ma.rfidmaroc.patrolmanager.entities.Role;
import ma.rfidmaroc.patrolmanager.entities.Utilisateur;
import ma.rfidmaroc.patrolmanager.models.UserForm;

@Service
@Transactional
public class UtilisatateurServices implements IutilisateurServices{
	
	@Autowired
	AdministrateurRepository adminRepository;
	@Autowired
	ResponsableRepository respRepository;
	@Autowired
	PatrouilleurRepository patrRepository;
	@Autowired
	UtilisateurRepository userRepository;
	@Autowired
	RoleRepository roleRepository;

	@Override
	public Utilisateur enregistrerUtilisateur(Utilisateur u) {
		return userRepository.save(u);
	}

	@Override
	public List<Utilisateur> chercherUtilisateurs(String mc, String role) {
		
		List<Utilisateur> list = new ArrayList<Utilisateur>();
		
		if(role.isEmpty())
			list = userRepository.chercherUtilisateurs("%"+mc+"%");
		if(role.equals("admin")) {
			List<Utilisateur> res = userRepository.chercherUtilisateurs("%"+mc+"%");
			
			for (Utilisateur u : res) {
				if(u.getClass().getSimpleName().equals("Administrateur"))
					list.add(u);
			}
		}else if(role.equals("resp")) {
			List<Utilisateur> res = userRepository.chercherUtilisateurs("%"+mc+"%");
			
			for (Utilisateur u : res) {
				if(u.getClass().getSimpleName().equals("Responsable"))
					list.add(u);
			}
		}else if(role.equals("patr")) {
			List<Utilisateur> res = userRepository.chercherUtilisateurs("%"+mc+"%");
			
			for (Utilisateur u : res) {
				if(u.getClass().getSimpleName().equals("Patrouilleur"))
					list.add(u);
			}
		}
		
		return list;
	}
	
	public Utilisateur saveUserFromUserForm(UserForm userForm) {
		Utilisateur user = null;
		
		if(userForm.getRole().equals("admin")) {
			List<Role> lr1 = roleRepository.findByRoleLibelle("ADMIN");
			
			Collection<Role> roles =  new ArrayList<Role>();

			roles.add(lr1.get(0));
			
			user = new Administrateur(userForm.getNom(),
					userForm.getPrenom(), 
					userForm.getDate_naissance(), 
					userForm.getCin(),
					userForm.getEmail(),
					userForm.getTelephone(),
					userForm.getLogin(),
					userForm.getPassword(),
					null,
					true);
			user.setRoles(roles);
			
			userRepository.save(user);
		}else if(userForm.getRole().equals("resp")) {
			List<Role> lr1 = roleRepository.findByRoleLibelle("RESP");
			
			Collection<Role> roles =  new ArrayList<Role>();

			roles.add(lr1.get(0));
			
			user = new Responsable(userForm.getNom(),
					userForm.getPrenom(), 
					userForm.getDate_naissance(), 
					userForm.getCin(),
					userForm.getEmail(),
					userForm.getTelephone(),
					userForm.getLogin(),
					userForm.getPassword(),
					null,
					true);
			user.setRoles(roles);
			
			userRepository.save(user);
		}else if(userForm.getRole().equals("patr")) {
				List<Role> lr1 = roleRepository.findByRoleLibelle("PATR");
				
				Collection<Role> roles =  new ArrayList<Role>();

				roles.add(lr1.get(0));
				
				user = new Administrateur(userForm.getNom(),
						userForm.getPrenom(), 
						userForm.getDate_naissance(), 
						userForm.getCin(),
						userForm.getEmail(),
						userForm.getTelephone(),
						userForm.getLogin(),
						userForm.getPassword(),
						null,
						true);
				user.setRoles(roles);
				
				userRepository.save(user);
			}
		
		return user;
	}
}
