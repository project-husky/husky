/* **********************************************************************
 * Author: roeland
 * Date  : Dec 16, 2015
 * File  : GetRelatedDocumentsQueryTest.java
 * **********************************************************************
 * ehealth_connector-communication-gen
 *
 * Copyright (c) 2015
 * Arpage AG, CH - 8700 Kuesnacht ZH
 * All rights reserved
 * **********************************************************************
 */
package org.ehealth_connector.communication.xd.storedquery;

import static org.junit.Assert.assertTrue;

import org.ehealth_connector.communication.testhelper.XdsTestUtils;
import org.junit.Before;
import org.junit.Test;
import org.openhealthtools.ihe.xds.consumer.storedquery.ObjectType;
import org.openhealthtools.ihe.xds.consumer.storedquery.StoredQueryParameterList;

/**
 * 
 * @author roeland
 * @version 1.0
 * @since Dec 16, 2015 11:13:24 AM
 *
 */
public class GetRelatedDocumentsQueryTest extends XdsTestUtils {

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@Before
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
