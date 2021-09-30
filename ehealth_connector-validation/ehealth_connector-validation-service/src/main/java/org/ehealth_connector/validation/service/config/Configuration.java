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

package org.ehealth_connector.validation.service.config;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.ehealth_connector.common.utils.FileUtil;
import org.ehealth_connector.validation.service.config.bind.ApplicationType;
import org.ehealth_connector.validation.service.config.bind.ConfigurationType;
import org.ehealth_connector.validation.service.config.bind.InsufficientMemoryReaction;
import org.ehealth_connector.validation.service.config.bind.MaxWaitReaction;
import org.ehealth_connector.validation.service.config.bind.RuleSetType;
import org.ehealth_connector.validation.service.config.bind.SchematronType;
import org.ehealth_connector.validation.service.schematron.RuleSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Holds the application's configuration.
 */
public class Configuration {

	/** The SLF4J logger instance. */
	private final Logger log = LoggerFactory.getLogger(getClass());

	/** The underlying unmarshalled configuration element. */
	private ConfigurationType configuration;

	/** Map object with current RuleSets. */
	private final Map<String, RuleSet> ruleSetMap = new LinkedHashMap<String, RuleSet>();

	/** Map object with current RuleSets. */
	private final Map<String, RuleSet> ruleSetOidMap = new HashMap<String, RuleSet>();

	/**
	 * Default constructor.
	 */
	public Configuration() {
		configuration = null;
	}

	/**
	 * Creates a new configuration instance wrapping the specified
	 * configuration.
	 *
	 * @param configuration
	 *            the underlying <tt>ConfigurationType</tt> instance, this
	 *            configuration should be based on.
	 * @throws ConfigurationException
	 *             the configuration exception
	 * @throws NullPointerException
	 *             if the specified configuration is <tt>null</tt>.
	 */
	public Configuration(ConfigurationType configuration) throws ConfigurationException {
		if (configuration == null) {
			throw new NullPointerException("Configuration is null.");
		}
		this.configuration = configuration;
		createRuleSetMaps(createRuleSetList());
	}

	/**
	 * Creates and returns the list of configured rule-sets.
	 *
	 * @return the list of configured rule-sets.
	 */
	protected ArrayList<RuleSet> createRuleSetList() {
		final SchematronType schematron = configuration.getSchematron();
		final ArrayList<RuleSet> ruleSetList = new ArrayList<RuleSet>();
		try {
			final File ruleSetDir = getRuleSetsDir();
			for (final RuleSetType ruleSetType : schematron.getRuleSets()) {
				ruleSetList.add(new RuleSetImpl(ruleSetType, ruleSetDir));
			}
		} catch (final ConfigurationException e) {
			log.error("RuleSet is invalid: '{}'", e);
		}
		return ruleSetList;
	}

	/**
	 * Creates the RuleSetMaps.
	 *
	 * @param ruleSetList
	 *            the rule set list
	 */
	private void createRuleSetMaps(List<RuleSet> ruleSetList) {
		ruleSetMap.clear();
		ruleSetOidMap.clear();
		for (final RuleSet ruleSet : ruleSetList) {
			ruleSetMap.put(ruleSet.getId(), ruleSet);
			if (ruleSet.getTemplateId() != null) {
				RuleSet first = null;
				if ((first = ruleSetOidMap.put(ruleSet.getTemplateId(), ruleSet)) != null) {
					final Object[] args = new Object[] { ruleSet.getTemplateId(),
							first.getPath().getName(), ruleSet.getPath().getName() };
					log.error("RuleSet OID {} is not unique." + " It was declared in '{}' and '{}'",
							args);
				}
			}
		}
	}

