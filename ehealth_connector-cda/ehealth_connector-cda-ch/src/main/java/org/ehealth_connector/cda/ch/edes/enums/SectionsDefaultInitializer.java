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

package org.ehealth_connector.cda.ch.edes.enums;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.Consumable;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.ManufacturedProduct;
import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.cda.Procedure;
import org.openhealthtools.mdht.uml.cda.SubstanceAdministration;
import org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection;
import org.openhealthtools.mdht.uml.cda.ihe.AllergiesReactionsSection;
import org.openhealthtools.mdht.uml.cda.ihe.ImmunizationsSection;
import org.openhealthtools.mdht.uml.cda.ihe.MedicationsSection;
import org.openhealthtools.mdht.uml.cda.ihe.ProceduresAndInterventionsSection;
import org.openhealthtools.mdht.uml.cda.ihe.pcc.AcuityAssessmentSection;
import org.openhealthtools.mdht.uml.cda.ihe.pcc.EDDiagnosesSection;
import org.openhealthtools.mdht.uml.cda.ihe.pcc.EDDispositionSection;
import org.openhealthtools.mdht.uml.cda.ihe.pcc.ModeOfArrivalSection;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVXB_TS;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClass;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClassObservation;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActClassDocumentEntryAct;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActMoodDocumentObservation;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentActMood;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentProcedureMood;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentSubstanceMood;

/**
 * Initialize sections with default HL7 level 3 data.
 *
 */
public class SectionsDefaultInitializer {

	private CS getCS(String code) {
		CS cs = DatatypesFactory.eINSTANCE.createCS();
		cs.setCode(code);
		return cs;
	}

	private CD getNullFlavorCd() {
		CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setNullFlavor(NullFlavor.NA);
		return cd;
	}

	private CE getNullFlavorCe() {
		CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setNullFlavor(NullFlavor.NA);
		return ce;
	}

	private II getNullFlavorIi() {
		return DatatypesFactory.eINSTANCE.createII(NullFlavor.NA);
	}

	private IVL_PQ getNullFlavorIVL_PQ() {
		IVL_PQ ivl = DatatypesFactory.eINSTANCE.createIVL_PQ();
		ivl.setNullFlavor(NullFlavor.UNK);
		return ivl;
	}

	private IVL_TS getNullFlavorIVL_TS() {
		IVL_TS time = DatatypesFactory.eINSTANCE.createIVL_TS();
		time.setNullFlavor(NullFlavor.UNK);
		return time;
	}

	private IVL_TS getNullFlavorIVL_TSLow() {
		IVL_TS time = DatatypesFactory.eINSTANCE.createIVL_TS();
		IVXB_TS unk = DatatypesFactory.eINSTANCE.createIVXB_TS();
		unk.setNullFlavor(NullFlavor.UNK);
		time.setLow(unk);
		return time;
	}

	private IVL_TS getNullFlavorIVL_TSLowHigh() {
		IVL_TS time = DatatypesFactory.eINSTANCE.createIVL_TS();
		IVXB_TS unk = DatatypesFactory.eINSTANCE.createIVXB_TS();
		unk.setNullFlavor(NullFlavor.UNK);
		time.setHigh(unk);
		unk = DatatypesFactory.eINSTANCE.createIVXB_TS();
		unk.setNullFlavor(NullFlavor.UNK);
		time.setLow(unk);
		return time;
	}

	private ED getTodoText() {
		return Util.createReference("#TODO");
	}

	public ActiveProblemsSection init(ActiveProblemsSection section) {
		Act act = CDAFactory.eINSTANCE.createAct();
		act.setClassCode(x_ActClassDocumentEntryAct.ACT);
		act.setMoodCode(x_DocumentActMood.EVN);
		act.getTemplateIds().add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.5.2", "").getIi());
		act.getTemplateIds().add(new Identificator("2.16.840.1.113883.10.20.1.27", "").getIi());
		act.getTemplateIds().add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.5.1", "").getIi());
		act.setCode(getNullFlavorCd());
		act.setStatusCode(getCS("completed"));
		act.getIds().add(getNullFlavorIi());
		act.setText(getTodoText());
		act.setEffectiveTime(getNullFlavorIVL_TSLowHigh());

		Observation observation = CDAFactory.eINSTANCE.createObservation();
		observation.setClassCode(ActClassObservation.OBS);
		observation.setMoodCode(x_ActMoodDocumentObservation.EVN);
		observation.setNegationInd(false);

		observation.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.5", "").getIi());
		observation.getTemplateIds().add(new Identificator("2.16.840.1.113883.10.20.1.28", "").getIi());

		observation.getIds().add(getNullFlavorIi());
		observation.setCode(getNullFlavorCd());
		observation.setText(getTodoText());
		observation.setStatusCode(getCS("completed"));
		observation.setEffectiveTime(getNullFlavorIVL_TSLow());
		observation.getValues().add(getNullFlavorCd());

		EntryRelationship relationship = CDAFactory.eINSTANCE.createEntryRelationship();
		relationship.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
		relationship.setInversionInd(false);
		relationship.setAct(act);
		relationship.setObservation(observation);

		act.getEntryRelationships().add(relationship);

		section.addAct(act);
		return section;
	}

