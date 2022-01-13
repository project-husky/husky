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
package org.husky.emed.ch.models.common;

import lombok.Data;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.emed.ch.enums.ParticipationFunction;

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
    @Nullable
    private ParticipationFunction participationFunction;

    /**
     * The author GS1 GLN. For persons, their personal GLN must be declared. For devices or software modules, the
     * GLN of their organization must be declared. If it is not (yet) known, it can be {@code null}.
     */
    @Nullable
    private String authorGln;

    private final List<String> otherIds = new ArrayList<>();

    private final List<String> addresses = new ArrayList<>();

    private final List<String> telecoms = new ArrayList<>();
}
