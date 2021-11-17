/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.husky.xua.hl7v3.impl;

import org.apache.commons.lang3.StringUtils;
import org.husky.xua.hl7v3.OpenSamlRole;
import org.husky.xua.hl7v3.Role;
import org.opensaml.core.xml.AbstractXMLObjectBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class extending the abstract class AbstractXMLObjectBuilder with type OpenSaml PurposeOfUse.</div>
 * <div class="de">Die Klasse erweitert die abstrakte Klasse AbstractXMLObjectBuilder mit typ OpenSaml PurposeOfUse.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class RoleBuilder extends AbstractXMLObjectBuilder<OpenSamlRole> {

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
	 * <!-- @formatter:off -->
	 * <div class="en">Method to build an OpenSamlPurposeOfUse instance.</div>
	 * <div class="de">Methode um eine OpenSamlPurposeOfUse Instanz zu kreiiren.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the OpenSamlPurposeOfUse instance.</div>
	 * <div class="de">Die OpenSamlPurposeOfUse Instanz.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public OpenSamlRole buildObject() {
		return buildObject(Role.DEFAULT_NS_URI, Role.DEFAULT_ELEMENT_LOCAL_NAME,
				Role.DEFAULT_PREFIX);
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.opensaml.core.xml.AbstractXMLObjectBuilder#buildObject(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public OpenSamlRole buildObject(String namespaceURI, String localName, String namespacePrefix) {
		// This is just to make the assertion Valid in the Gazelle EVS Client:
		// https://ehealthsuisse.ihe-europe.net/EVSClient/xml/validator.seam?extension=CH%3AXUA&standard=CH%3AXUA&type=XML
		// The prefox lead to schema error on 19.7.2018
		// final OpenSamlPurposeOfUse ppou = new PurposeOfUseImpl(namespaceURI,
		// localName,
		// namespacePrefix);
		final OpenSamlRole ppou = new RoleImpl(namespaceURI, localName, "");

		if (!StringUtils.isEmpty(code)) {
			ppou.setCode(code);
		}
		if (!StringUtils.isEmpty(codeSystem)) {
			ppou.setCodeSystem(codeSystem);
		}
		if (!StringUtils.isEmpty(codeSystemName)) {
			ppou.setCodeSystemName(codeSystemName);
		}
		if (!StringUtils.isEmpty(codeSystemVersion)) {
			ppou.setCodeSystemVersion(codeSystemVersion);
		}
		if (!StringUtils.isEmpty(displayName)) {
			ppou.setDisplayName(displayName);
		}
		return ppou;
	}

	public RoleBuilder code(String aCode) {
		code = aCode;
		return this;
	}

	public RoleBuilder codeSystem(String aCodeSystem) {
		codeSystem = aCodeSystem;
		return this;
	}

	public RoleBuilder codeSystemName(String aCodeSystemName) {
		codeSystemName = aCodeSystemName;
		return this;
	}

	public RoleBuilder codeSystemVersion(String aCodeSystemVersion) {
		codeSystemVersion = aCodeSystemVersion;
		return this;
	}

	public RoleBuilder displayName(String aDisplayNamen) {
		displayName = aDisplayNamen;
		return this;
	}

}
