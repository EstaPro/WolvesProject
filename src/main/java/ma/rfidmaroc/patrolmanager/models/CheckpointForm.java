package ma.rfidmaroc.patrolmanager.models;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class CheckpointForm {

	@NotEmpty
	private String geo_location;
	

	public String getGeo_location() {
		return geo_location;
	}

	public void setGeo_location(String geo_location) {
		this.geo_location = geo_location;
	}

}
