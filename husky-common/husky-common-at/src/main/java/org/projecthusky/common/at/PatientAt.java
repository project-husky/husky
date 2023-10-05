/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.projecthusky.common.at;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.projecthusky.common.hl7cdar2.POCDMT000040RecordTarget;
import org.projecthusky.common.model.Address;
import org.projecthusky.common.model.Name;
import org.projecthusky.common.model.Patient;

public class PatientAt extends Patient {

	private LocalDate dateOfDeath;
	private List<Guardian> guardians;
	private Address birthPlace;
	private Name name;
	private List<Address> addresses;

	public PatientAt() {
		super();
	}

	public PatientAt(POCDMT000040RecordTarget target) {
		super(target);
		if (target != null && target.getPatientRole() != null && target.getPatientRole().getPatient() != null
				&& target.getPatientRole().getPatient().getBirthplace() != null
				&& target.getPatientRole().getPatient().getBirthplace().getPlace() != null) {
			this.birthPlace = new Address(target.getPatientRole().getPatient().getBirthplace().getPlace().getAddr());
		}
	}

	public List<Guardian> getGuardians() {
		return this.guardians;
	}

	public void setGuardians(List<Guardian> orgGuardian) {
		this.guardians = orgGuardian;
	}

	public Address getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(Address birthPlace) {
		this.birthPlace = birthPlace;
	}

	public LocalDate getDateOfDeath() {
		return dateOfDeath;
	}

	public void setDateOfDeath(LocalDate dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	@Override
	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	@Override
	public List<Address> getAddresses() {
		if (addresses == null) {
			this.addresses = new LinkedList<>();
		}
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

}
