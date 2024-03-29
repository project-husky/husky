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
package org.projecthusky.xua.saml2;

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
	 * <div class="en">a {@link java.util.List} of {@link org.projecthusky.xua.saml2.SubjectConfirmation}s</div>
	 * <div class="de">eine {@link java.util.List} von {@link org.projecthusky.xua.saml2.SubjectConfirmation}s</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	List<SubjectConfirmation> getSubjectConfirmations();

}
