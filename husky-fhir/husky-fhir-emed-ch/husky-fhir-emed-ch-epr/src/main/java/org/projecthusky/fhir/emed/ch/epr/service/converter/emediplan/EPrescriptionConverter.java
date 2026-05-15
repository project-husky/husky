package org.projecthusky.fhir.emed.ch.epr.service.converter.emediplan;

import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.*;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.core.ch.resource.extension.r4.TextLink;
import org.projecthusky.fhir.emed.ch.common.enums.UnitCode;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.epr.datatypes.ChEmedEprDosage;
import org.projecthusky.fhir.emed.ch.epr.datatypes.ChEmedQuantityWithEmedUnits;
import org.projecthusky.fhir.emed.ch.epr.enums.RegularUnitCodeAmbu;
import org.projecthusky.fhir.emed.ch.epr.enums.SubstanceAdministrationSubstitutionCode;
import org.projecthusky.fhir.emed.ch.epr.enums.TimingEventAmbu;
import org.projecthusky.fhir.emed.ch.epr.model.common.Author;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.ChMed16AHealthcareOrganization;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.ChMed16AHealthcarePerson;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.EPrescription;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.EPrescriptionMedicament;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedication;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPatient;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPractitionerRole;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprCompositionPre;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprDocumentPre;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprMedicationRequestPre;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * Specialized version of the CHMED16A converter that deals with the ePrescription format as defined by the latest
 * revision supported by this module (see {@link EPrescription}).
 */
@Slf4j
public class EPrescriptionConverter extends ChMed16ABaseConverter<EPrescriptionMedicament, EPrescription> {
    protected final EMediplanMedicationResolver  medicationResolver;
    protected final TreatmentPlanResolver treatmentPlanResolver;

    /**
     * Convenience constructor that uses a {@link EMediplanMedicationResolver.NoOpMedicationResolver} and a no-op
     * treatment resolver. Note that resulting PRE documents will not be valid because its medication requests will be
     * missing the treatment plan extension.
     * <p>
     * See {@link EPrescriptionConverter#EPrescriptionConverter(EMediplanMedicationResolver, TreatmentPlanResolver)}
     * </p>
     */
    public EPrescriptionConverter() {
        this(new EMediplanMedicationResolver.NoOpMedicationResolver(), medRequest -> null);
    }

    /**
     * Constructor of an ePrescription converter.
     *
     * @param medicationResolver The resolver that can get a FHIR medication resource from a eMediplan medication id
     *                           and id type.
     * @param treatmentPlanResolver The resolver that can get to which treatment plan to attach new medication requests.
     */
    public EPrescriptionConverter(final EMediplanMedicationResolver medicationResolver,
                                  final  TreatmentPlanResolver treatmentPlanResolver) {
        this.medicationResolver = Objects.requireNonNull(medicationResolver);
        this.treatmentPlanResolver = Objects.requireNonNull(treatmentPlanResolver);
    }

    /**
     * Not supported.
     * @throws UnsupportedOperationException always.
     */
    @Override
    @ExpectsValidResource
    public EPrescription toEMediplan(final ChEmedEprDocumentPmlc pmlc) {
        throw new UnsupportedOperationException("The EPrescriptionConverter supports only prescription conversion.");
    }

    @Override
    public EPrescription toEMediplan(final ChEmedEprDocumentPre pre) {
        final var ePrescription = super.toEMediplan(pre);

        ePrescription.setRevision(EPrescription.LAST_SUPPORTED_REVISION);

        return ePrescription;
    }

    @Override
    protected EPrescriptionMedicament getNewMedicamentInstance() {
        return new EPrescriptionMedicament();
    }

    @Override
    protected EPrescription getNewEmediplanInstance() {
        return new EPrescription();
    }

    @ExpectsValidResource
    protected EPrescription setPrescriptionAuthor(final EPrescription ePrescription, final Author lastMedicalAuthor) {
        super.setPrescriptionAuthor(ePrescription, lastMedicalAuthor);
        // at this point we know this is a practitioner role
        ePrescription.setHealthcarePerson(ChMed16AHealthcarePerson.fromChEmedEprPractitioner(lastMedicalAuthor.getPractitionerRole().resolvePractitioner()));
        ePrescription.setHealthcareOrganization(ChMed16AHealthcareOrganization.fromChEmedEprOrganization(lastMedicalAuthor.getPractitionerRole().resolveOrganization()));
        return ePrescription;
    }

