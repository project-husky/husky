/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.husky.common.model;

/**
 * Class that contains information about a vendor and its applications.
 */
public class VendorInformation {

    // Default values, will be used, if the user does not provide his own
    // information.
    public static final String DEFAULT_CONTACT_INFORMATION = "https://github.com/project-husky/husky";
    public static final String DEFAULT_MODULE_NAME = "Convenience API";
    public static final String DEFAULT_PRODUCT_NAME = "Husky - https://github.com/project-husky/husky";
    public static final String DEFAULT_VENDOR_NAME = "Open Source";

    private String contactInformation;
    private String moduleName;
    private String productName;
    private String vendorName;

    /**
     * Constructor. husky default values will be used (see DEFAULT_* constants of this class, accordingly).
     */
    public VendorInformation() {
        this(DEFAULT_VENDOR_NAME, DEFAULT_PRODUCT_NAME, DEFAULT_MODULE_NAME,
                DEFAULT_CONTACT_INFORMATION);
    }

    /**
     * Constructor. Individual values can be provided.
     *
     * @param vendorName         Vendors (company) name
     * @param productName        name of the product
     * @param moduleName         name of the module, which was used inside the application
     * @param contactInformation contact information
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
     * Sets the contact information
     *
     * @param contactInformation the contact information
     */
    public void setContactInformation(String contactInformation) {
        if (contactInformation == null) {
            this.contactInformation = DEFAULT_CONTACT_INFORMATION;
        } else {
            this.contactInformation = contactInformation;
        }
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
     * Sets the module name.
     *
     * @param moduleName name of the module
     */
    public void setModuleName(String moduleName) {
        if (moduleName == null) {
            this.moduleName = DEFAULT_MODULE_NAME;
        } else {
            this.moduleName = moduleName;
        }
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
     * Sets the application name
     *
     * @param productName name of the application
     */
    public void setProductName(String productName) {
        if (productName == null) {
            this.productName = DEFAULT_PRODUCT_NAME;
        } else {
            this.productName = productName;
        }
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
     * Sets the vendors name.
     *
     * @param name name of the vendor
     */
    public void setVendorName(String name) {
        if (name == null) {
            this.vendorName = DEFAULT_VENDOR_NAME;
        } else {
            this.vendorName = name;
        }
    }
}
