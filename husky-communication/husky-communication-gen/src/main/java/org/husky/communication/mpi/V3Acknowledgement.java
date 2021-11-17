/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: �����
 *
 */

package org.husky.communication.mpi;

import net.ihe.gazelle.hl7v3.mcciin000002UV01.MCCIIN000002UV01Type;

/**
 * @author <a href="mailto:anthony.larocca@sage.com">Anthony Larocca</a>
 *
 */
public class V3Acknowledgement extends V3Response {

	private MCCIIN000002UV01Type rootElement = null;

	// right now the only constructor takes in xml element
	/**
	 * Constructor that accepts the XML containing the Acknowledgement message (MCCIIN000002UV01).
	 * 
	 * @param v3Acknowledgement
	 * @throws Exception
	 */
	public V3Acknowledgement(MCCIIN000002UV01Type v3Acknowledgement) {

		// get the pix response
		rootElement = v3Acknowledgement;

		// set the id
		this.messageId = rootElement.getId();

		// get sender information
		this.sendingApplication = rootElement.getSender().getDevice().getId().get(0).getRoot();
		if (null != rootElement.getSender().getDevice().getAsAgent()
				&& null != rootElement.getSender().getDevice().getAsAgent().getRepresentedOrganization()
				&& !rootElement.getSender().getDevice().getAsAgent().getRepresentedOrganization().getId().isEmpty())
			this.sendingFacility = rootElement.getSender().getDevice().getAsAgent().getRepresentedOrganization().getId()
					.get(0).getRoot();

		// find how many receivers there are
		int numReceivers = rootElement.getReceiver().size();

		// for each reciever
		for (var i = 0; i < numReceivers; i++) {
			// get the application and (if available) facility
			this.addReceivingApplication(rootElement.getReceiver().get(i).getDevice().getId().get(0).getRoot());
			if (null != rootElement.getReceiver().get(i).getDevice().getAsAgent())
				this.addReceivingFacility(rootElement.getReceiver().get(i).getDevice().getAsAgent()
						.getRepresentedOrganization().getId().get(0).getRoot());
		}

		// get the ack code
		this.setAcknowledgementCode(rootElement.getAcknowledgement().get(0).getTypeCode().getCode());

		// if there is acknowledgement detail
		if (!rootElement.getAcknowledgement().get(0).getAcknowledgementDetail().isEmpty()) {
			var detailCode = "";
			var detailText = "";

			if (null != rootElement.getAcknowledgement().get(0).getAcknowledgementDetail().get(0).getCode())
				detailCode = rootElement.getAcknowledgement().get(0).getAcknowledgementDetail().get(0).getCode()
						.getCode();

			if (null != rootElement.getAcknowledgement().get(0).getAcknowledgementDetail().get(0).getText())
				detailText = rootElement.getAcknowledgement().get(0).getAcknowledgementDetail().get(0).getText()
						.getMixed().get(0).toString();

			if (rootElement.getAcknowledgement().get(0).getAcknowledgementDetail().get(0).getLocation() != null
					&& !rootElement.getAcknowledgement().get(0).getAcknowledgementDetail().get(0).getLocation()
							.isEmpty())
				detailText += " Location: " + rootElement.getAcknowledgement().get(0).getAcknowledgementDetail().get(0)
						.getLocation().get(0).getMixed().get(0).toString();

			this.setAcknowledgementDetail(detailCode, detailText, null, null);
		}
	}

}
