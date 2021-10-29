package org.ehealth_connector.emed.cda.generated.artdecor;

import javax.annotation.processing.Generated;
import org.ehealth_connector.emed.cda.generated.hl7cdar2.ObjectFactory;
import org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship;

/**
 * DosageInstructionsEntryRelatedComponents
 * <p>
 * Template description: Dosage Instructions are a set of data elements which together represent the dosage instructions to a medication such as duration of treatment, medication frequency, dose quantity, route of administration, etc. Dosage Instructions may be provided structured and/or narrative. This entry describes structured dosage instructions.<br>
 * Element description: Dosage Instructions PCC 6.3.4.16.20 - Related components<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.4.36<br>
 * Effective date: 2017-01-23 16:30:55<br>
 * Version: 2021<br>
 * Status: draft
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class DosageInstructionsEntryRelatedComponents extends POCDMT000040EntryRelationship {

    public DosageInstructionsEntryRelatedComponents() {
        super.setTypeCode(org.ehealth_connector.emed.cda.generated.hl7cdar2.XActRelationshipEntryRelationship.COMP);
        super.setSubstanceAdministration(createHl7SubstanceAdministrationFixedValue("SBADM"));
    }

    /**
     * Creates fixed contents for CDA Element hl7SubstanceAdministration
     *
     * @param classCode the desired fixed value for this argument.
     */
    private static org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040SubstanceAdministration createHl7SubstanceAdministrationFixedValue(String classCode) {
        ObjectFactory factory = new ObjectFactory();
        org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040SubstanceAdministration retVal = factory.createPOCDMT000040SubstanceAdministration();
        retVal.getClassCode().add(classCode);
        return retVal;
    }

    /**
     * Gets the hl7SequenceNumber
     */
    public org.ehealth_connector.emed.cda.generated.hl7cdar2.INT getHl7SequenceNumber() {
        return sequenceNumber;
    }

    /**
     * Gets the hl7SubstanceAdministration
     */
    public org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040SubstanceAdministration getHl7SubstanceAdministration() {
        return substanceAdministration;
    }

    /**
     * Sets the hl7SequenceNumber
     */
    public void setHl7SequenceNumber(org.ehealth_connector.emed.cda.generated.hl7cdar2.INT value) {
        this.sequenceNumber = value;
    }

    /**
     * Sets the hl7SubstanceAdministration
     */
    public void setHl7SubstanceAdministration(org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040SubstanceAdministration value) {
        this.substanceAdministration = value;
    }
}
