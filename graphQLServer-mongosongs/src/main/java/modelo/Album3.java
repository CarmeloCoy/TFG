package modelo;

import java.util.List;

public class Album3 extends SuperAlbum {

	private List<String> availabitlity;
	private List<String> genre;

	public Album3(String name, List<String> formats, int releaseYear, List<String> tracks, List<String> availabitlity,
			List<String> genre) {
		super(name, formats, releaseYear, tracks);
		this.availabitlity = availabitlity;
		this.genre = genre;
	}

	public List<String> getAvailabitlity() {
		return availabitlity;
	}

	public void setAvailabitlity(List<String> availabitlity) {
		this.availabitlity = availabitlity;
	}

	public List<String> getGenre() {
		return genre;
	}

	public void setGenre(List<String> genre) {
		this.genre = genre;
	}

}