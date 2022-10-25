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

package org.projecthusky.xua.hl7v3;

/**
 *
 */
public interface CE {
	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the code.</div>
	 * <div class="de">Methode um den code zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">The Code.</div>
	 * <div class="de">Der Code.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public String getCode();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the CodeSystem.</div>
	 * <div class="de">Methode um das CodeSystem zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">The CodeSystem.</div>
	 * <div class="de">Das CodeSystem.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public String getCodeSystem();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the CodeSystemName.</div>
	 * <div class="de">Methode um den CodeSystemName zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">The CodeSystemName.</div>
	 * <div class="de">Der CodeSystemName.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public String getCodeSystemName();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the CodeSystemVersion.</div>
	 * <div class="de">Methode um die CodeSystemVersion zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">The CodeSystemVersion.</div>
	 * <div class="de">Die CodeSystemVersion.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public String getCodeSystemVersion();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the DisplayName.</div>
	 * <div class="de">Methode um den DisplayName zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">The DisplayName.</div>
	 * <div class="de">Der DisplayName.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public String getDisplayName();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the Code.</div>
	 * <div class="de">Methode um den Code zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param value
	 * <div class="en">The value to be set as Code.</div>
	 * <div class="de">Der Wert der als Code gesetzt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public void setCode(String value);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the CodeSystem.</div>
	 * <div class="de">Methode um das CodeSystem zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param value
	 * <div class="en">The value to be set as CodeSystem.</div>
	 * <div class="de">Der Wert der als CodeSystem gesetzt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public void setCodeSystem(String value);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the CodeSystemName.</div>
	 * <div class="de">Methode um den CodeSystemName zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param value
	 * <div class="en">The value to be set as CodeSystemName.</div>
	 * <div class="de">Der Wert der als CodeSystemName gesetzt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public void setCodeSystemName(String value);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the CodeSystemVersion.</div>
	 * <div class="de">Methode um die CodeSystemVersion zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param value
	 * <div class="en">The value to be set as CodeSystemVersion.</div>
	 * <div class="de">Der Wert der als CodeSystemVersion gesetzt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public void setCodeSystemVersion(String value);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the DisplayName.</div>
	 * <div class="de">Methode um den DisplayName zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param value
	 * <div class="en">The value to be set as DisplayName.</div>
	 * <div class="de">Der Wert der als DisplayName gesetzt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public void setDisplayName(String value);
}
