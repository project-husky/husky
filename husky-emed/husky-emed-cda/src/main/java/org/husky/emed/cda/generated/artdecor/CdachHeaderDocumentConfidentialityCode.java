/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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
package org.husky.emed.cda.generated.artdecor;

import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.CE;

/**
 * cdach_header_DocumentConfidentialityCode
 * <p>
 * Template description: A confidentiality level of a CDA document instance according to the Swiss EPR regulation. All CDA-CH V2 derivatives, i.e. Swiss exchange formats MUST reference this template.Language dependent references to the Swiss EPR regulation:
 * - en: Federal Act on the Electronic Patient Record (EPRA), FDHA Ordinance on the Electronic Patient Record (EPRO-FDHA), Appendix 3 (Metadata)
 * - de: Bundesgesetz über das elektronische Patientendossier (EPDG), Verordnung des EDI über das elektronische Patientendossier (EPDV-EDI), Anhang 3 (Metadaten)
 * - fr: Loi fédérale sur le dossier électronique du patient (LDEP), Ordonnance du DFI sur le dossier électronique du patient (ODEP-DFI), Annexe 3 (Métadonnées)
 * - it: Legge federale sulla cartella informatizzata del paziente (LCIP), Ordinanza del DFI sulla cartella informatizzata del paziente (OCIP-DFI), Allegato 3 (Metadati)<br>
 * Element description: Swiss Realm of Confidentiality Code according to the Swiss EPR regulation.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.2.19<br>
 * Effective date: 2019-09-12 14:08:42<br>
 * Version: 2019<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-11-24")
public class CdachHeaderDocumentConfidentialityCode extends CE {

    public CdachHeaderDocumentConfidentialityCode() {
    }
}
