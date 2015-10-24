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

package org.ehealth_connector.cda;

import org.ehealth_connector.cda.ch.enums.CdaChVacdImmunizations;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Util;
import org.openhealthtools.ihe.utils.UUID;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

/**
 * MedicationTargetEntry convenience functionality for the CDA Body Level 3 -
 * Medication Target Element. Required is the ID of the software which created
 * the entry and an an immunization target code
 */
public class MedicationTargetEntry
		extends EFacade<org.openhealthtools.mdht.uml.cda.ch.MedicationTargetEntry> {

	/**
	 * Instantiates a new medication target entry.
	 */
	public MedicationTargetEntry() {
		super(CHFactory.eINSTANCE.createMedicationTargetEntry().init(), null, null);
		this.getMdht().getTemplateIds().clear();
		// cannot add it in the model because VACD has the same templateId
		this.getMdht().getTemplateIds().add(
				new Identificator("2.16.756.5.30.1.1.1.1.3.5.1", "CDA-CH.VACD.Body.MediL3.Reason")
						.getIi());

		Identificator id = new Identificator("2.16.756.5.30.1.1.1.1.3.5.1", UUID.generate());
		this.setSoftwareCreatedId(id);
	}

	/**
	 * Instantiates a new medication target entry.
	 */
	protected MedicationTargetEntry(
			org.openhealthtools.mdht.uml.cda.ch.MedicationTargetEntry entry) {
		super(entry, "2.16.756.5.30.1.1.1.1.3.5.1", "CDA-CH.VACD.Body.MediL3.Reason");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof MedicationTargetEntry)) {
			return false;
		}
		MedicationTargetEntry other = (MedicationTargetEntry) obj;

		Code code = getImmunizationTargetCode();
		if ((code != null && !code.equals(other.getImmunizationTargetCode()))
				|| (code == null && other.getImmunizationTargetCode() != null)) {
			return false;
		}

		Identificator id = getSoftwareCreatedId();
		if ((id != null && !id.equals(other.getSoftwareCreatedId()))
				|| (id == null && other.getSoftwareCreatedId() != null)) {
			return false;
		}

		return true;
	}

	/**
	 * Gets the immunization target.
	 *
	 * @return the immunization target
	 */
	public CdaChVacdImmunizations getImmunizationTarget() {
		Code code = this.getImmunizationTargetCode();
		if (code != null && CdaChVacdImmunizations.CODE_SYSTEM_OID.equals(code.getCodeSystem())) {
			return CdaChVacdImmunizations.getEnum(code.getCode());
		}
		return null;
	}

	/**
	 * Gets the immunization target code.
	 *
	 * @return the immunization target code
	 */
	public Code getImmunizationTargetCode() {
		if (getMdht().getCode() != null) {
			return new Code(getMdht().getCode());
		}
		return null;
	}

	/**
	 * Gets the software created id.
	 *
	 * @return the software created id
	 */
	public Identificator getSoftwareCreatedId() {
		if (getMdht().getIds().size() > 0) {
			return new Identificator(this.getMdht().getIds().get(0));
		}
		return null;
	}

	/**
	 * Gets the text reference.
	 *
	 * @return the text reference
	 */
	public String getTextReference() {
		if (this.getMdht().getText() != null && this.getMdht().getText().getReference() != null) {
			return this.getMdht().getText().getReference().getValue();
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.getSoftwareCreatedId() != null
				? this.getSoftwareCreatedId().hashCode() : 0);
		result = prime * result + (this.getImmunizationTargetCode() != null
				? this.getImmunizationTargetCode().hashCode() : 0);
		return result;
	}

	/**
	 * Sets the immunization target.
	 *
	 * @param targetImmunization
	 *            the new immunization target
	 */
	public void setImmunizationTarget(CdaChVacdImmunizations targetImmunization) {
		if (targetImmunization != null) {
			this.setImmunizationTargetCode(targetImmunization.getCode());
		} else {
			this.setImmunizationTargetCode((Code) null);
		}
	}

	/**
	 * Sets the immunization target code.
	 *
	 * @param code
	 *            the new immunization target code
	 */
	public void setImmunizationTargetCode(Code code) {
		getMdht().setCode(code.getCD());
	}

	/**
	 * Sets the software created id.
	 *
	 * @param identifier
	 *            the new software created id
	 */
	public void setSoftwareCreatedId(Identificator identifier) {
		getMdht().getIds().clear();
		getMdht().getIds().add(identifier.getIi());
	}

	/**
	 * Sets the text reference.
	 *
	 * @param value
	 *            the new text reference, # for local reference has to be
	 *            included
	 */
	public void setTextReference(String value) {
		this.getMdht().setText(Util.createReference(value));
	}

}
