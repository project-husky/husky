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

package ehealth_connector.validation.service.config;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ehealth_connector.validation.service.config.bind.ApplicationType;
import ehealth_connector.validation.service.config.bind.ConfigurationType;
import ehealth_connector.validation.service.config.bind.RuleSetType;
import ehealth_connector.validation.service.config.bind.SchematronType;
import ehealth_connector.validation.service.schematron.RuleSet;

/**
 * Holds the application's configuration.
 */
public class Configuration {

	/** The SLF4J logger instance. */
	protected final Logger log = LoggerFactory.getLogger(getClass());

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
		createRuleSetMaps();
	}

	/**
	 * Creates and returns the list of configured rule-sets.
	 *
	 * @return the list of configured rule-sets.
	 */
	protected List<RuleSet> createRuleSetList() {
		SchematronType schematron = configuration.getSchematron();
		List<RuleSet> ruleSetList = new ArrayList<RuleSet>();
		try {
			File ruleSetDir = getRuleSetsDir();
			for (RuleSetType ruleSetType : schematron.getRuleSets()) {
				ruleSetList.add(new RuleSetImpl(ruleSetType, ruleSetDir));
			}
		} catch (ConfigurationException e) {
			log.error("RuleSet is invalid: '{}'", e);
		}
		return ruleSetList;
	}

	/**
	 * @return
	 */
	private void createRuleSetMaps() {
		RuleSet first;
		ruleSetMap.clear();
		ruleSetOidMap.clear();
		for (RuleSet ruleSet : createRuleSetList()) {
			ruleSetMap.put(ruleSet.getId(), ruleSet);
			if (ruleSet.getTemplateId() != null) {
				if ((first = ruleSetOidMap.put(ruleSet.getTemplateId(), ruleSet)) != null) {
					Object[] args = new Object[] { ruleSet.getTemplateId(),
							first.getPath().getName(), ruleSet.getPath().getName() };
					log.error("RuleSet OID {} is not unique." + " It was declared in '{}' and '{}'",
							args);
				}
			}
		}
	}

	/**
	 * @return
	 */
	public File getBaseDir() {
		return configuration.getBaseDir();
	}

	/**
	 * @return
	 */
	public String getDocumentSchema() throws ConfigurationException {
		ApplicationType application = configuration.getApplication();
		if (application != null) {
			File schema = new File(application.getDocumentSchema());
			if (!schema.isFile()) {
				schema = new File(getBaseDir() + "/" + application.getDocumentSchema());
			}
			if (!schema.isFile()) {
				schema = new File(getUserDir() + "/" + application.getDocumentSchema());
			}
			if (!schema.isFile()) {
				throw new ConfigurationException("Document schema not found");
			}
			if (!schema.canRead()) {
				throw new ConfigurationException("Document schema is not readable");
			}
			return schema.getAbsolutePath();
		}
		return null;
	}

	/**
	 * @return
	 */
	public String getDownloadsUrl() {
		ApplicationType application = configuration.getApplication();
		return (application != null ? application.getDownloadsUrl() : null);
	}

	/**
	 * @return
	 */
	public String getLicenseKey() {
		ApplicationType application = configuration.getApplication();
		return (application != null ? application.getLicenseKey() : null);
	}

	/**
	 * @return
	 */
	public String getPdfLevel() {
		ApplicationType application = configuration.getApplication();
		return (application != null ? application.getPdfLevel() : null);
	}

	/**
	 * @return
	 */
	public String getPdfReportingLevel() {
		ApplicationType application = configuration.getApplication();
		return (application != null ? application.getPdfReportingLevel() : null);
	}

	/**
	 * Returns the rule-set to which the specified <tt>id</tt> is mapped, or
	 * <tt>null</tt> if no such rule-set is found.
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
	 * Returns an ordered list of all available rule-sets.
	 *
	 * @return the list of available rule-sets as an array.
	 */
	public RuleSet[] getRuleSetList() {
		return ruleSetMap.values().toArray(new RuleSet[0]);
	}

	/**
	 * @return
	 */
	public int getRuleSetsCount() {
		return getRuleSetList().length;
	}

	/**
	 * Returns the base directory of the <cite>Schematron</cite> rule-sets.
	 *
	 * @return the absolute path denoted by the <tt>dir</tt> attribute of the
	 *         <tt>schematron</tt> element.
	 */
	public File getRuleSetsDir() throws ConfigurationException {
		File schematron = new File(configuration.getSchematron().getDirectory());
		if (!schematron.getAbsoluteFile().isDirectory()) {
			schematron = new File(
					getBaseDir() + "/" + configuration.getSchematron().getDirectory());
		}
		if (!schematron.isDirectory()) {
			schematron = new File(
					getUserDir() + "/" + configuration.getSchematron().getDirectory());
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
	 * @return
	 */
	public String getTheme() {
		ApplicationType application = configuration.getApplication();
		return (application != null ? application.getTheme() : null);
	}

	/**
	 * @return
	 */
	public File getUserDir() {
		return configuration.getUserDir();
	}

	/**
	 * @return
	 */
	public File getWorkDir() {
		try {
			return configuration.getWorkDir();
		} catch (ConfigurationException e) {
			log.error("<<< Configuration failed: " + e.getCause());
			return configuration.getBaseDir();
		}
	}

}
