package org.projecthusky.fhir.emed.ch.epr.validator;

import ca.uhn.fhir.validation.ResultSeverityEnum;
import ca.uhn.fhir.validation.SingleValidationMessage;
import org.projecthusky.fhir.emed.ch.epr.datatypes.ChEmedEprDosage;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocument;
import org.projecthusky.fhir.emed.ch.epr.resource.dis.ChEmedEprDocumentDis;
import org.projecthusky.fhir.emed.ch.epr.resource.mtp.ChEmedEprDocumentMtp;
import org.projecthusky.fhir.emed.ch.epr.resource.padv.ChEmedEprDocumentPadv;
import org.projecthusky.fhir.emed.ch.epr.resource.pml.ChEmedEprDocumentPml;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprDocumentPre;

import java.util.ArrayList;
import java.util.List;

/**
 * A logic validator for CH-EMED-EPR documents. It contains checks that are too difficult to implement in the FHIR IG.
 * <p>
 * It's to be executed by the public class {@link ChEmedEprValidator}.
 *
 * @author Quentin Ligier
 */
class LogicValidator {

    /**
     * Validates a CH-EMED-EPR document.
     *
     * @param document The document to validate.
     * @return a list of validation messages.
     */
    public List<SingleValidationMessage> validate(final ChEmedEprDocument document) {
        final var messages = new ArrayList<SingleValidationMessage>(0);

        if (document instanceof final ChEmedEprDocumentMtp mtpDocument) {

        } else if (document instanceof final ChEmedEprDocumentPre preDocument) {

        } else if (document instanceof final ChEmedEprDocumentDis disDocument) {

        } else if (document instanceof final ChEmedEprDocumentPadv padvDocument) {

        } else if (document instanceof final ChEmedEprDocumentPml pmlDocument) {

        } else if (document instanceof final ChEmedEprDocumentPmlc pmlcDocument) {

        }

        return messages;
    }


    public void validateDosages(final ChEmedEprDosage baseDosage,
                                final List<ChEmedEprDosage> additionalDosages,
                                final List<SingleValidationMessage> messages) {
        if (!baseDosage.hasDoseAndRate() && !additionalDosages.isEmpty()) {
            messages.add(new SingleValidationMessage());
        }
    }

    protected static SingleValidationMessage createError(final String message) {
        final var error = new SingleValidationMessage();
        error.setSeverity(ResultSeverityEnum.ERROR);
        error.setMessage(message);
        return error;
    }
}
