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
import org.husky.common.hl7cdar2.POCDMT000040ClinicalDocument;

/**
 * cdach_header_DocumentTemplateIdsCdaChv2.0-structuredBody
 * <p>
 * Template description: CDA-CH V2 bases on HL7 CDA R2 (2005) and - by using this template - require a structured body. All CDA-CH V2 derivatives, i.e. Swiss exchange formats SHALL reference this template. These SHALL define further template ids in their own separate templates.<br>
 * Element description: HL7 CDA R2 (2005).<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.2.18<br>
 * Effective date: 2019-10-17 15:21:50<br>
 * Version: 2020<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-07-11")
public class CdachHeaderDocumentTemplateIdsCdaChv20StructuredBody extends POCDMT000040ClinicalDocument {

    public CdachHeaderDocumentTemplateIdsCdaChv20StructuredBody() {
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.1.9"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.12.2"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.12.1"));
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
     * Gets the hl7TemplateId<br/>
     * CDA-CH v2.0 specification. This is an informational reference, only.
     */
    public List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.II, filled by: "2.16.756.5.30.1.1.1.1.4"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.II getPredefinedTemplateId21675653011114() {
        return createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.1.1.4");
    }

    /**
     * Sets the hl7TemplateId<br/>
     * CDA-CH v2.0 specification. This is an informational reference, only.
     */
    public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }
}
