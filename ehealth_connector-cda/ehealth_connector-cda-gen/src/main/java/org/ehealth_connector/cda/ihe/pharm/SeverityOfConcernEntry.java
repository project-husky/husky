/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */

package org.ehealth_connector.cda.ihe.pharm;

import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.cda.ihe.pharm.enums.SeverityObservation;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.Severity;

/**
 * Implements the IHE SeverityOfConcernEntry.
 */
public class SeverityOfConcernEntry extends MdhtFacade<Severity> {

	/** The language code. */
	private LanguageCode languageCode;

	/**
	 * Instantiates a new severity of concern entry.
	 */
	public SeverityOfConcernEntry() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new severity of concern entry.
	 *
	 * @param languageCode
	 *            the language code
	 */
	public SeverityOfConcernEntry(LanguageCode languageCode) {
		super(IHEFactory.eINSTANCE.createSeverity().init());
		this.languageCode = languageCode;
	}

	/**
	 * Instantiates a new severity of concern entry.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public SeverityOfConcernEntry(Severity mdht) {
		super(mdht);
	}

	/**
	 * Gets the severity observation.
	 *
	 * @return the severity observation
	 */
	public SeverityObservation getSeverityObservation() {
		if (this.getMdht().getCode() != null) {
			return SeverityObservation.getEnum(this.getMdht().getCode().getCode());
		}
		return null;
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
	 * Sets the severity observation.
	 *
	 * @param severityObservation
	 *            the new severity observation
	 */
	public void setSeverityObservation(SeverityObservation severityObservation) {
		this.getMdht().setCode(severityObservation.getCode(languageCode).getCD());
	}

	/**
	 * Sets the text reference.
	 *
	 * @param value
	 *            the new text reference
	 */
	@Override
	public void setTextReference(String value) {
		this.getMdht().setText(Util.createReference(value));
	}

}
