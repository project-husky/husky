/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.61
 * Template description: Legal authenticator.
 *
 * Element description: Legal authenticator.
 */
public class CdachlrepHeaderLegalAuthenticator extends org.ehealth_connector.common.hl7cdar2.POCDMT000040LegalAuthenticator {

	public CdachlrepHeaderLegalAuthenticator() {
		setHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.2.61");
		setHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.2.5");
		setHl7SignatureCodeFixedValue("S", "2.16.840.1.113883.1.11.10282", "ParticipationSignature", "signed");
	}

	/**
	 * Gets the hl7AssignedEntity
	 * The GLN MUST be used to identify the legal authenticator (e.g., laboratory manager or responsible physician). All persons and organizations, MUST according to XD-LAB contain name, addr and telecom.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040AssignedEntity getHl7AssignedEntity() {
		return super.assignedEntity;
	}

	/**
	 * Gets the hl7SignatureCode
	 */
	public org.ehealth_connector.common.hl7cdar2.CS getHl7SignatureCode() {
		return super.signatureCode;
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
	 * Gets the hl7Time
	 * Date of the signature.
	 */
	public org.ehealth_connector.common.hl7cdar2.TS getHl7Time() {
		return super.time;
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFileName the full path and filename of the sourcefile.
	 * @return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static CdachlrepHeaderLegalAuthenticator loadFromFile(String inputFileName) throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFile the source file.
	 * n@return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static CdachlrepHeaderLegalAuthenticator loadFromFile(File inputFile) throws JAXBException, IOException {
		CdachlrepHeaderLegalAuthenticator retVal;
		JAXBContext context = JAXBContext.newInstance(CdachlrepHeaderLegalAuthenticator.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<CdachlrepHeaderLegalAuthenticator> root = mar.unmarshal(source, CdachlrepHeaderLegalAuthenticator.class);
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
	 * Sets the hl7AssignedEntity
	 * The GLN MUST be used to identify the legal authenticator (e.g., laboratory manager or responsible physician). All persons and organizations, MUST according to XD-LAB contain name, addr and telecom.
	 */
	public void setHl7AssignedEntity(org.ehealth_connector.common.hl7cdar2.POCDMT000040AssignedEntity value) {
		super.assignedEntity = value;
	}

	/**
	 * Sets the hl7SignatureCode
	 */
	public void setHl7SignatureCode(org.ehealth_connector.common.hl7cdar2.CS value) {
		super.signatureCode = value;
	}

	/**
	 * Creates fixed contents for hl7SignatureCode
	 *
	 * @param code the desired fixed value for this argument.
	 * @param codeSystem the desired fixed value for this argument.
	 * @param codeSystemName the desired fixed value for this argument.
	 * @param displayName the desired fixed value for this argument.
	 */
	public void setHl7SignatureCodeFixedValue(String code, String codeSystem, String codeSystemName, String displayName) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CS member = factory.createCS();
		member.setCode(code);
		member.setCodeSystem(codeSystem);
		member.setCodeSystemName(codeSystemName);
		member.setDisplayName(displayName);
		// setting the fixed value
		super.setSignatureCode(member);
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		super.getTemplateId().clear();
		super.getTemplateId().add(value);
	}

	/**
	 * Creates fixed contents for hl7TemplateId
	 *
	 * @param root the desired fixed value for this argument.
	 */
	public void setHl7TemplateIdFixedValue(String root) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.II member = factory.createII();
		member.setRoot(root);
		// setting the fixed value
		super.getTemplateId().add(member);
	}

	/**
	 * Sets the hl7Time
	 * Date of the signature.
	 */
	public void setHl7Time(org.ehealth_connector.common.hl7cdar2.TS value) {
		super.time = value;
	}
}
