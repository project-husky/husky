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

package org.ehealth_connector.cda.ch.edes;

import java.text.ParseException;
import java.util.Date;

import org.ehealth_connector.cda.AbstractVitalSignObservation;
import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.ehealth_connector.cda.ch.edes.enums.ObservationInterpretationForVitalSign;
import org.ehealth_connector.cda.enums.ActSite;
import org.ehealth_connector.cda.enums.VitalSignCodes;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.LangTexts;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

public class VitalSignObservation extends AbstractVitalSignObservation {

	/**
	 * Instantiates a new vital sign observation.
	 */
	public VitalSignObservation() {
		super(null);
		initMdht();
		setMethodCodeTranslation(null);
	}

	/**
	 * Instantiates a new vital sign observation.
	 *
	 * @param code
	 *            <div class="en">Code for a vital sign observation</div>
	 *            <div class="de">Code für ein Vitalzeichen</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 * @param effectiveTime
	 *            <div class="en">clinically or operationally relevant
	 *            time</div> <div class="de">klinisch relevantes Datum und
	 *            Uhrzeit</div> <div class="fr"></div> <div class="it"></div>
	 * @param interpretation
	 *            <div class="de">Beurteilung des Resultats</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 * @param targetSite
	 *            <div class="de">Anatomische Lage des Resultats</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 * @param value
	 *            <div class="de">Wert des Resultats (als Value-Objekt)</div>
	 *            <div class="fr"></div> <div class="it"></div> xxx
	 * @param targetSiteLangTexts
	 *            the langTexts for the Value
	 */
	public VitalSignObservation(Code code, Date effectiveTime,
			ObservationInterpretationForVitalSign interpretation, ActSite targetSite, Value value,
			LangTexts valueLangTexts, LangTexts targetSiteLangTexts) {
		super(null);
		initMdht();

		setCode(code);
		setEffectiveTime(effectiveTime);
		setInterpretationCode(interpretation);
		setTargetSite(targetSite);
		setValue(value);
		super.myValueLangTexts = valueLangTexts;
		super.myTargetSiteLangTexts = targetSiteLangTexts;
		super.setTargetSite(targetSite, targetSiteLangTexts);
	}

	/**
	 * Instantiates a new vital sign observation.
	 *
	 * @param code
	 *            <div class="en">Code for a vital sign observation</div>
	 *            <div class="de">Code für ein Vitalzeichen</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 * @param effectiveTime
	 *            <div class="en">clinically or operationally relevant
	 *            time</div> <div class="de">klinisch relevantes Datum und
	 *            Uhrzeit</div> <div class="fr"></div> <div class="it"></div>
	 * @param value
	 *            <div class="de">Wert des Resultats (als Value-Objekt)</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 */
	public VitalSignObservation(Code code, Date effectiveTime, Value value) {
		this(code, effectiveTime, null, null, value, null, null);
	}

	/**
	 * Instantiates a new vital sign observation.
	 *
	 * @param code
	 *            <div class="en">Code for a vital sign observation</div>
	 *            <div class="de">Code für ein Vitalzeichen</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 * @param effectiveTime
	 *            <div class="en">clinically or operationally relevant
	 *            time</div> <div class="de">klinisch relevantes Datum und
	 *            Uhrzeit</div> <div class="fr"></div> <div class="it"></div>
	 * @param value
	 *            <div class="de">Wert des Resultats (als Value-Objekt)</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 * @param valueLangTexts
	 *            the langTexts for the Value
	 */
	public VitalSignObservation(Code code, Date effectiveTime, Value value,
			LangTexts valueLangTexts) {
		this(code, effectiveTime, null, null, value, valueLangTexts, null);
	}

	/**
	 * Instantiates a new vital sign observation.
	 *
	 * @param observation
	 *            <div class="en">Existing vital sign observation</div>
	 *            <div class="de">Existierende vital sign observation</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 */
	public VitalSignObservation(
			org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation observation) {
		super(null);
		setVitalSignObservation(observation);
	}

