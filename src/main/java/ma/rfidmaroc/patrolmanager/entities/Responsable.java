package ma.rfidmaroc.patrolmanager.entities;


@SuppressWarnings("serial")
public class Responsable extends Utilisateur {

	private int matricule_resp;

	public Responsable(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public int getMatricule_resp() {
		return matricule_resp;
	}

	public void setMatricule_resp(int matricule_resp) {
		this.matricule_resp = matricule_resp;
	}

}