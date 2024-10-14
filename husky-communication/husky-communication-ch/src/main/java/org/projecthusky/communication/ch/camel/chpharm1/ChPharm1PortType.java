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
package org.projecthusky.communication.ch.camel.chpharm1;

import org.apache.cxf.annotations.DataBinding;
import org.openehealth.ipf.commons.ihe.xds.core.XdsJaxbDataBinding;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.query.AdhocQueryRequest;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.query.AdhocQueryResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;

/**
 * Provides the CH:PHARM-1 web-service interface.
 *
 * @author Quentin Ligier
 */
@WebService(
        targetNamespace = "urn:ihe:iti:xds-b:2007",
        name = "CommunityPharmacyManager_PortType",
        portName = "CommunityPharmacyManager_Port_Soap12"
)
@XmlSeeAlso({
        org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.ObjectFactory.class,
        org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.lcm.ObjectFactory.class,
        org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rs.ObjectFactory.class,
        org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.query.ObjectFactory.class
})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@DataBinding(XdsJaxbDataBinding.class)
public interface ChPharm1PortType {

    /**
     * Performs a stored query according to the CH:PHARM-1 specification.
     *
     * @param body The query request.
     * @return the query response.
     */
    @WebResult(
            name = "AdhocQueryResponse",
            targetNamespace = "urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0",
            partName = "body"
    )
    @Action(
            input = "urn:ihe:pharm:cmpd:2010:QueryPharmacyDocuments",
            output = "urn:ihe:pharm:cmpd:2010:QueryPharmacyDocumentsResponse"
    )
    @WebMethod(operationName = "CommunityPharmacyManager_QueryPharmacyDocuments")
    AdhocQueryResponse communityPharmacyManagerQueryPharmacyDocuments(
            @WebParam(
                    partName = "body",
                    name = "AdhocQueryRequest",
                    targetNamespace = "urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0")
                    AdhocQueryRequest body
    );
}
