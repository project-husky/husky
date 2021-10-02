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
import org.herasaf.xacml.core.policy.impl.RuleType;

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

}
