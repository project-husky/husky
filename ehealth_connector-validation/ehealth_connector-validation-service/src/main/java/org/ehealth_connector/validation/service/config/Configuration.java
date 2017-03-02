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

package org.ehealth_connector.validation.service.config;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.ehealth_connector.common.utils.FileUtil;
import org.ehealth_connector.validation.service.config.bind.ApplicationType;
import org.ehealth_connector.validation.service.config.bind.ConfigurationType;
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
	private final ConfigurationType configuration;

	/** Map object with current RuleSets */
	private final Map<String, RuleSet> ruleSetMap = new LinkedHashMap<String, RuleSet>();

	/** Map object with current RuleSets */
	private final Map<String, RuleSet> ruleSetOidMap = new HashMap<String, RuleSet>();

	/**
	 * Creates a new configuration instance wrapping the specified
	 * configuration.
	 *
	 * @param configuration
	 *            the underlying <tt>ConfigurationType</tt> instance, this
	 *            configuration should be based on.
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
	protected List<RuleSet> createRuleSetList() {
		final SchematronType schematron = configuration.getSchematron();
		final List<RuleSet> ruleSetList = new ArrayList<RuleSet>();
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
	 */
	private void createRuleSetMaps(Collection<RuleSet> ruleSetList) {
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
	 * Gets the BaseDir. This is a read-only system property containing the
	 * Catalina Base Dir and only used by Online CDA Validators.
	 *
	 * @return the BaseDir.
	 */
	public File getBaseDir() {
		return configuration.getBaseDir();
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
		final ApplicationType application = configuration.getApplication();
		if (application != null) {
			File schema = new File(application.getDocumentSchema());
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
			return schema.getAbsolutePath();
		}
		return null;
	}

	/**
	 * Gets the ConfigurationDir. This is a read-only system property containing
	 * the configuration directory of Tomcat and only used by Online CDA
	 * Validators.
	 *
	 * @return the ConfigurationDir.
	 */
	public File getConfigurationDir() {
		return configuration.getConfigurationDir();
	}

	/**
	 * Gets the DownloadsUrl. This is only used by Online CDA Validators and
	 * therefore currently read-only.
	 *
	 * @return the DownloadsUrl.
	 */
	public String getDownloadsUrl() {
		final ApplicationType application = configuration.getApplication();
		return (application != null ? application.getDownloadsUrl() : null);
	}

	/**
	 * Gets the LicenseKey for the external PDF-Tools PdfValidator engine.
	 *
	 * @return the the LicenseKey for the external PDF-Tools PdfValidator
	 *         engine.
	 */
	public String getLicenseKey() {
		final ApplicationType application = configuration.getApplication();
		return (application != null ? application.getLicenseKey() : null);
	}

	/**
	 * Gets the PdfLevel to be validated by the external PDF-Tools PdfValidator
	 * engine.
	 *
	 * @return the PdfLevel to be validated by the external PDF-Tools
	 *         PdfValidator engine.
	 */
	public String getPdfLevel() {
		final ApplicationType application = configuration.getApplication();
		return (application != null ? application.getPdfLevel() : null);
	}

	/**
	 * Gets the level of messages to be reported by the external PDF-Tools
	 * PdfValidator engine.
	 *
	 * @return the level of messages to be reported by the external PDF-Tools
	 *         PdfValidator engine.
	 */
	public String getPdfReportingLevel() {
		final ApplicationType application = configuration.getApplication();
		return (application != null ? application.getPdfReportingLevel() : null);
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RuleSet> getRuleSetList() {
		return new ArrayList(ruleSetMap.values());
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
	 */
	public File getRuleSetsDir() throws ConfigurationException {
		File schematron = new File(configuration.getSchematron().getDirectory());
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
		return schematron.getAbsoluteFile();
	}

	/**
	 * Gets the theme (JQuery Theme). This is only used by Online CDA Validators
	 * and therefore currently read-only.
	 *
	 * @return the theme (JQuery Theme).
	 */
	public String getTheme() {
		final ApplicationType application = configuration.getApplication();
		return (application != null ? application.getTheme() : null);
	}

	/**
	 * Gets the directory where java was run from, where you started the JVM.
	 * This is a read-only system property.
	 *
	 * @return the directory where java was run from, where you started the JVM.
	 */
	public File getUserDir() {
		return configuration.getUserDir();
	}

	/**
	 * Gets the WorkDir. This the path where the CdaValidsator will store
	 * pre-compiled Schematrons.
	 *
	 * @return the WorkDir.
	 */
	public File getWorkDir() {
		try {
			return configuration.getWorkDir();
		} catch (final ConfigurationException e) {
			log.error("<<< Configuration failed: " + e.getCause());
			return configuration.getBaseDir();
		}
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
		final ApplicationType application = configuration.getApplication();
		if (application != null) {
			application.setDocumentSchema(cdaDocumentSchema);
		}
	}

	/**
	 * Sets the LicenseKey for the external PDF-Tools PdfValidator engine.
	 *
	 * @param licenseKey
	 *            the LicenseKey for the external PDF-Tools PdfValidator engine.
	 */
	public void setLicenseKey(String licenseKey) {
		final ApplicationType application = configuration.getApplication();
		if (application != null)
			application.setLicenseKey(licenseKey);
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
		final ApplicationType application = configuration.getApplication();
		if (application != null)
			application.setPdfLevel(pdfLevel);
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
		final ApplicationType application = configuration.getApplication();
		if (application != null)
			application.setPdfReportingLevel(pdfReportingLevel);
	}

	/**
	 * Sets the list of available rule-sets.
	 *
	 * @param ruleSetList
	 *            the list of available rule-sets
	 */
	public void setRuleSetList(Collection<RuleSet> ruleSetList) {
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
		configuration.setWorkDir(workDir);
	}

	/**
	 * Sets the WorkDir. This the path where the CdaValidsator will store
	 * pre-compiled Schematrons.
	 *
	 * @param workDir
	 *            the WorkDir
	 */
	public void setWorkDir(String workDir) {
		configuration.setWorkDir(workDir);
	}

}
