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

import org.husky.common.basetypes.*;
import org.husky.common.enums.NullFlavor;
import org.husky.common.hl7cdar2.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * The class Organization contains all necessary fields for an organization such as a company or an association. This
 * class also provides mapping methods to other data types.
 */
public class Organization extends OrganizationBaseType {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 3468258613512445510L;

    /**
     * Instantiates a new instance from the given HL7 CDA R2 data type.
     *
     * @param hl7CdaR2Value the HL7 CDA R2 data type
     */
    public Organization(
            org.husky.common.hl7cdar2.POCDMT000040CustodianOrganization hl7CdaR2Value) {
        initFromHl7CdaR2(hl7CdaR2Value);
    }

    /**
     * Instantiates a new instance from the given HL7 CDA R2 data type.
     *
     * @param hl7CdaR2Value the HL7 CDA R2 data type
     */
    public Organization(
            org.husky.common.hl7cdar2.POCDMT000040Organization hl7CdaR2Value) {
        initFromHl7CdaR2(hl7CdaR2Value);
    }

    /**
     * Instantiates a new instance from the given base type.
     *
     * @param baseType the base type
     */
    public Organization(OrganizationBaseType baseType) {
        initFromBaseType(baseType);
    }

    /**
     * Creates the HL7 CDA R2 data type from the string name.
     *
     * @param baseType the base type
     * @return the HL7 CDA R2 data typed value
     */
    public static org.husky.common.hl7cdar2.ON createHl7CdaR2On(NameBaseType baseType) {
        ON retVal = new ON();

        NullFlavor nf = baseType.getNullFlavor();
        if (nf != null) {
            if (retVal.nullFlavor == null)
                retVal.nullFlavor = new ArrayList<String>();
            retVal.nullFlavor.add(nf.getCodeValue());
        } else {

            retVal.setXmlMixed(baseType.getName());
            // Default=legal name
            if (baseType.getUsage() == null)
                retVal.getUse().add("L");
            else
                retVal.getUse().add(baseType.getUsage().getCodeValue());
        }
        return retVal;
    }

    /**
     * Creates the base type from the given HL7 CDA R2 value.
     *
     * @param hl7CdaR2Value the HL7 CDA R2 value
     * @return the base type
     */
    public static OrganizationBaseType createOrganizationBaseType(
            POCDMT000040CustodianOrganization hl7CdaR2Value) {
        OrganizationBaseType retVal = new OrganizationBaseType();

        if (hl7CdaR2Value != null) {
            retVal.addAddress(Address.createAddressBaseType(hl7CdaR2Value.getAddr()));

            for (II item : hl7CdaR2Value.getId()) {
                retVal.addIdentificator(Identificator.createIdentificatorBaseType(item));
            }

            retVal.addName(
                    NameBaseType.builder().withName(hl7CdaR2Value.getName().getMergedXmlMixed()).build());

            retVal.addTelecom(Telecom.createTelecomBaseType(hl7CdaR2Value.getTelecom()));
        } else
            retVal.setNullFlavor(NullFlavor.NOT_AVAILABLE_L2);

        return retVal;
    }

    /**
     * Creates the base type from the given HL7 CDA R2 value.
     *
     * @param hl7CdaR2Value the HL7 CDA R2 value
     * @return the base type
     */
    public static OrganizationBaseType createOrganizationBaseType(
            POCDMT000040Organization hl7CdaR2Value) {
        OrganizationBaseType retVal = new OrganizationBaseType();

        if (hl7CdaR2Value != null) {
            for (AD item : hl7CdaR2Value.getAddr()) {
                retVal.addAddress(Address.createAddressBaseType(item));
            }

            for (II item : hl7CdaR2Value.getId()) {
                retVal.addIdentificator(Identificator.createIdentificatorBaseType(item));
            }

            for (ON item : hl7CdaR2Value.getName()) {
                retVal.addName(NameBaseType.builder().withName(item.getMergedXmlMixed()).build());
            }

            for (TEL item : hl7CdaR2Value.getTelecom()) {
                retVal.addTelecom(Telecom.createTelecomBaseType(item));
            }
        } else
            retVal.setNullFlavor(NullFlavor.NOT_AVAILABLE_L2);

        return retVal;
    }

