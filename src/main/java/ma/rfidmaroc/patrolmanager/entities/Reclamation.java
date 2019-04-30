package ma.rfidmaroc.patrolmanager.entities;


public class Reclamation extends Activite {

	private int id_rec;
	private String description;
	private String imgPath;

	public Reclamation(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public int getId_rec() {
		return id_rec;
	}

	public void setId_rec(int id_rec) {
		this.id_rec = id_rec;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	

}