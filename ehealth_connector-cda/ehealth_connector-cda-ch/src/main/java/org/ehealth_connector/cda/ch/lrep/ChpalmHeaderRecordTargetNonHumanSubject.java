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
import javax.xml.transform.stream.StreamSource;
import org.ehealth_connector.common.CdaNamespacePrefixMapper;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.26
 * Template description: ClinicalDocument/recordTarget SHALL be present and SHALL conform to the Human Patient, Non-Human Subject or Human Patient with Non-Human Subject templates defined below. There are three varieties of laboratory reports:
 * - Human (patient): The document reports laboratory observations produced on specimens collected exclusively from the patient.
 * - Non-Human Subject: The document reports laboratory observations produced on specimens collected from a non-human material (e.g. water, milk…) or living subject (e.g. animal).
 * - Human (patient) paired with Non-Human Subject: The document reports laboratory observations produced on a non-human specimen with a relationship to a human patient, (e.g. peanut butter eaten by a patient, a ferret that bit a patient).Non-Human SubjectWhen the subject of the observations in the report is a sample exclusively taken from a non-human subject, such as an animal, a lake, soil or other environmental element, the following SHALL be present.
 * - &lt;templateId root="1.3.6.1.4.1.19376.1.3.3.1.2"/&gt; - The templateId element identifies this recordTarget as a non-human subject of laboratory testing. The templateId SHALL have root="1.3.6.1.4.1.19376.1.3.3.1.2".
 * - &lt;id/&gt; - /patientRole/id SHALL be present and SHALL represent the id of the non-human subject.
 * - &lt;patient@nullFlavor/&gt; - The recordTarget/patientRole SHALL have a patient sub-element and its nullFlavor SHALL be set to "OTH". This indicates that other information pertaining to the non-human subject can be found in the body of the document.
 * - &lt;structuredBody&gt; mark-up - In addition to the elements specified in the CDA header for the non-human subject, this non-human subject SHALL be represented in a Subject element in level 3 entries in the structuredBody as described in template Non-Human Subject 1.3.6.1.4.1.19376.1.3.3.1.2.1.
 *
 * Element description: Non-Human Subject.
 */
public class ChpalmHeaderRecordTargetNonHumanSubject extends org.ehealth_connector.common.hl7cdar2.POCDMT000040RecordTarget {

	public ChpalmHeaderRecordTargetNonHumanSubject() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.3.3.1.2"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.2.26"));
	}

	/**
	 * Creates fixed contents for hl7TemplateId
	 *
	 * @param root the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.II retVal = factory.createII();
		retVal.setRoot(root);
		return retVal;
	}

	/**
	 * Gets the hl7PatientRole
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040PatientRole getHl7PatientRole() {
		return super.patientRole;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId() {
		org.ehealth_connector.common.hl7cdar2.II retVal = null;
		if (super.getTemplateId() != null)
			if (super.getTemplateId().size() > 0)
				retVal = super.getTemplateId().get(0);
		return retVal;
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFileName the full path and filename of the sourcefile.
	 * @return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static ChpalmHeaderRecordTargetNonHumanSubject loadFromFile(String inputFileName) throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFile the source file.
	 * n@return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static ChpalmHeaderRecordTargetNonHumanSubject loadFromFile(File inputFile) throws JAXBException, IOException {
		ChpalmHeaderRecordTargetNonHumanSubject retVal;
		JAXBContext context = JAXBContext.newInstance(ChpalmHeaderRecordTargetNonHumanSubject.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<ChpalmHeaderRecordTargetNonHumanSubject> root = mar.unmarshal(source, ChpalmHeaderRecordTargetNonHumanSubject.class);
		retVal = root.getValue();
		return retVal;
	}

	/**
	 * Saves the current CDA document to file.
	 * @param outputFileName the full path and filename of the destination file.
	 * @throws JAXBException
	 */
	public void saveToFile(String outputFileName) throws JAXBException {
		saveToFile(new File(outputFileName));
	}

	/**
	 * Saves the current CDA document to file.
	 * @param outputFile the destination file.
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
	 * Sets the hl7PatientRole
	 */
	public void setHl7PatientRole(org.ehealth_connector.common.hl7cdar2.POCDMT000040PatientRole value) {
		super.patientRole = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		super.getTemplateId().clear();
		super.getTemplateId().add(value);
	}
}
