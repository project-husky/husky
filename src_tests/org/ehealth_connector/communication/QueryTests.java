package org.ehealth_connector.communication;

import static org.junit.Assert.*;

import org.ehealth_connector.communication.ch.storedquery.*;
import org.junit.Test;
import org.openhealthtools.ihe.xds.consumer.storedquery.MalformedStoredQueryException;
import org.openhealthtools.ihe.xds.consumer.storedquery.StoredQueryParameterList;
import org.openhealthtools.ihe.xds.consumer.storedquery.ObjectType;

public class QueryTests extends XdsTestUtils {
	
	public QueryTests() {
		super();
	}
	
	@Test
	public void FindDocumentsQueryTest() {
		//Constructor Test
		try {
			//Create a query
			FindDocumentsQuery q = new FindDocumentsQuery(patientId, classCodes, eDateTimeRanges, practiceSettingCodes, healthCareFacilityCodes, confidentialityCodes, formatCodes, authorPerson, avaiabilityStatus);
			
			//Check query parameters
			StoredQueryParameterList sqpl = q.getOhtStoredQuery().getQueryParameters();
			
			assertTrue(sqpl.get("$XDSDocumentEntryPatientId").contains(patientId.getRoot()));
			assertTrue(sqpl.get("$XDSDocumentEntryPatientId").contains(patientId.getExtension()));
			
			assertTrue(sqpl.get("$XDSDocumentEntryStatus").contains(avaiabilityStatus.getCodeValue()));

			assertTrue(sqpl.get("$XDSDocumentEntryCreationTimeFrom").contains(eDateTimeRange1.getFromAsUsFormattedString()));
			assertTrue(sqpl.get("$XDSDocumentEntryCreationTimeTo").contains(eDateTimeRange1.getToAsUsFormattedString()));
			
			assertTrue(sqpl.get("$XDSDocumentEntryClassCode").contains(classCodes[0].getCodeValue()));
			assertTrue(sqpl.get("$XDSDocumentEntryPracticeSettingCode").contains(practiceSettingCodes[0].getCodeSystemName()));
			assertTrue(sqpl.get("$XDSDocumentEntryHealthcareFacilityTypeCode").contains(healthCareFacilityCodes[0].getCodeValue()));
			assertTrue(sqpl.get("$XDSDocumentEntryConfidentialityCode").contains(confidentialityCodes[1].getCodeValue()));
			assertTrue(sqpl.get("$XDSDocumentEntryFormatCode").contains(formatCodes[1].getCodeValue()));
			
			assertTrue(sqpl.get("$XDSDocumentEntryAuthorPerson").contains(authorPerson.getGivenName()));
			assertTrue(sqpl.get("$XDSDocumentEntryAuthorPerson").contains(authorPerson.getFamilyName()));
			assertTrue(sqpl.get("$XDSDocumentEntryAuthorPerson").contains(authorPerson.getPrefix()));
			assertTrue(sqpl.get("$XDSDocumentEntryAuthorPerson").contains(authorPerson.getPrefix()));
		} catch (MalformedStoredQueryException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void FindFoldersStoredQueryTest() {
		 try {
			FindFoldersStoredQuery q = new org.ehealth_connector.communication.ch.storedquery.FindFoldersStoredQuery(patientId, avaiabilityStatus);
		
			StoredQueryParameterList sqpl = q.getOhtStoredQuery().getQueryParameters();
			
			assertTrue(sqpl.get("$XDSFolderPatientId").contains(patientId.getRoot()));
			assertTrue(sqpl.get("$XDSFolderStatus").contains(avaiabilityStatus.getCodeValue()));
		 } catch (MalformedStoredQueryException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void GetDocumentsQueryTest() {
		try {
			GetDocumentsQuery q = new GetDocumentsQuery(docIds, true);
			
			StoredQueryParameterList sqpl = q.getOhtStoredQuery().getQueryParameters();
			
			assertTrue(sqpl.get("$XDSDocumentEntryEntryUUID").contains(docIds[0]));
			assertTrue(sqpl.get("$XDSDocumentEntryEntryUUID").contains(docIds[1]));
		} catch (MalformedStoredQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void GetFolderAndContentsQueryTest() {
		try {
			GetFolderAndContentsQuery q1 = new GetFolderAndContentsQuery("1234", true, formatCodes, confidentialityCodes);
			GetFolderAndContentsQuery q2 = new GetFolderAndContentsQuery("1234", true, formatCodes, confidentialityCodes, "9876");
			GetFolderAndContentsQuery q3 = new GetFolderAndContentsQuery("1234", true, formatCodes, confidentialityCodes, "6565873dsdgsdg", ObjectType.STATIC);
		
			StoredQueryParameterList sqpl1 = q1.getOhtStoredQuery().getQueryParameters();
			
			//Check first query
			assertTrue(sqpl1.get("$XDSFolderEntryUUID").contains("1234"));
			assertTrue(sqpl1.get("$XDSDocumentEntryFormatCode").contains(formatCodes[1].getCodeValue()));
			assertTrue(sqpl1.get("$XDSDocumentEntryConfidentialityCode").contains(confidentialityCodes[1].getCodeSystemName()));
			
			//Check second query
			assertTrue(q2.getOhtStoredQuery().getHomeCommunityId().contains("9876"));
			
			//Check third query
			assertTrue(q3.getOhtStoredQuery().getQueryParameters().get("$XDSDocumentEntryType").contains("urn:uuid:7edca82f-054d-47f2-a032-9b2a5b5186c1"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void GetRelatedDocumentsQueryTest() {
		try {
			GetRelatedDocumentsQuery q1 = new GetRelatedDocumentsQuery("1234", true, parentRelation);
			GetRelatedDocumentsQuery q2 = new GetRelatedDocumentsQuery("1234", true, parentRelation, "9876");
			GetRelatedDocumentsQuery q3 = new GetRelatedDocumentsQuery("1234", true, parentRelation, "6789", ObjectType.STATIC);
			
			StoredQueryParameterList sqpl = q1.getOhtStoredQuery().getQueryParameters();
			
			assertTrue(sqpl.get("$XDSDocumentEntryEntryUUID").contains("1234"));
			assertTrue(sqpl.get("$AssociationTypes").contains(parentRelation[0].getLiteral()));
			assertTrue(sqpl.get("$AssociationTypes").contains(parentRelation[1].getLiteral()));
			
			assertTrue(q2.getOhtStoredQuery().getHomeCommunityId().contains("9876"));
			
			assertTrue(q3.getOhtStoredQuery().getQueryParameters().get("$XDSDocumentEntryType").contains("urn:uuid:7edca82f-054d-47f2-a032-9b2a5b5186c1"));
		} catch (MalformedStoredQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}