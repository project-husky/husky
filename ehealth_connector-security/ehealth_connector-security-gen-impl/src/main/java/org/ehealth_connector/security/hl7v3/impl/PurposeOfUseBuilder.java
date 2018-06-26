/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.security.hl7v3.impl;

import org.apache.commons.lang.StringUtils;
import org.ehealth_connector.security.hl7v3.OpenSamlPurposeOfUse;
import org.opensaml.core.xml.AbstractXMLObjectBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class extending the abstract class AbstractXMLObjectBuilder with type OpenSaml PurposeOfUse.</div>
 * <div class="de">Die Klasse erweitert die abstrakte Klasse AbstractXMLObjectBuilder mit typ OpenSaml PurposeOfUse.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class PurposeOfUseBuilder extends AbstractXMLObjectBuilder<OpenSamlPurposeOfUse> {

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
	public OpenSamlPurposeOfUse buildObject() {
		return buildObject(OpenSamlPurposeOfUse.DEFAULT_NS_URI,
				OpenSamlPurposeOfUse.DEFAULT_ELEMENT_LOCAL_NAME,
				OpenSamlPurposeOfUse.DEFAULT_PREFIX);
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.opensaml.core.xml.AbstractXMLObjectBuilder#buildObject(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public OpenSamlPurposeOfUse buildObject(String namespaceURI, String localName,
			String namespacePrefix) {
		final OpenSamlPurposeOfUse ppou = new PurposeOfUseImpl(namespaceURI, localName,
				namespacePrefix);
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

	PurposeOfUseBuilder code(String aCode) {
		code = aCode;
		return this;
	}

	PurposeOfUseBuilder codeSystem(String aCodeSystem) {
		codeSystem = aCodeSystem;
		return this;
	}

	PurposeOfUseBuilder codeSystemName(String aCodeSystemName) {
		codeSystemName = aCodeSystemName;
		return this;
	}

	PurposeOfUseBuilder codeSystemVersion(String aCodeSystemVersion) {
		codeSystemVersion = aCodeSystemVersion;
		return this;
	}

	PurposeOfUseBuilder displayName(String aDisplayNamen) {
		displayName = aDisplayNamen;
		return this;
	}

}
