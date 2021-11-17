/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.husky.communication.xd.storedquery;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.husky.communication.testhelper.XdsTestUtils;
import org.husky.communication.xd.storedquery.GetRelatedDocumentsQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntryType;

/**
 * Test of class GetRelatedDocumentsQuery
 */
class GetRelatedDocumentsQueryTest extends XdsTestUtils {

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
	}

	/**
	 * Test method for
	 * {@link org.husky.communication.xd.storedquery.GetRelatedDocumentsQuery#GetRelatedDocumentsQuery(java.lang.String, boolean, org.openhealthtools.ihe.xds.metadata.ParentDocumentRelationshipType[])}
	 * .
	 */
	@Test
	void testGetRelatedDocumentsQueryStringBooleanParentDocumentRelationshipTypeArray() {
		final GetRelatedDocumentsQuery q1 = new GetRelatedDocumentsQuery("1234", true,
				parentRelation);

		assertTrue(q1
				.getIpfQuery() instanceof org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetRelatedDocumentsQuery);

		var sqpl = (org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetRelatedDocumentsQuery) q1.getIpfQuery();

		assertEquals("1234", sqpl.getUuid());
		assertTrue(sqpl.getAssociationTypes().stream()
				.anyMatch(t -> t != null && t.getOpcode21().equals(parentRelation.get(0).getOpcode21())));
		assertTrue(sqpl.getAssociationTypes().stream()
				.anyMatch(t -> t != null && t.getOpcode21().equals(parentRelation.get(1).getOpcode21())));

	}

	/**
	 * Test method for
	 * {@link org.husky.communication.xd.storedquery.GetRelatedDocumentsQuery#GetRelatedDocumentsQuery(java.lang.String, boolean, org.openhealthtools.ihe.xds.metadata.ParentDocumentRelationshipType[], java.lang.String)}
	 * .
	 */
	@Test
	void testGetRelatedDocumentsQueryStringBooleanParentDocumentRelationshipTypeArrayString() {
		final GetRelatedDocumentsQuery q2 = new GetRelatedDocumentsQuery("1234", true,
				parentRelation, "9876");
		assertTrue(q2.getIpfQuery().getHomeCommunityId().contains("9876"));
	}

	/**
	 * Test method for
	 * {@link org.husky.communication.xd.storedquery.GetRelatedDocumentsQuery#GetRelatedDocumentsQuery(java.lang.String, boolean, org.openhealthtools.ihe.xds.metadata.ParentDocumentRelationshipType[], java.lang.String, org.openhealthtools.ihe.xds.consumer.storedquery.ObjectType)}
	 * .
	 */
	@Test
	void testGetRelatedDocumentsQueryStringBooleanParentDocumentRelationshipTypeArrayStringObjectType() {
		final GetRelatedDocumentsQuery q3 = new GetRelatedDocumentsQuery("1234", true,
				parentRelation, "6789", DocumentEntryType.STABLE);

		assertTrue(q3
				.getIpfQuery() instanceof org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetRelatedDocumentsQuery);

		var sqpl = (org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetRelatedDocumentsQuery) q3.getIpfQuery();

		assertTrue(sqpl.getDocumentEntryTypes().stream().anyMatch(
				t -> t != null && t.getUuid().equalsIgnoreCase("urn:uuid:7edca82f-054d-47f2-a032-9b2a5b5186c1")));
	}

}
