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

package ch.ehc.communication;

import org.ehc.general.Identificator;

import ch.ehc.general.ConvenienceUtilsEnums.AuthorRoleCode;
import ch.ehc.general.ConvenienceUtilsEnums.AuthorSpecialityCode;
import ch.ehc.general.ConvenienceUtilsEnums.HealthcareFacilityTypeCode;
import ch.ehc.general.ConvenienceUtilsEnums.PracticeSettingCode;

/**
 * Stellt die Metadaten gemäss [IHE ITI TF-3], Table 4.1-5: Document Metadata
 * Attribute Definition bereit
 * */
public class XdsMetadata {
	PracticeSettingCode practiceSettingCode;
	HealthcareFacilityTypeCode healthcareFacilityTypeCode;
	Identificator sourceId;
	AuthorRoleCode authorRole;
	AuthorSpecialityCode authorSpeciality;

	/**
	 * Metadaten gemäss [IHE ITI TF-3], Table 4.1-5: Document Metadata Attribute
	 * Definition
	 * 
	 * @param sourceId
	 *          Weltweit eindeutige Identifikation der Documentenquelle (Document
	 *          Source)
	 * @param practiceSettingCode
	 *          Medizinischer Fachbereich, welchem der medizinische Inhalt des
	 *          Dokuments zugeordnet wird
	 * @param healthcareFacilityTypeCode
	 *          Typ der Gesundheitseinrichtung, in der das Dokument erstellt wurde
	 * @param authorRole
	 *          Fachrichtung des Autors
	 * @param authorSpeciality
	 *          Spezialgebiet des Autors
	 */
	public XdsMetadata(Identificator sourceId,
			PracticeSettingCode practiceSettingCode,
			HealthcareFacilityTypeCode healthcareFacilityTypeCode,
			AuthorRoleCode authorRole, AuthorSpecialityCode authorSpeciality) {
		super();
		this.practiceSettingCode = practiceSettingCode;
		this.healthcareFacilityTypeCode = healthcareFacilityTypeCode;
		this.sourceId = sourceId;
	}

}
