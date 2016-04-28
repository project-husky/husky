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
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.ehealth_connector.validation.service.config.Configuration;
import org.ehealth_connector.validation.service.config.ConfigurationException;
import org.ehealth_connector.validation.service.config.Configurator;
import org.ehealth_connector.validation.service.pdf.PdfValidationResult;
import org.ehealth_connector.validation.service.pdf.PdfValidationResultEntry;
import org.ehealth_connector.validation.service.pdf.PdfValidationResultEntry.SEVERITY;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	/** The SLF4J logger instance. */
	private final Logger log = LoggerFactory.getLogger(getClass());

	/** Configuration of the validator */
	private final Configuration configuration;
	/** Validators to be used */
	private final Validators validators;
	/** ReportBuilder for schematron results */
	private final ReportBuilder reportBuilder;
	/** XSD-schema to be used */
	private Schema schema;
	/** CDA file to be validated */
	private File cdaFile;

	private String langCode;

	private ValidationResult validationResult;

	/**
	 * Minimal constructor
	 *
	 * @param configFilePath
	 *            The configfile with following attributes - baseDir -
	 *            document-schema - pdf-level - pdf-reporting-level -
	 *            license-key - schematron/rule-set
	 * @throws ConfigurationException
	 *             If the configuration fails, an exception will be thrown
	 */
	public CdaValidator(File configFile) throws ConfigurationException {
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
	public CdaValidator(File cdaFile, File configFile, String langCode)
			throws ConfigurationException {
		this.cdaFile = cdaFile;
		this.configuration = configure(configFile);
		this.validators = createValidators(this.configuration);
		this.reportBuilder = new ReportBuilder(validators);
		this.langCode = langCode;

	}

	private boolean checkPdfLevel(PdfValidationResult result) {
		boolean retVal = false;

		String pdfLevel = this.configuration.getPdfLevel();
		if (pdfLevel == null)
			pdfLevel = "not set";

		// 1a: PDF/A 1a, ISO 19005-1, Level A compliance
		if (!retVal)
			retVal = (pdfLevel.equals("1a"));

		// 1b: PDF/A 1b, ISO 19005-1, Level B compliance
		if (!retVal)
			retVal = (pdfLevel.equals("1b"));

		// 2a: PDF/A 2a, ISO 19005-2, Level A compliance
		if (!retVal)
			retVal = (pdfLevel.equals("2a"));

		// 2b: PDF/A 2b, ISO 19005-2, Level B compliance
		if (!retVal)
			retVal = (pdfLevel.equals("2b"));

		// 2u: PDF/A 2u, ISO 19005-2, Level U compliance
		if (!retVal)
			retVal = (pdfLevel.equals("2u"));

		// 3a: PDF/A 3a, ISO 19005-3, Level A compliance
		if (!retVal)
			retVal = (pdfLevel.equals("3a"));

		// 3b: PDF/A 3b, ISO 19005-3, Level B compliance
		if (!retVal)
			retVal = (pdfLevel.equals("3b"));

		// 3u: PDF/A 3u, ISO 19005-3, Level U compliance
		if (!retVal)
			retVal = (pdfLevel.equals("3u"));

		if (!retVal) {
			String errorMsg = "Invalid pdf-level specified: " + pdfLevel;
			log.error(errorMsg);
			PdfValidationResultEntry failure = new PdfValidationResultEntry();
			failure.setErrMsg(errorMsg, SEVERITY.Error);
			failure.setLineNumber("none");
			result.add(failure);
		}

		return retVal;
	}

	private boolean checkReportingLevel(PdfValidationResult result) {
		boolean retVal = false;
		String reportingLevel = this.configuration.getPdfReportingLevel();
		if (reportingLevel == null)
			reportingLevel = "not set";
		if (!retVal)
			retVal = (reportingLevel.equals("0"));
		if (!retVal)
			retVal = (reportingLevel.equals("1"));
		if (!retVal)
			retVal = (reportingLevel.equals("2"));
		if (!retVal)
			retVal = (reportingLevel.equals("3"));

		if (!retVal) {
			String errorMsg = "Invalid pdf-reporting-level specified: " + reportingLevel;
			log.error(errorMsg);
			PdfValidationResultEntry failure = new PdfValidationResultEntry();
			failure.setErrMsg(errorMsg, SEVERITY.Error);
			failure.setLineNumber("none");
			result.add(failure);
		}

		return retVal;
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
			final Configurator configurator = new Configurator(file);
			final Configuration configuration = configurator.createConfiguration();
			this.schema = loadSchema(configuration.getDocumentSchema());
			return configuration;
		} catch (final ConfigurationException e) {
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
	 * @return The SchematronValidationResult
	 */
	private SchematronValidationResult convertSchematronOutput(SchematronOutput schOut) {

		ActivePatternResult currentApResult = null;
		Object temp = null;
		Object prevObject = null;
		final SchematronValidationResult schValRes = new SchematronValidationResult();
		schValRes.setSchematronValid(true);

		final List<Object> schOutputList = schOut.getActivePatternAndFiredRuleAndFailedAssert();

		if (!schOutputList.isEmpty()) {
			final Iterator<Object> schIter = schOutputList.iterator();
			do {
				temp = schIter.next();
				if ((temp instanceof ActivePattern) && (prevObject == null)) {
					currentApResult = new ActivePatternResult();
					currentApResult.setAp((ActivePattern) temp);
					prevObject = temp;
					continue;
				}
				if ((temp instanceof ActivePattern) && (prevObject != null)
						&& (prevObject instanceof ActivePattern)) {
					schValRes.getActivePatternResultFull().add(currentApResult);
					currentApResult = new ActivePatternResult();
					currentApResult.setAp((ActivePattern) temp);
					prevObject = temp;
					continue;
				}
				if ((temp instanceof ActivePattern) && !(prevObject instanceof ActivePattern)) {
					schValRes.getActivePatternResultFull().add(currentApResult);
					currentApResult = new ActivePatternResult();
					currentApResult.setAp((ActivePattern) temp);
					prevObject = temp;
					continue;
				}
				if (!(temp instanceof ActivePattern)) {
					if (temp instanceof FailedAssert) {
						String role = ((FailedAssert) temp).getRole();

						// if there is no role, a failed assert is always an
						// error
						if (role == null)
							role = "error";

						if (role.equals("") || role.toLowerCase().equals("error"))
							schValRes.setSchematronValid(false);

					}
					if (temp instanceof SuccessfulReport) {
						String role = ((SuccessfulReport) temp).getRole();

						// if there is no role, a successful report is never an
						// error
						if (role == null)
							role = "";

						if (role.toLowerCase().equals("error"))
							schValRes.setSchematronValid(false);

					}
					currentApResult.getApChilds().add(temp);
					prevObject = temp;
				}

				/*
				 * if (!(temp instanceof ActivePattern)) { if (temp instanceof
				 * FailedAssert) { if (((FailedAssert)
				 * temp).getRole().equals("") || ((FailedAssert)
				 * temp).getRole().toLowerCase().equals("error"))
				 * schValRes.setSchematronValid(false);
				 * currentApResult.getApChilds().add(temp); prevObject = temp; }
				 * } if (!(temp instanceof ActivePattern)) { if (temp instanceof
				 * SuccessfulReport) { if (((SuccessfulReport)
				 * temp).getRole().toLowerCase().equals("error"))
				 * schValRes.setSchematronValid(false);
				 * currentApResult.getApChilds().add(temp); prevObject = temp; }
				 * }
				 */

			} while (schIter.hasNext());
			schValRes.getActivePatternResultFull().add(currentApResult);
		}
		return schValRes;
	}

	/**
	 * Instantiate JAXB classes of the schematron XML validation output
	 *
	 * @param in
	 * @return Instantitad classes from svrl.xml
	 */
	private SchematronOutput createSchematronOutput(ByteArrayInputStream in) {

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(SchematronOutput.class);
			final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (SchematronOutput) jaxbUnmarshaller.unmarshal(in);
		} catch (final JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param configuration
	 * @return validators for the current configuration
	 */
	private Validators createValidators(Configuration configuration) {
		log.debug("Building rule-set transformer ...");

		final Processor processor = new Processor(false);

		processor.getUnderlyingConfiguration().setErrorListener(new ErrorListener() {
			@Override
			public void error(TransformerException exception) throws TransformerException {
				throw new TransformerException(exception);
			}

			@Override
			public void fatalError(TransformerException exception) throws TransformerException {
				throw new TransformerException(exception);
			}

			@Override
			public void warning(TransformerException exception) throws TransformerException {
				// Do nothing (suppress warnings)
				log.warn("XSLT TransformerException:" + exception.getMessage());
			}
		});
		final RuleSetTransformer factory = new RuleSetTransformer(processor);
		return new Validators(factory);
	}

	/**
	 * @param schemaPath
	 * @return XSD schema
	 */
	private Schema loadSchema(final String schemaPath) {
		if ((schemaPath == null) || schemaPath.isEmpty()) {
			return null;
		}
		log.info("Loading XSD schema '" + schemaPath + "' ...");
		final File schemaFile = new File(schemaPath).getAbsoluteFile();
		if (!schemaFile.canRead()) {
			log.error(
					"XSD schema " + schemaFile.toString() + " does not exist or can not be read.");
			return null;
		}
		final Source source = new StreamSource(schemaFile);
		final SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		factory.setErrorHandler(new ErrorHandler() {
			@Override
			public void error(SAXParseException exception) throws SAXException {
				log.warn("XSD schema error: " + exception.getMessage());
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
		} catch (final SAXException e) {
			log.error("Could not load XSD schema '" + schemaPath + "'", e);
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
			validateXsdSchema();
			validationResult.setXsdValid(true);
			validationResult.getXsdValidationResult().setXsdValidationMsg("XSD Valid");
		} catch (SAXException | IOException e) {
			validationResult.setXsdValid(false);
			validationResult.getXsdValidationResult().setXsdValidationMsg(e.getMessage());
		}

		try {
			final SchematronOutput schOut = validateSchRaw();
			final SchematronValidationResult schValRes = convertSchematronOutput(schOut);
			validationResult.setSchValidationResult(schValRes);

		} catch (SAXException | FileNotFoundException | RuleSetDetectionException
				| TransformationException | InterruptedException e) {
			System.out.println("Schematron validation failed: " + e.getMessage());
		}

		try {
			validationResult.setPdfValidationResult(validatePdf());
		} catch (ConfigurationException | SaxonApiException | IOException e) {
			System.out.println("PDF validation failed: " + e.getMessage());
		}
		return validationResult;
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
	 *
	 *             public ArrayList<PdfValidationResult> validatePDF(String
	 *             pdfLevel, String pdfReportingLevel, String licenseKey) throws
	 *             ConfigurationException, SaxonApiException, IOException {
	 *
	 *             //this.configuration // geht nur mühsam, da config via file
	 *             implementiert ist return validatePDF(); }
	 */

	/**
	 * Do a PDF validation of the file, with the current configuration
	 *
	 * @return ArrayList of PDF Validation results
	 * @throws ConfigurationException
	 * @throws SaxonApiException
	 * @throws IOException
	 */
	public PdfValidationResult validatePdf()
			throws ConfigurationException, SaxonApiException, IOException {

		PdfValidationResult retVal = new PdfValidationResult();
		if (this.configuration.getLicenseKey() != null) {
			if (checkPdfLevel(retVal) && checkReportingLevel(retVal)) {
				final PdfValidator pdfValidator = new PdfValidator(this.configuration);
				pdfValidator.validateCdaFile(this.cdaFile);
				retVal = pdfValidator.getPdfValidationResults();
			} else
				retVal.setIsDone();
		}
		return retVal;

	}

	/**
	 * Do a PDF validation of the file, with the current configuration
	 *
	 * @return ArrayList of PDF Validation results
	 * @throws ConfigurationException
	 * @throws SaxonApiException
	 * @throws IOException
	 */
	public PdfValidationResult validatePdf(File cdaFile)
			throws ConfigurationException, SaxonApiException, IOException {
		this.cdaFile = cdaFile;
		final PdfValidator pdfValidator = new PdfValidator(this.configuration);
		pdfValidator.validateCdaFile(this.cdaFile);

		return pdfValidator.getPdfValidationResults();
	}

	/**
	 * @return SchematronValidationResult
	 * @throws SAXException
	 * @throws FileNotFoundException
	 * @throws RuleSetDetectionException
	 * @throws TransformationException
	 * @throws InterruptedException
	 * @throws ConfigurationException
	 */
	public SchematronValidationResult validateSch()
			throws SAXException, FileNotFoundException, RuleSetDetectionException,
			TransformationException, InterruptedException, ConfigurationException {
		return this.convertSchematronOutput(validateSchRaw());
	}

	/**
	 * Do a Schematron validation of the file, with the current configuration
	 *
	 * @return Flat SchematronOutput
	 * @throws FileNotFoundException
	 * @throws RuleSetDetectionException
	 * @throws TransformationException
	 * @throws InterruptedException
	 * @throws ConfigurationException
	 */
	public SchematronValidationResult validateSch(File cdaFile)
			throws SAXException, FileNotFoundException, RuleSetDetectionException,
			TransformationException, InterruptedException, ConfigurationException {
		this.cdaFile = cdaFile;
		return this.convertSchematronOutput(validateSchRaw());
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
	public SchematronOutput validateSchRaw()
			throws SAXException, FileNotFoundException, RuleSetDetectionException,
			TransformationException, InterruptedException, ConfigurationException {

		if (this.configuration == null)
			throw new ConfigurationException("No configuration available");
		if (this.cdaFile == null)
			throw new ConfigurationException("No CDA-File to validate");

		final RuleSet[] ruleSetList = this.configuration.getRuleSetList();
		final Source source = new StreamSource(this.cdaFile);
		final RuleSet ruleSet = reportBuilder.detectRuleSet(source, ruleSetList);

		final InputStream in = new BufferedInputStream(new FileInputStream(this.cdaFile));
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		final Properties parameters = new Properties();
		if ((langCode != null) && !langCode.isEmpty())
			parameters.put("uiLanguage", langCode);

		final byte[] svrlReport = reportBuilder.createSvrlReport(ruleSet, in, out, parameters);

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
	public SchematronOutput validateSchRaw(File schFile)
			throws SAXException, FileNotFoundException, RuleSetDetectionException,
			TransformationException, InterruptedException, ConfigurationException {
		this.cdaFile = schFile;
		return validateSchRaw();
	}

	private void validateXsdSchema() throws SAXException, IOException {
		final Schema schema = this.schema;
		final Validator validator = schema.newValidator();
		validator.validate(new StreamSource(this.cdaFile));
	}

	/**
	 * Do a XSD validation of the file, with the given configuration
	 *
	 * @return XsdValidationResult
	 * @throws ConfigurationException
	 */
	public XsdValidationResult validateXsd() throws ConfigurationException {
		if (this.configuration == null)
			throw new ConfigurationException("No configuration available");
		if (this.cdaFile == null)
			throw new ConfigurationException("No CDA-File to validate");
		final XsdValidationResult xsdValRes = new XsdValidationResult();
		try {
			validateXsdSchema();
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
	public XsdValidationResult validateXsd(File xsdFile) throws ConfigurationException {
		this.cdaFile = xsdFile;
		return validateXsd();
	}

}
