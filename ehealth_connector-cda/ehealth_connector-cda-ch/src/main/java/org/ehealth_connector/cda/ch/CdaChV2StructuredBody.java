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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.AbstractCda;
import org.ehealth_connector.cda.DataEnterer;
import org.ehealth_connector.cda.ObservationMediaEntry;
import org.ehealth_connector.cda.ch.textbuilder.ObservationChTextBuilder;
import org.ehealth_connector.cda.ihe.lab.BaseLaboratorySpecialtySection;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.common.Person;
import org.ehealth_connector.common.ch.enums.ConfidentialityCode;
import org.ehealth_connector.common.enums.CountryCode;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.AssignedEntity;
import org.openhealthtools.mdht.uml.cda.Authenticator;
import org.openhealthtools.mdht.uml.cda.Author;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.Custodian;
import org.openhealthtools.mdht.uml.cda.InformationRecipient;
import org.openhealthtools.mdht.uml.cda.RecordTarget;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.ST;

/**
 * The implementation of the Swiss CDA-CH V2 Standard.
 *
 * @param <EClinicalDocument>
 *            the generic type <div class="en">Implements a CDA document based
 *            on the CDA-CH V2 (2017) specification.</div>
 *            <div class="de">Implementiert ein CDA-Dokument basierend auf der
 *            CDA-CH V2 (2017) Spezifikation.</div>
 */
