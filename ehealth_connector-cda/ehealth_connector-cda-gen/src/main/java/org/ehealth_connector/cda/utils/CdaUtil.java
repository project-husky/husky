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
package org.ehealth_connector.cda.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;

import javax.xml.bind.Binder;
import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.io.IOUtils;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.basetypes.NameBaseType;
import org.ehealth_connector.common.enums.EhcVersions;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.enums.NullFlavor;
import org.ehealth_connector.common.hl7cdar2.AD;
import org.ehealth_connector.common.hl7cdar2.ANY;
import org.ehealth_connector.common.hl7cdar2.AdxpCity;
import org.ehealth_connector.common.hl7cdar2.AdxpCountry;
import org.ehealth_connector.common.hl7cdar2.AdxpPostalCode;
import org.ehealth_connector.common.hl7cdar2.BL;
import org.ehealth_connector.common.hl7cdar2.BinaryDataEncoding;
import org.ehealth_connector.common.hl7cdar2.CD;
import org.ehealth_connector.common.hl7cdar2.CE;
import org.ehealth_connector.common.hl7cdar2.COCTMT230100UVIngredient;
import org.ehealth_connector.common.hl7cdar2.COCTMT230100UVSubstance;
import org.ehealth_connector.common.hl7cdar2.CS;
import org.ehealth_connector.common.hl7cdar2.ED;
import org.ehealth_connector.common.hl7cdar2.EN;
import org.ehealth_connector.common.hl7cdar2.INT;
import org.ehealth_connector.common.hl7cdar2.IVLINT;
import org.ehealth_connector.common.hl7cdar2.IVLPQ;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040ClinicalDocument;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Component2;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Component3;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Component4;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Observation;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040ObservationMedia;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Organizer;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Section;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040StructuredBody;
import org.ehealth_connector.common.hl7cdar2.PQ;
import org.ehealth_connector.common.hl7cdar2.SC;
import org.ehealth_connector.common.hl7cdar2.ST;
import org.ehealth_connector.common.hl7cdar2.StrucDocContent;
import org.ehealth_connector.common.hl7cdar2.StrucDocRenderMultiMedia;
import org.ehealth_connector.common.hl7cdar2.StrucDocText;
import org.ehealth_connector.common.hl7cdar2.TS;
import org.ehealth_connector.common.utils.Hl7CdaR2Util;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 * <div class="en">A util class with helper functions for CDA based on
 * ART-DECOR.</div>
 *
 * <div class="de">Eine Klasse mit Hilfsfunktionen für CDA basierend auf
 * ART-DECOR.</div>
 */
public class CdaUtil {

	/**
	 * <div class="en">Completes the given original representation section with
	 * the PDF as observation media.</div>
	 *
	 * <div class="de">Vervollständigt die angegebene original representation
	 * section mit dem PDF als observation media.</div>
	 *
	 * @param doc
	 *            the doc
	 * @param section
	 *            the section
	 * @param pdf
	 *            the pdf
	 */
	public static void completeOriginalRepresentationSection(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040ClinicalDocument doc,
			org.ehealth_connector.common.hl7cdar2.POCDMT000040Section section, byte[] pdf) {

		final String id = "originalrepresentationpdf";
		ObjectFactory factory = new ObjectFactory();

		section.setTitle(CdaUtil.createHl7CdaR2St("Original representation"));

		POCDMT000040ObservationMedia obsMedia = factory.createPOCDMT000040ObservationMedia();
		obsMedia.getClassCode().add("OBS");
		obsMedia.getMoodCode().add("EVN");
		obsMedia.setIDAttr(id);
		obsMedia.getTemplateId()
				.add(new Identificator("2.16.756.5.30.1.1.10.4.83").getHl7CdaR2Ii());
		obsMedia.setLanguageCode(doc.getLanguageCode());

		String valueString = null;
		try {
			valueString = new String(IOUtils.toByteArray(
					new ByteArrayInputStream(DatatypeConverter.printBase64Binary(pdf).getBytes())));
		} catch (IOException e) {
			// DO nothing
		}
		ED value = CdaUtil.createHl7CdaR2Ed(valueString);
		value.setMediaType("application/pdf");
		value.setRepresentation(BinaryDataEncoding.B_64);
		obsMedia.setValue(value);

		StrucDocText strucDocText = CdaUtil.createHl7CdaR2StrucDocText(
				"Representation of the original view which has been signed by the legal authenticator:\n");
		StrucDocRenderMultiMedia renderMultimedia = factory.createStrucDocRenderMultiMedia();
		renderMultimedia.getReferencedObject().add(obsMedia);
		strucDocText.getContent()
				.add(new JAXBElement<StrucDocRenderMultiMedia>(
						new QName("urn:hl7-org:v3", "renderMultiMedia"),
						StrucDocRenderMultiMedia.class, renderMultimedia));

		section.getEntry().get(0).setObservationMedia(obsMedia);
		section.setText(strucDocText);

		POCDMT000040StructuredBody structuredBody = CdaUtil.getHl7CdaR2StructuredBody(doc);
		POCDMT000040Component3 comp3 = factory.createPOCDMT000040Component3();

		// complete section
		comp3.setSection(section);
		structuredBody.getComponent().add(comp3);
	}

