package org.ehealth_connector.cda.ch.lab.lrtp;

import org.ehealth_connector.cda.AbstractVitalSignObservation;
import org.ehealth_connector.cda.ch.edes.enums.ObservationInterpretationVitalSign;
import org.ehealth_connector.cda.ch.lab.lrtp.enums.VitalSignList;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Value;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

public class VitalSignsObservation extends AbstractVitalSignObservation {

	public VitalSignsObservation() {
		initMdht();
		setMethodCodeTranslation(null);
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

	/**
	 * Instantiates the class with the required elements
	 *
	 * @param code
	 *          the code according to Lrtp specification chap. 5.6.5
	 * @param value
	 *          the value according to [IHE PCC TF-2] 6.3.4.22.3
	 */
	public VitalSignsObservation(VitalSignList code, Value value) {
		this();
		setCode(code);
		setValue(value);
		super.mVitalSignObservation.getInterpretationCodes().clear();
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

	public Code getMethodCodeTranslation() {
		if (!mVitalSignObservation.getMethodCodes().isEmpty()
				&& !mVitalSignObservation.getMethodCodes().get(0).getTranslations().isEmpty()) {
			return new Code(mVitalSignObservation.getMethodCodes().get(0).getTranslations().get(0));
		}
		return null;
	}

	public ObservationInterpretationVitalSign getObservationInterpretationCodeEnum() {
		if (!mVitalSignObservation.getInterpretationCodes().isEmpty()) {
			return ObservationInterpretationVitalSign
					.getEnum(mVitalSignObservation.getInterpretationCodes().get(0).getCode());
		}
		return null;
	}

	@Override
	protected void initMdht() {
		super.initMdht();
		Identificator id = new Identificator("2.16.756.5.30.1.1.1.1.3.4.1",
				"CDA-CH-LRTP.Body.VitalSignL3");
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

	public void setMethodCodeTranslation(Code translation) {
		mVitalSignObservation.getMethodCodes().clear();
		CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setNullFlavor(NullFlavor.NA);
		if (translation != null) {
			ce.getTranslations().add(translation.getCE());
		}
		mVitalSignObservation.getMethodCodes().add(ce);
	}
}
