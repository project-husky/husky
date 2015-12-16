/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/
package org.ehealth_connector.common.enums;

import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;

/**
 * @since Sep 22, 2015 10:00:45 AM
 */
public interface CodedMetadataEnumInterface {
	/**
	 * <div class="en">Gets the CodeMetadataType</div> <div class="de">Liefert
	 * das OHT CodedMetadataType Objekt</div>
	 *
	 * @return the enum as codedMetadataType
	 */
	public CodedMetadataType getCodedMetadataType();
}