    @Override
    @ExpectsValidResource
    protected EPrescriptionMedicament toMedicament(final ChEmedEprMedication medication,
                                                   final ChEmedEprDosage baseDosage,
                                                   final List<@NonNull ChEmedEprDosage> additionalDosages,
                                                   final @Nullable String treatmentReason,
                                                   final Author medicalAuthor,
                                                   final SubstanceAdministrationSubstitutionCode substitutionCode,
                                                   final MedicationRequest.@Nullable MedicationRequestDispenseRequestComponent dispenseRequest,
                                                   final EMediplanType mediplanType) {
        final var medicament = super.toMedicament(
                medication,
                baseDosage,
                additionalDosages,
                treatmentReason,
                medicalAuthor,
                substitutionCode,
                dispenseRequest,
                mediplanType
        );

        // TODO: https://github.com/project-husky/husky/issues/352 (indicationCode)

        return medicament;
    }

    /**
     * Converts an ePrescription to a CH EMED EPR PRE document. No pre-validation is performed before conversion.
     * <p>
     *     Note that the method might result in exceptions if the provided ePrescription content is not valid or cannot
     *     be converted to CH EMED EPR. However, the lack of exceptions does not mean the resulting PRE is outright
     *     valid. This converter might produce PRE documents that are still missing needed elements to pass CH EMED EPR
     *     validation. This allows client systems to complete PRE documents with their own business logic and/or
     *     specific needs.
     * </p>
     * @param ePrescription The ePrescription document to be converted.
     * @param language      The language to which to set the resulting FHIR document. Note that ePrescription does not
     *                      have such a field.
     * @param pdf           The original PDF in Base64. Note that the PDF should be PDF/A1 or PDF/A2 conformant, but
     *                      this method will not run any checks on this.
     * @return The resulting CH EMED EPR PRE document object.
     */
    @ExpectsValidResource
    public ChEmedEprDocumentPre toChEmedEprPrescription(final EPrescription ePrescription, final LanguageCode language, final byte[] pdf) {
        final var id = Uuids.match(ePrescription.getId())? Uuids.parseUrnEncoded(ePrescription.getId()) : UUID.randomUUID();
        final var pre = new ChEmedEprDocumentPre(id, ePrescription.getTimestamp());
        if (ePrescription.getPatient() != null) {
            if (ePrescription.getPatient().getIds() == null || ePrescription.getPatient().getIds().isEmpty())
                throw new InvalidEmedContentException("The patient does not have any ids in the ePrescription, but this is mandatory for CH EMED EPR.");
        } else throw new InvalidEmedContentException("The patient object is missing but it is mandatory.");
        final var patient = ePrescription.getPatient().toFhir();
        pre.addPatient(patient).setFullUrl(Uuids.URN_PREFIX + Uuids.generate());
        final var composition = new ChEmedEprCompositionPre(id, ePrescription.getTimestamp(), language);
        composition.setSubject(new Reference(patient));
        composition.setLanguage(language.getCodeValue());
        pre.setComposition(composition);

        if (ePrescription.getHealthcarePerson() == null) throw new InvalidEmedContentException("The hcPerson is mandatory but it is missing.");
        if (ePrescription.getHealthcareOrganization() == null) throw new InvalidEmedContentException("The organization is mandatory but it is missing.");
        final var pro = ePrescription.getHealthcarePerson().toFhir();
        final var org = ePrescription.getHealthcareOrganization().toFhir();
        pre.addEntry().setResource(pro).setFullUrl(Uuids.URN_PREFIX + Uuids.generate());
        pre.addEntry().setResource(org).setFullUrl(Uuids.URN_PREFIX + Uuids.generate());
        final var practitionerRole = new ChEmedEprPractitionerRole();
        practitionerRole.setPractitioner(new Reference(pro));
        practitionerRole.setOrganization(new Reference(org));
        pre.addEntry().setResource(practitionerRole).setFullUrl(Uuids.URN_PREFIX + Uuids.generate());
        composition.addAuthor(practitionerRole);

        if (ePrescription.getMedicaments() != null && !ePrescription.getMedicaments().isEmpty()) {
            for (final var medicament : ePrescription.getMedicaments()) {
                final var medReq = toMedicationRequest(
                        medicament,
                        patient,
                        practitionerRole,
                        ePrescription.getTimestamp(),
                        language);
                pre.addMedicationRequest(medReq);
                composition.addMedicationRequest(medReq);
            }
        } else throw new InvalidEmedContentException("There must be at least one medication in the prescription, but found none.");

        if (ePrescription.getRemark() != null && !ePrescription.getRemark().isEmpty()) {
            final var narrative = new Narrative().setStatus(Narrative.NarrativeStatus.ADDITIONAL);
            narrative.setDivAsString(ePrescription.getRemark());
            composition.getAnnotationSection().setText(narrative);
        }

        composition.setOriginalRepresentationPdf(pdf);
        final var binaryFullUrl = Uuids.URN_PREFIX + Uuids.generate();
        final var htmlId = Uuids.generate();
        pre.addEntry()
                .setResource((Resource) composition.getOriginalRepresentationSection().getEntryFirstRep().getResource())
                .setFullUrl(binaryFullUrl);
        composition.getOriginalRepresentationSection().addExtension(new TextLink(htmlId, new UriType(binaryFullUrl)));
        composition.getOriginalRepresentationSection().getText()
                .setDivAsString("<div><span id=%s>%s</span></div>".formatted(htmlId, composition.getOriginalRepresentationSection().getTitle()));

        return pre;
    }

