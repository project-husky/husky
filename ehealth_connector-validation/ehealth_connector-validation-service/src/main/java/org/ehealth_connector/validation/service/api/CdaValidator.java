/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.validation.service.api;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.ehealth_connector.validation.service.config.Configuration;
import org.ehealth_connector.validation.service.config.ConfigurationException;
import org.ehealth_connector.validation.service.config.Configurator;
import org.ehealth_connector.validation.service.pdf.PdfValidationResult;
import org.ehealth_connector.validation.service.pdf.PdfValidator;
import org.ehealth_connector.validation.service.schematron.ReportBuilder;
import org.ehealth_connector.validation.service.schematron.RuleSet;
import org.ehealth_connector.validation.service.schematron.RuleSetDetectionException;
import org.ehealth_connector.validation.service.schematron.RuleSetTransformer;
import org.ehealth_connector.validation.service.schematron.Validators;
import org.ehealth_connector.validation.service.schematron.bind.ActivePattern;
import org.ehealth_connector.validation.service.schematron.bind.FailedAssert;
import org.ehealth_connector.validation.service.schematron.bind.SchematronOutput;
import org.ehealth_connector.validation.service.schematron.bind.SuccessfulReport;
import org.ehealth_connector.validation.service.schematron.result.ActivePatternResult;
import org.ehealth_connector.validation.service.schematron.result.SchematronValidationResult;
import org.ehealth_connector.validation.service.transform.TransformationException;
/*import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehealth_connector.demo.validation.DemoValidation;*/
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.SaxonApiException;

/**
 * This class offers all methods to do the validation of a CDA document
 *
 */
public class CdaValidator {

	/** Configuration of the validator */
	private Configuration configuration;
	/** Validators to be used */
	private Validators validators;
	/** ReportBuilder for schematron results */
	private ReportBuilder reportBuilder;
	/** XSD-schema to be used */
	private Schema schema;
	/** CDA file to be validated */
	private File cdaFile;

	private String langCode;

	private ValidationResult validationResult;

	/**
	 *
	 * @param cdaFilePath
	 *            The CDA document to be validated
	 * @param configFilePath
	 *            The configfile with following attributes - baseDir -
	 *            document-schema - pdf-level - pdf-reporting-level -
	 *            license-key - schematron/rule-set
	 * @param langCode
	 *            The outputLangauge of the schematron validation Different
	 *            language messages have to be defined in the schematrons
	 * @throws ConfigurationException
	 *             If the configuration fails, an exception will be thrown
	 */
	public CdaValidator(File cdaFile, File configFile) throws ConfigurationException {
		this.cdaFile = cdaFile;
		this.configuration = configure(configFile);
		this.validators = createValidators(this.configuration);
		this.reportBuilder = new ReportBuilder(validators);
	}

	/**
	 *
	 * @param cdaFilePath
	 *            The CDA document to be validated
	 * @param configFilePath
	 *            The configfile with following attributes - baseDir -
	 *            document-schema - pdf-level - pdf-reporting-level -
	 *            license-key - schematron/rule-set
	 * @param langCode
	 *            The outputLangauge of the schematron validation Different
	 *            language messages have to be defined in the schematrons
	 * @throws ConfigurationException
	 *             If the configuration fails, an exception will be thrown
	 */
	public CdaValidator(File cdaFile, File configFile, String langCode) throws ConfigurationException {
		this.cdaFile = cdaFile;
		this.configuration = configure(configFile);
		this.validators = createValidators(this.configuration);
		this.reportBuilder = new ReportBuilder(validators);
		this.langCode = langCode;

	}

	/**
	 * Create a new configuration for the validator
	 *
	 * @param file
	 *            Configuration file
	 * @return A valid configuration
	 * @throws ConfigurationException
	 *
	 */
	private Configuration configure(File file) throws ConfigurationException {
		try {
			if (file == null) {
				throw new ConfigurationException("No configuration file specified.");
			}
			Configurator configurator = new Configurator(file);
			Configuration configuration = configurator.createConfiguration();
			this.schema = loadSchema(configuration.getDocumentSchema());
			return configuration;
		} catch (ConfigurationException e) {
			throw new ConfigurationException("Configuration error: " + e.getMessage());
		}
	}

