package org.projecthusky.emed.ch.cda.digesters;

import org.projecthusky.common.ch.enums.stable.ConfidentialityCode;
import org.projecthusky.common.enums.AdministrativeGender;
import org.projecthusky.common.hl7cdar2.POCDMT000040ClinicalDocument;
import org.projecthusky.common.hl7cdar2.POCDMT000040SubstanceAdministration;
import org.projecthusky.common.utils.xml.XmlFactories;
import org.projecthusky.emed.ch.cda.services.EmedEntryDigestService;
import org.projecthusky.emed.ch.cda.xml.CceDocumentUnmarshaller;
import org.projecthusky.emed.ch.enums.*;
import org.projecthusky.emed.ch.errors.InvalidEmedContentException;
import org.projecthusky.emed.ch.models.common.*;
import org.projecthusky.emed.ch.models.document.EmedPreDocumentDigest;
import org.projecthusky.emed.ch.models.entry.EmedEntryDigest;
import org.projecthusky.emed.ch.models.treatment.MedicationProduct;
import org.junit.jupiter.api.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of the {@link CcePreEntryDigester} class.
 *
 * @author Ronaldo Loureiro
 */
class CcePreDigesterTest {

    final String DIR_SAMPLES_BY_HAND_MTP = "/Samples/ByHand/mtp/valid/";
    final String DIR_SAMPLES_BY_HAND_PRE = "/Samples/ByHand/pre/";

    private final static Class<?> UNMARSHALLED_CLASS = POCDMT000040SubstanceAdministration.class;
    private final Unmarshaller UNMARSHALLER;

    public CcePreDigesterTest() throws JAXBException {
        final var context = JAXBContext.newInstance(UNMARSHALLED_CLASS);
        UNMARSHALLER = context.createUnmarshaller();
    }

    @Test
    void testWithoutLoadPreDigester() throws Exception {
        final var digester = new CceDocumentDigester();
        final var preDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_PRE + "valid/PRE_01_valid.xml");

