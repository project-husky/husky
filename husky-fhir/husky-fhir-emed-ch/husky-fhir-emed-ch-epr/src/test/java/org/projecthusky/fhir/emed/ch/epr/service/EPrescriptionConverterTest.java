package org.projecthusky.fhir.emed.ch.epr.service;

import ca.uhn.fhir.context.FhirContext;
import org.junit.jupiter.api.Test;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.CdTyp9;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.MedicamentIdType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.EPrescription;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.enums.ChMed16AGender;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprCompositionPre;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprDocumentPre;
import org.projecthusky.fhir.emed.ch.epr.service.converter.emediplan.EPrescriptionConverter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
//TODO add a test with non-structured dosage?
//TODO add a test with a prescription with several med requests?
public class EPrescriptionConverterTest {
    @Test
    void convertAndValidatePrescription() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-DocumentPreParacetamolAxapharmCARAPMP004.xml").readAllBytes());
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
}
