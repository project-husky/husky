/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.communication.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openehealth.ipf.commons.core.OidGenerator;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AssociationType;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.projecthusky.common.basetypes.NameBaseType;
import org.projecthusky.common.communication.DocumentMetadata;
import org.projecthusky.common.communication.SubmissionSetMetadata;
import org.projecthusky.common.enums.DateTimeRangeAttributes;
import org.projecthusky.common.enums.EhcVersions;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.model.Author;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.model.Name;
import org.projecthusky.communication.xd.storedquery.DateTimeRange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XdsTestUtils {

	// Initialize PatientId
	public static Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.2005.1000",
			"IHERED-1644");

	// Initialize AuthorPerson
	public static Author authorPerson;

	public static List<Code> formatCodes = List
			.of(new Code("urn:ihe:rad:1.2.840.10008.5.1.4.1.1.88.59", "KOS Dokument", null));

	public static List<Code> confidentialityCodes = List.of(new Code("30001", "administrative Daten", null));

	public static List<String> docIds = List.of("123455.235234", "1.2.3.4.5.6.7.8");

	public static List<AssociationType> parentRelation = List.of(AssociationType.APPEND, AssociationType.REPLACE);

	// Date Time Ranges
	public static DateTimeRange dateTimeRange1;

	public static DateTimeRange dateTimeRange2;

	public static DateTimeRange[] dateTimeRanges;

	public static DateTimeRange eDateTimeRange1;
	public static DateTimeRange eDateTimeRange2;

	public static DateTimeRange eDateTimeRanges[];
	public static ZonedDateTime d1;
	public static ZonedDateTime d2;
	/** The SLF4J logger instance. */
	protected final Logger log = LoggerFactory.getLogger(getClass());

	public AvailabilityStatus availabilityStatus;

	public XdsTestUtils() {
		// Initalize DateTimeRanges
		dateTimeRange1 = new DateTimeRange(DateTimeRangeAttributes.CREATION_TIME,
				LocalDateTime.parse("201401012300", DateTimeFormatter.ofPattern("yyyyMMddHHmm"))
						.atZone(ZoneId.systemDefault()),
				LocalDateTime.parse("201412310400", DateTimeFormatter.ofPattern("yyyyMMddHHmm"))
						.atZone(ZoneId.systemDefault()));
		dateTimeRange2 = new DateTimeRange(DateTimeRangeAttributes.CREATION_TIME,
				LocalDateTime.parse("201501012300", DateTimeFormatter.ofPattern("yyyyMMddHHmm"))
						.atZone(ZoneId.systemDefault()),
				LocalDateTime.parse("201502010400", DateTimeFormatter.ofPattern("yyyyMMddHHmm"))
						.atZone(ZoneId.systemDefault()));
		dateTimeRanges = new DateTimeRange[] { dateTimeRange1, dateTimeRange2 };

		d1 = LocalDateTime.parse("19800521022211", DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))
				.atZone(ZoneId.systemDefault());
		d2 = LocalDateTime.parse("20150521133459", DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))
				.atZone(ZoneId.systemDefault());
			eDateTimeRange1 = new DateTimeRange(
					DateTimeRangeAttributes.CREATION_TIME, d1, d2);
			eDateTimeRange2 = new DateTimeRange(
					DateTimeRangeAttributes.SERVICE_START_TIME, d1, d2);
			eDateTimeRanges = new DateTimeRange[] {
					eDateTimeRange1, eDateTimeRange2 };

		availabilityStatus = AvailabilityStatus.SUBMITTED;

		// Initialize AuthorPerson
		authorPerson = new Author();
		var name = new Name();
		name.setFamily("Bereit");
		name.setGiven("Allzeit");
		name.setPrefix("Dr.");
		authorPerson.addName(name);

		authorPerson.getIds().add(new Identificator(null, "123456789"));
	}

	public String extractByRegex(String aRegEx, List<List<String>> aInput) {
		final Pattern p = Pattern.compile(aRegEx);

		for (List<String> item : aInput) {
			for (String itemStr : item) {
				final Matcher m = p.matcher(itemStr);
				if (m.find()) {
					return m.group(1);
				}
			}
		}

		return "";
	}

	protected InputStream getDocPdf() throws FileNotFoundException {
		File file = new File("src/test/resources/docConsumer/patientconsent.pdf");
		return new FileInputStream(file);
	}

	protected InputStream getDocCda() throws FileNotFoundException {
		File file = new File("src/test/resources/docConsumer/CDA-CH-VACD_Impfausweis.xml");
		return new FileInputStream(file);
	}

	protected InputStream getDocCdaV2() throws FileNotFoundException {
		File file = new File("src/test/resources/docConsumer/CDA-CH-VACD_Impfausweis_V2.xml");
		return new FileInputStream(file);
	}

	protected void setMetadataForCda(DocumentMetadata metaData, Identificator patientId) {
		Name name = new Name(new NameBaseType());
		name.setGiven("Gerald");
		name.setFamily("Smitty");

		Author author = new Author();
		author.addName(name);

		author.setRoleFunction(new Code("HCP", "2.16.756.5.30.1.127.3.10.1.1.3", "Healthcare professional"));

		metaData.addAuthor(author);
		metaData.setDestinationPatientId(patientId);
		metaData.setSourcePatientId(new Identificator("1.2.3.4", "2342134localid"));
		metaData.setCodedLanguage(LanguageCode.FRENCH_CODE);

		metaData.setTypeCode(
				new Code("41000179103", "2.16.840.1.113883.6.96", "Immunization record (record artifact)"));
		metaData.setFormatCode(new Code("urn:ihe:iti:xds-sd:pdf:2008", "1.3.6.1.4.1.19376.1.2.3",
				"1.3.6.1.4.1.19376.1.2.20 (Scanned Document)"));
		metaData.setClassCode(
				new Code("419891008", "2.16.840.1.113883.6.96", "Record artifact (record artifact)"));
		metaData.setHealthcareFacilityTypeCode(new Code("394747008", "2.16.840.1.113883.6.96", "Health Authority"));
		metaData.setPracticeSettingCode(
				new Code("394802001", "2.16.840.1.113883.6.96", "General medicine (qualifier value)"));
		metaData.addConfidentialityCode(new Code("17621005", "2.16.840.1.113883.6.96", "Normal (qualifier value)"));
	}

	protected void setMetadataForPdf(DocumentMetadata metaData, Identificator patientId) {
		Name name = new Name(new NameBaseType());
		name.setGiven("Gerald");
		name.setFamily("Smitty");

		Author author = new Author();
		author.addName(name);

		author.setRoleFunction(new Code("HCP", "2.16.756.5.30.1.127.3.10.1.1.3", "Healthcare professional"));

		metaData.addAuthor(author);
		metaData.setDestinationPatientId(patientId);
		metaData.setSourcePatientId(new Identificator("1.2.3.4", "2342134localid"));
		metaData.setCodedLanguage(LanguageCode.GERMAN_CODE);
		metaData.setTypeCode(new Code("419891008", "2.16.840.1.113883.6.96", "Record artifact (record artifact)"));
		metaData.setFormatCode(new Code("urn:ihe:iti:xds-sd:pdf:2008", "1.3.6.1.4.1.19376.1.2.3",
				"1.3.6.1.4.1.19376.1.2.20 (Scanned Document)"));
		metaData.setClassCode(new Code("184216000", "2.16.840.1.113883.6.96", "Patient record type (record artifact)"));
		metaData.setHealthcareFacilityTypeCode(new Code("394747008", "2.16.840.1.113883.6.96", "Health Authority"));
		metaData.setPracticeSettingCode(
				new Code("394802001", "2.16.840.1.113883.6.96", "General medicine (qualifier value)"));
		metaData.addConfidentialityCode(new Code("17621005", "2.16.840.1.113883.6.96", "Normal (qualifier value)"));
		metaData.setTitle("Informed Consent");
	}

	protected void setSubmissionMetadata(SubmissionSetMetadata metadata, Identificator patientId) {
		metadata.getAuthor().add(authorPerson);
		metadata.setUniqueId(OidGenerator.uniqueOid().toString());
		metadata.setSourceId(EhcVersions.getCurrentVersion().getOid());
		metadata.setEntryUUID(UUID.randomUUID().toString());
		metadata.setDestinationPatientId(patientId);
		metadata.setContentTypeCode(new Code("71388002", "2.16.840.1.113883.6.96", "Procedure (procedure)"));
	}

}
