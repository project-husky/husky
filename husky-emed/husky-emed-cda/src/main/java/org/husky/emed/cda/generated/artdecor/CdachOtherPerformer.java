package org.husky.emed.cda.generated.artdecor;

import java.util.List;
import javax.annotation.processing.Generated;

import org.husky.emed.cda.generated.hl7cdar2.ObjectFactory;
import org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Performer1;

/**
 * cdach_other_Performer
 * <p>
 * Template description: Reusable template wherever a healthcare provider who was the primary performer of an act is used in a CDA-CH V2 document. CDA-CH V2 derivatives, i.e. Swiss exchange formats MAY use this template by either reference or specialisation.<br>
 * Element description: Information about a healthcare provider who was the primary performer of the act.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.9.31<br>
 * Effective date: 2018-12-24 19:51:04<br>
 * Version: 2020<br>
 * Status: active
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class CdachOtherPerformer extends POCDMT000040Performer1 {

    public CdachOtherPerformer() {
        super.setTypeCode(org.husky.emed.cda.generated.hl7cdar2.XServiceEventPerformer.PRF);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.9.31"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.1.24.3.5"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.12.323"));
    }

    /**
     * Creates fixed contents for CDA Element hl7TemplateId
     *
     * @param root the desired fixed value for this argument.
     */
    private static org.husky.emed.cda.generated.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.emed.cda.generated.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7AssignedEntity
     */
    public org.husky.emed.cda.generated.hl7cdar2.POCDMT000040AssignedEntity getHl7AssignedEntity() {
        return assignedEntity;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.husky.emed.cda.generated.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Time
     * Duration of the performance.
     */
    public org.husky.emed.cda.generated.hl7cdar2.IVLTS getHl7Time() {
        return time;
    }

    /**
     * Sets the hl7AssignedEntity
     */
    public void setHl7AssignedEntity(org.husky.emed.cda.generated.hl7cdar2.POCDMT000040AssignedEntity value) {
        this.assignedEntity = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.husky.emed.cda.generated.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Time
     * Duration of the performance.
     */
    public void setHl7Time(org.husky.emed.cda.generated.hl7cdar2.IVLTS value) {
        this.time = value;
    }
}
