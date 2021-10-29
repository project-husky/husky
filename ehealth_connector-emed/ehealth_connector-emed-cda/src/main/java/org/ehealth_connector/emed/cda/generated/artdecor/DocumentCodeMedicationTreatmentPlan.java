package org.ehealth_connector.emed.cda.generated.artdecor;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.ehealth_connector.emed.cda.models.common.Code;
import org.ehealth_connector.emed.cda.models.common.basetypes.CodeBaseType;
import org.ehealth_connector.emed.cda.generated.hl7cdar2.CE;
import org.ehealth_connector.emed.cda.generated.hl7cdar2.CS;

/**
 * DocumentCodeMedicationTreatmentPlan
 * <p>
 * Template description: A LOINC based document type of a CDA document instance including a translation to the Swiss EPR XDS.b metadata.<br>
 * Element description: IHE PHARM MTP document code<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.2.54<br>
 * Effective date: 2020-02-03 17:29:10<br>
 * Version: 2020<br>
 * Status: draft
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class DocumentCodeMedicationTreatmentPlan extends CE {

    public DocumentCodeMedicationTreatmentPlan() {
        super.setCode("77603-9");
        super.setCodeSystem("2.16.840.1.113883.6.1");
        super.setCodeSystemName("LOINC");
        super.setDisplayName("Medication treatment plan.extended");
        vocabTranslationCode.add(new Code(CodeBaseType.builder().withCode("419891008").withCodeSystem("2.16.840.1.113883.6.96").withCodeSystemName("SNOMED CT").withDisplayName("Record artifact (record artifact)").build()));
        super.getTranslation().add((new Code(CodeBaseType.builder().withCode("419891008").withCodeSystem("2.16.840.1.113883.6.96").withCodeSystemName("SNOMED CT").withDisplayName("Record artifact (record artifact)").build())).getHl7CdaR2Cd());
    }

    private final List<Code> vocabTranslationCode = new ArrayList<>();

    /**
     * Gets the hl7Translation
     * Translation to the Swiss EPR XDS.b metadata.
     */
    public List<org.ehealth_connector.emed.cda.generated.hl7cdar2.CD> getHl7Translation() {
        return translation;
    }

    /**
     * Returns a list of vocab codes as defined in the ART-DECOR model
     */
    public List<Code> getVocabTranslationCode() {
        return vocabTranslationCode;
    }

    /**
     * Sets the hl7Translation
     * Translation to the Swiss EPR XDS.b metadata.
     */
    public void setHl7Translation(org.ehealth_connector.emed.cda.generated.hl7cdar2.CD value) {
        getTranslation().clear();
        getTranslation().add(value);
    }
}
