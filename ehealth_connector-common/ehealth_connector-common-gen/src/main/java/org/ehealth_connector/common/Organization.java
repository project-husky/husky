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
package org.ehealth_connector.common;

import java.util.ArrayList;

import org.ehealth_connector.common.basetypes.AddressBaseType;
import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.common.basetypes.NameBaseType;
import org.ehealth_connector.common.basetypes.OrganizationBaseType;
import org.ehealth_connector.common.basetypes.TelecomBaseType;
import org.ehealth_connector.common.enums.NullFlavor;
import org.ehealth_connector.common.hl7cdar2.AD;
import org.ehealth_connector.common.hl7cdar2.II;
import org.ehealth_connector.common.hl7cdar2.ON;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040AssignedCustodian;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Custodian;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040CustodianOrganization;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040InformationRecipient;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040IntendedRecipient;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Organization;
import org.ehealth_connector.common.hl7cdar2.TEL;

/**
 * <div class="en">The class Organization contains all necessary fields for an
 * organization such as a company or an association. This class also provides
 * mapping methods to other data types. <div>
 *
 * <div class="de">Die Klasse Organization enthält alle erforderlichen Felder
 * für eine Organisation wie eine Firma oder einen Verein. Diese Klasse bietet
 * auch Zuordnungsmethoden für andere Datentypen.<div>
 *
 */
public class Organization extends OrganizationBaseType {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3468258613512445510L;

	/**
	 * <div class="en">Creates the HL7 CDA R2 data type from the string
	 * name.<div>
	 *
	 * <div class="de">Erstellt den HL7 CDA R2 Datentyp aus dem angegebenen
	 * String Namen.<div>
	 *
	 * @param baseType
	 *            the base type
	 * @return the HL7 CDA R2 data typed value
	 */
	public static org.ehealth_connector.common.hl7cdar2.ON createHl7CdaR2On(NameBaseType baseType) {
		ON retVal = new ON();

		NullFlavor nf = baseType.getNullFlavor();
		if (nf != null) {
			if (retVal.nullFlavor == null)
				retVal.nullFlavor = new ArrayList<String>();
			retVal.nullFlavor.add(nf.getCodeValue());
		} else {

			retVal.xmlContent = baseType.getName();
			// Default=legal name
			if (baseType.getUsage() == null)
				retVal.getUse().add("L");
			else
				retVal.getUse().add(baseType.getUsage().getCodeValue());
		}
		return retVal;
	}

	/**
	 * <div class="en">Creates the base type from the given HL7 CDA R2
	 * value.<div>
	 *
	 * <div class="de">Erstellt den Basistyp aus dem angegebenen HL7 CDA R2
	 * Wert.<div>
	 *
	 * @param hl7CdaR2Value
	 *            the HL7 CDA R2 value
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
					NameBaseType.builder().withName(hl7CdaR2Value.getName().xmlContent).build());

			retVal.addTelecom(Telecom.createTelecomBaseType(hl7CdaR2Value.getTelecom()));
		} else
			retVal.setNullFlavor(NullFlavor.NOT_AVAILABLE);

		return retVal;
	}

	/**
	 * <div class="en">Creates the base type from the given HL7 CDA R2
	 * value.<div>
	 *
	 * <div class="de">Erstellt den Basistyp aus dem angegebenen HL7 CDA R2
	 * Wert.<div>
	 *
	 * @param hl7CdaR2Value
	 *            the HL7 CDA R2 value
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
				retVal.addName(NameBaseType.builder().withName(item.xmlContent).build());
			}

			for (TEL item : hl7CdaR2Value.getTelecom()) {
				retVal.addTelecom(Telecom.createTelecomBaseType(item));
			}
		} else
			retVal.setNullFlavor(NullFlavor.NOT_AVAILABLE);

		return retVal;
	}

	/**
	 * <div class="en">Instantiates a new instance from the given HL7 CDA R2
	 * data type.<div>
	 *
	 * <div class="de">Instanziiert eine neue Instanz vom angegebenen HL7 CDA R2
	 * Datentyp.<div>
	 *
	 * @param hl7CdaR2Value
	 *            the HL7 CDA R2 data type
	 */
	public Organization(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040CustodianOrganization hl7CdaR2Value) {
		initFromHl7CdaR2(hl7CdaR2Value);
	}

