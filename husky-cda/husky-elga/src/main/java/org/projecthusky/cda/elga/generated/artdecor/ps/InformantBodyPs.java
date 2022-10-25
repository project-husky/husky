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

import javax.annotation.processing.Generated;
import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040Informant12;

/**
 * InformantBodyPS
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.13.3.20<br>
 * Effective date: 2017-08-10 20:49:25<br>
 * Version: 0.1<br>
 * Status: draft
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-03-01")
public class InformantBodyPs extends POCDMT000040Informant12 {

    public InformantBodyPs() {
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
     * Creates fixed contents for CDA Element hl7RelatedEntity
     *
     * @param classCode the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.POCDMT000040RelatedEntity createHl7RelatedEntityFixedValue(String classCode) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.POCDMT000040RelatedEntity retVal = factory.createPOCDMT000040RelatedEntity();
        retVal.getClassCode().add(classCode);
        return retVal;
    }

    /**
     * Gets the hl7AssignedEntity
     */
    public org.projecthusky.common.hl7cdar2.POCDMT000040AssignedEntity getHl7AssignedEntity() {
        return assignedEntity;
    }

    /**
     * Gets the hl7RelatedEntity
     */
    public org.projecthusky.common.hl7cdar2.POCDMT000040RelatedEntity getHl7RelatedEntity() {
        return relatedEntity;
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.POCDMT000040AssignedEntity, filled by: "ASSIGNED"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.POCDMT000040AssignedEntity getPredefinedAssignedEntityAssigned() {
        return createHl7AssignedEntityFixedValue("ASSIGNED");
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.POCDMT000040RelatedEntity, filled by: "PRS"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.POCDMT000040RelatedEntity getPredefinedRelatedEntityPrs() {
        return createHl7RelatedEntityFixedValue("PRS");
    }

    /**
     * Sets the hl7AssignedEntity
     */
    public void setHl7AssignedEntity(org.projecthusky.common.hl7cdar2.POCDMT000040AssignedEntity value) {
        this.assignedEntity = value;
    }

    /**
     * Sets the hl7RelatedEntity
     */
    public void setHl7RelatedEntity(org.projecthusky.common.hl7cdar2.POCDMT000040RelatedEntity value) {
        this.relatedEntity = value;
    }
}