    /**
     * Gets the HL7 CDA R2 data type from the given base type.
     *
     * @param baseType the base type
     * @return the CDA R2 data type
     */
    public POCDMT000040Custodian createHl7CdaR2Pocdmt000040Custodian(
            OrganizationBaseType baseType) {

        org.husky.common.hl7cdar2.POCDMT000040Custodian retVal = null;
        ObjectFactory factory = new ObjectFactory();

        if (baseType != null) {
            retVal = createHl7CdaR2Pocdmt000040Custodian(factory.createPOCDMT000040Custodian(),
                    baseType);
        }

        return retVal;
    }

    /**
     * Gets the HL7 CDA R2 data type from the given base type.
     *
     * @param base     the custodian to be used as base
     * @param baseType the base type
     * @return the CDA R2 data type
     */
    public POCDMT000040Custodian createHl7CdaR2Pocdmt000040Custodian(POCDMT000040Custodian base,
                                                                     OrganizationBaseType baseType) {

        org.husky.common.hl7cdar2.POCDMT000040Custodian retVal = base;
        ObjectFactory factory = new ObjectFactory();

        if (baseType != null) {
            POCDMT000040AssignedCustodian assignedCustodian = factory
                    .createPOCDMT000040AssignedCustodian();
            POCDMT000040CustodianOrganization org = factory
                    .createPOCDMT000040CustodianOrganization();
            assignedCustodian.setRepresentedCustodianOrganization(org);
            retVal.setAssignedCustodian(assignedCustodian);
            if (!baseType.getAddressList().isEmpty())
                org.setAddr(Address.createHl7CdaR2Ad(baseType.getAddressList().get(0)));

            for (IdentificatorBaseType item : baseType.getIdentificatorList()) {
                if (item != null)
                    org.getId().add(Identificator.createHl7CdaR2Ii(item));
            }

            if (!baseType.getNameList().isEmpty())
                org.setName(createHl7CdaR2On(baseType.getNameList().get(0)));

            if (!baseType.getTelecomList().isEmpty())
                org.setTelecom(Telecom.createHl7CdaR2Tel(baseType.getTelecomList().get(0)));
        }

        return retVal;
    }

    /**
     * Gets the HL7 CDA R2 data type from the given base type.
     *
     * @param baseType the base type
     * @return the CDA R2 data type
     */
    public POCDMT000040InformationRecipient createHl7CdaR2Pocdmt000040InformationRecipient(
            OrganizationBaseType baseType) {

        POCDMT000040InformationRecipient retVal = null;
        ObjectFactory factory = new ObjectFactory();

        if (baseType != null) {
            retVal = createHl7CdaR2Pocdmt000040InformationRecipient(
                    factory.createPOCDMT000040InformationRecipient(), baseType);
        }

        return retVal;
    }

    /**
     * Gets the HL7 CDA R2 data type from the given base type.
     *
     * @param base     the recipient to be used as base
     * @param baseType the base type
     * @return the CDA R2 data type
     */
    public POCDMT000040InformationRecipient createHl7CdaR2Pocdmt000040InformationRecipient(
            POCDMT000040InformationRecipient base, OrganizationBaseType baseType) {

        POCDMT000040InformationRecipient retVal = base;
        ObjectFactory factory = new ObjectFactory();

        if (baseType != null) {
            POCDMT000040IntendedRecipient intendedRecipient = factory
                    .createPOCDMT000040IntendedRecipient();
            POCDMT000040Organization org = factory.createPOCDMT000040Organization();
            intendedRecipient.setReceivedOrganization(org);
            retVal.setIntendedRecipient(intendedRecipient);

            List<AD> addresses = createHl7AdList(baseType.getAddressList());
            org.getAddr().addAll(addresses);
            retVal.getIntendedRecipient().getAddr().addAll(addresses);

            org.getId().addAll(createHl7IiList(baseType.getIdentificatorList()));

            for (NameBaseType item : baseType.getNameList()) {
                if (item != null)
                    org.getName().add(createHl7CdaR2On(item));
            }

            List<TEL> tels = createHl7TelList(baseType.getTelecomList());
            org.getTelecom().addAll(tels);
            retVal.getIntendedRecipient().getTelecom().addAll(tels);
        }

        return retVal;
    }

