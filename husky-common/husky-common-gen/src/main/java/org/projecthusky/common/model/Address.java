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

import org.apache.commons.lang3.NotImplementedException;
import org.projecthusky.common.basetypes.AddressBaseType;
import org.projecthusky.common.enums.NullFlavor;
import org.projecthusky.common.enums.PostalAddressUse;
import org.projecthusky.common.hl7cdar2.*;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The class Address contains all necessary fields for a postal address. This class also provides mapping methods to
 * other data types.
 */
public class Address extends AddressBaseType {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8984600430220953028L;

	private static final String HL7_NAMESPACE = "urn:hl7-org:v3";

	/**
	 * Instantiates a new instance from the given base type.
	 *
	 * @param baseType the base type
	 */
	public Address(AddressBaseType baseType) {
		initFromBaseType(baseType);
	}

	 /**
     * Instantiates a new instance from the given HL7 CDA R2 data type.
     *
     * @param hl7CdaR2Value the HL7 CDA R2 data type
     */
	public Address(org.projecthusky.common.hl7cdar2.AD hl7CdaR2Value) {
		initFromHl7CdaR2(hl7CdaR2Value);
	}

	/**
	 * Creates the base type from the given HL7 CDA R2 value.
	 *
	 * @param hl7CdaR2Value the HL7 CDA R2 value
	 * @return the base type
	 */
	public static AddressBaseType createAddressBaseType(
			org.projecthusky.common.hl7cdar2.AD hl7CdaR2Value) {
		AddressBaseType retVal = new AddressBaseType();

		if (hl7CdaR2Value != null) {
			String nullFlavor = null;
			if (hl7CdaR2Value.nullFlavor != null && !hl7CdaR2Value.nullFlavor.isEmpty())
					nullFlavor = hl7CdaR2Value.nullFlavor.get(0);
			if (nullFlavor != null)
				retVal.setNullFlavor(NullFlavor.getEnum(nullFlavor));

			if (!hl7CdaR2Value.getUse().isEmpty())
				retVal.setUsage(PostalAddressUse.getEnum(hl7CdaR2Value.getUse().get(0)));

			for (Serializable element : hl7CdaR2Value.getContent()) {
				if (element instanceof JAXBElement) {
					JAXBElement<?> elem = (JAXBElement<?>) element;
					extractAddressFieldsFromContent(retVal, elem.getValue());
				}
			}
		} else
			retVal.setNullFlavor(NullFlavor.NOT_AVAILABLE_L2);

		return retVal;
	}

	private static void extractAddressFieldsFromContent(AddressBaseType retVal, Object value) {
		if (value instanceof AdxpAdditionalLocator obj) {
			retVal.setAdditionalLocator(obj.getTextContent());
		} else if (value instanceof AdxpStreetName obj) {
			retVal.setStreetName(obj.getTextContent());
		} else if (value instanceof AdxpHouseNumber obj) {
			retVal.setBuildingNumber(obj.getTextContent());
		} else if (value instanceof AdxpPostBox obj) {
			retVal.setPostBox(obj.getTextContent());
		} else if (value instanceof AdxpPostalCode obj) {
			retVal.setPostalCode(obj.getTextContent());
		} else if (value instanceof AdxpCity obj) {
			retVal.setCity(obj.getTextContent());
		} else if (value instanceof AdxpState obj) {
			retVal.setState(obj.getTextContent());
		} else if (value instanceof AdxpCountry obj) {
			retVal.setCountry(obj.getTextContent());
		} else if (value instanceof AdxpStreetAddressLine obj) {
			if (retVal.getStreetAddressLine1() == null) {
				retVal.setStreetAddressLine1(obj.getTextContent());
			} else if (retVal.getStreetAddressLine2() == null) {
				retVal.setStreetAddressLine2(obj.getTextContent());
			}
		} else
			throw new NotImplementedException(value.getClass().getName());
	}

	/**
	 * Creates the HL7 CDA R2 data type from the given base type.
	 *
	 * @param baseType the base type
	 * @return the HL7 CDA R2 data typed value
	 */
	public static org.projecthusky.common.hl7cdar2.AD createHl7CdaR2Ad(
			AddressBaseType baseType) {

		org.projecthusky.common.hl7cdar2.AD retVal = null;

		if (baseType != null) {
			retVal = new org.projecthusky.common.hl7cdar2.AD();
			createAddress(retVal, baseType);
		}

		return retVal;

	}

	private static void createAddress(AD retVal, AddressBaseType baseType) {
		NullFlavor nf = baseType.getNullFlavor();
		if (nf != null) {
			if (retVal.nullFlavor == null)
				retVal.nullFlavor = new ArrayList<String>();
			retVal.nullFlavor.add(nf.getCodeValue());
		}

		retVal.getContent().addAll(createAddressContent(baseType));

		PostalAddressUse usage = baseType.getUsage();
		if (usage != null) {
			retVal.getUse().clear();
			retVal.getUse().add(usage.getCode().getCode());
		}
	}

