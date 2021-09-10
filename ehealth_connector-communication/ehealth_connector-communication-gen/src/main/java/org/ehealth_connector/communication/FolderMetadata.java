/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
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

package org.ehealth_connector.communication;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.utils.XdsMetadataUtil;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Folder;

/**
 * <div class="en">Class FolderMetadata. Provides metadata attributes as
 * specified in [IHE ITI TF-3, Sep 9, 2016], Table 4.1.3.4-1: Folder Metadata
 * Attribute Definition </div>
 *
 * <div class="de">Klasse FolderMetadata Stellt die Metadata Attribute wine in
 * [IHE ITI TF-3, Sep 9, 2016], Table 4.1.3.4-1: Folder Metadata Attribute
 * Definition zur Verfügung.</div>
 */
public class FolderMetadata {

	/** the IPF Folder */
	private final Folder f;

	/**
	 * Default constructor to instanciate the object
	 */
	public FolderMetadata() {
		f = new Folder();
	}

	/**
	 * <div class="en">Default constructor to instanciate the object
	 *
	 * @param ipfFolder IPF folder </div>
	 */
	public FolderMetadata(Folder ipfFolder) {
		f = ipfFolder;
	}

	/**
	 * Method to add a code to codelist
	 *
	 * @param aCode
	 *            the code to be added
	 */
	public void addCode(Code aCode) {
		final List<org.openehealth.ipf.commons.ihe.xds.core.metadata.Code> list = f.getCodeList();
		list.add(XdsMetadataUtil.convertEhcCodeToCode(aCode));
	}

	/**
	 * <div class="en">Gets the Availability Status of the Document
	 *
	 * @return status the AvailabilityStatus </div>
	 */
	public AvailabilityStatus getAvailabilityStatus() {
		return f.getAvailabilityStatus();
	}

	/**
	 * <div class="en">Gets a list of Codes
	 *
	 * @return a list of Codes </div>
	 */
	public List<Code> getCodeList() {
		final List<Code> retVal = new ArrayList<>();

		List<org.openehealth.ipf.commons.ihe.xds.core.metadata.Code> list = f.getCodeList();
		for (var i = 0; i < list.size(); ++i) {
			retVal.add(XdsMetadataUtil.convertOhtCodedMetadataType(list.get(i)));
		}

		return retVal;
	}

	/**
	 * <div class="en">Gets comments for this submission
	 *
	 * @return comments the comments </div>
	 */
	public String getComments() {
		return XdsMetadataUtil.convertInternationalStringType(f.getComments());
	}

	/**
	 * <div class="en">Gets the EntryUUID
	 *
	 * @return the EntryUUID </div>
	 */
	public String getEntryUUID() {
		return f.getEntryUuid();
	}

	/**
	 * <div class="en">Gets the last update time of the folder.
	 *
	 * The DTM formatted string is converted to date
	 *
	 * @return the update time </div>
	 */
	public ZonedDateTime getLastUpdateTime() {
		return f.getLastUpdateTime().getDateTime();
	}

	/**
	 * <div class="en">Gets the ID of the patient
	 *
	 * @return id the patientId
	 */
	public Identificator getPatientId() {
		return XdsMetadataUtil.convertOhtCx(f.getPatientId());
	}

	/**
	 * <div class="en">Gets the title of the submission set
	 *
	 * @return the title
	 */
	public String getTitle() {
		return XdsMetadataUtil.convertInternationalStringType(f.getTitle());
	}

	/**
	 *
	 * <div class="en">Gets the uniqueid of the submission set
	 *
	 * @return hte unique id
	 */
	public String getUniqueId() {
		return f.getUniqueId();
	}

	// getHomeCommunityId()
	// setHomeCommunityId()

	/**
	 * <div class="en">Sets the Availability Status of the Document
	 *
	 * @param status
	 *            the AvailabilityStatus </div>
	 */
	public void setAvailabilityStatus(AvailabilityStatus status) {
		f.setAvailabilityStatus(status);
	}

	/**
	 * <div class="en">Sets a list of codes
	 *
	 * @param codeList
	 *            the list of codes to be set </div>
	 */
	public void setCodeList(List<Code> codeList) {
		final List<org.openehealth.ipf.commons.ihe.xds.core.metadata.Code> list = f.getCodeList();
		list.clear();
		for (final Code code : codeList) {
			list.add(XdsMetadataUtil.convertEhcCodeToCode(code));
		}

	}

	/**
	 * <div class="en">Sets comments for this submission
	 *
	 * @param comments
	 *            the comments </div>
	 */
	public void setComments(String comments) {
		f.setComments(XdsMetadataUtil.createInternationalString(comments));
	}

	/**
	 * <div class="en">Sets the entry uuid.
	 *
	 * @param entryUuid
	 *            the uuid to be set </div>
	 */
	public void setEntryUUID(String entryUuid) {
		f.setEntryUuid(entryUuid);
	}

	/**
	 * <div class="en">
	 *
	 * @param lastUpdateTime
	 */
	public void setLastUpdateTime(Date lastUpdateTime) {
		f.setLastUpdateTime(XdsMetadataUtil.convertDateToDtmString(lastUpdateTime));
	}

	/**
	 *
	 * <div class="en">Sets the ID of the patient
	 *
	 * @param id
	 *            the patientId
	 */
	public void setPatientId(Identificator id) {
		f.setPatientId(XdsMetadataUtil.convertEhcIdentificator(id));
	}

	/**
	 * <div class="en">Sets the title of the submission set
	 *
	 * @param title
	 *            the title
	 */
	public void setTitle(String title) {
		f.setTitle(XdsMetadataUtil.createInternationalString(title));
	}

	/**
	 * <div class="en">Sets the unique id.
	 *
	 * @param uniqueyId
	 *            the unique id to be set
	 */
	public void setUniqueId(String uniqueyId) {
		f.setUniqueId(uniqueyId);
	}

}
