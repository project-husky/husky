/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.husky.cda.elga.models;

import java.util.List;

import org.husky.cda.elga.generated.artdecor.AtcdabbrOtherInformantBody;
import org.husky.cda.elga.generated.artdecor.enums.ElgaAuthorSpeciality;
import org.husky.cda.elga.generated.artdecor.enums.ElgaPersonalRelationship;
import org.husky.common.enums.NullFlavor;
import org.husky.common.hl7cdar2.CE;
import org.husky.common.hl7cdar2.POCDMT000040AssignedEntity;
import org.husky.common.hl7cdar2.POCDMT000040Organization;
import org.husky.common.hl7cdar2.POCDMT000040Person;
import org.husky.common.hl7cdar2.POCDMT000040RelatedEntity;
import org.husky.common.model.Address;
import org.husky.common.model.Identificator;
import org.husky.common.model.Name;
import org.husky.common.model.Organization;
import org.husky.common.model.Telecom;

public class Informant {

	private ElgaPersonalRelationship persRel;
	private ElgaAuthorSpeciality authorSpeciality;
	private Name name;
	private List<Identificator> ids;
	private Organization organization;
	private List<Address> addresses;
	private List<Telecom> telecoms;

	public Name getName() {
		return name;
	}

	public Organization getOrganization() {
		return organization;
	}

	public ElgaPersonalRelationship getPersRel() {
		return persRel;
	}

	/**
	 * if ids is empty or null UNKNOWN Null flavor will be used. If the entry of ids
	 * is null than NOINFORMATION NullFlavor will be used
	 * 
	 * @param ids
	 */
	public void setIds(List<Identificator> ids) {
		this.ids = ids;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public void setPersRel(ElgaPersonalRelationship persRel) {
		this.persRel = persRel;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Telecom> getTelecoms() {
		return telecoms;
	}

	public void setTelecoms(List<Telecom> telecoms) {
		this.telecoms = telecoms;
	}

	public List<Identificator> getIds() {
		return ids;
	}

	public ElgaAuthorSpeciality getAuthorSpeciality() {
		return authorSpeciality;
	}

	public void setAuthorSpeciality(ElgaAuthorSpeciality authorSpeciality) {
		this.authorSpeciality = authorSpeciality;
	}

	protected AtcdabbrOtherInformantBody getInformantBodyPs() {
		AtcdabbrOtherInformantBody informantBody = new AtcdabbrOtherInformantBody();

		if (this.persRel != null) {
			informantBody.setHl7RelatedEntity(
					getHl7CdaR2Pocdmt000040RelatedEntity(AtcdabbrOtherInformantBody.getPredefinedRelatedEntityPrs()));
		} else {
			informantBody.setHl7AssignedEntity(
					getHl7CdaR2Pocdmt000040AssignedEntity(
							AtcdabbrOtherInformantBody.getPredefinedAssignedEntityAssigned()));
		}

		return informantBody;
	}

	protected POCDMT000040RelatedEntity getHl7CdaR2Pocdmt000040RelatedEntity(POCDMT000040RelatedEntity entity) {
		if (this.persRel != null && persRel.getCode() != null) {
			entity.setCode(new CE(this.persRel.getCode().getCode(), this.persRel.getCode().getCodeSystem(),
					this.persRel.getCode().getCodeSystemName(), this.persRel.getCode().getDisplayName()));
		}

		if (this.addresses != null && !this.addresses.isEmpty()) {
			for (Address address : this.addresses) {
				if (address != null) {
					entity.getAddr().add(address.getHl7CdaR2Ad());
				}
			}
		}

		if (this.telecoms != null && !this.telecoms.isEmpty()) {
			for (Telecom telecom : this.telecoms) {
				if (telecom != null) {
					entity.getTelecom().add(telecom.getHl7CdaR2Tel());
				}
			}
		}

		if (this.name != null) {
			entity.setRelatedPerson(getHl7CdaR2Pocdmt000040Person(new POCDMT000040Person()));
		}

		return entity;
	}

	/**
	 * 
	 * if ids is empty or null UNKNOWN Null flavor will be used. If the entry of ids
	 * is null than NOINFORMATION NullFlavor will be used
	 * 
	 * @param assignedEntity assigned entity to fill with data
	 * @return filled assigned entity
	 */
	protected POCDMT000040AssignedEntity getHl7CdaR2Pocdmt000040AssignedEntity(
			POCDMT000040AssignedEntity assignedEntity) {
		assignedEntity.setClassCode("ASSIGNED");

		if (ids != null && !ids.isEmpty()) {
			for (Identificator id : ids) {
				if (id != null) {
					assignedEntity.getId().add(id.getHl7CdaR2Ii());
				} else {
					Identificator niId = new Identificator();
					niId.setNullFlavor(NullFlavor.NOINFORMATION);
					assignedEntity.getId().add(niId.getHl7CdaR2Ii());
				}
			}
		} else {
			Identificator unknownId = new Identificator();
			unknownId.setNullFlavor(NullFlavor.UNKNOWN);
			assignedEntity.getId().add(unknownId.getHl7CdaR2Ii());
		}

		if (this.name != null) {
			assignedEntity.setAssignedPerson(getHl7CdaR2Pocdmt000040Person(new POCDMT000040Person()));
		}

		if (this.organization != null) {
			POCDMT000040Organization legalAuthenOrg = new POCDMT000040Organization();
			legalAuthenOrg.setClassCode("ORG");
			legalAuthenOrg.setDeterminerCode("INSTANCE");
			assignedEntity
					.setRepresentedOrganization(this.organization.getHl7CdaR2Pocdmt000040Organization(legalAuthenOrg));
		}

		if (this.authorSpeciality != null && this.authorSpeciality.getCode() != null) {
			assignedEntity.setCode(
					new CE(this.authorSpeciality.getCode().getCode(), this.authorSpeciality.getCode().getCodeSystem(),
							this.authorSpeciality.getCode().getCodeSystemName(),
							this.authorSpeciality.getCode().getDisplayName()));
		}

		if (this.addresses != null && !this.addresses.isEmpty() && this.addresses.get(0) != null) {
			assignedEntity.getAddr().add(this.addresses.get(0).getHl7CdaR2Ad());
		}

		if (this.telecoms != null && !this.telecoms.isEmpty()) {
			for (Telecom telecom : this.telecoms) {
				if (telecom != null) {
					assignedEntity.getTelecom().add(telecom.getHl7CdaR2Tel());
				}
			}
		}

		return assignedEntity;
	}

	protected POCDMT000040Person getHl7CdaR2Pocdmt000040Person(POCDMT000040Person person) {
		if (this.name != null) {
			person.getName().add(this.name.getHl7CdaR2Pn());
			if (person.getClassCode() != null && person.getClassCode().isEmpty()) {
				person.getClassCode().add("PSN");
			}
			person.setDeterminerCode("INSTANCE");
		}
		return person;
	}


}