	/**
	 * <div class="en">Creates an instance of the HL7 CDA R2 data type
	 * corresponding to the given argument.</div>
	 *
	 * <div class="de">Erstellt eine Instanz des HL7 CDA R2 Datentyps, welcher
	 * dem angegebenen Argument entspricht.</div>
	 *
	 * @param value
	 *            the value
	 * @return the bl
	 */
	public static BL createHl7CdaR2Bl(boolean value) {
		ObjectFactory factory = new ObjectFactory();
		BL retVal = factory.createBL();
		retVal.setValue(value);
		return retVal;
	}

	/**
	 * <div class="en">Creates an instance of the HL7 CDA R2 data type
	 * corresponding to the given arguments.</div>
	 *
	 * <div class="de">Erstellt eine Instanz des HL7 CDA R2 Datentyps, welcher
	 * den angegebenen Argumenten entspricht.</div>
	 *
	 * @param code
	 *            the code
	 * @param codeSystem
	 *            the code system
	 * @return the ce
	 */
	public static CE createHl7CdaR2Ce(String code, String codeSystem) {
		ObjectFactory factory = new ObjectFactory();
		CE retVal = factory.createCE();
		retVal.setCode(code);
		retVal.setCodeSystem(codeSystem);
		return retVal;
	}

	/**
	 * <div class="en">Creates an instance of the HL7 CDA R2 data type
	 * corresponding to the given argument.</div>
	 *
	 * <div class="de">Erstellt eine Instanz des HL7 CDA R2 Datentyps, welcher
	 * dem angegebenen Argument entspricht.</div>
	 *
	 * @param value
	 *            the value
	 * @return the cs
	 */
	public static CS createHl7CdaR2Cs(String value) {
		ObjectFactory factory = new ObjectFactory();
		CS retVal = factory.createCS();
		retVal.setCode(value);
		return retVal;
	}

	/**
	 * <div class="en">Creates an instance of the HL7 CDA R2 data type
	 * corresponding to the given argument.</div>
	 *
	 * <div class="de">Erstellt eine Instanz des HL7 CDA R2 Datentyps, welcher
	 * dem angegebenen Argument entspricht.</div>
	 *
	 * @param value
	 *            the value
	 * @return the ed
	 */
	public static ED createHl7CdaR2Ed(String value) {
		ObjectFactory factory = new ObjectFactory();
		ED retVal = factory.createED();
		retVal.xmlContent = value;
		return retVal;
	}

	/**
	 * <div class="en">Creates an instance of the HL7 CDA R2 data type
	 * corresponding to the given argument.</div>
	 *
	 * <div class="de">Erstellt eine Instanz des HL7 CDA R2 Datentyps, welcher
	 * dem angegebenen Argument entspricht.</div>
	 *
	 * @param i
	 *            the i
	 * @return the int
	 */
	public static INT createHl7CdaR2Int(int i) {
		ObjectFactory factory = new ObjectFactory();
		INT retVal = factory.createINT();
		retVal.setValue(BigInteger.valueOf(i));
		return retVal;
	}

	/**
	 * <div class="en">Creates an instance of the HL7 CDA R2 data type
	 * corresponding to the given arguments.</div>
	 *
	 * <div class="de">Erstellt eine Instanz des HL7 CDA R2 Datentyps, welcher
	 * den angegebenen Argumenten entspricht.</div>
	 *
	 * @param lowValue
	 *            the low value
	 * @param highValue
	 *            the high value
	 * @return the ivlint
	 */
	public static IVLINT createHl7CdaR2IvlInt(Integer lowValue, Integer highValue) {
		ObjectFactory factory = new ObjectFactory();
		IVLINT retVal = factory.createIVLINT();

		INT intLow = null;
		if (lowValue == null) {
			intLow = createHl7CdaR2NullFlavorInt(null);
		} else {
			intLow = factory.createINT();
			intLow.setValue(BigInteger.valueOf(lowValue));
		}

		INT intHigh = null;
		if (highValue == null) {
			intHigh = createHl7CdaR2NullFlavorInt(null);
		} else {
			intHigh = factory.createINT();
			intHigh.setValue(BigInteger.valueOf(highValue));
		}

		retVal.getRest()
				.add(new JAXBElement<INT>(new QName("urn:hl7-org:v3", "low"), INT.class, intLow));
		retVal.getRest()
				.add(new JAXBElement<INT>(new QName("urn:hl7-org:v3", "high"), INT.class, intHigh));
		return retVal;
	}

	/**
	 * <div class="en">Creates an instance of the HL7 CDA R2 data type
	 * corresponding to the given arguments.</div>
	 *
	 * <div class="de">Erstellt eine Instanz des HL7 CDA R2 Datentyps, welcher
	 * den angegebenen Argumenten entspricht.</div>
	 *
	 * @param lowValue
	 *            the low value
	 * @param highValue
	 *            the high value
	 * @return the ivlint
	 */
	public static IVLINT createHl7CdaR2IvlInt(String lowValue, String highValue) {
		Integer low = null;
		Integer high = null;
		if (lowValue != null)
			low = Integer.parseInt(lowValue);
		if (highValue != null)
			high = Integer.parseInt(highValue);
		return createHl7CdaR2IvlInt(low, high);
	}