	public AcuityAssessmentSection init(AcuityAssessmentSection section) {
		Observation observation = CDAFactory.eINSTANCE.createObservation();
		observation.setClassCode(ActClassObservation.OBS);
		observation.setMoodCode(x_ActMoodDocumentObservation.EVN);
		observation.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.1.13.3.1", "").getIi());
		observation.setCode(getNullFlavorCd());
		observation.getIds().add(getNullFlavorIi());
		observation.setText(getTodoText());
		observation.setEffectiveTime(getNullFlavorIVL_TSLowHigh());
		section.addObservation(observation);
		return section;
	}

	public AllergiesReactionsSection init(AllergiesReactionsSection section) {
		Act act = CDAFactory.eINSTANCE.createAct();
		act.setClassCode(x_ActClassDocumentEntryAct.ACT);
		act.setMoodCode(x_DocumentActMood.EVN);

		act.getTemplateIds().add(new Identificator("2.16.840.1.113883.10.20.1.27", "").getIi());
		act.getTemplateIds().add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.5.1", "").getIi());
		act.getTemplateIds().add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.5.3", "").getIi());

		act.getIds().add(getNullFlavorIi());
		act.setCode(getNullFlavorCd());
		act.setStatusCode(getCS("completed"));
		act.setEffectiveTime(getNullFlavorIVL_TSLowHigh());

		Observation observation = CDAFactory.eINSTANCE.createObservation();
		observation.setClassCode(ActClassObservation.OBS);
		observation.setMoodCode(x_ActMoodDocumentObservation.EVN);
		observation.setNegationInd(false);

		observation.getTemplateIds().add(new Identificator("2.16.840.1.113883.10.20.1.28", "").getIi());
		observation.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.5", "").getIi());
		observation.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.6", "").getIi());

		observation.getIds().add(getNullFlavorIi());
		Code code = new Code("2.16.840.1.113883.5.4", "OINT", "ObservationIntoleranceType",
				"intolerance");
		observation.setCode(code.getCD());

		observation.setText(getTodoText());
		observation.setStatusCode(getCS("completed"));
		observation.setEffectiveTime(getNullFlavorIVL_TSLow());
		observation.getValues().add(getNullFlavorCd());

		EntryRelationship relationship = CDAFactory.eINSTANCE.createEntryRelationship();
		relationship.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
		relationship.setInversionInd(false);
		relationship.setAct(act);
		relationship.setObservation(observation);

		act.getEntryRelationships().add(relationship);

		section.addAct(act);
		return section;
	}

	public EDDiagnosesSection init(EDDiagnosesSection section) {
		Observation observation = CDAFactory.eINSTANCE.createObservation();
		observation.setClassCode(ActClassObservation.OBS);
		observation.setMoodCode(x_ActMoodDocumentObservation.EVN);
		observation.setNegationInd(false);
		observation.getTemplateIds().add(new Identificator("2.16.840.1.113883.10.20.1.28", "").getIi());
		observation.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.5", "").getIi());
		observation.setCode(getNullFlavorCd());
		observation.getIds().add(getNullFlavorIi());
		observation.setText(getTodoText());
		observation.setStatusCode(getCS("completed"));
		observation.setEffectiveTime(getNullFlavorIVL_TSLowHigh());
		observation.getValues().add(getNullFlavorCd());
		section.addObservation(observation);
		return section;
	}

	public EDDispositionSection init(EDDispositionSection section) {
		Act act = CDAFactory.eINSTANCE.createAct();
		act.setClassCode(x_ActClassDocumentEntryAct.ACT);
		act.setMoodCode(x_DocumentActMood.INT);
		act.getTemplateIds().add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.1.10.4.2", "").getIi());
		act.setCode(getNullFlavorCd());
		act.getIds().add(getNullFlavorIi());
		act.setText(getTodoText());
		act.setStatusCode(getCS("normal"));
		act.setEffectiveTime(getNullFlavorIVL_TS());
		section.addAct(act);
		return section;
	}

