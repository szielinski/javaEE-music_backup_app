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

	public UserLibrary() {
	}

	public UserLibrary(String username) {
		this.username = username;
	}

	public UserLibrary(String username, String password, Collection <Track> tracks, Collection <Playlist> playlists) {
		this.username = username;
		this.password = password;
		this.tracks = tracks;
		this.playlists = playlists;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Collection <Track> getTracks() {
		return tracks;
	}

	public void setTracks(Collection <Track> tracks) {
		this.tracks = tracks;
	}

	public Collection <Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(Collection <Playlist> playlists) {
		this.playlists = playlists;
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
