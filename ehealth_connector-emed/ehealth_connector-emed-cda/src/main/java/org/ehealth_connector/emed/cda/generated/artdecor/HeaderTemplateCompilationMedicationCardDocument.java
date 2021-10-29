package org.ehealth_connector.emed.cda.generated.artdecor;

import javax.annotation.processing.Generated;
import org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040ClinicalDocument;

/**
 * HeaderTemplateCompilationMedicationCardDocument
 * <p>
 * Template description: Header Templates for Medication Card document.<br>
 * Element description: The document's creation date and time. If this document replaces a previous version (linked via parentDocument), this is the date and time of the new version.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.9.42<br>
 * Effective date: 2019-10-17 13:58:45<br>
 * Version: 2019<br>
 * Status: draft
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class HeaderTemplateCompilationMedicationCardDocument extends POCDMT000040ClinicalDocument {

    public HeaderTemplateCompilationMedicationCardDocument() {
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
     * <div>The German title shall be "Medikationsplan".</div><div>The French title shall be "Plan de médication".</div><div>The Italian title shall be "Piano farmacologico".</div><div>The English title shall be "Medication Card".</div><div>Titles in other languages are allowed and unrestricted.</div>
     */
    public org.ehealth_connector.emed.cda.generated.hl7cdar2.ST getHl7Title() {
        return title;
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
     * <div>The German title shall be "Medikationsplan".</div><div>The French title shall be "Plan de médication".</div><div>The Italian title shall be "Piano farmacologico".</div><div>The English title shall be "Medication Card".</div><div>Titles in other languages are allowed and unrestricted.</div>
     */
    public void setHl7Title(org.ehealth_connector.emed.cda.generated.hl7cdar2.ST value) {
        this.title = value;
    }
}
