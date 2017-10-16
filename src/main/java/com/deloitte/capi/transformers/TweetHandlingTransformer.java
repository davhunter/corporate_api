package com.deloitte.capi.transformers;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;

import com.deloitte.capi.cdm.executioncontrol.DetailedResult;
import com.deloitte.capi.cdm.executioncontrol.SimpleResult;
import com.deloitte.capi.cdm.executioncontrol.Source;
import com.deloitte.capi.cdm.twitter.Tweet;
import com.deloitte.capi.cdm.twitter.Tweets;

/**
 * Anypoint Java Transformer that is executed after calls to the Twitter API, to
 * combine the returned data with the <code>Source</code> data.
 * 
 * @author David Hunter (Deloitte)
 * @apiviz.landmark
 */
public class TweetHandlingTransformer extends AbstractMessageTransformer {

	/**
	 * Called by Anypoint at runtime. Takes the data returned from the Twitter
	 * API, and uses each tweet to populate <code>SimpleResult</code> and
	 * <code>DetailedResult</code> objects, which are added to the amalgamated
	 * data.
	 * 
	 * @param message
	 *            The Anypoint <code>message</code> object
	 * @param outputEncoding
	 *            not used
	 * @return The same <code>Source</code> object that was originally in the
	 *         payload
	 */
	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		Tweets tweets = message.getProperty("tweets", PropertyScope.INVOCATION);
		Source currentSource = (Source) message.getPayload();

		for (Tweet tweet : tweets.getTweets()) {
			SimpleResult sr = new SimpleResult();
			sr.setCategories(tweet.getHashTags());
			sr.setId(Long.toString(tweet.getId()));
			sr.setText(tweet.getText());
			currentSource.getSimpleResults().add(sr);

			DetailedResult dr = new DetailedResult();
			dr.setDatePublished(tweet.getCreatedAt());
			dr.setHashtags(tweet.getHashTags());
			dr.setId(Long.toString(tweet.getId()));
			dr.setText(tweet.getText());
			dr.setUser(tweet.getUser());
			currentSource.getDetailedResults().add(dr);
		}

		return currentSource;
	}

}
