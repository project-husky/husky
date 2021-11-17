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

import java.util.Map.Entry;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.herasaf.xacml.core.policy.impl.AttributeSelectorType;
import org.herasaf.xacml.core.policy.impl.AttributeValueType;
import org.herasaf.xacml.core.policy.impl.SubjectAttributeDesignatorType;
import org.herasaf.xacml.core.policy.impl.SubjectMatchType;
import org.husky.xua.core.SecurityObjectBuilder;
import org.husky.xua.hl7v3.OpenSamlInstanceIdentifier;
import org.husky.xua.hl7v3.impl.InstanceIdentifierBuilder;
import org.husky.xua.hl7v3.impl.InstanceIdentifierImpl;
import org.husky.xua.saml2.SimpleBuilder;
import org.openehealth.ipf.commons.ihe.xacml20.stub.hl7v3.CV;
import org.openehealth.ipf.commons.ihe.xacml20.stub.hl7v3.II;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.schema.XSAny;
import org.opensaml.core.xml.schema.impl.XSAnyBuilder;
import org.opensaml.core.xml.schema.impl.XSAnyImpl;
import org.opensaml.xacml.policy.impl.AttributeSelectorTypeImplBuilder;
import org.opensaml.xacml.policy.impl.AttributeValueTypeImplBuilder;
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
			if (aInternalObject.getAttributeValue().getContent() != null) {
				if (retVal.getAttributeValue() == null) {
					var attributeVal = new AttributeValueTypeImplBuilder().buildObject();
					retVal.setAttributeValue(attributeVal);
				}

				for (Object object : aInternalObject.getAttributeValue().getContent()) {
					if(object instanceof JAXBElement) {
						var jaxbElement = (JAXBElement<?>) object;
						if (jaxbElement != null) {
							if (jaxbElement.getValue() instanceof CV) {
								var cv = (CV) jaxbElement.getValue();

								XSAny any = new XSAnyBuilder().buildObject(new QName("urn:hl7-org:v3", "CodedValue"));
								any.getUnknownAttributes().put(new QName("code"), cv.getCode());
								any.getUnknownAttributes().put(new QName("codeSystem"), cv.getCodeSystem());
								any.getUnknownAttributes().put(new QName("displayName"), cv.getDisplayName());

								retVal.getAttributeValue().getUnknownXMLObjects().add(any);
							} else if (jaxbElement.getValue() instanceof II) {
								II id = (II) jaxbElement.getValue();
								OpenSamlInstanceIdentifier instanceIdent = new InstanceIdentifierBuilder()
										.buildObject();
								instanceIdent.setExtension(id.getExtension());
								instanceIdent.setRoot(id.getRoot());
								retVal.getAttributeValue().getUnknownXMLObjects().add(instanceIdent);
							} else if (jaxbElement.getValue() instanceof AttributeValueType) {
								var attributeVal = (AttributeValueType) jaxbElement.getValue();
								var attVal = new AttributeValueTypeImplBuilder().buildObject();
								attVal.setValue((String) attributeVal.getContent().get(0));
								retVal.setAttributeValue(attVal);
							}
						}
					} else if (object instanceof String) {
						retVal.getAttributeValue().setValue((String) object);
					}
				}
			}

			if (aInternalObject.getAttributeValue().getDataType() != null) {
				retVal.getAttributeValue().setDataType(
						new DataTypeAttributeBuilderImpl().create(aInternalObject.getAttributeValue().getDataType()));
			}
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
