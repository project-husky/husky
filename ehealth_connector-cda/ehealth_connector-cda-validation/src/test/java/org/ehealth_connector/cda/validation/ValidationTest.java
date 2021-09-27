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
package org.ehealth_connector.cda.validation;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.transform.stream.StreamSource;

import org.apache.commons.io.IOUtils;
import org.ehealth_connector.cda.validation.api.CdaValidator;
import org.ehealth_connector.cda.validation.api.XsdValidationResult;
import org.ehealth_connector.validation.service.config.ConfigurationException;
import org.ehealth_connector.validation.service.pdf.PdfValidationResult;
import org.ehealth_connector.validation.service.pdf.VeraPdfValidationResult;
import org.ehealth_connector.validation.service.schematron.RuleSetDetectionException;
import org.ehealth_connector.validation.service.schematron.result.SchematronValidationResult;
import org.ehealth_connector.validation.service.transform.TransformationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
	private VeraPdfValidationResult veraPdfValiRes;

	private final String configFilePath = "rsc/config.xml";
	private final String cdaFilePath_Valid = "rsc/cda/miniCDA_Valid.xml";
	private final String cdaFilePath_SchemaAndSchematronFailure = "rsc/cda/miniCDA_SchemaAndSchematronFailure.xml";
	private final String cdaFilePath_SchemaFailure = "rsc/cda/miniCDA_SchemaFailure.xml";
	private final String cdaFilePath_SchematronFailures = "rsc/cda/miniCDA_SchematronFailures.xml";
	private final String cdaFilePath_ValidPdf = "rsc/cda/miniCDA_PdfValid.xml";
	private final String cdaFilePath_InvalidPdf = "rsc/cda/miniCDA_PdfInvalid.xml";

	/** The SLF4J logger instance. */
	private final Logger log = LoggerFactory.getLogger(getClass());

	@BeforeEach
	public void setUp() throws Exception {
		log.info("basePath='" + new File(".").getAbsolutePath() + "'");
		cdaVali = new CdaValidator(new File(configFilePath).getAbsoluteFile());
	}

	@Test
	public void testPdfValidation() throws ConfigurationException, SaxonApiException, IOException {

		String testFile = null;
		if (cdaVali.isUseVeraPdfValidator()) {

			// test validation by passing the CDA document as file
			testFile = cdaFilePath_ValidPdf;
			veraPdfValiRes = cdaVali.validateVeraPdf(new File(testFile).getAbsoluteFile());
			log.info("PDF file validation result of '" + testFile + "': "
					+ veraPdfValiRes.isPdfValid());
			assertTrue(veraPdfValiRes.isPdfValid());

			// test validation by passing an invalid CDA document as file
			testFile = cdaFilePath_InvalidPdf;
			veraPdfValiRes = cdaVali.validateVeraPdf(new File(testFile).getAbsoluteFile());
			log.info("PDF file validation result of '" + testFile + "': "
					+ veraPdfValiRes.isPdfValid());
			assertTrue(!veraPdfValiRes.isPdfValid());

			// test validation by passing the CDA document as stream
			testFile = cdaFilePath_ValidPdf;
			veraPdfValiRes = cdaVali
					.validateVeraPdf(new StreamSource(new File(testFile).getAbsoluteFile()));
			log.info("PDF stream validation result of '" + testFile + "': "
					+ veraPdfValiRes.isPdfValid());
			assertTrue(veraPdfValiRes.isPdfValid());

		} else {
			// test validation by passing the CDA document as file
			testFile = cdaFilePath_ValidPdf;
			pdfValiRes = cdaVali.validatePdf(new File(testFile).getAbsoluteFile());
			log.info(
					"PDF file validation result of '" + testFile + "': " + pdfValiRes.isPdfValid());
			assertTrue(pdfValiRes.isPdfValid());

			testFile = cdaFilePath_InvalidPdf;
			pdfValiRes = cdaVali.validatePdf(new File(testFile).getAbsoluteFile());
			log.info(
					"PDF file validation result of '" + testFile + "': " + pdfValiRes.isPdfValid());
			assertTrue(!pdfValiRes.isPdfValid());

			// test validation by passing the CDA document as stream
			testFile = cdaFilePath_ValidPdf;
			pdfValiRes = cdaVali
					.validatePdf(new StreamSource(new File(testFile).getAbsoluteFile()));
			log.info("PDF stream validation result of '" + testFile + "': "
					+ pdfValiRes.isPdfValid());
			assertTrue(pdfValiRes.isPdfValid());

			// test validation by passing the CDA document as byte[]
			testFile = cdaFilePath_ValidPdf;
			// read the file into a byte[]
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] cdaByteArray = null;
			try {
				IOUtils.copyLarge(new FileInputStream(new File(testFile).getAbsoluteFile()), baos);
				cdaByteArray = baos.toByteArray();
			} catch (IOException e) {
			}
			pdfValiRes = cdaVali.validatePdf(cdaByteArray);
			log.info("PDF byte[] validation result of '" + testFile + "': "
					+ pdfValiRes.isPdfValid());
			assertTrue(pdfValiRes.isPdfValid() || !pdfValiRes.isDone());
		}
	}

	@Test
	public void testSchematronValidation()
			throws SAXException, ConfigurationException, FileNotFoundException,
			RuleSetDetectionException, TransformationException, InterruptedException {

		String testFile = null;

		// test validation by passing the CDA document as file
		testFile = cdaFilePath_Valid;
		schValiRes = cdaVali.validateSch(new File(testFile).getAbsoluteFile());
		log.info("Schematron file validation result of '" + testFile + "': "
				+ schValiRes.isSchematronValid());
		assertTrue(schValiRes.isSchematronValid());

		testFile = cdaFilePath_SchemaAndSchematronFailure;
		schValiRes = cdaVali.validateSch(new File(testFile).getAbsoluteFile());
		log.info("Schematron file validation result of '" + testFile + "': "
				+ schValiRes.isSchematronValid());
		assertTrue(!schValiRes.isSchematronValid());

		testFile = cdaFilePath_SchemaFailure;
		schValiRes = cdaVali.validateSch(new File(testFile).getAbsoluteFile());
		log.info("Schematron file validation result of '" + testFile + "': "
				+ schValiRes.isSchematronValid());
		assertTrue(schValiRes.isSchematronValid());

		testFile = cdaFilePath_SchematronFailures;
		schValiRes = cdaVali.validateSch(new File(testFile).getAbsoluteFile());
		log.info("Schematron file validation result of '" + testFile + "': "
				+ schValiRes.isSchematronValid());
		assertTrue(!schValiRes.isSchematronValid());

		// test validation by passing the CDA document as stream
		testFile = cdaFilePath_Valid;
		schValiRes = cdaVali.validateSch(new StreamSource(new File(testFile).getAbsoluteFile()));
		log.info("Schematron stream validation result of '" + testFile + "': "
				+ schValiRes.isSchematronValid());
		assertTrue(schValiRes.isSchematronValid());

		testFile = cdaFilePath_SchematronFailures;
		schValiRes = cdaVali.validateSch(new StreamSource(new File(testFile).getAbsoluteFile()));
		log.info("Schematron stream validation result of '" + testFile + "': "
				+ schValiRes.isSchematronValid());
		assertTrue(!schValiRes.isSchematronValid());

		// test validation by passing the CDA document as byte[]
		testFile = cdaFilePath_Valid;
		// read the file into a byte[]
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] cdaByteArray = null;
		try {
			IOUtils.copyLarge(new FileInputStream(new File(testFile).getAbsoluteFile()), baos);
			cdaByteArray = baos.toByteArray();
		} catch (IOException e) {
		}
		schValiRes = cdaVali.validateSch(cdaByteArray);
		log.info("Schematron byte[] validation result of '" + testFile + "': "
				+ schValiRes.isSchematronValid());
		assertTrue(schValiRes.isSchematronValid());

		testFile = cdaFilePath_SchematronFailures;
		// read the file into a byte[]
		baos = new ByteArrayOutputStream();
		cdaByteArray = null;
		try {
			IOUtils.copyLarge(new FileInputStream(new File(testFile).getAbsoluteFile()), baos);
			cdaByteArray = baos.toByteArray();
		} catch (IOException e) {
		}
		schValiRes = cdaVali.validateSch(cdaByteArray);
		log.info("Schematron byte[] validation result of '" + testFile + "': "
				+ schValiRes.isSchematronValid());
		assertTrue(!schValiRes.isSchematronValid());
	}

	@Test
	public void testXSDValidation() throws ConfigurationException {

		String testFile = null;

		// test validation by passing the CDA document as file
		testFile = cdaFilePath_Valid;
		xsdValiRes = cdaVali.validateXsd(new File(testFile).getAbsoluteFile());
		log.info("Schema file validation result of '" + testFile + "': " + xsdValiRes.isXsdValid());
		assertTrue(xsdValiRes.isXsdValid());

		testFile = cdaFilePath_SchemaAndSchematronFailure;
		xsdValiRes = cdaVali.validateXsd(new File(testFile).getAbsoluteFile());
		log.info("Schema file validation result of '" + testFile + "': " + xsdValiRes.isXsdValid());
		assertTrue(!xsdValiRes.isXsdValid());

		testFile = cdaFilePath_SchemaFailure;
		xsdValiRes = cdaVali.validateXsd(new File(testFile).getAbsoluteFile());
		log.info("Schema file validation result of '" + testFile + "': " + xsdValiRes.isXsdValid());
		assertTrue(!xsdValiRes.isXsdValid());

		testFile = cdaFilePath_SchematronFailures;
		xsdValiRes = cdaVali.validateXsd(new File(testFile).getAbsoluteFile());
		log.info("Schema file validation result of '" + testFile + "': " + xsdValiRes.isXsdValid());
		assertTrue(xsdValiRes.isXsdValid());

		// test validation by passing the CDA document as stream
		testFile = cdaFilePath_Valid;
		xsdValiRes = cdaVali.validateXsd(new StreamSource(new File(testFile).getAbsoluteFile()));
		log.info("Schema stream validation result of '" + testFile + "': "
				+ xsdValiRes.isXsdValid());
		assertTrue(xsdValiRes.isXsdValid());

		testFile = cdaFilePath_SchematronFailures;
		xsdValiRes = cdaVali.validateXsd(new StreamSource(new File(testFile).getAbsoluteFile()));
		log.info("Schema file validation result of '" + testFile + "': " + xsdValiRes.isXsdValid());
		assertTrue(xsdValiRes.isXsdValid());

		// test validation by passing the CDA document as byte[]
		testFile = cdaFilePath_Valid;
		java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
		byte[] cdaByteArray = null;
		try {
			IOUtils.copyLarge(new FileInputStream(new File(testFile).getAbsoluteFile()), baos);
			cdaByteArray = baos.toByteArray();
		} catch (IOException e) {
		}
		xsdValiRes = cdaVali.validateXsd(cdaByteArray);
		log.info("Schema stream validation result of '" + testFile + "': "
				+ xsdValiRes.isXsdValid());
		assertTrue(xsdValiRes.isXsdValid());

		testFile = cdaFilePath_SchematronFailures;
		baos = new ByteArrayOutputStream();
		cdaByteArray = null;
		try {
			IOUtils.copyLarge(new FileInputStream(new File(testFile).getAbsoluteFile()), baos);
			cdaByteArray = baos.toByteArray();
		} catch (IOException e) {
		}
		xsdValiRes = cdaVali.validateXsd(cdaByteArray);
		log.info("Schema file validation result of '" + testFile + "': " + xsdValiRes.isXsdValid());
		assertTrue(xsdValiRes.isXsdValid());
	}
}
