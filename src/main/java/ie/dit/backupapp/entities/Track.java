package ie.dit.backupapp.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_tracks")
// @NamedQueries()
public class Track {

	@Id
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
	@Column
	private int size;
	@Column(name = "total_time")
	private int totalTime;
	@Column(name = "track_number")
	private int trackNumber;
	@Column
	private int year;
	@Column(name = "date_added")
	private Date dateAdded;
	@Column(name = "play_count")
	private int playCount;
	@Column(name = "play_date_utc")
	private Date playDateUTC;
}
