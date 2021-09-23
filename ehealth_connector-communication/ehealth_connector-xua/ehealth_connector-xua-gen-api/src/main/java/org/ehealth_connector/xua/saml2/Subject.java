/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.xua.saml2;

import java.util.List;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of Subject</div>
 * <div class="de">Interface welches die Methoden von Subject beschreibt</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 *
 */
public interface Subject {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the NameID.Value.</div>
	 * <div class="de">Methode um den NameID.Value zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the NameID.Format as {@link java.lang.String}</div>
	 * <div class="de">das NameID.Format als {@link java.lang.String}</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getNameIDFormat();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the NameID.NameQualifier.</div>
	 * <div class="de">Methode um den NameID.NameQualifier zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the NameID.NameQualifier as {@link java.lang.String}</div>
	 * <div class="de">den NameID.NameQualifier als {@link java.lang.String}</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getNameIDNameQualifier();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the NameID.Value.</div>
	 * <div class="de">Methode um den NameID.Value zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the NameID.Value as {@link java.lang.String}</div>
	 * <div class="de">den NameID.Value als {@link java.lang.String}</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getNameIDValue();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the SubjectConfirmations.</div>
	 * <div class="de">Methode um die SubjectConfirmationen zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">a {@link java.util.List} of {@link org.ehealth_connector.xua.saml2.SubjectConfirmation}s</div>
	 * <div class="de">eine {@link java.util.List} von {@link org.ehealth_connector.xua.saml2.SubjectConfirmation}s</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	List<SubjectConfirmation> getSubjectConfirmations();

}
