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
package org.husky.communication.xdsmhdconversion;

import org.hl7.fhir.r4.model.ListResource;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.SubmissionSet;

/**
 * A converter between XDS' SubmissionSet and the equivalent MHD resource.
 *
 * @author Quentin Ligier
 * @see <a href="https://ihe.github.io/publications/ITI/TF/Volume3/ch-4.2.html#4.2.3.3">SubmissionSet Attributes</a>
 * @see <a
 * href="https://ihe.github.io/publications/ITI/MHD/StructureDefinition-IHE.MHD.Comprehensive.SubmissionSet.html">Resource
 * Profile: MHD SubmissionSet Comprehensive</a>
 * @see <a
 * href="http://build.fhir.org/ig/ehealthsuisse/ch-epr-mhealth/StructureDefinition-ch-mhd-submissionset-comprehensive.html">Resource
 * Profile: CH MHD SubmissionSet Comprehensive</a>
 **/
public class SubmissionSetConverter {

    /**
     * Convert an MHD List to an XDS SubmissionSet.
     *
     * @param list The MHD list to convert.
     * @return the equivalent XDS SubmissionSet.
     */
    public SubmissionSet convertList(final ListResource list) {
        // TODO: list contient un submission set et peut contenir d'autres resources qui ne sont pas utiles
        return null;
    }

    /**
     * Convert an XDS SubmissionSet to an MHD list.
     *
     * @param submissionSet The XDS SubmissionSet to convert.
     * @param list          The MHD list in which to put the created resources.
     */
    public void convertSubmissionSet(final SubmissionSet submissionSet,
                                     final ListResource list) {

    }
}
