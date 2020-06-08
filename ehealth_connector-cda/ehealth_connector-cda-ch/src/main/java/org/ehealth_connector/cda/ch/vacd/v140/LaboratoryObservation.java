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

package org.ehealth_connector.cda.ch.vacd.v140;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.BaseObservation;
import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.ch.utils.CdaChUtil;
import org.ehealth_connector.cda.ch.vacd.v140.enums.ObservationInterpretationForImmunization;
import org.ehealth_connector.cda.enums.ActSite;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.mdht.IdentityDomain;
import org.ehealth_connector.common.mdht.Organization;
import org.ehealth_connector.common.mdht.Performer;
import org.ehealth_connector.common.mdht.ReferenceRange;
import org.ehealth_connector.common.mdht.Value;
import org.ehealth_connector.common.mdht.enums.StatusCode;
import org.ehealth_connector.common.utils.DateUtilMdht;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.AssignedEntity;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.Performer2;
import org.openhealthtools.mdht.uml.cda.ihe.Comment;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ANY;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.vocab.ParticipationPhysicalPerformer;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * <div class="en">Class LaboratoryObservation.</div> <div class="de">Klasse
 * Laborbefund</div> <div class="it"></div>
 */
public class LaboratoryObservation extends BaseObservation {

	/** The m laboratory observation. */
	private final org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation mLaboratoryObservation;

	/**
	 * Instantiates a new laboratory observation.
	 */
	public LaboratoryObservation() {
		super(null);
		mLaboratoryObservation = LABFactory.eINSTANCE.createLaboratoryObservation().init();
		mLaboratoryObservation.setStatusCode(StatusCode.COMPLETED.getCS());
		super.mObservation = mLaboratoryObservation;
	}

	/**
	 * Instantiates a new laboratory observation.
	 *
	 * @param code
	 *            <div class="en">Code for a laboratory observation</div>
	 *            <div class="de">Code für einen bezüglich einer Impfung
	 *            relevanten Laborbefund</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 * @param immuneProtection
	 *            <div class="en">true, if an immune protection exists</div>
	 *            <div class="de">true, wenn ein Immunschutz besteht.</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 * @param dateTimeOfResult
	 *            <div class="en">date and time, when the result was known</div>
	 *            <div class="de">Datum und Uhrzeit, an dem das Resultat bekannt
	 *            wurde.</div> <div class="fr"></div> <div class="it"></div>
	 * @param laboratory
	 *            <div class="en">the performing laboratory</div>
	 *            <div class="de">Das ausführende Labor.</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 */
	public LaboratoryObservation(Code code, boolean immuneProtection, Date dateTimeOfResult,
			Organization laboratory) {
		super(null);
		mLaboratoryObservation = LABFactory.eINSTANCE.createLaboratoryObservation().init();

		setCode(code);
		setEffectiveTime(dateTimeOfResult);
		setLaboratory(laboratory, dateTimeOfResult);
		mLaboratoryObservation.setStatusCode(StatusCode.COMPLETED.getCS());
		super.mObservation = mLaboratoryObservation;
	}

	/**
	 * Instantiates a new laboratory observation.
	 *
	 * @param code
	 *            <div class="en">Code for a laboratory observation</div>
	 *            <div class="de">Code für einen bezüglich einer Impfung
	 *            relevanten Laborbefund</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 * @param laboratory
	 *            <div class="en">the performing laboratory</div>
	 *            <div class="de">Das ausführende Labor.</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 * @param immuneProtection
	 *            <div class="en">true, if an immune protection exists</div>
	 *            <div class="de">true, wenn ein Immunschutz besteht.</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 * @param dateTimeOfResult
	 *            <div class="en">date and time, when the result was known</div>
	 *            <div class="de">Datum und Uhrzeit, an dem das Resultat bekannt
	 *            wurde.</div> <div class="fr"></div> <div class="it"></div>
	 * @param valueCode
	 *            <div class="de">Wert des Resultats (als Code-Objekt)</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 */
	public LaboratoryObservation(Code code, Organization laboratory, boolean immuneProtection,
			Date dateTimeOfResult, Code valueCode) {
		this(code, immuneProtection, dateTimeOfResult, laboratory);

		this.addValue(valueCode);
	}

	/**
	 * Instantiates a new laboratory observation.
	 *
	 * @param code
	 *            <div class="en">Code for a laboratory observation</div>
	 *            <div class="de">Code für einen bezüglich einer Impfung
	 *            relevanten Laborbefund</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 * @param laboratory
	 *            <div class="en">the performing laboratory</div>
	 *            <div class="de">Das ausführende Labor.</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 * @param immuneProtection
	 *            <div class="en">true, if an immune protection exists</div>
	 *            <div class="de">true, wenn ein Immunschutz besteht.</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 * @param dateTimeOfResult
	 *            <div class="en">date and time, when the result was known</div>
	 *            <div class="de">Datum und Uhrzeit, an dem das Resultat bekannt
	 *            wurde.</div> <div class="fr"></div> <div class="it"></div>
	 * @param value
	 *            <div class="de">Wert des Resultats (als Code-Objekt)</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 */
	public LaboratoryObservation(Code code, Organization laboratory, boolean immuneProtection,
			Date dateTimeOfResult, Value value) {
		this(code, immuneProtection, dateTimeOfResult, laboratory);

		this.addValue(value);
	}

