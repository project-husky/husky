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

package org.ehealth_connector.cda.ch;

import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

/**
 * ExternalDocumentEntry implements the relationship for holding an External
 * Document Entry to the immunization recommendation in switzerland, see chapter
 * 7.5.8.5 Spezifikation CDA Body Level 3 – Immunization Recommendation Entry
 * CDA-CH-VACD, entryRelationship, guidelines
 */
public class ExternalReferenceEntry extends org.ehealth_connector.cda.AbstractExternalReferenceEntry {

	/**
	 * Instantiates a new external reference entry.
	 */
	public ExternalReferenceEntry() {
		super(CHFactory.eINSTANCE.createCDACHBodyExtRef().init(), "2.16.756.5.30.1.1.1.1.1", "CDA-CH.Body.ExtRef");
	}

	/**
	 * Instantiates a new external reference entry.
	 *
	 * @param externalReference the external reference
	 */
	public ExternalReferenceEntry(org.openhealthtools.mdht.uml.cda.ch.CDACHBodyExtRef externalReference) {
		super(externalReference);
	}

}
