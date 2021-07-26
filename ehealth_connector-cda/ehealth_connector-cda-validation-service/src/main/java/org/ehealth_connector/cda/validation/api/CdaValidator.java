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

package org.ehealth_connector.cda.validation.api;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

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

import org.ehealth_connector.common.utils.Util;
import org.ehealth_connector.validation.service.config.Configuration;
import org.ehealth_connector.validation.service.config.ConfigurationException;
import org.ehealth_connector.validation.service.config.Configurator;
import org.ehealth_connector.validation.service.config.bind.InsufficientMemoryReaction;
import org.ehealth_connector.validation.service.config.bind.MaxWaitReaction;
import org.ehealth_connector.validation.service.enums.Severity;
import org.ehealth_connector.validation.service.pdf.PdfValidationResult;
import org.ehealth_connector.validation.service.pdf.PdfValidationResultEntry;
import org.ehealth_connector.validation.service.pdf.PdfValidator;
import org.ehealth_connector.validation.service.pdf.VeraPdfValidationResult;
import org.ehealth_connector.validation.service.pdf.VeraPdfValidationResultEntry;
import org.ehealth_connector.validation.service.pdf.VeraPdfValidator;
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

	/**
	 * Create a new configuration for the validator
	 *
	 * @param file
	 *            Configuration file
	 * @return A valid configuration
	 * @throws ConfigurationException
	 *
	 */
	public static Configuration configure(File file) throws ConfigurationException {
		try {
			if (file == null) {
				throw new ConfigurationException("No configuration file specified.");
			}
			final Configurator configurator = new Configurator(file);
			final Configuration configuration = configurator.createConfiguration();
			return configuration;
		} catch (final ConfigurationException e) {
			throw new ConfigurationException("Configuration error: " + e.getMessage());
		}
	}

	/** The SLF4J logger instance. */
	private final Logger log = LoggerFactory.getLogger(getClass());
	/** Configuration of the validator */
	private Configuration configuration = null;
	/** Validators to be used */
	private Validators validators = null;
	/** ReportBuilder for schematron results */
	private ReportBuilder reportBuilder = null;
	/** Result of the validation */
	private ValidationResult validationResult = null;
	/** List of available Rule Sets */
	private Collection<RuleSet> ruleSetList = null;

	/** PDF Validator */
	private PdfValidator pdfValidator = null;
	/** veraPDF Validator */
	private VeraPdfValidator veraPdfValidator = null;
	/** Indicator to use veraPDF Validator */
	private boolean useVeraPdfValidator = false;

	/**
	 * Default constructor
	 *
	 */
	public CdaValidator() {
	}

	/**
	 * Constructor initializes configuration only
	 *
	 * @param config
	 *            The configuration
	 */
	public CdaValidator(Configuration config) throws ConfigurationException {
		initialize(config);
	}

	/**
	 * Constructor initializes configuration only
	 *
	 * @param configFile
	 *            The configuration file with following attributes: baseDir,
	 *            document-schema, pdf-level, pdf-reporting-level, pdf validator
	 *            license-key, schematron rule-set
	 * @throws ConfigurationException
	 *             If the configuration fails, an exception will be thrown
	 */
	public CdaValidator(File configFile) throws ConfigurationException {
		initialize(configFile);
	}

	/**
	 * Checks whether the configuration contains a valid PDF level.
	 *
	 * @return true the configuration contains a valid PDF level, false
	 *         otherwise
	 * @throws ConfigurationException
	 */
	private boolean checkConfiguredPdfLevel() throws ConfigurationException {
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
			throw new ConfigurationException("Configuration error: " + errorMsg);
		}

		return retVal;
	}

	/**
	 * Checks whether the configuration contains a valid reporting level.
	 *
	 * @return true the configuration contains a valid reporting level, false
	 *         otherwise
	 * @throws ConfigurationException
	 */
	private boolean checkConfiguredReportingLevel() throws ConfigurationException {
		boolean retVal = false;
		String reportingLevel = this.configuration.getPdfReportingLevel();
		if (reportingLevel == null)
			reportingLevel = "not set";
		// 0: none Nothing is reported
		if (!retVal)
			retVal = (reportingLevel.equals("0"));

		// 1: errors Errors are reported
		if (!retVal)
			retVal = (reportingLevel.equals("1"));

		// 2: warnings Errors and warnings are reported
		if (!retVal)
			retVal = (reportingLevel.equals("2"));

		// 3: information Error, warnings and information are reported
		if (!retVal)
			retVal = (reportingLevel.equals("3"));

		if (!retVal) {
			String errorMsg = "Invalid pdf-reporting-level specified: " + reportingLevel;
			log.error(errorMsg);
			throw new ConfigurationException("Configuration error: " + errorMsg);
		}

		return retVal;
	}

	/**
	 * Converts the raw schematron validation output to
	 * SchematronValidationResult, with either successful-report oder
	 * failed-assert and the associated active-pattern and fired-rule
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
		schValRes.setRuleSet(schOut.getRuleSet());
		schValRes.setSourceFile(schOut.getSourceFile());

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

			} while (schIter.hasNext());
			schValRes.getActivePatternResultFull().add(currentApResult);
		}
		return schValRes;
	}

	/**
	 * Instantiate JAXB classes of the schematron XML validation output
	 *
	 * @param in
	 *            the input stream
	 * @return Instantiated classes from svrl.xml
	 */
	private SchematronOutput createSchematronOutput(ByteArrayInputStream in) {

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(SchematronOutput.class);
			final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (SchematronOutput) jaxbUnmarshaller.unmarshal(in);
		} catch (final JAXBException e) {
		}
		return null;
	}

	/**
	 * Creates the internal validators
	 *
	 * @param configuration
	 *            the configuration to be used
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
	 * Gets the current configuration
	 *
	 * @return current configuration
	 */
	public Configuration getConfiguration() {
		return this.configuration;
	}

	/**
	 * Gets the pdf validator.
	 *
	 * @return the pdf validator
	 */
	public PdfValidator getPdfValidator() {
		return pdfValidator;
	}

	/**
	 * Gets the vera pdf validator.
	 *
	 * @return the vera pdf validator
	 */
	public VeraPdfValidator getVeraPdfValidator() {
		return veraPdfValidator;
	}

	/**
	 * Returns the validator's work directory
	 *
	 * @return the validator's work directory
	 */
	public File getWorkDir() {
		File retVal = null;
		if (this.configuration != null)
			retVal = this.configuration.getWorkDir();
		return retVal;
	}

	/**
	 * Initializes the class.
	 *
	 * @param config
	 *            the configuration
	 * @throws ConfigurationException
	 *             the configuration exception
	 */
	private void initialize(Configuration config) throws ConfigurationException {

		this.configuration = config;
		this.ruleSetList = config.getRuleSetList();
		this.validators = createValidators(this.configuration);
		this.reportBuilder = new ReportBuilder(validators, ruleSetList);

		if (this.configuration.getLicenseKey() != null) {
			if (checkConfiguredPdfLevel() && checkConfiguredReportingLevel()) {
				this.pdfValidator = new PdfValidator(this.configuration);
			}
		} else {
			log.info("Use of veraPdfValidator");
			this.veraPdfValidator = new VeraPdfValidator(this.configuration);
			useVeraPdfValidator = true;
			log.info("Initialization of veraPdfValidator succeed");
		}
	}

	/**
	 * Initializes the class.
	 *
	 * @param configFile
	 *            the config file
	 * @throws ConfigurationException
	 *             the configuration exception
	 */
	private void initialize(File configFile) throws ConfigurationException {

		initialize(configure(configFile));
	}

	/**
	 * Indicates if the veraPDF validator is used for PDF validation.
	 *
	 * @return true, if the veraPDF validator is used for PDF validation
	 */
	public boolean isUseVeraPdfValidator() {
		return useVeraPdfValidator;
	}

	/**
	 * Loads the XML Schema to be used for schema validation
	 *
	 * @param schemaPath
	 *            path and filename to the XSD
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
	 * Sets the configuration
	 *
	 * @param config
	 *            The configuration
	 * @throws ConfigurationException
	 *             If the configuration fails, an exception will be thrown
	 */
	public void setConfiguration(Configuration config) throws ConfigurationException {
		initialize(config);
	}

	/**
	 * initializes the configuration
	 *
	 * @param configFile
	 *            The configuration file with following attributes: baseDir,
	 *            document-schema, pdf-level, pdf-reporting-level, pdf validator
	 *            license-key, schematron rule-set
	 * @throws ConfigurationException
	 *             If the configuration fails, an exception will be thrown
	 */
	public void setConfiguration(File configFile) throws ConfigurationException {
		initialize(configFile);
	}

	/**
	 * Executes a XSD, a Schematron and the PDF validation (if a license key is
	 * provided)
	 *
	 * @param cdaByteArray
	 *            the CDA document to be validated
	 * @return ValidationResult object, containing of all results
	 * @throws ConfigurationException
	 */
	public ValidationResult validate(byte[] cdaByteArray) {
		return validate(new StreamSource(new ByteArrayInputStream(cdaByteArray)));
	}

	/**
	 * Executes a XSD, a Schematron and the PDF validation (if a license key is
	 * provided)
	 *
	 * @param cdaFile
	 *            the CDA document to be validated
	 * @return ValidationResult object, containing of all results
	 * @throws ConfigurationException
	 */
	public ValidationResult validate(File cdaFile) {
		return validate(new StreamSource(cdaFile));
	}

	/**
	 * Executes a XSD, a Schematron and the PDF validation (if a license key is
	 * provided)
	 *
	 * @param cdaStream
	 *            the CDA document to be validated
	 * @return ValidationResult object, containing of all results
	 * @throws ConfigurationException
	 */
	public ValidationResult validate(StreamSource cdaStream) {
		validationResult = new ValidationResult();
		validationResult.setXsdValidationResult(validateXsd(cdaStream));
		validationResult.setSchValidationResult(validateSch(cdaStream));
		if (useVeraPdfValidator)
			validationResult.setVeraPdfValRes(validateVeraPdf(cdaStream));
		else
			validationResult.setPdfValidationResult(validatePdf(cdaStream));
		return validationResult;
	}

	/**
	 * Executes a PDF validation of the given CDA document
	 *
	 * @param cdaByteArray
	 *            the CDA document to be validated
	 * @return ArrayList of PDF Validation results
	 */
	public PdfValidationResult validatePdf(byte[] cdaByteArray) {
		return validatePdf(new StreamSource(new ByteArrayInputStream(cdaByteArray)));
	}

	/**
	 * Executes a PDF validation of the given CDA document
	 *
	 * @param cdaFile
	 *            the CDA document to be validated
	 * @return ArrayList of PDF Validation results
	 */
	public PdfValidationResult validatePdf(File cdaFile) {
		return validatePdf(new StreamSource(cdaFile));
	}

	/**
	 * Executes a PDF validation of the given CDA document
	 *
	 * @param cdaStream
	 *            the CDA document to be validated
	 * @return ArrayList of PDF Validation results
	 */
	public PdfValidationResult validatePdf(StreamSource cdaStream) {
		PdfValidationResult retVal = new PdfValidationResult();

		String errorMsg = null;
		if (this.configuration == null)
			errorMsg = "No configuration available";
		if (cdaStream == null)
			errorMsg = "No CDA-Document provided for validation";

		if (errorMsg == null) {
			log.info("Start of PDF validation");
			if (pdfValidator != null) {
				retVal.setReportingLevel(pdfValidator.getReportingLevel());
				retVal.setPdfConformanceLevel(pdfValidator.getPdfConformanceLevel());
				try {
					// make sure we read the stream from the beginning
					InputStream is = cdaStream.getInputStream();
					if (is != null)
						cdaStream.getInputStream().reset();
					pdfValidator.validateCda(cdaStream);
				} catch (ConfigurationException | SaxonApiException | IOException e) {
					PdfValidationResultEntry failure = new PdfValidationResultEntry();
					failure.setErrMsg(e.getClass().getName() + ":" + e.getMessage(),
							Severity.Error);
					failure.setLineNumber("none");
					retVal.add(failure);
				}
				retVal = pdfValidator.getPdfValidationResults();
			}
			log.info("End of PDF validation");
		} else {
			PdfValidationResultEntry failure = new PdfValidationResultEntry();
			failure.setErrMsg(errorMsg, Severity.Error);
			failure.setLineNumber("none");
			retVal.add(failure);
		}

		return retVal;
	}

	/**
	 * Executes a Schematron validation of the given CDA document
	 *
	 * @param cdaByteArray
	 *            the CDA document to be validated
	 * @return the Schematron validation results
	 */
	public SchematronValidationResult validateSch(byte[] cdaByteArray) {
		return validateSch(new StreamSource(new ByteArrayInputStream(cdaByteArray)));
	}

	/**
	 * Executes a Schematron validation of the given CDA document
	 *
	 * @param cdaFile
	 *            the CDA document to be validated
	 * @return the Schematron validation results
	 */
	public SchematronValidationResult validateSch(File cdaFile) {
		return validateSch(new StreamSource(cdaFile));
	}

	/**
	 * Executes a Schematron validation of the given CDA document
	 *
	 * @param cdaStream
	 *            the CDA document to be validated
	 * @return the Schematron validation results
	 */
	public SchematronValidationResult validateSch(StreamSource cdaStream) {

		SchematronValidationResult schValRes = null;

		String errorMsg = null;
		if (this.configuration == null)
			errorMsg = "No configuration available";
		if (cdaStream == null)
			errorMsg = "No CDA-Document provided for validation";

		// Initialize
		long requiredMemory = -1;
		long timeoutMaxMillis = -1;
		long timeoutSleep = -1;
		long timeoutMax = -1;
		InsufficientMemoryReaction insufficientMemoryReaction = null;
		MaxWaitReaction timeoutReaction = null;
		if (errorMsg == null) {
			try {
				// make sure we read the stream from the beginning
				InputStream is = cdaStream.getInputStream();
				if (is != null)
					cdaStream.getInputStream().reset();
				insufficientMemoryReaction = configuration.getInsufficientMemoryReaction();
				requiredMemory = configuration.getMinimalRequiredMemory();
				timeoutMax = configuration.getTimeoutMax();
				timeoutMaxMillis = (timeoutMax * 1000);
				timeoutSleep = configuration.getTimeoutSleep();
				timeoutReaction = configuration.getTimeoutReaction();

				log.debug("Schematron validation configuration - requiredMemory: "
						+ Long.toString(requiredMemory / (1024 * 1024)) + "m");
				log.debug("Schematron validation configuration - insufficientMemoryReaction: "
						+ insufficientMemoryReaction);
				log.debug("Schematron validation configuration - timeoutSleep: "
						+ Long.toString(timeoutSleep) + "ms");
				log.debug("Schematron validation configuration - timeoutMax: "
						+ Long.toString(timeoutMax) + "s");
				log.debug("Schematron validation configuration - timeoutReaction: "
						+ timeoutReaction);

			} catch (ConfigurationException | IOException e1) {
				errorMsg = e1.getCause().getMessage() + ":" + e1.getMessage();
			}
		}

		if (errorMsg == null) {
			boolean doValidate = false;

			// Check minimum Java heap space
			switch (insufficientMemoryReaction) {
			case RETURN_VALIDATION_ERROR:
				doValidate = (Runtime.getRuntime().freeMemory() >= requiredMemory);
				if (!doValidate) {
					errorMsg = "Insufficient memory (available: "
							+ Long.toString(Runtime.getRuntime().freeMemory() / (1024 * 1024))
							+ "m; configured minimum: "
							+ Long.toString(requiredMemory / (1024 * 1024)) + "m)";
					log.error(errorMsg);
					schValRes = new SchematronValidationResult();
					schValRes.setException(errorMsg);
					schValRes.setSourceFile(null);
				}
				break;
			case SLEEP:
				boolean doAbort = false;
				doValidate = (Runtime.getRuntime().freeMemory() >= requiredMemory);
				long startTimeMillis = System.currentTimeMillis();
				long endTimeMillis = startTimeMillis + timeoutMaxMillis;
				if (!doValidate)
					log.debug("Waiting for memory (currently available: "
							+ Long.toString(Runtime.getRuntime().freeMemory() / (1024 * 1024))
							+ "m; configured minimum: "
							+ Long.toString(requiredMemory / (1024 * 1024)) + "m)");

				while (!doValidate && !doAbort) {
					try {
						Util.freeMemory();
						Thread.sleep(timeoutSleep);

					} catch (InterruptedException e) {
					}
					doValidate = (Runtime.getRuntime().freeMemory() >= requiredMemory);
					doAbort = (System.currentTimeMillis() > endTimeMillis);
				}
				if (doValidate)
					log.debug("Waiting for memory was not worth it (currently available: "
							+ Long.toString(Runtime.getRuntime().freeMemory() / (1024 * 1024))
							+ "m; configured minimum: "
							+ Long.toString(requiredMemory / (1024 * 1024)) + "m)");
				else
					log.debug("Waiting for memory was worth it (currently available: "
							+ Long.toString(Runtime.getRuntime().freeMemory() / (1024 * 1024))
							+ "m; configured minimum: "
							+ Long.toString(requiredMemory / (1024 * 1024)) + "m)");
				if (doAbort) {
					errorMsg = "Insufficient memory (timeout reached after "
							+ Long.toString(timeoutMax) + " seconds; currently available: "
							+ Long.toString(Runtime.getRuntime().freeMemory() / (1024 * 1024))
							+ "m; configured minimum: "
							+ Long.toString(requiredMemory / (1024 * 1024)) + "m)";
					switch (timeoutReaction) {
					case RETURN_VALIDATION_ERROR:
						log.error("Aborting validation - returning validation error: " + errorMsg);
						schValRes = new SchematronValidationResult();
						schValRes.setException(errorMsg);
						schValRes.setSourceFile(null);
						break;
					case THROW_EXCEPTION:
						log.error("Aborting validation - throwing OutOfMemoryError: " + errorMsg);
						throw new OutOfMemoryError(errorMsg);
					default:
						schValRes = new SchematronValidationResult();
						schValRes.setException("Invalid configuration value for TimeoutReaction ("
								+ timeoutReaction + ")");
						schValRes.setSourceFile(null);
					}
				}
				break;
			case THROW_EXCEPTION:
				// default behavior.
				// java.lang.OutOfMemoryError can be thrown by the underlying
				// methods.
				doValidate = true;
				break;
			default:
				schValRes = new SchematronValidationResult();
				schValRes
						.setException("Invalid configuration value for InsufficientMemoryReaction ("
								+ insufficientMemoryReaction + ")");
				schValRes.setSourceFile(null);
				break;
			}

			if (doValidate) {
				Util.logAvailableMemory(getClass(), "Schematron validation (before)");
				try {
					final SchematronOutput schOut = validateSchRaw(cdaStream);
					if (schOut != null)
						schValRes = convertSchematronOutput(schOut);
					else {
						log.error("Schematron validation failed: validateSchRaw returned null");
						schValRes = new SchematronValidationResult();
						schValRes.setException(
								"Schematron validation failed: validateSchRaw returned null");
						schValRes.setSourceFile(null);
					}

				} catch (SAXException | RuleSetDetectionException | TransformationException
						| InterruptedException | ConfigurationException | OutOfMemoryError e) {
					log.error("Schematron validation failed: " + e.getMessage());
					schValRes = new SchematronValidationResult();
					schValRes.setException(e.getMessage());
					schValRes.setSourceFile(null);
				}
				Util.logAvailableMemory(getClass(), "Schematron validation (after)");
			} else {
				log.error("Schematron validation not performed due to insufficient memory");
			}

		} else {
			errorMsg = "Configuration error: " + errorMsg;
			log.error(errorMsg);
			schValRes = new SchematronValidationResult();
			schValRes.setException(errorMsg);
			schValRes.setSourceFile(null);
		}

		Util.freeMemory();

		return schValRes;
	}

	/**
	 * Executes a raw Schematron validation of the given CDA document
	 *
	 * @param cdaFile
	 *            the CDA document to be validated
	 * @return the raw Schematron validation results
	 * @throws SAXException
	 * @throws FileNotFoundException
	 * @throws RuleSetDetectionException
	 * @throws TransformationException
	 * @throws InterruptedException
	 * @throws ConfigurationException
	 */
	public SchematronOutput validateSchRaw(File cdaFile)
			throws SAXException, FileNotFoundException, RuleSetDetectionException,
			TransformationException, InterruptedException, ConfigurationException {
		return validateSchRaw(new StreamSource(cdaFile));
	}

	/**
	 * Executes a raw Schematron validation of the given CDA document
	 *
	 * @param cdaStream
	 *            the CDA document to be validated
	 * @return the raw Schematron validation results
	 * @throws SAXException
	 * @throws RuleSetDetectionException
	 * @throws TransformationException
	 * @throws InterruptedException
	 * @throws ConfigurationException
	 */
	public SchematronOutput validateSchRaw(StreamSource cdaStream)
			throws SAXException, RuleSetDetectionException, TransformationException,
			InterruptedException, ConfigurationException {

		SchematronOutput retVal = null;

		if (this.configuration == null)
			throw new ConfigurationException("No configuration available");
		if (cdaStream == null)
			throw new ConfigurationException("No CDA-Document provided for validation");

		try {
			// make sure we read the stream from the beginning
			InputStream is = cdaStream.getInputStream();
			if (is != null)
				cdaStream.getInputStream().reset();
		} catch (IOException e) {
			// Do nothing
		}
		final RuleSet ruleSet = reportBuilder.detectRuleSet(cdaStream);

		try {
			InputStream is = cdaStream.getInputStream();
			if (is != null)
				cdaStream.getInputStream().reset();
		} catch (IOException e) {
			// Do nothing
		}

		final ByteArrayOutputStream out = new ByteArrayOutputStream();

		final byte[] svrlReport = reportBuilder.createSvrlReport(ruleSet,
				configuration.getWorkDir(), cdaStream, out, null);
		if (svrlReport != null) {
			retVal = createSchematronOutput(new ByteArrayInputStream(svrlReport));
			retVal.setRuleSet(ruleSet);
			retVal.setSourceFile(null);
		}

		return retVal;
	}

	/**
	 * Executes a veraPDF validation of the given CDA document
	 *
	 * @param cdaByteArray
	 *            the CDA document to be validated
	 * @return ArrayList of PDF Validation results
	 */
	public VeraPdfValidationResult validateVeraPdf(byte[] cdaByteArray) {
		return validateVeraPdf(new StreamSource(new ByteArrayInputStream(cdaByteArray)));
	}

	/**
	 * Executes a veraPDF validation of the given CDA document
	 *
	 * @param cdaFile
	 *            the CDA document to be validated
	 * @return ArrayList of PDF Validation results
	 */
	public VeraPdfValidationResult validateVeraPdf(File cdaFile) {
		return validateVeraPdf(new StreamSource(cdaFile));
	}

	/**
	 * Executes a veraPDF validation of the given CDA document
	 *
	 * @param cdaStream
	 *            the CDA document to be validated
	 * @return ArrayList of PDF Validation results
	 */
	public VeraPdfValidationResult validateVeraPdf(StreamSource cdaStream) {
		VeraPdfValidationResult retVal = new VeraPdfValidationResult();
		String errorMsg = null;
		if (this.configuration == null)
			errorMsg = "No configuration available";
		if (cdaStream == null)
			errorMsg = "No CDA-Document provided for validation";
		if (errorMsg == null) {
			log.info("Start of veraPDF validation");
			try {
				// make sure we read the stream from the beginning
				InputStream is = cdaStream.getInputStream();
				if (is != null)
					cdaStream.getInputStream().reset();
				veraPdfValidator.validateCda(cdaStream);
			} catch (ConfigurationException | SaxonApiException | IOException e) {
				VeraPdfValidationResultEntry failure = new VeraPdfValidationResultEntry();
				failure.setErrMsg(e.getClass().getName() + ":" + e.getMessage(), Severity.Error);
				failure.setLineNumber("none");
				retVal.add(failure);
			}
			retVal = veraPdfValidator.getPdfValidationResults();

			log.info("End of PDF validation");
		} else {
			VeraPdfValidationResultEntry failure = new VeraPdfValidationResultEntry();
			failure.setErrMsg(errorMsg, Severity.Error);
			failure.setLineNumber("none");
			retVal.add(failure);
		}

		return retVal;
	}

	/**
	 * Executes a XSD validation of the given CDA document
	 *
	 * @param cdaByteArray
	 *            the CDA document to be validated
	 * @return the schema validation result
	 * @throws ConfigurationException
	 */
	public XsdValidationResult validateXsd(byte[] cdaByteArray) {
		return validateXsd(new StreamSource(new ByteArrayInputStream(cdaByteArray)));
	}

	/**
	 * Executes a XSD validation of the given CDA document
	 *
	 * @param cdaFile
	 *            the CDA document to be validated
	 * @return the schema validation result
	 * @throws ConfigurationException
	 */
	public XsdValidationResult validateXsd(File cdaFile) {
		return validateXsd(new StreamSource(cdaFile));
	}

	/**
	 * Executes a XSD validation of the given CDA document
	 *
	 * @param cdaStream
	 *            the CDA document to be validated
	 * @return the schema validation result
	 * @throws ConfigurationException
	 */
	public XsdValidationResult validateXsd(StreamSource cdaStream) {
		final XsdValidationResult xsdValRes = new XsdValidationResult();

		String errorMsg = null;

		if (this.configuration == null)
			errorMsg = "No configuration available";
		if (cdaStream == null)
			errorMsg = "No CDA-Document provided for validation";

		if (errorMsg == null) {
			try {
				final Schema schema = loadSchema(configuration.getCdaDocumentSchema());
				final Validator validator = schema.newValidator();

				// make sure we read the stream from the beginning
				InputStream is = cdaStream.getInputStream();
				if (is != null)
					cdaStream.getInputStream().reset();
				validator.validate(cdaStream);
				xsdValRes.setXsdValid(true);
				xsdValRes.setXsdValidationMsg("XSD Valid");
			} catch (SAXException | IOException | ConfigurationException e) {
				xsdValRes.setXsdValid(false);
				xsdValRes.setXsdValidationMsg(e.getClass().getName() + ":" + e.getMessage());
			}
		} else {
			xsdValRes.setXsdValid(false);
			xsdValRes.setXsdValidationMsg(errorMsg);
		}
		return xsdValRes;
	}
}
