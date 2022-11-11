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

import java.util.Map.Entry;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.herasaf.xacml.core.policy.impl.AttributeValueType;
import org.projecthusky.xua.core.SecurityObjectBuilder;
import org.projecthusky.xua.hl7v3.OpenSamlInstanceIdentifier;
import org.projecthusky.xua.hl7v3.impl.InstanceIdentifierBuilder;
import org.projecthusky.xua.hl7v3.impl.InstanceIdentifierImpl;
import org.projecthusky.xua.saml2.SimpleBuilder;
import org.openehealth.ipf.commons.ihe.xacml20.stub.hl7v3.CV;
import org.openehealth.ipf.commons.ihe.xacml20.stub.hl7v3.II;
import org.opensaml.core.xml.schema.XSAny;
import org.opensaml.core.xml.schema.impl.XSAnyBuilder;
import org.opensaml.core.xml.schema.impl.XSAnyImpl;
import org.opensaml.xacml.policy.impl.AttributeValueTypeImplBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for AttributeValueType building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um AttributeValueType bilden zu können.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class AttributeValueTypeBuilderImpl implements SimpleBuilder<AttributeValueType>,
		SecurityObjectBuilder<org.opensaml.xacml.policy.AttributeValueType, AttributeValueType> {

	@Override
	public AttributeValueType create(org.opensaml.xacml.policy.AttributeValueType aInternalObject) {
		var attrValue = new org.herasaf.xacml.core.policy.impl.AttributeValueType();

		for (org.opensaml.core.xml.XMLObject object : aInternalObject.getUnknownXMLObjects()) {
			if (object instanceof XSAnyImpl anyImpl) {
				if ("CodedValue".equalsIgnoreCase(anyImpl.getElementQName().getLocalPart())) {
					attrValue.getContent()
							.add(new JAXBElement<>(anyImpl.getElementQName(), CV.class, getCVfromXsAnyImpl(anyImpl)));
				}
			} else if (object instanceof InstanceIdentifierImpl instanceIdent) {
				var instanceId = new II();
				instanceId.setExtension(instanceIdent.getExtension());
				instanceId.setRoot(instanceIdent.getRoot());
				attrValue.getContent().add(
						new JAXBElement<>(new QName("urn:hl7-org:v3", "InstanceIdentifier"), II.class, instanceId));
			}
		}

		if (aInternalObject.getValue() != null) {
			attrValue.getContent().add(aInternalObject.getValue());
		}

		if (aInternalObject.getDataType() != null) {
			attrValue.setDataType(new DataTypeAttributeBuilderImpl().create(aInternalObject.getDataType()));
		}

		return attrValue;
	}

	@Override
	public AttributeValueType create() {
		return new org.herasaf.xacml.core.policy.impl.AttributeValueType();
	}

	/**
	 * Method to create the AttributeValueType
	 * @param attributeValueInternalObj the AttributeValueType
	 * @return the AttributeValueType
	 */
	public org.opensaml.xacml.policy.AttributeValueType createAttrType(
			org.herasaf.xacml.core.policy.impl.AttributeValueType attributeValueInternalObj) {
		var attributeVal = new AttributeValueTypeImplBuilder().buildObject();

		if (attributeValueInternalObj.getContent() != null) {
			for (Object object : attributeValueInternalObj.getContent()) {
				if (object instanceof JAXBElement) {
					var jaxbElement = (JAXBElement<?>) object;
					if (jaxbElement.getValue() instanceof CV) {
						var cv = (CV) jaxbElement.getValue();

						XSAny any = new XSAnyBuilder().buildObject(new QName("urn:hl7-org:v3", "CodedValue"));
						any.getUnknownAttributes().put(new QName("code"), cv.getCode());
						any.getUnknownAttributes().put(new QName("codeSystem"), cv.getCodeSystem());
						any.getUnknownAttributes().put(new QName("displayName"), cv.getDisplayName());

						attributeVal.getUnknownXMLObjects().add(any);
					} else if (jaxbElement.getValue() instanceof II) {
						II id = (II) jaxbElement.getValue();
						OpenSamlInstanceIdentifier instanceIdent = new InstanceIdentifierBuilder().buildObject();
						instanceIdent.setExtension(id.getExtension());
						instanceIdent.setRoot(id.getRoot());
						attributeVal.getUnknownXMLObjects().add(instanceIdent);
					} else if (jaxbElement.getValue()instanceof AttributeValueType attributeValType) {
						attributeVal.setValue((String) attributeValType.getContent().get(0));
					}
				} else if (object instanceof String stringObj) {
					attributeVal.setValue(stringObj);
				}
			}

		}

		if (attributeValueInternalObj.getDataType() != null) {
			attributeVal
					.setDataType(new DataTypeAttributeBuilderImpl().create(attributeValueInternalObj.getDataType()));
		}

		return attributeVal;
	}

	/**
	 * Method to get the CV from XSAny
	 * @param anyImpl the XSAny
	 * @return tge CV
	 */
	public CV getCVfromXsAnyImpl(XSAnyImpl anyImpl) {
		var cv = new CV();

		for (Entry<QName, String> entry : anyImpl.getUnknownAttributes().entrySet()) {
			if (entry != null && entry.getKey() != null && "code".equalsIgnoreCase(entry.getKey().getLocalPart())) {
				cv.setCode(entry.getValue());
			} else if (entry != null && entry.getKey() != null
					&& "codeSystem".equalsIgnoreCase(entry.getKey().getLocalPart())) {
				cv.setCodeSystem(entry.getValue());
			}
		}

		return cv;
	}
}
