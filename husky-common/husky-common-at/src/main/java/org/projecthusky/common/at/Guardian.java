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

import java.util.List;

import org.projecthusky.common.hl7cdar2.POCDMT000040Guardian;
import org.projecthusky.common.hl7cdar2.POCDMT000040Person;
import org.projecthusky.common.model.Address;
import org.projecthusky.common.model.Name;
import org.projecthusky.common.model.Organization;
import org.projecthusky.common.model.Telecom;

public class Guardian {

	private Address address;
	private List<Telecom> telecoms;
	private Name name;
	private Organization organization;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Telecom> getTelecoms() {
		return telecoms;
	}

	public void setTelecoms(List<Telecom> telecoms) {
		this.telecoms = telecoms;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public POCDMT000040Guardian getPOCDMT000040Guardian() {
		POCDMT000040Guardian guardian = new POCDMT000040Guardian();
		guardian.getClassCode().add("GUARD");

		if (address != null) {
			guardian.getAddr().add(address.getHl7CdaR2Ad());
		}

		if (telecoms != null && !telecoms.isEmpty()) {
			for (Telecom tel : telecoms) {
				if (tel != null) {
					guardian.getTelecom().add(tel.getHl7CdaR2Tel());
				}
			}
		}

		if (organization != null) {
			guardian.setGuardianOrganization(organization.getHl7CdaR2Pocdmt000040Organization());
		} else if (name != null) {
			POCDMT000040Person person = new POCDMT000040Person();
			person.setDeterminerCode("INSTANCE");
			person.getClassCode().add("PSN");
			person.getName().add(name.getHl7CdaR2Pn());
			guardian.setGuardianPerson(person);
		}

		return guardian;
	}

}
