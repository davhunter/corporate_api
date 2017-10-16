package com.deloitte.capi.cdm.executioncontrol;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * POJO containing simplified data for any search result. Every field should be
 * populated, regardless of the search source.
 * 
 * @author David Hunter (Deloitte)
 * @apiviz.landmark
 */
public class SimpleResult implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> categories = new ArrayList<String>();
	private String id;
	private String text;

	public SimpleResult(ArrayList<String> categories, String id, String text) {
		super();
		this.categories = categories;
		this.id = id;
		this.text = text;
	}

	public SimpleResult() {

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SimpleResult [categories=");
		builder.append(categories);
		builder.append(", id=");
		builder.append(id);
		builder.append(", text=");
		builder.append(text);
		builder.append("]");
		return builder.toString();
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
}
