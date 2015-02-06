package org.ehc.cda;

import org.ehc.cda.ch.enums.StatusCode;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVXB_TS;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClassObservation;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActClassDocumentEntryAct;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActMoodDocumentObservation;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentActMood;

/**
 * Builder for one problem concern entry.
 * 
 * @author gsc
 */
public class PastIllnessBuilder {

	private Disease disease;
	
	/**
	 * Constructor.
	 * @param disease
	 */
	public PastIllnessBuilder(Disease disease) {
		this.disease = disease;
	}
	
	/**
	 * @return ProblemConcernEntry
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry build() {
		org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry entry = IHEFactory.eINSTANCE.createProblemConcernEntry();

		entry.setClassCode(x_ActClassDocumentEntryAct.ACT); // make it XML schema compliant...
		entry.setMoodCode(x_DocumentActMood.EVN);
		
		// TODO define OID constant
		entry.getTemplateIds().add(ii("2.16.840.1.113883.10.20.1.27"));
		entry.getTemplateIds().add(ii("1.3.6.1.4.1.19376.1.5.3.1.4.5.1"));
		entry.getTemplateIds().add(ii("1.3.6.1.4.1.19376.1.5.3.1.4.5.2"));
		
		entry.getIds().add(ii("2.16.756.5.30.1.1.1.1.3.1.1", "497E45CF-E8EA-4CCE-90A6-8249C06809EB"));
		
		entry.setCode(createCodeNullFlavor());
		entry.setText(DatatypesFactory.eINSTANCE.createED());
		entry.setStatusCode(StatusCode.COMPLETED.getCS());
		
		entry.setEffectiveTime(createUnknownLowHighTime());
		
		entry.addObservation(createProblemEntry(disease));

		entry.getEntryRelationships().get(0).setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
		entry.getEntryRelationships().get(0).setInversionInd(Boolean.FALSE);

		return entry;
	}
	
	private org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry createProblemEntry(Disease disease) {
		org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry entry = IHEFactory.eINSTANCE.createProblemEntry();
		entry.setClassCode(ActClassObservation.OBS);
		entry.setMoodCode(x_ActMoodDocumentObservation.EVN);
		
		entry.getTemplateIds().add(ii("1.3.6.1.4.1.19376.1.5.3.1.4.5"));
		entry.getTemplateIds().add(ii("2.16.840.1.113883.10.20.1.28"));
		entry.getTemplateIds().add(ii("2.16.840.1.113883.10.20.1.54"));
		
		entry.getIds().add(ii("2.16.756.5.30.1.1.1.1.3.1.1", "B3DC860A-D59C-42E2-9527-BE21A0D0334F"));
		
		entry.setCode(createCode(disease));
		entry.setText(createProblemEntryText());
		entry.setStatusCode(StatusCode.COMPLETED.getCS());
		entry.setEffectiveTime(createUnknownLowHighTimeNullFlavor());
		entry.getValues().add(createCode(disease));
		return entry;
	}

	private ED createProblemEntryText() {
		return DatatypesFactory.eINSTANCE.createED();
	}

	private IVL_TS createUnknownLowHighTimeNullFlavor() {
		IVL_TS effectiveTime = DatatypesFactory.eINSTANCE.createIVL_TS();
		effectiveTime.setLow(createNullFlavorUnknown());
		effectiveTime.setHigh(createNullFlavorUnknown());
		return effectiveTime;
	}
	
	private IVXB_TS createNullFlavorUnknown() {
		IVXB_TS ts = DatatypesFactory.eINSTANCE.createIVXB_TS();
		ts.setNullFlavor(NullFlavor.UNK);
		return ts;
	}	
	
	private CD createCode(Disease disease) {
		CD code = DatatypesFactory.eINSTANCE.createCD();
		code.setCode(disease.getSnomedCode());
		code.setCodeSystem("2.16.840.1.113883.6.96");
		code.setCodeSystemName("SNOMED CT");
		code.setDisplayName(disease.name());
		return code;
	}	
	
	private II ii(String root) {
		II ii = DatatypesFactory.eINSTANCE.createII();
		ii.setRoot(root);
		return ii;
	}
	
	private II ii(String root, String extension) {
		II ii = ii(root);
		ii.setExtension(extension);
		return ii;
	}
	
	private CD createCodeNullFlavor() {
		CD code = DatatypesFactory.eINSTANCE.createCD();
		code.setNullFlavor(NullFlavor.NA);
		return code;
	}
	
	private IVL_TS createUnknownLowHighTime() {
		IVL_TS effectiveTime = DatatypesFactory.eINSTANCE.createIVL_TS();
		effectiveTime.setLow(DatatypesFactory.eINSTANCE.createIVXB_TS());
		effectiveTime.setHigh(DatatypesFactory.eINSTANCE.createIVXB_TS());
		return effectiveTime;
	}	
	
}
