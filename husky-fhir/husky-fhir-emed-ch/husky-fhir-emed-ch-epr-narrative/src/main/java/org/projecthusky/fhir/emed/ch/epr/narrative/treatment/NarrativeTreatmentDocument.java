package org.projecthusky.fhir.emed.ch.epr.narrative.treatment;

import lombok.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.Enumerations;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;
import org.projecthusky.fhir.emed.ch.common.resource.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.epr.model.common.Author;
import org.projecthusky.fhir.emed.ch.epr.narrative.enums.NarrativeLanguage;
import org.projecthusky.fhir.emed.ch.epr.narrative.services.ValueSetEnumNarrativeForPatientService;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprComposition;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocument;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPractitioner;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPractitionerRole;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprCompositionPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprMedicationStatementPmlc;

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
     * The author of the last item entry (of type MTP, PRE, or any type of PADV except COMMENT that apply to an MTP
     * or PRE) in this treatment. This is the last "medical" participant.
     */
    private final NarrativeTreatmentAuthor lastMedicalAuthor;

    /**
     * The name of patient
     */
    private final String patientName;

    /**
     * The gender of patient
     */
    private final String patientGender;

    /**
     * The birth date of patient
     */
    private final String patientBirthDate;

    /**
     * The address of patient
     */
    private final String patientAddress;

    /**
     * The number phone of patient
     */
    private final String patientContact;

    /**
     * Constructor
     * @param builder the builder
     */
    private NarrativeTreatmentDocument(final NarrativeTreatmentDocumentBuilder builder) {
        this.narrativeLanguage = Objects.requireNonNull(builder.narrativeLanguage);
        this.documentType = Objects.requireNonNull(builder.documentType);
        this.creationTime = Objects.requireNonNull(builder.creationTime);
        this.documentationTime = Objects.requireNonNull(builder.documentationTime);
        this.activeTreatments = Objects.requireNonNull(builder.activeTreatments);
        this.recentTreatments = Objects.requireNonNull(builder.recentTreatments);
//        this.lastInterveningAuthor = Objects.requireNonNull(builder.lastInterveningAuthor);
//        this.lastMedicalAuthor = Objects.requireNonNull(builder.lastMedicalAuthor);
        this.lastInterveningAuthor = builder.lastInterveningAuthor;
        this.lastMedicalAuthor = builder.lastMedicalAuthor;
        this.patientName = Objects.requireNonNull(builder.patientName);
        this.patientGender = Objects.requireNonNull(builder.patientGender);
        this.patientBirthDate = Objects.requireNonNull(builder.patientBirthDate);
        this.patientAddress = builder.patientAddress;
        this.patientContact = builder.patientContact;
    }

    /**
     * Creates builder to build {@link NarrativeTreatmentDocument}.
     * @param narrativeLanguage language in which the item should be generated
     *
     * @return created builder
     * @throws IOException
     */
    public static NarrativeTreatmentDocumentBuilder builder(NarrativeLanguage narrativeLanguage) throws IOException {
        return new NarrativeTreatmentDocumentBuilder(narrativeLanguage);
    }

    @NonNull
    public NarrativeLanguage getNarrativeLanguage() { return this.narrativeLanguage; }

    @NonNull
    public EmedDocumentType getDocumentType() {
        return this.documentType;
    }

    @NonNull
    public String getCreationTime() {
        return this.creationTime;
    }

    @NonNull
    public String getDocumentationTime() {
        return this.documentationTime;
    }

    @NonNull
    public List<NarrativeTreatmentItem> getActiveTreatments() {
        return this.activeTreatments;
    }

    @NonNull
    public List<NarrativeTreatmentItem> getRecentTreatments() {
        return this.recentTreatments;
    }

    @NonNull
    public NarrativeTreatmentAuthor getLastInterveningAuthor() { return lastInterveningAuthor; }

    @NonNull
    public NarrativeTreatmentAuthor getLastMedicalAuthor() { return lastMedicalAuthor; }

    @NonNull
    public String getPatientName() {
        return this.patientName;
    }

    @NonNull
    public  String getPatientGender() {
        return this.patientGender;
    }

    @NonNull
    public String getPatientBirthDate() {
        return this.patientBirthDate;
    }

    @Nullable
    public String getPatientAddress() { return this.patientAddress; }

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
        private NarrativeTreatmentAuthor lastMedicalAuthor;
        private String patientName;
        private String patientGender;
        private String patientBirthDate;
        private String patientAddress;
        private String patientContact;

        public NarrativeTreatmentDocumentBuilder(final NarrativeLanguage narrativeLanguage) throws IOException {
            this.narrativeLanguage = narrativeLanguage;
            this.valueSetEnumNarrativeForPatientService = new ValueSetEnumNarrativeForPatientService();
            this.activeTreatments = new ArrayList<>();
            this.recentTreatments = new ArrayList<>();
        }

        private String formatTemporalAccessor(final String pattern,
                                              final TemporalAccessor temporal) {
            return DateTimeFormatter.ofPattern(pattern, this.narrativeLanguage.getLocale())
                    .withZone(ZoneId.systemDefault())
                    .format(temporal);
        }

        public NarrativeTreatmentDocumentBuilder documentType(final EmedDocumentType documentType) {
            this.documentType = documentType;
            return this;
        }

        public NarrativeTreatmentDocumentBuilder creationTime(final TemporalAccessor creationTime) {
            this.creationTime = this.formatTemporalAccessor(DATETIME_PATTERN, creationTime);
            return this;
        }

        public NarrativeTreatmentDocumentBuilder documentationTime(final TemporalAccessor documentationTime) {
            this.documentationTime = this.formatTemporalAccessor(DATETIME_PATTERN, documentationTime);
            return this;
        }

        public NarrativeTreatmentDocumentBuilder addActiveTreatments(final List<NarrativeTreatmentItem> activeTreatments) {
            this.activeTreatments.addAll(activeTreatments);
            return this;
        }

        public NarrativeTreatmentDocumentBuilder addActiveTreatments(final NarrativeTreatmentItem... activeTreatments) {
            this.activeTreatments.addAll(List.of(activeTreatments));
            return this;
        }

        public NarrativeTreatmentDocumentBuilder addRecentTreatments(final List<NarrativeTreatmentItem> recentTreatments) {
            this.recentTreatments.addAll(recentTreatments);
            return this;
        }

        public NarrativeTreatmentDocumentBuilder addRecentTreatments(final NarrativeTreatmentItem... recentTreatments) {
            this.recentTreatments.addAll(List.of(recentTreatments));
            return this;
        }

        public NarrativeTreatmentDocumentBuilder lastInterveningAuthor(final Author author) {
            this.lastInterveningAuthor = new NarrativeTreatmentAuthor(author);
            return this;
        }

        public NarrativeTreatmentDocumentBuilder lastMedicalAuthor(final Author author) {
            this.lastMedicalAuthor = new NarrativeTreatmentAuthor(author);
            return this;
        }

        public NarrativeTreatmentDocumentBuilder patient(final ChCorePatientEpr patient) {
            this.patientName(String.format("%s %s", patient.getNameFirstRep().getGivenAsSingleString(), patient.getNameFirstRep().getFamily()));
            this.patientGender(patient.resolveGender());
            this.patientBirthDate(patient.resolveBirthDate());
            return this;
        }

        public NarrativeTreatmentDocumentBuilder patientName(final String patientName) {
            this.patientName = patientName;
            return this;
        }

        public NarrativeTreatmentDocumentBuilder patientGender(final Enumerations.AdministrativeGender gender) {
            this.patientGender = gender.getDisplay();
            return this;
        }

        public NarrativeTreatmentDocumentBuilder patientBirthDate(final LocalDate patientBirthDate) {
            this.patientBirthDate = this.formatTemporalAccessor(DATE_PATTERN, patientBirthDate);
            return this;
        }

        // TODO with ChCoreAddress
        public NarrativeTreatmentDocumentBuilder patientAddress(final Address address) {
            this.patientAddress = String.format("%s, %s %s", address.getLine(), address.getPostalCode(), address.getCity());
            return this;
        }

        public NarrativeTreatmentDocumentBuilder patientContact(final ContactPoint contact) {
            this.patientContact = contact.getValue();;
            return this;
        }

        public NarrativeTreatmentDocumentBuilder emedDocumentDigest(final ChEmedEprDocument document,
                                                                    final EmedDocumentType emedDocumentType) {
            this.documentType(emedDocumentType);
            this.creationTime(document.resolveTimestamp());
            this.documentationTime(document.resolveComposition().resolveDate());
            this.patient(document.resolvePatient());
//            if (document.getAuthors().size() > 0) {
//                this.lastMedicalAuthor(document.getAuthors().get(document.getAuthors().size() == 2 ? 1 : 0));
//            }

            if (document.resolveComposition() instanceof final ChEmedEprCompositionPmlc composition) {
                //this.lastInterveningAuthor(composition.resolveAuthors().get(0));

                this.addActiveTreatments(composition
                        .resolveMedicationStatements()
                        .stream()
                        .map(medication -> {
                            try {
                                return NarrativeTreatmentItem.builder(this.narrativeLanguage).emedMedicationStatementEntryDigest(medication).build();
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
