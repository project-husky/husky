package org.ehealth_connector.cda.enums;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
*<div class="de">Sonderfälle bei fehlenden Angaben</div>
*<div class="fr"></div>
*/
public enum NullFlavor {

	/**
	 * <div class="en">Information was sought but not found (e.g. patient was
	 * asked but didn't know)</div> <div class="de">Gefragt, aber keine Antwort
	 * erhalten</div> <div class="fr"></div> <div class="it"></div>
	 */
	ASKED_BUT_UNKNOWN("ASKU", "asked but unknown"),
	/**
	 * <div class="en">Description:An actual value may exist, but it must be
	 * derived from the provided information (usually an EXPR generic data type
	 * extension will be used to convey the derivation
	 * expressionexpression.</div> <div class="de"></div> <div class="fr"></div>
	 * <div class="it"></div>
	 */
	DERIVED("DER", "derived"),
	/**
	 * <div class="en">Description:The value as represented in the instance is
	 * not a member of the set of permitted data values in the constrained value
	 * domain of a variable.</div> <div class="de"></div> <div class="fr"></div>
	 * <div class="it"></div>
	 */
	INVALID("INV", "invalid"),
	/**
	 * <div class="en">There is information on this item available but it has
	 * not been provided by the sender due to security, privacy or other
	 * reasons. There may be an alternate mechanism for gaining access to this
	 * information. Note: using this null flavor does provide information that
	 * may be a breach of confidentiality, even though no detail data is
	 * provided. Its primary purpose is for those circumstances where it is
	 * necessary to inform the receiver that the information does exist without
	 * providing any detail.</div> <div class="de">Anonymisierte Daten</div>
	 * <div class="fr"></div> <div class="it"></div>
	 */
	MASKED("MSK", "masked"),
	/**
	 * <div class="en">Negative infinity of numbers.</div>
	 * <div class="de"></div> <div class="fr"></div> <div class="it"></div>
	 */
	NEGATIVE_INFINITY("NINF", "negative infinity"),
	/**
	 * <div class="en">Description:The value is exceptional (missing, omitted,
	 * incomplete, improper). No information as to the reason for being an
	 * exceptional value is provided. This is the most general exceptional
	 * value. It is also the default exceptional value.</div>
	 * <div class="de"></div> <div class="fr"></div> <div class="it"></div>
	 */
	NOINFORMATION("NI", "NoInformation"),
	/**
	 * <div class="en">Known to have no proper value (e.g. last menstrual period
	 * for a male).</div> <div class="de">Nicht anwendbar</div>
	 * <div class="fr"></div> <div class="it"></div>
	 */
	NOT_APPLICABLE("NA", "not applicable"),
	/**
	 * <div class="en">This information has not been sought (e.g. patient was
	 * not asked)</div> <div class="de"></div> <div class="fr"></div>
	 * <div class="it"></div>
	 */
	NOT_ASKED("NASK", "not asked"),
	/**
	 * <div class="en">Value is not present in a message. This is only defined
	 * in messages, never in application data! All values not present in the
	 * message must be replaced by the applicable default, or no-information
	 * (NI) as the default of all defaults.</div> <div class="de"></div>
	 * <div class="fr"></div> <div class="it"></div>
	 */
	NOT_PRESENT("NP", "not present"),
	/**
	 * <div class="en">Description:The actual value is not a member of the set
	 * of permitted data values in the constrained value domain of a variable.
	 * (e.g. concept not provided by required code system). Usage Notes: This
	 * flavor and its specializations are most commonly used with the CD
	 * datatype and its flavors. However, it may apply to *any* datatype where
	 * the constraints of the type are tighter than can be conveyed. For
	 * example, a PQ that is for a true measured amount whose units are not
	 * supported in UCUM, a need to convey a REAL when the type has been
	 * constrained to INT, etc. With coded datatypes, this null flavor may only
	 * be used if the vocabulary binding has a coding strength of CNE. By
	 * definition, all local codes and original text are part of the value set
	 * if the coding strength is CWE.</div> <div class="de">Andere Gründe</div>
	 * <div class="fr"></div> <div class="it"></div>
	 */
	OTHER("OTH", "other"),
	/**
	 * <div class="en">Positive infinity of numbers.</div>
	 * <div class="de"></div> <div class="fr"></div> <div class="it"></div>
	 */
	POSITIVE_INFINITY("PINF", "positive infinity"),
	/**
	 * <div class="en">Description:The specific quantity is not known, but is
	 * known to be non-zero and is not specified because it makes up the bulk of
	 * the material e.g. 'Add 10mg of ingredient X, 50mg of ingredient Y, and
	 * sufficient quantity of water to 100mL.' The null flavor would be used to
	 * express the quantity of water.</div> <div class="de"></div>
	 * <div class="fr"></div> <div class="it"></div>
	 */
	SUFFICIENT_QUANTITY("QS", "Sufficient Quantity"),
	/**
	 * <div class="en">Information is not available at this time but it is
	 * expected that it will be available later.</div>
	 * <div class="de"> Vorübergehend unbekannt, wird später ausgefüllt</div>
	 * <div class="fr"></div> <div class="it"></div>
	 */
	TEMPORARILY_UNAVAILABLE("NAV", "temporarily unavailable"),
	/**
	 * <div class="en">The content is greater than zero, but too small to be
	 * quantified.</div> <div class="de"></div> <div class="fr"></div>
	 * <div class="it"></div>
	 */
	TRACE("TRC", "trace"),
	/**
	 * <div class="en">Description: The actual value has not yet been encoded
	 * within the approved value domain. Example: Original text or a local code
	 * has been specified but translation or encoding to the approved value set
	 * has not yet occurred due to limitations of the sending system. Original
	 * text has been captured for a PQ, but not attempt has been made to split
	 * the value and unit or to encode the unit in UCUM. Usage Notes: If it is
	 * known that it is not possible to encode the concept, OTH should be used
	 * instead. However, use of UNC does not necessarily guarantee the concept
	 * will be encodable, only that encoding has not been attempted. Data type
	 * properties such as original text and translations may be present when
	 * this null flavor is included.</div> <div class="de"></div>
	 * <div class="fr"></div> <div class="it"></div>
	 */
	UN_ENCODED("UNC", "un-encoded"),
	/**
	 * <div class="en">Description:A proper value is applicable, but not known.
	 * Usage Notes: This means the actual value is not known. If the only thing
	 * that is unknown is how to properly express the value in the necessary
	 * constraints (value set, datatype, etc.), then the OTH or UNC flavor
	 * should be used. No properties should be included for a datatype with this
	 * property unless: Those properties themselves directly translate to a
	 * semantic of 'unknown'. (E.g. a local code sent as a translation that
	 * conveys 'unknown') Those properties further qualify the nature of what is
	 * unknown. (E.g. specifying a use code of 'H' and a URL prefix of 'tel:' to
	 * convey that it is the home phone number that is unknown.)</div>
	 * <div class="de">Unbekannt, ohne weitere Präzisierung</div>
	 * <div class="fr"></div> <div class="it"></div>
	 */
	UNKNOWN("UNK", "unknown");
	public static final String ASKED_BUT_UNKNOWN_CODE = "ASKU";
	/**
	 * <div class="en">Name of the Code System</div> <div class="de">Name des
	 * Codes Systems</div>
	 */
	public static final String CODE_SYSTEM_NAME = "NullFlavor";
	/**
	 * <div class="en">Identifier of the Code System</div>
	 * <div class="de">Identifikator für das Code System</div>
	 */
	public static final String CODE_SYSTEM_OID = "2.16.840.1.113883.5.1008";
	public static final String DERIVED_CODE = "DER";
	public static final String INVALID_CODE = "INV";
	public static final String MASKED_CODE = "MSK";
	public static final String NEGATIVE_INFINITY_CODE = "NINF";
	public static final String NOINFORMATION_CODE = "NI";
	public static final String NOT_APPLICABLE_CODE = "NA";
	public static final String NOT_ASKED_CODE = "NASK";
	public static final String NOT_PRESENT_CODE = "NP";
	public static final String OTHER_CODE = "OTH";
	public static final String POSITIVE_INFINITY_CODE = "PINF";
	public static final String SUFFICIENT_QUANTITY_CODE = "QS";
	public static final String TEMPORARILY_UNAVAILABLE_CODE = "NAV";
	public static final String TRACE_CODE = "TRC";

