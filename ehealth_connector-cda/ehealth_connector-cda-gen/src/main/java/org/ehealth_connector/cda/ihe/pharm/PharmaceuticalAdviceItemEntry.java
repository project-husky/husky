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
 * Year of publication: 2015
 *
 *******************************************************************************/
package org.ehealth_connector.cda.ihe.pharm;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.ExternalDocumentEntry;
import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.cda.ihe.pharm.enums.MedicationsSpecialConditions;
import org.ehealth_connector.cda.ihe.pharm.enums.PharmaceuticalAdviceStatusList;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.Precondition;
import org.openhealthtools.mdht.uml.cda.Reference;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.ExternalDocumentRef;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/**
 * Implements the Base Class PharmaceuticalAdviceItemEntry from the IHE PHARM Model
 *
 */
public class PharmaceuticalAdviceItemEntry extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmaceuticalAdviceItemEntry> {

	/**
	 * Instantiates a new prescription item entry.
	 *
	 * @param languageCode the language code
	 */
	public PharmaceuticalAdviceItemEntry(LanguageCode languageCode) {
		super(PHARMFactory.eINSTANCE.createPharmaceuticalAdviceItemEntry().init());
		final CS statusCodeCompleted = DatatypesFactory.eINSTANCE.createCS();
		statusCodeCompleted.setCode("completed");
		this.getMdht().setStatusCode(statusCodeCompleted);		
	}

	/**
	 * Instantiates a new dipsen item entry.
	 */
	public PharmaceuticalAdviceItemEntry() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new facade for the provided mdht object.
	 * 
	 * @param mdht
	 *            the mdht model object
	 */
	protected PharmaceuticalAdviceItemEntry(org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmaceuticalAdviceItemEntry mdht) {
		super(mdht, null, null);
	}
	
	public void setStatusCodeActive() {
		final CS statusCodeCompleted = DatatypesFactory.eINSTANCE.createCS();
		statusCodeCompleted.setCode("active");
		this.getMdht().setStatusCode(statusCodeCompleted);		
	}

	/**
	 * Adds the precondition entry.
	 *
	 * @param entry the entry
	 */
	public void addPreconditionEntry(CriterionEntry entry) {
		Precondition precondition = CDAFactory.eINSTANCE.createPrecondition();
		precondition.setCriterion(entry.getMdht());
		getMdht().getPreconditions().add(precondition);
	}

	/**
	 * Gets the external document entry.
	 *
	 * @return the external document entry
	 */
	public ExternalDocumentEntry getExternalDocumentEntry() {
		if (getMdht().getReferences().size() > 0) {
			final Reference reference = this.getMdht().getReferences().get(0);
			return new ExternalDocumentEntry(reference.getExternalDocument());
		}
		return null;
	}

	/**
	 * Gets the first .
	 *
	 * @return the id
	 */
	public Identificator getId() {
		Identificator id = null;
		if ((getMdht().getIds() != null) && (getMdht().getIds().size() > 0)) {
			id = new Identificator(getMdht().getIds().get(0));
		}
		return id;
	}

	/**
	 * Gets the pharmaceutical advice status list.
	 *
	 * @return the pharmaceutical advice status list
	 */
	public PharmaceuticalAdviceStatusList getPharmaceuticalAdviceStatusList() {
		if (this.getMdht().getCode()!=null) {
			final Code code = new Code(this.getMdht().getCode());
			if ((code != null)
					&& PharmaceuticalAdviceStatusList.CODE_SYSTEM_OID.equals(code.getCodeSystem())) {
				return PharmaceuticalAdviceStatusList.getEnum(code.getCode());
			}
		}
		return null;
	}

	/**
	 * Gets the precondition entries.
	 *
	 * @return the precondition entries
	 */
	public List<CriterionEntry> getPreconditionEntries() {
		final List<CriterionEntry> preconditionEntries = new ArrayList<CriterionEntry>();
		for (Precondition precondition : getMdht().getPreconditions()) {
			preconditionEntries.add(new CriterionEntry(precondition.getCriterion()));
		}
		return preconditionEntries;
	}

	/**
	 * Gets the text reference.
	 * 
	 * @return the text reference
	 */
	@Override
	public String getTextReference() {
		if ((this.getMdht().getText() != null)
				&& (this.getMdht().getText().getReference() != null)) {
			return this.getMdht().getText().getReference().getValue();
		}
		return null;
	}

	/**
	 * Sets the external document entry.
	 *
	 * @param externalDocumentEntry
	 *            the new external document entry
	 */
	public void setExternalDocumentEntry(ExternalDocumentEntry externalDocumentEntry) {
		// note PCC Template only for REFR not for XCRPT
		ExternalDocumentRef reference = PHARMFactory.eINSTANCE.createExternalDocumentRef().init();
		reference.getTemplateIds().clear();
		externalDocumentEntry.getMdht().getTemplateIds().clear(); 
		reference.setExternalDocument(externalDocumentEntry.getMdht());
		getMdht().getReferences().clear();
		getMdht().getReferences().add(reference);
	}

	/**
	 * Sets the identificator. Note: replaces all existing identifiers
	 *
	 * @param id
	 *            the new identificator
	 */
	public void setId(Identificator id) {
		this.getMdht().getIds().clear();
		if (id != null) {
			this.getMdht().getIds().add(id.getIi());
		}
	}


	/**
	 * Sets the medications special conditions.
	 *
	 * @param code
	 *            the code
	 */
	public void setPharmaceuticalAdviceStatus(PharmaceuticalAdviceStatusList code) {
		if (code != null) {
			this.getMdht().setCode(code.getCode().getCD());
		}
	}

	/**
	 * Sets the text reference.
	 *
	 * @param value
	 *            the new text reference
	 */
	@Override
	public void setTextReference(String value) {
		this.getMdht().setText(Util.createReference(value));
	}
	
	public void setPharmaceuticalAdviceStatus(Code code) {
		this.getMdht().setCode(code.getCD());
	}
	
	public Code getPharmaceuticalAdviceStatus() {
		if (this.getMdht().getCode()!=null) {
			return new Code(this.getMdht().getCode());
		}
		return null;
	}

}
