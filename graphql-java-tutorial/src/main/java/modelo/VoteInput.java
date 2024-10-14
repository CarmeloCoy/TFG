package modelo;

import java.time.ZonedDateTime;

public class VoteInput {
	private final DateTime createdAt;
	private final String user;
	private final String link;


	public VoteInput(){
		this(null, null, null);
	}

	public VoteInput( DateTime createdAt, String userId, String linkId) {
		this.createdAt = createdAt;
		this.user = userId;
		this.link = linkId;
	}

	public DateTime getCreatedAt() {
		return createdAt;
	}

	public String getUser() {
		return user;
	}

	public String getLink() {
		return link;
	}
}