	public static final String UN_ENCODED_CODE = "UNC";

	public static final String UNKNOWN_CODE = "UNK";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static NullFlavor getEnum(String code) {
		for (final NullFlavor x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets
	 * ist.</div>
	 *
	 *
	 * @param enumName
	 *            <br>
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(NullFlavor.class, enumName);
			return true;
		} catch (final IllegalArgumentException ex) {
			return false;
		}
	}

	/**
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der gegebene code in diesem Value Set vorhanden
	 * ist.</div>
	 *
	 * @param codeValue
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final NullFlavor x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <div class="en">Machine interpretable and (inside this class) unique
	 * code</div> <div class="de">Maschinen interpretierbarer und (innerhalb
	 * dieser Klasse) eindeutiger Code</div>
	 */
	private String code;

	/**
	 * <div class="en">Human readable name</div>
	 * <div class="de">Menschenlesbarer Name</div>
	 */
	private String displayName;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instantiiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @param displayName
	 *            <br>
	 *            <div class="de"> display name</div>
	 */
	private NullFlavor(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div>
	 * <div class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 *
	 * @return <div class="en">The MDHT Code</div>
	 */
	public CD getCD() {
		final CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setCodeSystem(CODE_SYSTEM_OID);
		cd.setCode(code);
		cd.setDisplayName(displayName);
		return cd;
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div>
	 * <div class="de">Liefert das ehealthconnector Code Objekt</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public Code getCode() {
		final Code ehcCode = new Code(CODE_SYSTEM_OID, code, displayName);
		return ehcCode;
	}

	/**
	 * <div class="en">Gets the code system name.</div> <div class="de">Liefert
	 * code system name.</div>
	 *
	 * @return <div class="en">the code system name</div>
	 */
	public String getCodeSystemName() {
		return CODE_SYSTEM_NAME;
	}

	/**
	 * <div class="en">Gets the code system id.</div> <div class="de">Liefert
	 * die code system id.</div>
	 *
	 * @return <div class="en">the code system id</div>
	 */
	public String getCodeSystemOid() {
		return CODE_SYSTEM_OID;
	}

	/**
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public String getCodeValue() {
		return this.code;
	}

	/**
	 * <div class="en">Gets the display name.</div> <div class="de">Liefert
	 * display name.</div>
	 *
	 * @return <div class="en">the display name</div>
	 */
	public String getDisplayName() {
		return this.displayName;
	}

}