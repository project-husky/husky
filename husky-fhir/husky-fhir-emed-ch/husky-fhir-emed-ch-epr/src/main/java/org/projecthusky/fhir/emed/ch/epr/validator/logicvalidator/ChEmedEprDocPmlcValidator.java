package org.projecthusky.fhir.emed.ch.epr.validator.logicvalidator;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationIssue;

import java.util.List;

public class ChEmedEprDocPmlcValidator extends ChEmedEprDocValidator<ChEmedEprDocumentPmlc>{
    public ChEmedEprDocPmlcValidator(final ChEmedEprDocumentPmlc document){
        super(document);
    }

    @Override
    public List<@NonNull ValidationIssue> validate() {
        for (final var statement : document.resolveComposition().resolveMedicationStatements())
            validateDosages(statement.resolveBaseDosage(), statement.resolveAdditionalDosage());
        return this.issues;
    }
}
