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
package org.ehealth_connector.cda.ch.lrep;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

import org.ehealth_connector.common.CdaNamespacePrefixMapper;
import org.ehealth_connector.common.hl7cdar2.EnFamily;
import org.ehealth_connector.common.hl7cdar2.EnGiven;
import org.ehealth_connector.common.hl7cdar2.EnPrefix;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.9.34 Template
 * description: Person name information (with required family and given name)
 * according to the eCH-0011 V8.1 nameData data type. CDA-CH V2 derivatives,
 * i.e. Swiss exchange formats MAY use this template by either reference or
 * specialisation.See
 * https://www.ech.ch/vechweb/page?p=dossier&amp;documentNumber=eCH-0011&amp;documentVersion=8.1,
 * section 3.3.2 nameData – Namensangaben for more information.
 *
 * Element description: The person's legal name (with required family and given
 * name).
 */
public class CdachOtherPersonNameInformationCompilationECh0011
		extends org.ehealth_connector.common.hl7cdar2.PN {

	/**
	 * Loads the CDA document from file.
	 *
	 * @param inputFile
	 *            the source file. n@return the CDA document\n@throws
	 *            JAXBException\n@throws IOException Signals that an I/O
	 *            exception has occurred.
	 */
	public static CdachOtherPersonNameInformationCompilationECh0011 loadFromFile(File inputFile)
			throws JAXBException, IOException {
		CdachOtherPersonNameInformationCompilationECh0011 retVal;
		JAXBContext context = JAXBContext
				.newInstance(CdachOtherPersonNameInformationCompilationECh0011.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<CdachOtherPersonNameInformationCompilationECh0011> root = mar.unmarshal(source,
				CdachOtherPersonNameInformationCompilationECh0011.class);
		retVal = root.getValue();
		return retVal;
	}

	/**
	 * Loads the CDA document from file.
	 *
	 * @param inputFileName
	 *            the full path and filename of the sourcefile.
	 * @return the CDA document\n@throws JAXBException\n@throws IOException
	 *         Signals that an I/O exception has occurred.
	 */
	public static CdachOtherPersonNameInformationCompilationECh0011 loadFromFile(
			String inputFileName) throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	public CdachOtherPersonNameInformationCompilationECh0011() {
		setHl7PrefixFixedValue("AC");
		setHl7FamilyFixedValue("BR");
		setHl7GivenFixedValue("CL");
	}

	/**
	 * Adds a hl7Family The person's family name ([ge]: Nachname; [fr]: nom de
	 * famille).
	 */
	public void addHl7Family(org.ehealth_connector.common.hl7cdar2.ENXP value) {
		EnFamily obj = new EnFamily();
		obj.xmlContent = value.xmlContent;
		getContent().add(new JAXBElement<EnFamily>(new QName("hl7:family"), EnFamily.class, obj));
	}

	/**
	 * Adds a hl7Given The person's given name ([ge]: Vorname; [fr]: prénom).
	 */
	public void addHl7Given(org.ehealth_connector.common.hl7cdar2.ENXP value) {
		EnGiven obj = new EnGiven();
		obj.xmlContent = value.xmlContent;
		getContent().add(new JAXBElement<EnGiven>(new QName("hl7:given"), EnGiven.class, obj));
	}

	/**
	 * Adds a hl7Prefix The person's academic title (such as Dr. med. or Prof.).
	 */
	public void addHl7Prefix(org.ehealth_connector.common.hl7cdar2.ENXP value) {
		EnPrefix obj = new EnPrefix();
		obj.xmlContent = value.xmlContent;
		getContent().add(new JAXBElement<EnPrefix>(new QName("hl7:prefix"), EnPrefix.class, obj));
	}

	/**
	 * Saves the current CDA document to file.
	 *
	 * @param outputFile
	 *            the destination file.
	 * @throws JAXBException
	 */
	public void saveToFile(File outputFile) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(this.getClass());
		Marshaller mar = context.createMarshaller();
		mar.setProperty("com.sun.xml.bind.namespacePrefixMapper", new CdaNamespacePrefixMapper());
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		mar.marshal(this, outputFile);
	}

	/**
	 * Saves the current CDA document to file.
	 *
	 * @param outputFileName
	 *            the full path and filename of the destination file.
	 * @throws JAXBException
	 */
	public void saveToFile(String outputFileName) throws JAXBException {
		saveToFile(new File(outputFileName));
	}

	/**
	 * Creates fixed contents for hl7Family
	 *
	 * @param qualifier
	 *            the desired fixed value for this argument.
	 */
	public void setHl7FamilyFixedValue(String qualifier) {
		ObjectFactory factory = new ObjectFactory();
	}

	/**
	 * Creates fixed contents for hl7Given
	 *
	 * @param qualifier
	 *            the desired fixed value for this argument.
	 */
	public void setHl7GivenFixedValue(String qualifier) {
		ObjectFactory factory = new ObjectFactory();
	}

	/**
	 * Creates fixed contents for hl7Prefix
	 *
	 * @param qualifier
	 *            the desired fixed value for this argument.
	 */
	public void setHl7PrefixFixedValue(String qualifier) {
		ObjectFactory factory = new ObjectFactory();
	}
}
