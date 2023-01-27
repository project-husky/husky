package org.projecthusky.fhir.emed.ch.epr.narrative.services;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.projecthusky.common.enums.ValueSetEnumInterface;
import org.projecthusky.fhir.emed.ch.epr.enums.RouteOfAdministrationAmbu;
import org.projecthusky.fhir.emed.ch.epr.enums.TimingEventAmbu;
import org.projecthusky.fhir.emed.ch.epr.narrative.enums.NarrativeLanguage;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Tests of the {@link ValueSetEnumNarrativeForPatientService} class.
 *
 * @author Ronaldo Loureiro
 */
class ValueSetEnumNarrativeForPatientServiceTest {

    ValueSetEnumNarrativeForPatientService valueSetEnumNarrativeForPatientService;

    ValueSetEnumNarrativeForPatientServiceTest() throws IOException {
        this.valueSetEnumNarrativeForPatientService = new ValueSetEnumNarrativeForPatientService();
    }

    @Test
    void testValueSetEnumNarrativeIfNonEmptyValues() {
        final ValueSetEnumInterface[] valueSetEnum = Stream.of(
                RouteOfAdministrationAmbu.values(),
                TimingEventAmbu.values())
                .flatMap(Stream::of)
                .toArray(ValueSetEnumInterface[]::new);

        for (final var enumm : valueSetEnum) {
            for (final var narrativeLanguage: NarrativeLanguage.values()) {
                assertNotEquals(this.valueSetEnumNarrativeForPatientService.getMessage(enumm, narrativeLanguage),
                        StringUtils.EMPTY);
            }
        }
    }
}
