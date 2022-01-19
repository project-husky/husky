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

import org.husky.common.hl7cdar2.TEL;

import java.util.List;
import java.util.Objects;

/**
 * A reader for CDA-CH-EMED telecoms.
 *
 * @author Quentin Ligier
 */
public class TelecomReader {

    private final List<TEL> telecoms;

    public TelecomReader(final List<TEL> telecoms) {
        this.telecoms = Objects.requireNonNull(telecoms);
    }
}
