package org.ehealth_connector.cda;

import java.text.ParseException;
import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.enums.CodeSystems;
import org.ehealth_connector.cda.ch.enums.ObservationInterpretation;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.Value;
import org.openhealthtools.mdht.uml.cda.AssignedEntity;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.Performer2;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.vocab.ParticipationPhysicalPerformer;

public class LaboratoryObservation {
	org.openhealthtools.mdht.uml.cda.ch.LaboratoryObservation mLaboratoryObservation;

	public LaboratoryObservation() {
		mLaboratoryObservation = CHFactory.eINSTANCE.createLaboratoryObservation().init();
	}

	public LaboratoryObservation(org.ehealth_connector.cda.ch.enums.Serologie code, boolean immuneProtection, Date dateTimeOfResult, Organization laboratory) {
		mLaboratoryObservation = CHFactory.eINSTANCE.createLaboratoryObservation().init();

		setCode(code.getCode());
		setImmuneProtection(immuneProtection);
		setDateTimeOfResult(dateTimeOfResult);
		setLaboratory(laboratory, dateTimeOfResult);
	}

	public LaboratoryObservation(org.ehealth_connector.cda.ch.enums.Serologie code, Organization laboratory, boolean immuneProtection, Date dateTimeOfResult, Code valueCode) {
		this(code, immuneProtection, dateTimeOfResult, laboratory);

		this.setValue(valueCode);
	}

	//TODO Create Constructor for unknown Types of "Erregernachweise"

	public LaboratoryObservation(org.ehealth_connector.cda.ch.enums.Serologie code, Organization laboratory, boolean immuneProtection, Date dateTimeOfResult, Value value) {
		this(code, immuneProtection, dateTimeOfResult, laboratory);

		this.setValue(value);
	}

	public LaboratoryObservation(org.openhealthtools.mdht.uml.cda.ch.LaboratoryObservation labObs) {
		mLaboratoryObservation = labObs;
	}

	public org.openhealthtools.mdht.uml.cda.ch.LaboratoryObservation copyMdhtLaboratoryObservation() {
		return EcoreUtil.copy(mLaboratoryObservation);
	}

	public Code getCode() {
		Code code = new Code(mLaboratoryObservation.getCode());
		return code;
	}

	public Date getDateTimeOfResult() {
		if (mLaboratoryObservation.getPerformers().size()>0) {
			return DateUtil.parseIVL_TSVDateTimeValue(mLaboratoryObservation.getPerformers().get(0).getTime());
		}
		else {
			return DateUtil.parseIVL_TSVDateTimeValue(mLaboratoryObservation.getEffectiveTime());
		}
	}

	public boolean getImmuneProtection() {
		if (mLaboratoryObservation.getInterpretationCodes().get(0).equals(ObservationInterpretation.NEGATIVE_PATHOGEN_COULDNT_BE_DETERMINED_IN_SPECI_MEN.getCode())) {
			return true;
		}
		else {
			return false;
		}
	}

	public String getInterpretationCode() {
		return mLaboratoryObservation.getInterpretationCodes().get(0).getCode();
	}

	public Organization getLaboratory() {
		if (mLaboratoryObservation.getPerformers().size()>0) {
			if (mLaboratoryObservation.getPerformers().get(0).getAssignedEntity() != null) {
				if (mLaboratoryObservation.getPerformers().get(0).getAssignedEntity().getRepresentedOrganizations().size()>0) {
					return new Organization(mLaboratoryObservation.getPerformers().get(0).getAssignedEntity().getRepresentedOrganizations().get(0));
				}
			}
		}
		return null;
	}

	public org.openhealthtools.mdht.uml.cda.ch.LaboratoryObservation getMdhtOLaboratoryObservation() {
		return mLaboratoryObservation;
	}

	public void setCode(Code code) {
		mLaboratoryObservation.setCode(code.getCD());
	}

	public void setDateTimeOfResult(Date dateTimeOfResult) {
		try {
			mLaboratoryObservation.setEffectiveTime(DateUtil.createIVL_TSFromEuroDateTime(dateTimeOfResult));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setImmuneProtection(boolean immuneProtection) {
		if (immuneProtection == true) {
			mLaboratoryObservation.getInterpretationCodes().add(ObservationInterpretation.NEGATIVE_PATHOGEN_COULDNT_BE_DETERMINED_IN_SPECI_MEN.getCE());
		}
		else {
			mLaboratoryObservation.getInterpretationCodes().add(ObservationInterpretation.POSITIVE_PATHOGEN_FOUND_IN_SPECIMEN.getCE());
		}
	}

	public void setInterpretationCode(ObservationInterpretation code) {
		mLaboratoryObservation.getInterpretationCodes().add(code.getCE());
	}

	public void setLaboratory(Organization laboratory, Date dateTimeOfResult) {
		Performer2 perf = CDAFactory.eINSTANCE.createPerformer2();
		AssignedEntity asEnt = CDAFactory.eINSTANCE.createAssignedEntity();

		II ii = DatatypesFactory.eINSTANCE.createII(CodeSystems.GLN.getCodeSystemId(), laboratory.getId());
		asEnt.getIds().add(ii);

		asEnt.getRepresentedOrganizations().add(laboratory.copyMdhtOrganization());
		perf.setAssignedEntity(asEnt);
		perf.setTypeCode(ParticipationPhysicalPerformer.PRF);
		try {
			perf.setTime(DateUtil.createIVL_TSFromEuroDateTime(dateTimeOfResult));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mLaboratoryObservation.getPerformers().add(perf);
	}

	public void setValue(Code code) {
		mLaboratoryObservation.getValues().add(code.getCD());
	}

	public void setValue(Value value) {
		if (value.isPhysicalQuantity()) {
			mLaboratoryObservation.getValues().add(value.copyMdhtPhysicalQuantity());
		}
		if (value.isCode()) {
			mLaboratoryObservation.getValues().add(value.copyMdhtCode());
		}
	}
}
