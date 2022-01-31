/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.generated.artdecor;

import java.util.List;
import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040DocumentationOf;

/**
 * cdach_header_HealthService
 * <p>
 * Template description: Information about a health service describing the context of this CDA document. All CDA-CH V2 derivatives, i.e. Swiss exchange formats MUST use this template by either reference or specialisation.<br>
 * Element description: Information about a health service describing the context of this CDA document.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.2.46<br>
 * Effective date: 2019-01-01 20:53:33<br>
 * Version: 2019<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-12-09")
public class CdachHeaderHealthService extends POCDMT000040DocumentationOf {

    public CdachHeaderHealthService() {
        super.getTypeCode().add("DOC");
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.2.46"));
        super.setServiceEvent(createHl7ServiceEventFixedValue("ACT",
                                                              "EVN"));
    }

    /**
     * Creates fixed contents for CDA Element hl7ServiceEvent
     *
     * @param classCode the desired fixed value for this argument.
     * @param moodCode the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.POCDMT000040ServiceEvent createHl7ServiceEventFixedValue(String classCode, String moodCode) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.POCDMT000040ServiceEvent retVal = factory.createPOCDMT000040ServiceEvent();
        retVal.getClassCode().add(classCode);
        retVal.getMoodCode().add(moodCode);
        return retVal;
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
     * Gets the hl7ServiceEvent
     */
    public org.husky.common.hl7cdar2.POCDMT000040ServiceEvent getHl7ServiceEvent() {
        return serviceEvent;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Sets the hl7ServiceEvent
     */
    public void setHl7ServiceEvent(org.husky.common.hl7cdar2.POCDMT000040ServiceEvent value) {
        this.serviceEvent = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }
}
