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
package org.projecthusky.xua.hl7v3.impl;

import org.apache.commons.lang3.StringUtils;
import org.opensaml.core.xml.AbstractXMLObjectBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class extending the abstract class AbstractXMLObjectBuilder with type OpenSaml XMLObject (CE).</div>
 * <div class="de">Die Klasse erweitert die abstrakte Klasse AbstractXMLObjectBuilder mit typ OpenSaml XMLObject (CE).</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class CodedWithEquivalentsBuilder extends AbstractXMLObjectBuilder<CodedWithEquivalentImpl> {

	/** The code. */
	protected String code;

	/** The code system. */
	protected String codeSystem;

	/** The code system name. */
	protected String codeSystemName;

	/** The code system version. */
	protected String codeSystemVersion;

	/** The display name. */
	protected String displayName;

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.opensaml.core.xml.AbstractXMLObjectBuilder#buildObject(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public CodedWithEquivalentImpl buildObject(String namespaceURI, String localName, String namespacePrefix) {
		// This is just to make the assertion Valid in the Gazelle EVS Client:
		// https://ehealthsuisse.ihe-europe.net/EVSClient/xml/validator.seam?extension=CH%3AXUA&standard=CH%3AXUA&type=XML
		// The prefix lead to schema error on 19.7.2018
		final CodedWithEquivalentImpl ce = new CodedWithEquivalentImpl(namespaceURI, localName, "");

		if (!StringUtils.isEmpty(code)) {
			ce.setCode(code);
		}
		if (!StringUtils.isEmpty(codeSystem)) {
			ce.setCodeSystem(codeSystem);
		}
		if (!StringUtils.isEmpty(codeSystemName)) {
			ce.setCodeSystemName(codeSystemName);
		}
		if (!StringUtils.isEmpty(codeSystemVersion)) {
			ce.setCodeSystemVersion(codeSystemVersion);
		}
		if (!StringUtils.isEmpty(displayName)) {
			ce.setDisplayName(displayName);
		}
		return ce;
	}

	/**
	 * Method to set code.
	 * 
	 * @param aCode the code to be set
	 * @return this instance of builder
	 */
	public CodedWithEquivalentsBuilder code(String aCode) {
		code = aCode;
		return this;
	}

	/**
	 * Method to set codeSystem.
	 * 
	 * @param aCodeSystem the codeSystem to be set
	 * @return this instance of builder
	 */
	public CodedWithEquivalentsBuilder codeSystem(String aCodeSystem) {
		codeSystem = aCodeSystem;
		return this;
	}

	/**
	 * Method to set codeSystemName.
	 * 
	 * @param aCodeSystemName the codeSystemName to be set
	 * @return this instance of builder
	 */
	public CodedWithEquivalentsBuilder codeSystemName(String aCodeSystemName) {
		codeSystemName = aCodeSystemName;
		return this;
	}

	/**
	 * Method to set codeSystemVersion.
	 * 
	 * @param aCodeSystemVersion the codeSystemVersion to be set
	 * @return this instance of builder
	 */
	public CodedWithEquivalentsBuilder codeSystemVersion(String aCodeSystemVersion) {
		codeSystemVersion = aCodeSystemVersion;
		return this;
	}

	/**
	 * Method to set displayName.
	 * 
	 * @param aDisplayNamen the displayName to be set
	 * @return this instance of builder
	 */
	public CodedWithEquivalentsBuilder displayName(String aDisplayNamen) {
		displayName = aDisplayNamen;
		return this;
	}

}
