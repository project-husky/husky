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

import org.husky.common.hl7cdar2.POCDMT000040AuthoringDevice;
import org.husky.common.hl7cdar2.SC;


/**
 * The Class AuthoringDevice. The element represents a system or device which produced the document.
 */
public class AuthoringDevice {

    /**
     * The MDHT authoring device object.
     */
    private POCDMT000040AuthoringDevice mAuthoringDevice;

    /**
     * Instantiates a new authoring device.
     */
    public AuthoringDevice() {
        mAuthoringDevice = new POCDMT000040AuthoringDevice();
    }

    /**
     * Instantiates a new authoring device.
     *
     * @param mdht the mdht
     */
    public AuthoringDevice(POCDMT000040AuthoringDevice mdht) {
        mAuthoringDevice = mdht;
    }

    /**
     * Instantiates a new authoring device.
     *
     * @param name the name
     */
    public AuthoringDevice(String name) {
        this();
        setSoftwareName(name);
    }

    /**
     * Gets the manufacturer name.
     *
     * @return the manufacturer name
     */
    public String getManufacturerName() {
        if ((mAuthoringDevice.getManufacturerModelName() != null)
                && (mAuthoringDevice.getManufacturerModelName().getXmlMixed() != null)) {
            return mAuthoringDevice.getManufacturerModelName().getTextContent();
        }
        return null;
    }

    /**
     * Sets the manufacturer name.
     *
     * @param name the new manufacturer name
     */
    public void setManufacturerName(String name) {
        final var sc = new SC();
        sc.setXmlMixed(name);
        mAuthoringDevice.setManufacturerModelName(sc);
    }

    /**
     * Gets the mdht.
     *
     * @return the mdht
     */
    public POCDMT000040AuthoringDevice getMdht() {
        return mAuthoringDevice;
    }

    /**
     * Gets the software name.
     *
     * @return the software name
     */
    public String getSoftwareName() {
        if ((mAuthoringDevice.getSoftwareName() != null)
                && (mAuthoringDevice.getSoftwareName().getXmlMixed() != null)) {
            return mAuthoringDevice.getSoftwareName().getTextContent();
        }
        return null;
    }

    /**
     * Sets the software name.
     *
     * @param name the new software name
     */
    public void setSoftwareName(String name) {
        final var sc = new SC();
        sc.setXmlMixed(name);
        mAuthoringDevice.setSoftwareName(sc);
    }
}
