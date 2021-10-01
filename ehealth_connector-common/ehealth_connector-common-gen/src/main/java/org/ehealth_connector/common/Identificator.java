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
import java.util.List;

import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.common.enums.NullFlavor;
import org.ehealth_connector.common.hl7cdar2.II;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Identifiable;

/**
 * <div class="en">The class Identificator contains all necessary fields for an
 * id. This class also provides mapping methods to other data types. <div>
 *
 * <div class="de">Die Klasse Identificator enthält alle erforderlichen Felder
 * für eine ID. Diese Klasse bietet auch Zuordnungsmethoden für andere
 * Datentypen.<div>
 *
 */
public class Identificator extends IdentificatorBaseType {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6963042793314704003L;

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
	public static org.ehealth_connector.common.hl7cdar2.II createHl7CdaR2Ii(
			IdentificatorBaseType baseType) {

		org.ehealth_connector.common.hl7cdar2.II retVal = null;

		if (baseType != null) {
			retVal = new org.ehealth_connector.common.hl7cdar2.II();
			String value;

			var nf = baseType.getNullFlavor();
			if (nf != null) {
				if (retVal.nullFlavor == null)
					retVal.nullFlavor = new ArrayList<String>();
				retVal.nullFlavor.add(nf.getCodeValue());
			} else {

				value = baseType.getAssigningAuthorityName();
				if (value != null) {
					retVal.setAssigningAuthorityName(value);
				}

				Boolean bValue = baseType.isDisplayable();
				if (bValue != null) {
					retVal.setDisplayable(bValue);
				}

				value = baseType.getExtension();
				if (value != null) {
					retVal.setExtension(value);
				}

				value = baseType.getRoot();
				if (value != null) {
					retVal.setRoot(value);
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
	public static IdentificatorBaseType createIdentificatorBaseType(
			org.ehealth_connector.common.hl7cdar2.II hl7CdaR2Value) {
		var retVal = new IdentificatorBaseType();

		if (hl7CdaR2Value != null) {
			String nullFlavor = null;
			if (hl7CdaR2Value.nullFlavor != null && !hl7CdaR2Value.nullFlavor.isEmpty())
					nullFlavor = hl7CdaR2Value.nullFlavor.get(0);
			if (nullFlavor != null)
				retVal.setNullFlavor(NullFlavor.getEnum(nullFlavor));

			retVal.setAssigningAuthorityName(hl7CdaR2Value.getAssigningAuthorityName());
			if (hl7CdaR2Value.isDisplayable() != null)
				retVal.setDisplayable(hl7CdaR2Value.isDisplayable());
			retVal.setExtension(hl7CdaR2Value.getExtension());
			retVal.setRoot(hl7CdaR2Value.getRoot());
		} else
			retVal.setNullFlavor(NullFlavor.NOT_AVAILABLE);

		return retVal;

	}

	/**
	 * Instantiates a new identificator. Default constructor.
	 */
	public Identificator() {

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
	public Identificator(IdentificatorBaseType baseType) {
		initFromBaseType(baseType);
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
	public Identificator(org.ehealth_connector.common.hl7cdar2.II hl7CdaR2Value) {
		initFromHl7CdaR2(hl7CdaR2Value);
	}

	/**
	 * <div class="en">Instantiates a new instance from the given root.<div>
	 *
	 * <div class="de">Instanziiert eine neue Instanz vom angegebenen root.<div>
	 *
	 * @param root
	 *            the root
	 */
	public Identificator(String root) {
		super.setRoot(root);
	}

	/**
	 * <div class="en">Instantiates a new instance from the given root and
	 * extension.<div>
	 *
	 * <div class="de">Instanziiert eine neue Instanz vom angegebenen root und
	 * extension.<div>
	 *
	 * @param root
	 *            the root
	 * @param extension
	 *            the extension
	 */
	public Identificator(String root, String extension) {
		super.setRoot(root);
		super.setExtension(extension);
	}

	public Identificator(Identifiable id) {
		if (id != null) {
			super.setExtension(id.getId());
			if (id.getAssigningAuthority() != null) {
				super.setRoot(id.getAssigningAuthority().getUniversalId());
			}
		}
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
	public org.ehealth_connector.common.hl7cdar2.II getHl7CdaR2Ii() {
		return createHl7CdaR2Ii(this);
	}

	/**
	 * Inits from the base type.
	 *
	 * @param baseType
	 *            the base type
	 */
	private void initFromBaseType(IdentificatorBaseType baseType) {
		if (baseType != null) {
			setAssigningAuthorityName(baseType.getAssigningAuthorityName());
			setDisplayable(baseType.isDisplayable());
			setExtension(baseType.getExtension());
			setRoot(baseType.getRoot());
			setNullFlavor(baseType.getNullFlavor());
		} else
			setNullFlavor(NullFlavor.NOT_AVAILABLE);
	}

	/**
	 * Inits from the HL7 CDA R2 data type.
	 *
	 * @param hl7CdaR2Value
	 *            the HL7 CDA R2 data type value
	 */
	private void initFromHl7CdaR2(org.ehealth_connector.common.hl7cdar2.II hl7CdaR2Value) {
		initFromBaseType(createIdentificatorBaseType(hl7CdaR2Value));
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
	public void set(IdentificatorBaseType baseType) {
		initFromBaseType(baseType);
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
	public void set(org.ehealth_connector.common.hl7cdar2.II hl7CdaR2Value) {
		initFromHl7CdaR2(hl7CdaR2Value);
	}

	/**
	 * <div class="en">Gets the identificator with the given root id from a list of
	 * ids.</div> <div class="de">Liefert identificator mit der gegebenen root id
	 * aus der liste der Ids.</div>
	 *
	 * @param iiList <br>
	 *               <div class="de"> ii list</div>
	 * @param root   <br>
	 *               <div class="de"> root</div>
	 * @return <div class="en">the identificator</div>
	 */
	public static Identificator getIdentificator(List<II> iiList, String root) {
		for (final II i : iiList) {
			if (i.getRoot().equals(root)) {
				return new Identificator(i);
			}
		}
		return null;
	}
}
