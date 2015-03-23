package ie.dit.backupapp.services;

import javax.ejb.Local;

@Local
public interface XMLReaderService {
	public void createUserLibraryFromXML(String location, String username, String password);
}
