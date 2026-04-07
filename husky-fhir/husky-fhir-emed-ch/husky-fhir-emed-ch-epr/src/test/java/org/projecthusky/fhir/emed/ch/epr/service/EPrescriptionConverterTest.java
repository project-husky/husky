package org.projecthusky.fhir.emed.ch.epr.service;

import ca.uhn.fhir.context.FhirContext;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.junit.jupiter.api.Test;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.CdTyp9;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.MedicamentIdType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.*;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.enums.ChMed16AGender;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.posology.ChMed16ADailyDosage;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.posology.ChMed16APosology;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedication;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtTreatmentPlan;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprCompositionPre;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprDocumentPre;
import org.projecthusky.fhir.emed.ch.epr.service.converter.emediplan.EPrescriptionConverter;
import org.projecthusky.fhir.emed.ch.epr.validator.ChEmedEprHapiValidator;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.ChMed16APatientId.PATIENT_ID_TYPE_INSURANCE_CARD;

public class EPrescriptionConverterTest {
    private static final String CHMED16A_PRE_CH_TRANSMISSION_FORMAT_EXAMPLE = "CHMED16A1H4sIAAAAAAAAAzWPMU/DMBCFZ/IrolvB0p3b+O6yUSEEEkUM3RCDW7uiQyNE3AFV+e84diN5ed/ze093bdoWPnw6xSFB316zzOD53Z9jlvDihxEeKnxb4PYypvi74M3THARSZkOUH9xlY5pd2MZwOuTUkMb857ME6kQ2X8OcYyfYEWuHa3S3zmLu/n7mNVvI1HwthTe+Krp2+OACd7I3qvFoSOloNAgZF0UcH7yGzpdqeLyk77qKhIjMwqLVqmdYtCuDzljZEfUo/Vrv0faI0Ez/cZpKMywBAAA=";

    @Test
    void convertChEmedEprPrescriptionAndValidate() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/examples/ch-emed-epr/Bundle-DocumentPreParacetamolAxapharmCARAPMP004.xml").readAllBytes());
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var document = parser.parse(xml, EmedDocumentType.PRE);
        assertInstanceOf(ChEmedEprDocumentPre.class, document);
        final var preDocument = (ChEmedEprDocumentPre) document;
        assertNotNull(preDocument.resolveComposition());
        final var composition = preDocument.resolveComposition();
        assertInstanceOf(ChEmedEprCompositionPre.class, composition);
        final var converter = new EPrescriptionConverter();

