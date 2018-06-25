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
package org.ehealth_connector.communication.ch.testhelper;

import org.ehealth_connector.common.ch.enums.AuthorRole;
import org.ehealth_connector.common.ch.enums.AuthorSpeciality;
import org.ehealth_connector.common.ch.enums.ConfidentialityCode;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.communication.ch.enums.AvailabilityStatus;
import org.ehealth_connector.communication.ch.enums.ClassCode;
import org.ehealth_connector.communication.ch.enums.FormatCode;
import org.ehealth_connector.communication.ch.enums.HealthcareFacilityTypeCode;
import org.ehealth_connector.communication.ch.enums.MimeType;
import org.ehealth_connector.communication.ch.enums.PracticeSettingCode;
import org.ehealth_connector.communication.ch.enums.SourcePatientInfo;
import org.ehealth_connector.communication.ch.enums.TypeCode;
import org.ehealth_connector.communication.testhelper.XdsTestUtils;

public class XdsChTestUtils extends XdsTestUtils {

	// Initialize Example CH Enum Vectors
	public static AuthorRole[] authorRoles = new AuthorRole[] { AuthorRole.HEALTHCARE_PROFESSIONAL,
			AuthorRole.PHARMACIST };
	public static AuthorSpeciality[] authorSpecialities = new AuthorSpeciality[] {
			AuthorSpeciality.ANDERE_GESUNDHEITSBEZOGENE_FACHRICHTUNG,
			AuthorSpeciality.APOTHEKERINAPOTHEKER_IN_OFFIZINPHARMAZIE };
	public static AvailabilityStatus avaiabilityStatus = AvailabilityStatus.APPROVED;
	public static ClassCode[] classCodes = new ClassCode[] { ClassCode.ALERTS,
			ClassCode.CARE_PLANS };
	public static ConfidentialityCode[] confidentialityCodes = new ConfidentialityCode[] {
			ConfidentialityCode.NORMAL, ConfidentialityCode.SECRET };
	public static FormatCode[] formatCodes = new FormatCode[] { FormatCode.IMMUNIZATION_CONTENT,
			FormatCode.UNSTRUCTURED_EPR_DOCUMENT };
	public static HealthcareFacilityTypeCode[] healthCareFacilityCodes = new HealthcareFacilityTypeCode[] {
			HealthcareFacilityTypeCode.AMBULATORY_CARE_SITE,
			HealthcareFacilityTypeCode.OTHER_SITE_OF_CARE };
	public static LanguageCode[] languageCodes = new LanguageCode[] { LanguageCode.GERMAN,
			LanguageCode.ENGLISH };
	public static MimeType[] mimeTypes = new MimeType[] { MimeType.CDA_LEVEL_1_MULTIPART,
			MimeType.DICOM };
	public static PracticeSettingCode[] practiceSettingCodes = new PracticeSettingCode[] {
			PracticeSettingCode.CLINICAL_IMMUNOLOGY_ALLERGY, PracticeSettingCode.GENERAL_MEDICINE };
	public static SourcePatientInfo[] sourcePatientInfos = new SourcePatientInfo[] {
			SourcePatientInfo.OTHER, SourcePatientInfo.FEMALE };
	public static TypeCode[] typeCodes = new TypeCode[] { TypeCode.OTHER_EPD_DOCUMENT_TYPE,
			TypeCode.ANAESTHESIOLOGY_REPORT };

	public XdsChTestUtils() {
		super();
	}
}
