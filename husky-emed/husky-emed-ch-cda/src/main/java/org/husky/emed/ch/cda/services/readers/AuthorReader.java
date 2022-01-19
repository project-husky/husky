/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.services.readers;

import org.husky.common.hl7cdar2.*;
import org.husky.common.model.Identificator;
import org.husky.common.utils.OptionalUtils;
import org.husky.common.utils.datatypes.Gln;
import org.husky.common.utils.time.DateTimes;
import org.husky.common.utils.time.Hl7Dtm;
import org.husky.emed.ch.errors.InvalidEmedContentException;
import org.husky.emed.ch.enums.ParticipationFunction;
import org.husky.emed.ch.models.common.AuthorDigest;
import org.husky.emed.ch.cda.utils.TemplateIds;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.husky.common.enums.CodeSystems.GLN;

/**
 * A reader for CDA-CH-EMED POCDMT000040Author.
 *
 * @author Quentin Ligier
 */
public class AuthorReader {

    /**
     * The author.
     */
    protected final POCDMT000040Author author;

    /**
     * Constructor.
     *
     * @param author The author.
     * @throws InvalidEmedContentException if the author is invalid.
     */
    public AuthorReader(final POCDMT000040Author author) throws InvalidEmedContentException {
        if (!TemplateIds.isInList("2.16.756.5.30.1.1.10.9.23", author.getTemplateId())) {
            throw new InvalidEmedContentException("The given author is not a CDA-CH author");
        }
        this.author = Objects.requireNonNull(author);
    }

    /**
     * Gets the participation function, if specified.
     */
    public Optional<ParticipationFunction> getParticipationFunction() {
        return Optional.ofNullable(this.author.getFunctionCode())
                .map(CD::getCode)
                .map(ParticipationFunction::getEnum);
    }

    /**
     * Gets the authorship timestamp.
     */
    public Instant getAuthorshipTimestamp() {
        return Optional.ofNullable(this.author.getTime())
                .map(TS::getValue)
                .map(Hl7Dtm::fromHl7)
                .map(DateTimes::toInstant)
                .orElseThrow(() ->
                        new InvalidEmedContentException("The authorship timestamp is missing or invalid"));
    }

    /**
     * Gets the author GLN if known. For persons: their personal GLN is declared. For devices or software modules:
     * the GLN of their organization is declared.
     */
    public Optional<String> getGln() {
        final var identifier = Optional.ofNullable(this.author.getAssignedAuthor())
                .map(POCDMT000040AssignedAuthor::getId)
                .map(OptionalUtils::getListFirstElement)
                .filter(ii -> GLN.getCodeSystemId().equals(ii.getRoot()))
                .orElseThrow(() ->
                        new InvalidEmedContentException("The author GLN is missing"));
        return Optional.ofNullable(identifier.getExtension());
    }

    /**
     * Gets the author identifiers others than the GLN.
     */
    public List<II> getIds() {
        return Optional.ofNullable(this.author.getAssignedAuthor())
                .map(POCDMT000040AssignedAuthor::getId)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(ii -> !GLN.getCodeSystemId().equals(ii.getRoot()))
                .toList();
    }

    /**
     * Gets the author address wrapped in an {@link AddressReader}.
     */
    public AddressReader getAddresses() {
        return Optional.ofNullable(this.author.getAssignedAuthor())
                .map(POCDMT000040AssignedAuthor::getAddr)
                .map(AddressReader::new)
                .orElseGet(() -> new AddressReader(Collections.emptyList()));
    }

    /**
     * Gets the author telecom wrapped in a {@link TelecomReader}.
     */
    public TelecomReader getTelecoms() {
        return Optional.ofNullable(this.author.getAssignedAuthor())
                .map(POCDMT000040AssignedAuthor::getTelecom)
                .map(TelecomReader::new)
                .orElseGet(() -> new TelecomReader(Collections.emptyList()));
    }

    /**
     * Gets the author's name (for a person) wrapped in a {@link NameReader}, if any.
     */
    public Optional<NameReader> getPersonNames() {
        return Optional.ofNullable(this.author.getAssignedAuthor())
                .map(POCDMT000040AssignedAuthor::getAssignedPerson)
                .map(POCDMT000040Person::getName)
                .map(NameReader::new);
    }

    /**
     * Gets the authoring device wrapped in a {@link DeviceReader}, if any.
     */
    public Optional<DeviceReader> getDevice() {
        return Optional.ofNullable(this.author.getAssignedAuthor())
                .map(POCDMT000040AssignedAuthor::getAssignedAuthoringDevice)
                .map(DeviceReader::new);
    }

    /**
     * Gets the author's organization wrapped in an {@link OrganizationReader}, if any.
     */
    public Optional<OrganizationReader> getOrganization() {
        return Optional.ofNullable(this.author.getAssignedAuthor())
                .map(POCDMT000040AssignedAuthor::getRepresentedOrganization)
                .map(OrganizationReader::new);
    }
}
