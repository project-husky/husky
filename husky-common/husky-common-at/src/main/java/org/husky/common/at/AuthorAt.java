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
import org.husky.common.model.Organization;
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

	public static org.openehealth.ipf.commons.ihe.xds.core.metadata.Author getIpfAuthor(Author author) {
		org.openehealth.ipf.commons.ihe.xds.core.metadata.Author at = new org.openehealth.ipf.commons.ihe.xds.core.metadata.Author();

		org.openehealth.ipf.commons.ihe.xds.core.metadata.Person ap = new org.openehealth.ipf.commons.ihe.xds.core.metadata.Person();
		XcnName namePerson = new XcnName();

		if (author.getAsAuthor() != null && author.getAsAuthor().getAssignedAuthoringDevice() != null) {
			namePerson.setFamilyName(
					author.getAsAuthor().getAssignedAuthoringDevice().getManufacturerModelName().getDisplayName());
			namePerson
					.setGivenName(author.getAsAuthor().getAssignedAuthoringDevice().getSoftwareName().getDisplayName());

		} else {
			if (author.getIds() != null && !author.getIds().isEmpty() && author.getIds().get(0) != null) {
				ap.setId(XdsMetadataUtil.convertEhcIdentificator(author.getIds().get(0)));
			}

			if (author.getNames() != null) {
				// Name
				ap.setName(Name.getIpfXpnName(author.getName().getHl7CdaR2Pn()));
			}
		}

		ap.setName(namePerson);
		at.setAuthorPerson(ap);

		// Institution
		if (author.getOrganization() != null) {
			at.getAuthorInstitution().add(getIpfOrganization(author.getOrganization()));
		}

		if (author.getRoleFunction() != null) {
			at.getAuthorRole().add(new Identifiable(author.getRoleFunction().getDisplayName()));
		}

		if (author.getSpeciality() != null && author.getSpeciality().getCode() != null
				&& author.getSpeciality().getDisplayName() != null) {
			at.getAuthorSpecialty().add(new Identifiable(author.getSpeciality().getDisplayName()));
		}


		return at;
	}

	private static org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization getIpfOrganization(Organization org) {
		org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization inst = new org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization();
		if (org.getNameList() != null && !org.getNameList().isEmpty() && org.getNameList().get(0) != null) {
			inst.setOrganizationName(org.getNameList().get(0).getFullName());
		}

		if (org.getIdentificatorList() != null) {
			for (IdentificatorBaseType id : org.getIdentificatorList()) {
				if (id != null && id.getExtension() != null) {
					inst.setIdNumber(id.getExtension());
				}

				if (id != null && id.getRoot() != null) {
					var assigningAuthority = new AssigningAuthority();
					assigningAuthority.setUniversalId(id.getRoot());
					assigningAuthority.setUniversalIdType("ISO");
					inst.setAssigningAuthority(assigningAuthority);
				}
			}
		}

		return inst;
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
