package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.CdTyp9;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.RelativeToMeal;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.PosologyDetail;

import java.time.Instant;

/**
 * Describes when and what amount of medication must be taken.
 */
@Data
public class EMediplanPosology {
    /**
     * From date. Format: YYYY-MM-DDThh:mm:ss+02:00 or YYYY-MM-DD (ISO 860113 Combined date and time including time zone
     * or date only) (e.g. 2016-06-16T16:26:15+02:00).
     */
    @JsonProperty("dtFrom")
    @JsonFormat(pattern = "yyyy-MM-dd")
    protected @Nullable Instant start;
    /**
     * To date. Format: YYYY-MM-DDThh:mm:ss+02:00 or YYYY-MM-DD (ISO 860114 Combined date and time including time zone
     * or date only) (e.g. 2016-06-16T16:26:15+02:00).
     * The DtTo must be considered as inclusive. For example, DtTo: 2015-05-01, the patient must apply the medicament
     * also on 2015-05-01.
     */
    @JsonProperty("dtTo")
    @JsonFormat(pattern = "yyyy-MM-dd")
    protected @Nullable Instant end;
    /**
     * Reserve medication. True if in reserve, false otherwise. By default, false is assumed.
     */
    @JsonProperty("inRes")
    protected @Nullable Boolean asNeeded;
    /**
     * Dosage details.
     */
    @JsonProperty("po")
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
}
