package org.ehealth_connector.communication.xd.xdm;

public class VendorInformation {
	public static final String DEFAULT_NAME = "the eHealthConnector Open Source Projekt";
	public static final String DEFAULT_APPLICATION_NAME = org.ehealth_connector.common.EHealthConnectorVersions.EHealthConnectorR201503
			.getSystemVersionName();
	public static final String DEFAULT_CONTACT_INFORMATION = "See http://sourceforge.net/p/ehealthconnector/wiki/Team";

	private String name;
	private String applicationName;
	private String contactInformation;

	/**
	 * Constructor. eHealthConnector default values will be used.
	 */
	public VendorInformation() {
		this(null, null, null);
	}

	/**
	 * Constructor. Individual values can be provided.
	 * 
	 * @param name
	 *            Vendors (company) name
	 * @param applicationName
	 *            name of the application
	 * @param contactInformation
	 *            contact information
	 */
	public VendorInformation(String name, String applicationName, String contactInformation) {
		setName(name);
		setApplicationName(applicationName);
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
	 * Gets the vendor name
	 * 
	 * @return the vendors name
	 */
	public String getName() {
		return name;
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
	 * Sets the vendors name.
	 *
	 * @param name
	 *            name of the vendor
	 */
	public void setName(String name) {
		if (name == null) {
			this.name = DEFAULT_NAME;
		} else {
			this.name = name;
		}
	}
}
