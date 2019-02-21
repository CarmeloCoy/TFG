package modelo;

public class RatingInput {
	private double score;
	private int voters;
	
	public RatingInput() {
	}
	
	public RatingInput(double score, int voters) {
		this();
		this.score = score;
		this.voters = voters;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getVoters() {
		return voters;
	}

	public void setVoters(int voters) {
		this.voters = voters;
	}
	
	public Rating getRating() {
		return new Rating(score, voters);
	}
	
	
}
