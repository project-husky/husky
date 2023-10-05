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
package org.projecthusky.common.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.apache.commons.lang3.NotImplementedException;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.XpnName;
import org.projecthusky.common.basetypes.NameBaseType;
import org.projecthusky.common.enums.EntityNameUse;
import org.projecthusky.common.enums.NullFlavor;
import org.projecthusky.common.hl7cdar2.EN;
import org.projecthusky.common.hl7cdar2.EnDelimiter;
import org.projecthusky.common.hl7cdar2.EnFamily;
import org.projecthusky.common.hl7cdar2.EnGiven;
import org.projecthusky.common.hl7cdar2.EnPrefix;
import org.projecthusky.common.hl7cdar2.EnSuffix;
import org.projecthusky.common.hl7cdar2.PN;

/**
 * The class Name contains all fields for different name parts such as given or
 * family. This class also provides mapping methods to other data types.
 */
public class Name extends NameBaseType {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1233422782853908534L;

	private static final String ELEMENT_NAME_NAMESPACE_DELIMITER = "delimiter";
	private static final String ELEMENT_NAME_NAMESPACE_FAMILY = "family";
	private static final String ELEMENT_NAME_NAMESPACE_GIVEN = "given";
	private static final String ELEMENT_NAME_NAMESPACE_SUFFIX = "suffix";
	private static final String ELEMENT_NAME_NAMESPACE_PREFIX = "prefix";
	private static final String HL7_NAMESPACE = "urn:hl7-org:v3";

	/**
	 * Instantiates a new instance. Default constructor.
	 */
	public Name() {
	}

	/**
	 * Instantiates a new instance from the given base type.
	 *
	 * @param baseType the base type
	 */
	public Name(NameBaseType baseType) {
		initFromBaseType(baseType);
	}

	/**
	 * Instantiates a new instance from the given HL7 CDA R2 data type.
	 *
	 * @param hl7CdaR2Value the HL7 CDA R2 data type
	 */
	public Name(org.projecthusky.common.hl7cdar2.EN hl7CdaR2Value) {
		initFromHl7CdaR2(hl7CdaR2Value);
	}

	/**
	 * Instantiates a new instance from the given HL7 CDA R2 data type.
	 *
	 * @param hl7CdaR2Value the HL7 CDA R2 data type
	 */
	public Name(org.projecthusky.common.hl7cdar2.ON hl7CdaR2Value) {
		initFromHl7CdaR2(hl7CdaR2Value);
	}

	/**
	 * Instantiates a new instance from the given HL7 CDA R2 data type.
	 *
	 * @param hl7CdaR2Value the HL7 CDA R2 data type
	 */
	public Name(org.projecthusky.common.hl7cdar2.PN hl7CdaR2Value) {
		initFromHl7CdaR2(hl7CdaR2Value);
	}

	/**
	 * Instantiates a new instance from the given IPF name type.
	 *
	 * @param ipfName the ipf name
	 */
	public Name(org.openehealth.ipf.commons.ihe.xds.core.metadata.Name<?> ipfName) {
		initFromIpfType(ipfName);
	}

	/**
	 * Instantiates a new instance from the given name.
	 *
	 * @param name the name
	 */
	public Name(String name) {
		setName(name);
	}

	/**
	 * Creates the HL7 CDA R2 data type from the given base type.
	 *
	 * @param baseType the base type
	 * @return the HL7 CDA R2 data typed value
	 */
	public static org.projecthusky.common.hl7cdar2.EN createHl7CdaR2En(NameBaseType baseType) {
		org.projecthusky.common.hl7cdar2.EN retVal = null;

		if (baseType != null) {
			retVal = new org.projecthusky.common.hl7cdar2.EN();
			createName(retVal, baseType);

		}

		return retVal;
	}

	/**
	 * Creates the HL7 CDA R2 data type from the given base type.
	 *
	 * @param baseType the base type
	 * @return the HL7 CDA R2 data typed value
	 */
	public static org.projecthusky.common.hl7cdar2.ON createHl7CdaR2On(NameBaseType baseType) {
		org.projecthusky.common.hl7cdar2.ON retVal = null;

		if (baseType != null) {
			retVal = new org.projecthusky.common.hl7cdar2.ON();
			createName(retVal, baseType);

			EntityNameUse usage = baseType.getUsage();
			if (usage != null) {
				retVal.getUse().clear();
				retVal.getUse().add(usage.getCode().getCode());
			}
		}

		return retVal;
	}

