/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: �����
 *
 */
package org.ehealth_connector.cda.ch.lrep;

import javax.xml.bind.JAXBElement;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.9.48
 * Template description: Reusable template wherever an author with required name is used in a CDA-CH V2 document. CDA-CH V2 derivatives, i.e. Swiss exchange formats MAY use this template by either reference or specialisation.
 *
 * Element description: The functionCode MUST be taken from the Swiss EPR Value-Set for author roles. See FDHA Ordinance on the Electronic Patient Record (EPRO-FDHA), Appendix 3: Metadata, Section 2.1.If the desired functionCode is not available in the Swiss EPR Value-Set for author roles, nullFlavor='NAV' MUST be used. In this case, the originalText element MUST contain the description of the role.Translations to other vocabularies are allowed.
 */
public class CdachOtherAuthorCompilationWithName extends org.ehealth_connector.common.hl7cdar2.CE {

	/**
	 * Adds a hl7Translation
	 * A translation of the code to another coding system (e.g. ISCO-08: 2.16.840.1.113883.2.9.6.2.7)
	 */
	public void addHl7Translation(org.ehealth_connector.common.hl7cdar2.CD value) {
		getTranslation().add(value);
	}

	/**
	 * Adds a hl7Translation
	 * A translation of the code to another coding system (e.g. ISCO-08: 2.16.840.1.113883.2.9.6.2.7)
	 */
	public void clearHl7Translation() {
		getTranslation().clear();
	}
}
