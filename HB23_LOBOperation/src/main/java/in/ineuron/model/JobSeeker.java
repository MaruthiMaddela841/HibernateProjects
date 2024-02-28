package in.ineuron.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class JobSeeker implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer jsId;
	private String jsName;
	private String jsAddress;
	@Lob
	private byte[] photo;
	@Lob
	private char[] resume;
	@Override
	public String toString() {
		return "JobSeeker [jsId=" + jsId + ", jsName=" + jsName + ", jsAddress=" + jsAddress;
	}
	public Integer getJsId() {
		return jsId;
	}
	public void setJsId(Integer jsId) {
		this.jsId = jsId;
	}
	public String getJsName() {
		return jsName;
	}
	public void setJsName(String jsName) {
		this.jsName = jsName;
	}
	public String getJsAddress() {
		return jsAddress;
	}
	public void setJsAddress(String jsAddress) {
		this.jsAddress = jsAddress;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public char[] getResume() {
		return resume;
	}
	public void setResume(char[] resume) {
		this.resume = resume;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
