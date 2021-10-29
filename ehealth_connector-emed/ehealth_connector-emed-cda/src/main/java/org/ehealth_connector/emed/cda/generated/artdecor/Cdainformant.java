package org.ehealth_connector.emed.cda.generated.artdecor;

import javax.annotation.processing.Generated;
import org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040Informant12;

/**
 * CDAinformant
 * <p>
 * Template description: Template CDA Informant (prototype, directly derived from POCD_RM000040 MIF)<br>
 * <p>
 * Identifier: 2.16.840.1.113883.10.12.154<br>
 * Effective date: 2005-09-07 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class Cdainformant extends POCDMT000040Informant12 {

    public Cdainformant() {
        super.getTypeCode().add("INF");
        super.setContextControlCode("OP");
    }

    /**
     * Gets the hl7AssignedEntity
     */
    public org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040AssignedEntity getHl7AssignedEntity() {
        return assignedEntity;
    }

    /**
     * Gets the hl7RelatedEntity
     */
    public org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040RelatedEntity getHl7RelatedEntity() {
        return relatedEntity;
    }

    /**
     * Sets the hl7AssignedEntity
     */
    public void setHl7AssignedEntity(org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040AssignedEntity value) {
        this.assignedEntity = value;
    }

    /**
     * Sets the hl7RelatedEntity
     */
    public void setHl7RelatedEntity(org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040RelatedEntity value) {
        this.relatedEntity = value;
    }
}