	/**
	 * Converts the raw SchematronOutput to SchematronValidationResult, with
	 * either successful-report oder failed-assert and the associated
	 * active-pattern and fired-rule
	 *
	 * @param schOut
	 *            SchematronOutput
	 * @return
	 */
	private SchematronValidationResult convertSchematronOutput(SchematronOutput schOut) {

		ActivePatternResult currentApResult = null;
		Object temp = null;
		Object prevObject = null;
		SchematronValidationResult schValRes = new SchematronValidationResult();
		schValRes.setSchematronValid(true);

		List<Object> schOutputList = schOut.getActivePatternAndFiredRuleAndFailedAssert();

		if (!schOutputList.isEmpty()) {
			Iterator<Object> schIter = schOutputList.iterator();
			do {
				temp = schIter.next();
				if (temp instanceof ActivePattern && prevObject == null) {
					currentApResult = new ActivePatternResult();
					currentApResult.setAp((ActivePattern) temp);
					prevObject = temp;
					continue;
				}
				if (temp instanceof ActivePattern && prevObject != null && prevObject instanceof ActivePattern) {
					schValRes.getActivePatternResultFull().add(currentApResult);
					currentApResult = new ActivePatternResult();
					currentApResult.setAp((ActivePattern) temp);
					prevObject = temp;
					continue;
				}
				if (temp instanceof ActivePattern && !(prevObject instanceof ActivePattern)) {
					schValRes.getActivePatternResultFull().add(currentApResult);
					currentApResult = new ActivePatternResult();
					currentApResult.setAp((ActivePattern) temp);
					prevObject = temp;
					continue;
				}
				if (!(temp instanceof ActivePattern)) {
					if (temp instanceof FailedAssert) {
						if (((FailedAssert) temp).getRole().equals("")
								|| ((FailedAssert) temp).getRole().toLowerCase().equals("error"))
							schValRes.setSchematronValid(false);
					}
					if (temp instanceof SuccessfulReport) {
						if (((SuccessfulReport) temp).getRole().toLowerCase().equals("error"))
							schValRes.setSchematronValid(false);
					}
					currentApResult.getApChilds().add(temp);
					prevObject = temp;
				}
				
				/*
				if (!(temp instanceof ActivePattern)) {
					if (temp instanceof FailedAssert) {
						if (((FailedAssert) temp).getRole().equals("")
								|| ((FailedAssert) temp).getRole().toLowerCase().equals("error"))
							schValRes.setSchematronValid(false);
						currentApResult.getApChilds().add(temp);
						prevObject = temp;
					}
				}
				if (!(temp instanceof ActivePattern)) {
					if (temp instanceof SuccessfulReport) {
						if (((SuccessfulReport) temp).getRole().toLowerCase().equals("error"))
							schValRes.setSchematronValid(false);
						currentApResult.getApChilds().add(temp);
						prevObject = temp;
					}
				}*/

			} while (schIter.hasNext());
			schValRes.getActivePatternResultFull().add(currentApResult);
		}
		return schValRes;
	}

