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

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlTransient;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.18
 * Template description: CDA-CH V2 bases on HL7 CDA R2 (2005) and - by using this template - require a structured body. All CDA-CH V2 derivatives, i.e. Swiss exchange formats SHALL reference this template. These SHALL define further template ids in their own separate templates.
 *
 * Element description: HL7 CDA R2 (2005).
 */
public class CdachHeaderDocumentTemplateIdsCdaChv20StructuredBody {

	public CdachHeaderDocumentTemplateIdsCdaChv20StructuredBody() {
		templateId.add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.1.1.4"));
		templateId.add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.12.2"));
		templateId.add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.12.1"));
	// cdach_header_DocumentTemplateIdsCdaChv2.0-structuredBody/hl7:templateId:uid root = "2.16.756.5.30.1.1.1.1.4";
	// cdach_header_DocumentTemplateIdsCdaChv2.0-structuredBody/hl7:templateId:uid root = "2.16.840.1.113883.10.12.2";
	// cdach_header_DocumentTemplateIdsCdaChv2.0-structuredBody/hl7:templateId:uid root = "2.16.840.1.113883.10.12.1";
	}

	/**
	 * CDA-CH v2.0 specification. This is an informational reference, only.
	 */
	@XmlTransient()
	private ArrayList<org.ehealth_connector.common.hl7cdar2.II> templateId = new ArrayList<org.ehealth_connector.common.hl7cdar2.II>();

	/**
	 * Creates fixed contents for hl7TemplateId
	 *
	 * @param root the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.II retVal = factory.createII();
		retVal.setRoot(root);
		return retVal;
	}

	/**
	 * Gets the hl7TemplateId
	 * CDA-CH v2.0 specification. This is an informational reference, only.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId() {
		org.ehealth_connector.common.hl7cdar2.II retVal = null;
		if (templateId != null)
			if (templateId.size() > 0)
				retVal = templateId.get(0);
		return retVal;
	}

	/**
	 * Sets the hl7TemplateId
	 * CDA-CH v2.0 specification. This is an informational reference, only.
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		templateId.clear();
		templateId.add(value);
	}
}
