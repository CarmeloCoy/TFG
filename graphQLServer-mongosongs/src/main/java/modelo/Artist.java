package modelo;

import java.util.ArrayList;
import java.util.List;

public class Artist {

	private String id;
	private String name;
	private int startingYear;
	private List<String> albums;
	private List<String> composedTracks;
	private List<String> lyricstracks;

	public Artist() {
		super();
		this.albums = new ArrayList<String>();
		this.composedTracks = new ArrayList<String>();
		this.lyricstracks = new ArrayList<String>();
	}

	public Artist(String name, int startingYear) {
		this(null, name, startingYear);
	}

	public Artist(String id, String name, int startingYear) {
		this();
		this.id = id;
		this.name = name;
		this.startingYear = startingYear;
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

	public int getStartingYear() {
		return startingYear;
	}

	public List<String> getAlbums() {
		return albums;
	}

	public List<String> getComposedTracks() {
		return composedTracks;
	}

	public List<String> getLyricstracks() {
		return lyricstracks;
	}

}
