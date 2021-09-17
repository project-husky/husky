/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
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
package org.ehealth_connector.communication.xd.storedquery;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.ehealth_connector.communication.testhelper.XdsTestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openhealthtools.ihe.xds.consumer.storedquery.ObjectType;
import org.openhealthtools.ihe.xds.consumer.storedquery.StoredQueryParameterList;

/**
 * Test of class GetRelatedDocumentsQuery
 */
public class GetRelatedDocumentsQueryTest extends XdsTestUtils {

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
	 * {@link org.ehealth_connector.communication.xd.storedquery.GetRelatedDocumentsQuery#GetRelatedDocumentsQuery(java.lang.String, boolean, org.openhealthtools.ihe.xds.metadata.ParentDocumentRelationshipType[])}
	 * .
	 */
	@Test
	public void testGetRelatedDocumentsQueryStringBooleanParentDocumentRelationshipTypeArray() {
		final GetRelatedDocumentsQuery q1 = new GetRelatedDocumentsQuery("1234", true,
				parentRelation);

		final StoredQueryParameterList sqpl = q1.getOhtStoredQuery().getQueryParameters();

		assertTrue(sqpl.get("$XDSDocumentEntryEntryUUID").contains("1234"));
		assertTrue(sqpl.get("$AssociationTypes").contains(parentRelation[0].getLiteral()));
		assertTrue(sqpl.get("$AssociationTypes").contains(parentRelation[1].getLiteral()));

	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.communication.xd.storedquery.GetRelatedDocumentsQuery#GetRelatedDocumentsQuery(java.lang.String, boolean, org.openhealthtools.ihe.xds.metadata.ParentDocumentRelationshipType[], java.lang.String)}
	 * .
	 */
	@Test
	public void testGetRelatedDocumentsQueryStringBooleanParentDocumentRelationshipTypeArrayString() {
		final GetRelatedDocumentsQuery q2 = new GetRelatedDocumentsQuery("1234", true,
				parentRelation, "9876");
		assertTrue(q2.getOhtStoredQuery().getHomeCommunityId().contains("9876"));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.communication.xd.storedquery.GetRelatedDocumentsQuery#GetRelatedDocumentsQuery(java.lang.String, boolean, org.openhealthtools.ihe.xds.metadata.ParentDocumentRelationshipType[], java.lang.String, org.openhealthtools.ihe.xds.consumer.storedquery.ObjectType)}
	 * .
	 */
	@Test
	public void testGetRelatedDocumentsQueryStringBooleanParentDocumentRelationshipTypeArrayStringObjectType() {
		final GetRelatedDocumentsQuery q3 = new GetRelatedDocumentsQuery("1234", true,
				parentRelation, "6789", ObjectType.STATIC);
		assertTrue(q3.getOhtStoredQuery().getQueryParameters().get("$XDSDocumentEntryType")
				.contains("urn:uuid:7edca82f-054d-47f2-a032-9b2a5b5186c1"));
	}

}
