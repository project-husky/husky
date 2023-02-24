package org.projecthusky.fhir.emed.ch.epr.validator;

import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.datatypes.ChEmedEprDosage;
import org.projecthusky.fhir.emed.ch.epr.enums.TimingEventAmbu;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocument;
import org.projecthusky.fhir.emed.ch.epr.resource.dis.ChEmedEprDocumentDis;
import org.projecthusky.fhir.emed.ch.epr.resource.mtp.ChEmedEprDocumentMtp;
import org.projecthusky.fhir.emed.ch.epr.resource.padv.ChEmedEprDocumentPadv;
import org.projecthusky.fhir.emed.ch.epr.resource.pml.ChEmedEprDocumentPml;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprDocumentPre;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * A logic validator for CH-EMED-EPR documents. It contains checks that are too difficult to implement in the FHIR IG.
 * <p>
 * It is to be executed by the public class {@link ChEmedEprValidator}.
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
    public List<OperationOutcome.OperationOutcomeIssueComponent> validate(final ChEmedEprDocument document) {
        final var messages = new ArrayList<OperationOutcome.OperationOutcomeIssueComponent>(0);

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
                                final List<OperationOutcome.OperationOutcomeIssueComponent> messages) {


        if (additionalDosages.isEmpty()) {
            return;
        }
        // From here, there are additional dosages

        if (!baseDosage.hasDoseAndRate()) {
            messages.add(createError("Additional dosages shall not be present if the main dosage has no dose or rate"));
        }

        final var timingEventSeen = EnumSet.noneOf(TimingEventAmbu.class);
        for (final var timingEvent : baseDosage.resolveWhen()) {
            if (timingEventSeen.contains(timingEvent)) {
                messages.add(createError("The timing event '" + timingEvent.getCodeValue() + "' shall not appear multiple times"));
            }
            timingEventSeen.add(timingEvent);
        }
        for (final var additionDosage : additionalDosages) {
            for (final var timingEvent : additionDosage.resolveWhen()) {
                if (timingEventSeen.contains(timingEvent)) {
                    messages.add(createError("The timing event '" + timingEvent.getCodeValue() + "' shall not appear multiple times"));
                }
                timingEventSeen.add(timingEvent);
            }
        }
    }

    protected static OperationOutcome.OperationOutcomeIssueComponent createError(final String message) {
        final var error = new OperationOutcome.OperationOutcomeIssueComponent();
        error.setSeverity(OperationOutcome.IssueSeverity.ERROR);
        error.getDetails().setText(message);
        return error;
    }
}
