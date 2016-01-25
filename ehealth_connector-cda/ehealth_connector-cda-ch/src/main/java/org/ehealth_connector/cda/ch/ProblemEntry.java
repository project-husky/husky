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
package org.ehealth_connector.cda.ch;

import org.ehealth_connector.cda.AbstractProblemEntry;
import org.ehealth_connector.cda.ch.enums.RiskOfComplications;
import org.ehealth_connector.cda.ch.enums.RiskOfExposure;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.cda.enums.ProblemType;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Value;
import org.openhealthtools.ihe.utils.UUID;

/**
 * ProblemEntry convenience functionality for the CDA Body Level 3 -Problem
 *
 */
public class ProblemEntry extends AbstractProblemEntry {

	/**
	 * Default constructor to instanciate the object
	 */
	public ProblemEntry() {
		this.setId(new Identificator("2.16.756.5.30.1.1.1.1.3.5", UUID.generate()));
	}

	/**
	 * Instantiates a new problem entry.
	 *
	 * @param entry the entry
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
			if ((code != null) && RiskOfComplications.CODE_SYSTEM_OID.equals(code.getCodeSystem())) {
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
