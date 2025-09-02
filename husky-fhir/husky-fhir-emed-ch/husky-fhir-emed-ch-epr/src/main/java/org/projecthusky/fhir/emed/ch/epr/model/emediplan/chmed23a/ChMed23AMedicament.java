package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanMedicament;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.MedicamentIdType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.posology.ChMed23APosology;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.repetition.Repetition;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.repetition.RepetitionDuration;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.repetition.RepetitionNumber;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Information about a medication as well as its dosage.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ChMed23AMedicament extends EMediplanMedicament<ChMed23AExtension> implements ChMed23AExtendable {
    protected final static String ID_FIELD_NAME = "id";
    protected final static String ID_TYPE_FIELD_NAME = "idType";
    protected final static String POSOLOGY_FIELD_NAME = "pos";
    protected final static String SELF_MEDICATION_FIELD_NAME = "autoMed";
    protected final static String PRESCRIBER_FIELD_NAME = "prscbBy";
    protected final static String REPETITION_FIELD_NAME = "reps";
    protected final static String SIC_FIELD_NAME = "sic";
    protected final static String NUMBER_OF_PACKAGES_FIELD_NAME = "nbPack";
    protected final static String EXTENSIONS_FIELD_NAME = "exts";

    protected final static Repetition DEFAULT_REPETITION = new RepetitionNumber(1);

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
    @JsonProperty(POSOLOGY_FIELD_NAME)
    protected List<@NonNull ChMed23APosology> posology;
    /**
     * Reason for applying the medication, i.e. reason for treatment.
     */
    @JsonProperty("rsn")
    protected @Nullable String reason;
    /**
     * Whether it is self-medication treatment ({@code true}) or not ({@code false}).
     */
    @JsonProperty(SELF_MEDICATION_FIELD_NAME)
    protected @Nullable Boolean selfMedication;
    /**
     * Prescribed by: the GLN or designation of the prescriber (e.g. physician, pharmacist...).
     */
    @JsonProperty(PRESCRIBER_FIELD_NAME)
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
    @JsonProperty(REPETITION_FIELD_NAME)
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
    @JsonProperty(NUMBER_OF_PACKAGES_FIELD_NAME)
    protected @Nullable Double numberOfPackages;
    /**
     * The list of extensions. Optional if empty.
     */
    @JsonProperty(EXTENSIONS_FIELD_NAME)
    protected @Nullable List<@NonNull ChMed23AExtension> extensions;

    @Override
    public List<@NonNull ChMed23AExtension> getExtensions() {
        if (extensions == null) extensions = new ArrayList<>();
        return extensions;
    }

    @JsonProperty("isNotSub")
    public boolean isSubstitutionForbidden() {
        if (forbidSubstitution == null) return false;
        return forbidSubstitution;
    }

    public boolean isSic() {
        if (sic == null) return false;
        return sic;
    }

    @Override
    @ExpectsValidResource
    public boolean isSelfMedication() {
        if (selfMedication == null) return false;
        return selfMedication;
    }

    @Override
    public String getIdFieldName() {
        return ID_FIELD_NAME;
    }

    @Override
    public String getIdTypeFieldName() {
        return ID_TYPE_FIELD_NAME;
    }

    @Override
    protected ValidationResult validateBase(final @Nullable String basePath, boolean contextAwareCaller) {
        final var result = super.validateBase(basePath, contextAwareCaller);

        if (!contextAwareCaller && posology != null && !posology.isEmpty()) {
            final var posologyIterator = posology.listIterator();
            while (posologyIterator.hasNext()) {
                final var index = posologyIterator.nextIndex();
                result.add(posologyIterator.next().validate(getFieldValidationPath(basePath, POSOLOGY_FIELD_NAME, index)));
            }
        }

        if (repetition != null) result.add(repetition.validate(getFieldValidationPath(basePath, REPETITION_FIELD_NAME)));

        return result;
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath, final EMediplanType mediplanType) {
        final var result = super.validate(basePath, mediplanType);

        if (mediplanType == EMediplanType.MEDICATION_PLAN) {
            if (selfMedication == null) result.add(getRequiredFieldValidationIssue(
                    getFieldValidationPath(basePath, SELF_MEDICATION_FIELD_NAME),
                    "The autoMed field is mandatory for medication plans but it is missing."
            ));

            if (repetition != null) result.add(getIgnoredFieldValidationIssue(
                    getFieldValidationPath(basePath, REPETITION_FIELD_NAME),
                    "Medicaments in medication plan objects should not have specified repetitions."
            ));

            if (sic != null) result.add(getIgnoredFieldValidationIssue(
                    getFieldValidationPath(basePath, SIC_FIELD_NAME),
                    "The sic (sic erat scriptum) flag should not be set for medication plans, but it is present."
            ));

            if (numberOfPackages != null) result.add(getIgnoredFieldValidationIssue(
                    getFieldValidationPath(basePath, NUMBER_OF_PACKAGES_FIELD_NAME),
                    "The number of packages should not be specified in a medication plan document."
            ));
        }

        if (mediplanType == EMediplanType.PRESCRIPTION) {
            if (selfMedication != null) result.add(getIgnoredFieldValidationIssue(
                    getFieldValidationPath(basePath, SELF_MEDICATION_FIELD_NAME),
                    "The self-medication field should not be present for prescription documents, since self-medication cannot be prescribed."
            ));

            if (prescriber != null && !prescriber.isBlank()) result.add(getIgnoredFieldValidationIssue(
                    getFieldValidationPath(basePath, PRESCRIBER_FIELD_NAME),
                    "The prescriber field of the medicament should not be filled for prescription documents. This is assumed to be the HC person."
            ));
        }

        if (posology != null && !posology.isEmpty()) {
            final var posologyIterator = posology.listIterator();
            while (posologyIterator.hasNext()) {
                final var index = posologyIterator.nextIndex();
                result.add(posologyIterator.next().validate(getFieldValidationPath(basePath, POSOLOGY_FIELD_NAME, index), mediplanType));
            }
        }

        return result;
    }

    @Override
    public void trim() {
        super.trim();

        if (posology != null && !posology.isEmpty()) posology.forEach(ChMed23APosology::trim);

        if (repetition != null) {
            if (DEFAULT_REPETITION.equals(repetition))
                repetition = null;
            else repetition.trim();
        }

        if (forbidSubstitution != null && !forbidSubstitution) forbidSubstitution = null;

        if (sic != null && !sic) sic = null;

        if (DEFAULT_NUMBER_OF_PACKAGES.equals(numberOfPackages)) numberOfPackages = null;
    }

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return (extensions != null && !extensions.isEmpty()) || (inDepth && (
                (posology != null && posology.stream().anyMatch(pos -> pos.hasExtensions(true))) ||
                (repetition != null && repetition.hasExtensions(true))
                ));
    }
}
