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
package org.husky.common.model;

import org.apache.commons.lang3.NotImplementedException;
import org.husky.common.basetypes.AddressBaseType;
import org.husky.common.enums.NullFlavor;
import org.husky.common.enums.PostalAddressUse;
import org.husky.common.hl7cdar2.*;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * The class Address contains all necessary fields for a postal address. This class also provides mapping methods to
 * other data types.
 */
public class Address extends AddressBaseType {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 8984600430220953028L;

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
    public Address(org.husky.common.hl7cdar2.AD hl7CdaR2Value) {
        initFromHl7CdaR2(hl7CdaR2Value);
    }

    /**
     * Creates the base type from the given HL7 CDA R2 value.
     *
     * @param hl7CdaR2Value the HL7 CDA R2 value
     * @return the base type
     */
    public static AddressBaseType createAddressBaseType(
            org.husky.common.hl7cdar2.AD hl7CdaR2Value) {
        AddressBaseType retVal = new AddressBaseType();

        if (hl7CdaR2Value != null) {
            String nullFlavor = null;
            if (hl7CdaR2Value.nullFlavor != null)
                if (hl7CdaR2Value.nullFlavor.size() > 0)
                    nullFlavor = hl7CdaR2Value.nullFlavor.get(0);
            if (nullFlavor != null)
                retVal.setNullFlavor(NullFlavor.getEnum(nullFlavor));

            if (hl7CdaR2Value.getUse().size() > 0)
                retVal.setUsage(PostalAddressUse.getEnum(hl7CdaR2Value.getUse().get(0)));

            String streetAddressLine1 = null;
            String streetAddressLine2 = null;

            for (Serializable element : hl7CdaR2Value.getContent()) {
                if (element instanceof JAXBElement) {
                    JAXBElement<?> elem = (JAXBElement<?>) element;
                    if (elem.getValue() instanceof AdxpAdditionalLocator) {
                        AdxpAdditionalLocator obj = (AdxpAdditionalLocator) elem.getValue();
                        retVal.setAdditionalLocator(obj.getTextContent());
                    } else if (elem.getValue() instanceof AdxpStreetName) {
                        AdxpStreetName obj = (AdxpStreetName) elem.getValue();
                        retVal.setStreetName(obj.getTextContent());
                    } else if (elem.getValue() instanceof AdxpHouseNumber) {
                        AdxpHouseNumber obj = (AdxpHouseNumber) elem.getValue();
                        retVal.setBuildingNumber(obj.getTextContent());
                    } else if (elem.getValue() instanceof AdxpPostBox) {
                        AdxpPostBox obj = (AdxpPostBox) elem.getValue();
                        retVal.setPostBox(obj.getTextContent());
                    } else if (elem.getValue() instanceof AdxpPostalCode) {
                        AdxpPostalCode obj = (AdxpPostalCode) elem.getValue();
                        retVal.setPostalCode(obj.getTextContent());
                    } else if (elem.getValue() instanceof AdxpCity) {
                        AdxpCity obj = (AdxpCity) elem.getValue();
                        retVal.setCity(obj.getTextContent());
                    } else if (elem.getValue() instanceof AdxpState) {
                        AdxpState obj = (AdxpState) elem.getValue();
                        retVal.setState(obj.getTextContent());
                    } else if (elem.getValue() instanceof AdxpCountry) {
                        AdxpCountry obj = (AdxpCountry) elem.getValue();
                        retVal.setCountry(obj.getTextContent());
                    } else if (elem.getValue() instanceof AdxpStreetAddressLine) {
                        if (streetAddressLine1 == null) {
                            AdxpStreetAddressLine obj = (AdxpStreetAddressLine) elem.getValue();
                            streetAddressLine1 = obj.getTextContent();
                            retVal.setStreetAddressLine1(streetAddressLine1);
                        } else if (streetAddressLine2 == null) {
                            AdxpStreetAddressLine obj = (AdxpStreetAddressLine) elem.getValue();
                            streetAddressLine2 = obj.getTextContent();
                            retVal.setStreetAddressLine2(streetAddressLine2);
                        }
                    } else
                        throw new NotImplementedException(elem.getValue().getClass().getName());
                }
            }
        } else
            retVal.setNullFlavor(NullFlavor.NOT_AVAILABLE);

        return retVal;
    }

