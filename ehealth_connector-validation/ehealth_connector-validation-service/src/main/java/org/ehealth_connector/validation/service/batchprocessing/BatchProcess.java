package org.ehealth_connector.validation.service.batchprocessing;

import java.io.File;

import org.ehealth_connector.validation.service.batchprocessing.bind.BatchConfigurationType;
import org.ehealth_connector.validation.service.config.ConfigurationException;

public class BatchProcess {

	/** Parser used to process the batch process configuration file */
	private final BatchProcessConfigurationParser batchProcessConfigurationParser;

	/** Configuration of the validator */
	private BatchConfigurationType batchConfiguration = null;

	public BatchProcess(File batchProcessConfigFile) throws ConfigurationException {

		try {
			if (batchProcessConfigFile == null) {
				throw new ConfigurationException("No configuration file specified.");
			}
			this.batchProcessConfigurationParser = new BatchProcessConfigurationParser(
					batchProcessConfigFile);
			this.batchConfiguration = batchProcessConfigurationParser.parse();
		} catch (final ConfigurationException e) {
			throw new ConfigurationException("Configuration error: " + e.getMessage());
		}
	}

	public BatchConfigurationType getConfiguration() {
		return batchConfiguration;
	}
}
