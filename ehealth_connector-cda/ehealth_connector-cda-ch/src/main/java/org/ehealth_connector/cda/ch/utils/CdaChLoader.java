/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/
package org.ehealth_connector.cda.ch.utils;

import java.io.InputStream;
import java.lang.reflect.Constructor;

import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.ch.CHPackage;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil;

/**
 * <div class="en">A helper class to load specific clinical documents.</div>
 * <div class="de">Eine Hilfsklasse zum laden von CH clinical dokumente.</div>
 */
public class CdaChLoader<T> {

	/**
	 * <div class="en">Loads a CdaCh document from an input stream and
	 * instantiate to a given type.</div>
	 *
	 * <div class="de">Lädt ein CdaCh aus einem inputstream und instanziert
	 * object vom angegebenen typ.</div>
	 *
	 * <div class="fr"></div>
	 *
	 * <div class="it"></div>
	 *
	 * @param input
	 *            the inputstream
	 * @param aClazz
	 *            the class to be instantiated
	 * @param aConstrParam
	 *            the constructor parameter of the aClazz
	 * @return the instance of aClazz
	 * @throws Exception
	 *             fails on loading and instantiating
	 */
	public T loadFromStream(InputStream input, Class<T> aClazz, Class<?> aConstrParam)
			throws Exception {
		// Explicit initialization
		CHPackage.eINSTANCE.eClass();

		// load the clinical document
		final ClinicalDocument clinicalDocument = CDAUtil.load(input);

		// get the constructor
		final Constructor<T> constr = aClazz.getConstructor(aConstrParam);
		// the instance
		final T retVal = constr.newInstance(clinicalDocument);
		return retVal;

	}

}
