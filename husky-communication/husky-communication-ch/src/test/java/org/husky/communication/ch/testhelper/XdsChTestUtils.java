/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
package org.husky.communication.ch.testhelper;

import org.husky.common.ch.enums.AuthorRole;
import org.husky.common.ch.enums.AuthorSpeciality;
import org.husky.common.ch.enums.ConfidentialityCode;
import org.husky.common.enums.LanguageCode;
import org.husky.communication.ch.enums.AvailabilityStatus;
import org.husky.communication.ch.enums.ClassCode;
import org.husky.communication.ch.enums.FormatCode;
import org.husky.communication.ch.enums.HealthcareFacilityTypeCode;
import org.husky.communication.ch.enums.MimeType;
import org.husky.communication.ch.enums.PracticeSettingCode;
import org.husky.communication.ch.enums.SourcePatientInfo;
import org.husky.communication.ch.enums.TypeCode;
import org.husky.communication.testhelper.XdsTestUtils;

public class XdsChTestUtils extends XdsTestUtils {

	// Initialize Example CH Enum Vectors
	public static AuthorRole[] authorRoles = new AuthorRole[] { AuthorRole.HEALTHCARE_PROFESSIONAL,
			AuthorRole.HEALTHCARE_PROFESSIONAL };
	public static AuthorSpeciality[] authorSpecialities = new AuthorSpeciality[] {
			AuthorSpeciality.ANAESTHESIOLOGY, AuthorSpeciality.BIOMEDICAL_ANALYSIS };
	public static AvailabilityStatus avaiabilityStatus = AvailabilityStatus.APPROVED;
	public static ClassCode[] classCodes = new ClassCode[] { ClassCode.CARE_PLAN,
			ClassCode.AUDIT_TRAIL_REPORT };
	public static ConfidentialityCode[] confidentialityCodes = new ConfidentialityCode[] {
			ConfidentialityCode.NORMALLY_ACCESSIBLE, ConfidentialityCode.SECRET };
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
	public static TypeCode[] typeCodes = new TypeCode[] { TypeCode.ALLERGY_RECORD,
			TypeCode.NURSING_CARE_PLAN };

	public XdsChTestUtils() {
		super();
	}
}
