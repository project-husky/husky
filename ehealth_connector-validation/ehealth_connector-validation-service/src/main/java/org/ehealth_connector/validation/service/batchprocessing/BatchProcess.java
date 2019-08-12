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
