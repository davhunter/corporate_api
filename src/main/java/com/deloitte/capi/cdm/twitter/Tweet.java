package com.deloitte.capi.cdm.twitter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * POJO containing information about a Tweet
 * 
 * @author David Hunter (Deloitte)
 * @apiviz.landmark
 */
@JsonAutoDetect()
public class Tweet implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date createdAt;
	@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
	private ArrayList<String> hashTags;
	private long id;
	private String text;
	private String user;

	public Tweet(Date createdAt, ArrayList<String> hashTags, long id, String text, String user) {
		super();
		this.createdAt = createdAt;
		this.hashTags = hashTags;
		this.id = id;
		this.text = text;
		this.user = user;
	}
	
	public Tweet() {
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tweet [createdAt=");
		builder.append(createdAt);
		builder.append(", hashTags=");
		builder.append(hashTags);
		builder.append(", id=");
		builder.append(id);
		builder.append(", text=");
		builder.append(text);
		builder.append(", user=");
		builder.append(user);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt
	 *            the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the hashTags
	 */
	public ArrayList<String> getHashTags() {
		return hashTags;
	}

	/**
	 * @param hashTags
	 *            the hashTags to set
	 */
	public void setHashTags(ArrayList<String> hashTags) {
		this.hashTags = hashTags;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
}
