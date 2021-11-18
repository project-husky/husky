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

import java.util.ArrayList;
import java.util.List;

import org.husky.common.basetypes.CodeBaseType;
import org.husky.common.enums.NullFlavor;
import org.husky.common.enums.ValueSetEnumInterface;
import org.husky.common.hl7cdar2.CD;
import org.husky.common.hl7cdar2.ED;

/**
 * <div class="en">The class Code contains all necessary fields for a coded
 * element. This class also provides mapping methods to other data types. <div>
 *
 * <div class="de">Die Klasse Code enthält alle notwendigen Felder für ein
 * codiertes Element. Diese Klasse bietet auch Zuordnungsmethoden für andere
 * Datentypen.<div>
 *
 */
public class Code extends CodeBaseType {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5410972500384690838L;

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
	public static CodeBaseType createCodeBaseType(
			org.husky.common.hl7cdar2.CD hl7CdaR2Value) {
		var retVal = new CodeBaseType();

		if (hl7CdaR2Value != null) {
			String nullFlavor = null;
			if (hl7CdaR2Value.nullFlavor != null && !hl7CdaR2Value.nullFlavor.isEmpty())
					nullFlavor = hl7CdaR2Value.nullFlavor.get(0);
			if (nullFlavor != null)
				retVal.setNullFlavor(NullFlavor.getEnum(nullFlavor));
			else {

				retVal.setCode(hl7CdaR2Value.getCode());
				retVal.setCodeSystem(hl7CdaR2Value.getCodeSystem());
				retVal.setCodeSystemName(hl7CdaR2Value.getCodeSystemName());
				retVal.setCodeSystemVersion(hl7CdaR2Value.getCodeSystemVersion());
				retVal.setDisplayName(hl7CdaR2Value.getDisplayName());

				var ed = hl7CdaR2Value.getOriginalText();
				if (ed != null)
					retVal.setOriginalText(ed.getTextContent());
			}

			for (CD item : hl7CdaR2Value.getTranslation()) {
				retVal.addCodeTranslation(createCodeBaseType(item));
			}

			// setDisplayNameTranslationList() is not implemented, because
			// it is
			// not supported by CD
		} else
			retVal.setNullFlavor(NullFlavor.NOT_AVAILABLE);

		return retVal;

	}

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
	public static org.husky.common.hl7cdar2.CD createHl7CdaR2Cd(CodeBaseType baseType) {
		org.husky.common.hl7cdar2.CD retVal = null;
		if (baseType != null) {
			retVal = new org.husky.common.hl7cdar2.CD();
			String value;

			var nf = baseType.getNullFlavor();
			if (nf != null) {
				if (retVal.nullFlavor == null)
					retVal.nullFlavor = new ArrayList<String>();
				retVal.nullFlavor.add(nf.getCodeValue());
			} else {

				value = baseType.getCode();
				if (value != null) {
					retVal.setCode(value);
				}

				value = baseType.getCodeSystem();
				if (value != null) {
					retVal.setCodeSystem(value);
				}

				value = baseType.getCodeSystemName();
				if (value != null) {
					retVal.setCodeSystemName(value);
				}

				value = baseType.getCodeSystemVersion();
				if (value != null) {
					retVal.setCodeSystemVersion(value);
				}

				value = baseType.getDisplayName();
				if (value != null) {
					retVal.setDisplayName(value);
				}

				value = baseType.getOriginalText();
				if (value != null) {
					ED ed = new ED();
					ed.setXmlMixed(List.of(value));
					retVal.setOriginalText(ed);
				}
			}

			for (CodeBaseType item : baseType.getCodeTranslationList()) {
				retVal.getTranslation().add(createHl7CdaR2Cd(item));
			}

			// listDisplayNameTranslations() is not implemented, because it
			// is
			// not
			// supported by CD
		}
		return retVal;

	}

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
	public static org.husky.common.hl7cdar2.CE createHl7CdaR2Ce(CodeBaseType baseType) {
		org.husky.common.hl7cdar2.CE retVal = null;
		if (baseType != null) {
			retVal = new org.husky.common.hl7cdar2.CE();
			String value;

			var nf = baseType.getNullFlavor();
			if (nf != null) {
				if (retVal.nullFlavor == null)
					retVal.nullFlavor = new ArrayList<String>();
				retVal.nullFlavor.add(nf.getCodeValue());
			} else {

				value = baseType.getCode();
				if (value != null) {
					retVal.setCode(value);
				}

				value = baseType.getCodeSystem();
				if (value != null) {
					retVal.setCodeSystem(value);
				}

				value = baseType.getCodeSystemName();
				if (value != null) {
					retVal.setCodeSystemName(value);
				}

				value = baseType.getCodeSystemVersion();
				if (value != null) {
					retVal.setCodeSystemVersion(value);
				}

				value = baseType.getDisplayName();
				if (value != null) {
					retVal.setDisplayName(value);
				}

				value = baseType.getOriginalText();
				if (value != null) {
					var ed = new ED();
					ed.setXmlMixed(List.of(value));
					retVal.setOriginalText(ed);
				}
			}

			for (CodeBaseType item : baseType.getCodeTranslationList()) {
				retVal.getTranslation().add(createHl7CdaR2Cd(item));
			}

			// listDisplayNameTranslations() is not implemented, because it is
			// not
			// supported by CD
		}

		return retVal;

	}

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
	public static org.husky.common.hl7cdar2.CS createHl7CdaR2Cs(CodeBaseType baseType) {
		org.husky.common.hl7cdar2.CS retVal = null;
		if (baseType != null) {
			retVal = new org.husky.common.hl7cdar2.CS();
			String value;

			var nf = baseType.getNullFlavor();
			if (nf != null) {
				if (retVal.nullFlavor == null)
					retVal.nullFlavor = new ArrayList<String>();
				retVal.nullFlavor.add(nf.getCodeValue());
			} else {

				value = baseType.getCode();
				if (value != null) {
					retVal.setCode(value);
				}

				value = baseType.getCodeSystem();
				if (value != null) {
					retVal.setCodeSystem(value);
				}

				value = baseType.getCodeSystemName();
				if (value != null) {
					retVal.setCodeSystemName(value);
				}

				value = baseType.getCodeSystemVersion();
				if (value != null) {
					retVal.setCodeSystemVersion(value);
				}

				value = baseType.getDisplayName();
				if (value != null) {
					retVal.setDisplayName(value);
				}

				value = baseType.getOriginalText();
				if (value != null) {
					var ed = new ED();
					ed.setXmlMixed(List.of(value));
					retVal.setOriginalText(ed);
				}
			}

			for (CodeBaseType item : baseType.getCodeTranslationList()) {
				retVal.getTranslation().add(createHl7CdaR2Cd(item));
			}

			// listDisplayNameTranslations() is not implemented, because it is
			// not
			// supported by CD
		}

		return retVal;

	}

