package ie.dit.backupapp.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ie.dit.backupapp.dao.UserLibraryDAO;
import ie.dit.backupapp.entities.UserLibrary;

public class JPAUserLibraryDAO implements UserLibraryDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public UserLibrary getUserLibrary(String username) {
		return em.find(UserLibrary.class, new UserLibrary(username));
	}

	@Override
	public void updateUserLibrary(UserLibrary userLibrary) {
		em.merge(userLibrary);
	}

	@Override
	public void addUserLibrary(UserLibrary userLibrary) {
		em.persist(userLibrary);
	}

}
