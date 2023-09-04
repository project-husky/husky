package org.projecthusky.fhir.emed.ch.epr.validator.logicvalidator;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.projecthusky.fhir.emed.ch.epr.resource.padv.ChEmedEprDocumentPadv;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationIssue;

import java.util.List;

public class ChEmedEprDocPadvValidator extends ChEmedEprDocValidator<ChEmedEprDocumentPadv>{
    public ChEmedEprDocPadvValidator(final ChEmedEprDocumentPadv document){
        super(document);
    }

    @Override
    public List<@NonNull ValidationIssue> validate() {
        final var medReqChangedEntry =
                document.resolveComposition().resolveObservation().resolveMedicationRequestChanged();
        if (medReqChangedEntry != null) validateDosages(medReqChangedEntry.resolveBaseDosage(),
                medReqChangedEntry.resolveAdditionalDosage()
        );
        final var statementChangedEntry =
                document.resolveComposition().resolveObservation().resolveMedicationStatementChanged();
        if (statementChangedEntry != null) validateDosages(statementChangedEntry.resolveBaseDosage(),
                statementChangedEntry.resolveAdditionalDosage()
        );
        return this.issues;
    }
}