	public ImmunizationsSection init(ImmunizationsSection section) {
		SubstanceAdministration administration = CDAFactory.eINSTANCE.createSubstanceAdministration();
		administration.setClassCode(ActClass.SBADM);
		administration.setMoodCode(x_DocumentSubstanceMood.EVN);
		administration.setNegationInd(false);

		administration.getTemplateIds()
				.add(new Identificator("2.16.756.5.30.1.1.1.1.1", "CDA-CH.Body.MediL3").getIi());
		administration.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7.1", "").getIi());
		administration.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7", "").getIi());
		administration.getTemplateIds()
				.add(new Identificator("2.16.840.1.113883.10.20.1.24", "").getIi());
		administration.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.12", "").getIi());

		administration.getIds().add(getNullFlavorIi());
		Code code = new Code("2.16.840.1.113883.5.4", "IMMUNIZ");
		administration.setCode(code.getCD());
		administration.setText(getTodoText());
		administration.setStatusCode(getCS("completed"));

		administration.setPriorityCode(getNullFlavorCe());
		administration.setRouteCode(getNullFlavorCe());
		administration.setDoseQuantity(getNullFlavorIVL_PQ());
		administration.setRateQuantity(getNullFlavorIVL_PQ());
		administration.getEffectiveTimes().add(getNullFlavorIVL_TS());
		administration.getApproachSiteCodes().add(getNullFlavorCd());

		Consumable consumable = CDAFactory.eINSTANCE.createConsumable();
		ManufacturedProduct product = CDAFactory.eINSTANCE.createManufacturedProduct();
		product.getTemplateIds().add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7.2", "").getIi());
		product.getTemplateIds().add(new Identificator("2.16.840.1.113883.10.20.1.53", "").getIi());
		product.getIds().add(getNullFlavorIi());
		product.setManufacturedMaterial(CDAFactory.eINSTANCE.createMaterial());
		consumable.setManufacturedProduct(product);
		administration.setConsumable(consumable);
		section.addSubstanceAdministration(administration);
		return section;
	}

	public MedicationsSection init(MedicationsSection section) {
		SubstanceAdministration administration = CDAFactory.eINSTANCE.createSubstanceAdministration();
		administration.setClassCode(ActClass.SBADM);
		administration.setMoodCode(x_DocumentSubstanceMood.EVN);

		administration.getTemplateIds()
				.add(new Identificator("2.16.756.5.30.1.1.1.1.1", "CDA-CH.Body.MediL3").getIi());
		administration.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7.1", "").getIi());
		administration.getTemplateIds()
				.add(new Identificator("2.16.840.1.113883.10.20.1.24", "").getIi());
		administration.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7", "").getIi());

		administration.getIds().add(getNullFlavorIi());
		Code code = new Code("2.16.840.1.113883.5.4", "DRUG", "Medikamentöse Therapie");
		administration.setCode(code.getCD());
		administration.setText(getTodoText());
		administration.setStatusCode(getCS("completed"));

		administration.setPriorityCode(getNullFlavorCe());
		administration.setRouteCode(getNullFlavorCe());
		administration.setDoseQuantity(getNullFlavorIVL_PQ());
		administration.setRateQuantity(getNullFlavorIVL_PQ());
		administration.getEffectiveTimes().add(getNullFlavorIVL_TS());

		Consumable consumable = CDAFactory.eINSTANCE.createConsumable();
		ManufacturedProduct product = CDAFactory.eINSTANCE.createManufacturedProduct();
		product.getTemplateIds().add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7.2", "").getIi());
		product.getTemplateIds().add(new Identificator("2.16.840.1.113883.10.20.1.53", "").getIi());
		product.getIds().add(getNullFlavorIi());
		product.setManufacturedMaterial(CDAFactory.eINSTANCE.createMaterial());
		consumable.setManufacturedProduct(product);
		administration.setConsumable(consumable);
		section.addSubstanceAdministration(administration);
		return section;
	}

	public ModeOfArrivalSection init(ModeOfArrivalSection section) {
		Act act = CDAFactory.eINSTANCE.createAct();
		act.setClassCode(x_ActClassDocumentEntryAct.ACT);
		act.setMoodCode(x_DocumentActMood.EVN);
		act.getTemplateIds().add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.1.10.4.1", "").getIi());
		act.setCode(getNullFlavorCd());
		act.getIds().add(getNullFlavorIi());
		act.setText(getTodoText());
		act.setEffectiveTime(getNullFlavorIVL_TSLowHigh());
		section.addAct(act);
		return section;
	}

	public ProceduresAndInterventionsSection init(ProceduresAndInterventionsSection section) {
		Procedure procedure = CDAFactory.eINSTANCE.createProcedure();
		procedure.setClassCode(ActClass.PROC);
		procedure.setMoodCode(x_DocumentProcedureMood.EVN);
		procedure.getTemplateIds().add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.19", "").getIi());
		procedure.getTemplateIds().add(new Identificator("2.16.840.1.113883.10.20.1.29", "").getIi());
		procedure.setCode(getNullFlavorCd());
		procedure.getIds().add(getNullFlavorIi());
		procedure.setText(getTodoText());
		procedure.setStatusCode(getCS("completed"));
		procedure.setPriorityCode(getNullFlavorCe());
		procedure.getApproachSiteCodes().add(getNullFlavorCd());
		procedure.getTargetSiteCodes().add(getNullFlavorCd());
		section.addProcedure(procedure);
		return section;
	}
}
