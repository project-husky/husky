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
import java.util.Comparator;

import javax.xml.bind.DatatypeConverter;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.AbstractCda;
import org.ehealth_connector.cda.AbstractObservation;
import org.ehealth_connector.cda.AbstractOrganizer;
import org.ehealth_connector.cda.ObservationMediaEntry;
import org.ehealth_connector.cda.ch.textbuilder.ObservationChTextBuilder;
import org.ehealth_connector.cda.ihe.lab.AbstractLaboratorySpecialtySection;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.enums.CountryCode;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.DateUtil;
import org.openhealthtools.ihe.utils.UUID;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.cda.ihe.CodedVitalSignsSection;
import org.openhealthtools.mdht.uml.cda.ihe.impl.CodedVitalSignsSectionImpl;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratorySpecialtySection;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.ST;

/**
 * The Class AbstractCdaCh implements a CDA document based on CDA-CH
 * specification
 *
 * @param <EClinicalDocument>
 *            the generic type
 */
public abstract class AbstractCdaCh<EClinicalDocument extends ClinicalDocument>
		extends AbstractCda<EClinicalDocument> {

	/** main OID for CDA-CH */
	public static final String OID_MAIN = "2.16.756.5.30.1.1.1.1";

	/** OID for CDA-CH V1.* */
	public static final String OID_V1 = "2.16.756.5.30.1.1.1.1.1";

	/**
	 * <div class="en">Constructor for CdaCh documents</div>
	 * <div class="de">Erstellt ein CdaCh Objekt</div> <div class="fr"></div>.
	 *
	 * @param doc
	 *            the CDA-CH Object in its MDHT representation.
	 */
	public AbstractCdaCh(EClinicalDocument doc) {
		super(doc);
	}

	/**
	 * <div class="en">Constructor for CdaCh documents</div>
	 * <div class="de">Erstellt ein CdaCh Objekt</div> <div class="fr"></div>.
	 *
	 * @param doc
	 *            the CDA-CH Object in its MDHT representation.
	 * @param languageCode
	 *            the desired document language.
	 */
	public AbstractCdaCh(EClinicalDocument doc, LanguageCode languageCode) {
		super(doc, languageCode);
	}

	/**
	 * <div class="en">Constructor that includes a stylesheet and a cascasing
	 * stylesheet into the document processing instructions and initalizes the
	 * standard document attributes.</div> <div class="de">Erzeugt ein CdaCh
	 * Objekt (CDA Header nach schweizer Spezifikation)</div>
	 * <div class="fr"></div>
	 *
	 * @param doc
	 *            the CDA-CH Object in its MDHT representation
	 * @param stylesheet
	 *            the stylesheet for the document (e.g.
	 *            '../../../../stylesheets/HL7.ch/CDA-CH/v1.2/cda-ch.xsl').
	 * @param css
	 *            the Cascasing stylesheet for the document (e.g.
	 *            '../../../../stylesheets/HL7.ch/CDA-CH/v1.2/cda-ch.xsl').
	 */
	public AbstractCdaCh(EClinicalDocument doc, String stylesheet, String css) {
		super(doc, stylesheet, css);
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
	public void addOriginalRepresentationSection(byte[] pdf) throws IOException {
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

		getDoc().addSection(s);
	}

	/**
	 * Generates the narrative text for laboratory observations.
	 *
	 * @param laboratorySpecialtySection
	 *            the laboratory specialty section.
	 * @param contentIdPrefix
	 *            the content id prefix for text references.
	 * @return the narrative text for laboratory observations.
	 */
	public String generateNarrativeTextLaboratoryObservations(
			AbstractLaboratorySpecialtySection laboratorySpecialtySection, String contentIdPrefix) {
		return generateNarrativeTextLaboratoryObservations(laboratorySpecialtySection,
				contentIdPrefix, null);
	}

	/**
	 * <div class="en">Generates the human readable text of the laboratory
	 * observations chapter</div> <div class="de">Liefert den menschenlesbaren
	 * Text zu dem Kapitel Laborresultate zurück</div>.
	 *
	 * @param laboratorySpecialtySection
	 *            the laboratory specialty section
	 * @param contentIdPrefix
	 *            the content id prefix
	 * @param posCodeSystemOid
	 *            the oid of the code system to be used as position (e.g.
	 *            2.16.756.5.30.1.129.1.3 for the Swiss Analysis List)
	 * @return the laboratory observations text
	 */
	public String generateNarrativeTextLaboratoryObservations(
			AbstractLaboratorySpecialtySection laboratorySpecialtySection, String contentIdPrefix,
			String posCodeSystemOid) {
		final ObservationChTextBuilder b = new ObservationChTextBuilder(laboratorySpecialtySection,
				contentIdPrefix, LanguageCode.getEnum(getMdht().getLanguageCode().getCode()),
				posCodeSystemOid);
		return b.toString();
	}

	/**
	 * <div class="en">Generates the human readable text of the laboratory
	 * observations chapter</div> <div class="de">Liefert den menschenlesbaren
	 * Text zu dem Kapitel Laborresultate zurück</div>.
	 *
	 * @param laboratorySpecialtySection
	 *            the laboratory specialty section
	 * @param contentIdPrefix
	 *            the content id prefix
	 * @param posCodeSystemOid
	 *            the oid of the code system to be used as position (e.g.
	 *            2.16.756.5.30.1.129.1.3 for the Swiss Analysis List)
	 * @param organizerComparator
	 *            the organizer comparator (pass null for default sorting)
	 * @param observationComparator
	 *            the observation comparator (pass null for default sorting)
	 * @return the laboratory observations text
	 */
	public String generateNarrativeTextLaboratoryObservations(
			AbstractLaboratorySpecialtySection laboratorySpecialtySection, String contentIdPrefix,
			String posCodeSystemOid, Comparator<AbstractOrganizer> organizerComparator,
			Comparator<AbstractObservation> observationComparator) {
		final ObservationChTextBuilder b = new ObservationChTextBuilder(laboratorySpecialtySection,
				contentIdPrefix, LanguageCode.getEnum(getMdht().getLanguageCode().getCode()),
				posCodeSystemOid);
		b.setOrganizerComparator(organizerComparator);
		b.setObservationComparator(observationComparator);
		return b.toString();
	}

	/**
	 * <div class="en">Generates the human readable text of the laboratory
	 * observations chapter</div> <div class="de">Liefert den menschenlesbaren
	 * Text zu dem Kapitel Laborresultate zurück</div>.
	 *
	 * @param contentIdPrefix
	 *            the content id prefix
	 * @return the laboratory observations text
	 */
	public String generateNarrativeTextLaboratoryObservations(String contentIdPrefix) {
		return generateNarrativeTextLaboratoryObservations(getLaboratorySpecialtySection(),
				contentIdPrefix, null);
	}

	/**
	 * Generates the narrative text for laboratory observations.
	 *
	 * @param contentIdPrefix
	 *            the content id prefix for text references.
	 * @param posCodeSystemOid
	 *            the oid of the code system to be used as position (e.g.
	 *            2.16.756.5.30.1.129.1.3 for the Swiss Analysis List)
	 * @return the narrative text for laboratory observations.
	 */
	public String generateNarrativeTextLaboratoryObservations(String contentIdPrefix,
			String posCodeSystemOid) {
		return generateNarrativeTextLaboratoryObservations(getLaboratorySpecialtySection(),
				contentIdPrefix, posCodeSystemOid);
	}

	/**
	 * Generates the narrative text for laboratory observations.
	 *
	 * @param vitalSignsSection
	 *            the vital signs section.
	 * @param contentIdPrefix
	 *            the content id prefix for text references.
	 * @return the narrative text for laboratory observations.
	 */
	public String generateNarrativeTextVitalSignObservations(

			org.openhealthtools.mdht.uml.cda.ihe.CodedVitalSignsSection vitalSignsSection,
			String contentIdPrefix) {
		final ObservationChTextBuilder b = new ObservationChTextBuilder(vitalSignsSection,
				contentIdPrefix, LanguageCode.getEnum(getMdht().getLanguageCode().getCode()));
		return b.toString();
	}

	/**
	 * Generates the narrative text for laboratory observations.
	 *
	 * @param contentIdPrefix
	 *            the content id prefix for text references.
	 * @return the narrative text for laboratory observations.
	 */
	public String generateNarrativeTextVitalSignObservations(String contentIdPrefix) {
		return generateNarrativeTextVitalSignObservations(getCodedVitalSignsSection(),
				contentIdPrefix);
	}

	/**
	 * Gets the coded vital signs section.
	 *
	 * @return the coded vital signs section
	 */
	private CodedVitalSignsSection getCodedVitalSignsSection() {
		for (final Section s : getMdht().getAllSections()) {
			if (s instanceof CodedVitalSignsSectionImpl) {
				return (CodedVitalSignsSectionImpl) s;
			}
		}
		return null;
	}

	/**
	 * Gets the laboratory specialty section.
	 *
	 * @return the laboratory specialty section
	 */
	public AbstractLaboratorySpecialtySection getLaboratorySpecialtySection() {
		for (final Section s : getMdht().getAllSections()) {
			if (s instanceof LaboratorySpecialtySection) {
				return new AbstractLaboratorySpecialtySection((LaboratorySpecialtySection) s);
			}
		}
		return null;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.AbstractCda#getLanguageCode()
	 */
	@Override
	public LanguageCode getLanguageCode() {
		return LanguageCode.getEnum(super.getDoc().getLanguageCode().getCode());
	}

	/**
	 * Method implementing.
	 */
	@Override
	public void initCda() {

		// Fix RealmCode
		final CS cs = DatatypesFactory.eINSTANCE.createCS();
		cs.setCode(CountryCode.SWITZERLAND.getCodeAlpha3());
		getDoc().getRealmCodes().clear();
		getDoc().getRealmCodes().add(cs);

		// Type ID
		setTypeId();

		// Set OID of the document
		setId(null);
		setSetId(null);
		setVersion(null, null);

		// Set default Swiss EPR confidentiality code of the document (normal)
		setConfidentialityCode(org.ehealth_connector.common.ch.enums.ConfidentialityCode.NORMAL);

		// Set creation time of the document
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
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.AbstractCda#setId(org.ehealth_connector.common.Identificator)
	 */
	@Override
	public void setId(Identificator id) {
		if (id == null) {
			final II docID = DatatypesFactory.eINSTANCE.createII();
			docID.setRoot(AbstractCdaCh.OID_MAIN);
			docID.setExtension(UUID.generate());
			getDoc().setId(docID);
		} else {
			getDoc().setId(id.getIi());
		}
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.AbstractCda#setSetId(org.ehealth_connector.common.Identificator)
	 */
	@Override
	public void setSetId(Identificator id) {
		if (id == null) {
			getDoc().setSetId(EcoreUtil.copy(getDoc().getId()));
		} else {
			final II ii = DatatypesFactory.eINSTANCE.createII();
			ii.setRoot(id.getRoot());
			ii.setExtension(id.getExtension());
			getDoc().setSetId(ii);
		}
	}

}
