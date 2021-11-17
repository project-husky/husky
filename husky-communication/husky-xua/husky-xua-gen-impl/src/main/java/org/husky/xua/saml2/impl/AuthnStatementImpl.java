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
package org.husky.xua.saml2.impl;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import org.husky.xua.core.SecurityObject;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AuthnContextType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AuthnStatementType;
import org.opensaml.saml.saml2.core.AuthnContextClassRef;
import org.opensaml.saml.saml2.core.impl.AuthnContextBuilder;
import org.opensaml.saml.saml2.core.impl.AuthnContextClassRefBuilder;
import org.opensaml.saml.saml2.core.impl.AuthnStatementBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of AuthnStatement</div>
 * <div class="de">Implementations Klasse von AuthnStatement</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class AuthnStatementImpl extends AuthnStatementType
		implements SecurityObject<org.opensaml.saml.saml2.core.AuthnStatement> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthnStatementImpl.class);

	private org.opensaml.saml.saml2.core.AuthnStatement authnStatement;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Default constructor to instanciate the object.</div>
	 * <div class="de">Default Konstruktor für die Instanziierung des Objekts.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * <!-- @formatter:on -->
	 *
	 * @param aAuthnStatement the AuthnStatement
	 */
	protected AuthnStatementImpl(org.opensaml.saml.saml2.core.AuthnStatement aAuthnStatement) {
		authnStatement = aAuthnStatement;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Default constructor to instanciate the object.</div>
	 * <div class="de">Default Konstruktor für die Instanziierung des Objekts.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * <!-- @formatter:on -->
	 *
	 * @param aAuthnStatement the AuthnStatement
	 */
	protected AuthnStatementImpl(AuthnStatementType aAuthnStatement) {
		authnStatement = new AuthnStatementBuilder().buildObject();
		var authnContext = new AuthnContextBuilder().buildObject();
		var authnContextClassRef = new AuthnContextClassRefBuilder().buildObject();

		for (JAXBElement<?> jaxbElement : aAuthnStatement.getAuthnContext().getContent()) {
			if (jaxbElement != null && "AuthnContextClassRef".equalsIgnoreCase(jaxbElement.getName().getLocalPart())) {
				authnContextClassRef.setURI((String) jaxbElement.getValue());
			}
		}

		authnContext.setAuthnContextClassRef(authnContextClassRef);
		authnStatement.setAuthnContext(authnContext);

		if (aAuthnStatement.getAuthnInstant() != null) {
			XMLGregorianCalendar xmlGregCal = aAuthnStatement.getAuthnInstant();
			authnStatement.setAuthnInstant(xmlGregCal.toGregorianCalendar().toInstant());
		}

		authnStatement.setSessionIndex(aAuthnStatement.getSessionIndex());

		if (aAuthnStatement.getSessionNotOnOrAfter() != null) {
			XMLGregorianCalendar xmlGregCal = aAuthnStatement.getSessionNotOnOrAfter();
			authnStatement.setSessionNotOnOrAfter(xmlGregCal.toGregorianCalendar().toInstant());
		}

	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.AuthnStatement#getAuthnContextClassRef()
	 */
	@Override
	public AuthnContextType getAuthnContext() {
		if ((authnStatement.getAuthnContext() != null)
				&& (authnStatement.getAuthnContext().getAuthnContextClassRef() != null)) {
			this.authnContext = new AuthnContextType();
			var qname = new QName("urn:oasis:names:tc:SAML:2.0:assertion", "AuthnContextClassRef");
			this.authnContext.getContent().add(new JAXBElement<>(qname, AuthnContextClassRef.class,
					authnStatement.getAuthnContext().getAuthnContextClassRef()));
			return this.authnContext;
		}
		return null;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.AuthnStatement#getAuthnInstant()
	 */
	@Override
	public XMLGregorianCalendar getAuthnInstant() {
		final var instant = authnStatement.getAuthnInstant();
		final var retVal = GregorianCalendar.from(ZonedDateTime.ofInstant(instant, ZoneId.systemDefault()));

		XMLGregorianCalendar xmlGregCal = null;
		try {
			xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(retVal);
			setAuthnInstant(xmlGregCal);
		} catch (DatatypeConfigurationException e) {
			LOGGER.error(e.getMessage(), e);
		}

		return xmlGregCal;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.AuthnStatement#getSessionIndex()
	 */
	@Override
	public String getSessionIndex() {
		this.sessionIndex = authnStatement.getSessionIndex();
		return authnStatement.getSessionIndex();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.AuthnStatement#getSessionNotOnOrAfter()
	 */
	@Override
	public XMLGregorianCalendar getSessionNotOnOrAfter() {
		final var instant = authnStatement.getSessionNotOnOrAfter();
		final var retVal = GregorianCalendar.from(ZonedDateTime.ofInstant(instant, ZoneId.systemDefault()));

		XMLGregorianCalendar xmlGregCal = null;
		try {
			xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(retVal);
			setAuthnInstant(xmlGregCal);
		} catch (DatatypeConfigurationException e) {
			LOGGER.error(e.getMessage(), e);
		}

		return xmlGregCal;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.core.SecurityObject#getWrappedObject()
	 */
	@Override
	public org.opensaml.saml.saml2.core.AuthnStatement getWrappedObject() {
		return authnStatement;
	}

}