    /**
     * Gets the CH EMED EPR MedicationRequest representation of a received medication from an eMediplan ePrescription.
     *
     * @param medicament The medicament entry from the eMediplan ePrescription to be converted.
     * @param patient    The prescription's patient.
     * @param requester  The prescriber.
     * @param timestamp  The timestamp of the prescription.
     * @param language   The prescription's language.
     * @return The resulting CH EMED EPR medication request if conversion is successful. Note that successful conversion
     *         does not mean that the medication request is complete and would pass validation. This depends on the
     *         completeness of the received eMediplan medicament object as well as this converter's configuration,
     *         notably regarding the treatment plan resolver and the medication resolver.
     */
    @ExpectsValidResource
    protected ChEmedEprMedicationRequestPre toMedicationRequest(final EPrescriptionMedicament medicament,
                                                                final ChEmedEprPatient patient,
                                                                final ChEmedEprPractitionerRole requester,
                                                                final Instant timestamp,
                                                                final LanguageCode language
                                                   ) {
        final var medRequest =  new ChEmedEprMedicationRequestPre(UUID.randomUUID());
        medRequest.setAuthoredOn(Date.from(timestamp));

        if (medicament.getIdType() == null || medicament.getId() == null)
            throw new InvalidEmedContentException("The eMediplan medicament id or id type is missing but it is mandatory.");
        final var medication = medicationResolver.getMedication(medicament.getIdType(), medicament.getId());
        medRequest.addContained(medication);
        medRequest.setMedicationReference(medication);

        medRequest.setSubject(new Reference(patient));
        medRequest.setRequester(new Reference(requester));

        medRequest.setDosageInstruction(getDosage(medicament));

        if (medicament.getRepetition() != null)
            log.warn("The eMediplan ePrescription specifies repetitions in months, but this is not supported by CH EMED EPR. This field will be ignored by the conversion.");

        final var dispenseRequest = medRequest.addDispenseRequest();
        final var dispenseQuantity =
                new Quantity(medicament.getNumberOfPackages() == null? 1 : medicament.getNumberOfPackages());
        dispenseQuantity.setCode(RegularUnitCodeAmbu.PACKAGE.getCodeValue());
        dispenseQuantity.setSystem(RegularUnitCodeAmbu.PACKAGE.getCodeSystemId());
        dispenseQuantity.setUnit(RegularUnitCodeAmbu.PACKAGE.getDisplayName(language));
        dispenseRequest.setQuantity(dispenseQuantity);
        if (medicament.getRepetition() != null) {
            if (medicament.getRepetition() == 0) dispenseRequest.setNumberOfRepeatsAllowed(0);
            else dispenseRequest
                    .setValidityPeriod(new Period()
                            .setStart(Date.from(timestamp))
                            .setEnd(Date.from(Instant.from(ZonedDateTime.ofInstant(timestamp, TimeZone.getDefault().toZoneId()).plusMonths(medicament.getRepetition()).toInstant()))));
        }

        if (medicament.isSubstitutionForbidden())
            medRequest.setSubstitution(new MedicationRequest.MedicationRequestSubstitutionComponent(
                    SubstanceAdministrationSubstitutionCode.NONE.getCodeableConcept(language)
            ));

        // TODO https://github.com/project-husky/husky/issues/352 (indicationCode)
        if (medicament.getIndicationCode() != null && !medicament.getIndicationCode().isBlank()) {
            log.warn("Clear support for the indication code has not yet been added to CH EMED and/or CH EMED EPR. It will be ignored by the conversion.");
        }

        // IMPORTANT: this step must always be the last step, so that the fully converted med request is sent to the resolver
        medRequest.setTreatmentPlanElement(treatmentPlanResolver.getTreatmentPlan(medRequest));

        return  medRequest;
    }

