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

import java.util.List;

import org.husky.xua.core.SecurityObject;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AudienceRestrictionType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.ConditionAbstractType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.ConditionsType;
import org.opensaml.saml.saml2.core.impl.ConditionsBuilder;

/**
 *
 */
public class ConditionsImpl
		extends ConditionsType implements SecurityObject<org.opensaml.saml.saml2.core.Conditions> {

	private org.opensaml.saml.saml2.core.Conditions wrappedObject;

	protected ConditionsImpl(org.opensaml.saml.saml2.core.Conditions aInternalObject) {
		wrappedObject = aInternalObject;
	}

	protected ConditionsImpl(ConditionsType aInternalObject) {
		wrappedObject = new ConditionsBuilder().buildObject();
		
		if(aInternalObject != null) {
			for(ConditionAbstractType condition: aInternalObject.getConditionOrAudienceRestrictionOrOneTimeUse()) {
				if(condition instanceof AudienceRestrictionType) {
					var audienceRestr = (AudienceRestrictionType) condition;
					wrappedObject.getAudienceRestrictions().add(new AudienceRestrictionBuilderImpl().create(audienceRestr));
				}
			}

			if (aInternalObject.getNotBefore() != null) {
				wrappedObject.setNotBefore(aInternalObject.getNotBefore().toGregorianCalendar().toInstant());
			}

			if (aInternalObject.getNotOnOrAfter() != null) {
				wrappedObject.setNotOnOrAfter(aInternalObject.getNotOnOrAfter().toGregorianCalendar().toInstant());
			}
		}
	}

	public List<AudienceRestrictionType> getAudienceRestrictions() {	
		if (wrappedObject.getAudienceRestrictions() != null) {
			wrappedObject.getAudienceRestrictions().forEach(audienceRestrictions -> 
				getAudienceRestrictions().add(new AudienceRestrictionBuilderImpl().create(audienceRestrictions))
				);
		}
		return getAudienceRestrictions();
	}

	@Override
	public org.opensaml.saml.saml2.core.Conditions getWrappedObject() {
		return wrappedObject;
	}

}
