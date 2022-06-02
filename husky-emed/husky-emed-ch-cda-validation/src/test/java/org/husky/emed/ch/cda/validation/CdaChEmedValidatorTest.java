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
package org.husky.emed.ch.cda.validation;

import org.husky.emed.ch.enums.CceDocumentType;
import org.husky.emed.ch.errors.InvalidEmedContentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.xml.sax.SAXException;

import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Tests for the {@link CdaChEmedValidator} class.
 *
 * <p>It is excluded from CI runners because it requires too much memory.
 *
 * @author Quentin Ligier
 **/
@DisabledIfEnvironmentVariable(named = "CI", matches = "true")
class CdaChEmedValidatorTest {

    private final CdaChEmedValidator validator;

    public CdaChEmedValidatorTest() throws XPathExpressionException, IOException, SAXException {
        this.validator = new CdaChEmedValidator();
        this.validator.prewarm();
    }

    public static Stream<Arguments> validSamplesProvider() {
        return Stream.of(
                arguments("/ehealthsuisse/1-1-MedicationTreatmentPlan.xml", CceDocumentType.MTP),
                arguments("/ehealthsuisse/2-6-MedicationPrescription.xml", CceDocumentType.PRE),
                arguments("/ehealthsuisse/2-4-MedicationDispense.xml", CceDocumentType.DIS),
                arguments("/ehealthsuisse/2-2-PharmaceuticalAdvice.xml", CceDocumentType.PADV),
                arguments("/ehealthsuisse/2-1-MedicationList.xml", CceDocumentType.PML),
                arguments("/ehealthsuisse/2-7-MedicationCard.xml", CceDocumentType.PMLC)
        );
    }

    public static Stream<Arguments> invalidSamplesProvider() {
        return Stream.of(
                arguments("/PlanDeTraitement/1 - CDA-MTP-1-1.xml", CceDocumentType.MTP),
                arguments("/PlanDeTraitement/1 - CDA-PRE-1.xml", CceDocumentType.PRE),
                arguments("/PlanDeTraitement/2 - CDA-DIS-1.xml", CceDocumentType.DIS),
                arguments("/PlanDeTraitement/5 - CDA-PADV-1.xml", CceDocumentType.PADV),
                arguments("/PlanDeTraitement/12 - CDA-PML-final.xml", CceDocumentType.PML)
        );
    }

    @ParameterizedTest(name = "{1}")
    @DisplayName("Ensure valid documents are accepted")
    @MethodSource("validSamplesProvider")
    void testValidSamples(final String filePath,
                          final CceDocumentType type) {
        assertDoesNotThrow(() -> this.validator.validate(getClass().getResourceAsStream(filePath), type));
    }

    @ParameterizedTest(name = "{1}")
    @DisplayName("Ensure valid documents with wrong type are rejected")
    @MethodSource("validSamplesProvider")
    void testInvalidType(final String filePath,
                         final CceDocumentType type) {
        final var wrongType = Arrays.stream(CceDocumentType.values())
                .filter(thisType -> thisType != type)
                .skip(new Random().nextInt(5))
                .findAny()
                .get();
        assertThrows(InvalidEmedContentException.class,
                () -> this.validator.validate(getClass().getResourceAsStream(filePath), wrongType));

    }

    @ParameterizedTest(name = "{1}")
    @DisplayName("Ensure invalid documents are rejected")
    @MethodSource("invalidSamplesProvider")
    void testInvalidSamples(final String filePath,
                            final CceDocumentType type) {
        assertThrows(InvalidEmedContentException.class,
                () -> this.validator.validate(getClass().getResourceAsStream(filePath), type));
    }

    @Test
    @DisplayName("Ensure invalid PDF is rejected")
    void testInvalidPdf() {
        assertThrows(InvalidEmedContentException.class, () -> this.validator.validate(getClass().getResourceAsStream(
                "/invalid-pdf.xml"), CceDocumentType.MTP));
    }

    @Test
    @DisplayName("Ensure concurrent validations are not failing")
    void testThreadSafety() {
        final int nbOfThreads = Runtime.getRuntime().availableProcessors();
        final var executor = Executors.newFixedThreadPool(nbOfThreads);
        final var service = new ExecutorCompletionService<Boolean>(executor);
        final List<Future<Boolean>> futures = new ArrayList<>(3);

        try {
            // Launch the threads
            for (int i = 0; i < nbOfThreads; ++i) {
                futures.add(service.submit(() -> {
                    try {
                        this.validator.validate(getClass().getResourceAsStream("/ehealthsuisse/1-1" +
                             "-MedicationTreatmentPlan.xml"), CceDocumentType.MTP);
                        return true;
                    } catch (final Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                }));
            }
            // And check the outputs
            for (int i = 0; i < nbOfThreads; ++i) {
                try {
                    final Boolean bool = service.take().get();
                    assertTrue(bool);
                } catch (final ExecutionException | InterruptedException e) {
                    fail();
                }
            }
        } finally {
            for (final var future : futures) {
                future.cancel(true);
            }
        }
    }
}
