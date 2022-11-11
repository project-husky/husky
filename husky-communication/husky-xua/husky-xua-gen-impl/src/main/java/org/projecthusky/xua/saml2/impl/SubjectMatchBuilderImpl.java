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

import org.herasaf.xacml.core.policy.impl.AttributeSelectorType;
import org.herasaf.xacml.core.policy.impl.SubjectAttributeDesignatorType;
import org.herasaf.xacml.core.policy.impl.SubjectMatchType;
import org.projecthusky.xua.core.SecurityObjectBuilder;
import org.projecthusky.xua.saml2.SimpleBuilder;
import org.opensaml.xacml.policy.impl.AttributeSelectorTypeImplBuilder;
import org.opensaml.xacml.policy.impl.SubjectAttributeDesignatorTypeImplBuilder;
import org.opensaml.xacml.policy.impl.SubjectMatchTypeImplBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for SubjectMatchType building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um SubjectMatchType bilden zu können.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class SubjectMatchBuilderImpl
		implements SimpleBuilder<SubjectMatchType>,
		SecurityObjectBuilder<org.opensaml.xacml.policy.SubjectMatchType, SubjectMatchType> {

	@Override
	public SubjectMatchType create(org.opensaml.xacml.policy.SubjectMatchType aInternalObject) {
		var retVal = new SubjectMatchType();
		
		if (aInternalObject.getAttributeSelector() != null) {
			var attrSelectorType = new AttributeSelectorType();

			if (aInternalObject.getAttributeSelector().getDataType() != null) {
				attrSelectorType.setDataType(aInternalObject.getAttributeSelector().getDataType());
			}

			attrSelectorType.setMustBePresent(aInternalObject.getAttributeSelector().getMustBePresent());
			attrSelectorType.setRequestContextPath(aInternalObject.getAttributeSelector().getRequestContextPath());
			retVal.setAttributeSelector(attrSelectorType);
		}

		
		if (aInternalObject.getAttributeValue() != null) {
			retVal.setAttributeValue(new AttributeValueTypeBuilderImpl().create(aInternalObject.getAttributeValue()));
		}

		if (aInternalObject.getSubjectAttributeDesignator() != null) {
			var subjectAttrDesignator = new SubjectAttributeDesignatorType();
			subjectAttrDesignator.setAttributeId(aInternalObject.getSubjectAttributeDesignator().getAttributeId());

			if (aInternalObject.getSubjectAttributeDesignator().getIssuer() != null) {
				subjectAttrDesignator.setIssuer(aInternalObject.getSubjectAttributeDesignator().getIssuer());
			}

			if (aInternalObject.getSubjectAttributeDesignator().getDataType() != null) {
				subjectAttrDesignator.setDataType(new DataTypeAttributeBuilderImpl()
						.create(aInternalObject.getSubjectAttributeDesignator().getDataType()));
			}

			subjectAttrDesignator.setMustBePresent(aInternalObject.getSubjectAttributeDesignator().getMustBePresent());
			retVal.setSubjectAttributeDesignator(subjectAttrDesignator);
		}
		
		retVal.setMatchFunction(new FunctionBuilderImpl().create(aInternalObject.getMatchId()));

		return retVal;
	}

	@Override
	public SubjectMatchType create() {
		return new SubjectMatchType();
	}

	/**
	 * Method to create SubjectMatchType.
	 * 
	 * @param aInternalObject the SubjectMatchType
	 * @return the opensaml SubjectMatchType
	 */
	public org.opensaml.xacml.policy.SubjectMatchType create(SubjectMatchType aInternalObject) {
		var retVal = new SubjectMatchTypeImplBuilder().buildObject();

		if (aInternalObject.getAttributeSelector() != null) {
			var attrSelectorType = new AttributeSelectorTypeImplBuilder().buildObject();

			if (aInternalObject.getAttributeSelector().getDataType() != null) {
				attrSelectorType.setDataType(aInternalObject.getAttributeSelector().getDataType());
			}

			attrSelectorType.setMustBePresent(aInternalObject.getAttributeSelector().isMustBePresent());
			attrSelectorType.setRequestContextPath(aInternalObject.getAttributeSelector().getRequestContextPath());
			retVal.setAttributeSelector(attrSelectorType);
		}

		if (aInternalObject.getAttributeValue() != null) {
			retVal.setAttributeValue(
					new AttributeValueTypeBuilderImpl().createAttrType(aInternalObject.getAttributeValue()));
		}

		if (aInternalObject.getSubjectAttributeDesignator() != null) {
			var subjectAttrDesignator = new SubjectAttributeDesignatorTypeImplBuilder().buildObject();
			subjectAttrDesignator.setAttributeId(aInternalObject.getSubjectAttributeDesignator().getAttributeId());

			if (aInternalObject.getSubjectAttributeDesignator().getIssuer() != null) {
				subjectAttrDesignator.setIssuer(aInternalObject.getSubjectAttributeDesignator().getIssuer());
			}

			if (aInternalObject.getSubjectAttributeDesignator().getDataType() != null) {
				subjectAttrDesignator.setDataType(new DataTypeAttributeBuilderImpl()
						.create(aInternalObject.getSubjectAttributeDesignator().getDataType()));
			}

			subjectAttrDesignator.setMustBePresent(aInternalObject.getSubjectAttributeDesignator().isMustBePresent());
			retVal.setSubjectAttributeDesignator(subjectAttrDesignator);
		}

		retVal.setMatchId(aInternalObject.getMatchFunction().getFunctionId());

		return retVal;
	}

}