	/**
	 * Gets the BaseDir. If it is not set in the configuration, then the
	 * read-only system property containing the Catalina Base Dir will be
	 * returned.$ This is only used by Online CDA Validators.
	 *
	 * @return the BaseDir.
	 */
	public File getBaseDir() {

		File retVal = null;

		if (configuration == null)
			configuration = new ConfigurationType();

		String baseDir = configuration.getBaseDir();

		if (baseDir == null) {
			String catalinaBase = System.getProperty("catalina.base");
			if (catalinaBase != null)
				baseDir = new File(catalinaBase).getAbsolutePath();
		}
		if (baseDir != null)
			retVal = new File(baseDir).getAbsoluteFile();
		return retVal;
	}

	/**
	 * Gets the HL7 CDA DocumentSchema. This is the XSD to be used for CDA
	 * Schema Validation.
	 *
	 * @return the HL7 CDA DocumentSchema.
	 * @throws ConfigurationException
	 *             if the specified DocumentSchema does not exist or is invalid.
	 */
	public String getCdaDocumentSchema() throws ConfigurationException {
		String retVal = null;
		if (configuration == null)
			configuration = new ConfigurationType();
		if (configuration.getApplication() == null)
			configuration.setApplication(new ApplicationType());

		final ApplicationType application = configuration.getApplication();
		String xsd = application.getDocumentSchema();
		if (xsd != null) {
			File schema = new File(xsd);
			if (!schema.isFile()) {
				schema = new File(getBaseDir() + "/" + application.getDocumentSchema());
			}
			if (!schema.isFile()) {
				schema = new File(getConfigurationDir() + "/" + application.getDocumentSchema());
			}
			if (!schema.isFile()) {
				throw new ConfigurationException(
						"Document schema not found (baseDir: " + getBaseDir() + ")");
			}
			if (!schema.canRead()) {
				throw new ConfigurationException("Document schema is not readable");
			}
			retVal = schema.getAbsolutePath();
		}
		return retVal;
	}

	/**
	 * Gets the ConfigurationDir. This is a read-only system property containing
	 * the configuration directory of Tomcat and only used by Online CDA
	 * Validators.
	 *
	 * @return the ConfigurationDir.
	 */
	public File getConfigurationDir() {
		String configDir = System.getProperty("configuration.dir");
		return new File(configDir).getAbsoluteFile();
	}

	/**
	 * Gets the DownloadsUrl. This is only used by Online CDA Validators and
	 * therefore currently read-only.
	 *
	 * @return the DownloadsUrl.
	 */
	public String getDownloadsUrl() {
		if (configuration == null)
			configuration = new ConfigurationType();
		if (configuration.getApplication() == null)
			configuration.setApplication(new ApplicationType());

		return configuration.getApplication().getDownloadsUrl();
	}

	/**
	 * Gets the configured Insufficient Memory Reaction. Default value, if not
	 * configured: THROW_EXCEPTION On .Net use THROW_EXCEPTION
	 *
	 * @return the configured Insufficient Memory Reaction
	 */
	public InsufficientMemoryReaction getInsufficientMemoryReaction() {
		InsufficientMemoryReaction retVal = null;

		if (configuration == null)
			configuration = new ConfigurationType();
		if (configuration.getApplication() == null)
			configuration.setApplication(new ApplicationType());

		retVal = configuration.getApplication().getInsufficientMemoryReaction();

		if (retVal == null) {
			// default value
			retVal = InsufficientMemoryReaction.THROW_EXCEPTION;
		}

		return retVal;
	}

	/**
	 * Gets the LicenseKey for the external PDF-Tools PdfValidator engine.
	 *
	 * @return the the LicenseKey for the external PDF-Tools PdfValidator
	 *         engine.
	 */
	public String getLicenseKey() {
		if (configuration == null)
			configuration = new ConfigurationType();
		if (configuration.getApplication() == null)
			configuration.setApplication(new ApplicationType());

		return configuration.getApplication().getLicenseKey();
	}