        final var emediplan = converter.toEMediplan(preDocument);
        assertNotNull(emediplan);
        assertEquals(EPrescription.LAST_SUPPORTED_REVISION, emediplan.getRevision());
        assertEquals(document.resolveIdentifier().toString(), emediplan.getId());
        assertEquals(document.resolveTimestamp(), emediplan.getTimestamp());
        assertNotNull(emediplan.getPatient());
        final var patient = preDocument.resolvePatient();
        assertEquals(patient.getNameFirstRep().getGivenAsSingleString(), emediplan.getPatient().getFirstName());
        assertEquals(patient.getNameFirstRep().getFamily(), emediplan.getPatient().getLastName());
        assertEquals(LocalDate.ofInstant(patient.getBirthDateElement().getValueAsCalendar().toInstant(), ZoneId.systemDefault()), emediplan.getPatient().getBirthDate());
        assertEquals(ChMed16AGender.MALE, emediplan.getPatient().getGender());
        assertNotNull(emediplan.getMedicaments());
        assertNull(emediplan.getPatient().getAddress());
        assertNull(emediplan.getPatient().getPhone());
        assertNull(emediplan.getPatient().getEmail());
        assertNull(emediplan.getPatient().getReceiver());
        assertTrue(emediplan.getPatient().getIds().isEmpty());
        assertTrue(emediplan.getPatient().getExtensions().isEmpty());
        assertEquals(composition.resolveMedicationRequests().size(), emediplan.getMedicaments().size());
        final var lastRequest = preDocument.resolveLastRequest();
        assertEquals(lastRequest.resolveMedication().resolveGtinCode(), emediplan.getMedicaments().getFirst().getId());
        assertEquals(MedicamentIdType.GTIN, emediplan.getMedicaments().getFirst().getIdType());
        assertNotNull(emediplan.getMedicaments().getFirst().getPosology());
        assertFalse(emediplan.getMedicaments().getFirst().getPosology().isEmpty());
        assertEquals(lastRequest.getDosageInstructionFirstRep().getBoundsPeriod().getEndElement().getValueAsCalendar().toInstant(), emediplan.getMedicaments().getFirst().getPosology().getFirst().getEnd());
        assertNotNull(emediplan.getMedicaments().getFirst().getPosology().getFirst().getDailyDoses());
        assertEquals(1, emediplan.getMedicaments().getFirst().getPosology().getFirst().getDailyDoses().getMorningDose());
        assertEquals(1, emediplan.getMedicaments().getFirst().getPosology().getFirst().getDailyDoses().getNoonDose());
        assertEquals(1, emediplan.getMedicaments().getFirst().getPosology().getFirst().getDailyDoses().getEveningDose());
        assertEquals(0, emediplan.getMedicaments().getFirst().getPosology().getFirst().getDailyDoses().getNightDose());
        assertEquals(CdTyp9.TABLET, emediplan.getMedicaments().getFirst().getUnit());
        assertEquals(lastRequest.getDosageInstructionFirstRep().getPatientInstruction(), emediplan.getMedicaments().getFirst().getApplicationInstructions());
        assertNull(emediplan.getMedicaments().getFirst().getRepetition());
        assertNull(emediplan.getMedicaments().getFirst().getRepetitionObject());
        assertNull(emediplan.getMedicaments().getFirst().getForbidSubstitution());
        assertNull(emediplan.getMedicaments().getFirst().getNumberOfPackages());
        assertTrue(emediplan.getMedicaments().getFirst().getExtensions().isEmpty());
        assertEquals(lastRequest.resolveMedicalAuthor().getPractitionerRole().resolvePractitioner().resolveGln(), emediplan.getAuthor());
        assertNull(emediplan.getRemark());
        assertNotNull(emediplan.getHealthcarePerson());
        assertEquals(emediplan.getAuthor(), emediplan.getHealthcarePerson().getGln());
        assertEquals(lastRequest.resolveMedicalAuthor().getPractitionerRole().resolvePractitioner().resolveName().getGivenAsSingleString(), emediplan.getHealthcarePerson().getFirstName());
        assertEquals(lastRequest.resolveMedicalAuthor().getPractitionerRole().resolvePractitioner().resolveName().getFamily(), emediplan.getHealthcarePerson().getLastName());
        assertNull(emediplan.getHealthcarePerson().getZsr());
        assertNotNull(emediplan.getHealthcareOrganization());
        assertEquals(lastRequest.resolveMedicalAuthor().getPractitionerRole().resolveOrganization().getName(), emediplan.getHealthcareOrganization().getName());
        assertNull(emediplan.getHealthcareOrganization().getNameAffix());
        assertNotNull(emediplan.getHealthcareOrganization().getAddress());
        assertEquals("Rue Gabrielle-Perret-Gentil 4", emediplan.getHealthcareOrganization().getAddress().getStreet());
        assertEquals(lastRequest.resolveMedicalAuthor().getPractitionerRole().resolveOrganization().getAddressFirstRep().getPostalCode(), emediplan.getHealthcareOrganization().getAddress().getPostalCode());
        assertEquals(lastRequest.resolveMedicalAuthor().getPractitionerRole().resolveOrganization().getAddressFirstRep().getCity(), emediplan.getHealthcareOrganization().getAddress().getCity());
        assertNull(emediplan.getHealthcareOrganization().getAddress().getCountry());
        assertNull(emediplan.getHealthcareOrganization().getZsr());
        assertNull(emediplan.getHealthcareOrganization().getPhoneNumber());
        assertNull(emediplan.getHealthcareOrganization().getEmail());
        assertNull(emediplan.getExtensionsSchema());
        assertTrue(emediplan.getExtensions().isEmpty());

        final var validationResult = emediplan.validate();
        assertNotNull(validationResult);
        assertTrue(validationResult.isSuccessful());

