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

import javax.xml.namespace.QName;

import org.herasaf.xacml.core.dataTypeAttribute.impl.AnyURIDataTypeAttribute;
import org.herasaf.xacml.core.policy.impl.AttributeSelectorType;
import org.herasaf.xacml.core.policy.impl.ResourceAttributeDesignatorType;
import org.herasaf.xacml.core.policy.impl.ResourceMatchType;
import org.projecthusky.xua.core.SecurityObjectBuilder;
import org.projecthusky.xua.saml2.SimpleBuilder;
import org.opensaml.xacml.policy.impl.AttributeDesignatorTypeImplBuilder;
import org.opensaml.xacml.policy.impl.AttributeSelectorTypeImplBuilder;
import org.opensaml.xacml.policy.impl.ResourceMatchTypeImplBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for SubjectMatchType building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um SubjectMatchType bilden zu können.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class ResourceMatchBuilderImpl implements SimpleBuilder<ResourceMatchType>,
		SecurityObjectBuilder<org.opensaml.xacml.policy.ResourceMatchType, ResourceMatchType> {

	@Override
	public ResourceMatchType create(org.opensaml.xacml.policy.ResourceMatchType aInternalObject) {
		var retVal = new ResourceMatchType();

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

		if (aInternalObject.getResourceAttributeDesignator() != null) {
			var resourceAttrDesignator = new ResourceAttributeDesignatorType();
			resourceAttrDesignator.setAttributeId(aInternalObject.getResourceAttributeDesignator().getAttributeId());

			if (aInternalObject.getResourceAttributeDesignator().getIssuer() != null) {
				resourceAttrDesignator.setIssuer(aInternalObject.getResourceAttributeDesignator().getIssuer());
			}

			if (aInternalObject.getResourceAttributeDesignator().getDataType() != null) {
				resourceAttrDesignator.setDataType(new DataTypeAttributeBuilderImpl()
						.create(aInternalObject.getResourceAttributeDesignator().getDataType()));
			} else {
				resourceAttrDesignator.setDataType(new AnyURIDataTypeAttribute());
			}

			resourceAttrDesignator
					.setMustBePresent(aInternalObject.getResourceAttributeDesignator().getMustBePresent());
			retVal.setResourceAttributeDesignator(resourceAttrDesignator);
		}

		retVal.setMatchFunction(new FunctionBuilderImpl().create(aInternalObject.getMatchId()));

		return retVal;
	}

	@Override
	public ResourceMatchType create() {
		return new ResourceMatchType();
	}

	/**
	 * Method to create ResourceMatchType.
	 * 
	 * @param aInternalObject the ResourceMatchType
	 * @return the opensaml ResourceMatchType
	 */
	public org.opensaml.xacml.policy.ResourceMatchType create(ResourceMatchType aInternalObject) {
		var retVal = new ResourceMatchTypeImplBuilder().buildObject();

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

		if (aInternalObject.getResourceAttributeDesignator() != null) {
			var resourceAttrDesignator = new AttributeDesignatorTypeImplBuilder().buildObject(
					new QName("urn:oasis:names:tc:xacml:2.0:policy:schema:os", "ResourceAttributeDesignator"));
			resourceAttrDesignator.setAttributeId(aInternalObject.getResourceAttributeDesignator().getAttributeId());

			if (aInternalObject.getResourceAttributeDesignator().getIssuer() != null) {
				resourceAttrDesignator.setIssuer(aInternalObject.getResourceAttributeDesignator().getIssuer());
			}

			if (aInternalObject.getResourceAttributeDesignator().getDataType() != null) {
				resourceAttrDesignator.setDataType(new DataTypeAttributeBuilderImpl()
						.create(aInternalObject.getResourceAttributeDesignator().getDataType()));
			} else {
				resourceAttrDesignator.setDataType("http://www.w3.org/2001/XMLSchema#anyURI");
			}

			resourceAttrDesignator
					.setMustBePresent(aInternalObject.getResourceAttributeDesignator().isMustBePresent());
			retVal.setResourceAttributeDesignator(resourceAttrDesignator);
		}

		retVal.setMatchId(aInternalObject.getMatchFunction().getFunctionId());

		return retVal;
	}

}
