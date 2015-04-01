package ie.dit.backupapp.dao.jpa;

import ie.dit.backupapp.dao.UserLibraryDAO;
import ie.dit.backupapp.entities.Track;
import ie.dit.backupapp.entities.UserLibrary;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JPAUserLibraryDAO implements UserLibraryDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public UserLibrary getUserLibrary(String username) {
		return (UserLibrary) em.createNamedQuery("getLibraryByUsername").setParameter("username", username).getSingleResult();
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
		return em.createNamedQuery("getAllPlaylistNames").getResultList();
	}

	@Override
	public Collection <Track> getTracksByPlaylistName(String username, String playlistName) {
		return em.createNamedQuery("getTracksByPlaylistName").setParameter("username", username).setParameter("playlistName", playlistName).getResultList();
	}
}