	/**
	 * <div class="en">Creates an instance of the HL7 CDA R2 data type
	 * corresponding to the given arguments.</div>
	 *
	 * <div class="de">Erstellt eine Instanz des HL7 CDA R2 Datentyps, welcher
	 * den angegebenen Argumenten entspricht.</div>
	 *
	 * @param centerValue
	 *            the center value
	 * @param unit
	 *            the unit
	 * @return the ivlpq
	 */
	public static IVLPQ createHl7CdaR2Ivlpq(String centerValue, String unit) {
		ObjectFactory factory = new ObjectFactory();
		IVLPQ retVal = factory.createIVLPQ();
		if (unit != null)
			retVal.setUnit(unit);

		PQ pqCenter = null;
		if (centerValue == null) {
			pqCenter = createHl7CdaR2NullFlavorPq(null);
		} else {
			pqCenter = factory.createPQ();
			pqCenter.setValue(centerValue);
		}

		retVal.getRest().add(
				new JAXBElement<PQ>(new QName("urn:hl7-org:v3", "center"), PQ.class, pqCenter));
		return retVal;
	}

	/**
	 * <div class="en">Creates an instance of the HL7 CDA R2 data type
	 * corresponding to the given arguments.</div>
	 *
	 * <div class="de">Erstellt eine Instanz des HL7 CDA R2 Datentyps, welcher
	 * den angegebenen Argumenten entspricht.</div>
	 *
	 * @param lowValue
	 *            the low value
	 * @param highValue
	 *            the high value
	 * @param unit
	 *            the unit
	 * @return the ivlpq
	 */
	public static IVLPQ createHl7CdaR2Ivlpq(String lowValue, String highValue, String unit) {
		ObjectFactory factory = new ObjectFactory();
		IVLPQ retVal = factory.createIVLPQ();
		if (unit != null)
			retVal.setUnit(unit);

		PQ pqLow = null;
		if (lowValue == null) {
			pqLow = createHl7CdaR2NullFlavorPq(null);
		} else {
			pqLow = factory.createPQ();
			pqLow.setValue(lowValue);
		}

		PQ pqHigh = null;
		if (highValue == null) {
			pqHigh = createHl7CdaR2NullFlavorPq(null);
		} else {
			pqHigh = factory.createPQ();
			pqHigh.setValue(highValue);
		}

		retVal.getRest()
				.add(new JAXBElement<PQ>(new QName("urn:hl7-org:v3", "low"), PQ.class, pqLow));
		retVal.getRest()
				.add(new JAXBElement<PQ>(new QName("urn:hl7-org:v3", "high"), PQ.class, pqHigh));
		return retVal;
	}

	/**
	 * <div class="en">Creates an instance of the HL7 CDA R2 data type
	 * corresponding to the return type, having nullFlavor set. A null
	 * nullFlavor arg will produce nullFlavor=UNK.</div>
	 *
	 * <div class="de">Erstellt eine Instanz des Datentyps HL7 CDA R2, der dem
	 * Rückgabetyp entspricht, wobei nullFlavor gesetzt ist. Ein null
	 * nullFlavor-Argument erzeugt nullFlavor = UNK.</div>
	 *
	 * @param nullFlavor
	 *            the desired nullFlavor value
	 * @return the ad
	 */
	public static AD createHl7CdaR2NullFlavorAddress(NullFlavor nullFlavor) {

		ObjectFactory factory = new ObjectFactory();
		AD addr = factory.createAD();
		addr.nullFlavor = new ArrayList<String>();
		if (nullFlavor == null) {
			addr.nullFlavor.add(NullFlavor.UNKNOWN.getCodeValue());
		} else {
			addr.nullFlavor.add(nullFlavor.getCodeValue());
		}

		AdxpPostalCode postalCode = factory.createAdxpPostalCode();
		postalCode.nullFlavor = new ArrayList<String>();
		if (nullFlavor == null) {
			postalCode.nullFlavor.add(NullFlavor.UNKNOWN.getCodeValue());
		} else {
			postalCode.nullFlavor.add(nullFlavor.getCodeValue());
		}
		addr.getContent().add(new JAXBElement<AdxpPostalCode>(
				new QName("urn:hl7-org:v3", "postalCode"), AdxpPostalCode.class, postalCode));

		AdxpCity city = factory.createAdxpCity();
		city.nullFlavor = new ArrayList<String>();
		if (nullFlavor == null) {
			city.nullFlavor.add(NullFlavor.UNKNOWN.getCodeValue());
		} else {
			city.nullFlavor.add(nullFlavor.getCodeValue());
		}
		addr.getContent().add(new JAXBElement<AdxpCity>(new QName("urn:hl7-org:v3", "city"),
				AdxpCity.class, city));

		AdxpCountry country = factory.createAdxpCountry();
		country.nullFlavor = new ArrayList<String>();
		if (nullFlavor == null) {
			country.nullFlavor.add(NullFlavor.UNKNOWN.getCodeValue());
		} else {
			country.nullFlavor.add(nullFlavor.getCodeValue());
		}
		addr.getContent().add(new JAXBElement<AdxpCountry>(new QName("urn:hl7-org:v3", "country"),
				AdxpCountry.class, country));

		return addr;

	}

