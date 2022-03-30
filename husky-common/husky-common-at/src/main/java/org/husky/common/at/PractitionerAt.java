/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.husky.common.at;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.husky.common.basetypes.AddressBaseType;
import org.husky.common.enums.NullFlavor;
import org.husky.common.hl7cdar2.AD;
import org.husky.common.hl7cdar2.CE;
import org.husky.common.hl7cdar2.EntityClassDevice;
import org.husky.common.hl7cdar2.II;
import org.husky.common.hl7cdar2.IVLTS;
import org.husky.common.hl7cdar2.PN;
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
import org.husky.common.hl7cdar2.TEL;
import org.husky.common.model.Address;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;
import org.husky.common.model.Name;
import org.husky.common.model.Telecom;
import org.husky.common.utils.time.DateTimes;

public class PractitionerAt {

	private static final String INSTANCE = "INSTANCE";
	private List<Identificator> identifiers;
	private OrganizationAt organization;
	private List<Telecom> telecoms;
	private List<Name> names;
	private List<Address> addresses;
	private Code code;
	private Code speciality;
	private String softwareName;
	private String modelNameOfDevice;

	public PractitionerAt() {
		this.identifiers = new ArrayList<>();
		this.telecoms = new ArrayList<>();
		this.names = new ArrayList<>();
	}

	public PractitionerAt(POCDMT000040Author author) {
		if (author != null && author.getAssignedAuthor() != null) {

			setNames(author.getAssignedAuthor().getAssignedPerson());

			setIdentifiers(author.getAssignedAuthor().getId());

			if (author.getAssignedAuthor().getAssignedPerson() != null
					&& author.getAssignedAuthor().getRepresentedOrganization() != null) {
				this.organization = new OrganizationAt(author.getAssignedAuthor().getRepresentedOrganization());
			}

			if (author.getAssignedAuthor().getCode() != null) {
				this.code = new Code(author.getAssignedAuthor().getCode());
			}

			setTelecoms(author.getAssignedAuthor().getTelecom());
		}
	}

	public PractitionerAt(POCDMT000040LegalAuthenticator authenticator) {
		if (authenticator != null && authenticator.getAssignedEntity() != null) {

			setIdentifiers(authenticator.getAssignedEntity().getId());

			setNames(authenticator.getAssignedEntity().getAssignedPerson());

			if (authenticator.getAssignedEntity().getAssignedPerson() != null
					&& authenticator.getAssignedEntity().getRepresentedOrganization() != null) {
				this.organization = new OrganizationAt(authenticator.getAssignedEntity().getRepresentedOrganization());
			}

			if (authenticator.getAssignedEntity().getCode() != null) {
				this.code = new Code(authenticator.getAssignedEntity().getCode());
			}

			setTelecoms(authenticator.getAssignedEntity().getTelecom());

			if (authenticator.getSignatureCode() != null) {
				this.speciality = new Code(authenticator.getSignatureCode());
			}
		}
	}

	public List<Identificator> getIdentifier() {
		return identifiers;
	}

	public void setIdentifier(List<Identificator> identifier) {
		this.identifiers = identifier;
	}

	public void setIdentifiers(List<II> ids) {
		this.identifiers = new ArrayList<>();
		for (II id : ids) {
			this.identifiers.add(new Identificator(id));
		}
	}

