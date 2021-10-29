package org.ehealth_connector.emed.cda.generated.artdecor;

import java.util.List;
import javax.annotation.processing.Generated;
import org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040ClinicalDocument;

/**
 * HeaderTemplateCompilationMedicationPrescriptionDocument
 * <p>
 * Template description: Header Templates for Medication Prescription<br>
 * Element description: Validity of document<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.9.45<br>
 * Effective date: 2018-01-08 16:28:39<br>
 * Version: 2021<br>
 * Status: draft
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class HeaderTemplateCompilationMedicationPrescriptionDocument extends POCDMT000040ClinicalDocument {

    public HeaderTemplateCompilationMedicationPrescriptionDocument() {
    }

    /**
     * Gets the hl7DocumentationOf
     * Validity of document
     */
    public List<org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040DocumentationOf> getHl7DocumentationOf() {
        return documentationOf;
    }

    /**
     * Gets the hl7EffectiveTime
     * The document's creation date and time. If this document replaces a previous version (linked via parentDocument), this is the date and time of the new version.
     */
    public org.ehealth_connector.emed.cda.generated.hl7cdar2.TS getHl7EffectiveTime() {
        return effectiveTime;
    }

    /**
     * Gets the hl7Title
     * <div>The German title shall be "Rezept".</div><div>The French title shall be "Ordonnance".</div><div>The Italian title shall be "Ricetta".</div><div>The English title shall be "Prescription".</div><div>Titles in other languages are allowed and unrestricted.</div>
     */
    public org.ehealth_connector.emed.cda.generated.hl7cdar2.ST getHl7Title() {
        return title;
    }

    /**
     * Sets the hl7DocumentationOf
     * Validity of document
     */
    public void setHl7DocumentationOf(org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040DocumentationOf value) {
        getDocumentationOf().clear();
        getDocumentationOf().add(value);
    }

    /**
     * Sets the hl7EffectiveTime
     * The document's creation date and time. If this document replaces a previous version (linked via parentDocument), this is the date and time of the new version.
     */
    public void setHl7EffectiveTime(org.ehealth_connector.emed.cda.generated.hl7cdar2.TS value) {
        this.effectiveTime = value;
    }

    /**
     * Sets the hl7Title
     * <div>The German title shall be "Rezept".</div><div>The French title shall be "Ordonnance".</div><div>The Italian title shall be "Ricetta".</div><div>The English title shall be "Prescription".</div><div>Titles in other languages are allowed and unrestricted.</div>
     */
    public void setHl7Title(org.ehealth_connector.emed.cda.generated.hl7cdar2.ST value) {
        this.title = value;
    }
}