	/**
	 * Creates the HL7 CDA R2 data type from the given base type.
	 *
	 * @param baseType the base type
	 * @return the HL7 CDA R2 data typed value
	 */
	public static org.projecthusky.common.hl7cdar2.PN createHl7CdaR2Pn(NameBaseType baseType) {
		org.projecthusky.common.hl7cdar2.PN retVal = null;

		if (baseType != null) {
			retVal = new org.projecthusky.common.hl7cdar2.PN();
			createName(retVal, baseType);

			EntityNameUse usage = baseType.getUsage();
			if (usage != null) {
				retVal.getUse().clear();
				retVal.getUse().add(usage.getCode().getCode());
			}
		}

		return retVal;
	}

	/**
	 * Creates the HL7 CDA R2 data type from the given base type.
	 *
	 * @param baseType the base type
	 * @return the HL7 CDA R2 data typed value
	 */
	public static org.projecthusky.common.hl7cdar2.TN createHl7CdaR2Tn(NameBaseType baseType) {
		org.projecthusky.common.hl7cdar2.TN retVal = null;

		if (baseType != null) {
			retVal = new org.projecthusky.common.hl7cdar2.TN();
			createName(retVal, baseType);
		}

		return retVal;
	}

	private static void createName(EN retVal, NameBaseType baseType) {
		var nf = baseType.getNullFlavor();
		if (nf != null) {
			if (retVal.nullFlavor == null)
				retVal.nullFlavor = new ArrayList<String>();
			retVal.nullFlavor.add(nf.getCodeValue());
		}

		List<Serializable> content = createNameContent(baseType);

		String value = baseType.getName();
		if (value != null && content.isEmpty()) {
			retVal.setXmlMixed(value);
		} else {
			retVal.getContent().addAll(content);
		}
	}

	private static List<Serializable> createNameContent(NameBaseType baseType) {
		List<Serializable> content = new ArrayList<>();

		String value;

		value = baseType.getDelimiter();
		if (value != null) {
			var obj = new EnDelimiter();
			obj.setXmlMixed(value);
			content.add(
					new JAXBElement<EnDelimiter>(new QName(HL7_NAMESPACE, ELEMENT_NAME_NAMESPACE_DELIMITER, ""),
							EnDelimiter.class, obj));
		}

		value = baseType.getFamily();
		if (value != null) {
			var obj = new EnFamily();
			obj.setXmlMixed(value);
			content.add(new JAXBElement<EnFamily>(new QName(HL7_NAMESPACE, ELEMENT_NAME_NAMESPACE_FAMILY, ""),
					EnFamily.class, obj));
		}

		value = baseType.getGiven();
		if (value != null) {
			var obj = new EnGiven();
			obj.setXmlMixed(value);
			content.add(new JAXBElement<EnGiven>(new QName(HL7_NAMESPACE, ELEMENT_NAME_NAMESPACE_GIVEN, ""),
					EnGiven.class, obj));
		}

		value = baseType.getPrefix();
		if (value != null) {
			var obj = new EnPrefix();
			obj.setXmlMixed(value);
			// Note: This need probably to become more dynamic. Feel free to
			// contribute.
			obj.getQualifier().add("AC");
			content.add(new JAXBElement<EnPrefix>(new QName(HL7_NAMESPACE, ELEMENT_NAME_NAMESPACE_PREFIX, ""),
					EnPrefix.class, obj));
		}

		value = baseType.getSuffix();
		if (value != null) {
			var obj = new EnSuffix();
			obj.setXmlMixed(value);
			content.add(new JAXBElement<EnSuffix>(new QName(HL7_NAMESPACE, ELEMENT_NAME_NAMESPACE_SUFFIX, ""),
					EnSuffix.class, obj));
		}

		return content;
	}

	/**
	 * Creates the base type from the given HL7 CDA R2 value.
	 *
	 * @param hl7CdaR2Value the HL7 CDA R2 value
	 * @return the base type
	 */
	public static NameBaseType createNameBaseType(org.projecthusky.common.hl7cdar2.EN hl7CdaR2Value) {

		var retVal = new NameBaseType();

		if (hl7CdaR2Value != null) {
			String nullFlavor = null;
			if (hl7CdaR2Value.nullFlavor != null && !hl7CdaR2Value.nullFlavor.isEmpty())
				nullFlavor = hl7CdaR2Value.nullFlavor.get(0);
			if (nullFlavor != null)
				retVal.setNullFlavor(NullFlavor.getEnum(nullFlavor));

			if (!hl7CdaR2Value.getUse().isEmpty())
				retVal.setUsage(EntityNameUse.getEnum(hl7CdaR2Value.getUse().get(0)));

			if (!hl7CdaR2Value.getContent().isEmpty()) {
				extractNameFieldsFromContent(retVal, hl7CdaR2Value);
			} else
				retVal.setName(hl7CdaR2Value.getMergedXmlMixed());
		} else
			retVal.setNullFlavor(NullFlavor.NOT_AVAILABLE_L2);

		return retVal;
	}

