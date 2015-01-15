package org.ehc.cda;

import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.SubstanceAdministration;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClass;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentSubstanceMood;

/**
 * Builds a substanceAdministration out of a Treatment class.
 * 
 * @see also Immunization class, where an analog coding is done,
 * but by delegating to the IHE Immunization class.
 * 
 * @author gsc
 */
public class TreatmentBuilder {

	private Treatment treatment;
	
	public TreatmentBuilder(Treatment treatment) {
		this.treatment = treatment;
	}

	/**
	 * Builds the treatment entry.
	 * 
	 * @return
	 */
	public SubstanceAdministration build() {
		SubstanceAdministration substanceAdministration  = CDAFactory.eINSTANCE.createSubstanceAdministration();

		substanceAdministration.setClassCode(ActClass.SBADM);
		substanceAdministration.setMoodCode(x_DocumentSubstanceMood.INT);
		substanceAdministration.setNegationInd(Boolean.FALSE);
		
		substanceAdministration.getTemplateIds().add(ii("2.16.756.5.30.1.1.1.1.1", "CDA-CH.Body.MediL3"));
		substanceAdministration.getTemplateIds().add(ii("2.16.840.1.113883.10.20.1.25"));
		substanceAdministration.getTemplateIds().add(ii("1.3.6.1.4.1.19376.1.5.3.1.4.12.2"));
		
		// TODO add correct GTIN for recommended vaccination
		substanceAdministration.getIds().add(ii("1.3.160", "7680006690012"));
			
		return substanceAdministration;
	}
	
	private II ii(String root, String extension) {
		return DatatypesFactory.eINSTANCE.createII(root, extension);	
	}
	
	private II ii(String root) {
		return DatatypesFactory.eINSTANCE.createII(root);	
	}	
	
}
