package ie.dit.backupapp.entities;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_user_libraries")
@NamedQuery(name = "getAllPlaylistNames", query = "SELECT playlists.name as name FROM UserLibrary userLibraries, Playlist playlists WHERE name MEMBER OF userLibraries.playlists AND userLibraries.username = :username")
public class UserLibrary {

	@Id
	@Column(name = "PK_library_id")
	private int libraryId;

	@Column(unique = true, nullable = false, length = 32)
	private String username;
	@Column(length = 64, nullable = false)
	private String password;
	@Column(name = "library_persistent_id", unique = true, nullable = false)
	private String libraryPersistentId;
	@Column(nullable = false)
	private String role;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "library_id", referencedColumnName = "PK_library_id")
	private Collection <Track> tracks;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "library_id", referencedColumnName="PK_library_id")
	private Collection <Playlist> playlists;

	public UserLibrary() {
		this.tracks = new ArrayList <>();
		this.playlists = new ArrayList <>();
		this.role = "user";
	}

	public UserLibrary(String username) {
		this.username = username;
		this.role = "user";
	}

	public UserLibrary(String username, String password, String libraryPersistentId, Collection <Track> tracks, Collection <Playlist> playlists) {
		this.username = username;
		this.password = password;
		this.libraryPersistentId = libraryPersistentId;
		this.tracks = tracks;
		this.playlists = playlists;
		this.role = "user";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLibraryPersistentId() {
		return libraryPersistentId;
	}

	public void setLibraryPersistentId(String libraryPersistentId) {
		this.libraryPersistentId = libraryPersistentId;
	}

	public Collection <Track> getTracks() {
		return tracks;
	}

	public void setTracks(Collection <Track> tracks) {
		this.tracks = tracks;
	}

	public void addTrack(Track track) {
		if(this.tracks == null){
			this.tracks = new ArrayList<>();
		}
		tracks.add(track);
	}

	public Track getTrackById(int trackId) {
		for (Track t : tracks) {
			if (t.getTrackId() == trackId) {
				return t;
			}
		}
		return null;
	}

	public Collection <Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(Collection <Playlist> playlists) {
		this.playlists = playlists;
	}

	public void addPlaylist(Playlist playlist) {
		if(this.playlists == null){
			this.playlists = new ArrayList<>();
		}
		playlists.add(playlist);
	}

	public int getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserLibrary other = (UserLibrary) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		}
		else if ( !username.equals(other.username))
			return false;
		return true;
	}
}
