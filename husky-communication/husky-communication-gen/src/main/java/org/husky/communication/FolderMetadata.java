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

package org.husky.communication;

import org.husky.common.model.Code;
import org.husky.common.model.Identificator;
import org.husky.common.utils.XdsMetadataUtil;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Folder;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class FolderMetadata. Provides metadata attributes as specified in [IHE ITI TF-3, Sep 9, 2016], Table 4.1.3.4-1:
 * Folder Metadata Attribute Definition
 */
public class FolderMetadata {

    /**
     * the IPF Folder
     */
    private final Folder f;

    /**
     * Default constructor to instanciate the object
     */
    public FolderMetadata() {
        f = new Folder();
    }

    /**
     * Default constructor to instanciate the object
     *
     * @param ipfFolder IPF folder
     */
    public FolderMetadata(Folder ipfFolder) {
        f = ipfFolder;
    }

    /**
     * Method to add a code to codelist
     *
     * @param aCode the code to be added
     */
    public void addCode(Code aCode) {
        final List<org.openehealth.ipf.commons.ihe.xds.core.metadata.Code> list = f.getCodeList();
        list.add(XdsMetadataUtil.convertEhcCodeToCode(aCode));
    }

    /**
     * Gets the Availability Status of the Document
     *
     * @return status the AvailabilityStatus
     */
    public AvailabilityStatus getAvailabilityStatus() {
        return f.getAvailabilityStatus();
    }

    /**
     * Sets the Availability Status of the Document
     *
     * @param status the AvailabilityStatus
     */
    public void setAvailabilityStatus(AvailabilityStatus status) {
        f.setAvailabilityStatus(status);
    }

    /**
     * Gets a list of Codes
     *
     * @return a list of Codes
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
     * Sets a list of codes
     *
     * @param codeList the list of codes to be set
     */
    public void setCodeList(List<Code> codeList) {
        final List<org.openehealth.ipf.commons.ihe.xds.core.metadata.Code> list = f.getCodeList();
        list.clear();
        for (final Code code : codeList) {
            list.add(XdsMetadataUtil.convertEhcCodeToCode(code));
        }

    }

    /**
     * Gets comments for this submission
     *
     * @return comments the comments
     */
    public String getComments() {
        return XdsMetadataUtil.convertInternationalStringType(f.getComments());
    }

    /**
     * Sets comments for this submission
     *
     * @param comments the comments
     */
    public void setComments(String comments) {
        f.setComments(XdsMetadataUtil.createInternationalString(comments));
    }

    /**
     * Gets the EntryUUID
     *
     * @return the EntryUUID
     */
    public String getEntryUUID() {
        return f.getEntryUuid();
    }

    /**
     * Sets the entry uuid.
     *
     * @param entryUuid the uuid to be set
     */
    public void setEntryUUID(String entryUuid) {
        f.setEntryUuid(entryUuid);
    }

    // getHomeCommunityId()
    // setHomeCommunityId()

    /**
     * Gets the last update time of the folder.
     * <p>
     * The DTM formatted string is converted to date
     *
     * @return the update time
     */
    public ZonedDateTime getLastUpdateTime() {
        return f.getLastUpdateTime().getDateTime();
    }

    /**
     * @param lastUpdateTime
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        f.setLastUpdateTime(XdsMetadataUtil.convertDateToDtmString(lastUpdateTime));
    }

    /**
     * Gets the ID of the patient
     *
     * @return id the patientId
     */
    public Identificator getPatientId() {
        return XdsMetadataUtil.convertOhtCx(f.getPatientId());
    }

    /**
     * Sets the ID of the patient
     *
     * @param id the patientId
     */
    public void setPatientId(Identificator id) {
        f.setPatientId(XdsMetadataUtil.convertEhcIdentificator(id));
    }

    /**
     * Gets the title of the submission set
     *
     * @return the title
     */
    public String getTitle() {
        return XdsMetadataUtil.convertInternationalStringType(f.getTitle());
    }

    /**
     * Sets the title of the submission set
     *
     * @param title the title
     */
    public void setTitle(String title) {
        f.setTitle(XdsMetadataUtil.createInternationalString(title));
    }

    /**
     * Gets the uniqueid of the submission set
     *
     * @return hte unique id
     */
    public String getUniqueId() {
        return f.getUniqueId();
    }

    /**
     * Sets the unique id.
     *
     * @param uniqueyId the unique id to be set
     */
    public void setUniqueId(String uniqueyId) {
        f.setUniqueId(uniqueyId);
    }

}
