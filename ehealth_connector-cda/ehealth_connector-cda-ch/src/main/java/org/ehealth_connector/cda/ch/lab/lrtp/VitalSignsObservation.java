package org.ehealth_connector.cda.ch.lab.lrtp;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.AbstractVitalSignObservation;
import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.ch.edes.enums.ObservationInterpretationForVitalSign;
import org.ehealth_connector.cda.ch.lab.lrtp.enums.VitalSignList;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Value;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.ihe.Comment;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

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

	public void addCommentEntry(SectionAnnotationCommentEntry entry) {
		mVitalSignObservation.addAct(entry.getMdht());
		int nb = mVitalSignObservation.getEntryRelationships().size() - 1;
		mVitalSignObservation.getEntryRelationships().get(nb)
				.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
		mVitalSignObservation.getEntryRelationships().get(nb).setInversionInd(true);
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

	public List<SectionAnnotationCommentEntry> getCommentEntries() {
		ArrayList<SectionAnnotationCommentEntry> sacl = new ArrayList<SectionAnnotationCommentEntry>();
		for (EntryRelationship er : mVitalSignObservation.getEntryRelationships()) {
			if (er.getTypeCode().equals(x_ActRelationshipEntryRelationship.SUBJ)
					&& er.getInversionInd().equals(true)) {
				if (er.getAct().getTemplateIds().get(0).getRoot().equals("2.16.840.1.113883.10.20.1.40")
						|| er.getAct().getTemplateIds().get(0).getRoot()
								.equals("1.3.6.1.4.1.19376.1.5.3.1.4.2")) {
					sacl.add(new SectionAnnotationCommentEntry((Comment) er.getAct()));
				}
			}
		}
		return sacl;
	}

	public Code getMethodCodeTranslation() {
		if (!mVitalSignObservation.getMethodCodes().isEmpty()
				&& !mVitalSignObservation.getMethodCodes().get(0).getTranslations().isEmpty()) {
			return new Code(mVitalSignObservation.getMethodCodes().get(0).getTranslations().get(0));
		}
		return null;
	}

	public ObservationInterpretationForVitalSign getObservationInterpretationCodeEnum() {
		if (!mVitalSignObservation.getInterpretationCodes().isEmpty()) {
			return ObservationInterpretationForVitalSign
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
	public void setInterpretationCode(ObservationInterpretationForVitalSign code) {
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
