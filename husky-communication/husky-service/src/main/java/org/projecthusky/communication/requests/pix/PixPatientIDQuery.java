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
package org.projecthusky.communication.requests.pix;

import java.util.List;

import org.openehealth.ipf.commons.ihe.hl7v3.core.metadata.Device;
import org.openehealth.ipf.commons.ihe.hl7v3.core.requests.PixV3QueryRequest;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.communication.utils.PixPdqV3Utils;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;
import net.ihe.gazelle.hl7v3.datatypes.II;

/**
 * This is the class that collects all parameters required (and optional) for querying Patient IDs when the user already knows one ID.
 * @author szalai
 */
@Getter
@Builder
@ToString
public class PixPatientIDQuery {
	@NonNull
	private Destination destination;
	@NonNull
	private String homeCommunityOid;
	@NonNull
	private String homeCommunityPatientOid;
	@NonNull
	private String homeCommunityNamespace;
	@Singular
	private List<String> queryDomainOids;

	public static class PixPatientIDQueryBuilder {}
	
	public PixV3QueryRequest build() {
		var v3PixConsumerQueryRequest = new PixV3QueryRequest();
		String senderApplicationOid = this.destination.getSenderApplicationOid();

        var senderDev = new Device();
        var id = new II();
        id.setRoot(senderApplicationOid);
        senderDev.getIds().add(id);
        v3PixConsumerQueryRequest.setSender(senderDev);

        var receiverDev = new Device();
        var idReceiver = new II();
        idReceiver.setRoot(this.destination.getReceiverApplicationOid());
        receiverDev.getIds().add(idReceiver);
        v3PixConsumerQueryRequest.setReceiver(receiverDev);

        v3PixConsumerQueryRequest.setQueryId(PixPdqV3Utils.createIIwithUniqueExtension(senderApplicationOid));
        v3PixConsumerQueryRequest.setMessageId(PixPdqV3Utils.createIIwithUniqueExtension(senderApplicationOid));

        v3PixConsumerQueryRequest.setQueryPatientId(
        		PixPdqV3Utils.createII(this.homeCommunityOid, this.homeCommunityPatientOid, this.homeCommunityNamespace));

        for (String domainToReturnOid : queryDomainOids) {
            v3PixConsumerQueryRequest.getDataSourceOids().add(domainToReturnOid);
        }
		return v3PixConsumerQueryRequest;
	}

}
