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
package org.husky.fhir.structures.gen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.UUID;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Identifier;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;
import org.husky.fhir.structures.gen.FhirCommon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 *
 * @version 1.0
 * @since Jan 2, 2018 11:32:48 AM
 *
 */
class FhirCommonTest {

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
	@BeforeEach
	public void setUp() throws Exception {
		testSystemOid = "1.2.3.4.5";
		testOidString = "2.16.840.1.113883.3.72.5.9.2";
		testDisplayName = "my display name";
		testUuid = UUID.randomUUID().toString();

		testIdentificator = new Identificator(testSystemOid, testOidString);

		testCode = new Code(testOidString, testSystemOid, null);
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#addDocManifestContent(org.hl7.fhir.r4.model.DocumentManifest, org.hl7.fhir.r4.model.Resource)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testAddDocManifestContent() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#addUrnOid(java.lang.String)}.
	 */
	@Test
	void testAddUrnOid() {
		final String ref = FhirCommon.addUrnOid(testOidString);
		assertNotNull(ref);
		assertTrue(ref.startsWith(FhirCommon.OID_URN));
		assertTrue(ref.endsWith(testOidString));
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#addUrnUuid(java.lang.String)}.
	 */
	@Test
	void testAddUrnUuid() {
		final String ref = FhirCommon.addUrnUuid(testUuid);
		assertNotNull(ref);
		assertTrue(ref.startsWith(FhirCommon.UUID_URN));
		assertTrue(ref.endsWith(testUuid));
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#createCodeableConcept(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCreateCodeableConceptStringString() {
		final CodeableConcept ref = FhirCommon.createCodeableConcept(testSystemOid, testOidString);
		assertNotNull(ref);
		assertNotNull(ref.getCodingFirstRep());
		assertTrue(ref.getCodingFirstRep().getSystem().endsWith(testSystemOid));
		assertEquals(testOidString, ref.getCodingFirstRep().getCode());
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#createCodeableConcept(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCreateCodeableConceptStringStringString() {
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
	 * {@link org.husky.fhir.structures.gen.FhirCommon#createCoding(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCreateCodingStringString() {
		final Coding ref = FhirCommon.createCoding(testSystemOid, testOidString);
		assertNotNull(ref);
		assertTrue(ref.getSystem().endsWith(testSystemOid));
		assertEquals(testOidString, ref.getCode());
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#createCoding(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCreateCodingStringStringString() {
		final Coding ref = FhirCommon.createCoding(testSystemOid, testOidString, testDisplayName);
		assertNotNull(ref);
		assertTrue(ref.getSystem().endsWith(testSystemOid));
		assertEquals(testOidString, ref.getCode());
		assertEquals(testDisplayName, ref.getDisplay());
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#createIdentifier(org.org.husky.common.model.Identificator)}.
	 */
	@Test
	void testCreateIdentifierIdentificator() {
		final Identifier ref = FhirCommon.createIdentifier(testIdentificator);
		assertNotNull(ref);
		assertTrue(ref.getSystem().endsWith(testSystemOid));
		assertEquals(testOidString, ref.getValue());
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#createIdentifier(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCreateIdentifierStringString() {
		final Identifier ref = FhirCommon.createIdentifier(testSystemOid, testOidString);
		assertNotNull(ref);
		assertTrue(ref.getSystem().endsWith(testSystemOid));
		assertEquals(testOidString, ref.getValue());
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#createObservation()}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testCreateObservation() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#createObservation(org.hl7.fhir.r4.model.CodeableConcept)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testCreateObservationCodeableConcept() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#ehcCodeToFhirCode(org.org.husky.common.model.Code)}.
	 */
	@Test
	void testEhcCodeToFhirCode() {
		final CodeableConcept ref = FhirCommon.ehcCodeToFhirCode(testCode);
		assertNotNull(ref);
		assertTrue(ref.getCodingFirstRep().getSystem().endsWith(testSystemOid));
		assertEquals(testOidString, ref.getCodingFirstRep().getCode());
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#fhirAddressToEhcAddress(org.hl7.fhir.r4.model.Address)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testFhirAddressToEhcAddress() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#fhirCodeToEhcCode(org.hl7.fhir.r4.model.CodeableConcept)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testFhirCodeToEhcCode() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#fhirIdentifierToEhcIdentificator(org.hl7.fhir.r4.model.Identifier)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testFhirIdentifierToEhcIdentificator() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#fhirNameToEhcName(org.hl7.fhir.r4.model.HumanName)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testFhirNameToEhcName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#getAuthor(org.hl7.fhir.instance.model.api.IBaseResource)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testGetAuthorIBaseResource() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#getAuthor(org.hl7.fhir.r4.model.Organization)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testGetAuthorOrganization() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#getAuthor(org.hl7.fhir.r4.model.Person)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testGetAuthorPerson() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#getAuthor(org.hl7.fhir.r4.model.Practitioner)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testGetAuthorPractitioner() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#getAuthor(org.hl7.fhir.r4.model.Reference)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testGetAuthorReference() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#getCommunityPatientId(org.husky.common.mdht.Patient, java.lang.String)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testGetCommunityPatientId() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#getDocumentFilepath(org.hl7.fhir.r4.model.DocumentReference)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testGetDocumentFilepath() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#getFormatCode(org.hl7.fhir.r4.model.DocumentReference)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testGetFormatCode() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#getMetadataLanguage(org.hl7.fhir.r4.model.DocumentReference)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testGetMetadataLanguage() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#getMimeType(org.hl7.fhir.r4.model.DocumentReference)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testGetMimeType() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#getOrganization(org.hl7.fhir.instance.model.api.IBaseResource)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testGetOrganizationIBaseResource() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#getOrganization(org.hl7.fhir.r4.model.Organization)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testGetOrganizationOrganization() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#getOrganization(org.hl7.fhir.r4.model.Reference)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testGetOrganizationReference() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#getPatient(org.hl7.fhir.r4.model.Bundle)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testGetPatientBundle() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#getPatient(org.hl7.fhir.r4.model.DocumentManifest)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testGetPatientDocumentManifest() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#getPatient(org.hl7.fhir.instance.model.api.IBaseResource)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testGetPatientIBaseResource() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#getPatient(org.hl7.fhir.r4.model.Patient)}.
	 */
	@Test
	@Disabled("Not yet implemented")
    void testGetPatientPatient() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#getPatient(org.hl7.fhir.r4.model.Reference)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testGetPatientReference() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#getPracticeSettingCode(org.hl7.fhir.r4.model.DocumentReference)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testGetPracticeSettingCode() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#getTelecoms(java.util.List)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testGetTelecoms() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#getXmlResource(java.lang.String)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testGetXmlResource() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#removeUrnOidPrefix(java.lang.String)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testRemoveUrnOidPrefix() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.husky.fhir.structures.gen.FhirCommon#saveResource(org.slf4j.Logger, java.lang.String, org.hl7.fhir.instance.model.api.IBaseResource, java.lang.String, org.husky.fhir.structures.gen.FhirCommon.SaveMode)}.
	 */
	@Test
	@Disabled("Not yet implemented")
	void testSaveResource() {
		fail("Not yet implemented");
	}

}
