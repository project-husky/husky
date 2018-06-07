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
package org.ehealth_connector.security.saml2.utils;

import javax.xml.namespace.QName;

import org.ehealth_connector.security.exceptions.BuildException;
import org.opensaml.core.xml.XMLObjectBuilderFactory;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;

public final class OpenSamlUtils {
	public static <T> T buildSAMLObject(final Class<T> clazz) throws BuildException {
		try {
			final XMLObjectBuilderFactory builderFactory = XMLObjectProviderRegistrySupport
					.getBuilderFactory();
			final QName defaultElementName = (QName) clazz.getDeclaredField("DEFAULT_ELEMENT_NAME")
					.get(null);
			@SuppressWarnings("unchecked")
			final T object = (T) builderFactory.getBuilder(defaultElementName)
					.buildObject(defaultElementName);
			return object;
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
				| SecurityException e) {
			throw new BuildException(clazz, e);
		}

	}
}
