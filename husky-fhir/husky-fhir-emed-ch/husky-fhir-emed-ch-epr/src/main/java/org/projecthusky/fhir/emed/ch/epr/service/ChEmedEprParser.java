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
package org.projecthusky.fhir.emed.ch.epr.service;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.FhirVersionEnum;
import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.rest.api.EncodingEnum;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.Bundle;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.resource.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.common.resource.ChEmedOrganization;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocument;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedication;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPractitioner;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPractitionerRole;
import org.projecthusky.fhir.emed.ch.epr.resource.dis.ChEmedEprCompositionDis;
import org.projecthusky.fhir.emed.ch.epr.resource.dis.ChEmedEprDocumentDis;
import org.projecthusky.fhir.emed.ch.epr.resource.dis.ChEmedEprMedicationDis;
import org.projecthusky.fhir.emed.ch.epr.resource.dis.ChEmedEprMedicationDispenseDis;
import org.projecthusky.fhir.emed.ch.epr.resource.mtp.ChEmedEprCompositionMtp;
import org.projecthusky.fhir.emed.ch.epr.resource.mtp.ChEmedEprDocumentMtp;
import org.projecthusky.fhir.emed.ch.epr.resource.mtp.ChEmedEprMedicationStatementMtp;
import org.projecthusky.fhir.emed.ch.epr.resource.padv.ChEmedEprCompositionPadv;
import org.projecthusky.fhir.emed.ch.epr.resource.padv.ChEmedEprDocumentPadv;
import org.projecthusky.fhir.emed.ch.epr.resource.padv.ChEmedEprObservationPadv;
import org.projecthusky.fhir.emed.ch.epr.resource.pml.*;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprCompositionPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprMedicationStatementPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprCompositionPre;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprDocumentPre;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprMedicationRequestPre;
import org.projecthusky.fhir.emed.ch.epr.validator.ChEmedEprValidator;

import javax.annotation.concurrent.ThreadSafe;
import java.util.ArrayList;

/**
 * A parser for the FHIR CH-EMED-EPR IG resources. It can both serialize and parse (deserialize) documents.
 *
 * @author Quentin Ligier
 * @implNote Parsers are cheap to create and may not be thread-safe. They're created on-the-fly for each operation.
 **/
@ThreadSafe
public class ChEmedEprParser {

    /**
     * The FHIR context (R4).
     */
    private final FhirContext context;

    /**
     * Constructor.
     *
     * @param fhirR4Context The non-null FHIR context (R4).
     */
    public ChEmedEprParser(@Nullable final FhirContext fhirR4Context) {
        if (fhirR4Context == null || fhirR4Context.getVersion().getVersion() != FhirVersionEnum.R4) {
            throw new IllegalArgumentException("ChEmedEprParser requires a FHIR R4 context");
        }
        this.context = fhirR4Context;
    }

    /**
     * Parses the given string (JSON or XML) as a CH-EMED-EPR document Bundle.
     * <p>
     * The resource shall be validated before, with {@link ChEmedEprValidator}.
     *
     * @param resource The document Bundle representation as XML, JSON or RDF.
     * @param type     The type of eMed document.
     */
    public <T extends ChEmedEprDocument> T parse(final String resource,
                                                 final EmedDocumentType type) {
        final EncodingEnum encoding = EncodingEnum.detectEncodingNoDefault(resource);
        if (encoding == null) {
            throw new InvalidEmedContentException("Unable to determine the FHIR resource encoding");
        }
        final var parsed = this.getParser(encoding, type).parseResource(resource);
        if (parsed.getClass().getSuperclass() == ChEmedEprDocument.class) {
            @SuppressWarnings("unchecked") // We've just checked it
            final var document = (T) parsed;
            return document;
        }
        throw new InvalidEmedContentException("The given resource isn't a CH-EMED Document");
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
     * and {@link org.projecthusky.fhir.emed.ch.epr.resource} over HAPI's resources).
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
        if (type == null) {
            return parser;
        }
        final var preferTypes = new ArrayList<Class<? extends IBaseResource>>(10);
        preferTypes.add(ChCorePatientEpr.class);
        preferTypes.add(ChEmedOrganization.class);
        preferTypes.add(ChEmedEprPractitioner.class);
        preferTypes.add(ChEmedEprPractitionerRole.class);
        preferTypes.add(ChEmedEprMedication.class);
        switch (type) {
            case MTP -> {
                preferTypes.add(ChEmedEprDocumentMtp.class);
                preferTypes.add(ChEmedEprCompositionMtp.class);
                preferTypes.add(ChEmedEprMedicationStatementMtp.class);
            }
            case PRE -> {
                preferTypes.add(ChEmedEprDocumentPre.class);
                preferTypes.add(ChEmedEprCompositionPre.class);
                preferTypes.add(ChEmedEprMedicationRequestPre.class);
            }
            case DIS -> {
                preferTypes.add(ChEmedEprDocumentDis.class);
                preferTypes.add(ChEmedEprCompositionDis.class);
                preferTypes.add(ChEmedEprMedicationDispenseDis.class);
                preferTypes.add(ChEmedEprMedicationDis.class);
            }
            case PADV -> {
                preferTypes.add(ChEmedEprDocumentPadv.class);
                preferTypes.add(ChEmedEprCompositionPadv.class);
                preferTypes.add(ChEmedEprObservationPadv.class);
            }
            case PML -> {
                preferTypes.add(ChEmedEprDocumentPml.class);
                preferTypes.add(ChEmedEprCompositionPml.class);
                preferTypes.add(ChEmedEprMedicationStatementPml.class);
                preferTypes.add(ChEmedEprMedicationRequestPml.class);
                preferTypes.add(ChEmedEprMedicationDispensePml.class);
                preferTypes.add(ChEmedEprObservationPml.class);
            }
            case PMLC -> {
                preferTypes.add(ChEmedEprDocumentPmlc.class);
                preferTypes.add(ChEmedEprCompositionPmlc.class);
                preferTypes.add(ChEmedEprMedicationStatementPmlc.class);
            }
        }
        parser.setPreferTypes(preferTypes);
        return parser;
    }
}
