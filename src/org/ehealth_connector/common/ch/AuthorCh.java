package org.ehealth_connector.common.ch;

import org.ehealth_connector.common.Name;
import org.ehealth_connector.communication.ch.enums.AuthorRole;
import org.ehealth_connector.communication.ch.enums.AuthorSpeciality;
import org.openhealthtools.ihe.xds.metadata.AuthorType;

public class AuthorCh extends org.ehealth_connector.common.Author {

	public AuthorCh() {
		super();
	}

	/**
	 * <div class="en">Instantiates a new author.</div> <div
	 * class="de">Instantiiert a neuen Autor</div> <div class="fr"></div> <div
	 * class="it"></div>
	 * 
	 * @param iAuthor
	 * <br>
	 *            <div class="de">IHE Author-Objekt</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public AuthorCh(AuthorType iAuthor) {
		super(iAuthor);
	}

	public AuthorCh(Name name) {
		super(name);
	}

	/**
	 * Erstellt einen neuen Autor (Dieser Konstruktor wird oft gebraucht für
	 * Behandelnde).
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
	 * Erstellt ein eHealthconnector-Author Objekt mittels eines MDHT-Author
	 * Objekts.
	 * 
	 * @param authorMdht
	 *            the MDHT Author Object
	 */
	public AuthorCh(org.openhealthtools.mdht.uml.cda.Author authorMdht) {
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
		return AuthorRole.getEnum(mAuthor.getFunctionCode().getCode());
	}

	/**
	 * Sets the author speciality code. This element specifies the speciality
	 * ("Fachrichtung", e.g.
	 * "Fachärztin/Facharzt für Allgemeine Innere Medizin") of the author. The
	 * code can also be used as author speciality, when a document is beeing
	 * sent (via XDS, XDM, XDR).
	 * 
	 * @return code the speciality code
	 */
	public AuthorSpeciality getSpecialityEnum() {
		return AuthorSpeciality.getEnum(mAsAuthor.getCode().getCode());
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
		mAuthor.setFunctionCode(code.getCode().getCE());
	}

	/**
	 * Sets the author speciality code. This element specifies the speciality
	 * ("Fachrichtung", e.g. Code "50001" for
	 * "Fachärztin/Facharzt für Allgemeine Innere Medizin") of the author. The
	 * code can also be used as author speciality, when a document is beeing
	 * sent (via XDS, XDM, XDR).
	 * 
	 * @param code
	 *            the speciality code
	 */
	public void setSpeciality(AuthorSpeciality code) {
		mAsAuthor.setCode(code.getCode().getCE());
	}
}
