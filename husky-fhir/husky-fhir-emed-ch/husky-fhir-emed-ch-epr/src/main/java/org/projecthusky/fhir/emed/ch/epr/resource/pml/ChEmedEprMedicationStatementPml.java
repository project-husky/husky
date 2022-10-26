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
package org.projecthusky.fhir.emed.ch.epr.resource.pml;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.epr.enums.SubstanceAdministrationSubstitutionCode;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedicationStatement;

import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR MedicationStatement (PML).
 * <p>
 * TODO javadoc
 *
 * @author Quentin Ligier
 **/
public class ChEmedEprMedicationStatementPml extends ChEmedEprMedicationStatement {

    @Child(name = "substitution")
    @Extension(url = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-substitution", definedLocally = false)
    protected CodeableConcept substitution;

    // TODO: add support for extension authorDocument

    public ChEmedEprMedicationStatementPml(final UUID entryUuid) {
        super(entryUuid);
    }

    public CodeableConcept getSubstitutionElement() {
        if (this.substitution == null) {
            this.substitution = new CodeableConcept();
        }
        return this.substitution;
    }

    @ExpectsValidResource
    public SubstanceAdministrationSubstitutionCode getSubstitution() {
        if (!this.hasSubstitution()) {
            return SubstanceAdministrationSubstitutionCode.EQUIVALENT;
        }
        final var substitutionCode =
                SubstanceAdministrationSubstitutionCode.fromCoding(this.getSubstitution().getCoding());
        if (substitutionCode == null) {
            throw new InvalidEmedContentException("The substitution code is invalid");
        }
        return substitutionCode;
    }

    public boolean hasSubstitution() {
        return this.substitution != null && !this.substitution.isEmpty();
    }

    public ChEmedEprMedicationStatementPml setSubstitutionElement(final CodeableConcept value) {
        this.substitution = value;
        return this;
    }

    public ChEmedEprMedicationStatementPml setSubstitution(final SubstanceAdministrationSubstitutionCode value) {
        this.setSubstitutionElement(value.getCodeableConcept());
        return this;
    }
}
