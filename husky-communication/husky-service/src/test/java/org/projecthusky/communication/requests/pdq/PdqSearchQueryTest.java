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
package org.projecthusky.communication.requests.pdq;

import org.junit.jupiter.api.Test;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.common.model.Identificator;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for {@link PdqSearchQuery}.
 *
 * @author Quentin Ligier
 **/
class PdqSearchQueryTest {

    @Test
    void testBuild() throws URISyntaxException {
        final var destination = new Destination("4.5.6", new URI("http://www.example.org"));
        destination.setReceiverFacilityOid("7.8.9");
        final var query = PdqSearchQuery.builder()
                .destination(destination)
                .identificator(new Identificator("1.2.3", "ABC"))
                .build();
        final var prpa = query.build().getRootElement();
        System.out.println(prpa);
    }
}