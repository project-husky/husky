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
package org.projecthusky.fhir.vacd.ch.common.enums;

import java.util.Objects;

import org.hl7.fhir.r4.model.Coding;

/**
 * 
 */
public enum ChVacdDocumentType {
	ADMIN("ADMIN", //
			new Coding("http://snomed.info/sct","41000179103","Immunization record (record artifact)"), // Type
			new Coding("http://snomed.info/sct","184216000","Patient record type (record artifact)"), // Class
			new Coding("urn:oid:2.16.756.5.30.1.127.3.10.10", "urn:che:epr:ch-vacd:immunization-administration:2022", "CH VACD Immunization Administration"), // Format
			"http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-document-immunization-administration"), //
	RECORD("RECORD", //
			new Coding("http://snomed.info/sct","41000179103","Immunization record (record artifact)"), //Type
			new Coding("http://snomed.info/sct","184216000","Patient record type (record artifact)"), //Class
			new Coding("urn:oid:2.16.756.5.30.1.127.3.10.10", "urn:che:epr:ch-vacd:vaccination-record:2022", "CH VACD Vaccination Record"), //Format
			"http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-document-vaccination-record");

	/**
	 * The name of the eMedication document type.
	 */
	private final String name;

	/**
	 * The equivalent type code.
	 */
	private final Coding typeCode;

	/**
	 * The equivalent class code.
	 */
	private final Coding classCode;

	/**
	 * The format code in the IHE Format system (1.3.6.1.4.1.19376.1.2.3).
	 */
	private final Coding formatCode;

	/**
	 * The FHIR profile URN.
	 */
	private final String profile;

	/**
	 * Constructor for the ch vacd document type.
	 * 
	 * @param name
	 *            the name of the document type
	 * @param typeCode
	 *            the equivalent type code
	 * @param classCode
	 *            the equivalent class code
	 * @param formatCode
	 *            the format code in the IHE Format system (
	 * @param profile
	 *            the FHIR profile URN
	 */
	ChVacdDocumentType(final String name, final Coding typeCode, final Coding classCode,
			final Coding formatCode, final String profile) {
		this.name = Objects.requireNonNull(name);
		this.typeCode = Objects.requireNonNull(typeCode);
		this.classCode = Objects.requireNonNull(classCode);
		this.formatCode = Objects.requireNonNull(formatCode);
		this.profile = Objects.requireNonNull(profile);
	}

	public String getName() {
		return name;
	}

	public Coding getTypeCode() {
		return typeCode;
	}

	public Coding getClassCode() {
		return classCode;
	}

	public Coding getFormatCode() {
		return formatCode;
	}

	public String getProfile() {
		return profile;
	}

}
