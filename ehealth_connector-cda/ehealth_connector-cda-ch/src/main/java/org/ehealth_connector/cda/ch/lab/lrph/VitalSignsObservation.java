package org.ehealth_connector.cda.ch.lab.lrph;

import org.ehealth_connector.cda.AbstractVitalSignObservation;
import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.ehealth_connector.cda.ch.edes.enums.ObservationInterpretationVitalSign;
import org.ehealth_connector.cda.ch.lab.lrtp.enums.VitalSignList;
import org.ehealth_connector.common.Identificator;

public class VitalSignsObservation extends AbstractVitalSignObservation {

	public VitalSignsObservation() {
		initMdht();
	}

	/**
	 * Instantiates a new vital sign observation.
	 *
	 * @param observation
	 *          <div class="en">Existing vital sign observation</div>
	 *          <div class="de">Existierende vital sign observation</div>
	 *          <div class="fr"></div> <div class="it"></div>
	 */
	public VitalSignsObservation(
			org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation observation) {
		mVitalSignObservation = observation;
	}

	// Swiss specific VitalSignObserations
	// Es MUSS ein LOINC Code aus dem Value Set CDA-CH-LRTP vitalSignList
	// verwendet werden (siehe Kapitel 5.6.5 Liste der Vitalzeichen“ auf Seite 52)
	public VitalSignList getCodeEnum() {
		if (getCode() != null) {
			return VitalSignList.getEnum(getCode().getCode());
		}
		return null;
	}

	@Override
	protected void initMdht() {
		super.initMdht();
		Identificator id = new Identificator(AbstractCdaCh.OID_V1, "CDA-CH.Body.VitalSignL3");
		mVitalSignObservation.getTemplateIds().add(id.getIi());
	}

	public void setCode(VitalSignList code) {
		setCode(code.getCode());
	}

	/**
	 * Set a new interpretations of the vital sign observation.
	 *
	 * @param code
	 *          <div class="de">Beurteilung des Resultats</div>
	 *          <div class="fr"></div> <div class="it"></div>
	 */
	public void setInterpretationCode(ObservationInterpretationVitalSign code) {
		if (code != null) {
			mVitalSignObservation.getInterpretationCodes().clear();
			mVitalSignObservation.getInterpretationCodes().add(code.getCE());
		}
	}
}