    /**
     * Gets the HL7 CDA R2 data type from the given base type.
     *
     * @param baseType the base type
     * @return the CDA R2 data type
     */
    public org.husky.common.hl7cdar2.POCDMT000040Organization createHl7CdaR2Pocdmt000040Organization(
            OrganizationBaseType baseType) {

        org.husky.common.hl7cdar2.POCDMT000040Organization retVal = null;
        ObjectFactory factory = new ObjectFactory();

        if (baseType != null) {
            retVal = createHl7CdaR2Pocdmt000040Organization(
                    factory.createPOCDMT000040Organization(), baseType);
        }

        return retVal;

    }

    /**
     * Gets the HL7 CDA R2 data type from the given base type.
     *
     * @param base     the organization to be used as base
     * @param baseType the base type
     * @return the CDA R2 data type
     */
    public org.husky.common.hl7cdar2.POCDMT000040Organization createHl7CdaR2Pocdmt000040Organization(
            POCDMT000040Organization base, OrganizationBaseType baseType) {

        org.husky.common.hl7cdar2.POCDMT000040Organization retVal = base;

        if (baseType != null) {
            retVal.getAddr().addAll(createHl7AdList(baseType.getAddressList()));
            retVal.getId().addAll(createHl7IiList(baseType.getIdentificatorList()));
            retVal.getTelecom().addAll(createHl7TelList(baseType.getTelecomList()));

            for (NameBaseType item : baseType.getNameList()) {
                if (item != null)
                    retVal.getName().add(createHl7CdaR2On(item));
            }
        }

        return retVal;

    }

    /**
     * Gets the HL7 CDA R2 data type from the given base type.
     *
     * @return the CDA R2 data type
     */
    public org.husky.common.hl7cdar2.POCDMT000040AssignedAuthor createHl7CdaR2Pocdmt000040AssignedAuthor() {

        org.husky.common.hl7cdar2.POCDMT000040AssignedAuthor retVal = null;
        ObjectFactory factory = new ObjectFactory();

        retVal = createHl7CdaR2Pocdmt000040AssignedAuthor(factory.createPOCDMT000040AssignedAuthor());

        return retVal;

    }

    /**
     * Gets the HL7 CDA R2 data type from the given base type.
     *
     * @param base the assigned author to be used as base
     * @return the CDA R2 data type
     */
    public org.husky.common.hl7cdar2.POCDMT000040AssignedAuthor createHl7CdaR2Pocdmt000040AssignedAuthor(
            POCDMT000040AssignedAuthor base) {

        org.husky.common.hl7cdar2.POCDMT000040AssignedAuthor retVal = base;

        retVal.getAddr().addAll(createHl7AdList(getAddressList()));
        retVal.getId().addAll(createHl7IiList(getIdentificatorList()));
        retVal.getTelecom().addAll(createHl7TelList(getTelecomList()));

        return retVal;

    }

    private List<II> createHl7IiList(List<IdentificatorBaseType> listIdent) {
        List<II> ids = new LinkedList<>();
        for (IdentificatorBaseType item : listIdent) {
            if (item != null)
                ids.add(Identificator.createHl7CdaR2Ii(item));
        }

        return ids;
    }

    private List<TEL> createHl7TelList(List<TelecomBaseType> listTelecom) {
        List<TEL> tels = new LinkedList<>();
        for (TelecomBaseType item : listTelecom) {
            if (item != null)
                tels.add(Telecom.createHl7CdaR2Tel(item));
        }

        return tels;
    }

    private List<AD> createHl7AdList(List<AddressBaseType> listAddresses) {
        List<AD> addresses = new LinkedList<>();
        for (AddressBaseType item : listAddresses) {
            if (item != null)
                addresses.add(Address.createHl7CdaR2Ad(item));
        }

        return addresses;
    }

    /**
     * Gets the HL7 CDA R2 data type from the current instance.
     *
     * @return the HL7 CDA R2 data type
     */
    public POCDMT000040Custodian getHl7CdaR2Pocdmt000040Custodian() {
        return createHl7CdaR2Pocdmt000040Custodian(this);
    }

