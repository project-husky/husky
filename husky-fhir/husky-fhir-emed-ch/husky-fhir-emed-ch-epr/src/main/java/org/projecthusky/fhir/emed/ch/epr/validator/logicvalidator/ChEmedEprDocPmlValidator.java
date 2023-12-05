package org.projecthusky.fhir.emed.ch.epr.validator.logicvalidator;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.projecthusky.fhir.emed.ch.epr.resource.pml.*;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationIssue;

import java.util.List;

public class ChEmedEprDocPmlValidator extends ChEmedEprDocValidator<ChEmedEprDocumentPml>{
    public ChEmedEprDocPmlValidator(final ChEmedEprDocumentPml document){
        super(document);
    }

    @Override
    public List<@NonNull ValidationIssue> validate() {
        for(final var entry : document.resolveComposition().resolveEntries()) {
            switch (entry.getEmedType()) {
                case MTP -> {
                    final var mtpEntry = (ChEmedEprMedicationStatementPml) entry;
                    validateDosages(mtpEntry.resolveBaseDosage(), mtpEntry.resolveAdditionalDosage());
                }
                case PRE -> {
                    final var preEntry = (ChEmedEprMedicationRequestPml) entry;
                    validateDosages(preEntry.resolveBaseDosage(), preEntry.resolveAdditionalDosage());
                }
                case DIS -> {
                    final var disEntry = (ChEmedEprMedicationDispensePml) entry;
                    validateDosages(disEntry.resolveBaseDosage(), disEntry.resolveAdditionalDosage());
                }
                case PADV -> {
                    final var padvEntry = (ChEmedEprObservationPml) entry;
                    final var medReqChangedEntry = padvEntry.resolveMedicationRequestChanged();
                    if (medReqChangedEntry != null) validateDosages(medReqChangedEntry.resolveBaseDosage(),
                                                                    medReqChangedEntry.resolveAdditionalDosage()
                    );
                    final var statementChangedEntry = padvEntry.resolveMedicationStatementChanged();
                    if (statementChangedEntry != null) validateDosages(statementChangedEntry.resolveBaseDosage(),
                                                                       statementChangedEntry.resolveAdditionalDosage()
                    );
                }
            }
        }
        return this.issues;
    }
}
