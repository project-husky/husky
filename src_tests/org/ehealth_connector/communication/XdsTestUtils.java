package org.ehealth_connector.communication;

import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.communication.ch.enums.*;
import org.openhealthtools.ihe.common.hl7v2.Hl7v2Factory;
import org.openhealthtools.ihe.common.hl7v2.XCN;
import org.openhealthtools.ihe.xds.consumer.query.DateTimeRange;
import org.openhealthtools.ihe.xds.consumer.query.MalformedQueryException;
import org.openhealthtools.ihe.xds.metadata.ParentDocumentRelationshipType;
import org.openhealthtools.ihe.xds.metadata.constants.DocumentEntryConstants;

import sun.security.krb5.internal.PAEncTSEnc;

public class XdsTestUtils {
	
	//Initialize PatientId
	public static Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.2005.1000", "IHERED-1644");
	
	//Initialize AuthorPerson
	public static XCN authorPerson;
	
	//Initialize Example CH Enum Vectors
	public static AuthorRole[] authorRoles = new AuthorRole[]{AuthorRole.ANDERE, AuthorRole.APOTHEKER};
	public static AuthorSpeciality[] authorSpecialities = new AuthorSpeciality[]{AuthorSpeciality.ANDERE_GESUNDHEITSBEZOGENE_FACHRICHTUNG, AuthorSpeciality.APOTHEKERINAPOTHEKER_IN_OFFIZINPHARMAZIE};
	public static AvailabilityStatus avaiabilityStatus = AvailabilityStatus.APPROVED;
	public static ClassCode[] classCodes = new ClassCode[]{ClassCode.ALERTS, ClassCode.CARE_PLANS};
	public static ConfidentialityCode[] confidentialityCodes = new ConfidentialityCode[]{ConfidentialityCode.ADMINISTRATIVE_DATEN, ConfidentialityCode.GEHEIME_DATEN};
	public static FormatCode[] formatCodes = new FormatCode[]{FormatCode.EIMPFDOSSIER, FormatCode.EPD_DOKUMENT};
	public static HealthcareFacilityTypeCode[] healthCareFacilityCodes = new HealthcareFacilityTypeCode[]{HealthcareFacilityTypeCode.AMBULANTE_EINRICHTUNG_INKL__AMBULATORIUM, HealthcareFacilityTypeCode.ANDERE_GESUNDHEITS_ORGANISATION};
	public static LanguageCode[] languageCodes = new LanguageCode[]{LanguageCode.DEUTSCH, LanguageCode.ENGLISCH};
	public static MimeType[] mimeTypes = new MimeType[]{MimeType.CDA_LEVEL_1_MULTIPART, MimeType.DICOM};
	public static PracticeSettingCode[] practiceSettingCodes = new PracticeSettingCode[]{PracticeSettingCode.ALLERGOLOGIE, PracticeSettingCode.ALLGEMEINMEDIZIN};
	public static SourcePatientInfo[] sourcePatientInfos = new SourcePatientInfo[]{SourcePatientInfo.AMBIGUOUS, SourcePatientInfo.FEMALE};
	public static TypeCode[] typeCodes = new TypeCode[]{TypeCode.ANDERE_NICHT_NÄHER_SPEZIFIZIERT, TypeCode.ANÄSTHESIE_BERICHT};
	
	public static String[] docIds = new String[]{"123455.235234","1.2.3.4.5.6.7.8"};
	public static ParentDocumentRelationshipType[] parentRelation = new ParentDocumentRelationshipType[]{ParentDocumentRelationshipType.APND_LITERAL, ParentDocumentRelationshipType.RPLC_LITERAL};
	
	//Date Time Ranges
	//TODO Evtl. Wrapper Objekt mit deutscher Datumsschreibweise erstellen.
	public static DateTimeRange dateTimeRange1;
	public static DateTimeRange dateTimeRange2;
	public static DateTimeRange[] dateTimeRanges;
	
	public XdsTestUtils() {
		//Initalize DateTimeRanges
		try {
			dateTimeRange1 = new DateTimeRange(DocumentEntryConstants.CREATION_TIME, "201401012300", "201412310400");
			dateTimeRange2 = new DateTimeRange(DocumentEntryConstants.CREATION_TIME, "201501012300", "201502010400");
			dateTimeRanges = new DateTimeRange[]{dateTimeRange1, dateTimeRange2};
		} catch (MalformedQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Initialize AuthorPerson
		authorPerson = Hl7v2Factory.eINSTANCE.createXCN();
		authorPerson.setGivenName("Allzeit");
		authorPerson.setFamilyName("Bereit");
		authorPerson.setPrefix("Dr.");
		authorPerson.setIdNumber("123456789");
	}
}

