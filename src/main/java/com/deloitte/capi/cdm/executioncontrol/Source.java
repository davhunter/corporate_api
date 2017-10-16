package com.deloitte.capi.cdm.executioncontrol;

import java.io.Serializable;
import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Overall POJO used for a "source" of data (e.g. Twitter). These objects are
 * used to drive execution of the API, including amalgamation of the returned
 * data, in both simple and detailed variants.
 * 
 * @author David Hunter (Deloitte)
 * @apiviz.landmark
 * @apiviz.uses com.deloitte.capi.cdm.executioncontrol.SimpleResult
 * @apiviz.uses com.deloitte.capi.cdm.executioncontrol.DetailedResult
 * @apiviz.uses org.codehaus.jackson.annotate.JsonAutoDetect
 */
@JsonAutoDetect
public class Source implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private ArrayList<DetailedResult> detailedResults = new ArrayList<DetailedResult>();
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private ArrayList<SimpleResult> simpleResults = new ArrayList<SimpleResult>();
	private String searchTerm;

	public Source(String name, ArrayList<DetailedResult> detailedResults, ArrayList<SimpleResult> simpleResults) {
		super();
		this.name = name;
		this.detailedResults = detailedResults;
		this.simpleResults = simpleResults;
	}

	/**
	 * Special constructor for creating an object, specifying only the name and
	 * search term
	 * 
	 * @param name
	 *            The name of the source
	 * @param searchTerm
	 *            The search term to be used in searching the source data.
	 */
	public Source(String name, String searchTerm) {
		super();
		this.name = name;
		this.searchTerm = searchTerm;
	}

	public Source() {

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Source [");
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}
		if (detailedResults != null) {
			builder.append("detailedResults=");
			builder.append(detailedResults);
			builder.append(", ");
		}
		if (simpleResults != null) {
			builder.append("simpleResults=");
			builder.append(simpleResults);
		}
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the detailedResults
	 */
	public ArrayList<DetailedResult> getDetailedResults() {
		return detailedResults;
	}

	/**
	 * @param detailedResults
	 *            the detailedResults to set
	 */
	public void setDetailedResults(ArrayList<DetailedResult> detailedResults) {
		this.detailedResults = detailedResults;
	}

	/**
	 * @return the simpleResults
	 */
	public ArrayList<SimpleResult> getSimpleResults() {
		return simpleResults;
	}

	/**
	 * @param simpleResults
	 *            the simpleResults to set
	 */
	public void setSimpleResults(ArrayList<SimpleResult> simpleResults) {
		this.simpleResults = simpleResults;
	}

	/**
	 * @return the searchTerm
	 */
	public String getSearchTerm() {
		return searchTerm;
	}

	/**
	 * @param searchTerm
	 *            the searchTerm to set
	 */
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
}
