/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.emed.ch.cda;

import org.projecthusky.common.utils.xml.XmlUnmarshaller;
import org.projecthusky.common.hl7cdar2.POCDMT000040ClinicalDocument;
import org.xml.sax.InputSource;

import javax.xml.parsers.ParserConfigurationException;
import java.util.Optional;

/**
 * Helpers to run the tests.
 *
 * @author Quentin Ligier
 */
public class TestUtils {

    /**
     * Loads a CDA-CH-EMED document from a resource path.
     */
    public static POCDMT000040ClinicalDocument loadCdaChEmedResource(final String resourcePath) throws ParserConfigurationException {
        final var is = Optional.ofNullable(TestUtils.class.getClassLoader().getResourceAsStream(resourcePath))
                        .orElseThrow(() -> new RuntimeException("The resource path is invalid"));

        return XmlUnmarshaller.unmarshallAsType(new InputSource(is), POCDMT000040ClinicalDocument.class);
    }
}
