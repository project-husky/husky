package org.ehealth_connector.emed.cda.models.common;

import lombok.Data;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.ehealth_connector.emed.cda.generated.artdecor.enums.ParticipationFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the author of an eMed document, section or item entry.
 *
 * @author Quentin Ligier
 */
@Data
public class AuthorDigest {

    /**
     * This code is used to specify the exact function an actor has.
     */
    @Nullable private ParticipationFunction participationFunction;

    /**
     * The author GS1 GLN. For persons, their personal GLN must be declared. For devices or software modules, the
     * GLN of their organization must be declared. If it is not (yet) known, it can be {@code null}.
     */
    @Nullable private String authorGln;

    private final List<String> otherIds = new ArrayList<>();

    private final List<String> addresses = new ArrayList<>();

    private final List<String> telecoms = new ArrayList<>();
}
