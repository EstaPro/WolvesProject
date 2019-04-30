package ma.rfidmaroc.patrolmanager.entities;


public class Pointage extends Activite {

	public Checkpoint m_Checkpoint;

	public Checkpoint getM_Checkpoint() {
		return m_Checkpoint;
	}

	public void setM_Checkpoint(Checkpoint m_Checkpoint) {
		this.m_Checkpoint = m_Checkpoint;
	}

	public Pointage(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
}