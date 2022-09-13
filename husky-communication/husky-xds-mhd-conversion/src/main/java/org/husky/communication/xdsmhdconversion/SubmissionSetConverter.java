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

import org.hl7.fhir.r4.model.*;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.ListResource;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Identifier.IdentifierUse;
import org.hl7.fhir.r4.model.ListResource.ListMode;
import org.hl7.fhir.r4.model.ListResource.ListStatus;
import org.husky.common.utils.XdsMetadataUtil;
import org.husky.communication.xdsmhdconversion.utils.SubmissionSetConverterUtils;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
        SubmissionSet submissionSet = new SubmissionSet();

        // profile | SubmissionSet.limitedMetadata
        // ¯\_(ツ)_/¯
        submissionSet.setLimitedMetadata(getLimitedMetadata(list.getMeta().getProfile()));

        // extension (designationType) | SubmissionSet.contentTypeCode
        Extension designationType = list.getExtensionByUrl("https://profiles.ihe.net/ITI/MHD/StructureDefinition/ihe-designationType");
        if (designationType != null && designationType.getValue() instanceof CodeableConcept codeableConcept) {
            submissionSet.setContentTypeCode(SubmissionSetConverterUtils.transformToCode(codeableConcept));
        }

        // extension (sourceId) | SubmissionSet.sourceId
        Extension source = list.getExtensionByUrl("http://profiles.ihe.net/ITI/MHD/StructureDefinition/ihe-sourceId");
        if (source != null && source.getValue() instanceof Identifier identifier) {
            submissionSet.setSourceId(SubmissionSetConverterUtils.removePrefixOid(identifier.getValue()));
        }

        // extension (intendedRecipient) | SubmissionSet.intendedRecipient
        List<Extension> extIntentRecipients = list.getExtensionsByUrl("https://profiles.ihe.net/ITI/MHD/StructureDefinition/ihe-intendedRecipient");
        submissionSet.getIntendedRecipients().addAll(getIntendedRecipients(extIntentRecipients, list.getContained()));

        // identifier | SubmissionSet.uniqueId
        submissionSet.setUniqueId(this.getUniqueId(list.getIdentifier()));

        // identifier | SubmissionSet.entryUUID
        // ¯\_(ツ)_/¯
        submissionSet.assignEntryUuid();
        list.setId(submissionSet.getEntryUuid());

        // status | SubmissionSet.availabilityStatus
        submissionSet.setAvailabilityStatus(AvailabilityStatus.APPROVED);

        // mode | shall be 'working'
        // ---

        // title | SubmissionSet.title
        if (list.getTitle() != null) {
            submissionSet.setTitle(SubmissionSetConverterUtils.getLocalizedString(list.getTitle()));
        }

        // code | shall be 'submissionset'
        // ---

        // subject | SubmissionSet.patientId
        submissionSet.setPatientId(SubmissionSetConverterUtils.transformToIdentifiable(list.getSubject().getIdentifier()));

        // date | SubmissionSet.submissionTime
        submissionSet.setSubmissionTime(XdsMetadataUtil.convertDateToDtmString(list.getDate()));

        // source | SubmissionSet.author
        Extension extensionAuthorRole = list.getExtensionByUrl("http://fhir.ch/ig/ch-epr-mhealth/StructureDefinition/ch-ext-author-authorrole");
        if (list.hasSource() || extensionAuthorRole != null) {
            submissionSet.setAuthor(getAuthor(list.getSource(), extensionAuthorRole, list.getContained()));
        }

        // note | SubmissionSet.comments
        Annotation note = list.getNoteFirstRep();
        if (note != null && note.hasText()) {
            submissionSet.setComments(SubmissionSetConverterUtils.getLocalizedString(note.getText()));
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


        // code | shall be 'submissionset'
        list.setCode(new CodeableConcept(new Coding("https://profiles.ihe.net/ITI/MHD/CodeSystem/MHDlistTypes", "submissionset", "SubmissionSet as a FHIR List")));

        // mode | shall be 'working'
        list.setMode(ListMode.WORKING);

        // profile | SubmissionSet.limitedMetadata
        if (submissionSet.isLimitedMetadata()) {
            list.getMeta().addProfile("https://profiles.ihe.net/ITI/MHD/StructureDefinition/IHE.MHD.Minimal.SubmissionSet");
        } else {
            list.getMeta().addProfile("https://profiles.ihe.net/ITI/MHD/StructureDefinition/IHE.MHD.Comprehensive.SubmissionSet");
        }

        // note | SubmissionSet.comments
        if (submissionSet.getComments() != null) {
            list.addNote().setText(submissionSet.getComments().getValue());
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

        // extension (designationType) | SubmissionSet.contentTypeCode
        if (submissionSet.getContentTypeCode() != null) {
            list.addExtension()
                .setUrl("https://profiles.ihe.net/ITI/MHD/StructureDefinition/ihe-designationType")
                .setValue(SubmissionSetConverterUtils.transformToCodeableConcept(submissionSet.getContentTypeCode()));
        }

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
//            list.setSource()
        }

    }

    private String getUniqueId(List<Identifier> identifiers) {
        return identifiers.stream()
                .filter(id -> id.getUse() == IdentifierUse.USUAL)
                .map(id -> SubmissionSetConverterUtils.removePrefixOid(id.getValue()))
                .findAny()
                .orElse(null);
    }

    private Author getAuthor(Reference author, Extension extensionAuthorRole, List<Resource> contained) {
        Identifiable identifiable = null;
        if (extensionAuthorRole != null) {
            Coding coding = extensionAuthorRole.castToCoding(extensionAuthorRole.getValue());
            if (coding != null) {
                identifiable = new Identifiable(coding.getCode(), new AssigningAuthority(SubmissionSetConverterUtils.removePrefixOid(coding.getSystem())));
            }
        }
        return SubmissionSetConverterUtils.transformAuthor(author, contained, identifiable);
    }

    private List<Recipient> getIntendedRecipients(List<Extension> extensions, List<Resource> contained) {
        List<Recipient> recipients = new ArrayList<>();

        for (Extension extRecipient : extensions) {
            Reference refRecipient = (Reference) extRecipient.getValue();
            Resource res = SubmissionSetConverterUtils.findResource(refRecipient, contained);
            Recipient recipient = new Recipient();

            if (res instanceof Practitioner practitioner) {
                recipient.setPerson(SubmissionSetConverterUtils.transformToPerson(practitioner));
                recipient.setTelecom(SubmissionSetConverterUtils.transformToTelecom(practitioner.getTelecomFirstRep()));
            } else if (res instanceof Organization organization) {
                recipient.setOrganization(SubmissionSetConverterUtils.transformToOrganization(organization));
                recipient.setTelecom(SubmissionSetConverterUtils.transformToTelecom(organization.getTelecomFirstRep()));
            } else if (res instanceof PractitionerRole practitionerRole) {
                recipient.setPerson(SubmissionSetConverterUtils.transformToPerson((Practitioner) SubmissionSetConverterUtils.findResource(practitionerRole.getPractitioner(), contained)));
                recipient.setOrganization(SubmissionSetConverterUtils.transformToOrganization((Organization) SubmissionSetConverterUtils.findResource(practitionerRole.getOrganization(), contained)));
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

    private boolean getLimitedMetadata(List<CanonicalType> profiles) {
        final Set<String> limitedProfiles = Set.of("http://ihe.net/fhir/StructureDefinition/IHE_MHD_Provide_Minimal_DocumentBundle",
                "http://profiles.ihe.net/ITI/MHD/StructureDefinition/IHE.MHD.Minimal.ProvideBundle");

        return profiles.stream()
                .filter(p -> limitedProfiles.contains(p.getValue()))
                .toList().isEmpty();
    }
}
