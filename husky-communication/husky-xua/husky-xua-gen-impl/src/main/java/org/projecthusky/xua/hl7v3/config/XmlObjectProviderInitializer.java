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
package org.projecthusky.xua.hl7v3.config;

import org.opensaml.core.xml.config.AbstractXMLObjectProviderInitializer;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Interface XUserAssertionRequest and SecurityObject</div>
 * <div class="de">Implementations Klasse von Interface XUserAssertionRequest und SecurityObject</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class XmlObjectProviderInitializer extends AbstractXMLObjectProviderInitializer {

	/** Config resources. */
	private static String[] configs = { "/hl7-config.xml", };

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
