/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */

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
import org.husky.common.hl7cdar2.POCDMT000040RelatedDocument;

/**
 * cdach_header_DocumentReplacement
 * <p>
 * Template description: Relationship to another CDA-CH V2 based document that is replaced by the current one. All CDA-CH V2 derivatives, i.e. Swiss exchange formats MUST reference this template.<br>
 * Element description: Relationship to another CDA-CH V2 based document that is replaced by the current one.Notes:For correction of wrong information, a new document that replaces the earlier document MUST be created. The new document corrects previously incorrect information. This also applies to the case where information in the CDA header has been corrected (e.g., if the original document has been issued to the wrong patient). While processing the new document at the recipient, all values from the previous document MUST be interpreted as deprecated (deleted/marked as deleted/deprecated) and all values in the new document MUST be marked as valid:
 * - Values that were only contained in the previous document have to be treated as deleted.
 * - Values that are present in both documents are overwritten with the contents of the new document.
 * - Values that are only contained in the new document are to be added.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.2.13<br>
 * Effective date: 2019-01-01 21:22:58<br>
 * Version: 2020<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-12-09")
public class CdachHeaderDocumentReplacement extends POCDMT000040RelatedDocument {

    public CdachHeaderDocumentReplacement() {
        super.setTypeCode(org.husky.common.hl7cdar2.XActRelationshipDocument.RPLC);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.2.13"));
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
     * Gets the hl7ParentDocument<br/>
     * Relationship to the document that needs to be replaced.
     */
    public org.husky.common.hl7cdar2.POCDMT000040ParentDocument getHl7ParentDocument() {
        return parentDocument;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Sets the hl7ParentDocument<br/>
     * Relationship to the document that needs to be replaced.
     */
    public void setHl7ParentDocument(org.husky.common.hl7cdar2.POCDMT000040ParentDocument value) {
        this.parentDocument = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }
}
