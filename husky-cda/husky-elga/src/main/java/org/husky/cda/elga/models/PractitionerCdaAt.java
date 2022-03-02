/*
* This getCode() is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.husky.cda.elga.models;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.husky.cda.elga.generated.artdecor.AtcdabbrHeaderAuthor;
import org.husky.cda.elga.generated.artdecor.AtcdabbrHeaderDataEnterer;
import org.husky.cda.elga.generated.artdecor.AtcdabbrHeaderLegalAuthenticator;
import org.husky.cda.elga.generated.artdecor.AtcdabbrOtherAuthorBodyEImpfpass;
import org.husky.cda.elga.generated.artdecor.ps.AuthorBodyPs;
import org.husky.common.at.PractitionerAt;
import org.husky.common.basetypes.AddressBaseType;
import org.husky.common.enums.NullFlavor;
import org.husky.common.hl7cdar2.CE;
import org.husky.common.hl7cdar2.EntityClassDevice;
import org.husky.common.hl7cdar2.IVLTS;
import org.husky.common.hl7cdar2.POCDMT000040AssignedAuthor;
import org.husky.common.hl7cdar2.POCDMT000040AssignedEntity;
import org.husky.common.hl7cdar2.POCDMT000040AssociatedEntity;
import org.husky.common.hl7cdar2.POCDMT000040Author;
import org.husky.common.hl7cdar2.POCDMT000040AuthoringDevice;
import org.husky.common.hl7cdar2.POCDMT000040LegalAuthenticator;
import org.husky.common.hl7cdar2.POCDMT000040Organization;
import org.husky.common.hl7cdar2.POCDMT000040Participant1;
import org.husky.common.hl7cdar2.POCDMT000040Person;
import org.husky.common.hl7cdar2.POCDMT000040ResponsibleParty;
import org.husky.common.hl7cdar2.SC;
import org.husky.common.hl7cdar2.TS;
import org.husky.common.model.Address;
import org.husky.common.model.Identificator;
import org.husky.common.model.Name;
import org.husky.common.model.Telecom;
import org.husky.common.utils.time.DateTimes;

public class PractitionerCdaAt extends PractitionerAt {

	public PractitionerCdaAt() {
		super();
	}

	public PractitionerCdaAt(POCDMT000040Author author) {
		super(author);
	}

	public PractitionerCdaAt(POCDMT000040LegalAuthenticator authenticator) {
		super(authenticator);
	}

	public AtcdabbrHeaderAuthor getAtcdabbrHeaderAuthor(ZonedDateTime timeAuthor) {
		AtcdabbrHeaderAuthor author = new AtcdabbrHeaderAuthor();

		TS time = new TS();

		if (timeAuthor == null) {
			time.getNullFlavor().add(NullFlavor.UNKNOWN_CODE);
		} else {
			time.setValue(DateTimes.toDatetimeTs(timeAuthor).getValue());
		}

		author.setTime(time);

		if (getCode() != null) {
			author.setFunctionCode(getCode().getHl7CdaR2Ce());
		}

		author.setAssignedAuthor(getHl7CdaR2Pocdmt000040AssignedAuthor(author.getAssignedAuthor()));
		return author;
	}

	public AtcdabbrHeaderLegalAuthenticator getHeaderLegalAuthenticator(ZonedDateTime timeLegalAuthen) {
		AtcdabbrHeaderLegalAuthenticator legalAuthenticator = new AtcdabbrHeaderLegalAuthenticator();

		TS time = new TS();

		if (timeLegalAuthen == null) {
			time.getNullFlavor().add(NullFlavor.UNKNOWN_CODE);
		} else {
			time.setValue(DateTimes.toDatetimeTs(timeLegalAuthen).getValue());
		}

		legalAuthenticator.setHl7Time(time);
		legalAuthenticator.setAssignedEntity(
				createAssignedEntity(new POCDMT000040AssignedEntity()));
		return legalAuthenticator;
	}

	protected POCDMT000040AssociatedEntity getHl7CdaR2Pocdmt000040AssociatedEntity() {
		POCDMT000040AssociatedEntity associatedEntity = new POCDMT000040AssociatedEntity();

		if (this.getIdentifier() != null && !getIdentifier().isEmpty()) {
			for (Identificator id : getIdentifier()) {
				if (id != null) {
					associatedEntity.getId().add(id.getHl7CdaR2Ii());
				}
			}
		}

		if (this.getAddresses() != null && !this.getAddresses().isEmpty()) {
			for (Address address : this.getAddresses()) {
				if (address != null) {
					associatedEntity.getAddr().add(address.getHl7CdaR2Ad());
				}
			}
		}

		if (this.getTelecom() != null && !getTelecom().isEmpty()) {
			for (Telecom tel : getTelecom()) {
				if (tel != null) {
					associatedEntity.getTelecom().add(tel.getHl7CdaR2Tel());
				}
			}
		}

		if (getOrganization() != null) {
			associatedEntity.setScopingOrganization(getOrganization().getHl7CdaR2Pocdmt000040Organization());
		}

		if (this.getNames() != null) {
			associatedEntity
					.setAssociatedPerson(getHl7CdaR2Pocdmt000040Person(new POCDMT000040Person()));
		} else {
			POCDMT000040Person person = new POCDMT000040Person();
			person.getNullFlavor().add("UNK");
			associatedEntity.setAssociatedPerson(person);
		}

		return associatedEntity;
	}

	protected POCDMT000040AuthoringDevice getAtcdabbrOtherDeviceCompilation() {
		POCDMT000040AuthoringDevice device = new POCDMT000040AuthoringDevice();
		device.setClassCode(EntityClassDevice.DEV);
		device.setDeterminerCode("INSTANCE");
		device.setManufacturerModelName(new SC(getModelNameOfDevice()));
		device.setSoftwareName(new SC(getSoftwareName()));
		return device;
	}

	protected POCDMT000040AssignedAuthor getHl7CdaR2Pocdmt000040AssignedAuthor(
			POCDMT000040AssignedAuthor assignedAuthor) {

		if (getOrganization() != null) {
			POCDMT000040Organization representedOrganization = assignedAuthor.getRepresentedOrganization();

			if (representedOrganization == null) {
				representedOrganization = new POCDMT000040Organization();
				representedOrganization.setClassCode("ORG");
				representedOrganization.setDeterminerCode("INSTANCE");
			}

			assignedAuthor.setRepresentedOrganization(
					getOrganization().getHl7CdaR2Pocdmt000040Organization(representedOrganization));
		}

		if (this.getIdentifier() != null && !this.getIdentifier().isEmpty()) {
			for (Identificator id : this.getIdentifier()) {
				if (id != null) {
					assignedAuthor.getId().add(id.getHl7CdaR2Ii());
				}
			}
		}

		if (getTelecom() != null && !getTelecom().isEmpty()) {
			for (Telecom tel : getTelecom()) {
				if (tel != null) {
					assignedAuthor.getTelecom().add(tel.getHl7CdaR2Tel());
				}
			}
		}

		if (this.getAddresses() != null) {
			for (Address address : this.getAddresses()) {
				if (address != null) {
					assignedAuthor.getAddr().add(address.getHl7CdaR2Ad());
				}
			}
		}

		if (this.getNames() != null) {
			assignedAuthor.setAssignedPerson(getHl7CdaR2Pocdmt000040Person(assignedAuthor.getAssignedPerson()));
		}

		if (getSpeciality() != null) {
			assignedAuthor.setCode(getSpeciality().getHl7CdaR2Ce());
		}

		if (this.getSoftwareName() != null && this.getModelNameOfDevice() != null) {
			assignedAuthor.setAssignedAuthoringDevice(getAtcdabbrOtherDeviceCompilation());
		}

		return assignedAuthor;
	}

	protected POCDMT000040AssignedEntity getHl7CdaR2Pocdmt000040AssignedEntity(
			POCDMT000040AssignedEntity assignedEntity) {
		if (assignedEntity == null) {
			return assignedEntity;
		}

		if (this.getIdentifier() != null && !getIdentifier().isEmpty()) {
			for (Identificator id : getIdentifier()) {
				if (id != null) {
					assignedEntity.getId().add(id.getHl7CdaR2Ii());
				}
			}
		}

		if (this.getCode() != null) {
			assignedEntity.setCode(this.getCode().getHl7CdaR2Ce());
		} else {
			CE codeCE = new CE();
			codeCE.nullFlavor = new ArrayList<>();
			codeCE.nullFlavor.add("UNK");
			assignedEntity.setCode(codeCE);
		}

		if (getTelecom() != null && !getTelecom().isEmpty()) {
			for (Telecom tel : getTelecom()) {
				if (tel != null) {
					assignedEntity.getTelecom().add(tel.getHl7CdaR2Tel());
				}
			}
		}

		if (getOrganization() != null) {
			assignedEntity.setRepresentedOrganization(getOrganization().getHl7CdaR2Pocdmt000040Organization());
		}

		if (this.getNames() != null) {
			assignedEntity.setAssignedPerson(
					getHl7CdaR2Pocdmt000040Person(assignedEntity.getAssignedPerson()));
		}

		return assignedEntity;
	}

	protected POCDMT000040Person getHl7CdaR2Pocdmt000040Person(POCDMT000040Person person) {
		if (person == null) {
			person = new POCDMT000040Person();
		}

		if (this.getNames() != null) {
			for (Name nam : this.getNames()) {
				if (nam != null) {
					person.getName().add(nam.getHl7CdaR2Pn());
				}
			}

			if (person.getClassCode().isEmpty()) {
				person.getClassCode().add("PSN");
			}
			person.setDeterminerCode("INSTANCE");
		}
		return person;
	}

	public POCDMT000040Participant1 getHeaderOrderingProvider(ZonedDateTime timeAuthor) {
		POCDMT000040Participant1 participant = new POCDMT000040Participant1();
		participant.getTypeCode().add("REF");

		IVLTS time = new IVLTS();
		if (timeAuthor == null) {
			time.getNullFlavor().add(NullFlavor.UNKNOWN_CODE);
		} else {
			time.setValue(DateTimes.toDatetimeTs(timeAuthor).getValue());
		}

		participant.setTime(time);

		participant.setAssociatedEntity(getHl7CdaR2Pocdmt000040AssociatedEntity());
		return participant;
	}

	protected POCDMT000040AssignedEntity createAssignedEntity(POCDMT000040AssignedEntity assignedEntity) {
		if (assignedEntity == null) {
			assignedEntity = new POCDMT000040AssignedEntity();
		}

		assignedEntity.setClassCode("ASSIGNED");

		if (this.getIdentifier() != null) {
			for (Identificator id : this.getIdentifier()) {
				if (id != null) {
					assignedEntity.getId().add(id.getHl7CdaR2Ii());
				}
			}
		}

		if (this.getNames() != null) {
			assignedEntity.setAssignedPerson(createPerson(new POCDMT000040Person()));
		}

		if (getOrganization() != null) {
			POCDMT000040Organization legalAuthenOrg = new POCDMT000040Organization();
			legalAuthenOrg.setClassCode("ORG");
			legalAuthenOrg.setDeterminerCode("INSTANCE");
			legalAuthenOrg = getOrganization().getHl7CdaR2Pocdmt000040Organization(legalAuthenOrg);
			assignedEntity.setRepresentedOrganization(legalAuthenOrg);
		}

		return assignedEntity;
	}

	protected POCDMT000040Person createPerson(POCDMT000040Person person) {
		if (person == null) {
			person = new POCDMT000040Person();
		}

		if (getNames() != null) {
			for (Name nam : getNames()) {
				if (nam != null) {
					person.getName().add(nam.getHl7CdaR2Pn());
				}
			}
		}

		if (person.getClassCode().isEmpty()) {
			person.getClassCode().add("PSN");
		}
		person.setDeterminerCode("INSTANCE");
		return person;
	}

	public AtcdabbrOtherAuthorBodyEImpfpass getAtcdabbrOtherAuthorBodyEImpfpass(ZonedDateTime timeAuthor) {
		AtcdabbrOtherAuthorBodyEImpfpass author = new AtcdabbrOtherAuthorBodyEImpfpass();

		TS time = new TS();
		if (timeAuthor != null) {
			time.setValue(DateTimes.toDatetimeTs(timeAuthor).getValue());
		} else {
			time.nullFlavor = new ArrayList<>();
			time.getNullFlavor().add(NullFlavor.UNKNOWN_CODE);
		}
		author.setTime(time);

		author.setAssignedAuthor(getHl7CdaR2Pocdmt000040AssignedAuthor(author.getAssignedAuthor()));
		return author;
	}

	public String getGdaIndex() {
		if (getIdentifier() == null) {
			return null;
		}

		Optional<Identificator> optionalId = getIdentifier().stream()
				.filter(id -> id != null && (id.getExtension() == null || id.getExtension().isEmpty())
						&& id.getAssigningAuthorityName() != null
						&& id.getAssigningAuthorityName().toUpperCase().contains("GDA"))
				.findFirst();
		if (optionalId.isPresent() && optionalId.get() != null) {
			return optionalId.get().getRoot();
		}

		return null;
	}

	public POCDMT000040ResponsibleParty getPOCDMT000040ResponsibleParty() {
		POCDMT000040ResponsibleParty responsibleParty = new POCDMT000040ResponsibleParty();
		POCDMT000040AssignedEntity assignedEntity = new POCDMT000040AssignedEntity();
		assignedEntity.setClassCode("ASSIGNED");

		if (this.getIdentifier() == null || this.getIdentifier().isEmpty()) {
			Identificator niId = new Identificator();
			niId.setNullFlavor(NullFlavor.NOINFORMATION);
			assignedEntity.getId().add(niId.getHl7CdaR2Ii());
		} else {
			for (Identificator id : this.getIdentifier()) {
				if (id != null) {
					assignedEntity.getId().add(id.getHl7CdaR2Ii());
				} else {
					Identificator unkId = new Identificator();
					unkId.setNullFlavor(NullFlavor.UNKNOWN);
					assignedEntity.getId().add(unkId.getHl7CdaR2Ii());
				}
			}
		}

		if (this.getAddresses() != null && !this.getAddresses().isEmpty()) {
			assignedEntity.getAddr().clear();
			if (this.getAddresses().get(0) != null) {
				assignedEntity.getAddr().add(this.getAddresses().get(0).getHl7CdaR2Ad());
			} else {
				Address addressUnk = new Address(new AddressBaseType());
				addressUnk.setNullFlavor(NullFlavor.UNKNOWN);
				assignedEntity.getAddr().add(addressUnk.getHl7CdaR2Ad());
			}
		}

		if (this.getNames() != null && !this.getNames().isEmpty()) {
			assignedEntity.setAssignedPerson(getHl7CdaR2Pocdmt000040Person(assignedEntity.getAssignedPerson()));
		}

		if (getTelecom() != null && !getTelecom().isEmpty()) {
			for (Telecom tel : getTelecom()) {
				if (tel != null) {
					assignedEntity.getTelecom().add(tel.getHl7CdaR2Tel());
				}
			}
		}

		if (getOrganization() != null) {
			assignedEntity.setRepresentedOrganization(getOrganization().getHl7CdaR2Pocdmt000040Organization());
		}

		responsibleParty.setAssignedEntity(assignedEntity);

		return responsibleParty;
	}

	public AtcdabbrHeaderDataEnterer getHeaderDataEnterer(ZonedDateTime timeDataEnterer) {
		AtcdabbrHeaderDataEnterer dataEnterer = new AtcdabbrHeaderDataEnterer();
		POCDMT000040AssignedEntity assignedEntity = new POCDMT000040AssignedEntity();

		if (getIdentifier() != null && !getIdentifier().isEmpty()) {
			for (Identificator id : getIdentifier()) {
				if (id != null) {
					assignedEntity.getId().add(id.getHl7CdaR2Ii());
				} else {
					Identificator unkId = new Identificator();
					unkId.setNullFlavor(NullFlavor.UNKNOWN);
				}
			}
		}


		if (this.getAddresses() != null && !this.getAddresses().isEmpty()) {
			for (Address address : this.getAddresses()) {
					if (address != null) {
						assignedEntity.getAddr().add(address.getHl7CdaR2Ad());
					} else {
						Address unkAddress = new Address(new AddressBaseType());
						unkAddress.setNullFlavor(NullFlavor.UNKNOWN);
					}
				}
			}

			assignedEntity.setAssignedPerson(
					getHl7CdaR2Pocdmt000040Person(assignedEntity.getAssignedPerson()));


			if (getTelecom() != null && !getTelecom().isEmpty()) {
				for (Telecom telecom : getTelecom()) {
				if (telecom != null) {
					assignedEntity.getTelecom().add(telecom.getHl7CdaR2Tel());
				}
			}
		}

		if (getOrganization() != null) {
			assignedEntity.setRepresentedOrganization(getOrganization().getHl7CdaR2Pocdmt000040Organization());
		}

		dataEnterer.setAssignedEntity(assignedEntity);

		return dataEnterer;
	}

	public AuthorBodyPs getAuthorBodyPs(ZonedDateTime authTime) {
		AuthorBodyPs author = new AuthorBodyPs();
		author.setTime(DateTimes.toDatetimeTs(authTime));
		author.setAssignedAuthor(getHl7CdaR2Pocdmt000040AssignedAuthor(author.getAssignedAuthor()));
		return author;
	}

}
