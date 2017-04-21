/*
 *
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

package org.ehealth_connector.validation.service.config;

import java.io.File;

import org.ehealth_connector.validation.service.config.bind.RuleSetType;
import org.ehealth_connector.validation.service.schematron.RuleSet;

/**
 * Concrete Implementation of the RuleSet Interface
 */
public class RuleSetImpl implements RuleSet {

	/** The underlying <tt>RuleSetType</tt> instance. */
	private final RuleSetType ruleSetType;

	/** The base directory used for relative paths. */
	private File path;

	public RuleSetImpl(RuleSetType ruleSetType, File baseDir) {
		if (ruleSetType == null) {
			throw new NullPointerException("RuleSetType must not be null.");
		}
		this.ruleSetType = ruleSetType;

		File path = new File(ruleSetType.getFileName());
		if (!path.isAbsolute()) {
			if (baseDir == null)
				baseDir = new File(".");
			path = new File(baseDir, path.getPath());
		}
		this.path = path;
	}

	@Override
	public String getDescription() {
		return ruleSetType.getDescription();
	}

	@Override
	public String getDisplayName() {
		if (ruleSetType.getDisplayName() != null) {
			return ruleSetType.getDisplayName();
		}
		return getPath().getName();
	}

	@Override
	public String getId() {
		return String.valueOf(hashCode());
	}

	@Override
	public File getPath() {
		return path;
	}

	@Override
	public String getTemplateId() {
		return ruleSetType.getTemplateId();
	}

	@Override
	public boolean isCacheable() {
		return ruleSetType.isCacheable();
	}

	@Override
	public boolean isPersistable() {
		return ruleSetType.isPersistable();
	}

	@Override
	public void setPath(File path) {
		this.path = path;
	}

}
