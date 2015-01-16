/*******************************************************************************
*
* The authorship of this code and the accompanying materials is held by
* medshare GmbH, Switzerland. All rights reserved.
* http://medshare.net
*
* Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
*
* This code is are made available under the terms of the
* Eclipse Public License v1.0.
*
* Accompanying materials are made available under the terms of the
* Creative Commons Attribution-ShareAlike 3.0 Switzerland License.
*
* Year of publication: 2014
*
*******************************************************************************/

package org.ehc.cda;

import java.util.Date;
import java.util.Date;

/**
 * Eine Impfempfehlung
 */
public class ImmunizationRecommendation {
	private boolean intendedOrProposed;
	private boolean shallNotBeAdministerd;
	private String codedId;
	private Date startOfPossibleAppliance;
	private Date endOfPossibleAppliance;
	private String dataEnterer;
	private String responsibleHealthcareProfessional;
	private String tradeNameOfVaccine;
	private String WHOACTCode;

	/**
	 * Erzeugt ein Objekt welches eine Impfempfehlung repräsentiert. Dieses Objekt
	 * kann einer ImmunizationRecommendationsSection hinzugefügt werden.
	 * 
	 * @param intendedOrProposed
	 *          true, bei einer beabsichtigten, aber noch nicht erfolgten Impfung.
	 *          false bei einer vorgeschlagenen Impfung.
	 * @param shallNotBeAdministerd
	 *          true, wenn die Impfung nicht verabreicht werden soll. false, wenn
	 *          die Impfung zu verabreichen ist.
	 * @param codedId
	 *          Packungs-GTIN, GLN oder swissINDEX
	 * @param startOfPossibleAppliance
	 *          Start des Zeitraums, in welchem die empfohlene Impfung verabreicht
	 *          werden soll.
	 * @param endOfPossibleAppliance
	 *          Ende des Zeitraums, in welchem die empfohlene Impfung verabreicht
	 *          werden soll.
	 * @param dataEnterer
	 *          Nachname der Person, die die Eintragung vornimmt
	 * @param responsibleHealthcareProfessional
	 *          Nachname Fachperson, die für die Impfung verantwortlich ist
	 * @param tradeNameOfVaccine
	 *          Handelsname des Impfstoffes
	 * @param whoACTCode
	 *          WHO ACT Code des Impfstoffes
	 */
	public ImmunizationRecommendation(boolean intendedOrProposed,
			boolean shallNotBeAdministerd, String codedId,
			Date startOfPossibleAppliance, Date endOfPossibleAppliance,
			String dataEnterer, String responsibleHealthcareProfessional,
			String tradeNameOfVaccine, String whoACTCode) {
		this.intendedOrProposed = intendedOrProposed;
		this.shallNotBeAdministerd = shallNotBeAdministerd;
		this.codedId = codedId;
		this.startOfPossibleAppliance = startOfPossibleAppliance;
		this.endOfPossibleAppliance = endOfPossibleAppliance;
		this.dataEnterer = dataEnterer;
		this.responsibleHealthcareProfessional = responsibleHealthcareProfessional;
		this.tradeNameOfVaccine = tradeNameOfVaccine;
		this.WHOACTCode = whoACTCode;
	}

	/**
	 * @return das codedId Objekt
	 */
	public String getCodedId() {
		return this.codedId;
	}

	/**
	 * @return das dataEnterer Objekt
	 */
	public String getDataEnterer() {
		return this.dataEnterer;
	}

	/**
	 * @return das endOfPossibleAppliance Objekt
	 */
	public Date getEndOfPossibleAppliance() {
		return this.endOfPossibleAppliance;
	}

	/**
	 * @return das responsibleHealthcareProfessional Objekt
	 */
	public String getResponsibleHealthcareProfessional() {
		return this.responsibleHealthcareProfessional;
	}

	/**
	 * @return das startOfPossibleAppliance Objekt
	 */
	public Date getStartOfPossibleAppliance() {
		return this.startOfPossibleAppliance;
	}

	/**
	 * @return das tradeNameOfVaccine Objekt
	 */
	public String getTradeNameOfVaccine() {
		return this.tradeNameOfVaccine;
	}

	/**
	 * @return das wHOACTCode Objekt
	 */
	public String getWHOACTCode() {
		return this.WHOACTCode;
	}

	/**
	 * @return das intendedOrProposed Objekt
	 */
	public boolean isIntendedOrProposed() {
		return this.intendedOrProposed;
	}

	/**
	 * @return das shallNotBeAdministerd Objekt
	 */
	public boolean isShallNotBeAdministerd() {
		return this.shallNotBeAdministerd;
	}

	/**
	 * @param codedId
	 *          das codedId Objekt welches gesetzt wird
	 */
	public void setCodedId(String codedId) {
		this.codedId = codedId;
	}

	/**
	 * @param dataEnterer
	 *          das dataEnterer Objekt welches gesetzt wird
	 */
	public void setDataEnterer(String dataEnterer) {
		this.dataEnterer = dataEnterer;
	}

	/**
	 * @param endOfPossibleAppliance
	 *          das endOfPossibleAppliance Objekt welches gesetzt wird
	 */
	public void setEndOfPossibleAppliance(Date endOfPossibleAppliance) {
		this.endOfPossibleAppliance = endOfPossibleAppliance;
	}

	/**
	 * @param intendedOrProposed
	 *          das intendedOrProposed Objekt welches gesetzt wird
	 */
	public void setIntendedOrProposed(boolean intendedOrProposed) {
		this.intendedOrProposed = intendedOrProposed;
	}

	/**
	 * @param responsibleHealthcareProfessional
	 *          das responsibleHealthcareProfessional Objekt welches gesetzt wird
	 */
	public void setResponsibleHealthcareProfessional(
			String responsibleHealthcareProfessional) {
		this.responsibleHealthcareProfessional = responsibleHealthcareProfessional;
	}

	/**
	 * @param shallNotBeAdministerd
	 *          das shallNotBeAdministerd Objekt welches gesetzt wird
	 */
	public void setShallNotBeAdministerd(boolean shallNotBeAdministerd) {
		this.shallNotBeAdministerd = shallNotBeAdministerd;
	}

	/**
	 * @param startOfPossibleAppliance
	 *          das startOfPossibleAppliance Objekt welches gesetzt wird
	 */
	public void setStartOfPossibleAppliance(Date startOfPossibleAppliance) {
		this.startOfPossibleAppliance = startOfPossibleAppliance;
	}

	/**
	 * @param tradeNameOfVaccine
	 *          das tradeNameOfVaccine Objekt welches gesetzt wird
	 */
	public void setTradeNameOfVaccine(String tradeNameOfVaccine) {
		this.tradeNameOfVaccine = tradeNameOfVaccine;
	}

	/**
	 * @param wHOACTCode
	 *          das wHOACTCode Objekt welches gesetzt wird
	 */
	public void setWHOACTCode(String wHOACTCode) {
		this.WHOACTCode = wHOACTCode;
	}

}
