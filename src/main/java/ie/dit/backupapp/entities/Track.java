package ie.dit.backupapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(IdClasss.class)
@Table(name = "TB_tracks")
// @NamedQueries()
public class Track {

	@Id
	@Column(name = "track_id")
	private int trackId;
	@Id
	@Column(name = "library_id")
	private int libraryId;

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

	public Track() {
	}

	public Track(int trackId, int libraryId, String name, String artist, String composer, String album, String genre, int trackNumber, int year) {
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

	public int getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(int libraryId) {
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
	
	public String toString(){
		return ""+getName()+"\n"+getTrackId()+"\n"+getArtist()+"\n"+getComposer()+"\n"+getAlbum()+"\n"+getGenre()+"\n"+getYear();
	}
}
