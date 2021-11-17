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
package org.husky.common.model;

import java.util.ArrayList;

import org.husky.common.basetypes.TelecomBaseType;
import org.husky.common.enums.NullFlavor;
import org.husky.common.enums.TelecomAddressUse;

/**
 * <div class="en">The class Telecom contains all necessary fields for mean of
 * communication such as a eMail, phone or website. This class also provides
 * mapping methods to other data types. <div>
 *
 * <div class="de">Die Klasse Telecom enthält alle notwendigen Felder für ein
 * Kommunikationsmittel wie eMail, Telefon oder Webseite. Diese Klasse bietet
 * auch Zuordnungsmethoden für andere Datentypen.<div>
 *
 */
public class Telecom extends TelecomBaseType {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8468062608880568287L;

	/**
	 * <div class="en">Creates the HL7 CDA R2 data type from the given base
	 * type.<div>
	 *
	 * <div class="de">Erstellt den HL7 CDA R2 Datentyp aus dem angegebenen
	 * Basistyp.<div>
	 *
	 * @param baseType
	 *            the base type
	 * @return the HL7 CDA R2 data typed value
	 */
	public static org.husky.common.hl7cdar2.TEL createHl7CdaR2Tel(
			TelecomBaseType baseType) {
		org.husky.common.hl7cdar2.TEL retVal = null;
		if (baseType != null) {
			retVal = new org.husky.common.hl7cdar2.TEL();

			var nf = baseType.getNullFlavor();
			if (nf != null) {
				if (retVal.nullFlavor == null)
					retVal.nullFlavor = new ArrayList<String>();
				retVal.nullFlavor.add(nf.getCodeValue());
			} else {

				TelecomAddressUse usage = baseType.getUsage();
				if (usage != null) {
					retVal.getUse().add(usage.getCodeValue());
				}

				String value;
				value = baseType.getValue();
				if (value != null) {
					retVal.setValue(value);
				}
			}
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
	public static TelecomBaseType createTelecomBaseType(
			org.husky.common.hl7cdar2.TEL hl7CdaR2Value) {
		var retVal = new TelecomBaseType();
		if (hl7CdaR2Value != null) {
			String usage = null;
			String nullFlavor = null;
			if (hl7CdaR2Value.nullFlavor != null && !hl7CdaR2Value.nullFlavor.isEmpty())
					nullFlavor = hl7CdaR2Value.nullFlavor.get(0);
			if (nullFlavor != null)
				retVal.setNullFlavor(NullFlavor.getEnum(nullFlavor));
			else {
				if (hl7CdaR2Value.getUse() != null && !hl7CdaR2Value.getUse().isEmpty())
						usage = hl7CdaR2Value.getUse().get(0);
				if (usage != null)
					retVal.setUsage(TelecomAddressUse.getEnum(usage));
				retVal.setValue(hl7CdaR2Value.getValue());
			}
		} else
			retVal.setNullFlavor(NullFlavor.NOT_AVAILABLE);
		return retVal;

	}

	/**
	 * Instantiates a new telecom. Default constructor.
	 */
	public Telecom() {
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
	public Telecom(org.husky.common.hl7cdar2.TEL hl7CdaR2Value) {
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
	public Telecom(TelecomBaseType baseType) {
		initFromBaseType(baseType);
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
	public org.husky.common.hl7cdar2.TEL getHl7CdaR2Tel() {
		return createHl7CdaR2Tel(this);
	}

	/**
	 * Inits from the base type.
	 *
	 * @param baseType
	 *            the base type
	 */
	private void initFromBaseType(TelecomBaseType baseType) {
		if (baseType != null) {
			setUsage(baseType.getUsage());
			setValue(baseType.getValue());
			setNullFlavor(baseType.getNullFlavor());
		} else
			setNullFlavor(NullFlavor.NOT_AVAILABLE);
	}

	/**
	 * Inits the from HL7 CDA R2 data type.
	 *
	 * @param hl7CdaR2Value
	 *            the HL7 CDA R2 data type value
	 */
	private void initFromHl7CdaR2(org.husky.common.hl7cdar2.TEL hl7CdaR2Value) {
		initFromBaseType(createTelecomBaseType(hl7CdaR2Value));
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
	public void set(org.husky.common.hl7cdar2.TEL hl7CdaR2Value) {
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
	public void set(TelecomBaseType baseType) {
		initFromBaseType(baseType);
	}
}
