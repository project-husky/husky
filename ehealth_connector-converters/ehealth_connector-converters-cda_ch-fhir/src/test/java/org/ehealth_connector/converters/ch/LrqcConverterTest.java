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

import org.ehealth_connector.cda.ch.lab.lrqc.CdaChLrqc;
import org.ehealth_connector.fhir.structures.ch.FhirCdaChLrqc.LrqcDocument;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author roeland
 * @version 1.0
 * @since Jan 2, 2018 1:48:38 PM
 *
 */
public class LrqcConverterTest extends AbstractConverter {

	private LrqcConverter converter;

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		converter = new LrqcConverter();
		setUpTestFile("/FHIRLrqcDocument_Chemie.xml");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.converters.ch.LrqcConverter#readLrqcDocumentFromFile(java.lang.String)}.
	 * {@link org.ehealth_connector.converters.ch.LrqcConverter#createCdaChLrqcFromFhir(org.hl7.fhir.dstu3.model.DocumentManifest, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testReadLrqcDocumentFromFileCreateCdaChLrqcFromFhir() {
		final LrqcDocument fhirDocument = converter.readLrqcDocumentFromFile(testFile);
		assertNotNull(fhirDocument);
		final CdaChLrqc ref = converter.createCdaChLrqcFromFhir(fhirDocument, styleSheet, css);
		assertNotNull(ref);

		assertNotNull(ref.getPatient());
		assertNotNull(ref.getPatient().getIds());
		assertNotNull(ref.getPatient().getIds().get(0));
		assertEquals("2.16.756.5.30.1.139", ref.getPatient().getIds().get(0).getRoot());
		assertEquals("434", ref.getPatient().getIds().get(0).getExtension());
	}

}
