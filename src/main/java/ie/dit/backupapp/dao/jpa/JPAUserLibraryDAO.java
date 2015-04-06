package ie.dit.backupapp.dao.jpa;

import ie.dit.backupapp.dao.UserLibraryDAO;
import ie.dit.backupapp.entities.IdClasss;
import ie.dit.backupapp.entities.Playlist;
import ie.dit.backupapp.entities.Track;
import ie.dit.backupapp.entities.UserLibrary;
import java.util.Collection;
import java.util.Iterator;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

public class JPAUserLibraryDAO implements UserLibraryDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public UserLibrary getUserLibrary(String username) {
		UserLibrary userLibrary = null;
		try{
			userLibrary = (UserLibrary) em.createNamedQuery("getLibraryByUsername").setParameter("username", username).getSingleResult();
		} catch (NoResultException e){}
		return userLibrary;
	}

	@Override
	public void updateUserLibrary(UserLibrary userLibrary) {
		em.merge(userLibrary);
	}

	@Override
	public void addUserLibrary(UserLibrary userLibrary) {
		em.persist(userLibrary);
	}

	@Override
	public Collection <String> getAllPlaylistNames(String username) {
		return em.createNamedQuery("getAllPlaylistNames").setParameter("username", username).getResultList();
	}

	@Override
	public Collection <Playlist> getAllPlaylists(String username) {
		UserLibrary ul = (UserLibrary) em.createNamedQuery("getLibraryByUsername").setParameter("username", username).getSingleResult();
		return ul.getPlaylists();
	}

	@Override
	public Collection <Track> getTracksByPlaylistName(String username, String playlistName) {
		Playlist p = (Playlist) em.createNamedQuery("getTracksByPlaylistName").setParameter("username", username).setParameter("playlistName", playlistName)
				.getSingleResult();
		return p.getTracks();
	}

	@Override
	public boolean updateTrack(Track track) {
		Track old = em.find(Track.class, new IdClasss(track.getTrackId(), track.getLibraryId()));
		if (old == null)
			return false;
		old.setName(track.getName());
		old.setAlbum(track.getAlbum());
		old.setArtist(track.getArtist());
		old.setTrackNumber(track.getTrackNumber());
		old.setYear(track.getYear());
		old.setGenre(track.getGenre());
		em.merge(old);
		return true;
	}

	@Override
	public boolean deleteTrack(String username, int trackId) {
		UserLibrary present = getUserLibrary(username);
		Collection <Playlist> playlists = present.getPlaylists();
		Collection <Track> tracks = present.getTracks();

		for (Playlist p : playlists) {
			p.removeTrack(trackId);
		}
		em.merge(present);

		for (Iterator <Track> iterator = tracks.iterator(); iterator.hasNext();) {
			Track t = iterator.next();
			if (t.getTrackId() == trackId) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updatePlaylist(Playlist playlist) {
		Playlist old = em.find(Playlist.class, playlist.getPlaylistId());
		if (old == null)
			return false;
		old.setName(playlist.getName());
		em.merge(old);
		return true;
	}

	@Override
	public boolean deletePlaylist(String username, int playlistId) {
		UserLibrary present = getUserLibrary(username);
		Collection <Playlist> playlists = present.getPlaylists();

		for (Iterator <Playlist> iterator = playlists.iterator(); iterator.hasNext();) {
			Playlist p = iterator.next();
			if (p.getPlaylistId() == playlistId) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean addTrackToPlaylist(String username, String playlistName, String trackName) {
		UserLibrary present = getUserLibrary(username);
		Collection <Playlist> playlists = present.getPlaylists();
		Collection <Track> tracks = present.getTracks();

		for (Track t : tracks) {
			if (t.getName().equals(trackName)) {
				for (Playlist p : playlists) {
					if (p.getName().equals(playlistName)) {
						p.addTrack(t);
						return true;
					}
				}
			}
		}

		return false;
	}

	@Override
	public boolean removeTrackFromPlaylist(String username, String playlistName, String trackName) {
		UserLibrary present = getUserLibrary(username);
		Collection <Playlist> playlists = present.getPlaylists();
		for (Playlist p : playlists) {
			if (p.getName().equals(playlistName)) {
				for (Track t : p.getTracks()) {
					if (t.getName().equals(trackName)) {
						p.removeTrack(t.getTrackId());
						return true;
					}
				}
			}
		}

		return false;
	}

	@Override
	public boolean addTrack(String username, Track track) {
		UserLibrary present = getUserLibrary(username);
		int currentHighestId = (int) em.createNamedQuery("getHighestTrackId").setParameter("libraryId", present.getLibraryPersistentId()).getSingleResult();
		track.setTrackId(currentHighestId + 1);
		track.setUserLibrary(present);
		track.setLibraryId(present.getLibraryPersistentId());
		present.addTrack(track);
		System.out.println("here");
		em.merge(present);
		return true;
	}

	@Override
	public boolean addPlaylist(String username, Playlist playlist) {
		UserLibrary present = getUserLibrary(username);
		playlist.setUserLibrary(present);
		present.addPlaylist(playlist);
		em.merge(present);
		return true;
	}

	@Override
	public UserLibrary getUserLibraryByPersistentID(String persistentID) {
		UserLibrary userLibrary = null;
		try{
			userLibrary = (UserLibrary) em.createNamedQuery("getLibraryByPersistentID").setParameter("persistentID", persistentID).getSingleResult();
		} catch (NoResultException e){}
		return userLibrary;
	}
}
