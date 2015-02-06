/*******************************************************************************
*
* The authorship of this code and the accompanying materials is held by
* medshare GmbH, Switzerland. All rights reserved.
* http://medshare.net
*
* Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
*
* This code is are made available under the terms of the
* Eclipse Public License v1.0.
*
* Accompanying materials are made available under the terms of the
* Creative Commons Attribution-ShareAlike 3.0 Switzerland License.
*
* Year of publication: 2014
*
*******************************************************************************/

package org.ehc.cda;

import java.net.URI;

import org.ehc.common.ch.ConvenienceUtilsEnums.AdvanceDirectiveTypeCdaChVacd;
import org.ehc.common.ch.ConvenienceUtilsEnums.AgreementStatusCode;

/**
 * Codierte Patienteneinverständniserklärung
 */
public class AdvanceDirectiveObservation {

	/**
	 * Erzeugt ein Objekt welches eine Patientenverfügung repräsentiert.
	 * 
	 * @param advanceDirective
	 *          Eigentliche Verfügung (Codierter Eintrag gemäss CDA-CH-VACD,
	 *          Tabelle 22)
	 * @param agreementStatus
	 *          Angabe ob der Patient dieser Patientenverfügung zustimmt oder sie
	 *          ablehnt
	 */
	public AdvanceDirectiveObservation(
			AdvanceDirectiveTypeCdaChVacd advanceDirective,
			AgreementStatusCode agreementStatus) {
	}

	/**
	 * Erzeugt ein Objekt welches eine Patientenverfügung repräsentiert.
	 * 
	 * @param advanceDirective
	 *          Eigentliche Verfügung (Codierter Eintrag gemäss CDA-CH-VACD,
	 *          Tabelle 22)
	 * @param agreementStatus
	 *          Angabe ob der Patient dieser Patientenverfügung zustimmt oder sie
	 *          ablehnt
	 * @param doc
	 *          URL auf das Dokument, welches die rechtsgültige Patientenverfügung
	 *          enthält
	 */
	public AdvanceDirectiveObservation(
			AdvanceDirectiveTypeCdaChVacd advanceDirective,
			AgreementStatusCode agreementStatus, URI doc) {
	}
}
