package modelo;

public class Rating_ {
	
	private double score;
	private int voters;
	
	public Rating_() {
		super();
	}
	
	public Rating_(double score, int voters) {
		this();
		this.score = score;
		this.voters = voters;
	}

	public double getScore() {
		return score;
	}

	public int getVoters() {
		return voters;
	}

	public Rating getRating() {
		return new Rating(score, voters);
	}
	
	
	
}