        assertThrows(NullPointerException.class, () -> digester.digest(preDocument));
    }

    @Test
    void testPreDigester1() throws Exception {
        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);

        emedEntryDigestServiceImpl.addAll(this.getEntryDigests(DIR_SAMPLES_BY_HAND_MTP + "MTP_04_valid.xml", digester));

        final var preDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_PRE + "valid/PRE_01_valid.xml");
        final var digest = digester.digest(preDocument);

        assertNotNull(digest);
        assertInstanceOf(EmedPreDocumentDigest.class, digest);
        final var preDigest = (EmedPreDocumentDigest) digest;

        // Document
        assertEquals("00E00000-0000-0000-0000-000000000001", preDigest.getId().toString().toUpperCase());
        assertEquals("00E00000-0000-0000-0000-000000000001", preDigest.getSetId().toString().toUpperCase());
        assertEquals(1, preDigest.getVersion());
        assertEquals("fr-CH", preDigest.getLanguageCode());
        assertEquals(ConfidentialityCode.NORMALLY_ACCESSIBLE, preDigest.getConfidentialityCode());
        assertEquals(1641033240L, preDigest.getCreationTime().toEpochSecond());
        assertEquals(1322560800000L, preDigest.getDocumentationTime().toEpochMilli());
        assertEquals(1, preDigest.getAuthors().size());
        assertInstanceOf(AuthorDigest.class, preDigest.getAuthors().get(0));
        assertEquals(1322560800000L, preDigest.getAuthors().get(0).getAuthorshipTimestamp().toEpochMilli());
        assertEquals("Familien", preDigest.getAuthors().get(0).getGivenName());
        assertEquals("Hausarzt", preDigest.getAuthors().get(0).getFamilyName());
        assertEquals("7601000234438", preDigest.getAuthors().get(0).getAuthorGln());
        assertInstanceOf(OrganizationDigest.class, preDigest.getAuthors().get(0).getOrganization());
        assertInstanceOf(TelecomDigest.class, preDigest.getAuthors().get(0).getTelecoms());
        assertEquals(1, preDigest.getRecipients().size());
        assertInstanceOf(PatientDigest.class, preDigest.getPatient());
        assertEquals(List.of(new QualifiedIdentifier("11111111", "2.999")), preDigest.getPatient().ids());
        assertEquals("Monika", preDigest.getPatient().givenName());
        assertEquals("Wegmüller", preDigest.getPatient().familyName());
        assertEquals(AdministrativeGender.FEMALE, preDigest.getPatient().gender());
        assertEquals(-9728, preDigest.getPatient().birthdate().toEpochDay());
        assertInstanceOf(OrganizationDigest.class, preDigest.getCustodian());
        assertNull(preDigest.getRemarks());
        assertNotEquals(0, preDigest.getPdfRepresentation().length);
        assertEquals(1, preDigest.getRecipients().size());
        assertEquals(1, preDigest.getRecipients().get(0).getAddresses().size());
        assertEquals("CH", preDigest.getRecipients().get(0).getAddresses().get(0).getCountry());
        assertEquals("Zürich", preDigest.getRecipients().get(0).getAddresses().get(0).getCity());
        assertEquals("8003", preDigest.getRecipients().get(0).getAddresses().get(0).getPostalCode());
        assertEquals(Instant.parse("2022-01-01T10:34:00Z"), preDigest.getPrescriptionValidityStart());
        assertNull(preDigest.getPrescriptionValidityStop());

        // Entry
        assertEquals(1, preDigest.getPreEntryDigests().size());
        final var preEntryDigest = preDigest.getPreEntryDigests().get(0);
        assertNotNull(preEntryDigest);
        assertEquals(0, preEntryDigest.getSequence());
        assertEquals(preDigest.getId(), preEntryDigest.getDocumentId());
        assertEquals("00E00000-0000-0000-0000-000000000001", preEntryDigest.getEntryId().toString().toUpperCase());
        assertEquals("00000000-0000-0000-0000-000000000004", preEntryDigest.getMedicationTreatmentId().toString().toUpperCase());
        assertEquals(EmedEntryType.PRE, preEntryDigest.getEmedEntryType());
        assertEquals(Instant.parse("2022-01-10T11:00:00.00Z"), preEntryDigest.getItemValidityStart());
        assertEquals(Instant.parse("2022-03-10T11:00:00.00Z"), preEntryDigest.getItemValidityStop());
        assertEquals(preDigest.getPrescriptionValidityStart().toEpochMilli(), preEntryDigest.getPrescriptionDocumentValidityStart().toEpochMilli());
        assertNull(preEntryDigest.getPrescriptionDocumentValidityStop());
        assertEquals(2, preEntryDigest.getRepeatNumber());
        assertEquals(RouteOfAdministrationAmbu.ORAL_USE, preEntryDigest.getRouteOfAdministration());
        assertInstanceOf(MedicationDosageInstructions.class, preEntryDigest.getDosageInstructions());
        assertEquals(MedicationDosageInstructions.Type.NORMAL, preEntryDigest.getDosageInstructions().getType());
        assertEquals(1, preEntryDigest.getDosageInstructions().getIntakes().size());
        assertNull(preEntryDigest.getDosageInstructions().getNarrativeDosageInstructions());
        assertInstanceOf(MedicationProduct.class, preEntryDigest.getProduct());
        assertNull(preEntryDigest.getProduct().getGtinCode());
        assertNull(preEntryDigest.getProduct().getPackageGtinCode());
        assertEquals("J01EE01", preEntryDigest.getProduct().getAtcCode());
        assertEquals("sulfamethoxazole and trimethoprim", preEntryDigest.getProduct().getName());
        assertNull(preEntryDigest.getProduct().getPackageName());
        assertEquals(PharmaceuticalDoseFormEdqm.TABLET, preEntryDigest.getProduct().getFormCode());
        assertNull(preEntryDigest.getProduct().getLotNumber());
        assertNull(preEntryDigest.getProduct().getExpirationDate());
        assertNull(preEntryDigest.getProduct().getPackageFormCode());
        assertNull(preEntryDigest.getProduct().getPackageCapacityQuantity());
        assertEquals(2, preEntryDigest.getProduct().getIngredients().size());
        assertEquals("Sulfamethoxazole", preEntryDigest.getProduct().getIngredients().get(0).getName());
        assertEquals("800", preEntryDigest.getProduct().getIngredients().get(0).getQuantityNumerator().getValue());
        assertEquals(RegularUnitCodeAmbu.MG, preEntryDigest.getProduct().getIngredients().get(0).getQuantityNumerator().getUnit());
        assertEquals("1", preEntryDigest.getProduct().getIngredients().get(0).getQuantityDenominator().getValue());
        assertEquals("732936001", preEntryDigest.getProduct().getIngredients().get(0).getQuantityDenominator().getUnit().getCodeValue());
        assertEquals(ActivePharmaceuticalIngredient.SULFAMETHOXAZOLE, preEntryDigest.getProduct().getIngredients().get(0).getCode());
        assertEquals("Trimethoprim", preEntryDigest.getProduct().getIngredients().get(1).getName());
        assertEquals("160", preEntryDigest.getProduct().getIngredients().get(1).getQuantityNumerator().getValue());
        assertEquals(RegularUnitCodeAmbu.MG, preEntryDigest.getProduct().getIngredients().get(1).getQuantityNumerator().getUnit());
        assertEquals("1", preEntryDigest.getProduct().getIngredients().get(1).getQuantityDenominator().getValue());
        assertEquals("732936001", preEntryDigest.getProduct().getIngredients().get(1).getQuantityDenominator().getUnit().getCodeValue());
        assertEquals(ActivePharmaceuticalIngredient.TRIMETHOPRIM, preEntryDigest.getProduct().getIngredients().get(1).getCode());
        assertEquals(preDigest.getAuthors().get(0), preEntryDigest.getDocumentAuthor());
        assertEquals(preDigest.getAuthors().get(0), preEntryDigest.getSectionAuthor());

        assertEquals("Treatment Reason", preEntryDigest.getTreatmentReason());
        assertNotNull(preEntryDigest.getMtpReference());
        assertEquals("00000000-0000-0000-0000-000000000004", preEntryDigest.getMtpReference().getEntryId().toString());
        assertEquals("00000000-0000-0000-0000-000000000004", preEntryDigest.getMtpReference().getDocumentId().toString());
        assertNull(preEntryDigest.getFulfilmentInstructions());
        assertNull(preEntryDigest.getPatientMedicationInstructions());
        assertEquals("2", preEntryDigest.getQuantityToDispense());
        assertNull(preEntryDigest.getRenewalPeriod());
        assertNull(preEntryDigest.getAnnotationComment());
    }

    @Test
    void testPreDigester2() throws Exception {
        final var emedEntryDigestServiceImpl = new EmedEntryDigestServiceImpl();
        final var digester = new CceDocumentDigester(emedEntryDigestServiceImpl);

        emedEntryDigestServiceImpl.addAll(this.getEntryDigests(DIR_SAMPLES_BY_HAND_MTP + "MTP_05_valid.xml", digester));

        final var preDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_PRE + "valid/PRE_02_valid.xml");
        final var digest = digester.digest(preDocument);

        assertNotNull(digest);
        assertInstanceOf(EmedPreDocumentDigest.class, digest);
        final var preDigest = (EmedPreDocumentDigest) digest;

        // Document

        assertEquals("00E00000-0000-0000-0000-000000000002", preDigest.getId().toString().toUpperCase());
        assertEquals("00E00000-0000-0000-0000-000000000002", preDigest.getSetId().toString().toUpperCase());
        assertEquals(1, preDigest.getVersion());
        assertEquals("fr-CH", preDigest.getLanguageCode());
        assertEquals(ConfidentialityCode.NORMALLY_ACCESSIBLE, preDigest.getConfidentialityCode());
        assertEquals(1641033240L, preDigest.getCreationTime().toEpochSecond());
        assertEquals(1322560800000L, preDigest.getDocumentationTime().toEpochMilli());
        assertEquals(1, preDigest.getAuthors().size());
        assertInstanceOf(AuthorDigest.class, preDigest.getAuthors().get(0));
        assertEquals(1322560800000L, preDigest.getAuthors().get(0).getAuthorshipTimestamp().toEpochMilli());
        assertEquals("Familien", preDigest.getAuthors().get(0).getGivenName());
        assertEquals("Hausarzt", preDigest.getAuthors().get(0).getFamilyName());
        assertEquals("7601000234438", preDigest.getAuthors().get(0).getAuthorGln());
        assertEquals(0, preDigest.getAuthors().get(0).getTelecoms().size());
        assertInstanceOf(OrganizationDigest.class, preDigest.getAuthors().get(0).getOrganization());
        assertInstanceOf(TelecomDigest.class, preDigest.getAuthors().get(0).getTelecoms());
        assertEquals(1, preDigest.getRecipients().size());
        assertInstanceOf(PatientDigest.class, preDigest.getPatient());
        assertEquals(List.of(new QualifiedIdentifier("11111111", "2.999")), preDigest.getPatient().ids());
        assertEquals("Monika", preDigest.getPatient().givenName());
        assertEquals("Wegmüller", preDigest.getPatient().familyName());
        assertEquals(AdministrativeGender.FEMALE, preDigest.getPatient().gender());
        assertEquals(-9728, preDigest.getPatient().birthdate().toEpochDay());
        assertInstanceOf(OrganizationDigest.class, preDigest.getCustodian());
        assertNull(preDigest.getRemarks());
        assertNotEquals(0, preDigest.getPdfRepresentation().length);
        assertEquals(1, preDigest.getRecipients().size());
        assertEquals(1, preDigest.getRecipients().get(0).getAddresses().size());
        assertEquals("CH", preDigest.getRecipients().get(0).getAddresses().get(0).getCountry());
        assertEquals("Zürich", preDigest.getRecipients().get(0).getAddresses().get(0).getCity());
        assertEquals("8003", preDigest.getRecipients().get(0).getAddresses().get(0).getPostalCode());
        assertEquals(Instant.parse("2022-01-01T10:34:00Z"), preDigest.getPrescriptionValidityStart());
        assertNull(preDigest.getPrescriptionValidityStop());

        // Entry
        assertEquals(1, preDigest.getPreEntryDigests().size());
        final var preEntryDigest = preDigest.getPreEntryDigests().get(0);
        assertNotNull(preEntryDigest);
        assertEquals(0, preEntryDigest.getSequence());
        assertEquals(preDigest.getId(), preEntryDigest.getDocumentId());
        assertEquals("00E00000-0000-0000-0000-000000000002", preEntryDigest.getEntryId().toString().toUpperCase());
        assertEquals("00000000-0000-0000-0000-000000000005", preEntryDigest.getMedicationTreatmentId().toString().toUpperCase());
        assertEquals(EmedEntryType.PRE, preEntryDigest.getEmedEntryType());
        assertEquals(Instant.parse("2022-01-10T11:00:00.00Z"), preEntryDigest.getItemValidityStart());
        assertEquals(Instant.parse("2022-03-10T11:00:00.00Z"), preEntryDigest.getItemValidityStop());
        assertEquals(preDigest.getPrescriptionValidityStart().toEpochMilli(), preEntryDigest.getPrescriptionDocumentValidityStart().toEpochMilli());
        assertNull(preEntryDigest.getPrescriptionDocumentValidityStop());
        assertEquals(2, preEntryDigest.getRepeatNumber());
        assertEquals(RouteOfAdministrationAmbu.ORAL_USE, preEntryDigest.getRouteOfAdministration());
        assertInstanceOf(MedicationDosageInstructions.class, preEntryDigest.getDosageInstructions());
        assertEquals(MedicationDosageInstructions.Type.NORMAL, preEntryDigest.getDosageInstructions().getType());
        assertEquals(1, preEntryDigest.getDosageInstructions().getIntakes().size());
        assertNull(preEntryDigest.getDosageInstructions().getNarrativeDosageInstructions());
        assertInstanceOf(MedicationProduct.class, preEntryDigest.getProduct());
        assertEquals("7680531520746", preEntryDigest.getProduct().getGtinCode());
        assertEquals("7680531520746", preEntryDigest.getProduct().getPackageGtinCode());
        assertNull(preEntryDigest.getProduct().getAtcCode());
        assertEquals("PROGRAF caps 0.5 mg 50 Stk", preEntryDigest.getProduct().getName());
        assertEquals("PROGRAF caps 0.5 mg 50 Stk", preEntryDigest.getProduct().getPackageName());
        assertEquals(PharmaceuticalDoseFormEdqm.CAPSULE_HARD, preEntryDigest.getProduct().getFormCode());
        assertNull(preEntryDigest.getProduct().getLotNumber());
        assertNull(preEntryDigest.getProduct().getExpirationDate());
        assertNull(preEntryDigest.getProduct().getPackageFormCode());
        assertEquals("50", preEntryDigest.getProduct().getPackageCapacityQuantity().getValue());
        assertEquals("732937005", preEntryDigest.getProduct().getPackageCapacityQuantity().getUnit().getCodeValue());
        assertEquals(1, preEntryDigest.getProduct().getIngredients().size());
        assertEquals("Tacrolimus", preEntryDigest.getProduct().getIngredients().get(0).getName());
        assertEquals("0.5", preEntryDigest.getProduct().getIngredients().get(0).getQuantityNumerator().getValue());
        assertEquals(RegularUnitCodeAmbu.MG, preEntryDigest.getProduct().getIngredients().get(0).getQuantityNumerator().getUnit());
        assertEquals("1", preEntryDigest.getProduct().getIngredients().get(0).getQuantityDenominator().getValue());
        assertEquals("732937005", preEntryDigest.getProduct().getIngredients().get(0).getQuantityDenominator().getUnit().getCodeValue());
        assertEquals(ActivePharmaceuticalIngredient.TACROLIMUS, preEntryDigest.getProduct().getIngredients().get(0).getCode());
        assertEquals(preDigest.getAuthors().get(0), preEntryDigest.getDocumentAuthor());
        assertEquals(preDigest.getAuthors().get(0), preEntryDigest.getSectionAuthor());

        assertEquals("Raison du traitement", preEntryDigest.getTreatmentReason());
        assertNotNull(preEntryDigest.getMtpReference());
        assertEquals("00000000-0000-0000-0000-000000000005", preEntryDigest.getMtpReference().getEntryId().toString());
        assertEquals("00000000-0000-0000-0000-000000000005", preEntryDigest.getMtpReference().getDocumentId().toString());
        assertNull(preEntryDigest.getFulfilmentInstructions());
        assertNull(preEntryDigest.getPatientMedicationInstructions());
        assertEquals("2", preEntryDigest.getQuantityToDispense());
        assertEquals(Instant.parse("2022-01-01T00:00:00.00Z").getEpochSecond(), preEntryDigest.getRenewalPeriod().getLow().getEpochSecond());
        assertEquals(Instant.parse("2022-03-01T00:00:00.00Z").getEpochSecond(), preEntryDigest.getRenewalPeriod().getHigh().getEpochSecond());
        assertEquals(Instant.parse("2022-03-01T00:00:00.00Z").getEpochSecond() -
                        Instant.parse("2022-01-01T00:00:00.00Z").getEpochSecond(),
                preEntryDigest.getRenewalPeriod().getDuration().get(ChronoUnit.SECONDS));
        assertNull(preEntryDigest.getAnnotationComment());
    }

    @Test
    void testPreWithoutMtpReference() throws Exception {
        final var preDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_PRE + "valid/PRE_02_valid.xml");
        final var digester = new CceDocumentDigester(new CcePreDigesterTest.EmedEntryDigestServiceImpl());

        var substanceAdministration = preDocument.getComponent()
                .getStructuredBody()
                .getComponent()
                .get(0)
                .getSection()
                .getEntry()
                .get(0)
                .getSubstanceAdministration();

        var entryRWithoutReference = substanceAdministration.getEntryRelationship()
                .stream()
                .filter(e -> !e.getTypeCode().value().equals("REFR"))
                .collect(Collectors.toList());

        substanceAdministration.getEntryRelationship().clear();
        substanceAdministration.getEntryRelationship().addAll(entryRWithoutReference);

        final var digest = digester.digest(preDocument);
        assertNotNull(digest);
        assertInstanceOf(EmedPreDocumentDigest.class, digest);
        final var preDigest = (EmedPreDocumentDigest) digest;

        assertEquals(1, preDigest.getPreEntryDigests().size());
        final var preEntryDigest = preDigest.getPreEntryDigests().get(0);
        assertNotNull(preEntryDigest);
        assertNull(preEntryDigest.getMtpReference());
    }

    @Test
    void testPreInvalidDigester1() throws Exception {
        final var preDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_PRE + "invalid/PRE_02_invalid.xml");
        final var digester = new CceDocumentDigester(new CcePreDigesterTest.EmedEntryDigestServiceImpl());

        assertThrows(InvalidEmedContentException.class, () -> digester.digest(preDocument));
    }

    @Test
    void testPreInvalidDigester2() throws Exception {
        final var preDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_PRE + "invalid/PRE_03_invalid.xml");
        final var digester = new CceDocumentDigester(new CcePreDigesterTest.EmedEntryDigestServiceImpl());

        assertThrows(IllegalArgumentException.class, () -> digester.digest(preDocument));
    }

    @Test
    void testPreInvalidDigester3() throws Exception {
        final var preDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_PRE + "invalid/PRE_04_invalid.xml");
        final var digester = new CceDocumentDigester(new EmedEntryDigestServiceImpl());

        assertThrows(InvalidEmedContentException.class, () -> digester.digest(preDocument));
    }

    @Test
    void testAuthorInSubstanceAdministration() throws Exception {
        var sectionAuthor = """
                <author>
                    <templateId root="2.16.756.5.30.1.1.10.9.23" />
                    <time value="20111129110000+0100" />
                    <assignedAuthor>
                        <id root="2.51.1.3" extension="7601000234438" />
                        <assignedPerson>
                            <name>
                                <family>Hausarzt</family>
                                <given>Familien</given>
                            </name>
                        </assignedPerson>
                    </assignedAuthor>
                </author>
                """;

        var documentAuthor = """
                <author>
                    <templateId root="2.16.756.5.30.1.1.10.9.23" />
                    <time value="20111129110000+0100" />
                    <assignedAuthor>
                        <id root="2.51.1.3" extension="7601000234438" />
                        <assignedPerson>
                            <name>
                                <family>Zarsauh</family>
                                <given>Familien</given>
                            </name>
                        </assignedPerson>
                    </assignedAuthor>
                </author>
                """;

        var substanceAdministration = """
                 <templateId root="2.16.756.5.30.1.1.10.4.43" />
                 <templateId root="1.3.6.1.4.1.19376.1.9.1.3.2" />
                 <templateId root="1.3.6.1.4.1.19376.1.9.1.3.6" />
                 <templateId root="2.16.840.1.113883.10.20.1.24" />
                 <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.7" />
                 <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.7.1" />
                 <id root="00E00000-0000-0000-0000-000000000002" />
                 <text>
                     <reference value="#pre.content" />
                 </text>
                 <statusCode code="completed" />
                 <effectiveTime xsi:type="IVL_TS">
                     <low value="20220110120000+0100" />
                     <high value="20220310120000+0100" />
                 </effectiveTime>
                 <effectiveTime xsi:type="EIVL_TS" operator="A">
                     <event code="MORN" />
                 </effectiveTime>
                 <repeatNumber value="2" />
                 <routeCode code="20053000" codeSystem="0.4.0.127.0.16.1.1.2.1" displayName="Oral use" />
                 <doseQuantity unit="mg" value="0.5" />
                 <consumable>
                     <manufacturedProduct>
                         <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.7.2" />
                         <templateId root="2.16.840.1.113883.10.20.1.53" />
                         <manufacturedMaterial classCode="MMAT" determinerCode="KIND">
                             <templateId root="2.16.756.5.30.1.1.10.4.33" />
                             <templateId root="1.3.6.1.4.1.19376.1.9.1.3.1" />
                             <code code="7680531520746" codeSystem="2.51.1.1" codeSystemName="GTIN" displayName="PROGRAF caps 0.5 mg 50 Stk">
                                 <originalText>
                                     <reference value="#mtp.content" />
                                 </originalText>
                             </code>
                             <name>PROGRAF caps 0.5 mg 50 Stk</name>
                             <pharm:formCode code="10210000" codeSystem="0.4.0.127.0.16.1.1.2.1" displayName="Capsule, hard" />
                         </manufacturedMaterial>
                     </manufacturedProduct>
                 </consumable>
                """ + sectionAuthor;

        var digest = new CcePreEntryDigester(new EmedEntryDigestServiceImpl()).createDigest(this.unmarshall(substanceAdministration),
                UUID.randomUUID(),
                Instant.parse("2022-01-01T00:00:00.00Z"),
                Instant.parse("2022-01-01T00:00:00.00Z"),
                null,
                null,
                null);

        assertEquals(digest.getSectionAuthor(), digest.getDocumentAuthor());

        substanceAdministration += documentAuthor;
        digest = new CcePreEntryDigester(new EmedEntryDigestServiceImpl()).createDigest(this.unmarshall(substanceAdministration),
                UUID.randomUUID(),
                Instant.parse("2022-01-01T00:00:00.00Z"),
                Instant.parse("2022-01-01T00:00:00.00Z"),
                null,
                null,
                null);

        assertNotEquals(digest.getSectionAuthor().getFamilyName(), digest.getDocumentAuthor().getFamilyName());
    }

    @Test
    void testIsProvisional() throws Exception {
        var entryRelationship = """
                 <entryRelationship typeCode="REFR">
                  <substanceAdministration classCode="SBADM" moodCode="PRP">
                    <templateId root="1.3.6.1.4.1.19376.1.9.1.3.16"/>
                    <consumable>
                      <manufacturedProduct>
                        <manufacturedMaterial nullFlavor="NA"/>
                      </manufacturedProduct>
                    </consumable>
                  </substanceAdministration>
                 </entryRelationship>""";

        var er = this.unmarshall(entryRelationship).getEntryRelationship().get(0);

        var preDocument = this.loadDoc(DIR_SAMPLES_BY_HAND_PRE + "valid/PRE_01_valid.xml");
        preDocument.getComponent()
                .getStructuredBody()
                .getComponent()
                .get(0)
                .getSection()
                .getEntry()
                .get(0)
                .getSubstanceAdministration()
                .getEntryRelationship()
                .add(er);

        final var digester = new CceDocumentDigester(new CcePreDigesterTest.EmedEntryDigestServiceImpl());
        var digest = digester.digest(preDocument);

        assertNotNull(digest);
        assertInstanceOf(EmedPreDocumentDigest.class, digest);
        final var preDigest = (EmedPreDocumentDigest) digest;
        assertEquals(1, preDigest.getPreEntryDigests().size());
        final var preEntryDigest = preDigest.getPreEntryDigests().get(0);
        assertNotNull(preEntryDigest);

        assertTrue(preEntryDigest.isProvisional());
    }

    private POCDMT000040ClinicalDocument loadDoc(final String docName) throws SAXException {
        return CceDocumentUnmarshaller.unmarshall(CcePreDigesterTest.class.getResourceAsStream("/CDA-CH-EMED"
                + docName));
    }

    private POCDMT000040SubstanceAdministration unmarshall(final String substanceAdministrationContent) throws ParserConfigurationException, IOException, SAXException, JAXBException {
        final var completeElement = "<substanceAdministration classCode=\"SBADM\" moodCode=\"INT\" xmlns:pharm=\"urn:ihe:pharm\" xmlns=\"urn:hl7-org:v3\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                + substanceAdministrationContent
                + "</substanceAdministration>";

        final var document =
                XmlFactories.newSafeDocumentBuilder().parse(new InputSource(new StringReader(completeElement)));

        final Object root = UNMARSHALLER.unmarshal(document, POCDMT000040SubstanceAdministration.class);
        return (POCDMT000040SubstanceAdministration) JAXBIntrospector.getValue(root);
    }

    private List<EmedEntryDigest> getEntryDigests(String docPath, CceDocumentDigester digester) throws Exception {
        final var document = this.loadDoc(docPath);
        return digester.digest(document).getEntryDigests();
    }

    private static class EmedEntryDigestServiceImpl implements EmedEntryDigestService {

        private final List<EmedEntryDigest> digests = new ArrayList<>();

        @Override
        public Optional<EmedEntryDigest> getById(UUID entryId) {
            return this.digests.stream().filter(digest -> digest.getEntryId().equals(entryId)).findAny();
        }

        @Override
        public int getSequence(UUID medicationTreatmentId, Instant creationTime) {
            return 0;
        }

        public void add(EmedEntryDigest digest) {
            this.digests.add(digest);
        }

        public void addAll(List<EmedEntryDigest> digests) {
            this.digests.addAll(digests);
        }
    }

}
