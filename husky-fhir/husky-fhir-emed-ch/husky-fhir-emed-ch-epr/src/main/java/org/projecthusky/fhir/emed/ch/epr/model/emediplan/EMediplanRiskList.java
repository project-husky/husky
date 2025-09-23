package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Models the RiskCategory object of eMediplan, that contains risks grouped by category.
 * <p>
 * If the risk category is specified without any risk being specified in the list of risks, the entire risk category is
 * considered as explicitly excluded for the current patient. If the category does not exist, the risks are considered
 * as unknown for the patient.
 * </p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EMediplanRiskList implements EMediplanObject {
    /**
     * The id of the risk category.
     */
    @JsonProperty("id")
    protected RiskCategory category;
    /**
     * The lis of risks within the risk category.
     */
    @JsonProperty("rIds")
    protected @Nullable List<@NonNull EMediplanRisk> risks;

    public List<@NonNull EMediplanRisk> getRisks() {
        if (risks == null) risks = new ArrayList<>();
        return risks;
    }

    public EMediplanRiskList(final RiskCategory category, final EMediplanRisk... risks) {
        this.category = category;
        this.risks = new ArrayList<>(risks.length);
        this.risks.addAll(Arrays.asList(risks));
    }

    public ValidationResult validate(final @Nullable String basePath) {
        final var result = new ValidationResult();

        if (category == null) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, "id"),
                "The risk category code is missing but it is required."
                ));

        final var risksIterator = getRisks().listIterator();
        while (risksIterator.hasNext()) {
            final var index = risksIterator.nextIndex();
            result.add(risksIterator.next().validate(getFieldValidationPath(basePath, "rIds", index)));
        }

        return result;
    }

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return (risks != null && risks.stream().anyMatch(risk -> risk.hasExtensions(inDepth)));
    }

    public void trim() {
        getRisks().forEach(EMediplanRisk::trim);
    }
}
