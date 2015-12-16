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

import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClassDocument;
import org.openhealthtools.mdht.uml.hl7.vocab.ActMood;

/**
 * ExternalDocumentEntry implements the External Document Entry for providing
 * the reference to the immunization recommendation in switzerland, see chapter
 * 7.5.8.7 CDA-CH-VACD
 */
public class ExternalDocumentEntry
		extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ExternalDocument> {

	/**
	 * Instantiates a new criterion entry.
	 */
	public ExternalDocumentEntry() {
		super(CDAFactory.eINSTANCE.createExternalDocument());
		this.getMdht().getTemplateIds()
				.add(DatatypesFactory.eINSTANCE.createII("2.16.840.1.113883.10.20.1.36"));
		this.getMdht().setClassCode(ActClassDocument.DOC);
		this.getMdht().setMoodCode(ActMood.EVN);

	}

	/**
	 * Instantiates a new criterion entry.
	 */
	protected ExternalDocumentEntry(
			org.openhealthtools.mdht.uml.cda.ExternalDocument externalReference) {
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
		if (!(obj instanceof ExternalDocumentEntry)) {
			return false;
		}
		final ExternalDocumentEntry other = (ExternalDocumentEntry) obj;

		final Identificator id = this.getId();
		if (((id != null) && !id.equals(other.getId()))
				|| ((id == null) && (other.getId() != null))) {
			return false;
		}

		final String reference = this.getReferenceUrl();
		if (((reference != null) && !reference.equals(other.getReferenceUrl()))
				|| ((reference == null) && (other.getReferenceUrl() != null))) {
			return false;
		}

		return true;
	}

	/**
	 * one id can be provided
	 * 
	 * @return the id
	 */
	public Identificator getId() {
		Identificator id = null;
		if ((getMdht().getIds() != null) && (getMdht().getIds().size() > 0)) {
			id = new Identificator(getMdht().getIds().get(0));
		}
		return id;
	}

	/**
	 * Gets the narrative text for the reference.
	 * 
	 * @return the narrative text for the reference.
	 */
	public String getReferenceNarrativeText() {
		if ((this.getMdht().getText() != null) && (this.getMdht().getText().getText() != null)) {
			return this.getMdht().getText().getText();
		}
		return null;
	}

	/**
	 * Gets the url for the reference.
	 * 
	 * @return the url for the reference
	 */
	public String getReferenceUrl() {
		if ((this.getMdht().getText() != null)
				&& (this.getMdht().getText().getReference() != null)) {
			return this.getMdht().getText().getReference().getValue();
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + (this.getId() != null ? this.getId().hashCode() : 0);
		result = (prime * result)
				+ (this.getReferenceUrl() != null ? this.getReferenceUrl().hashCode() : 0);
		return result;
	}

	/**
	 * one id can be provided
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(Identificator id) {
		this.getMdht().getIds().clear();
		if (id != null) {
			this.getMdht().getIds().add(id.getIi());
		}
	}

	/**
	 * Sets the text reference.
	 * 
	 * @param value
	 *            the new text reference, # for local reference has to be
	 *            included
	 * 
	 * @param narrativeText
	 *            the narrative Text to be used for the link in the CDA body
	 *            level 1 text generation
	 */
	public void setReference(String value, String narrativeText) {
		this.getMdht().setText(Util.createReference(value, narrativeText));
	}

}
