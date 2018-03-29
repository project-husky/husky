/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland. All rights reserved.
 * https://medshare.net Source code, documentation and other resources have been contributed by various people. Project Team:
 * https://sourceforge.net/p/ehealthconnector/wiki/Team/ For exact developer information, please refer to the commit history of the forge.
 * This code is made available under the terms of the Eclipse Public License v1.0. Accompanying materials are made available under the terms
 * of the Creative Commons Attribution-ShareAlike 4.0 License. This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 */
package org.ehealth_connector.security.saml2;

import java.util.Calendar;
import java.util.List;

import org.ehealth_connector.security.core.SecurityObject;

/**
 * @since Jan 16, 2018 2:24:45 PM
 *
 */
public interface Response<T, U> extends SecurityObject<T> {

	String getID();

	String getInResponseTo();

	Calendar getIssueInstant();

	String getDestination();

	String getConsent();

	String getIssuer();

	List<Assertion<U>> getAssertions();

	// List<EncryptedAssertion> getEncryptedAssertions()

}