    /**
     * Creates the HL7 CDA R2 data type from the given base type.
     *
     * @param baseType the base type
     * @return the HL7 CDA R2 data typed value
     */
    public static org.husky.common.hl7cdar2.AD createHl7CdaR2Ad(
            AddressBaseType baseType) {

        org.husky.common.hl7cdar2.AD retVal = null;

        if (baseType != null) {
            retVal = new org.husky.common.hl7cdar2.AD();
            String value;

            NullFlavor nf = baseType.getNullFlavor();
            if (nf != null) {
                if (retVal.nullFlavor == null)
                    retVal.nullFlavor = new ArrayList<String>();
                retVal.nullFlavor.add(nf.getCodeValue());
            }

            value = baseType.getAdditionalLocator();
            if (value != null) {
                AdxpAdditionalLocator obj = new AdxpAdditionalLocator();
                obj.setXmlMixed(value);
                retVal.getContent()
                        .add(new JAXBElement<AdxpAdditionalLocator>(
                                new QName("urn:hl7-org:v3", "additionalLocator"),
                                AdxpAdditionalLocator.class, obj));
            }

            value = baseType.getBuildingNumber();
            if (value != null) {
                AdxpHouseNumber obj = new AdxpHouseNumber();
                obj.setXmlMixed(value);
                retVal.getContent().add(new JAXBElement<AdxpHouseNumber>(
                        new QName("urn:hl7-org:v3", "houseNumber"), AdxpHouseNumber.class, obj));
            }

            value = baseType.getCity();
            if (value != null) {
                AdxpCity obj = new AdxpCity();
                obj.setXmlMixed(value);
                retVal.getContent().add(new JAXBElement<AdxpCity>(
                        new QName("urn:hl7-org:v3", "city"), AdxpCity.class, obj));
            }

            value = baseType.getCountry();
            if (value != null) {
                AdxpCountry obj = new AdxpCountry();
                obj.setXmlMixed(value);
                retVal.getContent().add(new JAXBElement<AdxpCountry>(
                        new QName("urn:hl7-org:v3", "country"), AdxpCountry.class, obj));
            }

            value = baseType.getPostalCode();
            if (value != null) {
                AdxpPostalCode obj = new AdxpPostalCode();
                obj.setXmlMixed(value);
                retVal.getContent().add(new JAXBElement<AdxpPostalCode>(
                        new QName("urn:hl7-org:v3", "postalCode"), AdxpPostalCode.class, obj));
            }

            value = baseType.getPostBox();
            if (value != null) {
                AdxpPostBox obj = new AdxpPostBox();
                obj.setXmlMixed(value);
                retVal.getContent().add(new JAXBElement<AdxpPostBox>(
                        new QName("urn:hl7-org:v3", "postBox"), AdxpPostBox.class, obj));
            }

            value = baseType.getState();
            if (value != null) {
                AdxpState obj = new AdxpState();
                obj.setXmlMixed(value);
                retVal.getContent().add(new JAXBElement<AdxpState>(
                        new QName("urn:hl7-org:v3", "state"), AdxpState.class, obj));
            }

            value = baseType.getStreetAddressLine1();
            if (value != null) {
                AdxpStreetAddressLine obj = new AdxpStreetAddressLine();
                obj.setXmlMixed(value);
                retVal.getContent()
                        .add(new JAXBElement<AdxpStreetAddressLine>(
                                new QName("urn:hl7-org:v3", "streetAddressLine"),
                                AdxpStreetAddressLine.class, obj));
            }

            value = baseType.getStreetAddressLine2();
            if (value != null) {
                AdxpStreetAddressLine obj = new AdxpStreetAddressLine();
                obj.setXmlMixed(value);
                retVal.getContent()
                        .add(new JAXBElement<AdxpStreetAddressLine>(
                                new QName("urn:hl7-org:v3", "streetAddressLine"),
                                AdxpStreetAddressLine.class, obj));
            }

            value = baseType.getStreetName();
            if (value != null) {
                AdxpStreetName obj = new AdxpStreetName();
                obj.setXmlMixed(value);
                retVal.getContent().add(new JAXBElement<AdxpStreetName>(
                        new QName("urn:hl7-org:v3", "streetName"), AdxpStreetName.class, obj));
            }

            PostalAddressUse usage = baseType.getUsage();
            if (usage != null) {
                retVal.getUse().clear();
                retVal.getUse().add(usage.getCode().getCode());
            }
        }

        return retVal;

    }

    /**
     * Gets the HL7 CDA R2 data type from the current instance.
     *
     * @return the HL7 CDA R2 data type
     */
    public org.husky.common.hl7cdar2.AD getHl7CdaR2Ad() {
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
            setNullFlavor(NullFlavor.NOT_AVAILABLE);

    }

    /**
     * Inits from the HL7 CDA R2 data type.
     *
     * @param hl7CdaR2Value the HL7 CDA R2 data type value
     */
    private void initFromHl7CdaR2(org.husky.common.hl7cdar2.AD hl7CdaR2Value) {
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
    public void set(org.husky.common.hl7cdar2.AD hl7CdaR2Value) {
        initFromHl7CdaR2(hl7CdaR2Value);
    }
}
