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

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.husky.common.basetypes.CodeBaseType;
import org.husky.common.hl7cdar2.CE;
import org.husky.common.model.Code;

/**
 * DocumentCodeMedicationPrescription
 * <p>
 * Template description: A LOINC based document type of a CDA document instance including a translation to the Swiss EPR XDS.b metadata.<br>
 * Element description: IHE PHARM PRE document code<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.2.52<br>
 * Effective date: 2020-02-03 17:22:41<br>
 * Version: 2020<br>
 * Status: draft
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-12-09")
public class DocumentCodeMedicationPrescription extends CE {

    public DocumentCodeMedicationPrescription() {
        super.setCode("57833-6");
        super.setCodeSystem("2.16.840.1.113883.6.1");
        super.setCodeSystemName("LOINC");
        super.setDisplayName("Prescription for medication");
        vocabTranslationCode.add(new Code(CodeBaseType.builder().withCode("761938008").withCodeSystem("2.16.840.1.113883.6.96").withCodeSystemName("SNOMED CT").withDisplayName("Medicinal prescription record (record artifact)").build()));
        super.getTranslation().add((new Code(CodeBaseType.builder().withCode("761938008").withCodeSystem("2.16.840.1.113883.6.96").withCodeSystemName("SNOMED CT").withDisplayName("Medicinal prescription record (record artifact)").build())).getHl7CdaR2Cd());
    }

    private final List<Code> vocabTranslationCode = new ArrayList<>();

    /**
     * Gets the hl7Translation<br/>
     * Translation to the Swiss EPR XDS.b metadata.
     */
    public List<org.husky.common.hl7cdar2.CD> getHl7Translation() {
        return translation;
    }

    /**
     * Returns a list of vocab codes as defined in the ART-DECOR model
     */
    public List<Code> getVocabTranslationCode() {
        return vocabTranslationCode;
    }

    /**
     * Sets the hl7Translation<br/>
     * Translation to the Swiss EPR XDS.b metadata.
     */
    public void setHl7Translation(org.husky.common.hl7cdar2.CD value) {
        getTranslation().clear();
        getTranslation().add(value);
    }
}
