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
package org.ehealth_connector.cda.ch.lrep.v133;

import javax.xml.bind.annotation.XmlTransient;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.25
 * Template description: Swiss Realm (CHE) of HL7 CDA. All CDA-CH V2 derivatives, i.e. Swiss exchange formats MUST reference this template.
 *
 * Element description: Swiss Realm (CHE) of HL7 CDA.
 */
public class CdachHeaderDocumentRealm extends org.ehealth_connector.common.hl7cdar2.CS {

	public CdachHeaderDocumentRealm() {
		super.setCode("CHE");
	// cdach_header_DocumentRealm/hl7:realmCode:cs code = "CHE"; (isVocab)
	}

	@XmlTransient()
	private String myCode;

	/**
	 * Creates fixed contents for CDA Attribute code
	 */
	private void createCodeFixedValue(String value) {
		this.myCode = value;
	}

	/**
	 * Gets the member myCode
	 */
	public String getPredefinedCode() {
		return myCode;
	}
}
