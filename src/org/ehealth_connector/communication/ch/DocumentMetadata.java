package org.ehealth_connector.communication.ch;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.XdsUtil;

public class DocumentMetadata extends org.ehealth_connector.communication.DocumentMetadata {
	/**
	 * Sets the (required, but in principle computable) class code, which defines
	 * the class of the document (e.g. Code for "Consultation")
	 * 
	 * @param code
	 *          the new class code
	 */
	public void setClassCode(org.ehealth_connector.communication.ch.enums.ClassCode code) {
		xDoc.setClassCode(code.getCodedMetadataType());
	}
}
