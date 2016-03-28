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
import ehealth_connector.validation.service.pdf.PdfValidator;
import ehealth_connector.validation.service.schematron.ReportBuilder;
import ehealth_connector.validation.service.schematron.RuleSet;
import ehealth_connector.validation.service.schematron.RuleSetDetectionException;
import ehealth_connector.validation.service.schematron.RuleSetTransformer;
import ehealth_connector.validation.service.schematron.Validators;
import ehealth_connector.validation.service.schematron.bind.SchematronOutput;
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
	
	/**
	 * Simple Constructor
	 *  
	 * @param cdaFilePath
	 * 				The CDA Document to be validated
	 */
	public CdaValidator(String cdaFilePath) {
		
	}

	/**
	 * @param cdaFilePath
	 * 				The CDA document to be validated
	 * @param configFilePath
	 * 				The configfile with following attributes
	 * 				- baseDir
	 * 				- document-schema
	 * 				- pdf-level
	 * 				- pdf-reporting-level
	 * 				- license-key
	 * 				- schematron/rule-set  
	 * @throws ConfigurationException 
	 * 				If the configuration fails, an exception will be thrown
	 */
	public CdaValidator(File cdaFile, File configFile) throws ConfigurationException {
		this.cdaFile = cdaFile;
		this.configuration = configure(configFile);
		this.validators = createValidators(this.configuration);
		this.reportBuilder = new ReportBuilder(validators);
	}
	
	// TEST: will be private in prod
	public SchematronOutput validateSchematron() throws FileNotFoundException, RuleSetDetectionException, TransformationException, InterruptedException {
		
		RuleSet[] ruleSetList = this.configuration.getRuleSetList();
		Source source = new StreamSource(this.cdaFile);
		RuleSet ruleSet = reportBuilder.detectRuleSet(source, ruleSetList);

		InputStream in = new BufferedInputStream(new FileInputStream(this.cdaFile));
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Properties parameters = new Properties();
		byte[] svrlReport = reportBuilder.createSvrlReport(ruleSet, in, out, parameters);
		
		return createSchematronOutput(new ByteArrayInputStream(svrlReport));
	}
	// TEST: will be private in prod
	public String validateXsd() {
		Schema schema = this.schema;
		Validator validator = schema.newValidator();
		try {
			validator.validate(new StreamSource(this.cdaFile));
		} catch (SAXException | IOException e) {
			return e.getMessage();
		}
		return "XSD OK";
	}

	// TEST: will be private in prod
	public String validatePDF() {

		PdfValidator pdfValidator = new PdfValidator(this.configuration);
		try {
			pdfValidator.validatePdfFile(this.cdaFile);
		} catch (SaxonApiException | IOException | ConfigurationException e) {
			return e.getMessage();
		}
		return "PDF OK";
	}

	/**
	 * Create a new configuration for the validator
	 * 
	 * @param file
	 * 			Configuration file
	 * @return	
	 * 			A valid configuration
	 * @throws ConfigurationException
	 * 
	 */
	private Configuration configure(File file) throws ConfigurationException {
		try {
			if (file == null) {
				throw new ConfigurationException("No configuration file specified.");
			}
			//log.debug(">>> Loading new configuration ...");
			Configurator configurator = new Configurator(file);
			Configuration configuration = configurator.createConfiguration();
			this.schema = loadSchema(configuration.getDocumentSchema());
			if (this.schema != null) {
				//log.info("XSD validation is turned on, using schema '{}'" + configuration.getDocumentSchema());
			} else {
				//log.info("XSD validation is turned off.");
			}
			//log.debug("<<< Configuration done.");
			return configuration;
		} catch (ConfigurationException e) {
			//log.error("<<< Configuration failed: " + e.getCause());
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
		//log.info("Loading XSD schema '" + schemaPath + "' ...");
		File schemaFile = new File(schemaPath).getAbsoluteFile();
		if (!schemaFile.canRead()) {
			//log.error("XSD schema " + schemaFile.toString() + " does not exist or can not be read.");
			return null;
		}
		Source source = new StreamSource(schemaFile);
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		factory.setErrorHandler(new ErrorHandler() {
			@Override
			public void error(SAXParseException exception) throws SAXException {
				//log.warn("XSD schema error: " + exception.getMessage());
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
			//log.error("Could not load XSD schema '" + schemaPath + "'", e);
			return null;
		}
	}

	/**
	 * @param configuration
	 * @return
	 */
	private Validators createValidators(Configuration configuration) {
		//log.debug("Building rule-set transformer ...");
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


