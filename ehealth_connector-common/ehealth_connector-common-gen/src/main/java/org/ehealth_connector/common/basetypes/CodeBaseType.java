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

import java.util.List;

import org.ehealth_connector.common.utils.LangText;

/**
 * Java Prototype for Value Set Management Concept.
 *
 * A concept descriptor represents any kind of concept usually by giving a code
 * defined in a code system. A concept descriptor can contain the original text
 * or phrase that served as the basis of the coding and one or more translations
 * into different coding systems. A concept descriptor can also contain
 * qualifiers to describe, e.g., the concept of a "left foot" as a
 * postcoordinated term built from the primary code "FOOT" and the qualifier
 * "LEFT". In exceptional cases, the concept descriptor need not contain a code
 * but only the original text describing that concept.
 *
 */
public interface CodeBaseType {

	/**
	 * Adds the code translation.
	 *
	 * A set of other concept descriptors that translate this concept descriptor
	 * into other code systems.
	 *
	 * @param code
	 *            the code
	 */
	public void addCodeTranslation(CodeBaseType value);

	public void addDisplayNameTranslation(LangText value);

	public String getCode();

	public String getCodeSystem();

	public String getCodeSystemName();

	public String getDisplayName();

	public String getOriginalText();

	public List<CodeBaseType> listCodeTranslations();

	public List<LangText> listDisplayNameTranslations();

	/**
	 * Sets the code.
	 *
	 * The plain code symbol defined by the code system. For example, "784.0" is
	 * the code symbol of the ICD-9 code "784.0" for headache.
	 *
	 * @param code
	 *            the new code
	 */
	public void setCode(String value);

	/**
	 * Sets the code system.
	 *
	 * Specifies the code system that defines the code.
	 *
	 * @param codeSystem
	 *            the new code system
	 */
	public void setCodeSystem(String value);

	/**
	 * Sets the code system name.
	 *
	 * A common name of the coding system.
	 *
	 * @param codeSystemName
	 *            the new code system name
	 */
	public void setCodeSystemName(String value);

	/**
	 * Sets the display name.
	 *
	 * A name or title for the code, under which the sending system shows the
	 * code value to its users.
	 *
	 * @param displayName
	 *            the new display name
	 */
	public void setDisplayName(String value);

	/**
	 * Sets the original text.
	 *
	 * The text or phrase used as the basis for the coding.
	 *
	 * @param originalText
	 *            the new original text
	 */
	public void setOriginalText(String value);

	/*
	 * Im Schema steht noch:
	 *
	 * qualifier: Specifies additional codes that increase the specificity of
	 * the primary code.
	 *
	 * codeSystemVersion: If applicable, a version descriptor defined
	 * specifically for the given code system.
	 */

}
