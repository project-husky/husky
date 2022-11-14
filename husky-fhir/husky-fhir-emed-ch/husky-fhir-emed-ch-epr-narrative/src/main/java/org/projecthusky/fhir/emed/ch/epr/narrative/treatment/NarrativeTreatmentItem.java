package org.projecthusky.fhir.emed.ch.epr.narrative.treatment;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.common.enums.PharmaceuticalDoseFormEdqm;
import org.projecthusky.fhir.emed.ch.common.enums.RouteOfAdministrationEdqm;
import org.projecthusky.fhir.emed.ch.common.enums.UnitCode;
import org.projecthusky.fhir.emed.ch.epr.enums.RegularUnitCodeAmbu;
import org.projecthusky.fhir.emed.ch.epr.enums.RouteOfAdministrationAmbu;
import org.projecthusky.fhir.emed.ch.epr.enums.TimingEventAmbu;
import org.projecthusky.fhir.emed.ch.epr.model.common.Author;
import org.projecthusky.fhir.emed.ch.epr.narrative.enums.NarrativeLanguage;
import org.projecthusky.fhir.emed.ch.epr.narrative.enums.ProductCodeType;
import org.projecthusky.fhir.emed.ch.epr.narrative.services.ValueSetEnumNarrativeForPatientService;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedication;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedicationIngredient;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedicationStatement;
import org.projecthusky.fhir.emed.ch.epr.resource.dosage.ChEmedDosage;
import org.projecthusky.fhir.emed.ch.epr.resource.dosage.ChEmedDosageSplit;
import org.projecthusky.fhir.emed.ch.epr.resource.dosage.ChEmedQuantityWithEmedUnits;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprMedicationStatementPmlc;

import java.io.IOException;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.*;


/**
 * Represents an entry in a treatment card
 *
 * @author Ronaldo Loureiro
 */
public class NarrativeTreatmentItem {

    /**
     * The "last" author and her/his organization of the medical decision.
     */
    private final NarrativeTreatmentAuthor lastMedicalAuthor;

    /**
     * The "last" author of the original document.
     */
    private final NarrativeTreatmentAuthor documentAuthor;

    /**
     * The medication code type in the GTIN system or in the ATC system.
     */
    private final ProductCodeType codeType;

    /**
     * The medication code in the GTIN system or in the ATC system
     */
    private final String productCode;

    /**
     * The form code
     */
    @Nullable
    private final String productFormCode;

    /**
     * The active ingredients
     */
    private final List<NarrativeTreatmentIngredient> productIngredients;

    /**
     * The lower bound of the planned item validity period.
     */
    private final String treatmentStart;

    /**
     * The higher bound of the planned item validity period or {@code null} if it's not bounded.
     */
    @Nullable
    private final String treatmentStop;

    /**
     * The number of doses to take in the morning
     */
    @Nullable
    private final String dosageIntakeMorning;

    /**
     * The number of doses to take in the noon
     */
    @Nullable
    private final String dosageIntakeNoon;

    /**
     * The number of doses to take in the evening
     */
    @Nullable
    private final String dosageIntakeEvening;

    /**
     * The number of doses to take in the night
     */
    @Nullable
    private final String dosageIntakeNight;

    /**
     * The unit of dosage
     */
    @Nullable
    private final String dosageUnit;

    /**
     * The treatment reason or {@code null} if it isn't provided.
     */
    @Nullable
    private final String treatmentReason;

    /**
     * Whether the treatment is to be taken regularly ({@code false}) or only if required ({@code true}).
     */
    private final boolean inReserve;

    /**
     * The medication name.
     */
    private String productName;

    /**
     * The medication icon
     */
    @Nullable
    private String productIcon;

    /**
     * The image on the front of the medicine
     */
    @Nullable
    private String productImageFront;

    /**
     * The image on the back of the medicine
     */
    @Nullable
    private String productImageBack;

    /**
     * The medication route of administration or {@code null} if it's not specified.
     */
    @Nullable
    private String routeOfAdministration;

    /**
     * The patient medication instructions or {@code null} if it isn't provided.
     */
    @Nullable
    private final String patientMedicationInstructions;

    /**
     * The fulfilment instructions or {@code null} if it isn't provided.
     */
    @Nullable
    private final String fulfilmentInstructions;

    /**
     * The annotation comment or {@code null} if it isn't provided.
     */
    @Nullable
    private final String annotationComment;

