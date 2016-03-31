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

package ehealth_connector.validation.service.api;

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

/*import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehealth_connector.demo.validation.DemoValidation;*/
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import ehealth_connector.validation.service.config.Configuration;
import ehealth_connector.validation.service.config.ConfigurationException;
import ehealth_connector.validation.service.config.Configurator;
import ehealth_connector.validation.service.pdf.PdfValidationResult;
import ehealth_connector.validation.service.pdf.PdfValidator;
import ehealth_connector.validation.service.schematron.ReportBuilder;
import ehealth_connector.validation.service.schematron.RuleSet;
import ehealth_connector.validation.service.schematron.RuleSetDetectionException;
import ehealth_connector.validation.service.schematron.RuleSetTransformer;
import ehealth_connector.validation.service.schematron.Validators;
import ehealth_connector.validation.service.schematron.bind.ActivePattern;
import ehealth_connector.validation.service.schematron.bind.FailedAssert;
import ehealth_connector.validation.service.schematron.bind.FiredRule;
import ehealth_connector.validation.service.schematron.bind.SchematronOutput;
import ehealth_connector.validation.service.schematron.result.ActivePatternResult;
import ehealth_connector.validation.service.schematron.result.FiredRuleResult;
import ehealth_connector.validation.service.schematron.result.SchematronValidationResult;
import ehealth_connector.validation.service.transform.TransformationException;
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

	private ValidationResult validationResult;

	/**
	 * Simple constructor with the file to be validated
	 * 
	 * @param cdaFilePath
	 *            The CDA Document to be validated
	 */
	public CdaValidator(File cdaFile) {

	}

	/**
	 * 
	 * @param cdaFilePath
	 *            The CDA document to be validated
	 * @param configFilePath
	 *            The configfile with following attributes - baseDir -
	 *            document-schema - pdf-level - pdf-reporting-level -
	 *            license-key - schematron/rule-set
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
	 * Do a XSD, a Schematron and the PDF validation (if a license key is provided)
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
			SchematronOutput schOut = validateSchematron();
			SchematronValidationResult schValRes = convertSchematronOutput(schOut);
			validationResult.setSchValRes(schValRes);

		} catch (FileNotFoundException | RuleSetDetectionException | TransformationException | InterruptedException e) {
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
	 * Do a XSD, a Schematron and the PDF validation (if a license key is provided)
	 * with the configuration passed to the method
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
	 * Do a XSD validation of the file, with the given configuration
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
	 *  Do a XSD validation of the file, with the current configuration
	 * @param xsdFile to validate
	 * @return XsdValidationResult
	 * @throws ConfigurationException
	 */
	public XsdValidationResult validateXSD(File xsdFile) throws ConfigurationException {
		this.cdaFile = xsdFile;
		return validateXSD();
	}

	/**
	 * Do a Schematron validation of the file, with the current configuration
	 * @return SchematronOutput
	 * @throws FileNotFoundException
	 * @throws RuleSetDetectionException
	 * @throws TransformationException
	 * @throws InterruptedException
	 * @throws ConfigurationException
	 */
	public SchematronOutput validateSchematron() throws FileNotFoundException, RuleSetDetectionException,
			TransformationException, InterruptedException, ConfigurationException {

		if (this.configuration == null)
			throw new ConfigurationException("No configuration available");
		if (this.cdaFile == null)
			throw new ConfigurationException("No Schematron-File to validate");

		RuleSet[] ruleSetList = this.configuration.getRuleSetList();
		Source source = new StreamSource(this.cdaFile);
		RuleSet ruleSet = reportBuilder.detectRuleSet(source, ruleSetList);

		InputStream in = new BufferedInputStream(new FileInputStream(this.cdaFile));
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Properties parameters = new Properties();
		byte[] svrlReport = reportBuilder.createSvrlReport(ruleSet, in, out, parameters);

		return createSchematronOutput(new ByteArrayInputStream(svrlReport));
	}

	/**
	 * Do a Schematron validation of the file, with the current configuration
	 * @param schFile
	 * @return
	 * @throws FileNotFoundException
	 * @throws RuleSetDetectionException
	 * @throws TransformationException
	 * @throws InterruptedException
	 * @throws ConfigurationException
	 */
	public SchematronOutput validateSchematron(File schFile) throws FileNotFoundException, RuleSetDetectionException,
			TransformationException, InterruptedException, ConfigurationException {
		this.cdaFile = schFile;
		return validateSchematron();
	}

	/**
	 * Do a PDF validation of the file, with the current configuration
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

		// geht nur mühsam, da config via file implementiert ist
		return validatePDF();
	}

	private void validateXsd() throws SAXException, IOException {
		Schema schema = this.schema;
		Validator validator = schema.newValidator();
		validator.validate(new StreamSource(this.cdaFile));
	}

	/**
	 * Converts the raw SchematronOutput to SchematronValidationResult,
	 * with either succesful-report oder failed-assert and the associated active-pattern and fired-rule
	 *   
	 * @param schOut Raw SchematronOutput
	 * @return
	 */
	private SchematronValidationResult convertSchematronOutput(SchematronOutput schOut) {

		ActivePattern currentAP = null;
		ActivePatternResult tempAP = null;
		FiredRule currentFR = null;
		Object prevTemp = null;
		SchematronValidationResult schValRes = new SchematronValidationResult();

		List<Object> schOutputList = schOut.getActivePatternAndFiredRuleAndFailedAssert();

		if (!schOutputList.isEmpty()) {
			Iterator<Object> schIter = schOutputList.iterator();
			do {
				Object temp = schIter.next();
				if (temp instanceof ActivePattern) {
					currentAP = (ActivePattern) temp;
					if (prevTemp != null && prevTemp instanceof FailedAssert)
						schValRes.getActivePatternResult().add(tempAP);
				}
				if (temp instanceof FiredRule) {
					currentFR = (FiredRule) temp;
					if (prevTemp != null && prevTemp instanceof FailedAssert)
						schValRes.getActivePatternResult().add(tempAP);
				}
				if (temp instanceof FailedAssert) {
					FiredRuleResult tempFR = new FiredRuleResult(currentFR);
					tempFR.setFailedAssert((FailedAssert) temp);
					tempAP = new ActivePatternResult();
					tempAP.setAp(currentAP);
					tempAP.getFiredRileList().add(tempFR);
				}
				prevTemp = temp;
			} while (schIter.hasNext());
		}
		return schValRes;
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
			// log.debug(">>> Loading new configuration ...");
			Configurator configurator = new Configurator(file);
			Configuration configuration = configurator.createConfiguration();
			this.schema = loadSchema(configuration.getDocumentSchema());
			if (this.schema != null) {
				// log.info("XSD validation is turned on, using schema '{}'" +
				// configuration.getDocumentSchema());
			} else {
				// log.info("XSD validation is turned off.");
			}
			// log.debug("<<< Configuration done.");
			return configuration;
		} catch (ConfigurationException e) {
			// log.error("<<< Configuration failed: " + e.getCause());
			throw e;
		}
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
	 * @param configuration
	 * @return
	 */
	private Validators createValidators(Configuration configuration) {
		// log.debug("Building rule-set transformer ...");
		RuleSetTransformer factory = new RuleSetTransformer(new Processor(false));
		return new Validators(factory);
	}

	private SchematronOutput createSchematronOutput(ByteArrayInputStream in) {
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(SchematronOutput.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (SchematronOutput) jaxbUnmarshaller.unmarshal(in);

		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}

	}
}
