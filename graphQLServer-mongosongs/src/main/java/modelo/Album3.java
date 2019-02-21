package modelo;

import java.util.List;

public class Album3 extends Album {

	private List<String> availabitlity;
	private List<String> genres;

	public Album3(String id,String name, List<String> formats, int releaseYear, List<String> tracks, List<String> availabitlity,
			List<String> genres) {
		super(id, name, formats, releaseYear, tracks);
		this.availabitlity = availabitlity;
		this.genres = genres;
	}
	
	public Album3(String name, List<String> formats, int releaseYear, List<String> tracks, List<String> availabitlity,
			List<String>  genres) {
		super(null,name, formats, releaseYear, tracks);
		this.availabitlity=availabitlity;
		this.genres=genres;
	}

	public List<String> getAvailabitlity() {
		return availabitlity;
	}

	public void setAvailabitlity(List<String> availabitlity) {
		this.availabitlity = availabitlity;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenre(List<String> genres) {
		this.genres = genres;
	}

}