	/**
	 * <div class="en">Instantiates a new instance from the given HL7 CDA R2
	 * data type.<div>
	 *
	 * <div class="de">Instanziiert eine neue Instanz vom angegebenen HL7 CDA R2
	 * Datentyp.<div>
	 *
	 * @param hl7CdaR2Value
	 *            the HL7 CDA R2 data type
	 */
	public Organization(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040Organization hl7CdaR2Value) {
		initFromHl7CdaR2(hl7CdaR2Value);
	}

	/**
	 * <div class="en">Instantiates a new instance from the given base
	 * type.<div>
	 *
	 * <div class="de">Instanziiert eine neue Instanz vom angegebenen
	 * Basistyp.<div>
	 *
	 * @param baseType
	 *            the base type
	 */
	public Organization(OrganizationBaseType baseType) {
		initFromBaseType(baseType);
	}

	/**
	 * <div class="en">Gets the HL7 CDA R2 data type from the given base
	 * type.<div>
	 *
	 * <div class="de">Ruft den HL7 CDA R2 Datentyp vom angegebenen Basistyp
	 * ab.<div>
	 *
	 * @param baseType
	 *            the base type
	 * @return the CDA R2 data type
	 */
	public POCDMT000040Custodian createHl7CdaR2Pocdmt000040Custodian(
			OrganizationBaseType baseType) {

		org.ehealth_connector.common.hl7cdar2.POCDMT000040Custodian retVal = null;
		ObjectFactory factory = new ObjectFactory();

		if (baseType != null) {
			retVal = createHl7CdaR2Pocdmt000040Custodian(factory.createPOCDMT000040Custodian(),
					baseType);
		}

		return retVal;
	}

	/**
	 * <div class="en">Gets the HL7 CDA R2 data type from the given base
	 * type.<div>
	 *
	 * <div class="de">Ruft den HL7 CDA R2 Datentyp vom angegebenen Basistyp
	 * ab.<div>
	 *
	 * @param base
	 *            the custodian to be used as base
	 * @param baseType
	 *            the base type
	 * @return the CDA R2 data type
	 */
	public POCDMT000040Custodian createHl7CdaR2Pocdmt000040Custodian(POCDMT000040Custodian base,
			OrganizationBaseType baseType) {

		org.ehealth_connector.common.hl7cdar2.POCDMT000040Custodian retVal = base;
		ObjectFactory factory = new ObjectFactory();

		if (baseType != null) {
			POCDMT000040AssignedCustodian assignedCustodian = factory
					.createPOCDMT000040AssignedCustodian();
			POCDMT000040CustodianOrganization org = factory
					.createPOCDMT000040CustodianOrganization();
			assignedCustodian.setRepresentedCustodianOrganization(org);
			retVal.setAssignedCustodian(assignedCustodian);
			if (baseType.getAddressList().size() > 0)
				org.setAddr(Address.createHl7CdaR2Ad(baseType.getAddressList().get(0)));

			for (IdentificatorBaseType item : baseType.getIdentificatorList()) {
				if (item != null)
					org.getId().add(Identificator.createHl7CdaR2Ii(item));
			}

			if (baseType.getNameList().size() > 0)
				org.setName(createHl7CdaR2On(baseType.getNameList().get(0)));

			if (baseType.getTelecomList().size() > 0)
				org.setTelecom(Telecom.createHl7CdaR2Tel(baseType.getTelecomList().get(0)));
		}

		return retVal;
	}

