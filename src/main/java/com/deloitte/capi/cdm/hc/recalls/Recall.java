package com.deloitte.capi.cdm.hc.recalls;

import java.io.Serializable;
import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Contains detail about a Recall from Health Canada
 * @author David Hunter
 * @apiviz.landmark
 */
@JsonAutoDetect
public class Recall implements Serializable {
	private static final long serialVersionUID = 1L;
	private String recallId;
	private String title;
	private String department;
	private long datePublished;
	private ArrayList<String> categories = new ArrayList<String>();
	private String url;

	public Recall(String recallId, String title, String department, long datePublished, ArrayList<String> categories, String url) {
		super();
		this.recallId = recallId;
		this.title = title;
		this.department = department;
		this.datePublished = datePublished;
		this.categories = categories;
		this.url = url;
	}

	public Recall() {
		this.recallId = this.title = this.department = this.url = "";
		this.datePublished = -1;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Recall [");
		if (recallId != null) {
			builder.append("recallId=");
			builder.append(recallId);
			builder.append(", ");
		}
		if (title != null) {
			builder.append("title=");
			builder.append(title);
			builder.append(", ");
		}
		if (department != null) {
			builder.append("department=");
			builder.append(department);
			builder.append(", ");
		}
		builder.append("datePublished=");
		builder.append(datePublished);
		builder.append(", ");
		if (categories != null) {
			builder.append("categories=");
			builder.append(categories);
			builder.append(", ");
		}
		if (url != null) {
			builder.append("url=");
			builder.append(url);
		}
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

	@JsonProperty("category")
	public ArrayList<String> getCategories() {
		return categories;
	}

	@JsonProperty("category")
	public void setCategories(ArrayList<String> categories) {
		this.categories = categories;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
