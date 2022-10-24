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
package org.projecthusky.fhir.emed.ch.pmp.resource;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Medication;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.PharmaceuticalDoseFormEdqm;
import org.projecthusky.fhir.emed.ch.common.resource.ChCoreOrganizationEpr;

/**
 * The HAPI custom structure for CH-EMED-EPR Medication.
 *
 * @author Quentin Ligier
 **/
public class ChEmedEprMedication extends Medication {

    public ChEmedEprMedication() {
        // TODO
    }

    @ExpectsValidResource
    @Nullable
    public String resolveGtin() {
    } // TODO

    @ExpectsValidResource
    @Nullable
    public String resolveAtc() {
    } // TODO

    public void setGtin(final String gtin) {
    } // TODO

    public void setAtc(final String gtin) {
    } // TODO

    public boolean hasGtin() {
    } // TODO

    public boolean hasAtc() {
    } // TODO

    @ExpectsValidResource
    public ChCoreOrganizationEpr resolveManufacturer() {
    } // TODO

    @ExpectsValidResource
    public PharmaceuticalDoseFormEdqm resolveForm() {
    } // TODO

    public hasForm() {
    } // TODO

    public setForm(final PharmaceuticalDoseFormEdqm doseForm) {
    } // TODO
}
