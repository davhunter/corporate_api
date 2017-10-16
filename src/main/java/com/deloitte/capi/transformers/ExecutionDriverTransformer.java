package com.deloitte.capi.transformers;

import java.util.ArrayList;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;

import com.deloitte.capi.cdm.executioncontrol.Source;

/**
 * This class is used to generate data (Java objects) that will be used to drive
 * execution of the overall API. It is implemented this way to allow for
 * multi-threaded processing; an array of objects is created -- one object for
 * each source that is to be searched -- and Anypoint's asynchronous queuing
 * feature is used to send each object for execution.
 * 
 * @author David Hunter (Deloitte)
 * @apiviz.landmark
 * @apiviz.uses com.deloitte.capi.cdm.executioncontrol.Source
 */
public class ExecutionDriverTransformer extends AbstractMessageTransformer {

	/**
	 * Called by MuleSoft at runtime to perform the "transformation." Simply
	 * creates one object (of type <code>Source</code> for each search that is
	 * to be performed.
	 * 
	 * @param message
	 *            The Anypoint <code>message</code> object
	 * @param outputEncoding
	 *            Not used
	 * @return Array of <code>Source</code objects.
	 */
	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		ArrayList<Source> sources = new ArrayList<Source>();
		String searchTerm = message.getProperty("corporation-name", PropertyScope.INVOCATION);

		// Health Canada
		Source hc = new Source("healthcanada", searchTerm);
		sources.add(hc);

		// Twitter
		Source t = new Source("twitter", searchTerm);
		sources.add(t);

		return sources;
	}

}
