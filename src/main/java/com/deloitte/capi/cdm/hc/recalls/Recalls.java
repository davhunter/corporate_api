package com.deloitte.capi.cdm.hc.recalls;

import java.io.Serializable;
import java.util.Arrays;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonAutoDetect
public class Recalls implements Serializable {

	private static final long serialVersionUID = 1L;
	private Recall[] results;
	private int resultsCount;

	public Recalls(Recall[] results, int resultsCount) {
		super();
		this.results = results;
		this.resultsCount = resultsCount;
	}
	
	public Recalls() {
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Recalls [results=");
		builder.append(Arrays.toString(results));
		builder.append(", resultsCount=");
		builder.append(resultsCount);
		builder.append("]");
		return builder.toString();
	}

	public Recall[] getResults() {
		return results;
	}

	public void setResults(Recall[] results) {
		this.results = results;
	}

	@JsonProperty("results_count")
	public int getResultsCount() {
		return resultsCount;
	}

	@JsonProperty("results_count")
	public void setResultsCount(int resultsCount) {
		this.resultsCount = resultsCount;
	}
}
