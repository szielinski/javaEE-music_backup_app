package ie.dit.backupapp.entities;

import java.io.Serializable;

public class IdClasss implements Serializable {

	private static final long serialVersionUID = 1582850329534801192L;

	private int trackId;
	private String libraryId;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((libraryId == null) ? 0 : libraryId.hashCode());
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
		IdClasss other = (IdClasss) obj;
		if (libraryId == null) {
			if (other.libraryId != null)
				return false;
		}
		else if ( !libraryId.equals(other.libraryId))
			return false;
		if (trackId != other.trackId)
			return false;
		return true;
	}

}
