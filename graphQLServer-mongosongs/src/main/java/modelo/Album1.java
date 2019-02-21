package modelo;

import java.util.List;

public class Album1 extends Album {

	private String availabitlity;
	private String genre;

	public Album1(String name, List<String> formats, int releaseYear, List<String> tracks, String availabitlity,
			String genre) {
		super(null,name, formats, releaseYear, tracks);
		this.availabitlity=availabitlity;
		this.genre=genre;
	}
	
	public Album1(String id,String name, List<String> formats, int releaseYear, List<String> tracks, String availabitlity,
			String genre) {
		super(id, name, formats, releaseYear, tracks);
		this.availabitlity=availabitlity;
		this.genre=genre;
	}

	public String getAvailabitlity() {
		return availabitlity;
	}

	public void setAvailabitlity(String availabitlity) {
		this.availabitlity = availabitlity;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	

}
