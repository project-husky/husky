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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;

import javax.xml.bind.Binder;
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

import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.basetypes.NameBaseType;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.enums.NullFlavor;
import org.ehealth_connector.common.hl7cdar2.AD;
import org.ehealth_connector.common.hl7cdar2.ANY;
import org.ehealth_connector.common.hl7cdar2.AdxpCity;
import org.ehealth_connector.common.hl7cdar2.AdxpCountry;
import org.ehealth_connector.common.hl7cdar2.AdxpPostalCode;
import org.ehealth_connector.common.hl7cdar2.BL;
import org.ehealth_connector.common.hl7cdar2.CE;
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
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Organizer;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Section;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040StructuredBody;
import org.ehealth_connector.common.hl7cdar2.PQ;
import org.ehealth_connector.common.hl7cdar2.SC;
import org.ehealth_connector.common.hl7cdar2.ST;
import org.ehealth_connector.common.hl7cdar2.StrucDocText;
import org.ehealth_connector.common.hl7cdar2.TS;
import org.ehealth_connector.common.mdht.enums.EhcVersions;
import org.ehealth_connector.common.utils.Hl7CdaR2Util;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class CdaUtil {

	public static void addNarrativeTextSection(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040ClinicalDocument doc, String title,
			String text) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040Section section = factory
				.createPOCDMT000040Section();
		section.setTitle(CdaUtil.createSt(title));
		section.setText(CdaUtil.createStrucDocText(text));
		POCDMT000040StructuredBody structuredBody = CdaUtil.getStructuredBody(doc);
		POCDMT000040Component3 comp3 = factory.createPOCDMT000040Component3();

		// complete section
		comp3.setSection(section);
		structuredBody.getComponent().add(comp3);
	}

	public static BL createBl(boolean value) {
		ObjectFactory factory = new ObjectFactory();
		BL retVal = factory.createBL();
		retVal.setValue(value);
		return retVal;
	}

	public static CE createCe(String code, String codeSystem) {
		ObjectFactory factory = new ObjectFactory();
		CE retVal = factory.createCE();
		retVal.setCode(code);
		retVal.setCodeSystem(codeSystem);
		return retVal;
	}

	public static CS createCs(String value) {
		ObjectFactory factory = new ObjectFactory();
		CS retVal = factory.createCS();
		retVal.setCode(value);
		return retVal;
	}

	public static ED createEd(String value) {
		ObjectFactory factory = new ObjectFactory();
		ED retVal = factory.createED();
		retVal.xmlContent = value;
		return retVal;
	}

	public static INT createInt(int i) {
		ObjectFactory factory = new ObjectFactory();
		INT retVal = factory.createINT();
		retVal.setValue(BigInteger.valueOf(i));
		return retVal;
	}

	public static INT createIntUnknown(NullFlavor value) {
		ObjectFactory factory = new ObjectFactory();
		final INT i = factory.createINT();
		if (value == null) {
			i.nullFlavor.add(NullFlavor.UNKNOWN.getCodeValue());
		} else {
			i.nullFlavor.add(value.getCodeValue());
		}
		return i;
	}

	public static IVLINT createIvlInt(String lowValue, String highValue) {
		ObjectFactory factory = new ObjectFactory();
		IVLINT retVal = factory.createIVLINT();

		INT intLow = null;
		if (lowValue == null) {
			intLow = createIntUnknown(null);
		} else {
			intLow = factory.createINT();
			intLow.setValue(BigInteger.valueOf(Integer.parseInt(lowValue)));
		}

		INT intHigh = null;
		if (highValue == null) {
			intHigh = createIntUnknown(null);
		} else {
			intHigh = factory.createINT();
			intHigh.setValue(BigInteger.valueOf(Integer.parseInt(highValue)));
		}

		retVal.getRest()
				.add(new JAXBElement<INT>(new QName("urn:hl7-org:v3", "low"), INT.class, intLow));
		retVal.getRest()
				.add(new JAXBElement<INT>(new QName("urn:hl7-org:v3", "high"), INT.class, intHigh));
		return retVal;
	}

	public static IVLPQ createIvlpq(String centerValue, String unit) {
		ObjectFactory factory = new ObjectFactory();
		IVLPQ retVal = factory.createIVLPQ();
		if (unit != null)
			retVal.setUnit(unit);

		PQ pqCenter = null;
		if (centerValue == null) {
			pqCenter = createPqUnknown(null);
		} else {
			pqCenter = factory.createPQ();
			pqCenter.setValue(centerValue);
		}

		retVal.getRest().add(
				new JAXBElement<PQ>(new QName("urn:hl7-org:v3", "center"), PQ.class, pqCenter));
		return retVal;
	}

	public static IVLPQ createIvlpq(String lowValue, String highValue, String unit) {
		ObjectFactory factory = new ObjectFactory();
		IVLPQ retVal = factory.createIVLPQ();
		if (unit != null)
			retVal.setUnit(unit);

		PQ pqLow = null;
		if (lowValue == null) {
			pqLow = createPqUnknown(null);
		} else {
			pqLow = factory.createPQ();
			pqLow.setValue(lowValue);
		}

		PQ pqHigh = null;
		if (highValue == null) {
			pqHigh = createPqUnknown(null);
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

	public static PQ createPqUnknown(NullFlavor value) {
		ObjectFactory factory = new ObjectFactory();
		final PQ pq = factory.createPQ();
		if (value == null) {
			pq.nullFlavor.add(NullFlavor.UNKNOWN.getCodeValue());
		} else {
			pq.nullFlavor.add(value.getCodeValue());
		}
		return pq;
	}

	public static ST createSt(String value) {
		ObjectFactory factory = new ObjectFactory();
		ST retVal = factory.createST();
		retVal.xmlContent = value;
		return retVal;
	}

	public static StrucDocText createStrucDocText(String value) {
		return createStrucDocText(null, null, value);
	}

	public static StrucDocText createStrucDocText(String id, LanguageCode languageCode,
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

	public static TS createTsUnknown(NullFlavor value) {
		ObjectFactory factory = new ObjectFactory();
		final TS ts = factory.createTS();
		if (value == null) {
			ts.nullFlavor.add(NullFlavor.UNKNOWN.getCodeValue());
		} else {
			ts.nullFlavor.add(value.getCodeValue());
		}
		return ts;
	}

	/**
	 * Generate comment.
	 *
	 * @return the string
	 */
	public static String generateXmlHeaderComment() {
		return "Document based on CDA R2 generated by "
				+ EhcVersions.getCurrentVersion().getSystemVersionName() + ", Release Date "
				+ EhcVersions.getCurrentVersion().getReleaseDate();
	}

	public static String getFullName(EN en) {
		NameBaseType nameBt = Name.createNameBaseType(en);
		return nameBt.getFullName();
	}

	public static String getFullName(SC value) {
		return value.xmlContent;
	}

	public static Integer getInt(INT value) {
		return value.getValue().intValue();
	}

	public static ArrayList<POCDMT000040Organizer> getLaboratoryBatteries(
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
	 * Gets the result.
	 *
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
				} else if (value instanceof BL) {
					tempOneValue = ((BL) value).isValue().toString();
				} else if (value instanceof ED) {
					tempOneValue = ((ED) value).xmlContent;
					tempOneValue = tempOneValue.replace("<", "&lt;");
					tempOneValue = tempOneValue.replace(">", "&gt;");
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

	public static ArrayList<POCDMT000040Observation> getLaboratoryObservations(
			POCDMT000040Organizer battery) {
		ArrayList<POCDMT000040Observation> retVal = new ArrayList<POCDMT000040Observation>();
		for (POCDMT000040Component4 comp : battery.getComponent()) {
			if (comp.getObservation() != null)
				retVal.add(comp.getObservation());
		}
		return retVal;
	}

	public static AD getNullflaveredAddress() {

		ObjectFactory factory = new ObjectFactory();
		AD addr = factory.createAD();
		addr.nullFlavor = new ArrayList<String>();
		addr.nullFlavor.add(NullFlavor.UNKNOWN.getCodeValue());

		AdxpPostalCode postalCode = factory.createAdxpPostalCode();
		postalCode.nullFlavor = new ArrayList<String>();
		postalCode.nullFlavor.add(NullFlavor.UNKNOWN.getCodeValue());
		addr.getContent().add(new JAXBElement<AdxpPostalCode>(
				new QName("urn:hl7-org:v3", "postalCode"), AdxpPostalCode.class, postalCode));

		AdxpCity city = factory.createAdxpCity();
		city.nullFlavor = new ArrayList<String>();
		city.nullFlavor.add(NullFlavor.UNKNOWN.getCodeValue());
		addr.getContent().add(new JAXBElement<AdxpCity>(new QName("urn:hl7-org:v3", "city"),
				AdxpCity.class, city));

		AdxpCountry country = factory.createAdxpCountry();
		country.nullFlavor = new ArrayList<String>();
		country.nullFlavor.add(NullFlavor.UNKNOWN.getCodeValue());
		addr.getContent().add(new JAXBElement<AdxpCountry>(new QName("urn:hl7-org:v3", "country"),
				AdxpCountry.class, country));

		return addr;

	}

	public static int getSectionCount(POCDMT000040StructuredBody structuredBody) {
		int retVal = 0;
		if (structuredBody != null)
			if (structuredBody.getComponent() != null)
				retVal = structuredBody.getComponent().size();
		return retVal;
	}

	public static ArrayList<POCDMT000040Section> getSections(
			POCDMT000040StructuredBody structuredBody) {
		ArrayList<POCDMT000040Section> retVal = new ArrayList<POCDMT000040Section>();
		for (POCDMT000040Component3 comp3 : structuredBody.getComponent()) {
			retVal.add(comp3.getSection());
		}
		return retVal;
	}

	public static POCDMT000040StructuredBody getStructuredBody(
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
	 * Sets the version number to 1 and makes sure the setId is the same as the
	 * document id.
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
		setVersion(doc, docId, 1);
	}

	/**
	 * Increases the version number by one and makes sure the setId remains the
	 * same as previously.
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
		setVersion(doc, new Identificator(setId), version + 1);
	}

	/**
	 * Loads the CDA document from file.
	 *
	 * @param inputFile
	 *            the source file. n@return the CDA document\n@throws
	 *            JAXBException the JAXB exception\n@throws IOException Signals
	 *            that an I/O exception has occurred.
	 */
	public static POCDMT000040ClinicalDocument loadFromFile(File inputFile)
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
	 * Loads the CDA document from file.
	 *
	 * @param inputFileName
	 *            the full path and filename of the sourcefile.
	 * @return the CDA document\n@throws JAXBException the JAXB
	 *         exception\n@throws IOException Signals that an I/O exception has
	 *         occurred.
	 */
	public static POCDMT000040ClinicalDocument loadFromFile(String inputFileName)
			throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	/**
	 * <div class="en">prints the XML representation of the document to the
	 * console</div> <div class="de">Gibt die XML-Repräsentation des Dokuments
	 * auf der Konsole aus</div>.
	 *
	 * @throws TransformerException
	 * @throws ParserConfigurationException
	 * @throws JAXBException
	 */
	public static void printCdaToConsole(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040ClinicalDocument cdaDoc)
			throws JAXBException, ParserConfigurationException, TransformerException {
		org.ehealth_connector.cda.utils.CdaUtil.saveJaxbObjectToStream(cdaDoc, System.out, null,
				null);
	}

	public static void saveJaxbObjectToFile(Object jaxbObject, File outputFile, String xsl,
			String css) throws JAXBException, ParserConfigurationException, TransformerException,
			FileNotFoundException {
		saveJaxbObjectToStream(jaxbObject, new FileOutputStream(outputFile), xsl, css);

	}

	public static void saveJaxbObjectToFile(Object jaxbObject, String outputFileName, String xsl,
			String css) throws JAXBException, ParserConfigurationException, TransformerException,
			FileNotFoundException {
		saveJaxbObjectToFile(jaxbObject, new File(outputFileName), xsl, css);
	}

	public static void saveJaxbObjectToStream(Object jaxbObject, OutputStream outputStream,
			String xsl, String css)
			throws JAXBException, ParserConfigurationException, TransformerException {
		final JAXBContext context = JAXBContext.newInstance(jaxbObject.getClass());
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		final DocumentBuilder builder = factory.newDocumentBuilder();
		final Document doc = builder.getDOMImplementation().createDocument(null, null, null);

		final Binder<Node> binder = context.createBinder();
		final Comment comment = doc.createComment(CdaUtil.generateXmlHeaderComment());
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
	 * Saves the given CDA document to file.
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
	 *             the transformer exception\n@throws FileNotFoundException the
	 *             file not found exception
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public static void saveToFile(POCDMT000040ClinicalDocument doc, File outputFile, String xsl,
			String css) throws JAXBException, ParserConfigurationException, TransformerException,
			FileNotFoundException {
		CdaUtil.saveJaxbObjectToFile(doc, outputFile, xsl, css);
	}

	/**
	 * Saves the given CDA document to file.
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
	 *             the transformer exception\n@throws FileNotFoundException the
	 *             file not found exception
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public static void saveToFile(POCDMT000040ClinicalDocument doc, String outputFileName,
			String xsl, String css) throws JAXBException, ParserConfigurationException,
			TransformerException, FileNotFoundException {
		saveToFile(doc, new File(outputFileName), xsl, css);
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
	public static void setVersion(POCDMT000040ClinicalDocument doc, Identificator idVersion1,
			int version) {
		doc.setSetId(idVersion1.getHl7CdaR2Ii());
		doc.setVersionNumber(Hl7CdaR2Util.createHl7CdaR2Int(version));
	}
}
