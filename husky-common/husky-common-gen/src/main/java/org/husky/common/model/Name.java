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

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.apache.commons.lang3.NotImplementedException;
import org.husky.common.basetypes.NameBaseType;
import org.husky.common.enums.EntityNameUse;
import org.husky.common.enums.NullFlavor;
import org.husky.common.hl7cdar2.EnDelimiter;
import org.husky.common.hl7cdar2.EnFamily;
import org.husky.common.hl7cdar2.EnGiven;
import org.husky.common.hl7cdar2.EnPrefix;
import org.husky.common.hl7cdar2.EnSuffix;
import org.husky.common.hl7cdar2.PN;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.XpnName;

/**
 * <div class="en">The class Name contains all fields for different name parts
 * such as given or family. This class also provides mapping methods to other
 * data types. <div>
 *
 * <div class="de">Die Klasse Name enthält alle Felder für verschiedene
 * Namensteile wie Vornamen oder Familiennamen. Diese Klasse bietet auch
 * Zuordnungsmethoden für andere Datentypen.<div>
 *
 */
public class Name extends NameBaseType {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1233422782853908534L;

	/**
	 * <div class="en">Creates the HL7 CDA R2 data type from the given base
	 * type.<div>
	 *
	 * <div class="de">Erstellt den HL7 CDA R2 Datentyp aus dem angegebenen
	 * Basistyp.<div>
	 *
	 * @param baseType the base type
	 * @return the HL7 CDA R2 data typed value
	 */
	public static org.husky.common.hl7cdar2.EN createHl7CdaR2En(NameBaseType baseType) {
		org.husky.common.hl7cdar2.EN retVal = null;

		if (baseType != null) {
			retVal = new org.husky.common.hl7cdar2.EN();
			String value;

			var nf = baseType.getNullFlavor();
			if (nf != null) {
				if (retVal.nullFlavor == null)
					retVal.nullFlavor = new ArrayList<String>();
				retVal.nullFlavor.add(nf.getCodeValue());
			}

			value = baseType.getDelimiter();
			if (value != null) {
				var obj = new EnDelimiter();
				obj.setXmlMixed(value);
				retVal.getContent()
						.add(new JAXBElement<EnDelimiter>(new QName("hl7:delimiter"), EnDelimiter.class, obj));
			}

			value = baseType.getFamily();
			if (value != null) {
				var obj = new EnFamily();
				obj.setXmlMixed(value);
				retVal.getContent().add(new JAXBElement<EnFamily>(new QName("hl7:family"), EnFamily.class, obj));
			}

			value = baseType.getGiven();
			if (value != null) {
				var obj = new EnGiven();
				obj.setXmlMixed(value);
				retVal.getContent().add(new JAXBElement<EnGiven>(new QName("hl7:given"), EnGiven.class, obj));
			}

			value = baseType.getPrefix();
			if (value != null) {
				var obj = new EnPrefix();
				obj.setXmlMixed(value);
				retVal.getContent().add(new JAXBElement<EnPrefix>(new QName("hl7:prefix"), EnPrefix.class, obj));
			}

			value = baseType.getSuffix();
			if (value != null) {
				var obj = new EnSuffix();
				obj.setXmlMixed(value);
				retVal.getContent().add(new JAXBElement<EnSuffix>(new QName("hl7:suffix"), EnSuffix.class, obj));
			}

			value = baseType.getName();
			if (value != null && retVal.getContent().isEmpty()) {
				retVal.setXmlMixed(value);
			}

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
	 * @param baseType the base type
	 * @return the HL7 CDA R2 data typed value
	 */
	public static org.husky.common.hl7cdar2.ON createHl7CdaR2On(NameBaseType baseType) {
		org.husky.common.hl7cdar2.ON retVal = null;

		if (baseType != null) {
			retVal = new org.husky.common.hl7cdar2.ON();
			String value;

			var nf = baseType.getNullFlavor();
			if (nf != null) {
				if (retVal.nullFlavor == null)
					retVal.nullFlavor = new ArrayList<String>();
				retVal.nullFlavor.add(nf.getCodeValue());
			}

			value = baseType.getDelimiter();
			if (value != null) {
				var obj = new EnDelimiter();
				obj.setXmlMixed(value);
				retVal.getContent()
						.add(new JAXBElement<EnDelimiter>(new QName("hl7:delimiter"), EnDelimiter.class, obj));
			}

			value = baseType.getFamily();
			if (value != null) {
				var obj = new EnFamily();
				obj.setXmlMixed(value);
				retVal.getContent().add(new JAXBElement<EnFamily>(new QName("hl7:family"), EnFamily.class, obj));
			}

			value = baseType.getGiven();
			if (value != null) {
				var obj = new EnGiven();
				obj.setXmlMixed(value);
				retVal.getContent().add(new JAXBElement<EnGiven>(new QName("hl7:given"), EnGiven.class, obj));
			}

			value = baseType.getPrefix();
			if (value != null) {
				var obj = new EnPrefix();
				obj.setXmlMixed(value);
				retVal.getContent().add(new JAXBElement<EnPrefix>(new QName("hl7:prefix"), EnPrefix.class, obj));
			}

			value = baseType.getSuffix();
			if (value != null) {
				var obj = new EnSuffix();
				obj.setXmlMixed(value);
				retVal.getContent().add(new JAXBElement<EnSuffix>(new QName("hl7:suffix"), EnSuffix.class, obj));
			}

			value = baseType.getName();
			if (value != null && retVal.getContent().isEmpty()) {
				retVal.setXmlMixed(value);
			}

			EntityNameUse usage = baseType.getUsage();
			if (usage != null) {
				retVal.getUse().clear();
				retVal.getUse().add(usage.getCode().getCode());
			}
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
	 * @param baseType the base type
	 * @return the HL7 CDA R2 data typed value
	 */
	public static org.husky.common.hl7cdar2.PN createHl7CdaR2Pn(NameBaseType baseType) {
		org.husky.common.hl7cdar2.PN retVal = null;

		if (baseType != null) {
			retVal = new org.husky.common.hl7cdar2.PN();
			String value;

			var nf = baseType.getNullFlavor();
			if (nf != null) {
				if (retVal.nullFlavor == null)
					retVal.nullFlavor = new ArrayList<String>();
				retVal.nullFlavor.add(nf.getCodeValue());
			}

			value = baseType.getDelimiter();
			if (value != null) {
				var obj = new EnDelimiter();
				obj.setXmlMixed(value);
				retVal.getContent().add(
						new JAXBElement<EnDelimiter>(new QName("urn:hl7-org:v3", "delimiter"), EnDelimiter.class, obj));
			}

			value = baseType.getFamily();
			if (value != null) {
				var obj = new EnFamily();
				obj.setXmlMixed(value);
				retVal.getContent()
						.add(new JAXBElement<EnFamily>(new QName("urn:hl7-org:v3", "family"), EnFamily.class, obj));
			}

			value = baseType.getGiven();
			if (value != null) {
				var obj = new EnGiven();
				obj.setXmlMixed(value);
				retVal.getContent()
						.add(new JAXBElement<EnGiven>(new QName("urn:hl7-org:v3", "given"), EnGiven.class, obj));
			}

			value = baseType.getPrefix();
			if (value != null) {
				var obj = new EnPrefix();
				obj.setXmlMixed(value);
				// Note: This need probably to become more dynamic. Feel free to
				// contribute.
				obj.getQualifier().add("AC");
				retVal.getContent()
						.add(new JAXBElement<EnPrefix>(new QName("urn:hl7-org:v3", "prefix"), EnPrefix.class, obj));
			}

			value = baseType.getSuffix();
			if (value != null) {
				var obj = new EnSuffix();
				obj.setXmlMixed(value);
				retVal.getContent()
						.add(new JAXBElement<EnSuffix>(new QName("urn:hl7-org:v3", "suffix"), EnSuffix.class, obj));
			}

			value = baseType.getName();
			if (value != null && retVal.getContent().isEmpty()) {
				retVal.setXmlMixed(value);
			}

			EntityNameUse usage = baseType.getUsage();
			if (usage != null) {
				retVal.getUse().clear();
				retVal.getUse().add(usage.getCode().getCode());
			}
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
	 * @param baseType the base type
	 * @return the HL7 CDA R2 data typed value
	 */
	public static org.husky.common.hl7cdar2.TN createHl7CdaR2Tn(NameBaseType baseType) {
		org.husky.common.hl7cdar2.TN retVal = null;

		if (baseType != null) {
			retVal = new org.husky.common.hl7cdar2.TN();
			String value;

			var nf = baseType.getNullFlavor();
			if (nf != null) {
				if (retVal.nullFlavor == null)
					retVal.nullFlavor = new ArrayList<String>();
				retVal.nullFlavor.add(nf.getCodeValue());
			}

			value = baseType.getDelimiter();
			if (value != null) {
				var obj = new EnDelimiter();
				obj.setXmlMixed(value);
				retVal.getContent()
						.add(new JAXBElement<EnDelimiter>(new QName("hl7:delimiter"), EnDelimiter.class, obj));
			}

			value = baseType.getFamily();
			if (value != null) {
				var obj = new EnFamily();
				obj.setXmlMixed(value);
				retVal.getContent().add(new JAXBElement<EnFamily>(new QName("hl7:family"), EnFamily.class, obj));
			}

			value = baseType.getGiven();
			if (value != null) {
				var obj = new EnGiven();
				obj.setXmlMixed(value);
				retVal.getContent().add(new JAXBElement<EnGiven>(new QName("hl7:given"), EnGiven.class, obj));
			}

			value = baseType.getPrefix();
			if (value != null) {
				var obj = new EnPrefix();
				obj.setXmlMixed(value);
				retVal.getContent().add(new JAXBElement<EnPrefix>(new QName("hl7:prefix"), EnPrefix.class, obj));
			}

			value = baseType.getSuffix();
			if (value != null) {
				var obj = new EnSuffix();
				obj.setXmlMixed(value);
				retVal.getContent().add(new JAXBElement<EnSuffix>(new QName("hl7:suffix"), EnSuffix.class, obj));
			}

			value = baseType.getName();
			if (value != null && retVal.getContent().isEmpty()) {
				retVal.setXmlMixed(value);
			}

		}

		return retVal;
	}

	/**
	 * <div class="en">Creates the base type from the given HL7 CDA R2 value.<div>
	 *
	 * <div class="de">Erstellt den Basistyp aus dem angegebenen HL7 CDA R2
	 * Wert.<div>
	 *
	 * @param hl7CdaR2Value the HL7 CDA R2 value
	 * @return the base type
	 */
	public static NameBaseType createNameBaseType(org.husky.common.hl7cdar2.EN hl7CdaR2Value) {

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
				for (Serializable element : hl7CdaR2Value.getContent()) {
					if (element instanceof JAXBElement) {
						JAXBElement<?> elem = (JAXBElement<?>) element;
						if (elem.getValue() instanceof EnDelimiter) {
							EnDelimiter obj = (EnDelimiter) elem.getValue();
							retVal.setDelimiter(obj.getTextContent());
						} else if (elem.getValue() instanceof EnFamily) {
							EnFamily obj = (EnFamily) elem.getValue();
							retVal.setFamily(obj.getTextContent());
						} else if (elem.getValue() instanceof EnGiven) {
							EnGiven obj = (EnGiven) elem.getValue();
							retVal.setGiven(obj.getTextContent());
						} else if (elem.getValue() instanceof EnPrefix) {
							EnPrefix obj = (EnPrefix) elem.getValue();
							retVal.setPrefix(obj.getTextContent());
						} else if (elem.getValue() instanceof EnSuffix) {
							EnSuffix obj = (EnSuffix) elem.getValue();
							retVal.setSuffix(obj.getTextContent());
						} else
							throw new NotImplementedException(elem.getValue().getClass().getName());
					}
				}
			} else
				retVal.setName(hl7CdaR2Value.getMergedXmlMixed());
		} else
			retVal.setNullFlavor(NullFlavor.NOT_AVAILABLE);

		return retVal;
	}

	public static XpnName getIpfXpnName(PN hl7CdaR2Value) {
		var nameBase = createNameBaseType(hl7CdaR2Value);
		return new XpnName(nameBase.getFamily(), nameBase.getGiven(), null, nameBase.getSuffix(), nameBase.getPrefix(),
				null);
	}

	/**
	 * <div class="en">Instantiates a new instance. Default constructor.<div>
	 *
	 * <div class="de">Instanziiert eine neue Instanz. Standard Konstruktor.<div>
	 */
	public Name() {
	}

	/**
	 * <div class="en">Instantiates a new instance from the given base type.<div>
	 *
	 * <div class="de">Instanziiert eine neue Instanz vom angegebenen Basistyp.<div>
	 *
	 * @param baseType the base type
	 */
	public Name(NameBaseType baseType) {
		initFromBaseType(baseType);
	}

	/**
	 * <div class="en">Instantiates a new instance from the given HL7 CDA R2 data
	 * type.<div>
	 *
	 * <div class="de">Instanziiert eine neue Instanz vom angegebenen HL7 CDA R2
	 * Datentyp.<div>
	 *
	 * @param hl7CdaR2Value the HL7 CDA R2 data type
	 */
	public Name(org.husky.common.hl7cdar2.EN hl7CdaR2Value) {
		initFromHl7CdaR2(hl7CdaR2Value);
	}

	/**
	 * <div class="en">Instantiates a new instance from the given HL7 CDA R2 data
	 * type.<div>
	 *
	 * <div class="de">Instanziiert eine neue Instanz vom angegebenen HL7 CDA R2
	 * Datentyp.<div>
	 *
	 * @param hl7CdaR2Value the HL7 CDA R2 data type
	 */
	public Name(org.husky.common.hl7cdar2.ON hl7CdaR2Value) {
		initFromHl7CdaR2(hl7CdaR2Value);
	}

	/**
	 * <div class="en">Instantiates a new instance from the given HL7 CDA R2 data
	 * type.<div>
	 *
	 * <div class="de">Instanziiert eine neue Instanz vom angegebenen HL7 CDA R2
	 * Datentyp.<div>
	 *
	 * @param hl7CdaR2Value the HL7 CDA R2 data type
	 */
	public Name(org.husky.common.hl7cdar2.PN hl7CdaR2Value) {
		initFromHl7CdaR2(hl7CdaR2Value);
	}

	/**
	 * <div class="en">Instantiates a new instance from the given IPF name
	 * type.<div>
	 *
	 * <div class="de">Instanziiert eine neue Instanz vom angegebenen IPF
	 * Datentyp.<div>
	 *
	 * @param ipfName the ipf name
	 */
	public Name(org.openehealth.ipf.commons.ihe.xds.core.metadata.Name<?> ipfName) {
		initFromIpfType(ipfName);
	}

	/**
	 * <div class="en">Instantiates a new instance from the given name.<div>
	 *
	 * <div class="de">Instanziiert eine neue Instanz vom angegebenen Namen.<div>
	 *
	 * @param name the name
	 */
	public Name(String name) {
		setName(name);
	}

	/**
	 * <div class="en">Gets the HL7 CDA R2 data type from the current instance.<div>
	 *
	 * <div class="de">Ruft den HL7 CDA R2 Datentyp aus der aktuellen Instanz
	 * ab.<div>
	 *
	 * @return the HL7 CDA R2 data type
	 */
	public org.husky.common.hl7cdar2.EN getHl7CdaR2En() {
		return createHl7CdaR2En(this);
	}

	/**
	 * <div class="en">Gets the HL7 CDA R2 data type from the current instance.<div>
	 *
	 * <div class="de">Ruft den HL7 CDA R2 Datentyp aus der aktuellen Instanz
	 * ab.<div>
	 *
	 * @return the HL7 CDA R2 data type
	 */
	public org.husky.common.hl7cdar2.PN getHl7CdaR2Pn() {
		return createHl7CdaR2Pn(this);
	}

	/**
	 * <div class="en">Gets the HL7 CDA R2 data type from the current instance.<div>
	 *
	 * <div class="de">Ruft den HL7 CDA R2 Datentyp aus der aktuellen Instanz
	 * ab.<div>
	 *
	 * @return the HL7 CDA R2 data type
	 */
	public org.husky.common.hl7cdar2.TN getHl7CdaR2Tn() {
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
			setNullFlavor(NullFlavor.NOT_AVAILABLE);
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
			setNullFlavor(NullFlavor.NOT_AVAILABLE);
	}

	/**
	 * Inits the from HL7 CDA R2 data type.
	 *
	 * @param hl7CdaR2Value the HL7 CDA R2 data type value
	 */
	private void initFromHl7CdaR2(org.husky.common.hl7cdar2.EN hl7CdaR2Value) {
		initFromBaseType(createNameBaseType(hl7CdaR2Value));
	}

	/**
	 * <div class="en">Sets the fields of the current instance by the given base
	 * type.<div>
	 *
	 * <div class="de">Legt die Felder der aktuellen Instanz durch den angegebenen
	 * Basistyp fest.<div>
	 *
	 * @param baseType the base type
	 */
	public void set(NameBaseType baseType) {
		initFromBaseType(baseType);
	}

	/**
	 * <div class="en">Sets the fields of the current instance by the given HL7 CDA
	 * R2 data type.<div>
	 *
	 * <div class="de">Legt die Felder der aktuellen Instanz durch den angegebenen
	 * HL7 CDA R2 Datentyp fest.<div>
	 *
	 * @param hl7CdaR2Value the HL7 CDA R2 data typed value
	 */
	public void set(org.husky.common.hl7cdar2.EN hl7CdaR2Value) {
		initFromHl7CdaR2(hl7CdaR2Value);
	}

}
