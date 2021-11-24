/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.husky.emed.cda.generated.artdecor;

import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040EntryRelationship;

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
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-11-24")
public class DosageInstructionsEntryRelatedComponents extends POCDMT000040EntryRelationship {

    public DosageInstructionsEntryRelatedComponents() {
        super.setTypeCode(org.husky.common.hl7cdar2.XActRelationshipEntryRelationship.COMP);
        super.setSubstanceAdministration(createHl7SubstanceAdministrationFixedValue("SBADM"));
    }

    /**
     * Creates fixed contents for CDA Element hl7SubstanceAdministration
     *
     * @param classCode the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.POCDMT000040SubstanceAdministration createHl7SubstanceAdministrationFixedValue(String classCode) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.POCDMT000040SubstanceAdministration retVal = factory.createPOCDMT000040SubstanceAdministration();
        retVal.getClassCode().add(classCode);
        return retVal;
    }

    /**
     * Gets the hl7SequenceNumber
     */
    public org.husky.common.hl7cdar2.INT getHl7SequenceNumber() {
        return sequenceNumber;
    }

    /**
     * Gets the hl7SubstanceAdministration
     */
    public org.husky.common.hl7cdar2.POCDMT000040SubstanceAdministration getHl7SubstanceAdministration() {
        return substanceAdministration;
    }

    /**
     * Sets the hl7SequenceNumber
     */
    public void setHl7SequenceNumber(org.husky.common.hl7cdar2.INT value) {
        this.sequenceNumber = value;
    }

    /**
     * Sets the hl7SubstanceAdministration
     */
    public void setHl7SubstanceAdministration(org.husky.common.hl7cdar2.POCDMT000040SubstanceAdministration value) {
        this.substanceAdministration = value;
    }
}
