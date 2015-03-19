package ie.dit.backupapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_tracks")
// @NamedQueries()
public class Track {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PK_track_id")
	private int trackId;
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
	private int trackNumber;
	@Column
	private int year;
	
	public Track(){}
	public Track(String name, String artist, String composer, String album, String genre, int trackNumber, int year){
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
	
	public int getTrackNumber() {
		return trackNumber;
	}
	
	public void setTrackNumber(int trackNumber) {
		this.trackNumber = trackNumber;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + trackId;
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
		Track other = (Track) obj;
		if (trackId != other.trackId)
			return false;
		return true;
	}
}
