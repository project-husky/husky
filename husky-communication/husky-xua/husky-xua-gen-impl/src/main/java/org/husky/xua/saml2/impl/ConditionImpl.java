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
package org.husky.xua.saml2.impl;

import org.husky.xua.core.SecurityObject;
import org.husky.xua.saml2.Condition;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Condition</div>
 * <div class="de">Implementations Klasse von Condition</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 *
 * <!-- @formatter:on -->
 */
public class ConditionImpl
		implements Condition, SecurityObject<org.opensaml.saml.saml2.core.Condition> {

	/** The wrapped object. */
	private org.opensaml.saml.saml2.core.Condition wrappedObject;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Default constructor to instanciate the object.</div>
	 * <div class="de">Default Konstruktor für die Instanziierung des Objekts.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * <!-- @formatter:on -->
	 *
	 * @param aInternalObject the Condition
	 */
	protected ConditionImpl(org.opensaml.saml.saml2.core.Condition aInternalObject) {
		wrappedObject = aInternalObject;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.core.SecurityObject#getWrappedObject()
	 */
	@Override
	public org.opensaml.saml.saml2.core.Condition getWrappedObject() {
		return wrappedObject;
	}

}
