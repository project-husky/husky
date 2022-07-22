/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.husky.cda.elga.models;

import org.husky.cda.elga.generated.artdecor.AtcdabbrEntryEingebettetesObjektEntry;
import org.husky.cda.elga.generated.artdecor.AtcdabbrEntryExternalDocument;
import org.husky.cda.elga.generated.artdecor.AtcdabbrEntryImpfPlan;
import org.husky.common.hl7cdar2.ED;
import org.husky.common.hl7cdar2.INT;
import org.husky.common.hl7cdar2.POCDMT000040Entry;
import org.husky.common.hl7cdar2.TEL;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;

public class Appendix {

	private String title;
	private String author;
	private String creationTime;
	private String mediaType;
	private String document;
	private Identificator id;
	private Code cdaCode;
	private Identificator setId;
	private int version;

	public Appendix() {

	}

	public Appendix(POCDMT000040Entry entry) {
		if (entry != null && entry.getObservationMedia() != null && entry.getObservationMedia().getValue() != null) {
			this.mediaType = entry.getObservationMedia().getValue().getMediaType();
			this.document = entry.getObservationMedia().getValue().getMergedXmlMixed();
		}
	}

	public String getAuthor() {
		return author;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public String getDocument() {
		return document;
	}

	public String getMediaType() {
		return mediaType;
	}

	public String getTitle() {
		return title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Identificator getId() {
		return id;
	}

	public void setId(Identificator id) {
		this.id = id;
	}

	public Code getCdaCode() {
		return cdaCode;
	}

	public void setCdaCode(Code cdaCode) {
		this.cdaCode = cdaCode;
	}

	public Identificator getSetId() {
		return setId;
	}

	public void setSetId(Identificator setId) {
		this.setId = setId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * <div class="en">Creates the HL7 CDA R2 data type from the given type. Creates
	 * an entry with nested object. <div>
	 *
	 * <div class="de">Erstellt den HL7 CDA R2 Datentyp aus dem angegebenen Typ.
	 * Erstellt ein HL7 Entry mit einem eingebetteten Objekt.<div>
	 *
	 * @param index id for attr
	 * @return the HL7 CDA R2 data typed value
	 */
	public POCDMT000040Entry getHl7CdaR2AppendixEntry(String prefix, int index) {
		if (this.document != null && this.mediaType != null) {
			POCDMT000040Entry entry = new POCDMT000040Entry();
			entry.setObservationMedia(getEingebettetesObjektEntry(prefix, index));
			return entry;
		}

		return null;
	}

	public AtcdabbrEntryEingebettetesObjektEntry getEingebettetesObjektEntry(String prefix, int index) {
		AtcdabbrEntryEingebettetesObjektEntry object = new AtcdabbrEntryEingebettetesObjektEntry();
		object.setIDAttr("Attachment-" + prefix + "-" + index);
		object.getValue().setXmlMixed(this.getDocument());
		object.getValue().setMediaType(this.mediaType);
		return object;
	}

	public AtcdabbrEntryExternalDocument getAtcdabbrEntryExternalDocument(int index) {
		AtcdabbrEntryExternalDocument externalDoc = new AtcdabbrEntryExternalDocument();

		if (this.id != null) {
			externalDoc.setHl7Id(this.id.getHl7CdaR2Ii());
		}

		if (this.cdaCode != null) {
			externalDoc.setHl7Code(this.cdaCode.getHl7CdaR2Cd());
		}

		if (this.setId != null) {
			externalDoc.setHl7SetId(this.setId.getHl7CdaR2Ii());
		}

		if (this.version > 0) {
			externalDoc.setHl7VersionNumber(new INT(version));
		}

		externalDoc.setText(new ED(null, new TEL("#external-doc-" + index)));

		return externalDoc;
	}

	public AtcdabbrEntryImpfPlan getAtcdabbrEntryImpfPlan(int index) {
		AtcdabbrEntryImpfPlan immunizationPlan = new AtcdabbrEntryImpfPlan();

		if (id != null) {
			immunizationPlan.setHl7Id(id.getHl7CdaR2Ii());
		}

		if (cdaCode != null) {
			immunizationPlan.setHl7Code(cdaCode.getHl7CdaR2Cd());
		}

		immunizationPlan.setText(new ED(null, new TEL("#impfplan-" + index)));

		if (setId != null) {
			immunizationPlan.setHl7SetId(setId.getHl7CdaR2Ii());
			immunizationPlan.setVersionNumber(new INT(version));
		}

		return immunizationPlan;
	}


}
