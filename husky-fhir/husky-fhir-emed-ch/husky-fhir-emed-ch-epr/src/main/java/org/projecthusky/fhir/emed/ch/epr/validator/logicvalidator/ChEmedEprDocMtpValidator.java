package org.projecthusky.fhir.emed.ch.epr.validator.logicvalidator;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.projecthusky.fhir.emed.ch.epr.resource.mtp.ChEmedEprDocumentMtp;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationIssue;

import java.util.List;

public class ChEmedEprDocMtpValidator extends ChEmedEprDocValidator<ChEmedEprDocumentMtp>{
    public ChEmedEprDocMtpValidator(final ChEmedEprDocumentMtp document) {
        super(document);
    }
    @Override
    public List<@NonNull ValidationIssue> validate() {
        final var mtpEntry = document.resolveComposition().resolveMedicationStatement();
        validateDosages(mtpEntry.resolveBaseDosage(), mtpEntry.resolveAdditionalDosage());
        return this.issues;
    }
}