	public OrganizationAt getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationAt organization) {
		this.organization = organization;
	}

	public List<Telecom> getTelecom() {
		return telecoms;
	}

	public void setTelecom(List<Telecom> telecom) {
		this.telecoms = telecom;
	}

	public void setTelecoms(List<TEL> tels) {
		this.telecoms = new ArrayList<>();
		for (TEL tel : tels) {
			this.telecoms.add(new Telecom(tel));
		}
	}

	public List<Name> getNames() {
		return names;
	}

	public void setNames(List<Name> names) {
		this.names = names;
	}

	public void setNames(POCDMT000040Person person) {
		if (person != null) {
			for (PN pn : person.getName()) {
				if (pn != null) {
					this.names.add(new Name(pn));
				}
			}
		}
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	public Code getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Code speciality) {
		this.speciality = speciality;
	}

	public String getSoftwareName() {
		return softwareName;
	}

	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}

	public String getModelNameOfDevice() {
		return modelNameOfDevice;
	}

	public void setModelNameOfDevice(String modelNameOfDevice) {
		this.modelNameOfDevice = modelNameOfDevice;
	}

	protected POCDMT000040AssociatedEntity getHl7CdaR2Pocdmt000040AssociatedEntity() {
		POCDMT000040AssociatedEntity associatedEntity = new POCDMT000040AssociatedEntity();

		if (this.identifiers != null && !identifiers.isEmpty()) {
			associatedEntity.getId().addAll(getIis());
		}

		if (this.addresses != null && !this.addresses.isEmpty()) {
			associatedEntity.getAddr().addAll(getAds());
		}

		if (this.telecoms != null && !this.telecoms.isEmpty()) {
			associatedEntity.getTelecom().addAll(getTels());
		}

		if (this.organization != null) {
			associatedEntity.setScopingOrganization(this.organization.getHl7CdaR2Pocdmt000040Organization());
		}

		if (this.names != null) {
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
		device.setDeterminerCode(INSTANCE);
		device.setManufacturerModelName(new SC(modelNameOfDevice));
		device.setSoftwareName(new SC(softwareName));
		return device;
	}

	protected POCDMT000040AssignedAuthor getHl7CdaR2Pocdmt000040AssignedAuthor(
			POCDMT000040AssignedAuthor assignedAuthor) {

		if (this.organization != null) {
			POCDMT000040Organization representedOrganization = assignedAuthor.getRepresentedOrganization();

			if (representedOrganization == null) {
				representedOrganization = new POCDMT000040Organization();
				representedOrganization.setClassCode("ORG");
				representedOrganization.setDeterminerCode(INSTANCE);
			}

			assignedAuthor.setRepresentedOrganization(
					this.organization.getHl7CdaR2Pocdmt000040Organization(representedOrganization));
		}

		if (this.identifiers != null && !this.identifiers.isEmpty()) {
			assignedAuthor.getId().addAll(getIis());
		}

		if (this.telecoms != null && !this.telecoms.isEmpty()) {
			assignedAuthor.getTelecom().addAll(getTels());
		}

		if (this.addresses != null) {
			assignedAuthor.getAddr().addAll(getAds());
		}

		if (this.names != null) {
			assignedAuthor.setAssignedPerson(getHl7CdaR2Pocdmt000040Person(assignedAuthor.getAssignedPerson()));
		}

		if (this.speciality != null) {
			assignedAuthor.setCode(this.speciality.getHl7CdaR2Ce());
		}

		if (this.softwareName != null && this.modelNameOfDevice != null) {
			assignedAuthor.setAssignedAuthoringDevice(getAtcdabbrOtherDeviceCompilation());
		}

		return assignedAuthor;
	}

	protected POCDMT000040AssignedEntity getHl7CdaR2Pocdmt000040AssignedEntity(
			POCDMT000040AssignedEntity assignedEntity) {
		if (assignedEntity == null) {
			return assignedEntity;
		}

		if (this.identifiers != null && !identifiers.isEmpty()) {
			assignedEntity.getId().addAll(getIis());
		}

		if (this.code != null) {
			assignedEntity.setCode(this.code.getHl7CdaR2Ce());
		} else {
			CE codeCE = new CE();
			codeCE.nullFlavor = new ArrayList<>();
			codeCE.nullFlavor.add("UNK");
			assignedEntity.setCode(codeCE);
		}

		if (this.telecoms != null && !this.telecoms.isEmpty()) {
			assignedEntity.getTelecom().addAll(getTels());
		}

		if (this.organization != null) {
			assignedEntity.setRepresentedOrganization(this.organization.getHl7CdaR2Pocdmt000040Organization());
		}

		if (this.names != null) {
			assignedEntity.setAssignedPerson(
					getHl7CdaR2Pocdmt000040Person(assignedEntity.getAssignedPerson()));
		}

		return assignedEntity;
	}

	protected POCDMT000040Person getHl7CdaR2Pocdmt000040Person(POCDMT000040Person person) {
		if (person == null) {
			person = new POCDMT000040Person();
		}

		if (this.names != null) {
			for (Name nam : this.names) {
				if (nam != null) {
					person.getName().add(nam.getHl7CdaR2Pn());
				}
			}

			if (person.getClassCode().isEmpty()) {
				person.getClassCode().add("PSN");
			}
			person.setDeterminerCode(INSTANCE);
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

		if (this.identifiers != null) {
			assignedEntity.getId().addAll(getIis());
		}

		if (this.names != null) {
			assignedEntity.setAssignedPerson(createPerson(new POCDMT000040Person()));
		}

		if (this.organization != null) {
			POCDMT000040Organization legalAuthenOrg = new POCDMT000040Organization();
			legalAuthenOrg.setClassCode("ORG");
			legalAuthenOrg.setDeterminerCode(INSTANCE);
			legalAuthenOrg = this.organization.getHl7CdaR2Pocdmt000040Organization(legalAuthenOrg);
			assignedEntity.setRepresentedOrganization(legalAuthenOrg);
		}

		return assignedEntity;
	}

	protected POCDMT000040Person createPerson(POCDMT000040Person person) {
		if (person == null) {
			person = new POCDMT000040Person();
		}

		if (names != null) {
			for (Name nam : names) {
				if (nam != null) {
					person.getName().add(nam.getHl7CdaR2Pn());
				}
			}
		}

		if (person.getClassCode().isEmpty()) {
			person.getClassCode().add("PSN");
		}
		person.setDeterminerCode(INSTANCE);
		return person;
	}

	public String getGdaIndex() {
		if (identifiers == null) {
			return null;
		}

		Optional<Identificator> optionalId = identifiers.stream()
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

		if (this.identifiers == null || this.identifiers.isEmpty()) {
			Identificator niId = new Identificator();
			niId.setNullFlavor(NullFlavor.NOINFORMATION);
			assignedEntity.getId().add(niId.getHl7CdaR2Ii());
		} else {
			assignedEntity.getId().addAll(getIis());
		}

		if (this.addresses != null && !this.addresses.isEmpty()) {
			assignedEntity.getAddr().clear();
			assignedEntity.getAddr().addAll(getAds());
		}

		if (this.names != null && !this.names.isEmpty()) {
			assignedEntity.setAssignedPerson(getHl7CdaR2Pocdmt000040Person(assignedEntity.getAssignedPerson()));
		}

		if (telecoms != null && !telecoms.isEmpty()) {
			assignedEntity.getTelecom().addAll(getTels());
		}

		if (organization != null) {
			assignedEntity.setRepresentedOrganization(organization.getHl7CdaR2Pocdmt000040Organization());
		}

		responsibleParty.setAssignedEntity(assignedEntity);

		return responsibleParty;
	}

	protected List<AD> getAds() {
		List<AD> ads = new LinkedList<>();
		for (Address address : this.addresses) {
			if (address != null) {
				ads.add(address.getHl7CdaR2Ad());
			} else {
				Address addressUnk = new Address(new AddressBaseType());
				addressUnk.setNullFlavor(NullFlavor.UNKNOWN);
				ads.add(addressUnk.getHl7CdaR2Ad());
			}
		}

		return ads;
	}

	protected List<II> getIis() {
		List<II> iis = new LinkedList<>();
		for (Identificator id : this.identifiers) {
			if (id != null) {
				iis.add(id.getHl7CdaR2Ii());
			} else {
				Identificator unkId = new Identificator();
				unkId.setNullFlavor(NullFlavor.UNKNOWN);
				iis.add(unkId.getHl7CdaR2Ii());
			}
		}

		return iis;
	}

	protected List<TEL> getTels() {
		List<TEL> tels = new LinkedList<>();
		for (Telecom tel : this.telecoms) {
			if (tel != null) {
				tels.add(tel.getHl7CdaR2Tel());
			}
		}

		return tels;

	}

}
