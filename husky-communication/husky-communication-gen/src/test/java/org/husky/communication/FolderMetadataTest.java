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
package org.husky.communication;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.husky.common.model.Code;
import org.husky.common.model.Identificator;
import org.husky.common.utils.OID;
import org.husky.communication.FolderMetadata;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;

/**
 * <div class="en">Testclass for
 * {@link org.husky.communication.FolderMetadata}.</div>
 *
 */
class FolderMetadataTest {

	private AvailabilityStatus testAvailabilityStatus1;
	private AvailabilityStatus testAvailabilityStatus2;

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
	@BeforeEach
	public void setUp() throws Exception {
		testAvailabilityStatus1 = AvailabilityStatus.APPROVED;
		testAvailabilityStatus2 = AvailabilityStatus.DEPRECATED;
		testCodeList = new ArrayList<>();

		testCode1 = new Code("1.2.3.4", "TestCode1", null);
		testCode2 = new Code("5.6.7.8", "TestCode2", null);
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
	 * {@link org.husky.communication.FolderMetadata#addCode(org.org.husky.common.model.Code)}.
	 */
	@Test
	void testAddCode() {
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
	 * {@link org.husky.communication.FolderMetadata#setAvailabilityStatus(org.openhealthtools.ihe.xds.metadata.AvailabilityStatusType)}.
	 */
	@Test
	void testSetAvailabilityStatus() {
		final FolderMetadata ref = new FolderMetadata();
		assertNull(ref.getAvailabilityStatus());

		ref.setAvailabilityStatus(testAvailabilityStatus1);
		assertEquals(testAvailabilityStatus1, ref.getAvailabilityStatus());

		ref.setAvailabilityStatus(testAvailabilityStatus2);
		assertEquals(testAvailabilityStatus2, ref.getAvailabilityStatus());
	}

	/**
	 * Test method for
	 * {@link org.husky.communication.FolderMetadata#setCodeList(java.util.List)}.
	 */
	@Test
	void testSetGetCodeList() {
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
	 * {@link org.husky.communication.FolderMetadata#setComments(java.lang.String)}.
	 */
	@Test
	void testSetGetComments() {
		final FolderMetadata ref = new FolderMetadata();
		assertNull(ref.getComments());

		ref.setComments(testComments);
		assertEquals(testComments, ref.getComments());
	}

	/**
	 * Test method for
	 * {@link org.husky.communication.FolderMetadata#setEntryUUID(java.lang.String)},
	 * {@link org.husky.communication.FolderMetadata#getEntryUUID()}.
	 */
	@Test
	void testSetGetEntryUUID() {
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
	 * {@link org.husky.communication.FolderMetadata#setLastUpdateTime(java.util.Date)},
	 * {@link org.husky.communication.FolderMetadata#getLastUpdateTime()}.
	 */
	@Test
	@Disabled
	void testSetGetLastUpdateTime() {
		final FolderMetadata ref = new FolderMetadata();
		assertNull(ref.getLastUpdateTime());

		ref.setLastUpdateTime(testLastUpdateTime);
		assertEquals(testLastUpdateTime.toInstant(), ref.getLastUpdateTime().toInstant());
	}

	/**
	 * Test method for
	 * {@link org.husky.communication.FolderMetadata#setPatientId(org.org.husky.common.model.Identificator)},
	 * {@link org.husky.communication.FolderMetadata#getPatientId()}.
	 */
	@Test
	void testSetGetPatientId() {
		final FolderMetadata ref = new FolderMetadata();
		assertNull(ref.getPatientId());

		ref.setPatientId(testPatientId);
		assertEquals(testPatientId, ref.getPatientId());
	}

	/**
	 * Test method for
	 * {@link org.husky.communication.FolderMetadata#setTitle(java.lang.String)},
	 * {@link org.husky.communication.FolderMetadata#getTitle()}.
	 */
	@Test
	void testSetGetTitle() {
		final FolderMetadata ref = new FolderMetadata();
		assertNull(ref.getTitle());

		ref.setTitle(testTitle1);
		assertEquals(testTitle1, ref.getTitle());

		ref.setTitle(testTitle2);
		assertEquals(testTitle2, ref.getTitle());
	}

	/**
	 * Test method for
	 * {@link org.husky.communication.FolderMetadata#setUniqueId(java.lang.String)},
	 * {@link org.husky.communication.FolderMetadata#getUniqueId()}.
	 */
	@Test
	void testSetGetUniqueId() {
		final FolderMetadata ref = new FolderMetadata();
		assertNull(ref.getUniqueId());

		ref.setUniqueId(testUniqueId1);
		assertEquals(testUniqueId1, ref.getUniqueId());

		ref.setUniqueId(testUniqueId2);
		assertEquals(testUniqueId2, ref.getUniqueId());
	}

}
