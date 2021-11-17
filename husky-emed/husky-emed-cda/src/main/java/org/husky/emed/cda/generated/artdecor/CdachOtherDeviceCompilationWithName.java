package org.husky.emed.cda.generated.artdecor;

import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.POCDMT000040AuthoringDevice;
import org.husky.common.hl7cdar2.SC;

/**
 * cdach_other_DeviceCompilationWithName
 * <p>
 * Template description: Reusable template wherever a device with required name is used in a CDA-CH V2 document. CDA-CH V2 derivatives, i.e. Swiss exchange formats MAY use this template by either reference or specialisation.A device is either a physical device (e.g. analyzer with which laboratory results are determined) or a software (e.g. laboratory information system, in which laboratory results are documented).<br>
 * Element description: The name of the device MUST be declared.Note:Altough this element is called softwareName, it contains also the name of physical devices (e.g. laboratory analyzer).<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.9.21<br>
 * Effective date: 2018-04-18 00:00:00<br>
 * Version: 2017<br>
 * Status: active
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class CdachOtherDeviceCompilationWithName extends POCDMT000040AuthoringDevice {

    public CdachOtherDeviceCompilationWithName() {
    }

    /**
     * Gets the hl7ManufacturerModelName
     * The model name of the device MAY be declared.
     */
    public SC getHl7ManufacturerModelName() {
        return manufacturerModelName;
    }

    /**
     * Gets the hl7SoftwareName
     * The name of the device MUST be declared.Note:Altough this element is called softwareName, it contains also the name of physical devices (e.g. laboratory analyzer).
     */
    public SC getHl7SoftwareName() {
        return softwareName;
    }

    /**
     * Sets the hl7ManufacturerModelName
     * The model name of the device MAY be declared.
     */
    public void setHl7ManufacturerModelName(SC value) {
        this.manufacturerModelName = value;
    }

    /**
     * Sets the hl7SoftwareName
     * The name of the device MUST be declared.Note:Altough this element is called softwareName, it contains also the name of physical devices (e.g. laboratory analyzer).
     */
    public void setHl7SoftwareName(SC value) {
        this.softwareName = value;
    }
}
