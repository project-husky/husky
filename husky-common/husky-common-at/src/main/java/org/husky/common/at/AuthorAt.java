/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.husky.common.at;

import org.husky.common.at.enums.AuthorRole;
import org.husky.common.at.enums.AuthorSpeciality;
import org.husky.common.basetypes.IdentificatorBaseType;
import org.husky.common.hl7cdar2.ON;
import org.husky.common.model.Author;
import org.husky.common.model.Name;
import org.husky.common.utils.XdsMetadataUtil;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AssigningAuthority;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Identifiable;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.XcnName;

/**
 * The Austrian derivation of an Author.
 */
public class AuthorAt extends Author {

	public ON getAuthorInstitution() {
		return super.getAuthorMdht().getAssignedAuthor().getRepresentedOrganization().getName().get(0);
	}

	public org.openehealth.ipf.commons.ihe.xds.core.metadata.Author getIpfAuthor() {
		org.openehealth.ipf.commons.ihe.xds.core.metadata.Author at = new org.openehealth.ipf.commons.ihe.xds.core.metadata.Author();

		org.openehealth.ipf.commons.ihe.xds.core.metadata.Person ap = new org.openehealth.ipf.commons.ihe.xds.core.metadata.Person();
		XcnName namePerson = new XcnName();

		if (getAsAuthor() != null && getAsAuthor().getAssignedAuthoringDevice() != null) {
			namePerson.setFamilyName(
					getAsAuthor().getAssignedAuthoringDevice().getManufacturerModelName().getDisplayName());
			namePerson.setGivenName(this.getAsAuthor().getAssignedAuthoringDevice().getSoftwareName().getDisplayName());

		} else {
			if (this.getIds() != null && !this.getIds().isEmpty() && this.getIds().get(0) != null) {
				ap.setId(XdsMetadataUtil.convertEhcIdentificator(this.getIds().get(0)));
			}

			if (this.getNames() != null) {
				// Name
				ap.setName(Name.getIpfXpnName(this.getName().getHl7CdaR2Pn()));
			}
		}

		ap.setName(namePerson);
		at.setAuthorPerson(ap);

		// Institution
		if (this.getOrganization() != null) {
			org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization inst = new org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization();
			if (this.getOrganization().getNameList() != null && !this.getOrganization().getNameList().isEmpty()
					&& this.getOrganization().getNameList().get(0) != null) {
				inst.setOrganizationName(this.getOrganization().getNameList().get(0).getFullName());
			}

			if (this.getOrganization().getIdentificatorList() != null) {
				for (IdentificatorBaseType id : this.getOrganization().getIdentificatorList()) {
					if (id != null && id.getExtension() != null) {
						inst.setIdNumber(id.getExtension());
					}

					if (id != null && id.getRoot() != null) {
						inst.setAssigningAuthority(new AssigningAuthority());
						inst.getAssigningAuthority().setUniversalId(id.getRoot());
						inst.getAssigningAuthority().setUniversalIdType("ISO");
					}
				}
			}

			at.getAuthorInstitution().add(inst);
		}

		if (this.getRoleFunction() != null) {
			at.getAuthorRole().add(new Identifiable(this.getRoleFunction().getDisplayName()));
		}

		if (this.getSpecialityEnum() != null && this.getSpecialityEnum().getCode() != null
				&& this.getSpecialityEnum().getCode().getDisplayName() != null) {
			at.getAuthorSpecialty().add(new Identifiable(this.getSpecialityEnum().getCode().getDisplayName()));
		}


		return at;
	}

	/**
	 * <div class="en">Gets the author time. The author/time element represents the
	 * start time of the author’s participation in the creation of the clinical
	 * document </div> <div class="de">Liefert die Zeit für den Autor. Diese gibt
	 * den Startzeitpunkt an, an dem der Autor bei der Erstellung des Dokument
	 * mitgewirkt hat.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 *
	 * @return date <div class="en">the start time of the participation as
	 *         string</div> <div class="de">den Startzeitpunkt der Partizipation als
	 *         String</div> <div class="fr"></div> <div class="it"></div>
	 */
	public String getTimeAsString() {
		if (getAuthorMdht().getTime() != null) {
			return getAuthorMdht().getTime().getValue();
		}
		return null;
	}


	/**
	 * Gets the author function code. This element specifies in which role or
	 * function the author is related to this document (e.g. Code "40001" for
	 * "Apotheker"). The code can also be used as author role, when a document is
	 * beeing sent (via XDS, XDM, XDR).
	 *
	 * @return code the function code
	 */
	public AuthorRole getRoleFunctionEnum() {
		return AuthorRole.getEnum(getAuthorMdht().getFunctionCode().getCode());
	}

	/**
	 * Sets the author speciality code. This element specifies the speciality
	 * ("Fachrichtung", e.g. "Fachärztin/Facharzt für Allgemeine Innere Medizin" )
	 * of the author. The code can also be used as author speciality, when a
	 * document is beeing sent (via XDS, XDM, XDR).
	 *
	 * @return code the speciality code
	 */
	public AuthorSpeciality getSpecialityEnum() {
		if (getAsAuthor() == null || getAsAuthor().getCode() == null || getAsAuthor().getCode().getCode() == null) {
			return null;
		}
		return AuthorSpeciality.getEnum(getAsAuthor().getCode().getCode());
	}

	/**
	 * Sets the author function code. This element specifies in which role or
	 * function the author is related to this document (e.g. Code "40001" for
	 * "Apotheker"). The code can also be used as author role, when a document is
	 * beeing sent (via XDS, XDM, XDR).
	 *
	 * @param code the function code
	 */
	public void setRoleFunction(AuthorRole code) {
		setFunctionCode(code.getCode());
	}

	/**
	 * Sets the author speciality code. This element specifies the speciality
	 * ("Fachrichtung", e.g. Code "50001" for "Fachärztin/Facharzt für Allgemeine
	 * Innere Medizin") of the author. The code can also be used as author
	 * speciality, when a document is beeing sent (via XDS, XDM, XDR).
	 *
	 * @param code the speciality code
	 */
	public void setSpeciality(AuthorSpeciality code) {
		getAsAuthor().setCode(code.getHl7cdar2CE());
		getAuthorMdht().getAssignedAuthor().getAssignedPerson().getName().add(getName().getHl7CdaR2Pn());
	}

}
