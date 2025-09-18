package org.projecthusky.fhir.emed.ch.epr.service.converter.emediplan;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.epr.model.common.Author;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplan;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprDocumentPre;

public sealed interface EMediplanConverter permits ChMed16ABaseConverter, ChMed23AConverter {
    /**
     * Converts the received PMLC document to an eMediplan object.
     * @param pmlc The PMLC document to be converted.
     * @return A best-effort equivalent eMediplan object.
     */
    @ExpectsValidResource
    EMediplan<?,?> toEMediplan(final ChEmedEprDocumentPmlc pmlc);

    /**
     * Converts the received PRE document to an eMediplan object.
     * @param pre The PRE document to be converted.
     * @return A best-effort equivalent eMediplan object.
     */
    @ExpectsValidResource
    EMediplan<?,?> toEMediplan(final ChEmedEprDocumentPre pre);

    /**
     * Translates a {@link Author} to a prescriber string for eMediplan. The prescriber string, according to the
     * eMediplan specifications, consists of the prescriber's GLN number.
     *
     * @param author The CH EMED EPR Author from which to get a prescriber string.
     * @return The GLN of the practitioner author, if a professional author, {@code null} otherwise.
     */
    @ExpectsValidResource
    default @Nullable String medicalAuthorToPrescriber(final Author author) {
        if (author.getPractitionerRole() != null)
            return author.getPractitionerRole().resolvePractitioner().resolveGln();
        return null;
    }
}
