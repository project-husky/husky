/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.husky.xua.hl7v3.impl;

import java.util.LinkedList;
import java.util.List;

import org.husky.xua.hl7v3.CE;
import org.opensaml.core.xml.AbstractXMLObject;
import org.opensaml.core.xml.XMLObject;

/**
 * <!-- @formatter:off -->
 * <div class="en">HEREISENGLISH</div>
 * <div class="de">HIERISTDEUTSCH</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 *
 * <!-- @formatter:on -->
 */
public abstract class AbstractImpl extends AbstractXMLObject implements CE {

	protected String code;
	protected String codeSystem;
	protected String codeSystemName;
	protected String codeSystemVersion;
	protected String displayName;

	protected AbstractImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
		super(namespaceURI, elementLocalName, namespacePrefix);
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getCodeSystem() {
		return codeSystem;
	}

	@Override
	public String getCodeSystemName() {
		return codeSystemName;
	}

	@Override
	public String getCodeSystemVersion() {
		return codeSystemVersion;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public List<XMLObject> getOrderedChildren() {
		return new LinkedList<>();
	}

	@Override
	public void setCode(String value) {
		code = value;
	}

	@Override
	public void setCodeSystem(String value) {
		codeSystem = value;
	}

	@Override
	public void setCodeSystemName(String value) {
		codeSystemName = value;
	}

	@Override
	public void setCodeSystemVersion(String value) {
		codeSystemVersion = value;
	}

	@Override
	public void setDisplayName(String value) {
		displayName = value;
	}

}
