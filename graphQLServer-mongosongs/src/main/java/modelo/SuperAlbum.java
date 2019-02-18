package modelo;

import java.util.List;

public abstract class SuperAlbum {
	protected String id;
	protected String name;
	protected List<String> formats;
	protected int releaseYear;
	protected List<String> tracks;
	
	public SuperAlbum(String name, List<String> formats, int releaseYear, List<String> tracks) {
		super();
		this.name = name;
		this.formats = formats;
		this.releaseYear = releaseYear;
		this.tracks = tracks;
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

	public List<String> getTracks() {
		return tracks;
	}

	public void setTracks(List<String> tracks) {
		this.tracks = tracks;
	}
	
		
	

}
