/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor.base;

import java.util.List;
import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Performer1;

/**
 * LaboratoryPerformer
 * <p>
 * Template description: Laboratory Performers SHALL be recorded as performers in the CDA Header as well as in the structured body. Documentation of laboratory performers MAY be done in multiple levels of the document to reflect performance scope. In the case where there is a single Laboratory Performer, this entity SHALL be documented in CDA header as shown. In the case where multiple Laboratory Performers participated in the lab testing process, they SHALL be documented in the structuredBody at the observation level. These performers SHALL conform to the General Constraints found in HL7 CRS: 2.1.1 with respect to the requirements for name, address, telephone numbers and other contact information.This module is out of the XDS-Lab Specification and documented there in a &lt;performer&gt; element. This module does not change requirements stated in that specification but is structured as a module to ensure consistent content representation and re-usability.<br>
 * <p>
 * Identifier: 1.3.6.1.4.1.19376.1.3.3.1.7<br>
 * Effective date: 2014-05-26 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-21")
public class LaboratoryPerformer extends POCDMT000040Performer1 {

    public LaboratoryPerformer() {
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.3.3.1.7"));
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
     * Gets the hl7AssignedEntity
     */
    public org.husky.common.hl7cdar2.POCDMT000040AssignedEntity getHl7AssignedEntity() {
        return assignedEntity;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Time
     */
    public org.husky.common.hl7cdar2.IVLTS getHl7Time() {
        return time;
    }

    /**
     * Sets the hl7AssignedEntity
     */
    public void setHl7AssignedEntity(org.husky.common.hl7cdar2.POCDMT000040AssignedEntity value) {
        this.assignedEntity = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Time
     */
    public void setHl7Time(org.husky.common.hl7cdar2.IVLTS value) {
        this.time = value;
    }
}
