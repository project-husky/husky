/*
 *
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

package org.ehealth_connector.codegenerator.ch.valuesets.model;

import java.util.List;

/**
 * <div class="en">This POJO class is used to parse the configuration from the
 * file <code>valuesets-sources.yaml</code> into an object for easier
 * handling</div>
 */
public class ValueSetConfiguration {

	private String baseUrl;

	private List<ValueSet> valueSets;

	/**
	 * <div class="en">Gets the base URL that is used to download the value sets
	 * in JSON</div>
	 * 
	 * @return
	 */
	public String getBaseUrl() {
		return baseUrl;
	}

	/**
	 * <div class="en">Gets the list of all configured value sets that will be
	 * generated from the CH-EPR value set repository</div>
	 * 
	 * @return
	 */
	public List<ValueSet> getValueSets() {
		return valueSets;
	}

	/**
	 * <div class="en">Sets the base URL that is used to download the value sets
	 * in JSON</div>
	 * 
	 * @param baseUrl
	 */
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	/**
	 * <div class="en">Sets the list of all configured value sets that will be
	 * generated from the CH-EPR value set repository</div>
	 * 
	 * @param valueSets
	 */
	public void setValueSets(List<ValueSet> valueSets) {
		this.valueSets = valueSets;
	}
}
