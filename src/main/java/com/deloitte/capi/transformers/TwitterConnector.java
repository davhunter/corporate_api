package com.deloitte.capi.transformers;

import java.util.ArrayList;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;

import com.deloitte.capi.cdm.twitter.Tweet;
import com.deloitte.capi.cdm.twitter.Tweets;

import twitter4j.HashtagEntity;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * <p>Java code to connect to the Twitter API, using OAuth security. Implemented as an Anypoint Java Transformer, since it was the easiest way to approach the problem (and the data is returned into the payload, as it would be for a normal transformer, so it is logically consistent.)</p>
 * 
 * <p>Uses the <code>Twitter4J<code> library, which takes care of the OAuth implementation.</p>
 * 
 * @author David Hunter (Deloitte)
 * @apiviz.landmark
 * @apiviz.uses twitter4j.Twitter
 * @apiviz.uses com.deloitte.capi.cdm.twitter.Tweets
 * @apiviz.uses com.deloitte.capi.cdm.twitter.Tweet
 */
public class TwitterConnector extends AbstractMessageTransformer {

	private String apiKey;
	private String apiSecret;
	private String accessToken;
	private String accessTokenSecret;

	/**
	 * Called by Anypoint at runtime. Uses the <code>Twitter4J</code> library to call Twitter, then converts the returned data into <code>Tweet</code> objects.
	 * @param message The Anypoint <code>message</code> object
	 * @param outputEncoding Not used
	 * @return <code>Tweets</code> object, containing all of the tweets that were returned
	 */
	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		Tweets tweets = new Tweets();

		String searchTerm = message.getProperty("searchTerm", PropertyScope.INVOCATION);

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey(this.apiKey);
		cb.setOAuthConsumerSecret(this.apiSecret);
		cb.setOAuthAccessToken(this.accessToken);
		cb.setOAuthAccessTokenSecret(this.accessTokenSecret);
		
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		Query query = new Query(searchTerm);
		
		try {
			QueryResult result = twitter.search(query);
			for (Status status : result.getTweets()) {
				Tweet tweet = new Tweet(status.getCreatedAt(), getHashtagsFromStatus(status), status.getId(),
						status.getText(), status.getUser().getName());
				tweets.getTweets().add(tweet);
			}
		} catch (TwitterException e) {
			throw new TransformerException(this, e);
		}
		
		return tweets;
	}

	/**
	 * Helper function that inspects the <code>Status</code> object returned from Twitter, and returns a simpler <code>ArrayList</code> of strings containing those hashtags.
	 * 
	 * @param status The <code>Status</code> object returned from Twitter
	 * @return Simplfied <code>ArrayList</code> of Strings, for each hashtag in the <code>Status</code>
	 */
	private ArrayList<String> getHashtagsFromStatus(Status status) {
		ArrayList<String> hashtags = new ArrayList<String>();
		
		if(status.getHashtagEntities() == null) {
			return hashtags;
		}

		for (HashtagEntity e : status.getHashtagEntities()) {
			hashtags.add(e.getText());
		}

		return hashtags;
	}

	/**
	 * @return the apiKey
	 */
	public String getApiKey() {
		return apiKey;
	}

	/**
	 * @param apiKey
	 *            the apiKey to set
	 */
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	/**
	 * @return the apiSecret
	 */
	public String getApiSecret() {
		return apiSecret;
	}

	/**
	 * @param apiSecret
	 *            the apiSecret to set
	 */
	public void setApiSecret(String apiSecret) {
		this.apiSecret = apiSecret;
	}

	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * @param accessToken
	 *            the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * @return the accessTokenSecret
	 */
	public String getAccessTokenSecret() {
		return accessTokenSecret;
	}

	/**
	 * @param accessTokenSecret
	 *            the accessTokenSecret to set
	 */
	public void setAccessTokenSecret(String accessTokenSecret) {
		this.accessTokenSecret = accessTokenSecret;
	}

}
