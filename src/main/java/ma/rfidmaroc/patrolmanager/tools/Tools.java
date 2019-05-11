package ma.rfidmaroc.patrolmanager.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class Tools {
	
	public static String EncoderMD5(String plainTxt) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		md.update(plainTxt.getBytes());
		return DatatypeConverter.printHexBinary(md.digest()).toLowerCase();
	}
}
