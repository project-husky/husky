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

package org.ehealth_connector.communication.mpi.impl.pix;

import org.ehealth_connector.communication.mpi.V3Acknowledgement;

import net.ihe.gazelle.hl7v3.mcciin000002UV01.MCCIIN000002UV01Type;

/**
 * @author <a href="mailto:anthony.larocca@sage.com">Anthony Larocca</a>
 *
 */
public class V3PixSourceAcknowledgement extends V3Acknowledgement {

	/**
	 * This class extends V3Acknowledgement with no changes. Creates an Acknowledgement object from the provided XML element.
	 * 
	 * @param v3Acknowledgement
	 *            - the XML Ack returned from the server.
	 * @throws Exception
	 */
	public V3PixSourceAcknowledgement(MCCIIN000002UV01Type v3Acknowledgement) throws Exception {
		super(v3Acknowledgement);
	}
}
