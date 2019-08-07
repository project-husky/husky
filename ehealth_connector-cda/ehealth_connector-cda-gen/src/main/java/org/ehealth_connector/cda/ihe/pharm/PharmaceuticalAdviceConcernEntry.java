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

package org.ehealth_connector.cda.ihe.pharm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.BaseProblemConcern;
import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.DateUtilMdht;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_TS;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * The Class PharmaceuticalAdviceConcernEntry.
 */
public class PharmaceuticalAdviceConcernEntry extends
		MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmaceuticalAdviceConcernEntry> {

	/**
	 * Instantiates a new criterion entry.
	 */
	public PharmaceuticalAdviceConcernEntry() {
		super(PHARMFactory.eINSTANCE.createPharmaceuticalAdviceConcernEntry().init());
	}

	/**
	 * Instantiates a new criterion entry.
	 *
	 * @param pharmaceuticalAdviceConcernEntry
	 *            the pharmaceutical advice concern entry
	 */
	protected PharmaceuticalAdviceConcernEntry(
			org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmaceuticalAdviceConcernEntry pharmaceuticalAdviceConcernEntry) {
		super(pharmaceuticalAdviceConcernEntry);
	}

	/**
	 * Adds the problem concern entry.
	 *
	 * @param problemConcernEntry
	 *            the problem concern entry
	 */
	public void addProblemConcernEntry(BaseProblemConcern problemConcernEntry) {
		final EntryRelationship entryRelationship = CDAFactory.eINSTANCE.createEntryRelationship();
		entryRelationship.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
		entryRelationship.setInversionInd(Boolean.FALSE);
		entryRelationship.setAct(problemConcernEntry.getMdht());
		this.getMdht().getEntryRelationships().add(entryRelationship);
	}

	/**
	 * Gets the dispense item reference entry.
	 *
	 * @return the dispense item reference entry
	 */
	public DispenseItemReferenceEntry getDispenseItemReferenceEntry() {
		if (getMdht().getDispenseItemReferenceEntry() != null) {
			return new DispenseItemReferenceEntry(getMdht().getDispenseItemReferenceEntry());
		}
		return null;
	}

	/**
	 * Gets the effective time.
	 *
	 * @return the effective time
	 */
	public Date getEffectiveTime() {
		if ((this.getMdht().getEffectiveTime() != null)
				&& (this.getMdht().getEffectiveTime().getLow() != null)) {
			return DateUtil
					.parseDateyyyyMMddHHmmss(this.getMdht().getEffectiveTime().getLow().getValue());
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
	 * Gets the prescription item reference entry.
	 *
	 * @return the prescription item reference entry
	 */
	public PrescriptionItemReferenceEntry getPrescriptionItemReferenceEntry() {
		if (getMdht().getPrescriptionItemReferenceEntry() != null) {
			return new PrescriptionItemReferenceEntry(
					getMdht().getPrescriptionItemReferenceEntry());
		}
		return null;
	}

	/**
	 * Gets the problem concern entries.
	 *
	 * @return the problem concern entries
	 */
	public List<BaseProblemConcern> getProblemConcernEntries() {
		final List<BaseProblemConcern> list = new ArrayList<BaseProblemConcern>();
		if (this.getMdht().getProblemConcernEntriess() != null) {
			for (final org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry problemConcernEntry : getMdht()
					.getProblemConcernEntriess()) {
				list.add(new BaseProblemConcern(problemConcernEntry));
			}
		}
		return list;
	}

	/**
	 * Gets the severity of concern entry.
	 *
	 * @return the severity of concern entry
	 */
	public SeverityOfConcernEntry getSeverityOfConcernEntry() {
		if (getMdht().getSeverityOfConcernEntry() != null) {
			return new SeverityOfConcernEntry(getMdht().getSeverityOfConcernEntry());
		}
		return null;
	}

	/**
	 * Gets the text reference pointing to the narrative text in the section.
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
	 * Sets the dispense item reference entry.
	 *
	 * @param entry
	 *            the new dispense item reference entry
	 */
	public void setDispenseItemReferenceEntry(DispenseItemReferenceEntry entry) {
		final DispenseItemReferenceEntry old = getDispenseItemReferenceEntry();
		if (old != null) {
			for (final EntryRelationship entryRelationship : getMdht().getEntryRelationships()) {
				if (old.getMdht() == entryRelationship.getAct()) {
					entryRelationship.setSupply(entry.getMdht());
					break;
				}
			}
		} else {
			EntryRelationship entryRelationship = null;
			entryRelationship = CDAFactory.eINSTANCE.createEntryRelationship();
			entryRelationship.setTypeCode(x_ActRelationshipEntryRelationship.REFR);
			entryRelationship.setSupply(entry.getMdht());
			this.getMdht().getEntryRelationships().add(entryRelationship);
		}
	}

	/**
	 * Sets the effective time in the low attribute.
	 *
	 * @param date
	 *            the new effective time
	 */
	public void setEffectiveTime(Date date) {
		final IVL_TS ivlts = DatatypesFactory.eINSTANCE.createIVL_TS();
		ivlts.setLow(DateUtilMdht.createIVXB_TSFromDateTime(date));
		this.getMdht().setEffectiveTime(ivlts);
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
	 * Sets the prescription item reference entry.
	 *
	 * @param entry
	 *            the new prescription item reference entry
	 */
	public void setPrescriptionItemReferenceEntry(PrescriptionItemReferenceEntry entry) {
		final PrescriptionItemReferenceEntry old = getPrescriptionItemReferenceEntry();
		if (old != null) {
			for (final EntryRelationship entryRelationship : getMdht().getEntryRelationships()) {
				if (old.getMdht() == entryRelationship.getAct()) {
					entryRelationship.setSubstanceAdministration(entry.getMdht());
					break;
				}
			}
		} else {
			EntryRelationship entryRelationship = null;
			entryRelationship = CDAFactory.eINSTANCE.createEntryRelationship();
			entryRelationship.setTypeCode(x_ActRelationshipEntryRelationship.REFR);
			entryRelationship.setSubstanceAdministration(entry.getMdht());
			this.getMdht().getEntryRelationships().add(entryRelationship);
		}
	}

	/**
	 * Sets the severity of concern entry.
	 *
	 * @param entry
	 *            the new severity of concern entry
	 */
	public void setSeverityOfConcernEntry(SeverityOfConcernEntry entry) {
		final SeverityOfConcernEntry old = this.getSeverityOfConcernEntry();
		if (old != null) {
			for (final EntryRelationship entryRelationship : getMdht().getEntryRelationships()) {
				if (old.getMdht() == entryRelationship.getAct()) {
					entryRelationship.setObservation(entry.getMdht());
					break;
				}
			}
		} else {
			EntryRelationship entryRelationship = null;
			entryRelationship = CDAFactory.eINSTANCE.createEntryRelationship();
			entryRelationship.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
			entryRelationship.setInversionInd(Boolean.TRUE);
			entryRelationship.setObservation(entry.getMdht());
			this.getMdht().getEntryRelationships().add(entryRelationship);
		}
	}

	/**
	 * Sets the text reference.
	 *
	 * @param value
	 *            the new text reference, # for local reference has to be
	 *            included
	 */
	@Override
	public void setTextReference(String value) {
		this.getMdht().setText(Util.createReference(value));
	}

}
