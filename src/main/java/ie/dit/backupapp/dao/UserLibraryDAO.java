package ie.dit.backupapp.dao;

import ie.dit.backupapp.entities.Track;
import ie.dit.backupapp.entities.UserLibrary;
import java.util.Collection;

public interface UserLibraryDAO {

	public UserLibrary getUserLibrary(String username);

	public void addUserLibrary(UserLibrary userLibrary);
	
	public void updateUserLibrary(UserLibrary userLibrary);
	
	public Collection<String> getAllPlaylistNames(String username);

	public Collection <Track> getTracksByPlaylistName(String username, String playlistName);
}