	/**
	 * <div class="en">Gets the HL7 CDA R2 data type from the given base
	 * type.<div>
	 *
	 * <div class="de">Ruft den HL7 CDA R2 Datentyp vom angegebenen Basistyp
	 * ab.<div>
	 *
	 * @param baseType
	 *            the base type
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
	 * <div class="en">Gets the HL7 CDA R2 data type from the given base
	 * type.<div>
	 *
	 * <div class="de">Ruft den HL7 CDA R2 Datentyp vom angegebenen Basistyp
	 * ab.<div>
	 *
	 * @param base
	 *            the recipient to be used as base
	 * @param baseType
	 *            the base type
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

			for (AddressBaseType item : baseType.getAddressList()) {
				if (item != null) {
					AD ad = Address.createHl7CdaR2Ad(item);
					org.getAddr().add(ad);
					retVal.getIntendedRecipient().getAddr().add(ad);
				}
			}

			for (IdentificatorBaseType item : baseType.getIdentificatorList()) {
				if (item != null)
					org.getId().add(Identificator.createHl7CdaR2Ii(item));
			}

			for (NameBaseType item : baseType.getNameList()) {
				if (item != null)
					org.getName().add(createHl7CdaR2On(item));
			}

			for (TelecomBaseType item : baseType.getTelecomList()) {
				if (item != null) {
					TEL tel = Telecom.createHl7CdaR2Tel(item);
					org.getTelecom().add(tel);
					retVal.getIntendedRecipient().getTelecom().add(tel);
				}
			}
		}

		return retVal;
	}

	/**
	 * <div class="en">Gets the HL7 CDA R2 data type from the given base
	 * type.<div>
	 *
	 * <div class="de">Ruft den HL7 CDA R2 Datentyp vom angegebenen Basistyp
	 * ab.<div>
	 *
	 * @param baseType
	 *            the base type
	 * @return the CDA R2 data type
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Organization createHl7CdaR2Pocdmt000040Organization(
			OrganizationBaseType baseType) {

		org.ehealth_connector.common.hl7cdar2.POCDMT000040Organization retVal = null;
		ObjectFactory factory = new ObjectFactory();

		if (baseType != null) {
			retVal = createHl7CdaR2Pocdmt000040Organization(
					factory.createPOCDMT000040Organization(), baseType);
		}

		return retVal;

	}

	/**
	 * <div class="en">Gets the HL7 CDA R2 data type from the given base
	 * type.<div>
	 *
	 * <div class="de">Ruft den HL7 CDA R2 Datentyp vom angegebenen Basistyp
	 * ab.<div>
	 *
	 * @param base
	 *            the organization to be used as base
	 * @param baseType
	 *            the base type
	 * @return the CDA R2 data type
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Organization createHl7CdaR2Pocdmt000040Organization(
			POCDMT000040Organization base, OrganizationBaseType baseType) {

		org.ehealth_connector.common.hl7cdar2.POCDMT000040Organization retVal = base;

		if (baseType != null) {
			for (AddressBaseType item : baseType.getAddressList()) {
				if (item != null)
					retVal.getAddr().add(Address.createHl7CdaR2Ad(item));
			}

			for (IdentificatorBaseType item : baseType.getIdentificatorList()) {
				if (item != null)
					retVal.getId().add(Identificator.createHl7CdaR2Ii(item));
			}

			for (NameBaseType item : baseType.getNameList()) {
				if (item != null)
					retVal.getName().add(createHl7CdaR2On(item));
			}

			for (TelecomBaseType item : baseType.getTelecomList()) {
				if (item != null)
					retVal.getTelecom().add(Telecom.createHl7CdaR2Tel(item));
			}
		}

		return retVal;

	}

	/**
	 * <div class="en">Gets the HL7 CDA R2 data type from the current
	 * instance.<div>
	 *
	 * <div class="de">Ruft den HL7 CDA R2 Datentyp aus der aktuellen Instanz
	 * ab.<div>
	 *
	 * @return the HL7 CDA R2 data type
	 */
	public POCDMT000040Custodian getHl7CdaR2Pocdmt000040Custodian() {
		return createHl7CdaR2Pocdmt000040Custodian(this);
	}

	/**
	 * <div class="en">Gets the HL7 CDA R2 data type from the current
	 * instance.<div>
	 *
	 * <div class="de">Ruft den HL7 CDA R2 Datentyp aus der aktuellen Instanz
	 * ab.<div>
	 *
	 * @param base
	 *            the custodian to be used as base (e.g. containing templateIds)
	 * @return the HL7 CDA R2 data type
	 */
	public POCDMT000040Custodian getHl7CdaR2Pocdmt000040Custodian(POCDMT000040Custodian base) {
		return createHl7CdaR2Pocdmt000040Custodian(base, this);
	}

