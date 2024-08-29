package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.RiskCategory;

/**
 * This sould be an enum representation of the CDSCODE table of HCI INDEX used by the
 * <a href="https://chmed20af.emediplan.ch/fhir/ValueSet-chmed20af-valueset-risks-cdscode.html">eMediplan specification</a>
 *  paired with {@link RiskCategory}.
 * <p>
 * HCI does not provide a translation to/from SNOMED CT codes, as preferred by
 * <a href="https://fhir.ch/ig/ch-core/StructureDefinition-ch-core-allergyintolerance.html">CH CORE</a> and required by
 * <a href="https://fhir.ch/ig/ch-allergyintolerance/StructureDefinition-ch-allergyintolerance.html">CH Allergy Intolerance</a>
 * in the <a href="http://fhir.ch/ig/ch-term/3.0.0/ValueSet-CHAllergyIntoleranceValueSet.html">CH TERM value set</a>.
 * </p>
 *
 * Given that CH EMED EPR is not explicitly concerned with medical risks or allergies, at least for the time being, that
 * there is no provided mapping by HCI between their own codes and the SNOMED CT ones to be used by the FHIR IGs in both
 * Swiss and international contexts, and the size of this table (more than 700 elements), this will just be a regular
 * class with no code validation or enforcement.
 */
@Data
public class EMediplanRisk {
    /*
    TERMINAL_RENAL_INSUFFICIENCY(RiskCategory.RENAL_INSUFFICIENCY, 597),
    ACUTE_RENAL_INSUFFICIENCY(RiskCategory.RENAL_INSUFFICIENCY, 575),
    MODERATE_RENAL_INSUFFICIENCY(RiskCategory.RENAL_INSUFFICIENCY, 576),
    MILD_RENAL_INSUFFICIENCY(RiskCategory.RENAL_INSUFFICIENCY, 577),
    ACUTE_LIVER_INSUFFICIENCY(RiskCategory.LIVER_INSUFFICIENCY, 572),
    MODERATE_LIVER_INSUFFICIENCY(RiskCategory.LIVER_INSUFFICIENCY, 573),
    MILD_LIVER_INSUFFICIENCY(RiskCategory.LIVER_INSUFFICIENCY, 574),
    PREGNANCY(RiskCategory.REPRODUCTION, 78),
    BREASTFEEDING(RiskCategory.REPRODUCTION, 77),
    FEMALE_OF_REPRODUCTIVE_AGE(RiskCategory.REPRODUCTION, 612),
    COMPETITIVE_ATHLETE(RiskCategory.COMPETITIVE_ATHLETE, 580),
    EXPOSED_TO_HAZARDOUS_ACTIVITIES(RiskCategory.OPERATING_VEHICLES_OR_MACHINES, 615),
    ALLERGY_TO_PENICILLIN(RiskCategory.ALLERGIES, 1),
    ALLERGY_TO_CLINDAMYCIN(RiskCategory.ALLERGIES, 2),
    ALLERGY_TO_PINE_TAR(RiskCategory.ALLERGIES, 3),
    ALLERGY_TO_PROTEASE_INHIBITOR(RiskCategory.ALLERGIES, 4),
    ALLERGY_TO_GYRASE_INHIBITOR_PIPEMIDIC_ACID(RiskCategory.ALLERGIES, 5),
    ALLERGY_TO_GYRASE_INHIBITOR_NALIDIXIC_ACID(RiskCategory.ALLERGIES, 6),
    ALLERGY_TO_GYRASE_INHIBITOR_CINOXACIN(RiskCategory.ALLERGIES, 7),
    ALLERGY_TO_PERFUME(RiskCategory.ALLERGIES, 8),
    ALLERGY_TO_ANTIVIRAL_MOZENAVIR(RiskCategory.ALLERGIES, 9),
    ALLERGY_TO_ROYAL_JELLY(RiskCategory.ALLERGIES, 10),
    ALLERGY_TO_BEEF_GELATIN(RiskCategory.ALLERGIES, 11),
    ALLERGY_TO_PYRITINOL(RiskCategory.ALLERGIES, 12),
    ALLERGY_TO_ALPHA_1_PROTEINASE_INHIBITOR(RiskCategory.ALLERGIES, 13),
    ALLERGY_TO_POLIDOCANOL(RiskCategory.ALLERGIES, 14),
    ALLERGY_TO_HUMAN_IMMUNOGLOBULIN(RiskCategory.ALLERGIES, 15),
    ALLERGY_TO_HUMAN_COAGULATION_FACTOR(RiskCategory.ALLERGIES, 16),
    ALLERGY_TO_MILK(RiskCategory.ALLERGIES, 17),
    ALLERGY_TO_BEESWAX(RiskCategory.ALLERGIES, 18),
    ALLERGY_TO_ALKYL_HYDROQUINONE_GEROQUINOL(RiskCategory.ALLERGIES, 19),
    ALLERGY_TO_ALKYL_HYDROQUINONE_GINKGOLAT(RiskCategory.ALLERGIES, 20),
    ALLERGY_TO_ALKYL_HYDROQUINONE_GREVILLOL(RiskCategory.ALLERGIES, 21),
    ALLERGY_TO_ALKYLPHENOL(RiskCategory.ALLERGIES, 22),
    ALLERGY_TO_DILL_OR_PERSIL(RiskCategory.ALLERGIES, 23),
    ALLERGY_TO_CAFFEIC_ACID(RiskCategory.ALLERGIES, 24),
    ALLERGY_TO_RHATANY(RiskCategory.ALLERGIES, 25),
    ALLERGY_TO_ALLIOIDEAE(RiskCategory.ALLERGIES, 26),
    ALLERGY_TO_CHASTE_TREE(RiskCategory.ALLERGIES, 27),
    ALLERGY_TO_KAVA(RiskCategory.ALLERGIES, 28),
    ALLERGY_TO_PEARLESCENT_AGENT(RiskCategory.ALLERGIES, 29),
    ALLERGY_TO_PHENYLENEDIAMINE(RiskCategory.ALLERGIES, 30),
    ALLERGY_TO_ACETANILIDE(RiskCategory.ALLERGIES, 31),
    ALLERGY_TO_BIS_HYDROXYMETHYL_IMIDAZOLIDINE_THIONE(RiskCategory.ALLERGIES, 32),
    ALLERGY_TO_PERSULFATE(RiskCategory.ALLERGIES, 33),
    ALLERGY_TO_CHLOROACETAMIDE(RiskCategory.ALLERGIES, 34),
    ALLERGY_TO_UV_FILTER_ALKYL_AMINOBENZOIC_ACID(RiskCategory.ALLERGIES, 35),
    ALLERGY_TO_UV_FILTER_CINNAMIC_ACID(RiskCategory.ALLERGIES, 36),
    ALLERGY_TO_ETHYLENEDIAMINE_DERIVATIVE(RiskCategory.ALLERGIES, 37),
    //[...]
    TYPE_1_DIABETES(RiskCategory.DIABETES, 779),
    TYPE_2_DIABETES(RiskCategory.DIABETES, 780);

    private final RiskCategory category;
    private final int code;

    Risk(final RiskCategory category, final int code) {
        this.category = category;
        this.code = code;
    }
     */

    protected RiskCategory category;
    @JsonValue
    protected int code;
}
