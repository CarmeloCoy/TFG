package modelo;

import java.util.ArrayList;
import java.util.List;

public class Artist {

	private String id;
	private String name;
	private int startingYear;
	private List<String> album_ids;
	private List<String> composedTrack_ids;
	private List<String> lyricstrack_ids;

	public Artist() {
		super();
		this.album_ids = new ArrayList<String>();
		this.composedTrack_ids = new ArrayList<String>();
	}
	
	public Artist( String name, int startingYear) {
		this( name, startingYear, null, null, null);
	}


	public Artist( String name, int startingYear, List<String> album_ids, List<String> composedTracks,
			List<String> lyricstracks) {
		this(null, name, startingYear, album_ids, composedTracks,lyricstracks);
	}
	

	public Artist(String id, String name, int startingYear, List<String> album_ids, List<String> composedTracks,
			List<String> lyricstracks) {
		this();
		this.id = id;
		this.name = name;
		this.startingYear = startingYear;
		if(album_ids!=null) this.album_ids.addAll(album_ids);
		if(composedTracks!=null)this.composedTrack_ids.addAll(composedTracks);
		this.lyricstrack_ids =lyricstracks;
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

	public List<String> getAlbum_ids() {
		return album_ids;
	}

	public List<String> getComposedTracks() {
		return composedTrack_ids;
	}

	public List<String> getLyricstracks() {
		return lyricstrack_ids;
	}

	public void addLyricsTracks(List<String> lyricsTracks) {
		if(this.lyricstrack_ids==null) 
			this.lyricstrack_ids = new ArrayList<String>();
		if (lyricsTracks != null) 
			this.lyricstrack_ids.addAll(lyricsTracks);
		
	}

	public void addComposedTracks(List<String> composedTracks) {
		if(this.composedTrack_ids==null)
			this.composedTrack_ids = new ArrayList<String>();
		if (composedTracks!=null)
			this.composedTrack_ids.addAll(composedTracks);
		
	}
	
	public void addAlbums(List<String> albums) {
		if(this.album_ids==null)
			this.album_ids = new ArrayList<String>();
		if(albums!=null) {
			this.album_ids.addAll(albums);
		}
	}

}
