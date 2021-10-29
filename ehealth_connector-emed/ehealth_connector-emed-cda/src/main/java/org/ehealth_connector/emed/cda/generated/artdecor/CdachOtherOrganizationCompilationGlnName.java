package org.ehealth_connector.emed.cda.generated.artdecor;

import java.util.List;
import javax.annotation.processing.Generated;
import org.ehealth_connector.emed.cda.generated.hl7cdar2.ObjectFactory;
import org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040Organization;

/**
 * cdach_other_OrganizationCompilationGlnName
 * <p>
 * Template description: Reusable template wherever an organization with required GLN as id and name is used in a CDA-CH V2 document. CDA-CH V2 derivatives, i.e. Swiss exchange formats MAY use this template by either reference or specialisation.<br>
 * Element description: The organization's address.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.9.30<br>
 * Effective date: 2018-04-18 00:00:00<br>
 * Version: 2017<br>
 * Status: active
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class CdachOtherOrganizationCompilationGlnName extends POCDMT000040Organization {

    public CdachOtherOrganizationCompilationGlnName() {
        super.getId().add(createHl7IdFixedValue("2.51.1.3"));
    }

    /**
     * Adds a hl7Addr
     * The organization's address.
     */
    public void addHl7Addr(org.ehealth_connector.emed.cda.generated.hl7cdar2.AD value) {
        getAddr().add(value);
    }

    /**
     * Adds a hl7Name
     * The organization's name.
     */
    public void addHl7Name(org.ehealth_connector.emed.cda.generated.hl7cdar2.ON value) {
        getName().add(value);
    }

    /**
     * Adds a hl7Telecom
     * The organization's means of communication (phone, eMail, ...).
     */
    public void addHl7Telecom(org.ehealth_connector.emed.cda.generated.hl7cdar2.TEL value) {
        getTelecom().add(value);
    }

    /**
     * Adds a hl7Addr
     * The organization's address.
     */
    public void clearHl7Addr() {
        getAddr().clear();
    }

    /**
     * Adds a hl7Name
     * The organization's name.
     */
    public void clearHl7Name() {
        getName().clear();
    }

    /**
     * Adds a hl7Telecom
     * The organization's means of communication (phone, eMail, ...).
     */
    public void clearHl7Telecom() {
        getTelecom().clear();
    }

    /**
     * Creates fixed contents for CDA Element hl7Id
     *
     * @param root the desired fixed value for this argument.
     */
    private static org.ehealth_connector.emed.cda.generated.hl7cdar2.II createHl7IdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.ehealth_connector.emed.cda.generated.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7Id
     * The organization's id (GLN).
     */
    public List<org.ehealth_connector.emed.cda.generated.hl7cdar2.II> getHl7Id() {
        return id;
    }

    /**
     * Sets the hl7Id
     * The organization's id (GLN).
     */
    public void setHl7Id(org.ehealth_connector.emed.cda.generated.hl7cdar2.II value) {
        getId().clear();
        getId().add(value);
    }
}
