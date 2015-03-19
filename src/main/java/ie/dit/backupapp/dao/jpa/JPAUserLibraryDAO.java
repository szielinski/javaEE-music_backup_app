package ie.dit.backupapp.dao.jpa;

import ie.dit.backupapp.dao.UserLibraryDAO;
import ie.dit.backupapp.entities.UserLibrary;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JPAUserLibraryDAO implements UserLibraryDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public UserLibrary getUserLibrary(String username) {
		return em.find(UserLibrary.class, new UserLibrary(username));
	}

	@Override
	public boolean updateUserLibrary(UserLibrary userLibrary) {
		em.merge(userLibrary);
	}

	@Override
	public boolean addUserLibrary(UserLibrary userLibrary) {
		em.persist(userLibrary);
	}

}
