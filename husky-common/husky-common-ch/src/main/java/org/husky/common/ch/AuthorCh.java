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
package org.husky.common.ch;

import org.husky.common.ch.enums.AuthorRole;
import org.husky.common.ch.enums.AuthorSpeciality;
import org.husky.common.hl7cdar2.POCDMT000040Author;
import org.husky.common.model.Author;
import org.husky.common.model.Name;

/**
 * The Swis derivation of an Author (adds features for GLN).
 */
public class AuthorCh extends org.husky.common.model.Author {

	/**
	 * Instantiates a new instance.
	 */
	public AuthorCh() {
		super();
	}

	/**
	 * Default constructor to instantiate the object.
	 *
	 * @param aAuthor
	 *            the generic author
	 */
	public AuthorCh(Author aAuthor) {
		super(aAuthor.getAuthorMdht());
	}

	/**
	 * Instantiates a new instance.
	 *
	 * @param name
	 *            the name
	 */
	public AuthorCh(Name name) {
		super(name);
	}

	/**
	 * Instantiates a new instance.
	 *
	 * @param name
	 *            Name
	 * @param gln
	 *            Global Location Number (GLN)
	 */
	public AuthorCh(Name name, String gln) {
		super(name, gln);
	}

	/**
	 * Instantiates a new instance.
	 *
	 * @param authorMdht
	 *            the MDHT Author Object
	 */
	public AuthorCh(POCDMT000040Author authorMdht) {
		super(authorMdht);
	}

	/**
	 * Gets the author function code. This element specifies in which role or
	 * function the author is related to this document (e.g. Code "40001" for
	 * "Apotheker"). The code can also be used as author role, when a document
	 * is beeing sent (via XDS, XDM, XDR).
	 *
	 * @return code the function code
	 */
	public AuthorRole getRoleFunctionEnum() {
		return AuthorRole.getEnum(getAuthorMdht().getFunctionCode().getCode());
	}

	/**
	 * Sets the author speciality code. This element specifies the speciality
	 * ("Fachrichtung", e.g. "Fachärztin/Facharzt für Allgemeine Innere Medizin"
	 * ) of the author. The code can also be used as author speciality, when a
	 * document is beeing sent (via XDS, XDM, XDR).
	 *
	 * @return code the speciality code
	 */
	public AuthorSpeciality getSpecialityEnum() {
		return AuthorSpeciality.getEnum(getAsAuthor().getCode().getCode());
	}

	/**
	 * Sets the author function code. This element specifies in which role or
	 * function the author is related to this document (e.g. Code "40001" for
	 * "Apotheker"). The code can also be used as author role, when a document
	 * is beeing sent (via XDS, XDM, XDR).
	 *
	 * @param code
	 *            the function code
	 */
	public void setRoleFunction(AuthorRole code) {
		getAuthorMdht().setFunctionCode(code.getCode().getHl7CdaR2Ce());
	}

	/**
	 * Sets the author speciality code. This element specifies the speciality
	 * ("Fachrichtung", e.g. Code "50001" for "Fachärztin/Facharzt für
	 * Allgemeine Innere Medizin") of the author. The code can also be used as
	 * author speciality, when a document is beeing sent (via XDS, XDM, XDR).
	 *
	 * @param code
	 *            the speciality code
	 */
	public void setSpeciality(AuthorSpeciality code) {
		getAsAuthor().setCode(code.getCode().getHl7CdaR2Ce());
	}
}
