/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
package org.husky.xua.saml2;

import org.husky.xua.hl7v3.InstanceIdentifier;
import org.husky.xua.hl7v3.PurposeOfUse;
import org.husky.xua.hl7v3.Role;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of Attribute. </div>
 * <div class="de">Interface welches die Methoden von Attribute beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface Attribute {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the FriendlyName.</div>
	 * <div class="de">Methode um das FriendlyName zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the FriendlyName as {@link java.lang.String}</div>
	 * <div class="de">der FriendlyName als {@link java.lang.String}</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getFriendlyName();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the name.</div>
	 * <div class="de">Methode um den Namen zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the name as {@link java.lang.String}</div>
	 * <div class="de">der Name als {@link java.lang.String}</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getName();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the NameFormat.</div>
	 * <div class="de">Methode um das NameFormat zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the Value as {@link java.lang.String}</div>
	 * <div class="de">der Value als {@link java.lang.String}</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getNameFormat();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the NameFormat.</div>
	 * <div class="de">Methode um das NameFormat zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the Value as {org.husky.xua.hl7v3.InstanceIdentifier}</div>
	 * <div class="de">der Value als {org.husky.xua.hl7v3.InstanceIdentifier}</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	InstanceIdentifier getValueAsInstanceIdentifier();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the NameFormat.</div>
	 * <div class="de">Methode um das NameFormat zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the Value as {org.husky.xua.hl7v3.PurposeOfUse}</div>
	 * <div class="de">der Value als {org.husky.xua.hl7v3.PurposeOfUse}</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	PurposeOfUse getValueAsPurposeOfUse();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the NameFormat.</div>
	 * <div class="de">Methode um das NameFormat zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the Value as {org.husky.xua.hl7v3.Role}</div>
	 * <div class="de">der Value als {org.husky.xua.hl7v3.Role}</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	Role getValueAsRole();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the value.</div>
	 * <div class="de">Methode um das value zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the value as {@link java.lang.String}</div>
	 * <div class="de">der value als {@link java.lang.String}</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getValueAsString();

	boolean isValueAInstanceIdentifier();

	boolean isValueAPurposeOfUse();

	boolean isValueARole();

	boolean isValueAString();

}
