package org.ehealth_connector.emed.cda.generated.artdecor;

import java.util.List;
import javax.annotation.processing.Generated;
import org.ehealth_connector.emed.cda.generated.hl7cdar2.ObjectFactory;
import org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040ClinicalDocument;

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
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
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
    private static org.ehealth_connector.emed.cda.generated.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.ehealth_connector.emed.cda.generated.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7TemplateId
     * CDA-CH v2.0 specification. This is an informational reference, only.
     */
    public List<org.ehealth_connector.emed.cda.generated.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.II, filled by: "2.16.756.5.30.1.1.1.1.4"
     * @return the predefined element.
     */
    public static org.ehealth_connector.emed.cda.generated.hl7cdar2.II getPredefinedTemplateId21675653011114() {
        return createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.1.1.4");
    }

    /**
     * Sets the hl7TemplateId
     * CDA-CH v2.0 specification. This is an informational reference, only.
     */
    public void setHl7TemplateId(org.ehealth_connector.emed.cda.generated.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }
}
