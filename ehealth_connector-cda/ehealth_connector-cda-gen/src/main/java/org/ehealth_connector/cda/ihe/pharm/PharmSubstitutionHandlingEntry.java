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

package org.ehealth_connector.cda.ihe.pharm;

import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.cda.ihe.pharm.enums.SubstanceAdminSubstitution;
import org.ehealth_connector.common.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.PharmSubjectOf4;
import org.openhealthtools.mdht.uml.cda.PharmSubstitutionPermission;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClassRoot;
import org.openhealthtools.mdht.uml.hl7.vocab.ActMood;

/**
 * Implements the IHE PharmSubstitutionHandlingEntry.
 */
public class PharmSubstitutionHandlingEntry extends
		MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmSubstitutionHandlingEntry> {

	/**
	 * Instantiates a new pharm substitution handling entry.
	 */
	public PharmSubstitutionHandlingEntry() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new pharm substitution handling entry.
	 *
	 * @param languageCode
	 *            the language code
	 */
	public PharmSubstitutionHandlingEntry(LanguageCode languageCode) {
		super(PHARMFactory.eINSTANCE.createPharmSubstitutionHandlingEntry().init());
		this.getMdht().setIndependentInd(DatatypesFactory.eINSTANCE.createBL(false));
	}

	/**
	 * Instantiates a new pharm substitution handling entry.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public PharmSubstitutionHandlingEntry(
			org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmSubstitutionHandlingEntry mdht) {
		super(mdht);
	}

	/**
	 * Gets the substance admin substitution.
	 *
	 * @return the substance admin substitution
	 */
	public SubstanceAdminSubstitution getSubstanceAdminSubstitution() {
		if (this.getMdht().getSubjectOf4() != null
				&& (this.getMdht().getSubjectOf4().getSubstitutionPermission() != null)) {
			final PharmSubstitutionPermission pharmSubstitution = this.getMdht().getSubjectOf4()
					.getSubstitutionPermission();
			if (pharmSubstitution.getCode() != null) {
				return SubstanceAdminSubstitution.getEnum(pharmSubstitution.getCode().getCode());
			}
		}
		return null;
	}

	/**
	 * Sets the substance admin substitution.
	 *
	 * @param substanceAdminSubstitution
	 *            the substance admin substitution
	 * @param languageCode
	 *            the language code
	 */
	public void setSubstanceAdminSubstitution(SubstanceAdminSubstitution substanceAdminSubstitution,
			LanguageCode languageCode) {
		if (substanceAdminSubstitution != null) {
			if (this.getMdht().getSubjectOf4() == null
					|| this.getMdht().getSubjectOf4().getSubstitutionPermission() == null) {
				final PharmSubstitutionPermission pharmSubstitution = CDAFactory.eINSTANCE
						.createPharmSubstitutionPermission();
				pharmSubstitution.setClassCode(ActClassRoot.SUBST);
				pharmSubstitution.setMoodCode(ActMood.PERM);
				PharmSubjectOf4 subjectOf4 = CDAFactory.eINSTANCE.createPharmSubjectOf4();
				subjectOf4.setSubstitutionPermission(pharmSubstitution);
				this.getMdht().setSubjectOf4(subjectOf4);
			}
			final PharmSubstitutionPermission pharmSubstitution = this.getMdht().getSubjectOf4()
					.getSubstitutionPermission();
			pharmSubstitution.setCode(substanceAdminSubstitution.getCode(languageCode).getCE());
		} else {
			this.getMdht().setSubjectOf4(null);
		}

	}

}
