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
package org.ehealth_connector.communication.mpi.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.ehealth_connector.communication.testhelper.TestPatient;
import org.ehealth_connector.fhir.structures.gen.FhirPatient;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Junit Tests for the ImMemoryMpiAdapter
 *
 * @see org.ehealth_connector.communication.mpi.impl.InMemoryMockMpiAdapter
 */
public class InMemoryMockMpiAdapterTests {

	/** The SLF4J logger instance. */
	protected final Logger log = LoggerFactory.getLogger(getClass());

	private InMemoryMockMpiAdapter mpiAdapter;

	@Before
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
		assertTrue(patientId != null);
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
		assertTrue(!mpiPatientId.equals(mpiPatientIdObsolete));
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
		assertTrue(patientId != null);
	}

}
