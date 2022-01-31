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

import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.POCDMT000040ClinicalDocument;

/**
 * HeaderTemplateCompilationMedicationTreatmentPlan
 * <p>
 * Template description: Header Templates for MedicationTreatmentPlan<br>
 * Element description: The document's creation date and time. If this document replaces a previous version (linked via parentDocument), this is the date and time of the new version.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.9.44<br>
 * Effective date: 2018-01-08 16:26:11<br>
 * Version: 2019<br>
 * Status: draft
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-12-09")
public class HeaderTemplateCompilationMedicationTreatmentPlan extends POCDMT000040ClinicalDocument {

    public HeaderTemplateCompilationMedicationTreatmentPlan() {
    }

    /**
     * Gets the hl7EffectiveTime<br/>
     * The document's creation date and time. If this document replaces a previous version (linked via parentDocument), this is the date and time of the new version.
     */
    public org.husky.common.hl7cdar2.TS getHl7EffectiveTime() {
        return effectiveTime;
    }

    /**
     * Gets the hl7Title<br/>
     * <div>The German title shall be "Therapieentscheid Medikation".</div><div>The French title shall be "Décision thérapeutique relative à la médication".<br/></div><div>The Italian title shall be "Decisione terapeutica di trattamento farmacologico".<br/></div><div>The English title shall be "Medication Treatment Plan".<br/>Titles in other languages are allowed and unrestricted.</div>
     */
    public org.husky.common.hl7cdar2.ST getHl7Title() {
        return title;
    }

    /**
     * Sets the hl7EffectiveTime<br/>
     * The document's creation date and time. If this document replaces a previous version (linked via parentDocument), this is the date and time of the new version.
     */
    public void setHl7EffectiveTime(org.husky.common.hl7cdar2.TS value) {
        this.effectiveTime = value;
    }

    /**
     * Sets the hl7Title<br/>
     * <div>The German title shall be "Therapieentscheid Medikation".</div><div>The French title shall be "Décision thérapeutique relative à la médication".<br/></div><div>The Italian title shall be "Decisione terapeutica di trattamento farmacologico".<br/></div><div>The English title shall be "Medication Treatment Plan".<br/>Titles in other languages are allowed and unrestricted.</div>
     */
    public void setHl7Title(org.husky.common.hl7cdar2.ST value) {
        this.title = value;
    }
}
