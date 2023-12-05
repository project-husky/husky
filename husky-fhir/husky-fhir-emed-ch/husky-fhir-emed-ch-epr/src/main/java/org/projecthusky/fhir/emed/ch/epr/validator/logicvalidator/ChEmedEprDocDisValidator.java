package org.projecthusky.fhir.emed.ch.epr.validator.logicvalidator;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.projecthusky.fhir.emed.ch.epr.resource.dis.ChEmedEprDocumentDis;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationIssue;

import java.util.List;

public class ChEmedEprDocDisValidator extends ChEmedEprDocValidator<ChEmedEprDocumentDis>{
    public ChEmedEprDocDisValidator(final ChEmedEprDocumentDis document){
        super(document);
    }
    @Override
    public List<@NonNull ValidationIssue> validate() {
        final var disEntry = document.resolveComposition().resolveMedicationDispense();
        validateDosages(disEntry.resolveBaseDosage(), disEntry.resolveAdditionalDosage());
        return this.issues;
    }
}
