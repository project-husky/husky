/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.communication.ch.camel.chpharm1.requests;

import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Code;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Identifiable;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.*;

import javax.xml.bind.annotation.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Base class for Pharmacy Documents Queries (CH:PHARM-1).
 *
 * @author Quentin Ligier
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PharmacyDocumentsQuery", propOrder = {"homeCommunityId", "extraParameters", "patientEprSpid", "status",
        "metadataLevel", "formatCodes"})
@XmlRootElement(name = "pharmacyDocumentsQuery")
public abstract class ChPharmacyDocumentsQuery implements PatientIdBasedStoredQuery, Serializable {
    @Serial
    private static final long serialVersionUID = -7916431036877819618L;

    @XmlAttribute
    protected ChPharm1QueryType type;
    protected String homeCommunityId;
    protected final Map<String, QueryList<String>> extraParameters = new HashMap<>();
    protected Identifiable patientEprSpid;
    protected List<AvailabilityStatus> status;
    protected Integer metadataLevel;
    @XmlElement(name = "formatCode")
    protected List<Code> formatCodes;

    /**
     * For JAXB serialization only.
     */
    public ChPharmacyDocumentsQuery() {
    }

    /**
     * Constructs the query.
     * @param queryType
     *          the type of the query.
     */
    protected ChPharmacyDocumentsQuery(final ChPharm1QueryType queryType) {
        Objects.requireNonNull(queryType, "queryType shall not be null in ChPharmacyDocumentsQuery()");
        this.type = queryType;
    }

    public ChPharm1QueryType getType() {
        return type;
    }

    public String getHomeCommunityId() {
        return homeCommunityId;
    }

    public void setHomeCommunityId(final String homeCommunityId) {
        this.homeCommunityId = homeCommunityId;
    }

    public Map<String, QueryList<String>> getExtraParameters() {
        return extraParameters;
    }

    public Identifiable getPatientId() {
        return patientEprSpid;
    }

    public void setPatientId(final Identifiable patientEprSpid) {
        this.patientEprSpid = patientEprSpid;
    }

    public List<AvailabilityStatus> getStatus() {
        return status;
    }

    public void setStatus(final List<AvailabilityStatus> status) {
        this.status = status;
    }

    public Integer getMetadataLevel() {
        return metadataLevel;
    }

    public void setMetadataLevel(final Integer metadataLevel) {
        this.metadataLevel = metadataLevel;
    }

    public List<Code> getFormatCodes() {
        return formatCodes;
    }

    public void setFormatCodes(final List<Code> formatCodes) {
        this.formatCodes = formatCodes;
    }

    /**
     * Visitor interface used for this class to implement the visitor pattern.
     */
    public interface Visitor {
        // for CH:PHARM-1
        void visit(final ChPharmacyDocumentsQuery query);
        void visit(final ChFindPrescriptionsQuery query);
        void visit(final ChFindDispensesQuery query);
        void visit(final ChFindMedicationAdministrationsQuery query);
        void visit(final ChFindPrescriptionsForValidationQuery query);
        void visit(final ChFindPrescriptionsForDispenseQuery query);
        void visit(final ChFindMedicationListQuery query);
        void visit(final ChFindMedicationCardQuery query);
    }

    /**
     * Accept a visitor to process an instance of this class.
     * @param visitor
     *          the visitor implementation.
     */
    public abstract void accept(final Visitor visitor);

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final ChPharmacyDocumentsQuery that)) return false;
        return type == that.type
                && Objects.equals(homeCommunityId, that.homeCommunityId)
                && Objects.equals(extraParameters, that.extraParameters)
                && Objects.equals(patientEprSpid, that.patientEprSpid)
                && Objects.equals(status, that.status)
                && Objects.equals(metadataLevel, that.metadataLevel)
                && Objects.equals(formatCodes, that.formatCodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, homeCommunityId, extraParameters, patientEprSpid, status, metadataLevel, formatCodes);
    }

    @Override
    public String toString() {
        return "ChPharmacyDocumentsQuery{" +
                "type=" + this.type +
                ", homeCommunityId='" + this.homeCommunityId + '\'' +
                ", extraParameters=" + this.extraParameters +
                ", patientId=" + this.patientEprSpid +
                ", status=" + this.status +
                ", metadataLevel=" + this.metadataLevel +
                ", formatCodes=" + this.formatCodes +
                '}';
    }
}
