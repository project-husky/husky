/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.xua.validation;

import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.communication.ch.enums.Role;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.opensaml.core.config.InitializationService;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.Unmarshaller;
import org.opensaml.core.xml.util.XMLObjectSupport;
import org.opensaml.saml.common.assertion.ValidationResult;
import org.opensaml.saml.saml2.core.Assertion;
import org.w3c.dom.Element;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.opensaml.saml.saml2.assertion.SAML2AssertionValidationParameters.CLOCK_SKEW;

@Disabled
class ChEprAssertionValidatorTest {

    @MonotonicNonNull
    private static ChEprAssertionValidator VALIDATOR = null;
    @MonotonicNonNull
    private static Unmarshaller UNMARSHALLER = null;

    private static final Map<String, @Nullable Object> VALIDATION_PARAMS = new HashMap<>();

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        // Initialize the library
        InitializationService.initialize();
        VALIDATOR = new ChEprAssertionValidator(Duration.ofSeconds(3));
        UNMARSHALLER = XMLObjectSupport.getUnmarshaller(Assertion.TYPE_NAME);
        VALIDATION_PARAMS.put(CLOCK_SKEW, Duration.ofDays(3650));
    }

    @Test
    void testValidateHcp() throws Exception {
        final var assertion = this.unmarshal("assertion-hcp.xml");
        final var result = VALIDATOR.validate(assertion, VALIDATION_PARAMS);
        assertNotNull(result);
        assertEquals(ValidationResult.VALID, result.getResult());
        assertEquals(Role.HEALTHCARE_PROFESSIONAL, result.getRole());
        assertEquals("2000000090092", result.getResponsibleSubjectId());
        assertEquals(null, result.getResponsibleSubjectId());
    }

    private Assertion unmarshal(final String fileName) throws Exception {
        Element element = Objects.requireNonNull(XMLObjectProviderRegistrySupport.getParserPool())
                .parse(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("xua/" + fileName)))
                .getDocumentElement();
        return (Assertion) UNMARSHALLER.unmarshall(element);
    }

    /**
     * TODO:
     * test notBefore, notOnOrAfter, notOnOrAfter <= notBefore
     */
}