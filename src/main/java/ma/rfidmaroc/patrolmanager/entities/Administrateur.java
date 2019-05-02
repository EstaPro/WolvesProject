package ma.rfidmaroc.patrolmanager.entities;

@SuppressWarnings("serial")
public class Administrateur extends Responsable {

	private Administrateur m_Administrateur;

	public Administrateur(){

	}

	public Administrateur getM_Administrateur() {
		return m_Administrateur;
	}

	public void setM_Administrateur(Administrateur m_Administrateur) {
		this.m_Administrateur = m_Administrateur;
	}
}