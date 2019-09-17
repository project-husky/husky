/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.fhir.structures.gen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.UUID;

import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.mdht.Identificator;
import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.Identifier;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @version 1.0
 * @since Jan 2, 2018 11:32:48 AM
 *
 */
public class FhirCommonTest {

	private String testOidString;
	private String testUuid;
	private String testSystemOid;
	private String testDisplayName;
	private Identificator testIdentificator;
	private Code testCode;

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testSystemOid = "1.2.3.4.5";
		testOidString = "2.16.840.1.113883.3.72.5.9.2";
		testDisplayName = "my display name";
		testUuid = UUID.randomUUID().toString();

		testIdentificator = new Identificator(testSystemOid, testOidString);

		testCode = new Code(testSystemOid, testOidString);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#addDocManifestContent(org.hl7.fhir.dstu3.model.DocumentManifest, org.hl7.fhir.dstu3.model.Resource)}.
	 */
	@Test
	@Ignore
	public void testAddDocManifestContent() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#addUrnOid(java.lang.String)}.
	 */
	@Test
	public void testAddUrnOid() {
		final String ref = FhirCommon.addUrnOid(testOidString);
		assertNotNull(ref);
		assertTrue(ref.startsWith(FhirCommon.oidUrn));
		assertTrue(ref.endsWith(testOidString));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#addUrnUuid(java.lang.String)}.
	 */
	@Test
	public void testAddUrnUuid() {
		final String ref = FhirCommon.addUrnUuid(testUuid);
		assertNotNull(ref);
		assertTrue(ref.startsWith(FhirCommon.uuidUrn));
		assertTrue(ref.endsWith(testUuid));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#createCodeableConcept(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCreateCodeableConceptStringString() {
		final CodeableConcept ref = FhirCommon.createCodeableConcept(testSystemOid, testOidString);
		assertNotNull(ref);
		assertNotNull(ref.getCodingFirstRep());
		assertTrue(ref.getCodingFirstRep().getSystem().endsWith(testSystemOid));
		assertEquals(testOidString, ref.getCodingFirstRep().getCode());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#createCodeableConcept(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCreateCodeableConceptStringStringString() {
		final CodeableConcept ref = FhirCommon.createCodeableConcept(testSystemOid, testOidString,
				testDisplayName);
		assertNotNull(ref);
		assertNotNull(ref.getCodingFirstRep());
		assertTrue(ref.getCodingFirstRep().getSystem().endsWith(testSystemOid));
		assertEquals(testOidString, ref.getCodingFirstRep().getCode());
		assertEquals(testDisplayName, ref.getCodingFirstRep().getDisplay());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#createCoding(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCreateCodingStringString() {
		final Coding ref = FhirCommon.createCoding(testSystemOid, testOidString);
		assertNotNull(ref);
		assertTrue(ref.getSystem().endsWith(testSystemOid));
		assertEquals(testOidString, ref.getCode());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#createCoding(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCreateCodingStringStringString() {
		final Coding ref = FhirCommon.createCoding(testSystemOid, testOidString, testDisplayName);
		assertNotNull(ref);
		assertTrue(ref.getSystem().endsWith(testSystemOid));
		assertEquals(testOidString, ref.getCode());
		assertEquals(testDisplayName, ref.getDisplay());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#createIdentifier(org.ehealth_connector.common.mdht.Identificator)}.
	 */
	@Test
	public void testCreateIdentifierIdentificator() {
		final Identifier ref = FhirCommon.createIdentifier(testIdentificator);
		assertNotNull(ref);
		assertTrue(ref.getSystem().endsWith(testSystemOid));
		assertEquals(testOidString, ref.getValue());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#createIdentifier(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCreateIdentifierStringString() {
		final Identifier ref = FhirCommon.createIdentifier(testSystemOid, testOidString);
		assertNotNull(ref);
		assertTrue(ref.getSystem().endsWith(testSystemOid));
		assertEquals(testOidString, ref.getValue());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#createObservation()}.
	 */
	@Test
	@Ignore
	public void testCreateObservation() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#createObservation(org.hl7.fhir.dstu3.model.CodeableConcept)}.
	 */
	@Test
	@Ignore
	public void testCreateObservationCodeableConcept() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#ehcCodeToFhirCode(org.ehealth_connector.common.mdht.Code)}.
	 */
	@Test
	public void testEhcCodeToFhirCode() {
		final CodeableConcept ref = FhirCommon.ehcCodeToFhirCode(testCode);
		assertNotNull(ref);
		assertTrue(ref.getCodingFirstRep().getSystem().endsWith(testSystemOid));
		assertEquals(testOidString, ref.getCodingFirstRep().getCode());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#fhirAddressToEhcAddress(org.hl7.fhir.dstu3.model.Address)}.
	 */
	@Test
	@Ignore
	public void testFhirAddressToEhcAddress() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#fhirCodeToEhcCode(org.hl7.fhir.dstu3.model.CodeableConcept)}.
	 */
	@Test
	@Ignore
	public void testFhirCodeToEhcCode() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#fhirIdentifierToEhcIdentificator(org.hl7.fhir.dstu3.model.Identifier)}.
	 */
	@Test
	@Ignore
	public void testFhirIdentifierToEhcIdentificator() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#fhirNameToEhcName(org.hl7.fhir.dstu3.model.HumanName)}.
	 */
	@Test
	@Ignore
	public void testFhirNameToEhcName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#getAuthor(org.hl7.fhir.instance.model.api.IBaseResource)}.
	 */
	@Test
	@Ignore
	public void testGetAuthorIBaseResource() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#getAuthor(org.hl7.fhir.dstu3.model.Organization)}.
	 */
	@Test
	@Ignore
	public void testGetAuthorOrganization() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#getAuthor(org.hl7.fhir.dstu3.model.Person)}.
	 */
	@Test
	@Ignore
	public void testGetAuthorPerson() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#getAuthor(org.hl7.fhir.dstu3.model.Practitioner)}.
	 */
	@Test
	@Ignore
	public void testGetAuthorPractitioner() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#getAuthor(org.hl7.fhir.dstu3.model.Reference)}.
	 */
	@Test
	@Ignore
	public void testGetAuthorReference() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#getCommunityPatientId(org.ehealth_connector.common.mdht.Patient, java.lang.String)}.
	 */
	@Test
	@Ignore
	public void testGetCommunityPatientId() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#getDocumentFilepath(org.hl7.fhir.dstu3.model.DocumentReference)}.
	 */
	@Test
	@Ignore
	public void testGetDocumentFilepath() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#getFormatCode(org.hl7.fhir.dstu3.model.DocumentReference)}.
	 */
	@Test
	@Ignore
	public void testGetFormatCode() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#getMetadataLanguage(org.hl7.fhir.dstu3.model.DocumentReference)}.
	 */
	@Test
	@Ignore
	public void testGetMetadataLanguage() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#getMimeType(org.hl7.fhir.dstu3.model.DocumentReference)}.
	 */
	@Test
	@Ignore
	public void testGetMimeType() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#getOrganization(org.hl7.fhir.instance.model.api.IBaseResource)}.
	 */
	@Test
	@Ignore
	public void testGetOrganizationIBaseResource() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#getOrganization(org.hl7.fhir.dstu3.model.Organization)}.
	 */
	@Test
	@Ignore
	public void testGetOrganizationOrganization() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#getOrganization(org.hl7.fhir.dstu3.model.Reference)}.
	 */
	@Test
	@Ignore
	public void testGetOrganizationReference() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#getPatient(org.hl7.fhir.dstu3.model.Bundle)}.
	 */
	@Test
	@Ignore
	public void testGetPatientBundle() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#getPatient(org.hl7.fhir.dstu3.model.DocumentManifest)}.
	 */
	@Test
	@Ignore
	public void testGetPatientDocumentManifest() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#getPatient(org.hl7.fhir.instance.model.api.IBaseResource)}.
	 */
	@Test
	@Ignore
	public void testGetPatientIBaseResource() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#getPatient(org.hl7.fhir.dstu3.model.Patient)}.
	 */
	@Test
	@Ignore
	public void testGetPatientPatient() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#getPatient(org.hl7.fhir.dstu3.model.Reference)}.
	 */
	@Test
	@Ignore
	public void testGetPatientReference() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#getPracticeSettingCode(org.hl7.fhir.dstu3.model.DocumentReference)}.
	 */
	@Test
	@Ignore
	public void testGetPracticeSettingCode() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#getTelecoms(java.util.List)}.
	 */
	@Test
	@Ignore
	public void testGetTelecoms() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#getXmlResource(java.lang.String)}.
	 */
	@Test
	@Ignore
	public void testGetXmlResource() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#removeUrnOidPrefix(java.lang.String)}.
	 */
	@Test
	@Ignore
	public void testRemoveUrnOidPrefix() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.fhir.structures.gen.FhirCommon#saveResource(org.slf4j.Logger, java.lang.String, org.hl7.fhir.instance.model.api.IBaseResource, java.lang.String, org.ehealth_connector.fhir.structures.gen.FhirCommon.SaveMode)}.
	 */
	@Test
	@Ignore
	public void testSaveResource() {
		fail("Not yet implemented");
	}

}
