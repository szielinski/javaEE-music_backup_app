package ie.dit.backupapp.services;

import ie.dit.backupapp.entities.Playlist;
import ie.dit.backupapp.entities.Track;
import ie.dit.backupapp.entities.UserLibrary;
import java.util.Collection;
import javax.ejb.Local;

@Local
public interface UserLibraryService {

	public void updateLibrary(UserLibrary userLibrary);

	public void addLibrary(UserLibrary userLibrary);

	public UserLibrary getUserLibrary(String username);
	
	public Collection <Playlist> getAllPlaylists(String username);
	
	public Collection<String> getAllPlaylistNames(String username);

	public Collection <Track> getTracksByPlaylistName(String username, String playlistName);

	public boolean updateTrack(Track track);

	public boolean deleteTrack(String username, int trackId);

	public boolean updatePlaylist(Playlist playlist);

	public boolean deletePlaylist(String username, int playlistId);

	public boolean addTrackToPlaylist(String username, String playlistName, String trackName);

	public boolean removeTrackFromPlaylist(String username, String playlistName, String trackName);

	public boolean addTrack(String username, Track track);

	public boolean addPlaylist(String username, Playlist playlist);
}
