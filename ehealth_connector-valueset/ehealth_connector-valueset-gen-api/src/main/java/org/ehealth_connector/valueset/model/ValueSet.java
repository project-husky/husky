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

import java.util.Date;
import java.util.List;

import org.ehealth_connector.common.basetypes.CodeBaseType;
import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.valueset.enums.ValueSetStatusEnum;

/**
 * Java Prototype for Value Set Management Concept.
 */
public interface ValueSet {

	public void addMappingIdentificator(IdentificatorBaseType value);

	public void addMappingName(String value);

	public void addValueSetEntry(ValueSetEntry value);

	public String getDecription();

	public String getDisplayName();

	public Date getEffectiveDate();

	public IdentificatorBaseType getIdentificator();

	public String getName();

	public ValueSetStatusEnum getStatus();

	public ValueSetEntry getValueSetEntryByCode(CodeBaseType value);

	public ValueSetEntry getValueSetEntryByMappingCode(CodeBaseType value);

	public ValueSetEntry getValueSetEntryByMappingName(String value);

	public Version getVersion();

	public List<IdentificatorBaseType> listMappingIdentificator();

	public List<String> listMappingNames();

	public List<ValueSetEntry> listValueSetEntries();

	public void setDecription(String value);

	public void setDisplayName(String value);

	public void setEffectiveDate(Date value);

	public void setIdentificator(IdentificatorBaseType value);

	public void setName(String value);

	public void setStatus(ValueSetStatusEnum value);

	public void setVersion(Version value);

	// Terminologieserver: Verantwortliche Organisation bei
	// assigningAuthorityName in der ID angeben?

	/*
	 * public void addMappingId(String valueSetEntryMappingId); public
	 * List<String> listMappingIds();
	 *
	 * public void addValueSetEntryMappingCode(CodeBaseType
	 * valueSetEntryMappingCode, ValueSetEntry valueSetEntry);
	 *
	 * public void addValueSetEntryMappingName(String valueSetEntryMappingName,
	 * ValueSetEntry valueSetEntry);
	 *
	 * public List<CodeBaseType> listValueSetEntryMappingCodes(ValueSetEntry
	 * valueSetEntry); public List<String>
	 * listValueSetEntryMappingNames(ValueSetEntry valueSetEntry);
	 */
}
