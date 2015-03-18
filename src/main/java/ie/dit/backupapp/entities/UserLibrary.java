package ie.dit.backupapp.entities;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_user_libraries")
// @NamedQueries()
public class UserLibrary {

	@Id
	@Column(name = "PK_username", length = 32)
	private String username;
	@Column(length = 64)
	private String password;
	@Column
	private Date date;

	@OneToMany
	private Collection <Track> tracks;
	@OneToMany
	private Collection <Playlist> playlists;
}
