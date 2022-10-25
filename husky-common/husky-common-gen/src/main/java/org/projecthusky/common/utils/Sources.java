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
package org.projecthusky.common.utils;

import org.w3c.dom.Document;

import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Utilities to create {@link Source}s.
 *
 * @author Quentin Ligier
 **/
public class Sources {

    /**
     * This class is not instantiable.
     */
    private Sources() {
    }

    /**
     * Creates a {@link Source} from a {@link File}.
     *
     * @param file The file.
     * @return the source.
     */
    public static Source fromFile(final File file) {
        return new StreamSource(file);
    }

    /**
     * Creates a {@link Source} from an input stream.
     *
     * @param inputStream The input stream.
     * @return the source.
     */
    public static Source fromInputStream(final InputStream inputStream) {
        return new StreamSource(inputStream);
    }

    /**
     * Creates a {@link Source} from a byte array.
     *
     * @param bytes The byte array.
     * @return the source.
     */
    public static Source fromByteArray(final byte[] bytes) {
        return fromInputStream(new ByteArrayInputStream(bytes));
    }

    /**
     * Creates a {@link Source} from a UTF-8 string.
     *
     * @param string The UTF-8 string.
     * @return the source.
     */
    public static Source fromString(final String string) {
        return fromByteArray(string.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Creates a {@link Source} from a DOM document.
     *
     * @param document The DOM document.
     * @return the source.
     */
    public static Source fromDomDocument(final Document document) {
        return new DOMSource(document);
    }
}
