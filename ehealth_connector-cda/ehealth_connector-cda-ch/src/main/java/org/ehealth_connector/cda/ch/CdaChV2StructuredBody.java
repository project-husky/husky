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
package org.ehealth_connector.cda.ch;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.bind.DatatypeConverter;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.AbstractCda;
import org.ehealth_connector.cda.DataEnterer;
import org.ehealth_connector.cda.ObservationMediaEntry;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.common.Person;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.AssignedEntity;
import org.openhealthtools.mdht.uml.cda.Authenticator;
import org.openhealthtools.mdht.uml.cda.Author;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.InformationRecipient;
import org.openhealthtools.mdht.uml.cda.RecordTarget;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.ST;

/**
 * @formatter:off
 * <div class="en">Implements a CDA document based on the CDA-CH V2 (2017) specification.</div>
 * <div class="de">Implementiert ein CDA-Dokument basierend auf der CDA-CH V2 (2017) Spezifikation.</div>
 * <div class="fr">TODO.</div>
 * @formatter:on
 *
 * @param <EClinicalDocument>
 *            the generic type
 */
public class CdaChV2StructuredBody<EClinicalDocument extends ClinicalDocument>
		extends AbstractCda<EClinicalDocument> {

	public CdaChV2StructuredBody(EClinicalDocument doc) {
		super(doc);
	}

	public CdaChV2StructuredBody(EClinicalDocument doc, LanguageCode languageCode,
			String stylesheet, String css) {
		super(doc, languageCode, stylesheet, css);
	}

	/**
	 * <div class="en">Adds an authenricator to the CDA document</div>
	 * <div class="de">Fügt dem CDA Dokument einen Unterzeichner hinzu</div>
	 *
	 * @param authenticator
	 *            Unterzeichner
	 */
	@Override
	public void addAuthenticator(org.ehealth_connector.common.Author author) {
		Authenticator authenticator = Util.createAuthenticatorFromAuthor(author);
		getDoc().getLegalAuthenticator().setTime(EcoreUtil.copy(author.getAuthorMdht().getTime()));
		CdaUtil.addTemplateIdOnce(authenticator, new Identificator("2.16.756.5.30.1.1.10.2.6"));
		super.addAuthenticator(authenticator);
	}

	/**
	 * <div class="en">Adds an author</div> <div class="de">Fügt einen Autoren
	 * hinzu</div>
	 *
	 * @param author
	 *            the autor
	 */
	@Override
	public void addAuthor(org.ehealth_connector.common.Author author) {
		final Author docAuthor = author.copyMdhtAuthor();
		CdaUtil.addTemplateIdOnce(docAuthor, new Identificator("2.16.756.5.30.1.1.10.9.23"));
		getDoc().getAuthors().add(docAuthor);
	}

	@Override
	public void initCda() {

		// Make sure the document contains all necessary templateIds
		CdaUtil.addTemplateIdOnce(getDoc(), new Identificator("2.16.840.1.113883.10.12.1"));
		CdaUtil.addTemplateIdOnce(getDoc(), new Identificator("2.16.840.1.113883.10.12.2"));
		CdaUtil.addTemplateIdOnce(getDoc(), new Identificator("2.16.756.5.30.1.1.1.1.4"));

		// Type ID
		setTypeId();

		// Set default Swiss EPR confidentiality code of the document (normal)
		setConfidentialityCode(org.ehealth_connector.common.ch.enums.ConfidentialityCode.NORMAL);

		// Set the basic elements of the document as default values
		Identificator id = new Identificator(org.openhealthtools.ihe.utils.UUID.generate());
		setId(id);
		setSetId(id);
		setVersion(id, 1);
		setTimestamp(DateUtil.nowAsDate());
	}

	/**
	 *
	 * Sets Swiss EPR Confidentially Code
	 *
	 * @param code
	 *            If null, "N" for "normal" will be set.
	 *
	 */
	public void setConfidentialityCode(
			org.ehealth_connector.common.ch.enums.ConfidentialityCode code) {
		CE confidentialityCode;
		if (code == null) {
			confidentialityCode = org.ehealth_connector.common.ch.enums.ConfidentialityCode.NORMAL
					.getCE();
		} else {
			confidentialityCode = code.getCE();
		}
		getDoc().setConfidentialityCode(confidentialityCode);
	}

	/**
	 * <div class="en">Sets an organization as the custodian of the
	 * document</div> <div class="de">Weist dem CDA Dokument die verwaltende
	 * Organisation zu</div>
	 *
	 * @param organization
	 *            <div class="en">custodian organization</div>
	 *            <div class="de">verwaltende Organisation</div>
	 */
	@Override
	public void setCustodian(Organization organization) {
		super.setCustodian(organization);
		CdaUtil.addTemplateIdOnce(getCustodian(), new Identificator("2.16.756.5.30.1.1.10.2.3"));

	}

	/**
	 * <div class="en">Adds a data enterer</div> <div class="de">Fügt dem CDA
	 * Dokument einen Erfasser hinzu</div>.
	 *
	 * @param dataEnterer
	 *            <div class="en">a person, which delivered content for this
	 *            document</div> <div class="de">Erfasser oder
	 *            Sachbearbeiter/-in, welche(r) das Dokument erstellt oder
	 *            Beiträge dazu geliefert hat.</div>
	 */
	@Override
	public void setDataEnterer(DataEnterer dataEnterer) {
		CdaUtil.addTemplateIdOnce(dataEnterer.getMdht(),
				new Identificator("2.16.756.5.30.1.1.10.2.7"));
		getDoc().setDataEnterer(dataEnterer.getMdht());
	}

	/**
	 * <div class="en">Adds a data enterer</div> <div class="de">Fügt dem CDA
	 * Dokument einen Erfasser hinzu</div>
	 *
	 * @param dataEnterer
	 *            <div class="en">a person, which delivered content for this
	 *            document</div> <div class="de">Erfasser oder
	 *            Sachbearbeiter/-in, welche(r) das Dokument erstellt oder
	 *            Beiträge dazu geliefert hat.</div>
	 */
	@Override
	public void setDataEnterer(Person dataEnterer) {
		final org.openhealthtools.mdht.uml.cda.DataEnterer enterer = CDAFactory.eINSTANCE
				.createDataEnterer();
		final AssignedEntity entity = CDAFactory.eINSTANCE.createAssignedEntity();

		entity.setAssignedPerson(dataEnterer.copyMdhtPerson());
		enterer.setAssignedEntity(entity);
		CdaUtil.addTemplateIdOnce(enterer, new Identificator("2.16.756.5.30.1.1.10.2.7"));
		getDoc().setDataEnterer(enterer);
	}

	/**
	 * <div class="en">Sets the legal authenticator of the document</div>
	 * <div class="de">Weist dem CDA Dokument einen rechtsgültigen Unterzeichner
	 * hinzu</div>
	 *
	 * @param legalAuthenticator
	 *            <div class="en">legal authenticator</div>
	 *            <div class="de">rechtsgültiger Unterzeichner</div>
	 */
	@Override
	public void setLegalAuthenticator(org.ehealth_connector.common.Author legalAuthenticator) {
		getDoc().setLegalAuthenticator(Util.createLegalAuthenticatorFromAuthor(legalAuthenticator));
		getDoc().getLegalAuthenticator()
				.setTime(EcoreUtil.copy(legalAuthenticator.getAuthorMdht().getTime()));
		CdaUtil.addTemplateIdOnce(getDoc().getLegalAuthenticator(),
				new Identificator("2.16.756.5.30.1.1.10.2.5"));
	}

	/**
	 * <div class="en">Adds the original representation section.</div>
	 *
	 * @param pdf
	 *            <div class="en">the pdf containing the original representation
	 *            in PDF/A format</div>
	 * @throws IOException
	 *             <div class="en">Signals that an I/O exception has
	 *             occurred.</div>
	 */
	public void setOriginalRepresentationSection(byte[] pdf) throws IOException {
		// TODO Add Template ID 2.16.756.5.30.1.1.10.1.14 ( CDA-CH v2.0 -
		// structuredBody enhanced) if it dos not exist
		Section s = CDAFactory.eINSTANCE.createSection();
		final II tIi = DatatypesFactory.eINSTANCE.createII();
		tIi.setRoot("2.16.756.5.30.1.1.10.3.45");
		s.getTemplateIds().add(tIi);

		final CE tCe = DatatypesFactory.eINSTANCE.createCE();
		tCe.setCode("55108-5");
		tCe.setCodeSystem("2.16.840.1.113883.6.1");
		tCe.setCodeSystemName("LOINC");
		tCe.setDisplayName("Clinical presentation");
		s.setCode(tCe);

		final ST tSt = DatatypesFactory.eINSTANCE.createST();
		tSt.addText("Original representation");
		s.setTitle(tSt);

		s.createStrucDocText(
				"Representation of the original view which has been signed by the legal authenticator:\r\n"
						+ "						<renderMultiMedia referencedObject=\"originalrepresentationpdf\"/>\r\n          ");

		ObservationMediaEntry obsMedia = new ObservationMediaEntry();
		obsMedia.setObservationMediaId("originalrepresentationpdf");
		final II tObsIi = DatatypesFactory.eINSTANCE.createII();
		tObsIi.setRoot("2.16.756.5.30.1.1.10.4.83");
		obsMedia.getMdht().getTemplateIds().add(tIi);
		obsMedia.setBase64Object(
				new ByteArrayInputStream(DatatypeConverter.printBase64Binary(pdf).getBytes()),
				"application/pdf");
		s.addObservationMedia(obsMedia.copy());

		// Todo remove the old section if exists
		getDoc().addSection(s);
	}

	/**
	 * <div class="en">Adds a patient</div> <div class="de">Weist dem CDA
	 * Dokument einen Patienten zu</div>
	 *
	 * @param patient
	 *            Patient
	 */
	@Override
	public void setPatient(Patient patient) {
		RecordTarget mdhtPatient = patient.getMdhtRecordTarget();
		CdaUtil.addTemplateIdOnce(mdhtPatient, new Identificator("2.16.756.5.30.1.1.10.2.1"));
		getDoc().getRecordTargets().add(mdhtPatient);
	}

	@Override
	public void setPrimaryRecipient(Organization recipient) {
		super.setPrimaryRecipient(recipient);
		InformationRecipient mdhtRecipient = getMdhtPrimaryRecipient();
		CdaUtil.addTemplateIdOnce(mdhtRecipient, new Identificator("2.16.756.5.30.1.1.10.2.4"));

	}

}
