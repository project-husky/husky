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

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.ehealth_connector.xua.core.SecurityObjectBuilder;
import org.ehealth_connector.xua.hl7v3.impl.InstanceIdentifierImpl;
import org.ehealth_connector.xua.saml2.SimpleBuilder;
import org.herasaf.xacml.core.function.Function;
import org.herasaf.xacml.core.function.impl.bagFunctions.DateBagFunction;
import org.herasaf.xacml.core.function.impl.bagFunctions.DateBagSizeFunction;
import org.herasaf.xacml.core.function.impl.bagFunctions.DateIsInFunction;
import org.herasaf.xacml.core.function.impl.bagFunctions.DateOneAndOnlyFunction;
import org.herasaf.xacml.core.function.impl.dateAndTimeArithmeticFunctions.DateAddYearMonthDurationFunction;
import org.herasaf.xacml.core.function.impl.dateAndTimeArithmeticFunctions.DateSubtractYearMonthDurationFunction;
import org.herasaf.xacml.core.function.impl.equalityPredicates.DateEqualFunction;
import org.herasaf.xacml.core.function.impl.equalityPredicates.StringEqualFunction;
import org.herasaf.xacml.core.function.impl.nonNumericComparisonFunctions.DateGreaterThanFunction;
import org.herasaf.xacml.core.function.impl.nonNumericComparisonFunctions.DateGreaterThanOrEqualFunction;
import org.herasaf.xacml.core.function.impl.nonNumericComparisonFunctions.DateLessThanFunction;
import org.herasaf.xacml.core.function.impl.nonNumericComparisonFunctions.DateLessThanOrEqualFunction;
import org.herasaf.xacml.core.function.impl.setFunction.DateAtLeastOneMemberOfFunction;
import org.herasaf.xacml.core.function.impl.setFunction.DateIntersectionFunction;
import org.herasaf.xacml.core.function.impl.setFunction.DateSetEqualsFunction;
import org.herasaf.xacml.core.function.impl.setFunction.DateSubsetFunction;
import org.herasaf.xacml.core.function.impl.setFunction.DateUnionFunction;
import org.herasaf.xacml.core.policy.impl.AttributeSelectorType;
import org.herasaf.xacml.core.policy.impl.AttributeValueType;
import org.herasaf.xacml.core.policy.impl.SubjectAttributeDesignatorType;
import org.herasaf.xacml.core.policy.impl.SubjectMatchType;
import org.openehealth.ipf.commons.ihe.xacml20.herasaf.functions.CvEqualFunction;
import org.openehealth.ipf.commons.ihe.xacml20.herasaf.functions.IiEqualFunction;
import org.openehealth.ipf.commons.ihe.xacml20.stub.hl7v3.II;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.schema.impl.XSAnyImpl;
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

	private org.opensaml.xacml.policy.SubjectMatchType wrappedObject;

	public SubjectMatchBuilderImpl() {
		wrappedObject = new SubjectMatchTypeImplBuilder().buildObject();
	}

	@Override
	public SubjectMatchType create(org.opensaml.xacml.policy.SubjectMatchType aInternalObject) {
		wrappedObject = aInternalObject;
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
			var attrValue = new AttributeValueType();

			if (aInternalObject.getAttributeValue().getUnknownXMLObjects() != null) {
				for (XMLObject object : aInternalObject.getAttributeValue().getUnknownXMLObjects()) {
					if (object instanceof XSAnyImpl) {
						XSAnyImpl anyImpl = (XSAnyImpl) object;

						if (anyImpl.getElementQName() != null) {
							attrValue.getContent()
									.add(new JAXBElement<>(anyImpl.getElementQName(), XSAnyImpl.class, anyImpl));
						}
					} else if (object instanceof InstanceIdentifierImpl) {
						InstanceIdentifierImpl instanceIdent = (InstanceIdentifierImpl) object;

						var instanceId = new II();
						instanceId.setExtension(instanceIdent.getExtension());
						instanceId.setRoot(instanceIdent.getRoot());
						attrValue.getContent().add(new JAXBElement<>(new QName("urn:hl7-org:v3", "InstanceIdentifier"),
								II.class, instanceId));
					}
				}
			}

			if (aInternalObject.getAttributeValue().getValue() != null) {
				attrValue.getContent().add(aInternalObject.getAttributeValue().getValue());
			}

			retVal.setAttributeValue(attrValue);
		}

		if (aInternalObject.getSubjectAttributeDesignator() != null) {
			var subjectAttrDesignator = new SubjectAttributeDesignatorType();
			subjectAttrDesignator.setAttributeId(aInternalObject.getSubjectAttributeDesignator().getAttributeId());
			subjectAttrDesignator.setIssuer(aInternalObject.getSubjectAttributeDesignator().getIssuer());
			subjectAttrDesignator.setMustBePresent(aInternalObject.getSubjectAttributeDesignator().getMustBePresent());
			retVal.setSubjectAttributeDesignator(subjectAttrDesignator);
		}
		
		Function function = null;
		if ("urn:hl7-org:v3:function:CV-equal".equalsIgnoreCase(aInternalObject.getMatchId())) {
			function = new CvEqualFunction();
		} else if ("urn:hl7-org:v3:function:II-equal".equalsIgnoreCase(aInternalObject.getMatchId())) {
			function = new IiEqualFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:string-equal"
				.equalsIgnoreCase(aInternalObject.getMatchId())) {
			function = new StringEqualFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:date-equal".equalsIgnoreCase(aInternalObject.getMatchId())) {
			function = new DateEqualFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:date-greater-than"
				.equalsIgnoreCase(aInternalObject.getMatchId())) {
			function = new DateGreaterThanFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:date-at-least-one-member-of"
				.equalsIgnoreCase(aInternalObject.getMatchId())) {
			function = new DateAtLeastOneMemberOfFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:date-bag".equalsIgnoreCase(aInternalObject.getMatchId())) {
			function = new DateBagFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:date-bag-size"
				.equalsIgnoreCase(aInternalObject.getMatchId())) {
			function = new DateBagSizeFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:date-greater-than-or-equal"
				.equalsIgnoreCase(aInternalObject.getMatchId())) {
			function = new DateGreaterThanOrEqualFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:date-intersection"
				.equalsIgnoreCase(aInternalObject.getMatchId())) {
			function = new DateIntersectionFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:date-is-in".equalsIgnoreCase(aInternalObject.getMatchId())) {
			function = new DateIsInFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:date-less-than"
				.equalsIgnoreCase(aInternalObject.getMatchId())) {
			function = new DateLessThanFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:date-less-than-or-equal"
				.equalsIgnoreCase(aInternalObject.getMatchId())) {
			function = new DateLessThanOrEqualFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:date-one-and-only"
				.equalsIgnoreCase(aInternalObject.getMatchId())) {
			function = new DateOneAndOnlyFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:date-set-equals"
				.equalsIgnoreCase(aInternalObject.getMatchId())) {
			function = new DateSetEqualsFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:date-subset".equalsIgnoreCase(aInternalObject.getMatchId())) {
			function = new DateSubsetFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:date-union".equalsIgnoreCase(aInternalObject.getMatchId())) {
			function = new DateUnionFunction();
		} else if ("urn:oasis:names:tc:xacml:3.0:function:date-add-yearMonthDuration"
				.equalsIgnoreCase(aInternalObject.getMatchId())) {
			function = new DateAddYearMonthDurationFunction();
		} else if ("urn:oasis:names:tc:xacml:3.0:function:date-subtract-yearMonthDuration"
				.equalsIgnoreCase(aInternalObject.getMatchId())) {
			function = new DateSubtractYearMonthDurationFunction();
		}
		
		retVal.setMatchFunction(function);

		return retVal;
	}

	@Override
	public SubjectMatchType create() {
		return new SubjectMatchType();
	}

}