    /**
     * Constructor
     *
     * @param builder the builder
     */
    private NarrativeTreatmentItem(final NarrativeTreatmentItemBuilder builder) {
        this.lastMedicalAuthor = builder.lastMedicalAuthor;
        this.documentAuthor = builder.documentAuthor;

        this.productName = Objects.requireNonNull(builder.productName);
        this.codeType = Objects.requireNonNull(builder.codeType);
        this.productCode = Objects.requireNonNull(builder.productCode);
        this.productFormCode = builder.productFormCode;

//        this.productIngredients = Objects.requireNonNull(builder.productIngredients);
        this.productIngredients = builder.productIngredients;

//        this.treatmentStart = Objects.requireNonNull(builder.treatmentStart);
        this.treatmentStart = builder.treatmentStart;

        this.treatmentStop = builder.treatmentStop;
        this.dosageIntakeMorning = builder.dosageIntakeMorning;
        this.dosageIntakeNoon = builder.dosageIntakeNoon;
        this.dosageIntakeEvening = builder.dosageIntakeEvening;
        this.dosageIntakeNight = builder.dosageIntakeNight;
        this.dosageUnit = builder.dosageUnit;
        this.routeOfAdministration = builder.routeOfAdministration;
        this.treatmentReason = builder.treatmentReason;
        this.patientMedicationInstructions = builder.patientMedicationInstructions;
        this.fulfilmentInstructions = builder.fulfilmentInstructions;
        this.inReserve = builder.inReserve;
        this.annotationComment = builder.annotationComment;
        this.productIcon = builder.productIcon;
        this.productImageFront = builder.productImageFront;
        this.productImageBack = builder.productImageBack;

//        this.productIcon = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAABHNCSVQICAgIfAhkiAAAAAlwSFlzAAAApgAAAKYB3X3/OAAAABl0RVh0U29mdHdhcmUAd3d3Lmlua3NjYXBlLm9yZ5vuPBoAAAJBSURBVEiJldXLi85RHMfx148xKeTOxsKkkFwml4UyxUZZkFgojdtCLlsWykZZ+AvGwqVcplGEBaXcIrkrQwyhiKIwrsndsfh9n/rNmMdvnlOnnud8P+fz/n2/55allBRblmX1WIFZmIGJeIRbuIbWlNJPvWxZEZBlWSMOYBI6wrQDDZiK2biPVSml9l4RUkoCshY/cAfTKuPFjik4E7qNPWn+mRMTp+I7dqH+vxPYgRSQxlIA6tGO2zWYb8GFyLZfGWAlfmFyb83j/3T8weoyQAvaazEvjN9CSxngBvbUah6xvbhSBviMzbWaR3wrOssAd7GzVvPQ7MKDMkArLtdqHrorOFkGWIfflcNVg/nM2EXNZYA63MPZGsyH4jy+ye+sYVW1MWFuGFfbLQOwAW14XNAW+xecwnqM6AIIk+b4otMYXxhfhjdRjrdhdhRz5HdTE5ZiE87hZ+iWdAGE2Wy8CLOb2B+/j2EyBkcWCYcwuIdsR2JfaNb0VN++mB/mv3AdfbppmvERz9BUZZ3acLvqQoboA65WiTXENv2N7agrxOoiVt28AEhR20lVst0WmV7DOEzAkcrid3nRurcsyzrlV/Jw+ZvRETvlEV6jE4OwSH6evqI/noRmQRngYCx8o3wrN8dXNgS00j7gafTDOCE/J+/KSjQlvvQ5lmNgITYoyjGkMNYfi/EQn9D03wwii9HYjYXyZ/JStxINwSiMxTz5obyKlSmlJ6WAAmisvNbzMQajMQzv8QovcRHHU0qPK/P+Ao5hifKA5QCNAAAAAElFTkSuQmCC";
//        this.productImageFront = "data:image/png;base64,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";
    }

    /**
     * Creates builder to build {@link NarrativeTreatmentItem}.
     *
     * @param narrativeLanguage language in which the item should be generated
     * @return created builder
     * @throws IOException
     */
    public static NarrativeTreatmentItemBuilder builder(final NarrativeLanguage narrativeLanguage) throws IOException {
        return new NarrativeTreatmentItemBuilder(narrativeLanguage);
    }

    @Nullable
    public NarrativeTreatmentAuthor getLastMedicalAuthor() {
        return this.lastMedicalAuthor;
    }