	/**
	 * Gets the configured Minimal Required Memory. Default value, if not
	 * configured: 20m
	 *
	 * @return the Minimal Required Memory
	 * @throws ConfigurationException
	 */
	public long getMinimalRequiredMemory() throws ConfigurationException {
		long retVal = -1;
		if (configuration == null)
			configuration = new ConfigurationType();
		if (configuration.getApplication() == null)
			configuration.setApplication(new ApplicationType());

		String minimalMemory = configuration.getApplication().getMinimalMemorySch();
		if (minimalMemory == null) {
			// default value
			minimalMemory = "20m";
		}
		String tempValue = minimalMemory;
		long factor = 1;

		if (minimalMemory.toLowerCase().endsWith("k")) {
			tempValue = tempValue.substring(0, minimalMemory.length() - 1);
			factor = 1024;
		} else if (minimalMemory.toLowerCase().endsWith("m")) {
			tempValue = tempValue.substring(0, minimalMemory.length() - 1);
			factor = 1024 * 1024L;

		} else if (minimalMemory.toLowerCase().endsWith("g")) {
			tempValue = tempValue.substring(0, minimalMemory.length() - 1);
			factor = 1024 * 1024 * 1024L;
		}

		try {
			retVal = Long.parseLong(tempValue) * factor;
		} catch (NumberFormatException e) {
			throw new ConfigurationException(
					"minimal-memory-sch contains an invalid value: " + minimalMemory);
		}

		return retVal;
	}

	/**
	 * Gets the PdfLevel to be validated by the external PDF-Tools PdfValidator
	 * engine.
	 *
	 * @return the PdfLevel to be validated by the external PDF-Tools
	 *         PdfValidator engine.
	 */
	public String getPdfLevel() {
		if (configuration == null)
			configuration = new ConfigurationType();
		if (configuration.getApplication() == null)
			configuration.setApplication(new ApplicationType());

		return configuration.getApplication().getPdfLevel();
	}

	/**
	 * Gets the level of messages to be reported by the external PDF-Tools
	 * PdfValidator engine.
	 *
	 * @return the level of messages to be reported by the external PDF-Tools
	 *         PdfValidator engine.
	 */
	public String getPdfReportingLevel() {
		if (configuration == null)
			configuration = new ConfigurationType();
		if (configuration.getApplication() == null)
			configuration.setApplication(new ApplicationType());

		return configuration.getApplication().getPdfReportingLevel();
	}

	/**
	 * Gets the rule-set to which the specified <tt>id</tt> is mapped, or
	 * <tt>null</tt> if no such rule-set is found. This is a read-only property.
	 *
	 * @param id
	 *            the identifier of the rule-set.
	 * @return the rule-set to which the specified <tt>id</tt> is mapped, or
	 *         <tt>null</tt> if no such rule-set is found.
	 */
	public RuleSet getRuleSet(String id) {
		return ruleSetMap.get(id);
	}

	/**
	 * Gets the ordered list of all available rule-sets.
	 *
	 * @return the list of available rule-sets as an array.
	 */
	public List<RuleSet> getRuleSetList() {
		return new ArrayList<RuleSet>(ruleSetMap.values());
	}

	/**
	 * Gets the number of configured rule-sets. This is a read-only property.
	 *
	 * @return the number of configured rule-sets.
	 */
	public int getRuleSetsCount() {
		return getRuleSetList().size();
	}

	/**
	 * Gets the base directory containing the <cite>Schematron</cite> rule-sets.
	 *
	 * @return the base directory containing the <cite>Schematron</cite>
	 *         rule-sets.
	 * @throws ConfigurationException
	 *             the configuration exception
	 */
	public File getRuleSetsDir() throws ConfigurationException {
		File retVal = null;

		if (configuration == null)
			configuration = new ConfigurationType();
		if (configuration.getSchematron() == null)
			configuration.setSchematron(new SchematronType());

		String dir = configuration.getSchematron().getDirectory();
		if (dir != null) {
			File schematron = new File(dir);
			if (!schematron.getAbsoluteFile().isDirectory()) {
				schematron = new File(
						getBaseDir() + "/" + configuration.getSchematron().getDirectory());
			}
			if (!schematron.isDirectory()) {
				schematron = new File(
						getConfigurationDir() + "/" + configuration.getSchematron().getDirectory());
			}
			if (!schematron.isDirectory()) {
				throw new ConfigurationException("Schematron directory not found");
			}
			if (!schematron.canRead()) {
				throw new ConfigurationException("Schematron directory is not readable");
			}
			retVal = schematron.getAbsoluteFile();
		}
		return retVal;

	}

