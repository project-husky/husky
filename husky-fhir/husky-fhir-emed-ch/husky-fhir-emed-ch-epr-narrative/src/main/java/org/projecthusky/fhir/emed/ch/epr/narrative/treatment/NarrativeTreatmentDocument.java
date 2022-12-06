package org.projecthusky.fhir.emed.ch.epr.narrative.treatment;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.Enumerations;
import org.hl7.fhir.r4.model.StringType;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;
import org.projecthusky.fhir.emed.ch.common.resource.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.epr.model.common.Author;
import org.projecthusky.fhir.emed.ch.epr.narrative.enums.NarrativeLanguage;
import org.projecthusky.fhir.emed.ch.epr.narrative.services.ValueSetEnumNarrativeForPatientService;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocument;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprCompositionPmlc;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a narrative treatment document
 *
 * @author Ronaldo Loureiro
 */
public class NarrativeTreatmentDocument {

    /**
     * The language to use to generate the narrative text.
     */
    private final NarrativeLanguage narrativeLanguage;

    /**
     * The type of document
     */
    private final EmedDocumentType documentType;

    /**
     * The document creation time
     */
    private final String creationTime;

    // TODO remove ?
    /**
     * The time of the documentation
     */
    private final String documentationTime;

    /**
     * The active treatments
     */
    private final List<NarrativeTreatmentItem> activeTreatments;

    /**
     * The recently stopped treatments
     */
    private final List<NarrativeTreatmentItem> recentTreatments;

    /**
     * The author of the last item entry (of any kind) in this treatment. This is the last intervening.
     */
    private final NarrativeTreatmentAuthor lastInterveningAuthor;

    /**
     * The name of patient
     */
    private final String patientName;

    /**
     * The gender of patient
     */
    @Nullable
    private final String patientGender;

    /**
     * The birth date of patient
     */
    @Nullable
    private final String patientBirthDate;

    /**
     * The address of patient
     */
    @Nullable
    private final String patientAddress;

    /**
     * The number phone of patient
     */
    @Nullable
    private final String patientContact;

    /**
     * Constructor
     *
     * @param builder the builder
     */
    private NarrativeTreatmentDocument(final NarrativeTreatmentDocumentBuilder builder) {
        this.narrativeLanguage = Objects.requireNonNull(builder.narrativeLanguage);
        this.documentType = Objects.requireNonNull(builder.documentType);
        this.creationTime = Objects.requireNonNull(builder.creationTime);
        this.documentationTime = Objects.requireNonNull(builder.documentationTime);
        this.activeTreatments = Objects.requireNonNull(builder.activeTreatments);
        this.recentTreatments = Objects.requireNonNull(builder.recentTreatments);
        this.lastInterveningAuthor = Objects.requireNonNull(builder.lastInterveningAuthor);
        this.patientName = Objects.requireNonNull(builder.patientName);
        this.patientGender = Objects.requireNonNull(builder.patientGender);
        this.patientBirthDate = Objects.requireNonNull(builder.patientBirthDate);
        this.patientAddress = builder.patientAddress;
        this.patientContact = builder.patientContact;
    }

    /**
     * Creates builder to build {@link NarrativeTreatmentDocument}.
     *
     * @param narrativeLanguage language in which the item should be generated
     * @return created builder
     * @throws IOException
     */
    public static NarrativeTreatmentDocumentBuilder builder(NarrativeLanguage narrativeLanguage) throws IOException {
        return new NarrativeTreatmentDocumentBuilder(narrativeLanguage);
    }

    public NarrativeLanguage getNarrativeLanguage() {
        return this.narrativeLanguage;
    }


    public EmedDocumentType getDocumentType() {
        return this.documentType;
    }


    public String getCreationTime() {
        return this.creationTime;
    }


    public String getDocumentationTime() {
        return this.documentationTime;
    }


    public List<NarrativeTreatmentItem> getActiveTreatments() {
        return this.activeTreatments;
    }


    public List<NarrativeTreatmentItem> getRecentTreatments() {
        return this.recentTreatments;
    }


    public NarrativeTreatmentAuthor getLastInterveningAuthor() {
        return lastInterveningAuthor;
    }

    public String getPatientName() {
        return this.patientName;
    }

    @Nullable
    public String getPatientGender() {
        return this.patientGender;
    }

    @Nullable
    public String getPatientBirthDate() {
        return this.patientBirthDate;
    }

    @Nullable
    public String getPatientAddress() {
        return this.patientAddress;
    }

    @Nullable
    public String getPatientContact() {
        return this.patientContact;
    }


    public static class NarrativeTreatmentDocumentBuilder {
        private final String DATE_PATTERN = "dd.MM.yyyy";
        private final String DATETIME_PATTERN = "dd.MM.yyyy HH:mm:ss";
        private final NarrativeLanguage narrativeLanguage;
        private final ValueSetEnumNarrativeForPatientService valueSetEnumNarrativeForPatientService;
        private EmedDocumentType documentType;
        private String creationTime;
        private String documentationTime;
        private final List<NarrativeTreatmentItem> activeTreatments;
        private final List<NarrativeTreatmentItem> recentTreatments;
        private NarrativeTreatmentAuthor lastInterveningAuthor;
        private String patientName;
        private String patientGender;
        private String patientBirthDate;
        private String patientAddress;
        private String patientContact;

        /**
         * Constructor.
         *
         * @param narrativeLanguage the lang of the narrative content.
         * @throws IOException
         */
        public NarrativeTreatmentDocumentBuilder(final NarrativeLanguage narrativeLanguage) throws IOException {
            this.narrativeLanguage = narrativeLanguage;
            this.valueSetEnumNarrativeForPatientService = new ValueSetEnumNarrativeForPatientService();
            this.activeTreatments = new ArrayList<>();
            this.recentTreatments = new ArrayList<>();
        }

