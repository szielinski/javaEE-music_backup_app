package ie.dit.backupapp.entities;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_playlists")
//@NamedQueries()
public class Playlist {

	@Id
	@Column(name = "PK_playlist_id")
	private String playlistId;
	@Column
	private String name;

	@OneToMany
	private Collection<Track> tracks;
}
