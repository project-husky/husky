package org.husky.emed.cda.generated.artdecor;

import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.POCDMT000040ClinicalDocument;
import org.husky.common.hl7cdar2.ST;
import org.husky.common.hl7cdar2.TS;

/**
 * HeaderTemplateCompilationPharmaceuticalAdviceDocument
 * <p>
 * Template description: Header Templates for Pharmaceutical Advice document.<br>
 * Element description: The document's creation date and time. If this document replaces a previous version (linked via parentDocument), this is the date and time of the new version.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.9.43<br>
 * Effective date: 2018-01-08 16:23:16<br>
 * Version: 2019<br>
 * Status: draft
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class HeaderTemplateCompilationPharmaceuticalAdviceDocument extends POCDMT000040ClinicalDocument {

    public HeaderTemplateCompilationPharmaceuticalAdviceDocument() {
    }

    /**
     * Gets the hl7EffectiveTime
     * The document's creation date and time. If this document replaces a previous version (linked via parentDocument), this is the date and time of the new version.
     */
    public TS getHl7EffectiveTime() {
        return effectiveTime;
    }

    /**
     * Gets the hl7Title
     * <div>The German title shall be "Kommentar zur Medikation".</div><div>The French title shall be "Commentaire relatif à la médication".</div><div>The Italian title shall be "Commento sulla terapia farmacologica".</div><div>The English title shall be "Pharmaceutical Advice".</div><div>Titles in other languages are allowed and unrestricted.</div>
     */
    public ST getHl7Title() {
        return title;
    }

    /**
     * Sets the hl7EffectiveTime
     * The document's creation date and time. If this document replaces a previous version (linked via parentDocument), this is the date and time of the new version.
     */
    public void setHl7EffectiveTime(TS value) {
        this.effectiveTime = value;
    }

    /**
     * Sets the hl7Title
     * <div>The German title shall be "Kommentar zur Medikation".</div><div>The French title shall be "Commentaire relatif à la médication".</div><div>The Italian title shall be "Commento sulla terapia farmacologica".</div><div>The English title shall be "Pharmaceutical Advice".</div><div>Titles in other languages are allowed and unrestricted.</div>
     */
    public void setHl7Title(ST value) {
        this.title = value;
    }
}
