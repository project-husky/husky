/*
 *
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

package org.ehealth_connector.cda.ch.vacd;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.AbstractCodedResults;
import org.ehealth_connector.cda.AbstractObservation;
import org.ehealth_connector.cda.AbstractProblemConcern;
import org.ehealth_connector.cda.AllergyConcern;
import org.ehealth_connector.cda.ch.AbstractCdaChV1;
import org.ehealth_connector.cda.ch.ActiveProblemConcern;
import org.ehealth_connector.cda.ch.PastProblemConcern;
import org.ehealth_connector.cda.ch.PregnancyHistory;
import org.ehealth_connector.cda.ch.enums.RiskOfComplications;
import org.ehealth_connector.cda.ch.enums.RiskOfExposure;
import org.ehealth_connector.cda.ch.lab.lrph.LaboratorySpecialtySection;
import org.ehealth_connector.cda.ch.textbuilder.AllergyConcernChTextBuilder;
import org.ehealth_connector.cda.ch.textbuilder.ProblemConcernEntryChTextBuilder;
import org.ehealth_connector.cda.ch.utils.CdaChUtil;
import org.ehealth_connector.cda.ch.vacd.enums.ObservationInterpretationForImmunization;
import org.ehealth_connector.cda.ch.vacd.enums.SectionsVacd;
import org.ehealth_connector.cda.ch.vacd.enums.SerologieForVacd;
import org.ehealth_connector.cda.enums.ProblemsSpecialConditions;
import org.ehealth_connector.cda.textbuilder.SimpleTextBuilder;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Performer;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.enums.StatusCode;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.Entry;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.Patient;
import org.openhealthtools.mdht.uml.cda.PatientRole;
import org.openhealthtools.mdht.uml.cda.RecordTarget;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.cda.StrucDocText;
import org.openhealthtools.mdht.uml.cda.StructuredBody;
import org.openhealthtools.mdht.uml.cda.SubstanceAdministration;
import org.openhealthtools.mdht.uml.cda.ch.CdaChVacdV1;
import org.openhealthtools.mdht.uml.cda.ch.ChFactory;
import org.openhealthtools.mdht.uml.cda.ch.ChPackage;
import org.openhealthtools.mdht.uml.cda.ihe.Comment;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.PregnancyHistorySection;
import org.openhealthtools.mdht.uml.cda.ihe.PregnancyObservation;
import org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryReportDataProcessingEntry;
import org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenAct;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil.Query;
import org.openhealthtools.mdht.uml.hl7.datatypes.AD;
import org.openhealthtools.mdht.uml.hl7.datatypes.ADXP;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.vocab.ActRelationshipHasComponent;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * <div class="en">A CDA document, which is conform to the CDA-CH-CdaChVacdV1
 * specification</div> <div class="de">Ein CDA Dokument, welches der
 * Spezifikation CDA-CH-CdaChVacdV1 entspricht.</div> <div class="fr">Class
 * CdaChVacd.</div> <div class="it">Class CdaChVacd.</div>
 */
public class CdaChVacd extends AbstractCdaChV1<CdaChVacdV1> {

	/** The Constant eVACDOCTitle. */
	public static final String ECdaChVacdV1OC_TITLE = "eVACDOC";

	/** main OID for CDA-CH-CdaChVacdV1 */
	public static final String OID_MAIN = "2.16.756.5.30.1.1.1.1.3.5";

	/** main OID for CDA-CH-CdaChVacdV1 V1 */
	public static final String OID_V1 = "2.16.756.5.30.1.1.1.1.3.5.1";

	/**
	 * <div class="en">Creates a new eVACDOC CDA document</div>
	 * <div class="de">Erstellt ein neues eVACDOC CDA Dokument.</div>
	 */
	public CdaChVacd() {
		super(ChFactory.eINSTANCE.createCdaChVacdV1().init());
		super.initCda();
		initVacd();
	}

	/**
	 * <div class="en">Creates a new CdaChVacd convenience object on the basis
	 * of a MDHT-CdaChVacdV1 object. Both represent an immunization
	 * document</div> <div class="de">Erstellt ein neues CdaChVacd Convenience
	 * Objekt mittels eines MDHT-CdaChVacdV1 Objekts. Beide repräsentieren ein
	 * Impfdokument.</div> <div class="fr"></div>
	 *
	 * @param doc
	 *            MDHT CdaChVacdV1 object
	 */
	public CdaChVacd(CdaChVacdV1 doc) {
		super(doc);
		new Query(getDoc());
	}

	/**
	 * Erstellt ein neues eVACDOC CDA Dokument.
	 *
	 * @param language
	 *            document language
	 * @param immunization
	 *            an immunization
	 */
	public CdaChVacd(LanguageCode language, Immunization immunization) {
		this();
		setLanguageCode(language);
		addStylesheet(null);
		addImmunization(immunization);
	}

	/**
	 * <div class="en">Creates a new eVACDOC CDA document</div>
	 * <div class="de">Erstellt ein neues eVACDOC CDA Dokument.</div>
	 *
	 * @param language
	 *            <br>
	 *            <div class="en">document language</div>
	 *            <div class="de">Sprache des Dokments</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 * @param stylesheet
	 *            <div class="en">stylesheet, which should be referenced to
	 *            render a human readable representation of the document</div>
	 *            <div class="de">Stylesheet, welches im CDA mittels
	 *            ?xml-stylesheet für die menschlich lesbare Darstellung
	 *            referenziert werden soll (z.B.
	 *            '../../../../stylesheets/HL7.ch/CDA-CH/v1.2/cda-ch.xsl').</div
	 *            >
	 * @param cascadingStylesheet
	 *            <div class="en">Cascading stylesheet, which should be
	 *            referenced to render a human readable representation of the
	 *            document</div> <div class="de">Cascasing Stylesheet, welches
	 *            Designinformationen für die menschlich lesbare Darstellung
	 *            referenziert (z.B.
	 *            '../../../../stylesheets/HL7.ch/CDA-CH/v1.2/cda-ch.xsl').</div
	 *            >
	 */
	public CdaChVacd(LanguageCode language, String stylesheet, String cascadingStylesheet) {
		super(ChFactory.eINSTANCE.createCdaChVacdV1().init(), language, stylesheet,
				cascadingStylesheet);
		initVacd();
	}

