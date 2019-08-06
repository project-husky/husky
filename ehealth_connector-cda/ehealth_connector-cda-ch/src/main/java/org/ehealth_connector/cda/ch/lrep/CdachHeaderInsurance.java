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
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.ehealth_connector.common.CdaNamespacePrefixMapper;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040ClinicalDocument;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.15
 * Template description: Information on a patient's insurance. CDA-CH V2 derivatives, i.e. Swiss exchange formats MAY use this template by either reference or specialisation.
 *
 * Element description: Information on a patient's insurance.
 */
public class CdachHeaderInsurance extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant1 {

	private org.ehealth_connector.common.hl7cdar2.POCDMT000040AssociatedEntity hl7AssociatedEntity;

	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId;

	/**
	 * Validity period of the contract.
	 */
	private org.ehealth_connector.common.hl7cdar2.IVLTS hl7Time;

	/**
	 * Gets the hl7AssociatedEntity
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040AssociatedEntity getHl7AssociatedEntity() {
		return hl7AssociatedEntity;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId() {
		return hl7TemplateId;
	}

	/**
	 * Gets the hl7Time
	 * Validity period of the contract.
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLTS getHl7Time() {
		return hl7Time;
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
	 * Sets the hl7AssociatedEntity
	 */
	public void setHl7AssociatedEntity(org.ehealth_connector.common.hl7cdar2.POCDMT000040AssociatedEntity value) {
		hl7AssociatedEntity = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7TemplateId = value;
	}

	/**
	 * Sets the hl7Time
	 * Validity period of the contract.
	 */
	public void setHl7Time(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
		hl7Time = value;
	}
}
