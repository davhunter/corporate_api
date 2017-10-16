package com.deloitte.capi.cdm.executioncontrol;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * POJO containing detailed results, from any search source (<b>Canada
 * Health</b>, <b>Twitter</b>, etc.) Data can be serialized/deserialized to
 * JSON.
 * 
 * @author David Hunter (Deloitte)
 * @apiviz.landmark
 */
@JsonAutoDetect
public class DetailedResult implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date datePublished;
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private String department;
	private String id;
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private String title;
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private String url;
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private ArrayList<String> hashtags = new ArrayList<String>();
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private String text;
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private String user;
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private ArrayList<String> categories;

	public DetailedResult(Date datePublished, String department, String id, String title, String url,
			ArrayList<String> hashtags, String text, String user, ArrayList<String> categories) {
		super();
		this.datePublished = datePublished;
		this.department = department;
		this.id = id;
		this.title = title;
		this.url = url;
		this.hashtags = hashtags;
		this.text = text;
		this.user = user;
		this.categories = categories;
	}

	public DetailedResult() {

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DetailedResult [");
		if (datePublished != null) {
			builder.append("datePublished=");
			builder.append(datePublished);
			builder.append(", ");
		}
		if (department != null) {
			builder.append("department=");
			builder.append(department);
			builder.append(", ");
		}
		if (id != null) {
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (title != null) {
			builder.append("title=");
			builder.append(title);
			builder.append(", ");
		}
		if (url != null) {
			builder.append("url=");
			builder.append(url);
			builder.append(", ");
		}
		if (hashtags != null) {
			builder.append("hashtags=");
			builder.append(hashtags);
			builder.append(", ");
		}
		if (text != null) {
			builder.append("text=");
			builder.append(text);
			builder.append(", ");
		}
		if (user != null) {
			builder.append("user=");
			builder.append(user);
			builder.append(", ");
		}
		if (categories != null) {
			builder.append("categories=");
			builder.append(categories);
		}
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the datePublished
	 */
	public Date getDatePublished() {
		return datePublished;
	}

	/**
	 * @param datePublished
	 *            the datePublished to set
	 */
	public void setDatePublished(Date datePublished) {
		this.datePublished = datePublished;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department
	 *            the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the hashtags
	 */
	public ArrayList<String> getHashtags() {
		return hashtags;
	}

	/**
	 * @param hashtags
	 *            the hashtags to set
	 */
	public void setHashtags(ArrayList<String> hashtags) {
		this.hashtags = hashtags;
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

	/**
	 * @return the categories
	 */
	public ArrayList<String> getCategories() {
		return categories;
	}

	/**
	 * @param categories
	 *            the categories to set
	 */
	public void setCategories(ArrayList<String> categories) {
		this.categories = categories;
	}
}
