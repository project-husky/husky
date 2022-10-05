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
package org.projecthusky.communication.ch.camel.chpharm1.requests;

import org.projecthusky.communication.ch.camel.chpharm1.requests.query.*;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.*;

import javax.xml.bind.annotation.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

import static org.apache.commons.lang3.Validate.notNull;

/**
 * Request object for the Query Registry and Registry Stored Query transactions.
 *
 * @author Jens Riemschneider
 * @author Quentin Ligier
 **/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueryRegistry")
@XmlRootElement(name = "queryRegistry")
public class ChQueryRegistry implements Serializable {
    @Serial
    private static final long serialVersionUID = -6470028790241453562L;

    @XmlElementRefs({
            @XmlElementRef(type = ChFindDispensesQuery.class),
            @XmlElementRef(type = ChFindMedicationAdministrationsQuery.class),
            @XmlElementRef(type = ChFindMedicationCardQuery.class),
            @XmlElementRef(type = ChFindMedicationListQuery.class),
            @XmlElementRef(type = ChFindMedicationTreatmentPlansQuery.class),
            @XmlElementRef(type = ChFindPrescriptionsForDispenseQuery.class),
            @XmlElementRef(type = ChFindPrescriptionsForValidationQuery.class),
            @XmlElementRef(type = ChFindPrescriptionsQuery.class)})

    private ChPharmacyDocumentsQuery query;

    @XmlAttribute
    private QueryReturnType returnType = QueryReturnType.OBJECT_REF;

    /**
     * For JAXB serialization only.
     */
    public ChQueryRegistry() {
    }

    /**
     * Constructs the request.
     *
     * @param query The query to use. Cannot be {@code null}.
     */
    public ChQueryRegistry(final ChPharmacyDocumentsQuery query) {
        notNull(query, "query cannot be null");
        this.query = query;
    }

    /**
     * Constructs the request.
     *
     * @param query      The query to use. Cannot be {@code null}.
     * @param returnType The return type.
     */
    public ChQueryRegistry(final ChPharmacyDocumentsQuery query, final QueryReturnType returnType) {
        notNull(query, "query cannot be null");
        notNull(returnType, "returnType cannot be null");
        this.query = query;
        this.returnType = returnType;
    }

    public ChPharmacyDocumentsQuery getQuery() {
        return this.query;
    }

    public QueryReturnType getReturnType() {
        return this.returnType;
    }

    public void setReturnType(final QueryReturnType returnType) {
        this.returnType = returnType;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final ChQueryRegistry that)) return false;
        return Objects.equals(query, that.query)
                && returnType == that.returnType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(query, returnType);
    }

    @Override
    public String toString() {
        return "ChQueryRegistry{" +
                "query=" + this.query +
                ", returnType=" + this.returnType +
                '}';
    }
}
