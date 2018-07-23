/*
 *
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
package org.ehealth_connector.cda;

import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.Reference;

/**
 * ExternalDocumentEntry implements the relationship for holding an External
 * Document Entry
 */
public abstract class AbstractExternalReferenceEntry
		extends MdhtFacade<org.openhealthtools.mdht.uml.cda.Reference> {

	/**
	 * Default constructor to instanciate the object
	 */
	public AbstractExternalReferenceEntry() {
		super(CDAFactory.eINSTANCE.createReference());
	}

	/**
	 *
	 * Default constructor to instanciate the object
	 *
	 * @param mdht
	 *            the mdht
	 */
	public AbstractExternalReferenceEntry(Reference mdht) {
		super(mdht);
	}

	/**
	 * Default constructor to instanciate the object
	 *
	 * @param mdht
	 *            the mdht
	 * @param templateIdRoot
	 *            the id root
	 * @param templateIdExtension
	 *            the id extension
	 */
	public AbstractExternalReferenceEntry(Reference mdht, String templateIdRoot,
			String templateIdExtension) {
		super(mdht, templateIdRoot, templateIdExtension);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AbstractExternalReferenceEntry)) {
			return false;
		}
		final AbstractExternalReferenceEntry other = (AbstractExternalReferenceEntry) obj;

		final ExternalDocumentEntry documentEntry = getExternalDocumentEntry();
		if (((documentEntry != null) && !documentEntry.equals(other.getExternalDocumentEntry()))
				|| ((documentEntry == null) && (other.getExternalDocumentEntry() != null))) {
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

		result = (prime * result) + (this.getExternalDocumentEntry() != null
				? this.getExternalDocumentEntry().hashCode()
				: 0);

		return result;
	}

	/**
	 * Sets the external document entry.
	 *
	 * @param externalDocumentEntry
	 *            the new external document entry
	 */
	public void setExternalDocumentEntry(ExternalDocumentEntry externalDocumentEntry) {
		if (externalDocumentEntry != null) {
			this.getMdht().setExternalDocument(externalDocumentEntry.getMdht());
		}
	}

}
