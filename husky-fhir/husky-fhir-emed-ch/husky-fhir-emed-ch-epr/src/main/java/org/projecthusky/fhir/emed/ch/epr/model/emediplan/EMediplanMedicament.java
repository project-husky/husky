package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.MedicamentIdType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.EMediplanPosology;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.repetition.Repetition;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.repetition.RepetitionDuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Information about a medication as well as its dosage.
 */
@Data
public class EMediplanMedicament implements EMediplanExtendable {
    /**
     * The id defined of the type specified by idType. If idType is NONE, then add a free text description here.
     */
    protected String id;
    /**
     * The type of id.
     */
    protected MedicamentIdType idType;
    /**
     * List of posologies (dosage information).
     */
    @JsonProperty("pos")
    protected List<@NonNull EMediplanPosology> posology;
    /**
     * Reason for applying the medication, i.e. reason for treatment.
     */
    @JsonProperty("rsn")
    protected @Nullable String reason;
    /**
     * Whether it is self-medication treatment ({@code true}) or not ({@code false}).
     */
    @JsonProperty("autoMed")
    protected boolean selfMedication;
    /**
     * Prescribed by: the GLN or designation of the prescriber (e.g. physician, pharmacist...).
     */
    @JsonProperty("prscbBy")
    protected @Nullable String prescriber;
    /**
     * The repetition object indicates how often a prescription can be repeated or how long the prescription is valid.
     * <p>
     * If no repetition object is set, a {@link RepetitionDuration} is assumed with value 1, that is: the prescription
     * can be repeated once. This means the prescription would be allow to be dispensed <b>twice</b>: the initial
     * dispense that is always allowed plus the one repetition that is assumed by default.
     * </p>
     * <p>
     * If the dispense is not to be allowed to be done more than once, it is required to set a repetition object with
     * value 0 (no repetition).
     * </p>
     */
    @JsonProperty("reps")
    protected @Nullable Repetition repetition;
    /**
     * {@code true} if the medication should not be substituted, {@code false} otherwise. By default, false is assumed.
     */
    @JsonProperty("isNotSub")
    protected @Nullable Boolean forbidSubstitution;
    /**
     * Sic era scriptum. This field is intended to avoid misunderstandings between the physician and pharmacist and
     * indicates to the pharmacist that the physician has deliberately chosen the prescription and wishes to prescribe
     * the drug in exactly this way and not otherwise. By default, false is assumed.
     */
    protected @Nullable Boolean sic;
    /**
     * Number of packages to be delivered. By default, 1 is assumed for prescriptions, for medication plans it is
     * ignored.
     */
    @JsonProperty("nbPack")
    protected @Nullable Double numberOfPackages;
    /**
     * The list of extensions. Optional if empty.
     */
    @JsonProperty("exts")
    protected @Nullable List<@NonNull EMediplanExtension> extensions;

    public List<@NonNull EMediplanExtension> getExtensions() {
        if (extensions == null) extensions = new ArrayList<>();
        return extensions;
    }
}