	/**
	 * Instantiate JAXB classes of the schematron XML validation output
	 *
	 * @param in
	 * @return
	 */
	private SchematronOutput createSchematronOutput(ByteArrayInputStream in) {

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(SchematronOutput.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (SchematronOutput) jaxbUnmarshaller.unmarshal(in);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param configuration
	 * @return
	 */
	private Validators createValidators(Configuration configuration) {
		// log.debug("Building rule-set transformer ...");
		RuleSetTransformer factory = new RuleSetTransformer(new Processor(false));
		return new Validators(factory);
	}

	/**
	 * @param schemaPath
	 * @return
	 */
	private Schema loadSchema(final String schemaPath) {
		if (schemaPath == null || schemaPath.isEmpty()) {
			return null;
		}
		// log.info("Loading XSD schema '" + schemaPath + "' ...");
		File schemaFile = new File(schemaPath).getAbsoluteFile();
		if (!schemaFile.canRead()) {
			// log.error("XSD schema " + schemaFile.toString() + " does not
			// exist or can not be read.");
			return null;
		}
		Source source = new StreamSource(schemaFile);
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		factory.setErrorHandler(new ErrorHandler() {
			@Override
			public void error(SAXParseException exception) throws SAXException {
				// log.warn("XSD schema error: " + exception.getMessage());
			}

			@Override
			public void fatalError(SAXParseException exception) throws SAXException {
				throw exception;
			}

			@Override
			public void warning(SAXParseException exception) throws SAXException {
			}
		});
		try {
			return factory.newSchema(source);
		} catch (SAXException e) {
			// log.error("Could not load XSD schema '" + schemaPath + "'", e);
			return null;
		}
	}

	/**
	 * Do a XSD, a Schematron and the PDF validation (if a license key is
	 * provided)
	 *
	 * @return ValidationResult object, containing of all results
	 * @throws ConfigurationException
	 */
	public ValidationResult validate() throws ConfigurationException {
		if (this.configuration == null)
			throw new ConfigurationException("No configuration available");
		this.validationResult = new ValidationResult();
		try {
			validateXsd();
			validationResult.setXsdValid(true);
			validationResult.xsdValRes.setXsdValidationMsg("XSD Valid");
		} catch (SAXException | IOException e) {
			validationResult.setXsdValid(false);
			validationResult.xsdValRes.setXsdValidationMsg(e.getMessage());
		}

		try {
			SchematronOutput schOut = validateSchematronRaw();
			SchematronValidationResult schValRes = convertSchematronOutput(schOut);
			validationResult.setSchValRes(schValRes);

		} catch (SAXException | FileNotFoundException | RuleSetDetectionException | TransformationException
				| InterruptedException e) {
			System.out.println("Schematron validation failed: " + e.getMessage());
		}

		if (this.configuration.getLicenseKey() != null) {
			try {
				validationResult.setPdfValRes(validatePDF());
			} catch (ConfigurationException | SaxonApiException | IOException e) {
				System.out.println("PDF validation failed: " + e.getMessage());
			}
		}
		return validationResult;
	}

	/**
	 * Do a XSD, a Schematron and the PDF validation (if a license key is
	 * provided) with the configuration passed to the method
	 *
	 * @param configFile
	 * @return ValidationResult object, containing of all results
	 * @throws ConfigurationException
	 */
	public ValidationResult validate(File configFile) throws ConfigurationException {
		this.configuration = configure(configFile);
		this.validators = createValidators(this.configuration);
		this.reportBuilder = new ReportBuilder(validators);
		return validate();

	}

	/**
	 * Do a PDF validation of the file, with the current configuration
	 *
	 * @return
	 * @throws ConfigurationException
	 * @throws SaxonApiException
	 * @throws IOException
	 */
	public ArrayList<PdfValidationResult> validatePDF() throws ConfigurationException, SaxonApiException, IOException {

		PdfValidator pdfValidator = new PdfValidator(this.configuration);
		pdfValidator.validatePdfFile(this.cdaFile);

		return pdfValidator.getPdfValidationResults();
	}

	/**
	 * Do a PDF validation of the file, with the given attributes
	 *
	 * @param pdfLevel
	 * @param pdfReportingLevel
	 * @param licenseKey
	 * @return
	 * @throws ConfigurationException
	 * @throws SaxonApiException
	 * @throws IOException
	 */
	public ArrayList<PdfValidationResult> validatePDF(String pdfLevel, String pdfReportingLevel, String licenseKey)
			throws ConfigurationException, SaxonApiException, IOException {

		//this.configuration
		// geht nur mühsam, da config via file implementiert ist
		return validatePDF();
	}

	public SchematronValidationResult validateSchematron() throws SAXException, FileNotFoundException,
			RuleSetDetectionException, TransformationException, InterruptedException, ConfigurationException {
		return this.convertSchematronOutput(validateSchematronRaw());
	}

	public SchematronValidationResult validateSchematron(File schFile) throws SAXException, FileNotFoundException,
			RuleSetDetectionException, TransformationException, InterruptedException, ConfigurationException {
		this.cdaFile = schFile;
		return this.convertSchematronOutput(validateSchematronRaw());
	}

	/**
	 * Do a Schematron validation of the file, with the current configuration
	 *
	 * @return SchematronOutput
	 * @throws FileNotFoundException
	 * @throws RuleSetDetectionException
	 * @throws TransformationException
	 * @throws InterruptedException
	 * @throws ConfigurationException
	 */
	public SchematronOutput validateSchematronRaw() throws SAXException, FileNotFoundException,
			RuleSetDetectionException, TransformationException, InterruptedException, ConfigurationException {

		if (this.configuration == null)
			throw new ConfigurationException("No configuration available");
		if (this.cdaFile == null)
			throw new ConfigurationException("No CDA-File to validate");

		RuleSet[] ruleSetList = this.configuration.getRuleSetList();
		Source source = new StreamSource(this.cdaFile);
		RuleSet ruleSet = reportBuilder.detectRuleSet(source, ruleSetList);

		InputStream in = new BufferedInputStream(new FileInputStream(this.cdaFile));
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Properties parameters = new Properties();
		if (langCode != null && !langCode.isEmpty())
			parameters.put("uiLanguage", langCode);

		byte[] svrlReport = reportBuilder.createSvrlReport(ruleSet, in, out, parameters);

		return createSchematronOutput(new ByteArrayInputStream(svrlReport));
	}

	/**
	 * Do a Schematron validation of the file, with the current configuration
	 *
	 * @param schFile
	 * @return
	 * @throws FileNotFoundException
	 * @throws RuleSetDetectionException
	 * @throws TransformationException
	 * @throws InterruptedException
	 * @throws ConfigurationException
	 */
	public SchematronOutput validateSchematronRaw(File schFile) throws SAXException, FileNotFoundException,
			RuleSetDetectionException, TransformationException, InterruptedException, ConfigurationException {
		this.cdaFile = schFile;
		return validateSchematronRaw();
	}

	private void validateXsd() throws SAXException, IOException {
		Schema schema = this.schema;
		Validator validator = schema.newValidator();
		validator.validate(new StreamSource(this.cdaFile));
	}

	/**
	 * Do a XSD validation of the file, with the given configuration
	 *
	 * @return XsdValidationResult
	 * @throws ConfigurationException
	 */
	public XsdValidationResult validateXSD() throws ConfigurationException {
		if (this.configuration == null)
			throw new ConfigurationException("No configuration available");
		if (this.cdaFile == null)
			throw new ConfigurationException("No XSD-File to validate");
		XsdValidationResult xsdValRes = new XsdValidationResult();
		try {
			validateXsd();
			xsdValRes.setXsdValid(true);
			xsdValRes.setXsdValidationMsg("XSD Valid");
		} catch (SAXException | IOException e) {
			xsdValRes.setXsdValid(false);
			xsdValRes.setXsdValidationMsg(e.getMessage());
		}
		return xsdValRes;
	}

	/**
	 * Do a XSD validation of the file, with the current configuration
	 *
	 * @param xsdFile
	 *            to validate
	 * @return XsdValidationResult
	 * @throws ConfigurationException
	 */
	public XsdValidationResult validateXSD(File xsdFile) throws ConfigurationException {
		this.cdaFile = xsdFile;
		return validateXSD();
	}
}