	private static List<Serializable> createAddressContent(AddressBaseType baseType) {
		List<Serializable> content = new ArrayList<>();

		String value = baseType.getAdditionalLocator();
		if (value != null) {
			AdxpAdditionalLocator obj = new AdxpAdditionalLocator();
			obj.setXmlMixed(value);
			content.add(new JAXBElement<AdxpAdditionalLocator>(
					new QName(HL7_NAMESPACE, "additionalLocator"), AdxpAdditionalLocator.class, obj));
		}

		value = baseType.getBuildingNumber();
		if (value != null) {
			AdxpHouseNumber obj = new AdxpHouseNumber();
			obj.setXmlMixed(value);
			content.add(new JAXBElement<AdxpHouseNumber>(new QName(HL7_NAMESPACE, "houseNumber"),
					AdxpHouseNumber.class, obj));
		}

		value = baseType.getCity();
		if (value != null) {
			AdxpCity obj = new AdxpCity();
			obj.setXmlMixed(value);
			content.add(new JAXBElement<AdxpCity>(new QName(HL7_NAMESPACE, "city"), AdxpCity.class, obj));
		}

		value = baseType.getCountry();
		if (value != null) {
			AdxpCountry obj = new AdxpCountry();
			obj.setXmlMixed(value);
			content
					.add(new JAXBElement<AdxpCountry>(new QName(HL7_NAMESPACE, "country"), AdxpCountry.class, obj));
		}

		value = baseType.getPostalCode();
		if (value != null) {
			AdxpPostalCode obj = new AdxpPostalCode();
			obj.setXmlMixed(value);
			content.add(
					new JAXBElement<AdxpPostalCode>(new QName(HL7_NAMESPACE, "postalCode"), AdxpPostalCode.class, obj));
		}

		value = baseType.getPostBox();
		if (value != null) {
			AdxpPostBox obj = new AdxpPostBox();
			obj.setXmlMixed(value);
			content
					.add(new JAXBElement<AdxpPostBox>(new QName(HL7_NAMESPACE, "postBox"), AdxpPostBox.class, obj));
		}

		value = baseType.getState();
		if (value != null) {
			AdxpState obj = new AdxpState();
			obj.setXmlMixed(value);
			content
					.add(new JAXBElement<AdxpState>(new QName(HL7_NAMESPACE, "state"), AdxpState.class, obj));
		}

		value = baseType.getStreetAddressLine1();
		if (value != null) {
			AdxpStreetAddressLine obj = new AdxpStreetAddressLine();
			obj.setXmlMixed(value);
			content.add(new JAXBElement<AdxpStreetAddressLine>(
					new QName(HL7_NAMESPACE, "streetAddressLine"), AdxpStreetAddressLine.class, obj));
		}

		value = baseType.getStreetAddressLine2();
		if (value != null) {
			AdxpStreetAddressLine obj = new AdxpStreetAddressLine();
			obj.setXmlMixed(value);
			content.add(new JAXBElement<AdxpStreetAddressLine>(
					new QName(HL7_NAMESPACE, "streetAddressLine"), AdxpStreetAddressLine.class, obj));
		}

		value = baseType.getStreetName();
		if (value != null) {
			AdxpStreetName obj = new AdxpStreetName();
			obj.setXmlMixed(value);
			content.add(
					new JAXBElement<AdxpStreetName>(new QName(HL7_NAMESPACE, "streetName"), AdxpStreetName.class, obj));
		}

		return content;
	}



	/**
	 * Gets the HL7 CDA R2 data type from the current instance.
	 *
	 * @return the HL7 CDA R2 data type
	 */
	public org.projecthusky.common.hl7cdar2.AD getHl7CdaR2Ad() {
		return createHl7CdaR2Ad(this);
	}

	/**
	 * Inits from the base type.
	 *
	 * @param baseType the base type
	 */
	private void initFromBaseType(AddressBaseType baseType) {
		if (baseType != null) {
			setAdditionalLocator(baseType.getAdditionalLocator());
			setBuildingNumber(baseType.getBuildingNumber());
			setCity(baseType.getCity());
			setCountry(baseType.getCountry());
			setPostalCode(baseType.getPostalCode());
			setPostBox(baseType.getPostBox());
			setState(baseType.getState());
			setStreetAddressLine1(baseType.getStreetAddressLine1());
			setStreetAddressLine2(baseType.getStreetAddressLine2());
			setStreetName(baseType.getStreetName());
			setUsage(baseType.getUsage());
			setNullFlavor(baseType.getNullFlavor());
		} else
			setNullFlavor(NullFlavor.NOT_AVAILABLE_L2);

	}

	/**
	 * Inits from the HL7 CDA R2 data type.
	 *
	 * @param hl7CdaR2Value the HL7 CDA R2 data type value
	 */
	private void initFromHl7CdaR2(org.projecthusky.common.hl7cdar2.AD hl7CdaR2Value) {
		initFromBaseType(createAddressBaseType(hl7CdaR2Value));
	}

	/**
	 * Sets the fields of the current instance by the given base type.
	 *
	 * @param baseType the base type
	 */
	public void set(AddressBaseType baseType) {
		initFromBaseType(baseType);
	}

	/**
	 * Sets the fields of the current instance by the given HL7 CDA R2 data type.
	 *
	 * @param hl7CdaR2Value the HL7 CDA R2 data typed value
	 */
	public void set(org.projecthusky.common.hl7cdar2.AD hl7CdaR2Value) {
		initFromHl7CdaR2(hl7CdaR2Value);
	}

}
