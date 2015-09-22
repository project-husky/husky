package org.ehealth_connector.communication.xd.xdm;

public class VendorInformation {
	public static final String DEFAULT_NAME = "The eHealthconnector Open Source Projekt";
	public static final String DEFAULT_APPLICATION_NAME = "eHealthconnector "+org.ehealth_connector.common.EHealthConnectorVersions.EHealthConnectorR201503.getSystemVersionName();
	public static final String DEFAULT_CONTACT_INFORMATION = "Oliver Egger, Tony Schaller, Axel Helmer. See <a href=\"http://sourceforge.net/p/ehealthconnector/wiki/Team\">http://sourceforge.net/p/ehealthconnector/wiki/Team</a>";
	
	private String name;
	private String applicationName;
	private String contactInformation;
	
	public VendorInformation() {
		this(null, null, null);
	}
	
	public VendorInformation(String name, String applicationName, String contactInformation) {
		setName(name);
		setApplicationName(applicationName);
		setContactInformation(contactInformation);
	}
	
	public String getApplicationName() {
		return applicationName;
	}
	
	public String getContactInformation() {
		return contactInformation;
	}
	
	public String getName() {
		return name;
	}
	
	public void setApplicationName(String applicationName) {
		if (applicationName == null) {
			this.applicationName = DEFAULT_APPLICATION_NAME;
		}
		else {
			this.applicationName = applicationName;
		}
	}
	
	public void setContactInformation(String contactInformation) {
		if (contactInformation == null) {
			this.contactInformation = DEFAULT_CONTACT_INFORMATION;
		}
		else {
			this.contactInformation = contactInformation;
		}
	}
	
	public void setName(String name) {
		if (name == null) {
			this.name = DEFAULT_NAME;
		}
		else {
			this.name = name;
		}
	}
}
