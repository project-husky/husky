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
package org.projecthusky.valueset.enums;

/**
 * <div class="en">The content of the enum is as given by ART-DECOR. In case of
 * a possible implementation of the interface to the terminology server, a
 * mapping to the available statuses in the terminology server need to be made.
 * ART-DECOR documentation for statusCode (see
 * https://art-decor.org/mediawiki/index.php?title=DECOR-terminology): The
 * mandatory status of a defining value set. According to the Business
 * Requirements for Value Set Registries ART-DECOR uses the following subset of
 * status codes of a value set.</div>
 *
 * <div class="de">Der Inhalt des Enums ist wie von ART-DECOR vorgegeben. Bei
 * einer allfälligen Implementierung der Schnittstelle zum Terminologieserver
 * muss hier evtl. ein Mapping zu den verfügbaren Stati im Terminologieserver
 * gemacht werden. ART-DECOR-Dokumentation für statusCode (siehe
 * https://art-decor.org/mediawiki/index.php?title=DECOR-terminology): Der
 * obligatorische Status ValueSets. ART-DECOR verwendet die folgende Teilmenge
 * von Statuscodes eines Wertesatzes.</div>.
 */
public enum ValueSetStatus {

	/**
	 * <div class="en">Value set is withdrawn. Don't use it.</div>
	 *
	 * <div class="de">Die Entwicklung am ValueSet wurde abgebrochen. Nicht
	 * verwenden.</div>
	 */
	CANCELLED,

	/**
	 * <div class="en">Value set retired: No longer fit for use. Information
	 * available for historical reference.</div>
	 *
	 * <div class="de">Veraltetes ValueSet: Nicht mehr einsatzbereit.
	 * Informationen nur als historische Referenz verfügbar.</div>
	 */
	DEPRECATED,

	/**
	 * <div class="en">Value set under development (nascent). Metadata and value
	 * set may be incomplete. Entered primarily to encourage other users to be
	 * aware of ongoing process.</div>
	 *
	 * <div class="de">In Entwicklung befindliches ValueSet (Entwurf). Metadaten
	 * und Inhalt sind möglicherweise unvollständig. Wird in erster Linie
	 * verwendet, um andere Benutzer zu ermutigen, sich des laufenden Prozesses
	 * bewusst zu werden.</div>
	 */
	DRAFT,

	/**
	 * <div class="en">Value set has been published by the custodian
	 * organization and deemed fit for use. May have associated adoption and
	 * annotation metadata.</div>
	 *
	 * <div class="de">Das ValueSet wurde vom Herausgeber veröffentlicht und als
	 * gebrauchstauglich eingestuft.</div>
	 */
	FINAL,

	/**
	 * <div class="en">Value set just created and is new and work in progress to
	 * become a draft/finalized value set. Beyond the author, nobody should look
	 * at this value set unless it's status code is draft or finalized.</div>
	 *
	 * <div class="de">ValueSet, das gerade erstellt wurde und neu und in Arbeit
	 * ist. Ausser dem Autor des ValueSets sollte sich niemand mit diesem
	 * ValueSet befassen.</div>
	 */
	NEW,

	/**
	 * <div class="en">Value set is rejected. Don't use it.</div>
	 *
	 * <div class="de">Das ValueSet wurde verworfen. Nicht verwenden.</div>
	 */
	REJECTED;

}
