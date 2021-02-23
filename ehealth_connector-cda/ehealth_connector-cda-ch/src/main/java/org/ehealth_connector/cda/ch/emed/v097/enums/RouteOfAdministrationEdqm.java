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
package org.ehealth_connector.cda.ch.emed.v097.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * <div class="en">Valueset RouteOufAdministration from EQM, ROA, export 24.4.2018, see https://standardterms.edqm.eu/#</div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-02-23")
public enum RouteOfAdministrationEdqm implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Auricular use</div>
	 * <div class="de">Anwendung am Ohr</div>
	 * <div class="fr">Voie auriculaire</div>
	 * <div class="it">Uso auricolare</div>
	 * <!-- @formatter:on -->
	 */
	AURICULAR_USE("20001000", "0.4.0.127.0.16.1.1.2.1", "Auricular use", "Auricular use",
			"Anwendung am Ohr", "Voie auriculaire", "Uso auricolare"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Buccal use</div>
	 * <div class="de">Buccale Anwendung</div>
	 * <div class="fr">Voie buccogingivale</div>
	 * <!-- @formatter:on -->
	 */
	BUCCAL_USE("20002500", "0.4.0.127.0.16.1.1.2.1", "Buccal use", "Buccal use",
			"Buccale Anwendung", "Voie buccogingivale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cutaneous use</div>
	 * <div class="de">Anwendung auf der Haut</div>
	 * <div class="fr">Voie cutanée</div>
	 * <div class="it">Uso cutaneo</div>
	 * <!-- @formatter:on -->
	 */
	CUTANEOUS_USE("20003000", "0.4.0.127.0.16.1.1.2.1", "Cutaneous use", "Cutaneous use",
			"Anwendung auf der Haut", "Voie cutanée", "Uso cutaneo"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dental use</div>
	 * <div class="de">dentale Anwendung</div>
	 * <div class="fr">Voie dentaire</div>
	 * <div class="it">Uso dentale</div>
	 * <!-- @formatter:on -->
	 */
	DENTAL_USE("20004000", "0.4.0.127.0.16.1.1.2.1", "Dental use", "Dental use",
			"dentale Anwendung", "Voie dentaire", "Uso dentale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Endocervical use</div>
	 * <div class="de">endozervikale Anwendung</div>
	 * <div class="fr">Voie endocervicale</div>
	 * <div class="it">Uso endocervicale</div>
	 * <!-- @formatter:on -->
	 */
	ENDOCERVICAL_USE("20006000", "0.4.0.127.0.16.1.1.2.1", "Endocervical use", "Endocervical use",
			"endozervikale Anwendung", "Voie endocervicale", "Uso endocervicale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Endosinusial use</div>
	 * <div class="de">Anwendung in den Nebenhöhlen</div>
	 * <div class="fr">Voie endosinusale</div>
	 * <div class="it">Uso endosinusiale</div>
	 * <!-- @formatter:on -->
	 */
	ENDOSINUSIAL_USE("20007000", "0.4.0.127.0.16.1.1.2.1", "Endosinusial use", "Endosinusial use",
			"Anwendung in den Nebenhöhlen", "Voie endosinusale", "Uso endosinusiale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Endotracheopulmonary use</div>
	 * <div class="de">endotracheopulmonale Anwendung</div>
	 * <div class="fr">Voie endotrachéobronchique</div>
	 * <div class="it">Uso endotracheobronchiale</div>
	 * <!-- @formatter:on -->
	 */
	ENDOTRACHEOPULMONARY_USE("20008000", "0.4.0.127.0.16.1.1.2.1", "Endotracheopulmonary use",
			"Endotracheopulmonary use", "endotracheopulmonale Anwendung",
			"Voie endotrachéobronchique", "Uso endotracheobronchiale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Epidural use</div>
	 * <div class="de">epidurale Anwendung</div>
	 * <div class="fr">Voie péridurale</div>
	 * <div class="it">Uso epidurale</div>
	 * <!-- @formatter:on -->
	 */
	EPIDURAL_USE("20009000", "0.4.0.127.0.16.1.1.2.1", "Epidural use", "Epidural use",
			"epidurale Anwendung", "Voie péridurale", "Uso epidurale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Epilesional use</div>
	 * <div class="de">zum Auftragen auf die Wunde</div>
	 * <div class="fr">Voie épilésionnelle</div>
	 * <div class="it">Uso epilesionale</div>
	 * <!-- @formatter:on -->
	 */
	EPILESIONAL_USE("20010000", "0.4.0.127.0.16.1.1.2.1", "Epilesional use", "Epilesional use",
			"zum Auftragen auf die Wunde", "Voie épilésionnelle", "Uso epilesionale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Extraamniotic use</div>
	 * <div class="de">extraamniotische Anwendung</div>
	 * <div class="fr">Voie extra-amniotique</div>
	 * <div class="it">Uso extra-amniotico</div>
	 * <!-- @formatter:on -->
	 */
	EXTRAAMNIOTIC_USE("20011000", "0.4.0.127.0.16.1.1.2.1", "Extraamniotic use",
			"Extraamniotic use", "extraamniotische Anwendung", "Voie extra-amniotique",
			"Uso extra-amniotico"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Extracorporeal use</div>
	 * <div class="de">extrakorporale Anwendung</div>
	 * <div class="fr">Voie extracorporelle</div>
	 * <!-- @formatter:on -->
	 */
	EXTRACORPOREAL_USE("20011500", "0.4.0.127.0.16.1.1.2.1", "Extracorporeal use",
			"Extracorporeal use", "extrakorporale Anwendung", "Voie extracorporelle",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gastric use</div>
	 * <div class="de">zur Anwendung mittels Magensonde</div>
	 * <div class="fr">Voie gastrique</div>
	 * <div class="it">Uso gastrico</div>
	 * <!-- @formatter:on -->
	 */
	GASTRIC_USE("20013500", "0.4.0.127.0.16.1.1.2.1", "Gastric use", "Gastric use",
			"zur Anwendung mittels Magensonde", "Voie gastrique", "Uso gastrico"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gastroenteral use</div>
	 * <div class="de">gastrointestinale Anwendung</div>
	 * <div class="fr">Voie gastro-entérale</div>
	 * <div class="it">Uso gastrointestinale</div>
	 * <!-- @formatter:on -->
	 */
	GASTROENTERAL_USE("20013000", "0.4.0.127.0.16.1.1.2.1", "Gastroenteral use",
			"Gastroenteral use", "gastrointestinale Anwendung", "Voie gastro-entérale",
			"Uso gastrointestinale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gingival use</div>
	 * <div class="de">Anwendung am Zahnfleisch</div>
	 * <div class="fr">Voie gingivale</div>
	 * <div class="it">Uso gengivale</div>
	 * <!-- @formatter:on -->
	 */
	GINGIVAL_USE("20014000", "0.4.0.127.0.16.1.1.2.1", "Gingival use", "Gingival use",
			"Anwendung am Zahnfleisch", "Voie gingivale", "Uso gengivale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Haemodialysis</div>
	 * <div class="de">Hämodialyse</div>
	 * <div class="fr">Hémodialyse</div>
	 * <div class="it">Emodialisi</div>
	 * <!-- @formatter:on -->
	 */
	HAEMODIALYSIS("20015000", "0.4.0.127.0.16.1.1.2.1", "Haemodialysis", "Haemodialysis",
			"Hämodialyse", "Hémodialyse", "Emodialisi"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Implantation</div>
	 * <div class="de">zur Implantation</div>
	 * <div class="fr">Implantation</div>
	 * <!-- @formatter:on -->
	 */
	IMPLANTATION("20015500", "0.4.0.127.0.16.1.1.2.1", "Implantation", "Implantation",
			"zur Implantation", "Implantation", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Infiltration</div>
	 * <div class="de">Infiltration</div>
	 * <div class="fr">Infiltration</div>
	 * <!-- @formatter:on -->
	 */
	INFILTRATION("20019500", "0.4.0.127.0.16.1.1.2.1", "Infiltration", "Infiltration",
			"Infiltration", "Infiltration", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation use</div>
	 * <div class="de">zur Inhalation</div>
	 * <div class="fr">Voie inhalée</div>
	 * <div class="it">Uso inalatorio</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_USE("20020000", "0.4.0.127.0.16.1.1.2.1", "Inhalation use", "Inhalation use",
			"zur Inhalation", "Voie inhalée", "Uso inalatorio"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intestinal use</div>
	 * <div class="de">intestinale Anwendung</div>
	 * <div class="fr">Voie intestinale</div>
	 * <div class="it">Uso intestinale</div>
	 * <!-- @formatter:on -->
	 */
	INTESTINAL_USE("20021000", "0.4.0.127.0.16.1.1.2.1", "Intestinal use", "Intestinal use",
			"intestinale Anwendung", "Voie intestinale", "Uso intestinale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intraamniotic use</div>
	 * <div class="de">intraamniotische Anwendung</div>
	 * <div class="fr">Voie intraamniotique</div>
	 * <div class="it">Uso intra-amniotico</div>
	 * <!-- @formatter:on -->
	 */
	INTRAAMNIOTIC_USE("20022000", "0.4.0.127.0.16.1.1.2.1", "Intraamniotic use",
			"Intraamniotic use", "intraamniotische Anwendung", "Voie intraamniotique",
			"Uso intra-amniotico"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intraarterial use</div>
	 * <div class="de">intraarterielle Anwendung</div>
	 * <div class="fr">Voie intraartérielle</div>
	 * <div class="it">Uso endoarterioso</div>
	 * <!-- @formatter:on -->
	 */
	INTRAARTERIAL_USE("20023000", "0.4.0.127.0.16.1.1.2.1", "Intraarterial use",
			"Intraarterial use", "intraarterielle Anwendung", "Voie intraartérielle",
			"Uso endoarterioso"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intraarticular use</div>
	 * <div class="de">intraartikuläre Anwendung</div>
	 * <div class="fr">Voie intraarticulaire</div>
	 * <div class="it">Uso intra-articolare</div>
	 * <!-- @formatter:on -->
	 */
	INTRAARTICULAR_USE("20024000", "0.4.0.127.0.16.1.1.2.1", "Intraarticular use",
			"Intraarticular use", "intraartikuläre Anwendung", "Voie intraarticulaire",
			"Uso intra-articolare"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intrabursal use</div>
	 * <div class="de">intrabursale Anwendung</div>
	 * <div class="fr">Voie intrabursale</div>
	 * <div class="it">Uso intrabursale</div>
	 * <!-- @formatter:on -->
	 */
	INTRABURSAL_USE("20025000", "0.4.0.127.0.16.1.1.2.1", "Intrabursal use", "Intrabursal use",
			"intrabursale Anwendung", "Voie intrabursale", "Uso intrabursale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intracameral use</div>
	 * <div class="de">intrakamerale Anwendung</div>
	 * <div class="fr">Voie intracamérulaire</div>
	 * <!-- @formatter:on -->
	 */
	INTRACAMERAL_USE("20025500", "0.4.0.127.0.16.1.1.2.1", "Intracameral use", "Intracameral use",
			"intrakamerale Anwendung", "Voie intracamérulaire", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intracardiac use</div>
	 * <div class="de">intracardiale Anwendung</div>
	 * <div class="fr">Voie intracardiaque</div>
	 * <div class="it">Uso intracardiaco</div>
	 * <!-- @formatter:on -->
	 */
	INTRACARDIAC_USE("20026000", "0.4.0.127.0.16.1.1.2.1", "Intracardiac use", "Intracardiac use",
			"intracardiale Anwendung", "Voie intracardiaque", "Uso intracardiaco"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intracartilaginous use</div>
	 * <div class="de">intrakartilaginäre Anwendung</div>
	 * <div class="fr">Voie intracartilagineuse</div>
	 * <!-- @formatter:on -->
	 */
	INTRACARTILAGINOUS_USE("20026500", "0.4.0.127.0.16.1.1.2.1", "Intracartilaginous use",
			"Intracartilaginous use", "intrakartilaginäre Anwendung", "Voie intracartilagineuse",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intracavernous use</div>
	 * <div class="de">intrakavernöse Anwendung</div>
	 * <div class="fr">Voie intracaverneuse</div>
	 * <div class="it">Uso intracavernoso</div>
	 * <!-- @formatter:on -->
	 */
	INTRACAVERNOUS_USE("20027000", "0.4.0.127.0.16.1.1.2.1", "Intracavernous use",
			"Intracavernous use", "intrakavernöse Anwendung", "Voie intracaverneuse",
			"Uso intracavernoso"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intracerebral use</div>
	 * <div class="de">Intrazerebrale Anwendung</div>
	 * <div class="fr">Voie intracérébrale</div>
	 * <div class="it">Uso intracerebrale</div>
	 * <!-- @formatter:on -->
	 */
	INTRACEREBRAL_USE("20027010", "0.4.0.127.0.16.1.1.2.1", "Intracerebral use",
			"Intracerebral use", "Intrazerebrale Anwendung", "Voie intracérébrale",
			"Uso intracerebrale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intracerebroventricular use</div>
	 * <div class="de">intracerebroventrikuläre Anwendung</div>
	 * <div class="fr">Voie intracérébroventriculaire</div>
	 * <!-- @formatter:on -->
	 */
	INTRACEREBROVENTRICULAR_USE("20080000", "0.4.0.127.0.16.1.1.2.1", "Intracerebroventricular use",
			"Intracerebroventricular use", "intracerebroventrikuläre Anwendung",
			"Voie intracérébroventriculaire", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intracervical use</div>
	 * <div class="de">intrazervikale Anwendung</div>
	 * <div class="fr">Voie intracervicale</div>
	 * <div class="it">Uso intracervicale</div>
	 * <!-- @formatter:on -->
	 */
	INTRACERVICAL_USE("20028000", "0.4.0.127.0.16.1.1.2.1", "Intracervical use",
			"Intracervical use", "intrazervikale Anwendung", "Voie intracervicale",
			"Uso intracervicale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intracholangiopancreatic use</div>
	 * <div class="de">zur Anwendung in der Cholangiopankreatikographie</div>
	 * <div class="fr">Voie intracholangiopancréatique</div>
	 * <!-- @formatter:on -->
	 */
	INTRACHOLANGIOPANCREATIC_USE("20028300", "0.4.0.127.0.16.1.1.2.1",
			"Intracholangiopancreatic use", "Intracholangiopancreatic use",
			"zur Anwendung in der Cholangiopankreatikographie", "Voie intracholangiopancréatique",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intracisternal use</div>
	 * <div class="de">intracisternale Anwendung</div>
	 * <div class="fr">Voie intracisternale</div>
	 * <!-- @formatter:on -->
	 */
	INTRACISTERNAL_USE("20028500", "0.4.0.127.0.16.1.1.2.1", "Intracisternal use",
			"Intracisternal use", "intracisternale Anwendung", "Voie intracisternale",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intracoronary use</div>
	 * <div class="de">intrakoronare Anwendung</div>
	 * <div class="fr">Voie intracoronaire</div>
	 * <div class="it">Uso intracoronarico</div>
	 * <!-- @formatter:on -->
	 */
	INTRACORONARY_USE("20029000", "0.4.0.127.0.16.1.1.2.1", "Intracoronary use",
			"Intracoronary use", "intrakoronare Anwendung", "Voie intracoronaire",
			"Uso intracoronarico"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intradermal use</div>
	 * <div class="de">intradermale Anwendung</div>
	 * <div class="fr">Voie intradermique</div>
	 * <div class="it">Uso intradermico</div>
	 * <!-- @formatter:on -->
	 */
	INTRADERMAL_USE("20030000", "0.4.0.127.0.16.1.1.2.1", "Intradermal use", "Intradermal use",
			"intradermale Anwendung", "Voie intradermique", "Uso intradermico"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intradiscal use</div>
	 * <div class="de">intradiskale Anwendung</div>
	 * <div class="fr">Voie intradiscale</div>
	 * <div class="it">Uso intradiscale</div>
	 * <!-- @formatter:on -->
	 */
	INTRADISCAL_USE("20031000", "0.4.0.127.0.16.1.1.2.1", "Intradiscal use", "Intradiscal use",
			"intradiskale Anwendung", "Voie intradiscale", "Uso intradiscale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intraepidermal use</div>
	 * <div class="de">intraepidermale Anwendung</div>
	 * <div class="fr">Voie intraépidermique</div>
	 * <!-- @formatter:on -->
	 */
	INTRAEPIDERMAL_USE("20031500", "0.4.0.127.0.16.1.1.2.1", "Intraepidermal use",
			"Intraepidermal use", "intraepidermale Anwendung", "Voie intraépidermique",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intraglandular use</div>
	 * <div class="de">intraglanduläre Anwendung</div>
	 * <div class="fr">Voie intraglandulaire</div>
	 * <!-- @formatter:on -->
	 */
	INTRAGLANDULAR_USE("20031700", "0.4.0.127.0.16.1.1.2.1", "Intraglandular use",
			"Intraglandular use", "intraglanduläre Anwendung", "Voie intraglandulaire",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intralesional use</div>
	 * <div class="de">intraläsionale Anwendung</div>
	 * <div class="fr">Voie intralésionnelle</div>
	 * <div class="it">Uso intralesionale</div>
	 * <!-- @formatter:on -->
	 */
	INTRALESIONAL_USE("20032000", "0.4.0.127.0.16.1.1.2.1", "Intralesional use",
			"Intralesional use", "intraläsionale Anwendung", "Voie intralésionnelle",
			"Uso intralesionale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intralymphatic use</div>
	 * <div class="de">intralymphatische Anwendung</div>
	 * <div class="fr">Voie intralymphatique</div>
	 * <div class="it">Uso intralinfatico</div>
	 * <!-- @formatter:on -->
	 */
	INTRALYMPHATIC_USE("20033000", "0.4.0.127.0.16.1.1.2.1", "Intralymphatic use",
			"Intralymphatic use", "intralymphatische Anwendung", "Voie intralymphatique",
			"Uso intralinfatico"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intramuscular use</div>
	 * <div class="de">intramuskuläre Anwendung</div>
	 * <div class="fr">Voie intramusculaire</div>
	 * <div class="it">Uso intramuscolare</div>
	 * <!-- @formatter:on -->
	 */
	INTRAMUSCULAR_USE("20035000", "0.4.0.127.0.16.1.1.2.1", "Intramuscular use",
			"Intramuscular use", "intramuskuläre Anwendung", "Voie intramusculaire",
			"Uso intramuscolare"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intraocular use</div>
	 * <div class="de">intraokulare Anwendung</div>
	 * <div class="fr">Voie intraoculaire</div>
	 * <div class="it">Uso intraoculare</div>
	 * <!-- @formatter:on -->
	 */
	INTRAOCULAR_USE("20036000", "0.4.0.127.0.16.1.1.2.1", "Intraocular use", "Intraocular use",
			"intraokulare Anwendung", "Voie intraoculaire", "Uso intraoculare"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intraosseous use</div>
	 * <div class="de">intraossäre Anwendung</div>
	 * <div class="fr">Voie intraosseuse</div>
	 * <div class="it">Uso intraosseo</div>
	 * <!-- @formatter:on -->
	 */
	INTRAOSSEOUS_USE("20036500", "0.4.0.127.0.16.1.1.2.1", "Intraosseous use", "Intraosseous use",
			"intraossäre Anwendung", "Voie intraosseuse", "Uso intraosseo"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intrapericardial use</div>
	 * <div class="de">Intraperikardial</div>
	 * <div class="fr">Voie intrapéricardiaque</div>
	 * <div class="it">Uso intrapericardico</div>
	 * <!-- @formatter:on -->
	 */
	INTRAPERICARDIAL_USE("20037000", "0.4.0.127.0.16.1.1.2.1", "Intrapericardial use",
			"Intrapericardial use", "Intraperikardial", "Voie intrapéricardiaque",
			"Uso intrapericardico"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intraperitoneal use</div>
	 * <div class="de">intraperitoneale Anwendung</div>
	 * <div class="fr">Voie intrapéritonéale</div>
	 * <div class="it">Uso intraperitoneale</div>
	 * <!-- @formatter:on -->
	 */
	INTRAPERITONEAL_USE("20038000", "0.4.0.127.0.16.1.1.2.1", "Intraperitoneal use",
			"Intraperitoneal use", "intraperitoneale Anwendung", "Voie intrapéritonéale",
			"Uso intraperitoneale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intrapleural use</div>
	 * <div class="de">intrapleurale Anwendung</div>
	 * <div class="fr">Voie intrapleurale</div>
	 * <div class="it">Uso intrapleurico</div>
	 * <!-- @formatter:on -->
	 */
	INTRAPLEURAL_USE("20039000", "0.4.0.127.0.16.1.1.2.1", "Intrapleural use", "Intrapleural use",
			"intrapleurale Anwendung", "Voie intrapleurale", "Uso intrapleurico"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intraportal use</div>
	 * <div class="de">intraportale Anwendung</div>
	 * <div class="fr">Voie intraportale</div>
	 * <!-- @formatter:on -->
	 */
	INTRAPORTAL_USE("20039200", "0.4.0.127.0.16.1.1.2.1", "Intraportal use", "Intraportal use",
			"intraportale Anwendung", "Voie intraportale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intraprostatic use</div>
	 * <div class="de">intraprostatische Anwendung</div>
	 * <div class="fr">Voie intraprostatique</div>
	 * <!-- @formatter:on -->
	 */
	INTRAPROSTATIC_USE("20039500", "0.4.0.127.0.16.1.1.2.1", "Intraprostatic use",
			"Intraprostatic use", "intraprostatische Anwendung", "Voie intraprostatique",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intrasternal use</div>
	 * <div class="de">intrasternale Anwendung</div>
	 * <div class="fr">Voie intrasternale</div>
	 * <div class="it">Uso intrasternale</div>
	 * <!-- @formatter:on -->
	 */
	INTRASTERNAL_USE("20041000", "0.4.0.127.0.16.1.1.2.1", "Intrasternal use", "Intrasternal use",
			"intrasternale Anwendung", "Voie intrasternale", "Uso intrasternale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intrathecal use</div>
	 * <div class="de">intrathekale Anwendung</div>
	 * <div class="fr">Voie intrathécale</div>
	 * <div class="it">Uso intratecale</div>
	 * <!-- @formatter:on -->
	 */
	INTRATHECAL_USE("20042000", "0.4.0.127.0.16.1.1.2.1", "Intrathecal use", "Intrathecal use",
			"intrathekale Anwendung", "Voie intrathécale", "Uso intratecale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intratumoral use</div>
	 * <div class="de">intratumorale Anwendung</div>
	 * <div class="fr">Voie intratumorale</div>
	 * <div class="it">Uso intratumorale</div>
	 * <!-- @formatter:on -->
	 */
	INTRATUMORAL_USE("20043000", "0.4.0.127.0.16.1.1.2.1", "Intratumoral use", "Intratumoral use",
			"intratumorale Anwendung", "Voie intratumorale", "Uso intratumorale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intrauterine use</div>
	 * <div class="de">intrauterine Anwendung</div>
	 * <div class="fr">Voie intra-utérine</div>
	 * <div class="it">Uso intrauterino</div>
	 * <!-- @formatter:on -->
	 */
	INTRAUTERINE_USE("20044000", "0.4.0.127.0.16.1.1.2.1", "Intrauterine use", "Intrauterine use",
			"intrauterine Anwendung", "Voie intra-utérine", "Uso intrauterino"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intravenous use</div>
	 * <div class="de">intravenöse Anwendung</div>
	 * <div class="fr">Voie intraveineuse</div>
	 * <div class="it">Uso endovenoso</div>
	 * <!-- @formatter:on -->
	 */
	INTRAVENOUS_USE("20045000", "0.4.0.127.0.16.1.1.2.1", "Intravenous use", "Intravenous use",
			"intravenöse Anwendung", "Voie intraveineuse", "Uso endovenoso"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intravesical use</div>
	 * <div class="de">intravesikale Anwendung</div>
	 * <div class="fr">Voie intravésicale</div>
	 * <div class="it">Uso endovescicale</div>
	 * <!-- @formatter:on -->
	 */
	INTRAVESICAL_USE("20046000", "0.4.0.127.0.16.1.1.2.1", "Intravesical use", "Intravesical use",
			"intravesikale Anwendung", "Voie intravésicale", "Uso endovescicale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intravitreal use</div>
	 * <div class="de">Intravitreal</div>
	 * <div class="fr">Voie intravitréenne</div>
	 * <div class="it">Uso intravitreo</div>
	 * <!-- @formatter:on -->
	 */
	INTRAVITREAL_USE("20047000", "0.4.0.127.0.16.1.1.2.1", "Intravitreal use", "Intravitreal use",
			"Intravitreal", "Voie intravitréenne", "Uso intravitreo"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Iontophoresis</div>
	 * <div class="de">zur Iontophorese</div>
	 * <div class="fr">Iontophorèse</div>
	 * <div class="it">0</div>
	 * <!-- @formatter:on -->
	 */
	IONTOPHORESIS("20047500", "0.4.0.127.0.16.1.1.2.1", "Iontophoresis", "Iontophoresis",
			"zur Iontophorese", "Iontophorèse", "0"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Laryngopharyngeal use</div>
	 * <div class="de">zur Anwendung im Rachen und am Kehlkopf</div>
	 * <div class="fr">Voie laryngopharyngée</div>
	 * <div class="it">Uso laringofaringeo</div>
	 * <!-- @formatter:on -->
	 */
	LARYNGOPHARYNGEAL_USE("20048000", "0.4.0.127.0.16.1.1.2.1", "Laryngopharyngeal use",
			"Laryngopharyngeal use", "zur Anwendung im Rachen und am Kehlkopf",
			"Voie laryngopharyngée", "Uso laringofaringeo"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nasal use</div>
	 * <div class="de">nasale Anwendung</div>
	 * <div class="fr">Voie nasale</div>
	 * <div class="it">Uso nasale</div>
	 * <!-- @formatter:on -->
	 */
	NASAL_USE("20049000", "0.4.0.127.0.16.1.1.2.1", "Nasal use", "Nasal use", "nasale Anwendung",
			"Voie nasale", "Uso nasale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ocular use</div>
	 * <div class="de">Anwendung am Auge</div>
	 * <div class="fr">Voie ophtalmique</div>
	 * <div class="it">Uso oftalmico</div>
	 * <!-- @formatter:on -->
	 */
	OCULAR_USE("20051000", "0.4.0.127.0.16.1.1.2.1", "Ocular use", "Ocular use",
			"Anwendung am Auge", "Voie ophtalmique", "Uso oftalmico"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oral use</div>
	 * <div class="de">zum Einnehmen</div>
	 * <div class="fr">Voie orale</div>
	 * <div class="it">Uso orale</div>
	 * <!-- @formatter:on -->
	 */
	ORAL_USE("20053000", "0.4.0.127.0.16.1.1.2.1", "Oral use", "Oral use", "zum Einnehmen",
			"Voie orale", "Uso orale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oromucosal use</div>
	 * <div class="de">Anwendung in der Mundhöhle</div>
	 * <div class="fr">Voie buccale</div>
	 * <div class="it">Per mucosa orale</div>
	 * <!-- @formatter:on -->
	 */
	OROMUCOSAL_USE("20054000", "0.4.0.127.0.16.1.1.2.1", "Oromucosal use", "Oromucosal use",
			"Anwendung in der Mundhöhle", "Voie buccale", "Per mucosa orale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oropharyngeal use</div>
	 * <div class="de">zur Anwendung im Mund- und Rachenraum</div>
	 * <div class="fr">Voie oropharyngée</div>
	 * <div class="it">Uso orofaringeo</div>
	 * <!-- @formatter:on -->
	 */
	OROPHARYNGEAL_USE("20055000", "0.4.0.127.0.16.1.1.2.1", "Oropharyngeal use",
			"Oropharyngeal use", "zur Anwendung im Mund- und Rachenraum", "Voie oropharyngée",
			"Uso orofaringeo"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Periarticular use</div>
	 * <div class="de">periartikuläre Anwendung</div>
	 * <div class="fr">Voie périarticulaire</div>
	 * <div class="it">Uso periarticolare</div>
	 * <!-- @formatter:on -->
	 */
	PERIARTICULAR_USE("20057000", "0.4.0.127.0.16.1.1.2.1", "Periarticular use",
			"Periarticular use", "periartikuläre Anwendung", "Voie périarticulaire",
			"Uso periarticolare"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Perineural use</div>
	 * <div class="de">perineurale Anwendung</div>
	 * <div class="fr">Voie périneurale</div>
	 * <div class="it">Uso perineurale</div>
	 * <!-- @formatter:on -->
	 */
	PERINEURAL_USE("20058000", "0.4.0.127.0.16.1.1.2.1", "Perineural use", "Perineural use",
			"perineurale Anwendung", "Voie périneurale", "Uso perineurale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Periodontal use</div>
	 * <div class="de">zur periodontalen Anwendung</div>
	 * <div class="fr">Voie périodontale</div>
	 * <div class="it">Uso periodontale</div>
	 * <!-- @formatter:on -->
	 */
	PERIODONTAL_USE("20059000", "0.4.0.127.0.16.1.1.2.1", "Periodontal use", "Periodontal use",
			"zur periodontalen Anwendung", "Voie périodontale", "Uso periodontale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Periosseous use</div>
	 * <div class="de">periossäre Anwendung</div>
	 * <div class="fr">Voie périosseuse</div>
	 * <!-- @formatter:on -->
	 */
	PERIOSSEOUS_USE("20059300", "0.4.0.127.0.16.1.1.2.1", "Periosseous use", "Periosseous use",
			"periossäre Anwendung", "Voie périosseuse", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Peritumoral use</div>
	 * <div class="de">peritumorale Anwendung</div>
	 * <div class="fr">Voie péritumorale</div>
	 * <!-- @formatter:on -->
	 */
	PERITUMORAL_USE("20059400", "0.4.0.127.0.16.1.1.2.1", "Peritumoral use", "Peritumoral use",
			"peritumorale Anwendung", "Voie péritumorale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Posterior juxtascleral use</div>
	 * <div class="de">posteriore juxtasclerale Anwendung</div>
	 * <div class="fr">Voie juxta-sclérale postérieure</div>
	 * <div class="it">Uso iuxtasclerale posteriore</div>
	 * <!-- @formatter:on -->
	 */
	POSTERIOR_JUXTASCLERAL_USE("20059500", "0.4.0.127.0.16.1.1.2.1", "Posterior juxtascleral use",
			"Posterior juxtascleral use", "posteriore juxtasclerale Anwendung",
			"Voie juxta-sclérale postérieure", "Uso iuxtasclerale posteriore"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rectal use</div>
	 * <div class="de">rektale Anwendung</div>
	 * <div class="fr">Voie rectale</div>
	 * <div class="it">Uso rettale</div>
	 * <!-- @formatter:on -->
	 */
	RECTAL_USE("20061000", "0.4.0.127.0.16.1.1.2.1", "Rectal use", "Rectal use",
			"rektale Anwendung", "Voie rectale", "Uso rettale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Retrobulbar use</div>
	 * <div class="de">retrobulbäre Anwendung</div>
	 * <div class="fr">Voie rétrobulbaire</div>
	 * <!-- @formatter:on -->
	 */
	RETROBULBAR_USE("20061500", "0.4.0.127.0.16.1.1.2.1", "Retrobulbar use", "Retrobulbar use",
			"retrobulbäre Anwendung", "Voie rétrobulbaire", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Route of administration not applicable</div>
	 * <div class="de">Art der Anwendung nicht spezifizierbar</div>
	 * <div class="fr">Autre(s)</div>
	 * <div class="it">Via di somministrazione non specificabile</div>
	 * <!-- @formatter:on -->
	 */
	ROUTE_OF_ADMINISTRATION_NOT_APPLICABLE("20062000", "0.4.0.127.0.16.1.1.2.1",
			"Route of administration not applicable", "Route of administration not applicable",
			"Art der Anwendung nicht spezifizierbar", "Autre(s)",
			"Via di somministrazione non specificabile"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Skin scarification</div>
	 * <div class="de">Einritzen der Haut</div>
	 * <div class="fr">Scarification</div>
	 * <div class="it">Scarificazione</div>
	 * <!-- @formatter:on -->
	 */
	SKIN_SCARIFICATION("20063000", "0.4.0.127.0.16.1.1.2.1", "Skin scarification",
			"Skin scarification", "Einritzen der Haut", "Scarification", "Scarificazione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Subconjunctival use</div>
	 * <div class="de">subkonjunktivale Anwendung</div>
	 * <div class="fr">Voie sous-conjonctivale</div>
	 * <div class="it">Uso subcongiuntivale</div>
	 * <!-- @formatter:on -->
	 */
	SUBCONJUNCTIVAL_USE("20065000", "0.4.0.127.0.16.1.1.2.1", "Subconjunctival use",
			"Subconjunctival use", "subkonjunktivale Anwendung", "Voie sous-conjonctivale",
			"Uso subcongiuntivale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Subcutaneous use</div>
	 * <div class="de">subkutane Anwendung</div>
	 * <div class="fr">Voie sous-cutanée</div>
	 * <div class="it">Uso sottocutaneo</div>
	 * <!-- @formatter:on -->
	 */
	SUBCUTANEOUS_USE("20066000", "0.4.0.127.0.16.1.1.2.1", "Subcutaneous use", "Subcutaneous use",
			"subkutane Anwendung", "Voie sous-cutanée", "Uso sottocutaneo"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Sublingual use</div>
	 * <div class="de">Sublingual</div>
	 * <div class="fr">Voie sublinguale</div>
	 * <div class="it">Uso sublinguale</div>
	 * <!-- @formatter:on -->
	 */
	SUBLINGUAL_USE("20067000", "0.4.0.127.0.16.1.1.2.1", "Sublingual use", "Sublingual use",
			"Sublingual", "Voie sublinguale", "Uso sublinguale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Submucosal use</div>
	 * <div class="de">submuköse Anwendung</div>
	 * <div class="fr">Voie sous-muqueuse</div>
	 * <!-- @formatter:on -->
	 */
	SUBMUCOSAL_USE("20067500", "0.4.0.127.0.16.1.1.2.1", "Submucosal use", "Submucosal use",
			"submuköse Anwendung", "Voie sous-muqueuse", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Subretinal use</div>
	 * <div class="de">subretinale Anwendung</div>
	 * <div class="fr">Voie subrétinale</div>
	 * <!-- @formatter:on -->
	 */
	SUBRETINAL_USE("20081000", "0.4.0.127.0.16.1.1.2.1", "Subretinal use", "Subretinal use",
			"subretinale Anwendung", "Voie subrétinale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Transdermal use</div>
	 * <div class="de">transdermale Anwendung</div>
	 * <div class="fr">Voie transdermique</div>
	 * <div class="it">Uso transdermico</div>
	 * <!-- @formatter:on -->
	 */
	TRANSDERMAL_USE("20070000", "0.4.0.127.0.16.1.1.2.1", "Transdermal use", "Transdermal use",
			"transdermale Anwendung", "Voie transdermique", "Uso transdermico"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Urethral use</div>
	 * <div class="de">Anwendung in der Harnröhre</div>
	 * <div class="fr">Voie urétrale</div>
	 * <div class="it">Uso uretrale</div>
	 * <!-- @formatter:on -->
	 */
	URETHRAL_USE("20071000", "0.4.0.127.0.16.1.1.2.1", "Urethral use", "Urethral use",
			"Anwendung in der Harnröhre", "Voie urétrale", "Uso uretrale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Vaginal use</div>
	 * <div class="de">vaginale Anwendung</div>
	 * <div class="fr">Voie vaginale</div>
	 * <div class="it">Uso vaginale</div>
	 * <!-- @formatter:on -->
	 */
	VAGINAL_USE("20072000", "0.4.0.127.0.16.1.1.2.1", "Vaginal use", "Vaginal use",
			"vaginale Anwendung", "Voie vaginale", "Uso vaginale");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Auricular use</div>
	 * <div class="de">Code für Anwendung am Ohr</div>
	 * <div class="fr">Code de Voie auriculaire</div>
	 * <div class="it">Code per Uso auricolare</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AURICULAR_USE_CODE = "20001000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Buccal use</div>
	 * <div class="de">Code für Buccale Anwendung</div>
	 * <div class="fr">Code de Voie buccogingivale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BUCCAL_USE_CODE = "20002500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cutaneous use</div>
	 * <div class="de">Code für Anwendung auf der Haut</div>
	 * <div class="fr">Code de Voie cutanée</div>
	 * <div class="it">Code per Uso cutaneo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CUTANEOUS_USE_CODE = "20003000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dental use</div>
	 * <div class="de">Code für dentale Anwendung</div>
	 * <div class="fr">Code de Voie dentaire</div>
	 * <div class="it">Code per Uso dentale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DENTAL_USE_CODE = "20004000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Endocervical use</div>
	 * <div class="de">Code für endozervikale Anwendung</div>
	 * <div class="fr">Code de Voie endocervicale</div>
	 * <div class="it">Code per Uso endocervicale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENDOCERVICAL_USE_CODE = "20006000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Endosinusial use</div>
	 * <div class="de">Code für Anwendung in den Nebenhöhlen</div>
	 * <div class="fr">Code de Voie endosinusale</div>
	 * <div class="it">Code per Uso endosinusiale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENDOSINUSIAL_USE_CODE = "20007000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Endotracheopulmonary use</div>
	 * <div class="de">Code für endotracheopulmonale Anwendung</div>
	 * <div class="fr">Code de Voie endotrachéobronchique</div>
	 * <div class="it">Code per Uso endotracheobronchiale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENDOTRACHEOPULMONARY_USE_CODE = "20008000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Epidural use</div>
	 * <div class="de">Code für epidurale Anwendung</div>
	 * <div class="fr">Code de Voie péridurale</div>
	 * <div class="it">Code per Uso epidurale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EPIDURAL_USE_CODE = "20009000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Epilesional use</div>
	 * <div class="de">Code für zum Auftragen auf die Wunde</div>
	 * <div class="fr">Code de Voie épilésionnelle</div>
	 * <div class="it">Code per Uso epilesionale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EPILESIONAL_USE_CODE = "20010000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Extraamniotic use</div>
	 * <div class="de">Code für extraamniotische Anwendung</div>
	 * <div class="fr">Code de Voie extra-amniotique</div>
	 * <div class="it">Code per Uso extra-amniotico</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EXTRAAMNIOTIC_USE_CODE = "20011000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Extracorporeal use</div>
	 * <div class="de">Code für extrakorporale Anwendung</div>
	 * <div class="fr">Code de Voie extracorporelle</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EXTRACORPOREAL_USE_CODE = "20011500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gastric use</div>
	 * <div class="de">Code für zur Anwendung mittels Magensonde</div>
	 * <div class="fr">Code de Voie gastrique</div>
	 * <div class="it">Code per Uso gastrico</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GASTRIC_USE_CODE = "20013500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gastroenteral use</div>
	 * <div class="de">Code für gastrointestinale Anwendung</div>
	 * <div class="fr">Code de Voie gastro-entérale</div>
	 * <div class="it">Code per Uso gastrointestinale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GASTROENTERAL_USE_CODE = "20013000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gingival use</div>
	 * <div class="de">Code für Anwendung am Zahnfleisch</div>
	 * <div class="fr">Code de Voie gingivale</div>
	 * <div class="it">Code per Uso gengivale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GINGIVAL_USE_CODE = "20014000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Haemodialysis</div>
	 * <div class="de">Code für Hämodialyse</div>
	 * <div class="fr">Code de Hémodialyse</div>
	 * <div class="it">Code per Emodialisi</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HAEMODIALYSIS_CODE = "20015000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Implantation</div>
	 * <div class="de">Code für zur Implantation</div>
	 * <div class="fr">Code de Implantation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMPLANTATION_CODE = "20015500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Infiltration</div>
	 * <div class="de">Code für Infiltration</div>
	 * <div class="fr">Code de Infiltration</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INFILTRATION_CODE = "20019500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation use</div>
	 * <div class="de">Code für zur Inhalation</div>
	 * <div class="fr">Code de Voie inhalée</div>
	 * <div class="it">Code per Uso inalatorio</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_USE_CODE = "20020000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intestinal use</div>
	 * <div class="de">Code für intestinale Anwendung</div>
	 * <div class="fr">Code de Voie intestinale</div>
	 * <div class="it">Code per Uso intestinale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTESTINAL_USE_CODE = "20021000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intraamniotic use</div>
	 * <div class="de">Code für intraamniotische Anwendung</div>
	 * <div class="fr">Code de Voie intraamniotique</div>
	 * <div class="it">Code per Uso intra-amniotico</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAAMNIOTIC_USE_CODE = "20022000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intraarterial use</div>
	 * <div class="de">Code für intraarterielle Anwendung</div>
	 * <div class="fr">Code de Voie intraartérielle</div>
	 * <div class="it">Code per Uso endoarterioso</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAARTERIAL_USE_CODE = "20023000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intraarticular use</div>
	 * <div class="de">Code für intraartikuläre Anwendung</div>
	 * <div class="fr">Code de Voie intraarticulaire</div>
	 * <div class="it">Code per Uso intra-articolare</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAARTICULAR_USE_CODE = "20024000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intrabursal use</div>
	 * <div class="de">Code für intrabursale Anwendung</div>
	 * <div class="fr">Code de Voie intrabursale</div>
	 * <div class="it">Code per Uso intrabursale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRABURSAL_USE_CODE = "20025000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intracameral use</div>
	 * <div class="de">Code für intrakamerale Anwendung</div>
	 * <div class="fr">Code de Voie intracamérulaire</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRACAMERAL_USE_CODE = "20025500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intracardiac use</div>
	 * <div class="de">Code für intracardiale Anwendung</div>
	 * <div class="fr">Code de Voie intracardiaque</div>
	 * <div class="it">Code per Uso intracardiaco</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRACARDIAC_USE_CODE = "20026000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intracartilaginous use</div>
	 * <div class="de">Code für intrakartilaginäre Anwendung</div>
	 * <div class="fr">Code de Voie intracartilagineuse</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRACARTILAGINOUS_USE_CODE = "20026500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intracavernous use</div>
	 * <div class="de">Code für intrakavernöse Anwendung</div>
	 * <div class="fr">Code de Voie intracaverneuse</div>
	 * <div class="it">Code per Uso intracavernoso</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRACAVERNOUS_USE_CODE = "20027000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intracerebral use</div>
	 * <div class="de">Code für Intrazerebrale Anwendung</div>
	 * <div class="fr">Code de Voie intracérébrale</div>
	 * <div class="it">Code per Uso intracerebrale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRACEREBRAL_USE_CODE = "20027010";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intracerebroventricular use</div>
	 * <div class="de">Code für intracerebroventrikuläre Anwendung</div>
	 * <div class="fr">Code de Voie intracérébroventriculaire</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRACEREBROVENTRICULAR_USE_CODE = "20080000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intracervical use</div>
	 * <div class="de">Code für intrazervikale Anwendung</div>
	 * <div class="fr">Code de Voie intracervicale</div>
	 * <div class="it">Code per Uso intracervicale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRACERVICAL_USE_CODE = "20028000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intracholangiopancreatic use</div>
	 * <div class="de">Code für zur Anwendung in der Cholangiopankreatikographie</div>
	 * <div class="fr">Code de Voie intracholangiopancréatique</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRACHOLANGIOPANCREATIC_USE_CODE = "20028300";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intracisternal use</div>
	 * <div class="de">Code für intracisternale Anwendung</div>
	 * <div class="fr">Code de Voie intracisternale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRACISTERNAL_USE_CODE = "20028500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intracoronary use</div>
	 * <div class="de">Code für intrakoronare Anwendung</div>
	 * <div class="fr">Code de Voie intracoronaire</div>
	 * <div class="it">Code per Uso intracoronarico</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRACORONARY_USE_CODE = "20029000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intradermal use</div>
	 * <div class="de">Code für intradermale Anwendung</div>
	 * <div class="fr">Code de Voie intradermique</div>
	 * <div class="it">Code per Uso intradermico</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRADERMAL_USE_CODE = "20030000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intradiscal use</div>
	 * <div class="de">Code für intradiskale Anwendung</div>
	 * <div class="fr">Code de Voie intradiscale</div>
	 * <div class="it">Code per Uso intradiscale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRADISCAL_USE_CODE = "20031000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intraepidermal use</div>
	 * <div class="de">Code für intraepidermale Anwendung</div>
	 * <div class="fr">Code de Voie intraépidermique</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAEPIDERMAL_USE_CODE = "20031500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intraglandular use</div>
	 * <div class="de">Code für intraglanduläre Anwendung</div>
	 * <div class="fr">Code de Voie intraglandulaire</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAGLANDULAR_USE_CODE = "20031700";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intralesional use</div>
	 * <div class="de">Code für intraläsionale Anwendung</div>
	 * <div class="fr">Code de Voie intralésionnelle</div>
	 * <div class="it">Code per Uso intralesionale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRALESIONAL_USE_CODE = "20032000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intralymphatic use</div>
	 * <div class="de">Code für intralymphatische Anwendung</div>
	 * <div class="fr">Code de Voie intralymphatique</div>
	 * <div class="it">Code per Uso intralinfatico</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRALYMPHATIC_USE_CODE = "20033000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intramuscular use</div>
	 * <div class="de">Code für intramuskuläre Anwendung</div>
	 * <div class="fr">Code de Voie intramusculaire</div>
	 * <div class="it">Code per Uso intramuscolare</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAMUSCULAR_USE_CODE = "20035000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intraocular use</div>
	 * <div class="de">Code für intraokulare Anwendung</div>
	 * <div class="fr">Code de Voie intraoculaire</div>
	 * <div class="it">Code per Uso intraoculare</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAOCULAR_USE_CODE = "20036000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intraosseous use</div>
	 * <div class="de">Code für intraossäre Anwendung</div>
	 * <div class="fr">Code de Voie intraosseuse</div>
	 * <div class="it">Code per Uso intraosseo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAOSSEOUS_USE_CODE = "20036500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intrapericardial use</div>
	 * <div class="de">Code für Intraperikardial</div>
	 * <div class="fr">Code de Voie intrapéricardiaque</div>
	 * <div class="it">Code per Uso intrapericardico</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAPERICARDIAL_USE_CODE = "20037000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intraperitoneal use</div>
	 * <div class="de">Code für intraperitoneale Anwendung</div>
	 * <div class="fr">Code de Voie intrapéritonéale</div>
	 * <div class="it">Code per Uso intraperitoneale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAPERITONEAL_USE_CODE = "20038000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intrapleural use</div>
	 * <div class="de">Code für intrapleurale Anwendung</div>
	 * <div class="fr">Code de Voie intrapleurale</div>
	 * <div class="it">Code per Uso intrapleurico</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAPLEURAL_USE_CODE = "20039000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intraportal use</div>
	 * <div class="de">Code für intraportale Anwendung</div>
	 * <div class="fr">Code de Voie intraportale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAPORTAL_USE_CODE = "20039200";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intraprostatic use</div>
	 * <div class="de">Code für intraprostatische Anwendung</div>
	 * <div class="fr">Code de Voie intraprostatique</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAPROSTATIC_USE_CODE = "20039500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intrasternal use</div>
	 * <div class="de">Code für intrasternale Anwendung</div>
	 * <div class="fr">Code de Voie intrasternale</div>
	 * <div class="it">Code per Uso intrasternale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRASTERNAL_USE_CODE = "20041000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intrathecal use</div>
	 * <div class="de">Code für intrathekale Anwendung</div>
	 * <div class="fr">Code de Voie intrathécale</div>
	 * <div class="it">Code per Uso intratecale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRATHECAL_USE_CODE = "20042000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intratumoral use</div>
	 * <div class="de">Code für intratumorale Anwendung</div>
	 * <div class="fr">Code de Voie intratumorale</div>
	 * <div class="it">Code per Uso intratumorale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRATUMORAL_USE_CODE = "20043000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intrauterine use</div>
	 * <div class="de">Code für intrauterine Anwendung</div>
	 * <div class="fr">Code de Voie intra-utérine</div>
	 * <div class="it">Code per Uso intrauterino</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAUTERINE_USE_CODE = "20044000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intravenous use</div>
	 * <div class="de">Code für intravenöse Anwendung</div>
	 * <div class="fr">Code de Voie intraveineuse</div>
	 * <div class="it">Code per Uso endovenoso</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAVENOUS_USE_CODE = "20045000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intravesical use</div>
	 * <div class="de">Code für intravesikale Anwendung</div>
	 * <div class="fr">Code de Voie intravésicale</div>
	 * <div class="it">Code per Uso endovescicale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAVESICAL_USE_CODE = "20046000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intravitreal use</div>
	 * <div class="de">Code für Intravitreal</div>
	 * <div class="fr">Code de Voie intravitréenne</div>
	 * <div class="it">Code per Uso intravitreo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAVITREAL_USE_CODE = "20047000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Iontophoresis</div>
	 * <div class="de">Code für zur Iontophorese</div>
	 * <div class="fr">Code de Iontophorèse</div>
	 * <div class="it">Code per 0</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IONTOPHORESIS_CODE = "20047500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Laryngopharyngeal use</div>
	 * <div class="de">Code für zur Anwendung im Rachen und am Kehlkopf</div>
	 * <div class="fr">Code de Voie laryngopharyngée</div>
	 * <div class="it">Code per Uso laringofaringeo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LARYNGOPHARYNGEAL_USE_CODE = "20048000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nasal use</div>
	 * <div class="de">Code für nasale Anwendung</div>
	 * <div class="fr">Code de Voie nasale</div>
	 * <div class="it">Code per Uso nasale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NASAL_USE_CODE = "20049000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ocular use</div>
	 * <div class="de">Code für Anwendung am Auge</div>
	 * <div class="fr">Code de Voie ophtalmique</div>
	 * <div class="it">Code per Uso oftalmico</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OCULAR_USE_CODE = "20051000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oral use</div>
	 * <div class="de">Code für zum Einnehmen</div>
	 * <div class="fr">Code de Voie orale</div>
	 * <div class="it">Code per Uso orale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORAL_USE_CODE = "20053000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oromucosal use</div>
	 * <div class="de">Code für Anwendung in der Mundhöhle</div>
	 * <div class="fr">Code de Voie buccale</div>
	 * <div class="it">Code per Per mucosa orale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OROMUCOSAL_USE_CODE = "20054000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oropharyngeal use</div>
	 * <div class="de">Code für zur Anwendung im Mund- und Rachenraum</div>
	 * <div class="fr">Code de Voie oropharyngée</div>
	 * <div class="it">Code per Uso orofaringeo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OROPHARYNGEAL_USE_CODE = "20055000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Periarticular use</div>
	 * <div class="de">Code für periartikuläre Anwendung</div>
	 * <div class="fr">Code de Voie périarticulaire</div>
	 * <div class="it">Code per Uso periarticolare</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PERIARTICULAR_USE_CODE = "20057000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Perineural use</div>
	 * <div class="de">Code für perineurale Anwendung</div>
	 * <div class="fr">Code de Voie périneurale</div>
	 * <div class="it">Code per Uso perineurale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PERINEURAL_USE_CODE = "20058000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Periodontal use</div>
	 * <div class="de">Code für zur periodontalen Anwendung</div>
	 * <div class="fr">Code de Voie périodontale</div>
	 * <div class="it">Code per Uso periodontale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PERIODONTAL_USE_CODE = "20059000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Periosseous use</div>
	 * <div class="de">Code für periossäre Anwendung</div>
	 * <div class="fr">Code de Voie périosseuse</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PERIOSSEOUS_USE_CODE = "20059300";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Peritumoral use</div>
	 * <div class="de">Code für peritumorale Anwendung</div>
	 * <div class="fr">Code de Voie péritumorale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PERITUMORAL_USE_CODE = "20059400";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Posterior juxtascleral use</div>
	 * <div class="de">Code für posteriore juxtasclerale Anwendung</div>
	 * <div class="fr">Code de Voie juxta-sclérale postérieure</div>
	 * <div class="it">Code per Uso iuxtasclerale posteriore</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POSTERIOR_JUXTASCLERAL_USE_CODE = "20059500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Rectal use</div>
	 * <div class="de">Code für rektale Anwendung</div>
	 * <div class="fr">Code de Voie rectale</div>
	 * <div class="it">Code per Uso rettale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RECTAL_USE_CODE = "20061000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Retrobulbar use</div>
	 * <div class="de">Code für retrobulbäre Anwendung</div>
	 * <div class="fr">Code de Voie rétrobulbaire</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RETROBULBAR_USE_CODE = "20061500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Route of administration not applicable</div>
	 * <div class="de">Code für Art der Anwendung nicht spezifizierbar</div>
	 * <div class="fr">Code de Autre(s)</div>
	 * <div class="it">Code per Via di somministrazione non specificabile</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ROUTE_OF_ADMINISTRATION_NOT_APPLICABLE_CODE = "20062000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Skin scarification</div>
	 * <div class="de">Code für Einritzen der Haut</div>
	 * <div class="fr">Code de Scarification</div>
	 * <div class="it">Code per Scarificazione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SKIN_SCARIFICATION_CODE = "20063000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Subconjunctival use</div>
	 * <div class="de">Code für subkonjunktivale Anwendung</div>
	 * <div class="fr">Code de Voie sous-conjonctivale</div>
	 * <div class="it">Code per Uso subcongiuntivale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUBCONJUNCTIVAL_USE_CODE = "20065000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Subcutaneous use</div>
	 * <div class="de">Code für subkutane Anwendung</div>
	 * <div class="fr">Code de Voie sous-cutanée</div>
	 * <div class="it">Code per Uso sottocutaneo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUBCUTANEOUS_USE_CODE = "20066000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Sublingual use</div>
	 * <div class="de">Code für Sublingual</div>
	 * <div class="fr">Code de Voie sublinguale</div>
	 * <div class="it">Code per Uso sublinguale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUBLINGUAL_USE_CODE = "20067000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Submucosal use</div>
	 * <div class="de">Code für submuköse Anwendung</div>
	 * <div class="fr">Code de Voie sous-muqueuse</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUBMUCOSAL_USE_CODE = "20067500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Subretinal use</div>
	 * <div class="de">Code für subretinale Anwendung</div>
	 * <div class="fr">Code de Voie subrétinale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUBRETINAL_USE_CODE = "20081000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Transdermal use</div>
	 * <div class="de">Code für transdermale Anwendung</div>
	 * <div class="fr">Code de Voie transdermique</div>
	 * <div class="it">Code per Uso transdermico</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TRANSDERMAL_USE_CODE = "20070000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Urethral use</div>
	 * <div class="de">Code für Anwendung in der Harnröhre</div>
	 * <div class="fr">Code de Voie urétrale</div>
	 * <div class="it">Code per Uso uretrale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String URETHRAL_USE_CODE = "20071000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Vaginal use</div>
	 * <div class="de">Code für vaginale Anwendung</div>
	 * <div class="fr">Code de Voie vaginale</div>
	 * <div class="it">Code per Uso vaginale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VAGINAL_USE_CODE = "20072000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.1.11.2";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "RouteOfAdministrationEDQM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 * <!-- @formatter:on -->
	 *
	 * @param code
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static RouteOfAdministrationEdqm getEnum(final String code) {
		for (final RouteOfAdministrationEdqm x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der angegebene enum Teil dieses Value Sets ist.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param enumName
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(final String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(RouteOfAdministrationEdqm.class, enumName);
			return true;
		} catch (final IllegalArgumentException ex) {
			return false;
		}
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der angegebene code in diesem Value Set vorhanden ist.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param codeValue
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(final String codeValue) {
		for (final RouteOfAdministrationEdqm x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Machine interpretable and (inside this class) unique code</div>
	 * <div class="de">Maschinen interpretierbarer und (innerhalb dieser Klasse) eindeutiger Code</div>
	 * <!-- @formatter:on -->
	 */
	private String code;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the referencing code system.</div>
	 * <div class="de">Identifikator des referenzierende Codesystems.</div>
	 * <!-- @formatter:on -->
	 */
	private String codeSystem;

	/**
	 * The display names per language
	 */
	private Map<LanguageCode, String> displayNames;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instantiates this Enum Object with a given Code and Display Name</div>
	 * <div class="de">Instanziiert dieses Enum Object mittels eines Codes und einem Display Name</div>.
	 * <!-- @formatter:on -->
	 *
	 * @param code
	 *            code
	 * @param codeSystem
	 *            codeSystem
	 * @param displayName
	 *            the default display name
	 * @param displayNameEn
	 *            the display name en
	 * @param displayNameDe
	 *            the display name de
	 * @param displayNameFr
	 *            the display name fr
	 * @param displayNameIt
	 *            the display name it
	 */
	RouteOfAdministrationEdqm(final String code, final String codeSystem, final String displayName,
			final String displayNameEn, final String displayNameDe, final String displayNameFr,
			final String displayNameIt) {
		this.code = code;
		this.codeSystem = codeSystem;
		this.displayNames = new HashMap<>();
		this.displayNames.put(null, displayName);
		this.displayNames.put(LanguageCode.ENGLISH, displayNameEn);
		this.displayNames.put(LanguageCode.GERMAN, displayNameDe);
		this.displayNames.put(LanguageCode.FRENCH, displayNameFr);
		this.displayNames.put(LanguageCode.ITALIAN, displayNameIt);
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the code system identifier.</div>
	 * <div class="de">Liefert den Code System Identifikator.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the code system identifier</div>
	 */
	@Override
	public String getCodeSystemId() {
		return this.codeSystem;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the code system name.</div>
	 * <div class="de">Liefert den Code System Namen.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the code system identifier</div>
	 */
	@Override
	public String getCodeSystemName() {
		String retVal = "";
		CodeSystems cs = CodeSystems.getEnum(this.codeSystem);
		if (cs != null)
			retVal = cs.getCodeSystemName();
		return retVal;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the code</div>
	 */
	@Override
	public String getCodeValue() {
		return this.code;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the display name defined by the language param. If
	 * there is no english translation, the default display name is returned.</div>
	 * <div class="de">Liefert display name gemäss Parameter, falls es keine
	 * Englische Übersetzung gibt, wird der default-Name zurückgegeben.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param languageCode
	 *            the language code to get the display name for
	 * @return returns the display name in the desired language. if language not
	 *         found, display name in german will returned
	 */
	@Override
	public String getDisplayName(LanguageCode languageCode) {
		String displayName = this.displayNames.get(languageCode);
		if (displayName == null && languageCode == LanguageCode.ENGLISH) {
			return this.displayNames.get(null);
		}
		return displayName;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the value set identifier.</div>
	 * <div class="de">Liefert den Value Set Identifikator.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the value set identifier</div>
	 */
	@Override
	public String getValueSetId() {
		return VALUE_SET_ID;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the value set name.</div>
	 * <div class="de">Liefert den Value Set Namen.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the value set name</div>
	 */
	@Override
	public String getValueSetName() {
		return VALUE_SET_NAME;
	}
}
