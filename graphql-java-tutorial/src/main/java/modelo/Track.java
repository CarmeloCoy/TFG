package modelo;

import java.time.ZonedDateTime;

public class Track {
	private final String id;
	private final ZonedDateTime createdAt;
	private final String userId;
	private final String linkId;

	public Track(ZonedDateTime createdAt, String userId, String linkId) {
		this(null, createdAt, userId, linkId);
	}

	public Track(String id, ZonedDateTime createdAt, String userId, String linkId) {
		this.id = id;
		this.createdAt = createdAt;
		this.userId = userId;
		this.linkId = linkId;
	}

	public String getId() {
		return id;
	}

	public ZonedDateTime getCreatedAt() {
		return createdAt;
	}

	public String getUserId() {
		return userId;
	}

	public String getLinkId() {
		return linkId;
	}
}