	/**
	 * Gets the theme (JQuery Theme). This is only used by Online CDA Validators
	 * and therefore currently read-only.
	 *
	 * @return the theme (JQuery Theme).
	 */
	public String getTheme() {
		if (configuration == null)
			configuration = new ConfigurationType();
		if (configuration.getApplication() == null)
			configuration.setApplication(new ApplicationType());

		return configuration.getApplication().getJqueryTheme();
	}

	/**
	 * Gets the maximum amount of seconds to wait in case of insufficient
	 * memory. Default value, if not configured: 30
	 *
	 * @return the timeout value in seconds
	 */
	public int getTimeoutMax() {
		Integer retVal = null;
		if (configuration == null)
			configuration = new ConfigurationType();
		if (configuration.getApplication() == null)
			configuration.setApplication(new ApplicationType());

		retVal = configuration.getApplication().getTimeoutMaxS();
		if (retVal == null) {
			// default value
			retVal = 30;
		}

		return retVal;
	}

	/**
	 * Gets the timeout reaction. Default value, if not configured:
	 * returnValidationError
	 *
	 * @return the timeout reaction
	 */
	public MaxWaitReaction getTimeoutReaction() {
		MaxWaitReaction retVal = null;

		if (configuration == null)
			configuration = new ConfigurationType();
		if (configuration.getApplication() == null)
			configuration.setApplication(new ApplicationType());

		retVal = configuration.getApplication().getTimeoutReaction();

		if (retVal == null) {
			// default value
			retVal = MaxWaitReaction.RETURN_VALIDATION_ERROR;
		}

		return retVal;
	}

	/**
	 * Gets the amount of milliseconds to sleep in case of insufficient memory.
	 * Default value, if not configured: 500
	 *
	 * @return the timeout value in milliseconds
	 */
	public Integer getTimeoutSleep() {
		Integer retVal = null;
		if (configuration == null)
			configuration = new ConfigurationType();
		if (configuration.getApplication() == null)
			configuration.setApplication(new ApplicationType());

		retVal = configuration.getApplication().getTimeoutSleepMs();
		if (retVal == null) {
			// default value
			retVal = 500;
		}

		return retVal;
	}

	/**
	 * Gets the directory where java was run from, where you started the JVM.
	 * This is a read-only system property.
	 *
	 * @return the directory where java was run from, where you started the JVM.
	 */
	public File getUserDir() {
		return new File(System.getProperty("user.dir")).getAbsoluteFile();
	}

	/**
	 * Gets the WorkDir. This the path where the CdaValidsator will store
	 * pre-compiled Schematrons.
	 *
	 * @return the WorkDir.
	 */
	public File getWorkDir() {
		if (configuration == null)
			configuration = new ConfigurationType();

		return new File(configuration.getWorkDir());
	}

	/**
	 * Sets the HL7 CDA DocumentSchema. This is the XSD to be used for CDA
	 * Schema Validation.
	 *
	 * @param cdaDocumentSchema
	 *            the HL7 CDA DocumentSchema.
	 */
	public void setCdaDocumentSchema(File cdaDocumentSchema) {
		setCdaDocumentSchema(cdaDocumentSchema.getAbsolutePath());
	}

	/**
	 * Sets the HL7 CDA DocumentSchema. This is the XSD to be used for CDA
	 * Schema Validation.
	 *
	 * @param cdaDocumentSchema
	 *            the HL7 CDA DocumentSchema.
	 */
	public void setCdaDocumentSchema(String cdaDocumentSchema) {

		if (configuration == null)
			configuration = new ConfigurationType();
		if (configuration.getApplication() == null)
			configuration.setApplication(new ApplicationType());

		configuration.getApplication().setDocumentSchema(cdaDocumentSchema);

	}

