package ie.dit.backupapp.services;

import javax.ejb.Local;

@Local
public interface XMLReaderService {
	public String createUserLibraryFromXML(String location, String username, String password);
}
