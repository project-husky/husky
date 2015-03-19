/********************************************************************************
*
* The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
* All rights reserved. http://medshare.net
*
* Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
*
* This code is are made available under the terms of the Eclipse Public License v1.0.
*
* Accompanying materials are made available under the terms of the Creative Commons
* Attribution-ShareAlike 4.0 Switzerland License.
*
* Year of publication: 2015
*
********************************************************************************/


package org.ehealth_connector.common.ch;

/**
 * Auswahllisten für Schweiz-spezifische Wertemengen
 */
public class ConvenienceUtilsEnums {

  /**
   * Art der Patientenverfügung gemäss CDA-CH-VACD (Tabelle 22: Wertebereich
   * für „Art der Patientenverfügung“; SNOMED CT; 2.16.840.1.113883.6.96)
   * <ul>
   * <li>Resuscitation (Reanimation; 304251008)</li>
   * <li>Intubation (Intubation; 52765003)</li>
   * <li>IVFluidAndSupport (Infusionen und andere intravenöse Massnahmen;
   * 225204009)</li>
   * <li>CPR (Herz- Lungen-Wiederbelebung; 89666000)</li>
   * <li>Antibiotics (Antibiotika; 281789004)</li>
   * <li>LifeSupport (Lebenserhaltende Massnahmen; 78823007)</li>
   * <li>TubeFeedings (Sonden-Ernährung; 61420007)</li>
   * <li>TransfusionOfBloodProduct (Transfusion von Blutprodukten; 116859006)</li>
   * <li>OtherDirective (andere Verfügung; 71388002)</li>
   * </ul>
   * 
   */
  public enum AdvanceDirectiveTypeCdaChVacd {
    /**
     * Reanimation (SNOMED-CT Code: 304251008)
     */
    Resuscitation,
    /**
     * Intubation (SNOMED-CT Code: 52765003)
     */
    Intubation,
    /**
     * Infusionen und andere intravenöse Massnahmen (SNOMED-CT Code:
     * 225204009)
     */
    IVFluidAndSupport,
    /**
     * Herz- Lungen-Wiederbelebung (CPR) (SNOMED-CT Code: 89666000)
     */
    CPR,
    /**
     * Antibiotika (SNOMED-CT Code: 281789004)
     */
    Antibiotics,
    /**
     * Lebenserhaltende Massnahmen (SNOMED-CT Code: 78823007)
     */
    LifeSupport,
    /**
     * Sonden-Ernährung (SNOMED-CT Code: 61420007)
     */
    TubeFeedings,
    /**
     * Transfusion von Blutprodukten (SNOMED-CT Code: 116859006)
     */
    TransfusionOfBloodProduct,
    /**
     * andere Verfügung (SNOMED-CT Code: 71388002)
     */
    OtherDirective
  }

  public enum AgreementStatusCode {
    agreementConfirmed, agreementDecilned
  }

  /**
   * Substanz für Allergie oder Unverträglichkeit
   * 
   */
  public enum AllergySubstanceType {
    /**
     * Hühnereiweiss (SNOMED-CT Code: 303300008)
     */
    EggProtein
  }

  /**
   * Gemäss S&A Empfehlungen II, Anhang 4: Liste der Fachrichtungen In der
   * nachfolgenden Tabelle ist die Liste der Fachrichtungen gemäss der
   * Verordnung über Diplome, Ausbildung, Weiterbildung und Berufsausübung in
   * den universitären Medizinalberufen vom 27. Juni 2007, Anhang 1,
   * abgebildet.
   * 
   */
  public enum AuthorRoleCode {
    /**
     * Allgemeinmedizin (Code: noch nicht definiert von eHealth Suisse...)
     */
    GP
  }

  /**
   * Gemäss S&M Empfehlungen I, Anhang 4: Wertebereich Attribut
   * „authorSpecialty" Dieses Attribut ist ein beschreibendes Sub-Attribut von
   * „author" und dient der Beschreibung der Medizinischen Fachrichtung der
   * Person, welche ein Dokument verfasst hat. Diese Information kann für die
   * Suche und Filterung benutzt werden. Es ist denkbar, dass der Patient mit
   * dieser Information eine Hilfestellung erhält zum Setzen oder Verändern
   * der Vertraulichkeitsstufe von Dokumenten, welche relevant ist für die
   * Zugriffssteuerung. Passende internationale Codes werden in einem nächsten
   * Schritt definiert und können später in den IT-Systemen entsprechend
   * abgeglichen werden.
   */
  public enum AuthorSpecialityCode {
    /**
     * Fachärztin/Facharzt für Allgemeine Innere Medizin
     * (EPD_XDS_authorSpecialty Code: 50001)
     */
    GP
  }

  /**
   * Gemäss S&A Empfehlungen II, Anhang 3: Dokumentenkategorien Die
   * nachfolgende Tabelle ist Bestandteil von prCEN 13606 / 2000 als Anhang 4.
   * 
   * TODO: Enum vervollständigen (nur Minimum für Demo enthalten)
   */
  public enum DocumentCategoryCode {
    /**
     * Notes on Consultations (Code: DTC01)
     */
    NoteOnConsultation
  }

  /**
   * Gemäss S&M Empfehlungen I, Anhang 2: Wertebereich Attribut
   * „healthcareFacilityTypeCode" Dieser Code beschreibt den Typ der
   * Gesundheitseinrichtung, in der das Dokument während des
   * Behandlungsprozesses erstellt wurde. Der Patient kann im Zusammenhang mit
   * der Berechtigungsteuerung diese Information nutzen, um beispielsweise in
   * seinen Rechteattributen allen Dokumenten aus einem bestimmten
   * Gesundheitseinrichtungstyp eine bestimmte Vertraulichkeitsstufe
   * zuzuordnen. Passende internationale Codes werden in einem nächsten
   * Schritt definiert und können später in den IT-Systemen entsprechend
   * abgeglichen werden.
   * 
   * TODO: Enum vervollständigen (nur Minimum für Demo enthalten)
   */
  public enum HealthcareFacilityTypeCode {
    /**
     * Hausarztpraxis (EPD_XDS_healthcareFacilityTypeCode: 190010)
     */
    GP
  }

  /**
   * Typen von Partizipationen am Dokument Insurance (Versicherung;COV/PAYOR)
   */
  public enum ParticipantType {
    Insurance
  }

  /**
   * Gemäss S&M Empfehlungen I, Anhang 3: Wertebereich Attribut
   * „practiceSettingCode" Dieses Attribut soll den Inhalt eines Dokumentes
   * einer medizinischen Fachrichtung zuordnen. Es ist denkbar, dass der
   * Patient mit dieser Information eine Hilfestellung erhält zum Setzen oder
   * Verändern der Vertraulichkeitsstufe von Dokumenten, welche relevant ist
   * für die Zugriffs steurung. Passende internationale Codes werden in einem
   * nächsten Schritt definiert und können später in den IT-Systemen
   * entsprechend abgeglichen werden.
   * 
   * TODO: Enum vervollständigen (nur Minimum für Demo enthalten)
   * 
   */
  public enum PracticeSettingCode {
    /**
     * Allgemeinmedizin (EPD_XDS_practiceSettingCode: 260002)
     */
    GP
  }

}
