package org.husky.emed.cda.generated.artdecor;

import java.util.List;
import javax.annotation.processing.Generated;

import org.husky.emed.cda.generated.hl7cdar2.ObjectFactory;
import org.husky.emed.cda.generated.hl7cdar2.POCDMT000040InformationRecipient;

/**
 * cdach_header_InformationRecipient
 * <p>
 * Template description: A recipient of this CDA document (corresponds to the addressee of a letter - person or organization). All CDA-CH V2 derivatives, i.e. Swiss exchange formats MUST use this template by either reference or specialisation.<br>
 * Element description: A recipient of this CDA document (corresponds to the addressee of a letter - person or organization).Recipient types:
 * - The main recipient of the document is indicated by typeCode 'PRCP' (primary recipient).Note: Since it makes no sense to create a CDA document without doing it for someone, in Switzerland at least one recipient MUST be declared. If the document is created for the user's own needs, the user itself or its organization will be the primary recipient.
 * - Other recipients (copy to; Cc) are indicated with typeCode, TRC '(secondary recipient).<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.2.4<br>
 * Effective date: 2018-04-18 00:00:00<br>
 * Version: 2017<br>
 * Status: active
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class CdachHeaderInformationRecipient extends POCDMT000040InformationRecipient {

    public CdachHeaderInformationRecipient() {
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.2.4"));
    }

    /**
     * Creates fixed contents for CDA Element hl7TemplateId
     *
     * @param root the desired fixed value for this argument.
     */
    private static org.husky.emed.cda.generated.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.emed.cda.generated.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7IntendedRecipient
     */
    public org.husky.emed.cda.generated.hl7cdar2.POCDMT000040IntendedRecipient getHl7IntendedRecipient() {
        return intendedRecipient;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.husky.emed.cda.generated.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Sets the hl7IntendedRecipient
     */
    public void setHl7IntendedRecipient(org.husky.emed.cda.generated.hl7cdar2.POCDMT000040IntendedRecipient value) {
        this.intendedRecipient = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.husky.emed.cda.generated.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }
}
