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

import org.herasaf.xacml.core.policy.impl.RuleType;
import org.husky.xua.core.SecurityObjectBuilder;
import org.husky.xua.saml2.SimpleBuilder;
import org.opensaml.xacml.policy.impl.RuleTypeImplBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for PolicyType building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um PolicyType bilden zu können.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class RuleBuilderImpl
		implements SimpleBuilder<RuleType>, SecurityObjectBuilder<org.opensaml.xacml.policy.RuleType, RuleType> {

	@Override
	public RuleType create(org.opensaml.xacml.policy.RuleType aInternalObject) {
		var ruleType = new RuleType();

		if (aInternalObject.getTarget() != null) {
			ruleType.setTarget(new TargetBuilderImpl().create(aInternalObject.getTarget()));
		}

		if (aInternalObject.getCondition() != null) {
			ruleType.setCondition(new ConditionXacmlBuilderImpl().create(aInternalObject.getCondition()));
		}

		return ruleType;
	}

	@Override
	public RuleType create() {
		return new RuleType();
	}

	public org.opensaml.xacml.policy.RuleType create(RuleType aInternalObject) {
		var ruleType = new RuleTypeImplBuilder().buildObject();

		if (aInternalObject.getTarget() != null) {
			ruleType.setTarget(new TargetBuilderImpl().create(aInternalObject.getTarget()));
		}

		if (aInternalObject.getCondition() != null) {
			ruleType.setCondition(new ConditionXacmlBuilderImpl().create(aInternalObject.getCondition()));
		}

		return ruleType;
	}

}