	/**
	 * <div class="en">Creates an instance of the HL7 CDA R2 data type
	 * corresponding to the return type, having nullFlavor set. A null
	 * nullFlavor arg will produce nullFlavor=UNK.</div>
	 *
	 * <div class="de">Erstellt eine Instanz des Datentyps HL7 CDA R2, der dem
	 * Rückgabetyp entspricht, wobei nullFlavor gesetzt ist. Ein null
	 * nullFlavor-Argument erzeugt nullFlavor = UNK.</div>
	 *
	 * @param nullFlavor
	 *            the desired nullFlavor value
	 * @return the int
	 */
	public static INT createHl7CdaR2NullFlavorInt(NullFlavor nullFlavor) {
		ObjectFactory factory = new ObjectFactory();
		final INT i = factory.createINT();
		i.nullFlavor = new ArrayList<String>();
		if (nullFlavor == null) {
			i.nullFlavor.add(NullFlavor.UNKNOWN.getCodeValue());
		} else {
			i.nullFlavor.add(nullFlavor.getCodeValue());
		}
		return i;
	}

	/**
	 * <div class="en">Creates an instance of the HL7 CDA R2 data type
	 * corresponding to the return type, having nullFlavor set. A null
	 * nullFlavor arg will produce nullFlavor=UNK.</div>
	 *
	 * <div class="de">Erstellt eine Instanz des Datentyps HL7 CDA R2, der dem
	 * Rückgabetyp entspricht, wobei nullFlavor gesetzt ist. Ein null
	 * nullFlavor-Argument erzeugt nullFlavor = UNK.</div>
	 *
	 * @param nullFlavor
	 *            the desired nullFlavor value
	 * @return the pq
	 */
	public static PQ createHl7CdaR2NullFlavorPq(NullFlavor nullFlavor) {
		ObjectFactory factory = new ObjectFactory();
		final PQ pq = factory.createPQ();
		pq.nullFlavor = new ArrayList<String>();
		if (nullFlavor == null) {
			pq.nullFlavor.add(NullFlavor.UNKNOWN.getCodeValue());
		} else {
			pq.nullFlavor.add(nullFlavor.getCodeValue());
		}
		return pq;
	}

	/**
	 * <div class="en">Creates an instance of the HL7 CDA R2 data type
	 * corresponding to the return type, having nullFlavor set. A null
	 * nullFlavor arg will produce nullFlavor=UNK.</div>
	 *
	 * <div class="de">Erstellt eine Instanz des Datentyps HL7 CDA R2, der dem
	 * Rückgabetyp entspricht, wobei nullFlavor gesetzt ist. Ein null
	 * nullFlavor-Argument erzeugt nullFlavor = UNK.</div>
	 *
	 * @param nullFlavor
	 *            the desired nullFlavor value
	 * @return the ts
	 */
	public static TS createHl7CdaR2NullFlavorTs(NullFlavor nullFlavor) {
		ObjectFactory factory = new ObjectFactory();
		final TS ts = factory.createTS();
		ts.nullFlavor = new ArrayList<String>();
		if (nullFlavor == null) {
			ts.nullFlavor.add(NullFlavor.UNKNOWN.getCodeValue());
		} else {
			ts.nullFlavor.add(nullFlavor.getCodeValue());
		}
		return ts;
	}

	/**
	 * <div class="en">Creates an instance of the HL7 CDA R2 data type
	 * corresponding to the given argument.</div>
	 *
	 * <div class="de">Erstellt eine Instanz des HL7 CDA R2 Datentyps, welcher
	 * dem angegebenen Argument entspricht.</div>
	 *
	 * @param value
	 *            the value
	 * @return the st
	 */
	public static ST createHl7CdaR2St(String value) {
		ObjectFactory factory = new ObjectFactory();
		ST retVal = factory.createST();
		retVal.xmlContent = value;
		return retVal;
	}

	/**
	 * <div class="en">Creates an instance of the HL7 CDA R2 data type
	 * corresponding to the given argument.</div>
	 *
	 * <div class="de">Erstellt eine Instanz des HL7 CDA R2 Datentyps, welcher
	 * dem angegebenen Argument entspricht.</div>
	 *
	 * @param value
	 *            the value
	 * @return the struc doc text
	 */
	public static StrucDocText createHl7CdaR2StrucDocText(String value) {
		return createHl7CdaR2StrucDocText(null, null, value);
	}

	/**
	 * <div class="en">Creates an instance of the HL7 CDA R2 data type
	 * corresponding to the given arguments.</div>
	 *
	 * <div class="de">Erstellt eine Instanz des HL7 CDA R2 Datentyps, welcher
	 * den angegebenen Argumenten entspricht.</div>
	 *
	 * @param id
	 *            the id
	 * @param languageCode
	 *            the language code
	 * @param value
	 *            the value
	 * @return the struc doc text
	 */
	public static StrucDocText createHl7CdaR2StrucDocText(String id, LanguageCode languageCode,
			String value) {
		ObjectFactory factory = new ObjectFactory();
		StrucDocText retVal = factory.createStrucDocText();
		if (id != null)
			retVal.setID(id);
		if (languageCode != null)
			retVal.setLanguage(languageCode.getCodeValue());
		if (value != null)
			retVal.xmlContent = value;
		return retVal;
	}

