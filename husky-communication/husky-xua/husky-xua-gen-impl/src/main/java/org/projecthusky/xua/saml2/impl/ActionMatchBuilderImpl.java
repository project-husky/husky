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

import org.herasaf.xacml.core.policy.impl.ActionAttributeDesignatorType;
import org.herasaf.xacml.core.policy.impl.ActionMatchType;
import org.projecthusky.xua.core.SecurityObjectBuilder;
import org.projecthusky.xua.saml2.SimpleBuilder;
import org.opensaml.xacml.policy.impl.ActionMatchTypeImplBuilder;
import org.opensaml.xacml.policy.impl.AttributeDesignatorTypeImplBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for Obligation building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um Obligation bilden zu können.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class ActionMatchBuilderImpl
		implements SimpleBuilder<ActionMatchType>,
		SecurityObjectBuilder<org.opensaml.xacml.policy.ActionMatchType, ActionMatchType> {

	@Override
	public ActionMatchType create(org.opensaml.xacml.policy.ActionMatchType aInternalObject) {
		var retVal = new ActionMatchType();
		var actionAttrDesType = new ActionAttributeDesignatorType();
		actionAttrDesType.setAttributeId(aInternalObject.getActionAttributeDesignator().getAttributeId());
		actionAttrDesType.setIssuer(aInternalObject.getActionAttributeDesignator().getIssuer());
		actionAttrDesType.setMustBePresent(aInternalObject.getActionAttributeDesignator().getMustBePresent());

		if (aInternalObject.getActionAttributeDesignator().getDataType() != null) {
			actionAttrDesType.setDataType(
					new DataTypeAttributeBuilderImpl()
							.create(aInternalObject.getActionAttributeDesignator().getDataType()));
		}

		retVal.setActionAttributeDesignator(actionAttrDesType);
		
		retVal.setMatchFunction(new FunctionBuilderImpl().create(aInternalObject.getMatchId()));

		return retVal;
	}

	@Override
	public ActionMatchType create() {
		return new ActionMatchType();
	}

	/**
	 * Method to create an instance of type U from T.
	 * 
	 * @param aInternalObject the internal wrapped object of type U
	 * 
	 * @return the instance of type T
	 */
	public org.opensaml.xacml.policy.ActionMatchType create(ActionMatchType aInternalObject) {
		var retVal = new ActionMatchTypeImplBuilder().buildObject();
		var actionAttrDesType = new AttributeDesignatorTypeImplBuilder().buildObject();
		actionAttrDesType.setAttributeId(aInternalObject.getActionAttributeDesignator().getAttributeId());
		actionAttrDesType.setIssuer(aInternalObject.getActionAttributeDesignator().getIssuer());
		actionAttrDesType.setMustBePresent(aInternalObject.getActionAttributeDesignator().isMustBePresent());

		if (aInternalObject.getActionAttributeDesignator().getDataType() != null) {
			actionAttrDesType
					.setDataType(aInternalObject.getActionAttributeDesignator().getDataType().getDatatypeURI());
		}

		retVal.setActionAttributeDesignator(actionAttrDesType);

		retVal.setMatchId(aInternalObject.getMatchFunction().getFunctionId());

		return retVal;
	}

}