	/**
	 * Sets the LicenseKey for the external PDF-Tools PdfValidator engine.
	 *
	 * @param licenseKey
	 *            the LicenseKey for the external PDF-Tools PdfValidator engine.
	 */
	public void setLicenseKey(String licenseKey) {
		if (configuration == null)
			configuration = new ConfigurationType();
		if (configuration.getApplication() == null)
			configuration.setApplication(new ApplicationType());

		configuration.getApplication().setLicenseKey(licenseKey);
	}

	/**
	 * Sets the PdfLevel to be validated by the external PDF-Tools PdfValidator
	 * engine.
	 *
	 * @param pdfLevel
	 *            the PdfLevel to be validated by the external PDF-Tools
	 *            PdfValidator engine.
	 */
	public void setPdfLevel(String pdfLevel) {
		if (configuration == null)
			configuration = new ConfigurationType();
		if (configuration.getApplication() == null)
			configuration.setApplication(new ApplicationType());

		configuration.getApplication().setPdfLevel(pdfLevel);
	}

	/**
	 * Sets the level of messages to be reported by the external PDF-Tools
	 * PdfValidator engine.
	 *
	 * @param pdfReportingLevel
	 *            the level of messages to be reported by the external PDF-Tools
	 *            PdfValidator engine.
	 */
	public void setPdfReportingLevel(String pdfReportingLevel) {
		if (configuration == null)
			configuration = new ConfigurationType();
		if (configuration.getApplication() == null)
			configuration.setApplication(new ApplicationType());

		configuration.getApplication().setPdfReportingLevel(pdfReportingLevel);
	}

	/**
	 * Sets the list of available rule-sets.
	 *
	 * @param ruleSetList
	 *            the list of available rule-sets
	 */
	public void setRuleSetList(List<RuleSet> ruleSetList) {
		createRuleSetMaps(ruleSetList);
	}

	/**
	 * Sets the base directory containing the <cite>Schematron</cite> rule-sets.
	 *
	 * @param ruleSetsDir
	 *            the base directory containing the <cite>Schematron</cite>
	 *            rule-sets.
	 */
	public void setRuleSetsDir(File ruleSetsDir) {

		if (configuration == null)
			configuration = new ConfigurationType();
		if (configuration.getSchematron() == null)
			configuration.setSchematron(new SchematronType());

		String ruleSetPath = ruleSetsDir.getAbsolutePath();
		configuration.getSchematron().setDirectory(ruleSetPath);
		for (RuleSet ruleSet : ruleSetMap.values()) {
			File oldPath = ruleSet.getPath();
			File newPath = new File(FileUtil.combinePath(ruleSetPath, oldPath.getName()));
			ruleSet.setPath(newPath);
		}
	}

	/**
	 * Sets the base directory containing the <cite>Schematron</cite> rule-sets.
	 *
	 * @param ruleSetsDir
	 *            the base directory containing the <cite>Schematron</cite>
	 *            rule-sets.
	 */
	public void setRuleSetsDir(String ruleSetsDir) {
		setRuleSetsDir(new File(ruleSetsDir));
	}

	/**
	 * Sets the WorkDir. This the path where the CdaValidsator will store
	 * pre-compiled Schematrons.
	 *
	 * @param workDir
	 *            the WorkDir
	 */
	public void setWorkDir(File workDir) {
		configuration.setWorkDir(workDir.getAbsolutePath());
	}

	/**
	 * Sets the WorkDir. This the path where the CdaValidsator will store
	 * pre-compiled Schematrons.
	 *
	 * @param workDir
	 *            the WorkDir
	 */
	public void setWorkDir(String workDir) {
		setWorkDir(new File(workDir));
	}

}
