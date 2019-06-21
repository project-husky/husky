/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.valueset.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.ehealth_connector.valueset.config.ValueSetPackageConfig;
import org.ehealth_connector.valueset.enums.ValueSetPackageStatus;
import org.ehealth_connector.valueset.model.ValueSetPackage;
import org.yaml.snakeyaml.Yaml;

public class ValueSetPackageManager {
	private ArrayList<ValueSetPackageConfig> valueSetPackageConfigList;

	public void addValueSetPackageConfig(ValueSetPackageConfig value) {
		if (this.valueSetPackageConfigList == null) {
			this.valueSetPackageConfigList = new ArrayList<ValueSetPackageConfig>();
		}
		this.valueSetPackageConfigList.add(value);

	}

	public void downloadAndSaveValueSetPackage(ValueSetPackageConfig valueSetPackageConfig,
			String fileName) {

	}

	public OutputStream downloadValueSetPackage(ValueSetPackageConfig valueSetPackageConfig) {
		// TODO NYI
		return null;
	}

	public ValueSetPackageConfig getLatestValueSetPackageConfig() {
		ValueSetPackageConfig retVal = null;
		boolean isCandidate = false;
		Date latestFrom = null;
		Date latestTo = null;
		if (valueSetPackageConfigList != null) {
			for (ValueSetPackageConfig valueSetPackageConfig : valueSetPackageConfigList) {
				if (retVal == null)
					retVal = valueSetPackageConfig;
				Date from = valueSetPackageConfig.getVersion().getValidFrom();
				Date to = valueSetPackageConfig.getVersion().getValidTo();

				if (from != null) {
					if (latestFrom == null)
						latestFrom = from;
				} else
					isCandidate = true;

				if (to != null) {
					if (latestTo == null)
						latestTo = to;
				} else {
					// from null and to null => this always valid
					// -> the first entry makes it
					if (isCandidate)
						retVal = valueSetPackageConfig;
					isCandidate = true;
				}

				if (from != null) {
					if (from.after(latestFrom)) {
						latestFrom = from;
						// in this case, a from candidate with a later from date
						// will
						// get the new choice
						if (isCandidate)
							retVal = valueSetPackageConfig;
						isCandidate = true;
					}
				}

				if (to != null) {
					if (to.after(latestTo)) {
						latestTo = to;
						// in this case, a from candidate with a later to date
						// will
						// get the new choice
						if (isCandidate)
							retVal = valueSetPackageConfig;
						isCandidate = true;
					}
				} else if (isCandidate)
					// in this case, a from candidate with a null to date will
					// get the new choice
					retVal = valueSetPackageConfig;
			}
		}
		return retVal;

	}

	public ValueSetPackageConfig getLatestValueSetPackageConfigByStatus(
			ValueSetPackageStatus value) {
		// TODO NYI
		return null;

	}

	public ValueSetPackageConfig getValueSetPackageConfigByStatusAndDate(
			ValueSetPackageStatus status, Date date) {
		// TODO NYI
		return null;

	}

	public List<ValueSetPackageConfig> listValueSetPackageConfig() {
		if (this.valueSetPackageConfigList == null) {
			this.valueSetPackageConfigList = new ArrayList<ValueSetPackageConfig>();
		}
		return this.valueSetPackageConfigList;

	}

	public ValueSetPackage loadValueSetPackage(File valueSetPackage) {
		// TODO NYI
		return null;

	}

	public ValueSetPackage loadValueSetPackage(InputStream valueSetPackage) {
		// TODO NYI
		return null;

	}

	public ValueSetPackageConfig loadValueSetPackageConfig(File config)
			throws FileNotFoundException {
		InputStream inputStream = new FileInputStream(config);
		return loadValueSetPackageConfig(inputStream);

	}

	public ValueSetPackageConfig loadValueSetPackageConfig(InputStream config) {
		Yaml yaml = new Yaml();
		return yaml.loadAs(config, ValueSetPackageConfig.class);
	}

	public ValueSetPackageConfig loadValueSetPackageConfig(InputStreamReader reader) {
		Yaml yaml = new Yaml();
		return yaml.loadAs(reader, ValueSetPackageConfig.class);
	}

	public ValueSetPackageConfig loadValueSetPackageConfig(String fileName)
			throws FileNotFoundException {
		if (this.valueSetPackageConfigList == null) {
			this.valueSetPackageConfigList = new ArrayList<ValueSetPackageConfig>();
		}

		InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName),
				Charsets.UTF_8);
		ValueSetPackageConfig valueSetPackageConfig = loadValueSetPackageConfig(reader);
		valueSetPackageConfigList.add(valueSetPackageConfig);
		return valueSetPackageConfig;

	}

	public void saveValueSetPackageConfig(ValueSetPackageConfig config, File file)
			throws IOException {
		Yaml yaml = new Yaml();
		FileUtils.writeByteArrayToFile(file, yaml.dumpAsMap(config).getBytes(Charsets.UTF_8));
	}

	public void saveValueSetPackageConfig(ValueSetPackageConfig config, String fileName)
			throws IOException {
		saveValueSetPackageConfig(config, new File(fileName));
	}
}
