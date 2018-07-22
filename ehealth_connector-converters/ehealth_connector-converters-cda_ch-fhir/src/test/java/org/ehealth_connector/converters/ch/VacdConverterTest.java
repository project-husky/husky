/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.ehealth_connector.cda.ch.vacd.CdaChVacd;
import org.ehealth_connector.common.enums.AdministrativeGender;
import org.ehealth_connector.fhir.structures.ch.FhirCdaChVacd.VacdDocument;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author roeland
 * @version 1.0
 * @since Jan 2, 2018 2:00:40 PM
 *
 */
public class VacdConverterTest extends AbstractConverter {

	private VacdConverter converter;

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		converter = new VacdConverter();
		setUpTestFile("/FHIRVacdDocument_ImmunizationMaxContent.xml");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.converters.ch.VacdConverter#readVacDocumentFromFile(java.lang.String)}.
	 * {@link org.ehealth_connector.converters.ch.VacdConverter#createCdaChVacdFromFHIR(org.hl7.fhir.dstu3.model.DocumentManifest, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testReadVacDocumentFromFileCreateCdaChVacdFromFHIR() {
		final VacdDocument fhirDocument = converter.readVacDocumentFromFile(testFile);
		assertNotNull(fhirDocument);

		// assertNotNull(fhirDocument.getImmunizations());
		// assertTrue(fhirDocument.getImmunizations().size() > 0);
		// final Author immunAuthor =
		// converter.getAuthor(fhirDocument.getImmunizations().get(0));
		// assertNotNull(immunAuthor);
		// assertEquals("7607777777777", immunAuthor.getGln());

		final CdaChVacd ref = converter.createCdaChVacdFromFHIR(fhirDocument, styleSheet, css);
		assertNotNull(ref);

		assertNotNull(ref.getPatient());
		assertNotNull(ref.getPatient().getName());
		assertEquals("Tigrinja", ref.getPatient().getName().getFamilyName());
		assertEquals("Sesuna", ref.getPatient().getName().getAllGivenNames());

		assertNotNull(ref.getPatient().getAdministrativeGenderCode());
		assertEquals(AdministrativeGender.FEMALE, ref.getPatient().getAdministrativeGenderCode());

		assertNotNull(ref.getPatient().getIds());
		assertNotNull(ref.getPatient().getIds().get(0));
		assertEquals("2.16.756.5.30.999999999999", ref.getPatient().getIds().get(0).getRoot());
		assertEquals("898989", ref.getPatient().getIds().get(0).getExtension());

		assertNotNull(ref.getAppliedImmunizations());
		assertTrue(ref.getAppliedImmunizations().size() > 0);
		assertNotNull(ref.getAppliedImmunizations().get(0));
		assertNotNull(ref.getAppliedImmunizations().get(0).getAuthor());
		assertEquals("7607777777777", ref.getAppliedImmunizations().get(0).getAuthor().getGln());
	}

}
