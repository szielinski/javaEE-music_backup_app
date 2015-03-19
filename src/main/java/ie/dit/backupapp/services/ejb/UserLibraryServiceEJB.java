package ie.dit.backupapp.services.ejb;

import ie.dit.backupapp.dao.UserLibraryDAO;
import ie.dit.backupapp.entities.UserLibrary;
import ie.dit.backupapp.services.UserLibraryService;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Local
@Stateless
public class UserLibraryServiceEJB implements UserLibraryService {

	@Inject
	private UserLibraryDAO userLibraryDAO;

	@Override
	public void updateLibrary(UserLibrary userLibrary) {
		userLibraryDAO.updateUserLibrary(userLibrary);
	}

	@Override
	public void addLibrary(UserLibrary userLibrary) {
		userLibraryDAO.addUserLibrary(userLibrary);
	}

	@Override
	public UserLibrary getUserLibrary(String username) {
		return userLibraryDAO.getUserLibrary(username);
	}
}
