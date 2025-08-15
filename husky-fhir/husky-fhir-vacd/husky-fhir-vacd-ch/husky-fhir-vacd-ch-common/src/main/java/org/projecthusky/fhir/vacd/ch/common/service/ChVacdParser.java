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
package org.projecthusky.fhir.vacd.ch.common.service;

import java.io.InputStream;
import java.util.ArrayList;

import javax.annotation.concurrent.ThreadSafe;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.projecthusky.fhir.core.ch.resource.r4.ChCoreOrganization;
import org.projecthusky.fhir.core.ch.resource.r4.ChCorePatient;
import org.projecthusky.fhir.core.ch.resource.r4.ChCorePractitioner;
import org.projecthusky.fhir.core.ch.resource.r4.ChCorePractitionerRole;
import org.projecthusky.fhir.vacd.ch.common.enums.ChVacdDocumentType;
import org.projecthusky.fhir.vacd.ch.common.exceptions.InvalidVacdContentException;
import org.projecthusky.fhir.vacd.ch.common.resource.r4.ChVacdAbstractDocument;
import org.projecthusky.fhir.vacd.ch.common.resource.r4.ChVacdAllergyIntolerance;
import org.projecthusky.fhir.vacd.ch.common.resource.r4.ChVacdBasicImmunization;
import org.projecthusky.fhir.vacd.ch.common.resource.r4.ChVacdImmunization;
import org.projecthusky.fhir.vacd.ch.common.resource.r4.ChVacdImmunizationAdministrationComposition;
import org.projecthusky.fhir.vacd.ch.common.resource.r4.ChVacdImmunizationAdministrationDocument;
import org.projecthusky.fhir.vacd.ch.common.resource.r4.ChVacdLaboratoryAndSerology;
import org.projecthusky.fhir.vacd.ch.common.resource.r4.ChVacdMedicalProblem;
import org.projecthusky.fhir.vacd.ch.common.resource.r4.ChVacdMedicationForImmunization;
import org.projecthusky.fhir.vacd.ch.common.resource.r4.ChVacdPastIllness;
import org.projecthusky.fhir.vacd.ch.common.resource.r4.ChVacdVaccinationRecordComposition;
import org.projecthusky.fhir.vacd.ch.common.resource.r4.ChVacdVaccinationRecordDocument;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.FhirVersionEnum;
import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.rest.api.EncodingEnum;

/**
 * Parser for CH-VACD documents.
 */
@ThreadSafe
public class ChVacdParser {

	private final FhirContext context;

	/**
	 * Constructor for the parser.
	 */
	public ChVacdParser(@Nullable final FhirContext fhirR4Context) {
		if (fhirR4Context == null
				|| fhirR4Context.getVersion().getVersion() != FhirVersionEnum.R4) {
			throw new IllegalArgumentException("ChEmedEprParser requires a FHIR R4 context");
		}
		this.context = fhirR4Context;
	}

	/**
	 * Parses the given resource as a CH-VACD document.
	 *
	 * @param resource
	 *            The resource to parse.
	 * @param type
	 *            The document type to use for parsing.
	 * @return the parsed document.
	 * @throws InvalidVacdContentException
	 *             if the content is invalid or not a CH-VACD document.
	 */
	public <T extends ChVacdAbstractDocument> T parse(final String resource,
			final ChVacdDocumentType type) {
		final EncodingEnum encoding = EncodingEnum.detectEncodingNoDefault(resource);
		if (encoding == null) {
			throw new InvalidVacdContentException("Unable to determine the FHIR resource encoding");
		}
		final var parsed = this.getParser(encoding, type).parseResource(resource);
		if (parsed.getClass().getSuperclass() == ChVacdAbstractDocument.class) {
			@SuppressWarnings("unchecked") // We've just checked it
			final var document = (T) parsed;
			postHapiParsing(document);
			return document;
		}
		throw new InvalidVacdContentException("The given resource isn't a CH-EMED Document");
	}
	
//	public <T extends ChVacdAbstractDocument> T parse(final InputStream resource, final ChVacdDocumentType type) {
//		
//		final EncodingEnum encoding = EncodingEnum.detectEncoding(resource);
//	}
	
	private void postHapiParsing(ChVacdAbstractDocument document) {
		
	}

	/**
	 * Creates a FHIR parser for the given encoding. If the document type is
	 * given, it'll also configure the preferred types for this document type
	 * (i.e. to use resources from
	 * {@link org.projecthusky.fhir.emed.ch.common.resource} and
	 * {@link org.projecthusky.fhir.emed.ch.epr.resource} over HAPI's
	 * resources).
	 *
	 * @param encoding
	 *            The encoding to use (XML, JSON, NDJSON or RDF).
	 * @param type
	 *            The document type or {@code null} to disable the preferred
	 *            types (not needed for serialization).
	 * @return the created parser.
	 */
	protected IParser getParser(final EncodingEnum encoding,
			@Nullable final ChVacdDocumentType type) {
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
		preferTypes.add(ChCorePatient.class);
		preferTypes.add(ChCoreOrganization.class);
		preferTypes.add(ChCorePractitioner.class);
		preferTypes.add(ChCorePractitionerRole.class);
		preferTypes.add(ChVacdMedicationForImmunization.class);

		preferTypes.add(ChVacdMedicationForImmunization.class);
		preferTypes.add(ChVacdAllergyIntolerance.class);
		preferTypes.add(ChVacdBasicImmunization.class);
		preferTypes.add(ChVacdImmunization.class);
		preferTypes.add(ChVacdLaboratoryAndSerology.class);
		preferTypes.add(ChVacdMedicalProblem.class);
		preferTypes.add(ChVacdPastIllness.class);

		switch (type) {
		case ADMIN -> {
			preferTypes.add(ChVacdImmunizationAdministrationDocument.class);
			preferTypes.add(ChVacdImmunizationAdministrationComposition.class);
			break;
		}
		case RECORD -> {
			preferTypes.add(ChVacdVaccinationRecordDocument.class);
			preferTypes.add(ChVacdVaccinationRecordComposition.class);
			break;
		}

		}
		parser.setPreferTypes(preferTypes);
		return parser;
	}

}