        /**
         * Formats a {@link TemporalAccessor} with the given pattern.
         *
         * @param pattern  The pattern.
         * @param temporal The {@link TemporalAccessor}
         * @return this.
         */
        private String formatTemporalAccessor(final String pattern,
                                              final TemporalAccessor temporal) {
            return DateTimeFormatter.ofPattern(pattern, this.narrativeLanguage.getLocale())
                    .withZone(ZoneId.systemDefault())
                    .format(temporal);
        }

        /**
         * Sets the type of the document.
         *
         * @param documentType The type of the document.
         * @return this.
         */
        public NarrativeTreatmentDocumentBuilder documentType(final EmedDocumentType documentType) {
            this.documentType = documentType;
            return this;
        }

        /**
         * Sets the creation time of the document
         *
         * @param creationTime The creation time of the document.
         * @return this.
         */
        public NarrativeTreatmentDocumentBuilder creationTime(final TemporalAccessor creationTime) {
            this.creationTime = this.formatTemporalAccessor(DATETIME_PATTERN, creationTime);
            return this;
        }

        public NarrativeTreatmentDocumentBuilder documentationTime(final TemporalAccessor documentationTime) {
            this.documentationTime = this.formatTemporalAccessor(DATETIME_PATTERN, documentationTime);
            return this;
        }

        /**
         * Adds the active treatments
         *
         * @param activeTreatments The active treatments
         * @return this.
         */
        public NarrativeTreatmentDocumentBuilder addActiveTreatments(final List<NarrativeTreatmentItem> activeTreatments) {
            this.activeTreatments.addAll(activeTreatments);
            return this;
        }

        public NarrativeTreatmentDocumentBuilder addRecentTreatments(final List<NarrativeTreatmentItem> recentTreatments) {
            this.recentTreatments.addAll(recentTreatments);
            return this;
        }

        /**
         * Sets the last intervening author.
         *
         * @param author The last intervening author.
         * @return this.
         */
        public NarrativeTreatmentDocumentBuilder lastInterveningAuthor(final Author author) {
            this.lastInterveningAuthor = new NarrativeTreatmentAuthor(author);
            return this;
        }

        /**
         * Sets the patient.
         *
         * @param patient The patient.
         * @return this.
         */
        public NarrativeTreatmentDocumentBuilder patient(final ChCorePatientEpr patient) {
            return this.patientName(String.format("%s %s",
                                                  patient.getNameFirstRep().getGivenAsSingleString(),
                                                  patient.getNameFirstRep().getFamily()))
                    .patientGender(patient.resolveGender())
                    .patientBirthDate(patient.resolveBirthDate())
                    .patientAddress(patient.resolveAddress());
        }

        /**
         * Sets the patient's name.
         *
         * @param patientName The patient's name.
         * @return this.
         */
        public NarrativeTreatmentDocumentBuilder patientName(final String patientName) {
            this.patientName = patientName;
            return this;
        }

        /**
         * Sets the patient's gender.
         *
         * @param gender The patient's gender.
         * @return this.
         */
        public NarrativeTreatmentDocumentBuilder patientGender(final Enumerations.AdministrativeGender gender) {
            this.patientGender = gender.getDisplay();
            return this;
        }

        /**
         * Sets the patient's birthdate.
         *
         * @param patientBirthDate The patient's birthdate.
         * @return this.
         */
        public NarrativeTreatmentDocumentBuilder patientBirthDate(final LocalDate patientBirthDate) {
            this.patientBirthDate = this.formatTemporalAccessor(DATE_PATTERN, patientBirthDate);
            return this;
        }

        /**
         * Sets the patient's address.
         *
         * @param address The patient's address.
         * @return this.
         */
        public NarrativeTreatmentDocumentBuilder patientAddress(@Nullable final Address address) {
            if (address != null) {
                final var line = String.join(" ",
                                             address.getLine()
                                                     .stream()
                                                     .map(StringType::getValue)
                                                     .toList());
                this.patientAddress = String.format("%s, %s %s", line, address.getPostalCode(), address.getCity());
            }
            return this;
        }

        /**
         * Sets the patient's contact.
         *
         * @param contact the patient's contact.
         * @return this.
         */
        public NarrativeTreatmentDocumentBuilder patientContact(final ContactPoint contact) {
            this.patientContact = contact.getValue();
            return this;
        }

        /**
         * Creates a {@link NarrativeTreatmentDocument}.
         *
         * @param document         The CH EMED Document.
         * @param emedDocumentType The type of the CH EMED Document.
         * @return this.
         */
        public NarrativeTreatmentDocumentBuilder emedDocumentDigest(final ChEmedEprDocument document,
                                                                    final EmedDocumentType emedDocumentType) {
            this.documentType(emedDocumentType);
            this.creationTime(document.resolveTimestamp());
            this.documentationTime(document.resolveComposition().resolveDate());
            this.patient(document.resolvePatient());

            if (document.resolveComposition() instanceof final ChEmedEprCompositionPmlc composition) {

                final var authorDoc = new Author(composition.resolveAuthors().get(0));
                this.lastInterveningAuthor(authorDoc);

                this.addActiveTreatments(composition
                                                 .resolveMedicationStatements()
                                                 .stream()
                                                 .map(medication -> {
                                                     try {
                                                         return NarrativeTreatmentItem.builder(this.narrativeLanguage).emedMedicationStatementEntryDigest(
                                                                 medication).build();
                                                     } catch (IOException e) {
                                                         throw new RuntimeException(e);
                                                     }
                                                 })
                                                 .toList());
            }
            return this;
        }

        public NarrativeTreatmentDocument build() {
            return new NarrativeTreatmentDocument(this);
        }
    }
}
