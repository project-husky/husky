/*
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
package org.ehealth_connector.cda.ch.lab.lrep;

import org.ehealth_connector.cda.ch.CdaChV2StructuredBody;
import org.ehealth_connector.common.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.ch.ChFactory;

/**
 * @formatter:off
 * <div class="en">TODO</div>
 * <div class="de">TODO</div>
 * @formatter:on
 */
public class CdaChLrepV1GeneralReport extends
		CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChLrepV1GeneralReport> {

	/**
	 * {@inheritDoc}
	 */
	public CdaChLrepV1GeneralReport(LanguageCode languageCode, String styleSheet, String css) {
		super(ChFactory.eINSTANCE.createCdaChLrepV1GeneralReport().init(), languageCode, styleSheet,
				css);
		super.initCda();
		switch (this.getLanguageCode()) {
		case GERMAN:
			this.setTitle("TODO title de");
			break;
		case FRENCH:
			setTitle("TODO title fr");
			break;
		case ITALIAN:
			setTitle("TODO title it");
			break;
		case ENGLISH:
			setTitle("TODO title en");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public CdaChLrepV1GeneralReport(
			org.openhealthtools.mdht.uml.cda.ch.CdaChLrepV1GeneralReport doc) {
		super(doc);
	}

}
