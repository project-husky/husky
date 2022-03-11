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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.openehealth.ipf.commons.ihe.xds.core.validate.ValidationMessage;
import org.openehealth.ipf.commons.ihe.xds.core.validate.XDSMetaDataException;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * All possible query types.
 *
 * @author Quentin Ligier
 * @see org.openehealth.ipf.commons.ihe.xds.core.requests.query.QueryType
 **/
@XmlType(name = "QueryType")
@XmlEnum
public enum ChPharm1QueryType {

    /**
     * Find planned medication documents and their related documents (CH:PHARM-1).
     */
    @XmlEnumValue("FindMedicationTreatmentPlans")
    CH_FIND_MEDICATION_TREATMENT_PLANS("urn:uuid:c85f5ade-81c1-44b6-8f7c-48b9cd6b9489", ChFindMedicationTreatmentPlansQuery.class),

    /**
     * Find prescriptions and their related documents (CH:PHARM-1).
     */
    @XmlEnumValue("FindPrescriptions")
    CH_FIND_PRESCRIPTIONS("urn:uuid:0e6095c5-dc3d-47d9-a219-047064086d92", ChFindPrescriptionsQuery.class),

    /**
     * Find dispense documents and their related documents (CH:PHARM-1).
     */
    @XmlEnumValue("FindDispenses")
    CH_FIND_DISPENSES("urn:uuid:ac79c7c7-f21b-4c88-ab81-57e4889e8758", ChFindDispensesQuery.class),

    /**
     * Find administered medication documents and their related documents (CH:PHARM-1).
     */
    @XmlEnumValue("FindMedicationAdministrations")
    CH_FIND_MEDICATION_ADMINISTRATIONS("urn:uuid:fdbe8fb8-7b5c-4470-9383-8abc7135f462",
            ChFindMedicationAdministrationsQuery.class),

    /**
     * Find prescriptions and their related documents containing Prescription Items ready to be validated (CH:PHARM-1).
     */
    @XmlEnumValue("FindPrescriptionsForValidation")
    CH_FIND_PRESCRIPTIONS_FOR_VALIDATION("urn:uuid:c1a43b20-0254-102e-8469-a6af440562e8",
            ChFindPrescriptionsForValidationQuery.class),

    /**
     * Find prescriptions and their related documents containing Prescription Items ready to be dispensed (CH:PHARM-1).
     */
    @XmlEnumValue("FindPrescriptionsForDispense")
    CH_FIND_PRESCRIPTIONS_FOR_DISPENSE("urn:uuid:c875eb9c-0254-102e-8469-a6af440562e8", ChFindPrescriptionsForDispenseQuery.class),

    /**
     * Find the medication list for the patient (CH:PHARM-1).
     */
    @XmlEnumValue("FindMedicationList")
    CH_FIND_MEDICATION_LIST("urn:uuid:80ebbd83-53c1-4453-9860-349585962af6", ChFindMedicationListQuery.class),

    /**
     * Find the medication card for the patient (CH:PHARM-1).
     */
    @XmlEnumValue("FindMedicationCard")
    CH_FIND_MEDICATION_CARD("urn:uuid:a8fc04c1-5fb0-45a9-bc59-7a59958beb38", ChFindMedicationCardQuery.class);


    private final String id;
    private final Class<? extends ChPharmacyDocumentsQuery> type;

    ChPharm1QueryType(final String id,
                      final Class<? extends ChPharmacyDocumentsQuery> type) {
        this.id = id;
        this.type = type;
    }

    /**
     * Returns a query type by its id.
     *
     * @param id the id. Can be <code>null</code>.
     * @return the type. <code>null</code> if the id is <code>null</code>.
     */
    @Nullable
    public static ChPharm1QueryType valueOfId(@Nullable final String id) {
        if (id == null) {
            return null;
        }

        for (var type : values()) {
            if (id.equals(type.getId())) {
                return type;
            }
        }

        throw new XDSMetaDataException(ValidationMessage.UNKNOWN_QUERY_TYPE, id);
    }

    /**
     * @return the ID of the query.
     */
    public String getId() {
        return id;
    }

    /**
     * @return the class implementing the query.
     */
    public Class<? extends ChPharmacyDocumentsQuery> getType() {
        return type;
    }
}
