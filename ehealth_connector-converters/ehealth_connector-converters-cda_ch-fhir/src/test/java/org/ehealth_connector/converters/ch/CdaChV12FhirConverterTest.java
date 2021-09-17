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
package org.ehealth_connector.converters.ch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.hl7.fhir.dstu3.model.Narrative;
import org.hl7.fhir.dstu3.model.Observation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 *
 * @author roeland
 * @version 1.0
 * @since Jan 2, 2018 11:56:26 AM
 *
 */
public class CdaChV12FhirConverterTest {

	public class MyCdaChFhirConverter extends AbstractCdaChV12FhirConverter {

	}

	private AbstractCdaChV12FhirConverter converter;
	private String testComment;

	private String testText;

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		converter = new MyCdaChFhirConverter();

		testComment = "This is my comment";
		testText = "This is a text";
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.converters.ch.AbstractCdaChV12FhirConverter#createComment(java.lang.String)}.
	 */
	@Test
	public void testCreateComment() {
		final Observation ref = converter.createComment(testComment);
		assertNotNull(ref);
		assertEquals(testComment, ref.getComment());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.converters.ch.AbstractCdaChV12FhirConverter#createText(java.lang.String)}.
	 */
	@Test
	public void testCreateText() {
		final Narrative ref = converter.createText(testText);
		assertNotNull(ref);
		assertEquals(testText, ref.getDiv().allText());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.converters.ch.AbstractCdaChV12FhirConverter#getActiveProblemConcernEntries(org.hl7.fhir.dstu3.model.DocumentManifest)}.
	 */
	@Test
	@Disabled
	public void testGetActiveProblemConcernEntries() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.converters.ch.AbstractCdaChV12FhirConverter#getAllergyProblemConcernEntries(org.hl7.fhir.dstu3.model.DocumentManifest)}.
	 */
	@Test
	@Disabled
	public void testGetAllergyProblemConcernEntries() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.converters.ch.AbstractCdaChV12FhirConverter#getAuthors(org.hl7.fhir.dstu3.model.DocumentManifest)}.
	 */
	@Test
	@Disabled
	public void testGetAuthors() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.converters.ch.AbstractCdaChV12FhirConverter#getCodedVitalSigns(org.hl7.fhir.dstu3.model.DocumentManifest)}.
	 */
	@Test
	@Disabled
	public void testGetCodedVitalSigns() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.converters.ch.AbstractCdaChV12FhirConverter#getComment(org.hl7.fhir.dstu3.model.DocumentManifest)}.
	 */
	@Test
	@Disabled
	public void testGetCommentDocumentManifest() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.converters.ch.AbstractCdaChV12FhirConverter#getConfidentialityCode(org.hl7.fhir.dstu3.model.DocumentManifest)}.
	 */
	@Test
	@Disabled
	public void testGetConfidentialityCode() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.converters.ch.AbstractCdaChV12FhirConverter#getCustodian(org.hl7.fhir.dstu3.model.DocumentManifest)}.
	 */
	@Test
	@Disabled
	public void testGetCustodian() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.converters.ch.AbstractCdaChV12FhirConverter#getDocLanguage(org.hl7.fhir.dstu3.model.DocumentManifest)}.
	 */
	@Test
	@Disabled
	public void testGetDocLanguage() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.converters.ch.AbstractCdaChV12FhirConverter#getDocumentDate(org.hl7.fhir.dstu3.model.DocumentManifest)}.
	 */
	@Test
	@Disabled
	public void testGetDocumentDate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.converters.ch.AbstractCdaChV12FhirConverter#getDocumentId(org.hl7.fhir.dstu3.model.DocumentManifest)}.
	 */
	@Test
	@Disabled
	public void testGetDocumentId() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.converters.ch.AbstractCdaChV12FhirConverter#getDocumentSetId(org.hl7.fhir.dstu3.model.DocumentManifest)}.
	 */
	@Test
	@Disabled
	public void testGetDocumentSetId() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.converters.ch.AbstractCdaChV12FhirConverter#getEdDiagnoses(org.hl7.fhir.dstu3.model.DocumentManifest)}.
	 */
	@Test
	@Disabled
	public void testGetEdDiagnoses() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.converters.ch.AbstractCdaChV12FhirConverter#getGestationalAge(org.hl7.fhir.dstu3.model.DocumentManifest)}.
	 */
	@Test
	@Disabled
	public void testGetGestationalAge() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.converters.ch.AbstractCdaChV12FhirConverter#getIntendedRecipient(org.hl7.fhir.dstu3.model.DocumentManifest)}.
	 */
	@Test
	@Disabled
	public void testGetIntendedRecipient() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.converters.ch.AbstractCdaChV12FhirConverter#getLaboratoryObservations(org.hl7.fhir.dstu3.model.DocumentManifest)}.
	 */
	@Test
	@Disabled
	public void testGetLaboratoryObservations() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.converters.ch.AbstractCdaChV12FhirConverter#getLegalAuthenticator(org.hl7.fhir.dstu3.model.DocumentManifest)}.
	 */
	@Test
	@Disabled
	public void testGetLegalAuthenticator() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.converters.ch.AbstractCdaChV12FhirConverter#getNarrative(org.hl7.fhir.dstu3.model.DocumentManifest, java.lang.String)}.
	 */
	@Test
	@Disabled
	public void testGetNarrative() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.converters.ch.AbstractCdaChV12FhirConverter#getPastProblemConcernEntries(org.hl7.fhir.dstu3.model.DocumentManifest)}.
	 */
	@Test
	@Disabled
	public void testGetPastProblemConcernEntries() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.converters.ch.AbstractCdaChV12FhirConverter#getPerformer(org.hl7.fhir.dstu3.model.MedicationStatement)}.
	 */
	@Test
	@Disabled
	public void testGetPerformer() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.converters.ch.AbstractCdaChV12FhirConverter#getPregnancyHistory(org.hl7.fhir.dstu3.model.DocumentManifest)}.
	 */
	@Test
	@Disabled
	public void testGetPregnancyHistory() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.converters.ch.AbstractCdaChV12FhirConverter#getValueFromKeyValueString(org.hl7.fhir.dstu3.model.Observation, java.lang.String)}.
	 */
	@Test
	@Disabled
	public void testGetValueFromKeyValueString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.converters.ch.AbstractCdaChV12FhirConverter#isDocType(org.hl7.fhir.dstu3.model.DocumentManifest, java.lang.String)}.
	 */
	@Test
	@Disabled
	public void testIsDocType() {
		fail("Not yet implemented");
	}

}
