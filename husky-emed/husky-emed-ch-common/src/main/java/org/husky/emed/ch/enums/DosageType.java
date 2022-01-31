/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.enums;

import java.util.Objects;

/**
 * The different types of dosage structures supported by this module.
 *
 * @see <a href="https://www.ihe.net/uploadedFiles/Documents/PCC/IHE_PCC_TF_Vol2.pdf">IHE PCC 6.3.4.16.3</a>
 */
public enum DosageType {

	/** The Normal Dosing */
	NORMAL("1.3.6.1.4.1.19376.1.5.3.1.4.7.1"),

	/** The Split Dosing */
	SPLIT("1.3.6.1.4.1.19376.1.5.3.1.4.9");

	/**
	 * The template identifier.
	 */
	private final String templateId;

	/**
	 * Constructor.
	 *
	 * @param templateId The template identifier.
	 */
	DosageType(final String templateId) {
		this.templateId = Objects.requireNonNull(templateId);
	}

	/**
	 * Returns the template identifier.
	 */
	public String getTemplateId() {
		return this.templateId;
	}
}
