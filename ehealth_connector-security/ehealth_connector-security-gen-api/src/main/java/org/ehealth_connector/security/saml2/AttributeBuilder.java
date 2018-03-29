/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland. All rights reserved.
 * https://medshare.net Source code, documentation and other resources have been contributed by various people. Project Team:
 * https://sourceforge.net/p/ehealthconnector/wiki/Team/ For exact developer information, please refer to the commit history of the forge.
 * This code is made available under the terms of the Eclipse Public License v1.0. Accompanying materials are made available under the terms
 * of the Creative Commons Attribution-ShareAlike 4.0 License. This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 */
package org.ehealth_connector.security.saml2;

/**
 * @since Jan 16, 2018 1:55:43 PM
 *
 */
public interface AttributeBuilder<T> {

	AttributeBuilder<T> name(String name);

	AttributeBuilder<T> value(String value);

	Attribute<T> createAttribute();

	Attribute<T> createAttribute(T aInternalObject);

}
