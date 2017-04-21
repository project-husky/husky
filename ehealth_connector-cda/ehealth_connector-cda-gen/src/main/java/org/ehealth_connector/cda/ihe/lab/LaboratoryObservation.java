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

package org.ehealth_connector.cda.ihe.lab;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.MdhtObservationFacade;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.Performer;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.ObservationInterpretation;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Util;
import org.ehealth_connector.valueset.enums.IdentityDomain;
import org.openhealthtools.mdht.uml.cda.AssignedEntity;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.Performer2;
import org.openhealthtools.mdht.uml.cda.ihe.Comment;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.vocab.ParticipationPhysicalPerformer;
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

	// /**
	// * Instantiates a new laboratory observation.
	// *
	// * @param labObs
	// * <br>
	// * <div class="de"> lab obs</div> <div class="fr"> lab obs</div>
	// * <div class="it"> lab obs</div>
	// */
	// public
	// LaboratoryObservation(org.openhealthtools.mdht.uml.cda.ch.LaboratoryObservation
	// labObs) {
	// mLaboratoryObservation = labObs;
	// }

	/**
	 * Adds the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void addId(Identificator id) {
		// final II ii = CdaChUtil.createUuidVacdIdentificator(id);
		// mLaboratoryObservation.getIds().add(ii);
	}

	/**
	 * Adds the interpretation code.
	 *
	 * @param code
	 *            the new interpretation code
	 */
	public void addInterpretationCode(Code code) {
		getMdht().getInterpretationCodes().add(code.getCE());
	}

	/**
	 * Adds the interpretation code.
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
	 * @param dateTimeOfResult
	 *            <div class="en">date and time, when the result was known</div>
	 *            <div class="de">Datum und Uhrzeit, an dem das Resultat bekannt
	 *            wurde.</div> <div class="fr"></div> <div class="it"></div>
	 */
	public void addPerformer(Performer performer, Date dateTimeOfResult) {
		final Performer2 mPerformer = performer.copyMdhtPerfomer();
		mPerformer.setTypeCode(ParticipationPhysicalPerformer.PRF);
		try {
			mPerformer.setTime(DateUtil.createIVL_TSFromEuroDate(dateTimeOfResult));
		} catch (final ParseException e) {
			e.printStackTrace();
		}
		getMdht().getPerformers().add(mPerformer);
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
	 * Adds the value.
	 *
	 * @param value
	 *            the new value
	 */
	@Override
	public void addValue(Value value) {
		getMdht().getValues().add(value.getValue());
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

	// /**
	// * Gets the text of the comment text element (this is not necessarily the
	// * comment itself)
	// *
	// * @return the comment text
	// */
	// public String getCommentText() {
	// return Util.getCommentText(getMdht().getEntryRelationships());
	// }

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
			return DateUtil.parseIVL_TSVDateTimeValue(getMdht().getPerformers().get(0).getTime());
		} else {
			return DateUtil.parseIVL_TSVDateTimeValue(getMdht().getEffectiveTime());
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
			return DateUtil.formatDateTimeCh(
					DateUtil.parseIVL_TSVDateTimeValue(getMdht().getPerformers().get(0).getTime()));
		} else {
			return DateUtil.formatDateTimeCh(
					DateUtil.parseIVL_TSVDateTimeValue(getMdht().getEffectiveTime()));
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
	 * <div class="en">Gets interpretation code values, which indicates wheater
	 * an immune protection exists (Interpretation Code)</div>
	 * <div class="de">Gibt zurück, ob ein Impfschutz besteht (erster
	 * Interpretation Code).</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return the interpretation code
	 */
	public List<Code> getInterpretationCodes() {
		final List<Code> icl = new ArrayList<Code>();
		for (final CE ic : getMdht().getInterpretationCodes()) {
			icl.add(new Code(ic));
		}
		return icl;
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
	public List<Performer> getPerformerList() {
		final List<Performer> list = new ArrayList<Performer>();
		for (final Performer2 mdht : getMdht().getPerformers()) {
			final Performer eHC = new Performer(mdht);
			list.add(eHC);
		}
		return list;
	}

	/**
	 * Adds the code.
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
			perf.setTime(DateUtil.createIVL_TSFromEuroDateTime(dateTimeOfResult));
		} catch (final ParseException e) {
			e.printStackTrace();
		}
		getMdht().getPerformers().add(perf);
	}
}
