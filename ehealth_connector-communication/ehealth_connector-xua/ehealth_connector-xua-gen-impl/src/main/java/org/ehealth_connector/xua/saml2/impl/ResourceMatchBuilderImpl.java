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

import java.util.Map.Entry;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.ehealth_connector.xua.core.SecurityObjectBuilder;
import org.ehealth_connector.xua.hl7v3.impl.InstanceIdentifierImpl;
import org.ehealth_connector.xua.saml2.SimpleBuilder;
import org.herasaf.xacml.core.policy.impl.AttributeSelectorType;
import org.herasaf.xacml.core.policy.impl.AttributeValueType;
import org.herasaf.xacml.core.policy.impl.ResourceAttributeDesignatorType;
import org.herasaf.xacml.core.policy.impl.ResourceMatchType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.hl7v3.CV;
import org.openehealth.ipf.commons.ihe.xacml20.stub.hl7v3.II;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.schema.impl.XSAnyImpl;

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
			var attrValue = new AttributeValueType();

			if (aInternalObject.getAttributeValue().getUnknownXMLObjects() != null) {
				for (XMLObject object : aInternalObject.getAttributeValue().getUnknownXMLObjects()) {
					if (object instanceof XSAnyImpl) {
						XSAnyImpl anyImpl = (XSAnyImpl) object;

						if (anyImpl.getElementQName() != null
								&& "CodedValue".equalsIgnoreCase(anyImpl.getElementQName().getLocalPart())) {
							var cv = new CV();

							for (Entry<QName, String> entry : anyImpl.getUnknownAttributes().entrySet()) {
								if (entry != null && entry.getKey() != null
										&& "code".equalsIgnoreCase(entry.getKey().getLocalPart())) {
									cv.setCode(entry.getValue());
								} else if (entry != null && entry.getKey() != null
										&& "codeSystem".equalsIgnoreCase(entry.getKey().getLocalPart())) {
									cv.setCodeSystem(entry.getValue());
								}
							}

							attrValue.getContent()
									.add(new JAXBElement<>(anyImpl.getElementQName(), CV.class, cv));
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

			if (aInternalObject.getAttributeValue().getDataType() != null) {
				attrValue.setDataType(new DataTypeAttributeBuilderImpl()
						.create(aInternalObject.getAttributeValue().getDataType()));
			}

			retVal.setAttributeValue(attrValue);
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

}