    /**
     * Gets the CH EMED EPR dosage instructions,  i.e. the list of {@link Dosage} objects, for a medication entry of an
     * eMediplan ePrescription.
     *
     * <p>
     *     Note that at present this method has several caveats:
     *     <ul>
     *         <li>It will not fill the {@code text} element of the base dosage. There is no eMediplan equivalent and
     *             although foreseen, a generator has yet to be implemented. See issue
     *             <a href="https://github.com/project-husky/husky/issues/348">#348</a> for more information.</li>
 *             <li>eMediplan ePrescription allow for a medication entry to be conveyed without either text patient
     *             instructions or a posology object. CH EMED EPR requires at least either of them. An eMediplan entry
     *             missing both will result in an {@link InvalidEmedContentException}.</li>
     *         <li>Other incompatibilities (like unmapped units like
     *             {@link org.projecthusky.fhir.emed.ch.epr.model.emediplan.CdTyp9#UNKNOWN}) may result in a
     *             runtime exception.</li>
     *     </ul>
     * </p>
     *
     * @param medicament The eMediplan ePrescription medication [request] entry.
     * @return The resulting list of FHIR dosage objects.
     */
    @ExpectsValidResource
    protected List<@NonNull Dosage> getDosage(final EPrescriptionMedicament medicament) {
        final var dosage = new ArrayList<@NonNull Dosage>();
        final var baseDosage = new ChEmedEprDosage();
        dosage.add(baseDosage);
        if (medicament.getPosology() != null && !medicament.getPosology().isEmpty()) {
            final var posology = medicament.getPosology().getFirst();
            if (posology.getEnd() != null) baseDosage.setBoundsPeriod(new Period().setEnd(Date.from(posology.getEnd())));
            if (posology.getDailyDoses() != null) {
                if  (medicament.getUnit() == null)
                    throw new InvalidEmedContentException("The units of the doses are missing for structured dosage intake.");
                final var fhirUnit = medicament.getUnit().toFhir();
                if (fhirUnit == null)
                    throw new UnsupportedOperationException("The CdTyp9 unit \"" + medicament.getUnit().getCode() + "\" is not supported.");
                addDose(TimingEventAmbu.MORNING, posology.getDailyDoses().getMorningDose(), fhirUnit, dosage);
                addDose(TimingEventAmbu.NOON, posology.getDailyDoses().getNoonDose(), fhirUnit, dosage);
                addDose(TimingEventAmbu.EVENING, posology.getDailyDoses().getEveningDose(), fhirUnit, dosage);
                addDose(TimingEventAmbu.NIGHT, posology.getDailyDoses().getNightDose(), fhirUnit, dosage);
            }
            baseDosage.setPatientInstruction(medicament.getApplicationInstructions());
            //TODO generate text representation of dosage https://github.com/project-husky/husky/issues/348
        } else {
            // eMediplan ePrescription allows for conveying neither a posology object nor patient instructions
            // in this case we CANNOT create the CH EMED EPR dosage object
            if (medicament.getApplicationInstructions() == null || medicament.getApplicationInstructions().isBlank())
                throw new InvalidEmedContentException("The eMediplan prescription does not have either a posology object or application instructions. Conversion to CH EMED EPR not possible.");
            baseDosage.setText(medicament.getApplicationInstructions());
        }
        return dosage;
    }

    /**
     * Adds a single dose information to the dosage instructions list.
     * <p>
     *     This method will add the dose to an existing {@link ChEmedEprDosage} object within the dosage instructions
     *     list, if appropriate, or add is a new one to the list otherwise. For instance: if there is already a base
     *     dosage with 1 tablet to be taken in the morning, a second dosage with 2 tablets to be taken at noon, and the
     *     method is called with a dose of 1 tablet to be taken in the evening, the method will simply add the new
     *     timing to the base dosage object. Should the method then be called with 3 tablets in the night, a new dosage
     *     object will be added to the dosage instructions list and the sequence element set accordingly.
     * </p>
     *
     * @param timing The dosage timing.
     * @param value  The dose quantity value.
     * @param unit   The dose quantity unit.
     * @param dosage The dosage instructions list. Note that the list might be mutated by the method.
     */
    @ExpectsValidResource
    protected void addDose(final TimingEventAmbu timing,
                           final double value,
                           final UnitCode unit,
                           final List<@NonNull Dosage> dosage) {
        if (value != 0f) {
            for (final var dose : dosage) {
                if (dose instanceof ChEmedEprDosage chEmedEprDosage) {
                    if (chEmedEprDosage.hasDoseAndRate()) {
                        if (chEmedEprDosage.getDoseAndRateFirstRep().getDoseQuantity().getValue().doubleValue() == value) {
                            chEmedEprDosage.addWhen(timing);
                            return;
                        }
                    } else {
                        chEmedEprDosage.addWhen(timing);
                        chEmedEprDosage.setDoseQuantity(new ChEmedQuantityWithEmedUnits(new BigDecimal(value), unit));
                        return;
                    }
                } else throw new InvalidEmedContentException("The medication request contains a non CH EMED EPR dosage.");
            }
            dosage.getFirst().setSequence(1);
            dosage.add(new ChEmedEprDosage().setDoseQuantity(new ChEmedQuantityWithEmedUnits(new BigDecimal(value), unit)).addWhen(timing));
            dosage.getLast().setSequence(dosage.size());
        }
    }
}
