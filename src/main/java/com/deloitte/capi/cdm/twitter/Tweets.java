package com.deloitte.capi.cdm.twitter;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * POJO containing data from a series of Tweets
 * 
 * @author David Hunter (Deloitte)
 * @apiviz.landmark
 * @apiviz.uses com.deloitte.capi.cdm.twitter.Tweet
 */
public class Tweets implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tweets [tweets=");
		builder.append(tweets);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the tweets
	 */
	public ArrayList<Tweet> getTweets() {
		return tweets;
	}

	/**
	 * @param tweets
	 *            the tweets to set
	 */
	public void setTweets(ArrayList<Tweet> tweets) {
		this.tweets = tweets;
	}
}
