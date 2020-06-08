/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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

package org.ehealth_connector.cda.ch.vacd.v140;

import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.cda.ch.vacd.v140.enums.CdaChVacdImmunizations;
import org.ehealth_connector.common.enums.EhcVersions;
import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.ihe.utils.UUID;
import org.openhealthtools.mdht.uml.cda.ch.ChFactory;

/**
 * MedicationTargetEntry convenience functionality for the CDA Body Level 3 -
 * Medication Target Element. Required is the ID of the software which created
 * the entry and an an immunization target code
 */
public class MedicationTargetEntry
		extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ch.MedicationTargetEntry>
		implements Comparable<MedicationTargetEntry> {

	/**
	 * Instantiates a new medication target entry.
	 */
	public MedicationTargetEntry() {
		super(ChFactory.eINSTANCE.createMedicationTargetEntry().init(), null, null);
		this.getMdht().getTemplateIds().clear();
		// cannot add it in the model because VACD has the same templateId
		this.getMdht().getTemplateIds().add(
				new Identificator("2.16.756.5.30.1.1.1.1.3.5.1", "CDA-CH.VACD.Body.MediL3.Reason")
						.getIi());

		final Identificator id = new Identificator(EhcVersions.getCurrentVersion().getOid(),
				UUID.generate());
		this.setId(id);
	}

	/**
	 * Instantiates a new medication target entry.
	 *
	 * @param targetImmunization
	 *            the target immunization
	 */
	public MedicationTargetEntry(CdaChVacdImmunizations targetImmunization) {
		this();
		this.setImmunizationTarget(targetImmunization);
	}

	/**
	 * Instantiates a new medication target entry.
	 *
	 * @param entry
	 *            the target entry
	 */
	public MedicationTargetEntry(org.openhealthtools.mdht.uml.cda.ch.MedicationTargetEntry entry) {
		super(entry, "2.16.756.5.30.1.1.1.1.3.5.1", "CDA-CH.VACD.Body.MediL3.Reason");
	}

	@Override
	public int compareTo(MedicationTargetEntry o) {

		final CdaChVacdImmunizations immunizationTarget = getImmunizationTarget();
		final CdaChVacdImmunizations otherImmunizationTarget = o.getImmunizationTarget();

		if ((immunizationTarget != null) && (otherImmunizationTarget != null)) {
			return new Integer(immunizationTarget.getSortOrder())
					.compareTo(otherImmunizationTarget.getSortOrder());
		}

		if ((immunizationTarget != null) && (otherImmunizationTarget == null)) {
			return -1;
		}

		if ((immunizationTarget == null) && (otherImmunizationTarget != null)) {
			return 1;
		}

		if ((immunizationTarget == null) && (otherImmunizationTarget == null)) {
			return 0;
		}
		return 0;
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
		final MedicationTargetEntry other = (MedicationTargetEntry) obj;

		final Code code = getImmunizationTargetCode();
		if (((code != null) && !code.equals(other.getImmunizationTargetCode()))
				|| ((code == null) && (other.getImmunizationTargetCode() != null))) {
			return false;
		}

		final Identificator id = getId();
		if (((id != null) && !id.equals(other.getId()))
				|| ((id == null) && (other.getId() != null))) {
			return false;
		}

		return true;
	}

	/**
	 * Gets the software created id.
	 *
	 * @return the software created id
	 */
	public Identificator getId() {
		if (getMdht().getIds().size() > 0) {
			return new Identificator(this.getMdht().getIds().get(0));
		}
		return null;
	}

	/**
	 * Gets the immunization target.
	 *
	 * @return the immunization target
	 */
	public CdaChVacdImmunizations getImmunizationTarget() {
		final Code code = this.getImmunizationTargetCode();
		if ((code != null) && CdaChVacdImmunizations.CODE_SYSTEM_OID.equals(code.getCodeSystem())) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + (this.getId() != null ? this.getId().hashCode() : 0);
		result = (prime * result) + (this.getImmunizationTargetCode() != null
				? this.getImmunizationTargetCode().hashCode()
				: 0);
		return result;
	}

	/**
	 * Sets the software created id.
	 *
	 * @param identifier
	 *            the new software created id
	 */
	public void setId(Identificator identifier) {
		getMdht().getIds().clear();
		getMdht().getIds().add(identifier.getIi());
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
