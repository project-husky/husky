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
package org.husky.communication.mpi.impl;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.husky.communication.testhelper.InMemoryMockMpiAdapter;
import org.husky.communication.testhelper.TestPatient;
import org.husky.fhir.structures.gen.FhirPatient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Junit Tests for the ImMemoryMpiAdapter
 *
 * @see org.husky.communication.testhelper.InMemoryMockMpiAdapter
 */
public class InMemoryMockMpiAdapterTests {

	/** The SLF4J logger instance. */
	protected final Logger log = LoggerFactory.getLogger(getClass());

	private InMemoryMockMpiAdapter mpiAdapter;

	@BeforeEach
	public void initMpi() {
		log.debug("init mpi");
		mpiAdapter = new InMemoryMockMpiAdapter();
		mpiAdapter.clear();
	}

	@Test
	public void useCase1RegisterNewPatientWithLocalId() {
		final FhirPatient patient = TestPatient.getFhirPatientMueller();
		assertTrue(mpiAdapter.addPatient(patient));
		final String patientId = mpiAdapter.queryPatientId(patient);
		assertNotNull(patientId);
	}

	@Test
	public void useCase2UpdateNewPatientWithLocalId() {
		final FhirPatient patient = TestPatient.getFhirPatientMueller();
		assertTrue(mpiAdapter.addPatient(patient));
		final String patientId = mpiAdapter.queryPatientId(patient);
		patient.getName().get(0).setFamily("Müster");
		assertTrue(mpiAdapter.updatePatient(patient));
		final String patientIdAfterUpdate = mpiAdapter.queryPatientId(patient);
		assertEquals(patientId, patientIdAfterUpdate);
	}

	@Test
	public void useCase3MergeNewPatientWithObsoleteId() {
		final FhirPatient patient = TestPatient.getFhirPatientMueller();
		assertTrue(mpiAdapter.addPatient(patient));
		final String mpiPatientId = mpiAdapter.queryPatientId(patient);
		final FhirPatient patientObsolete = TestPatient.getFhirPatientMuellerObsoleteId();
		assertTrue(mpiAdapter.addPatient(patientObsolete));
		final String mpiPatientIdObsolete = mpiAdapter.queryPatientId(patientObsolete);
		assertNotEquals(mpiPatientId, mpiPatientIdObsolete);
		assertTrue(mpiAdapter.mergePatient(patient,
				TestPatient.getTestPatientMuellerObsolete().localId));
		assertEquals(mpiPatientId, mpiAdapter.queryPatientId(patient));
		assertEquals(mpiPatientId, mpiAdapter.queryPatientId(patientObsolete));
	}

	@Test
	public void useCase4RegisterNewPatientWithLocalId() {
		final FhirPatient patient = TestPatient.getFhirPatientMueller();
		assertTrue(mpiAdapter.addPatient(patient));
		final String patientId = mpiAdapter.queryPatientId(patient);
		assertNotNull(patientId);
	}

}
