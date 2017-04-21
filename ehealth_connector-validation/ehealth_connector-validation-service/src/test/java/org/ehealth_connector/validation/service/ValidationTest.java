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
package org.ehealth_connector.validation.service;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.ehealth_connector.validation.service.api.CdaValidator;
import org.ehealth_connector.validation.service.api.XsdValidationResult;
import org.ehealth_connector.validation.service.config.ConfigurationException;
import org.ehealth_connector.validation.service.pdf.PdfValidationResult;
import org.ehealth_connector.validation.service.schematron.RuleSetDetectionException;
import org.ehealth_connector.validation.service.schematron.result.SchematronValidationResult;
import org.ehealth_connector.validation.service.transform.TransformationException;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import net.sf.saxon.s9api.SaxonApiException;

/**
 * Unit test for simple App.
 */
public class ValidationTest {

	private CdaValidator cdaVali = null;
	private XsdValidationResult xsdValiRes;
	private SchematronValidationResult schValiRes;
	private PdfValidationResult pdfValiRes;

	private final String configFilePath = "rsc/config.xml";
	private final String cdaFilePath_Valid = "rsc/cda/miniCDA_Valid.xml";
	private final String cdaFilePath_SchemaAndSchematronFailure = "rsc/cda/miniCDA_SchemaAndSchematronFailure.xml";
	private final String cdaFilePath_SchemaFailure = "rsc/cda/miniCDA_SchemaFailure.xml";
	private final String cdaFilePath_SchematronFailures = "rsc/cda/miniCDA_SchematronFailures.xml";
	private final String cdaFilePath_ValidPdf = "rsc/cda/miniCDA_PdfValid.xml";
	private final String cdaFilePath_InvalidPdf = "rsc/cda/miniCDA_PdfInvalid.xml";

	/** The SLF4J logger instance. */
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Before
	public void setUp() throws Exception {
		log.info("basePath='" + new File(".").getAbsolutePath() + "'");
		cdaVali = new CdaValidator(new File(configFilePath).getAbsoluteFile());
	}

	@Test
	public void testPdfValidation() throws ConfigurationException, SaxonApiException, IOException {

		String testFile = null;
		testFile = cdaFilePath_ValidPdf;
		pdfValiRes = cdaVali.validatePdf(new File(testFile).getAbsoluteFile());
		log.info("PDF validation result of '" + testFile + "': " + pdfValiRes.isPdfValid());
		assertTrue(pdfValiRes.isPdfValid() || !pdfValiRes.isDone());

		testFile = cdaFilePath_InvalidPdf;
		pdfValiRes = cdaVali.validatePdf(new File(testFile).getAbsoluteFile());
		log.info("PDF validation result of '" + testFile + "': " + pdfValiRes.isPdfValid());
		assertTrue(!pdfValiRes.isPdfValid() || !pdfValiRes.isDone());

	}

	@Test
	public void testSchematronValidation()
			throws SAXException, ConfigurationException, FileNotFoundException,
			RuleSetDetectionException, TransformationException, InterruptedException {

		String testFile = null;

		testFile = cdaFilePath_Valid;
		schValiRes = cdaVali.validateSch(new File(testFile).getAbsoluteFile());
		log.info("Schematron validation result of '" + testFile + "': "
				+ schValiRes.isSchematronValid());
		assertTrue(schValiRes.isSchematronValid());

		testFile = cdaFilePath_SchemaAndSchematronFailure;
		schValiRes = cdaVali.validateSch(new File(testFile).getAbsoluteFile());
		log.info("Schematron validation result of '" + testFile + "': "
				+ schValiRes.isSchematronValid());
		assertTrue(!schValiRes.isSchematronValid());

		testFile = cdaFilePath_SchemaFailure;
		schValiRes = cdaVali.validateSch(new File(testFile).getAbsoluteFile());
		log.info("Schematron validation result of '" + testFile + "': "
				+ schValiRes.isSchematronValid());
		assertTrue(schValiRes.isSchematronValid());

		testFile = cdaFilePath_SchematronFailures;
		schValiRes = cdaVali.validateSch(new File(testFile).getAbsoluteFile());
		log.info("Schematron validation result of '" + testFile + "': "
				+ schValiRes.isSchematronValid());
		assertTrue(!schValiRes.isSchematronValid());

	}

	@Test
	public void testXSDValidation() throws ConfigurationException {

		String testFile = null;

		testFile = cdaFilePath_Valid;
		xsdValiRes = cdaVali.validateXsd(new File(testFile).getAbsoluteFile());
		log.info("Schema validation result of '" + testFile + "': " + xsdValiRes.isXsdValid());
		assertTrue(xsdValiRes.isXsdValid());

		testFile = cdaFilePath_SchemaAndSchematronFailure;
		xsdValiRes = cdaVali.validateXsd(new File(testFile).getAbsoluteFile());
		log.info("Schema validation result of '" + testFile + "': " + xsdValiRes.isXsdValid());
		assertTrue(!xsdValiRes.isXsdValid());

		testFile = cdaFilePath_SchemaFailure;
		xsdValiRes = cdaVali.validateXsd(new File(testFile).getAbsoluteFile());
		log.info("Schema validation result of '" + testFile + "': " + xsdValiRes.isXsdValid());
		assertTrue(!xsdValiRes.isXsdValid());

		testFile = cdaFilePath_SchematronFailures;
		xsdValiRes = cdaVali.validateXsd(new File(testFile).getAbsoluteFile());
		log.info("Schema validation result of '" + testFile + "': " + xsdValiRes.isXsdValid());
		assertTrue(xsdValiRes.isXsdValid());
	}
}
