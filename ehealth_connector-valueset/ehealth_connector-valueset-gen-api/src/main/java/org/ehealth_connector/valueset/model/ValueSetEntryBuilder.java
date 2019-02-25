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
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.valueset.model;

import org.ehealth_connector.common.basetypes.CodeBaseType;
import org.ehealth_connector.valueset.enums.ValueSetEntryTypeEnum;

public interface ValueSetEntryBuilder {
	public ValueSetEntryBuilder codeBaseType(CodeBaseType value);

	public ValueSetEntry createValueSetEntry();

	public ValueSetEntryBuilder defaultMappingName(String value);

	public ValueSetEntryBuilder level(int value);

	public ValueSetEntryBuilder valueSetEntryType(ValueSetEntryTypeEnum value);

}
