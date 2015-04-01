package ie.dit.backupapp.services;

import ie.dit.backupapp.entities.Track;
import ie.dit.backupapp.entities.UserLibrary;
import java.util.Collection;
import javax.ejb.Local;

@Local
public interface UserLibraryService {

	public void updateLibrary(UserLibrary userLibrary);

	public void addLibrary(UserLibrary userLibrary);

	public UserLibrary getUserLibrary(String username);
	
	public Collection<String> getAllPlaylistNames(String username);

	public Collection <Track> getTracksByPlaylistName(String username, String playlistName);
}
