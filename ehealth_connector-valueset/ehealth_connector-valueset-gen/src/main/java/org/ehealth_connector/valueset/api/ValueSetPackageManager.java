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
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.valueset.config.ValueSetPackageConfig;
import org.ehealth_connector.valueset.enums.ValueSetPackageStatusEnum;
import org.ehealth_connector.valueset.model.ValueSetPackage;

/**
 * Java Prototype for Value Set Management Concept.
 */
public interface ValueSetPackageManager {

	public void addValueSetPackageConfig(ValueSetPackageConfig value);

	public OutputStream downloadValueSetPackage(ValueSetPackageConfig valueSetPackageConfig);

	public ValueSetPackageConfig getLatestValueSetPackageConfig();

	public ValueSetPackageConfig getLatestValueSetPackageConfigByStatus(
			ValueSetPackageStatusEnum value);

	public ValueSetPackageConfig getValueSetPackageConfigByStatusAndDate(
			ValueSetPackageStatusEnum status, Date date);

	public List<ValueSetPackageConfig> listValueSetPackageConfig();

	public ValueSetPackage loadValueSetPackage(File valueSetPackage);

	public ValueSetPackage loadValueSetPackage(InputStream valueSetPackage);

	public ValueSetPackageConfig loadValueSetPackageConfig(File config);

	public ValueSetPackageConfig loadValueSetPackageConfig(InputStream config);
}
