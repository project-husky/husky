package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanEnum;

/**
 * The ID or description of the recommendation
 * <p>
 * Possible values:
 * </p>
 * <ul>
 *  <li>1: Week dosing system by the pharmacist</li>
 *  <li>2: Intensified compliance support</li>
 *  <li>3: Repeat check in ... months</li>
 *  <li>4: Forwarding to doctor/other specialist</li>
 *  <li>5: Analysis needed (e.g. interactions, side effects, duplications)</li>
 * </ul>
 */
@Getter
public enum ChMed16ARecommendationId implements EMediplanEnum<String> {
    WEEK_DOSING_SYSTEM("1"),
    INTENSIFIED_COMPLIANCE_SUPPORT("2"),
    REPEAT_CHECK("3"),
    FORWARDING("4"),
    ANALYSIS_NEEDED("5");

    @JsonValue
    private final String code;

    ChMed16ARecommendationId(String code) {
        this.code = code;
    }
}
