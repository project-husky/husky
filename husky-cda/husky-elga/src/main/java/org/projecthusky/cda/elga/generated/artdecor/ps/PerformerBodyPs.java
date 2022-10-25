/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.ps;

import java.util.List;
import javax.annotation.processing.Generated;
import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040Performer2;

/**
 * PerformerBodyPS
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.13.3.29<br>
 * Effective date: 2018-11-02 10:17:14<br>
 * Status: draft
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-03-01")
public class PerformerBodyPs extends POCDMT000040Performer2 {

    public PerformerBodyPs() {
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.6.0.11.3.2"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.13.3.29"));
        super.setAssignedEntity(createHl7AssignedEntityFixedValue("ASSIGNED"));
    }

    /**
     * Creates fixed contents for CDA Element hl7AssignedEntity
     *
     * @param classCode the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.POCDMT000040AssignedEntity createHl7AssignedEntityFixedValue(String classCode) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.POCDMT000040AssignedEntity retVal = factory.createPOCDMT000040AssignedEntity();
        retVal.setClassCode(classCode);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7TemplateId
     *
     * @param root the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7AssignedEntity
     */
    public org.projecthusky.common.hl7cdar2.POCDMT000040AssignedEntity getHl7AssignedEntity() {
        return assignedEntity;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.projecthusky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Time
     */
    public org.projecthusky.common.hl7cdar2.IVLTS getHl7Time() {
        return time;
    }

    /**
     * Sets the hl7AssignedEntity
     */
    public void setHl7AssignedEntity(org.projecthusky.common.hl7cdar2.POCDMT000040AssignedEntity value) {
        this.assignedEntity = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.projecthusky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Time
     */
    public void setHl7Time(org.projecthusky.common.hl7cdar2.IVLTS value) {
        this.time = value;
    }
}