	/**
	 * <div class="en">Generate the version string to be placed in the XML
	 * header of generated CDA documents.</div>
	 *
	 * <div class="de">Generiert die Versionszeichenfolge, die im XML-Header der
	 * generierten CDA-Dokumente platziert wird.</div>
	 *
	 * @return the string
	 */
	public static String generateVersionForCdaXmlHeaderComment() {
		return "Document based on CDA R2 generated by "
				+ EhcVersions.getCurrentVersion().getSystemVersionName() + ", Release Date "
				+ EhcVersions.getCurrentVersion().getReleaseDate();
	}

	/**
	 * <div class="en">Gets the full name of the given HL7 CDA R2 name
	 * object.</div>
	 *
	 * <div class="de">Ruft den vollständigen Namen des angegebenen HL7 CDA
	 * R2-Namensobjekts ab.</div>
	 *
	 * @param value
	 *            the value
	 * @return the full name
	 */
	public static String getFullName(EN value) {
		NameBaseType nameBt = Name.createNameBaseType(value);
		return nameBt.getFullName();
	}

	/**
	 * <div class="en">Gets the full name of the given HL7 CDA R2 name
	 * object.</div>
	 *
	 * <div class="de">Ruft den vollständigen Namen des angegebenen HL7 CDA
	 * R2-Namensobjekts ab.</div>
	 *
	 * @param value
	 *            the value
	 * @return the full name
	 */
	public static String getFullName(SC value) {
		return value.xmlContent;
	}

