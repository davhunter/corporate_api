/**
 * 
 */
package com.deloitte.capi.transformers;

import java.util.ArrayList;
import java.util.Date;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;

import com.deloitte.capi.cdm.executioncontrol.DetailedResult;
import com.deloitte.capi.cdm.executioncontrol.SimpleResult;
import com.deloitte.capi.cdm.executioncontrol.Source;
import com.deloitte.capi.cdm.hc.recalls.Recall;
import com.deloitte.capi.cdm.hc.recalls.Recalls;

/**
 * Anypoint Java Transformer that is executed after calls to the Health Canada
 * API, to combine the returned data with the <code>Source</code> data.
 * 
 * @author David Hunter (Deloitte)
 * @apiviz.landmark
 * @apiviz.uses com.deloitte.capi.cdm.executioncontrol.SimpleResult
 * @apiviz.uses com.deloitte.capi.cdm.executioncontrol.DetailedResult
 * @apiviz.uses com.deloitte.capi.cdm.executioncontrol.Source
 */
public class HCHandlingTransformer extends AbstractMessageTransformer {

	/**
	 * Called by Anypoint at runtime. For each result returned from the Health
	 * Canada API, creates <code>SimpleResult</code> and
	 * <code>DetailedResult</code> objects, which are added to the accumulated
	 * data.
	 * 
	 * @param message
	 *            The Anypoint <code>message</code> object
	 * @param outputEncoding
	 *            Not used
	 * @return the same <code>Source</code> object that was already in the
	 *         payload
	 */
	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		Recalls recalls = message.getProperty("recalls", PropertyScope.INVOCATION);
		Source currentSource = (Source) message.getPayload();

		for (Recall recall : recalls.getResults()) {
			SimpleResult sr = new SimpleResult();
			sr.setCategories(getTranslatedCategories(recall.getCategories()));
			sr.setId(recall.getRecallId());
			sr.setText(recall.getTitle());
			currentSource.getSimpleResults().add(sr);

			DetailedResult dr = new DetailedResult();
			dr.setDatePublished(new Date(recall.getDatePublished()));
			dr.setDepartment(recall.getDepartment());
			dr.setId(recall.getRecallId());
			dr.setTitle(recall.getTitle());
			dr.setUrl(recall.getUrl());
			dr.setCategories(getTranslatedCategories(recall.getCategories()));
			currentSource.getDetailedResults().add(dr);
		}

		return currentSource;
	}

	/**
	 * Helper function that translates the "categories" returned from the Health
	 * Canada API. The API returns only a numeric value (as a string), so this
	 * function translates those values into English descriptions.
	 * 
	 * @param categories
	 *            The untranslated list of category codes
	 * @return The translated list of category codes
	 */
	private ArrayList<String> getTranslatedCategories(ArrayList<String> categories) {
		ArrayList<String> translatedCategories = new ArrayList<String>();

		for (String cat : categories) {
			if (cat.equals("1")) {
				translatedCategories.add("Food");
			} else if (cat.equals("2")) {
				translatedCategories.add("Vehicles");
			} else if (cat.equals("3")) {
				translatedCategories.add("Health Products");
			} else if (cat.equals("4")) {
				translatedCategories.add("Consumer Products");
			}
		}

		return translatedCategories;
	}

}
