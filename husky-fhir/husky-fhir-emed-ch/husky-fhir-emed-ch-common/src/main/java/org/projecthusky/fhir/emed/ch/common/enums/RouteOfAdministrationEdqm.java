package org.projecthusky.fhir.emed.ch.common.enums;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.enums.ValueSetEnumInterface;

import javax.annotation.processing.Generated;
import java.util.Objects;

/**
 * Enumeration of RouteOfAdministrationEDQM values
 * <p>
 * EN: Valueset RouteOfAdministration from EDQM, ROA, export 1.6.2021, see https://standardterms.edqm.eu/#.<br> DE: No
 * designation found.<br> FR: No designation found.<br> IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.11.2<br> Effective date: 2022-06-08 15:42<br> Version: 2022<br> Status: DRAFT
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2022-07-11")
public enum RouteOfAdministrationEdqm implements ValueSetEnumInterface {

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
     * EN: Endocervical use.<br>
     * DE: endozervikale Anwendung.<br>
     * FR: Voie endocervicale.<br>
     * IT: Uso endocervicale.<br>
     */
    ENDOCERVICAL_USE("20006000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Endocervical use",
                     "Endocervical use",
                     "endozervikale Anwendung",
                     "Voie endocervicale",
                     "Uso endocervicale"),
    /**
     * EN: Endosinusial use.<br>
     * DE: Anwendung in den Nebenhöhlen.<br>
     * FR: Voie endosinusale.<br>
     * IT: Uso endosinusiale.<br>
     */
    ENDOSINUSIAL_USE("20007000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Endosinusial use",
                     "Endosinusial use",
                     "Anwendung in den Nebenhöhlen",
                     "Voie endosinusale",
                     "Uso endosinusiale"),
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
     * EN: Epidural use.<br>
     * DE: epidurale Anwendung.<br>
     * FR: Voie péridurale.<br>
     * IT: Uso epidurale.<br>
     */
    EPIDURAL_USE("20009000",
                 "0.4.0.127.0.16.1.1.2.1",
                 "Epidural use",
                 "Epidural use",
                 "epidurale Anwendung",
                 "Voie péridurale",
                 "Uso epidurale"),
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
     * EN: Extraamniotic use.<br>
     * DE: extraamniotische Anwendung.<br>
     * FR: Voie extra-amniotique.<br>
     * IT: Uso extra-amniotico.<br>
     */
    EXTRAAMNIOTIC_USE("20011000",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Extraamniotic use",
                      "Extraamniotic use",
                      "extraamniotische Anwendung",
                      "Voie extra-amniotique",
                      "Uso extra-amniotico"),
    /**
     * EN: Extracorporeal use.<br>
     * DE: extrakorporale Anwendung.<br>
     * FR: Voie extracorporelle.<br>
     * IT: Uso extracorporeo.<br>
     */
    EXTRACORPOREAL_USE("20011500",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Extracorporeal use",
                       "Extracorporeal use",
                       "extrakorporale Anwendung",
                       "Voie extracorporelle",
                       "Uso extracorporeo"),
    /**
     * EN: Extrapleural use.<br>
     * DE: extrapleurale Anwendung.<br>
     * FR: voie extrapleural.<br>
     * IT: uso extrapleurico.<br>
     */
    EXTRAPLEURAL_USE("20087000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Extrapleural use",
                     "Extrapleural use",
                     "extrapleurale Anwendung",
                     "voie extrapleural",
                     "uso extrapleurico"),
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
     * EN: Implantation.<br>
     * DE: zur Implantation.<br>
     * FR: Implantation.<br>
     * IT: Impianto.<br>
     */
    IMPLANTATION("20015500",
                 "0.4.0.127.0.16.1.1.2.1",
                 "Implantation",
                 "Implantation",
                 "zur Implantation",
                 "Implantation",
                 "Impianto"),
    /**
     * EN: Infiltration.<br>
     * DE: Infiltration.<br>
     * FR: Infiltration.<br>
     * IT: Infiltrazione.<br>
     */
    INFILTRATION("20019500",
                 "0.4.0.127.0.16.1.1.2.1",
                 "Infiltration",
                 "Infiltration",
                 "Infiltration",
                 "Infiltration",
                 "Infiltrazione"),
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
     * EN: Intraamniotic use.<br>
     * DE: intraamniotische Anwendung.<br>
     * FR: Voie intraamniotique.<br>
     * IT: Uso intra-amniotico.<br>
     */
    INTRAAMNIOTIC_USE("20022000",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Intraamniotic use",
                      "Intraamniotic use",
                      "intraamniotische Anwendung",
                      "Voie intraamniotique",
                      "Uso intra-amniotico"),
    /**
     * EN: Intraarterial use.<br>
     * DE: intraarterielle Anwendung.<br>
     * FR: Voie intraartérielle.<br>
     * IT: Uso endoarterioso.<br>
     */
    INTRAARTERIAL_USE("20023000",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Intraarterial use",
                      "Intraarterial use",
                      "intraarterielle Anwendung",
                      "Voie intraartérielle",
                      "Uso endoarterioso"),
    /**
     * EN: Intraarticular use.<br>
     * DE: intraartikuläre Anwendung.<br>
     * FR: Voie intraarticulaire.<br>
     * IT: Uso intra-articolare.<br>
     */
    INTRAARTICULAR_USE("20024000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Intraarticular use",
                       "Intraarticular use",
                       "intraartikuläre Anwendung",
                       "Voie intraarticulaire",
                       "Uso intra-articolare"),
    /**
     * EN: Intrabursal use.<br>
     * DE: intrabursale Anwendung.<br>
     * FR: Voie intrabursale.<br>
     * IT: Uso intrabursale.<br>
     */
    INTRABURSAL_USE("20025000",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Intrabursal use",
                    "Intrabursal use",
                    "intrabursale Anwendung",
                    "Voie intrabursale",
                    "Uso intrabursale"),
    /**
     * EN: Intracameral use.<br>
     * DE: intrakamerale Anwendung.<br>
     * FR: Voie intracamérulaire.<br>
     * IT: Uso intracamerale.<br>
     */
    INTRACAMERAL_USE("20025500",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Intracameral use",
                     "Intracameral use",
                     "intrakamerale Anwendung",
                     "Voie intracamérulaire",
                     "Uso intracamerale"),
    /**
     * EN: Intracardiac use.<br>
     * DE: intracardiale Anwendung.<br>
     * FR: Voie intracardiaque.<br>
     * IT: Uso intracardiaco.<br>
     */
    INTRACARDIAC_USE("20026000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Intracardiac use",
                     "Intracardiac use",
                     "intracardiale Anwendung",
                     "Voie intracardiaque",
                     "Uso intracardiaco"),
    /**
     * EN: Intracartilaginous use.<br>
     * DE: intrakartilaginäre Anwendung.<br>
     * FR: Voie intracartilagineuse.<br>
     * IT: Uso intracartilagineo.<br>
     */
    INTRACARTILAGINOUS_USE("20026500",
                           "0.4.0.127.0.16.1.1.2.1",
                           "Intracartilaginous use",
                           "Intracartilaginous use",
                           "intrakartilaginäre Anwendung",
                           "Voie intracartilagineuse",
                           "Uso intracartilagineo"),
    /**
     * EN: Intracavernous use.<br>
     * DE: intrakavernöse Anwendung.<br>
     * FR: Voie intracaverneuse.<br>
     * IT: Uso intracavernoso.<br>
     */
    INTRACAVERNOUS_USE("20027000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Intracavernous use",
                       "Intracavernous use",
                       "intrakavernöse Anwendung",
                       "Voie intracaverneuse",
                       "Uso intracavernoso"),
    /**
     * EN: Intracerebral use.<br>
     * DE: Intrazerebrale Anwendung.<br>
     * FR: Voie intracérébrale.<br>
     * IT: Uso intracerebrale.<br>
     */
    INTRACEREBRAL_USE("20027010",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Intracerebral use",
                      "Intracerebral use",
                      "Intrazerebrale Anwendung",
                      "Voie intracérébrale",
                      "Uso intracerebrale"),
    /**
     * EN: Intracerebroventricular use.<br>
     * DE: intracerebroventrikuläre Anwendung.<br>
     * FR: Voie intracérébroventriculaire.<br>
     * IT: Uso intracerebroventricolare.<br>
     */
    INTRACEREBROVENTRICULAR_USE("20080000",
                                "0.4.0.127.0.16.1.1.2.1",
                                "Intracerebroventricular use",
                                "Intracerebroventricular use",
                                "intracerebroventrikuläre Anwendung",
                                "Voie intracérébroventriculaire",
                                "Uso intracerebroventricolare"),
    /**
     * EN: Intracervical use.<br>
     * DE: intrazervikale Anwendung.<br>
     * FR: Voie intracervicale.<br>
     * IT: Uso intracervicale.<br>
     */
    INTRACERVICAL_USE("20028000",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Intracervical use",
                      "Intracervical use",
                      "intrazervikale Anwendung",
                      "Voie intracervicale",
                      "Uso intracervicale"),
    /**
     * EN: Intracholangiopancreatic use.<br>
     * DE: zur Anwendung in der Cholangiopankreatikographie.<br>
     * FR: Voie intracholangiopancréatique.<br>
     * IT: Uso intracolangiopancreatico.<br>
     */
    INTRACHOLANGIOPANCREATIC_USE("20028300",
                                 "0.4.0.127.0.16.1.1.2.1",
                                 "Intracholangiopancreatic use",
                                 "Intracholangiopancreatic use",
                                 "zur Anwendung in der Cholangiopankreatikographie",
                                 "Voie intracholangiopancréatique",
                                 "Uso intracolangiopancreatico"),
    /**
     * EN: Intracisternal use.<br>
     * DE: intracisternale Anwendung.<br>
     * FR: Voie intracisternale.<br>
     * IT: Uso intracisternale.<br>
     */
    INTRACISTERNAL_USE("20028500",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Intracisternal use",
                       "Intracisternal use",
                       "intracisternale Anwendung",
                       "Voie intracisternale",
                       "Uso intracisternale"),
    /**
     * EN: Intracorneal use.<br>
     * DE: intracorneale Anwendung.<br>
     * FR: Voie intracornéenne.<br>
     * IT: Uso intracorneale.<br>
     */
    INTRACORNEAL_USE("20084000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Intracorneal use",
                     "Intracorneal use",
                     "intracorneale Anwendung",
                     "Voie intracornéenne",
                     "Uso intracorneale"),
    /**
     * EN: Intracoronary use.<br>
     * DE: intrakoronare Anwendung.<br>
     * FR: Voie intracoronaire.<br>
     * IT: Uso intracoronarico.<br>
     */
    INTRACORONARY_USE("20029000",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Intracoronary use",
                      "Intracoronary use",
                      "intrakoronare Anwendung",
                      "Voie intracoronaire",
                      "Uso intracoronarico"),
    /**
     * EN: Intradermal use.<br>
     * DE: intradermale Anwendung.<br>
     * FR: Voie intradermique.<br>
     * IT: Uso intradermico.<br>
     */
    INTRADERMAL_USE("20030000",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Intradermal use",
                    "Intradermal use",
                    "intradermale Anwendung",
                    "Voie intradermique",
                    "Uso intradermico"),
    /**
     * EN: Intradiscal use.<br>
     * DE: intradiskale Anwendung.<br>
     * FR: Voie intradiscale.<br>
     * IT: Uso intradiscale.<br>
     */
    INTRADISCAL_USE("20031000",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Intradiscal use",
                    "Intradiscal use",
                    "intradiskale Anwendung",
                    "Voie intradiscale",
                    "Uso intradiscale"),
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
     * EN: Intraglandular use.<br>
     * DE: intraglanduläre Anwendung.<br>
     * FR: Voie intraglandulaire.<br>
     * IT: Uso intraghiandolare.<br>
     */
    INTRAGLANDULAR_USE("20031700",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Intraglandular use",
                       "Intraglandular use",
                       "intraglanduläre Anwendung",
                       "Voie intraglandulaire",
                       "Uso intraghiandolare"),
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
     * EN: Intralymphatic use.<br>
     * DE: intralymphatische Anwendung.<br>
     * FR: Voie intralymphatique.<br>
     * IT: Uso intralinfatico.<br>
     */
    INTRALYMPHATIC_USE("20033000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Intralymphatic use",
                       "Intralymphatic use",
                       "intralymphatische Anwendung",
                       "Voie intralymphatique",
                       "Uso intralinfatico"),
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
     * EN: Intraocular use.<br>
     * DE: intraokulare Anwendung.<br>
     * FR: Voie intraoculaire.<br>
     * IT: Uso intraoculare.<br>
     */
    INTRAOCULAR_USE("20036000",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Intraocular use",
                    "Intraocular use",
                    "intraokulare Anwendung",
                    "Voie intraoculaire",
                    "Uso intraoculare"),
    /**
     * EN: Intraosseous use.<br>
     * DE: intraossäre Anwendung.<br>
     * FR: Voie intraosseuse.<br>
     * IT: Uso intraosseo.<br>
     */
    INTRAOSSEOUS_USE("20036500",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Intraosseous use",
                     "Intraosseous use",
                     "intraossäre Anwendung",
                     "Voie intraosseuse",
                     "Uso intraosseo"),
    /**
     * EN: Intrapericardial use.<br>
     * DE: Intraperikardial.<br>
     * FR: Voie intrapéricardiaque.<br>
     * IT: Uso intrapericardico.<br>
     */
    INTRAPERICARDIAL_USE("20037000",
                         "0.4.0.127.0.16.1.1.2.1",
                         "Intrapericardial use",
                         "Intrapericardial use",
                         "Intraperikardial",
                         "Voie intrapéricardiaque",
                         "Uso intrapericardico"),
    /**
     * EN: Intraperitoneal use.<br>
     * DE: intraperitoneale Anwendung.<br>
     * FR: Voie intrapéritonéale.<br>
     * IT: Uso intraperitoneale.<br>
     */
    INTRAPERITONEAL_USE("20038000",
                        "0.4.0.127.0.16.1.1.2.1",
                        "Intraperitoneal use",
                        "Intraperitoneal use",
                        "intraperitoneale Anwendung",
                        "Voie intrapéritonéale",
                        "Uso intraperitoneale"),
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
     * EN: Intraportal use.<br>
     * DE: intraportale Anwendung.<br>
     * FR: Voie intraportale.<br>
     * IT: Uso intraportale.<br>
     */
    INTRAPORTAL_USE("20039200",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Intraportal use",
                    "Intraportal use",
                    "intraportale Anwendung",
                    "Voie intraportale",
                    "Uso intraportale"),
    /**
     * EN: Intraprostatic use.<br>
     * DE: intraprostatische Anwendung.<br>
     * FR: Voie intraprostatique.<br>
     * IT: Uso intraprostatico.<br>
     */
    INTRAPROSTATIC_USE("20039500",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Intraprostatic use",
                       "Intraprostatic use",
                       "intraprostatische Anwendung",
                       "Voie intraprostatique",
                       "Uso intraprostatico"),
    /**
     * EN: Intraputaminal use.<br>
     * DE: Intraputaminale Anwendung.<br>
     * FR: null.<br>
     * IT: Intraputaminale.<br>
     */
    INTRAPUTAMINAL_USE("20086000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Intraputaminal use",
                       "Intraputaminal use",
                       "Intraputaminale Anwendung",
                       "null",
                       "Intraputaminale"),
    /**
     * EN: Intrasternal use.<br>
     * DE: intrasternale Anwendung.<br>
     * FR: Voie intrasternale.<br>
     * IT: Uso intrasternale.<br>
     */
    INTRASTERNAL_USE("20041000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Intrasternal use",
                     "Intrasternal use",
                     "intrasternale Anwendung",
                     "Voie intrasternale",
                     "Uso intrasternale"),
    /**
     * EN: Intrathecal use.<br>
     * DE: intrathekale Anwendung.<br>
     * FR: Voie intrathécale.<br>
     * IT: Uso intratecale.<br>
     */
    INTRATHECAL_USE("20042000",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Intrathecal use",
                    "Intrathecal use",
                    "intrathekale Anwendung",
                    "Voie intrathécale",
                    "Uso intratecale"),
    /**
     * EN: Intratumoral use.<br>
     * DE: intratumorale Anwendung.<br>
     * FR: Voie intratumorale.<br>
     * IT: Uso intratumorale.<br>
     */
    INTRATUMORAL_USE("20043000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Intratumoral use",
                     "Intratumoral use",
                     "intratumorale Anwendung",
                     "Voie intratumorale",
                     "Uso intratumorale"),
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
     * EN: Intravitreal use.<br>
     * DE: Intravitreal.<br>
     * FR: Voie intravitréenne.<br>
     * IT: Uso intravitreo.<br>
     */
    INTRAVITREAL_USE("20047000",
                     "0.4.0.127.0.16.1.1.2.1",
                     "Intravitreal use",
                     "Intravitreal use",
                     "Intravitreal",
                     "Voie intravitréenne",
                     "Uso intravitreo"),
    /**
     * EN: Iontophoresis.<br>
     * DE: zur Iontophorese.<br>
     * FR: Iontophorèse.<br>
     * IT: Iontoforesi.<br>
     */
    IONTOPHORESIS("20047500",
                  "0.4.0.127.0.16.1.1.2.1",
                  "Iontophoresis",
                  "Iontophoresis",
                  "zur Iontophorese",
                  "Iontophorèse",
                  "Iontoforesi"),
    /**
     * EN: Laryngopharyngeal use.<br>
     * DE: zur Anwendung im Rachen und am Kehlkopf.<br>
     * FR: Voie laryngopharyngée.<br>
     * IT: Uso laringofaringeo.<br>
     */
    LARYNGOPHARYNGEAL_USE("20048000",
                          "0.4.0.127.0.16.1.1.2.1",
                          "Laryngopharyngeal use",
                          "Laryngopharyngeal use",
                          "zur Anwendung im Rachen und am Kehlkopf",
                          "Voie laryngopharyngée",
                          "Uso laringofaringeo"),
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
     * EN: Periarticular use.<br>
     * DE: periartikuläre Anwendung.<br>
     * FR: Voie périarticulaire.<br>
     * IT: Uso periarticolare.<br>
     */
    PERIARTICULAR_USE("20057000",
                      "0.4.0.127.0.16.1.1.2.1",
                      "Periarticular use",
                      "Periarticular use",
                      "periartikuläre Anwendung",
                      "Voie périarticulaire",
                      "Uso periarticolare"),
    /**
     * EN: Perineural use.<br>
     * DE: perineurale Anwendung.<br>
     * FR: Voie périneurale.<br>
     * IT: Uso perineurale.<br>
     */
    PERINEURAL_USE("20058000",
                   "0.4.0.127.0.16.1.1.2.1",
                   "Perineural use",
                   "Perineural use",
                   "perineurale Anwendung",
                   "Voie périneurale",
                   "Uso perineurale"),
    /**
     * EN: Periodontal use.<br>
     * DE: zur periodontalen Anwendung.<br>
     * FR: Voie périodontale.<br>
     * IT: Uso periodontale.<br>
     */
    PERIODONTAL_USE("20059000",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Periodontal use",
                    "Periodontal use",
                    "zur periodontalen Anwendung",
                    "Voie périodontale",
                    "Uso periodontale"),
    /**
     * EN: Periosseous use.<br>
     * DE: periossäre Anwendung.<br>
     * FR: Voie périosseuse.<br>
     * IT: Uso periosseo.<br>
     */
    PERIOSSEOUS_USE("20059300",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Periosseous use",
                    "Periosseous use",
                    "periossäre Anwendung",
                    "Voie périosseuse",
                    "Uso periosseo"),
    /**
     * EN: Peritumoral use.<br>
     * DE: peritumorale Anwendung.<br>
     * FR: Voie péritumorale.<br>
     * IT: Uso peritumorale.<br>
     */
    PERITUMORAL_USE("20059400",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Peritumoral use",
                    "Peritumoral use",
                    "peritumorale Anwendung",
                    "Voie péritumorale",
                    "Uso peritumorale"),
    /**
     * EN: Posterior juxtascleral use.<br>
     * DE: posteriore juxtasclerale Anwendung.<br>
     * FR: Voie juxta-sclérale postérieure.<br>
     * IT: Uso iuxtasclerale posteriore.<br>
     */
    POSTERIOR_JUXTASCLERAL_USE("20059500",
                               "0.4.0.127.0.16.1.1.2.1",
                               "Posterior juxtascleral use",
                               "Posterior juxtascleral use",
                               "posteriore juxtasclerale Anwendung",
                               "Voie juxta-sclérale postérieure",
                               "Uso iuxtasclerale posteriore"),
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
     * EN: Retrobulbar use.<br>
     * DE: retrobulbäre Anwendung.<br>
     * FR: Voie rétrobulbaire.<br>
     * IT: Uso retrobulbare.<br>
     */
    RETROBULBAR_USE("20061500",
                    "0.4.0.127.0.16.1.1.2.1",
                    "Retrobulbar use",
                    "Retrobulbar use",
                    "retrobulbäre Anwendung",
                    "Voie rétrobulbaire",
                    "Uso retrobulbare"),
    /**
     * EN: Route of administration not applicable.<br>
     * DE: Art der Anwendung nicht spezifizierbar.<br>
     * FR: Autre(s).<br>
     * IT: Via di somministrazione non specificabile.<br>
     */
    ROUTE_OF_ADMINISTRATION_NOT_APPLICABLE("20062000",
                                           "0.4.0.127.0.16.1.1.2.1",
                                           "Route of administration not applicable",
                                           "Route of administration not applicable",
                                           "Art der Anwendung nicht spezifizierbar",
                                           "Autre(s)",
                                           "Via di somministrazione non specificabile"),
    /**
     * EN: Skin scarification.<br>
     * DE: Einritzen der Haut.<br>
     * FR: Scarification.<br>
     * IT: Scarificazione.<br>
     */
    SKIN_SCARIFICATION("20063000",
                       "0.4.0.127.0.16.1.1.2.1",
                       "Skin scarification",
                       "Skin scarification",
                       "Einritzen der Haut",
                       "Scarification",
                       "Scarificazione"),
    /**
     * EN: Subconjunctival use.<br>
     * DE: subkonjunktivale Anwendung.<br>
     * FR: Voie sous-conjonctivale.<br>
     * IT: Uso subcongiuntivale.<br>
     */
    SUBCONJUNCTIVAL_USE("20065000",
                        "0.4.0.127.0.16.1.1.2.1",
                        "Subconjunctival use",
                        "Subconjunctival use",
                        "subkonjunktivale Anwendung",
                        "Voie sous-conjonctivale",
                        "Uso subcongiuntivale"),
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
     * EN: Submucosal use.<br>
     * DE: submuköse Anwendung.<br>
     * FR: Voie sous-muqueuse.<br>
     * IT: Uso sottomucosale.<br>
     */
    SUBMUCOSAL_USE("20067500",
                   "0.4.0.127.0.16.1.1.2.1",
                   "Submucosal use",
                   "Submucosal use",
                   "submuköse Anwendung",
                   "Voie sous-muqueuse",
                   "Uso sottomucosale"),
    /**
     * EN: Subretinal use.<br>
     * DE: subretinale Anwendung.<br>
     * FR: Voie subrétinale.<br>
     * IT: Uso sottoretinico.<br>
     */
    SUBRETINAL_USE("20081000",
                   "0.4.0.127.0.16.1.1.2.1",
                   "Subretinal use",
                   "Subretinal use",
                   "subretinale Anwendung",
                   "Voie subrétinale",
                   "Uso sottoretinico"),
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
     * EN: Code for Endocervical use.<br>
     * DE: Code für endozervikale Anwendung.<br>
     * FR: Code de Voie endocervicale.<br>
     * IT: Code per Uso endocervicale.<br>
     */
    public static final String ENDOCERVICAL_USE_CODE = "20006000";

    /**
     * EN: Code for Endosinusial use.<br>
     * DE: Code für Anwendung in den Nebenhöhlen.<br>
     * FR: Code de Voie endosinusale.<br>
     * IT: Code per Uso endosinusiale.<br>
     */
    public static final String ENDOSINUSIAL_USE_CODE = "20007000";

    /**
     * EN: Code for Endotracheopulmonary use.<br>
     * DE: Code für endotracheopulmonale Anwendung.<br>
     * FR: Code de Voie endotrachéobronchique.<br>
     * IT: Code per Uso endotracheobronchiale.<br>
     */
    public static final String ENDOTRACHEOPULMONARY_USE_CODE = "20008000";

    /**
     * EN: Code for Epidural use.<br>
     * DE: Code für epidurale Anwendung.<br>
     * FR: Code de Voie péridurale.<br>
     * IT: Code per Uso epidurale.<br>
     */
    public static final String EPIDURAL_USE_CODE = "20009000";

    /**
     * EN: Code for Epilesional use.<br>
     * DE: Code für zum Auftragen auf die Wunde.<br>
     * FR: Code de Voie épilésionnelle.<br>
     * IT: Code per Uso epilesionale.<br>
     */
    public static final String EPILESIONAL_USE_CODE = "20010000";

    /**
     * EN: Code for Extraamniotic use.<br>
     * DE: Code für extraamniotische Anwendung.<br>
     * FR: Code de Voie extra-amniotique.<br>
     * IT: Code per Uso extra-amniotico.<br>
     */
    public static final String EXTRAAMNIOTIC_USE_CODE = "20011000";

    /**
     * EN: Code for Extracorporeal use.<br>
     * DE: Code für extrakorporale Anwendung.<br>
     * FR: Code de Voie extracorporelle.<br>
     * IT: Code per Uso extracorporeo.<br>
     */
    public static final String EXTRACORPOREAL_USE_CODE = "20011500";

    /**
     * EN: Code for Extrapleural use.<br>
     * DE: Code für extrapleurale Anwendung.<br>
     * FR: Code de voie extrapleural.<br>
     * IT: Code per uso extrapleurico.<br>
     */
    public static final String EXTRAPLEURAL_USE_CODE = "20087000";

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
     * EN: Code for Implantation.<br>
     * DE: Code für zur Implantation.<br>
     * FR: Code de Implantation.<br>
     * IT: Code per Impianto.<br>
     */
    public static final String IMPLANTATION_CODE = "20015500";

    /**
     * EN: Code for Infiltration.<br>
     * DE: Code für Infiltration.<br>
     * FR: Code de Infiltration.<br>
     * IT: Code per Infiltrazione.<br>
     */
    public static final String INFILTRATION_CODE = "20019500";

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
     * EN: Code for Intraamniotic use.<br>
     * DE: Code für intraamniotische Anwendung.<br>
     * FR: Code de Voie intraamniotique.<br>
     * IT: Code per Uso intra-amniotico.<br>
     */
    public static final String INTRAAMNIOTIC_USE_CODE = "20022000";

    /**
     * EN: Code for Intraarterial use.<br>
     * DE: Code für intraarterielle Anwendung.<br>
     * FR: Code de Voie intraartérielle.<br>
     * IT: Code per Uso endoarterioso.<br>
     */
    public static final String INTRAARTERIAL_USE_CODE = "20023000";

    /**
     * EN: Code for Intraarticular use.<br>
     * DE: Code für intraartikuläre Anwendung.<br>
     * FR: Code de Voie intraarticulaire.<br>
     * IT: Code per Uso intra-articolare.<br>
     */
    public static final String INTRAARTICULAR_USE_CODE = "20024000";

    /**
     * EN: Code for Intrabursal use.<br>
     * DE: Code für intrabursale Anwendung.<br>
     * FR: Code de Voie intrabursale.<br>
     * IT: Code per Uso intrabursale.<br>
     */
    public static final String INTRABURSAL_USE_CODE = "20025000";

    /**
     * EN: Code for Intracameral use.<br>
     * DE: Code für intrakamerale Anwendung.<br>
     * FR: Code de Voie intracamérulaire.<br>
     * IT: Code per Uso intracamerale.<br>
     */
    public static final String INTRACAMERAL_USE_CODE = "20025500";

    /**
     * EN: Code for Intracardiac use.<br>
     * DE: Code für intracardiale Anwendung.<br>
     * FR: Code de Voie intracardiaque.<br>
     * IT: Code per Uso intracardiaco.<br>
     */
    public static final String INTRACARDIAC_USE_CODE = "20026000";

    /**
     * EN: Code for Intracartilaginous use.<br>
     * DE: Code für intrakartilaginäre Anwendung.<br>
     * FR: Code de Voie intracartilagineuse.<br>
     * IT: Code per Uso intracartilagineo.<br>
     */
    public static final String INTRACARTILAGINOUS_USE_CODE = "20026500";

    /**
     * EN: Code for Intracavernous use.<br>
     * DE: Code für intrakavernöse Anwendung.<br>
     * FR: Code de Voie intracaverneuse.<br>
     * IT: Code per Uso intracavernoso.<br>
     */
    public static final String INTRACAVERNOUS_USE_CODE = "20027000";

    /**
     * EN: Code for Intracerebral use.<br>
     * DE: Code für Intrazerebrale Anwendung.<br>
     * FR: Code de Voie intracérébrale.<br>
     * IT: Code per Uso intracerebrale.<br>
     */
    public static final String INTRACEREBRAL_USE_CODE = "20027010";

    /**
     * EN: Code for Intracerebroventricular use.<br>
     * DE: Code für intracerebroventrikuläre Anwendung.<br>
     * FR: Code de Voie intracérébroventriculaire.<br>
     * IT: Code per Uso intracerebroventricolare.<br>
     */
    public static final String INTRACEREBROVENTRICULAR_USE_CODE = "20080000";

    /**
     * EN: Code for Intracervical use.<br>
     * DE: Code für intrazervikale Anwendung.<br>
     * FR: Code de Voie intracervicale.<br>
     * IT: Code per Uso intracervicale.<br>
     */
    public static final String INTRACERVICAL_USE_CODE = "20028000";

    /**
     * EN: Code for Intracholangiopancreatic use.<br>
     * DE: Code für zur Anwendung in der Cholangiopankreatikographie.<br>
     * FR: Code de Voie intracholangiopancréatique.<br>
     * IT: Code per Uso intracolangiopancreatico.<br>
     */
    public static final String INTRACHOLANGIOPANCREATIC_USE_CODE = "20028300";

    /**
     * EN: Code for Intracisternal use.<br>
     * DE: Code für intracisternale Anwendung.<br>
     * FR: Code de Voie intracisternale.<br>
     * IT: Code per Uso intracisternale.<br>
     */
    public static final String INTRACISTERNAL_USE_CODE = "20028500";

    /**
     * EN: Code for Intracorneal use.<br>
     * DE: Code für intracorneale Anwendung.<br>
     * FR: Code de Voie intracornéenne.<br>
     * IT: Code per Uso intracorneale.<br>
     */
    public static final String INTRACORNEAL_USE_CODE = "20084000";

    /**
     * EN: Code for Intracoronary use.<br>
     * DE: Code für intrakoronare Anwendung.<br>
     * FR: Code de Voie intracoronaire.<br>
     * IT: Code per Uso intracoronarico.<br>
     */
    public static final String INTRACORONARY_USE_CODE = "20029000";

    /**
     * EN: Code for Intradermal use.<br>
     * DE: Code für intradermale Anwendung.<br>
     * FR: Code de Voie intradermique.<br>
     * IT: Code per Uso intradermico.<br>
     */
    public static final String INTRADERMAL_USE_CODE = "20030000";

    /**
     * EN: Code for Intradiscal use.<br>
     * DE: Code für intradiskale Anwendung.<br>
     * FR: Code de Voie intradiscale.<br>
     * IT: Code per Uso intradiscale.<br>
     */
    public static final String INTRADISCAL_USE_CODE = "20031000";

    /**
     * EN: Code for Intraepidermal use.<br>
     * DE: Code für intraepidermale Anwendung.<br>
     * FR: Code de Voie intraépidermique.<br>
     * IT: Code per Uso intraepidermico.<br>
     */
    public static final String INTRAEPIDERMAL_USE_CODE = "20031500";

    /**
     * EN: Code for Intraglandular use.<br>
     * DE: Code für intraglanduläre Anwendung.<br>
     * FR: Code de Voie intraglandulaire.<br>
     * IT: Code per Uso intraghiandolare.<br>
     */
    public static final String INTRAGLANDULAR_USE_CODE = "20031700";

    /**
     * EN: Code for Intralesional use.<br>
     * DE: Code für intraläsionale Anwendung.<br>
     * FR: Code de Voie intralésionnelle.<br>
     * IT: Code per Uso intralesionale.<br>
     */
    public static final String INTRALESIONAL_USE_CODE = "20032000";

    /**
     * EN: Code for Intralymphatic use.<br>
     * DE: Code für intralymphatische Anwendung.<br>
     * FR: Code de Voie intralymphatique.<br>
     * IT: Code per Uso intralinfatico.<br>
     */
    public static final String INTRALYMPHATIC_USE_CODE = "20033000";

    /**
     * EN: Code for Intramuscular use.<br>
     * DE: Code für intramuskuläre Anwendung.<br>
     * FR: Code de Voie intramusculaire.<br>
     * IT: Code per Uso intramuscolare.<br>
     */
    public static final String INTRAMUSCULAR_USE_CODE = "20035000";

    /**
     * EN: Code for Intraocular use.<br>
     * DE: Code für intraokulare Anwendung.<br>
     * FR: Code de Voie intraoculaire.<br>
     * IT: Code per Uso intraoculare.<br>
     */
    public static final String INTRAOCULAR_USE_CODE = "20036000";

    /**
     * EN: Code for Intraosseous use.<br>
     * DE: Code für intraossäre Anwendung.<br>
     * FR: Code de Voie intraosseuse.<br>
     * IT: Code per Uso intraosseo.<br>
     */
    public static final String INTRAOSSEOUS_USE_CODE = "20036500";

    /**
     * EN: Code for Intrapericardial use.<br>
     * DE: Code für Intraperikardial.<br>
     * FR: Code de Voie intrapéricardiaque.<br>
     * IT: Code per Uso intrapericardico.<br>
     */
    public static final String INTRAPERICARDIAL_USE_CODE = "20037000";

    /**
     * EN: Code for Intraperitoneal use.<br>
     * DE: Code für intraperitoneale Anwendung.<br>
     * FR: Code de Voie intrapéritonéale.<br>
     * IT: Code per Uso intraperitoneale.<br>
     */
    public static final String INTRAPERITONEAL_USE_CODE = "20038000";

    /**
     * EN: Code for Intrapleural use.<br>
     * DE: Code für intrapleurale Anwendung.<br>
     * FR: Code de Voie intrapleurale.<br>
     * IT: Code per Uso intrapleurico.<br>
     */
    public static final String INTRAPLEURAL_USE_CODE = "20039000";

    /**
     * EN: Code for Intraportal use.<br>
     * DE: Code für intraportale Anwendung.<br>
     * FR: Code de Voie intraportale.<br>
     * IT: Code per Uso intraportale.<br>
     */
    public static final String INTRAPORTAL_USE_CODE = "20039200";

    /**
     * EN: Code for Intraprostatic use.<br>
     * DE: Code für intraprostatische Anwendung.<br>
     * FR: Code de Voie intraprostatique.<br>
     * IT: Code per Uso intraprostatico.<br>
     */
    public static final String INTRAPROSTATIC_USE_CODE = "20039500";

    /**
     * EN: Code for Intraputaminal use.<br>
     * DE: Code für Intraputaminale Anwendung.<br>
     * FR: Code de null.<br>
     * IT: Code per Intraputaminale.<br>
     */
    public static final String INTRAPUTAMINAL_USE_CODE = "20086000";

    /**
     * EN: Code for Intrasternal use.<br>
     * DE: Code für intrasternale Anwendung.<br>
     * FR: Code de Voie intrasternale.<br>
     * IT: Code per Uso intrasternale.<br>
     */
    public static final String INTRASTERNAL_USE_CODE = "20041000";

    /**
     * EN: Code for Intrathecal use.<br>
     * DE: Code für intrathekale Anwendung.<br>
     * FR: Code de Voie intrathécale.<br>
     * IT: Code per Uso intratecale.<br>
     */
    public static final String INTRATHECAL_USE_CODE = "20042000";

    /**
     * EN: Code for Intratumoral use.<br>
     * DE: Code für intratumorale Anwendung.<br>
     * FR: Code de Voie intratumorale.<br>
     * IT: Code per Uso intratumorale.<br>
     */
    public static final String INTRATUMORAL_USE_CODE = "20043000";

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
     * EN: Code for Intravitreal use.<br>
     * DE: Code für Intravitreal.<br>
     * FR: Code de Voie intravitréenne.<br>
     * IT: Code per Uso intravitreo.<br>
     */
    public static final String INTRAVITREAL_USE_CODE = "20047000";

    /**
     * EN: Code for Iontophoresis.<br>
     * DE: Code für zur Iontophorese.<br>
     * FR: Code de Iontophorèse.<br>
     * IT: Code per Iontoforesi.<br>
     */
    public static final String IONTOPHORESIS_CODE = "20047500";

    /**
     * EN: Code for Laryngopharyngeal use.<br>
     * DE: Code für zur Anwendung im Rachen und am Kehlkopf.<br>
     * FR: Code de Voie laryngopharyngée.<br>
     * IT: Code per Uso laringofaringeo.<br>
     */
    public static final String LARYNGOPHARYNGEAL_USE_CODE = "20048000";

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
     * EN: Code for Periarticular use.<br>
     * DE: Code für periartikuläre Anwendung.<br>
     * FR: Code de Voie périarticulaire.<br>
     * IT: Code per Uso periarticolare.<br>
     */
    public static final String PERIARTICULAR_USE_CODE = "20057000";

    /**
     * EN: Code for Perineural use.<br>
     * DE: Code für perineurale Anwendung.<br>
     * FR: Code de Voie périneurale.<br>
     * IT: Code per Uso perineurale.<br>
     */
    public static final String PERINEURAL_USE_CODE = "20058000";

    /**
     * EN: Code for Periodontal use.<br>
     * DE: Code für zur periodontalen Anwendung.<br>
     * FR: Code de Voie périodontale.<br>
     * IT: Code per Uso periodontale.<br>
     */
    public static final String PERIODONTAL_USE_CODE = "20059000";

    /**
     * EN: Code for Periosseous use.<br>
     * DE: Code für periossäre Anwendung.<br>
     * FR: Code de Voie périosseuse.<br>
     * IT: Code per Uso periosseo.<br>
     */
    public static final String PERIOSSEOUS_USE_CODE = "20059300";

    /**
     * EN: Code for Peritumoral use.<br>
     * DE: Code für peritumorale Anwendung.<br>
     * FR: Code de Voie péritumorale.<br>
     * IT: Code per Uso peritumorale.<br>
     */
    public static final String PERITUMORAL_USE_CODE = "20059400";

    /**
     * EN: Code for Posterior juxtascleral use.<br>
     * DE: Code für posteriore juxtasclerale Anwendung.<br>
     * FR: Code de Voie juxta-sclérale postérieure.<br>
     * IT: Code per Uso iuxtasclerale posteriore.<br>
     */
    public static final String POSTERIOR_JUXTASCLERAL_USE_CODE = "20059500";

    /**
     * EN: Code for Rectal use.<br>
     * DE: Code für rektale Anwendung.<br>
     * FR: Code de Voie rectale.<br>
     * IT: Code per Uso rettale.<br>
     */
    public static final String RECTAL_USE_CODE = "20061000";

    /**
     * EN: Code for Retrobulbar use.<br>
     * DE: Code für retrobulbäre Anwendung.<br>
     * FR: Code de Voie rétrobulbaire.<br>
     * IT: Code per Uso retrobulbare.<br>
     */
    public static final String RETROBULBAR_USE_CODE = "20061500";

    /**
     * EN: Code for Route of administration not applicable.<br>
     * DE: Code für Art der Anwendung nicht spezifizierbar.<br>
     * FR: Code de Autre(s).<br>
     * IT: Code per Via di somministrazione non specificabile.<br>
     */
    public static final String ROUTE_OF_ADMINISTRATION_NOT_APPLICABLE_CODE = "20062000";

    /**
     * EN: Code for Skin scarification.<br>
     * DE: Code für Einritzen der Haut.<br>
     * FR: Code de Scarification.<br>
     * IT: Code per Scarificazione.<br>
     */
    public static final String SKIN_SCARIFICATION_CODE = "20063000";

    /**
     * EN: Code for Subconjunctival use.<br>
     * DE: Code für subkonjunktivale Anwendung.<br>
     * FR: Code de Voie sous-conjonctivale.<br>
     * IT: Code per Uso subcongiuntivale.<br>
     */
    public static final String SUBCONJUNCTIVAL_USE_CODE = "20065000";

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
     * EN: Code for Submucosal use.<br>
     * DE: Code für submuköse Anwendung.<br>
     * FR: Code de Voie sous-muqueuse.<br>
     * IT: Code per Uso sottomucosale.<br>
     */
    public static final String SUBMUCOSAL_USE_CODE = "20067500";

    /**
     * EN: Code for Subretinal use.<br>
     * DE: Code für subretinale Anwendung.<br>
     * FR: Code de Voie subrétinale.<br>
     * IT: Code per Uso sottoretinico.<br>
     */
    public static final String SUBRETINAL_USE_CODE = "20081000";

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
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "RouteOfAdministrationEDQM";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "2.16.756.5.30.1.1.11.2";

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

    RouteOfAdministrationEdqm(@NonNull final String code,
                              @NonNull final String codeSystem,
                              @NonNull final String displayName,
                              @NonNull final String displayNameEn,
                              @NonNull final String displayNameDe,
                              @NonNull final String displayNameFr,
                              @NonNull final String displayNameIt) {
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
        return switch (languageCode) {
            case ENGLISH -> this.displayNames[1];
            case GERMAN -> this.displayNames[2];
            case FRENCH -> this.displayNames[3];
            case ITALIAN -> this.displayNames[4];
            default -> "TOTRANSLATE";
        };
    }

    @Override
    public @NonNull String getValueSetId() {
        return null;
    }

    @Override
    public @NonNull String getValueSetName() {
        return null;
    }

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static RouteOfAdministrationEdqm getEnum(@Nullable final String code) {
        for (final var x : values()) {
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
            Enum.valueOf(RouteOfAdministrationEdqm.class,
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
        for (final var x : values()) {
            if (x.getCodeValue().equals(codeValue)) {
                return true;
            }
        }
        return false;
    }
}
