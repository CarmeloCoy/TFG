package modelo;

import java.time.ZonedDateTime;

public class Vote {
	private final String id;
	private final Object createdAt;
	private final String userId;
	private final String linkId;

	public Vote(Object createdAt, String userId, String linkId) {
		this(null, createdAt, userId, linkId);
	}

	public Vote(String id, Object createdAt, String userId, String linkId) {
		this.id = id;
		this.createdAt = createdAt;
		this.userId = userId;
		this.linkId = linkId;
	}

	public String getId() {
		return id;
	}

	public Object getCreatedAt() {
		return createdAt;
	}

	public String getUserId() {
		return userId;
	}

	public String getLinkId() {
		return linkId;
	}
}
