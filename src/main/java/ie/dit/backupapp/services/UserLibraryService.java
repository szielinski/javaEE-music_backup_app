package ie.dit.backupapp.services;

import ie.dit.backupapp.entities.UserLibrary;
import javax.ejb.Local;

@Local
public interface UserLibraryService {

	public void updateLibrary(UserLibrary userLibrary);

	public void addLibrary(UserLibrary userLibrary);

	public UserLibrary getUserLibrary(String username);
}
