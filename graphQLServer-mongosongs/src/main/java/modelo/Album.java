package modelo;

import java.util.List;

public abstract class Album {
	public String id;
	protected String name;
	protected List<String> formats;
	protected int releaseYear;
	protected List<String> track_ids;
	
	public Album(String id, String name, List<String> formats, int releaseYear, List<String> track_ids) {
		super();
		this.id=id;
		this.name = name;
		this.formats = formats;
		this.releaseYear = releaseYear;
		this.track_ids = track_ids;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getFormats() {
		return formats;
	}

	public void setFormats(List<String> formats) {
		this.formats = formats;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public List<String> getTrack_ids() {
		return track_ids;
	}

	public void setTrack_ids(List<String> track_ids) {
		this.track_ids = track_ids;
	}
	
		
	

}
