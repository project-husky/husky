/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
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
package org.ehealth_connector.xua.saml2.impl;

import org.ehealth_connector.xua.core.SecurityObjectBuilder;
import org.ehealth_connector.xua.saml2.SimpleBuilder;
import org.herasaf.xacml.core.policy.impl.EffectType;
import org.herasaf.xacml.core.policy.impl.ObligationType;
import org.opensaml.xacml.policy.impl.ObligationTypeImplBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for Obligation building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um Obligation bilden zu können.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class ObligationBuilderImpl
		implements SimpleBuilder<ObligationType>,
		SecurityObjectBuilder<org.opensaml.xacml.policy.ObligationType, ObligationType> {

	private org.opensaml.xacml.policy.ObligationType wrappedObject;

	public ObligationBuilderImpl() {
		wrappedObject = new ObligationTypeImplBuilder().buildObject();
	}

	@Override
	public ObligationType create(org.opensaml.xacml.policy.ObligationType aInternalObject) {
		wrappedObject = aInternalObject;
		var retVal = new ObligationType();
		retVal.setObligationId(aInternalObject.getObligationId());

		EffectType effectType = null;

		switch (aInternalObject.getFulfillOn()) {
		case Permit:
			effectType = EffectType.PERMIT;
			break;
		case Deny:
			effectType = EffectType.DENY;
		}

		retVal.setFulfillOn(effectType);
		
		return retVal;
	}

	@Override
	public ObligationType create() {
		return new ObligationType();
	}

}
