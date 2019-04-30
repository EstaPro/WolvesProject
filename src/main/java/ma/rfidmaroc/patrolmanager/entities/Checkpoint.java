package ma.rfidmaroc.patrolmanager.entities;

public class Checkpoint {

	private Long id_checkpoint;
	private String geo_location;
	public Tag m_Tag;

	public Checkpoint(){

	}

	public void finalize() throws Throwable {

	}

	public Long getId_checkpoint() {
		return id_checkpoint;
	}

	public void setId_checkpoint(Long id_checkpoint) {
		this.id_checkpoint = id_checkpoint;
	}

	public String getGeo_location() {
		return geo_location;
	}

	public void setGeo_location(String geo_location) {
		this.geo_location = geo_location;
	}

}