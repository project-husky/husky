/*******************************************************************************
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 *******************************************************************************/
package org.ehealth_connector.communication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openhealthtools.ihe.utils.OID;
import org.openhealthtools.ihe.xds.metadata.AvailabilityStatusType;

/**
 * <div class="en">Testclass for
 * {@link org.ehealth_connector.communication.FolderMetadata}.</div>
 *
 */
public class FolderMetadataTest {

	private AvailabilityStatusType testAvailabilityStatus1;
	private AvailabilityStatusType testAvailabilityStatus2;

	private List<Code> testCodeList;
	private Code testCode1;
	private Code testCode2;

	private String testComments;

	private String testEntryUUID1;
	private String testEntryUUID2;

	private Date testLastUpdateTime;

	private Identificator testPatientId;

	private String testTitle1;
	private String testTitle2;

	private String testUniqueId1;
	private String testUniqueId2;

	/**
	 * Setting up the test params
	 *
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testAvailabilityStatus1 = AvailabilityStatusType.WITHDRAWN_LITERAL;
		testAvailabilityStatus2 = AvailabilityStatusType.DEPRECATED_LITERAL;
		testCodeList = new ArrayList<>();

		testCode1 = new Code("1.2.3.4", "TestCode1");
		testCode2 = new Code("5.6.7.8", "TestCode2");
		testCodeList.add(testCode1);
		testCodeList.add(testCode2);

		testComments = "This is a testcomment for the unit test ÄÖÜäöü";

		testEntryUUID1 = UUID.randomUUID().toString();
		testEntryUUID2 = UUID.randomUUID().toString();

		testLastUpdateTime = Calendar.getInstance().getTime();

		testPatientId = new Identificator("1.2.3.4", "1234.345.23456.2346");

		testTitle1 = "The Folder Title 1";
		testTitle2 = "The Folder Title to be tested to";

		testUniqueId1 = OID.createOIDGivenRoot("1.2.3.9999");
		testUniqueId2 = OID.createOIDGivenRoot("1.2.3.9999");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.communication.FolderMetadata#setAvailabilityStatus(org.openhealthtools.ihe.xds.metadata.AvailabilityStatusType)}.
	 */
	@Test
	public void testSetAvailabilityStatus() {
		final FolderMetadata ref = new FolderMetadata();
		assertEquals(AvailabilityStatusType.SUBMITTED_LITERAL, ref.getAvailabilityStatus());

		ref.setAvailabilityStatus(testAvailabilityStatus1);
		assertEquals(testAvailabilityStatus1, ref.getAvailabilityStatus());

		ref.setAvailabilityStatus(testAvailabilityStatus2);
		assertEquals(testAvailabilityStatus2, ref.getAvailabilityStatus());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.communication.FolderMetadata#setCodeList(java.util.List)}.
	 */
	@Test
	public void testSetGetCodeList() {
		final FolderMetadata ref = new FolderMetadata();
		assertNotNull(ref.getCodeList());
		assertEquals(0, ref.getCodeList().size());

		ref.setCodeList(testCodeList);
		assertNotNull(ref.getCodeList());
		assertEquals(2, ref.getCodeList().size());
		assertEquals(testCode1, ref.getCodeList().get(0));
		assertEquals(testCode2, ref.getCodeList().get(1));

	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.communication.FolderMetadata#addCode(org.ehealth_connector.common.Code)}.
	 */
	@Test
	public void testAddCode() {
		final FolderMetadata ref = new FolderMetadata();
		assertNotNull(ref.getCodeList());
		assertEquals(0, ref.getCodeList().size());

		ref.addCode(testCode1);
		assertNotNull(ref.getCodeList());
		assertEquals(1, ref.getCodeList().size());
		assertEquals(testCode1, ref.getCodeList().get(0));

		ref.addCode(testCode2);
		assertNotNull(ref.getCodeList());
		assertEquals(2, ref.getCodeList().size());
		assertEquals(testCode2, ref.getCodeList().get(1));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.communication.FolderMetadata#setComments(java.lang.String)}.
	 */
	@Test
	public void testSetGetComments() {
		final FolderMetadata ref = new FolderMetadata();
		assertNull(ref.getComments());

		ref.setComments(testComments);
		assertEquals(testComments, ref.getComments());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.communication.FolderMetadata#setEntryUUID(java.lang.String)},
	 * {@link org.ehealth_connector.communication.FolderMetadata#getEntryUUID()}.
	 */
	@Test
	public void testSetGetEntryUUID() {
		final FolderMetadata ref = new FolderMetadata();
		assertNull(ref.getEntryUUID());

		ref.setEntryUUID(testEntryUUID1);
		assertEquals(testEntryUUID1, ref.getEntryUUID());
		assertNotEquals(testEntryUUID2, ref.getEntryUUID());

		ref.setEntryUUID(testEntryUUID2);
		assertNotEquals(testEntryUUID1, ref.getEntryUUID());
		assertEquals(testEntryUUID2, ref.getEntryUUID());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.communication.FolderMetadata#setLastUpdateTime(java.util.Date)},
	 * {@link org.ehealth_connector.communication.FolderMetadata#getLastUpdateTime()}.
	 */
	@Test
	@Ignore
	public void testSetGetLastUpdateTime() {
		final FolderMetadata ref = new FolderMetadata();
		assertNull(ref.getLastUpdateTime());

		ref.setLastUpdateTime(testLastUpdateTime);
		assertEquals(testLastUpdateTime, ref.getLastUpdateTime());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.communication.FolderMetadata#setPatientId(org.ehealth_connector.common.Identificator)},
	 * {@link org.ehealth_connector.communication.FolderMetadata#getPatientId()}.
	 */
	@Test
	public void testSetGetPatientId() {
		final FolderMetadata ref = new FolderMetadata();
		assertNull(ref.getPatientId());

		ref.setPatientId(testPatientId);
		assertEquals(testPatientId, ref.getPatientId());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.communication.FolderMetadata#setTitle(java.lang.String)},
	 * {@link org.ehealth_connector.communication.FolderMetadata#getTitle()}.
	 */
	@Test
	public void testSetGetTitle() {
		final FolderMetadata ref = new FolderMetadata();
		assertNull(ref.getTitle());

		ref.setTitle(testTitle1);
		assertEquals(testTitle1, ref.getTitle());

		ref.setTitle(testTitle2);
		assertEquals(testTitle2, ref.getTitle());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.communication.FolderMetadata#setUniqueId(java.lang.String)},
	 * {@link org.ehealth_connector.communication.FolderMetadata#getUniqueId()}.
	 */
	@Test
	public void testSetGetUniqueId() {
		final FolderMetadata ref = new FolderMetadata();
		assertNull(ref.getUniqueId());

		ref.setUniqueId(testUniqueId1);
		assertEquals(testUniqueId1, ref.getUniqueId());

		ref.setUniqueId(testUniqueId2);
		assertEquals(testUniqueId2, ref.getUniqueId());
	}

}
