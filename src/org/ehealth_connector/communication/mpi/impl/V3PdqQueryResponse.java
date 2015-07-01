package org.ehealth_connector.communication.mpi.impl;

import java.util.List;

import org.ehealth_connector.communication.mpi.FhirPatient;
import org.ehealth_connector.communication.mpi.MpiQueryResponse;

public class V3PdqQueryResponse implements MpiQueryResponse {

	private List<FhirPatient> patients;

	private final boolean success = false;

	@Override
	public boolean getSuccess() {
		return success;
	}

	@Override
	public int getTotalNumbers() {
		return 0;
	}

	@Override
	public int getPosition() {
		return 0;
	}

	@Override
	public List<FhirPatient> getPatients() {
		return patients;
	}

	public void setPatients(List<FhirPatient> patients) {
		this.patients = patients;
	}

}
