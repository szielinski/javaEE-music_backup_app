package ie.dit.backupapp.services.ejb;

import java.util.Collection;
import ie.dit.backupapp.dao.UserLibraryDAO;
import ie.dit.backupapp.entities.Playlist;
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
	}

	@Override
	public Collection <Track> getTracksByPlaylistName(String username, String playlistName) {
		return userLibraryDAO.getTracksByPlaylistName(username, playlistName);
	}

	@Override
	public Collection <Playlist> getAllPlaylists(String username) {
		return userLibraryDAO.getAllPlaylists(username);
	}

	@Override
	public boolean updateTrack(Track track) {
		return userLibraryDAO.updateTrack(track);
	}

	@Override
	public boolean deleteTrack(String username, int trackId) {
		return userLibraryDAO.deleteTrack(username, trackId);
	}

	@Override
	public boolean updatePlaylist(Playlist playlist) {
		return userLibraryDAO.updatePlaylist(playlist);
	}

	@Override
	public boolean deletePlaylist(String username, int playlistId) {
		return userLibraryDAO.deletePlaylist(username, playlistId);
	}

	@Override
	public boolean addTrackToPlaylist(String username, String playlistName, String trackName) {
		return userLibraryDAO.addTrackToPlaylist(username, playlistName, trackName);
	}

	@Override
	public boolean removeTrackFromPlaylist(String username, String playlistName, String trackName) {
		return userLibraryDAO.removeTrackFromPlaylist(username, playlistName, trackName);
	}

	@Override
	public boolean addTrack(String username, Track track) {
		return userLibraryDAO.addTrack(username, track);
	}

	@Override
	public boolean addPlaylist(String username, Playlist playlist) {
		return userLibraryDAO.addPlaylist(username, playlist);
	}
}
