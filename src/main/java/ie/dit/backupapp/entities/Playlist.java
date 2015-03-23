package ie.dit.backupapp.entities;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_playlists")
public class Playlist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PK_playlist_id")
	private int playlistId;

	@Column
	private String name;

	@ManyToMany
	@JoinTable(name = "TB_playlists_tracks", joinColumns = {@JoinColumn(name = "playlist_id", referencedColumnName = "PK_playlist_id")}, inverseJoinColumns = {
			@JoinColumn(name = "track_id", referencedColumnName = "track_id"), @JoinColumn(name = "library_id", referencedColumnName = "library_id")})
	private Collection <Track> tracks;

	public Playlist() {
		this.tracks = new ArrayList <>();
	}

	public Playlist(String name, Collection <Track> tracks) {
		this.name = name;
		this.tracks = tracks;
	}

	public int getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(int playlistId) {
		this.playlistId = playlistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		this.tracks.add(track);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + playlistId;
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
		Playlist other = (Playlist) obj;
		if (playlistId != other.playlistId)
			return false;
		return true;
	}

	public String toString() {
		String tracksString = "";
		for (Track t : tracks)
			tracksString += t.getTrackId() + "\n";
		return getName() + "\n" + tracksString;
	}
}
