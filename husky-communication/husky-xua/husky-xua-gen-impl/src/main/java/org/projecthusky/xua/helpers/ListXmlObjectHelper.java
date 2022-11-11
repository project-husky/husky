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
package org.projecthusky.xua.helpers;

import java.util.ArrayList;
import java.util.List;

import org.opensaml.core.xml.XMLObject;

/**
 * <!-- @formatter:off -->
 * <div class="en">Helper class providing methods to get filtered lists.</div>
 * <div class="de">Helferklasse welche Methoden zur Verfügung stellt um gefilterte Listen zu erhalten.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 * @param <T> the type
 */
public class ListXmlObjectHelper<T extends XMLObject> {
	/**
	 * Methodt to get compeonent
	 * 
	 * @param aType a type
	 * @param aList the list to fitler
	 * @return the found element or null
	 */
	@SuppressWarnings("unchecked")
	public T getComponent(Class<? extends XMLObject> aType, List<XMLObject> aList) {
		for (final XMLObject item : aList) {
			if (item.getClass().equals(aType)) {
				return (T) item;
			}
		}
		return null;
	}

	/**
	 * Methodt to get list filtered by type
	 * 
	 * @param aType a type
	 * @param aList the list to be filtered
	 * @return the filtered list
	 */
	@SuppressWarnings("unchecked")
	public List<T> getComponentList(Class<? extends XMLObject> aType, List<XMLObject> aList) {
		final List<T> retVal = new ArrayList<>();
		for (final XMLObject item : aList) {
			if (item.getClass().equals(aType)) {
				retVal.add((T) item);
			}
		}
		return retVal;
	}
}
