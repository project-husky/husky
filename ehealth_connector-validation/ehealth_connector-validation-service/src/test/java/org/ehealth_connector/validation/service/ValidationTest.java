package org.ehealth_connector.validation.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.ehealth_connector.validation.service.api.CdaValidator;
import org.ehealth_connector.validation.service.api.XsdValidationResult;
import org.ehealth_connector.validation.service.config.ConfigurationException;
import org.ehealth_connector.validation.service.pdf.PdfValidationResult;
import org.ehealth_connector.validation.service.schematron.RuleSetDetectionException;
import org.ehealth_connector.validation.service.schematron.result.SchematronValidationResult;
import org.ehealth_connector.validation.service.transform.TransformationException;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import net.sf.saxon.s9api.SaxonApiException;

/**
 * Unit test for simple App.
 */
public class ValidationTest {

	private CdaValidator cdaVali;
	XsdValidationResult xsdValiRes;
	SchematronValidationResult schValiRes;
	ArrayList<PdfValidationResult> pdfValiRes;

	private final String configFilePath = "rsc/config_elga.xml";
	private final String cdaFilePath = "rsc/cda/ELGA-031-Entlassungsbrief_Pflege_EIS-Structured_(PDFA-1).xml";
	private final String cdaXsdNokFilePath = "rsc/cda/ELGA-031-Entlassungsbrief_Pflege_EIS-Structured_(XML-Body)_xsd_nok.xml";
	private final String cdaSchNokFilePath = "rsc/cda/ELGA-021-Entlassungsbrief_aerztlich_EIS-Structured_(XML-Body)_SchematronFailure";

	//@Before
	public void setUp() throws Exception {
		cdaVali = new CdaValidator(new File(cdaFilePath).getAbsoluteFile(),
				new File(configFilePath).getAbsoluteFile());
	}

	//@Test
	public void testPdfValidation() throws ConfigurationException, SaxonApiException, IOException {

		pdfValiRes = cdaVali.validatePDF();
		boolean hasError = false;
		Iterator<PdfValidationResult> iter = pdfValiRes.iterator();
		boolean hasErrors = false;
		PdfValidationResult temp;
		while (iter.hasNext()) {
			temp = iter.next();
			hasErrors = hasErrors || temp.hasError();
		}
		assertTrue(!hasError);

		xsdValiRes = cdaVali.validateXSD(new File(cdaXsdNokFilePath));
		assertFalse(xsdValiRes.isXsdValid());
	}

	//@Test
	public void testSchematronValidation()
			throws SAXException, ConfigurationException, FileNotFoundException,
			RuleSetDetectionException, TransformationException, InterruptedException {

		schValiRes = cdaVali.validateSchematron();//.validateSchematron(new File(cdaFilePath));
		assertTrue(schValiRes.isSchematronValid());

		schValiRes = cdaVali.validateSchematron(new File(cdaSchNokFilePath));
		assertFalse(schValiRes.isSchematronValid());
	}

	//@Test
	public void testXSDValidation() throws ConfigurationException {

		xsdValiRes = cdaVali.validateXSD();
		assertTrue(xsdValiRes.isXsdValid());

		xsdValiRes = cdaVali.validateXSD(new File(cdaXsdNokFilePath));
		assertFalse(xsdValiRes.isXsdValid());
	}
}
