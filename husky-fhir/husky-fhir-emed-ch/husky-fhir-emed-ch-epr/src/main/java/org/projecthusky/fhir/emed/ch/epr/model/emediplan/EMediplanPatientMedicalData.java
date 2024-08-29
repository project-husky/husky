package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class EMediplanPatientMedicalData implements EMediplanExtendable {
    /**
     * First day of last menstruation, format: yyyy-mm-dd (ISO 86017 Date).
     * Only required in case of risk code 78, category code 3 (see {@link EMediplanRisk}).
     */
    @JsonProperty("dLstMen")
    @JsonFormat(pattern = "yyyy-MM-dd")
    protected @Nullable LocalDate lastMenstruation;
    /**
     * True if it is a premature baby (and only if age <= 18 months), false otherwise.
     */
    @JsonProperty("prem")
    protected @Nullable Boolean prematureBaby;
    /**
     * The time of gestation, should usually only be filled if prematureBaby is true.
     * Format: {week}-{day}, week is a natural number including 0, day excluding 0.
     */
    @JsonProperty("toG")
    protected @Nullable String timeOfGestation;
    /**
     * Risks per category. See {@link EMediplanRisk} and {@link EMediplanRiskList}.
     */
    @JsonProperty("rcs")
    protected @Nullable List<@NonNull EMediplanRiskList> risks;
    /**
     * Weight in kg.
     */
    @JsonProperty("w")
    protected @Nullable Double weight;
    /**
     * Height in cm.
     */
    @JsonProperty("h")
    protected @Nullable Double height;
    /**
     * Extensions.
     */
    @JsonProperty("exts")
    protected @Nullable List<@NonNull EMediplanExtension> extensions;

    public List<@NonNull EMediplanRiskList> getRisks() {
        if (risks == null) risks = new ArrayList<>();
        return risks;
    }

    public List<@NonNull EMediplanExtension> getExtensions() {
        if (extensions == null) extensions = new ArrayList<>();
        return extensions;
    }

    /**
     * Convenience method to add a risk to a medical data object. It will search for the appropriate list per category
     * to which to append the new risk and, if the category does not exist in the list, it creates it.
     * @param risk The risk to be added to the lists of risks.
     */
    @ExpectsValidResource
    public void addRisk(final EMediplanRisk risk) {
        if (risks == null) {
            risks = new ArrayList<>();
            risks.add(new EMediplanRiskList(risk.getCategory(), risk));
        } else {
            risks.stream().filter(riskList -> riskList.getCategory().equals(risk.getCategory())).findAny()
                    .ifPresentOrElse(
                            riskList -> riskList.getRisks().add(risk),
                            () -> risks.add(new EMediplanRiskList(risk.getCategory(), risk))
                    );
        }
    }
}
