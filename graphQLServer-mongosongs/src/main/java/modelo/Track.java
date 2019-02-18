package modelo;

import java.util.LinkedList;
import java.util.List;

public class Track {

	private String id;
	private List<String> genres;
	private double length;
	private String name;
	private List<String> artist_ids;
	private Rating ratings;


	public Track(List<String> genres, double length, String name, List<String> artist_ids, Rating ratings) {
		this(null, genres, length, name, artist_ids, ratings);
	}

	public Track(String id, List<String> genres, double length, String name, List<String> artist_ids, Rating ratings) {
		super();
		this.id = id;
		if (genres == null)
			this.genres = new LinkedList<String>();
		else
			this.genres = genres;
		this.length = length;
		this.name = name;
		if (artist_ids == null)
			this.artist_ids = new LinkedList<String>();
		else
			this.artist_ids = artist_ids;
		this.ratings = ratings;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getArtist_ids() {
		return artist_ids;
	}

	public void setArtist_ids(List<String> artist_ids) {
		this.artist_ids = artist_ids;
	}

	public Rating getRatings() {
		return ratings;
	}

	public void setRatings(Rating ratings) {
		this.ratings = ratings;
	}

}
