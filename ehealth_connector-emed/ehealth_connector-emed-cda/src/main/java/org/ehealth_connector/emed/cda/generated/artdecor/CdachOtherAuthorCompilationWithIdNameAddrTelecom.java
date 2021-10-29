package org.ehealth_connector.emed.cda.generated.artdecor;

import javax.annotation.processing.Generated;
import org.ehealth_connector.emed.cda.generated.hl7cdar2.ObjectFactory;
import org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040Author;

/**
 * cdach_other_AuthorCompilationWithIdNameAddrTelecom
 * <p>
 * Template description: Reusable template wherever an author with required name, addr and telecom is used in a CDA-CH V2 document. CDA-CH V2 derivatives, i.e. Swiss exchange formats MAY use this template by either reference or specialisation.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.9.54<br>
 * Effective date: 2020-04-28 12:02:52<br>
 * Version: 2020<br>
 * Status: active
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class CdachOtherAuthorCompilationWithIdNameAddrTelecom extends POCDMT000040Author {

    public CdachOtherAuthorCompilationWithIdNameAddrTelecom() {
    }

    /**
     * Creates fixed contents for CDA Element hl7FunctionCode
     */
    private static org.ehealth_connector.emed.cda.generated.hl7cdar2.CE createHl7FunctionCodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.ehealth_connector.emed.cda.generated.hl7cdar2.CE retVal = factory.createCE();
        return retVal;
    }

    /**
     * Gets the hl7AssignedAuthor
     */
    public org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040AssignedAuthor getHl7AssignedAuthor() {
        return assignedAuthor;
    }

    /**
     * Gets the hl7FunctionCode
     */
    public org.ehealth_connector.emed.cda.generated.hl7cdar2.CE getHl7FunctionCode() {
        return functionCode;
    }

    /**
     * Gets the hl7Time
     * Timestamp of the authorship.
     */
    public org.ehealth_connector.emed.cda.generated.hl7cdar2.TS getHl7Time() {
        return time;
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.CE, filled by:
     * @return the predefined element.
     */
    public static org.ehealth_connector.emed.cda.generated.hl7cdar2.CE getPredefinedFunctionCode() {
        return createHl7FunctionCodeFixedValue();
    }

    /**
     * Sets the hl7AssignedAuthor
     */
    public void setHl7AssignedAuthor(org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040AssignedAuthor value) {
        this.assignedAuthor = value;
    }

    /**
     * Sets the hl7FunctionCode
     */
    public void setHl7FunctionCode(org.ehealth_connector.emed.cda.generated.hl7cdar2.CE value) {
        this.functionCode = value;
    }

    /**
     * Sets the hl7Time
     * Timestamp of the authorship.
     */
    public void setHl7Time(org.ehealth_connector.emed.cda.generated.hl7cdar2.TS value) {
        this.time = value;
    }
}