        emediplan.trim();
        final var serializedEmediplan = emediplan.toChTransmissionFormat();
        assertNotNull(serializedEmediplan);
    }

    @Test
    void convertChEmedEprFreeTextDosagePrescriptionAndValidate() throws IOException {
        final var json = new String(getClass().getResourceAsStream("/examples/ch-emed-epr/Bundle-DocumentPreCARAPMP004MarcoumarFreeTextDosage.json").readAllBytes());
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var document = parser.parse(json, EmedDocumentType.PRE);
        assertInstanceOf(ChEmedEprDocumentPre.class, document);
        final var preDocument = (ChEmedEprDocumentPre) document;
        assertNotNull(preDocument.resolveComposition());
        final var composition = preDocument.resolveComposition();
        assertInstanceOf(ChEmedEprCompositionPre.class, composition);
        final var converter = new EPrescriptionConverter();

        final var emediplan = converter.toEMediplan(preDocument);
        assertNotNull(emediplan);
        assertEquals(EPrescription.LAST_SUPPORTED_REVISION, emediplan.getRevision());
        assertEquals(document.resolveIdentifier().toString(), emediplan.getId());
        assertEquals(document.resolveTimestamp(), emediplan.getTimestamp());
        assertNotNull(emediplan.getPatient());
        final var patient = preDocument.resolvePatient();
        assertEquals(patient.getNameFirstRep().getGivenAsSingleString(), emediplan.getPatient().getFirstName());
        assertEquals(patient.getNameFirstRep().getFamily(), emediplan.getPatient().getLastName());
        assertEquals(LocalDate.ofInstant(patient.getBirthDateElement().getValueAsCalendar().toInstant(), ZoneId.systemDefault()), emediplan.getPatient().getBirthDate());
        assertEquals(ChMed16AGender.MALE, emediplan.getPatient().getGender());
        assertNotNull(emediplan.getMedicaments());
        assertNull(emediplan.getPatient().getAddress());
        assertNull(emediplan.getPatient().getPhone());
        assertNull(emediplan.getPatient().getEmail());
        assertNull(emediplan.getPatient().getReceiver());
        assertTrue(emediplan.getPatient().getIds().isEmpty());
        assertTrue(emediplan.getPatient().getExtensions().isEmpty());
        assertEquals(composition.resolveMedicationRequests().size(), emediplan.getMedicaments().size());
        final var lastRequest = preDocument.resolveLastRequest();
        assertEquals(lastRequest.resolveMedication().resolveGtinCode(), emediplan.getMedicaments().getFirst().getId());
        assertEquals(MedicamentIdType.GTIN, emediplan.getMedicaments().getFirst().getIdType());
        assertNotNull(emediplan.getMedicaments().getFirst().getPosology());
        assertTrue(emediplan.getMedicaments().getFirst().getPosology().isEmpty());
        assertNull(emediplan.getMedicaments().getFirst().getUnit());
        assertEquals(lastRequest.getDosageInstructionFirstRep().getPatientInstruction(), emediplan.getMedicaments().getFirst().getApplicationInstructions());
        assertNull(emediplan.getMedicaments().getFirst().getRepetition());
        assertNull(emediplan.getMedicaments().getFirst().getRepetitionObject());
        assertNull(emediplan.getMedicaments().getFirst().getForbidSubstitution());
        assertNull(emediplan.getMedicaments().getFirst().getNumberOfPackages());
        assertTrue(emediplan.getMedicaments().getFirst().getExtensions().isEmpty());
        assertEquals(lastRequest.resolveMedicalAuthor().getPractitionerRole().resolvePractitioner().resolveGln(), emediplan.getAuthor());
        assertNull(emediplan.getRemark());
        assertNotNull(emediplan.getHealthcarePerson());
        assertEquals(emediplan.getAuthor(), emediplan.getHealthcarePerson().getGln());
        assertEquals(lastRequest.resolveMedicalAuthor().getPractitionerRole().resolvePractitioner().resolveName().getGivenAsSingleString(), emediplan.getHealthcarePerson().getFirstName());
        assertEquals(lastRequest.resolveMedicalAuthor().getPractitionerRole().resolvePractitioner().resolveName().getFamily(), emediplan.getHealthcarePerson().getLastName());
        assertNull(emediplan.getHealthcarePerson().getZsr());
        assertNotNull(emediplan.getHealthcareOrganization());
        assertEquals(lastRequest.resolveMedicalAuthor().getPractitionerRole().resolveOrganization().getName(), emediplan.getHealthcareOrganization().getName());
        assertNull(emediplan.getHealthcareOrganization().getNameAffix());
        assertNotNull(emediplan.getHealthcareOrganization().getAddress());
        assertEquals("Rue Gabrielle-Perret-Gentil 4", emediplan.getHealthcareOrganization().getAddress().getStreet());
        assertEquals(lastRequest.resolveMedicalAuthor().getPractitionerRole().resolveOrganization().getAddressFirstRep().getPostalCode(), emediplan.getHealthcareOrganization().getAddress().getPostalCode());
        assertEquals(lastRequest.resolveMedicalAuthor().getPractitionerRole().resolveOrganization().getAddressFirstRep().getCity(), emediplan.getHealthcareOrganization().getAddress().getCity());
        assertNull(emediplan.getHealthcareOrganization().getAddress().getCountry());
        assertNull(emediplan.getHealthcareOrganization().getZsr());
        assertNull(emediplan.getHealthcareOrganization().getPhoneNumber());
        assertNull(emediplan.getHealthcareOrganization().getEmail());
        assertNull(emediplan.getExtensionsSchema());
        assertTrue(emediplan.getExtensions().isEmpty());

        final var validationResult = emediplan.validate();
        assertNotNull(validationResult);
        assertTrue(validationResult.isSuccessful());

        emediplan.trim();
        final var serializedEmediplan = emediplan.toChTransmissionFormat();
        assertNotNull(serializedEmediplan);
    }

    @Test
    void convertChEmedEprMultipleMedicationsPrescriptionAndValidate() throws IOException {
        final var json = new String(getClass().getResourceAsStream("/examples/ch-emed-epr/Bundle-DocumentUCSF7CARAPMP004PREDafalgan.json").readAllBytes());
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var document = parser.parse(json, EmedDocumentType.PRE);
        assertInstanceOf(ChEmedEprDocumentPre.class, document);
        final var preDocument = (ChEmedEprDocumentPre) document;
        assertNotNull(preDocument.resolveComposition());
        final var composition = preDocument.resolveComposition();
        assertInstanceOf(ChEmedEprCompositionPre.class, composition);
        final var converter = new EPrescriptionConverter();

        final var emediplan = converter.toEMediplan(preDocument);
        assertNotNull(emediplan);
        assertEquals(EPrescription.LAST_SUPPORTED_REVISION, emediplan.getRevision());
        assertEquals(document.resolveIdentifier().toString(), emediplan.getId());
        assertEquals(document.resolveTimestamp(), emediplan.getTimestamp());
        assertNotNull(emediplan.getPatient());
        final var patient = preDocument.resolvePatient();
        assertEquals(patient.getNameFirstRep().getGivenAsSingleString(), emediplan.getPatient().getFirstName());
        assertEquals(patient.getNameFirstRep().getFamily(), emediplan.getPatient().getLastName());
        assertEquals(LocalDate.ofInstant(patient.getBirthDateElement().getValueAsCalendar().toInstant(), ZoneId.systemDefault()), emediplan.getPatient().getBirthDate());
        assertEquals(ChMed16AGender.MALE, emediplan.getPatient().getGender());
        assertNotNull(emediplan.getMedicaments());
        assertNull(emediplan.getPatient().getAddress());
        assertNull(emediplan.getPatient().getPhone());
        assertNull(emediplan.getPatient().getEmail());
        assertNull(emediplan.getPatient().getReceiver());
        assertTrue(emediplan.getPatient().getIds().isEmpty());
        assertTrue(emediplan.getPatient().getExtensions().isEmpty());
        assertEquals(composition.resolveMedicationRequests().size(), emediplan.getMedicaments().size());

        var request = preDocument.resolveMedicationRequests().get(0);
        assertEquals(request.resolveMedication().resolveGtinCode(), emediplan.getMedicaments().getFirst().getId());
        assertEquals(MedicamentIdType.GTIN, emediplan.getMedicaments().getFirst().getIdType());
        assertNotNull(emediplan.getMedicaments().getFirst().getPosology());
        assertTrue(emediplan.getMedicaments().getFirst().getPosology().isEmpty());
        assertNull(emediplan.getMedicaments().getFirst().getUnit());
        assertEquals(request.getDosageInstructionFirstRep().getPatientInstruction(), emediplan.getMedicaments().getFirst().getApplicationInstructions());
        assertNull(emediplan.getMedicaments().getFirst().getRepetition());
        assertNull(emediplan.getMedicaments().getFirst().getRepetitionObject());
        assertNull(emediplan.getMedicaments().getFirst().getForbidSubstitution());
        assertNull(emediplan.getMedicaments().getFirst().getNumberOfPackages());
        assertTrue(emediplan.getMedicaments().getFirst().getExtensions().isEmpty());
        assertEquals(request.resolveMedicalAuthor().getPractitionerRole().resolvePractitioner().resolveGln(), emediplan.getAuthor());
        assertNull(emediplan.getRemark());
        assertNotNull(emediplan.getHealthcarePerson());
        assertEquals(emediplan.getAuthor(), emediplan.getHealthcarePerson().getGln());
        assertEquals(request.resolveMedicalAuthor().getPractitionerRole().resolvePractitioner().resolveName().getGivenAsSingleString(), emediplan.getHealthcarePerson().getFirstName());
        assertEquals(request.resolveMedicalAuthor().getPractitionerRole().resolvePractitioner().resolveName().getFamily(), emediplan.getHealthcarePerson().getLastName());
        assertNull(emediplan.getHealthcarePerson().getZsr());
        assertNotNull(emediplan.getHealthcareOrganization());
        assertEquals(request.resolveMedicalAuthor().getPractitionerRole().resolveOrganization().getName(), emediplan.getHealthcareOrganization().getName());
        assertNull(emediplan.getHealthcareOrganization().getNameAffix());
        assertNotNull(emediplan.getHealthcareOrganization().getAddress());
        assertEquals("Rue Gabrielle-Perret-Gentil 4", emediplan.getHealthcareOrganization().getAddress().getStreet());
        assertEquals(request.resolveMedicalAuthor().getPractitionerRole().resolveOrganization().getAddressFirstRep().getPostalCode(), emediplan.getHealthcareOrganization().getAddress().getPostalCode());
        assertEquals(request.resolveMedicalAuthor().getPractitionerRole().resolveOrganization().getAddressFirstRep().getCity(), emediplan.getHealthcareOrganization().getAddress().getCity());
        assertNull(emediplan.getHealthcareOrganization().getAddress().getCountry());
        assertNull(emediplan.getHealthcareOrganization().getZsr());
        assertNull(emediplan.getHealthcareOrganization().getPhoneNumber());
        assertNull(emediplan.getHealthcareOrganization().getEmail());
        assertNull(emediplan.getExtensionsSchema());
        assertTrue(emediplan.getExtensions().isEmpty());

        request = preDocument.resolveMedicationRequests().get(1);
        final var medicament = emediplan.getMedicaments().get(1);
        assertEquals(request.resolveMedication().resolveMedicationName(), medicament.getId());
        assertEquals(MedicamentIdType.NONE, medicament.getIdType());
        assertNotNull(medicament.getPosology());
        assertTrue(medicament.getPosology().isEmpty());
        assertNull(medicament.getUnit());
        assertEquals(request.getDosageInstructionFirstRep().getPatientInstruction(), medicament.getApplicationInstructions());
        assertNull(medicament.getRepetition());
        assertNull(medicament.getRepetitionObject());
        assertNull(medicament.getForbidSubstitution());
        assertNull(medicament.getNumberOfPackages());
        assertTrue(medicament.getExtensions().isEmpty());
        assertEquals(request.resolveMedicalAuthor().getPractitionerRole().resolvePractitioner().resolveGln(), emediplan.getAuthor());
        assertNull(emediplan.getRemark());
        assertNotNull(emediplan.getHealthcarePerson());
        assertEquals(emediplan.getAuthor(), emediplan.getHealthcarePerson().getGln());
        assertEquals(request.resolveMedicalAuthor().getPractitionerRole().resolvePractitioner().resolveName().getGivenAsSingleString(), emediplan.getHealthcarePerson().getFirstName());
        assertEquals(request.resolveMedicalAuthor().getPractitionerRole().resolvePractitioner().resolveName().getFamily(), emediplan.getHealthcarePerson().getLastName());
        assertNull(emediplan.getHealthcarePerson().getZsr());
        assertNotNull(emediplan.getHealthcareOrganization());
        assertEquals(request.resolveMedicalAuthor().getPractitionerRole().resolveOrganization().getName(), emediplan.getHealthcareOrganization().getName());
        assertNull(emediplan.getHealthcareOrganization().getNameAffix());
        assertNotNull(emediplan.getHealthcareOrganization().getAddress());
        assertEquals("Rue Gabrielle-Perret-Gentil 4", emediplan.getHealthcareOrganization().getAddress().getStreet());
        assertEquals(request.resolveMedicalAuthor().getPractitionerRole().resolveOrganization().getAddressFirstRep().getPostalCode(), emediplan.getHealthcareOrganization().getAddress().getPostalCode());
        assertEquals(request.resolveMedicalAuthor().getPractitionerRole().resolveOrganization().getAddressFirstRep().getCity(), emediplan.getHealthcareOrganization().getAddress().getCity());
        assertNull(emediplan.getHealthcareOrganization().getAddress().getCountry());
        assertNull(emediplan.getHealthcareOrganization().getZsr());
        assertNull(emediplan.getHealthcareOrganization().getPhoneNumber());
        assertNull(emediplan.getHealthcareOrganization().getEmail());
        assertNull(emediplan.getExtensionsSchema());
        assertTrue(emediplan.getExtensions().isEmpty());

        final var validationResult = emediplan.validate();
        assertNotNull(validationResult);
        assertTrue(validationResult.isSuccessful());

        emediplan.trim();
        final var serializedEmediplan = emediplan.toChTransmissionFormat();
        assertNotNull(serializedEmediplan);
    }

    @Test
    public void convertEPrescriptionAndValidate() throws IOException {
        final var ePrescription = EPrescription.fromChTransmissionFormat(CHMED16A_PRE_CH_TRANSMISSION_FORMAT_EXAMPLE);
        assertNotNull(ePrescription);
        //the ePrescription example from eRezept site is actually from the original CHMED16A specs, so it is missing
        //some stuff from the revisions that we should add now
        ePrescription.setRevision(EPrescription.LAST_SUPPORTED_REVISION);
        ePrescription.setHealthcarePerson(new ChMed16AHealthcarePerson(
                ePrescription.getAuthor(),
                "John",
                "Doe",
                ePrescription.getZsr()
        ));
        final var orgAddress = new ChMed16AExtendedPostalAddress();
        orgAddress.setPostalCode("12345");
        orgAddress.setStreet("1 Rue de la Barbe-à-papa");
        orgAddress.setCity("Fausseville");
        ePrescription.setHealthcareOrganization(new ChMed16AHealthcareOrganization(
            "Example Cabinet",
                null,
                orgAddress,
                null,
                null,
                null
        ));
        final var posology = new ChMed16APosology();
        posology.setDailyDoses(new ChMed16ADailyDosage(0.0, 1.0, 0.0, 1.0));
        ePrescription.getMedicaments().getFirst().getPosology().add(posology);
        ePrescription.getMedicaments().getFirst().setUnit(CdTyp9.TABLET);
        ePrescription.getPatient().setIds(List.of(new ChMed16APatientId(PATIENT_ID_TYPE_INSURANCE_CARD, "80756012345678912345")));
        assertTrue(ePrescription.validate().isSuccessful());

        final var converter = new EPrescriptionConverter(
                (type, id) -> {
                    final var med = new ChEmedEprMedication();
                    med.setCode(new CodeableConcept().setText("IBUPROFEN"));
                    return med;
                },
                medReq -> new ChEmedExtTreatmentPlan(UUID.randomUUID(), UUID.randomUUID())
        );
        final var pre = converter.toChEmedEprPrescription(ePrescription, LanguageCode.ENGLISH, null);

        //validate the resulting PRE
        final var validator = new ChEmedEprHapiValidator(FhirContext.forR4Cached());
        assertTrue(validator.validateDocumentBundle(pre, EmedDocumentType.PRE.getProfile()).isSuccessful());
    }
}
