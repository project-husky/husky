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
package org.projecthusky.xua.saml2.impl;

import org.herasaf.xacml.core.policy.impl.EffectType;
import org.herasaf.xacml.core.policy.impl.ObligationType;
import org.projecthusky.xua.core.SecurityObjectBuilder;
import org.projecthusky.xua.saml2.SimpleBuilder;
import org.opensaml.xacml.policy.impl.ObligationTypeImplBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for Obligation building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um Obligation bilden zu können.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class ObligationBuilderImpl implements SimpleBuilder<ObligationType>,
		SecurityObjectBuilder<org.opensaml.xacml.policy.ObligationType, ObligationType> {

	@Override
	public ObligationType create(org.opensaml.xacml.policy.ObligationType aInternalObject) {
		var retVal = new ObligationType();
		retVal.setObligationId(aInternalObject.getObligationId());

		EffectType effectType = null;

		if (org.opensaml.xacml.policy.EffectType.Permit.equals(aInternalObject.getFulfillOn())) {
			effectType = EffectType.PERMIT;
		} else if (org.opensaml.xacml.policy.EffectType.Deny.equals(aInternalObject.getFulfillOn())) {
			effectType = EffectType.DENY;
		}

		retVal.setFulfillOn(effectType);

		return retVal;
	}

	@Override
	public ObligationType create() {
		return new ObligationType();
	}

	/**
	 * Method to create ObligationType.
	 * 
	 * @param aInternalObject the ObligationType
	 * @return the opensaml ObligationType
	 */
	public org.opensaml.xacml.policy.ObligationType create(ObligationType aInternalObject) {
		var retVal = new ObligationTypeImplBuilder().buildObject();
		retVal.setObligationId(aInternalObject.getObligationId());

		org.opensaml.xacml.policy.EffectType effectType = null;

		if (EffectType.PERMIT.equals(aInternalObject.getFulfillOn())) {
			effectType = org.opensaml.xacml.policy.EffectType.Permit;
		} else if (EffectType.DENY.equals(aInternalObject.getFulfillOn())) {
			effectType = org.opensaml.xacml.policy.EffectType.Deny;
		}

		retVal.setFulfillOn(effectType);

		return retVal;
	}

}
