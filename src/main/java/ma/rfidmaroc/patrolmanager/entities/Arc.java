package ma.rfidmaroc.patrolmanager.entities;


public class Arc {

	private Long id_arc;
	private Float dureeMoyenne_min;
	private Float margeErr_min;
	private Checkpoint m_Checkpoints[];
	
	public Arc(){

	}

	public void finalize() throws Throwable {

	}

	public Long getId_arc() {
		return id_arc;
	}

	public void setId_arc(Long id_arc) {
		this.id_arc = id_arc;
	}

	public Float getDureeMoyenne_min() {
		return dureeMoyenne_min;
	}

	public void setDureeMoyenne_min(Float dureeMoyenne_min) {
		this.dureeMoyenne_min = dureeMoyenne_min;
	}

	public Float getMargeErr_min() {
		return margeErr_min;
	}

	public void setMargeErr_min(Float margeErr_min) {
		this.margeErr_min = margeErr_min;
	}

	public Checkpoint[] getM_Checkpoints() {
		return m_Checkpoints;
	}

	public void setM_Checkpoints(Checkpoint m_Checkpoints[]) {
		this.m_Checkpoints = m_Checkpoints;
	}

}