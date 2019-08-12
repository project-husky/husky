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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.utils.XdsMetadataUtil;
import org.openhealthtools.ihe.xds.metadata.AvailabilityStatusType;
import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;
import org.openhealthtools.ihe.xds.metadata.FolderType;
import org.openhealthtools.ihe.xds.metadata.MetadataFactory;

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

	/** the OHT FolderType */
	private final FolderType f;

	/**
	 * Default constructor to instanciate the object
	 */
	public FolderMetadata() {
		f = MetadataFactory.eINSTANCE.createFolderType();
	}

	/**
	 * <div class="en">Default constructor to instanciate the object
	 *
	 * @param ohtFolderType
	 *            OHT FolderType </div>
	 */
	public FolderMetadata(FolderType ohtFolderType) {
		f = ohtFolderType;
	}

	/**
	 * Method to add a code to codelist
	 *
	 * @param aCode
	 *            the code to be added
	 */
	public void addCode(Code aCode) {
		@SuppressWarnings("unchecked")
		final EList<CodedMetadataType> eList = f.getCode();
		eList.add(XdsMetadataUtil.convertEhcCodeToCodedMetadataType(aCode));
	}

	/**
	 * <div class="en">Gets the Availability Status of the Document
	 *
	 * @return status the AvailabilityStatus </div>
	 */
	public AvailabilityStatusType getAvailabilityStatus() {
		return f.getAvailabilityStatus();
	}

	/**
	 * <div class="en">Gets a list of Codes
	 *
	 * @return a list of Codes </div>
	 */
	public List<Code> getCodeList() {
		final List<Code> retVal = new ArrayList<>();
		@SuppressWarnings("unchecked")
		final EList<CodedMetadataType> eList = f.getCode();
		for (int i = 0; i < eList.size(); ++i) {
			retVal.add(XdsMetadataUtil.convertOhtCodedMetadataType(eList.get(i)));
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
		return f.getEntryUUID();
	}

	/**
	 * <div class="en">Gets the last update time of the folder.
	 *
	 * The DTM formatted string is converted to date
	 *
	 * @return the update time </div>
	 */
	public Date getLastUpdateTime() {
		return XdsMetadataUtil.convertDtmStringToDate(f.getLastUpdateTime());
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
	public void setAvailabilityStatus(AvailabilityStatusType status) {
		f.setAvailabilityStatus(status);
	}

	/**
	 * <div class="en">Sets a list of codes
	 *
	 * @param codeList
	 *            the list of codes to be set </div>
	 */
	public void setCodeList(List<Code> codeList) {
		@SuppressWarnings("unchecked")
		final EList<CodedMetadataType> eList = f.getCode();
		eList.clear();
		for (final Code code : codeList) {
			eList.add(XdsMetadataUtil.convertEhcCodeToCodedMetadataType(code));
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
		f.setEntryUUID(entryUuid);
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
