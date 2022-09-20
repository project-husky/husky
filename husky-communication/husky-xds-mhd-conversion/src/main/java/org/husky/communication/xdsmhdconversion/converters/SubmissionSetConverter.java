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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.instance.model.api.IBaseReference;
import org.hl7.fhir.r4.model.*;
import org.hl7.fhir.r4.model.Identifier.IdentifierUse;
import org.hl7.fhir.r4.model.ListResource.ListMode;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.ListResource.ListStatus;
import org.husky.common.utils.XdsMetadataUtil;
import org.husky.communication.xdsmhdconversion.utils.SubmissionSetConverterUtils;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.*;

import java.util.*;

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
        final SubmissionSet submissionSet = new SubmissionSet();

        // profile | SubmissionSet.limitedMetadata
        submissionSet.setLimitedMetadata(isLimitedMetadata(list.getMeta().getProfile()));

        // extension (designationType) | SubmissionSet.contentTypeCode
        final Extension designationType = list.getExtensionByUrl("https://profiles.ihe.net/ITI/MHD/StructureDefinition/ihe-designationType");
        if (designationType != null && designationType.getValue() instanceof CodeableConcept codeableConcept) {
            submissionSet.setContentTypeCode(SubmissionSetConverterUtils.transformToCode(codeableConcept, list.getLanguage()));
        }

        // extension (sourceId) | SubmissionSet.sourceId (required)
        final Extension source = list.getExtensionByUrl("https://profiles.ihe.net/ITI/MHD/StructureDefinition/ihe-sourceId");
        if (source != null && source.getValue() instanceof Identifier identifier) {
            submissionSet.setSourceId(SubmissionSetConverterUtils.removePrefixOid(identifier.getValue()));
        }

        // extension (intendedRecipient) | SubmissionSet.intendedRecipient
        final List<Extension> extIntentRecipients = list.getExtensionsByUrl("https://profiles.ihe.net/ITI/MHD/StructureDefinition/ihe-intendedRecipient");
        submissionSet.getIntendedRecipients().addAll(getIntendedRecipients(extIntentRecipients, list.getContained()));

        // identifier | SubmissionSet.uniqueId
        submissionSet.setUniqueId(this.getUniqueId(list.getIdentifier()));

        // identifier | SubmissionSet.entryUUID
        submissionSet.assignEntryUuid();
        list.setId(submissionSet.getEntryUuid());

        // status | SubmissionSet.availabilityStatus
        submissionSet.setAvailabilityStatus(AvailabilityStatus.APPROVED);

        // mode | shall be 'working'
        // ---

        // title | SubmissionSet.title
        if (list.getTitle() != null) {
            submissionSet.setTitle(SubmissionSetConverterUtils.getLocalizedString(list.getTitle(), list.getLanguage()));
        }

        // code | shall be 'submissionset'
        // ---

        // subject | SubmissionSet.patientId (required)
        submissionSet.setPatientId(SubmissionSetConverterUtils.transformToIdentifiable(list.getSubject().getIdentifier()));

        // date | SubmissionSet.submissionTime
        submissionSet.setSubmissionTime(XdsMetadataUtil.convertDateToDtmString(list.getDate()));

        // source | SubmissionSet.author
        final Extension extensionAuthorRole = list.getExtensionByUrl("http://fhir.ch/ig/ch-epr-mhealth/StructureDefinition/ch-ext-author-authorrole");
        if (list.hasSource() || extensionAuthorRole != null) {
            submissionSet.setAuthor(getAuthor(list.getSource(), extensionAuthorRole, list.getContained(), list.getLanguage()));
        }

        // note | SubmissionSet.comments
        final Annotation note = list.getNoteFirstRep();
        if (note != null && note.hasText()) {
            submissionSet.setComments(SubmissionSetConverterUtils.getLocalizedString(note.getText(), list.getLanguage()));
        }

        // item | references to DocumentReference and Folder List
        // ---

        return submissionSet;
    }

    /**
     * Convert an XDS SubmissionSet to an MHD list.
     *
     * @param submissionSet The XDS SubmissionSet to convert.
     * @param list          The MHD list in which to put the created resources.
     */
    public void convertSubmissionSet(final SubmissionSet submissionSet,
                                     final ListResource list) {

        // profile | SubmissionSet.limitedMetadata
        if (submissionSet.isLimitedMetadata()) {
            list.getMeta().addProfile("https://profiles.ihe.net/ITI/MHD/StructureDefinition/IHE.MHD.Minimal.SubmissionSet");
        } else {
            list.getMeta().addProfile("https://profiles.ihe.net/ITI/MHD/StructureDefinition/IHE.MHD.Comprehensive.SubmissionSet");
        }

        // extension (sourceId) | SubmissionSet.sourceId
        if (submissionSet.getSourceId() != null) {
            list.addExtension()
                    .setUrl("https://profiles.ihe.net/ITI/MHD/StructureDefinition/ihe-sourceId")
                    .setValue(new Identifier().setValue(SubmissionSetConverterUtils.addPrefixOid(submissionSet.getSourceId())));
        }

        // extension (intendedRecipient) | SubmissionSet.intendedRecipient
        final List<Recipient> recipients = submissionSet.getIntendedRecipients();
        for (Recipient recipient : recipients) {
            list.addExtension()
                    .setUrl("https://profiles.ihe.net/ITI/MHD/StructureDefinition/ihe-intendedRecipient")
                    .setValue(getRecipientReference(recipient));
        }

        // extension (designationType) | SubmissionSet.contentTypeCode
        if (submissionSet.getContentTypeCode() != null) {
            list.addExtension()
                    .setUrl("https://profiles.ihe.net/ITI/MHD/StructureDefinition/ihe-designationType")
                    .setValue(SubmissionSetConverterUtils.transformToCodeableConcept(submissionSet.getContentTypeCode()));
        }

        // identifier | SubmissionSet.uniqueId
        list.addIdentifier(new Identifier().setUse(IdentifierUse.USUAL)
                .setSystem("urn:ietf:rfc:3986")
                .setValue(SubmissionSetConverterUtils.addPrefixOid(submissionSet.getUniqueId())));

        // identifier | SubmissionSet.entryUuid
        if (submissionSet.getEntryUuid() != null) {
            list.addIdentifier(new Identifier().setUse(IdentifierUse.OFFICIAL)
                    .setSystem("urn:ietf:rfc:3986")
                    .setValue(SubmissionSetConverterUtils.addPrefixUuid(submissionSet.getEntryUuid())));

            list.setId(SubmissionSetConverterUtils.removePrefixUuid(submissionSet.getEntryUuid()));
        }

        // status | SubmissionSet.availabilityStatus
        if (submissionSet.getAvailabilityStatus() == AvailabilityStatus.APPROVED) {
            list.setStatus(ListStatus.CURRENT);
        }

        // mode | shall be 'working'
        list.setMode(ListMode.WORKING);

        // title | SubmissionSet.title
        if (submissionSet.getTitle() != null) {
            list.setTitle(submissionSet.getTitle().getValue());
        }

        // code | shall be 'submissionset'
        list.setCode(new CodeableConcept(new Coding("https://profiles.ihe.net/ITI/MHD/CodeSystem/MHDlistTypes", "submissionset", "SubmissionSet as a FHIR List")));

        // subject | SubmissionSet.patientId
        if (submissionSet.getPatientId() != null) {
            list.setSubject(SubmissionSetConverterUtils.transformToPatientReference(submissionSet.getPatientId()));
        }

        // date | SubmissionSet.submissionTime
        if (submissionSet.getSubmissionTime() != null) {
            list.setDate(Date.from(submissionSet.getSubmissionTime().getDateTime().toInstant()));
        }

        // source | SubmissionSet.author
        if (submissionSet.getAuthors().size() == 1) {
            list.setSource(SubmissionSetConverterUtils.transformToReference(submissionSet.getAuthors().get(0)));
        }

        // note | SubmissionSet.comments
        if (submissionSet.getComments() != null) {
            list.addNote().setText(submissionSet.getComments().getValue());
        }
    }

    /**
     * Gets submissionSet uniqueId
     *
     * @param identifiers list of identifiers
     * @return submissionSet uniqueId
     */
    @Nullable
    private String getUniqueId(final List<Identifier> identifiers) {
        return identifiers.stream()
                .filter(id -> id.getUse() == IdentifierUse.USUAL)
                .map(id -> SubmissionSetConverterUtils.removePrefixOid(id.getValue()))
                .filter(Objects::nonNull)
                .findAny()
                .orElse(null);
    }

    /**
     * Gets submissionSet.author
     *
     * @param author the author's reference
     * @param extensionAuthorRole
     * @param contained the list of resources
     * @param languageCode language of resource content
     * @return submissionSet.author
     */
    @Nullable
    private Author getAuthor(@Nullable final Reference author,
                             @Nullable final Extension extensionAuthorRole,
                             final List<Resource> contained,
                             @Nullable final String languageCode) {
        Identifiable identifiable = null;
        if (extensionAuthorRole != null) {
            final Coding coding = extensionAuthorRole.castToCoding(extensionAuthorRole.getValue());
            if (coding != null) {
                identifiable = new Identifiable(coding.getCode(), new AssigningAuthority(SubmissionSetConverterUtils.removePrefixOid(coding.getSystem())));
            }
        }
        return SubmissionSetConverterUtils.transformAuthor(author, contained, identifiable, languageCode);
    }

    /**
     * Get submissionSet.intendedRecipient
     *
     * @param extensions list of extensions
     * @param contained list of resources
     * @return submissionSet.intendedRecipient
     */
    private List<Recipient> getIntendedRecipients(final List<Extension> extensions,
                                                  final List<Resource> contained) {
        final List<Recipient> recipients = new ArrayList<>();

        for (Extension extRecipient : extensions) {
            final var recipient = new Recipient();
            final var refRecipient = (Reference) extRecipient.getValue();
            final Resource res = SubmissionSetConverterUtils.findResource(refRecipient, contained);

            if (res instanceof Practitioner practitioner) {
                recipient.setPerson(SubmissionSetConverterUtils.transformToPerson(practitioner));
                recipient.setTelecom(SubmissionSetConverterUtils.transformToTelecom(practitioner.getTelecomFirstRep()));
            } else if (res instanceof Organization organization) {
                recipient.setOrganization(SubmissionSetConverterUtils.transformToXDSOrganization(organization));
                recipient.setTelecom(SubmissionSetConverterUtils.transformToTelecom(organization.getTelecomFirstRep()));
            } else if (res instanceof PractitionerRole practitionerRole) {
                recipient.setPerson(SubmissionSetConverterUtils.transformToPerson((Practitioner) SubmissionSetConverterUtils.findResource(practitionerRole.getPractitioner(), contained)));
                recipient.setOrganization(SubmissionSetConverterUtils.transformToXDSOrganization((Organization) SubmissionSetConverterUtils.findResource(practitionerRole.getOrganization(), contained)));
                recipient.setTelecom(SubmissionSetConverterUtils.transformToTelecom(practitionerRole.getTelecomFirstRep()));
            } else if (res instanceof Patient person) {
                recipient.setPerson(SubmissionSetConverterUtils.transformToPerson(person));
                recipient.setTelecom(SubmissionSetConverterUtils.transformToTelecom(person.getTelecomFirstRep()));
            } else if (res instanceof RelatedPerson relatedPerson) {
                recipient.setPerson(SubmissionSetConverterUtils.transformToPerson(relatedPerson));
                recipient.setTelecom(SubmissionSetConverterUtils.transformToTelecom(relatedPerson.getTelecomFirstRep()));
            }

            recipients.add(recipient);
        }

        return recipients;
    }

    /**
     * Gets submissionSet.limitedMetadata
     *
     * @param profiles list of profiles
     * @return submissionSet.limitedMetadata
     */
    private boolean isLimitedMetadata(final List<CanonicalType> profiles) {
        final Set<String> limitedProfiles = Set.of("http://ihe.net/fhir/StructureDefinition/IHE_MHD_Provide_Minimal_DocumentBundle",
                "https://profiles.ihe.net/ITI/MHD/StructureDefinition/IHE.MHD.Minimal.ProvideBundle");

        return profiles.stream().anyMatch(p -> limitedProfiles.contains(p.getValue()));
    }

    /**
     * Get a recipient reference from a submissionSet.intendedRecipient
     *
     * @param recipient submissionSet.intendedRecipient
     * @return a recipient reference
     */
    @Nullable
    private IBaseReference getRecipientReference(final Recipient recipient) {
        final Practitioner practitioner = SubmissionSetConverterUtils.transformToPractitioner(recipient.getPerson());
        final ContactPoint contact = SubmissionSetConverterUtils.transformToContactPoint(recipient.getTelecom());
        final var organization = SubmissionSetConverterUtils.transformToFHIROrganization(recipient.getOrganization());

        if (organization != null && practitioner == null) {
            organization.addTelecom(contact);
            return new Reference().setResource(organization);
        } else if (organization != null) {
            final PractitionerRole role = new PractitionerRole();

            role.setPractitioner((Reference) new Reference().setResource(practitioner));
            role.setOrganization((Reference) new Reference().setResource(organization));
            role.addTelecom(contact);

            return new Reference().setResource(role);
        } else if (practitioner != null) {
            // Maybe a patient, related person or practitioner
        }
        return null;
    }
}
