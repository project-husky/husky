/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.fhir.emed.ch.epr.enums;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.enums.ValueSetEnumInterface;
import org.projecthusky.fhir.structures.utils.FhirValueSetEnumInterface;

/**
 * Enumeration of RouteOfAdministrationAmbu values
 * <p>
 * EN: Valueset RouteOfAdministration Ambu based on "RouteOfAdministration (EDQM)" (and EDQM, ROA, export 1.6.2021, see https://standardterms.edqm.eu/#), for ambulatory use.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.127.77.12.11.1<br>
 * Effective date: 2022-04-15 08:51<br>
 * Version: 2022<br>
 * Status: DRAFT
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2024-06-24")
public enum RouteOfAdministrationAmbu implements ValueSetEnumInterface, FhirValueSetEnumInterface {

    /**
     * EN: Auricular use.<br>
     * DE: Anwendung am Ohr.<br>
     * FR: Voie auriculaire.<br>
     * IT: Uso auricolare.<br>
     */
    AURICULAR_USE("20001000",
                  "0.4.0.127.0.16.1.1.2.1",
                  "Auricular use",
                  "Auricular use",
                  "Anwendung am Ohr",
                  "Voie auriculaire",
                  "Uso auricolare"),
    /**
     * EN: Buccal use.<br>
     * DE: Buccale Anwendung.<br>
     * FR: Voie buccogingivale.<br>
     * IT: Somministrazione buccale.<br>
     */
    BUCCAL_USE("20002500",
               "0.4.0.127.0.16.1.1.2.1",
               "Buccal use",
               "Buccal use",
               "Buccale Anwendung",
               "Voie buccogingivale",
               "Somministrazione buccale"),
    /**
     * EN: Cutaneous use.<br>
     * DE: Anwendung auf der Haut.<br>
     * FR: Voie cutanée.<br>
     * IT: Uso cutaneo.<br>
     */
    CUTANEOUS_USE("20003000",
                  "0.4.0.127.0.16.1.1.2.1",
                  "Cutaneous use",
                  "Cutaneous use",
                  "Anwendung auf der Haut",
                  "Voie cutanée",
                  "Uso cutaneo"),
    /**
     * EN: Dental use.<br>
     * DE: dentale Anwendung.<br>
     * FR: Voie dentaire.<br>
     * IT: Uso dentale.<br>
     */
    DENTAL_USE("20004000",
               "0.4.0.127.0.16.1.1.2.1",
               "Dental use",
               "Dental use",
               "dentale Anwendung",
               "Voie dentaire",
               "Uso dentale"),
    /**
     * EN: Endotracheopulmonary use.<br>
     * DE: endotracheopulmonale Anwendung.<br>
     * FR: Voie endotrachéobronchique.<br>
     * IT: Uso endotracheobronchiale.<br>
     */
    ENDOTRACHEOPULMONARY_USE("20008000",
                             "0.4.0.127.0.16.1.1.2.1",
                             "Endotracheopulmonary use",
                             "Endotracheopulmonary use",
                             "endotracheopulmonale Anwendung",
                             "Voie endotrachéobronchique",
                             "Uso endotracheobronchiale"),
    /**
     * EN: Epilesional use.<br>
     * DE: zum Auftragen auf die Wunde.<br>
     * FR: Voie épilésionnelle.<br>
     * IT: Uso epilesionale.<br>
     */
    EPILESIONAL_USE("20010000",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Epilesional use",
                    "Epilesional use",
                    "zum Auftragen auf die Wunde",
                    "Voie épilésionnelle",
                    "Uso epilesionale"),
    /**
     * EN: Gastric use.<br>
     * DE: zur Anwendung mittels Magensonde.<br>
     * FR: Voie gastrique.<br>
     * IT: Uso gastrico.<br>
     */
    GASTRIC_USE("20013500",
                "0.4.0.127.0.16.1.1.2.1",
                "Gastric use",
                "Gastric use",
                "zur Anwendung mittels Magensonde",
                "Voie gastrique",
                "Uso gastrico"),
    /**
     * EN: Gastroenteral use.<br>
     * DE: gastrointestinale Anwendung.<br>
     * FR: Voie gastro-entérale.<br>
     * IT: Uso gastrointestinale.<br>
     */
    GASTROENTERAL_USE("20013000",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Gastroenteral use",
                      "Gastroenteral use",
                      "gastrointestinale Anwendung",
                      "Voie gastro-entérale",
                      "Uso gastrointestinale"),
    /**
     * EN: Gingival use.<br>
     * DE: Anwendung am Zahnfleisch.<br>
     * FR: Voie gingivale.<br>
     * IT: Uso gengivale.<br>
     */
    GINGIVAL_USE("20014000",
                 "0.4.0.127.0.16.1.1.2.1",
                 "Gingival use",
                 "Gingival use",
                 "Anwendung am Zahnfleisch",
                 "Voie gingivale",
                 "Uso gengivale"),
    /**
     * EN: Haemodialysis.<br>
     * DE: Hämodialyse.<br>
     * FR: Hémodialyse.<br>
     * IT: Emodialisi.<br>
     */
    HAEMODIALYSIS("20015000",
                  "0.4.0.127.0.16.1.1.2.1",
                  "Haemodialysis",
                  "Haemodialysis",
                  "Hämodialyse",
                  "Hémodialyse",
                  "Emodialisi"),
    /**
     * EN: Inhalation use.<br>
     * DE: zur Inhalation.<br>
     * FR: Voie inhalée.<br>
     * IT: Uso inalatorio.<br>
     */
    INHALATION_USE("20020000",
                   "0.4.0.127.0.16.1.1.2.1",
                   "Inhalation use",
                   "Inhalation use",
                   "zur Inhalation",
                   "Voie inhalée",
                   "Uso inalatorio"),
    /**
     * EN: Intestinal use.<br>
     * DE: intestinale Anwendung.<br>
     * FR: Voie intestinale.<br>
     * IT: Uso intestinale.<br>
     */
    INTESTINAL_USE("20021000",
                   "0.4.0.127.0.16.1.1.2.1",
                   "Intestinal use",
                   "Intestinal use",
                   "intestinale Anwendung",
                   "Voie intestinale",
                   "Uso intestinale"),
    /**
     * EN: Intraepidermal use.<br>
     * DE: intraepidermale Anwendung.<br>
     * FR: Voie intraépidermique.<br>
     * IT: Uso intraepidermico.<br>
     */
    INTRAEPIDERMAL_USE("20031500",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Intraepidermal use",
                       "Intraepidermal use",
                       "intraepidermale Anwendung",
                       "Voie intraépidermique",
                       "Uso intraepidermico"),
    /**
     * EN: Intralesional use.<br>
     * DE: intraläsionale Anwendung.<br>
     * FR: Voie intralésionnelle.<br>
     * IT: Uso intralesionale.<br>
     */
    INTRALESIONAL_USE("20032000",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Intralesional use",
                      "Intralesional use",
                      "intraläsionale Anwendung",
                      "Voie intralésionnelle",
                      "Uso intralesionale"),
    /**
     * EN: Intramuscular use.<br>
     * DE: intramuskuläre Anwendung.<br>
     * FR: Voie intramusculaire.<br>
     * IT: Uso intramuscolare.<br>
     */
    INTRAMUSCULAR_USE("20035000",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Intramuscular use",
                      "Intramuscular use",
                      "intramuskuläre Anwendung",
                      "Voie intramusculaire",
                      "Uso intramuscolare"),
    /**
     * EN: Intrapleural use.<br>
     * DE: intrapleurale Anwendung.<br>
     * FR: Voie intrapleurale.<br>
     * IT: Uso intrapleurico.<br>
     */
    INTRAPLEURAL_USE("20039000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Intrapleural use",
                     "Intrapleural use",
                     "intrapleurale Anwendung",
                     "Voie intrapleurale",
                     "Uso intrapleurico"),
    /**
     * EN: Intrauterine use.<br>
     * DE: intrauterine Anwendung.<br>
     * FR: Voie intra-utérine.<br>
     * IT: Uso intrauterino.<br>
     */
    INTRAUTERINE_USE("20044000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Intrauterine use",
                     "Intrauterine use",
                     "intrauterine Anwendung",
                     "Voie intra-utérine",
                     "Uso intrauterino"),
    /**
     * EN: Intravenous use.<br>
     * DE: intravenöse Anwendung.<br>
     * FR: Voie intraveineuse.<br>
     * IT: Uso endovenoso.<br>
     */
    INTRAVENOUS_USE("20045000",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Intravenous use",
                    "Intravenous use",
                    "intravenöse Anwendung",
                    "Voie intraveineuse",
                    "Uso endovenoso"),
    /**
     * EN: Intravesical use.<br>
     * DE: intravesikale Anwendung.<br>
     * FR: Voie intravésicale.<br>
     * IT: Uso endovescicale.<br>
     */
    INTRAVESICAL_USE("20046000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Intravesical use",
                     "Intravesical use",
                     "intravesikale Anwendung",
                     "Voie intravésicale",
                     "Uso endovescicale"),
    /**
     * EN: Nasal use.<br>
     * DE: nasale Anwendung.<br>
     * FR: Voie nasale.<br>
     * IT: Uso nasale.<br>
     */
    NASAL_USE("20049000",
              "0.4.0.127.0.16.1.1.2.1",
              "Nasal use",
              "Nasal use",
              "nasale Anwendung",
              "Voie nasale",
              "Uso nasale"),
    /**
     * EN: Ocular use.<br>
     * DE: Anwendung am Auge.<br>
     * FR: Voie ophtalmique.<br>
     * IT: Uso oftalmico.<br>
     */
    OCULAR_USE("20051000",
               "0.4.0.127.0.16.1.1.2.1",
               "Ocular use",
               "Ocular use",
               "Anwendung am Auge",
               "Voie ophtalmique",
               "Uso oftalmico"),
    /**
     * EN: Oral use.<br>
     * DE: zum Einnehmen.<br>
     * FR: Voie orale.<br>
     * IT: Uso orale.<br>
     */
    ORAL_USE("20053000",
             "0.4.0.127.0.16.1.1.2.1",
             "Oral use",
             "Oral use",
             "zum Einnehmen",
             "Voie orale",
             "Uso orale"),
    /**
     * EN: Oromucosal use.<br>
     * DE: Anwendung in der Mundhöhle.<br>
     * FR: Voie buccale.<br>
     * IT: Per mucosa orale.<br>
     */
    OROMUCOSAL_USE("20054000",
                   "0.4.0.127.0.16.1.1.2.1",
                   "Oromucosal use",
                   "Oromucosal use",
                   "Anwendung in der Mundhöhle",
                   "Voie buccale",
                   "Per mucosa orale"),
    /**
     * EN: Oropharyngeal use.<br>
     * DE: zur Anwendung im Mund- und Rachenraum.<br>
     * FR: Voie oropharyngée.<br>
     * IT: Uso orofaringeo.<br>
     */
    OROPHARYNGEAL_USE("20055000",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Oropharyngeal use",
                      "Oropharyngeal use",
                      "zur Anwendung im Mund- und Rachenraum",
                      "Voie oropharyngée",
                      "Uso orofaringeo"),
    /**
     * EN: Rectal use.<br>
     * DE: rektale Anwendung.<br>
     * FR: Voie rectale.<br>
     * IT: Uso rettale.<br>
     */
    RECTAL_USE("20061000",
               "0.4.0.127.0.16.1.1.2.1",
               "Rectal use",
               "Rectal use",
               "rektale Anwendung",
               "Voie rectale",
               "Uso rettale"),
    /**
     * EN: Subcutaneous use.<br>
     * DE: subkutane Anwendung.<br>
     * FR: Voie sous-cutanée.<br>
     * IT: Uso sottocutaneo.<br>
     */
    SUBCUTANEOUS_USE("20066000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Subcutaneous use",
                     "Subcutaneous use",
                     "subkutane Anwendung",
                     "Voie sous-cutanée",
                     "Uso sottocutaneo"),
    /**
     * EN: Sublingual use.<br>
     * DE: Sublingual.<br>
     * FR: Voie sublinguale.<br>
     * IT: Uso sublinguale.<br>
     */
    SUBLINGUAL_USE("20067000",
                   "0.4.0.127.0.16.1.1.2.1",
                   "Sublingual use",
                   "Sublingual use",
                   "Sublingual",
                   "Voie sublinguale",
                   "Uso sublinguale"),
    /**
     * EN: Transdermal use.<br>
     * DE: transdermale Anwendung.<br>
     * FR: Voie transdermique.<br>
     * IT: Uso transdermico.<br>
     */
    TRANSDERMAL_USE("20070000",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Transdermal use",
                    "Transdermal use",
                    "transdermale Anwendung",
                    "Voie transdermique",
                    "Uso transdermico"),
    /**
     * EN: Urethral use.<br>
     * DE: Anwendung in der Harnröhre.<br>
     * FR: Voie urétrale.<br>
     * IT: Uso uretrale.<br>
     */
    URETHRAL_USE("20071000",
                 "0.4.0.127.0.16.1.1.2.1",
                 "Urethral use",
                 "Urethral use",
                 "Anwendung in der Harnröhre",
                 "Voie urétrale",
                 "Uso uretrale"),
    /**
     * EN: Vaginal use.<br>
     * DE: vaginale Anwendung.<br>
     * FR: Voie vaginale.<br>
     * IT: Uso vaginale.<br>
     */
    VAGINAL_USE("20072000",
                "0.4.0.127.0.16.1.1.2.1",
                "Vaginal use",
                "Vaginal use",
                "vaginale Anwendung",
                "Voie vaginale",
                "Uso vaginale");

    /**
     * EN: Code for Auricular use.<br>
     * DE: Code für Anwendung am Ohr.<br>
     * FR: Code de Voie auriculaire.<br>
     * IT: Code per Uso auricolare.<br>
     */
    public static final String AURICULAR_USE_CODE = "20001000";

    /**
     * EN: Code for Buccal use.<br>
     * DE: Code für Buccale Anwendung.<br>
     * FR: Code de Voie buccogingivale.<br>
     * IT: Code per Somministrazione buccale.<br>
     */
    public static final String BUCCAL_USE_CODE = "20002500";

    /**
     * EN: Code for Cutaneous use.<br>
     * DE: Code für Anwendung auf der Haut.<br>
     * FR: Code de Voie cutanée.<br>
     * IT: Code per Uso cutaneo.<br>
     */
    public static final String CUTANEOUS_USE_CODE = "20003000";

    /**
     * EN: Code for Dental use.<br>
     * DE: Code für dentale Anwendung.<br>
     * FR: Code de Voie dentaire.<br>
     * IT: Code per Uso dentale.<br>
     */
    public static final String DENTAL_USE_CODE = "20004000";

    /**
     * EN: Code for Endotracheopulmonary use.<br>
     * DE: Code für endotracheopulmonale Anwendung.<br>
     * FR: Code de Voie endotrachéobronchique.<br>
     * IT: Code per Uso endotracheobronchiale.<br>
     */
    public static final String ENDOTRACHEOPULMONARY_USE_CODE = "20008000";

    /**
     * EN: Code for Epilesional use.<br>
     * DE: Code für zum Auftragen auf die Wunde.<br>
     * FR: Code de Voie épilésionnelle.<br>
     * IT: Code per Uso epilesionale.<br>
     */
    public static final String EPILESIONAL_USE_CODE = "20010000";

    /**
     * EN: Code for Gastric use.<br>
     * DE: Code für zur Anwendung mittels Magensonde.<br>
     * FR: Code de Voie gastrique.<br>
     * IT: Code per Uso gastrico.<br>
     */
    public static final String GASTRIC_USE_CODE = "20013500";

    /**
     * EN: Code for Gastroenteral use.<br>
     * DE: Code für gastrointestinale Anwendung.<br>
     * FR: Code de Voie gastro-entérale.<br>
     * IT: Code per Uso gastrointestinale.<br>
     */
    public static final String GASTROENTERAL_USE_CODE = "20013000";

    /**
     * EN: Code for Gingival use.<br>
     * DE: Code für Anwendung am Zahnfleisch.<br>
     * FR: Code de Voie gingivale.<br>
     * IT: Code per Uso gengivale.<br>
     */
    public static final String GINGIVAL_USE_CODE = "20014000";

    /**
     * EN: Code for Haemodialysis.<br>
     * DE: Code für Hämodialyse.<br>
     * FR: Code de Hémodialyse.<br>
     * IT: Code per Emodialisi.<br>
     */
    public static final String HAEMODIALYSIS_CODE = "20015000";

    /**
     * EN: Code for Inhalation use.<br>
     * DE: Code für zur Inhalation.<br>
     * FR: Code de Voie inhalée.<br>
     * IT: Code per Uso inalatorio.<br>
     */
    public static final String INHALATION_USE_CODE = "20020000";

    /**
     * EN: Code for Intestinal use.<br>
     * DE: Code für intestinale Anwendung.<br>
     * FR: Code de Voie intestinale.<br>
     * IT: Code per Uso intestinale.<br>
     */
    public static final String INTESTINAL_USE_CODE = "20021000";

    /**
     * EN: Code for Intraepidermal use.<br>
     * DE: Code für intraepidermale Anwendung.<br>
     * FR: Code de Voie intraépidermique.<br>
     * IT: Code per Uso intraepidermico.<br>
     */
    public static final String INTRAEPIDERMAL_USE_CODE = "20031500";

    /**
     * EN: Code for Intralesional use.<br>
     * DE: Code für intraläsionale Anwendung.<br>
     * FR: Code de Voie intralésionnelle.<br>
     * IT: Code per Uso intralesionale.<br>
     */
    public static final String INTRALESIONAL_USE_CODE = "20032000";

    /**
     * EN: Code for Intramuscular use.<br>
     * DE: Code für intramuskuläre Anwendung.<br>
     * FR: Code de Voie intramusculaire.<br>
     * IT: Code per Uso intramuscolare.<br>
     */
    public static final String INTRAMUSCULAR_USE_CODE = "20035000";

    /**
     * EN: Code for Intrapleural use.<br>
     * DE: Code für intrapleurale Anwendung.<br>
     * FR: Code de Voie intrapleurale.<br>
     * IT: Code per Uso intrapleurico.<br>
     */
    public static final String INTRAPLEURAL_USE_CODE = "20039000";

    /**
     * EN: Code for Intrauterine use.<br>
     * DE: Code für intrauterine Anwendung.<br>
     * FR: Code de Voie intra-utérine.<br>
     * IT: Code per Uso intrauterino.<br>
     */
    public static final String INTRAUTERINE_USE_CODE = "20044000";

    /**
     * EN: Code for Intravenous use.<br>
     * DE: Code für intravenöse Anwendung.<br>
     * FR: Code de Voie intraveineuse.<br>
     * IT: Code per Uso endovenoso.<br>
     */
    public static final String INTRAVENOUS_USE_CODE = "20045000";

    /**
     * EN: Code for Intravesical use.<br>
     * DE: Code für intravesikale Anwendung.<br>
     * FR: Code de Voie intravésicale.<br>
     * IT: Code per Uso endovescicale.<br>
     */
    public static final String INTRAVESICAL_USE_CODE = "20046000";

    /**
     * EN: Code for Nasal use.<br>
     * DE: Code für nasale Anwendung.<br>
     * FR: Code de Voie nasale.<br>
     * IT: Code per Uso nasale.<br>
     */
    public static final String NASAL_USE_CODE = "20049000";

    /**
     * EN: Code for Ocular use.<br>
     * DE: Code für Anwendung am Auge.<br>
     * FR: Code de Voie ophtalmique.<br>
     * IT: Code per Uso oftalmico.<br>
     */
    public static final String OCULAR_USE_CODE = "20051000";

    /**
     * EN: Code for Oral use.<br>
     * DE: Code für zum Einnehmen.<br>
     * FR: Code de Voie orale.<br>
     * IT: Code per Uso orale.<br>
     */
    public static final String ORAL_USE_CODE = "20053000";

    /**
     * EN: Code for Oromucosal use.<br>
     * DE: Code für Anwendung in der Mundhöhle.<br>
     * FR: Code de Voie buccale.<br>
     * IT: Code per Per mucosa orale.<br>
     */
    public static final String OROMUCOSAL_USE_CODE = "20054000";

    /**
     * EN: Code for Oropharyngeal use.<br>
     * DE: Code für zur Anwendung im Mund- und Rachenraum.<br>
     * FR: Code de Voie oropharyngée.<br>
     * IT: Code per Uso orofaringeo.<br>
     */
    public static final String OROPHARYNGEAL_USE_CODE = "20055000";

    /**
     * EN: Code for Rectal use.<br>
     * DE: Code für rektale Anwendung.<br>
     * FR: Code de Voie rectale.<br>
     * IT: Code per Uso rettale.<br>
     */
    public static final String RECTAL_USE_CODE = "20061000";

    /**
     * EN: Code for Subcutaneous use.<br>
     * DE: Code für subkutane Anwendung.<br>
     * FR: Code de Voie sous-cutanée.<br>
     * IT: Code per Uso sottocutaneo.<br>
     */
    public static final String SUBCUTANEOUS_USE_CODE = "20066000";

    /**
     * EN: Code for Sublingual use.<br>
     * DE: Code für Sublingual.<br>
     * FR: Code de Voie sublinguale.<br>
     * IT: Code per Uso sublinguale.<br>
     */
    public static final String SUBLINGUAL_USE_CODE = "20067000";

    /**
     * EN: Code for Transdermal use.<br>
     * DE: Code für transdermale Anwendung.<br>
     * FR: Code de Voie transdermique.<br>
     * IT: Code per Uso transdermico.<br>
     */
    public static final String TRANSDERMAL_USE_CODE = "20070000";

    /**
     * EN: Code for Urethral use.<br>
     * DE: Code für Anwendung in der Harnröhre.<br>
     * FR: Code de Voie urétrale.<br>
     * IT: Code per Uso uretrale.<br>
     */
    public static final String URETHRAL_USE_CODE = "20071000";

    /**
     * EN: Code for Vaginal use.<br>
     * DE: Code für vaginale Anwendung.<br>
     * FR: Code de Voie vaginale.<br>
     * IT: Code per Uso vaginale.<br>
     */
    public static final String VAGINAL_USE_CODE = "20072000";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.77.12.11.1";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "RouteOfAdministrationAmbu";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "0.4.0.127.0.16.1.1.2.1";

    /**
     * Machine interpretable and (inside this class) unique code.
     */
    @NonNull
    private final String code;

    /**
     * Identifier of the referencing code system.
     */
    @NonNull
    private final String codeSystem;

    /**
     * The display names per language. It's always stored in the given order: default display name (0), in English (1),
     * in German (2), in French (3) and in Italian (4).
     */
    @NonNull
    private final String[] displayNames;

    /**
     * Instantiates this enum with a given code and display names.
     *
     * @param code          The code value.
     * @param codeSystem    The code system (OID).
     * @param displayName   The default display name.
     * @param displayNameEn The display name in English.
     * @param displayNameDe The display name in German.
     * @param displayNameFr The display name in French.
     * @param displayNameIt The display name in Italian.
     */
    RouteOfAdministrationAmbu(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
        this.code = Objects.requireNonNull(code);
        this.codeSystem = Objects.requireNonNull(codeSystem);
        this.displayNames = new String[5];
        this.displayNames[0] = Objects.requireNonNull(displayName);
        this.displayNames[1] = Objects.requireNonNull(displayNameEn);
        this.displayNames[2] = Objects.requireNonNull(displayNameDe);
        this.displayNames[3] = Objects.requireNonNull(displayNameFr);
        this.displayNames[4] = Objects.requireNonNull(displayNameIt);
    }

    /**
     * Gets the code system identifier.
     *
     * @return the code system identifier.
     */
    @Override
    @NonNull
    public String getCodeSystemId() {
        return this.codeSystem;
    }

    /**
     * Gets the code system name.
     *
     * @return the code system name.
     */
    @Override
    @NonNull
    public String getCodeSystemName() {
        final var codeSystem = CodeSystems.getEnum(this.codeSystem);
        if (codeSystem != null) {
            return codeSystem.getCodeSystemName();
        }
        return "";
    }

    /**
     * Gets the code value as a string.
     *
     * @return the code value.
     */
    @Override
    @NonNull
    public String getCodeValue() {
        return this.code;
    }

    /**
     * Gets the display name defined by the language param.
     *
     * @param languageCode The language code to get the display name for, {@code null} to get the default display name.
     * @return the display name in the desired language.
     */
    @Override
    @NonNull
    public String getDisplayName(@Nullable final LanguageCode languageCode) {
        if (languageCode == null) {
            return this.displayNames[0];
        }
        return switch(languageCode) {
            case ENGLISH ->
                this.displayNames[1];
            case GERMAN ->
                this.displayNames[2];
            case FRENCH ->
                this.displayNames[3];
            case ITALIAN ->
                this.displayNames[4];
            default ->
                "TOTRANSLATE";
        };
    }

    /**
     * Gets the value set identifier.
     *
     * @return the value set identifier.
     */
    @Override
    @NonNull
    public String getValueSetId() {
        return VALUE_SET_ID;
    }

    /**
     * Gets the value set name.
     *
     * @return the value set name.
     */
    @Override
    @NonNull
    public String getValueSetName() {
        return VALUE_SET_NAME;
    }

    /**
     * Returns the enum value as a FHIR Coding.
     */
    @Override
    public Coding getCoding() {
        return new Coding(this.getCodeSystemId(),
                          this.getCodeValue(),
                          this.getCodeSystemName());
    }

    /**
     * Returns the enum value as a FHIR CodeableConcept.
     */
    @Override
    public CodeableConcept getCodeableConcept() {
        return new CodeableConcept().setText(this.getCodeSystemName()).addCoding(this.getCoding());
    }

    /**
     * Compares the enum value to the given FHIR Coding.
     *
     * @param coding The FHIR Coding to be compared.
     * @return {@code true} if they have the same system and value, {@code false} otherwise.
     */
    @Override
    public boolean isEqualTo(final Coding coding) {
        return this.getCodeSystemId().equals(coding.getSystem()) && this.getCodeValue().equals(coding.getCode());
    }

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static RouteOfAdministrationAmbu getEnum(@Nullable final String code) {
        for (final RouteOfAdministrationAmbu x : values()) {
            if (x.getCodeValue().equals(code)) {
                return x;
            }
        }
        return null;
    }

    /**
     * Checks if a given enum is part of this value set.
     *
     * @param enumName The name of the enum.
     * @return {@code true} if the name is found in this value set, {@code false} otherwise.
     */
    public static boolean isEnumOfValueSet(@Nullable final String enumName) {
        if (enumName == null) {
            return false;
        }
        try {
            Enum.valueOf(RouteOfAdministrationAmbu.class,
                         enumName);
            return true;
        } catch (final IllegalArgumentException ex) {
            return false;
        }
    }

    /**
     * Checks if a given code value is in this value set.
     *
     * @param codeValue The code value.
     * @return {@code true} if the value is found in this value set, {@code false} otherwise.
     */
    public static boolean isInValueSet(@Nullable final String codeValue) {
        for (final RouteOfAdministrationAmbu x : values()) {
            if (x.getCodeValue().equals(codeValue)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the Enum with a given FHIR Coding.
     *
     * @param coding The FHIR Coding.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static RouteOfAdministrationAmbu getEnum(@Nullable final Coding coding) {
        for (final var x : values()) {
            if (x.isEqualTo(coding)) {
                return x;
            }
        }
        return null;
    }

    /**
     * Checks if a given FHIR Coding is in this value set.
     *
     * @param coding The FHIR Coding.
     * @return {@code true} if the value is found in this value set, {@code false} otherwise.
     */
    public static boolean isInValueSet(@Nullable final Coding coding) {
        for (final var x : values()) {
            if (x.isEqualTo(coding)) {
                return true;
            }
        }
        return false;
    }
}
