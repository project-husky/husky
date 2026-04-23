package org.projecthusky.fhir.emed.ch.epr.service.converter.emediplan;

import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtTreatmentPlan;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprMedicationRequestPre;

/**
 * This is an interface for a service that can return a FHIR {@link ChEmedExtTreatmentPlan} resource from a provided
 * CH EMED EPR Medication Request. The medication request is assumed to be as complete as possible. Nothing is specified
 * at this level as how complete it should be when received by the treatment plan resolver, but the resolver should do
 * its best to resolve to which treatment plan this new medication request would be attached to. This treatment plan
 * could be a previously existing one or a new one, this is to be determined by the resolver.
 */
@FunctionalInterface
public interface TreatmentPlanResolver {
    /**
     * Gets the treatment plan to which to attach the received newly created CH EMED EPR medication request.
     * <p>
     *     This method expects a valid medication request, except for the treatment plan extension that should be empty.
     *     This method is supposed to resolve to which treatment plan this new medication request should be attached to.
     * </p>
     * <p>
     *     Note that this method does not automatically attach the treatment plan extension to the received medication
     *     request, which it does not modify.
     * </p>
     *
     * @param medRequest The new medication request for which to resolve a treatment plan to which to attach it.
     * @return           The extension containing the treatment plan to which to attach the received medication request.
     * @throws InvalidEmedContentException may be thrown if the content of the received medication request is not valid.
     */
    ChEmedExtTreatmentPlan getTreatmentPlan(final ChEmedEprMedicationRequestPre medRequest)
            throws InvalidEmedContentException;
}
