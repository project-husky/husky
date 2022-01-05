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
package org.husky.communication.mpi.impl.pdq;

import org.husky.communication.utils.PixPdqV3Utils;

/**
 * @author <a href="mailto:anthony.larocca@sage.com">Anthony Larocca</a>
 *
 */
public class V3PdqContinuationCancel extends V3PdqContinuationBase {

	/**
	 * Create a Continuation of type Cancel with the provided sender, receiver and original response
	 * 
	 * @param senderApplicationOID
	 *            (Sender Device ID)
	 * @param senderFacilityOID
	 *            (Sender Organization ID)
	 * @param receiverApplicationOID
	 *            (Receiver Device ID)
	 * @param receiverFacilityOID
	 *            (Receiver Organization ID)
	 * @param v3pdqresponse
	 *            (The original V3 PDQ Response)
	 */
	public V3PdqContinuationCancel(String senderApplicationOID, String senderFacilityOID, String receiverApplicationOID,
			String receiverFacilityOID, V3PdqConsumerResponse v3pdqresponse) {

		// set everything up
		super(senderApplicationOID, senderFacilityOID, receiverApplicationOID, receiverFacilityOID, v3pdqresponse);

		// set the values unique to cancellation
		this.queryContinuation.setStatusCode(PixPdqV3Utils.createCS("aborted"));

		// set the quantity to return to zero
		this.queryContinuation.setContinuationQuantity(PixPdqV3Utils.createINT1(0));

	}

	@Override
	protected void addControlActProcess() {
		// TODO Auto-generated method stub

	}
}