    @Nullable
    public NarrativeTreatmentAuthor getDocumentAuthor() {
        return this.documentAuthor;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(final String productName) {
        this.productName = Objects.requireNonNull(productName);
    }

    @Nullable
    public String getProductIcon() {
        return this.productIcon;
    }

    public void setProductIcon(final String productIcon) {
        this.productIcon = productIcon;
    }

    @Nullable
    public String getProductImageFront() {
        return this.productImageFront;
    }

    public void setProductImageFront(final String productImageFront) {
        this.productImageFront = productImageFront;
    }

    @Nullable
    public String getProductImageBack() {
        return this.productImageBack;
    }

    public void setProductImageBack(final String productImageBack) {
        this.productImageBack = productImageBack;
    }

    public ProductCodeType getCodeType() {
        return this.codeType;
    }

    public String getProductCode() {
        return this.productCode;
    }

    @Nullable
    public String getProductFormCode() {
        return this.productFormCode;
    }

    public List<NarrativeTreatmentIngredient> getProductIngredients() {
        return this.productIngredients;
    }

    public void setProductIngredients(final List<NarrativeTreatmentIngredient> productIngredients) {
        this.productIngredients.clear();
        this.productIngredients.addAll(productIngredients);
    }

    public String getTreatmentStart() {
        return this.treatmentStart;
    }

    @Nullable
    public String getTreatmentStop() {
        return this.treatmentStop;
    }

    @Nullable
    public String getDosageIntakeMorning() {
        return this.dosageIntakeMorning;
    }

    @Nullable
    public String getDosageIntakeNoon() {
        return this.dosageIntakeNoon;
    }

    @Nullable
    public String getDosageIntakeEvening() {
        return this.dosageIntakeEvening;
    }

    @Nullable
    public String getDosageIntakeNight() {
        return this.dosageIntakeNight;
    }

    @Nullable
    public String getDosageUnit() {
        return this.dosageUnit;
    }

    @Nullable
    public String getRouteOfAdministration() {
        return this.routeOfAdministration;
    }

    public void setRouteOfAdministration(final String routeOfAdministration) {
        this.routeOfAdministration = routeOfAdministration;
    }

    @Nullable
    public String getTreatmentReason() {
        return this.treatmentReason;
    }

    @Nullable
    public String getPatientMedicationInstructions() {
        return this.patientMedicationInstructions;
    }

    @Nullable
    public String getFulfilmentInstructions() {
        return this.fulfilmentInstructions;
    }

    public boolean isInReserve() {
        return this.inReserve;
    }

    @Nullable
    public String getAnnotationComment() {
        return this.annotationComment;
    }

    public static class NarrativeTreatmentItemBuilder {

        private final String DATE_PATTERN = "dd.MM.yyyy";
        private final String DATETIME_PATTERN = "dd.MM.yyyy HH:mm:ss";

        private NarrativeLanguage narrativeLanguage;
        private ValueSetEnumNarrativeForPatientService valueSetEnumNarrative;
        private NarrativeTreatmentAuthor lastMedicalAuthor;
        private NarrativeTreatmentAuthor documentAuthor;
        private String productName;
        private String productIcon;
        private String productImageFront;
        private String productImageBack;
        private ProductCodeType codeType;
        private String productCode;
        private String productFormCode;
        private List<NarrativeTreatmentIngredient> productIngredients;
        private String treatmentStart;
        private String treatmentStop;
        private String dosageIntakeMorning;
        private String dosageIntakeNoon;
        private String dosageIntakeEvening;
        private String dosageIntakeNight;
        private String dosageUnit;
        private String routeOfAdministration;
        private String treatmentReason;
        private String patientMedicationInstructions;
        private String fulfilmentInstructions;
        private boolean inReserve;
        private String annotationComment;

        public NarrativeTreatmentItemBuilder(final NarrativeLanguage narrativeLanguage) throws IOException {
            this.narrativeLanguage = narrativeLanguage;
            this.valueSetEnumNarrative = new ValueSetEnumNarrativeForPatientService();
            this.productIngredients = new ArrayList<>();
        }

        private String formatTemporalAccessor(final String pattern,
                                              final TemporalAccessor temporal) {
            return DateTimeFormatter.ofPattern(pattern, this.narrativeLanguage.getLocale())
                    .withZone(ZoneId.systemDefault())
                    .format(temporal);
        }

        public NarrativeTreatmentItemBuilder lastMedicalAuthor(final Author lastMedicalAuthor) {
            this.lastMedicalAuthor = new NarrativeTreatmentAuthor(lastMedicalAuthor);
            return this;
        }

        public NarrativeTreatmentItemBuilder documentAuthor(final Author documentAuthor) {
            this.documentAuthor = new NarrativeTreatmentAuthor(documentAuthor);
            return this;
        }

        public NarrativeTreatmentItemBuilder product(final ChEmedEprMedication medication) {

            final var gtin = medication.resolveGtinCode();
            final var atc = medication.resolveAtcCode();

            if (gtin != null) {
                this.codeType(ProductCodeType.GTIN);
                this.productCode(gtin);
            } else if (atc != null) {
                this.codeType(ProductCodeType.ATC);
                this.productCode(atc);
            }

            this.productName(medication.resolveMedicationName())
                    .productFormCode(medication.resolveForm())
                    .addProductIngredients(medication.resolveActiveIngredients());

            return this;
        }

        public NarrativeTreatmentItemBuilder productName(final String productName) {
            this.productName = productName;
            return this;
        }

        public NarrativeTreatmentItemBuilder productIcon(final String icon) {
            this.productIcon = icon;
            return this;
        }

        public NarrativeTreatmentItemBuilder productImageFront(final String image) {
            this.productImageFront = image;
            return this;
        }

        public NarrativeTreatmentItemBuilder productImageBack(final String image) {
            this.productImageBack = image;
            return this;
        }

        public NarrativeTreatmentItemBuilder codeType(final ProductCodeType codeType) {
            this.codeType = codeType;
            return this;
        }

        public NarrativeTreatmentItemBuilder productCode(final String productCode) {
            this.productCode = productCode;
            return this;
        }

        public NarrativeTreatmentItemBuilder productFormCode(final PharmaceuticalDoseFormEdqm formCode) {
            this.productFormCode = this.valueSetEnumNarrative.getMessage(formCode, this.narrativeLanguage);

            String iconPath = switch (formCode) {
                case GEL -> "/narrative/default/icons/droplet.png";
                case CREAM -> "/narrative/default/icons/tube.png";
                case INHALATION_POWDER -> "/narrative/default/icons/inhaler.png";
                case NASAL_SPRAY_SOLUTION -> "/narrative/default/icons/nasal-spray.png";
                case OROMUCOSAL_LARYNGOPHARYNGEAL_SOLUTION_SPRAY_SOLUTION -> "/narrative/default/icons/oral-spray.png";
                default -> "/narrative/default/icons/capsule-pill.png";
            };

            try {
                this.productIcon("data:image/png;base64," + Base64.getEncoder().encodeToString(NarrativeTreatmentItem.class.getResourceAsStream(iconPath).readAllBytes()));
            } catch (IOException ignored) {
            }

            return this;
        }

        public NarrativeTreatmentItemBuilder addProductIngredients(final List<ChEmedEprMedicationIngredient> productIngredients) {
            this.productIngredients.addAll(productIngredients.stream()
                    .filter(ingredient -> ingredient.resolveStrength() != null)
                    .map(ingredient -> new NarrativeTreatmentIngredient(
                            ingredient.resolveActiveIngredient().getDisplayName(),
                            ingredient.resolveStrength().resolveNumerator()))
                    .toList());
            return this;
        }

        public NarrativeTreatmentItemBuilder dosage(final ChEmedDosage dosage) {
            this.routeOfAdministration(dosage.resolveRouteOfAdministration());
            this.treatmentStart(dosage.getBoundsPeriod().getStart().toInstant());
            this.treatmentStop(dosage.getBoundsPeriod().getEnd().toInstant());
            this.inReserve(dosage.getAsNeededBooleanType().booleanValue());

            this.patientMedicationInstructions(dosage.getPatientInstruction());
            this.fulfilmentInstructions(dosage.getText());

            final var whens = dosage.resolveWhen();
            final var doseQuantity = dosage.resolveDoseQuantity();
            return this.whens(whens, doseQuantity);
        }

        public NarrativeTreatmentItemBuilder dosage(final List<ChEmedDosageSplit> dosages) {
            for (final var dosage : dosages) {
                final var whens = dosage.resolveWhen();
                final var doseQuantity = dosage.resolveDoseQuantity();
                this.whens(whens, doseQuantity);
            }

            return this;
        }

        public NarrativeTreatmentItemBuilder whens(@Nullable final List<TimingEventAmbu> whens,
                                                   @Nullable final ChEmedQuantityWithEmedUnits doseQuantity) {
            if (whens != null && !whens.isEmpty() && doseQuantity != null) {
                final var quantity = doseQuantity.resolveQuantity().toPlainString();
                for (final var when : whens) {
                    switch (when) {
                        case MORNING -> dosageIntakeMorning(quantity);
                        case NOON -> dosageIntakeNoon(quantity);
                        case EVENING -> dosageIntakeEvening(quantity);
                        case NIGHT -> dosageIntakeNight(quantity);
                    }
                }
                dosageUnit(doseQuantity.resolveUnitCode());
            }
            return this;
        }

        public NarrativeTreatmentItemBuilder treatmentStart(final TemporalAccessor treatmentStart) {
            this.treatmentStart = this.formatTemporalAccessor(DATE_PATTERN, treatmentStart);
            return this;
        }

        public NarrativeTreatmentItemBuilder treatmentStop(@Nullable final TemporalAccessor treatmentStop) {
            if (treatmentStop != null) {
                this.treatmentStop = this.formatTemporalAccessor(DATE_PATTERN, treatmentStop);
            }
            return this;
        }

        public NarrativeTreatmentItemBuilder dosageIntakeMorning(final String dosageIntakeMorning) {
            this.dosageIntakeMorning = dosageIntakeMorning;
            return this;
        }

        public NarrativeTreatmentItemBuilder dosageIntakeNoon(final String dosageIntakeNoon) {
            this.dosageIntakeNoon = dosageIntakeNoon;
            return this;
        }

        public NarrativeTreatmentItemBuilder dosageIntakeEvening(final String dosageIntakeEvening) {
            this.dosageIntakeEvening = dosageIntakeEvening;
            return this;
        }

        public NarrativeTreatmentItemBuilder dosageIntakeNight(final String dosageIntakeNight) {
            this.dosageIntakeNight = dosageIntakeNight;
            return this;
        }

        public NarrativeTreatmentItemBuilder dosageUnit(final RegularUnitCodeAmbu unit) {
            this.dosageUnit = this.valueSetEnumNarrative.getMessage(unit, this.narrativeLanguage);
            return this;
        }

        public NarrativeTreatmentItemBuilder dosageUnit(final UnitCode unit) {
            this.dosageUnit = this.valueSetEnumNarrative.getMessage(unit, this.narrativeLanguage);
            return this;
        }

        public NarrativeTreatmentItemBuilder routeOfAdministration(final RouteOfAdministrationAmbu routeOfAdministration) {
            if (routeOfAdministration != null) {
                this.routeOfAdministration = this.valueSetEnumNarrative.getMessage(routeOfAdministration, this.narrativeLanguage);
            }
            return this;
        }

        public NarrativeTreatmentItemBuilder routeOfAdministration(@Nullable final RouteOfAdministrationEdqm routeOfAdministration) {
            if (routeOfAdministration != null) {
                this.routeOfAdministration = this.valueSetEnumNarrative.getMessage(routeOfAdministration, this.narrativeLanguage);
            }
            return this;
        }

        public NarrativeTreatmentItemBuilder treatmentReason(final String treatmentReason) {
            this.treatmentReason = treatmentReason;
            return this;
        }

        public NarrativeTreatmentItemBuilder patientMedicationInstructions(final String patientMedicationInstructions) {
            this.patientMedicationInstructions = patientMedicationInstructions;
            return this;
        }

        public NarrativeTreatmentItemBuilder fulfilmentInstructions(final String fulfilmentInstructions) {
            this.fulfilmentInstructions = fulfilmentInstructions;
            return this;
        }

        public NarrativeTreatmentItemBuilder inReserve(final boolean inReserve) {
            this.inReserve = inReserve;
            return this;
        }

        public NarrativeTreatmentItemBuilder annotationComment(final String annotationComment) {
            this.annotationComment = annotationComment;
            return this;
        }

        public NarrativeTreatmentItemBuilder emedMedicationStatementEntryDigest(final ChEmedEprMedicationStatement medicationStatement) {
            final var medication = medicationStatement.resolveMedication();

            if (medicationStatement instanceof ChEmedEprMedicationStatementPmlc medStatementPmlc) {
                final var authorMed = new Author(medStatementPmlc.resolveInformationSource());
                final var authorDoc = medStatementPmlc.resolveAuthorDocument();

                if (authorDoc != null) this.documentAuthor(new Author(authorDoc));
                else this.documentAuthor(authorMed);

                this.lastMedicalAuthor(authorMed);
            }

            this.annotationComment(medicationStatement.getNoteFirstRep().getText());
//            this.dosage(medicationStatement.resolveDosageBaseEntry()); // TODO
//            this.dosage(medicationStatement.resolveDosageAdditionalEntry());
            this.product(medication);
            this.treatmentReason(medicationStatement.getReasonCodeFirstRep().getText());

            return this;
        }

        public NarrativeTreatmentItem build() {
            return new NarrativeTreatmentItem(this);
        }
    }
}
