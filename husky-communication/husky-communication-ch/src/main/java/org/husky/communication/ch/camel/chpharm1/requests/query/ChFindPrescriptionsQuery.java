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

package org.husky.communication.ch.camel.chpharm1.requests.query;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serial;

/**
 * Represents a stored query for FindPrescriptionsQuery (CH:PHARM-1).
 *
 * @author Quentin Ligier
 **/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FindPrescriptionsQuery", propOrder = {})
@XmlRootElement(name = "findPrescriptionsQuery")
public class ChFindPrescriptionsQuery extends ChPharmacyStableDocumentsQuery {
    @Serial
    private static final long serialVersionUID = 3492506001787540389L;

    /**
     * Constructs the query.
     */
    public ChFindPrescriptionsQuery() {
        super(ChPharm1QueryType.CH_FIND_PRESCRIPTIONS);
    }

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "ChFindPrescriptionsQuery{" +
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
