/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.cda.generated.artdecor;

import java.util.List;
import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040InformationRecipient;

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
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-12-09")
public class CdachHeaderInformationRecipient extends POCDMT000040InformationRecipient {

    public CdachHeaderInformationRecipient() {
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.2.4"));
    }

    /**
     * Creates fixed contents for CDA Element hl7TemplateId
     *
     * @param root the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7IntendedRecipient
     */
    public org.husky.common.hl7cdar2.POCDMT000040IntendedRecipient getHl7IntendedRecipient() {
        return intendedRecipient;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Sets the hl7IntendedRecipient
     */
    public void setHl7IntendedRecipient(org.husky.common.hl7cdar2.POCDMT000040IntendedRecipient value) {
        this.intendedRecipient = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }
}