	/**
	 * Instantiates a new laboratory observation.
	 *
	 * @param labObs
	 *            <br>
	 *            <div class="de"> lab obs</div> <div class="fr"> lab obs</div>
	 *            <div class="it"> lab obs</div>
	 */
	public LaboratoryObservation(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation labObs) {
		super(labObs);
		mLaboratoryObservation = labObs;
	}

	/**
	 * Add a comment entry.
	 *
	 * @param commentEntry
	 *            the new comment entry
	 */
	public void addCommentEntry(SectionAnnotationCommentEntry commentEntry) {
		mLaboratoryObservation.addAct(commentEntry.copy());
		// need to add the the Subj and setInversionInd, cannot do this
		// automatically with mdht
		for (final EntryRelationship entryRelationShip : mLaboratoryObservation
				.getEntryRelationships()) {
			if (entryRelationShip.getAct() instanceof Comment) {
				entryRelationShip.setInversionInd(true);
				entryRelationShip.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
			}
		}
	}

	/**
	 * Adds the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void addId(Identificator id) {
		final II ii = CdaChUtil.createUniqueIiFromIdentificator(id);
		mLaboratoryObservation.getIds().add(ii);
	}

	/**
	 * Adds a performer
	 *
	 * @param performer
	 *            the performer
	 * @param dateTimeOfResult
	 *            <div class="en">date and time, when the result was known</div>
	 *            <div class="de">Datum und Uhrzeit, an dem das Resultat bekannt
	 *            wurde.</div> <div class="fr"></div> <div class="it"></div>
	 */
	@Override
	public void addPerformer(Performer performer, Date dateTimeOfResult) {
		final Performer2 mPerformer = performer.copyMdhtPerfomer();
		mPerformer.setTypeCode(ParticipationPhysicalPerformer.PRF);
		mLaboratoryObservation.getPerformers().add(mPerformer);
	}

	/**
	 * Sets the value as code.
	 *
	 * @param code
	 *            the new value
	 */
	public void addValue(Code code) {
		mLaboratoryObservation.getValues().add(code.getCD());
	}

	/**
	 * Adds the value.
	 *
	 * @param value
	 *            the new value
	 */
	@Override
	public void addValue(Value value) {
		if (value.isPhysicalQuantity()) {
			mLaboratoryObservation.getValues().add(value.copyMdhtPhysicalQuantity());
		}
		if (value.isCode()) {
			mLaboratoryObservation.getValues().add(value.copyMdhtCode());
		}
		if (value.isRto()) {
			mLaboratoryObservation.getValues().add(value.copyMdhtRto());
		}
	}

	/**
	 * <div class="de">Copy mdht laboratory observation.</div>
	 * <div class="fr">Copy mdht laboratory observation.</div>
	 * <div class="it">Copy mdht laboratory observation.</div>
	 *
	 * @return the org.openhealthtools.mdht.uml.cda.ch. laboratory observation
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation copyMdhtLaboratoryObservation() {
		return EcoreUtil.copy(mLaboratoryObservation);
	}

	/**
	 * <div class="en">Gets the code of the observation</div>
	 * <div class="de">Gibt den Code der Beobachtung zurück.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @return the code
	 */
	@Override
	public Code getCode() {
		final Code code = new Code(mLaboratoryObservation.getCode());
		return code;
	}

	/**
	 * Gets the reference to the comment in the level 2 section text (when set).
	 *
	 * @return the reference of the level 3 comment entry, which point to the
	 *         level 2 text
	 */
	public String getCommentRef() {
		return Util.getCommentRef(mLaboratoryObservation.getEntryRelationships());
	}

