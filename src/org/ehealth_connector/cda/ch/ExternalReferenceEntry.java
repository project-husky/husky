/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.cda.ch;

import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

/**
 * ExternalDocumentEntry implements the relationship for holding an External
 * Document Entry to the immunization recommendation in switzerland, see chapter
 * 7.5.8.5 Spezifikation CDA Body Level 3 – Immunization Recommendation Entry
 * CDA-CH-VACD, entryRelationship, guidelines
 */
public class ExternalReferenceEntry
		extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ch.CDACHBodyExtRef> {

	/**
	 * Instantiates a new external reference entry.
	 */
	public ExternalReferenceEntry() {
		super(CHFactory.eINSTANCE.createCDACHBodyExtRef().init(), "2.16.756.5.30.1.1.1.1.1",
				"CDA-CH.Body.ExtRef");
	}

	/**
	 * Instantiates a new external reference entry.
	 */
	protected ExternalReferenceEntry(
			org.openhealthtools.mdht.uml.cda.ch.CDACHBodyExtRef externalReference) {
		super(externalReference);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ExternalReferenceEntry)) {
			return false;
		}
		ExternalReferenceEntry other = (ExternalReferenceEntry) obj;

		ExternalDocumentEntry documentEntry = getExternalDocumentEntry();
		if ((documentEntry != null && !documentEntry.equals(other.getExternalDocumentEntry()))
				|| (documentEntry == null && other.getExternalDocumentEntry() != null)) {
			return false;
		}

		return true;
	}

	/**
	 * Gets the external document entry.
	 *
	 * @return the external document entry
	 */
	public ExternalDocumentEntry getExternalDocumentEntry() {
		if (this.getMdht().getExternalDocument() != null) {
			return new ExternalDocumentEntry(getMdht().getExternalDocument());
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + (this.getExternalDocumentEntry() != null
				? this.getExternalDocumentEntry().hashCode() : 0);

		return result;
	}

	/**
	 * Sets the external document entry.
	 *
	 * @param externalDocumentEntry
	 *            the new external document entry
	 */
	public void setExternalDocumentEntry(ExternalDocumentEntry externalDocumentEntry) {
		this.getMdht().setExternalDocument(externalDocumentEntry.getMdht());
	}

}
