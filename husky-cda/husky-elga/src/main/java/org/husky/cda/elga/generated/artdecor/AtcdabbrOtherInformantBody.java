/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor;

import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Entry;

/**
 * atcdabbr_other_InformantBody
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.9.3<br>
 * Effective date: 2021-10-04 08:03:25<br>
 * Version: 1.0.1+20211213<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-18")
public class AtcdabbrOtherInformantBody extends POCDMT000040Entry {

    public AtcdabbrOtherInformantBody() {
    }

    /**
     * Creates fixed contents for CDA Element hl7RelatedEntity
     *
     * @param classCode the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.POCDMT000040Entry createHl7RelatedEntityFixedValue(String classCode) {
        org.husky.common.hl7cdar2.POCDMT000040Entry retVal = new org.husky.common.hl7cdar2.POCDMT000040Entry();
        return retVal;
    }

    /**
     * Gets the hl7AssignedEntity
     */
    public org.husky.common.hl7cdar2.POCDMT000040Entry getHl7AssignedEntity() {
        return this;
    }

    /**
     * Gets the hl7RelatedEntity
     */
    public org.husky.common.hl7cdar2.POCDMT000040Entry getHl7RelatedEntity() {
        return this;
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.POCDMT000040Entry, filled by: "PRS"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.POCDMT000040Entry getPredefinedRelatedEntityPrs() {
        return createHl7RelatedEntityFixedValue("PRS");
    }

    /**
     * Sets the hl7AssignedEntity
     */
    public void setHl7AssignedEntity(org.husky.common.hl7cdar2.POCDMT000040Entry value) {
        // TODO: NYI
    }

    /**
     * Sets the hl7RelatedEntity
     */
    public void setHl7RelatedEntity(org.husky.common.hl7cdar2.POCDMT000040Entry value) {
        // TODO: NYI
    }
}
