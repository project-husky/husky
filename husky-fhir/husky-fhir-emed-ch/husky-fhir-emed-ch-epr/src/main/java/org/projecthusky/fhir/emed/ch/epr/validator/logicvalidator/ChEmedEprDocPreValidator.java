package org.projecthusky.fhir.emed.ch.epr.validator.logicvalidator;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprDocumentPre;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationIssue;

import java.util.List;

public class ChEmedEprDocPreValidator extends ChEmedEprDocValidator<ChEmedEprDocumentPre>{
    public ChEmedEprDocPreValidator(final ChEmedEprDocumentPre document){
        super(document);
    }

    @Override
    public List<@NonNull ValidationIssue> validate() {
        final var preEntries = document.resolveComposition().resolveMedicationRequests();
        for (final var preEntry : preEntries)
            validateDosages(preEntry.resolveBaseDosage(), preEntry.resolveAdditionalDosage());
        return this.issues;
    }
}