	/**
	 * <div class="en">Gets the HL7 CDA R2 data type from the current
	 * instance.<div>
	 *
	 * <div class="de">Ruft den HL7 CDA R2 Datentyp aus der aktuellen Instanz
	 * ab.<div>
	 *
	 * @return the HL7 CDA R2 data type
	 */
	public POCDMT000040InformationRecipient getHl7CdaR2Pocdmt000040InformationRecipient() {

		return createHl7CdaR2Pocdmt000040InformationRecipient(this);
	}

	/**
	 * <div class="en">Gets the HL7 CDA R2 data type from the current
	 * instance.<div>
	 *
	 * <div class="de">Ruft den HL7 CDA R2 Datentyp aus der aktuellen Instanz
	 * ab.<div>
	 *
	 * @param base
	 *            the recipient to be used as base (e.g. containing templateIds)
	 * @return the HL7 CDA R2 data type
	 */
	public POCDMT000040InformationRecipient getHl7CdaR2Pocdmt000040InformationRecipient(
			POCDMT000040InformationRecipient base) {

		return createHl7CdaR2Pocdmt000040InformationRecipient(base, this);
	}

	/**
	 * <div class="en">Gets the HL7 CDA R2 data type from the current
	 * instance.<div>
	 *
	 * <div class="de">Ruft den HL7 CDA R2 Datentyp aus der aktuellen Instanz
	 * ab.<div>
	 *
	 * @return the HL7 CDA R2 data type
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Organization getHl7CdaR2Pocdmt000040Organization() {
		return createHl7CdaR2Pocdmt000040Organization(this);
	}

	/**
	 * <div class="en">Gets the HL7 CDA R2 data type from the current
	 * instance.<div>
	 *
	 * <div class="de">Ruft den HL7 CDA R2 Datentyp aus der aktuellen Instanz
	 * ab.<div>
	 *
	 * @param base
	 *            the Organization to be used as base (e.g. containing
	 *            templateIds)
	 * @return the HL7 CDA R2 data type
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Organization getHl7CdaR2Pocdmt000040Organization(
			POCDMT000040Organization base) {
		return createHl7CdaR2Pocdmt000040Organization(base, this);
	}

	/**
	 * Inits from the base type.
	 *
	 * @param baseType
	 *            the base type
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
			setNullFlavor(NullFlavor.NOT_AVAILABLE);
	}

	/**
	 * Inits from the HL7 CDA R2 data type.
	 *
	 * @param hl7CdaR2Value
	 *            the HL7 CDA R2 data typed value
	 */
	private void initFromHl7CdaR2(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040CustodianOrganization hl7CdaR2Value) {
		initFromBaseType(createOrganizationBaseType(hl7CdaR2Value));
	}

	/**
	 * Inits from the HL7 CDA R2 data type.
	 *
	 * @param hl7CdaR2Value
	 *            the HL7 CDA R2 data typed value
	 */
	private void initFromHl7CdaR2(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040Organization hl7CdaR2Value) {
		initFromBaseType(createOrganizationBaseType(hl7CdaR2Value));
	}

	/**
	 * <div class="en">Sets the fields of the current instance by the given HL7
	 * CDA R2 data type.<div>
	 *
	 * <div class="de">Legt die Felder der aktuellen Instanz durch den
	 * angegebenen HL7 CDA R2 Datentyp fest.<div>
	 *
	 * @param hl7CdaR2Value
	 *            the HL7 CDA R2 data typed value
	 */
	public void set(org.ehealth_connector.common.hl7cdar2.POCDMT000040Organization hl7CdaR2Value) {
		initFromHl7CdaR2(hl7CdaR2Value);
	}

	/**
	 * <div class="en">Sets the fields of the current instance by the given base
	 * type.<div>
	 *
	 * <div class="de">Legt die Felder der aktuellen Instanz durch den
	 * angegebenen Basistyp fest.<div>
	 *
	 * @param baseType
	 *            the base type
	 */
	public void set(OrganizationBaseType baseType) {
		initFromBaseType(baseType);
	}

}
