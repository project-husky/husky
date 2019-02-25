/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.common.basetypes;

// TODO: Auto-generated Javadoc
/**
 * Java Prototype for Value Set Management Concept.
 *
 * An identifier that uniquely identifies a thing or object. Examples are object
 * identifier for HL7 RIM objects, medical record number, order id, service
 * catalog item id, Vehicle Identification Number (VIN), etc. Instance
 * identifiers are defined based on ISO object identifiers.
 *
 */
public interface IdentificatorBaseType {

	/**
	 * Gets the assigning authority name.
	 *
	 * @return the assigning authority name
	 */
	public String getAssigningAuthorityName();

	/**
	 * Gets the extension.
	 *
	 * @return the extension
	 */
	public String getExtension();

	/**
	 * Gets the root.
	 *
	 * @return the root
	 */
	public String getRoot();

	/**
	 * Sets the assigning authority name. A human readable name or mnemonic for
	 * the assigning authority. This name may be provided solely for the
	 * convenience of unaided humans interpreting an II value and can have no
	 * computational meaning. Note: no automated processing must depend on the
	 * assigning authority name to be present in any form.
	 *
	 * @param name
	 *            the new assigning authority name
	 */
	public void setAssigningAuthorityName(String value);

	/**
	 * Sets the displayable. Specifies if the identifier is intended for human
	 * display and data entry (displayable = true) as opposed to pure machine
	 * interoperation (displayable = false).
	 *
	 * @param displayable
	 *            the new displayable
	 */
	public void setDisplayable(boolean value);
	public boolean getDisplayable();

	/**
	 * Sets the extension. A character string as a unique identifier within the
	 * scope of the identifier root.
	 *
	 * @param extension
	 *            the new extension
	 */
	public void setExtension(String value);

	/**
	 * Sets the root. A unique identifier that guarantees the global uniqueness
	 * of the instance identifier. The root alone may be the entire instance
	 * identifier.
	 *
	 * @param root
	 *            the new root
	 */
	public void setRoot(String value);

}