	/**
	 * <div class="en">Creates a new eVACDOC CDA document</div>
	 * <div class="de">Erstellt ein neues eVACDOC CDA Dokument.</div>
	 *
	 * @param language
	 *            <div class="en">document language</div>
	 *            <div class="de">Sprache des Dokments</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 * @param stylesheet
	 *            <div class="en">stylesheet, which should be referenced to
	 *            render a human readable representation of the document</div>
	 *            <div class="de">Stylesheet, welches im CDA mittels
	 *            ?xml-stylesheet für die menschlich lesbare Darstellung
	 *            referenziert werden soll (z.B.
	 *            '../../../../stylesheets/HL7.ch/CDA-CH/v1.2/cda-ch.xsl').</div
	 *            >
	 * @param cascasingStylesheet
	 *            <div class="en">Cascading stylesheet, which should be
	 *            referenced to render a human readable representation of the
	 *            document</div> <div class="de">Cascasing Stylesheet, welches
	 *            Designinformationen für die menschlich lesbare Darstellung
	 *            referenziert (z.B.
	 *            '../../../../stylesheets/HL7.ch/CDA-CH/v1.2/cda-ch.xsl').</div
	 *            >
	 * @param immunization
	 *            <div class="en">the immunization</div>
	 *            <div class="de">Impfung</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public CdaChVacd(LanguageCode language, String stylesheet, String cascasingStylesheet,
			Immunization immunization) {
		this(language, stylesheet, cascasingStylesheet);
		initVacd();
		addImmunization(immunization);
	}

	/**
	 * <div class="en">Adds the active problem concern.</div>
	 * <div class="de">Fügt ein Aktives Leiden hinzu</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param activeProblemConcern
	 *            <br>
	 *            <div class="en"> active problem concern</div> <div class="de">
	 *            Das aktive Leiden</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public void addActiveProblemConcern(ActiveProblemConcern activeProblemConcern) {
		// find or create (and add) the Section
		org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection aps = getDoc()
				.getActiveProblemsSection();
		if (aps == null) {
			aps = IHEFactory.eINSTANCE.createActiveProblemsSection().init();
			aps.setTitle(Util
					.st(SectionsVacd.ACTIVE_PROBLEMS.getSectionTitle(getDoc().getLanguageCode())));
			getDoc().addSection(aps);
		}

		// add the MDHT Object to the section
		aps.addAct(activeProblemConcern.copyMdhtProblemConcernEntry());

		// update the MDHT Object content references to CDA level 1 text
		if (updateProblemConcernReferences(aps.getActs(), SectionsVacd.ACTIVE_PROBLEMS)) {
			if (isNarrativeTextGenerationEnabled()) {
				// create the CDA level 1 text
				aps.createStrucDocText(generateNarrativeTextActiveProblemConcerns());
			} else {
				setNarrativeTextSectionActiveProblems("");
			}
		} else {
			aps.createStrucDocText("Keine Angaben");
			activeProblemConcern.copyMdhtProblemConcernEntry().getEntryRelationships().get(0)
					.getObservation().setText(Util.createEd(""));
		}
	}

	/**
	 * <div class="en">Adds the allergy concern</div> <div class="de">Fügt ein
	 * Allergie-Leiden hinzu</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param allergyConcern
	 *            <br>
	 *            <div class="de">Allergie leiden</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public void addAllergyConcern(AllergyConcern allergyConcern) {
		// find or create (and add) the Section
		org.openhealthtools.mdht.uml.cda.ihe.AllergiesReactionsSection ars = getDoc()
				.getAllergiesReactionsSection();
		if (ars == null) {
			ars = IHEFactory.eINSTANCE.createAllergiesReactionsSection().init();
			ars.setTitle(Util.st(
					SectionsVacd.ALLERGIES_REACTIONS.getSectionTitle(getDoc().getLanguageCode())));
			getDoc().addSection(ars);
		}

		// add the MDHT Object to the section
		ars.addAct(allergyConcern.copyMdhtAllergyConcern());

		// create the CDA level 2 text (either generated or empty text with
		// content reference)

		// update the MDHT Object content references to CDA level 1 text
		if (updateAllergyConcernReferences(ars.getActs(), SectionsVacd.ALLERGIES_REACTIONS)) {
			if (isNarrativeTextGenerationEnabled()) {
				// create the CDA level 1 text
				ars.createStrucDocText(generateNarrativeTextAllergyProblemConcerns(
						LanguageCode.getEnum(getMdht().getLanguageCode().getCode())));
			} else {
				setNarrativeTextSectionAllergiesAndOtherAdverseReactions("");
			}
		} else {
			ars.createStrucDocText("Keine Angaben");
			allergyConcern.copyMdhtAllergyConcern().getEntryRelationships().get(0).getObservation()
					.setText(Util.createEd(""));
		}
	}

	/**
	 * <div class="en">Sets the gestational age</div> <div class="de">Setzt das
	 * Gestationsalter</div>
	 *
	 * @param codedResults
	 *            the new gestational age
	 */
	public void addCodedResults(AbstractCodedResults codedResults) {
		// update the MDHT Object content references to CDA level 1 text
		if (codedResults instanceof GestationalAge) {
			final GestationalAge gestationalAge = (GestationalAge) codedResults;
			final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsVacd.CODED_RESULTS,
					gestationalAge.getCodedResultsText());

			final ED reference = Util.createReference(sb.getNewTextContentIDNr(),
					SectionsVacd.CODED_RESULTS.getContentIdPrefix());
			gestationalAge.getMdhtGestationalAgeWeeksObservation()
					.setText(EcoreUtil.copy(reference));
			gestationalAge.getMdhtGestationalAgeDaysObservation()
					.setText(EcoreUtil.copy(reference));

			// create the CDA level 1 text
			// gestationalAge.getMdhtCodedResultsSection().createStrucDocText(
			// sb.toString());
			gestationalAge.getCrs().createStrucDocText("");

			gestationalAge.getCrs().setTitle(Util
					.st(SectionsVacd.CODED_RESULTS.getSectionTitle(getDoc().getLanguageCode())));
		}
		getDoc().addSection(codedResults.copyMdhtCodedResultsSection());
	}

	/**
	 * <div class="en">Adds a comment</div> <div class="de">Fügt einen Kommentar
	 * hinzu</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param comment
	 *            the comment
	 */
	public void addComment(String comment) {

		// find or create (and add) the Section
		Section rs = findRemarksSection();
		if (rs == null) {
			rs = ChFactory.eINSTANCE.createRemarksSection().init();
			for (final II ii : rs.getTemplateIds()) {
				if ("2.16.756.5.30.1.1.1.1.1".equals(ii.getRoot())) {
					ii.setExtension("CDA-CH.Body.CodedRem");
				}
			}
			rs.setTitle(Util.st(SectionsVacd.REMARKS.getSectionTitle(getDoc().getLanguageCode())));
			getDoc().addSection(rs);
		}

		// create add the MDHT Object to the section
		final Comment mComment = IHEFactory.eINSTANCE.createComment().init();
		rs.addAct(mComment);

		// update the MDHT Object content references to CDA level 1 text
		SimpleTextBuilder sb = null;
		if (rs.getText() != null) {
			final String oldSectionText = Util.extractStringFromNonQuotedStrucDocText(rs.getText());
			sb = new SimpleTextBuilder(SectionsVacd.REMARKS, comment, oldSectionText);
		} else {
			sb = new SimpleTextBuilder(SectionsVacd.REMARKS, comment);
		}

		final ED reference = Util.createReference(sb.getNewTextContentIDNr(),
				SectionsVacd.REMARKS.getContentIdPrefix());

		// create the CDA level 1 text
		rs.createStrucDocText(sb.toString());
		mComment.setText(reference);
	}

	/**
	 * <div class="en">Adds an immunization</div> <div class="de">Fügt eine
	 * Impfung hinzu.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param immunization
	 *            the immunization
	 */
	public void addImmunization(org.ehealth_connector.cda.ch.vacd.Immunization immunization) {
		ImmunizationSection section = null;
		if (getMdht().getImmunizationsSection() == null) {
			section = new ImmunizationSection(getLanguageCode());
			this.getMdht().addSection(section.getMdht());
		} else {
			section = new ImmunizationSection(getMdht().getImmunizationsSection());
		}
		section.addImmunization(immunization, true);
	}

	/**
	 * <div class="en">Adds an immunization recommendation</div>
	 * <div class="de">Fügt eine Impfempfehlung hinzu</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param immunizationRecommendation
	 *            the immunization recommendation * the language code
	 */
	public void addImmunizationRecommendation(
			ImmunizationRecommendation immunizationRecommendation) {
		ImmunizationRecommendationSection section = null;
		if (getMdht().getImmunizationRecommendationSection() == null) {
			section = new ImmunizationRecommendationSection(getLanguageCode());
			this.getMdht().addSection(section.getMdht());
		} else {
			section = new ImmunizationRecommendationSection(
					getMdht().getImmunizationRecommendationSection());
		}
		section.addImmunizationRecommendation(immunizationRecommendation, getLanguageCode(), true);
	}

	/**
	 * <div class="en">Adds a laboratory observation</div> <div class="de">Fügt
	 * einen Laborbefund hinzu</div>
	 *
	 * @param laboratoryObservation
	 *            the laboratory observation
	 */
	public void addLaboratoryObservation(
			org.ehealth_connector.cda.ch.vacd.LaboratoryObservation laboratoryObservation) {
		// LaboratoryObservationTextBuilder tb;

		org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenAct spa = null;
		// Dieser Teil sollte in dem Objekt selbst ausgeführt werden. Also
		// in LaboratoryObservation die Battery etc. erzeugen.
		// find or create (and add) the Section
		org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratorySpecialtySection lss = getDoc()
				.getLaboratorySpecialtySection();
		if (lss == null) {
			lss = LABFactory.eINSTANCE.createLaboratorySpecialtySection().init();
			final LaboratoryReportDataProcessingEntry lrdpe = LABFactory.eINSTANCE
					.createLaboratoryReportDataProcessingEntry().init();
			spa = LABFactory.eINSTANCE.createSpecimenAct().init();

			// Fixed code for LaboratorySpecialty
			final Code labSpec = new Code("2.16.840.1.113883.6.1", "18727-8", "LOINC",
					"SEROLOGY STUDIES");
			lss.setCode(labSpec.getCE());
			lss.getEntries().add(lrdpe);
			lrdpe.setAct(spa);
			lrdpe.getAct().setStatusCode(StatusCode.COMPLETED.getCS());
			lrdpe.getAct().setCode(labSpec.getCD());

			lss.setTitle(Util
					.st(SectionsVacd.SEROLOGY_STUDIES.getSectionTitle(getDoc().getLanguageCode())));
			getDoc().addSection(lss);
		}
		// If the section is already present, get instances of the templates
		else {
			final LaboratoryReportDataProcessingEntry lrdpe = (LaboratoryReportDataProcessingEntry) lss
					.getEntries().get(0);
			spa = (org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenAct) lrdpe.getAct();
		}

		// Create a new Laboratory Battery Organizer for each Observation that
		// is added through this constructor and add it to the specimen act.
		final LaboratoryBatteryOrganizer lbo = LABFactory.eINSTANCE
				.createLaboratoryBatteryOrganizer().init();
		lbo.setStatusCode(StatusCode.COMPLETED.getCS());
		spa.addOrganizer(lbo);

		// add the MDHT Object to the section
		lbo.addObservation(laboratoryObservation.copyMdhtLaboratoryObservation());

		// Set the Type codes
		lbo.getComponents().get(lbo.getComponents().size() - 1)
				.setTypeCode(ActRelationshipHasComponent.COMP);
		spa.getEntryRelationships().get(spa.getEntryRelationships().size() - 1)
				.setTypeCode(x_ActRelationshipEntryRelationship.COMP);

		// Update the MDHT Object content references to CDA level 1 text
		// (if necessary)
		updateLaboratoryObservationReferences(spa, SectionsVacd.SEROLOGY_STUDIES);

		// create the CDA level 2 text (either generated or empty text with
		// content reference)
		if (isNarrativeTextGenerationEnabled()) {
			LaboratorySpecialtySection laboratorySpecialtySection = getLaboratorySpecialtySection();
			lss.createStrucDocText(generateNarrativeTextLaboratoryObservations(
					laboratorySpecialtySection, 1, "lss"));
		} else {
			if (laboratoryObservation.getCommentText() != null) {
				// Alle vorhandenen Kommentare zusammenfügen
				int i = 0;
				String allComments = "";
				for (final AbstractObservation t : getLaboratoryObservations()) {
					if (t.getCommentText() != null) {
						i++;
						allComments = allComments + "Kommentar " + i + ": " + t.getCommentText()
								+ " ";
					}
				}
				setNarrativeTextSectionLaboratorySpeciality(allComments);
			} else {
				setNarrativeTextSectionLaboratorySpeciality("-");
			}
		}
	}

	/**
	 * <div class="en">Adds a past problem concern</div> <div class="de">Fügt
	 * ein vergangenes Leiden hinzu</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param pastProblemConcern
	 *            the past problem concern
	 */
	public void addPastProblemConcern(PastProblemConcern pastProblemConcern) {
		org.openhealthtools.mdht.uml.cda.ihe.HistoryOfPastIllnessSection hopis;

		// find or create (and add) the Section
		hopis = getDoc().getHistoryOfPastIllnessSection();
		if (hopis == null) {
			hopis = IHEFactory.eINSTANCE.createHistoryOfPastIllnessSection().init();
			hopis.setTitle(Util.st(SectionsVacd.HISTORY_OF_PAST_ILLNESS
					.getSectionTitle(getDoc().getLanguageCode())));
			getDoc().addSection(hopis);
		}

		// add the MDHT Object to the section
		hopis.addAct(pastProblemConcern.copyMdhtProblemConcernEntry());

		// update the MDHT Object content references to CDA level 1 text
		if (updateProblemConcernReferences(hopis.getActs(), SectionsVacd.HISTORY_OF_PAST_ILLNESS)) {
			// create the CDA level 2 text (either generated or empty text with
			// content reference)
			if (isNarrativeTextGenerationEnabled()) {
				hopis.createStrucDocText(generateNarrativeTextPastProblemConcernEntries());
			} else {
				setNarrativeTextSectionHistoryOfPastIllnes("");
			}
		} else {
			hopis.createStrucDocText("");
			pastProblemConcern.copyMdhtProblemConcernEntry().getEntryRelationships().get(0)
					.getObservation().setText(Util.createEd(""));
		}
	}

	/**
	 * <div class="en">Adds a pregnancy history</div> <div class="de">Fügt eine
	 * Schwangerschaft hinzu</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param pregnancy
	 *            the pregnancy history
	 */
	public void addPregnancyHistory(PregnancyHistory pregnancy) {
		org.openhealthtools.mdht.uml.cda.ihe.PregnancyHistorySection phs;
		SimpleTextBuilder sb;

		// Change to max one section in the model
		phs = getDoc().getPregnancyHistorySection();

		if (phs == null) {
			phs = IHEFactory.eINSTANCE.createPregnancyHistorySection().init();
			phs.setTitle(Util.st(SectionsVacd.HISTORY_OF_PREGNANCIES
					.getSectionTitle(getDoc().getLanguageCode())));
			getDoc().addSection(phs);
		}

		// create the CDA level 2 text (either generated or empty text with
		// content reference)
		ED reference;
		if (isNarrativeTextGenerationEnabled()) {
			// create the CDA level 1 text and update the MDHT Object content
			// references to CDA level 1 text
			final String pregnancyText = "Voraussichtlicher Geburtstermin: "
					+ pregnancy.getEstimatedBirthdate();
			if (phs.getText() != null) {
				final String oldSectionText = Util
						.extractStringFromNonQuotedStrucDocText(phs.getText());
				sb = new SimpleTextBuilder(SectionsVacd.HISTORY_OF_PREGNANCIES, pregnancyText,
						oldSectionText);
			} else {
				sb = new SimpleTextBuilder(SectionsVacd.HISTORY_OF_PREGNANCIES, pregnancyText);
			}

			reference = Util.createReference(sb.getNewTextContentIDNr(),
					SectionsVacd.HISTORY_OF_PREGNANCIES.getContentIdPrefix());
			phs.createStrucDocText(sb.toString());
		} else {
			setNarrativeTextSectionHistoryOfPregnancies("");
			reference = Util.createReference(1,
					SectionsVacd.HISTORY_OF_PREGNANCIES.getContentIdPrefix());
		}
		pregnancy.getMdhtPregnancy().setText(reference);
		phs.addObservation(pregnancy.copyMdhtPregnancy());
	}

	protected CdaChVacdV1 correctSectionSequence() {
		// Correct the order of the body sections
		// Create a copy of the current document
		final CdaChVacdV1 newVacd = EcoreUtil.copy(getMdht());

		// Create a new structured body
		final StructuredBody sb = CDAFactory.eINSTANCE.createStructuredBody();

		// Copy all sections from the original document in the right order
		final CdaChVacdV1 oldVacd = getMdht();
		CdaUtil.addSectionToStructuredBodyAsCopy(sb, oldVacd.getImmunizationsSection());
		CdaUtil.addSectionToStructuredBodyAsCopy(sb, oldVacd.getActiveProblemsSection());
		CdaUtil.addSectionToStructuredBodyAsCopy(sb, oldVacd.getHistoryOfPastIllnessSection());
		CdaUtil.addSectionToStructuredBodyAsCopy(sb, oldVacd.getAllergiesReactionsSection());
		CdaUtil.addSectionToStructuredBodyAsCopy(sb, oldVacd.getCodedResultsSection());
		CdaUtil.addSectionToStructuredBodyAsCopy(sb, oldVacd.getLaboratorySpecialtySection());
		CdaUtil.addSectionToStructuredBodyAsCopy(sb, oldVacd.getPregnancyHistorySection());
		CdaUtil.addSectionToStructuredBodyAsCopy(sb,
				oldVacd.getImmunizationRecommendationSection());
		// Workaround for the MDHT bug (?), which causes the domain specific
		// getter to not find the remarks section
		CdaUtil.addSectionToStructuredBodyAsCopy(sb, this.findRemarksSection());

		newVacd.getComponent().setStructuredBody(sb);
		return newVacd;
	}

	/**
	 * <div class="en">creates a CdaChVacdV1 specific laboratory
	 * observation</div>
	 *
	 * @param serologieCode
	 *            the CdaChVacdV1 specific serologie code
	 * @param laboratorySpecificCode
	 *            a code that is used in the laboratory
	 * @param dateTimeOfResult
	 *            date and time, when the result was known
	 * @param performer
	 *            the performer, who made the observation
	 * @param value
	 *            the value of the observation
	 * @return the laboratory observation
	 */
	public LaboratoryObservation createLaboratoryObservation(SerologieForVacd serologieCode,
			Code laboratorySpecificCode, Date dateTimeOfResult, Performer performer, Value value) {
		final LaboratoryObservation lo = new LaboratoryObservation();
		final Code serCode = serologieCode.getCode();
		serCode.addTranslation(laboratorySpecificCode);
		lo.setCode(serCode);
		lo.setEffectiveTime(dateTimeOfResult);
		lo.addPerformer(performer, dateTimeOfResult);
		lo.addValue(value);
		return lo;
	}

	/**
	 * <div class="en">creates a CdaChVacdV1 specific laboratory
	 * observation</div>
	 *
	 * @param serologieCode
	 *            the CdaChVacdV1 specific serologie code
	 * @param laboratorySpecificCode
	 *            a code that is used in the laboratory
	 * @param dateTimeOfResult
	 *            date and time, when the result was known
	 * @param performer
	 *            the performer, who made the observation
	 * @param value
	 *            the value of the observation
	 * @param observationInterpretation
	 *            a CdaChVacdV1 related code for the observationInterpretation
	 * @return the laboratory observation
	 */
	public LaboratoryObservation createLaboratoryObservation(SerologieForVacd serologieCode,
			Code laboratorySpecificCode, Date dateTimeOfResult, Performer performer, Value value,
			final ObservationInterpretationForImmunization observationInterpretation) {
		final LaboratoryObservation lo = createLaboratoryObservation(serologieCode,
				laboratorySpecificCode, dateTimeOfResult, performer, value);
		lo.setInterpretationCode(observationInterpretation);
		return lo;
	}

	/**
	 * <div class="en">creates a CdaChVacdV1 specific laboratory
	 * observation</div>
	 *
	 * @param serologieCode
	 *            the CdaChVacdV1 specific serologie code
	 * @param laboratorySpecificCode
	 *            a code that is used in the laboratory
	 * @param dateTimeOfResult
	 *            date and time, when the result was known
	 * @param performer
	 *            the performer, who made the observation
	 * @param value
	 *            the value of the observation
	 * @param observationInterpretation
	 *            a CdaChVacdV1 related code for the observationInterpretation
	 * @param comment
	 *            a comment for this Laboratory Observation
	 * @return the laboratory observation
	 */
	public LaboratoryObservation createLaboratoryObservation(SerologieForVacd serologieCode,
			Code laboratorySpecificCode, Date dateTimeOfResult, Performer performer, Value value,
			final ObservationInterpretationForImmunization observationInterpretation,
			String comment) {
		final LaboratoryObservation lo = createLaboratoryObservation(serologieCode,
				laboratorySpecificCode, dateTimeOfResult, performer, value,
				observationInterpretation);
		lo.setCommentText(comment);
		return lo;
	}

	/**
	 * <div class="en">Get the immunizations defined by the filter</div>
	 * <div class="de">Gibt alle Impfungen gemäss filter zurück</div>
	 *
	 * @return List with filtered immunizations
	 */
	private List<Immunization> filterImmunizations(boolean undesired, boolean desired) {
		final List<Immunization> immunizations = new ArrayList<Immunization>();
		if (getDoc().getImmunizationsSection() != null) {
			final EList<org.openhealthtools.mdht.uml.cda.ch.Immunization> il = getDoc()
					.getImmunizationsSection().getImmunizations();

			for (final org.openhealthtools.mdht.uml.cda.ch.Immunization i : il) {
				final Immunization immunization = new Immunization(i);
				if (undesired && immunization.isUndesired()) {
					immunizations.add(immunization);
				} else if (desired && !immunization.isUndesired()) {
					immunizations.add(immunization);
				}
			}
		}
		return immunizations;
	}

	private Section findRemarksSection() {
		for (final Section section : getDoc().getSections()) {
			if (section.getCode() != null) {
				if (SectionsVacd.isRemarks(section.getCode().getCode())) {
					return section;
				}
			}
		}
		return null;
	}

	private void fixGeneralHeaderConstraintTemplateId() {
		for (int i = 0; i < getDoc().getTemplateIds().size(); i++) {
			if ("2.16.840.1.113883.10.20.3".equals(getDoc().getTemplateIds().get(i).getRoot())) {
				getDoc().getTemplateIds().remove(i);
			}
		}
	}

	/**
	 * <div class="en">Generates the human readable text of the active problems
	 * chapter</div> <div class="de">Liefert den menschenlesbaren Text des
	 * Kapitels zu Aktiven Leiden zurück</div>
	 *
	 * @return the active problem concerns text
	 */
	public String generateNarrativeTextActiveProblemConcerns() {
		final List<AbstractProblemConcern> problemConcernEntryList = new ArrayList<AbstractProblemConcern>();
		// Convert from the specific PastProblemConcern Type to the more
		// general PastProblemConcern
		problemConcernEntryList.addAll(getActiveProblemConcerns());
		final ProblemConcernEntryChTextBuilder b = new ProblemConcernEntryChTextBuilder(
				problemConcernEntryList, SectionsVacd.ACTIVE_PROBLEMS);
		return b.toString();
	}

	/**
	 * <div class="en">Generates the human readable text of the allergy concerns
	 * chapter</div> <div class="de">Liefert den Text des Kapitels Allergie
	 * Leiden zurück</div>
	 *
	 * @return the allergy problem concerns text
	 */
	public String generateNarrativeTextAllergyProblemConcerns(LanguageCode lang) {
		final AllergyConcernChTextBuilder b = new AllergyConcernChTextBuilder(
				getAllergyProblemConcerns(), SectionsVacd.ALLERGIES_REACTIONS, lang);
		return b.toString();
	}

	/**
	 * <div class="en">Generates the human readable text of the history of past
	 * illness chapter</div> <div class="de">Liefert den menschenlesbaren Text
	 * zu allen vergangenen Leiden zurück</div>
	 *
	 * @return the past problem concern entries text
	 */
	public String generateNarrativeTextPastProblemConcernEntries() {
		final List<AbstractProblemConcern> problemConcernEntryList = new ArrayList<AbstractProblemConcern>();

		// Convert from the specific PastProblemConcern Type to the more
		// general PastProblemConcern
		problemConcernEntryList.addAll(getPastProblemConcerns());
		final ProblemConcernEntryChTextBuilder b = new ProblemConcernEntryChTextBuilder(
				problemConcernEntryList, SectionsVacd.HISTORY_OF_PAST_ILLNESS);
		return b.toString();
	}

	/**
	 * <div class="en">Gets the active problems</div> <div class="de">Liefert
	 * alle Aktiven Leiden zurück</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return the active problem concerns
	 */
	public List<ActiveProblemConcern> getActiveProblemConcerns() {
		// Search for the right section
		final Section aps = getDoc().getActiveProblemsSection();
		if (aps == null) {
			return null;
		}
		final EList<Act> acts = aps.getActs();

		final List<ActiveProblemConcern> problemConcernEntries = new ArrayList<ActiveProblemConcern>();
		for (final Act act : acts) {
			final ActiveProblemConcern problemConcernEntry = new ActiveProblemConcern(
					(org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) act);
			problemConcernEntries.add(problemConcernEntry);
		}
		return problemConcernEntries;
	}

	/**
	 * <div class="en">Gets the allergy problem concerns</div>
	 * <div class="de">Liefert alle Allergie Leiden zurück</div>
	 *
	 * @return the allergy problem concerns
	 */
	public List<AllergyConcern> getAllergyProblemConcerns() {
		// Search for the right section
		final Section ars = getDoc().getAllergiesReactionsSection();
		if (ars == null) {
			return null;
		}
		final EList<Act> acts = ars.getActs();

		final List<AllergyConcern> problemConcernEntries = new ArrayList<AllergyConcern>();
		for (final Act act : acts) {
			final AllergyConcern problemConcernEntry = new AllergyConcern(
					(org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern) act);
			problemConcernEntries.add(problemConcernEntry);
		}
		return problemConcernEntries;
	}

	/**
	 * <div class="en">Gets all applied immunizations</div>
	 * <div class="de">Liefert alle durchgeführten Impfungen zurück</div>
	 *
	 * @return List with only applied immunizations
	 */
	public List<Immunization> getAppliedImmunizations() {
		return filterImmunizations(false, true);
	}

	/**
	 * <div class="en">Gets the coded results</div> <div class="de">Liefert die
	 * Codierten Resultate zurück</div>
	 *
	 * @return the gestational age
	 */
	public GestationalAge getCodedResults() {
		return new GestationalAge(getDoc().getCodedResultsSection());
	}

	/**
	 * <div class="en">Gets the human readable text of the coded results
	 * section</div> <div class="de">Liefert den menschenlesbaren Text zu den
	 * Codierten Resultaten zurück</div>
	 *
	 * @return the gestational age text
	 */
	public String getCodedResultsText() {
		return getCodedResults().getCodedResultsText();
	}

	/**
	 * <div class="en">Gets the MDHT-CdaChVacdV1 Object</div>
	 * <div class="de">Liefert das MDHT-CdaChVacdV1-Objekt zurück.</div>
	 *
	 * @return the doc
	 */
	@Override
	public CdaChVacdV1 getDoc() {
		return super.getDoc();
	}

	/**
	 * <div class="en">Gets the immunization recommendations</div>
	 * <div class="de">Liefert alle Impfempfehlungen zurück</div>
	 *
	 * @return List with immunization recommendations
	 */
	public List<ImmunizationRecommendation> getImmunizationRecommendations() {
		// Search for the right section
		final Section tps = getDoc().getImmunizationRecommendationSection();
		if (tps == null) {
			return null;
		}
		final EList<SubstanceAdministration> substanceAdministrations = tps
				.getSubstanceAdministrations();

		final List<ImmunizationRecommendation> immunizations = new ArrayList<ImmunizationRecommendation>();
		for (final SubstanceAdministration substanceAdministration : substanceAdministrations) {
			final ImmunizationRecommendation immunization = new ImmunizationRecommendation(
					(org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendation) substanceAdministration);
			immunizations.add(immunization);
		}
		return immunizations;
	}

	/**
	 * <div class="en">Gets all immunizations (applied and unwanted)</div>
	 * <div class="de">Liefert alle Impfungen zurück (durchgeführte und
	 * unerwünschte)</div>
	 *
	 * @return List with all immunizations
	 */
	public List<Immunization> getImmunizations() {
		return filterImmunizations(true, true);
	}

	/**
	 * <div class="en">Gets the laboratory observations</div>
	 * <div class="de">Liefert alle Laborresultate zurück</div>
	 *
	 * @return List with laboratory observations
	 */
	public List<AbstractObservation> getLaboratoryObservations() {
		// Search for the right section
		final Section los = getDoc().getLaboratorySpecialtySection();
		if (los == null) {
			return null;
		}
		final EList<Entry> entries = los.getEntries();

		final List<AbstractObservation> labObservations = new ArrayList<AbstractObservation>();
		for (final Entry entry : entries) {
			final org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryReportDataProcessingEntry mLabRdpe = (org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryReportDataProcessingEntry) entry;

			final Act act = mLabRdpe.getAct();
			for (final EntryRelationship er : act.getEntryRelationships()) {
				if (er.getOrganizer() instanceof LaboratoryBatteryOrganizer) {
					final LaboratoryBatteryOrganizer mLabOrg = (LaboratoryBatteryOrganizer) er
							.getOrganizer();
					for (final org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation mLo : mLabOrg
							.getLaboratoryObservations()) {
						final org.ehealth_connector.cda.ch.vacd.LaboratoryObservation lo = new org.ehealth_connector.cda.ch.vacd.LaboratoryObservation(
								mLo);
						labObservations.add(lo);
					}
				}
			}
		}
		return labObservations;
	}

	/**
	 * Gets the laboratory specialty section.
	 *
	 * @return the laboratory specialty section
	 */
	@Override
	public LaboratorySpecialtySection getLaboratorySpecialtySection() {
		return new LaboratorySpecialtySection(getMdht().getLaboratorySpecialtySection());
	}

	/**
	 * Gets the narrative text.
	 *
	 * @param s
	 *            the section
	 * @return the narrative text
	 */
	private String getNarrativeText(Section s) {
		if (s != null) {
			final StrucDocText t = s.getText();
			return Util.extractStringFromNonQuotedStrucDocText(t);
		}
		return null;
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionActiveProblems() {
		return getNarrativeText(getDoc().getActiveProblemsSection());
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionAllergiesAndOtherAdverseReactions() {
		return getNarrativeText(getDoc().getAllergiesReactionsSection());
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionCodedResults() {
		return getNarrativeText(getDoc().getCodedResultsSection());
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionHistoryOfPastIllnes() {
		return getNarrativeText(getDoc().getHistoryOfPastIllnessSection());
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionHistoryOfPregnancies() {
		return getNarrativeText(getDoc().getPregnancyHistorySection());
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionImmunizationRecommendations() {
		return getNarrativeText(getDoc().getImmunizationRecommendationSection());
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionImmunizations() {
		return getNarrativeText(getDoc().getImmunizationsSection());
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionLaboratorySpecialty() {
		return getNarrativeText(getDoc().getLaboratorySpecialtySection());
	}

	/**
	 * <div class="en">Gets the human readable CDA section text for the
	 * according section</div> <div class="de">Liefert den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @return <div class="en"> the text of the human readable part of the cda
	 *         document</div> <div class="de"> der text des menschlenlesbaren
	 *         Teils des CDA-Dokuments</div>
	 */
	public String getNarrativeTextSectionRemarks() {
		return getNarrativeText(findRemarksSection());
	}

	/**
	 * <div class="en">Gets the past problem concerns</div>
	 * <div class="de">Liefert alle vergangen Leiden zurück</div>
	 *
	 * @return the past problem concern entries
	 */
	public List<PastProblemConcern> getPastProblemConcerns() {
		// Search for the right section
		final Section hopis = getDoc().getHistoryOfPastIllnessSection();
		if (hopis == null) {
			return null;
		}
		final EList<Act> acts = hopis.getActs();

		final List<PastProblemConcern> problemConcernEntries = new ArrayList<PastProblemConcern>();
		for (final Act act : acts) {
			final PastProblemConcern problemConcernEntry = new PastProblemConcern(
					(org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) act);
			problemConcernEntries.add(problemConcernEntry);
		}
		return problemConcernEntries;
	}

	/**
	 * <div class="en">Gets the pregnancies</div> <div class="de">Liefert alle
	 * Schwangerschaften zurück</div>
	 *
	 * @return Liste von Schwangerschaften
	 */
	public List<PregnancyHistory> getPregnancies() {
		// Search for the right section
		final PregnancyHistorySection phs = getDoc().getPregnancyHistorySection();
		if (phs == null) {
			return null;
		}
		final List<PregnancyHistory> pregnancies = new ArrayList<PregnancyHistory>();
		for (final PregnancyObservation mPregnancy : phs.getPregnancyObservations()) {
			final PregnancyHistory immunization = new PregnancyHistory(mPregnancy);
			pregnancies.add(immunization);
		}
		return pregnancies;
	}

	/**
	 * <div class="en">Collects all ActiveProblemConcerns from the List from
	 * {@link #getActiveProblemConcerns()} which are of type
	 * {@link RiskOfComplications}</div>
	 *
	 * <div class="de">Sammelt alle Einträge des Typs
	 * {@link ActiveProblemConcern} aus der Liste von
	 * {@link #getActiveProblemConcerns()} welche vom Typ
	 * {@link RiskOfComplications} sind</div>
	 *
	 * @return the allergy problem concerns
	 */
	public List<ActiveProblemConcern> getRiskOfComplications() {
		final List<ActiveProblemConcern> problemConcerns = getActiveProblemConcerns();
		final List<ActiveProblemConcern> riskOfComplications = new ArrayList<ActiveProblemConcern>();
		if (problemConcerns != null) {
			for (final ActiveProblemConcern aConcern : problemConcerns) {
				final Value value = aConcern.getProblemEntry().getValue();
				if ((value != null) && (value.getCode() != null)
						&& !StringUtils.isEmpty(value.getCode().getCode())) {
					if (RiskOfComplications.isInValueSet(value.getCode().getCode())) {
						riskOfComplications.add(aConcern);
					}
				}
			}
		}
		return riskOfComplications;
	}

	/**
	 * <div class="en">Collects all ActiveProblemConcerns from the List from
	 * {@link #getActiveProblemConcerns()} which are of type
	 * {@link RiskOfExposure}</div>
	 *
	 * <div class="de">Sammelt alle Einträge des Typs
	 * {@link ActiveProblemConcern} aus der Liste von
	 * {@link #getActiveProblemConcerns()} welche vom Typ {@link RiskOfExposure}
	 * sind</div>
	 *
	 * @return the allergy problem concerns
	 */
	public List<ActiveProblemConcern> getRiskOfExposure() {
		final List<ActiveProblemConcern> problemConcerns = getActiveProblemConcerns();
		final List<ActiveProblemConcern> riskOfExposures = new ArrayList<ActiveProblemConcern>();
		if (problemConcerns != null) {
			for (final ActiveProblemConcern aConcern : problemConcerns) {
				final Value value = aConcern.getProblemEntry().getValue();
				if ((value != null) && (value.getCode() != null)
						&& !StringUtils.isEmpty(value.getCode().getCode())) {
					if (RiskOfExposure.isInValueSet(value.getCode().getCode())) {
						riskOfExposures.add(aConcern);
					}
				}
			}
		}
		return riskOfExposures;
	}

	/**
	 * <div class="en">Gets all immunizations</div> <div class="de">Liefert alle
	 * Impfungen zurück</div>
	 *
	 * @return List with only undesired immunizations
	 */
	public List<Immunization> getUndesiredImmunizations() {
		return filterImmunizations(true, false);
	}

	private void initVacd() {
		ChPackage.eINSTANCE.eClass();
		setTitle(ECdaChVacdV1OC_TITLE);
		fixGeneralHeaderConstraintTemplateId();
		new Query(getDoc());
	}

	/**
	 * <div class="en">Pseudonymization of a clinical document according to the
	 * CDA-CH-CdaChVacdV1 specification (Rule CH-CdaChVacdV1-HPAT)</div>
	 * <div class="de">Pseudonymisierung eines ClinicalDocument nach der
	 * CDA-CH-CdaChVacdV1 Spezifikation (siehe CDA-CH-CdaChVacdV1, UseCases ab
	 * Kapitel 6.3 und insbesondere Kapitel "7.4 CDA Header", Regel
	 * CH-CdaChVacdV1-HPAT)</div>
	 */
	public void pseudonymization() {
		final RecordTarget destRecordTarget = CDAFactory.eINSTANCE.createRecordTarget();
		for (@SuppressWarnings("unused")
		RecordTarget sourceRecTarget : getDoc().getRecordTargets()) {

			for (final PatientRole sourcePatientRole : getDoc().getPatientRoles()) {
				final Patient sourcePatient = sourcePatientRole.getPatient();

				final PatientRole destPatientRole = CDAFactory.eINSTANCE.createPatientRole();
				final Patient destPatient = CDAFactory.eINSTANCE.createPatient();
				destPatientRole.setPatient(destPatient);

				// Copy the allow attributes from the sourcePatient
				destPatient.setBirthTime(sourcePatient.getBirthTime());
				destPatient
						.setAdministrativeGenderCode(sourcePatient.getAdministrativeGenderCode());
				// Adress
				for (final AD sourceAd : sourcePatientRole.getAddrs()) {
					final AD ad = DatatypesFactory.eINSTANCE.createAD();
					for (final ADXP adxp : sourceAd.getPostalCodes()) {
						if (adxp.getText() != null) {
							ad.addPostalCode(adxp.getText());
							ad.getUses().addAll(sourceAd.getUses());
						}
					}
					destPatientRole.getAddrs().add(ad);
				}

				// ID MSK
				final II ii = DatatypesFactory.eINSTANCE.createII();
				ii.setNullFlavor(NullFlavor.MSK);
				destPatientRole.getIds().add(ii);
				destRecordTarget.setPatientRole(destPatientRole);
			}
			sourceRecTarget = destRecordTarget;
		}
		getDoc().getRecordTargets().clear();
		getDoc().getRecordTargets().add(destRecordTarget);
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionActiveProblems(String text) {
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsVacd.ACTIVE_PROBLEMS, text);
		if (getDoc().getActiveProblemsSection() != null) {
			getDoc().getActiveProblemsSection().createStrucDocText(sb.toString());
		}
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionAllergiesAndOtherAdverseReactions(String text) {
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsVacd.ALLERGIES_REACTIONS, text);
		if (getDoc().getAllergiesReactionsSection() != null) {
			getDoc().getAllergiesReactionsSection().createStrucDocText(sb.toString());
		}
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionCodedResults(String text) {
		if (getDoc().getCodedResultsSection() != null) {
			getDoc().getCodedResultsSection().createStrucDocText(text);
		}
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionHistoryOfPastIllnes(String text) {
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsVacd.HISTORY_OF_PAST_ILLNESS,
				text);
		if (getDoc().getHistoryOfPastIllnessSection() != null) {
			getDoc().getHistoryOfPastIllnessSection().createStrucDocText(sb.toString());
		}
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionHistoryOfPregnancies(String text) {
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsVacd.HISTORY_OF_PREGNANCIES,
				text);
		if (getDoc().getPregnancyHistorySection() != null) {
			getDoc().getPregnancyHistorySection().createStrucDocText(sb.toString());
		}
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionImmunizationRecommendations(String text) {
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsVacd.TREATMENT_PLAN, text);
		if (getDoc().getImmunizationRecommendationSection() != null) {
			getDoc().getImmunizationRecommendationSection().createStrucDocText(sb.toString());
		}
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionImmunizations(String text) {
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsVacd.HISTORY_OF_IMMUNIZATION,
				text);
		if (getDoc().getImmunizationsSection() != null) {
			getDoc().getImmunizationsSection().createStrucDocText(sb.toString());
		}
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>.
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 * @param contentId
	 *            the content id for text references.
	 */
	public void setNarrativeTextSectionImmunizations(String text, String contentId) {
		String temp = contentId;
		if (temp.startsWith("#"))
			temp = temp.substring(1, temp.length());
		final SimpleTextBuilder sb = new SimpleTextBuilder(temp, text);
		if (getDoc().getImmunizationsSection() != null) {
			getDoc().getImmunizationsSection().createStrucDocText(sb.toString());
		}
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionLaboratorySpeciality(String text) {
		if (getDoc().getLaboratorySpecialtySection() != null) {
			getDoc().getLaboratorySpecialtySection().createStrucDocText(text);
		}
	}

	/**
	 * <div class="en">Sets the human readable CDA section text for the
	 * according section</div> <div class="de">Setzt den menschenlesbaren CDA
	 * Section Text für die entsprechende Section</div>
	 *
	 * @param text
	 *            <div class="en"> the new text for the human readable part of
	 *            the cda document</div> <div class="de"> der neue text für den
	 *            menschlenlesbaren Teil des CDA-Dokuments</div>
	 */
	public void setNarrativeTextSectionRemarks(String text) {
		final SimpleTextBuilder sb = new SimpleTextBuilder(SectionsVacd.REMARKS, text);
		if (findRemarksSection() != null) {
			findRemarksSection().createStrucDocText(sb.toString());
		}
	}

	private boolean updateAllergyConcernReferences(EList<Act> acts, SectionsVacd loincSectionCode) {
		int i = 0;
		for (final Act act : acts) {
			int j = 0;
			i++;
			final org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern problemConcernEntry = (org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern) act;
			for (final ProblemEntry problemEntry : problemConcernEntry.getAllergyIntolerances()) {
				// Check if the problem is not unknown (leads to no reference,
				// because there is no problem)
				final Code code = new Code(problemEntry.getCode());
				if ("2.16.840.1.113883.6.96".equals(code.getCodeSystem()) && code.getCode().equals(
						ProblemsSpecialConditions.HISTORY_OF_PAST_ILLNESS_UNKNOWN.getCode())) {
					return false;
				} else {
					// Create references to level 1 text
					ED reference;
					if (isNarrativeTextGenerationEnabled()) {
						reference = Util.createReference(i, loincSectionCode.getContentIdPrefix());
					} else {
						reference = Util.createReference(1, loincSectionCode.getContentIdPrefix());
					}
					problemEntry.setText(EcoreUtil.copy(reference));
					problemEntry.getCode().setOriginalText(EcoreUtil.copy(reference));
				}
				for (final EntryRelationship er : problemEntry.getEntryRelationships()) {
					j++;
					CdaChUtil.updateRefIfComment(isNarrativeTextGenerationEnabled(), er,
							String.valueOf(i) + String.valueOf(j), loincSectionCode);
				}
			}
		}
		return true;
	}

	private void updateLaboratoryObservationReferences(SpecimenAct spa,
			SectionsVacd loincSectionCode) {
		for (int i = 0; i < spa.getLaboratoryBatteryOrganizers().size(); i++) {
			final LaboratoryBatteryOrganizer lba = spa.getLaboratoryBatteryOrganizers().get(i);
			for (int j = 0; j < lba.getLaboratoryObservations().size(); j++) {
				final org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation lo = lba
						.getLaboratoryObservations().get(j);
				for (int k = 0; k < lo.getEntryRelationships().size(); k++) {
					final EntryRelationship er = lo.getEntryRelationships().get(k);
					if (Util.isComment(er)) {
						++k;
						CdaChUtil.updateRefIfComment(
								isNarrativeTextGenerationEnabled(), er, String.valueOf(i + 1)
										+ String.valueOf(j + 1) + String.valueOf(k + 1),
								loincSectionCode);
					}
				}
			}
		}
	}

	private boolean updateProblemConcernReferences(EList<Act> acts, SectionsVacd loincSectionCode) {
		int i = 0;
		for (final Act act : acts) {
			final org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry problemConcernEntry = (org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) act;
			for (final ProblemEntry problemEntry : problemConcernEntry.getProblemEntries()) {
				// Check if the problem is not unknown (leads to no reference,
				// because there is no problem)
				final Code code = new Code(problemEntry.getCode());
				if ("2.16.840.1.113883.6.96".equals(code.getCodeSystem()) && code.getCode().equals(
						ProblemsSpecialConditions.HISTORY_OF_PAST_ILLNESS_UNKNOWN.getCode())) {
					return false;
				} else {
					// Create references to level 1 text
					i++;
					ED reference;
					if (isNarrativeTextGenerationEnabled()) {
						reference = Util.createReference(i, loincSectionCode.getContentIdPrefix());
					} else {
						reference = Util.createReference(1, loincSectionCode.getContentIdPrefix());
					}
					problemEntry.setText(EcoreUtil.copy(reference));
					problemEntry.getCode().setOriginalText(EcoreUtil.copy(reference));
				}
			}
		}
		return true;
	}

}
