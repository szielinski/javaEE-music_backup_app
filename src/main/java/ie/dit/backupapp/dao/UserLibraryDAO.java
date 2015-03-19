package ie.dit.backupapp.dao;

import ie.dit.backupapp.entities.UserLibrary;

public interface UserLibraryDAO {

	public UserLibrary getUserLibrary(String username);

	public void addUserLibrary(UserLibrary userLibrary);

	public void updateUserLibrary(UserLibrary userLibrary);
}
