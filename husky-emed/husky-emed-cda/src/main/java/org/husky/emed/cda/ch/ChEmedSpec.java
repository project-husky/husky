/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.cda.ch;

/**
 * Swiss specifications for pharmacy documents and eMedication.
 *
 * @author Quentin Ligier
 */
public class ChEmedSpec {

    /**
     * Default duration of a PRE document in months, if not specified.
     */
    public static final int PRE_DEFAULT_DURATION_MONTHS = 3;

    /**
     * Maximum duration of a PRE document, in months.
     */
    public static final int PRE_MAX_DURATION_MONTHS = 12;
}
