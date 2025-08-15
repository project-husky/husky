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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.projecthusky.fhir.vacd.ch.common.enums.ChVacdDocumentType;
import org.projecthusky.fhir.vacd.ch.common.resource.r4.ChVacdAbstractDocument;
import org.projecthusky.fhir.vacd.ch.common.resource.r4.ChVacdImmunizationAdministrationDocument;
import org.projecthusky.fhir.vacd.ch.common.resource.r4.ChVacdVaccinationRecordDocument;

import ca.uhn.fhir.context.FhirContext;

/**
 * 
 */
class ChVacdParserTest {

	private ChVacdParser parser;
	private String adminJson;
	private String adminXml;
	private String recordJson;
	private String recordXml;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		parser = new ChVacdParser(FhirContext.forR4Cached());
		{
			InputStream is = this.getClass()
					.getResourceAsStream("/fhir/Bundle-1-1-ImmunizationAdministration.json");
			adminJson = new String(is.readAllBytes());
			is.close();
		}
		{
			InputStream is = this.getClass()
					.getResourceAsStream("/fhir/Bundle-1-1-ImmunizationAdministration.xml");
			adminXml = new String(is.readAllBytes());
			is.close();
		}
		{
			InputStream is = this.getClass()
					.getResourceAsStream("/fhir/Bundle-1-3-VaccinationRecord.json");
			recordJson = new String(is.readAllBytes());
			is.close();
		}
		{
			InputStream is = this.getClass()
					.getResourceAsStream("/fhir/Bundle-1-3-VaccinationRecord.xml");
			recordXml = new String(is.readAllBytes());
			is.close();
		}

	}

	/**
	 * Test method for
	 * {@link org.projecthusky.fhir.vacd.ch.common.service.ChVacdParser#parse(java.lang.String, org.projecthusky.fhir.vacd.ch.common.enums.ChVacdDocumentType)}.
	 */
	@Test
	void testParseImmunAdminJson() {

		ChVacdImmunizationAdministrationDocument ref = parser.parse(adminJson,
				ChVacdDocumentType.ADMIN);
		assertNotNull(ref);
		assertTrue(ref instanceof ChVacdImmunizationAdministrationDocument);

	}

	/**
	 * Test method for
	 * {@link org.projecthusky.fhir.vacd.ch.common.service.ChVacdParser#parse(java.lang.String, org.projecthusky.fhir.vacd.ch.common.enums.ChVacdDocumentType)}.
	 */
	@Test
	void testParseImmunAdminXml() {
		ChVacdImmunizationAdministrationDocument ref = parser.parse(adminXml,
				ChVacdDocumentType.ADMIN);
		assertNotNull(ref);
		assertTrue(ref instanceof ChVacdImmunizationAdministrationDocument);
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.fhir.vacd.ch.common.service.ChVacdParser#parse(java.lang.String, org.projecthusky.fhir.vacd.ch.common.enums.ChVacdDocumentType)}.
	 */
	@Test
	void testParseImmunAdminJsonFalse() {

		Exception exception = assertThrows(ClassCastException.class, () -> {
			ChVacdImmunizationAdministrationDocument ref = parser.parse(adminXml,
					ChVacdDocumentType.RECORD);
		});
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.fhir.vacd.ch.common.service.ChVacdParser#parse(java.lang.String, org.projecthusky.fhir.vacd.ch.common.enums.ChVacdDocumentType)}.
	 */
	@Test
	void testParseVacRecJson() {
		ChVacdVaccinationRecordDocument ref = parser.parse(recordJson, ChVacdDocumentType.RECORD);
		assertNotNull(ref);
		assertTrue(ref instanceof ChVacdVaccinationRecordDocument);
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.fhir.vacd.ch.common.service.ChVacdParser#parse(java.lang.String, org.projecthusky.fhir.vacd.ch.common.enums.ChVacdDocumentType)}.
	 */
	@Test
	void testParseVacRecXml() {
		ChVacdVaccinationRecordDocument ref = parser.parse(recordXml, ChVacdDocumentType.RECORD);
		assertNotNull(ref);
		assertTrue(ref instanceof ChVacdVaccinationRecordDocument);
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.fhir.vacd.ch.common.service.ChVacdParser#parse(java.lang.String, org.projecthusky.fhir.vacd.ch.common.enums.ChVacdDocumentType)}.
	 */
	@Test
	void testParseVacRecJsonFalse() {

		Exception exception = assertThrows(ClassCastException.class, () -> {
			ChVacdVaccinationRecordDocument ref = parser.parse(adminXml, ChVacdDocumentType.ADMIN);
		});
	}

}
