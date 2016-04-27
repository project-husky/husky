/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2016
 *
 *******************************************************************************/

package org.ehealth_connector.cda.ch.edes;

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
	 * @param langTexts
	 *            the langTexts for the Value
	 */
	public VitalSignObservation(Code code, Date effectiveTime,
			ObservationInterpretationForVitalSign interpretation, ActSite targetSite, Value value,
			LangTexts valueLangTexts, LangTexts targetSiteLangTexts) {
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
	 * @param langTexts
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
	public void addCommentEntry(SectionAnnotationCommentEntry entry) {
		getVitalSignObservation().addAct(entry.getMdht());
		final int nb = getVitalSignObservation().getEntryRelationships().size() - 1;
		getVitalSignObservation().getEntryRelationships().get(nb)
				.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
		getVitalSignObservation().getEntryRelationships().get(nb).setInversionInd(true);
	}

	@Override
	protected void initMdht() {
		super.initMdht();
		final Identificator id = new Identificator(AbstractCdaCh.OID_V1, "CDA-CH.Body.VitalSignL3");
		getVitalSignObservation().getTemplateIds().add(id.getIi());
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
