/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.emed;

import javax.annotation.processing.Generated;
import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040RelatedDocument;

/**
 * HeaderRelatedDocument
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.20011<br>
 * Effective date: 2014-12-06 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-22")
public class HeaderRelatedDocument extends POCDMT000040RelatedDocument {

    public HeaderRelatedDocument() {
        super.setTypeCode(org.projecthusky.common.hl7cdar2.XActRelationshipDocument.RPLC);
        super.setParentDocument(createHl7ParentDocumentFixedValue("DOCCLIN",
                                                                  "EVN"));
    }

    /**
     * Creates fixed contents for CDA Element hl7ParentDocument
     *
     * @param classCode the desired fixed value for this argument.
     * @param moodCode the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.POCDMT000040ParentDocument createHl7ParentDocumentFixedValue(String classCode, String moodCode) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.POCDMT000040ParentDocument retVal = factory.createPOCDMT000040ParentDocument();
        retVal.setClassCode(org.projecthusky.common.hl7cdar2.ActClinicalDocument.fromValue(classCode));
        retVal.getMoodCode().add(moodCode);
        return retVal;
    }

    /**
     * Gets the hl7ParentDocument
     */
    public org.projecthusky.common.hl7cdar2.POCDMT000040ParentDocument getHl7ParentDocument() {
        return parentDocument;
    }

    /**
     * Sets the hl7ParentDocument
     */
    public void setHl7ParentDocument(org.projecthusky.common.hl7cdar2.POCDMT000040ParentDocument value) {
        this.parentDocument = value;
    }
}
