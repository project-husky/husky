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
package org.husky.communication.ch.camel.chpharm1.requests;

import org.openehealth.ipf.commons.ihe.xds.core.metadata.Code;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Person;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.TimeRange;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.query.QuerySlotHelper;

import javax.xml.bind.annotation.*;
import java.io.Serial;
import java.util.List;
import java.util.Objects;

/**
 * Abstract stored query for CH:PHARM-1 stable documents queries.
 *
 * @author Quentin Ligier
 **/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PharmacyStableDocumentsQuery", propOrder = {
        "authorPersons", "creationTime", "serviceStartTime", "serviceStopTime",
        "confidentialityCodes", "eventCodes", "uuids", "healthcareFacilityTypeCodes",
        "practiceSettingCodes", "uniqueIds"})
@XmlRootElement(name = "abstractPharm1StableDocumentsQuery")
public abstract class ChPharmacyStableDocumentsQuery extends ChPharmacyDocumentsQuery {
    @Serial
    private static final long serialVersionUID = -3599260950248058443L;

    protected final TimeRange creationTime = new TimeRange();
    protected final TimeRange serviceStartTime = new TimeRange();
    protected final TimeRange serviceStopTime = new TimeRange();
    @XmlElement(name = "uuid")
    protected List<String> uuids;
    @XmlElement(name = "uniqueId")
    protected List<String> uniqueIds;
    @XmlElement(name = "practiceSettingCode")
    protected List<Code> practiceSettingCodes;
    @XmlElement(name = "healthcareFacilityTypeCode")
    protected List<Code> healthcareFacilityTypeCodes;
    @XmlElement(name = "eventCode")
    protected List<Code> eventCodes;
    @XmlElement(name = "confidentialityCode")
    protected List<Code> confidentialityCodes;
    @XmlElement(name = "authorPerson")
    protected List<String> authorPersons;

    /**
     * For JAXB serialization only.
     */
    public ChPharmacyStableDocumentsQuery() {
    }

    /**
     * Constructs the query.
     *
     * @param queryType the type of the query.
     */
    protected ChPharmacyStableDocumentsQuery(final ChPharm1QueryType queryType) {
        super(queryType);
    }

    public TimeRange getCreationTime() {
        return creationTime;
    }

    public TimeRange getServiceStartTime() {
        return serviceStartTime;
    }

    public TimeRange getServiceStopTime() {
        return serviceStopTime;
    }

    public List<String> getUuids() {
        return uuids;
    }

    public void setUuids(final List<String> uuids) {
        this.uuids = uuids;
    }

    public List<String> getUniqueIds() {
        return uniqueIds;
    }

    public void setUniqueIds(final List<String> uniqueIds) {
        this.uniqueIds = uniqueIds;
    }

    public List<Code> getPracticeSettingCodes() {
        return practiceSettingCodes;
    }

    public void setPracticeSettingCodes(final List<Code> practiceSettingCodes) {
        this.practiceSettingCodes = practiceSettingCodes;
    }

    public List<Code> getHealthcareFacilityTypeCodes() {
        return healthcareFacilityTypeCodes;
    }

    public void setHealthcareFacilityTypeCodes(final List<Code> healthcareFacilityTypeCodes) {
        this.healthcareFacilityTypeCodes = healthcareFacilityTypeCodes;
    }

    public List<Code> getEventCodes() {
        return eventCodes;
    }

    public void setEventCodes(final List<Code> eventCodes) {
        this.eventCodes = eventCodes;
    }

    public List<Code> getConfidentialityCodes() {
        return confidentialityCodes;
    }

    public void setConfidentialityCodes(final List<Code> confidentialityCodes) {
        this.confidentialityCodes = confidentialityCodes;
    }

    public List<String> getAuthorPersons() {
        return authorPersons;
    }

    public void setAuthorPersons(final List<String> authorPersons) {
        this.authorPersons = authorPersons;
    }

    /**
     * Tries to return the query parameter "$XDSDocumentEntryAuthorPerson" as a collection of {@link Person} instead of
     * a collection of {@link String}. This may fail if SQL LIKE wildcards ("%", "_", etc.) are used in one or more
     * elements.
     *
     * @return a collection of {@link Person} objects.
     */
    public List<Person> getTypedAuthorPersons() {
        return QuerySlotHelper.parse(this.authorPersons, Person.class);
    }

    /**
     * Allows to use a collection of {@link Person} instead of a collection of {@link String} for specifying the query
     * parameter "$XDSDocumentEntryAuthorPerson".
     *
     * @param authorPersons a collection of {@link Person} objects.
     */
    public void setTypedAuthorPersons(final List<Person> authorPersons) {
        this.authorPersons = QuerySlotHelper.render(authorPersons);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final ChPharmacyStableDocumentsQuery that)) return false;
        return Objects.equals(creationTime, that.creationTime)
                && Objects.equals(serviceStartTime, that.serviceStartTime)
                && Objects.equals(serviceStopTime, that.serviceStopTime)
                && Objects.equals(uuids, that.uuids)
                && Objects.equals(uniqueIds, that.uniqueIds)
                && Objects.equals(practiceSettingCodes, that.practiceSettingCodes)
                && Objects.equals(healthcareFacilityTypeCodes, that.healthcareFacilityTypeCodes)
                && Objects.equals(eventCodes, that.eventCodes)
                && Objects.equals(confidentialityCodes, that.confidentialityCodes)
                && Objects.equals(authorPersons, that.authorPersons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), creationTime, serviceStartTime, serviceStopTime, uuids, uniqueIds, practiceSettingCodes, healthcareFacilityTypeCodes, eventCodes, confidentialityCodes, authorPersons);
    }

    @Override
    public String toString() {
        return "ChPharmacyStableDocumentsQuery{" +
                "type=" + this.type +
                ", homeCommunityId='" + this.homeCommunityId + '\'' +
                ", extraParameters=" + this.extraParameters +
                ", patientEprSpid=" + this.patientEprSpid +
                ", status=" + this.status +
                ", metadataLevel=" + this.metadataLevel +
                ", formatCodes=" + this.formatCodes +
                ", creationTime=" + this.creationTime +
                ", serviceStartTime=" + this.serviceStartTime +
                ", serviceStopTime=" + this.serviceStopTime +
                ", uuids=" + this.uuids +
                ", uniqueIds=" + this.uniqueIds +
                ", practiceSettingCodes=" + this.practiceSettingCodes +
                ", healthcareFacilityTypeCodes=" + this.healthcareFacilityTypeCodes +
                ", eventCodes=" + this.eventCodes +
                ", confidentialityCodes=" + this.confidentialityCodes +
                ", authorPersons=" + this.authorPersons +
                '}';
    }
}
