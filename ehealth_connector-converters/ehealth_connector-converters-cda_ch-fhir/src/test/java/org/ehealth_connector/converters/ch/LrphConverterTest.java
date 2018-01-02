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

import org.ehealth_connector.cda.ch.lab.lrph.CdaChLrph;
import org.ehealth_connector.common.enums.AdministrativeGender;
import org.ehealth_connector.fhir.structures.ch.FhirCdaChLrph.LrphDocument;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author roeland
 * @version 1.0
 * @since Jan 2, 2018 1:36:03 PM
 *
 */
public class LrphConverterTest extends AbstractConverter {

	private LrphConverter converter;

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		converter = new LrphConverter();
		setUpTestFile("/FHIRLrphDocument_Isolate.xml");
	}

	/**
	 * Test method for
	 */

	/**
	 * Test method for
	 * {@link org.ehealth_connector.converters.ch.LrphConverter#readLrphDocumentFromFile(java.lang.String)}.
	 * {@link org.ehealth_connector.converters.ch.LrphConverter#createCdaChLrphFromFhir(org.ehealth_connector.fhir.structures.ch.FhirCdaChLrph.LrphDocument, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testReadLrphDocumentFromFileCreateCdaChLrphFromFhir() {
		final LrphDocument fhirDocument = converter.readLrphDocumentFromFile(testFile);
		assertNotNull(fhirDocument);
		final CdaChLrph ref = converter.createCdaChLrphFromFhir(fhirDocument, styleSheet, css);
		assertNotNull(ref);

		assertNotNull(ref.getPatient());
		assertNotNull(ref.getPatient().getAdministrativeGenderCode());
		assertEquals(AdministrativeGender.FEMALE, ref.getPatient().getAdministrativeGenderCode());
	}

}
