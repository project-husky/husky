/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.cda.ihe.pharm;

import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.Criterion;

/**
 * The Class CriterionEntry.
 */
public class CriterionEntry extends MdhtFacade<org.openhealthtools.mdht.uml.cda.Criterion> {

	/**
	 * Instantiates a new criterion entry.
	 */
	public CriterionEntry() {
		super(CDAFactory.eINSTANCE.createCriterion());
	}

	/**
	 * Instantiates a new criterion entry.
	 *
	 * @param criterion
	 *            the criterion
	 */
	protected CriterionEntry(Criterion criterion) {
		super(criterion);
	}

	/**
	 * Gets the text reference pointing to the narrative text in the section.
	 * 
	 * @return the text reference
	 */
	@Override
	public String getTextReference() {
		if ((this.getMdht().getText() != null)
				&& (this.getMdht().getText().getReference() != null)) {
			return this.getMdht().getText().getReference().getValue();
		}
		return null;
	}

	/**
	 * Sets the text reference.
	 * 
	 * @param value
	 *            the new text reference, # for local reference has to be included
	 */
	@Override
	public void setTextReference(String value) {
		this.getMdht().setText(Util.createReference(value));
	}

}
