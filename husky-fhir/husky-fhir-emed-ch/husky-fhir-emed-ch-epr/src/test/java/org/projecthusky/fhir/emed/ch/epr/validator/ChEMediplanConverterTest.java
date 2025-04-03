package org.projecthusky.fhir.emed.ch.epr.validator;

import ca.uhn.fhir.context.FhirContext;
import org.junit.jupiter.api.Test;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanPatient;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanPatientId;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanPostalAddress;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.Gender;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.PatientIdType;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprCompositionPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.projecthusky.fhir.emed.ch.epr.service.ChEmedEprParser;
import org.projecthusky.fhir.emed.ch.epr.service.EMediplanConverter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ChEMediplanConverterTest {
    @Test
    void convertAndValidateMedicationCard() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-2-7-MedicationCard-UUIDfullUrl.xml").readAllBytes());
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var document = parser.parse(xml, EmedDocumentType.PMLC);
        assertInstanceOf(ChEmedEprDocumentPmlc.class, document);
        final var pmlcDocument = (ChEmedEprDocumentPmlc) document;
        assertNotNull(pmlcDocument.resolveComposition());
        assertInstanceOf(ChEmedEprCompositionPmlc.class, pmlcDocument.resolveComposition());

        final var emediplan = EMediplanConverter.toEMediplan(pmlcDocument);
        assertNotNull(emediplan);

        final var validationResult = emediplan.validate();
        assertNotNull(validationResult);
        assertTrue(validationResult.isSuccessful());

        emediplan.trim();
        final var serializedEmediplan = emediplan.toChTransmissionFormat();
        assertNotNull(serializedEmediplan);
    }

    /**
     * This test tries to verify the validation of all the {@link EMediplanPatient} fields, except the extensions and
     * the patient medical data.
     */
    @Test
    void testPatientValidation() {
        var patient = createValidPatient();
        var result = patient.validate();
        assertTrue(result.isSuccessful());
        assertTrue(result.getIssues().isEmpty());

        // remove first name and expect fail
        patient.setFirstName("");
        result = patient.validate();
        assertFalse(result.isSuccessful());

        // restore, remove last name and expect fail
        patient = createValidPatient();
        patient.setLastName("");
        result = patient.validate();
        assertFalse(result.isSuccessful());

        // restore, remove birthdate and expect failure
        patient = createValidPatient();
        patient.setBirthDate(null);
        result = patient.validate();
        assertFalse(result.isSuccessful());

        // restore, remove gender and expect failure
        patient = createValidPatient();
        patient.setGender(null);
        result = patient.validate();
        assertFalse(result.isSuccessful());

        // restore, remove address and expect success
        patient = createValidPatient();
        patient.setAddress(null);
        result = patient.validate();
        assertTrue(result.isSuccessful());

        // add address with bad country code, expect success but one warning
        patient.setAddress(new EMediplanPostalAddress(null, null, null, "55"));
        result = patient.validate();
        assertTrue(result.isSuccessful());
        assertEquals(1, result.getWarnings().size());

        // set address to more than 2 characteres, expect one warning
        patient.setAddress(new EMediplanPostalAddress(null, null, null, "ABC"));
        result = patient.validate();
        assertTrue(result.isSuccessful());
        assertEquals(1, result.getWarnings().size());

        // restore, remove language code, expect success
        patient = createValidPatient();
        patient.setLanguageCode("");
        result = patient.validate();
        assertTrue(result.isSuccessful());

        // set language code to numeric code, expect warning
        patient.setLanguageCode("12");
        result = patient.validate();
        assertTrue(result.isSuccessful());
        assertEquals(1, result.getWarnings().size());

        // set language code to more than 2 letters, expect warning
        patient.setLanguageCode("abc");
        result = patient.validate();
        assertTrue(result.isSuccessful());
        assertEquals(1, result.getWarnings().size());

        // restore and empty ids, expet failure
        patient = createValidPatient();
        patient.setIds(List.of());
        result = patient.validate();
        assertFalse(result.isSuccessful());

        // set id with without type, expect failure
        patient.setIds(List.of(new EMediplanPatientId(null, "fakesystem", "fakeid")));
        result = patient.validate();
        assertFalse(result.isSuccessful());

        // set id of type insurance card number with a system, expect warning
        patient.setIds(List.of(new EMediplanPatientId(PatientIdType.INSURANCE_CARD_NUMBER, "fakesystem", "fakeid")));
        result = patient.validate();
        assertTrue(result.isSuccessful());
        assertEquals(1, result.getWarnings().size());

        // set id of type insurance card number without a system and without a value, exepct failure
        patient.setIds(List.of(new EMediplanPatientId(PatientIdType.INSURANCE_CARD_NUMBER, "", "")));
        result = patient.validate();
        assertFalse(result.isSuccessful());

        // set id of local type with no system, expect failure
        patient.setIds(List.of(new EMediplanPatientId(PatientIdType.LOCAL_PID, "", "fakeid")));
        result = patient.validate();
        assertFalse(result.isSuccessful());

        // set id of local type with system but not value, expect failure
        patient.setIds(List.of(new EMediplanPatientId(PatientIdType.LOCAL_PID, "myfakesystem", "")));
        result = patient.validate();
        assertFalse(result.isSuccessful());

        // restore, add a list of valid phones, expect no issues
        patient = createValidPatient();
        patient.setPhones(List.of("993993993", "+34994994994", "+34 44 44 44"));
        result = patient.validate();
        assertTrue(result.isSuccessful());
        assertTrue(result.getIssues().isEmpty());

        // set 2 bad phone numbers, expect two warnings
        patient.setPhones(List.of("444 + 4444", "asd"));
        result = patient.validate();
        assertTrue(result.isSuccessful());
        assertEquals(2, result.getIssues().size());

        // restore set a list of invalid email addresses and expect a warning per email address
        patient = createValidPatient();
        patient.setEmails(List.of(
                ".bademail@fakedomain.com",
                "bademail.@fakedomain.com",
                "bademail@fakedomain.com.",
                "bademail@.com",
                "abc.example.com", // no @ character
                "a@b@c@example.com", // more than one @
                "a\"b(c)d,e:f;g<h>i[j\\k]l@example.com", // none of the special characters in this local-part are allowed outside quotation marks
                "just\"not\"right@example.com", // quoted strings must be dot separated or be the only element of the local part
                "this is\"not\\allowed@example.com", //  spaces, quotes and backslashes may only exist within quoted strings preceded by a backslash
                "this\\ still\\\"not\\\\allowed@example.com", // even if escaped (preceded by a backslash), spaces, quotes, and backslashes must still be contained by quotes
                "1234567890123456789012345678901234567890123456789012345678901234+x@example.com", // local-part is longer than 64 characters
                "i.like.underscores@but_they_are_not_allowed_in_this_part" // underscore is not allowed in domain part
        ));
        result = patient.validate();
        assertTrue(result.isSuccessful());
        assertEquals(patient.getEmails().size(), result.getWarnings().size());
    }

    private EMediplanPatient createValidPatient() {
        return new EMediplanPatient(
                "John",
                "Doe",
                LocalDate.of(1958, 2, 3),
                Gender.MALE,
                new EMediplanPostalAddress("Elm Street", "1203", "Springfield", "US"),
                "en",
                List.of(new EMediplanPatientId(PatientIdType.LOCAL_PID, "http://myfakesystem", "myfakeid")),
                null,
                null,
                List.of(),
                List.of("john.doe@myfakeprovider.com",
                        "用户名@领域.电脑",
                        "éléonore@example.com",
                        "δοκιμή@παράδειγμα.δοκιμή",
                        "二ノ宮@黒川.日本",
                        "медведь@с-балалайкой.рф",
                        "x@example.com",
                        "long.email-address-with-hyphens@and.subdomains.example.com",
                        "name/surname@example.com",
                        "user-@example.org",
                        "_john.doe@myfakeprovider.com"
                )
        );
    }
}
