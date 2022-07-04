/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.enums;

/**
 * The enumeration of all possible prescription statuses.
 * <p>
 * The {@code SUBMITTED} status is removed because prescriptions are either {@link #ACTIVE} or {@link #PROVISIONAL} when
 * created in Switzerland.
 *
 * @author Quentin Ligier
 */
public enum PrescriptionStatus {

    PROVISIONAL, ACTIVE, SUSPENDED, CANCELED, REFUSED
}