	/**
	 * Instantiates a new vital sign observation.
	 *
	 * @param code
	 *            <div class="en">Code for a vital sign observation</div>
	 *            <div class="de">Code für ein Vitalzeichen</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 * @param effectiveTime
	 *            <div class="en">clinically or operationally relevant
	 *            time</div> <div class="de">klinisch relevantes Datum und
	 *            Uhrzeit</div> <div class="fr"></div> <div class="it"></div>
	 * @param interpretation
	 *            <div class="de">Beurteilung des Resultats</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 * @param targetSite
	 *            <div class="de">Anatomische Lage des Resultats</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 * @param value
	 *            <div class="de">Wert des Resultats (als Value-Objekt)</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 */
	public VitalSignObservation(VitalSignCodes code, Date effectiveTime,
			ObservationInterpretationForVitalSign interpretation, ActSite targetSite, Value value) {
		this(code.getCode(), effectiveTime, interpretation, targetSite, value, code.getLangTexts(),
				targetSite.getLangTexts());
	}

	/**
	 * Instantiates a new vital sign observation.
	 *
	 * @param code
	 *            <div class="en">Code for a vital sign observation</div>
	 *            <div class="de">Code für ein Vitalzeichen</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 * @param effectiveTime
	 *            <div class="en">clinically or operationally relevant
	 *            time</div> <div class="de">klinisch relevantes Datum und
	 *            Uhrzeit</div> <div class="fr"></div> <div class="it"></div>
	 * @param value
	 *            <div class="de">Wert des Resultats (als Value-Objekt)</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 */
	public VitalSignObservation(VitalSignCodes code, Date effectiveTime, Value value) {
		this(code.getCode(), effectiveTime, value, code.getLangTexts());
	}

	/**
	 * Adds the comment entry.
	 *
	 * @param entry
	 *            the entry
	 */
	@Override
	public void addCommentEntry(SectionAnnotationCommentEntry entry) {
		getVitalSignObservation().addAct(entry.getMdht());
		final int nb = getVitalSignObservation().getEntryRelationships().size() - 1;
		getVitalSignObservation().getEntryRelationships().get(nb)
				.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
		getVitalSignObservation().getEntryRelationships().get(nb).setInversionInd(true);
	}

	/**
	 * Gets the Effective Time
	 *
	 * @return the effective time as date
	 */
	@Override
	public Date getEffectiveTime() {
		return DateUtil.parseIVL_TSVDateTimeValue(getVitalSignObservation().getEffectiveTime());
	}

	@Override
	protected void initMdht() {
		super.initMdht();
		final Identificator id = new Identificator(AbstractCdaCh.OID_V1, "CDA-CH.Body.VitalSignL3");
		getVitalSignObservation().getTemplateIds().add(id.getIi());
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
			getVitalSignObservation()
					.setEffectiveTime(DateUtil.createIVL_TSFromEuroDateTime(dateTimeOfResult));
		} catch (final ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Set a new interpretations of the vital sign observation.
	 *
	 * @param code
	 *            <div class="de">Beurteilung des Resultats</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 */
	public void setInterpretationCode(ObservationInterpretationForVitalSign code) {
		if (code != null) {
			getVitalSignObservation().getInterpretationCodes().clear();
			getVitalSignObservation().getInterpretationCodes().add(code.getCE());
		}
	}

	/**
	 * Sets the method code translation (code with NullFlavor.Na and the given
	 * translation)
	 *
	 * @param translation
	 *            the new method code translation
	 */
	@Override
	public void setMethodCodeTranslation(Code translation) {
		getVitalSignObservation().getMethodCodes().clear();
		final CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setNullFlavor(NullFlavor.NA);
		if (translation != null) {
			ce.getTranslations().add(translation.getCE());
		}
		getVitalSignObservation().getMethodCodes().add(ce);
	}

}
