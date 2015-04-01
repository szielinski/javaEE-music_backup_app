package ie.dit.backupapp.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@IdClass(IdClasss.class)
@Table(name = "TB_tracks")
// @NamedQueries()
public class Track implements Serializable {

	private static final long serialVersionUID = -5899790538477195104L;

	@Id
	@Column(name = "track_id")
	private int trackId;
	@Id
	@Column(name = "library_id")
	private String libraryId;

	@Column
	private String name;
	@Column
	private String artist;
	@Column
	private String composer;
	@Column
	private String album;
	@Column
	private String genre;
	@Column(name = "track_number")
	private Integer trackNumber;
	@Column
	private Integer year;

//	@ManyToOne(fetch = FetchType.EAGER)
//	// @Fetch(value = FetchMode.SUBSELECT)
//	@JoinColumn(name = "USER_LIBRARY")
//	private UserLibrary userLibrary;

//	@ManyToMany(mappedBy = "tracks")
//	private Collection <Playlist> playlists;

	public Track() {
	}

	public Track(int trackId, String libraryId, String name, String artist, String composer, String album, String genre, int trackNumber, int year) {
		this.trackId = trackId;
		this.libraryId = libraryId;
		this.name = name;
		this.artist = artist;
		this.composer = composer;
		this.album = album;
		this.genre = genre;
		this.trackNumber = trackNumber;
		this.year = year;
	}

	public int getTrackId() {
		return trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public String getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(String libraryId) {
		this.libraryId = libraryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getTrackNumber() {
		return trackNumber;
	}

	public void setTrackNumber(Integer trackNumber) {
		this.trackNumber = trackNumber;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String toString() {
		return "" + getName() + "\n" + getTrackId() + "\n" + getArtist() + "\n" + getComposer() + "\n" + getAlbum() + "\n" + getGenre() + "\n" + getYear();
	}

//	public UserLibrary getUserLibrary() {
//		return userLibrary;
//	}
//
//	public void setUserLibrary(UserLibrary userLibrary) {
//		this.userLibrary = userLibrary;
//	}
//
//	public Collection <Playlist> getPlaylists() {
//		return playlists;
//	}
//
//	public void setPlaylists(Collection <Playlist> playlists) {
//		this.playlists = playlists;
//	}
}
