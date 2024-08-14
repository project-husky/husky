package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.EMediplanAuthor;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.EMediplanType;

import java.time.Instant;
import java.util.List;

/**
 * This is the main eMediplan object, called {@code Medication} in ChMed23A specification. It contains exactly one
 * patient and a list of medications (named medicament in ChMed23A).
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class EMediplan {
    /**
     * The patient.
     */
    protected EMediplanPatient patient;
    /**
     * The healthcare person author of the document, required if the document author type is an HCP.
     */
    protected @Nullable EMediplanHealthcarePerson hcPerson;
    /**
     * The healthcare organization in which the HealthcarePerson works. Required if the document author type is an HCP.
     */
    protected @Nullable EMediplanHealthcareOrganization hcOrg;
    /**
     * List of medications.
     */
    protected List<@NonNull EMediplanMedicament> meds;
    //TODO add exts?
    /**
     * The type of Medication object, @see MedicationType.
     */
    @JsonProperty("medType")
    protected EMediplanType type;
    /**
     * The id of the Medication object. The eMediplan document creator is responsible for assigning the id.
     */
    protected @Nullable String id;
    /**
     * The type of author of the document.
     */
    @JsonProperty("auth")
    protected EMediplanAuthor author;
    /**
     * The recipient (GLN) of the electronic prescription. To be used if the electronic prescription is to be
     * transmitted electronically to a healthcare professional.
     */
    @JsonProperty("rec")
    protected @Nullable String recipient;
    /**
     * The date of creation. Format: yyyy-mm-ddThh:mm:ss+02:00 (ISO 86012 Combined date and time in UTC)
     * (e.g. 2016-06-16T16:26:15+02:00)
     */
    @JsonFormat(pattern = "yyyy-MM-ddThh:mm:ssXXX")
    @JsonProperty("dt")
    protected Instant timestamp;
    /**
     * Remark. Any information or advice the author would like to share independently of a specific medicament.
     */
    @JsonProperty("mk")
    protected @Nullable String remark;
}
