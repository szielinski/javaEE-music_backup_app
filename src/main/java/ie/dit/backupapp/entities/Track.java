package ie.dit.backupapp.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
@IdClass(IdClasss.class)
@Table(name = "TB_tracks")
public class Track implements Serializable {

	private static final long serialVersionUID = -5899790538477195104L;

	@Id
	@Column(name = "track_id")
	private Integer trackId;
	@Id
	@Column(name = "library_id")
	private String libraryId;

	@Column
	private String name;
	@Column
	private String artist;
	@Column
	private String album;
	@Column
	private String genre;
	@Column(name = "track_number")
	private Integer trackNumber;
	@Column
	private Integer year;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_LIBRARY")
	@JsonBackReference
	private UserLibrary userLibrary;

	public Track() {
	}

	public Track(int trackId, String libraryId, String name, String artist, String album, String genre, int trackNumber, int year) {
		this.trackId = trackId;
		this.libraryId = libraryId;
		this.name = name;
		this.artist = artist;
		this.album = album;
		this.genre = genre;
		this.trackNumber = trackNumber;
		this.year = year;
	}

	public Integer getTrackId() {
		return trackId;
	}

	public void setTrackId(Integer trackId) {
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
		return "" + getName() + "\n" + getTrackId() + "\n" + getArtist() + "\n" + getAlbum() + "\n" + getGenre() + "\n" + getYear();
	}

	public UserLibrary getUserLibrary() {
		return userLibrary;
	}

	public void setUserLibrary(UserLibrary userLibrary) {
		this.userLibrary = userLibrary;
	}
}
