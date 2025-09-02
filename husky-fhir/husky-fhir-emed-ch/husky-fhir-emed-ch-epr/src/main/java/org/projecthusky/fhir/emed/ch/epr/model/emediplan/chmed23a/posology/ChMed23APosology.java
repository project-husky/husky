package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.posology;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanPosology;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.CdTyp9;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.enums.RelativeToMeal;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.posology.detail.PosologyDetail;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.time.Instant;
import java.util.Objects;

import static org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.ChMed23AEMediplan.EMEDIPLAN_TIMEZONE;

/**
 * Describes when and what amount of medication must be taken.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ChMed23APosology extends EMediplanPosology {
    protected static final String DETAIL_FIELD_NAME = "po";
    protected static final String UNIT_FIELD_NAME = "unit";

    /**
     * From date. Format: YYYY-MM-DDThh:mm:ss+02:00 or YYYY-MM-DD (ISO 8601 Combined date and time including time zone
     * or date only) (e.g. 2016-06-16T16:26:15+02:00).
     */
    @JsonProperty("dtFrom")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone = EMEDIPLAN_TIMEZONE)
    protected @Nullable Instant start;
    /**
     * To date. Format: YYYY-MM-DDThh:mm:ss+02:00 or YYYY-MM-DD (ISO 8601 Combined date and time including time zone
     * or date only) (e.g. 2016-06-16T16:26:15+02:00).
     * The DtTo must be considered as inclusive. For example, DtTo: 2015-05-01, the patient must apply the medicament
     * also on 2015-05-01.
     */
    @JsonProperty("dtTo")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone = EMEDIPLAN_TIMEZONE)
    protected @Nullable Instant end;
    /**
     * Reserve medication. True if in reserve, false otherwise. By default, false is assumed.
     */
    @JsonProperty("inRes")
    protected @Nullable Boolean asNeeded;
    /**
     * Dosage details.
     */
    @JsonProperty(DETAIL_FIELD_NAME)
    protected PosologyDetail detail;
    /**
     * Indicates whether a medication has to be taken relative to a meal.
     */
    @JsonProperty("relMeal")
    protected @Nullable RelativeToMeal relativeToMeal;
    /**
     * The quantity unit. See
     * <a href="https://chmed20af.emediplan.ch/fhir/CodeSystem-chmed20af-codesystem-cdtyp9.html">allowed values</a>.
     */
    protected @Nullable CdTyp9 unit;
    /**
     * Application instructions. Further information on how to apply the medication. Do not use for unstructured
     * dosage information; use the inner posology object's free text instead.
     */
    @JsonProperty("appInstr")
    protected @Nullable String applicationInstructions;
    /**
     * The <a href="http://fhir.ch/ig/ch-emed/ValueSet-edqm-routeofadministration.html">EDQM route of administration</a>.
     */
    @JsonProperty("roa")
    protected @Nullable String routeOfAdministration;
    /**
     * The <a href="https://fhir.ch/ig/ch-term/ValueSet-edqm-administrationmethod.html">EDQM method of administration</a>.
     */
    @JsonProperty("moa")
    protected @Nullable String methodOfAdministration;

    @Override
    protected boolean isInReserve() {
        if (asNeeded == null) return DEFAULT_AS_NEEDED_VALUE;
        return asNeeded;
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = super.validate(basePath);

        if (detail == null) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, DETAIL_FIELD_NAME),
                "The detail of the posology is missing."
        ));
        else result.add(detail.validate(getFieldValidationPath(basePath, DETAIL_FIELD_NAME)));

        return result;
    }

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return inDepth && detail != null && detail.hasExtensions(true);
    }

    /**
     * Performs validation of the eMediplan object taking into account whether it belongs to an eMediplan medication
     * plan document or to an eMediplan prescription document. This performs the base checks of {@link #validate(String)}
     * plus extra validation checks tied to the eMediplan document type.
     *
     * @param basePath     The base path of the object.
     * @param mediplanType The type of eMediplan document.
     * @return The validation result.
     */
    public ValidationResult validate(final @Nullable String basePath, final EMediplanType mediplanType) {
        final var result = validate(basePath);

        if (Objects.requireNonNull(mediplanType) == EMediplanType.MEDICATION_PLAN) {
            if (unit == null) result.add(getRequiredFieldValidationIssue(
                    getFieldValidationPath(basePath, UNIT_FIELD_NAME),
                    "The dosage unit is missing, but it is required for medication plans."
            ));
        }

        return result;
    }

    @Override
    public void trim() {
        if (asNeeded != null && asNeeded == DEFAULT_AS_NEEDED_VALUE) asNeeded = null;
        if (detail != null) detail.trim();
    }
}
