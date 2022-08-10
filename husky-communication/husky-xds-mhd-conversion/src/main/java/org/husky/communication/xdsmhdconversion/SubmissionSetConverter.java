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

import org.openehealth.ipf.commons.ihe.xds.core.metadata.SubmissionSet;

/**
 * A converter between IHE's SubmissionSet and the equivalent MHD resource.
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
     * Convert an MHD List to an IHE SubmissionSet.
     */
    public SubmissionSet convertList(final ListResource list) {

    }
}
