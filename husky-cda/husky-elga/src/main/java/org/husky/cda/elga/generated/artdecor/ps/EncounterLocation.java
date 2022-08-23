/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor.ps;

import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Location;

/**
 * EncounterLocation
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.90006<br>
 * Effective date: 2014-01-05 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-03-01")
public class EncounterLocation extends POCDMT000040Location {

    public EncounterLocation() {
        super.setTypeCode(org.husky.common.hl7cdar2.ParticipationTargetLocation.LOC);
        super.setHealthCareFacility(createHl7HealthCareFacilityFixedValue("SDLOC"));
    }

    /**
     * Creates fixed contents for CDA Element hl7HealthCareFacility
     *
     * @param classCode the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.POCDMT000040HealthCareFacility createHl7HealthCareFacilityFixedValue(String classCode) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.POCDMT000040HealthCareFacility retVal = factory.createPOCDMT000040HealthCareFacility();
        retVal.setClassCode(org.husky.common.hl7cdar2.RoleClassServiceDeliveryLocation.fromValue(classCode));
        return retVal;
    }

    /**
     * Gets the hl7HealthCareFacility
     */
    public org.husky.common.hl7cdar2.POCDMT000040HealthCareFacility getHl7HealthCareFacility() {
        return healthCareFacility;
    }

    /**
     * Sets the hl7HealthCareFacility
     */
    public void setHl7HealthCareFacility(org.husky.common.hl7cdar2.POCDMT000040HealthCareFacility value) {
        this.healthCareFacility = value;
    }
}
