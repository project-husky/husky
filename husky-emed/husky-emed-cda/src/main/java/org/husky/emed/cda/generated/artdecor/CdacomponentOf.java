package org.husky.emed.cda.generated.artdecor;

import javax.annotation.processing.Generated;

import org.husky.emed.cda.generated.hl7cdar2.ObjectFactory;
import org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Component1;

/**
 * CDAcomponentOf
 * <p>
 * Template description: Template CDA componentOf (prototype, directly derived from POCD_RM000040 MIF)<br>
 * <p>
 * Identifier: 2.16.840.1.113883.10.12.113<br>
 * Effective date: 2005-09-07 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class CdacomponentOf extends POCDMT000040Component1 {

    public CdacomponentOf() {
        super.setTypeCode(org.husky.emed.cda.generated.hl7cdar2.ActRelationshipHasComponent.COMP);
        super.setEncompassingEncounter(createHl7EncompassingEncounterFixedValue("ENC",
                                                                                "EVN"));
    }

    /**
     * Creates fixed contents for CDA Element hl7EncompassingEncounter
     *
     * @param classCode the desired fixed value for this argument.
     * @param moodCode the desired fixed value for this argument.
     */
    private static org.husky.emed.cda.generated.hl7cdar2.POCDMT000040EncompassingEncounter createHl7EncompassingEncounterFixedValue(String classCode, String moodCode) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.emed.cda.generated.hl7cdar2.POCDMT000040EncompassingEncounter retVal = factory.createPOCDMT000040EncompassingEncounter();
        retVal.getClassCode().add(classCode);
        retVal.getMoodCode().add(moodCode);
        return retVal;
    }

    /**
     * Gets the hl7EncompassingEncounter
     */
    public org.husky.emed.cda.generated.hl7cdar2.POCDMT000040EncompassingEncounter getHl7EncompassingEncounter() {
        return encompassingEncounter;
    }

    /**
     * Sets the hl7EncompassingEncounter
     */
    public void setHl7EncompassingEncounter(org.husky.emed.cda.generated.hl7cdar2.POCDMT000040EncompassingEncounter value) {
        this.encompassingEncounter = value;
    }
}
