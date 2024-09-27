/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.fhir.emed.ch.epr.resource;

import org.hl7.fhir.r4.model.Observation;
import org.projecthusky.fhir.core.ch.resource.r4.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;

import java.sql.Date;
import java.time.LocalDate;

/**
 * The HAPI custom structure for CH-EMED-EPR Body Weight Observation.
 *
 * @author Quentin Ligier
 **/
public class ChEmedEprObservationBodyWeight extends Observation {

    /**
     * Initializes the Observation.
     */
    public ChEmedEprObservationBodyWeight() {
        this.getValueQuantity()
                .setUnit("kg")
                .setCode("kg")
                .setSystem(FhirSystem.UCUM);
        this.getCode().getCodingFirstRep()
                .setCode("29463-7")
                .setSystem(FhirSystem.LOINC);
    }

    /**
     * Initializes the Observation with the given weight value and date.
     *
     * @param weightValue The value of the body weight. It is a FHIR
     *                    <a href="http://hl7.org/fhir/R4/datatypes.html#decimal">decimal</a>.
     * @param weightDate  The date.
     */
    public ChEmedEprObservationBodyWeight(final String weightValue,
                                          final LocalDate weightDate) {
        this();
        this.getValueQuantity()
                .getValueElement().setValueAsString(weightValue);
        this.getEffectiveDateTimeType().setValue(Date.valueOf(weightDate));
    }

    /**
     * Resolves the subject as a {@link ChCorePatientEpr}.
     *
     * @return the subject.
     */
    @ExpectsValidResource
    public ChCorePatientEpr resolveSubject() {
        if (this.hasSubject() && this.getSubject().getResource() instanceof final ChCorePatientEpr patient) {
            return patient;
        }
        throw new InvalidEmedContentException("The subject (Patient) is missing");
    }
}
