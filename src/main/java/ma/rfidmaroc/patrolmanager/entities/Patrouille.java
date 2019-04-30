package ma.rfidmaroc.patrolmanager.entities;


public class Patrouille {

	private Long id_patrouille;
	private Float dureeMoyenne_min;
	private Float margeErr_min;

	public Patrouille(){

	}

	public void finalize() throws Throwable {

	}

	public Long getId_patrouille() {
		return id_patrouille;
	}

	public void setId_patrouille(Long id_patrouille) {
		this.id_patrouille = id_patrouille;
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

}