	/**
	 * Gets the text of the comment text element (this is not necessarily the
	 * comment itself)
	 *
	 * @return the comment text
	 */
	@Override
	public String getCommentText() {
		return Util.getCommentText(mLaboratoryObservation.getEntryRelationships());
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
		if (mLaboratoryObservation.getPerformers().size() > 0) {
			return DateUtilMdht.parseIVL_TSVDateTimeValue(
					mLaboratoryObservation.getPerformers().get(0).getTime());
		} else {
			return DateUtilMdht
					.parseIVL_TSVDateTimeValue(mLaboratoryObservation.getEffectiveTime());
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
		if (mLaboratoryObservation.getPerformers().size() > 0) {
			return DateUtilMdht.formatDateTimeCh(DateUtilMdht.parseIVL_TSVDateTimeValue(
					mLaboratoryObservation.getPerformers().get(0).getTime()));
		} else {
			return DateUtilMdht.formatDateTimeCh(DateUtilMdht
					.parseIVL_TSVDateTimeValue(mLaboratoryObservation.getEffectiveTime()));
		}
	}

	/**
	 * Gets the Effective Time
	 *
	 * @return the effective time as date
	 */
	@Override
	public Date getEffectiveTime() {
		return DateUtilMdht.parseIVL_TSVDateTimeValue(mLaboratoryObservation.getEffectiveTime());
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
		for (final II id : mLaboratoryObservation.getIds()) {
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
		return Util.convertIds(mLaboratoryObservation.getIds());
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
		if (mLaboratoryObservation.getPerformers().size() > 0) {
			if (mLaboratoryObservation.getPerformers().get(0).getAssignedEntity() != null) {
				if (mLaboratoryObservation.getPerformers().get(0).getAssignedEntity()
						.getRepresentedOrganizations().size() > 0) {
					return new Organization(mLaboratoryObservation.getPerformers().get(0)
							.getAssignedEntity().getRepresentedOrganizations().get(0));
				}
			}
		}
		return null;
	}

	/**
	 * Gets the mdht laboratory observation.
	 *
	 * @return the mdht laboratory observation
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation getMdhtLaboratoryObservation() {
		return mLaboratoryObservation;
	}

	@Override
	public Object getMdhtObservation() {
		return mLaboratoryObservation;
	}

	/**
	 * Get the (first) problem value. The Value may be a coded or uncoded
	 * String.
	 *
	 * @return the (first) problem value as string.
	 */
	@Override
	public Value getValue() {
		if (!mLaboratoryObservation.getValues().isEmpty()) {
			return new Value(mLaboratoryObservation.getValues().get(0));
		}
		return null;
	}

	/**
	 * Get a list of all problem values. Each Value may be a coded or uncoded
	 * String.
	 *
	 * @return all problem values as ArrayList.
	 */
	@Override
	public List<Value> getValues() {
		final List<Value> vl = new ArrayList<Value>();
		for (final ANY a : mLaboratoryObservation.getValues()) {
			final Value v = new Value(a);
			vl.add(v);
		}
		return vl;
	}

	/**
	 * Sets the code.
	 *
	 * @param code
	 *            the new code
	 */
	public void setCode(Code code) {
		mLaboratoryObservation.setCode(code.getCD());
	}

	/**
	 * Sets a comment text
	 *
	 * @param text
	 *            the text
	 */
	public void setCommentText(String text) {
		final Comment mComment = IHEFactory.eINSTANCE.createComment().init();
		final ED ed = DatatypesFactory.eINSTANCE.createED();
		ed.addText(text);
		mComment.setText(ed);
		mLaboratoryObservation.addAct(mComment);

		final EntryRelationship er = mLaboratoryObservation.getEntryRelationships()
				.get(mLaboratoryObservation.getEntryRelationships().size() - 1);
		er.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
		er.setInversionInd(true);
	}

	/**
	 * Sets the date time of result.
	 *
	 * @param dateTimeOfResult
	 *            the new date time of result
	 */
	@Override
	public void setEffectiveTime(Date dateTimeOfResult) {
		try {
			mLaboratoryObservation
					.setEffectiveTime(DateUtilMdht.createIVL_TSFromEuroDateTime(dateTimeOfResult));
		} catch (final ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sets the interpretation code for immunization.
	 *
	 * @param code
	 *            the new interpretation code
	 */
	public void setInterpretationCode(ObservationInterpretationForImmunization code) {
		mLaboratoryObservation.getInterpretationCodes().clear();
		mLaboratoryObservation.getInterpretationCodes().add(code.getCE());
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
		mLaboratoryObservation.getPerformers().add(perf);
	}

	/**
	 * Sets the reference range <div class="de">(Referenzbereich)</div>.
	 *
	 * @param referenceRange
	 *            the new reference range
	 */
	public void setReferenceRange(ReferenceRange referenceRange) {
		if (referenceRange != null) {
			mLaboratoryObservation.getReferenceRanges().clear();
			mLaboratoryObservation.getReferenceRanges().add(referenceRange.getMdht());
		}
	}

	@Override
	public void setTargetSite(ActSite actSite) {
		if (actSite != null) {
			mLaboratoryObservation.getTargetSiteCodes().clear();
			mLaboratoryObservation.getTargetSiteCodes().add(actSite.getCD());
		}
	}

	@Override
	public void setValue(Value value) {
		mLaboratoryObservation.getValues().clear();
		addValue(value);

	}
}
