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

import java.util.List;

import org.ehealth_connector.common.basetypes.CodeBaseType;
import org.ehealth_connector.valueset.enums.ValueSetEntryTypeEnum;

/**
 * Java Prototype for Value Set Management Concept.
 */
public interface ValueSetEntry {
	public void addChild(ValueSetEntry value);

	public void addMappingCode(CodeBaseType value);

	public void addMappingName(String value);

	public CodeBaseType getCodeBaseType();

	public String getDefaultMappingName();

	public int getLevel();

	public ValueSetEntryTypeEnum getValueSetEntryType();

	public List<ValueSetEntry> listChildren();

	public List<CodeBaseType> listMappingCodes();

	public List<String> listMappingNames();

	public void setCodeBaseType(CodeBaseType value);

	public void setDefaultMappingName(String value);

	public void setLevel(int value);

	public void setValueSetEntryType(ValueSetEntryTypeEnum value);

}
