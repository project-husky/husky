package org.husky.emed.cda.services.readers;

import org.husky.emed.cda.errors.InvalidEmedContentException;
import org.husky.emed.cda.generated.artdecor.enums.ParticipationFunction;
import org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Author;
import org.husky.emed.cda.models.common.AuthorDigest;
import org.husky.emed.cda.utils.TemplateIds;

import java.time.Instant;
import java.util.Objects;

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
