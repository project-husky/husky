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
package org.ehealth_connector.security.ch.epr.config;

import org.opensaml.core.xml.config.AbstractXMLObjectProviderInitializer;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Interface XUserAssertionRequest and SecurityObject</div>
 * <div class="de">Implementations Klasse von  Interface XUserAssertionRequest und SecurityObject</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class EprObjectProviderInitializer extends AbstractXMLObjectProviderInitializer {

	/** Config resources. */
	private static String[] configs = { "/epr-config.xml", };

	/**
	 * {@inheritDoc}
	 *
	 * @see org.opensaml.core.xml.config.AbstractXMLObjectProviderInitializer#getConfigResources()
	 */
	@Override
	protected String[] getConfigResources() {
		return configs;
	}

}
