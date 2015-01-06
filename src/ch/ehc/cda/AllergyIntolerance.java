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

package ch.ehc.cda;

import ch.ehc.general.ConvenienceUtilsEnums.AllergySubstanceType;
import org.ehc.general.ConvenienceUtilsEnums.AllergyType;
import org.ehc.general.ConvenienceUtilsEnums.Severity;

/**
 * Codierte Allergie oder Unverträglichkeit
 */
public class AllergyIntolerance {

	/**
	 * Erzeugt ein Objekt welches eine Allergie oder Unverträglichkeit
	 * repräsentiert. Dieses Objekt kann einem AllergyIntoleranceConcern
	 * hinzugefügt werden.
	 * 
	 * @param codedIntolerance
	 *          Codierte Intoleranz
	 * @param substanceThatCausesIntolerance
	 *          Substanz die die Intoleranz auslöst
	 * @param severity
	 *          Schweregrad der Intoleranz
	 * 
	 */
	public AllergyIntolerance(AllergyType codedIntolerance,
			AllergySubstanceType substanceThatCausesIntolerance, Severity severity) {
	}

}
