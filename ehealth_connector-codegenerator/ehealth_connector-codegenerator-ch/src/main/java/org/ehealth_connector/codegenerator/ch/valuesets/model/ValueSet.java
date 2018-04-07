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

package org.ehealth_connector.codegenerator.ch.valuesets.model;

/**
 * <div class="en">This POJO class is used to parse the configuration from the
 * file <code>valuesets-sources.yaml</code> into an object for easier
 * handling</div>
 */
public class ValueSet {

	private String id;

	private String projectFolder;

	private String className;

	private String effectiveDate;

	private String codeSystemName;

	/**
	 * <div class="en">Gets the fully qualified class name of the enum class
	 * that will be generated/overwritten</div>
	 *
	 * @return
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * <div class="en">Gets the code system name that should be set
	 * (CODE_SYSTEM_NAME)</div>
	 *
	 * @return
	 */
	public String getCodeSystemName() {
		return codeSystemName;
	}

	/**
	 * <div class="en">Gets the date and time stamp of the version to download
	 * from the CH-EPR repository</div>
	 *
	 * @return
	 */
	public String getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * <div class="en">Gets the unique OID of the value set
	 * (CODE_SYSTEM_OID)</div>
	 *
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * <div class="en">Gets the base folder where the project containing the
	 * enum Java class can be found</div>
	 *
	 * @return
	 */
	public String getProjectFolder() {
		return projectFolder;
	}

	/**
	 * <div class="en">Sets the fully qualified class name of the enum class
	 * that will be generated/overwritten</div>
	 *
	 * @param className
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * <div class="en">Sets the code system name that should be set
	 * (CODE_SYSTEM_NAME)</div>
	 *
	 * @param codeSystemName
	 */
	public void setCodeSystemName(String codeSystemName) {
		this.codeSystemName = codeSystemName;
	}

	/**
	 * <div class="en">Sets the date and time stamp of the version to download
	 * from the CH-EPR repository</div>
	 *
	 * @param effectiveDate
	 */
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * <div class="en">Sets the unique OID of the value set
	 * (CODE_SYSTEM_OID)</div>
	 *
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * <div class="en">Sets the base folder where the project containing the
	 * enum Java class can be found</div>
	 *
	 * @param projectFolder
	 */
	public void setProjectFolder(String projectFolder) {
		this.projectFolder = projectFolder;
	}
}
