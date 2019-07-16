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
package org.ehealth_connector.cda.ch;

import org.ehealth_connector.cda.BaseProblemEntry;
import org.ehealth_connector.cda.ch.enums.RiskOfComplications;
import org.ehealth_connector.cda.ch.enums.RiskOfExposure;
import org.ehealth_connector.cda.enums.ProblemType;
import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.mdht.Value;
import org.ehealth_connector.common.mdht.enums.EhcVersions;
import org.ehealth_connector.common.mdht.enums.LanguageCode;
import org.openhealthtools.ihe.utils.UUID;

/**
 * ProblemEntry convenience functionality for the CDA Body Level 3 -Problem
 *
 */
public class ProblemEntry extends BaseProblemEntry {

	/**
	 * Default constructor to instanciate the object
	 */
	public ProblemEntry() {
		this.setId(new Identificator(EhcVersions.getCurrentVersion().getOid(), UUID.generate()));
	}

	/**
	 * Instantiates a new problem entry.
	 *
	 * @param entry
	 *            the entry
	 */
	public ProblemEntry(org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry entry) {
		super(entry);
	}

	/**
	 * Gets the compl risk.
	 *
	 * @return the compl risk
	 */
	public RiskOfComplications getComplicationRisk() {
		final Value value = this.getValue();
		if (value != null) {
			final Code code = value.getCode();
			if ((code != null)
					&& RiskOfComplications.CODE_SYSTEM_OID.equals(code.getCodeSystem())) {
				return RiskOfComplications.getEnum(code.getCode());
			}
		}
		return null;
	}

	/**
	 * Gets the exposure risk.
	 *
	 * @return the exposure risk
	 */
	public RiskOfExposure getExposureRisk() {
		final Value value = this.getValue();
		if (value != null) {
			final Code code = value.getCode();
			if ((code != null) && RiskOfExposure.CODE_SYSTEM_OID.equals(code.getCodeSystem())) {
				return RiskOfExposure.getEnum(code.getCode());
			}
		}
		return null;
	}

	/**
	 * Sets the complication Risk and in addition sets the ProblemType to
	 * PROBLEM
	 *
	 * @param complRisk
	 *            the compl risk
	 * @param languageCode
	 *            the language code
	 */
	public void setComplicationRisk(RiskOfComplications complRisk, LanguageCode languageCode) {
		setProblemType(ProblemType.PROBLEM);
		setValue(new Value(complRisk.getCode(languageCode)));
	}

	/**
	 * Sets the exposure risk and in addition sets the ProblemType to PROBLEM.
	 *
	 * @param expRisk
	 *            the exp risk
	 * @param languageCode
	 *            the language code
	 */
	public void setExposureRisk(RiskOfExposure expRisk, LanguageCode languageCode) {
		setProblemType(ProblemType.PROBLEM);
		setValue(new Value(expRisk.getCode(languageCode)));
	}

}
