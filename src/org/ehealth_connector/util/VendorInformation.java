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
package org.ehealth_connector.util;

import org.ehealth_connector.common.EHealthConnectorVersions;

public class VendorInformation {
	public static final String DEFAULT_APPLICATION_NAME = EHealthConnectorVersions
			.getCurrentVersion().getSystemVersionName();
	public static final String DEFAULT_MODULE_NAME = "Convenience API";
	public static final String DEFAULT_CONTACT_INFORMATION = "See http://sourceforge.net/p/ehealthconnector/wiki/Team";
	public static final String DEFAULT_VENDOR_NAME = "The eHealthConnector Open Source Projekt";

	private String vendorName;
	private String applicationName;
	private String moduleName;
	private String contactInformation;

	/**
	 * Constructor. eHealthConnector default values will be used.
	 */
	public VendorInformation() {
		this(null, null, null, null);
	}

	/**
	 * Constructor. Individual values can be provided.
	 * 
	 * @param vendorName
	 *            Vendors (company) name
	 * @param applicationName
	 *            name of the application
	 * @param contactInformation
	 *            contact information
	 */
	public VendorInformation(String vendorName, String applicationName, String moduleName,
			String contactInformation) {
		setVendorName(vendorName);
		setApplicationName(applicationName);
		setModuleName(moduleName);
		setContactInformation(contactInformation);
	}

	/**
	 * Gets the application name.
	 * 
	 * @return application name
	 */
	public String getApplicationName() {
		return applicationName;
	}

	/**
	 * Gets the contact information
	 * 
	 * @return contact information
	 */
	public String getContactInformation() {
		return contactInformation;
	}

	/**
	 * Gets the module name
	 * 
	 * @return the modules name
	 */
	public String getModuleName() {
		return moduleName;
	}

	/**
	 * Gets the vendor name
	 * 
	 * @return the vendors name
	 */
	public String getVendorName() {
		return vendorName;
	}

	/**
	 * Sets the application name
	 * 
	 * @param applicationName
	 *            name of the application
	 */
	public void setApplicationName(String applicationName) {
		if (applicationName == null) {
			this.applicationName = DEFAULT_APPLICATION_NAME;
		} else {
			this.applicationName = applicationName;
		}
	}

	/**
	 * Sets the contact information
	 * 
	 * @param contactInformation
	 *            the contact information
	 */
	public void setContactInformation(String contactInformation) {
		if (contactInformation == null) {
			this.contactInformation = DEFAULT_CONTACT_INFORMATION;
		} else {
			this.contactInformation = contactInformation;
		}
	}

	/**
	 * Sets the module name.
	 *
	 * @param name
	 *            name of the module
	 */
	public void setModuleName(String moduleName) {
		if (moduleName == null) {
			this.moduleName = DEFAULT_MODULE_NAME;
		} else {
			this.moduleName = moduleName;
		}
	}

	/**
	 * Sets the vendors name.
	 *
	 * @param name
	 *            name of the vendor
	 */
	public void setVendorName(String name) {
		if (name == null) {
			this.vendorName = DEFAULT_VENDOR_NAME;
		} else {
			this.vendorName = name;
		}
	}
}
