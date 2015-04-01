package ie.dit.backupapp.services.ejb;

import java.util.Collection;
import ie.dit.backupapp.dao.UserLibraryDAO;
import ie.dit.backupapp.entities.Track;
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

	@Override
	public Collection <String> getAllPlaylistNames(String username) {
		return userLibraryDAO.getAllPlaylistNames(username);
		// userLibraryDAO.getAllPlaylistNames();
	}

	@Override
	public Collection <Track> getTracksByPlaylistName(String username, String playlistName) {
		return userLibraryDAO.getTracksByPlaylistName(username, playlistName);
	}
}
