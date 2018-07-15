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
package org.ehealth_connector.cda.ch.utils;

import java.io.InputStream;
import java.lang.reflect.Constructor;

import org.ehealth_connector.cda.ch.CdaChV2StructuredBody;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.ch.ChPackage;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil;

/**
 * <div class="en">A helper class to load specific clinical documents.</div>
 * <div class="de">Eine Hilfsklasse zum laden von CH clinical dokumente.</div>
 */
public class CdaChLoader<T> {

	public CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> loadCdaChV2StructuredBodyFromStream(
			InputStream inputStream) throws Exception {
		// Explicit initialization
		ChPackage.eINSTANCE.eClass();

		// load the clinical document
		final ClinicalDocument clinicalDocument = CDAUtil.load(inputStream);

		// the instance
		final CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> retVal = new CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody>(
				(org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody) clinicalDocument);
		return retVal;
	}

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
		ChPackage.eINSTANCE.eClass();

		// load the clinical document
		final ClinicalDocument clinicalDocument = CDAUtil.load(input);

		// get the constructor
		final Constructor<T> constr = aClazz.getConstructor(aConstrParam);
		// the instance
		final T retVal = constr.newInstance(clinicalDocument);
		return retVal;

	}

}
