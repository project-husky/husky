package org.ehealth_connector.emed.cda;

import org.ehealth_connector.common.utils.xml.XmlUnmarshaller;
import org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040ClinicalDocument;
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
