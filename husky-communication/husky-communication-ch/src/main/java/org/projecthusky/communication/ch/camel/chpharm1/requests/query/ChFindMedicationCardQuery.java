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

package org.projecthusky.communication.ch.camel.chpharm1.requests.query;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntryType;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.TimeRange;

import javax.xml.bind.annotation.*;
import java.io.Serial;
import java.util.List;
import java.util.Objects;

/**
 * Represents a stored query for FindMedicationCardQuery (CH:PHARM-1).
 *
 * @author Quentin Ligier
 **/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FindMedicationCardQuery", propOrder = {
        "documentEntryTypes", "serviceStart", "serviceEnd"})
@XmlRootElement(name = "findMedicationCardQuery")
public class ChFindMedicationCardQuery extends ChPharmacyDocumentsQuery {
    @Serial
    private static final long serialVersionUID = 7643647733043294769L;

    @Nullable @XmlElement(name = "documentEntryType")
    private List<DocumentEntryType> documentEntryTypes;
    private final TimeRange serviceStart = new TimeRange();
    private final TimeRange serviceEnd = new TimeRange();
    @Nullable
    private String languageCode;

    /**
     * Constructs the query.
     */
    public ChFindMedicationCardQuery() {
        super(ChPharm1QueryType.CH_FIND_MEDICATION_CARD);
    }

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

    @Nullable
    public List<DocumentEntryType> getDocumentEntryTypes() {
        return documentEntryTypes;
    }

    public void setDocumentEntryTypes(@Nullable final List<DocumentEntryType> documentEntryTypes) {
        this.documentEntryTypes = documentEntryTypes;
    }

    public TimeRange getServiceStart() {
        return serviceStart;
    }

    public TimeRange getServiceEnd() {
        return serviceEnd;
    }

    @Nullable
    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(@Nullable final String languageCode) {
        this.languageCode = languageCode;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final ChFindMedicationCardQuery that)) return false;
        return Objects.equals(documentEntryTypes, that.documentEntryTypes)
                && Objects.equals(serviceStart, that.serviceStart)
                && Objects.equals(serviceEnd, that.serviceEnd)
                && Objects.equals(languageCode, that.languageCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), documentEntryTypes, serviceStart, serviceEnd, languageCode);
    }

    @Override
    public String toString() {
        return "ChFindMedicationCardQuery{" +
                "documentEntryTypes=" + this.documentEntryTypes +
                ", serviceStart=" + this.serviceStart +
                ", serviceEnd=" + this.serviceEnd +
                ", languageCode='" + this.languageCode + '\'' +
                ", type=" + this.type +
                ", homeCommunityId='" + this.homeCommunityId + '\'' +
                ", extraParameters=" + this.extraParameters +
                ", patientEprSpid=" + this.patientEprSpid +
                ", status=" + this.status +
                ", metadataLevel=" + this.metadataLevel +
                ", formatCodes=" + this.formatCodes +
                '}';
    }
}
