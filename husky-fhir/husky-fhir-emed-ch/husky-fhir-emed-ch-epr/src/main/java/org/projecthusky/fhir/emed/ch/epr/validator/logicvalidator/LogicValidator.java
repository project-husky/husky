package org.projecthusky.fhir.emed.ch.epr.validator.logicvalidator;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocument;
import org.projecthusky.fhir.emed.ch.epr.resource.dis.ChEmedEprDocumentDis;
import org.projecthusky.fhir.emed.ch.epr.resource.mtp.ChEmedEprDocumentMtp;
import org.projecthusky.fhir.emed.ch.epr.resource.padv.ChEmedEprDocumentPadv;
import org.projecthusky.fhir.emed.ch.epr.resource.pml.*;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprDocumentPre;
import org.projecthusky.fhir.emed.ch.epr.validator.ChEmedEprValidator;
import org.projecthusky.fhir.emed.ch.epr.validator.ChEmedEprValidatorInternalException;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationIssue;

import java.util.List;

/**
 * A logic validator for CH-EMED-EPR documents. It contains checks that are too difficult to implement in the FHIR IG.
 * <p>
 * It is to be executed by the public class {@link ChEmedEprValidator}.
 *
 * @author Quentin Ligier
 */
public class LogicValidator {
    /**
     * Validates a CH-EMED-EPR document.
     *
     * @param document The document to validate.
     * @return a list of validation messages.
     */
    public List<@NonNull ValidationIssue> validate(final ChEmedEprDocument document) {
        ChEmedEprDocValidator validator = null;
        if (document instanceof final ChEmedEprDocumentMtp mtpDoc) validator = new ChEmedEprDocMtpValidator(mtpDoc);
        else if (document instanceof final ChEmedEprDocumentPre preDoc) validator = new ChEmedEprDocPreValidator(preDoc);
        else if (document instanceof final ChEmedEprDocumentDis disDoc) validator = new ChEmedEprDocDisValidator(disDoc);
        else if (document instanceof final ChEmedEprDocumentPadv padvDoc) validator = new ChEmedEprDocPadvValidator(padvDoc);
        else if (document instanceof final ChEmedEprDocumentPml pmlDoc) validator = new ChEmedEprDocPmlValidator(pmlDoc);
        else if (document instanceof final ChEmedEprDocumentPmlc pmlcDoc) validator = new ChEmedEprDocPmlcValidator(pmlcDoc);
        if (validator == null)
            throw new ChEmedEprValidatorInternalException("Could not validate doc logic: doc type not supported by LogicValidator.");
        else return validator.validate();
    }
}