	/**
	 * Instantiates a new code. Default constructor.
	 */
	public Code() {
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
	public Code(CodeBaseType baseType) {
		initFromBaseType(baseType);
	}

	/**
	 * <div class="en">Instantiates a new instance from the given information.<div>
	 *
	 * <div class="de">Instanziiert eine neue Instanz vom angegebenen Daten.<div>
	 *
	 * @param code       the code
	 * @param codeSystem the code System
	 * @param display    the display name
	 */
	public Code(String code, String codeSystem, String display) {
		setCode(code);
		setCodeSystem(codeSystem);
		setDisplayName(display);
	}

	/**
	 * <div class="en">Instantiates a new instance from the given information.<div>
	 *
	 * <div class="de">Instanziiert eine neue Instanz vom angegebenen Daten.<div>
	 *
	 * @param code       the code
	 * @param codeSystem the code System
	 * @param display    the display name
	 */
	public Code(String code, String codeSystem, String codeSystemName, String display) {
		setCode(code);
		setCodeSystem(codeSystem);
		setCodeSystemName(codeSystemName);
		setDisplayName(display);
	}

	/**
	 * <div class="en">Instantiates a new instance from the given null flavor.<div>
	 *
	 * <div class="de">Instanziiert eine neue Instanz vom angegebenen Null
	 * Flavor.<div>
	 *
	 * @param nf the null flavor
	 */
	public Code(NullFlavor nf) {
		setNullFlavor(nf);
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
	public Code(org.husky.common.hl7cdar2.CD hl7CdaR2Value) {
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
	public Code(org.husky.common.hl7cdar2.CE hl7CdaR2Value) {
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
	public Code(org.husky.common.hl7cdar2.CS hl7CdaR2Value) {
		initFromHl7CdaR2(hl7CdaR2Value);
	}

	/**
	 * Instantiates a new code based on an enum value.
	 *
	 * @param enumValue
	 *            the enum value
	 */
	public Code(ValueSetEnumInterface enumValue) {
		CodeBaseType codeBt = CodeBaseType.builder().withCode(enumValue.getCodeValue())
				.withCodeSystem(enumValue.getCodeSystemId()).build();
		if (enumValue.getCodeSystemName() != null && !enumValue.getCodeSystemName().isEmpty())
				codeBt.setCodeSystemName(enumValue.getCodeSystemName());

		if (enumValue.getDisplayName() != null && !enumValue.getDisplayName().isEmpty())
				codeBt.setDisplayName(enumValue.getDisplayName());

		initFromBaseType(codeBt);

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
	public org.husky.common.hl7cdar2.CD getHl7CdaR2Cd() {
		return createHl7CdaR2Cd(this);
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
	public org.husky.common.hl7cdar2.CE getHl7CdaR2Ce() {
		return createHl7CdaR2Ce(this);
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
	public org.husky.common.hl7cdar2.CS getHl7CdaR2Cs() {
		return createHl7CdaR2Cs(this);
	}

	/**
	 * Inits from the base type.
	 *
	 * @param baseType
	 *            the base type
	 */
	private void initFromBaseType(CodeBaseType baseType) {
		if (baseType != null) {
			setCode(baseType.getCode());
			setCodeSystem(baseType.getCodeSystem());
			setCodeSystemName(baseType.getCodeSystemName());
			setCodeSystemVersion(baseType.getCodeSystemVersion());
			setCodeTranslationList(baseType.getCodeTranslationList());
			setDisplayName(baseType.getDisplayName());
			setDisplayNameTranslationList(baseType.getDisplayNameTranslationList());
			setOriginalText(baseType.getOriginalText());
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
	private void initFromHl7CdaR2(org.husky.common.hl7cdar2.CD hl7CdaR2Value) {
		initFromBaseType(createCodeBaseType(hl7CdaR2Value));
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
	public void set(CodeBaseType baseType) {
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
	public void set(org.husky.common.hl7cdar2.CD hl7CdaR2Value) {
		initFromHl7CdaR2(hl7CdaR2Value);
	}

}
