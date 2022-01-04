package org.husky.valueset.model;

import java.util.ArrayList;
import java.util.List;

import org.husky.common.basetypes.IdentificatorBaseType;

public class ValueSetBase {

	/** The identificator. */
	private IdentificatorBaseType identificator;

	/** The mapping identificator list. */
	private List<IdentificatorBaseType> mappingIdentificatorList;

	/** The mapping name list. */
	private List<String> mappingNameList;

	/** The version. */
	private Version version;

	/**
	 * <div class="en">Adds a mapping identificator.</div>
	 *
	 * <div class="de">Fügt einen Zuordnungsidentifikator hinzu.</div>
	 *
	 * @param value the value
	 */
	public void addMappingIdentificator(IdentificatorBaseType value) {
		if (this.mappingIdentificatorList == null)
			this.mappingIdentificatorList = new ArrayList<>();

		this.mappingIdentificatorList.add(value);
	}

	/**
	 * <div class="en">Adds a mapping name.</div>
	 *
	 * <div class="de">Fügt einen Zuordnungsnamen hinzu.</div>
	 *
	 * @param value the value
	 */
	public void addMappingName(String value) {
		if (this.mappingNameList == null)
			this.mappingNameList = new ArrayList<>();

		this.mappingNameList.add(value);
	}

	/**
	 * <div class="en">Clears the mapping identificator list.</div>
	 *
	 * <div class="de">Löscht die Liste der Zuordnungsidentifikatoren.</div>
	 */
	public void clearMappingIdentificatorList() {
		this.mappingIdentificatorList = new ArrayList<>();
	}

	/**
	 * <div class="en">Clears the mapping name list.</div>
	 *
	 * <div class="de">Löscht die Liste der Zuordnungsnamen.</div>
	 */
	public void clearMappingNameList() {
		this.mappingNameList = new ArrayList<>();
	}

	/**
	 * <div class="en">Checks whether the list member contains the given
	 * value.</div>
	 *
	 * <div class="de">Überprüft, ob die Liste den angegebenen Wert enthält.</div>
	 * Contains.
	 *
	 * @param value the value
	 * @return true, if successful
	 */
	public boolean containsMappingIdentificator(IdentificatorBaseType value) {
		if (mappingIdentificatorList != null) {
			for (IdentificatorBaseType entry : mappingIdentificatorList) {
				if (entry.equals(value)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * <div class="en">Checks whether the list member contains the given
	 * value.</div>
	 *
	 * <div class="de">Überprüft, ob die Liste den angegebenen Wert enthält.</div>
	 * Contains.
	 *
	 * @param value the value
	 * @return true, if successful
	 */
	public boolean containsMappingName(String value) {
		if (mappingNameList != null) {
			for (String entry : mappingNameList) {
				if (entry.equals(value)) {
					return true;
				}
			}
		}
		return false;
	}

	protected boolean compareIdentificator(ValueSetBase obj) {
		var retVal = true;
		if (this.identificator == null)
			retVal = (obj.getIdentificator() == null);
		else
			retVal = this.identificator.equals(obj.getIdentificator());

		return retVal;
	}

	protected boolean compareMappingNameList(ValueSetBase obj) {
		var retVal = true;
		if (this.mappingNameList == null)
			this.mappingNameList = new ArrayList<>();
		retVal = (this.mappingNameList.size() == obj.getMappingNameList().size());
		if (retVal) {
			for (var i = 0; i < this.mappingNameList.size(); i++) {
				retVal = obj.containsMappingName(this.mappingNameList.get(i));
				if (!retVal)
					break;
			}
		}

		return retVal;
	}

	protected boolean compareMappingIdentificatorList(ValueSetBase obj) {
		var retVal = true;
		if (this.mappingIdentificatorList == null)
			this.mappingIdentificatorList = new ArrayList<>();
		retVal = (this.mappingIdentificatorList.size() == obj.getMappingIdentificatorList().size());
		if (retVal) {
			for (var i = 0; i < this.mappingIdentificatorList.size(); i++) {
				retVal = obj.containsMappingIdentificator(this.mappingIdentificatorList.get(i));
				if (!retVal)
					break;
			}
		}

		return retVal;
	}

	protected boolean compareVersion(ValueSetBase obj) {
		var retVal = true;
		if (this.getVersion() == null)
			retVal = (obj.getVersion() == null);
		else
			retVal = this.getVersion().equals(obj.getVersion());

		return retVal;
	}

	/**
	 * <div class="en">Gets the identificator.</div>
	 *
	 * <div class="de">Ruft den Identifikator ab.</div>
	 *
	 * @return the identificator
	 */
	public IdentificatorBaseType getIdentificator() {
		return identificator;
	}

	/**
	 * <div class="en">Gets the mapping identificator list.</div>
	 *
	 * <div class="de">Ruft die Liste der Zuordnungsidentifikatoren ab.</div>
	 *
	 * @return the mapping identificator list
	 */
	public List<IdentificatorBaseType> getMappingIdentificatorList() {
		if (mappingIdentificatorList == null) {
			mappingIdentificatorList = new ArrayList<>();
		}
		return mappingIdentificatorList;
	}

	/**
	 * <div class="en">Gets the mapping name list.</div>
	 *
	 * <div class="de">Ruft die Liste der Zuordnungsnamen ab.</div>
	 *
	 * @return the mapping name list
	 */
	public List<String> getMappingNameList() {
		if (mappingNameList == null) {
			mappingNameList = new ArrayList<>();
		}
		return mappingNameList;
	}

	/**
	 * <div class="en">Gets the version.</div>
	 *
	 * <div class="de">Ruft die Version ab.</div>
	 *
	 * @return the version
	 */
	public Version getVersion() {
		return version;
	}

	/**
	 * <div class="en">Sets the identificator.</div>
	 *
	 * <div class="de">Legt den Identifikator fest.</div>
	 *
	 * @param identificator the new identificator
	 */
	public void setIdentificator(IdentificatorBaseType identificator) {
		this.identificator = identificator;
	}

	/**
	 * <div class="en">Sets the mapping identificator list.</div>
	 *
	 * <div class="de">Legt die Liste der Zuordnungsidentifikatoren fest.</div>
	 *
	 * @param mappingIdentificatorList the new mapping identificator list
	 */
	public void setMappingIdentificatorList(List<IdentificatorBaseType> mappingIdentificatorList) {
		this.mappingIdentificatorList = mappingIdentificatorList;
	}

	/**
	 * <div class="en">Sets the mapping name list.</div>
	 *
	 * <div class="de">Legt die Liste der Zuordnungsnamen fest.</div>
	 *
	 * @param mappingNameList the new mapping name list
	 */
	public void setMappingNameList(List<String> mappingNameList) {
		this.mappingNameList = mappingNameList;
	}

	/**
	 * <div class="en">Sets the version.</div>
	 *
	 * <div class="de">Legt die Version fest.</div>
	 *
	 * @param version the new version
	 */
	public void setVersion(Version version) {
		this.version = version;
	}

}