	/**
	 * <div class="en">Gets a list of HL7 CDA R2 data type instances
	 * corresponding to the return type, that are contained in the given
	 * section.</div>
	 *
	 * <div class="de">Ruft eine Liste der HL7 CDA R2-Datentypinstanzen ab, die
	 * dem Rückgabetyp entsprechen und im angegebenen Abschnitt enthalten
	 * sind.</div>
	 *
	 * @param section
	 *            the section
	 * @return the HL7 CDA R2 laboratory batteries
	 */
	public static ArrayList<POCDMT000040Organizer> getHl7CdaR2LaboratoryBatteries(
			POCDMT000040Section section) {
		ArrayList<POCDMT000040Organizer> retVal = new ArrayList<POCDMT000040Organizer>();
		for (POCDMT000040Entry entry : section.getEntry()) {
			if (entry.getAct() != null) {
				for (POCDMT000040EntryRelationship er : entry.getAct().getEntryRelationship()) {
					if (er.getOrganizer() != null)
						retVal.add(er.getOrganizer());
				}
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets a list of HL7 CDA R2 data type instances
	 * corresponding to the return type, that are contained in the given
	 * battery.</div>
	 *
	 * <div class="de">Ruft eine Liste der HL7 CDA R2-Datentypinstanzen ab, die
	 * dem Rückgabetyp entsprechen und in der angegebenen Batterie enthalten
	 * sind.</div>
	 *
	 * @param battery
	 *            the battery
	 * @return the laboratory observations
	 */
	public static ArrayList<POCDMT000040Observation> getHl7CdaR2LaboratoryObservations(
			POCDMT000040Organizer battery) {
		ArrayList<POCDMT000040Observation> retVal = new ArrayList<POCDMT000040Observation>();
		for (POCDMT000040Component4 comp : battery.getComponent()) {
			if (comp.getObservation() != null)
				retVal.add(comp.getObservation());
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets a list of HL7 CDA R2 data type instances
	 * corresponding to the return type, that are contained in the given
	 * document (structured body).</div>
	 *
	 * <div class="de">Ruft eine Liste der HL7 CDA R2-Datentypinstanzen ab, die
	 * dem Rückgabetyp entsprechen und im angegebenen Dokument (structured body)
	 * enthalten sind.</div>
	 *
	 * @param structuredBody
	 *            the structured body
	 * @return the sections
	 */
	public static ArrayList<POCDMT000040Section> getHl7CdaR2Sections(
			POCDMT000040StructuredBody structuredBody) {
		ArrayList<POCDMT000040Section> retVal = new ArrayList<POCDMT000040Section>();
		for (POCDMT000040Component3 comp3 : structuredBody.getComponent()) {
			retVal.add(comp3.getSection());
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the HL7 CDA R2 data type instance 'structured body'
	 * in the given CDA document.</div>
	 *
	 * <div class="de">Gets the HL7 CDA R2 data type instance 'structured body'
	 * in the given CDA document.</div>
	 *
	 * @param doc
	 *            the doc
	 * @return the structured body
	 */
	public static POCDMT000040StructuredBody getHl7CdaR2StructuredBody(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040ClinicalDocument doc) {
		POCDMT000040StructuredBody retVal = null;

		if (doc != null)
			if (doc.getComponent() != null)
				retVal = doc.getComponent().getStructuredBody();

		if (retVal == null) {
			ObjectFactory factory = new ObjectFactory();
			POCDMT000040Component2 comp2 = factory.createPOCDMT000040Component2();
			retVal = factory.createPOCDMT000040StructuredBody();
			comp2.setStructuredBody(retVal);
			doc.setComponent(comp2);
		}

		return retVal;
	}

	/**
	 * <div class="en">Gets a simple data type instance of the given HL7 CDA R2
	 * object.</div>
	 *
	 * <div class="de">Ruft eine Instanz eines einfache Datentyps vom
	 * angegebenen HL7 CDA R2-Objekt ab.</div>
	 *
	 * @param value
	 *            the value
	 * @return the int
	 */
	public static Integer getInt(INT value) {
		return value.getValue().intValue();
	}

	/**
	 * <div class="en">Gets the observation result of the given HL7 CDA R2
	 * observation as String.</div>
	 *
	 * <div class="de">Ruft das Beobachtungsergebnis der angegebenen HL7 CDA
	 * R2-Beobachtung als String ab.</div>
	 *
	 * @param obs
	 *            the obs
	 * @return the result
	 */
	public static String getLaboratoryObservationResult(POCDMT000040Observation obs) {
		String retVal = "";
		for (ANY value : obs.getValue()) {
			String tempOneValue = "";
			String tempOneUnit = "";
			if (value != null) {
				if (value instanceof PQ) {
					tempOneValue = ((PQ) value).getValue();
					if ("-1".equals(tempOneValue))
						tempOneValue = "-";
					tempOneUnit = ((PQ) value).getUnit();
				} else if (value instanceof INT) {
					tempOneValue = ((INT) value).getValue().toString();
				} else if (value instanceof BL) {
					tempOneValue = ((BL) value).isValue().toString();
				} else if (value instanceof CD) {
					tempOneValue = new Code(((CD) value)).toString();
				} else if (value instanceof ED) {
					tempOneValue = ((ED) value).xmlContent;
					tempOneValue = tempOneValue.replace("<", "&lt;");
					tempOneValue = tempOneValue.replace(">", "&gt;");
					tempOneValue = tempOneValue.trim();
					if (tempOneValue.replace("\n", "").equals(""))
						tempOneValue = "";
					if ("".equals(tempOneValue))
						tempOneValue = "empty String";
					if (((ED) value).getReference() != null) {
						String ref = ((ED) value).getReference().getValue();
						if (ref != null)
							tempOneValue += " (reference: " + ref + ")";
					}

				} else
					tempOneValue = value.getClass().getName() + " not supported yet for printing";
			}
			if (!"".equals(retVal))
				retVal = retVal + "<br />";
			if (!"".equals(tempOneValue) && !"".equals(tempOneUnit))
				retVal = tempOneValue + " " + tempOneUnit;
			else
				retVal = tempOneValue + tempOneUnit;
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the number of sections in the given CDA structured
	 * body.</div>
	 *
	 * <div class="de">Ruft die Anzahl der Abschnitte im angegebenen CDA
	 * structured body ab.</div>
	 *
	 * @param structuredBody
	 *            the structured body
	 * @return the section count
	 */
	public static int getSectionCount(POCDMT000040StructuredBody structuredBody) {
		int retVal = 0;
		if (structuredBody != null)
			if (structuredBody.getComponent() != null)
				retVal = structuredBody.getComponent().size();
		return retVal;
	}

	/**
	 * <div class="en">Sets the version number to 1 and makes sure the setId is
	 * the same as the document id.</div>
	 *
	 * <div class="de">Setzt die Versionsnummer auf 1 und stellt sicher, dass
	 * die setId mit der Dokument-ID übereinstimmt.</div>
	 *
	 * @param doc
	 *            the doc
	 * @param newDocId
	 *            the new doc id
	 */
	public static void initFirstVersion(POCDMT000040ClinicalDocument doc, Identificator newDocId) {
		Identificator docId = newDocId;
		if (docId == null)
			docId = new Identificator(Identificator.builder()
					.withRoot(org.openhealthtools.ihe.utils.UUID.generate()).build());
		doc.setId(docId.getHl7CdaR2Ii());
		setCdaDocVersion(doc, docId, 1);
	}

	/**
	 * <div class="en">Increases the version number by one and makes sure the
	 * setId remains the same as previously.</div>
	 *
	 * <div class="de">Erhöht die Versionsnummer um eins und stellt sicher, dass
	 * die setId unverändert bleibt.</div>
	 *
	 * @param doc
	 *            the doc
	 * @param newDocId
	 *            the new doc id
	 */
	public static void initNextVersion(POCDMT000040ClinicalDocument doc, Identificator newDocId) {
		org.ehealth_connector.common.hl7cdar2.II setId = doc.getSetId();
		if (setId == null)
			setId = doc.getId();
		if (setId == null)
			setId = newDocId.getHl7CdaR2Ii();
		Integer version = CdaUtil.getInt(doc.getVersionNumber());
		doc.setId(newDocId.getHl7CdaR2Ii());
		setCdaDocVersion(doc, new Identificator(setId), version + 1);
	}

	/**
	 * <div class="en">Loads the CDA document from file.</div>
	 *
	 * <div class="de">Lädt das CDA-Dokument aus einer Datei.</div>
	 *
	 * @param inputFile
	 *            the source file.
	 * @return the POCDMT 000040 clinical document
	 * @throws JAXBException
	 *             the JAXB exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static POCDMT000040ClinicalDocument loadCdaFromFile(File inputFile)
			throws JAXBException, IOException {
		POCDMT000040ClinicalDocument retVal;
		JAXBContext context = JAXBContext.newInstance(POCDMT000040ClinicalDocument.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<POCDMT000040ClinicalDocument> root = mar.unmarshal(source,
				POCDMT000040ClinicalDocument.class);
		retVal = root.getValue();
		return retVal;
	}

	/**
	 * <div class="en">Loads the CDA document from file.</div>
	 *
	 * <div class="de">Lädt das CDA-Dokument aus einer Datei.</div>
	 *
	 * @param inputFileName
	 *            the full path and filename of the sourcefile.
	 * @return the CDA document
	 * @throws JAXBException
	 *             the JAXB exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static POCDMT000040ClinicalDocument loadCdaFromFile(String inputFileName)
			throws JAXBException, IOException {
		return loadCdaFromFile(new File(inputFileName));
	}

	/**
	 * <div class="en">prints the XML representation of the document to the
	 * console</div>
	 *
	 * <div class="de">Gibt die XML-Repräsentation des Dokuments auf der Konsole
	 * aus</div>.
	 *
	 * @param cdaDoc
	 *            the cda doc
	 * @throws JAXBException
	 *             the JAXB exception
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws TransformerException
	 *             the transformer exception
	 */
	public static void printCdaToConsole(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040ClinicalDocument cdaDoc)
			throws JAXBException, ParserConfigurationException, TransformerException {
		org.ehealth_connector.cda.utils.CdaUtil.saveJaxbObjectToStream(cdaDoc, System.out, null,
				null);
	}

	/**
	 * <div class="en">Saves the given CDA document to file.</div>
	 *
	 * <div class="de">Speichert das angegebene CDA-Dokument in einer
	 * Datei.</div>
	 *
	 * @param doc
	 *            the doc
	 * @param outputFile
	 *            the destination file.
	 * @param xsl
	 *            the path and filename or url to the rendering stylesheet
	 * @param css
	 *            the path and filename or url to the rendering css
	 * @throws JAXBException
	 *             the JAXB exception
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws TransformerException
	 *             the transformer exception
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public static void saveCdaToFile(POCDMT000040ClinicalDocument doc, File outputFile, String xsl,
			String css) throws JAXBException, ParserConfigurationException, TransformerException,
			FileNotFoundException {
		CdaUtil.saveJaxbObjectToFile(doc, outputFile, xsl, css);
	}

	/**
	 * <div class="en">Saves the given CDA document to file.</div>
	 *
	 * <div class="de">Speichert das angegebene CDA-Dokument in einer
	 * Datei.</div>
	 *
	 * @param doc
	 *            the doc
	 * @param outputFileName
	 *            the full path and filename of the destination file.
	 * @param xsl
	 *            the path and filename or url to the rendering stylesheet
	 * @param css
	 *            the path and filename or url to the rendering css
	 * @throws JAXBException
	 *             the JAXB exception
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws TransformerException
	 *             the transformer exception
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public static void saveCdaToFile(POCDMT000040ClinicalDocument doc, String outputFileName,
			String xsl, String css) throws JAXBException, ParserConfigurationException,
			TransformerException, FileNotFoundException {
		saveCdaToFile(doc, new File(outputFileName), xsl, css);
	}

	/**
	 * <div class="en">Saves the given JAXB object to file.</div>
	 *
	 * <div class="de">Speichert das angegebene JAXB object in einer
	 * Datei.</div>
	 *
	 * @param jaxbObject
	 *            the jaxb object
	 * @param outputFile
	 *            the output file
	 * @param xsl
	 *            the xsl
	 * @param css
	 *            the css
	 * @throws JAXBException
	 *             the JAXB exception
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws TransformerException
	 *             the transformer exception
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public static void saveJaxbObjectToFile(Object jaxbObject, File outputFile, String xsl,
			String css) throws JAXBException, ParserConfigurationException, TransformerException,
			FileNotFoundException {
		saveJaxbObjectToStream(jaxbObject, new FileOutputStream(outputFile), xsl, css);

	}

	/**
	 * <div class="en">Saves the given JAXB object to file.</div>
	 *
	 * <div class="de">Speichert das angegebene JAXB object in einer
	 * Datei.</div>
	 *
	 * @param jaxbObject
	 *            the jaxb object
	 * @param outputFileName
	 *            the output file name
	 * @param xsl
	 *            the xsl
	 * @param css
	 *            the css
	 * @throws JAXBException
	 *             the JAXB exception
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws TransformerException
	 *             the transformer exception
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public static void saveJaxbObjectToFile(Object jaxbObject, String outputFileName, String xsl,
			String css) throws JAXBException, ParserConfigurationException, TransformerException,
			FileNotFoundException {
		saveJaxbObjectToFile(jaxbObject, new File(outputFileName), xsl, css);
	}

	/**
	 * <div class="en">Saves the given JAXB object to stream.</div>
	 *
	 * <div class="de">Speichert das angegebene JAXB object in einen
	 * Stream.</div>
	 *
	 * @param jaxbObject
	 *            the jaxb object
	 * @param outputStream
	 *            the output stream
	 * @param xsl
	 *            the xsl
	 * @param css
	 *            the css
	 * @throws JAXBException
	 *             the JAXB exception
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws TransformerException
	 *             the transformer exception
	 */
	public static void saveJaxbObjectToStream(Object jaxbObject, OutputStream outputStream,
			String xsl, String css)
			throws JAXBException, ParserConfigurationException, TransformerException {
		final JAXBContext context = JAXBContext.newInstance(jaxbObject.getClass());
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		final DocumentBuilder builder = factory.newDocumentBuilder();
		final Document doc = builder.getDOMImplementation().createDocument(null, null, null);

		final Binder<Node> binder = context.createBinder();
		final Comment comment = doc.createComment(CdaUtil.generateVersionForCdaXmlHeaderComment());
		doc.appendChild(comment);
		doc.appendChild(doc.createProcessingInstruction("xml-stylesheet",
				"type=\"text/css\" href=\"" + css + "\""));
		doc.appendChild(doc.createProcessingInstruction("xml-stylesheet",
				"type=\"text/xsl\" href=\"" + xsl + "\""));

		binder.marshal(jaxbObject, doc);

		final DOMSource domSource = new DOMSource(doc);
		final StreamResult streamResult = new StreamResult(outputStream);
		final TransformerFactory tf = TransformerFactory.newInstance();
		final Transformer transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		transformer.transform(domSource, streamResult);

	}

	/**
	 * <div class="en">Sets the document set Id and version number.</div>
	 *
	 * <div class="de">Weist dem Dokument eine Set Id und eine Versionsnummer
	 * zu.</div>
	 *
	 * @param doc
	 *            the doc
	 * @param idVersion1
	 *            the set Id (if null, the document ID will be used)
	 * @param version
	 *            the version of the document
	 */
	public static void setCdaDocVersion(POCDMT000040ClinicalDocument doc, Identificator idVersion1,
			int version) {
		doc.setSetId(idVersion1.getHl7CdaR2Ii());
		doc.setVersionNumber(Hl7CdaR2Util.createHl7CdaR2Int(version));
	}

	/**
	 * <div class="en">Sets given substance as ingredient to the given
	 * ingredient.</div>
	 *
	 * <div class="de">Setzt die angegebene substance als ingredient auf den
	 * angegebenen ingredient.</div>
	 *
	 * @param ingredient
	 *            the ingredient
	 * @param substance
	 *            the substance
	 */
	public static void setIngredientSubstance(COCTMT230100UVIngredient ingredient,
			COCTMT230100UVSubstance substance) {

		ingredient.setIngredient(
				new JAXBElement<COCTMT230100UVSubstance>(new QName("urn:ihe:pharm", "ingredient"),
						COCTMT230100UVSubstance.class, substance));
	}

	/**
	 * <div class="en">Sets the given text to the given section.</div>
	 *
	 * <div class="de">Setzt den angegebenen Text im angegebenen
	 * Abschnitt.</div>
	 *
	 * Sets the section text.
	 *
	 * @param structuredBody
	 *            the structured body
	 * @param section
	 *            the section
	 * @param languageCode
	 *            the language code
	 * @param value
	 *            the value
	 * @param contentIdCounter
	 *            the content id counter
	 */
	public static void setSectionText(POCDMT000040StructuredBody structuredBody,
			POCDMT000040Section section, LanguageCode languageCode, String value,
			int contentIdCounter) {
		String temp = "section"
				+ ("000" + Integer.toString(CdaUtil.getSectionCount(structuredBody) + 1)).substring(
						Integer.toString(CdaUtil.getSectionCount(structuredBody) + 1).length());
		StrucDocText strucDocText = CdaUtil.createHl7CdaR2StrucDocText(temp, languageCode, value);
		ObjectFactory factory = new ObjectFactory();
		StrucDocContent contentId = factory.createStrucDocContent();
		String contentIdStr = "dummy";
		if (contentIdCounter > 0)
			contentIdStr += Integer.toString(contentIdCounter);
		contentId.setID(contentIdStr);
		strucDocText.getContent().add(new JAXBElement<StrucDocContent>(
				new QName("urn:hl7-org:v3", "content"), StrucDocContent.class, contentId));
		section.setText(strucDocText);
	}

	/**
	 * <div class="en">Sets the given text and title to the given section.</div>
	 *
	 * <div class="de">Setzt den angegebenen Text und Titel im angegebenen
	 * Abschnitt.</div>
	 *
	 * @param doc
	 *            the doc
	 * @param title
	 *            the title
	 * @param text
	 *            the text
	 */
	public static void setSectionTitleText(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040ClinicalDocument doc, String title,
			String text) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040Section section = factory
				.createPOCDMT000040Section();
		section.setTitle(CdaUtil.createHl7CdaR2St(title));
		section.setText(CdaUtil.createHl7CdaR2StrucDocText(text));
		POCDMT000040StructuredBody structuredBody = CdaUtil.getHl7CdaR2StructuredBody(doc);
		POCDMT000040Component3 comp3 = factory.createPOCDMT000040Component3();

		// complete section
		comp3.setSection(section);
		structuredBody.getComponent().add(comp3);
	}

}
