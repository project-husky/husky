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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.55
 * Template description: CDA-CH-LREP V1 bases on CDA-CH V2 (2017) and XD-LAB (IHE PaLM TF 8.0, 2017).
 *
 * Element description: Sharing Laboratory Reports (XD-LAB) Content Module, IHE PaLM Technical Framework Revision Revision 8.0 - June 21, 2017.
 */
public class CdachlrepHeaderTemplateIdsCdaChLrepV1 {

	public CdachlrepHeaderTemplateIdsCdaChLrepV1() {
		templateId.add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.1.1.3.9.1"));
		templateId.add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.127.1.4"));
		templateId.add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.3.3"));
	// cdachlrep_header_TemplateIdsCdaChLrepV1/hl7:templateId:uid root = "2.16.756.5.30.1.1.1.1.3.9.1";
	// cdachlrep_header_TemplateIdsCdaChLrepV1/hl7:templateId:uid root = "2.16.756.5.30.1.127.1.4";
	// cdachlrep_header_TemplateIdsCdaChLrepV1/hl7:templateId:uid root = "1.3.6.1.4.1.19376.1.3.3";
	}

	/**
	 * CDA-CH-LREP / Laboratory Reports V1 specification. This is an informational reference, only.
	 */
	@XmlTransient()
	private ArrayList<org.ehealth_connector.common.hl7cdar2.II> templateId = new ArrayList<org.ehealth_connector.common.hl7cdar2.II>();

	/**
	 * Creates fixed contents for CDA Element hl7TemplateId
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
	 * CDA-CH-LREP / Laboratory Reports V1 specification. This is an informational reference, only.
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
	 * CDA-CH-LREP / Laboratory Reports V1 specification. This is an informational reference, only.
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		templateId.clear();
		templateId.add(value);
	}
}
