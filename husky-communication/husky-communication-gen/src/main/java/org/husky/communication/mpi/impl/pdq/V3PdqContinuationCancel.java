/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
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
}