    /**
     * Gets the HL7 CDA R2 data type from the current instance.
     *
     * @param base the custodian to be used as base (e.g. containing templateIds)
     * @return the HL7 CDA R2 data type
     */
    public POCDMT000040Custodian getHl7CdaR2Pocdmt000040Custodian(POCDMT000040Custodian base) {
        return createHl7CdaR2Pocdmt000040Custodian(base, this);
    }

    /**
     * Gets the HL7 CDA R2 data type from the current instance.
     *
     * @return the HL7 CDA R2 data type
     */
    public POCDMT000040InformationRecipient getHl7CdaR2Pocdmt000040InformationRecipient() {

        return createHl7CdaR2Pocdmt000040InformationRecipient(this);
    }

    /**
     * Gets the HL7 CDA R2 data type from the current instance.
     *
     * @param base the recipient to be used as base (e.g. containing templateIds)
     * @return the HL7 CDA R2 data type
     */
    public POCDMT000040InformationRecipient getHl7CdaR2Pocdmt000040InformationRecipient(
            POCDMT000040InformationRecipient base) {

        return createHl7CdaR2Pocdmt000040InformationRecipient(base, this);
    }

    /**
     * Gets the HL7 CDA R2 data type from the current instance.
     *
     * @return the HL7 CDA R2 data type
     */
    public org.husky.common.hl7cdar2.POCDMT000040Organization getHl7CdaR2Pocdmt000040Organization() {
        return createHl7CdaR2Pocdmt000040Organization(this);
    }

    /**
     * Gets the HL7 CDA R2 data type from the current instance.
     *
     * @param base the Organization to be used as base (e.g. containing templateIds)
     * @return the HL7 CDA R2 data type
     */
    public org.husky.common.hl7cdar2.POCDMT000040Organization getHl7CdaR2Pocdmt000040Organization(
            POCDMT000040Organization base) {
        return createHl7CdaR2Pocdmt000040Organization(base, this);
    }

    /**
     * Inits from the base type.
     *
     * @param baseType the base type
     */
    private void initFromBaseType(OrganizationBaseType baseType) {
        if (baseType != null) {

            setAddressList(baseType.getAddressList());
            setIdentificatorList(baseType.getIdentificatorList());
            setNameList(baseType.getNameList());
            setPrimaryAddress(baseType.getPrimaryAddress());
            setPrimaryIdentificator(baseType.getPrimaryIdentificator());
            setPrimaryName(baseType.getPrimaryName());
            setPrimaryTelecom(baseType.getPrimaryTelecom());
            setTelecomList(baseType.getTelecomList());
            setNullFlavor(baseType.getNullFlavor());
        } else
            setNullFlavor(NullFlavor.NOT_AVAILABLE_L2);
    }

    /**
     * Inits from the HL7 CDA R2 data type.
     *
     * @param hl7CdaR2Value the HL7 CDA R2 data typed value
     */
    private void initFromHl7CdaR2(
            org.husky.common.hl7cdar2.POCDMT000040CustodianOrganization hl7CdaR2Value) {
        initFromBaseType(createOrganizationBaseType(hl7CdaR2Value));
    }

    /**
     * Inits from the HL7 CDA R2 data type.
     *
     * @param hl7CdaR2Value the HL7 CDA R2 data typed value
     */
    private void initFromHl7CdaR2(
            org.husky.common.hl7cdar2.POCDMT000040Organization hl7CdaR2Value) {
        initFromBaseType(createOrganizationBaseType(hl7CdaR2Value));
    }

    /**
     * Sets the fields of the current instance by the given HL7 CDA R2 data type.
     *
     * @param hl7CdaR2Value the HL7 CDA R2 data typed value
     */
    public void set(org.husky.common.hl7cdar2.POCDMT000040Organization hl7CdaR2Value) {
        initFromHl7CdaR2(hl7CdaR2Value);
    }

    /**
     * Sets the fields of the current instance by the given base type.
     *
     * @param baseType the base type
     */
    public void set(OrganizationBaseType baseType) {
        initFromBaseType(baseType);
    }

}
