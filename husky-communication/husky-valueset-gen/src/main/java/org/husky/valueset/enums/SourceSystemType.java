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
package org.husky.valueset.enums;

/**
 * <div class="en">This enum is used to configure the type of source of a
 * ValueSet. This information is used to apply the interface corresponding to
 * the source system. Note: TERMINOLOGIESERVER_SOAP and SWISS_MDI_SOAP are
 * foreseen, but are not going to be implemented in the first release of dynamic
 * value set handling.</div>
 *
 * <div class="de">Dieses Enum dient dazu, dass die Art der Quelle eines
 * ValueSets konfiguriert werden kann. Anhand dieser Fallunterscheidung wird
 * die, dem Quellsystem entsprechende Schnittstelle angewendet. Hinweis:
 * TERMINOLOGIESERVER_SOAP und SWISS_MDI_SOAP sind vorgesehen, werden jedoch in
 * der ersten Version dynamischen Value Set handlings nicht
 * implementiert.</div>.
 */
public enum SourceSystemType {

	/**
	 * <div class="en">Using this source type, the HL7 FHIR interface to
	 * ART-DECOR will be used (e.g.
	 * http://art-decor.org/fhir/3.0/ch-epr-/valueset).</div>
	 *
	 * <div class="de">Bei Verwendung dieses Quellentyps wird die HL7 FHIR
	 * Schnittstelle zu ART-DECOR verwendet (z.B.
	 * http://art-decor.org/fhir/3.0/ch-epr-/valueset).</div>
	 */
	ARTDECOR_FHIR;

	// TODO: These interfaces are not going to be implemented in the first
	// release of dynamic value set handling.
	// /**
	// * <div class="en">Using this source type, the SOAP interface to
	// terminology
	// * server will be used (e.g.
	// * https://termpub.gesundheit.gv.at/TermBrowser/gui/main/main.zul).</div>
	// *
	// * <div class="de">Bei Verwendung dieses Quellentyps wird die SOAP
	// * Schnittstelle zu Terminologoie-Server verwendet (z.B.
	// * https://termpub.gesundheit.gv.at/TermBrowser/gui/main/main.zul).</div>
	// */
	// TERMINOLOGIESERVER_SOAP,
	//
	// /**
	// * <div class="en">Using this source type, the SOAP interface to the Swiss
	// * Metadata Index will be used (e.g.
	// * https://ws.epd-ad-a.bag.admin.ch/Mdi/ValueSetRepository.svc).</div>
	// *
	// * <div class="de">Bei Verwendung dieses Quellentyps wird die SOAP
	// * Schnittstelle zu Schweizerischen Metadaten Index verwendet (z.B.
	// * https://ws.epd-ad-a.bag.admin.ch/Mdi/ValueSetRepository.svc).</div>
	// */
	// SWISS_MDI_SOAP;

}
