package org.ehealth_connector.communication.ch.testhelper;

import org.ehealth_connector.common.ch.enums.AuthorRole;
import org.ehealth_connector.common.ch.enums.AuthorSpeciality;
import org.ehealth_connector.communication.ch.enums.AvailabilityStatus;
import org.ehealth_connector.communication.ch.enums.ClassCode;
import org.ehealth_connector.communication.ch.enums.ConfidentialityCode;
import org.ehealth_connector.communication.ch.enums.FormatCode;
import org.ehealth_connector.communication.ch.enums.HealthcareFacilityTypeCode;
import org.ehealth_connector.communication.ch.enums.LanguageCode;
import org.ehealth_connector.communication.ch.enums.MimeType;
import org.ehealth_connector.communication.ch.enums.PracticeSettingCode;
import org.ehealth_connector.communication.ch.enums.SourcePatientInfo;
import org.ehealth_connector.communication.ch.enums.TypeCode;
import org.ehealth_connector.communication.testhelper.XdsTestUtils;

public class XdsChTestUtils extends XdsTestUtils {

	// Initialize Example CH Enum Vectors
	public static AuthorRole[] authorRoles = new AuthorRole[] { AuthorRole.ANDERE, AuthorRole.APOTHEKER };
	public static AuthorSpeciality[] authorSpecialities = new AuthorSpeciality[] { AuthorSpeciality.ANDERE_GESUNDHEITSBEZOGENE_FACHRICHTUNG,
			AuthorSpeciality.APOTHEKERINAPOTHEKER_IN_OFFIZINPHARMAZIE };
	public static AvailabilityStatus avaiabilityStatus = AvailabilityStatus.APPROVED;
	public static ClassCode[] classCodes = new ClassCode[] { ClassCode.ALERTS, ClassCode.CARE_PLANS };
	public static ConfidentialityCode[] confidentialityCodes = new ConfidentialityCode[] { ConfidentialityCode.ADMINISTRATIVE_DATEN,
			ConfidentialityCode.GEHEIME_DATEN };
	public static FormatCode[] formatCodes = new FormatCode[] { FormatCode.EIMPFDOSSIER, FormatCode.EPD_DOKUMENT };
	public static HealthcareFacilityTypeCode[] healthCareFacilityCodes = new HealthcareFacilityTypeCode[] {
			HealthcareFacilityTypeCode.AMBULANTE_EINRICHTUNG_INKL_AMBULATORIUM,
			HealthcareFacilityTypeCode.ANDERE_GESUNDHEITS_ORGANISATION };
	public static LanguageCode[] languageCodes = new LanguageCode[] { LanguageCode.DEUTSCH, LanguageCode.ENGLISCH };
	public static MimeType[] mimeTypes = new MimeType[] { MimeType.CDA_LEVEL_1_MULTIPART, MimeType.DICOM };
	public static PracticeSettingCode[] practiceSettingCodes = new PracticeSettingCode[] { PracticeSettingCode.ALLERGOLOGIE,
			PracticeSettingCode.ALLGEMEINMEDIZIN };
	public static SourcePatientInfo[] sourcePatientInfos = new SourcePatientInfo[] { SourcePatientInfo.AMBIGUOUS,
			SourcePatientInfo.FEMALE };
	public static TypeCode[] typeCodes = new TypeCode[] { TypeCode.ANDERE_NICHT_NAHER_SPEZIFIZIERT, TypeCode.ANASTHESIE_BERICHT };

	public XdsChTestUtils() {
		super();
	}
}