	private static void extractNameFieldsFromContent(NameBaseType retVal, EN hl7CdaR2Value) {
		for (Serializable element : hl7CdaR2Value.getContent()) {
			if (element instanceof JAXBElement) {
				JAXBElement<?> elem = (JAXBElement<?>) element;
				if (elem.getValue()instanceof EnDelimiter obj) {
					retVal.setDelimiter(obj.getTextContent());
				} else if (elem.getValue()instanceof EnFamily obj) {
					retVal.setFamily(obj.getTextContent());
				} else if (elem.getValue()instanceof EnGiven obj) {
					retVal.setGiven(obj.getTextContent());
				} else if (elem.getValue()instanceof EnPrefix obj) {
					retVal.setPrefix(obj.getTextContent());
				} else if (elem.getValue()instanceof EnSuffix obj) {
					retVal.setSuffix(obj.getTextContent());
				} else
					throw new NotImplementedException(elem.getValue().getClass().getName());
			}
		}
	}

	public static XpnName getIpfXpnName(PN hl7CdaR2Value) {
		var nameBase = createNameBaseType(hl7CdaR2Value);
		return new XpnName(nameBase.getFamily(), nameBase.getGiven(), null, nameBase.getSuffix(), nameBase.getPrefix(),
				null);
	}

	/**
	 * Gets the HL7 CDA R2 data type from the current instance.
	 *
	 * @return the HL7 CDA R2 data type
	 */
	public org.projecthusky.common.hl7cdar2.EN getHl7CdaR2En() {
		return createHl7CdaR2En(this);
	}

	/**
	 * Gets the HL7 CDA R2 data type from the current instance.
	 *
	 * @return the HL7 CDA R2 data type
	 */
	public org.projecthusky.common.hl7cdar2.PN getHl7CdaR2Pn() {
		return createHl7CdaR2Pn(this);
	}

	/**
	 * Gets the HL7 CDA R2 data type from the current instance.
	 *
	 * @return the HL7 CDA R2 data type
	 */
	public org.projecthusky.common.hl7cdar2.TN getHl7CdaR2Tn() {
		return createHl7CdaR2Tn(this);
	}

	/**
	 * Inits from the base type.
	 *
	 * @param baseType the base type
	 */
	private void initFromBaseType(NameBaseType baseType) {
		if (baseType != null) {
			setDelimiter(baseType.getDelimiter());
			setFamily(baseType.getFamily());
			setGiven(baseType.getGiven());
			setPrefix(baseType.getPrefix());
			setSuffix(baseType.getSuffix());
			setName(baseType.getName());
			if (baseType.getUsage() != null)
				setUsage(baseType.getUsage());
			else
				setUsage(EntityNameUse.LEGAL);
			setNullFlavor(baseType.getNullFlavor());
		} else
			setNullFlavor(NullFlavor.NOT_AVAILABLE_L2);
	}

	/**
	 * Inits from the ipf type.
	 *
	 * @param ipfType the ipf type
	 */
	private void initFromIpfType(org.openehealth.ipf.commons.ihe.xds.core.metadata.Name<?> ipfType) {
		if (ipfType != null) {
			setFamily(ipfType.getFamilyName());
			setGiven(ipfType.getGivenName());
			setPrefix(ipfType.getPrefix());
			setSuffix(ipfType.getSuffix());
		} else
			setNullFlavor(NullFlavor.NOT_AVAILABLE_L2);
	}

	/**
	 * Inits the from HL7 CDA R2 data type.
	 *
	 * @param hl7CdaR2Value the HL7 CDA R2 data type value
	 */
	private void initFromHl7CdaR2(org.projecthusky.common.hl7cdar2.EN hl7CdaR2Value) {
		initFromBaseType(createNameBaseType(hl7CdaR2Value));
	}

	/**
	 * Sets the fields of the current instance by the given base type.
	 *
	 * @param baseType the base type
	 */
	public void set(NameBaseType baseType) {
		initFromBaseType(baseType);
	}

	/**
	 * Sets the fields of the current instance by the given HL7 CDA R2 data type.
	 *
	 * @param hl7CdaR2Value the HL7 CDA R2 data typed value
	 */
	public void set(org.projecthusky.common.hl7cdar2.EN hl7CdaR2Value) {
		initFromHl7CdaR2(hl7CdaR2Value);
	}

}
