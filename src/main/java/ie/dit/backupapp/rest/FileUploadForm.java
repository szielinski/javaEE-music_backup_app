package ie.dit.backupapp.rest;

import javax.ws.rs.FormParam;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class FileUploadForm {
	private byte [] fileData;
	private String fileName;
	private String username;
	private String password;

	public FileUploadForm() {
	}

	@FormParam("fileName")
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@FormParam("username")
	@PartType("text/plain")
	public void setUsername(String username) {
		this.username = username;
	}

	@FormParam("password")
	@PartType("text/plain")
	public void setPassword(String password) {
		this.password = password;
	}

	@FormParam("selectedFile")
	@PartType("application/octet-stream")
	public void setFileData(byte [] fileData) {
		this.fileData = fileData;
	}

	public String getFileName() {
		return fileName;
	}
	
	public String getUsername(){
		return username;
	}

	public String getPassword(){
		return password;
	}

	public byte [] getFileData() {
		return fileData;
	}
}
