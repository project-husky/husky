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
package org.projecthusky.fhir.emed.ch.pmp.service;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.FhirVersionEnum;
import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.rest.api.EncodingEnum;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Bundle;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;

/**
 * A parser for the FHIR CH-EMED-EPR IG resources. It can both serialize and parse (deserialize) documents.
 *
 * @author Quentin Ligier
 **/
public class DocumentParser {

    private final FhirContext context;

    public DocumentParser(final FhirContext fhirR4Context) {
        if (fhirR4Context == null || fhirR4Context.getVersion().getVersion() != FhirVersionEnum.R4) {
            throw new IllegalArgumentException("DocumentParser requires a FHIR R4 context");
        }
        this.context = fhirR4Context;
    }

    /**
     * Parses the given string (JSON or XML) as a CH-EMED-EPR document Bundle.
     * <p>
     * The resource shall be validated before, with
     * {@link org.projecthusky.fhir.emed.ch.pmp.validator.ChEmedPmpValidator}.
     *
     * @param resource The document Bundle representation as XML, JSON or RDF.
     * @param type
     */
    public void parse(final String resource,
                      final EmedDocumentType type) {
    }

    /**
     * Encodes the CH-EMED-EPR document Bundle to a string, in either XML, JSON, NDJSON or RDF format. The parser will
     * output in condensed form, with no newlines or indenting; the resulting string is smaller.
     *
     * @param documentBundle The document Bundle to serialize.
     * @param encoding       The desired encoding.
     * @return the serialized document.
     */
    public String serialize(final Bundle documentBundle,
                            final EncodingEnum encoding) {
        return this.getParser(encoding, null).encodeResourceToString(documentBundle);
    }

    /**
     * Encodes the CH-EMED-EPR document Bundle to a string, in either XML, JSON, NDJSON or RDF format. The parser will
     * output in pretty-printed form, with newlines and indenting; the resulting string is larger but more easily human-
     * readable.
     *
     * @param documentBundle The document Bundle to serialize.
     * @param encoding       The desired encoding.
     * @return the serialized document.
     */
    public String serializePrettyPrint(final Bundle documentBundle,
                                       final EncodingEnum encoding) {
        return this.getParser(encoding, null).setPrettyPrint(true).encodeResourceToString(documentBundle);
    }

    /**
     * Creates a FHIR parser for the given encoding. If the document type is given, it'll also configure the preferred
     * types for this document type (i.e. to use resources from {@link org.projecthusky.fhir.emed.ch.common.resource}
     * and {@link org.projecthusky.fhir.emed.ch.pmp.resource} over HAPI's resources).
     *
     * @param encoding The encoding to use (XML, JSON, NDJSON or RDF).
     * @param type     The document type or {@code null} to disable the preferred types (not needed for serialization).
     * @return the created parser.
     */
    protected IParser getParser(final EncodingEnum encoding,
                                @Nullable final EmedDocumentType type) {
        final IParser parser = switch (encoding) {
            case JSON -> this.context.newJsonParser();
            case XML -> this.context.newXmlParser();
            case NDJSON -> this.context.newNDJsonParser();
            case RDF -> this.context.newRDFParser();
        };
        //parser.setPreferTypes();
        return parser;
    }
}