public class CdaChV2StructuredBody<EClinicalDocument extends ClinicalDocument>
		extends AbstractCda<EClinicalDocument> {

	/**
	 * The default Section Comparator.
	 */
	private class MySectionComparator implements Comparator<org.ehealth_connector.cda.Section> {
		/**
		 *
		 * Compares two Section on their logical order regarding the
		 * implementation guide (use the index property therefore) or on the
		 * title.
		 *
		 * {@inheritDoc}
		 *
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(org.ehealth_connector.cda.Section a,
				org.ehealth_connector.cda.Section b) {
			if ((a == null) && (b == null))
				return 0;
			else if ((a == null) && (b != null))
				return -1;
			else if ((a != null) && (b == null))
				return 1;
			else {
				if ((a.getIndex() == null) && (b.getIndex() == null)) {
					if ((a.getTitle() == null) && (b.getTitle() == null))
						return 0;
					else if ((a.getTitle() == null) && (b.getTitle() != null))
						return -1;
					else if ((a.getTitle() != null) && (b.getTitle() == null))
						return 1;
					else
						return a.getTitle().compareTo(b.getTitle());

				} else if ((a.getIndex() == null) && (b.getIndex() != null))
					return -1;
				else if ((a.getIndex() != null) && (b.getIndex() == null))
					return 1;
				else
					return a.getIndex().compareTo(b.getIndex());
			}
		}
	}

	/** The Section Comparator to be used. */
	private Comparator<org.ehealth_connector.cda.Section> mComparator = new MySectionComparator();

	/**
	 * Instantiates a new CDA-CH V2 structured body.
	 *
	 * @param doc
	 *            the doc
	 */
	public CdaChV2StructuredBody(EClinicalDocument doc) {
		super(doc);
	}

	/**
	 * Instantiates a new CDA-CH V2 structured body document.
	 *
	 * @param doc
	 *            the document
	 * @param languageCode
	 *            the language code
	 * @param stylesheet
	 *            the stylesheet
	 * @param css
	 *            the css
	 */
	public CdaChV2StructuredBody(EClinicalDocument doc, LanguageCode languageCode,
			String stylesheet, String css) {
		super(doc, languageCode, stylesheet, css);
	}

	/**
	 * <div class="en">Adds an authenticator to the CDA document</div>
	 * <div class="de">Fügt dem CDA Dokument einen Unterzeichner hinzu</div>.
	 *
	 * @param author
	 *            the author
	 */
	@Override
	public void addAuthenticator(org.ehealth_connector.common.Author author) {
		Authenticator authenticator = Util.createAuthenticatorFromAuthor(author);
		authenticator.setTime(EcoreUtil.copy(author.getAuthorMdht().getTime()));
		CdaUtil.addTemplateIdOnce(authenticator, new Identificator("2.16.756.5.30.1.1.10.2.6"));
		super.addAuthenticator(authenticator);
	}

	/**
	 * <div class="en">Adds an author</div> <div class="de">Fügt einen Autoren
	 * hinzu</div>.
	 *
	 * @param author
	 *            the autor
	 * @return the author
	 */
	@Override
	public Author addAuthor(org.ehealth_connector.common.Author author) {
		final Author docAuthor = author.copyMdhtAuthor();
		CdaUtil.addTemplateIdOnce(docAuthor, new Identificator("2.16.756.5.30.1.1.10.9.23"));
		getDoc().getAuthors().add(docAuthor);
		return docAuthor;
	}

	/**
	 * Adds the narrative text section.
	 *
	 * @param title
	 *            the title
	 * @param text
	 *            the text
	 */
	public void addNarrativeTextSection(String title, String text) {
		Section s = CDAFactory.eINSTANCE.createSection();
		s.setTitle(DatatypesFactory.eINSTANCE.createST(title));
		s.createStrucDocText(text);
		getDoc().addSection(s);
	}

	/**
	 * <div class="en">Generates the human readable text of the laboratory
	 * observations chapter</div> <div class="de">Liefert den menschenlesbaren
	 * Text zu dem Kapitel Laborresultate zurück</div>.
	 *
	 * @param laboratorySpecialtySection
	 *            the laboratory specialty section
	 * @param sectionIndex
	 *            the section index number
	 * @param contentIdPrefix
	 *            the content id prefix
	 * @param posCodeSystemOid
	 *            the oid of the code system to be used as position (e.g.
	 *            2.16.756.5.30.1.129.1.3 for the Swiss Analysis List)
	 * @return the laboratory observations text
	 */
	public String generateNarrativeTextLaboratoryObservations(
			BaseLaboratorySpecialtySection laboratorySpecialtySection, int sectionIndex,
			String contentIdPrefix, String posCodeSystemOid) {
		final ObservationChTextBuilder b = new ObservationChTextBuilder(this.getMdht(),
				laboratorySpecialtySection, sectionIndex, contentIdPrefix,
				LanguageCode.getEnum(getMdht().getLanguageCode().getCode()), posCodeSystemOid);
		return b.toString();
	}

	/**
	 * <div class="en">Gets the ConfidentialityCode as defined by the Swiss
	 * EPR</div> <div class="de">Gibt den ConfidentialityCode zurück wie er vom
	 * EPD in der Schweiz definiert ist.</div>.
	 *
	 * @return code
	 */
	public ConfidentialityCode getConfidentialityCodeCh() {
		if (getDoc().getConfidentialityCode() != null) {
			return ConfidentialityCode.getEnum(getDoc().getConfidentialityCode().getCode());
		}
		return null;
	}

	/**
	 * Gets a list of all laboratory specialty sections.
	 *
	 * @return the laboratory specialty sections list.
	 */
	public List<LaboratorySpecialtySection> getLaboratorySpecialtySections() {
		ArrayList<LaboratorySpecialtySection> retVal = new ArrayList<LaboratorySpecialtySection>();
		for (Section item : getMdht().getSections()) {
			retVal.add(new LaboratorySpecialtySection(item));
		}
		retVal.sort(mComparator);
		return retVal;
	}

	/**
	 * Gets the list of all sections in this document.
	 *
	 * @return the sections list
	 */
	public List<org.ehealth_connector.cda.Section> getSections() {
		ArrayList<org.ehealth_connector.cda.Section> retVal = new ArrayList<org.ehealth_connector.cda.Section>();
		for (Section item : getMdht().getSections()) {
			String title = null;
			String text = null;
			if (item.getTitle() != null)
				title = item.getTitle().getText();
			if (item.getText() != null)
				text = item.getText().getText();
			retVal.add(new org.ehealth_connector.cda.Section(title, text));
		}
		retVal.sort(mComparator);
		return retVal;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.AbstractCda#initCda()
	 */
	@Override
	public void initCda() {

		// Fix the RealmCode
		final CS cs = DatatypesFactory.eINSTANCE.createCS();
		cs.setCode(CountryCode.SWITZERLAND.getCodeAlpha3());
		getDoc().getRealmCodes().clear();
		getDoc().getRealmCodes().add(cs);

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
		setVersion(id, 1);
		setTimestamp(DateUtil.nowAsDate());
	}

	/**
	 * Sets the version number to 1 and makes sure the setId is the same as the
	 * document id.
	 */
	public void initFirstVersion() {
		Identificator docId = getId();
		if (docId == null) {
			docId = new Identificator(org.openhealthtools.ihe.utils.UUID.generate());
			setId(docId);
		}
		setVersion(docId, 1);
	}

	/**
	 * Sets the version number to 1 and makes sure the setId is the same as the
	 * document id.
	 *
	 * @param newDocId
	 *            the new doc id
	 */
	public void initFirstVersion(Identificator newDocId) {
		Identificator docId = newDocId;
		if (docId == null) {
			docId = new Identificator(org.openhealthtools.ihe.utils.UUID.generate());
		}
		setId(docId);
		setVersion(docId, 1);
	}

	/**
	 * Increases the version number by one and makes sure the setId remains the
	 * same as previously.
	 */
	public void initNextVersion() {
		Identificator newDocId = new Identificator(org.openhealthtools.ihe.utils.UUID.generate());
		Identificator setId = getSetId();

		if (setId == null)
			setId = getId();
		if (setId == null)
			setId = newDocId;

		Integer version = getVersion();

		setId(newDocId);
		setVersion(setId, version + 1);
	}

	/**
	 * Increases the version number by one and makes sure the setId remains the
	 * same as previously.
	 *
	 * @param newDocId
	 *            the new doc id
	 */
	public void initNextVersion(Identificator newDocId) {
		Identificator setId = getSetId();

		if (setId == null)
			setId = getId();
		if (setId == null)
			setId = newDocId;

		Integer version = getVersion();

		setId(newDocId);
		setVersion(setId, version + 1);
	}

	/**
	 * Sets the section comparator to be used.
	 *
	 * @param comparator
	 *            the new comparator
	 */
	public void setComparator(Comparator<org.ehealth_connector.cda.Section> comparator) {
		mComparator = comparator;
	}

	/**
	 * Sets Swiss EPR Confidentiality Code.
	 *
	 * @param code
	 *            If null, "N" for "normal" will be set.
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
	 * Organisation zu</div>.
	 *
	 * @param organization
	 *            <div class="en">custodian organization</div>
	 *            <div class="de">verwaltende Organisation</div>
	 * @return the custodian
	 */
	@Override
	public Custodian setCustodian(Organization organization) {
		Custodian mdht = super.setCustodian(organization);
		CdaUtil.addTemplateIdOnce(mdht, new Identificator("2.16.756.5.30.1.1.10.2.3"));
		return mdht;
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
	 * Dokument einen Erfasser hinzu</div>.
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
	 * Sets the CDA main document id.
	 *
	 * @param id
	 *            the new id
	 */
	@Override
	public void setId(Identificator id) {
		if (id != null) {
			getDoc().setId(id.getIi());
		}
	}

	/**
	 * <div class="en">Sets the legal authenticator of the document</div>
	 * <div class="de">Weist dem CDA Dokument einen rechtsgültigen Unterzeichner
	 * hinzu</div>.
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
	 * Dokument einen Patienten zu</div>.
	 *
	 * @param patient
	 *            Patient
	 * @return the record target
	 */
	@Override
	public RecordTarget setPatient(Patient patient) {
		RecordTarget mdhtPatient = patient.getMdhtRecordTarget();
		CdaUtil.addTemplateIdOnce(mdhtPatient, new Identificator("2.16.756.5.30.1.1.10.2.1"));
		getDoc().getRecordTargets().add(mdhtPatient);
		return mdhtPatient;
	}

	/**
	 * Sets the primary recipient.
	 *
	 * @param recipient
	 *            the recipient
	 * @return the information recipient
	 */
	@Override
	public InformationRecipient setPrimaryRecipient(Organization recipient) {
		super.setPrimaryRecipient(recipient);
		InformationRecipient mdhtRecipient = getMdhtPrimaryRecipient();
		CdaUtil.addTemplateIdOnce(mdhtRecipient, new Identificator("2.16.756.5.30.1.1.10.2.4"));
		return mdhtRecipient;
	}
}
