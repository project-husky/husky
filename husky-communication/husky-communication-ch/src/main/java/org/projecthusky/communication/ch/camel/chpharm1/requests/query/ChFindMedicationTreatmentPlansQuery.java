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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.io.Serial;

/**
 * Represents a stored query for FindMedicationTreatmentPlansQuery (CH:PHARM-1).
 *
 * @author Quentin Ligier
 **/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FindMedicationTreatmentPlansQuery", propOrder = {})
@XmlRootElement(name = "findMedicationTreatmentPlansQuery")
public class ChFindMedicationTreatmentPlansQuery extends ChPharmacyStableDocumentsQuery {
    @Serial
    private static final long serialVersionUID = 5983946116420097344L;

    /**
     * Constructs the query.
     */
    public ChFindMedicationTreatmentPlansQuery() {
        super(ChPharm1QueryType.CH_FIND_MEDICATION_TREATMENT_PLANS);
    }

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "ChFindMedicationTreatmentPlansQuery{" +
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
