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
package org.ehealth_connector.cda.ch.emed.v0953;

import java.util.List;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.13
 * Template description: Relationship to another CDA-CH V2 based document that is replaced by the current one. All CDA-CH V2 derivatives, i.e. Swiss exchange formats MUST reference this template.
 *
 * Element description: Relationship to another CDA-CH V2 based document that is replaced by the current one.Notes:For correction of wrong information, a new document that replaces the earlier document MUST be created. The new document corrects previously incorrect information. This also applies to the case where information in the CDA header has been corrected (e.g., if the original document has been issued to the wrong patient). While processing the new document at the recipient, all values from the previous document MUST be interpreted as deprecated (deleted/marked as deleted/deprecated) and all values in the new document MUST be marked as valid:
 * - Values that were only contained in the previous document have to be treated as deleted.
 * - Values that are present in both documents are overwritten with the contents of the new document.
 * - Values that are only contained in the new document are to be added.
 */
public class CdachHeaderDocumentReplacement extends org.ehealth_connector.common.hl7cdar2.POCDMT000040RelatedDocument {

	public CdachHeaderDocumentReplacement() {
		super.setTypeCode(org.ehealth_connector.common.hl7cdar2.XActRelationshipDocument.fromValue("RPLC"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.2.13"));
	// cdach_header_DocumentReplacement/hl7:relatedDocument:cs typeCode = "RPLC";
	// cdach_header_DocumentReplacement/hl7:templateId:uid root = "2.16.756.5.30.1.1.10.2.13";
	}

	/**
	 * Creates fixed contents for CDA Element hl7TemplateId
	 *
	 * @param root the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.II retVal = factory.createII();
		retVal.setRoot(root);
		return retVal;
	}

	/**
	 * Gets the hl7ParentDocument
	 * Relationship to the document that needs to be replaced.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040ParentDocument getHl7ParentDocument() {
		return parentDocument;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Sets the hl7ParentDocument
	 * Relationship to the document that needs to be replaced.
	 */
	public void setHl7ParentDocument(org.ehealth_connector.common.hl7cdar2.POCDMT000040ParentDocument value) {
		this.parentDocument = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}
}
