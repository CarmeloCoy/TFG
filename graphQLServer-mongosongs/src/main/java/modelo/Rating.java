package modelo;

public class Rating {
	private double score;
	private int voters;
	
	public Rating() {
	}
	
	public Rating(double score, int voters) {
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
	
	
}
