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

import org.husky.emed.errors.InvalidEmedContentException;
import org.husky.emed.enums.ParticipationFunction;
import org.husky.common.hl7cdar2.POCDMT000040Author;
import org.husky.emed.models.common.AuthorDigest;
import org.husky.emed.ch.cda.utils.TemplateIds;

import java.time.Instant;
import java.util.Objects;

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

    public ParticipationFunction getParticipationFunction() {
        return null;
    }

    public Instant getAuthorshipInstant() {
        return null;
    }

    public AuthorDigest toAuthorDigest() {
        return new AuthorDigest();
    }
}
