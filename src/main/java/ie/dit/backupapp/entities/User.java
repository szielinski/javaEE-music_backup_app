package ie.dit.backupapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_users")
//@NamedQueries()
public class User {

	@Id
	@Column(length = 32)
	private String username;
	@Column(length = 64)
	private String password;
	@Column
	private String libraryPersistentId;
}
