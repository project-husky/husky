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
package org.ehealth_connector.common;

/**
 * Class that contains information about a vendor and its applications.
 * 
 */
public class VendorInformation {

	// Default values, will be used, if the user does not provide his own
	// information.
	public static final String DEFAULT_CONTACT_INFORMATION = "http://sourceforge.net/p/ehealthconnector/wiki/Team";
	public static final String DEFAULT_MODULE_NAME = "Convenience API";
	public static final String DEFAULT_PRODUCT_NAME = "eHealth Connector - http://ehealth-connector.org";
	public static final String DEFAULT_VENDOR_NAME = "Open Source";

	private String contactInformation;
	private String moduleName;
	private String productName;
	private String vendorName;

	/**
	 * Constructor. eHealthConnector default values will be used (see DEFAULT_*
	 * constants of this class, accordingly).
	 */
	public VendorInformation() {
		this(DEFAULT_VENDOR_NAME, DEFAULT_PRODUCT_NAME, DEFAULT_MODULE_NAME,
				DEFAULT_CONTACT_INFORMATION);
	}

	/**
	 * Constructor. Individual values can be provided.
	 * 
	 * @param vendorName
	 *            Vendors (company) name
	 * @param productName
	 *            name of the product
	 * @param moduleName
	 *            name of the module, which was used inside the application
	 * @param contactInformation
	 *            contact information
	 */
	public VendorInformation(String vendorName, String productName, String moduleName,
			String contactInformation) {
		setVendorName(vendorName);
		setProductName(productName);
		setModuleName(moduleName);
		setContactInformation(contactInformation);
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
	 * Gets the application name.
	 * 
	 * @return application name
	 */
	public String getProductName() {
		return productName;
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
	 * @param moduleName
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
	 * Sets the application name
	 * 
	 * @param productName
	 *            name of the application
	 */
	public void setProductName(String productName) {
		if (productName == null) {
			this.productName = DEFAULT_PRODUCT_NAME;
		} else {
			this.productName = productName;
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
