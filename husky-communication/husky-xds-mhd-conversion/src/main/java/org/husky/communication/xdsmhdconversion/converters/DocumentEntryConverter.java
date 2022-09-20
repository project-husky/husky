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
package org.husky.communication.xdsmhdconversion.converters;

import org.hl7.fhir.r4.model.DocumentReference;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntry;

/**
 * A converter between XDS' DocumentEntry and MHD's DocumentReference.
 *
 * @author Quentin Ligier
 * @see <a href="https://ihe.github.io/publications/ITI/TF/Volume3/ch-4.2.html#4.2.3.2">DocumentEntry Attributes</a>
 * @see <a
 * href="https://ihe.github.io/publications/ITI/MHD/StructureDefinition-IHE.MHD.Comprehensive.DocumentReference.html">Resource
 * Profile: MHD DocumentReference Comprehensive</a>
 * @see <a
 * href="http://build.fhir.org/ig/ehealthsuisse/ch-epr-mhealth/StructureDefinition-ch-mhd-documentreference-comprehensive.html">Resource
 * Profile: CH MHD DocumentReference Comprehensive</a>
 **/
public class DocumentEntryConverter {

    /**
     * Convert an XDS DocumentEntry to an MHD DocumentReference.
     *
     * @param documentEntry The XDS DocumentEntry to convert.
     * @return the equivalent MHD DocumentReference.
     */
    public DocumentReference convertDocumentEntry(final DocumentEntry documentEntry) {
        // TODO: est-ce qu'on passe un Bundle au lieu de retourner un DocumentReference ?
        return null;
    }

    /**
     * Convert an MHD DocumentReference to an XDS DocumentEntry.
     *
     * @param documentReference The MHD DocumentReference to convert.
     * @return the equivalent XDS DocumentEntry.
     */
    public DocumentEntry convertDocumentReference(final DocumentReference documentReference) {
        return null;
    }
}
