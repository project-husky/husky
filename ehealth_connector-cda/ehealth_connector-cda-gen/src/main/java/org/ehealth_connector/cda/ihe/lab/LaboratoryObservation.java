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

package org.ehealth_connector.cda.ihe.lab;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.ehealth_connector.cda.MdhtObservationFacade;
import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.utils.CdaUtilMdht;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.mdht.Author;
import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.mdht.IdentityDomain;
import org.ehealth_connector.common.mdht.Organization;
import org.ehealth_connector.common.mdht.Performer;
import org.ehealth_connector.common.mdht.ReferenceRange;
import org.ehealth_connector.common.mdht.Value;
import org.ehealth_connector.common.mdht.enums.ObservationInterpretation;
import org.ehealth_connector.common.utils.DateUtilMdht;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.AssignedEntity;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.Performer2;
import org.openhealthtools.mdht.uml.cda.ihe.Comment;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.ParticipationPhysicalPerformer;
import org.openhealthtools.mdht.uml.hl7.vocab.ParticipationType;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * Class LaboratoryObservation. The document SHALL contain at least one
 * Laboratory Observation within each Laboratory Report Data Processing Entry.
 */
public class LaboratoryObservation extends
		MdhtObservationFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation> {

	/**
	 * Instantiates a new laboratory observation.
	 */
	public LaboratoryObservation() {
		super(LABFactory.eINSTANCE.createLaboratoryObservation().init());
		getMdht().getInterpretationCodes().clear();
	}

	/**
	 * Instantiates a new laboratory observation.
	 *
	 * @param code
	 *            <div class="en">Code for a laboratory observation</div>
	 *            <div class="de">Code für einen bezüglich einer Impfung
	 *            relevanten Laborbefund</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 * @param dateTimeOfResult
	 *            <div class="en">date and time, when the result was known</div>
	 *            <div class="de">Datum und Uhrzeit, an dem das Resultat bekannt
	 *            wurde.</div> <div class="fr"></div> <div class="it"></div>
	 * @param laboratory
	 *            <div class="en">the performing laboratory</div>
	 *            <div class="de">Das ausführende Labor.</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 */
	public LaboratoryObservation(Code code, Date dateTimeOfResult, Organization laboratory) {
		this();
		setCode(code);
		setEffectiveTime(dateTimeOfResult);
		setLaboratory(laboratory, dateTimeOfResult);
	}

	/**
	 * Instantiates a new laboratory observation.
	 *
	 * @param code
	 *            <div class="en">Code for a laboratory observation</div>
	 *            <div class="de">Code für einen bezüglich einer Impfung
	 *            relevanten Laborbefund</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 * @param dateTimeOfResult
	 *            <div class="en">date and time, when the result was known</div>
	 *            <div class="de">Datum und Uhrzeit, an dem das Resultat bekannt
	 *            wurde.</div> <div class="fr"></div> <div class="it"></div>
	 * @param laboratory
	 *            <div class="en">the performing laboratory</div>
	 *            <div class="de">Das ausführende Labor.</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 * @param value
	 *            <div class="de">Wert des Resultats (als Code-Objekt)</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 */
	public LaboratoryObservation(Code code, Date dateTimeOfResult, Organization laboratory,
			Value value) {
		this(code, dateTimeOfResult, laboratory);

		this.addValue(value);
	}

	/**
	 * Instantiates a new laboratory observation.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public LaboratoryObservation(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation mdht) {
		super(mdht);
	}

	/**
	 * Adds an author.
	 *
	 * @param author
	 *            the author
	 * @param dateTimeOfDocumentation
	 *            <div class="en">date and time, when the result was known</div>
	 *            <div class="de">Datum und Uhrzeit, an dem das Resultat bekannt
	 *            wurde.</div> <div class="fr"></div> <div class="it"></div>
	 */
	public void addAuthor(Author author, Date dateTimeOfDocumentation) {
		final org.openhealthtools.mdht.uml.cda.Author mAuthor = author.copyMdhtAuthor();
		mAuthor.setTypeCode(ParticipationType.AUT);
		try {
			mAuthor.setTime(DateUtilMdht.createIVL_TSFromEuroDate(dateTimeOfDocumentation));
		} catch (final ParseException e) {
			e.printStackTrace();
		}
		getMdht().getAuthors().add(mAuthor);
	}

	/**
	 * Add a comment entry.
	 *
	 * @param commentEntry
	 *            the new comment entry
	 */
	public void addCommentEntry(SectionAnnotationCommentEntry commentEntry) {
		this.getMdht().addAct(commentEntry.copy());
		// need to add the the Subj and setInversionInd, cannot do this
		// automatically with mdht
		for (final EntryRelationship entryRelationShip : getMdht().getEntryRelationships()) {
			if (entryRelationShip.getAct() instanceof Comment) {
				entryRelationShip.setInversionInd(true);
				entryRelationShip.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
			}
		}
	}

	/**
	 * Adds a nullFlavor interpretation code.
	 *
	 * @param nullFlavor
	 *            the desired NullFlavor.
	 */
	public void addInterpretationCode(NullFlavor nullFlavor) {
		final CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setNullFlavor(nullFlavor);
		getMdht().getInterpretationCodes().add(ce);
	}

	/**
	 * Adds a interpretation code.
	 *
	 * @param code
	 *            the new interpretation code
	 */
	public void addInterpretationCode(ObservationInterpretation code) {
		getMdht().getInterpretationCodes().add(code.getCE());
	}

	/**
	 * Adds a performer.
	 *
	 * @param performer
	 *            the performer
	 * @param dateTimeOfPerformance
	 *            <div class="en">date and time, when the result was known</div>
	 *            <div class="de">Datum und Uhrzeit, an dem das Resultat bekannt
	 *            wurde.</div> <div class="fr"></div> <div class="it"></div>
	 */
	public void addPerformer(Performer performer, Date dateTimeOfPerformance) {
		final Performer2 mPerformer = performer.copyMdhtPerfomer();
		mPerformer.setTypeCode(ParticipationPhysicalPerformer.PRF);
		try {
			mPerformer.setTime(DateUtilMdht.createIVL_TSFromEuroDate(dateTimeOfPerformance));
		} catch (final ParseException e) {
			e.printStackTrace();
		}
		getMdht().getPerformers().add(mPerformer);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.ehealth_connector.cda.MdhtObservationFacade#addPreviousObservation(
	 * org.ehealth_connector.cda.ihe.lab.LaboratoryObservation)
	 */
	@Override
	public void addPreviousObservation(LaboratoryObservation laboratoryObservation) {
		CdaUtilMdht.removeTemplateId(laboratoryObservation.getMdht(),
				new Identificator("2.16.756.5.30.1.1.10.4.3"));
		super.addPreviousObservation(laboratoryObservation);
	}

	/**
	 * Adds a translation code.
	 *
	 * @param code
	 *            the translation code
	 */
	public void addTranslation(Code code) {
		getMdht().getCode().getTranslations().add(code.getCD());
	}

	/**
	 * Sets the value as code.
	 *
	 * @param code
	 *            the new value
	 */
	public void addValue(Code code) {
		getMdht().getValues().add(code.getCD());
	}

	/**
	 * Adds a value.
	 *
	 * @param value
	 *            the new value
	 */
	@Override
	public void addValue(Value value) {
		getMdht().getValues().add(value.getValue());
	}

	/**
	 * Gets the auhtor list.
	 *
	 * @return the auhtor list
	 */
	public List<Author> getAuthors() {
		final List<Author> list = new ArrayList<Author>();
		for (final org.openhealthtools.mdht.uml.cda.Author mdht : getMdht().getAuthors()) {
			final Author eHC = new Author(mdht);
			list.add(eHC);
		}
		return list;
	}

	/**
	 * <div class="en">Gets the code of the observation</div>
	 * <div class="de">Gibt den Code der Beobachtung zurück.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @return the code
	 */
	public Code getCode() {
		final Code code = new Code(getMdht().getCode());
		return code;
	}

	/**
	 * Gets the reference to the comment in the level 2 section text (when set).
	 *
	 * @return the reference of the level 3 comment entry, which point to the
	 *         level 2 text
	 */
	public String getCommentRef() {
		return Util.getCommentRef(getMdht().getEntryRelationships());
	}

	/**
	 * <div class="en">Gets the date and time, when the examination was
	 * performed</div> <div class="de">Gibt das Datum und die Uhrzeit zurück,
	 * wann die Untersuchung durchgeführt wurde.</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return the date time of result
	 */
	public Date getDateTimeOfResult() {
		if (getMdht().getPerformers().size() > 0) {
			return DateUtilMdht
					.parseIVL_TSVDateTimeValue(getMdht().getPerformers().get(0).getTime());
		} else {
			return DateUtilMdht.parseIVL_TSVDateTimeValue(getMdht().getEffectiveTime());
		}
	}

	/**
	 * <div class="en">Gets the date and time of the performed examination as
	 * String</div> <div class="de">Gibt das Datum und die Uhrzeit, wann die
	 * Untersuchung durchgeführt wurde als String zurück (z.B. "28.02.2015
	 * 16:00" )</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return the date time of result
	 */
	public String getDateTimeOfResultStr() {
		if (getMdht().getPerformers().size() > 0) {
			return DateUtilMdht.formatDateTimeCh(DateUtilMdht
					.parseIVL_TSVDateTimeValue(getMdht().getPerformers().get(0).getTime()));
		} else {
			return DateUtilMdht.formatDateTimeCh(
					DateUtilMdht.parseIVL_TSVDateTimeValue(getMdht().getEffectiveTime()));
		}
	}

	/**
	 * Gets the specified id value based on its code system.
	 *
	 * @param codeSystem
	 *            id's identity domain
	 * @return the id or null if it doesn't exist
	 */
	public Identificator getId(IdentityDomain codeSystem) {
		Identificator ident = null;
		for (final II id : getMdht().getIds()) {
			if (id.getRoot().equalsIgnoreCase(codeSystem.getCodeSystemId())) {
				ident = new Identificator(id);
			}
		}
		return ident;
	}

	/**
	 * Get the ids.
	 *
	 * @return the ids
	 */
	public List<Identificator> getIds() {
		return Util.convertIds(getMdht().getIds());
	}

	/**
	 * Gets the interpretation codes as enum.
	 *
	 * @return the interpretation codes as enum
	 */
	public List<ObservationInterpretation> getInterpretationCodesAsEnum() {
		final List<ObservationInterpretation> icl = new ArrayList<ObservationInterpretation>();
		for (final CE ic : getMdht().getInterpretationCodes()) {
			final ObservationInterpretation oi = ObservationInterpretation.getEnum(ic.getCode());
			if (oi != null) {
				icl.add(ObservationInterpretation.getEnum(ic.getCode()));
			}
		}
		return icl;
	}

	/**
	 * <div class="en">Gets interpretation code values, which indicates wheater
	 * an immune protection exists (Interpretation Code)</div>
	 * <div class="de">Gibt zurück, ob ein Impfschutz besteht (erster
	 * Interpretation Code).</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return the interpretation code
	 */
	public List<String> getInterpretationCodeValues() {
		final List<String> icl = new ArrayList<String>();
		for (final CE ic : getMdht().getInterpretationCodes()) {
			icl.add(ic.getCode());
		}
		return icl;
	}

	/**
	 * <div class="en">Gets the laboratory organization, which performed the
	 * examination</div> <div class="de">Gibt das Labor zurück, welches das
	 * Ergebnis ermittelt hat.</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return the laboratory
	 */
	public Organization getLaboratory() {
		if (getMdht().getPerformers().size() > 0) {
			if (getMdht().getPerformers().get(0).getAssignedEntity() != null) {
				if (getMdht().getPerformers().get(0).getAssignedEntity()
						.getRepresentedOrganizations().size() > 0) {
					return new Organization(getMdht().getPerformers().get(0).getAssignedEntity()
							.getRepresentedOrganizations().get(0));
				}
			}
		}
		return null;
	}

	/**
	 * Gets the performer list.
	 *
	 * @return the performer list
	 */
	public List<Performer> getPerformers() {
		final List<Performer> list = new ArrayList<Performer>();
		for (final Performer2 mdht : getMdht().getPerformers()) {
			final Performer eHC = new Performer(mdht);
			list.add(eHC);
		}
		return list;
	}

	/**
	 * Gets the result.
	 *
	 * @param resBundle
	 *            the res bundle
	 * @return the result
	 */
	public String getResult(ResourceBundle resBundle) {
		String retVal = "";
		for (Value value : getValues()) {
			String tempOneValue = "";
			String tempOneUnit = "";
			if (value != null) {
				if (value.isPhysicalQuantity()) {
					tempOneValue = value.getPhysicalQuantityValue();
					if ("-1".equals(tempOneValue))
						tempOneValue = "-";
					tempOneUnit = value.getPhysicalQuantityUnit();
				} else if (value.isRto()) {
					tempOneValue = value.getRtoValueText();
					tempOneUnit = value.getRtoUnitText();
				} else if (value.isBl()) {
					if (value.getValue() != null) {
						String temp = value.getBlText();
						if (temp != null) {
							tempOneValue = resBundle.getString("generic." + temp);
						}
					}
				} else if (value.isEd()) {
					tempOneValue = value.toString();
					tempOneValue = tempOneValue.replace("<", "&lt;");
					tempOneValue = tempOneValue.replace(">", "&gt;");
				} else
					tempOneValue = value.toString();
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
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		String retVal = "";
		if (getMdht().getText() != null)
			retVal = getMdht().getText().getText();
		return retVal;
	}

	/**
	 * Gets the translation.
	 *
	 * @param codeSystemOid
	 *            the code system oid
	 * @return the translation
	 */
	public Code getTranslation(String codeSystemOid) {
		if (codeSystemOid != null) {
			for (CD item : getMdht().getCode().getTranslations()) {
				if (codeSystemOid.equals(item.getCodeSystem()))
					return new Code(item);
			}
		}
		return null;
	}

	/**
	 * Gets the translations.
	 *
	 * @return the translations
	 */
	public List<Code> getTranslations() {
		List<Code> retVal = new ArrayList<Code>();
		for (CD item : getMdht().getCode().getTranslations()) {
			retVal.add(new Code(item));
		}
		return retVal;
	}

	/**
	 * Adds a code.
	 *
	 * @param code
	 *            the new code
	 */
	public void setCode(Code code) {
		getMdht().setCode(code.getCD());
	}

	/**
	 * Sets a comment text.
	 *
	 * @param text
	 *            the text
	 */
	public void setCommentText(String text) {
		final Comment mComment = IHEFactory.eINSTANCE.createComment().init();
		final ED ed = DatatypesFactory.eINSTANCE.createED();
		ed.addText(text);
		mComment.setText(ed);
		getMdht().addAct(mComment);

		final EntryRelationship er = getMdht().getEntryRelationships()
				.get(getMdht().getEntryRelationships().size() - 1);
		er.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
		er.setInversionInd(true);
	}

	/**
	 * Adds a interpretation code.
	 *
	 * @param code
	 *            the new interpretation code
	 */
	public void setInterpretationCode(ObservationInterpretation code) {
		getMdht().getInterpretationCodes().clear();
		getMdht().getInterpretationCodes().add(code.getCE());
	}

	/**
	 * <div class="en">Sets the laboratory.</div> <div class="fr">Sets the
	 * laboratory.</div> <div class="it">Sets the laboratory.</div>
	 *
	 * @param laboratory
	 *            <br>
	 *            <div class="en"> laboratory</div> <div class="fr">
	 *            laboratory</div> <div class="it"> laboratory</div>
	 * @param dateTimeOfResult
	 *            <br>
	 *            <div class="en"> date time of result</div> <div class="fr">
	 *            date time of result</div> <div class="it"> date time of
	 *            result</div>
	 */
	public void setLaboratory(Organization laboratory, Date dateTimeOfResult) {
		final Performer2 perf = CDAFactory.eINSTANCE.createPerformer2();
		final AssignedEntity asEnt = CDAFactory.eINSTANCE.createAssignedEntity();

		if (laboratory.getId() != null) {
			final II ii = DatatypesFactory.eINSTANCE.createII(CodeSystems.GLN.getCodeSystemId(),
					laboratory.getId().getExtension());
			asEnt.getIds().add(ii);
		}

		asEnt.getRepresentedOrganizations().add(laboratory.copyMdhtOrganization());
		perf.setAssignedEntity(asEnt);
		perf.setTypeCode(ParticipationPhysicalPerformer.PRF);
		try {
			perf.setTime(DateUtilMdht.createIVL_TSFromEuroDateTime(dateTimeOfResult));
		} catch (final ParseException e) {
			e.printStackTrace();
		}
		getMdht().getPerformers().add(perf);
	}

	/**
	 * Sets the reference range <div class="de">(Referenzbereich)</div>.
	 *
	 * @param referenceRange
	 *            the new reference range
	 */
	public void setReferenceRange(ReferenceRange referenceRange) {
		if (referenceRange != null) {
			getMdht().getReferenceRanges().clear();
			getMdht().getReferenceRanges().add(referenceRange.getMdht());
		}
	}

	/**
	 * Sets the text.
	 *
	 * @param text
	 *            the new text
	 */
	public void setText(String text) {
		setText(text, null);
	}

	/**
	 * Sets the text.
	 *
	 * @param text
	 *            the text
	 * @param textReference
	 *            the text reference
	 */
	public void setText(String text, String textReference) {
		ED ed = null;
		if (textReference != null) {
			if (!textReference.startsWith("#"))
				textReference = "#" + textReference;
			ed = Util.createReference(textReference, text);
		}
		if (ed == null) {
			ed = DatatypesFactory.eINSTANCE.createED();
			ed.addText(text);
		}
		getMdht().setText(ed);
	}
}
