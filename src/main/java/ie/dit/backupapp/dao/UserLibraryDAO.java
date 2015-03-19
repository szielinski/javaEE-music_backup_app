package ie.dit.backupapp.dao;

import ie.dit.backupapp.entities.UserLibrary;

public interface UserLibraryDAO {

	public UserLibrary getUserLibrary(String username);

	public boolean addUserLibrary(UserLibrary userLibrary);

	public boolean updateUserLibrary(UserLibrary userLibrary);
}
