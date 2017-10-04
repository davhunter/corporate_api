package com.deloitte.capi.cdm.hc.recalls;

import java.io.Serializable;
import java.util.Arrays;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonAutoDetect
public class Recall implements Serializable {
	private static final long serialVersionUID = 1L;
	private String recallId;
	private String title;
	private String department;
	private long datePublished;
	private String[] category;
	private String url;

	public Recall(String recallId, String title, String department, long datePublished, String[] category, String url) {
		super();
		this.recallId = recallId;
		this.title = title;
		this.department = department;
		this.datePublished = datePublished;
		this.category = category;
		this.url = url;
	}

	public Recall() {
		this.recallId = this.title = this.department = this.url = "";
		this.datePublished = -1;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Recall [recallId=");
		builder.append(recallId);
		builder.append(", title=");
		builder.append(title);
		builder.append(", department=");
		builder.append(department);
		builder.append(", datePublished=");
		builder.append(datePublished);
		builder.append(", category=");
		builder.append(Arrays.toString(category));
		builder.append(", url=");
		builder.append(url);
		builder.append("]");
		return builder.toString();
	}

	public String getRecallId() {
		return recallId;
	}

	public void setRecallId(String recallId) {
		this.recallId = recallId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@JsonProperty("date_published")
	public long getDatePublished() {
		return datePublished;
	}

	@JsonProperty("date_published")
	public void setDatePublished(long datePublished) {
		this.datePublished = datePublished;
	}

	public String[] getCategory() {
		return category;
	}

	public void setCategory(String[] category) {
		this.category = category;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
