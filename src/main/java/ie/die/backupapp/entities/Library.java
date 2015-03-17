package ie.die.backupapp.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_libraries")
public class Library {

	@Id
	@Column(name = "PK_library_persistent_id")
	private String libraryPersistentId;
	
	@Column(name = "major_version")
	private int majorVersion;
	
	@Column(name = "minor_version")
	private int minorVersion;
	
	@Column
	private Date date;

	@Column(name = "application_version")
	private String applicationVersion;

	@Column
	private int features;

	@Column(name = "show_content_ratings")
	private boolean showContentRatings;

	@Column(name = "music_folder")
	private String musicFolder;
}
