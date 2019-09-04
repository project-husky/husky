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
package org.ehealth_connector.cda.ch.emed.v0954.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * <div class="en">Valueset RouteOuPharmaceutical Dose Form from EDQM, PDF, export 24.4.2018, see https://standardterms.edqm.eu/#</div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum PharmaceuticalDoseFormEdqm implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Anticoagulant and preservative solution for blood</div>
	 * <div class="de">Stabilisatorl�sung f�r Blutkonserven</div>
	 * <div class="fr">Solution anticoagulante et de conservation du sang humain</div>
	 * <div class="it">Soluzione anticoagulante e conservante per il sangue</div>
	 * <!-- @formatter:on -->
	 */
	ANTICOAGULANT_AND_PRESERVATIVE_SOLUTION_FOR_BLOOD("12102000", "0.4.0.127.0.16.1.1.2.1", "Anticoagulant and preservative solution for blood", "Anticoagulant and preservative solution for blood", "Stabilisatorl�sung f�r Blutkonserven", "Solution anticoagulante et de conservation du sang humain", "Soluzione anticoagulante e conservante per il sangue"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Bath additive</div>
	 * <div class="de">Badezusatz</div>
	 * <div class="fr">Adjuvant de bain</div>
	 * <div class="it">Additivo per bagno</div>
	 * <!-- @formatter:on -->
	 */
	BATH_ADDITIVE("10501000", "0.4.0.127.0.16.1.1.2.1", "Bath additive", "Bath additive", "Badezusatz", "Adjuvant de bain", "Additivo per bagno"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Bladder irrigation</div>
	 * <div class="de">Blasensp�ll�sung</div>
	 * <div class="fr">Solution pour irrigation v�sicale</div>
	 * <div class="it">Irrigazione vescicale</div>
	 * <!-- @formatter:on -->
	 */
	BLADDER_IRRIGATION("11502000", "0.4.0.127.0.16.1.1.2.1", "Bladder irrigation", "Bladder irrigation", "Blasensp�ll�sung", "Solution pour irrigation v�sicale", "Irrigazione vescicale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Buccal film</div>
	 * <div class="de">Buccalfilm</div>
	 * <div class="fr">Film buccogingival</div>
	 * <!-- @formatter:on -->
	 */
	BUCCAL_FILM("10314011", "0.4.0.127.0.16.1.1.2.1", "Buccal film", "Buccal film", "Buccalfilm", "Film buccogingival", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Buccal tablet</div>
	 * <div class="de">Buccaltablette</div>
	 * <div class="fr">Comprim� buccogingival</div>
	 * <div class="it">Compressa orosolubile</div>
	 * <!-- @formatter:on -->
	 */
	BUCCAL_TABLET("10320000", "0.4.0.127.0.16.1.1.2.1", "Buccal tablet", "Buccal tablet", "Buccaltablette", "Comprim� buccogingival", "Compressa orosolubile"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cachet</div>
	 * <div class="de">Oblatenkapsel</div>
	 * <div class="fr">Cachet</div>
	 * <div class="it">Cachet</div>
	 * <!-- @formatter:on -->
	 */
	CACHET("10209000", "0.4.0.127.0.16.1.1.2.1", "Cachet", "Cachet", "Oblatenkapsel", "Cachet", "Cachet"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Capsule, hard</div>
	 * <div class="de">Hartkapsel</div>
	 * <div class="fr">G�lule</div>
	 * <div class="it">Capsula rigida</div>
	 * <!-- @formatter:on -->
	 */
	CAPSULE_HARD("10210000", "0.4.0.127.0.16.1.1.2.1", "Capsule, hard", "Capsule, hard", "Hartkapsel", "G�lule", "Capsula rigida"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Capsule, soft</div>
	 * <div class="de">Weichkapsel</div>
	 * <div class="fr">Capsule molle</div>
	 * <div class="it">Capsula molle</div>
	 * <!-- @formatter:on -->
	 */
	CAPSULE_SOFT("10211000", "0.4.0.127.0.16.1.1.2.1", "Capsule, soft", "Capsule, soft", "Weichkapsel", "Capsule molle", "Capsula molle"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Chewable capsule, soft</div>
	 * <div class="de">Weichkapsel zum Zerbei�en</div>
	 * <div class="fr">Capsule molle � m�cher</div>
	 * <div class="it">Capsula molle masticabile</div>
	 * <!-- @formatter:on -->
	 */
	CHEWABLE_CAPSULE_SOFT("10214000", "0.4.0.127.0.16.1.1.2.1", "Chewable capsule, soft", "Chewable capsule, soft", "Weichkapsel zum Zerbei�en", "Capsule molle � m�cher", "Capsula molle masticabile"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Chewable/dispersible tablet</div>
	 * <div class="de">Kautablette/Tablette zur Herstellung einer Suspension zum Einnehmen</div>
	 * <div class="fr">Comprim� dispersible / � croquer</div>
	 * <!-- @formatter:on -->
	 */
	CHEWABLE_DISPERSIBLE_TABLET("50001000", "0.4.0.127.0.16.1.1.2.1", "Chewable/dispersible tablet", "Chewable/dispersible tablet", "Kautablette/Tablette zur Herstellung einer Suspension zum Einnehmen", "Comprim� dispersible / � croquer", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Chewable tablet</div>
	 * <div class="de">Kautablette</div>
	 * <div class="fr">Comprim� � croquer</div>
	 * <div class="it">Compressa masticabile</div>
	 * <!-- @formatter:on -->
	 */
	CHEWABLE_TABLET("10228000", "0.4.0.127.0.16.1.1.2.1", "Chewable tablet", "Chewable tablet", "Kautablette", "Comprim� � croquer", "Compressa masticabile"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Coated granules</div>
	 * <div class="de">�berzogenes Granulat</div>
	 * <div class="fr">Granul�s enrob�s</div>
	 * <!-- @formatter:on -->
	 */
	COATED_GRANULES("13046000", "0.4.0.127.0.16.1.1.2.1", "Coated granules", "Coated granules", "�berzogenes Granulat", "Granul�s enrob�s", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Coated tablet</div>
	 * <div class="de">�berzogene Tablette</div>
	 * <div class="fr">Comprim� enrob�</div>
	 * <div class="it">Compressa rivestita</div>
	 * <!-- @formatter:on -->
	 */
	COATED_TABLET("10220000", "0.4.0.127.0.16.1.1.2.1", "Coated tablet", "Coated tablet", "�berzogene Tablette", "Comprim� enrob�", "Compressa rivestita"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Collodion</div>
	 * <div class="de">filmbildende Fl�ssigkeit</div>
	 * <div class="fr">Collodion</div>
	 * <div class="it">Collodio</div>
	 * <!-- @formatter:on -->
	 */
	COLLODION("10520000", "0.4.0.127.0.16.1.1.2.1", "Collodion", "Collodion", "filmbildende Fl�ssigkeit", "Collodion", "Collodio"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Compressed lozenge</div>
	 * <div class="de">Lutschtablette, gepresst</div>
	 * <div class="fr">Comprim� � sucer</div>
	 * <div class="it">Pastiglia</div>
	 * <!-- @formatter:on -->
	 */
	COMPRESSED_LOZENGE("10322000", "0.4.0.127.0.16.1.1.2.1", "Compressed lozenge", "Compressed lozenge", "Lutschtablette, gepresst", "Comprim� � sucer", "Pastiglia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Concentrate for concentrate for solution for infusion</div>
	 * <div class="de">Konzentrat f�r ein Konzentrat zur Herstellung einer Infusionsl�sung</div>
	 * <div class="fr">0</div>
	 * <!-- @formatter:on -->
	 */
	CONCENTRATE_FOR_CONCENTRATE_FOR_SOLUTION_FOR_INFUSION("13001000", "0.4.0.127.0.16.1.1.2.1", "Concentrate for concentrate for solution for infusion", "Concentrate for concentrate for solution for infusion", "Konzentrat f�r ein Konzentrat zur Herstellung einer Infusionsl�sung", "0", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Concentrate for cutaneous solution</div>
	 * <div class="de">Konzentrat zur Herstellung einer L�sung zur Anwendung auf der Haut</div>
	 * <div class="fr">Solution � diluer pour solution cutan�e</div>
	 * <div class="it">Concentrato per soluzione cutanea</div>
	 * <!-- @formatter:on -->
	 */
	CONCENTRATE_FOR_CUTANEOUS_SOLUTION("10514000", "0.4.0.127.0.16.1.1.2.1", "Concentrate for cutaneous solution", "Concentrate for cutaneous solution", "Konzentrat zur Herstellung einer L�sung zur Anwendung auf der Haut", "Solution � diluer pour solution cutan�e", "Concentrato per soluzione cutanea"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Concentrate for cutaneous spray, emulsion</div>
	 * <div class="de">Konzentrat zur Herstellung eines Sprays zur Anwendung auf der Haut, Emulsion</div>
	 * <div class="fr">Solution � diluer pour �mulsion pour pulv�risation cutan�e</div>
	 * <!-- @formatter:on -->
	 */
	CONCENTRATE_FOR_CUTANEOUS_SPRAY_EMULSION("50009000", "0.4.0.127.0.16.1.1.2.1", "Concentrate for cutaneous spray, emulsion", "Concentrate for cutaneous spray, emulsion", "Konzentrat zur Herstellung eines Sprays zur Anwendung auf der Haut, Emulsion", "Solution � diluer pour �mulsion pour pulv�risation cutan�e", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Concentrate for dispersion for infusion</div>
	 * <div class="de">Konzentrat zur Herstellung einer Infusionsdispersion</div>
	 * <div class="fr">0</div>
	 * <!-- @formatter:on -->
	 */
	CONCENTRATE_FOR_DISPERSION_FOR_INFUSION("50009300", "0.4.0.127.0.16.1.1.2.1", "Concentrate for dispersion for infusion", "Concentrate for dispersion for infusion", "Konzentrat zur Herstellung einer Infusionsdispersion", "0", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Concentrate for emulsion for infusion</div>
	 * <div class="de">Konzentrat zur Herstellung einer Emulsion zur Infusion</div>
	 * <div class="fr">Solution � diluer pour perfusion d�une �mulsion</div>
	 * <!-- @formatter:on -->
	 */
	CONCENTRATE_FOR_EMULSION_FOR_INFUSION("50009500", "0.4.0.127.0.16.1.1.2.1", "Concentrate for emulsion for infusion", "Concentrate for emulsion for infusion", "Konzentrat zur Herstellung einer Emulsion zur Infusion", "Solution � diluer pour perfusion d�une �mulsion", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Concentrate for gargle</div>
	 * <div class="de">Konzentrat zur Herstellung einer Gurgell�sung</div>
	 * <div class="fr">Solution � diluer pour gargarisme</div>
	 * <div class="it">Concentrato per soluzione per gargarismi</div>
	 * <!-- @formatter:on -->
	 */
	CONCENTRATE_FOR_GARGLE("10302000", "0.4.0.127.0.16.1.1.2.1", "Concentrate for gargle", "Concentrate for gargle", "Konzentrat zur Herstellung einer Gurgell�sung", "Solution � diluer pour gargarisme", "Concentrato per soluzione per gargarismi"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Concentrate for intravesical solution</div>
	 * <div class="de">Konzentrat zur Herstellung einer L�sung zur intravesikalen Anwendung</div>
	 * <div class="fr">Solution � diluer pour solution intrav�sicale</div>
	 * <!-- @formatter:on -->
	 */
	CONCENTRATE_FOR_INTRAVESICAL_SOLUTION("50009750", "0.4.0.127.0.16.1.1.2.1", "Concentrate for intravesical solution", "Concentrate for intravesical solution", "Konzentrat zur Herstellung einer L�sung zur intravesikalen Anwendung", "Solution � diluer pour solution intrav�sicale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Concentrate for nebuliser solution</div>
	 * <div class="de">Konzentrat zur Herstellung einer L�sung f�r einen Vernebler</div>
	 * <div class="fr">Solution � diluer pour inhalation par n�buliseur</div>
	 * <!-- @formatter:on -->
	 */
	CONCENTRATE_FOR_NEBULISER_SOLUTION("13002000", "0.4.0.127.0.16.1.1.2.1", "Concentrate for nebuliser solution", "Concentrate for nebuliser solution", "Konzentrat zur Herstellung einer L�sung f�r einen Vernebler", "Solution � diluer pour inhalation par n�buliseur", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Concentrate for oral/rectal solution</div>
	 * <div class="de">Konzentrat zur Herstellung einer L�sung zum Einnehmen /Rektall�sung</div>
	 * <div class="fr">Solution � diluer pour solution orale/rectale</div>
	 * <!-- @formatter:on -->
	 */
	CONCENTRATE_FOR_ORAL_RECTAL_SOLUTION("50011000", "0.4.0.127.0.16.1.1.2.1", "Concentrate for oral/rectal solution", "Concentrate for oral/rectal solution", "Konzentrat zur Herstellung einer L�sung zum Einnehmen /Rektall�sung", "Solution � diluer pour solution orale/rectale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Concentrate for oral solution</div>
	 * <div class="de">Konzentrat zur Herstellung einer L�sung  zum Einnehmen</div>
	 * <div class="fr">Solution � diluer pour solution buvable</div>
	 * <!-- @formatter:on -->
	 */
	CONCENTRATE_FOR_ORAL_SOLUTION("50010000", "0.4.0.127.0.16.1.1.2.1", "Concentrate for oral solution", "Concentrate for oral solution", "Konzentrat zur Herstellung einer L�sung  zum Einnehmen", "Solution � diluer pour solution buvable", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Concentrate for oral suspension</div>
	 * <div class="de">Konzentrat zur Herstellung einer Suspension zum Einnehmen</div>
	 * <div class="fr">Suspension � diluer pour suspension buvable</div>
	 * <!-- @formatter:on -->
	 */
	CONCENTRATE_FOR_ORAL_SUSPENSION("10100500", "0.4.0.127.0.16.1.1.2.1", "Concentrate for oral suspension", "Concentrate for oral suspension", "Konzentrat zur Herstellung einer Suspension zum Einnehmen", "Suspension � diluer pour suspension buvable", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Concentrate for oromucosal solution</div>
	 * <div class="de">Konzentrat zur Herstellung einer L�sung zur Anwendung in der Mundh�hle</div>
	 * <div class="fr">Solution � diluer buccale</div>
	 * <!-- @formatter:on -->
	 */
	CONCENTRATE_FOR_OROMUCOSAL_SOLUTION("13003000", "0.4.0.127.0.16.1.1.2.1", "Concentrate for oromucosal solution", "Concentrate for oromucosal solution", "Konzentrat zur Herstellung einer L�sung zur Anwendung in der Mundh�hle", "Solution � diluer buccale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Concentrate for rectal solution</div>
	 * <div class="de">Konzentrat zur Herstellung einer Rektall�sung</div>
	 * <div class="fr">Solution rectale � diluer</div>
	 * <div class="it">Concentrato per soluzione rettale</div>
	 * <!-- @formatter:on -->
	 */
	CONCENTRATE_FOR_RECTAL_SOLUTION("11008000", "0.4.0.127.0.16.1.1.2.1", "Concentrate for rectal solution", "Concentrate for rectal solution", "Konzentrat zur Herstellung einer Rektall�sung", "Solution rectale � diluer", "Concentrato per soluzione rettale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Concentrate for solution for haemodialysis</div>
	 * <div class="de">Konzentrat zur Herstellung einer H�modialysel�sung</div>
	 * <div class="fr">Solution � diluer pour h�modialyse</div>
	 * <div class="it">Soluzione concentrata per emodialisi</div>
	 * <!-- @formatter:on -->
	 */
	CONCENTRATE_FOR_SOLUTION_FOR_HAEMODIALYSIS("11405000", "0.4.0.127.0.16.1.1.2.1", "Concentrate for solution for haemodialysis", "Concentrate for solution for haemodialysis", "Konzentrat zur Herstellung einer H�modialysel�sung", "Solution � diluer pour h�modialyse", "Soluzione concentrata per emodialisi"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Concentrate for solution for infusion</div>
	 * <div class="de">Konzentrat zur Herstellung einer Infusionsl�sung</div>
	 * <div class="fr">Solution � diluer pour perfusion</div>
	 * <div class="it">Concentrato per soluzione per infusione</div>
	 * <!-- @formatter:on -->
	 */
	CONCENTRATE_FOR_SOLUTION_FOR_INFUSION("11213000", "0.4.0.127.0.16.1.1.2.1", "Concentrate for solution for infusion", "Concentrate for solution for infusion", "Konzentrat zur Herstellung einer Infusionsl�sung", "Solution � diluer pour perfusion", "Concentrato per soluzione per infusione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Concentrate for solution for injection</div>
	 * <div class="de">Konzentrat zur Herstellung einer Injektionsl�sung</div>
	 * <div class="fr">Solution � diluer injectable</div>
	 * <div class="it">Concentrato per soluzione iniettabile</div>
	 * <!-- @formatter:on -->
	 */
	CONCENTRATE_FOR_SOLUTION_FOR_INJECTION("11209000", "0.4.0.127.0.16.1.1.2.1", "Concentrate for solution for injection", "Concentrate for solution for injection", "Konzentrat zur Herstellung einer Injektionsl�sung", "Solution � diluer injectable", "Concentrato per soluzione iniettabile"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Concentrate for solution for injection/infusion</div>
	 * <div class="de">Konzentrat zur Herstellung einer Injektions- /Infusionsl�sung</div>
	 * <div class="fr">Solution � diluer pour solution injectable/pour perfusion</div>
	 * <div class="it">Concentrato per soluzione iniettabile/ per infusione</div>
	 * <!-- @formatter:on -->
	 */
	CONCENTRATE_FOR_SOLUTION_FOR_INJECTION_INFUSION("50079000", "0.4.0.127.0.16.1.1.2.1", "Concentrate for solution for injection/infusion", "Concentrate for solution for injection/infusion", "Konzentrat zur Herstellung einer Injektions- /Infusionsl�sung", "Solution � diluer pour solution injectable/pour perfusion", "Concentrato per soluzione iniettabile/ per infusione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Concentrate for solution for intraocular irrigation</div>
	 * <div class="de">Konzentrat zur Herstellung einer L�sung zur intraokularen Anwendung</div>
	 * <div class="fr">Solution � diluer pour solution pour irrigation intraoculaire</div>
	 * <!-- @formatter:on -->
	 */
	CONCENTRATE_FOR_SOLUTION_FOR_INTRAOCULAR_IRRIGATION("10600500", "0.4.0.127.0.16.1.1.2.1", "Concentrate for solution for intraocular irrigation", "Concentrate for solution for intraocular irrigation", "Konzentrat zur Herstellung einer L�sung zur intraokularen Anwendung", "Solution � diluer pour solution pour irrigation intraoculaire", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Concentrate for solution for peritoneal dialysis</div>
	 * <div class="de">Konzentrat zur Herstellung einer Peritonealdialysel�sung</div>
	 * <div class="fr">Solution � diluer pour solution pour dialyse p�riton�ale</div>
	 * <!-- @formatter:on -->
	 */
	CONCENTRATE_FOR_SOLUTION_FOR_PERITONEAL_DIALYSIS("50013250", "0.4.0.127.0.16.1.1.2.1", "Concentrate for solution for peritoneal dialysis", "Concentrate for solution for peritoneal dialysis", "Konzentrat zur Herstellung einer Peritonealdialysel�sung", "Solution � diluer pour solution pour dialyse p�riton�ale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Concentrate for suspension for injection</div>
	 * <div class="de">Konzentrat zur Herstellung einer Injektionssuspension</div>
	 * <div class="fr">Suspension � diluer injectable</div>
	 * <!-- @formatter:on -->
	 */
	CONCENTRATE_FOR_SUSPENSION_FOR_INJECTION("13004000", "0.4.0.127.0.16.1.1.2.1", "Concentrate for suspension for injection", "Concentrate for suspension for injection", "Konzentrat zur Herstellung einer Injektionssuspension", "Suspension � diluer injectable", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cream</div>
	 * <div class="de">Creme</div>
	 * <div class="fr">Cr�me</div>
	 * <div class="it">Crema</div>
	 * <!-- @formatter:on -->
	 */
	CREAM("10502000", "0.4.0.127.0.16.1.1.2.1", "Cream", "Cream", "Creme", "Cr�me", "Crema"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cutaneous emulsion</div>
	 * <div class="de">Emulsion zur Anwendung auf der Haut</div>
	 * <div class="fr">Emulsion cutan�e</div>
	 * <div class="it">Emulsione cutanea</div>
	 * <!-- @formatter:on -->
	 */
	CUTANEOUS_EMULSION("10516000", "0.4.0.127.0.16.1.1.2.1", "Cutaneous emulsion", "Cutaneous emulsion", "Emulsion zur Anwendung auf der Haut", "Emulsion cutan�e", "Emulsione cutanea"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cutaneous foam</div>
	 * <div class="de">Schaum zur  Anwendung auf der Haut</div>
	 * <div class="fr">Mousse cutan�e</div>
	 * <div class="it">Schiuma cutanea</div>
	 * <!-- @formatter:on -->
	 */
	CUTANEOUS_FOAM("10507000", "0.4.0.127.0.16.1.1.2.1", "Cutaneous foam", "Cutaneous foam", "Schaum zur  Anwendung auf der Haut", "Mousse cutan�e", "Schiuma cutanea"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cutaneous liquid</div>
	 * <div class="de">Fl�ssigkeit zur Anwendung auf der Haut</div>
	 * <div class="fr">Liquide cutan�</div>
	 * <div class="it">Liquido cutaneo</div>
	 * <!-- @formatter:on -->
	 */
	CUTANEOUS_LIQUID("10512000", "0.4.0.127.0.16.1.1.2.1", "Cutaneous liquid", "Cutaneous liquid", "Fl�ssigkeit zur Anwendung auf der Haut", "Liquide cutan�", "Liquido cutaneo"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cutaneous/nasal ointment</div>
	 * <div class="de">Salbe zur Anwendung auf der Haut/Nasensalbe</div>
	 * <div class="fr">Pommade cutan�e/ nasale</div>
	 * <!-- @formatter:on -->
	 */
	CUTANEOUS_NASAL_OINTMENT("50015200", "0.4.0.127.0.16.1.1.2.1", "Cutaneous/nasal ointment", "Cutaneous/nasal ointment", "Salbe zur Anwendung auf der Haut/Nasensalbe", "Pommade cutan�e/ nasale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cutaneous paste</div>
	 * <div class="de">Paste zur Anwendung auf der Haut</div>
	 * <div class="fr">P�te cutan�e</div>
	 * <div class="it">Pasta cutanea</div>
	 * <!-- @formatter:on -->
	 */
	CUTANEOUS_PASTE("10505000", "0.4.0.127.0.16.1.1.2.1", "Cutaneous paste", "Cutaneous paste", "Paste zur Anwendung auf der Haut", "P�te cutan�e", "Pasta cutanea"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cutaneous patch</div>
	 * <div class="de">Kutanes Pflaster</div>
	 * <div class="fr">Dispositif cutan�</div>
	 * <div class="it">Cerotto cutaneo</div>
	 * <!-- @formatter:on -->
	 */
	CUTANEOUS_PATCH("10517500", "0.4.0.127.0.16.1.1.2.1", "Cutaneous patch", "Cutaneous patch", "Kutanes Pflaster", "Dispositif cutan�", "Cerotto cutaneo"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cutaneous powder</div>
	 * <div class="de">Pulver zur Anwendung auf der Haut</div>
	 * <div class="fr">Poudre pour application cutan�e</div>
	 * <div class="it">Polvere cutanea</div>
	 * <!-- @formatter:on -->
	 */
	CUTANEOUS_POWDER("10517000", "0.4.0.127.0.16.1.1.2.1", "Cutaneous powder", "Cutaneous powder", "Pulver zur Anwendung auf der Haut", "Poudre pour application cutan�e", "Polvere cutanea"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cutaneous solution</div>
	 * <div class="de">L�sung zur Anwendung auf der Haut</div>
	 * <div class="fr">Solution pour application cutan�e</div>
	 * <div class="it">Soluzione cutanea</div>
	 * <!-- @formatter:on -->
	 */
	CUTANEOUS_SOLUTION("10513000", "0.4.0.127.0.16.1.1.2.1", "Cutaneous solution", "Cutaneous solution", "L�sung zur Anwendung auf der Haut", "Solution pour application cutan�e", "Soluzione cutanea"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cutaneous solution/concentrate for oromucosal solution</div>
	 * <div class="de">L�sung zur Anwendung auf der Haut/Konzentrat zur Herstellung einer L�sung zur Anwendung in der Mundh�hle</div>
	 * <div class="fr">Solution cutan�e/ solution � diluer buccale</div>
	 * <!-- @formatter:on -->
	 */
	CUTANEOUS_SOLUTION_CONCENTRATE_FOR_OROMUCOSAL_SOLUTION("50015450", "0.4.0.127.0.16.1.1.2.1", "Cutaneous solution/concentrate for oromucosal solution", "Cutaneous solution/concentrate for oromucosal solution", "L�sung zur Anwendung auf der Haut/Konzentrat zur Herstellung einer L�sung zur Anwendung in der Mundh�hle", "Solution cutan�e/ solution � diluer buccale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cutaneous spray, emulsion</div>
	 * <div class="de">Spray zur Anwendung auf der Haut, Emulsion</div>
	 * <div class="fr">�mulsion pour pulv�risation cutan�e</div>
	 * <!-- @formatter:on -->
	 */
	CUTANEOUS_SPRAY_EMULSION("50015500", "0.4.0.127.0.16.1.1.2.1", "Cutaneous spray, emulsion", "Cutaneous spray, emulsion", "Spray zur Anwendung auf der Haut, Emulsion", "�mulsion pour pulv�risation cutan�e", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cutaneous spray, ointment</div>
	 * <div class="de">Spray zur Anwendung auf der Haut, Salbe</div>
	 * <div class="fr">Pommade pour pulv�risation cutan�e</div>
	 * <!-- @formatter:on -->
	 */
	CUTANEOUS_SPRAY_OINTMENT("50016000", "0.4.0.127.0.16.1.1.2.1", "Cutaneous spray, ointment", "Cutaneous spray, ointment", "Spray zur Anwendung auf der Haut, Salbe", "Pommade pour pulv�risation cutan�e", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cutaneous spray, powder</div>
	 * <div class="de">Pulver-Spray zur Anwendung auf der Haut</div>
	 * <div class="fr">Poudre pour pulv�risation cutan�e</div>
	 * <div class="it">Spray cutaneo, polvere</div>
	 * <!-- @formatter:on -->
	 */
	CUTANEOUS_SPRAY_POWDER("10511000", "0.4.0.127.0.16.1.1.2.1", "Cutaneous spray, powder", "Cutaneous spray, powder", "Pulver-Spray zur Anwendung auf der Haut", "Poudre pour pulv�risation cutan�e", "Spray cutaneo, polvere"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cutaneous spray, solution</div>
	 * <div class="de">Spray zur Anwendung auf der Haut, L�sung</div>
	 * <div class="fr">Solution pour pulv�risation cutan�e</div>
	 * <div class="it">Spray cutaneo, soluzione</div>
	 * <!-- @formatter:on -->
	 */
	CUTANEOUS_SPRAY_SOLUTION("10509000", "0.4.0.127.0.16.1.1.2.1", "Cutaneous spray, solution", "Cutaneous spray, solution", "Spray zur Anwendung auf der Haut, L�sung", "Solution pour pulv�risation cutan�e", "Spray cutaneo, soluzione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cutaneous spray, suspension</div>
	 * <div class="de">Spray zur Anwendung auf der Haut, Suspension</div>
	 * <div class="fr">Suspension pour pulv�risation cutan�e</div>
	 * <div class="it">Spray cutaneo, sospensione</div>
	 * <!-- @formatter:on -->
	 */
	CUTANEOUS_SPRAY_SUSPENSION("10510000", "0.4.0.127.0.16.1.1.2.1", "Cutaneous spray, suspension", "Cutaneous spray, suspension", "Spray zur Anwendung auf der Haut, Suspension", "Suspension pour pulv�risation cutan�e", "Spray cutaneo, sospensione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cutaneous stick</div>
	 * <div class="de">Stift zur Anwendung auf der Haut</div>
	 * <div class="fr">B�ton pour application cutan�e</div>
	 * <div class="it">Matita cutanea</div>
	 * <!-- @formatter:on -->
	 */
	CUTANEOUS_STICK("10523000", "0.4.0.127.0.16.1.1.2.1", "Cutaneous stick", "Cutaneous stick", "Stift zur Anwendung auf der Haut", "B�ton pour application cutan�e", "Matita cutanea"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cutaneous suspension</div>
	 * <div class="de">Suspension zur Anwendung auf der Haut</div>
	 * <div class="fr">Suspension pour application cutan�e</div>
	 * <div class="it">Sospensione cutanea</div>
	 * <!-- @formatter:on -->
	 */
	CUTANEOUS_SUSPENSION("10515000", "0.4.0.127.0.16.1.1.2.1", "Cutaneous suspension", "Cutaneous suspension", "Suspension zur Anwendung auf der Haut", "Suspension pour application cutan�e", "Sospensione cutanea"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dental cement</div>
	 * <div class="de">Dentalzement</div>
	 * <div class="fr">Ciment dentaire</div>
	 * <!-- @formatter:on -->
	 */
	DENTAL_CEMENT("10401500", "0.4.0.127.0.16.1.1.2.1", "Dental cement", "Dental cement", "Dentalzement", "Ciment dentaire", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dental emulsion</div>
	 * <div class="de">Dentalemulsion</div>
	 * <div class="fr">Emulsion dentaire</div>
	 * <div class="it">Emulsione dentale</div>
	 * <!-- @formatter:on -->
	 */
	DENTAL_EMULSION("10408000", "0.4.0.127.0.16.1.1.2.1", "Dental emulsion", "Dental emulsion", "Dentalemulsion", "Emulsion dentaire", "Emulsione dentale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dental gel</div>
	 * <div class="de">Dentalgel</div>
	 * <div class="fr">Gel dentaire</div>
	 * <div class="it">Gel dentale</div>
	 * <!-- @formatter:on -->
	 */
	DENTAL_GEL("10402000", "0.4.0.127.0.16.1.1.2.1", "Dental gel", "Dental gel", "Dentalgel", "Gel dentaire", "Gel dentale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dental paste</div>
	 * <div class="de">Dentalpaste</div>
	 * <div class="fr">P�te dentaire</div>
	 * <!-- @formatter:on -->
	 */
	DENTAL_PASTE("50017000", "0.4.0.127.0.16.1.1.2.1", "Dental paste", "Dental paste", "Dentalpaste", "P�te dentaire", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dental powder</div>
	 * <div class="de">Dentalpulver</div>
	 * <div class="fr">Poudre dentaire</div>
	 * <div class="it">Polvere dentale</div>
	 * <!-- @formatter:on -->
	 */
	DENTAL_POWDER("10405000", "0.4.0.127.0.16.1.1.2.1", "Dental powder", "Dental powder", "Dentalpulver", "Poudre dentaire", "Polvere dentale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dental solution</div>
	 * <div class="de">Dentall�sung</div>
	 * <div class="fr">Solution dentaire</div>
	 * <div class="it">Soluzione dentale</div>
	 * <!-- @formatter:on -->
	 */
	DENTAL_SOLUTION("10406000", "0.4.0.127.0.16.1.1.2.1", "Dental solution", "Dental solution", "Dentall�sung", "Solution dentaire", "Soluzione dentale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dental stick</div>
	 * <div class="de">Dentalstift</div>
	 * <div class="fr">B�ton dentaire</div>
	 * <div class="it">Bastoncino dentale</div>
	 * <!-- @formatter:on -->
	 */
	DENTAL_STICK("10403000", "0.4.0.127.0.16.1.1.2.1", "Dental stick", "Dental stick", "Dentalstift", "B�ton dentaire", "Bastoncino dentale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dental suspension</div>
	 * <div class="de">Dentalsuspension</div>
	 * <div class="fr">Suspension dentaire</div>
	 * <div class="it">Sospensione dentale</div>
	 * <!-- @formatter:on -->
	 */
	DENTAL_SUSPENSION("10407000", "0.4.0.127.0.16.1.1.2.1", "Dental suspension", "Dental suspension", "Dentalsuspension", "Suspension dentaire", "Sospensione dentale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Denture lacquer</div>
	 * <div class="de">Lack f�r die Gebisskontaktfl�che</div>
	 * <div class="fr">Laque dentaire</div>
	 * <div class="it">Smalto dentale</div>
	 * <!-- @formatter:on -->
	 */
	DENTURE_LACQUER("12101000", "0.4.0.127.0.16.1.1.2.1", "Denture lacquer", "Denture lacquer", "Lack f�r die Gebisskontaktfl�che", "Laque dentaire", "Smalto dentale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dispersible tablet</div>
	 * <div class="de">Tablette zur Herstellung einer Suspension zum Einnehmen</div>
	 * <div class="fr">Comprim� dispersible</div>
	 * <div class="it">Compressa dispersibile</div>
	 * <!-- @formatter:on -->
	 */
	DISPERSIBLE_TABLET("10121000", "0.4.0.127.0.16.1.1.2.1", "Dispersible tablet", "Dispersible tablet", "Tablette zur Herstellung einer Suspension zum Einnehmen", "Comprim� dispersible", "Compressa dispersibile"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dispersible tablets for dose dispenser</div>
	 * <div class="de">Tablette zur Herstellung einer Suspension zum Einnehmen f�r ein Dosierger�t</div>
	 * <div class="fr">Comprim�s dispersibles pour dispensateur de dose</div>
	 * <!-- @formatter:on -->
	 */
	DISPERSIBLE_TABLETS_FOR_DOSE_DISPENSER("10121500", "0.4.0.127.0.16.1.1.2.1", "Dispersible tablets for dose dispenser", "Dispersible tablets for dose dispenser", "Tablette zur Herstellung einer Suspension zum Einnehmen f�r ein Dosierger�t", "Comprim�s dispersibles pour dispensateur de dose", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dispersion for concentrate for dispersion for infusion</div>
	 * <div class="de">Dispersion f�r ein Konzentrat zur Herstellung einer Infusionsdispersion</div>
	 * <div class="fr">Dispersion pour dispersion � diluer pour perfusion</div>
	 * <!-- @formatter:on -->
	 */
	DISPERSION_FOR_CONCENTRATE_FOR_DISPERSION_FOR_INFUSION("13005000", "0.4.0.127.0.16.1.1.2.1", "Dispersion for concentrate for dispersion for infusion", "Dispersion for concentrate for dispersion for infusion", "Dispersion f�r ein Konzentrat zur Herstellung einer Infusionsdispersion", "Dispersion pour dispersion � diluer pour perfusion", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dispersion for infusion</div>
	 * <div class="de">Infusionsdispersion</div>
	 * <div class="fr">Dispersion pour perfusion</div>
	 * <!-- @formatter:on -->
	 */
	DISPERSION_FOR_INFUSION("50017500", "0.4.0.127.0.16.1.1.2.1", "Dispersion for infusion", "Dispersion for infusion", "Infusionsdispersion", "Dispersion pour perfusion", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dispersion for injection</div>
	 * <div class="de">Dispersion zur Injektion</div>
	 * <div class="fr">Dispersion injectable</div>
	 * <div class="it">Dispersione per preparazione iniettabile</div>
	 * <!-- @formatter:on -->
	 */
	DISPERSION_FOR_INJECTION("50077000", "0.4.0.127.0.16.1.1.2.1", "Dispersion for injection", "Dispersion for injection", "Dispersion zur Injektion", "Dispersion injectable", "Dispersione per preparazione iniettabile"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dispersion for injection/infusion</div>
	 * <div class="de">Dispersion zur Injektion /Infusion</div>
	 * <div class="fr">Dispersion injectable/ pour perfusion</div>
	 * <!-- @formatter:on -->
	 */
	DISPERSION_FOR_INJECTION_INFUSION("13049000", "0.4.0.127.0.16.1.1.2.1", "Dispersion for injection/infusion", "Dispersion for injection/infusion", "Dispersion zur Injektion /Infusion", "Dispersion injectable/ pour perfusion", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ear cream</div>
	 * <div class="de">Ohrencreme</div>
	 * <div class="fr">Cr�me auriculaire</div>
	 * <div class="it">Crema auricolare</div>
	 * <!-- @formatter:on -->
	 */
	EAR_CREAM("10701000", "0.4.0.127.0.16.1.1.2.1", "Ear cream", "Ear cream", "Ohrencreme", "Cr�me auriculaire", "Crema auricolare"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ear drops, emulsion</div>
	 * <div class="de">Ohrentropfen, Emulsion</div>
	 * <div class="fr">Emulsion auriculaire en gouttes</div>
	 * <div class="it">Gocce auricolari, emulsione</div>
	 * <!-- @formatter:on -->
	 */
	EAR_DROPS_EMULSION("10706000", "0.4.0.127.0.16.1.1.2.1", "Ear drops, emulsion", "Ear drops, emulsion", "Ohrentropfen, Emulsion", "Emulsion auriculaire en gouttes", "Gocce auricolari, emulsione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ear drops, powder for suspension</div>
	 * <div class="de">Pulver zur Herstellung einer Ohrentropfensuspension</div>
	 * <div class="fr">Poudre pour suspension auriculaire en gouttes</div>
	 * <!-- @formatter:on -->
	 */
	EAR_DROPS_POWDER_FOR_SUSPENSION("13006000", "0.4.0.127.0.16.1.1.2.1", "Ear drops, powder for suspension", "Ear drops, powder for suspension", "Pulver zur Herstellung einer Ohrentropfensuspension", "Poudre pour suspension auriculaire en gouttes", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ear drops, solution</div>
	 * <div class="de">Ohrentropfen, L�sung</div>
	 * <div class="fr">Solution auriculaire en gouttes</div>
	 * <div class="it">Gocce auricolari, soluzione</div>
	 * <!-- @formatter:on -->
	 */
	EAR_DROPS_SOLUTION("10704000", "0.4.0.127.0.16.1.1.2.1", "Ear drops, solution", "Ear drops, solution", "Ohrentropfen, L�sung", "Solution auriculaire en gouttes", "Gocce auricolari, soluzione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ear drops, suspension</div>
	 * <div class="de">Ohrentropfen, Suspension</div>
	 * <div class="fr">Suspension auriculaire en gouttes</div>
	 * <div class="it">Gocce auricolari, sospensione</div>
	 * <!-- @formatter:on -->
	 */
	EAR_DROPS_SUSPENSION("10705000", "0.4.0.127.0.16.1.1.2.1", "Ear drops, suspension", "Ear drops, suspension", "Ohrentropfen, Suspension", "Suspension auriculaire en gouttes", "Gocce auricolari, sospensione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ear/eye drops, solution</div>
	 * <div class="de">Augen-/Ohrentropfen, L�sung</div>
	 * <!-- @formatter:on -->
	 */
	EAR_EYE_DROPS_SOLUTION("50018000", "0.4.0.127.0.16.1.1.2.1", "Ear/eye drops, solution", "Ear/eye drops, solution", "Augen-/Ohrentropfen, L�sung", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ear/eye drops, suspension</div>
	 * <div class="de">Augen-/Ohrentropfen, Suspension</div>
	 * <!-- @formatter:on -->
	 */
	EAR_EYE_DROPS_SUSPENSION("50018500", "0.4.0.127.0.16.1.1.2.1", "Ear/eye drops, suspension", "Ear/eye drops, suspension", "Augen-/Ohrentropfen, Suspension", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ear/eye/nasal drops, solution</div>
	 * <div class="de">Augen-/Ohren-/Nasentropfen, L�sung</div>
	 * <div class="fr">Solution auriculaire/ ophtalmique/ nasale en gouttes</div>
	 * <!-- @formatter:on -->
	 */
	EAR_EYE_NASAL_DROPS_SOLUTION("50019500", "0.4.0.127.0.16.1.1.2.1", "Ear/eye/nasal drops, solution", "Ear/eye/nasal drops, solution", "Augen-/Ohren-/Nasentropfen, L�sung", "Solution auriculaire/ ophtalmique/ nasale en gouttes", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ear/eye ointment</div>
	 * <div class="de">Augen-/Ohrensalbe</div>
	 * <div class="fr">Pommade auriculaire/ ophtalmique</div>
	 * <!-- @formatter:on -->
	 */
	EAR_EYE_OINTMENT("50019000", "0.4.0.127.0.16.1.1.2.1", "Ear/eye ointment", "Ear/eye ointment", "Augen-/Ohrensalbe", "Pommade auriculaire/ ophtalmique", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ear gel</div>
	 * <div class="de">Ohrengel</div>
	 * <div class="fr">Gel auriculaire</div>
	 * <div class="it">Gel auricolare</div>
	 * <!-- @formatter:on -->
	 */
	EAR_GEL("10702000", "0.4.0.127.0.16.1.1.2.1", "Ear gel", "Ear gel", "Ohrengel", "Gel auriculaire", "Gel auricolare"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ear/nasal drops, suspension</div>
	 * <div class="de">Augen-/Nasentropfen, Suspension</div>
	 * <div class="fr">Suspension auriculaire/nasale en gouttes</div>
	 * <!-- @formatter:on -->
	 */
	EAR_NASAL_DROPS_SUSPENSION("50020200", "0.4.0.127.0.16.1.1.2.1", "Ear/nasal drops, suspension", "Ear/nasal drops, suspension", "Augen-/Nasentropfen, Suspension", "Suspension auriculaire/nasale en gouttes", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ear ointment</div>
	 * <div class="de">Ohrensalbe</div>
	 * <div class="fr">Pommade auriculaire</div>
	 * <div class="it">Unguento auricolare</div>
	 * <!-- @formatter:on -->
	 */
	EAR_OINTMENT("10703000", "0.4.0.127.0.16.1.1.2.1", "Ear ointment", "Ear ointment", "Ohrensalbe", "Pommade auriculaire", "Unguento auricolare"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ear powder</div>
	 * <div class="de">Ohrenpulver</div>
	 * <div class="fr">Poudre auriculaire</div>
	 * <div class="it">Polvere auricolare</div>
	 * <!-- @formatter:on -->
	 */
	EAR_POWDER("10708000", "0.4.0.127.0.16.1.1.2.1", "Ear powder", "Ear powder", "Ohrenpulver", "Poudre auriculaire", "Polvere auricolare"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ear spray, emulsion</div>
	 * <div class="de">Ohrenspray, Emulsion</div>
	 * <div class="fr">Emulsion pour pulv�risation auriculaire</div>
	 * <div class="it">Spray auricolare, emulsione</div>
	 * <!-- @formatter:on -->
	 */
	EAR_SPRAY_EMULSION("10711000", "0.4.0.127.0.16.1.1.2.1", "Ear spray, emulsion", "Ear spray, emulsion", "Ohrenspray, Emulsion", "Emulsion pour pulv�risation auriculaire", "Spray auricolare, emulsione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ear spray, solution</div>
	 * <div class="de">Ohrenspray, L�sung</div>
	 * <div class="fr">Solution pour pulv�risation auriculaire</div>
	 * <div class="it">Spray auricolare, soluzione</div>
	 * <!-- @formatter:on -->
	 */
	EAR_SPRAY_SOLUTION("10709000", "0.4.0.127.0.16.1.1.2.1", "Ear spray, solution", "Ear spray, solution", "Ohrenspray, L�sung", "Solution pour pulv�risation auriculaire", "Spray auricolare, soluzione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ear spray, suspension</div>
	 * <div class="de">Ohrenspray, Suspension</div>
	 * <div class="fr">Suspension pour pulv�risation auriculaire</div>
	 * <div class="it">Spray auricolare, sospensione</div>
	 * <!-- @formatter:on -->
	 */
	EAR_SPRAY_SUSPENSION("10710000", "0.4.0.127.0.16.1.1.2.1", "Ear spray, suspension", "Ear spray, suspension", "Ohrenspray, Suspension", "Suspension pour pulv�risation auriculaire", "Spray auricolare, sospensione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ear stick</div>
	 * <div class="de">Ohrenst�bchen</div>
	 * <div class="fr">B�ton pour usage auriculaire</div>
	 * <div class="it">Bastoncino auricolare</div>
	 * <!-- @formatter:on -->
	 */
	EAR_STICK("10715000", "0.4.0.127.0.16.1.1.2.1", "Ear stick", "Ear stick", "Ohrenst�bchen", "B�ton pour usage auriculaire", "Bastoncino auricolare"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ear tampon</div>
	 * <div class="de">Ohrentampon</div>
	 * <div class="fr">Tampon auriculaire</div>
	 * <div class="it">Tampone auricolare</div>
	 * <!-- @formatter:on -->
	 */
	EAR_TAMPON("10714000", "0.4.0.127.0.16.1.1.2.1", "Ear tampon", "Ear tampon", "Ohrentampon", "Tampon auriculaire", "Tampone auricolare"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ear wash, emulsion</div>
	 * <div class="de">Ohrensp�lung, Emulsion</div>
	 * <div class="fr">Emulsion pour lavage auriculaire</div>
	 * <div class="it">Lavaggio auricolare, emulsione</div>
	 * <!-- @formatter:on -->
	 */
	EAR_WASH_EMULSION("10713000", "0.4.0.127.0.16.1.1.2.1", "Ear wash, emulsion", "Ear wash, emulsion", "Ohrensp�lung, Emulsion", "Emulsion pour lavage auriculaire", "Lavaggio auricolare, emulsione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ear wash, solution</div>
	 * <div class="de">Ohrensp�ll�sung</div>
	 * <div class="fr">Solution pour lavage auriculaire</div>
	 * <div class="it">Lavaggio auricolare, soluzione</div>
	 * <!-- @formatter:on -->
	 */
	EAR_WASH_SOLUTION("10712000", "0.4.0.127.0.16.1.1.2.1", "Ear wash, solution", "Ear wash, solution", "Ohrensp�ll�sung", "Solution pour lavage auriculaire", "Lavaggio auricolare, soluzione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Effervescent granules</div>
	 * <div class="de">Brausegranulat</div>
	 * <div class="fr">Granul�s effervescents</div>
	 * <div class="it">Granulato effervescente</div>
	 * <!-- @formatter:on -->
	 */
	EFFERVESCENT_GRANULES("10205000", "0.4.0.127.0.16.1.1.2.1", "Effervescent granules", "Effervescent granules", "Brausegranulat", "Granul�s effervescents", "Granulato effervescente"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Effervescent granules for oral suspension</div>
	 * <div class="de">Brausegranulat zur Herstellung einer Suspension zum Einnehmen</div>
	 * <div class="fr">Granul�s effervescents pour suspension buvable</div>
	 * <!-- @formatter:on -->
	 */
	EFFERVESCENT_GRANULES_FOR_ORAL_SUSPENSION("13007000", "0.4.0.127.0.16.1.1.2.1", "Effervescent granules for oral suspension", "Effervescent granules for oral suspension", "Brausegranulat zur Herstellung einer Suspension zum Einnehmen", "Granul�s effervescents pour suspension buvable", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Effervescent powder</div>
	 * <div class="de">Brausepulver</div>
	 * <div class="fr">Poudre effervescente</div>
	 * <div class="it">Polvere effervescente</div>
	 * <!-- @formatter:on -->
	 */
	EFFERVESCENT_POWDER("10203000", "0.4.0.127.0.16.1.1.2.1", "Effervescent powder", "Effervescent powder", "Brausepulver", "Poudre effervescente", "Polvere effervescente"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Effervescent tablet</div>
	 * <div class="de">Brausetablette</div>
	 * <div class="fr">Comprim� effervescent</div>
	 * <div class="it">Compressa effervescente</div>
	 * <!-- @formatter:on -->
	 */
	EFFERVESCENT_TABLET("10222000", "0.4.0.127.0.16.1.1.2.1", "Effervescent tablet", "Effervescent tablet", "Brausetablette", "Comprim� effervescent", "Compressa effervescente"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Effervescent vaginal tablet</div>
	 * <div class="de">Schaumovula</div>
	 * <div class="fr">Comprim� vaginal effervescent</div>
	 * <div class="it">Compressa effervescente vaginale</div>
	 * <!-- @formatter:on -->
	 */
	EFFERVESCENT_VAGINAL_TABLET("10913000", "0.4.0.127.0.16.1.1.2.1", "Effervescent vaginal tablet", "Effervescent vaginal tablet", "Schaumovula", "Comprim� vaginal effervescent", "Compressa effervescente vaginale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Emulsion for emulsion for injection</div>
	 * <div class="de">Emulsion zur Herstellung einer Emulsion zur Injektion</div>
	 * <div class="fr">Emulsion pour �mulsion injectable</div>
	 * <!-- @formatter:on -->
	 */
	EMULSION_FOR_EMULSION_FOR_INJECTION("13008000", "0.4.0.127.0.16.1.1.2.1", "Emulsion for emulsion for injection", "Emulsion for emulsion for injection", "Emulsion zur Herstellung einer Emulsion zur Injektion", "Emulsion pour �mulsion injectable", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Emulsion for infusion</div>
	 * <div class="de">Emulsion zur Infusion</div>
	 * <div class="fr">Emulsion pour perfusion</div>
	 * <div class="it">Emulsione per infusione</div>
	 * <!-- @formatter:on -->
	 */
	EMULSION_FOR_INFUSION("11211000", "0.4.0.127.0.16.1.1.2.1", "Emulsion for infusion", "Emulsion for infusion", "Emulsion zur Infusion", "Emulsion pour perfusion", "Emulsione per infusione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Emulsion for injection</div>
	 * <div class="de">Emulsion zur Injektion</div>
	 * <div class="fr">Emulsion injectable</div>
	 * <div class="it">Emuslione iniettabile</div>
	 * <!-- @formatter:on -->
	 */
	EMULSION_FOR_INJECTION("11203000", "0.4.0.127.0.16.1.1.2.1", "Emulsion for injection", "Emulsion for injection", "Emulsion zur Injektion", "Emulsion injectable", "Emuslione iniettabile"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Emulsion for injection/infusion</div>
	 * <div class="de">Emulsion zur Injektion/Infusion</div>
	 * <div class="fr">�mulsion injectable/pour perfusion</div>
	 * <!-- @formatter:on -->
	 */
	EMULSION_FOR_INJECTION_INFUSION("50021000", "0.4.0.127.0.16.1.1.2.1", "Emulsion for injection/infusion", "Emulsion for injection/infusion", "Emulsion zur Injektion/Infusion", "�mulsion injectable/pour perfusion", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Emulsion for suspension for injection</div>
	 * <div class="de">Emulsion zur Herstellung einer Injektionssuspension</div>
	 * <div class="fr">Emulsion pour suspension injectable</div>
	 * <!-- @formatter:on -->
	 */
	EMULSION_FOR_SUSPENSION_FOR_INJECTION("13091000", "0.4.0.127.0.16.1.1.2.1", "Emulsion for suspension for injection", "Emulsion for suspension for injection", "Emulsion zur Herstellung einer Injektionssuspension", "Emulsion pour suspension injectable", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Endocervical gel</div>
	 * <div class="de">Gel zur endozervikalen Anwendung</div>
	 * <div class="fr">Gel endocervical</div>
	 * <div class="it">Gel endocervicale</div>
	 * <!-- @formatter:on -->
	 */
	ENDOCERVICAL_GEL("11701000", "0.4.0.127.0.16.1.1.2.1", "Endocervical gel", "Endocervical gel", "Gel zur endozervikalen Anwendung", "Gel endocervical", "Gel endocervicale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Endosinusial solution</div>
	 * <div class="de">L�sung zur Anwendung in den Nebenh�hlen</div>
	 * <div class="fr">Solution endosinusale</div>
	 * <!-- @formatter:on -->
	 */
	ENDOSINUSIAL_SOLUTION("13041000", "0.4.0.127.0.16.1.1.2.1", "Endosinusial solution", "Endosinusial solution", "L�sung zur Anwendung in den Nebenh�hlen", "Solution endosinusale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Endosinusial wash, suspension</div>
	 * <div class="de">Nebenh�hlensp�lung, Suspension</div>
	 * <div class="fr">Suspension pour lavage endosinusal</div>
	 * <!-- @formatter:on -->
	 */
	ENDOSINUSIAL_WASH_SUSPENSION("50022000", "0.4.0.127.0.16.1.1.2.1", "Endosinusial wash, suspension", "Endosinusial wash, suspension", "Nebenh�hlensp�lung, Suspension", "Suspension pour lavage endosinusal", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Endotracheopulmonary instillation, powder for solution</div>
	 * <div class="de">Pulver zur Herstellung einer L�sung zur endotracheopulmonalen Instillation</div>
	 * <div class="fr">Poudre pour solution pour instillation endotrach�obronchique</div>
	 * <div class="it">Polvere per soluzione per instillazione endotracheobronchiale</div>
	 * <!-- @formatter:on -->
	 */
	ENDOTRACHEOPULMONARY_INSTILLATION_POWDER_FOR_SOLUTION("11602000", "0.4.0.127.0.16.1.1.2.1", "Endotracheopulmonary instillation, powder for solution", "Endotracheopulmonary instillation, powder for solution", "Pulver zur Herstellung einer L�sung zur endotracheopulmonalen Instillation", "Poudre pour solution pour instillation endotrach�obronchique", "Polvere per soluzione per instillazione endotracheobronchiale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Endotracheopulmonary instillation, powder for suspension</div>
	 * <div class="de">Pulver zu Herstellung einer Suspension zur endotracheopulmonalen Instillation</div>
	 * <div class="fr">Poudre pour suspension pour instillation endotrach�obronchique</div>
	 * <!-- @formatter:on -->
	 */
	ENDOTRACHEOPULMONARY_INSTILLATION_POWDER_FOR_SUSPENSION("13009000", "0.4.0.127.0.16.1.1.2.1", "Endotracheopulmonary instillation, powder for suspension", "Endotracheopulmonary instillation, powder for suspension", "Pulver zu Herstellung einer Suspension zur endotracheopulmonalen Instillation", "Poudre pour suspension pour instillation endotrach�obronchique", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Endotracheopulmonary instillation, solution</div>
	 * <div class="de">L�sung zur endotracheopulmonalen Instillation</div>
	 * <div class="fr">Solution pour instillation endotrach�obronchique</div>
	 * <div class="it">Soluzione per instillazione endotracheobronchiale</div>
	 * <!-- @formatter:on -->
	 */
	ENDOTRACHEOPULMONARY_INSTILLATION_SOLUTION("11601000", "0.4.0.127.0.16.1.1.2.1", "Endotracheopulmonary instillation, solution", "Endotracheopulmonary instillation, solution", "L�sung zur endotracheopulmonalen Instillation", "Solution pour instillation endotrach�obronchique", "Soluzione per instillazione endotracheobronchiale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Endotracheopulmonary instillation, suspension</div>
	 * <div class="de">Suspension zur endotracheopulmonalen Instillation</div>
	 * <div class="fr">Suspension pour instillation endotrach�obronchique</div>
	 * <div class="it">Sospensione per instillazione endotracheobronchiale</div>
	 * <!-- @formatter:on -->
	 */
	ENDOTRACHEOPULMONARY_INSTILLATION_SUSPENSION("11603000", "0.4.0.127.0.16.1.1.2.1", "Endotracheopulmonary instillation, suspension", "Endotracheopulmonary instillation, suspension", "Suspension zur endotracheopulmonalen Instillation", "Suspension pour instillation endotrach�obronchique", "Sospensione per instillazione endotracheobronchiale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Epilesional solution</div>
	 * <div class="de">L�sung zum Auftragen auf die Haut</div>
	 * <div class="fr">Solution �pil�sionnelle</div>
	 * <!-- @formatter:on -->
	 */
	EPILESIONAL_SOLUTION("13042000", "0.4.0.127.0.16.1.1.2.1", "Epilesional solution", "Epilesional solution", "L�sung zum Auftragen auf die Haut", "Solution �pil�sionnelle", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Eye cream</div>
	 * <div class="de">Augencreme</div>
	 * <div class="fr">Cr�me ophtalmique</div>
	 * <div class="it">Crema oftalmica</div>
	 * <!-- @formatter:on -->
	 */
	EYE_CREAM("10601000", "0.4.0.127.0.16.1.1.2.1", "Eye cream", "Eye cream", "Augencreme", "Cr�me ophtalmique", "Crema oftalmica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Eye drops, emulsion</div>
	 * <div class="de">Augentropfen, Emulsion</div>
	 * <div class="fr">Collyre en �mulsion</div>
	 * <div class="it">Collirio, emulsione</div>
	 * <!-- @formatter:on -->
	 */
	EYE_DROPS_EMULSION("10604500", "0.4.0.127.0.16.1.1.2.1", "Eye drops, emulsion", "Eye drops, emulsion", "Augentropfen, Emulsion", "Collyre en �mulsion", "Collirio, emulsione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Eye drops, powder for solution</div>
	 * <div class="de">Pulver zur Herstellung von Augentropfen, L�sung</div>
	 * <div class="fr">Poudre pour solution ophtalmique en gouttes</div>
	 * <!-- @formatter:on -->
	 */
	EYE_DROPS_POWDER_FOR_SOLUTION("13010000", "0.4.0.127.0.16.1.1.2.1", "Eye drops, powder for solution", "Eye drops, powder for solution", "Pulver zur Herstellung von Augentropfen, L�sung", "Poudre pour solution ophtalmique en gouttes", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Eye drops, powder for suspension</div>
	 * <div class="de">Pulver zur Herstellung einer Augentropfensuspension</div>
	 * <div class="fr">Poudre pour suspension ophtalmique en gouttes</div>
	 * <!-- @formatter:on -->
	 */
	EYE_DROPS_POWDER_FOR_SUSPENSION("13011000", "0.4.0.127.0.16.1.1.2.1", "Eye drops, powder for suspension", "Eye drops, powder for suspension", "Pulver zur Herstellung einer Augentropfensuspension", "Poudre pour suspension ophtalmique en gouttes", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Eye drops, prolonged-release</div>
	 * <div class="de">Augentropfen mit verl�ngerter Wirkungsdauer</div>
	 * <div class="fr">Collyre � lib�ration prolong�e</div>
	 * <div class="it">Collirio a rilascio prolungato</div>
	 * <!-- @formatter:on -->
	 */
	EYE_DROPS_PROLONGED_RELEASE("10609000", "0.4.0.127.0.16.1.1.2.1", "Eye drops, prolonged-release", "Eye drops, prolonged-release", "Augentropfen mit verl�ngerter Wirkungsdauer", "Collyre � lib�ration prolong�e", "Collirio a rilascio prolungato"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Eye drops, solution</div>
	 * <div class="de">Augentropfen, L�sung</div>
	 * <div class="fr">Collyre en solution</div>
	 * <div class="it">Collirio, soluzione</div>
	 * <!-- @formatter:on -->
	 */
	EYE_DROPS_SOLUTION("10604000", "0.4.0.127.0.16.1.1.2.1", "Eye drops, solution", "Eye drops, solution", "Augentropfen, L�sung", "Collyre en solution", "Collirio, soluzione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Eye drops, solvent for reconstitution</div>
	 * <div class="de">L�sungsmittel zur Herstellung von Augentropfen</div>
	 * <div class="fr">Solvant pour collyre</div>
	 * <div class="it">Solvente per collirio</div>
	 * <!-- @formatter:on -->
	 */
	EYE_DROPS_SOLVENT_FOR_RECONSTITUTION("10608000", "0.4.0.127.0.16.1.1.2.1", "Eye drops, solvent for reconstitution", "Eye drops, solvent for reconstitution", "L�sungsmittel zur Herstellung von Augentropfen", "Solvant pour collyre", "Solvente per collirio"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Eye drops, suspension</div>
	 * <div class="de">Augentropfensuspension</div>
	 * <div class="fr">Collyre en suspension</div>
	 * <div class="it">Collirio, sospensione</div>
	 * <!-- @formatter:on -->
	 */
	EYE_DROPS_SUSPENSION("10605000", "0.4.0.127.0.16.1.1.2.1", "Eye drops, suspension", "Eye drops, suspension", "Augentropfensuspension", "Collyre en suspension", "Collirio, sospensione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Eye gel</div>
	 * <div class="de">Augengel</div>
	 * <div class="fr">Gel ophtalmique</div>
	 * <div class="it">Gel oftalmico</div>
	 * <!-- @formatter:on -->
	 */
	EYE_GEL("10602000", "0.4.0.127.0.16.1.1.2.1", "Eye gel", "Eye gel", "Augengel", "Gel ophtalmique", "Gel oftalmico"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Eye lotion</div>
	 * <div class="de">Augenbad</div>
	 * <div class="fr">Solution pour lavage ophtalmique</div>
	 * <div class="it">Bagno oculare</div>
	 * <!-- @formatter:on -->
	 */
	EYE_LOTION("10610000", "0.4.0.127.0.16.1.1.2.1", "Eye lotion", "Eye lotion", "Augenbad", "Solution pour lavage ophtalmique", "Bagno oculare"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Eye lotion, solvent for reconstitution</div>
	 * <div class="de">L�sungsmittel zur Herstellung eines Augenbades</div>
	 * <div class="fr">Solvant pour solution pour lavage ophtalmique</div>
	 * <div class="it">Solvente per bagno oculare</div>
	 * <!-- @formatter:on -->
	 */
	EYE_LOTION_SOLVENT_FOR_RECONSTITUTION("10611000", "0.4.0.127.0.16.1.1.2.1", "Eye lotion, solvent for reconstitution", "Eye lotion, solvent for reconstitution", "L�sungsmittel zur Herstellung eines Augenbades", "Solvant pour solution pour lavage ophtalmique", "Solvente per bagno oculare"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Eye ointment</div>
	 * <div class="de">Augensalbe</div>
	 * <div class="fr">Pommade ophtalmique</div>
	 * <div class="it">Unguento oftalmico</div>
	 * <!-- @formatter:on -->
	 */
	EYE_OINTMENT("10603000", "0.4.0.127.0.16.1.1.2.1", "Eye ointment", "Eye ointment", "Augensalbe", "Pommade ophtalmique", "Unguento oftalmico"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Film-coated tablet</div>
	 * <div class="de">Filmtablette</div>
	 * <div class="fr">Comprim� pellicul�</div>
	 * <div class="it">Compressa rivestita con film</div>
	 * <!-- @formatter:on -->
	 */
	FILM_COATED_TABLET("10221000", "0.4.0.127.0.16.1.1.2.1", "Film-coated tablet", "Film-coated tablet", "Filmtablette", "Comprim� pellicul�", "Compressa rivestita con film"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gargle</div>
	 * <div class="de">Gurgell�sung</div>
	 * <div class="fr">Solution pour gargarisme</div>
	 * <div class="it">Soluzione per gargarismi</div>
	 * <!-- @formatter:on -->
	 */
	GARGLE("10301000", "0.4.0.127.0.16.1.1.2.1", "Gargle", "Gargle", "Gurgell�sung", "Solution pour gargarisme", "Soluzione per gargarismi"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gargle/mouthwash</div>
	 * <div class="de">Gurgell�sung/Mundsp�lung</div>
	 * <div class="fr">Solution pour gargarisme/bain de bouche</div>
	 * <!-- @formatter:on -->
	 */
	GARGLE_MOUTHWASH("50024000", "0.4.0.127.0.16.1.1.2.1", "Gargle/mouthwash", "Gargle/mouthwash", "Gurgell�sung/Mundsp�lung", "Solution pour gargarisme/bain de bouche", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gargle/nasal wash</div>
	 * <div class="de">Gurgell�sung/Nasensp�lung</div>
	 * <div class="fr">Solution pour gargarisme/ nasale</div>
	 * <!-- @formatter:on -->
	 */
	GARGLE_NASAL_WASH("50024500", "0.4.0.127.0.16.1.1.2.1", "Gargle/nasal wash", "Gargle/nasal wash", "Gurgell�sung/Nasensp�lung", "Solution pour gargarisme/ nasale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gargle, powder for solution</div>
	 * <div class="de">Pulver zur Herstellung einer Gurgell�sung</div>
	 * <div class="fr">Poudre pour solution pour gargarisme</div>
	 * <div class="it">Polvere per soluzione per gargarismi</div>
	 * <!-- @formatter:on -->
	 */
	GARGLE_POWDER_FOR_SOLUTION("10303000", "0.4.0.127.0.16.1.1.2.1", "Gargle, powder for solution", "Gargle, powder for solution", "Pulver zur Herstellung einer Gurgell�sung", "Poudre pour solution pour gargarisme", "Polvere per soluzione per gargarismi"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gargle, tablet for solution</div>
	 * <div class="de">Tablette zur Herstellung einer Gurgell�sung</div>
	 * <div class="fr">Comprim� pour solution pour gargarisme</div>
	 * <div class="it">Compressa per soluzione per gargarismi</div>
	 * <!-- @formatter:on -->
	 */
	GARGLE_TABLET_FOR_SOLUTION("10304000", "0.4.0.127.0.16.1.1.2.1", "Gargle, tablet for solution", "Gargle, tablet for solution", "Tablette zur Herstellung einer Gurgell�sung", "Comprim� pour solution pour gargarisme", "Compressa per soluzione per gargarismi"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gastroenteral emulsion</div>
	 * <div class="de">Emulsion zur gastrointestinalen Anwendung</div>
	 * <div class="fr">Emulsion gastroent�rale</div>
	 * <div class="it">Emulsione gastroenterica</div>
	 * <!-- @formatter:on -->
	 */
	GASTROENTERAL_EMULSION("12111000", "0.4.0.127.0.16.1.1.2.1", "Gastroenteral emulsion", "Gastroenteral emulsion", "Emulsion zur gastrointestinalen Anwendung", "Emulsion gastroent�rale", "Emulsione gastroenterica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gastroenteral solution</div>
	 * <div class="de">L�sung zur gastrointestinalen Anwendung</div>
	 * <div class="fr">Solution gastroent�rale</div>
	 * <div class="it">Soluzione gastroenterica</div>
	 * <!-- @formatter:on -->
	 */
	GASTROENTERAL_SOLUTION("12108000", "0.4.0.127.0.16.1.1.2.1", "Gastroenteral solution", "Gastroenteral solution", "L�sung zur gastrointestinalen Anwendung", "Solution gastroent�rale", "Soluzione gastroenterica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gastroenteral suspension</div>
	 * <div class="de">Suspension zur gastrointestinalen Anwendung</div>
	 * <div class="fr">Suspension gastroent�rale</div>
	 * <div class="it">Sospensione gastroenterica</div>
	 * <!-- @formatter:on -->
	 */
	GASTROENTERAL_SUSPENSION("12110000", "0.4.0.127.0.16.1.1.2.1", "Gastroenteral suspension", "Gastroenteral suspension", "Suspension zur gastrointestinalen Anwendung", "Suspension gastroent�rale", "Sospensione gastroenterica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gastro-resistant capsule, hard</div>
	 * <div class="de">magensaftresistente Hartkapsel</div>
	 * <div class="fr">G�lule gastror�sistante</div>
	 * <div class="it">Capsula rigida gastroresistente</div>
	 * <!-- @formatter:on -->
	 */
	GASTRO_RESISTANT_CAPSULE_HARD("10212000", "0.4.0.127.0.16.1.1.2.1", "Gastro-resistant capsule, hard", "Gastro-resistant capsule, hard", "magensaftresistente Hartkapsel", "G�lule gastror�sistante", "Capsula rigida gastroresistente"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gastro-resistant capsule, soft</div>
	 * <div class="de">magensaftresistente Weichkapsel</div>
	 * <div class="fr">Capsule molle gastror�sistante</div>
	 * <div class="it">Capsula molle gastroresistente</div>
	 * <!-- @formatter:on -->
	 */
	GASTRO_RESISTANT_CAPSULE_SOFT("10213000", "0.4.0.127.0.16.1.1.2.1", "Gastro-resistant capsule, soft", "Gastro-resistant capsule, soft", "magensaftresistente Weichkapsel", "Capsule molle gastror�sistante", "Capsula molle gastroresistente"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gastro-resistant granules</div>
	 * <div class="de">magensaftresistentes Granulat</div>
	 * <div class="fr">Granul�s gastror�sistants</div>
	 * <div class="it">Granulato gastroresistente</div>
	 * <!-- @formatter:on -->
	 */
	GASTRO_RESISTANT_GRANULES("10206000", "0.4.0.127.0.16.1.1.2.1", "Gastro-resistant granules", "Gastro-resistant granules", "magensaftresistentes Granulat", "Granul�s gastror�sistants", "Granulato gastroresistente"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gastro-resistant granules for oral suspension</div>
	 * <div class="de">magensaftresistentes Granulat zur Herstellung einer Suspension zum Einnehmen</div>
	 * <div class="fr">Granul�s gastror�sistants pour suspension buvable</div>
	 * <!-- @formatter:on -->
	 */
	GASTRO_RESISTANT_GRANULES_FOR_ORAL_SUSPENSION("50026000", "0.4.0.127.0.16.1.1.2.1", "Gastro-resistant granules for oral suspension", "Gastro-resistant granules for oral suspension", "magensaftresistentes Granulat zur Herstellung einer Suspension zum Einnehmen", "Granul�s gastror�sistants pour suspension buvable", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gastro-resistant tablet</div>
	 * <div class="de">magensaftresistente Tablette</div>
	 * <div class="fr">Comprim� gastror�sistant</div>
	 * <div class="it">Compressa gastroresistente</div>
	 * <!-- @formatter:on -->
	 */
	GASTRO_RESISTANT_TABLET("10225000", "0.4.0.127.0.16.1.1.2.1", "Gastro-resistant tablet", "Gastro-resistant tablet", "magensaftresistente Tablette", "Comprim� gastror�sistant", "Compressa gastroresistente"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gas for dispersion for infusion</div>
	 * <div class="de">Gas zur Herstellung einer Infusionsdispersion</div>
	 * <div class="fr">Gaz pour dispersion pour perfusion</div>
	 * <!-- @formatter:on -->
	 */
	GAS_FOR_DISPERSION_FOR_INFUSION("13012000", "0.4.0.127.0.16.1.1.2.1", "Gas for dispersion for infusion", "Gas for dispersion for infusion", "Gas zur Herstellung einer Infusionsdispersion", "Gaz pour dispersion pour perfusion", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gas for dispersion for injection</div>
	 * <div class="de">Gas zur Herstellung einer Injektionsdispersion</div>
	 * <div class="fr">Gaz pour dispersion injectable</div>
	 * <!-- @formatter:on -->
	 */
	GAS_FOR_DISPERSION_FOR_INJECTION("13013000", "0.4.0.127.0.16.1.1.2.1", "Gas for dispersion for injection", "Gas for dispersion for injection", "Gas zur Herstellung einer Injektionsdispersion", "Gaz pour dispersion injectable", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gas for dispersion for injection/infusion</div>
	 * <div class="de">Gas zur Herstellung einer Injektions-/Infusionsdispersion</div>
	 * <div class="fr">Gaz pour dispersion injectable/ pour perfusion</div>
	 * <!-- @formatter:on -->
	 */
	GAS_FOR_DISPERSION_FOR_INJECTION_INFUSION("13050000", "0.4.0.127.0.16.1.1.2.1", "Gas for dispersion for injection/infusion", "Gas for dispersion for injection/infusion", "Gas zur Herstellung einer Injektions-/Infusionsdispersion", "Gaz pour dispersion injectable/ pour perfusion", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gel</div>
	 * <div class="de">Gel</div>
	 * <div class="fr">Gel</div>
	 * <div class="it">Gel</div>
	 * <!-- @formatter:on -->
	 */
	GEL("10503000", "0.4.0.127.0.16.1.1.2.1", "Gel", "Gel", "Gel", "Gel", "Gel"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gel for gel</div>
	 * <div class="de">Gel zur Herstellung eines Gels</div>
	 * <div class="fr">Gel pour gel</div>
	 * <!-- @formatter:on -->
	 */
	GEL_FOR_GEL("13014000", "0.4.0.127.0.16.1.1.2.1", "Gel for gel", "Gel for gel", "Gel zur Herstellung eines Gels", "Gel pour gel", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gel for injection</div>
	 * <div class="de">Gel zur Injektion</div>
	 * <div class="fr">Gel injectable</div>
	 * <div class="it">Gel iniettabile</div>
	 * <!-- @formatter:on -->
	 */
	GEL_FOR_INJECTION("11204000", "0.4.0.127.0.16.1.1.2.1", "Gel for injection", "Gel for injection", "Gel zur Injektion", "Gel injectable", "Gel iniettabile"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gingival gel</div>
	 * <div class="de">Gel zur Anwendung am Zahnfleisch</div>
	 * <div class="fr">Gel gingival</div>
	 * <div class="it">Gel gengivale</div>
	 * <!-- @formatter:on -->
	 */
	GINGIVAL_GEL("10315000", "0.4.0.127.0.16.1.1.2.1", "Gingival gel", "Gingival gel", "Gel zur Anwendung am Zahnfleisch", "Gel gingival", "Gel gengivale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gingival paste</div>
	 * <div class="de">Paste zur Anwendung am Zahnfleisch</div>
	 * <div class="fr">P�te gingivale</div>
	 * <div class="it">Pasta gengivale</div>
	 * <!-- @formatter:on -->
	 */
	GINGIVAL_PASTE("10316000", "0.4.0.127.0.16.1.1.2.1", "Gingival paste", "Gingival paste", "Paste zur Anwendung am Zahnfleisch", "P�te gingivale", "Pasta gengivale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gingival solution</div>
	 * <div class="de">L�sung zur Anwendung am Zahnfleisch</div>
	 * <div class="fr">Solution gingivale</div>
	 * <div class="it">Soluzione gengivale</div>
	 * <!-- @formatter:on -->
	 */
	GINGIVAL_SOLUTION("10312000", "0.4.0.127.0.16.1.1.2.1", "Gingival solution", "Gingival solution", "L�sung zur Anwendung am Zahnfleisch", "Solution gingivale", "Soluzione gengivale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Granules</div>
	 * <div class="de">Granulat</div>
	 * <div class="fr">Granul�s</div>
	 * <div class="it">Granulato</div>
	 * <!-- @formatter:on -->
	 */
	GRANULES("10204000", "0.4.0.127.0.16.1.1.2.1", "Granules", "Granules", "Granulat", "Granul�s", "Granulato"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Granules for oral/rectal suspension</div>
	 * <div class="de">Granulat zur Herstellung einer Suspension zum Einnehmen/Rektalsuspension</div>
	 * <div class="fr">Granul�s pour suspension buvable/rectale</div>
	 * <!-- @formatter:on -->
	 */
	GRANULES_FOR_ORAL_RECTAL_SUSPENSION("50029150", "0.4.0.127.0.16.1.1.2.1", "Granules for oral/rectal suspension", "Granules for oral/rectal suspension", "Granulat zur Herstellung einer Suspension zum Einnehmen/Rektalsuspension", "Granul�s pour suspension buvable/rectale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Granules for oral solution</div>
	 * <div class="de">Granulat zur Herstellung einer L�sung zum Einnehmen</div>
	 * <div class="fr">Granul�s pour solution buvable</div>
	 * <div class="it">Granulato per soluzione orale</div>
	 * <!-- @formatter:on -->
	 */
	GRANULES_FOR_ORAL_SOLUTION("10112000", "0.4.0.127.0.16.1.1.2.1", "Granules for oral solution", "Granules for oral solution", "Granulat zur Herstellung einer L�sung zum Einnehmen", "Granul�s pour solution buvable", "Granulato per soluzione orale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Granules for oral suspension</div>
	 * <div class="de">Granulat zur Herstellung einer Suspension zum Einnehmen</div>
	 * <div class="fr">Granul�s pour suspension buvable</div>
	 * <div class="it">Granulato per sospensione orale</div>
	 * <!-- @formatter:on -->
	 */
	GRANULES_FOR_ORAL_SUSPENSION("10113000", "0.4.0.127.0.16.1.1.2.1", "Granules for oral suspension", "Granules for oral suspension", "Granulat zur Herstellung einer Suspension zum Einnehmen", "Granul�s pour suspension buvable", "Granulato per sospensione orale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Granules for rectal suspension</div>
	 * <div class="de">Granulat zur Herstellung einer Rektalsuspension</div>
	 * <div class="fr">Granul�s pour suspension rectale</div>
	 * <!-- @formatter:on -->
	 */
	GRANULES_FOR_RECTAL_SUSPENSION("13015000", "0.4.0.127.0.16.1.1.2.1", "Granules for rectal suspension", "Granules for rectal suspension", "Granulat zur Herstellung einer Rektalsuspension", "Granul�s pour suspension rectale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Granules for suspension for injection</div>
	 * <div class="de">Granulat zur Herstellung einer Injektionssuspension</div>
	 * <div class="fr">Granul�s pour suspension injectable</div>
	 * <!-- @formatter:on -->
	 */
	GRANULES_FOR_SUSPENSION_FOR_INJECTION("13048000", "0.4.0.127.0.16.1.1.2.1", "Granules for suspension for injection", "Granules for suspension for injection", "Granulat zur Herstellung einer Injektionssuspension", "Granul�s pour suspension injectable", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Granules for syrup</div>
	 * <div class="de">Granulat zur Herstellung eines Sirups</div>
	 * <div class="fr">Granul�s pour sirop</div>
	 * <div class="it">Granulato per sciroppo</div>
	 * <!-- @formatter:on -->
	 */
	GRANULES_FOR_SYRUP("10119000", "0.4.0.127.0.16.1.1.2.1", "Granules for syrup", "Granules for syrup", "Granulat zur Herstellung eines Sirups", "Granul�s pour sirop", "Granulato per sciroppo"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Granules for vaginal solution</div>
	 * <div class="de">Granulat zur Herstellung einer Vaginall�sung</div>
	 * <div class="fr">Granul�s pour solution vaginale</div>
	 * <!-- @formatter:on -->
	 */
	GRANULES_FOR_VAGINAL_SOLUTION("50029500", "0.4.0.127.0.16.1.1.2.1", "Granules for vaginal solution", "Granules for vaginal solution", "Granulat zur Herstellung einer Vaginall�sung", "Granul�s pour solution vaginale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Herbal tea</div>
	 * <div class="de">Arzneitee</div>
	 * <div class="fr">Plante(s) pour tisane</div>
	 * <div class="it">Tisana</div>
	 * <!-- @formatter:on -->
	 */
	HERBAL_TEA("10122000", "0.4.0.127.0.16.1.1.2.1", "Herbal tea", "Herbal tea", "Arzneitee", "Plante(s) pour tisane", "Tisana"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Implant</div>
	 * <div class="de">Implantat</div>
	 * <div class="fr">Implant</div>
	 * <div class="it">Impianto</div>
	 * <!-- @formatter:on -->
	 */
	IMPLANT("11301000", "0.4.0.127.0.16.1.1.2.1", "Implant", "Implant", "Implantat", "Implant", "Impianto"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Implantation chain</div>
	 * <div class="de">Kette zur Implantation</div>
	 * <div class="fr">Implant en cha�ne</div>
	 * <div class="it">Catenella per impianto</div>
	 * <!-- @formatter:on -->
	 */
	IMPLANTATION_CHAIN("11303000", "0.4.0.127.0.16.1.1.2.1", "Implantation chain", "Implantation chain", "Kette zur Implantation", "Implant en cha�ne", "Catenella per impianto"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Implantation matrix</div>
	 * <div class="de">Matrix zur Implantation</div>
	 * <div class="fr">Matrice pour implantation</div>
	 * <!-- @formatter:on -->
	 */
	IMPLANTATION_MATRIX("11303300", "0.4.0.127.0.16.1.1.2.1", "Implantation matrix", "Implantation matrix", "Matrix zur Implantation", "Matrice pour implantation", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Implantation paste</div>
	 * <div class="de">Paste f�r Implantate</div>
	 * <div class="fr">P�te pour implantation</div>
	 * <!-- @formatter:on -->
	 */
	IMPLANTATION_PASTE("13043000", "0.4.0.127.0.16.1.1.2.1", "Implantation paste", "Implantation paste", "Paste f�r Implantate", "P�te pour implantation", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Implantation suspension</div>
	 * <div class="de">Suspension zur Implantation</div>
	 * <div class="fr">Suspension pour implantation</div>
	 * <!-- @formatter:on -->
	 */
	IMPLANTATION_SUSPENSION("11303500", "0.4.0.127.0.16.1.1.2.1", "Implantation suspension", "Implantation suspension", "Suspension zur Implantation", "Suspension pour implantation", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Implantation tablet</div>
	 * <div class="de">Tablette zur Implantation</div>
	 * <div class="fr">Comprim� pour implantation</div>
	 * <div class="it">Compressa per impianto</div>
	 * <!-- @formatter:on -->
	 */
	IMPLANTATION_TABLET("11302000", "0.4.0.127.0.16.1.1.2.1", "Implantation tablet", "Implantation tablet", "Tablette zur Implantation", "Comprim� pour implantation", "Compressa per impianto"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Impregnated dressing</div>
	 * <div class="de">impr�gnierter Verband</div>
	 * <div class="fr">Compresse impr�gn�e</div>
	 * <div class="it">Garza impregnata</div>
	 * <!-- @formatter:on -->
	 */
	IMPREGNATED_DRESSING("10525000", "0.4.0.127.0.16.1.1.2.1", "Impregnated dressing", "Impregnated dressing", "impr�gnierter Verband", "Compresse impr�gn�e", "Garza impregnata"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Impregnated pad</div>
	 * <div class="de">Impr�gnierter Tampon</div>
	 * <div class="fr">Tampon impr�gn�</div>
	 * <div class="it">Tampone medicato</div>
	 * <!-- @formatter:on -->
	 */
	IMPREGNATED_PAD("12117000", "0.4.0.127.0.16.1.1.2.1", "Impregnated pad", "Impregnated pad", "Impr�gnierter Tampon", "Tampon impr�gn�", "Tampone medicato"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Impregnated plug</div>
	 * <div class="de">Impr�gnierter Einsatz</div>
	 * <div class="fr">Support poreux impr�gn�</div>
	 * <!-- @formatter:on -->
	 */
	IMPREGNATED_PLUG("12117500", "0.4.0.127.0.16.1.1.2.1", "Impregnated plug", "Impregnated plug", "Impr�gnierter Einsatz", "Support poreux impr�gn�", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation powder</div>
	 * <div class="de">Pulver zur Inhalation</div>
	 * <div class="fr">Poudre pour inhalation</div>
	 * <div class="it">Polvere per inalazione</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_POWDER("11109000", "0.4.0.127.0.16.1.1.2.1", "Inhalation powder", "Inhalation powder", "Pulver zur Inhalation", "Poudre pour inhalation", "Polvere per inalazione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation powder, hard capsule</div>
	 * <div class="de">Hartkapsel mit Pulver zur Inhalation</div>
	 * <div class="fr">Poudre pour inhalation en g�lule</div>
	 * <div class="it">Polvere per inalazione, capsula rigida</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_POWDER_HARD_CAPSULE("11110000", "0.4.0.127.0.16.1.1.2.1", "Inhalation powder, hard capsule", "Inhalation powder, hard capsule", "Hartkapsel mit Pulver zur Inhalation", "Poudre pour inhalation en g�lule", "Polvere per inalazione, capsula rigida"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation powder, pre-dispensed</div>
	 * <div class="de">einzeldosiertes Pulver zur Inhalation</div>
	 * <div class="fr">Poudre pour inhalation en r�cipient unidose</div>
	 * <div class="it">Polvere per inalazione in contenitore monodose</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_POWDER_PRE_DISPENSED("11111000", "0.4.0.127.0.16.1.1.2.1", "Inhalation powder, pre-dispensed", "Inhalation powder, pre-dispensed", "einzeldosiertes Pulver zur Inhalation", "Poudre pour inhalation en r�cipient unidose", "Polvere per inalazione in contenitore monodose"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation powder, tablet</div>
	 * <div class="de">Tablette mit Pulver zur Inhalation</div>
	 * <div class="fr">Comprim� pour inhalation par poudre</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_POWDER_TABLET("50030000", "0.4.0.127.0.16.1.1.2.1", "Inhalation powder, tablet", "Inhalation powder, tablet", "Tablette mit Pulver zur Inhalation", "Comprim� pour inhalation par poudre", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation solution</div>
	 * <div class="de">L�sung zur Inhalation</div>
	 * <div class="fr">Solution � inhaler</div>
	 * <div class="it">Soluzione per inalazione</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_SOLUTION("50081000", "0.4.0.127.0.16.1.1.2.1", "Inhalation solution", "Inhalation solution", "L�sung zur Inhalation", "Solution � inhaler", "Soluzione per inalazione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation vapour, capsule</div>
	 * <div class="de">Kapsel zur Herstellung eines Dampfs zur Inhalation</div>
	 * <div class="fr">Capsule pour inhalation par vapeur</div>
	 * <div class="it">Capsula per suffumigi</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_VAPOUR_CAPSULE("11113000", "0.4.0.127.0.16.1.1.2.1", "Inhalation vapour, capsule", "Inhalation vapour, capsule", "Kapsel zur Herstellung eines Dampfs zur Inhalation", "Capsule pour inhalation par vapeur", "Capsula per suffumigi"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation vapour, effervescent tablet</div>
	 * <div class="de">Brausetablette zur Herstellung eines Dampfs zur Inhalation</div>
	 * <div class="fr">Comprim� effervescent pour inhalation par vapeur</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_VAPOUR_EFFERVESCENT_TABLET("50031000", "0.4.0.127.0.16.1.1.2.1", "Inhalation vapour, effervescent tablet", "Inhalation vapour, effervescent tablet", "Brausetablette zur Herstellung eines Dampfs zur Inhalation", "Comprim� effervescent pour inhalation par vapeur", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation vapour, emulsion</div>
	 * <div class="de">Emulsion zur Herstellung eines Dampfs zur Inhalation</div>
	 * <div class="fr">Emulsion pour inhalation par vapeur</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_VAPOUR_EMULSION("50032000", "0.4.0.127.0.16.1.1.2.1", "Inhalation vapour, emulsion", "Inhalation vapour, emulsion", "Emulsion zur Herstellung eines Dampfs zur Inhalation", "Emulsion pour inhalation par vapeur", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation vapour, impregnated pad</div>
	 * <div class="de">Dampf zur Inhalation, impr�gnierter Einsatz</div>
	 * <div class="fr">Tampon impr�gn� pour inhalation par vapeur</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_VAPOUR_IMPREGNATED_PAD("50033000", "0.4.0.127.0.16.1.1.2.1", "Inhalation vapour, impregnated pad", "Inhalation vapour, impregnated pad", "Dampf zur Inhalation, impr�gnierter Einsatz", "Tampon impr�gn� pour inhalation par vapeur", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation vapour, impregnated plug</div>
	 * <div class="de">Dampf zur Inhalation, impr�gnierter Einsatz</div>
	 * <div class="fr">Support poreux impr�gn� pour inhalation par vapeur</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_VAPOUR_IMPREGNATED_PLUG("50033100", "0.4.0.127.0.16.1.1.2.1", "Inhalation vapour, impregnated plug", "Inhalation vapour, impregnated plug", "Dampf zur Inhalation, impr�gnierter Einsatz", "Support poreux impr�gn� pour inhalation par vapeur", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation vapour, liquid</div>
	 * <div class="de">Fl�ssigkeit zur Herstellung eines Dampfs zur Inhalation</div>
	 * <div class="fr">Liquide pour inhalation par vapeur</div>
	 * <div class="it">Liquido per  suffumigi</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_VAPOUR_LIQUID("11117000", "0.4.0.127.0.16.1.1.2.1", "Inhalation vapour, liquid", "Inhalation vapour, liquid", "Fl�ssigkeit zur Herstellung eines Dampfs zur Inhalation", "Liquide pour inhalation par vapeur", "Liquido per  suffumigi"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation vapour, ointment</div>
	 * <div class="de">Salbe zur Herstellung eines Dampfs zur Inhalation</div>
	 * <div class="fr">Pommade pour inhalation par vapeur</div>
	 * <div class="it">Unguento per suffumigi</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_VAPOUR_OINTMENT("11116000", "0.4.0.127.0.16.1.1.2.1", "Inhalation vapour, ointment", "Inhalation vapour, ointment", "Salbe zur Herstellung eines Dampfs zur Inhalation", "Pommade pour inhalation par vapeur", "Unguento per suffumigi"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation vapour, powder</div>
	 * <div class="de">Pulver zur Herstellung eines Dampfs zur Inhalation</div>
	 * <div class="fr">Poudre pour inhalation par vapeur</div>
	 * <div class="it">Polvere per suffumigi</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_VAPOUR_POWDER("11112000", "0.4.0.127.0.16.1.1.2.1", "Inhalation vapour, powder", "Inhalation vapour, powder", "Pulver zur Herstellung eines Dampfs zur Inhalation", "Poudre pour inhalation par vapeur", "Polvere per suffumigi"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation vapour, solution</div>
	 * <div class="de">L�sung zur Herstellung eines Dampfs zur Inhalation</div>
	 * <div class="fr">Solution pour inhalation par vapeur</div>
	 * <div class="it">Soluzione per  suffumigi</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_VAPOUR_SOLUTION("11114000", "0.4.0.127.0.16.1.1.2.1", "Inhalation vapour, solution", "Inhalation vapour, solution", "L�sung zur Herstellung eines Dampfs zur Inhalation", "Solution pour inhalation par vapeur", "Soluzione per  suffumigi"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation vapour, tablet</div>
	 * <div class="de">Tablette zur Herstellung eines Dampfs zur Inhalation</div>
	 * <div class="fr">Comprim� pour inhalation par vapeur</div>
	 * <div class="it">Compressa per  suffumigi</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_VAPOUR_TABLET("11115000", "0.4.0.127.0.16.1.1.2.1", "Inhalation vapour, tablet", "Inhalation vapour, tablet", "Tablette zur Herstellung eines Dampfs zur Inhalation", "Comprim� pour inhalation par vapeur", "Compressa per  suffumigi"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instant herbal tea</div>
	 * <div class="de">Teeaufgusspulver</div>
	 * <div class="fr">Pr�paration instantan�e pour tisane</div>
	 * <div class="it">Tisana, polvere solubile</div>
	 * <!-- @formatter:on -->
	 */
	INSTANT_HERBAL_TEA("10202000", "0.4.0.127.0.16.1.1.2.1", "Instant herbal tea", "Instant herbal tea", "Teeaufgusspulver", "Pr�paration instantan�e pour tisane", "Tisana, polvere solubile"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intestinal gel</div>
	 * <div class="de">Gel zur intestinalen Anwendung</div>
	 * <div class="fr">Gel intestinal</div>
	 * <div class="it">Gel intestinale</div>
	 * <!-- @formatter:on -->
	 */
	INTESTINAL_GEL("12120000", "0.4.0.127.0.16.1.1.2.1", "Intestinal gel", "Intestinal gel", "Gel zur intestinalen Anwendung", "Gel intestinal", "Gel intestinale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intraocular instillation solution</div>
	 * <div class="de">L�sung zur intraokularen Instillation</div>
	 * <div class="fr">Solution pour instillation intraoculaire</div>
	 * <!-- @formatter:on -->
	 */
	INTRAOCULAR_INSTILLATION_SOLUTION("13044000", "0.4.0.127.0.16.1.1.2.1", "Intraocular instillation solution", "Intraocular instillation solution", "L�sung zur intraokularen Instillation", "Solution pour instillation intraoculaire", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intraperitoneal solution</div>
	 * <div class="de">L�sung zur intraperitonealen Awendung</div>
	 * <div class="fr">Solution intrap�riton�ale</div>
	 * <!-- @formatter:on -->
	 */
	INTRAPERITONEAL_SOLUTION("12111500", "0.4.0.127.0.16.1.1.2.1", "Intraperitoneal solution", "Intraperitoneal solution", "L�sung zur intraperitonealen Awendung", "Solution intrap�riton�ale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intrauterine delivery system</div>
	 * <div class="de">Intrauterines Wirkstofffreisetzungssystem</div>
	 * <div class="fr">Syst�me de diffusion intra-ut�rin</div>
	 * <div class="it">Sistema a rilascio intrauterino</div>
	 * <!-- @formatter:on -->
	 */
	INTRAUTERINE_DELIVERY_SYSTEM("11901000", "0.4.0.127.0.16.1.1.2.1", "Intrauterine delivery system", "Intrauterine delivery system", "Intrauterines Wirkstofffreisetzungssystem", "Syst�me de diffusion intra-ut�rin", "Sistema a rilascio intrauterino"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intravesical solution</div>
	 * <div class="de">L�sung zur intravesikalen Anwendung</div>
	 * <div class="fr">Solution intrav�sicale</div>
	 * <!-- @formatter:on -->
	 */
	INTRAVESICAL_SOLUTION("11502500", "0.4.0.127.0.16.1.1.2.1", "Intravesical solution", "Intravesical solution", "L�sung zur intravesikalen Anwendung", "Solution intrav�sicale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intravesical solution/solution for injection</div>
	 * <div class="de">L�sung zur intravesikalen Anwendung/Injektionsl�sung</div>
	 * <div class="fr">Solution intrav�sicale/solution injectable</div>
	 * <!-- @formatter:on -->
	 */
	INTRAVESICAL_SOLUTION_SOLUTION_FOR_INJECTION("50033400", "0.4.0.127.0.16.1.1.2.1", "Intravesical solution/solution for injection", "Intravesical solution/solution for injection", "L�sung zur intravesikalen Anwendung/Injektionsl�sung", "Solution intrav�sicale/solution injectable", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intravesical suspension</div>
	 * <div class="de">Suspension zur intravesikalen Anwendung</div>
	 * <div class="fr">Suspension intrav�sicale</div>
	 * <!-- @formatter:on -->
	 */
	INTRAVESICAL_SUSPENSION("13045000", "0.4.0.127.0.16.1.1.2.1", "Intravesical suspension", "Intravesical suspension", "Suspension zur intravesikalen Anwendung", "Suspension intrav�sicale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Irrigation solution</div>
	 * <div class="de">Sp�ll�sung</div>
	 * <div class="fr">Solution pour irrigation</div>
	 * <div class="it">Soluzione per irrigazione</div>
	 * <!-- @formatter:on -->
	 */
	IRRIGATION_SOLUTION("12113000", "0.4.0.127.0.16.1.1.2.1", "Irrigation solution", "Irrigation solution", "Sp�ll�sung", "Solution pour irrigation", "Soluzione per irrigazione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Kit for radiopharmaceutical preparation</div>
	 * <div class="de">Kit f�r ein radioaktives Arzneimittel</div>
	 * <div class="fr">Trousse pour pr�paration radiopharmaceutique</div>
	 * <div class="it">Kit per preparazione radiofarmaceutica</div>
	 * <!-- @formatter:on -->
	 */
	KIT_FOR_RADIOPHARMACEUTICAL_PREPARATION("12107000", "0.4.0.127.0.16.1.1.2.1", "Kit for radiopharmaceutical preparation", "Kit for radiopharmaceutical preparation", "Kit f�r ein radioaktives Arzneimittel", "Trousse pour pr�paration radiopharmaceutique", "Kit per preparazione radiofarmaceutica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Laryngopharyngeal solution</div>
	 * <div class="de">L�sung zur Anwendung im Rachenraum und am Kehlkopf</div>
	 * <div class="fr">Solution laryngopharyng�e</div>
	 * <!-- @formatter:on -->
	 */
	LARYNGOPHARYNGEAL_SOLUTION("13016000", "0.4.0.127.0.16.1.1.2.1", "Laryngopharyngeal solution", "Laryngopharyngeal solution", "L�sung zur Anwendung im Rachenraum und am Kehlkopf", "Solution laryngopharyng�e", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Laryngopharyngeal spray, solution</div>
	 * <div class="de">Spray zur Anwendung im Rachenraum und am Kehlkopf, L�sung</div>
	 * <div class="fr">Solution pour pulv�risation laryngopharyng�e</div>
	 * <!-- @formatter:on -->
	 */
	LARYNGOPHARYNGEAL_SPRAY_SOLUTION("13017000", "0.4.0.127.0.16.1.1.2.1", "Laryngopharyngeal spray, solution", "Laryngopharyngeal spray, solution", "Spray zur Anwendung im Rachenraum und am Kehlkopf, L�sung", "Solution pour pulv�risation laryngopharyng�e", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Living tissue equivalent</div>
	 * <div class="de">lebendes Gewebe�quivalent</div>
	 * <div class="fr">Substitut de tissu vivant</div>
	 * <div class="it">Tessuto vivente da coltura di cellule</div>
	 * <!-- @formatter:on -->
	 */
	LIVING_TISSUE_EQUIVALENT("12118000", "0.4.0.127.0.16.1.1.2.1", "Living tissue equivalent", "Living tissue equivalent", "lebendes Gewebe�quivalent", "Substitut de tissu vivant", "Tessuto vivente da coltura di cellule"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Lozenge</div>
	 * <div class="de">Lutschtablette</div>
	 * <div class="fr">Pastille</div>
	 * <div class="it">Pastiglia</div>
	 * <!-- @formatter:on -->
	 */
	LOZENGE("10321000", "0.4.0.127.0.16.1.1.2.1", "Lozenge", "Lozenge", "Lutschtablette", "Pastille", "Pastiglia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Matrix for implantation matrix</div>
	 * <div class="de">Matrix f�r Matrix zur Implantation</div>
	 * <div class="fr">Matrice pour matrice pour implantation</div>
	 * <!-- @formatter:on -->
	 */
	MATRIX_FOR_IMPLANTATION_MATRIX("13018000", "0.4.0.127.0.16.1.1.2.1", "Matrix for implantation matrix", "Matrix for implantation matrix", "Matrix f�r Matrix zur Implantation", "Matrice pour matrice pour implantation", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Medicated chewing-gum</div>
	 * <div class="de">wirkstoffhaltiges Kaugummi</div>
	 * <div class="fr">Gomme � m�cher m�dicamenteuse</div>
	 * <div class="it">Gomma da masticare medicata</div>
	 * <!-- @formatter:on -->
	 */
	MEDICATED_CHEWING_GUM("10229000", "0.4.0.127.0.16.1.1.2.1", "Medicated chewing-gum", "Medicated chewing-gum", "wirkstoffhaltiges Kaugummi", "Gomme � m�cher m�dicamenteuse", "Gomma da masticare medicata"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Medicated nail lacquer</div>
	 * <div class="de">wirkstoffhaltiger Nagellack</div>
	 * <div class="fr">Vernis � ongles m�dicamenteux</div>
	 * <div class="it">Smalto medicato per unghie</div>
	 * <!-- @formatter:on -->
	 */
	MEDICATED_NAIL_LACQUER("10521000", "0.4.0.127.0.16.1.1.2.1", "Medicated nail lacquer", "Medicated nail lacquer", "wirkstoffhaltiger Nagellack", "Vernis � ongles m�dicamenteux", "Smalto medicato per unghie"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Medicated plaster</div>
	 * <div class="de">wirkstoffhaltiges Pflaster</div>
	 * <div class="fr">Empl�tre m�dicamenteux</div>
	 * <div class="it">Empiastro medicato</div>
	 * <!-- @formatter:on -->
	 */
	MEDICATED_PLASTER("10506000", "0.4.0.127.0.16.1.1.2.1", "Medicated plaster", "Medicated plaster", "wirkstoffhaltiges Pflaster", "Empl�tre m�dicamenteux", "Empiastro medicato"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Medicated sponge</div>
	 * <div class="de">wirkstoffhaltiges Schw�mmchen</div>
	 * <div class="fr">Eponge m�dicamenteuse</div>
	 * <div class="it">Spugna medicata</div>
	 * <!-- @formatter:on -->
	 */
	MEDICATED_SPONGE("12119000", "0.4.0.127.0.16.1.1.2.1", "Medicated sponge", "Medicated sponge", "wirkstoffhaltiges Schw�mmchen", "Eponge m�dicamenteuse", "Spugna medicata"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Medicated thread</div>
	 * <div class="de">wirkstoffhaltiger Faden</div>
	 * <div class="fr">Fils m�dicamenteux</div>
	 * <div class="it">Filo medicato</div>
	 * <!-- @formatter:on -->
	 */
	MEDICATED_THREAD("12130000", "0.4.0.127.0.16.1.1.2.1", "Medicated thread", "Medicated thread", "wirkstoffhaltiger Faden", "Fils m�dicamenteux", "Filo medicato"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Medicated vaginal tampon</div>
	 * <div class="de">Wirkstoffhaltiger Vaginaltampon</div>
	 * <div class="fr">Tampon vaginal m�dicamenteux</div>
	 * <div class="it">Tampone vaginale medicato</div>
	 * <!-- @formatter:on -->
	 */
	MEDICATED_VAGINAL_TAMPON("10914000", "0.4.0.127.0.16.1.1.2.1", "Medicated vaginal tampon", "Medicated vaginal tampon", "Wirkstoffhaltiger Vaginaltampon", "Tampon vaginal m�dicamenteux", "Tampone vaginale medicato"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Medicinal gas, compressed</div>
	 * <div class="de">Gas zur medizinischen Anwendung, druckverdichtet</div>
	 * <div class="fr">Gaz m�dicinal comprim�</div>
	 * <div class="it">Gas medicinale compresso</div>
	 * <!-- @formatter:on -->
	 */
	MEDICINAL_GAS_COMPRESSED("12301000", "0.4.0.127.0.16.1.1.2.1", "Medicinal gas, compressed", "Medicinal gas, compressed", "Gas zur medizinischen Anwendung, druckverdichtet", "Gaz m�dicinal comprim�", "Gas medicinale compresso"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Medicinal gas, cryogenic</div>
	 * <div class="de">Gas zur medizinischen Anwendung, k�lteverfl�ssigt</div>
	 * <div class="fr">Gaz m�dicinal cryog�nique</div>
	 * <div class="it">Gas medicinale criogenico</div>
	 * <!-- @formatter:on -->
	 */
	MEDICINAL_GAS_CRYOGENIC("12302000", "0.4.0.127.0.16.1.1.2.1", "Medicinal gas, cryogenic", "Medicinal gas, cryogenic", "Gas zur medizinischen Anwendung, k�lteverfl�ssigt", "Gaz m�dicinal cryog�nique", "Gas medicinale criogenico"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Medicinal gas, liquefied</div>
	 * <div class="de">Gas zur medizinischen Anwendung, verfl�ssigt</div>
	 * <div class="fr">Gaz m�dicinal liqu�fi�</div>
	 * <div class="it">Gas medicinale liquefatto</div>
	 * <!-- @formatter:on -->
	 */
	MEDICINAL_GAS_LIQUEFIED("12303000", "0.4.0.127.0.16.1.1.2.1", "Medicinal gas, liquefied", "Medicinal gas, liquefied", "Gas zur medizinischen Anwendung, verfl�ssigt", "Gaz m�dicinal liqu�fi�", "Gas medicinale liquefatto"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Modified-release capsule, hard</div>
	 * <div class="de">Hartkapsel mit ver�nderter Wirkstofffreisetzung</div>
	 * <div class="fr">G�lule � lib�ration modifi�e</div>
	 * <div class="it">Capsula rigida a rilascio modificato</div>
	 * <!-- @formatter:on -->
	 */
	MODIFIED_RELEASE_CAPSULE_HARD("10217000", "0.4.0.127.0.16.1.1.2.1", "Modified-release capsule, hard", "Modified-release capsule, hard", "Hartkapsel mit ver�nderter Wirkstofffreisetzung", "G�lule � lib�ration modifi�e", "Capsula rigida a rilascio modificato"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Modified-release capsule, soft</div>
	 * <div class="de">Weichkapsel mit ver�nderter Wirkstofffreisetzung</div>
	 * <div class="fr">Capsule molle � lib�ration modifi�e</div>
	 * <div class="it">Capsula molle a rilascio modificato</div>
	 * <!-- @formatter:on -->
	 */
	MODIFIED_RELEASE_CAPSULE_SOFT("10218000", "0.4.0.127.0.16.1.1.2.1", "Modified-release capsule, soft", "Modified-release capsule, soft", "Weichkapsel mit ver�nderter Wirkstofffreisetzung", "Capsule molle � lib�ration modifi�e", "Capsula molle a rilascio modificato"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Modified-release granules</div>
	 * <div class="de">Granulat mit ver�nderter Wirkstofffreisetzung</div>
	 * <div class="fr">Granul�s � lib�ration modifi�e</div>
	 * <div class="it">Granulato a rilascio modificato</div>
	 * <!-- @formatter:on -->
	 */
	MODIFIED_RELEASE_GRANULES("10208000", "0.4.0.127.0.16.1.1.2.1", "Modified-release granules", "Modified-release granules", "Granulat mit ver�nderter Wirkstofffreisetzung", "Granul�s � lib�ration modifi�e", "Granulato a rilascio modificato"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Modified-release granules for oral suspension</div>
	 * <div class="de">Granulat mit ver�nderter Wirkstofffreisetzung zur Herstellung einer Suspension zum Einnehmen</div>
	 * <div class="fr">Granul�s � lib�ration modifi�e pour suspension buvable</div>
	 * <!-- @formatter:on -->
	 */
	MODIFIED_RELEASE_GRANULES_FOR_ORAL_SUSPENSION("50036000", "0.4.0.127.0.16.1.1.2.1", "Modified-release granules for oral suspension", "Modified-release granules for oral suspension", "Granulat mit ver�nderter Wirkstofffreisetzung zur Herstellung einer Suspension zum Einnehmen", "Granul�s � lib�ration modifi�e pour suspension buvable", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Modified-release tablet</div>
	 * <div class="de">Tablette mit ver�nderter Wirkstofffreisetzung</div>
	 * <div class="fr">Comprim� � lib�ration modifi�e</div>
	 * <div class="it">Compressa a rilascio modificato</div>
	 * <!-- @formatter:on -->
	 */
	MODIFIED_RELEASE_TABLET("10227000", "0.4.0.127.0.16.1.1.2.1", "Modified-release tablet", "Modified-release tablet", "Tablette mit ver�nderter Wirkstofffreisetzung", "Comprim� � lib�ration modifi�e", "Compressa a rilascio modificato"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Mouthwash</div>
	 * <div class="de">Mundwasser</div>
	 * <div class="fr">Solution pour bain de bouche</div>
	 * <div class="it">Collutorio</div>
	 * <!-- @formatter:on -->
	 */
	MOUTHWASH("10310000", "0.4.0.127.0.16.1.1.2.1", "Mouthwash", "Mouthwash", "Mundwasser", "Solution pour bain de bouche", "Collutorio"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Mouthwash, powder for solution</div>
	 * <div class="de">Pulver zur Herstellung einer Mundsp�lung, L�sung</div>
	 * <div class="fr">Poudre pour solution pour bain de bouche</div>
	 * <!-- @formatter:on -->
	 */
	MOUTHWASH_POWDER_FOR_SOLUTION("50036050", "0.4.0.127.0.16.1.1.2.1", "Mouthwash, powder for solution", "Mouthwash, powder for solution", "Pulver zur Herstellung einer Mundsp�lung, L�sung", "Poudre pour solution pour bain de bouche", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Mouthwash, tablet for solution</div>
	 * <div class="de">Tablette zur Herstellung eines Mundwassers</div>
	 * <div class="fr">Comprim� pour solution pour bain de bouche</div>
	 * <div class="it">Compressa per soluzione per collutorio</div>
	 * <!-- @formatter:on -->
	 */
	MOUTHWASH_TABLET_FOR_SOLUTION("10311000", "0.4.0.127.0.16.1.1.2.1", "Mouthwash, tablet for solution", "Mouthwash, tablet for solution", "Tablette zur Herstellung eines Mundwassers", "Comprim� pour solution pour bain de bouche", "Compressa per soluzione per collutorio"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Muco-adhesive buccal tablet</div>
	 * <div class="de">mucoadh�sive Buccaltablette</div>
	 * <div class="fr">Comprim� buccogingival muco-adh�sif</div>
	 * <div class="it">Compressa buccale mucoadesiva</div>
	 * <!-- @formatter:on -->
	 */
	MUCO_ADHESIVE_BUCCAL_TABLET("10319000", "0.4.0.127.0.16.1.1.2.1", "Muco-adhesive buccal tablet", "Muco-adhesive buccal tablet", "mucoadh�sive Buccaltablette", "Comprim� buccogingival muco-adh�sif", "Compressa buccale mucoadesiva"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nasal cream</div>
	 * <div class="de">Nasencreme</div>
	 * <div class="fr">Cr�me nasale</div>
	 * <div class="it">Crema nasale</div>
	 * <!-- @formatter:on -->
	 */
	NASAL_CREAM("10801000", "0.4.0.127.0.16.1.1.2.1", "Nasal cream", "Nasal cream", "Nasencreme", "Cr�me nasale", "Crema nasale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nasal drops, emulsion</div>
	 * <div class="de">Nasentropfen, Emulsion</div>
	 * <div class="fr">Emulsion nasale en gouttes</div>
	 * <div class="it">Gocce nasali, emulsione</div>
	 * <!-- @formatter:on -->
	 */
	NASAL_DROPS_EMULSION("10806000", "0.4.0.127.0.16.1.1.2.1", "Nasal drops, emulsion", "Nasal drops, emulsion", "Nasentropfen, Emulsion", "Emulsion nasale en gouttes", "Gocce nasali, emulsione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nasal drops, powder for solution</div>
	 * <div class="de">Pulver zur Herstellung von Nasentropfen, L�sung</div>
	 * <div class="fr">Poudre pour solution nasale en gouttes</div>
	 * <!-- @formatter:on -->
	 */
	NASAL_DROPS_POWDER_FOR_SOLUTION("13020000", "0.4.0.127.0.16.1.1.2.1", "Nasal drops, powder for solution", "Nasal drops, powder for solution", "Pulver zur Herstellung von Nasentropfen, L�sung", "Poudre pour solution nasale en gouttes", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nasal drops, solution</div>
	 * <div class="de">Nasentropfen, L�sung</div>
	 * <div class="fr">Solution nasale en gouttes</div>
	 * <div class="it">Gocce nasali, soluzione</div>
	 * <!-- @formatter:on -->
	 */
	NASAL_DROPS_SOLUTION("10804000", "0.4.0.127.0.16.1.1.2.1", "Nasal drops, solution", "Nasal drops, solution", "Nasentropfen, L�sung", "Solution nasale en gouttes", "Gocce nasali, soluzione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nasal drops, suspension</div>
	 * <div class="de">Nasentropfen, Suspension</div>
	 * <div class="fr">Suspension nasale en gouttes</div>
	 * <div class="it">Gocce nasali, sospensione</div>
	 * <!-- @formatter:on -->
	 */
	NASAL_DROPS_SUSPENSION("10805000", "0.4.0.127.0.16.1.1.2.1", "Nasal drops, suspension", "Nasal drops, suspension", "Nasentropfen, Suspension", "Suspension nasale en gouttes", "Gocce nasali, sospensione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nasal gel</div>
	 * <div class="de">Nasengel</div>
	 * <div class="fr">Gel nasal</div>
	 * <div class="it">Gel nasale</div>
	 * <!-- @formatter:on -->
	 */
	NASAL_GEL("10802000", "0.4.0.127.0.16.1.1.2.1", "Nasal gel", "Nasal gel", "Nasengel", "Gel nasal", "Gel nasale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nasal ointment</div>
	 * <div class="de">Nasensalbe</div>
	 * <div class="fr">Pommade nasale</div>
	 * <div class="it">Unguento nasale</div>
	 * <!-- @formatter:on -->
	 */
	NASAL_OINTMENT("10803000", "0.4.0.127.0.16.1.1.2.1", "Nasal ointment", "Nasal ointment", "Nasensalbe", "Pommade nasale", "Unguento nasale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nasal/oromucosal solution</div>
	 * <div class="de">L�sung zur nasalen Anwendung/L�sung zur Anwendung in der Mundh�hle</div>
	 * <div class="fr">Solution nasale/buccale</div>
	 * <!-- @formatter:on -->
	 */
	NASAL_OROMUCOSAL_SOLUTION("50036500", "0.4.0.127.0.16.1.1.2.1", "Nasal/oromucosal solution", "Nasal/oromucosal solution", "L�sung zur nasalen Anwendung/L�sung zur Anwendung in der Mundh�hle", "Solution nasale/buccale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nasal/oromucosal spray, solution</div>
	 * <div class="de">Nasenspray und Spray zur Anwendung in der Mundh�hle, L�sung</div>
	 * <div class="fr">Solution pour pulv�risation nasale/ buccale</div>
	 * <!-- @formatter:on -->
	 */
	NASAL_OROMUCOSAL_SPRAY_SOLUTION("50036700", "0.4.0.127.0.16.1.1.2.1", "Nasal/oromucosal spray, solution", "Nasal/oromucosal spray, solution", "Nasenspray und Spray zur Anwendung in der Mundh�hle, L�sung", "Solution pour pulv�risation nasale/ buccale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nasal powder</div>
	 * <div class="de">Nasenpulver</div>
	 * <div class="fr">Poudre nasale</div>
	 * <div class="it">Polvere nasale</div>
	 * <!-- @formatter:on -->
	 */
	NASAL_POWDER("10807000", "0.4.0.127.0.16.1.1.2.1", "Nasal powder", "Nasal powder", "Nasenpulver", "Poudre nasale", "Polvere nasale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nasal spray, emulsion</div>
	 * <div class="de">Nasenspray, Emulsion</div>
	 * <div class="fr">Emulsion pour pulv�risation nasale</div>
	 * <div class="it">Spray nasale, emulsione</div>
	 * <!-- @formatter:on -->
	 */
	NASAL_SPRAY_EMULSION("10810000", "0.4.0.127.0.16.1.1.2.1", "Nasal spray, emulsion", "Nasal spray, emulsion", "Nasenspray, Emulsion", "Emulsion pour pulv�risation nasale", "Spray nasale, emulsione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nasal spray, powder for solution</div>
	 * <div class="de">Nasenspray, Pulver zur Herstellung einer L�sung</div>
	 * <div class="fr">Poudre pour solution pour pulv�risation nasale</div>
	 * <!-- @formatter:on -->
	 */
	NASAL_SPRAY_POWDER_FOR_SOLUTION("50037100", "0.4.0.127.0.16.1.1.2.1", "Nasal spray, powder for solution", "Nasal spray, powder for solution", "Nasenspray, Pulver zur Herstellung einer L�sung", "Poudre pour solution pour pulv�risation nasale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nasal spray, solution</div>
	 * <div class="de">Nasenspray, L�sung</div>
	 * <div class="fr">Solution pour pulv�risation nasale</div>
	 * <div class="it">Spray nasale, soluzione</div>
	 * <!-- @formatter:on -->
	 */
	NASAL_SPRAY_SOLUTION("10808000", "0.4.0.127.0.16.1.1.2.1", "Nasal spray, solution", "Nasal spray, solution", "Nasenspray, L�sung", "Solution pour pulv�risation nasale", "Spray nasale, soluzione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nasal spray, solution/oromucosal solution</div>
	 * <div class="de">Nasenspray, L�sung/L�sung zur Anwendung in der Mundh�hle</div>
	 * <div class="fr">Solution pour pulv�risation nasale/ solution buccale</div>
	 * <!-- @formatter:on -->
	 */
	NASAL_SPRAY_SOLUTION_OROMUCOSAL_SOLUTION("50037400", "0.4.0.127.0.16.1.1.2.1", "Nasal spray, solution/oromucosal solution", "Nasal spray, solution/oromucosal solution", "Nasenspray, L�sung/L�sung zur Anwendung in der Mundh�hle", "Solution pour pulv�risation nasale/ solution buccale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nasal spray, suspension</div>
	 * <div class="de">Nasenspray, Suspension</div>
	 * <div class="fr">Suspension pour pulv�risation nasale</div>
	 * <div class="it">Spray nasale, sospensione</div>
	 * <!-- @formatter:on -->
	 */
	NASAL_SPRAY_SUSPENSION("10809000", "0.4.0.127.0.16.1.1.2.1", "Nasal spray, suspension", "Nasal spray, suspension", "Nasenspray, Suspension", "Suspension pour pulv�risation nasale", "Spray nasale, sospensione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nasal stick</div>
	 * <div class="de">Nasenstift</div>
	 * <div class="fr">B�ton pour usage nasal</div>
	 * <div class="it">Bastoncino nasale</div>
	 * <!-- @formatter:on -->
	 */
	NASAL_STICK("10812000", "0.4.0.127.0.16.1.1.2.1", "Nasal stick", "Nasal stick", "Nasenstift", "B�ton pour usage nasal", "Bastoncino nasale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nasal wash</div>
	 * <div class="de">Nasensp�lung</div>
	 * <div class="fr">Solution pour lavage nasal</div>
	 * <div class="it">Lavaggio nasale</div>
	 * <!-- @formatter:on -->
	 */
	NASAL_WASH("10811000", "0.4.0.127.0.16.1.1.2.1", "Nasal wash", "Nasal wash", "Nasensp�lung", "Solution pour lavage nasal", "Lavaggio nasale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nebuliser emulsion</div>
	 * <div class="de">Emulsion f�r einen Vernebler</div>
	 * <div class="fr">Emulsion pour inhalation par n�buliseur</div>
	 * <div class="it">Emulsione per nebulizzatore</div>
	 * <!-- @formatter:on -->
	 */
	NEBULISER_EMULSION("11105000", "0.4.0.127.0.16.1.1.2.1", "Nebuliser emulsion", "Nebuliser emulsion", "Emulsion f�r einen Vernebler", "Emulsion pour inhalation par n�buliseur", "Emulsione per nebulizzatore"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nebuliser solution</div>
	 * <div class="de">L�sung f�r einen Vernebler</div>
	 * <div class="fr">Solution pour inhalation par n�buliseur</div>
	 * <div class="it">Soluzione per nebulizzatore</div>
	 * <!-- @formatter:on -->
	 */
	NEBULISER_SOLUTION("11101000", "0.4.0.127.0.16.1.1.2.1", "Nebuliser solution", "Nebuliser solution", "L�sung f�r einen Vernebler", "Solution pour inhalation par n�buliseur", "Soluzione per nebulizzatore"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nebuliser suspension</div>
	 * <div class="de">Suspension f�r einen Vernebler</div>
	 * <div class="fr">Suspension pour inhalation par n�buliseur</div>
	 * <div class="it">Sospensione per nebulizzatore</div>
	 * <!-- @formatter:on -->
	 */
	NEBULISER_SUSPENSION("11102000", "0.4.0.127.0.16.1.1.2.1", "Nebuliser suspension", "Nebuliser suspension", "Suspension f�r einen Vernebler", "Suspension pour inhalation par n�buliseur", "Sospensione per nebulizzatore"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ointment</div>
	 * <div class="de">Salbe</div>
	 * <div class="fr">Pommade</div>
	 * <div class="it">Unguento</div>
	 * <!-- @formatter:on -->
	 */
	OINTMENT("10504000", "0.4.0.127.0.16.1.1.2.1", "Ointment", "Ointment", "Salbe", "Pommade", "Unguento"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ophthalmic insert</div>
	 * <div class="de">Augeninsert</div>
	 * <div class="fr">Insert ophtalmique</div>
	 * <div class="it">Inserto oftalmico</div>
	 * <!-- @formatter:on -->
	 */
	OPHTHALMIC_INSERT("10612000", "0.4.0.127.0.16.1.1.2.1", "Ophthalmic insert", "Ophthalmic insert", "Augeninsert", "Insert ophtalmique", "Inserto oftalmico"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ophthalmic strip</div>
	 * <div class="de">Teststreifen zur Anwendung am Auge</div>
	 * <div class="fr">Bandelette ophtalmique</div>
	 * <div class="it">Striscia oftalmica</div>
	 * <!-- @formatter:on -->
	 */
	OPHTHALMIC_STRIP("10613000", "0.4.0.127.0.16.1.1.2.1", "Ophthalmic strip", "Ophthalmic strip", "Teststreifen zur Anwendung am Auge", "Bandelette ophtalmique", "Striscia oftalmica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oral drops, emulsion</div>
	 * <div class="de">Tropfen zum Einnehmen, Emulsion</div>
	 * <div class="fr">Emulsion buvable en gouttes</div>
	 * <div class="it">Gocce orali, emulsione</div>
	 * <!-- @formatter:on -->
	 */
	ORAL_DROPS_EMULSION("10103000", "0.4.0.127.0.16.1.1.2.1", "Oral drops, emulsion", "Oral drops, emulsion", "Tropfen zum Einnehmen, Emulsion", "Emulsion buvable en gouttes", "Gocce orali, emulsione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oral drops, granules for solution</div>
	 * <div class="de">Granulat zur Herstellung von Tropfen zum Einnehmen, L�sung</div>
	 * <div class="fr">Granul�s pour solution buvale en gouttes</div>
	 * <!-- @formatter:on -->
	 */
	ORAL_DROPS_GRANULES_FOR_SOLUTION("50037500", "0.4.0.127.0.16.1.1.2.1", "Oral drops, granules for solution", "Oral drops, granules for solution", "Granulat zur Herstellung von Tropfen zum Einnehmen, L�sung", "Granul�s pour solution buvale en gouttes", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oral drops, liquid</div>
	 * <div class="de">Tropfen zum Einnehmen, Fl�ssigkeit</div>
	 * <div class="fr">Liquide oral en gouttes</div>
	 * <!-- @formatter:on -->
	 */
	ORAL_DROPS_LIQUID("50037750", "0.4.0.127.0.16.1.1.2.1", "Oral drops, liquid", "Oral drops, liquid", "Tropfen zum Einnehmen, Fl�ssigkeit", "Liquide oral en gouttes", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oral drops, powder for suspension</div>
	 * <div class="de">Pulver zur Herstellung von Tropfen zum Einnehmen, Suspension</div>
	 * <div class="fr">Poudre pour suspension oral en gouttes</div>
	 * <div class="it">Gocce orali, polvere per sospensione</div>
	 * <!-- @formatter:on -->
	 */
	ORAL_DROPS_POWDER_FOR_SUSPENSION("50082000", "0.4.0.127.0.16.1.1.2.1", "Oral drops, powder for suspension", "Oral drops, powder for suspension", "Pulver zur Herstellung von Tropfen zum Einnehmen, Suspension", "Poudre pour suspension oral en gouttes", "Gocce orali, polvere per sospensione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oral drops, solution</div>
	 * <div class="de">Tropfen zum Einnehmen, L�sung</div>
	 * <div class="fr">Solution buvable en gouttes</div>
	 * <div class="it">Gocce orali, soluzione</div>
	 * <!-- @formatter:on -->
	 */
	ORAL_DROPS_SOLUTION("10101000", "0.4.0.127.0.16.1.1.2.1", "Oral drops, solution", "Oral drops, solution", "Tropfen zum Einnehmen, L�sung", "Solution buvable en gouttes", "Gocce orali, soluzione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oral drops, suspension</div>
	 * <div class="de">Tropfen zum Einnehmen, Suspension</div>
	 * <div class="fr">Suspension buvable en gouttes</div>
	 * <div class="it">Gocce orali, sospensione</div>
	 * <!-- @formatter:on -->
	 */
	ORAL_DROPS_SUSPENSION("10102000", "0.4.0.127.0.16.1.1.2.1", "Oral drops, suspension", "Oral drops, suspension", "Tropfen zum Einnehmen, Suspension", "Suspension buvable en gouttes", "Gocce orali, sospensione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oral emulsion</div>
	 * <div class="de">Emulsion zum Einnehmen</div>
	 * <div class="fr">Emulsion buvable</div>
	 * <div class="it">Emulsione orale</div>
	 * <!-- @formatter:on -->
	 */
	ORAL_EMULSION("10107000", "0.4.0.127.0.16.1.1.2.1", "Oral emulsion", "Oral emulsion", "Emulsion zum Einnehmen", "Emulsion buvable", "Emulsione orale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oral gel</div>
	 * <div class="de">Gel zum Einnehmen</div>
	 * <div class="fr">Gel oral</div>
	 * <div class="it">Gel orale</div>
	 * <!-- @formatter:on -->
	 */
	ORAL_GEL("10108000", "0.4.0.127.0.16.1.1.2.1", "Oral gel", "Oral gel", "Gel zum Einnehmen", "Gel oral", "Gel orale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oral gum</div>
	 * <div class="de">Lutschpastille</div>
	 * <div class="fr">Gomme orale</div>
	 * <div class="it">Pastiglia gommosa</div>
	 * <!-- @formatter:on -->
	 */
	ORAL_GUM("10230000", "0.4.0.127.0.16.1.1.2.1", "Oral gum", "Oral gum", "Lutschpastille", "Gomme orale", "Pastiglia gommosa"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oral herbal material</div>
	 * <div class="de">0</div>
	 * <div class="fr">0</div>
	 * <!-- @formatter:on -->
	 */
	ORAL_HERBAL_MATERIAL("13106000", "0.4.0.127.0.16.1.1.2.1", "Oral herbal material", "Oral herbal material", "0", "0", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oral liquid</div>
	 * <div class="de">Fl�ssigkeit zum Einnehmen</div>
	 * <div class="fr">Liquide oral</div>
	 * <div class="it">Liquido orale</div>
	 * <!-- @formatter:on -->
	 */
	ORAL_LIQUID("10104000", "0.4.0.127.0.16.1.1.2.1", "Oral liquid", "Oral liquid", "Fl�ssigkeit zum Einnehmen", "Liquide oral", "Liquido orale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oral lyophilisate</div>
	 * <div class="de">Lyophilisat zum Einnehmen</div>
	 * <div class="fr">Lyophilisat oral</div>
	 * <div class="it">Liofilizzato orale</div>
	 * <!-- @formatter:on -->
	 */
	ORAL_LYOPHILISATE("10224000", "0.4.0.127.0.16.1.1.2.1", "Oral lyophilisate", "Oral lyophilisate", "Lyophilisat zum Einnehmen", "Lyophilisat oral", "Liofilizzato orale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oral paste</div>
	 * <div class="de">Paste zum Einnehmen</div>
	 * <div class="fr">P�te orale</div>
	 * <div class="it">Pasta per uso orale</div>
	 * <!-- @formatter:on -->
	 */
	ORAL_PASTE("10109000", "0.4.0.127.0.16.1.1.2.1", "Oral paste", "Oral paste", "Paste zum Einnehmen", "P�te orale", "Pasta per uso orale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oral powder</div>
	 * <div class="de">Pulver zum Einnehmen</div>
	 * <div class="fr">Poudre orale</div>
	 * <div class="it">Polvere orale</div>
	 * <!-- @formatter:on -->
	 */
	ORAL_POWDER("10201000", "0.4.0.127.0.16.1.1.2.1", "Oral powder", "Oral powder", "Pulver zum Einnehmen", "Poudre orale", "Polvere orale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oral/rectal solution</div>
	 * <div class="de">L�sung zum Einnehmen/Rektall�sung</div>
	 * <div class="fr">Solution buvable/rectale</div>
	 * <!-- @formatter:on -->
	 */
	ORAL_RECTAL_SOLUTION("50037900", "0.4.0.127.0.16.1.1.2.1", "Oral/rectal solution", "Oral/rectal solution", "L�sung zum Einnehmen/Rektall�sung", "Solution buvable/rectale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oral/rectal suspension</div>
	 * <div class="de">Suspension zum Einnehmen/Rektalsuspension</div>
	 * <div class="fr">Suspension buvable/rectale</div>
	 * <!-- @formatter:on -->
	 */
	ORAL_RECTAL_SUSPENSION("50038000", "0.4.0.127.0.16.1.1.2.1", "Oral/rectal suspension", "Oral/rectal suspension", "Suspension zum Einnehmen/Rektalsuspension", "Suspension buvable/rectale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oral solution</div>
	 * <div class="de">L�sung zum Einnehmen</div>
	 * <div class="fr">Solution  buvable</div>
	 * <div class="it">Soluzione orale</div>
	 * <!-- @formatter:on -->
	 */
	ORAL_SOLUTION("10105000", "0.4.0.127.0.16.1.1.2.1", "Oral solution", "Oral solution", "L�sung zum Einnehmen", "Solution  buvable", "Soluzione orale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oral solution/concentrate for nebuliser solution</div>
	 * <div class="de">L�sung zum Einnehmen/ Konzentrat zur Herstellung einer L�sung f�r einen Vernebler</div>
	 * <div class="fr">Solution orale/solution � diluer pour inhalation par n�buliseur</div>
	 * <!-- @formatter:on -->
	 */
	ORAL_SOLUTION_CONCENTRATE_FOR_NEBULISER_SOLUTION("50038500", "0.4.0.127.0.16.1.1.2.1", "Oral solution/concentrate for nebuliser solution", "Oral solution/concentrate for nebuliser solution", "L�sung zum Einnehmen/ Konzentrat zur Herstellung einer L�sung f�r einen Vernebler", "Solution orale/solution � diluer pour inhalation par n�buliseur", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oral suspension</div>
	 * <div class="de">Suspension zum Einnehmen</div>
	 * <div class="fr">Suspension buvable</div>
	 * <div class="it">Sospensione orale</div>
	 * <!-- @formatter:on -->
	 */
	ORAL_SUSPENSION("10106000", "0.4.0.127.0.16.1.1.2.1", "Oral suspension", "Oral suspension", "Suspension zum Einnehmen", "Suspension buvable", "Sospensione orale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Orodispersible film</div>
	 * <div class="de">Schmelzfilm</div>
	 * <div class="fr">Film orodispersible</div>
	 * <!-- @formatter:on -->
	 */
	ORODISPERSIBLE_FILM("10236100", "0.4.0.127.0.16.1.1.2.1", "Orodispersible film", "Orodispersible film", "Schmelzfilm", "Film orodispersible", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Orodispersible tablet</div>
	 * <div class="de">Schmelztablette</div>
	 * <div class="fr">Comprim� orodispersible</div>
	 * <div class="it">Compressa orodispersibile</div>
	 * <!-- @formatter:on -->
	 */
	ORODISPERSIBLE_TABLET("10223000", "0.4.0.127.0.16.1.1.2.1", "Orodispersible tablet", "Orodispersible tablet", "Schmelztablette", "Comprim� orodispersible", "Compressa orodispersibile"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oromucosal capsule</div>
	 * <div class="de">Kapsel zur Anwendung in der Mundh�hle</div>
	 * <div class="fr">Capsule buccale</div>
	 * <div class="it">Capsula per mucosa orale</div>
	 * <!-- @formatter:on -->
	 */
	OROMUCOSAL_CAPSULE("10317000", "0.4.0.127.0.16.1.1.2.1", "Oromucosal capsule", "Oromucosal capsule", "Kapsel zur Anwendung in der Mundh�hle", "Capsule buccale", "Capsula per mucosa orale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oromucosal cream</div>
	 * <div class="de">Creme zur Anwendung in der Mundh�hle</div>
	 * <div class="fr">cr�me buccale</div>
	 * <div class="it">Crema per mucosa orale</div>
	 * <!-- @formatter:on -->
	 */
	OROMUCOSAL_CREAM("10314010", "0.4.0.127.0.16.1.1.2.1", "Oromucosal cream", "Oromucosal cream", "Creme zur Anwendung in der Mundh�hle", "cr�me buccale", "Crema per mucosa orale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oromucosal drops</div>
	 * <div class="de">Tropfen zur Anwendung in der Mundh�hle</div>
	 * <div class="fr">Solution buccale en gouttes</div>
	 * <div class="it">Gocce per mucosa orale</div>
	 * <!-- @formatter:on -->
	 */
	OROMUCOSAL_DROPS("10307000", "0.4.0.127.0.16.1.1.2.1", "Oromucosal drops", "Oromucosal drops", "Tropfen zur Anwendung in der Mundh�hle", "Solution buccale en gouttes", "Gocce per mucosa orale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oromucosal gel</div>
	 * <div class="de">Gel zur Anwendung in der Mundh�hle</div>
	 * <div class="fr">Gel buccal</div>
	 * <div class="it">Gel per mucosa orale</div>
	 * <!-- @formatter:on -->
	 */
	OROMUCOSAL_GEL("10313000", "0.4.0.127.0.16.1.1.2.1", "Oromucosal gel", "Oromucosal gel", "Gel zur Anwendung in der Mundh�hle", "Gel buccal", "Gel per mucosa orale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oromucosal/laryngopharyngeal solution</div>
	 * <div class="de">L�sung zur Anwendung in der Mundh�hle/im Rachenraum und am Kehlkopf</div>
	 * <div class="fr">Solution buccale/laryngopharyng�e</div>
	 * <!-- @formatter:on -->
	 */
	OROMUCOSAL_LARYNGOPHARYNGEAL_SOLUTION("50039500", "0.4.0.127.0.16.1.1.2.1", "Oromucosal/laryngopharyngeal solution", "Oromucosal/laryngopharyngeal solution", "L�sung zur Anwendung in der Mundh�hle/im Rachenraum und am Kehlkopf", "Solution buccale/laryngopharyng�e", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oromucosal/laryngopharyngeal solution/spray, solution</div>
	 * <div class="de">L�sung/Spray zur Anwendung in der Mundh�hle/im Rachenraum oder am Kehlkopf, L�sung</div>
	 * <div class="fr">Solution/ solution pour pulv�risation buccale/ laryngopharyng�e</div>
	 * <!-- @formatter:on -->
	 */
	OROMUCOSAL_LARYNGOPHARYNGEAL_SOLUTION_SPRAY_SOLUTION("50040500", "0.4.0.127.0.16.1.1.2.1", "Oromucosal/laryngopharyngeal solution/spray, solution", "Oromucosal/laryngopharyngeal solution/spray, solution", "L�sung/Spray zur Anwendung in der Mundh�hle/im Rachenraum oder am Kehlkopf, L�sung", "Solution/ solution pour pulv�risation buccale/ laryngopharyng�e", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oromucosal ointment</div>
	 * <div class="de">Salbe zur Anwendung in der Mundh�hle</div>
	 * <div class="fr">Pommade buccale</div>
	 * <!-- @formatter:on -->
	 */
	OROMUCOSAL_OINTMENT("10314005", "0.4.0.127.0.16.1.1.2.1", "Oromucosal ointment", "Oromucosal ointment", "Salbe zur Anwendung in der Mundh�hle", "Pommade buccale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oromucosal paste</div>
	 * <div class="de">Paste zur Anwendung in der Mundh�hle</div>
	 * <div class="fr">P�te buccale</div>
	 * <div class="it">Pasta per mucosa orale</div>
	 * <!-- @formatter:on -->
	 */
	OROMUCOSAL_PASTE("10314000", "0.4.0.127.0.16.1.1.2.1", "Oromucosal paste", "Oromucosal paste", "Paste zur Anwendung in der Mundh�hle", "P�te buccale", "Pasta per mucosa orale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oromucosal patch</div>
	 * <div class="de">Pflaster zur Anwendung in der Mundh�hle</div>
	 * <div class="fr">Patch buccal</div>
	 * <!-- @formatter:on -->
	 */
	OROMUCOSAL_PATCH("50039000", "0.4.0.127.0.16.1.1.2.1", "Oromucosal patch", "Oromucosal patch", "Pflaster zur Anwendung in der Mundh�hle", "Patch buccal", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oromucosal solution</div>
	 * <div class="de">L�sung zur Anwendung in der Mundh�hle</div>
	 * <div class="fr">Solution buccale</div>
	 * <div class="it">Soluzione per mucosa orale</div>
	 * <!-- @formatter:on -->
	 */
	OROMUCOSAL_SOLUTION("10305000", "0.4.0.127.0.16.1.1.2.1", "Oromucosal solution", "Oromucosal solution", "L�sung zur Anwendung in der Mundh�hle", "Solution buccale", "Soluzione per mucosa orale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oromucosal spray, emulsion</div>
	 * <div class="de">Spray zur Anwendung in der Mundh�hle, Emulsion</div>
	 * <div class="fr">Emulsion pour pulv�risation buccale</div>
	 * <!-- @formatter:on -->
	 */
	OROMUCOSAL_SPRAY_EMULSION("10308100", "0.4.0.127.0.16.1.1.2.1", "Oromucosal spray, emulsion", "Oromucosal spray, emulsion", "Spray zur Anwendung in der Mundh�hle, Emulsion", "Emulsion pour pulv�risation buccale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oromucosal spray, solution</div>
	 * <div class="de">Spray zur Anwendung in der Mundh�hle, L�sung</div>
	 * <div class="fr">Solution pour pulv�risation buccale</div>
	 * <!-- @formatter:on -->
	 */
	OROMUCOSAL_SPRAY_SOLUTION("10308200", "0.4.0.127.0.16.1.1.2.1", "Oromucosal spray, solution", "Oromucosal spray, solution", "Spray zur Anwendung in der Mundh�hle, L�sung", "Solution pour pulv�risation buccale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oromucosal spray, suspension</div>
	 * <div class="de">Spray zur Anwendung in der Mundh�hle, Suspension</div>
	 * <div class="fr">Suspension pour pulv�risation buccale</div>
	 * <!-- @formatter:on -->
	 */
	OROMUCOSAL_SPRAY_SUSPENSION("10308300", "0.4.0.127.0.16.1.1.2.1", "Oromucosal spray, suspension", "Oromucosal spray, suspension", "Spray zur Anwendung in der Mundh�hle, Suspension", "Suspension pour pulv�risation buccale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oromucosal suspension</div>
	 * <div class="de">Suspension zur Anwendung in der Mundh�hle</div>
	 * <div class="fr">Suspension buccale</div>
	 * <div class="it">Sospensione per mucosa orale</div>
	 * <!-- @formatter:on -->
	 */
	OROMUCOSAL_SUSPENSION("10306000", "0.4.0.127.0.16.1.1.2.1", "Oromucosal suspension", "Oromucosal suspension", "Suspension zur Anwendung in der Mundh�hle", "Suspension buccale", "Sospensione per mucosa orale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pastille</div>
	 * <div class="de">Pastille</div>
	 * <div class="fr">P�te � sucer</div>
	 * <div class="it">Pastiglia molle</div>
	 * <!-- @formatter:on -->
	 */
	PASTILLE("10323000", "0.4.0.127.0.16.1.1.2.1", "Pastille", "Pastille", "Pastille", "P�te � sucer", "Pastiglia molle"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Periodontal gel</div>
	 * <div class="de">Gel zur periodontalen Anwendung</div>
	 * <div class="fr">Gel p�riodontal</div>
	 * <div class="it">Gel periodontale</div>
	 * <!-- @formatter:on -->
	 */
	PERIODONTAL_GEL("10410000", "0.4.0.127.0.16.1.1.2.1", "Periodontal gel", "Periodontal gel", "Gel zur periodontalen Anwendung", "Gel p�riodontal", "Gel periodontale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Periodontal insert</div>
	 * <div class="de">Insert zur periodontalen Anwendung</div>
	 * <div class="fr">Insert p�riodontal</div>
	 * <div class="it">Inserto periodontale</div>
	 * <!-- @formatter:on -->
	 */
	PERIODONTAL_INSERT("10411000", "0.4.0.127.0.16.1.1.2.1", "Periodontal insert", "Periodontal insert", "Insert zur periodontalen Anwendung", "Insert p�riodontal", "Inserto periodontale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Periodontal powder</div>
	 * <div class="de">Pulver zur periodontalen Anwendung</div>
	 * <div class="fr">Poudre p�ridontale</div>
	 * <div class="it">Polvere periodontale</div>
	 * <!-- @formatter:on -->
	 */
	PERIODONTAL_POWDER("10401000", "0.4.0.127.0.16.1.1.2.1", "Periodontal powder", "Periodontal powder", "Pulver zur periodontalen Anwendung", "Poudre p�ridontale", "Polvere periodontale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pessary</div>
	 * <div class="de">Vaginalz�pfchen</div>
	 * <div class="fr">Ovule</div>
	 * <div class="it">Ovulo</div>
	 * <!-- @formatter:on -->
	 */
	PESSARY("10909000", "0.4.0.127.0.16.1.1.2.1", "Pessary", "Pessary", "Vaginalz�pfchen", "Ovule", "Ovulo"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pillules</div>
	 * <div class="de">Streuk�gelchen</div>
	 * <div class="fr">Granules</div>
	 * <div class="it">Granuli</div>
	 * <!-- @formatter:on -->
	 */
	PILLULES("10231000", "0.4.0.127.0.16.1.1.2.1", "Pillules", "Pillules", "Streuk�gelchen", "Granules", "Granuli"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Plaster for provocation test</div>
	 * <div class="de">Pflaster f�r Provokationstest</div>
	 * <div class="fr">patch pour test �picutan�</div>
	 * <div class="it">Cerotto per saggio di provocazione</div>
	 * <!-- @formatter:on -->
	 */
	PLASTER_FOR_PROVOCATION_TEST("10550000", "0.4.0.127.0.16.1.1.2.1", "Plaster for provocation test", "Plaster for provocation test", "Pflaster f�r Provokationstest", "patch pour test �picutan�", "Cerotto per saggio di provocazione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pouch</div>
	 * <div class="de">Beutelchen</div>
	 * <!-- @formatter:on -->
	 */
	POUCH("30047500", "0.4.0.127.0.16.1.1.2.1", "Pouch", "Pouch", "Beutelchen", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Poultice</div>
	 * <div class="de">Umschlagpaste</div>
	 * <div class="fr">Cataplasme</div>
	 * <div class="it">Cataplasma</div>
	 * <!-- @formatter:on -->
	 */
	POULTICE("10522000", "0.4.0.127.0.16.1.1.2.1", "Poultice", "Poultice", "Umschlagpaste", "Cataplasme", "Cataplasma"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for bladder irrigation</div>
	 * <div class="de">Pulver zur Herstellung einer Blasensp�ll�sung</div>
	 * <div class="fr">Poudre pour solution pour irrigation v�sicale</div>
	 * <div class="it">Polvere per irrigazione vescicale</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_BLADDER_IRRIGATION("11503000", "0.4.0.127.0.16.1.1.2.1", "Powder for bladder irrigation", "Powder for bladder irrigation", "Pulver zur Herstellung einer Blasensp�ll�sung", "Poudre pour solution pour irrigation v�sicale", "Polvere per irrigazione vescicale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for concentrate for dispersion for infusion</div>
	 * <div class="de">Pulver f�r ein Konzentrat zur Herstellung einer Infusionsdispersion</div>
	 * <div class="fr">Poudre pour dispersion � diluer pour dispersion pour perfusion</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_CONCENTRATE_FOR_DISPERSION_FOR_INFUSION("50048750", "0.4.0.127.0.16.1.1.2.1", "Powder for concentrate for dispersion for infusion", "Powder for concentrate for dispersion for infusion", "Pulver f�r ein Konzentrat zur Herstellung einer Infusionsdispersion", "Poudre pour dispersion � diluer pour dispersion pour perfusion", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for concentrate for intravesical suspension</div>
	 * <div class="de">Pulver f�r ein Konzentrat zur Herstellung einer Suspension zur intravesikalen Anwendung</div>
	 * <div class="fr">Poudre pour suspension � diluer pour suspension intrav�sicale</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_CONCENTRATE_FOR_INTRAVESICAL_SUSPENSION("50049100", "0.4.0.127.0.16.1.1.2.1", "Powder for concentrate for intravesical suspension", "Powder for concentrate for intravesical suspension", "Pulver f�r ein Konzentrat zur Herstellung einer Suspension zur intravesikalen Anwendung", "Poudre pour suspension � diluer pour suspension intrav�sicale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for concentrate for solution for haemodialysis</div>
	 * <div class="de">Pulver f�r ein Konzentrat zur Herstellung einer H�modialysel�sung</div>
	 * <div class="fr">Poudre pour solution � diluer pour solution pour h�modialyse</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_CONCENTRATE_FOR_SOLUTION_FOR_HAEMODIALYSIS("50049200", "0.4.0.127.0.16.1.1.2.1", "Powder for concentrate for solution for haemodialysis", "Powder for concentrate for solution for haemodialysis", "Pulver f�r ein Konzentrat zur Herstellung einer H�modialysel�sung", "Poudre pour solution � diluer pour solution pour h�modialyse", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for concentrate for solution for infusion</div>
	 * <div class="de">Pulver f�r ein Konzentrat zur Herstellung einer Infusionsl�sung</div>
	 * <div class="fr">Poudre pour solution � diluer pour perfusion</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_CONCENTRATE_FOR_SOLUTION_FOR_INFUSION("50043000", "0.4.0.127.0.16.1.1.2.1", "Powder for concentrate for solution for infusion", "Powder for concentrate for solution for infusion", "Pulver f�r ein Konzentrat zur Herstellung einer Infusionsl�sung", "Poudre pour solution � diluer pour perfusion", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for concentrate for solution for injection/infusion</div>
	 * <div class="de">Pulver f�r ein Konzentrat zur Herstellung einer Injektions-/Infusionsl�sung</div>
	 * <div class="fr">Poudre pour solution � diluer pour solution injectable/pour perfusion</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_CONCENTRATE_FOR_SOLUTION_FOR_INJECTION_INFUSION("50049250", "0.4.0.127.0.16.1.1.2.1", "Powder for concentrate for solution for injection/infusion", "Powder for concentrate for solution for injection/infusion", "Pulver f�r ein Konzentrat zur Herstellung einer Injektions-/Infusionsl�sung", "Poudre pour solution � diluer pour solution injectable/pour perfusion", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for cutaneous solution</div>
	 * <div class="de">Pulver zur Herstellung einer L�sung zur Anwendung auf der Haut</div>
	 * <div class="fr">Poudre pour solution cutan�e</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_CUTANEOUS_SOLUTION("10514500", "0.4.0.127.0.16.1.1.2.1", "Powder for cutaneous solution", "Powder for cutaneous solution", "Pulver zur Herstellung einer L�sung zur Anwendung auf der Haut", "Poudre pour solution cutan�e", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for dental cement</div>
	 * <div class="de">Pulver zur Herstellung eines Dentalzements</div>
	 * <div class="fr">Poudre pour ciment dentaire</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_DENTAL_CEMENT("10413000", "0.4.0.127.0.16.1.1.2.1", "Powder for dental cement", "Powder for dental cement", "Pulver zur Herstellung eines Dentalzements", "Poudre pour ciment dentaire", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for dental gel</div>
	 * <div class="de">Pulver zur Herstellung eines Dentalgels</div>
	 * <div class="fr">Poudre pour gel dentaire</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_DENTAL_GEL("13022000", "0.4.0.127.0.16.1.1.2.1", "Powder for dental gel", "Powder for dental gel", "Pulver zur Herstellung eines Dentalgels", "Poudre pour gel dentaire", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for dental solution</div>
	 * <div class="de">Pulver zur Herstellung einer Dentall�sung</div>
	 * <div class="fr">Poudre pour solution dentaire</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_DENTAL_SOLUTION("50049270", "0.4.0.127.0.16.1.1.2.1", "Powder for dental solution", "Powder for dental solution", "Pulver zur Herstellung einer Dentall�sung", "Poudre pour solution dentaire", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for dispersion for infusion</div>
	 * <div class="de">Pulver zur Herstellung einer Infusionsdispersion</div>
	 * <div class="fr">Poudre pour dispersion pour perfusion</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_DISPERSION_FOR_INFUSION("11211500", "0.4.0.127.0.16.1.1.2.1", "Powder for dispersion for infusion", "Powder for dispersion for infusion", "Pulver zur Herstellung einer Infusionsdispersion", "Poudre pour dispersion pour perfusion", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for dispersion for injection</div>
	 * <div class="de">Pulver zur Herstellung einer Injektionsdispersion</div>
	 * <div class="fr">Poudre pour dispersion injectable</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_DISPERSION_FOR_INJECTION("13023000", "0.4.0.127.0.16.1.1.2.1", "Powder for dispersion for injection", "Powder for dispersion for injection", "Pulver zur Herstellung einer Injektionsdispersion", "Poudre pour dispersion injectable", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for emulsion for injection</div>
	 * <div class="de">Pulver zur Herstellung einer Emulsion zur Injektion</div>
	 * <div class="fr">Poudre pour �mulsion injectable</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_EMULSION_FOR_INJECTION("13040000", "0.4.0.127.0.16.1.1.2.1", "Powder for emulsion for injection", "Powder for emulsion for injection", "Pulver zur Herstellung einer Emulsion zur Injektion", "Poudre pour �mulsion injectable", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for endocervical gel</div>
	 * <div class="de">Pulver zur Herstellung eines Gels zur endozervikalen Anwendung</div>
	 * <div class="fr">Poudre pour gel endocervical</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_ENDOCERVICAL_GEL("13024000", "0.4.0.127.0.16.1.1.2.1", "Powder for endocervical gel", "Powder for endocervical gel", "Pulver zur Herstellung eines Gels zur endozervikalen Anwendung", "Poudre pour gel endocervical", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for endosinusial solution</div>
	 * <div class="de">Pulver zur Herstellung einer L�sung zur Anwendung in den Nasennebenh�hlen</div>
	 * <div class="fr">Poudre pour solution endosinusale</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_ENDOSINUSIAL_SOLUTION("13025000", "0.4.0.127.0.16.1.1.2.1", "Powder for endosinusial solution", "Powder for endosinusial solution", "Pulver zur Herstellung einer L�sung zur Anwendung in den Nasennebenh�hlen", "Poudre pour solution endosinusale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for epilesional solution</div>
	 * <div class="de">Pulver zur Herstellung einer L�sung zum Auftragen auf die Wunde</div>
	 * <div class="fr">Poudre pour solution �pil�sionnelle</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_EPILESIONAL_SOLUTION("50049300", "0.4.0.127.0.16.1.1.2.1", "Powder for epilesional solution", "Powder for epilesional solution", "Pulver zur Herstellung einer L�sung zum Auftragen auf die Wunde", "Poudre pour solution �pil�sionnelle", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for gel</div>
	 * <div class="de">Pulver zur Herstellung eines Gels</div>
	 * <div class="fr">Poudre pour gel</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_GEL("13021000", "0.4.0.127.0.16.1.1.2.1", "Powder for gel", "Powder for gel", "Pulver zur Herstellung eines Gels", "Poudre pour gel", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for gingival gel</div>
	 * <div class="de">Pulver zur Herstellung eines Gels zur Anwendung am Zahnfleisch</div>
	 * <div class="fr">Poudre pour gel gingival</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_GINGIVAL_GEL("13026000", "0.4.0.127.0.16.1.1.2.1", "Powder for gingival gel", "Powder for gingival gel", "Pulver zur Herstellung eines Gels zur Anwendung am Zahnfleisch", "Poudre pour gel gingival", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for implantation matrix</div>
	 * <div class="de">Pulver f�r Matrix zur Implantation</div>
	 * <div class="fr">Poudre pour matrice pour implantation</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_IMPLANTATION_MATRIX("13027000", "0.4.0.127.0.16.1.1.2.1", "Powder for implantation matrix", "Powder for implantation matrix", "Pulver f�r Matrix zur Implantation", "Poudre pour matrice pour implantation", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for implantation paste</div>
	 * <div class="de">Pulver zur Herstellung einer Paste f�r ein Implantat</div>
	 * <div class="fr">Poudre pour p�te pour implantation</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_IMPLANTATION_PASTE("13028000", "0.4.0.127.0.16.1.1.2.1", "Powder for implantation paste", "Powder for implantation paste", "Pulver zur Herstellung einer Paste f�r ein Implantat", "Poudre pour p�te pour implantation", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for implantation suspension</div>
	 * <div class="de">Pulver zur Herstellung einer Suspension zur Implantation</div>
	 * <div class="fr">Poudre pour suspension pour implantation</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_IMPLANTATION_SUSPENSION("50049500", "0.4.0.127.0.16.1.1.2.1", "Powder for implantation suspension", "Powder for implantation suspension", "Pulver zur Herstellung einer Suspension zur Implantation", "Poudre pour suspension pour implantation", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for intraocular instillation solution</div>
	 * <div class="de">Pulver zur Herstellung einer Instillationsl�sung zur intraokularen Anwendung</div>
	 * <div class="fr">Poudre pour solution pour instillation intraoculaire</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_INTRAOCULAR_INSTILLATION_SOLUTION("13029000", "0.4.0.127.0.16.1.1.2.1", "Powder for intraocular instillation solution", "Powder for intraocular instillation solution", "Pulver zur Herstellung einer Instillationsl�sung zur intraokularen Anwendung", "Poudre pour solution pour instillation intraoculaire", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for intravesical solution</div>
	 * <div class="de">Pulver zur Herstellung einer L�sung zur intravesikalen Anwendung</div>
	 * <div class="fr">Poudre pour solution intrav�sicale</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_INTRAVESICAL_SOLUTION("50050000", "0.4.0.127.0.16.1.1.2.1", "Powder for intravesical solution", "Powder for intravesical solution", "Pulver zur Herstellung einer L�sung zur intravesikalen Anwendung", "Poudre pour solution intrav�sicale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for intravesical solution/solution for injection</div>
	 * <div class="de">Pulver zur Herstellung einer L�sung zur intravesikalen Anwendung / Injektionsl�sung</div>
	 * <div class="fr">Poudre pour solution intrav�sicale/injectable</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_INTRAVESICAL_SOLUTION_SOLUTION_FOR_INJECTION("50050500", "0.4.0.127.0.16.1.1.2.1", "Powder for intravesical solution/solution for injection", "Powder for intravesical solution/solution for injection", "Pulver zur Herstellung einer L�sung zur intravesikalen Anwendung / Injektionsl�sung", "Poudre pour solution intrav�sicale/injectable", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for intravesical suspension</div>
	 * <div class="de">Pulver zur Herstellung einer Suspensionen zur intravesikalen Anwendung</div>
	 * <div class="fr">Poudre pour suspension intrav�sicale</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_INTRAVESICAL_SUSPENSION("50051000", "0.4.0.127.0.16.1.1.2.1", "Powder for intravesical suspension", "Powder for intravesical suspension", "Pulver zur Herstellung einer Suspensionen zur intravesikalen Anwendung", "Poudre pour suspension intrav�sicale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for nebuliser solution</div>
	 * <div class="de">Pulver zur Herstellung einer L�sung f�r einen Vernebler</div>
	 * <div class="fr">Poudre pour solution pour inhalation par n�buliseur</div>
	 * <div class="it">Polvere per soluzione per nebulizzatore</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_NEBULISER_SOLUTION("11104000", "0.4.0.127.0.16.1.1.2.1", "Powder for nebuliser solution", "Powder for nebuliser solution", "Pulver zur Herstellung einer L�sung f�r einen Vernebler", "Poudre pour solution pour inhalation par n�buliseur", "Polvere per soluzione per nebulizzatore"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for nebuliser suspension</div>
	 * <div class="de">Pulver zur Herstellung einer Suspension f�r einen Vernebler</div>
	 * <div class="fr">Poudre pour suspension pour inhalation par n�buliseur</div>
	 * <div class="it">Polvere per sospensione per nebulizzatore</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_NEBULISER_SUSPENSION("11103000", "0.4.0.127.0.16.1.1.2.1", "Powder for nebuliser suspension", "Powder for nebuliser suspension", "Pulver zur Herstellung einer Suspension f�r einen Vernebler", "Poudre pour suspension pour inhalation par n�buliseur", "Polvere per sospensione per nebulizzatore"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for oral/rectal suspension</div>
	 * <div class="de">Pulver zur Herstellung einer Suspension zum Einnehmen/Rektalsuspension</div>
	 * <div class="fr">Poudre pour suspension oral/rectal</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_ORAL_RECTAL_SUSPENSION("50052000", "0.4.0.127.0.16.1.1.2.1", "Powder for oral/rectal suspension", "Powder for oral/rectal suspension", "Pulver zur Herstellung einer Suspension zum Einnehmen/Rektalsuspension", "Poudre pour suspension oral/rectal", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for oral solution</div>
	 * <div class="de">Pulver zur Herstellung einer L�sung zum Einnehmen</div>
	 * <div class="fr">Poudre pour solution buvable</div>
	 * <div class="it">Polvere per soluzione orale</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_ORAL_SOLUTION("10110000", "0.4.0.127.0.16.1.1.2.1", "Powder for oral solution", "Powder for oral solution", "Pulver zur Herstellung einer L�sung zum Einnehmen", "Poudre pour solution buvable", "Polvere per soluzione orale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for oral suspension</div>
	 * <div class="de">Pulver zur Herstellung einer Suspension zum Einnehmen</div>
	 * <div class="fr">Poudre pour suspension buvable</div>
	 * <div class="it">Polvere per sospensione orale</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_ORAL_SUSPENSION("10111000", "0.4.0.127.0.16.1.1.2.1", "Powder for oral suspension", "Powder for oral suspension", "Pulver zur Herstellung einer Suspension zum Einnehmen", "Poudre pour suspension buvable", "Polvere per sospensione orale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for prolonged-release suspension for injection</div>
	 * <div class="de">Pulver zur Herstellung einer Depot-Injektionssuspension</div>
	 * <div class="fr">Poudre pour suspension injectable � lib�ration prolong�e</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_PROLONGED_RELEASE_SUSPENSION_FOR_INJECTION("11208400", "0.4.0.127.0.16.1.1.2.1", "Powder for prolonged-release suspension for injection", "Powder for prolonged-release suspension for injection", "Pulver zur Herstellung einer Depot-Injektionssuspension", "Poudre pour suspension injectable � lib�ration prolong�e", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for rectal solution</div>
	 * <div class="de">Pulver zur Herstellung einer Rektall�sung</div>
	 * <div class="fr">Poudre pour solution rectale</div>
	 * <div class="it">Polvere per soluzione rettale</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_RECTAL_SOLUTION("11009000", "0.4.0.127.0.16.1.1.2.1", "Powder for rectal solution", "Powder for rectal solution", "Pulver zur Herstellung einer Rektall�sung", "Poudre pour solution rectale", "Polvere per soluzione rettale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for rectal suspension</div>
	 * <div class="de">Pulver zur Herstellung einer Rektalsuspension</div>
	 * <div class="fr">Poudre pour suspension rectale</div>
	 * <div class="it">Polvere per sospensione rettale</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_RECTAL_SUSPENSION("11010000", "0.4.0.127.0.16.1.1.2.1", "Powder for rectal suspension", "Powder for rectal suspension", "Pulver zur Herstellung einer Rektalsuspension", "Poudre pour suspension rectale", "Polvere per sospensione rettale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for sealant</div>
	 * <div class="de">Pulver f�r einen Gewebekleber</div>
	 * <div class="fr">Poudre pour colle</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_SEALANT("13031000", "0.4.0.127.0.16.1.1.2.1", "Powder for sealant", "Powder for sealant", "Pulver f�r einen Gewebekleber", "Poudre pour colle", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for solution for infusion</div>
	 * <div class="de">Pulver zur Herstellung einer Infusionsl�sung</div>
	 * <div class="fr">Poudre pour solution pour perfusion</div>
	 * <div class="it">Polvere per soluzione per infusione</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_SOLUTION_FOR_INFUSION("11212000", "0.4.0.127.0.16.1.1.2.1", "Powder for solution for infusion", "Powder for solution for infusion", "Pulver zur Herstellung einer Infusionsl�sung", "Poudre pour solution pour perfusion", "Polvere per soluzione per infusione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for solution for injection</div>
	 * <div class="de">Pulver zur Herstellung einer Injektionsl�sung</div>
	 * <div class="fr">Poudre pour solution injectable</div>
	 * <div class="it">Polvere per soluzione iniettabile</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_SOLUTION_FOR_INJECTION("11205000", "0.4.0.127.0.16.1.1.2.1", "Powder for solution for injection", "Powder for solution for injection", "Pulver zur Herstellung einer Injektionsl�sung", "Poudre pour solution injectable", "Polvere per soluzione iniettabile"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for solution for injection/infusion</div>
	 * <div class="de">Pulver zur Herstellung einer Injektions-/Infusionsl�sung</div>
	 * <div class="fr">Poudre pour solution injectable/pour perfusion</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_SOLUTION_FOR_INJECTION_INFUSION("50053500", "0.4.0.127.0.16.1.1.2.1", "Powder for solution for injection/infusion", "Powder for solution for injection/infusion", "Pulver zur Herstellung einer Injektions-/Infusionsl�sung", "Poudre pour solution injectable/pour perfusion", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for solution for injection/skin-prick test</div>
	 * <div class="de">Pulver zur Herstellung einer Injektionsl�sung/Pricktestl�sung</div>
	 * <div class="fr">Poudre pour solution injectable/ pour prick-test</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_SOLUTION_FOR_INJECTION_SKIN_PRICK_TEST("13052000", "0.4.0.127.0.16.1.1.2.1", "Powder for solution for injection/skin-prick test", "Powder for solution for injection/skin-prick test", "Pulver zur Herstellung einer Injektionsl�sung/Pricktestl�sung", "Poudre pour solution injectable/ pour prick-test", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for solution for intraocular irrigation</div>
	 * <div class="de">Pulver zur Herstellung einer L�sung zur intraokularen Anwendung</div>
	 * <div class="fr">Poudre pour solution pour irrigation intraoculaire</div>
	 * <div class="it">Polvere per soluzione per irrigazione intraoculare</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_SOLUTION_FOR_INTRAOCULAR_IRRIGATION("50073000", "0.4.0.127.0.16.1.1.2.1", "Powder for solution for intraocular irrigation", "Powder for solution for intraocular irrigation", "Pulver zur Herstellung einer L�sung zur intraokularen Anwendung", "Poudre pour solution pour irrigation intraoculaire", "Polvere per soluzione per irrigazione intraoculare"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for solution for iontophoresis</div>
	 * <div class="de">Pulver zur Herstellung einer L�sung zur Iontophorese</div>
	 * <div class="fr">Poudre pour solution pour iontoph�r�se</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_SOLUTION_FOR_IONTOPHORESIS("10518500", "0.4.0.127.0.16.1.1.2.1", "Powder for solution for iontophoresis", "Powder for solution for iontophoresis", "Pulver zur Herstellung einer L�sung zur Iontophorese", "Poudre pour solution pour iontoph�r�se", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for solution for skin-prick test</div>
	 * <div class="de">Pulver zur Herstellung einer Pricktestl�sung</div>
	 * <div class="fr">Poudre pour solution pour prick-test</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_SOLUTION_FOR_SKIN_PRICK_TEST("13032000", "0.4.0.127.0.16.1.1.2.1", "Powder for solution for skin-prick test", "Powder for solution for skin-prick test", "Pulver zur Herstellung einer Pricktestl�sung", "Poudre pour solution pour prick-test", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for suspension for injection</div>
	 * <div class="de">Pulver zur Herstellung einer Injektionssuspension</div>
	 * <div class="fr">Poudre pour suspension injectable</div>
	 * <div class="it">Polvere per sospensione iniettabile</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_SUSPENSION_FOR_INJECTION("11206000", "0.4.0.127.0.16.1.1.2.1", "Powder for suspension for injection", "Powder for suspension for injection", "Pulver zur Herstellung einer Injektionssuspension", "Poudre pour suspension injectable", "Polvere per sospensione iniettabile"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Powder for syrup</div>
	 * <div class="de">Pulver zur Herstellung eines Sirups</div>
	 * <div class="fr">Poudre pour sirop</div>
	 * <div class="it">Polvere per sciroppo</div>
	 * <!-- @formatter:on -->
	 */
	POWDER_FOR_SYRUP("10118000", "0.4.0.127.0.16.1.1.2.1", "Powder for syrup", "Powder for syrup", "Pulver zur Herstellung eines Sirups", "Poudre pour sirop", "Polvere per sciroppo"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pressurised inhalation, emulsion</div>
	 * <div class="de">Druckgasinhalation, Emulsion</div>
	 * <div class="fr">Emulsion pour inhalation en flacon pressuris�</div>
	 * <div class="it">Emulsione pressurizzata per inalazione</div>
	 * <!-- @formatter:on -->
	 */
	PRESSURISED_INHALATION_EMULSION("11108000", "0.4.0.127.0.16.1.1.2.1", "Pressurised inhalation, emulsion", "Pressurised inhalation, emulsion", "Druckgasinhalation, Emulsion", "Emulsion pour inhalation en flacon pressuris�", "Emulsione pressurizzata per inalazione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pressurised inhalation, solution</div>
	 * <div class="de">Druckgasinhalation, L�sung</div>
	 * <div class="fr">Solution pour inhalation en flacon pressuris�</div>
	 * <div class="it">Soluzione pressurizzata per inalazione</div>
	 * <!-- @formatter:on -->
	 */
	PRESSURISED_INHALATION_SOLUTION("11106000", "0.4.0.127.0.16.1.1.2.1", "Pressurised inhalation, solution", "Pressurised inhalation, solution", "Druckgasinhalation, L�sung", "Solution pour inhalation en flacon pressuris�", "Soluzione pressurizzata per inalazione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pressurised inhalation, suspension</div>
	 * <div class="de">Druckgasinhalation, Suspension</div>
	 * <div class="fr">Suspension pour inhalation en flacon pressuris�</div>
	 * <div class="it">Sospensione pressurizzata per inalazione</div>
	 * <!-- @formatter:on -->
	 */
	PRESSURISED_INHALATION_SUSPENSION("11107000", "0.4.0.127.0.16.1.1.2.1", "Pressurised inhalation, suspension", "Pressurised inhalation, suspension", "Druckgasinhalation, Suspension", "Suspension pour inhalation en flacon pressuris�", "Sospensione pressurizzata per inalazione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Prolonged-release capsule, hard</div>
	 * <div class="de">Hartkapsel, retardiert</div>
	 * <div class="fr">G�lule � lib�ration prolong�e</div>
	 * <div class="it">Capsula rigida a rilascio prolungato</div>
	 * <!-- @formatter:on -->
	 */
	PROLONGED_RELEASE_CAPSULE_HARD("10215000", "0.4.0.127.0.16.1.1.2.1", "Prolonged-release capsule, hard", "Prolonged-release capsule, hard", "Hartkapsel, retardiert", "G�lule � lib�ration prolong�e", "Capsula rigida a rilascio prolungato"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Prolonged-release capsule, soft</div>
	 * <div class="de">Weichkapsel, retardiert</div>
	 * <div class="fr">Capsule molle � lib�ration prolong�e</div>
	 * <div class="it">Capsula molle a rilascio prolungato</div>
	 * <!-- @formatter:on -->
	 */
	PROLONGED_RELEASE_CAPSULE_SOFT("10216000", "0.4.0.127.0.16.1.1.2.1", "Prolonged-release capsule, soft", "Prolonged-release capsule, soft", "Weichkapsel, retardiert", "Capsule molle � lib�ration prolong�e", "Capsula molle a rilascio prolungato"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Prolonged-release granules</div>
	 * <div class="de">Retardgranulat</div>
	 * <div class="fr">Granul�s � lib�ration prolong�e</div>
	 * <div class="it">Granulato a rilascio prolungato</div>
	 * <!-- @formatter:on -->
	 */
	PROLONGED_RELEASE_GRANULES("10207000", "0.4.0.127.0.16.1.1.2.1", "Prolonged-release granules", "Prolonged-release granules", "Retardgranulat", "Granul�s � lib�ration prolong�e", "Granulato a rilascio prolungato"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Prolonged-release granules for oral suspension</div>
	 * <div class="de">Retardgranulat zur Herstellung einer Suspension zum Einnehmen</div>
	 * <div class="fr">Granul�s � lib�ration prolong�e pour suspension buvable</div>
	 * <!-- @formatter:on -->
	 */
	PROLONGED_RELEASE_GRANULES_FOR_ORAL_SUSPENSION("50056000", "0.4.0.127.0.16.1.1.2.1", "Prolonged-release granules for oral suspension", "Prolonged-release granules for oral suspension", "Retardgranulat zur Herstellung einer Suspension zum Einnehmen", "Granul�s � lib�ration prolong�e pour suspension buvable", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Prolonged-release solution for injection</div>
	 * <div class="de">0</div>
	 * <div class="fr">Solution injectable � lib�ration prolong�e</div>
	 * <!-- @formatter:on -->
	 */
	PROLONGED_RELEASE_SOLUTION_FOR_INJECTION("13076000", "0.4.0.127.0.16.1.1.2.1", "Prolonged-release solution for injection", "Prolonged-release solution for injection", "0", "Solution injectable � lib�ration prolong�e", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Prolonged-release suspension for injection</div>
	 * <div class="de">Depot-Injektionssuspension</div>
	 * <div class="fr">Suspension injectable � lib�ration prolong�e</div>
	 * <!-- @formatter:on -->
	 */
	PROLONGED_RELEASE_SUSPENSION_FOR_INJECTION("11208500", "0.4.0.127.0.16.1.1.2.1", "Prolonged-release suspension for injection", "Prolonged-release suspension for injection", "Depot-Injektionssuspension", "Suspension injectable � lib�ration prolong�e", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Prolonged-release tablet</div>
	 * <div class="de">Retardtablette</div>
	 * <div class="fr">Comprim� � lib�ration prolong�e</div>
	 * <div class="it">Compressa a rilascio prolungato</div>
	 * <!-- @formatter:on -->
	 */
	PROLONGED_RELEASE_TABLET("10226000", "0.4.0.127.0.16.1.1.2.1", "Prolonged-release tablet", "Prolonged-release tablet", "Retardtablette", "Comprim� � lib�ration prolong�e", "Compressa a rilascio prolungato"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Radionuclide generator</div>
	 * <div class="de">Radionuklidgenerator</div>
	 * <div class="fr">G�n�rateur radiopharmaceutique</div>
	 * <div class="it">Generatore di radionuclidi</div>
	 * <!-- @formatter:on -->
	 */
	RADIONUCLIDE_GENERATOR("12106000", "0.4.0.127.0.16.1.1.2.1", "Radionuclide generator", "Radionuclide generator", "Radionuklidgenerator", "G�n�rateur radiopharmaceutique", "Generatore di radionuclidi"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Radiopharmaceutical precursor</div>
	 * <div class="de">Markerzubereitung</div>
	 * <div class="fr">Pr�curseur radiopharmaceutique</div>
	 * <div class="it">Precursore radiofarmaceutico</div>
	 * <!-- @formatter:on -->
	 */
	RADIOPHARMACEUTICAL_PRECURSOR("12105000", "0.4.0.127.0.16.1.1.2.1", "Radiopharmaceutical precursor", "Radiopharmaceutical precursor", "Markerzubereitung", "Pr�curseur radiopharmaceutique", "Precursore radiofarmaceutico"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Radiopharmaceutical precursor, solution</div>
	 * <div class="de">Markerzubereitung, L�sung</div>
	 * <div class="fr">Solution de pr�curseur radiopharmaceutique</div>
	 * <!-- @formatter:on -->
	 */
	RADIOPHARMACEUTICAL_PRECURSOR_SOLUTION("50056500", "0.4.0.127.0.16.1.1.2.1", "Radiopharmaceutical precursor, solution", "Radiopharmaceutical precursor, solution", "Markerzubereitung, L�sung", "Solution de pr�curseur radiopharmaceutique", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rectal capsule</div>
	 * <div class="de">Rektalkapsel</div>
	 * <div class="fr">Capsule  rectale</div>
	 * <div class="it">Capsula rettale</div>
	 * <!-- @formatter:on -->
	 */
	RECTAL_CAPSULE("11014000", "0.4.0.127.0.16.1.1.2.1", "Rectal capsule", "Rectal capsule", "Rektalkapsel", "Capsule  rectale", "Capsula rettale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rectal cream</div>
	 * <div class="de">Rektalcreme</div>
	 * <div class="fr">Cr�me rectale</div>
	 * <div class="it">Crema rettale</div>
	 * <!-- @formatter:on -->
	 */
	RECTAL_CREAM("11001000", "0.4.0.127.0.16.1.1.2.1", "Rectal cream", "Rectal cream", "Rektalcreme", "Cr�me rectale", "Crema rettale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rectal emulsion</div>
	 * <div class="de">Rektalemulsion</div>
	 * <div class="fr">Emulsion rectale</div>
	 * <div class="it">Emulsione rettale</div>
	 * <!-- @formatter:on -->
	 */
	RECTAL_EMULSION("11007000", "0.4.0.127.0.16.1.1.2.1", "Rectal emulsion", "Rectal emulsion", "Rektalemulsion", "Emulsion rectale", "Emulsione rettale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rectal foam</div>
	 * <div class="de">Rektalschaum</div>
	 * <div class="fr">Mousse rectale</div>
	 * <div class="it">Schiuma rettale</div>
	 * <!-- @formatter:on -->
	 */
	RECTAL_FOAM("11004000", "0.4.0.127.0.16.1.1.2.1", "Rectal foam", "Rectal foam", "Rektalschaum", "Mousse rectale", "Schiuma rettale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rectal gel</div>
	 * <div class="de">Rektalgel</div>
	 * <div class="fr">Gel rectal</div>
	 * <div class="it">Gel rettale</div>
	 * <!-- @formatter:on -->
	 */
	RECTAL_GEL("11002000", "0.4.0.127.0.16.1.1.2.1", "Rectal gel", "Rectal gel", "Rektalgel", "Gel rectal", "Gel rettale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rectal ointment</div>
	 * <div class="de">Rektalsalbe</div>
	 * <div class="fr">Pommade rectale</div>
	 * <div class="it">Unguento rettale</div>
	 * <!-- @formatter:on -->
	 */
	RECTAL_OINTMENT("11003000", "0.4.0.127.0.16.1.1.2.1", "Rectal ointment", "Rectal ointment", "Rektalsalbe", "Pommade rectale", "Unguento rettale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rectal solution</div>
	 * <div class="de">Rektall�sung</div>
	 * <div class="fr">Solution rectale</div>
	 * <div class="it">Soluzione rettale</div>
	 * <!-- @formatter:on -->
	 */
	RECTAL_SOLUTION("11005000", "0.4.0.127.0.16.1.1.2.1", "Rectal solution", "Rectal solution", "Rektall�sung", "Solution rectale", "Soluzione rettale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rectal suspension</div>
	 * <div class="de">Rektalsuspension</div>
	 * <div class="fr">Suspension rectale</div>
	 * <div class="it">Sospensione rettale</div>
	 * <!-- @formatter:on -->
	 */
	RECTAL_SUSPENSION("11006000", "0.4.0.127.0.16.1.1.2.1", "Rectal suspension", "Rectal suspension", "Rektalsuspension", "Suspension rectale", "Sospensione rettale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rectal tampon</div>
	 * <div class="de">Rektaltampon</div>
	 * <div class="fr">Tampon rectal</div>
	 * <div class="it">Tampone rettale</div>
	 * <!-- @formatter:on -->
	 */
	RECTAL_TAMPON("11015000", "0.4.0.127.0.16.1.1.2.1", "Rectal tampon", "Rectal tampon", "Rektaltampon", "Tampon rectal", "Tampone rettale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Sealant</div>
	 * <div class="de">Gewebekleber</div>
	 * <div class="fr">Colle</div>
	 * <div class="it">Adesivo tissutale</div>
	 * <!-- @formatter:on -->
	 */
	SEALANT("12115000", "0.4.0.127.0.16.1.1.2.1", "Sealant", "Sealant", "Gewebekleber", "Colle", "Adesivo tissutale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Sealant matrix</div>
	 * <div class="de">Versiegelungsmatrix</div>
	 * <div class="fr">Matrice pour colle</div>
	 * <!-- @formatter:on -->
	 */
	SEALANT_MATRIX("12115100", "0.4.0.127.0.16.1.1.2.1", "Sealant matrix", "Sealant matrix", "Versiegelungsmatrix", "Matrice pour colle", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Sealant powder</div>
	 * <div class="de">Gewebekleber</div>
	 * <div class="fr">Poudre pour colle</div>
	 * <!-- @formatter:on -->
	 */
	SEALANT_POWDER("12115200", "0.4.0.127.0.16.1.1.2.1", "Sealant powder", "Sealant powder", "Gewebekleber", "Poudre pour colle", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Shampoo</div>
	 * <div class="de">Shampoo</div>
	 * <div class="fr">Shampoing</div>
	 * <div class="it">Shampoo</div>
	 * <!-- @formatter:on -->
	 */
	SHAMPOO("10508000", "0.4.0.127.0.16.1.1.2.1", "Shampoo", "Shampoo", "Shampoo", "Shampoing", "Shampoo"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Soluble tablet</div>
	 * <div class="de">Tablette zur Herstellung einer L�sung zum Einnehmen</div>
	 * <div class="fr">Comprim� pour solution buvable</div>
	 * <div class="it">Compressa solubile</div>
	 * <!-- @formatter:on -->
	 */
	SOLUBLE_TABLET("10120000", "0.4.0.127.0.16.1.1.2.1", "Soluble tablet", "Soluble tablet", "Tablette zur Herstellung einer L�sung zum Einnehmen", "Comprim� pour solution buvable", "Compressa solubile"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Solution for blood fraction modification</div>
	 * <div class="de">L�sung zur Modifikation einer Blutfraktion</div>
	 * <div class="fr">Solution pour la pr�paration ex vivo de fractions sanguines</div>
	 * <div class="it">Soluzione per la modifica di frazione ematica</div>
	 * <!-- @formatter:on -->
	 */
	SOLUTION_FOR_BLOOD_FRACTION_MODIFICATION("12103000", "0.4.0.127.0.16.1.1.2.1", "Solution for blood fraction modification", "Solution for blood fraction modification", "L�sung zur Modifikation einer Blutfraktion", "Solution pour la pr�paration ex vivo de fractions sanguines", "Soluzione per la modifica di frazione ematica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Solution for cardioplegia</div>
	 * <div class="de">Kardioplege L�sung</div>
	 * <div class="fr">Solution de cardiopl�gie</div>
	 * <!-- @formatter:on -->
	 */
	SOLUTION_FOR_CARDIOPLEGIA("11209500", "0.4.0.127.0.16.1.1.2.1", "Solution for cardioplegia", "Solution for cardioplegia", "Kardioplege L�sung", "Solution de cardiopl�gie", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Solution for cardioplegia/organ preservation</div>
	 * <div class="de">0</div>
	 * <div class="fr">0</div>
	 * <!-- @formatter:on -->
	 */
	SOLUTION_FOR_CARDIOPLEGIA_ORGAN_PRESERVATION("13107000", "0.4.0.127.0.16.1.1.2.1", "Solution for cardioplegia/organ preservation", "Solution for cardioplegia/organ preservation", "0", "0", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Solution for dental cement</div>
	 * <div class="de">L�sung zur Herstellung eines Dentalzements</div>
	 * <div class="fr">Solution pour ciment dentaire</div>
	 * <!-- @formatter:on -->
	 */
	SOLUTION_FOR_DENTAL_CEMENT("10414000", "0.4.0.127.0.16.1.1.2.1", "Solution for dental cement", "Solution for dental cement", "L�sung zur Herstellung eines Dentalzements", "Solution pour ciment dentaire", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Solution for haemodiafiltration</div>
	 * <div class="de">H�modiafiltrationsl�sung</div>
	 * <div class="fr">Solution pour h�modiafiltration</div>
	 * <div class="it">Soluzione per emofiltrazione</div>
	 * <!-- @formatter:on -->
	 */
	SOLUTION_FOR_HAEMODIAFILTRATION("11403000", "0.4.0.127.0.16.1.1.2.1", "Solution for haemodiafiltration", "Solution for haemodiafiltration", "H�modiafiltrationsl�sung", "Solution pour h�modiafiltration", "Soluzione per emofiltrazione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Solution for haemodialysis</div>
	 * <div class="de">H�modialysel�sung</div>
	 * <div class="fr">Solution pour h�modialyse</div>
	 * <div class="it">Soluzione per emodialisi</div>
	 * <!-- @formatter:on -->
	 */
	SOLUTION_FOR_HAEMODIALYSIS("11404000", "0.4.0.127.0.16.1.1.2.1", "Solution for haemodialysis", "Solution for haemodialysis", "H�modialysel�sung", "Solution pour h�modialyse", "Soluzione per emodialisi"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Solution for haemodialysis/haemofiltration</div>
	 * <div class="de">H�modialysel�sung/H�mofiltrationsl�sung</div>
	 * <div class="fr">Solution pour h�modialyse/h�mofiltration</div>
	 * <!-- @formatter:on -->
	 */
	SOLUTION_FOR_HAEMODIALYSIS_HAEMOFILTRATION("50057000", "0.4.0.127.0.16.1.1.2.1", "Solution for haemodialysis/haemofiltration", "Solution for haemodialysis/haemofiltration", "H�modialysel�sung/H�mofiltrationsl�sung", "Solution pour h�modialyse/h�mofiltration", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Solution for haemofiltration</div>
	 * <div class="de">H�mofiltrationsl�sung</div>
	 * <div class="fr">Solution pour h�mofiltration</div>
	 * <div class="it">Soluzione per emofiltrazione</div>
	 * <!-- @formatter:on -->
	 */
	SOLUTION_FOR_HAEMOFILTRATION("11402000", "0.4.0.127.0.16.1.1.2.1", "Solution for haemofiltration", "Solution for haemofiltration", "H�mofiltrationsl�sung", "Solution pour h�mofiltration", "Soluzione per emofiltrazione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Solution for infusion</div>
	 * <div class="de">Infusionsl�sung</div>
	 * <div class="fr">Solution pour perfusion</div>
	 * <div class="it">Soluzione per infusione</div>
	 * <!-- @formatter:on -->
	 */
	SOLUTION_FOR_INFUSION("11210000", "0.4.0.127.0.16.1.1.2.1", "Solution for infusion", "Solution for infusion", "Infusionsl�sung", "Solution pour perfusion", "Soluzione per infusione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Solution for injection</div>
	 * <div class="de">Injektionsl�sung</div>
	 * <div class="fr">Solution injectable</div>
	 * <div class="it">Soluzione iniettabile</div>
	 * <!-- @formatter:on -->
	 */
	SOLUTION_FOR_INJECTION("11201000", "0.4.0.127.0.16.1.1.2.1", "Solution for injection", "Solution for injection", "Injektionsl�sung", "Solution injectable", "Soluzione iniettabile"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Solution for injection/infusion</div>
	 * <div class="de">Injektions-/Infusionsl�sung</div>
	 * <div class="fr">Solution injectable/pour perfusion</div>
	 * <div class="it">Soluzione iniettabile o per infusione</div>
	 * <!-- @formatter:on -->
	 */
	SOLUTION_FOR_INJECTION_INFUSION("50060000", "0.4.0.127.0.16.1.1.2.1", "Solution for injection/infusion", "Solution for injection/infusion", "Injektions-/Infusionsl�sung", "Solution injectable/pour perfusion", "Soluzione iniettabile o per infusione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Solution for injection/skin-prick test</div>
	 * <div class="de">Injektionsl�sung/ Pricktestl�sung</div>
	 * <div class="fr">Solution injectable/ pour prick-test</div>
	 * <!-- @formatter:on -->
	 */
	SOLUTION_FOR_INJECTION_SKIN_PRICK_TEST("13051000", "0.4.0.127.0.16.1.1.2.1", "Solution for injection/skin-prick test", "Solution for injection/skin-prick test", "Injektionsl�sung/ Pricktestl�sung", "Solution injectable/ pour prick-test", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Solution for intraocular irrigation</div>
	 * <div class="de">L�sung zur intraokularen Anwendung</div>
	 * <div class="fr">Solution pour irrigation intraoculaire</div>
	 * <!-- @formatter:on -->
	 */
	SOLUTION_FOR_INTRAOCULAR_IRRIGATION("50073500", "0.4.0.127.0.16.1.1.2.1", "Solution for intraocular irrigation", "Solution for intraocular irrigation", "L�sung zur intraokularen Anwendung", "Solution pour irrigation intraoculaire", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Solution for iontophoresis</div>
	 * <div class="de">L�sung zur Iontophorese</div>
	 * <div class="fr">Solution pour iontophor�se</div>
	 * <div class="it">Soluzione per iontoforesi</div>
	 * <!-- @formatter:on -->
	 */
	SOLUTION_FOR_IONTOPHORESIS("10518000", "0.4.0.127.0.16.1.1.2.1", "Solution for iontophoresis", "Solution for iontophoresis", "L�sung zur Iontophorese", "Solution pour iontophor�se", "Soluzione per iontoforesi"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Solution for organ preservation</div>
	 * <div class="de">Organkonservierungsl�sung</div>
	 * <div class="fr">Solution pour conservation d'organe</div>
	 * <div class="it">Soluzione per conservazione di organi</div>
	 * <!-- @formatter:on -->
	 */
	SOLUTION_FOR_ORGAN_PRESERVATION("12112000", "0.4.0.127.0.16.1.1.2.1", "Solution for organ preservation", "Solution for organ preservation", "Organkonservierungsl�sung", "Solution pour conservation d'organe", "Soluzione per conservazione di organi"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Solution for peritoneal dialysis</div>
	 * <div class="de">Peritonealdialysel�sung</div>
	 * <div class="fr">Solution pour dialyse p�riton�ale</div>
	 * <div class="it">Soluzione per dialisi peritoneale</div>
	 * <!-- @formatter:on -->
	 */
	SOLUTION_FOR_PERITONEAL_DIALYSIS("11401000", "0.4.0.127.0.16.1.1.2.1", "Solution for peritoneal dialysis", "Solution for peritoneal dialysis", "Peritonealdialysel�sung", "Solution pour dialyse p�riton�ale", "Soluzione per dialisi peritoneale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Solution for provocation test</div>
	 * <div class="de">Provokationstestl�sung</div>
	 * <div class="fr">solution pour test de provocation</div>
	 * <div class="it">Soluzione per saggio di provocazione</div>
	 * <!-- @formatter:on -->
	 */
	SOLUTION_FOR_PROVOCATION_TEST("12131000", "0.4.0.127.0.16.1.1.2.1", "Solution for provocation test", "Solution for provocation test", "Provokationstestl�sung", "solution pour test de provocation", "Soluzione per saggio di provocazione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Solution for sealant</div>
	 * <div class="de">L�sung f�r Gewebekleber</div>
	 * <div class="fr">Solution pour colle</div>
	 * <!-- @formatter:on -->
	 */
	SOLUTION_FOR_SEALANT("50061500", "0.4.0.127.0.16.1.1.2.1", "Solution for sealant", "Solution for sealant", "L�sung f�r Gewebekleber", "Solution pour colle", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Solution for skin-prick test</div>
	 * <div class="de">Pricktestl�sung</div>
	 * <div class="fr">solution pour prick-test</div>
	 * <div class="it">Soluzione per cutireazione</div>
	 * <!-- @formatter:on -->
	 */
	SOLUTION_FOR_SKIN_PRICK_TEST("10548000", "0.4.0.127.0.16.1.1.2.1", "Solution for skin-prick test", "Solution for skin-prick test", "Pricktestl�sung", "solution pour prick-test", "Soluzione per cutireazione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Solution for skin-scratch test</div>
	 * <div class="de">Scratchtestl�sung</div>
	 * <div class="fr">solution pour test intradermique</div>
	 * <div class="it">Soluzione per scarificazione</div>
	 * <!-- @formatter:on -->
	 */
	SOLUTION_FOR_SKIN_SCRATCH_TEST("10549000", "0.4.0.127.0.16.1.1.2.1", "Solution for skin-scratch test", "Solution for skin-scratch test", "Scratchtestl�sung", "solution pour test intradermique", "Soluzione per scarificazione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Solution for solution for infusion</div>
	 * <div class="de">L�sung zur Herstellung einer Infusionsl�sung</div>
	 * <div class="fr">Solution pour solution pour perfusion</div>
	 * <!-- @formatter:on -->
	 */
	SOLUTION_FOR_SOLUTION_FOR_INFUSION("13061000", "0.4.0.127.0.16.1.1.2.1", "Solution for solution for infusion", "Solution for solution for infusion", "L�sung zur Herstellung einer Infusionsl�sung", "Solution pour solution pour perfusion", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Solution for solution for injection</div>
	 * <div class="de">L�sung zur Herstellung einer Injektionsl�sung</div>
	 * <div class="fr">Solution pour solution injectable</div>
	 * <!-- @formatter:on -->
	 */
	SOLUTION_FOR_SOLUTION_FOR_INJECTION("13033000", "0.4.0.127.0.16.1.1.2.1", "Solution for solution for injection", "Solution for solution for injection", "L�sung zur Herstellung einer Injektionsl�sung", "Solution pour solution injectable", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Solution for suspension for injection</div>
	 * <div class="de">L�sung zur Herstellung einer Injektionssuspension</div>
	 * <div class="fr">Solution pour suspension injectable</div>
	 * <!-- @formatter:on -->
	 */
	SOLUTION_FOR_SUSPENSION_FOR_INJECTION("13047000", "0.4.0.127.0.16.1.1.2.1", "Solution for suspension for injection", "Solution for suspension for injection", "L�sung zur Herstellung einer Injektionssuspension", "Solution pour suspension injectable", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Solvent for...</div>
	 * <div class="de">L�sungsmittel zur Herstellung...</div>
	 * <div class="fr">Solvant pour...</div>
	 * <!-- @formatter:on -->
	 */
	SOLVENT_FOR("13035000", "0.4.0.127.0.16.1.1.2.1", "Solvent for...", "Solvent for...", "L�sungsmittel zur Herstellung...", "Solvant pour...", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Solvent for parenteral use</div>
	 * <div class="de">L�sungsmittel zur Herstellung von Parenteralia</div>
	 * <div class="fr">Solvant pour pr�paration parent�rale</div>
	 * <div class="it">Solvente per uso parenterale</div>
	 * <!-- @formatter:on -->
	 */
	SOLVENT_FOR_PARENTERAL_USE("11216000", "0.4.0.127.0.16.1.1.2.1", "Solvent for parenteral use", "Solvent for parenteral use", "L�sungsmittel zur Herstellung von Parenteralia", "Solvant pour pr�paration parent�rale", "Solvente per uso parenterale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Solvent for solution for infusion</div>
	 * <div class="de">L�sungsmittel zur Herstellung einer Infusionsl�sung</div>
	 * <div class="fr">Solvant pour solution pour perfusion</div>
	 * <div class="it">Solvente per soluzione per infusione</div>
	 * <!-- @formatter:on -->
	 */
	SOLVENT_FOR_SOLUTION_FOR_INFUSION("50076000", "0.4.0.127.0.16.1.1.2.1", "Solvent for solution for infusion", "Solvent for solution for infusion", "L�sungsmittel zur Herstellung einer Infusionsl�sung", "Solvant pour solution pour perfusion", "Solvente per soluzione per infusione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Solvent for solution for intraocular irrigation</div>
	 * <div class="de">L�sungsmittel zur Herstellung einer L�sung zur intraokularen Anwendung</div>
	 * <div class="fr">Solvant pour solution pour irrigation intraoculaire</div>
	 * <div class="it">Solvente per soluzione per irrigazione intraoculare</div>
	 * <!-- @formatter:on -->
	 */
	SOLVENT_FOR_SOLUTION_FOR_INTRAOCULAR_IRRIGATION("50074000", "0.4.0.127.0.16.1.1.2.1", "Solvent for solution for intraocular irrigation", "Solvent for solution for intraocular irrigation", "L�sungsmittel zur Herstellung einer L�sung zur intraokularen Anwendung", "Solvant pour solution pour irrigation intraoculaire", "Solvente per soluzione per irrigazione intraoculare"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Stomach irrigation</div>
	 * <div class="de">Magensp�lfl�ssigkeit</div>
	 * <div class="fr">Solution pour irrigation stomacale</div>
	 * <div class="it">Liquido per lavanda gastrica</div>
	 * <!-- @formatter:on -->
	 */
	STOMACH_IRRIGATION("12114000", "0.4.0.127.0.16.1.1.2.1", "Stomach irrigation", "Stomach irrigation", "Magensp�lfl�ssigkeit", "Solution pour irrigation stomacale", "Liquido per lavanda gastrica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Sublingual film</div>
	 * <div class="de">Schmelzfilm zur sublingualen Anwendung</div>
	 * <div class="fr">Film sublinguale</div>
	 * <!-- @formatter:on -->
	 */
	SUBLINGUAL_FILM("10317500", "0.4.0.127.0.16.1.1.2.1", "Sublingual film", "Sublingual film", "Schmelzfilm zur sublingualen Anwendung", "Film sublinguale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Sublingual powder</div>
	 * <div class="de">0</div>
	 * <div class="fr">0</div>
	 * <!-- @formatter:on -->
	 */
	SUBLINGUAL_POWDER("13105000", "0.4.0.127.0.16.1.1.2.1", "Sublingual powder", "Sublingual powder", "0", "0", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Sublingual spray, emulsion</div>
	 * <div class="de">Sublingualspray, Emulsion</div>
	 * <div class="fr">Emulsion pour pulv�risation sublinguale</div>
	 * <!-- @formatter:on -->
	 */
	SUBLINGUAL_SPRAY_EMULSION("10309100", "0.4.0.127.0.16.1.1.2.1", "Sublingual spray, emulsion", "Sublingual spray, emulsion", "Sublingualspray, Emulsion", "Emulsion pour pulv�risation sublinguale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Sublingual spray, solution</div>
	 * <div class="de">Sublingualspray, L�sung</div>
	 * <div class="fr">Solution pour pulv�risation sublinguale</div>
	 * <!-- @formatter:on -->
	 */
	SUBLINGUAL_SPRAY_SOLUTION("10309200", "0.4.0.127.0.16.1.1.2.1", "Sublingual spray, solution", "Sublingual spray, solution", "Sublingualspray, L�sung", "Solution pour pulv�risation sublinguale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Sublingual spray, suspension</div>
	 * <div class="de">Sublingualspray, Suspension</div>
	 * <div class="fr">Suspension pour pulv�risation sublinguale</div>
	 * <!-- @formatter:on -->
	 */
	SUBLINGUAL_SPRAY_SUSPENSION("10309300", "0.4.0.127.0.16.1.1.2.1", "Sublingual spray, suspension", "Sublingual spray, suspension", "Sublingualspray, Suspension", "Suspension pour pulv�risation sublinguale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Sublingual tablet</div>
	 * <div class="de">Sublingualtablette</div>
	 * <div class="fr">Comprim� sublingual</div>
	 * <div class="it">Compressa sublinguale</div>
	 * <!-- @formatter:on -->
	 */
	SUBLINGUAL_TABLET("10318000", "0.4.0.127.0.16.1.1.2.1", "Sublingual tablet", "Sublingual tablet", "Sublingualtablette", "Comprim� sublingual", "Compressa sublinguale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Suppository</div>
	 * <div class="de">Z�pfchen</div>
	 * <div class="fr">Suppositoire</div>
	 * <div class="it">Supposta</div>
	 * <!-- @formatter:on -->
	 */
	SUPPOSITORY("11013000", "0.4.0.127.0.16.1.1.2.1", "Suppository", "Suppository", "Z�pfchen", "Suppositoire", "Supposta"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Suspension for emulsion for injection</div>
	 * <div class="de">Suspension zur Herstellung einer Emulsion zur Injektion</div>
	 * <div class="fr">Suspension pour �mulsion injectable</div>
	 * <!-- @formatter:on -->
	 */
	SUSPENSION_FOR_EMULSION_FOR_INJECTION("13036000", "0.4.0.127.0.16.1.1.2.1", "Suspension for emulsion for injection", "Suspension for emulsion for injection", "Suspension zur Herstellung einer Emulsion zur Injektion", "Suspension pour �mulsion injectable", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Suspension for injection</div>
	 * <div class="de">Injektionssuspension</div>
	 * <div class="fr">Suspension injectable</div>
	 * <div class="it">Sospensione iniettabile</div>
	 * <!-- @formatter:on -->
	 */
	SUSPENSION_FOR_INJECTION("11202000", "0.4.0.127.0.16.1.1.2.1", "Suspension for injection", "Suspension for injection", "Injektionssuspension", "Suspension injectable", "Sospensione iniettabile"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Suspension for oral suspension</div>
	 * <div class="de">Suspension zur Herstellung einer Suspension zum Einnehmen</div>
	 * <div class="fr">Suspension pour suspension buvable</div>
	 * <!-- @formatter:on -->
	 */
	SUSPENSION_FOR_ORAL_SUSPENSION("13037000", "0.4.0.127.0.16.1.1.2.1", "Suspension for oral suspension", "Suspension for oral suspension", "Suspension zur Herstellung einer Suspension zum Einnehmen", "Suspension pour suspension buvable", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Suspension for suspension for injection</div>
	 * <div class="de">Suspension zur Herstellung einer Injektionssuspension</div>
	 * <div class="fr">Suspension pour suspension injectable</div>
	 * <!-- @formatter:on -->
	 */
	SUSPENSION_FOR_SUSPENSION_FOR_INJECTION("13039000", "0.4.0.127.0.16.1.1.2.1", "Suspension for suspension for injection", "Suspension for suspension for injection", "Suspension zur Herstellung einer Injektionssuspension", "Suspension pour suspension injectable", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Syrup</div>
	 * <div class="de">Sirup</div>
	 * <div class="fr">Sirop</div>
	 * <div class="it">Sciroppo</div>
	 * <!-- @formatter:on -->
	 */
	SYRUP("10117000", "0.4.0.127.0.16.1.1.2.1", "Syrup", "Syrup", "Sirup", "Sirop", "Sciroppo"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Tablet</div>
	 * <div class="de">Tablette</div>
	 * <div class="fr">Comprim�</div>
	 * <div class="it">Compressa</div>
	 * <!-- @formatter:on -->
	 */
	TABLET("10219000", "0.4.0.127.0.16.1.1.2.1", "Tablet", "Tablet", "Tablette", "Comprim�", "Compressa"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Tablet for cutaneous solution</div>
	 * <div class="de">Tablette zur Herstellung einer L�sung zur Anwendung auf der Haut</div>
	 * <div class="fr">Comprim� pour solution cutan�e</div>
	 * <!-- @formatter:on -->
	 */
	TABLET_FOR_CUTANEOUS_SOLUTION("13066000", "0.4.0.127.0.16.1.1.2.1", "Tablet for cutaneous solution", "Tablet for cutaneous solution", "Tablette zur Herstellung einer L�sung zur Anwendung auf der Haut", "Comprim� pour solution cutan�e", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Tablet for rectal solution</div>
	 * <div class="de">Tablette zur Herstellung einer Rektall�sung</div>
	 * <div class="fr">Comprim� pour solution rectale</div>
	 * <div class="it">Compressa per soluzione rettale</div>
	 * <!-- @formatter:on -->
	 */
	TABLET_FOR_RECTAL_SOLUTION("11011000", "0.4.0.127.0.16.1.1.2.1", "Tablet for rectal solution", "Tablet for rectal solution", "Tablette zur Herstellung einer Rektall�sung", "Comprim� pour solution rectale", "Compressa per soluzione rettale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Tablet for rectal suspension</div>
	 * <div class="de">Tablette zur Herstellung einer Rektalsuspension</div>
	 * <div class="fr">Comprim� pour suspension rectale</div>
	 * <div class="it">Compressa per sospensione rettale</div>
	 * <!-- @formatter:on -->
	 */
	TABLET_FOR_RECTAL_SUSPENSION("11012000", "0.4.0.127.0.16.1.1.2.1", "Tablet for rectal suspension", "Tablet for rectal suspension", "Tablette zur Herstellung einer Rektalsuspension", "Comprim� pour suspension rectale", "Compressa per sospensione rettale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Tablet for vaginal solution</div>
	 * <div class="de">Tablette zur Herstellung einer Vaginall�sung</div>
	 * <div class="fr">Comprim� pour solution vaginale</div>
	 * <div class="it">Compressa per soluzione vaginale</div>
	 * <!-- @formatter:on -->
	 */
	TABLET_FOR_VAGINAL_SOLUTION("10908000", "0.4.0.127.0.16.1.1.2.1", "Tablet for vaginal solution", "Tablet for vaginal solution", "Tablette zur Herstellung einer Vaginall�sung", "Comprim� pour solution vaginale", "Compressa per soluzione vaginale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Toothpaste</div>
	 * <div class="de">Zahnpaste</div>
	 * <div class="fr">P�te dentifrice</div>
	 * <div class="it">Pasta dentifricia</div>
	 * <!-- @formatter:on -->
	 */
	TOOTHPASTE("10409000", "0.4.0.127.0.16.1.1.2.1", "Toothpaste", "Toothpaste", "Zahnpaste", "P�te dentifrice", "Pasta dentifricia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Transdermal gel</div>
	 * <div class="de">Transdermales Gel</div>
	 * <div class="fr">Gel transdermique</div>
	 * <!-- @formatter:on -->
	 */
	TRANSDERMAL_GEL("10546250", "0.4.0.127.0.16.1.1.2.1", "Transdermal gel", "Transdermal gel", "Transdermales Gel", "Gel transdermique", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Transdermal ointment</div>
	 * <div class="de">0</div>
	 * <div class="fr">Pommade transdermique</div>
	 * <!-- @formatter:on -->
	 */
	TRANSDERMAL_OINTMENT("13102000", "0.4.0.127.0.16.1.1.2.1", "Transdermal ointment", "Transdermal ointment", "0", "Pommade transdermique", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Transdermal patch</div>
	 * <div class="de">transdermales Pflaster</div>
	 * <div class="fr">Dispositif transdermique</div>
	 * <div class="it">Cerotto transdermico</div>
	 * <!-- @formatter:on -->
	 */
	TRANSDERMAL_PATCH("10519000", "0.4.0.127.0.16.1.1.2.1", "Transdermal patch", "Transdermal patch", "transdermales Pflaster", "Dispositif transdermique", "Cerotto transdermico"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Transdermal solution</div>
	 * <div class="de">transdermale L�sung</div>
	 * <div class="fr">Solution transdermique</div>
	 * <!-- @formatter:on -->
	 */
	TRANSDERMAL_SOLUTION("10546400", "0.4.0.127.0.16.1.1.2.1", "Transdermal solution", "Transdermal solution", "transdermale L�sung", "Solution transdermique", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Transdermal spray, solution</div>
	 * <div class="de">transdermales Spray, L�sung</div>
	 * <div class="fr">Solution pour pulv�risation transdermique</div>
	 * <!-- @formatter:on -->
	 */
	TRANSDERMAL_SPRAY_SOLUTION("10546500", "0.4.0.127.0.16.1.1.2.1", "Transdermal spray, solution", "Transdermal spray, solution", "transdermales Spray, L�sung", "Solution pour pulv�risation transdermique", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Transdermal system</div>
	 * <div class="de">transdermales System</div>
	 * <div class="fr">syst�me transdermique</div>
	 * <div class="it">Sistema transdermico</div>
	 * <!-- @formatter:on -->
	 */
	TRANSDERMAL_SYSTEM("10547000", "0.4.0.127.0.16.1.1.2.1", "Transdermal system", "Transdermal system", "transdermales System", "syst�me transdermique", "Sistema transdermico"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Urethral emulsion</div>
	 * <div class="de">Emulsion zur Anwendung in der Harnr�hre</div>
	 * <div class="fr">Emulsion ur�trale</div>
	 * <!-- @formatter:on -->
	 */
	URETHRAL_EMULSION("13077000", "0.4.0.127.0.16.1.1.2.1", "Urethral emulsion", "Urethral emulsion", "Emulsion zur Anwendung in der Harnr�hre", "Emulsion ur�trale", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Urethral gel</div>
	 * <div class="de">Gel zur Anwendung in der Harnr�hre</div>
	 * <div class="fr">Gel ur�tral</div>
	 * <div class="it">Gel uretrale</div>
	 * <!-- @formatter:on -->
	 */
	URETHRAL_GEL("11504000", "0.4.0.127.0.16.1.1.2.1", "Urethral gel", "Urethral gel", "Gel zur Anwendung in der Harnr�hre", "Gel ur�tral", "Gel uretrale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Urethral stick</div>
	 * <div class="de">St�bchen zur Anwendung in der Harnr�hre</div>
	 * <div class="fr">B�ton pour usage ur�tral</div>
	 * <div class="it">Bastoncino uretrale</div>
	 * <!-- @formatter:on -->
	 */
	URETHRAL_STICK("11505000", "0.4.0.127.0.16.1.1.2.1", "Urethral stick", "Urethral stick", "St�bchen zur Anwendung in der Harnr�hre", "B�ton pour usage ur�tral", "Bastoncino uretrale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Vaginal capsule, hard</div>
	 * <div class="de">Hartkapsel zur vaginalen Anwendung</div>
	 * <div class="fr">G�lule vaginale</div>
	 * <div class="it">Capsula rigida vaginale</div>
	 * <!-- @formatter:on -->
	 */
	VAGINAL_CAPSULE_HARD("10910000", "0.4.0.127.0.16.1.1.2.1", "Vaginal capsule, hard", "Vaginal capsule, hard", "Hartkapsel zur vaginalen Anwendung", "G�lule vaginale", "Capsula rigida vaginale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Vaginal capsule, soft</div>
	 * <div class="de">Weichkapsel zur vaginalen Anwendung</div>
	 * <div class="fr">Capsule molle vaginale</div>
	 * <div class="it">Capsula molle vaginale</div>
	 * <!-- @formatter:on -->
	 */
	VAGINAL_CAPSULE_SOFT("10911000", "0.4.0.127.0.16.1.1.2.1", "Vaginal capsule, soft", "Vaginal capsule, soft", "Weichkapsel zur vaginalen Anwendung", "Capsule molle vaginale", "Capsula molle vaginale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Vaginal cream</div>
	 * <div class="de">Vaginalcreme</div>
	 * <div class="fr">Cr�me vaginale</div>
	 * <div class="it">Crema vaginale</div>
	 * <!-- @formatter:on -->
	 */
	VAGINAL_CREAM("10901000", "0.4.0.127.0.16.1.1.2.1", "Vaginal cream", "Vaginal cream", "Vaginalcreme", "Cr�me vaginale", "Crema vaginale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Vaginal delivery system</div>
	 * <div class="de">vaginales Wirkstofffreisetzungssystem</div>
	 * <div class="fr">Syst�me de diffusion vaginal</div>
	 * <div class="it">Dispositivo vaginale</div>
	 * <!-- @formatter:on -->
	 */
	VAGINAL_DELIVERY_SYSTEM("10915000", "0.4.0.127.0.16.1.1.2.1", "Vaginal delivery system", "Vaginal delivery system", "vaginales Wirkstofffreisetzungssystem", "Syst�me de diffusion vaginal", "Dispositivo vaginale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Vaginal emulsion</div>
	 * <div class="de">Vaginalemulsion</div>
	 * <div class="fr">Emulsion vaginale</div>
	 * <div class="it">Emulsione vaginale</div>
	 * <!-- @formatter:on -->
	 */
	VAGINAL_EMULSION("10907000", "0.4.0.127.0.16.1.1.2.1", "Vaginal emulsion", "Vaginal emulsion", "Vaginalemulsion", "Emulsion vaginale", "Emulsione vaginale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Vaginal foam</div>
	 * <div class="de">Vaginalschaum</div>
	 * <div class="fr">Mousse vaginale</div>
	 * <div class="it">Schiuma vaginale</div>
	 * <!-- @formatter:on -->
	 */
	VAGINAL_FOAM("10904000", "0.4.0.127.0.16.1.1.2.1", "Vaginal foam", "Vaginal foam", "Vaginalschaum", "Mousse vaginale", "Schiuma vaginale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Vaginal gel</div>
	 * <div class="de">Vaginalgel</div>
	 * <div class="fr">Gel vaginal</div>
	 * <div class="it">Gel vaginale</div>
	 * <!-- @formatter:on -->
	 */
	VAGINAL_GEL("10902000", "0.4.0.127.0.16.1.1.2.1", "Vaginal gel", "Vaginal gel", "Vaginalgel", "Gel vaginal", "Gel vaginale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Vaginal ointment</div>
	 * <div class="de">Vaginalsalbe</div>
	 * <div class="fr">Pommade vaginale</div>
	 * <div class="it">Unguento vaginale</div>
	 * <!-- @formatter:on -->
	 */
	VAGINAL_OINTMENT("10903000", "0.4.0.127.0.16.1.1.2.1", "Vaginal ointment", "Vaginal ointment", "Vaginalsalbe", "Pommade vaginale", "Unguento vaginale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Vaginal solution</div>
	 * <div class="de">Vaginall�sung</div>
	 * <div class="fr">Solution vaginale</div>
	 * <div class="it">Soluzione vaginale</div>
	 * <!-- @formatter:on -->
	 */
	VAGINAL_SOLUTION("10905000", "0.4.0.127.0.16.1.1.2.1", "Vaginal solution", "Vaginal solution", "Vaginall�sung", "Solution vaginale", "Soluzione vaginale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Vaginal suspension</div>
	 * <div class="de">Vaginalsuspension</div>
	 * <div class="fr">Suspension vaginale</div>
	 * <div class="it">Sospensione vaginale</div>
	 * <!-- @formatter:on -->
	 */
	VAGINAL_SUSPENSION("10906000", "0.4.0.127.0.16.1.1.2.1", "Vaginal suspension", "Vaginal suspension", "Vaginalsuspension", "Suspension vaginale", "Sospensione vaginale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Vaginal tablet</div>
	 * <div class="de">Vaginaltablette</div>
	 * <div class="fr">Comprim� vaginal</div>
	 * <div class="it">Compressa vaginale</div>
	 * <!-- @formatter:on -->
	 */
	VAGINAL_TABLET("10912000", "0.4.0.127.0.16.1.1.2.1", "Vaginal tablet", "Vaginal tablet", "Vaginaltablette", "Comprim� vaginal", "Compressa vaginale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Wound stick</div>
	 * <div class="de">Wundst�bchen</div>
	 * <div class="fr">B�ton intral�sionnel</div>
	 * <div class="it">Matita emostatica</div>
	 * <!-- @formatter:on -->
	 */
	WOUND_STICK("12104000", "0.4.0.127.0.16.1.1.2.1", "Wound stick", "Wound stick", "Wundst�bchen", "B�ton intral�sionnel", "Matita emostatica");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Anticoagulant and preservative solution for blood</div>
	 * <div class="de">Code für Stabilisatorl�sung f�r Blutkonserven</div>
	 * <div class="fr">Code de Solution anticoagulante et de conservation du sang humain</div>
	 * <div class="it">Code per Soluzione anticoagulante e conservante per il sangue</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ANTICOAGULANT_AND_PRESERVATIVE_SOLUTION_FOR_BLOOD_CODE = "12102000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Bath additive</div>
	 * <div class="de">Code für Badezusatz</div>
	 * <div class="fr">Code de Adjuvant de bain</div>
	 * <div class="it">Code per Additivo per bagno</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BATH_ADDITIVE_CODE = "10501000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Bladder irrigation</div>
	 * <div class="de">Code für Blasensp�ll�sung</div>
	 * <div class="fr">Code de Solution pour irrigation v�sicale</div>
	 * <div class="it">Code per Irrigazione vescicale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BLADDER_IRRIGATION_CODE = "11502000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Buccal film</div>
	 * <div class="de">Code für Buccalfilm</div>
	 * <div class="fr">Code de Film buccogingival</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BUCCAL_FILM_CODE = "10314011";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Buccal tablet</div>
	 * <div class="de">Code für Buccaltablette</div>
	 * <div class="fr">Code de Comprim� buccogingival</div>
	 * <div class="it">Code per Compressa orosolubile</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BUCCAL_TABLET_CODE = "10320000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cachet</div>
	 * <div class="de">Code für Oblatenkapsel</div>
	 * <div class="fr">Code de Cachet</div>
	 * <div class="it">Code per Cachet</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CACHET_CODE = "10209000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Capsule, hard</div>
	 * <div class="de">Code für Hartkapsel</div>
	 * <div class="fr">Code de G�lule</div>
	 * <div class="it">Code per Capsula rigida</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CAPSULE_HARD_CODE = "10210000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Capsule, soft</div>
	 * <div class="de">Code für Weichkapsel</div>
	 * <div class="fr">Code de Capsule molle</div>
	 * <div class="it">Code per Capsula molle</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CAPSULE_SOFT_CODE = "10211000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Chewable capsule, soft</div>
	 * <div class="de">Code für Weichkapsel zum Zerbei�en</div>
	 * <div class="fr">Code de Capsule molle � m�cher</div>
	 * <div class="it">Code per Capsula molle masticabile</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHEWABLE_CAPSULE_SOFT_CODE = "10214000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Chewable/dispersible tablet</div>
	 * <div class="de">Code für Kautablette/Tablette zur Herstellung einer Suspension zum Einnehmen</div>
	 * <div class="fr">Code de Comprim� dispersible / � croquer</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHEWABLE_DISPERSIBLE_TABLET_CODE = "50001000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Chewable tablet</div>
	 * <div class="de">Code für Kautablette</div>
	 * <div class="fr">Code de Comprim� � croquer</div>
	 * <div class="it">Code per Compressa masticabile</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHEWABLE_TABLET_CODE = "10228000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Coated granules</div>
	 * <div class="de">Code für �berzogenes Granulat</div>
	 * <div class="fr">Code de Granul�s enrob�s</div>
	 * <!-- @formatter:on -->
	 */
	public static final String COATED_GRANULES_CODE = "13046000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Coated tablet</div>
	 * <div class="de">Code für �berzogene Tablette</div>
	 * <div class="fr">Code de Comprim� enrob�</div>
	 * <div class="it">Code per Compressa rivestita</div>
	 * <!-- @formatter:on -->
	 */
	public static final String COATED_TABLET_CODE = "10220000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Collodion</div>
	 * <div class="de">Code für filmbildende Fl�ssigkeit</div>
	 * <div class="fr">Code de Collodion</div>
	 * <div class="it">Code per Collodio</div>
	 * <!-- @formatter:on -->
	 */
	public static final String COLLODION_CODE = "10520000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Compressed lozenge</div>
	 * <div class="de">Code für Lutschtablette, gepresst</div>
	 * <div class="fr">Code de Comprim� � sucer</div>
	 * <div class="it">Code per Pastiglia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String COMPRESSED_LOZENGE_CODE = "10322000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Concentrate for concentrate for solution for infusion</div>
	 * <div class="de">Code für Konzentrat f�r ein Konzentrat zur Herstellung einer Infusionsl�sung</div>
	 * <div class="fr">Code de 0</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONCENTRATE_FOR_CONCENTRATE_FOR_SOLUTION_FOR_INFUSION_CODE = "13001000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Concentrate for cutaneous solution</div>
	 * <div class="de">Code für Konzentrat zur Herstellung einer L�sung zur Anwendung auf der Haut</div>
	 * <div class="fr">Code de Solution � diluer pour solution cutan�e</div>
	 * <div class="it">Code per Concentrato per soluzione cutanea</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONCENTRATE_FOR_CUTANEOUS_SOLUTION_CODE = "10514000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Concentrate for cutaneous spray, emulsion</div>
	 * <div class="de">Code für Konzentrat zur Herstellung eines Sprays zur Anwendung auf der Haut, Emulsion</div>
	 * <div class="fr">Code de Solution � diluer pour �mulsion pour pulv�risation cutan�e</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONCENTRATE_FOR_CUTANEOUS_SPRAY_EMULSION_CODE = "50009000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Concentrate for dispersion for infusion</div>
	 * <div class="de">Code für Konzentrat zur Herstellung einer Infusionsdispersion</div>
	 * <div class="fr">Code de 0</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONCENTRATE_FOR_DISPERSION_FOR_INFUSION_CODE = "50009300";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Concentrate for emulsion for infusion</div>
	 * <div class="de">Code für Konzentrat zur Herstellung einer Emulsion zur Infusion</div>
	 * <div class="fr">Code de Solution � diluer pour perfusion d�une �mulsion</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONCENTRATE_FOR_EMULSION_FOR_INFUSION_CODE = "50009500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Concentrate for gargle</div>
	 * <div class="de">Code für Konzentrat zur Herstellung einer Gurgell�sung</div>
	 * <div class="fr">Code de Solution � diluer pour gargarisme</div>
	 * <div class="it">Code per Concentrato per soluzione per gargarismi</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONCENTRATE_FOR_GARGLE_CODE = "10302000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Concentrate for intravesical solution</div>
	 * <div class="de">Code für Konzentrat zur Herstellung einer L�sung zur intravesikalen Anwendung</div>
	 * <div class="fr">Code de Solution � diluer pour solution intrav�sicale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONCENTRATE_FOR_INTRAVESICAL_SOLUTION_CODE = "50009750";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Concentrate for nebuliser solution</div>
	 * <div class="de">Code für Konzentrat zur Herstellung einer L�sung f�r einen Vernebler</div>
	 * <div class="fr">Code de Solution � diluer pour inhalation par n�buliseur</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONCENTRATE_FOR_NEBULISER_SOLUTION_CODE = "13002000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Concentrate for oral/rectal solution</div>
	 * <div class="de">Code für Konzentrat zur Herstellung einer L�sung zum Einnehmen /Rektall�sung</div>
	 * <div class="fr">Code de Solution � diluer pour solution orale/rectale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONCENTRATE_FOR_ORAL_RECTAL_SOLUTION_CODE = "50011000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Concentrate for oral solution</div>
	 * <div class="de">Code für Konzentrat zur Herstellung einer L�sung  zum Einnehmen</div>
	 * <div class="fr">Code de Solution � diluer pour solution buvable</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONCENTRATE_FOR_ORAL_SOLUTION_CODE = "50010000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Concentrate for oral suspension</div>
	 * <div class="de">Code für Konzentrat zur Herstellung einer Suspension zum Einnehmen</div>
	 * <div class="fr">Code de Suspension � diluer pour suspension buvable</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONCENTRATE_FOR_ORAL_SUSPENSION_CODE = "10100500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Concentrate for oromucosal solution</div>
	 * <div class="de">Code für Konzentrat zur Herstellung einer L�sung zur Anwendung in der Mundh�hle</div>
	 * <div class="fr">Code de Solution � diluer buccale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONCENTRATE_FOR_OROMUCOSAL_SOLUTION_CODE = "13003000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Concentrate for rectal solution</div>
	 * <div class="de">Code für Konzentrat zur Herstellung einer Rektall�sung</div>
	 * <div class="fr">Code de Solution rectale � diluer</div>
	 * <div class="it">Code per Concentrato per soluzione rettale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONCENTRATE_FOR_RECTAL_SOLUTION_CODE = "11008000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Concentrate for solution for haemodialysis</div>
	 * <div class="de">Code für Konzentrat zur Herstellung einer H�modialysel�sung</div>
	 * <div class="fr">Code de Solution � diluer pour h�modialyse</div>
	 * <div class="it">Code per Soluzione concentrata per emodialisi</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONCENTRATE_FOR_SOLUTION_FOR_HAEMODIALYSIS_CODE = "11405000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Concentrate for solution for infusion</div>
	 * <div class="de">Code für Konzentrat zur Herstellung einer Infusionsl�sung</div>
	 * <div class="fr">Code de Solution � diluer pour perfusion</div>
	 * <div class="it">Code per Concentrato per soluzione per infusione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONCENTRATE_FOR_SOLUTION_FOR_INFUSION_CODE = "11213000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Concentrate for solution for injection</div>
	 * <div class="de">Code für Konzentrat zur Herstellung einer Injektionsl�sung</div>
	 * <div class="fr">Code de Solution � diluer injectable</div>
	 * <div class="it">Code per Concentrato per soluzione iniettabile</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONCENTRATE_FOR_SOLUTION_FOR_INJECTION_CODE = "11209000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Concentrate for solution for injection/infusion</div>
	 * <div class="de">Code für Konzentrat zur Herstellung einer Injektions- /Infusionsl�sung</div>
	 * <div class="fr">Code de Solution � diluer pour solution injectable/pour perfusion</div>
	 * <div class="it">Code per Concentrato per soluzione iniettabile/ per infusione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONCENTRATE_FOR_SOLUTION_FOR_INJECTION_INFUSION_CODE = "50079000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Concentrate for solution for intraocular irrigation</div>
	 * <div class="de">Code für Konzentrat zur Herstellung einer L�sung zur intraokularen Anwendung</div>
	 * <div class="fr">Code de Solution � diluer pour solution pour irrigation intraoculaire</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONCENTRATE_FOR_SOLUTION_FOR_INTRAOCULAR_IRRIGATION_CODE = "10600500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Concentrate for solution for peritoneal dialysis</div>
	 * <div class="de">Code für Konzentrat zur Herstellung einer Peritonealdialysel�sung</div>
	 * <div class="fr">Code de Solution � diluer pour solution pour dialyse p�riton�ale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONCENTRATE_FOR_SOLUTION_FOR_PERITONEAL_DIALYSIS_CODE = "50013250";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Concentrate for suspension for injection</div>
	 * <div class="de">Code für Konzentrat zur Herstellung einer Injektionssuspension</div>
	 * <div class="fr">Code de Suspension � diluer injectable</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONCENTRATE_FOR_SUSPENSION_FOR_INJECTION_CODE = "13004000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cream</div>
	 * <div class="de">Code für Creme</div>
	 * <div class="fr">Code de Cr�me</div>
	 * <div class="it">Code per Crema</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CREAM_CODE = "10502000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cutaneous emulsion</div>
	 * <div class="de">Code für Emulsion zur Anwendung auf der Haut</div>
	 * <div class="fr">Code de Emulsion cutan�e</div>
	 * <div class="it">Code per Emulsione cutanea</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CUTANEOUS_EMULSION_CODE = "10516000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cutaneous foam</div>
	 * <div class="de">Code für Schaum zur  Anwendung auf der Haut</div>
	 * <div class="fr">Code de Mousse cutan�e</div>
	 * <div class="it">Code per Schiuma cutanea</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CUTANEOUS_FOAM_CODE = "10507000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cutaneous liquid</div>
	 * <div class="de">Code für Fl�ssigkeit zur Anwendung auf der Haut</div>
	 * <div class="fr">Code de Liquide cutan�</div>
	 * <div class="it">Code per Liquido cutaneo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CUTANEOUS_LIQUID_CODE = "10512000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cutaneous/nasal ointment</div>
	 * <div class="de">Code für Salbe zur Anwendung auf der Haut/Nasensalbe</div>
	 * <div class="fr">Code de Pommade cutan�e/ nasale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CUTANEOUS_NASAL_OINTMENT_CODE = "50015200";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cutaneous paste</div>
	 * <div class="de">Code für Paste zur Anwendung auf der Haut</div>
	 * <div class="fr">Code de P�te cutan�e</div>
	 * <div class="it">Code per Pasta cutanea</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CUTANEOUS_PASTE_CODE = "10505000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cutaneous patch</div>
	 * <div class="de">Code für Kutanes Pflaster</div>
	 * <div class="fr">Code de Dispositif cutan�</div>
	 * <div class="it">Code per Cerotto cutaneo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CUTANEOUS_PATCH_CODE = "10517500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cutaneous powder</div>
	 * <div class="de">Code für Pulver zur Anwendung auf der Haut</div>
	 * <div class="fr">Code de Poudre pour application cutan�e</div>
	 * <div class="it">Code per Polvere cutanea</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CUTANEOUS_POWDER_CODE = "10517000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cutaneous solution</div>
	 * <div class="de">Code für L�sung zur Anwendung auf der Haut</div>
	 * <div class="fr">Code de Solution pour application cutan�e</div>
	 * <div class="it">Code per Soluzione cutanea</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CUTANEOUS_SOLUTION_CODE = "10513000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cutaneous solution/concentrate for oromucosal solution</div>
	 * <div class="de">Code für L�sung zur Anwendung auf der Haut/Konzentrat zur Herstellung einer L�sung zur Anwendung in der Mundh�hle</div>
	 * <div class="fr">Code de Solution cutan�e/ solution � diluer buccale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CUTANEOUS_SOLUTION_CONCENTRATE_FOR_OROMUCOSAL_SOLUTION_CODE = "50015450";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cutaneous spray, emulsion</div>
	 * <div class="de">Code für Spray zur Anwendung auf der Haut, Emulsion</div>
	 * <div class="fr">Code de �mulsion pour pulv�risation cutan�e</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CUTANEOUS_SPRAY_EMULSION_CODE = "50015500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cutaneous spray, ointment</div>
	 * <div class="de">Code für Spray zur Anwendung auf der Haut, Salbe</div>
	 * <div class="fr">Code de Pommade pour pulv�risation cutan�e</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CUTANEOUS_SPRAY_OINTMENT_CODE = "50016000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cutaneous spray, powder</div>
	 * <div class="de">Code für Pulver-Spray zur Anwendung auf der Haut</div>
	 * <div class="fr">Code de Poudre pour pulv�risation cutan�e</div>
	 * <div class="it">Code per Spray cutaneo, polvere</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CUTANEOUS_SPRAY_POWDER_CODE = "10511000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cutaneous spray, solution</div>
	 * <div class="de">Code für Spray zur Anwendung auf der Haut, L�sung</div>
	 * <div class="fr">Code de Solution pour pulv�risation cutan�e</div>
	 * <div class="it">Code per Spray cutaneo, soluzione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CUTANEOUS_SPRAY_SOLUTION_CODE = "10509000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cutaneous spray, suspension</div>
	 * <div class="de">Code für Spray zur Anwendung auf der Haut, Suspension</div>
	 * <div class="fr">Code de Suspension pour pulv�risation cutan�e</div>
	 * <div class="it">Code per Spray cutaneo, sospensione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CUTANEOUS_SPRAY_SUSPENSION_CODE = "10510000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cutaneous stick</div>
	 * <div class="de">Code für Stift zur Anwendung auf der Haut</div>
	 * <div class="fr">Code de B�ton pour application cutan�e</div>
	 * <div class="it">Code per Matita cutanea</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CUTANEOUS_STICK_CODE = "10523000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cutaneous suspension</div>
	 * <div class="de">Code für Suspension zur Anwendung auf der Haut</div>
	 * <div class="fr">Code de Suspension pour application cutan�e</div>
	 * <div class="it">Code per Sospensione cutanea</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CUTANEOUS_SUSPENSION_CODE = "10515000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dental cement</div>
	 * <div class="de">Code für Dentalzement</div>
	 * <div class="fr">Code de Ciment dentaire</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DENTAL_CEMENT_CODE = "10401500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dental emulsion</div>
	 * <div class="de">Code für Dentalemulsion</div>
	 * <div class="fr">Code de Emulsion dentaire</div>
	 * <div class="it">Code per Emulsione dentale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DENTAL_EMULSION_CODE = "10408000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dental gel</div>
	 * <div class="de">Code für Dentalgel</div>
	 * <div class="fr">Code de Gel dentaire</div>
	 * <div class="it">Code per Gel dentale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DENTAL_GEL_CODE = "10402000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dental paste</div>
	 * <div class="de">Code für Dentalpaste</div>
	 * <div class="fr">Code de P�te dentaire</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DENTAL_PASTE_CODE = "50017000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dental powder</div>
	 * <div class="de">Code für Dentalpulver</div>
	 * <div class="fr">Code de Poudre dentaire</div>
	 * <div class="it">Code per Polvere dentale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DENTAL_POWDER_CODE = "10405000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dental solution</div>
	 * <div class="de">Code für Dentall�sung</div>
	 * <div class="fr">Code de Solution dentaire</div>
	 * <div class="it">Code per Soluzione dentale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DENTAL_SOLUTION_CODE = "10406000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dental stick</div>
	 * <div class="de">Code für Dentalstift</div>
	 * <div class="fr">Code de B�ton dentaire</div>
	 * <div class="it">Code per Bastoncino dentale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DENTAL_STICK_CODE = "10403000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dental suspension</div>
	 * <div class="de">Code für Dentalsuspension</div>
	 * <div class="fr">Code de Suspension dentaire</div>
	 * <div class="it">Code per Sospensione dentale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DENTAL_SUSPENSION_CODE = "10407000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Denture lacquer</div>
	 * <div class="de">Code für Lack f�r die Gebisskontaktfl�che</div>
	 * <div class="fr">Code de Laque dentaire</div>
	 * <div class="it">Code per Smalto dentale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DENTURE_LACQUER_CODE = "12101000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dispersible tablet</div>
	 * <div class="de">Code für Tablette zur Herstellung einer Suspension zum Einnehmen</div>
	 * <div class="fr">Code de Comprim� dispersible</div>
	 * <div class="it">Code per Compressa dispersibile</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DISPERSIBLE_TABLET_CODE = "10121000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dispersible tablets for dose dispenser</div>
	 * <div class="de">Code für Tablette zur Herstellung einer Suspension zum Einnehmen f�r ein Dosierger�t</div>
	 * <div class="fr">Code de Comprim�s dispersibles pour dispensateur de dose</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DISPERSIBLE_TABLETS_FOR_DOSE_DISPENSER_CODE = "10121500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dispersion for concentrate for dispersion for infusion</div>
	 * <div class="de">Code für Dispersion f�r ein Konzentrat zur Herstellung einer Infusionsdispersion</div>
	 * <div class="fr">Code de Dispersion pour dispersion � diluer pour perfusion</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DISPERSION_FOR_CONCENTRATE_FOR_DISPERSION_FOR_INFUSION_CODE = "13005000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dispersion for infusion</div>
	 * <div class="de">Code für Infusionsdispersion</div>
	 * <div class="fr">Code de Dispersion pour perfusion</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DISPERSION_FOR_INFUSION_CODE = "50017500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dispersion for injection</div>
	 * <div class="de">Code für Dispersion zur Injektion</div>
	 * <div class="fr">Code de Dispersion injectable</div>
	 * <div class="it">Code per Dispersione per preparazione iniettabile</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DISPERSION_FOR_INJECTION_CODE = "50077000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dispersion for injection/infusion</div>
	 * <div class="de">Code für Dispersion zur Injektion /Infusion</div>
	 * <div class="fr">Code de Dispersion injectable/ pour perfusion</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DISPERSION_FOR_INJECTION_INFUSION_CODE = "13049000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ear cream</div>
	 * <div class="de">Code für Ohrencreme</div>
	 * <div class="fr">Code de Cr�me auriculaire</div>
	 * <div class="it">Code per Crema auricolare</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EAR_CREAM_CODE = "10701000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ear drops, emulsion</div>
	 * <div class="de">Code für Ohrentropfen, Emulsion</div>
	 * <div class="fr">Code de Emulsion auriculaire en gouttes</div>
	 * <div class="it">Code per Gocce auricolari, emulsione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EAR_DROPS_EMULSION_CODE = "10706000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ear drops, powder for suspension</div>
	 * <div class="de">Code für Pulver zur Herstellung einer Ohrentropfensuspension</div>
	 * <div class="fr">Code de Poudre pour suspension auriculaire en gouttes</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EAR_DROPS_POWDER_FOR_SUSPENSION_CODE = "13006000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ear drops, solution</div>
	 * <div class="de">Code für Ohrentropfen, L�sung</div>
	 * <div class="fr">Code de Solution auriculaire en gouttes</div>
	 * <div class="it">Code per Gocce auricolari, soluzione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EAR_DROPS_SOLUTION_CODE = "10704000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ear drops, suspension</div>
	 * <div class="de">Code für Ohrentropfen, Suspension</div>
	 * <div class="fr">Code de Suspension auriculaire en gouttes</div>
	 * <div class="it">Code per Gocce auricolari, sospensione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EAR_DROPS_SUSPENSION_CODE = "10705000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ear/eye drops, solution</div>
	 * <div class="de">Code für Augen-/Ohrentropfen, L�sung</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EAR_EYE_DROPS_SOLUTION_CODE = "50018000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ear/eye drops, suspension</div>
	 * <div class="de">Code für Augen-/Ohrentropfen, Suspension</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EAR_EYE_DROPS_SUSPENSION_CODE = "50018500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ear/eye/nasal drops, solution</div>
	 * <div class="de">Code für Augen-/Ohren-/Nasentropfen, L�sung</div>
	 * <div class="fr">Code de Solution auriculaire/ ophtalmique/ nasale en gouttes</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EAR_EYE_NASAL_DROPS_SOLUTION_CODE = "50019500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ear/eye ointment</div>
	 * <div class="de">Code für Augen-/Ohrensalbe</div>
	 * <div class="fr">Code de Pommade auriculaire/ ophtalmique</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EAR_EYE_OINTMENT_CODE = "50019000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ear gel</div>
	 * <div class="de">Code für Ohrengel</div>
	 * <div class="fr">Code de Gel auriculaire</div>
	 * <div class="it">Code per Gel auricolare</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EAR_GEL_CODE = "10702000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ear/nasal drops, suspension</div>
	 * <div class="de">Code für Augen-/Nasentropfen, Suspension</div>
	 * <div class="fr">Code de Suspension auriculaire/nasale en gouttes</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EAR_NASAL_DROPS_SUSPENSION_CODE = "50020200";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ear ointment</div>
	 * <div class="de">Code für Ohrensalbe</div>
	 * <div class="fr">Code de Pommade auriculaire</div>
	 * <div class="it">Code per Unguento auricolare</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EAR_OINTMENT_CODE = "10703000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ear powder</div>
	 * <div class="de">Code für Ohrenpulver</div>
	 * <div class="fr">Code de Poudre auriculaire</div>
	 * <div class="it">Code per Polvere auricolare</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EAR_POWDER_CODE = "10708000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ear spray, emulsion</div>
	 * <div class="de">Code für Ohrenspray, Emulsion</div>
	 * <div class="fr">Code de Emulsion pour pulv�risation auriculaire</div>
	 * <div class="it">Code per Spray auricolare, emulsione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EAR_SPRAY_EMULSION_CODE = "10711000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ear spray, solution</div>
	 * <div class="de">Code für Ohrenspray, L�sung</div>
	 * <div class="fr">Code de Solution pour pulv�risation auriculaire</div>
	 * <div class="it">Code per Spray auricolare, soluzione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EAR_SPRAY_SOLUTION_CODE = "10709000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ear spray, suspension</div>
	 * <div class="de">Code für Ohrenspray, Suspension</div>
	 * <div class="fr">Code de Suspension pour pulv�risation auriculaire</div>
	 * <div class="it">Code per Spray auricolare, sospensione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EAR_SPRAY_SUSPENSION_CODE = "10710000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ear stick</div>
	 * <div class="de">Code für Ohrenst�bchen</div>
	 * <div class="fr">Code de B�ton pour usage auriculaire</div>
	 * <div class="it">Code per Bastoncino auricolare</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EAR_STICK_CODE = "10715000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ear tampon</div>
	 * <div class="de">Code für Ohrentampon</div>
	 * <div class="fr">Code de Tampon auriculaire</div>
	 * <div class="it">Code per Tampone auricolare</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EAR_TAMPON_CODE = "10714000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ear wash, emulsion</div>
	 * <div class="de">Code für Ohrensp�lung, Emulsion</div>
	 * <div class="fr">Code de Emulsion pour lavage auriculaire</div>
	 * <div class="it">Code per Lavaggio auricolare, emulsione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EAR_WASH_EMULSION_CODE = "10713000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ear wash, solution</div>
	 * <div class="de">Code für Ohrensp�ll�sung</div>
	 * <div class="fr">Code de Solution pour lavage auriculaire</div>
	 * <div class="it">Code per Lavaggio auricolare, soluzione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EAR_WASH_SOLUTION_CODE = "10712000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Effervescent granules</div>
	 * <div class="de">Code für Brausegranulat</div>
	 * <div class="fr">Code de Granul�s effervescents</div>
	 * <div class="it">Code per Granulato effervescente</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EFFERVESCENT_GRANULES_CODE = "10205000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Effervescent granules for oral suspension</div>
	 * <div class="de">Code für Brausegranulat zur Herstellung einer Suspension zum Einnehmen</div>
	 * <div class="fr">Code de Granul�s effervescents pour suspension buvable</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EFFERVESCENT_GRANULES_FOR_ORAL_SUSPENSION_CODE = "13007000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Effervescent powder</div>
	 * <div class="de">Code für Brausepulver</div>
	 * <div class="fr">Code de Poudre effervescente</div>
	 * <div class="it">Code per Polvere effervescente</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EFFERVESCENT_POWDER_CODE = "10203000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Effervescent tablet</div>
	 * <div class="de">Code für Brausetablette</div>
	 * <div class="fr">Code de Comprim� effervescent</div>
	 * <div class="it">Code per Compressa effervescente</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EFFERVESCENT_TABLET_CODE = "10222000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Effervescent vaginal tablet</div>
	 * <div class="de">Code für Schaumovula</div>
	 * <div class="fr">Code de Comprim� vaginal effervescent</div>
	 * <div class="it">Code per Compressa effervescente vaginale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EFFERVESCENT_VAGINAL_TABLET_CODE = "10913000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Emulsion for emulsion for injection</div>
	 * <div class="de">Code für Emulsion zur Herstellung einer Emulsion zur Injektion</div>
	 * <div class="fr">Code de Emulsion pour �mulsion injectable</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EMULSION_FOR_EMULSION_FOR_INJECTION_CODE = "13008000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Emulsion for infusion</div>
	 * <div class="de">Code für Emulsion zur Infusion</div>
	 * <div class="fr">Code de Emulsion pour perfusion</div>
	 * <div class="it">Code per Emulsione per infusione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EMULSION_FOR_INFUSION_CODE = "11211000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Emulsion for injection</div>
	 * <div class="de">Code für Emulsion zur Injektion</div>
	 * <div class="fr">Code de Emulsion injectable</div>
	 * <div class="it">Code per Emuslione iniettabile</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EMULSION_FOR_INJECTION_CODE = "11203000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Emulsion for injection/infusion</div>
	 * <div class="de">Code für Emulsion zur Injektion/Infusion</div>
	 * <div class="fr">Code de �mulsion injectable/pour perfusion</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EMULSION_FOR_INJECTION_INFUSION_CODE = "50021000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Emulsion for suspension for injection</div>
	 * <div class="de">Code für Emulsion zur Herstellung einer Injektionssuspension</div>
	 * <div class="fr">Code de Emulsion pour suspension injectable</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EMULSION_FOR_SUSPENSION_FOR_INJECTION_CODE = "13091000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Endocervical gel</div>
	 * <div class="de">Code für Gel zur endozervikalen Anwendung</div>
	 * <div class="fr">Code de Gel endocervical</div>
	 * <div class="it">Code per Gel endocervicale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENDOCERVICAL_GEL_CODE = "11701000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Endosinusial solution</div>
	 * <div class="de">Code für L�sung zur Anwendung in den Nebenh�hlen</div>
	 * <div class="fr">Code de Solution endosinusale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENDOSINUSIAL_SOLUTION_CODE = "13041000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Endosinusial wash, suspension</div>
	 * <div class="de">Code für Nebenh�hlensp�lung, Suspension</div>
	 * <div class="fr">Code de Suspension pour lavage endosinusal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENDOSINUSIAL_WASH_SUSPENSION_CODE = "50022000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Endotracheopulmonary instillation, powder for solution</div>
	 * <div class="de">Code für Pulver zur Herstellung einer L�sung zur endotracheopulmonalen Instillation</div>
	 * <div class="fr">Code de Poudre pour solution pour instillation endotrach�obronchique</div>
	 * <div class="it">Code per Polvere per soluzione per instillazione endotracheobronchiale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENDOTRACHEOPULMONARY_INSTILLATION_POWDER_FOR_SOLUTION_CODE = "11602000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Endotracheopulmonary instillation, powder for suspension</div>
	 * <div class="de">Code für Pulver zu Herstellung einer Suspension zur endotracheopulmonalen Instillation</div>
	 * <div class="fr">Code de Poudre pour suspension pour instillation endotrach�obronchique</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENDOTRACHEOPULMONARY_INSTILLATION_POWDER_FOR_SUSPENSION_CODE = "13009000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Endotracheopulmonary instillation, solution</div>
	 * <div class="de">Code für L�sung zur endotracheopulmonalen Instillation</div>
	 * <div class="fr">Code de Solution pour instillation endotrach�obronchique</div>
	 * <div class="it">Code per Soluzione per instillazione endotracheobronchiale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENDOTRACHEOPULMONARY_INSTILLATION_SOLUTION_CODE = "11601000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Endotracheopulmonary instillation, suspension</div>
	 * <div class="de">Code für Suspension zur endotracheopulmonalen Instillation</div>
	 * <div class="fr">Code de Suspension pour instillation endotrach�obronchique</div>
	 * <div class="it">Code per Sospensione per instillazione endotracheobronchiale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENDOTRACHEOPULMONARY_INSTILLATION_SUSPENSION_CODE = "11603000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Epilesional solution</div>
	 * <div class="de">Code für L�sung zum Auftragen auf die Haut</div>
	 * <div class="fr">Code de Solution �pil�sionnelle</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EPILESIONAL_SOLUTION_CODE = "13042000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Eye cream</div>
	 * <div class="de">Code für Augencreme</div>
	 * <div class="fr">Code de Cr�me ophtalmique</div>
	 * <div class="it">Code per Crema oftalmica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EYE_CREAM_CODE = "10601000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Eye drops, emulsion</div>
	 * <div class="de">Code für Augentropfen, Emulsion</div>
	 * <div class="fr">Code de Collyre en �mulsion</div>
	 * <div class="it">Code per Collirio, emulsione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EYE_DROPS_EMULSION_CODE = "10604500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Eye drops, powder for solution</div>
	 * <div class="de">Code für Pulver zur Herstellung von Augentropfen, L�sung</div>
	 * <div class="fr">Code de Poudre pour solution ophtalmique en gouttes</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EYE_DROPS_POWDER_FOR_SOLUTION_CODE = "13010000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Eye drops, powder for suspension</div>
	 * <div class="de">Code für Pulver zur Herstellung einer Augentropfensuspension</div>
	 * <div class="fr">Code de Poudre pour suspension ophtalmique en gouttes</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EYE_DROPS_POWDER_FOR_SUSPENSION_CODE = "13011000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Eye drops, prolonged-release</div>
	 * <div class="de">Code für Augentropfen mit verl�ngerter Wirkungsdauer</div>
	 * <div class="fr">Code de Collyre � lib�ration prolong�e</div>
	 * <div class="it">Code per Collirio a rilascio prolungato</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EYE_DROPS_PROLONGED_RELEASE_CODE = "10609000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Eye drops, solution</div>
	 * <div class="de">Code für Augentropfen, L�sung</div>
	 * <div class="fr">Code de Collyre en solution</div>
	 * <div class="it">Code per Collirio, soluzione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EYE_DROPS_SOLUTION_CODE = "10604000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Eye drops, solvent for reconstitution</div>
	 * <div class="de">Code für L�sungsmittel zur Herstellung von Augentropfen</div>
	 * <div class="fr">Code de Solvant pour collyre</div>
	 * <div class="it">Code per Solvente per collirio</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EYE_DROPS_SOLVENT_FOR_RECONSTITUTION_CODE = "10608000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Eye drops, suspension</div>
	 * <div class="de">Code für Augentropfensuspension</div>
	 * <div class="fr">Code de Collyre en suspension</div>
	 * <div class="it">Code per Collirio, sospensione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EYE_DROPS_SUSPENSION_CODE = "10605000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Eye gel</div>
	 * <div class="de">Code für Augengel</div>
	 * <div class="fr">Code de Gel ophtalmique</div>
	 * <div class="it">Code per Gel oftalmico</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EYE_GEL_CODE = "10602000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Eye lotion</div>
	 * <div class="de">Code für Augenbad</div>
	 * <div class="fr">Code de Solution pour lavage ophtalmique</div>
	 * <div class="it">Code per Bagno oculare</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EYE_LOTION_CODE = "10610000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Eye lotion, solvent for reconstitution</div>
	 * <div class="de">Code für L�sungsmittel zur Herstellung eines Augenbades</div>
	 * <div class="fr">Code de Solvant pour solution pour lavage ophtalmique</div>
	 * <div class="it">Code per Solvente per bagno oculare</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EYE_LOTION_SOLVENT_FOR_RECONSTITUTION_CODE = "10611000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Eye ointment</div>
	 * <div class="de">Code für Augensalbe</div>
	 * <div class="fr">Code de Pommade ophtalmique</div>
	 * <div class="it">Code per Unguento oftalmico</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EYE_OINTMENT_CODE = "10603000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Film-coated tablet</div>
	 * <div class="de">Code für Filmtablette</div>
	 * <div class="fr">Code de Comprim� pellicul�</div>
	 * <div class="it">Code per Compressa rivestita con film</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FILM_COATED_TABLET_CODE = "10221000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gargle</div>
	 * <div class="de">Code für Gurgell�sung</div>
	 * <div class="fr">Code de Solution pour gargarisme</div>
	 * <div class="it">Code per Soluzione per gargarismi</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GARGLE_CODE = "10301000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gargle/mouthwash</div>
	 * <div class="de">Code für Gurgell�sung/Mundsp�lung</div>
	 * <div class="fr">Code de Solution pour gargarisme/bain de bouche</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GARGLE_MOUTHWASH_CODE = "50024000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gargle/nasal wash</div>
	 * <div class="de">Code für Gurgell�sung/Nasensp�lung</div>
	 * <div class="fr">Code de Solution pour gargarisme/ nasale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GARGLE_NASAL_WASH_CODE = "50024500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gargle, powder for solution</div>
	 * <div class="de">Code für Pulver zur Herstellung einer Gurgell�sung</div>
	 * <div class="fr">Code de Poudre pour solution pour gargarisme</div>
	 * <div class="it">Code per Polvere per soluzione per gargarismi</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GARGLE_POWDER_FOR_SOLUTION_CODE = "10303000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gargle, tablet for solution</div>
	 * <div class="de">Code für Tablette zur Herstellung einer Gurgell�sung</div>
	 * <div class="fr">Code de Comprim� pour solution pour gargarisme</div>
	 * <div class="it">Code per Compressa per soluzione per gargarismi</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GARGLE_TABLET_FOR_SOLUTION_CODE = "10304000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gastroenteral emulsion</div>
	 * <div class="de">Code für Emulsion zur gastrointestinalen Anwendung</div>
	 * <div class="fr">Code de Emulsion gastroent�rale</div>
	 * <div class="it">Code per Emulsione gastroenterica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GASTROENTERAL_EMULSION_CODE = "12111000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gastroenteral solution</div>
	 * <div class="de">Code für L�sung zur gastrointestinalen Anwendung</div>
	 * <div class="fr">Code de Solution gastroent�rale</div>
	 * <div class="it">Code per Soluzione gastroenterica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GASTROENTERAL_SOLUTION_CODE = "12108000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gastroenteral suspension</div>
	 * <div class="de">Code für Suspension zur gastrointestinalen Anwendung</div>
	 * <div class="fr">Code de Suspension gastroent�rale</div>
	 * <div class="it">Code per Sospensione gastroenterica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GASTROENTERAL_SUSPENSION_CODE = "12110000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gastro-resistant capsule, hard</div>
	 * <div class="de">Code für magensaftresistente Hartkapsel</div>
	 * <div class="fr">Code de G�lule gastror�sistante</div>
	 * <div class="it">Code per Capsula rigida gastroresistente</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GASTRO_RESISTANT_CAPSULE_HARD_CODE = "10212000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gastro-resistant capsule, soft</div>
	 * <div class="de">Code für magensaftresistente Weichkapsel</div>
	 * <div class="fr">Code de Capsule molle gastror�sistante</div>
	 * <div class="it">Code per Capsula molle gastroresistente</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GASTRO_RESISTANT_CAPSULE_SOFT_CODE = "10213000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gastro-resistant granules</div>
	 * <div class="de">Code für magensaftresistentes Granulat</div>
	 * <div class="fr">Code de Granul�s gastror�sistants</div>
	 * <div class="it">Code per Granulato gastroresistente</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GASTRO_RESISTANT_GRANULES_CODE = "10206000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gastro-resistant granules for oral suspension</div>
	 * <div class="de">Code für magensaftresistentes Granulat zur Herstellung einer Suspension zum Einnehmen</div>
	 * <div class="fr">Code de Granul�s gastror�sistants pour suspension buvable</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GASTRO_RESISTANT_GRANULES_FOR_ORAL_SUSPENSION_CODE = "50026000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gastro-resistant tablet</div>
	 * <div class="de">Code für magensaftresistente Tablette</div>
	 * <div class="fr">Code de Comprim� gastror�sistant</div>
	 * <div class="it">Code per Compressa gastroresistente</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GASTRO_RESISTANT_TABLET_CODE = "10225000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gas for dispersion for infusion</div>
	 * <div class="de">Code für Gas zur Herstellung einer Infusionsdispersion</div>
	 * <div class="fr">Code de Gaz pour dispersion pour perfusion</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GAS_FOR_DISPERSION_FOR_INFUSION_CODE = "13012000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gas for dispersion for injection</div>
	 * <div class="de">Code für Gas zur Herstellung einer Injektionsdispersion</div>
	 * <div class="fr">Code de Gaz pour dispersion injectable</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GAS_FOR_DISPERSION_FOR_INJECTION_CODE = "13013000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gas for dispersion for injection/infusion</div>
	 * <div class="de">Code für Gas zur Herstellung einer Injektions-/Infusionsdispersion</div>
	 * <div class="fr">Code de Gaz pour dispersion injectable/ pour perfusion</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GAS_FOR_DISPERSION_FOR_INJECTION_INFUSION_CODE = "13050000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gel</div>
	 * <div class="de">Code für Gel</div>
	 * <div class="fr">Code de Gel</div>
	 * <div class="it">Code per Gel</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GEL_CODE = "10503000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gel for gel</div>
	 * <div class="de">Code für Gel zur Herstellung eines Gels</div>
	 * <div class="fr">Code de Gel pour gel</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GEL_FOR_GEL_CODE = "13014000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gel for injection</div>
	 * <div class="de">Code für Gel zur Injektion</div>
	 * <div class="fr">Code de Gel injectable</div>
	 * <div class="it">Code per Gel iniettabile</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GEL_FOR_INJECTION_CODE = "11204000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gingival gel</div>
	 * <div class="de">Code für Gel zur Anwendung am Zahnfleisch</div>
	 * <div class="fr">Code de Gel gingival</div>
	 * <div class="it">Code per Gel gengivale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GINGIVAL_GEL_CODE = "10315000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gingival paste</div>
	 * <div class="de">Code für Paste zur Anwendung am Zahnfleisch</div>
	 * <div class="fr">Code de P�te gingivale</div>
	 * <div class="it">Code per Pasta gengivale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GINGIVAL_PASTE_CODE = "10316000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gingival solution</div>
	 * <div class="de">Code für L�sung zur Anwendung am Zahnfleisch</div>
	 * <div class="fr">Code de Solution gingivale</div>
	 * <div class="it">Code per Soluzione gengivale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GINGIVAL_SOLUTION_CODE = "10312000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Granules</div>
	 * <div class="de">Code für Granulat</div>
	 * <div class="fr">Code de Granul�s</div>
	 * <div class="it">Code per Granulato</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GRANULES_CODE = "10204000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Granules for oral/rectal suspension</div>
	 * <div class="de">Code für Granulat zur Herstellung einer Suspension zum Einnehmen/Rektalsuspension</div>
	 * <div class="fr">Code de Granul�s pour suspension buvable/rectale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GRANULES_FOR_ORAL_RECTAL_SUSPENSION_CODE = "50029150";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Granules for oral solution</div>
	 * <div class="de">Code für Granulat zur Herstellung einer L�sung zum Einnehmen</div>
	 * <div class="fr">Code de Granul�s pour solution buvable</div>
	 * <div class="it">Code per Granulato per soluzione orale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GRANULES_FOR_ORAL_SOLUTION_CODE = "10112000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Granules for oral suspension</div>
	 * <div class="de">Code für Granulat zur Herstellung einer Suspension zum Einnehmen</div>
	 * <div class="fr">Code de Granul�s pour suspension buvable</div>
	 * <div class="it">Code per Granulato per sospensione orale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GRANULES_FOR_ORAL_SUSPENSION_CODE = "10113000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Granules for rectal suspension</div>
	 * <div class="de">Code für Granulat zur Herstellung einer Rektalsuspension</div>
	 * <div class="fr">Code de Granul�s pour suspension rectale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GRANULES_FOR_RECTAL_SUSPENSION_CODE = "13015000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Granules for suspension for injection</div>
	 * <div class="de">Code für Granulat zur Herstellung einer Injektionssuspension</div>
	 * <div class="fr">Code de Granul�s pour suspension injectable</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GRANULES_FOR_SUSPENSION_FOR_INJECTION_CODE = "13048000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Granules for syrup</div>
	 * <div class="de">Code für Granulat zur Herstellung eines Sirups</div>
	 * <div class="fr">Code de Granul�s pour sirop</div>
	 * <div class="it">Code per Granulato per sciroppo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GRANULES_FOR_SYRUP_CODE = "10119000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Granules for vaginal solution</div>
	 * <div class="de">Code für Granulat zur Herstellung einer Vaginall�sung</div>
	 * <div class="fr">Code de Granul�s pour solution vaginale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GRANULES_FOR_VAGINAL_SOLUTION_CODE = "50029500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Herbal tea</div>
	 * <div class="de">Code für Arzneitee</div>
	 * <div class="fr">Code de Plante(s) pour tisane</div>
	 * <div class="it">Code per Tisana</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HERBAL_TEA_CODE = "10122000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Implant</div>
	 * <div class="de">Code für Implantat</div>
	 * <div class="fr">Code de Implant</div>
	 * <div class="it">Code per Impianto</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMPLANT_CODE = "11301000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Implantation chain</div>
	 * <div class="de">Code für Kette zur Implantation</div>
	 * <div class="fr">Code de Implant en cha�ne</div>
	 * <div class="it">Code per Catenella per impianto</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMPLANTATION_CHAIN_CODE = "11303000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Implantation matrix</div>
	 * <div class="de">Code für Matrix zur Implantation</div>
	 * <div class="fr">Code de Matrice pour implantation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMPLANTATION_MATRIX_CODE = "11303300";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Implantation paste</div>
	 * <div class="de">Code für Paste f�r Implantate</div>
	 * <div class="fr">Code de P�te pour implantation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMPLANTATION_PASTE_CODE = "13043000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Implantation suspension</div>
	 * <div class="de">Code für Suspension zur Implantation</div>
	 * <div class="fr">Code de Suspension pour implantation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMPLANTATION_SUSPENSION_CODE = "11303500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Implantation tablet</div>
	 * <div class="de">Code für Tablette zur Implantation</div>
	 * <div class="fr">Code de Comprim� pour implantation</div>
	 * <div class="it">Code per Compressa per impianto</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMPLANTATION_TABLET_CODE = "11302000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Impregnated dressing</div>
	 * <div class="de">Code für impr�gnierter Verband</div>
	 * <div class="fr">Code de Compresse impr�gn�e</div>
	 * <div class="it">Code per Garza impregnata</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMPREGNATED_DRESSING_CODE = "10525000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Impregnated pad</div>
	 * <div class="de">Code für Impr�gnierter Tampon</div>
	 * <div class="fr">Code de Tampon impr�gn�</div>
	 * <div class="it">Code per Tampone medicato</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMPREGNATED_PAD_CODE = "12117000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Impregnated plug</div>
	 * <div class="de">Code für Impr�gnierter Einsatz</div>
	 * <div class="fr">Code de Support poreux impr�gn�</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMPREGNATED_PLUG_CODE = "12117500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation powder</div>
	 * <div class="de">Code für Pulver zur Inhalation</div>
	 * <div class="fr">Code de Poudre pour inhalation</div>
	 * <div class="it">Code per Polvere per inalazione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_POWDER_CODE = "11109000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation powder, hard capsule</div>
	 * <div class="de">Code für Hartkapsel mit Pulver zur Inhalation</div>
	 * <div class="fr">Code de Poudre pour inhalation en g�lule</div>
	 * <div class="it">Code per Polvere per inalazione, capsula rigida</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_POWDER_HARD_CAPSULE_CODE = "11110000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation powder, pre-dispensed</div>
	 * <div class="de">Code für einzeldosiertes Pulver zur Inhalation</div>
	 * <div class="fr">Code de Poudre pour inhalation en r�cipient unidose</div>
	 * <div class="it">Code per Polvere per inalazione in contenitore monodose</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_POWDER_PRE_DISPENSED_CODE = "11111000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation powder, tablet</div>
	 * <div class="de">Code für Tablette mit Pulver zur Inhalation</div>
	 * <div class="fr">Code de Comprim� pour inhalation par poudre</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_POWDER_TABLET_CODE = "50030000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation solution</div>
	 * <div class="de">Code für L�sung zur Inhalation</div>
	 * <div class="fr">Code de Solution � inhaler</div>
	 * <div class="it">Code per Soluzione per inalazione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_SOLUTION_CODE = "50081000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation vapour, capsule</div>
	 * <div class="de">Code für Kapsel zur Herstellung eines Dampfs zur Inhalation</div>
	 * <div class="fr">Code de Capsule pour inhalation par vapeur</div>
	 * <div class="it">Code per Capsula per suffumigi</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_VAPOUR_CAPSULE_CODE = "11113000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation vapour, effervescent tablet</div>
	 * <div class="de">Code für Brausetablette zur Herstellung eines Dampfs zur Inhalation</div>
	 * <div class="fr">Code de Comprim� effervescent pour inhalation par vapeur</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_VAPOUR_EFFERVESCENT_TABLET_CODE = "50031000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation vapour, emulsion</div>
	 * <div class="de">Code für Emulsion zur Herstellung eines Dampfs zur Inhalation</div>
	 * <div class="fr">Code de Emulsion pour inhalation par vapeur</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_VAPOUR_EMULSION_CODE = "50032000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation vapour, impregnated pad</div>
	 * <div class="de">Code für Dampf zur Inhalation, impr�gnierter Einsatz</div>
	 * <div class="fr">Code de Tampon impr�gn� pour inhalation par vapeur</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_VAPOUR_IMPREGNATED_PAD_CODE = "50033000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation vapour, impregnated plug</div>
	 * <div class="de">Code für Dampf zur Inhalation, impr�gnierter Einsatz</div>
	 * <div class="fr">Code de Support poreux impr�gn� pour inhalation par vapeur</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_VAPOUR_IMPREGNATED_PLUG_CODE = "50033100";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation vapour, liquid</div>
	 * <div class="de">Code für Fl�ssigkeit zur Herstellung eines Dampfs zur Inhalation</div>
	 * <div class="fr">Code de Liquide pour inhalation par vapeur</div>
	 * <div class="it">Code per Liquido per  suffumigi</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_VAPOUR_LIQUID_CODE = "11117000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation vapour, ointment</div>
	 * <div class="de">Code für Salbe zur Herstellung eines Dampfs zur Inhalation</div>
	 * <div class="fr">Code de Pommade pour inhalation par vapeur</div>
	 * <div class="it">Code per Unguento per suffumigi</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_VAPOUR_OINTMENT_CODE = "11116000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation vapour, powder</div>
	 * <div class="de">Code für Pulver zur Herstellung eines Dampfs zur Inhalation</div>
	 * <div class="fr">Code de Poudre pour inhalation par vapeur</div>
	 * <div class="it">Code per Polvere per suffumigi</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_VAPOUR_POWDER_CODE = "11112000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation vapour, solution</div>
	 * <div class="de">Code für L�sung zur Herstellung eines Dampfs zur Inhalation</div>
	 * <div class="fr">Code de Solution pour inhalation par vapeur</div>
	 * <div class="it">Code per Soluzione per  suffumigi</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_VAPOUR_SOLUTION_CODE = "11114000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation vapour, tablet</div>
	 * <div class="de">Code für Tablette zur Herstellung eines Dampfs zur Inhalation</div>
	 * <div class="fr">Code de Comprim� pour inhalation par vapeur</div>
	 * <div class="it">Code per Compressa per  suffumigi</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_VAPOUR_TABLET_CODE = "11115000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instant herbal tea</div>
	 * <div class="de">Code für Teeaufgusspulver</div>
	 * <div class="fr">Code de Pr�paration instantan�e pour tisane</div>
	 * <div class="it">Code per Tisana, polvere solubile</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTANT_HERBAL_TEA_CODE = "10202000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intestinal gel</div>
	 * <div class="de">Code für Gel zur intestinalen Anwendung</div>
	 * <div class="fr">Code de Gel intestinal</div>
	 * <div class="it">Code per Gel intestinale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTESTINAL_GEL_CODE = "12120000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intraocular instillation solution</div>
	 * <div class="de">Code für L�sung zur intraokularen Instillation</div>
	 * <div class="fr">Code de Solution pour instillation intraoculaire</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAOCULAR_INSTILLATION_SOLUTION_CODE = "13044000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intraperitoneal solution</div>
	 * <div class="de">Code für L�sung zur intraperitonealen Awendung</div>
	 * <div class="fr">Code de Solution intrap�riton�ale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAPERITONEAL_SOLUTION_CODE = "12111500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intrauterine delivery system</div>
	 * <div class="de">Code für Intrauterines Wirkstofffreisetzungssystem</div>
	 * <div class="fr">Code de Syst�me de diffusion intra-ut�rin</div>
	 * <div class="it">Code per Sistema a rilascio intrauterino</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAUTERINE_DELIVERY_SYSTEM_CODE = "11901000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intravesical solution</div>
	 * <div class="de">Code für L�sung zur intravesikalen Anwendung</div>
	 * <div class="fr">Code de Solution intrav�sicale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAVESICAL_SOLUTION_CODE = "11502500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intravesical solution/solution for injection</div>
	 * <div class="de">Code für L�sung zur intravesikalen Anwendung/Injektionsl�sung</div>
	 * <div class="fr">Code de Solution intrav�sicale/solution injectable</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAVESICAL_SOLUTION_SOLUTION_FOR_INJECTION_CODE = "50033400";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intravesical suspension</div>
	 * <div class="de">Code für Suspension zur intravesikalen Anwendung</div>
	 * <div class="fr">Code de Suspension intrav�sicale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAVESICAL_SUSPENSION_CODE = "13045000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Irrigation solution</div>
	 * <div class="de">Code für Sp�ll�sung</div>
	 * <div class="fr">Code de Solution pour irrigation</div>
	 * <div class="it">Code per Soluzione per irrigazione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IRRIGATION_SOLUTION_CODE = "12113000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Kit for radiopharmaceutical preparation</div>
	 * <div class="de">Code für Kit f�r ein radioaktives Arzneimittel</div>
	 * <div class="fr">Code de Trousse pour pr�paration radiopharmaceutique</div>
	 * <div class="it">Code per Kit per preparazione radiofarmaceutica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String KIT_FOR_RADIOPHARMACEUTICAL_PREPARATION_CODE = "12107000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Laryngopharyngeal solution</div>
	 * <div class="de">Code für L�sung zur Anwendung im Rachenraum und am Kehlkopf</div>
	 * <div class="fr">Code de Solution laryngopharyng�e</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LARYNGOPHARYNGEAL_SOLUTION_CODE = "13016000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Laryngopharyngeal spray, solution</div>
	 * <div class="de">Code für Spray zur Anwendung im Rachenraum und am Kehlkopf, L�sung</div>
	 * <div class="fr">Code de Solution pour pulv�risation laryngopharyng�e</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LARYNGOPHARYNGEAL_SPRAY_SOLUTION_CODE = "13017000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Living tissue equivalent</div>
	 * <div class="de">Code für lebendes Gewebe�quivalent</div>
	 * <div class="fr">Code de Substitut de tissu vivant</div>
	 * <div class="it">Code per Tessuto vivente da coltura di cellule</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LIVING_TISSUE_EQUIVALENT_CODE = "12118000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Lozenge</div>
	 * <div class="de">Code für Lutschtablette</div>
	 * <div class="fr">Code de Pastille</div>
	 * <div class="it">Code per Pastiglia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LOZENGE_CODE = "10321000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Matrix for implantation matrix</div>
	 * <div class="de">Code für Matrix f�r Matrix zur Implantation</div>
	 * <div class="fr">Code de Matrice pour matrice pour implantation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MATRIX_FOR_IMPLANTATION_MATRIX_CODE = "13018000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Medicated chewing-gum</div>
	 * <div class="de">Code für wirkstoffhaltiges Kaugummi</div>
	 * <div class="fr">Code de Gomme � m�cher m�dicamenteuse</div>
	 * <div class="it">Code per Gomma da masticare medicata</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MEDICATED_CHEWING_GUM_CODE = "10229000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Medicated nail lacquer</div>
	 * <div class="de">Code für wirkstoffhaltiger Nagellack</div>
	 * <div class="fr">Code de Vernis � ongles m�dicamenteux</div>
	 * <div class="it">Code per Smalto medicato per unghie</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MEDICATED_NAIL_LACQUER_CODE = "10521000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Medicated plaster</div>
	 * <div class="de">Code für wirkstoffhaltiges Pflaster</div>
	 * <div class="fr">Code de Empl�tre m�dicamenteux</div>
	 * <div class="it">Code per Empiastro medicato</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MEDICATED_PLASTER_CODE = "10506000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Medicated sponge</div>
	 * <div class="de">Code für wirkstoffhaltiges Schw�mmchen</div>
	 * <div class="fr">Code de Eponge m�dicamenteuse</div>
	 * <div class="it">Code per Spugna medicata</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MEDICATED_SPONGE_CODE = "12119000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Medicated thread</div>
	 * <div class="de">Code für wirkstoffhaltiger Faden</div>
	 * <div class="fr">Code de Fils m�dicamenteux</div>
	 * <div class="it">Code per Filo medicato</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MEDICATED_THREAD_CODE = "12130000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Medicated vaginal tampon</div>
	 * <div class="de">Code für Wirkstoffhaltiger Vaginaltampon</div>
	 * <div class="fr">Code de Tampon vaginal m�dicamenteux</div>
	 * <div class="it">Code per Tampone vaginale medicato</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MEDICATED_VAGINAL_TAMPON_CODE = "10914000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Medicinal gas, compressed</div>
	 * <div class="de">Code für Gas zur medizinischen Anwendung, druckverdichtet</div>
	 * <div class="fr">Code de Gaz m�dicinal comprim�</div>
	 * <div class="it">Code per Gas medicinale compresso</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MEDICINAL_GAS_COMPRESSED_CODE = "12301000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Medicinal gas, cryogenic</div>
	 * <div class="de">Code für Gas zur medizinischen Anwendung, k�lteverfl�ssigt</div>
	 * <div class="fr">Code de Gaz m�dicinal cryog�nique</div>
	 * <div class="it">Code per Gas medicinale criogenico</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MEDICINAL_GAS_CRYOGENIC_CODE = "12302000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Medicinal gas, liquefied</div>
	 * <div class="de">Code für Gas zur medizinischen Anwendung, verfl�ssigt</div>
	 * <div class="fr">Code de Gaz m�dicinal liqu�fi�</div>
	 * <div class="it">Code per Gas medicinale liquefatto</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MEDICINAL_GAS_LIQUEFIED_CODE = "12303000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Modified-release capsule, hard</div>
	 * <div class="de">Code für Hartkapsel mit ver�nderter Wirkstofffreisetzung</div>
	 * <div class="fr">Code de G�lule � lib�ration modifi�e</div>
	 * <div class="it">Code per Capsula rigida a rilascio modificato</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MODIFIED_RELEASE_CAPSULE_HARD_CODE = "10217000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Modified-release capsule, soft</div>
	 * <div class="de">Code für Weichkapsel mit ver�nderter Wirkstofffreisetzung</div>
	 * <div class="fr">Code de Capsule molle � lib�ration modifi�e</div>
	 * <div class="it">Code per Capsula molle a rilascio modificato</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MODIFIED_RELEASE_CAPSULE_SOFT_CODE = "10218000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Modified-release granules</div>
	 * <div class="de">Code für Granulat mit ver�nderter Wirkstofffreisetzung</div>
	 * <div class="fr">Code de Granul�s � lib�ration modifi�e</div>
	 * <div class="it">Code per Granulato a rilascio modificato</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MODIFIED_RELEASE_GRANULES_CODE = "10208000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Modified-release granules for oral suspension</div>
	 * <div class="de">Code für Granulat mit ver�nderter Wirkstofffreisetzung zur Herstellung einer Suspension zum Einnehmen</div>
	 * <div class="fr">Code de Granul�s � lib�ration modifi�e pour suspension buvable</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MODIFIED_RELEASE_GRANULES_FOR_ORAL_SUSPENSION_CODE = "50036000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Modified-release tablet</div>
	 * <div class="de">Code für Tablette mit ver�nderter Wirkstofffreisetzung</div>
	 * <div class="fr">Code de Comprim� � lib�ration modifi�e</div>
	 * <div class="it">Code per Compressa a rilascio modificato</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MODIFIED_RELEASE_TABLET_CODE = "10227000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Mouthwash</div>
	 * <div class="de">Code für Mundwasser</div>
	 * <div class="fr">Code de Solution pour bain de bouche</div>
	 * <div class="it">Code per Collutorio</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MOUTHWASH_CODE = "10310000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Mouthwash, powder for solution</div>
	 * <div class="de">Code für Pulver zur Herstellung einer Mundsp�lung, L�sung</div>
	 * <div class="fr">Code de Poudre pour solution pour bain de bouche</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MOUTHWASH_POWDER_FOR_SOLUTION_CODE = "50036050";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Mouthwash, tablet for solution</div>
	 * <div class="de">Code für Tablette zur Herstellung eines Mundwassers</div>
	 * <div class="fr">Code de Comprim� pour solution pour bain de bouche</div>
	 * <div class="it">Code per Compressa per soluzione per collutorio</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MOUTHWASH_TABLET_FOR_SOLUTION_CODE = "10311000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Muco-adhesive buccal tablet</div>
	 * <div class="de">Code für mucoadh�sive Buccaltablette</div>
	 * <div class="fr">Code de Comprim� buccogingival muco-adh�sif</div>
	 * <div class="it">Code per Compressa buccale mucoadesiva</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MUCO_ADHESIVE_BUCCAL_TABLET_CODE = "10319000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nasal cream</div>
	 * <div class="de">Code für Nasencreme</div>
	 * <div class="fr">Code de Cr�me nasale</div>
	 * <div class="it">Code per Crema nasale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NASAL_CREAM_CODE = "10801000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nasal drops, emulsion</div>
	 * <div class="de">Code für Nasentropfen, Emulsion</div>
	 * <div class="fr">Code de Emulsion nasale en gouttes</div>
	 * <div class="it">Code per Gocce nasali, emulsione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NASAL_DROPS_EMULSION_CODE = "10806000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nasal drops, powder for solution</div>
	 * <div class="de">Code für Pulver zur Herstellung von Nasentropfen, L�sung</div>
	 * <div class="fr">Code de Poudre pour solution nasale en gouttes</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NASAL_DROPS_POWDER_FOR_SOLUTION_CODE = "13020000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nasal drops, solution</div>
	 * <div class="de">Code für Nasentropfen, L�sung</div>
	 * <div class="fr">Code de Solution nasale en gouttes</div>
	 * <div class="it">Code per Gocce nasali, soluzione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NASAL_DROPS_SOLUTION_CODE = "10804000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nasal drops, suspension</div>
	 * <div class="de">Code für Nasentropfen, Suspension</div>
	 * <div class="fr">Code de Suspension nasale en gouttes</div>
	 * <div class="it">Code per Gocce nasali, sospensione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NASAL_DROPS_SUSPENSION_CODE = "10805000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nasal gel</div>
	 * <div class="de">Code für Nasengel</div>
	 * <div class="fr">Code de Gel nasal</div>
	 * <div class="it">Code per Gel nasale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NASAL_GEL_CODE = "10802000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nasal ointment</div>
	 * <div class="de">Code für Nasensalbe</div>
	 * <div class="fr">Code de Pommade nasale</div>
	 * <div class="it">Code per Unguento nasale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NASAL_OINTMENT_CODE = "10803000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nasal/oromucosal solution</div>
	 * <div class="de">Code für L�sung zur nasalen Anwendung/L�sung zur Anwendung in der Mundh�hle</div>
	 * <div class="fr">Code de Solution nasale/buccale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NASAL_OROMUCOSAL_SOLUTION_CODE = "50036500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nasal/oromucosal spray, solution</div>
	 * <div class="de">Code für Nasenspray und Spray zur Anwendung in der Mundh�hle, L�sung</div>
	 * <div class="fr">Code de Solution pour pulv�risation nasale/ buccale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NASAL_OROMUCOSAL_SPRAY_SOLUTION_CODE = "50036700";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nasal powder</div>
	 * <div class="de">Code für Nasenpulver</div>
	 * <div class="fr">Code de Poudre nasale</div>
	 * <div class="it">Code per Polvere nasale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NASAL_POWDER_CODE = "10807000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nasal spray, emulsion</div>
	 * <div class="de">Code für Nasenspray, Emulsion</div>
	 * <div class="fr">Code de Emulsion pour pulv�risation nasale</div>
	 * <div class="it">Code per Spray nasale, emulsione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NASAL_SPRAY_EMULSION_CODE = "10810000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nasal spray, powder for solution</div>
	 * <div class="de">Code für Nasenspray, Pulver zur Herstellung einer L�sung</div>
	 * <div class="fr">Code de Poudre pour solution pour pulv�risation nasale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NASAL_SPRAY_POWDER_FOR_SOLUTION_CODE = "50037100";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nasal spray, solution</div>
	 * <div class="de">Code für Nasenspray, L�sung</div>
	 * <div class="fr">Code de Solution pour pulv�risation nasale</div>
	 * <div class="it">Code per Spray nasale, soluzione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NASAL_SPRAY_SOLUTION_CODE = "10808000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nasal spray, solution/oromucosal solution</div>
	 * <div class="de">Code für Nasenspray, L�sung/L�sung zur Anwendung in der Mundh�hle</div>
	 * <div class="fr">Code de Solution pour pulv�risation nasale/ solution buccale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NASAL_SPRAY_SOLUTION_OROMUCOSAL_SOLUTION_CODE = "50037400";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nasal spray, suspension</div>
	 * <div class="de">Code für Nasenspray, Suspension</div>
	 * <div class="fr">Code de Suspension pour pulv�risation nasale</div>
	 * <div class="it">Code per Spray nasale, sospensione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NASAL_SPRAY_SUSPENSION_CODE = "10809000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nasal stick</div>
	 * <div class="de">Code für Nasenstift</div>
	 * <div class="fr">Code de B�ton pour usage nasal</div>
	 * <div class="it">Code per Bastoncino nasale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NASAL_STICK_CODE = "10812000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nasal wash</div>
	 * <div class="de">Code für Nasensp�lung</div>
	 * <div class="fr">Code de Solution pour lavage nasal</div>
	 * <div class="it">Code per Lavaggio nasale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NASAL_WASH_CODE = "10811000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nebuliser emulsion</div>
	 * <div class="de">Code für Emulsion f�r einen Vernebler</div>
	 * <div class="fr">Code de Emulsion pour inhalation par n�buliseur</div>
	 * <div class="it">Code per Emulsione per nebulizzatore</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEBULISER_EMULSION_CODE = "11105000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nebuliser solution</div>
	 * <div class="de">Code für L�sung f�r einen Vernebler</div>
	 * <div class="fr">Code de Solution pour inhalation par n�buliseur</div>
	 * <div class="it">Code per Soluzione per nebulizzatore</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEBULISER_SOLUTION_CODE = "11101000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nebuliser suspension</div>
	 * <div class="de">Code für Suspension f�r einen Vernebler</div>
	 * <div class="fr">Code de Suspension pour inhalation par n�buliseur</div>
	 * <div class="it">Code per Sospensione per nebulizzatore</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEBULISER_SUSPENSION_CODE = "11102000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ointment</div>
	 * <div class="de">Code für Salbe</div>
	 * <div class="fr">Code de Pommade</div>
	 * <div class="it">Code per Unguento</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OINTMENT_CODE = "10504000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ophthalmic insert</div>
	 * <div class="de">Code für Augeninsert</div>
	 * <div class="fr">Code de Insert ophtalmique</div>
	 * <div class="it">Code per Inserto oftalmico</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OPHTHALMIC_INSERT_CODE = "10612000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ophthalmic strip</div>
	 * <div class="de">Code für Teststreifen zur Anwendung am Auge</div>
	 * <div class="fr">Code de Bandelette ophtalmique</div>
	 * <div class="it">Code per Striscia oftalmica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OPHTHALMIC_STRIP_CODE = "10613000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oral drops, emulsion</div>
	 * <div class="de">Code für Tropfen zum Einnehmen, Emulsion</div>
	 * <div class="fr">Code de Emulsion buvable en gouttes</div>
	 * <div class="it">Code per Gocce orali, emulsione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORAL_DROPS_EMULSION_CODE = "10103000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oral drops, granules for solution</div>
	 * <div class="de">Code für Granulat zur Herstellung von Tropfen zum Einnehmen, L�sung</div>
	 * <div class="fr">Code de Granul�s pour solution buvale en gouttes</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORAL_DROPS_GRANULES_FOR_SOLUTION_CODE = "50037500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oral drops, liquid</div>
	 * <div class="de">Code für Tropfen zum Einnehmen, Fl�ssigkeit</div>
	 * <div class="fr">Code de Liquide oral en gouttes</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORAL_DROPS_LIQUID_CODE = "50037750";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oral drops, powder for suspension</div>
	 * <div class="de">Code für Pulver zur Herstellung von Tropfen zum Einnehmen, Suspension</div>
	 * <div class="fr">Code de Poudre pour suspension oral en gouttes</div>
	 * <div class="it">Code per Gocce orali, polvere per sospensione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORAL_DROPS_POWDER_FOR_SUSPENSION_CODE = "50082000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oral drops, solution</div>
	 * <div class="de">Code für Tropfen zum Einnehmen, L�sung</div>
	 * <div class="fr">Code de Solution buvable en gouttes</div>
	 * <div class="it">Code per Gocce orali, soluzione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORAL_DROPS_SOLUTION_CODE = "10101000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oral drops, suspension</div>
	 * <div class="de">Code für Tropfen zum Einnehmen, Suspension</div>
	 * <div class="fr">Code de Suspension buvable en gouttes</div>
	 * <div class="it">Code per Gocce orali, sospensione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORAL_DROPS_SUSPENSION_CODE = "10102000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oral emulsion</div>
	 * <div class="de">Code für Emulsion zum Einnehmen</div>
	 * <div class="fr">Code de Emulsion buvable</div>
	 * <div class="it">Code per Emulsione orale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORAL_EMULSION_CODE = "10107000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oral gel</div>
	 * <div class="de">Code für Gel zum Einnehmen</div>
	 * <div class="fr">Code de Gel oral</div>
	 * <div class="it">Code per Gel orale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORAL_GEL_CODE = "10108000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oral gum</div>
	 * <div class="de">Code für Lutschpastille</div>
	 * <div class="fr">Code de Gomme orale</div>
	 * <div class="it">Code per Pastiglia gommosa</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORAL_GUM_CODE = "10230000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oral herbal material</div>
	 * <div class="de">Code für 0</div>
	 * <div class="fr">Code de 0</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORAL_HERBAL_MATERIAL_CODE = "13106000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oral liquid</div>
	 * <div class="de">Code für Fl�ssigkeit zum Einnehmen</div>
	 * <div class="fr">Code de Liquide oral</div>
	 * <div class="it">Code per Liquido orale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORAL_LIQUID_CODE = "10104000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oral lyophilisate</div>
	 * <div class="de">Code für Lyophilisat zum Einnehmen</div>
	 * <div class="fr">Code de Lyophilisat oral</div>
	 * <div class="it">Code per Liofilizzato orale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORAL_LYOPHILISATE_CODE = "10224000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oral paste</div>
	 * <div class="de">Code für Paste zum Einnehmen</div>
	 * <div class="fr">Code de P�te orale</div>
	 * <div class="it">Code per Pasta per uso orale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORAL_PASTE_CODE = "10109000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oral powder</div>
	 * <div class="de">Code für Pulver zum Einnehmen</div>
	 * <div class="fr">Code de Poudre orale</div>
	 * <div class="it">Code per Polvere orale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORAL_POWDER_CODE = "10201000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oral/rectal solution</div>
	 * <div class="de">Code für L�sung zum Einnehmen/Rektall�sung</div>
	 * <div class="fr">Code de Solution buvable/rectale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORAL_RECTAL_SOLUTION_CODE = "50037900";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oral/rectal suspension</div>
	 * <div class="de">Code für Suspension zum Einnehmen/Rektalsuspension</div>
	 * <div class="fr">Code de Suspension buvable/rectale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORAL_RECTAL_SUSPENSION_CODE = "50038000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oral solution</div>
	 * <div class="de">Code für L�sung zum Einnehmen</div>
	 * <div class="fr">Code de Solution  buvable</div>
	 * <div class="it">Code per Soluzione orale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORAL_SOLUTION_CODE = "10105000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oral solution/concentrate for nebuliser solution</div>
	 * <div class="de">Code für L�sung zum Einnehmen/ Konzentrat zur Herstellung einer L�sung f�r einen Vernebler</div>
	 * <div class="fr">Code de Solution orale/solution � diluer pour inhalation par n�buliseur</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORAL_SOLUTION_CONCENTRATE_FOR_NEBULISER_SOLUTION_CODE = "50038500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oral suspension</div>
	 * <div class="de">Code für Suspension zum Einnehmen</div>
	 * <div class="fr">Code de Suspension buvable</div>
	 * <div class="it">Code per Sospensione orale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORAL_SUSPENSION_CODE = "10106000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Orodispersible film</div>
	 * <div class="de">Code für Schmelzfilm</div>
	 * <div class="fr">Code de Film orodispersible</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORODISPERSIBLE_FILM_CODE = "10236100";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Orodispersible tablet</div>
	 * <div class="de">Code für Schmelztablette</div>
	 * <div class="fr">Code de Comprim� orodispersible</div>
	 * <div class="it">Code per Compressa orodispersibile</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORODISPERSIBLE_TABLET_CODE = "10223000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oromucosal capsule</div>
	 * <div class="de">Code für Kapsel zur Anwendung in der Mundh�hle</div>
	 * <div class="fr">Code de Capsule buccale</div>
	 * <div class="it">Code per Capsula per mucosa orale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OROMUCOSAL_CAPSULE_CODE = "10317000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oromucosal cream</div>
	 * <div class="de">Code für Creme zur Anwendung in der Mundh�hle</div>
	 * <div class="fr">Code de cr�me buccale</div>
	 * <div class="it">Code per Crema per mucosa orale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OROMUCOSAL_CREAM_CODE = "10314010";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oromucosal drops</div>
	 * <div class="de">Code für Tropfen zur Anwendung in der Mundh�hle</div>
	 * <div class="fr">Code de Solution buccale en gouttes</div>
	 * <div class="it">Code per Gocce per mucosa orale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OROMUCOSAL_DROPS_CODE = "10307000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oromucosal gel</div>
	 * <div class="de">Code für Gel zur Anwendung in der Mundh�hle</div>
	 * <div class="fr">Code de Gel buccal</div>
	 * <div class="it">Code per Gel per mucosa orale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OROMUCOSAL_GEL_CODE = "10313000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oromucosal/laryngopharyngeal solution</div>
	 * <div class="de">Code für L�sung zur Anwendung in der Mundh�hle/im Rachenraum und am Kehlkopf</div>
	 * <div class="fr">Code de Solution buccale/laryngopharyng�e</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OROMUCOSAL_LARYNGOPHARYNGEAL_SOLUTION_CODE = "50039500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oromucosal/laryngopharyngeal solution/spray, solution</div>
	 * <div class="de">Code für L�sung/Spray zur Anwendung in der Mundh�hle/im Rachenraum oder am Kehlkopf, L�sung</div>
	 * <div class="fr">Code de Solution/ solution pour pulv�risation buccale/ laryngopharyng�e</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OROMUCOSAL_LARYNGOPHARYNGEAL_SOLUTION_SPRAY_SOLUTION_CODE = "50040500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oromucosal ointment</div>
	 * <div class="de">Code für Salbe zur Anwendung in der Mundh�hle</div>
	 * <div class="fr">Code de Pommade buccale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OROMUCOSAL_OINTMENT_CODE = "10314005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oromucosal paste</div>
	 * <div class="de">Code für Paste zur Anwendung in der Mundh�hle</div>
	 * <div class="fr">Code de P�te buccale</div>
	 * <div class="it">Code per Pasta per mucosa orale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OROMUCOSAL_PASTE_CODE = "10314000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oromucosal patch</div>
	 * <div class="de">Code für Pflaster zur Anwendung in der Mundh�hle</div>
	 * <div class="fr">Code de Patch buccal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OROMUCOSAL_PATCH_CODE = "50039000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oromucosal solution</div>
	 * <div class="de">Code für L�sung zur Anwendung in der Mundh�hle</div>
	 * <div class="fr">Code de Solution buccale</div>
	 * <div class="it">Code per Soluzione per mucosa orale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OROMUCOSAL_SOLUTION_CODE = "10305000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oromucosal spray, emulsion</div>
	 * <div class="de">Code für Spray zur Anwendung in der Mundh�hle, Emulsion</div>
	 * <div class="fr">Code de Emulsion pour pulv�risation buccale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OROMUCOSAL_SPRAY_EMULSION_CODE = "10308100";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oromucosal spray, solution</div>
	 * <div class="de">Code für Spray zur Anwendung in der Mundh�hle, L�sung</div>
	 * <div class="fr">Code de Solution pour pulv�risation buccale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OROMUCOSAL_SPRAY_SOLUTION_CODE = "10308200";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oromucosal spray, suspension</div>
	 * <div class="de">Code für Spray zur Anwendung in der Mundh�hle, Suspension</div>
	 * <div class="fr">Code de Suspension pour pulv�risation buccale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OROMUCOSAL_SPRAY_SUSPENSION_CODE = "10308300";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oromucosal suspension</div>
	 * <div class="de">Code für Suspension zur Anwendung in der Mundh�hle</div>
	 * <div class="fr">Code de Suspension buccale</div>
	 * <div class="it">Code per Sospensione per mucosa orale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OROMUCOSAL_SUSPENSION_CODE = "10306000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pastille</div>
	 * <div class="de">Code für Pastille</div>
	 * <div class="fr">Code de P�te � sucer</div>
	 * <div class="it">Code per Pastiglia molle</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PASTILLE_CODE = "10323000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Periodontal gel</div>
	 * <div class="de">Code für Gel zur periodontalen Anwendung</div>
	 * <div class="fr">Code de Gel p�riodontal</div>
	 * <div class="it">Code per Gel periodontale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PERIODONTAL_GEL_CODE = "10410000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Periodontal insert</div>
	 * <div class="de">Code für Insert zur periodontalen Anwendung</div>
	 * <div class="fr">Code de Insert p�riodontal</div>
	 * <div class="it">Code per Inserto periodontale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PERIODONTAL_INSERT_CODE = "10411000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Periodontal powder</div>
	 * <div class="de">Code für Pulver zur periodontalen Anwendung</div>
	 * <div class="fr">Code de Poudre p�ridontale</div>
	 * <div class="it">Code per Polvere periodontale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PERIODONTAL_POWDER_CODE = "10401000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pessary</div>
	 * <div class="de">Code für Vaginalz�pfchen</div>
	 * <div class="fr">Code de Ovule</div>
	 * <div class="it">Code per Ovulo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PESSARY_CODE = "10909000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pillules</div>
	 * <div class="de">Code für Streuk�gelchen</div>
	 * <div class="fr">Code de Granules</div>
	 * <div class="it">Code per Granuli</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PILLULES_CODE = "10231000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Plaster for provocation test</div>
	 * <div class="de">Code für Pflaster f�r Provokationstest</div>
	 * <div class="fr">Code de patch pour test �picutan�</div>
	 * <div class="it">Code per Cerotto per saggio di provocazione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PLASTER_FOR_PROVOCATION_TEST_CODE = "10550000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pouch</div>
	 * <div class="de">Code für Beutelchen</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POUCH_CODE = "30047500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Poultice</div>
	 * <div class="de">Code für Umschlagpaste</div>
	 * <div class="fr">Code de Cataplasme</div>
	 * <div class="it">Code per Cataplasma</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POULTICE_CODE = "10522000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for bladder irrigation</div>
	 * <div class="de">Code für Pulver zur Herstellung einer Blasensp�ll�sung</div>
	 * <div class="fr">Code de Poudre pour solution pour irrigation v�sicale</div>
	 * <div class="it">Code per Polvere per irrigazione vescicale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_BLADDER_IRRIGATION_CODE = "11503000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for concentrate for dispersion for infusion</div>
	 * <div class="de">Code für Pulver f�r ein Konzentrat zur Herstellung einer Infusionsdispersion</div>
	 * <div class="fr">Code de Poudre pour dispersion � diluer pour dispersion pour perfusion</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_CONCENTRATE_FOR_DISPERSION_FOR_INFUSION_CODE = "50048750";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for concentrate for intravesical suspension</div>
	 * <div class="de">Code für Pulver f�r ein Konzentrat zur Herstellung einer Suspension zur intravesikalen Anwendung</div>
	 * <div class="fr">Code de Poudre pour suspension � diluer pour suspension intrav�sicale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_CONCENTRATE_FOR_INTRAVESICAL_SUSPENSION_CODE = "50049100";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for concentrate for solution for haemodialysis</div>
	 * <div class="de">Code für Pulver f�r ein Konzentrat zur Herstellung einer H�modialysel�sung</div>
	 * <div class="fr">Code de Poudre pour solution � diluer pour solution pour h�modialyse</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_CONCENTRATE_FOR_SOLUTION_FOR_HAEMODIALYSIS_CODE = "50049200";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for concentrate for solution for infusion</div>
	 * <div class="de">Code für Pulver f�r ein Konzentrat zur Herstellung einer Infusionsl�sung</div>
	 * <div class="fr">Code de Poudre pour solution � diluer pour perfusion</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_CONCENTRATE_FOR_SOLUTION_FOR_INFUSION_CODE = "50043000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for concentrate for solution for injection/infusion</div>
	 * <div class="de">Code für Pulver f�r ein Konzentrat zur Herstellung einer Injektions-/Infusionsl�sung</div>
	 * <div class="fr">Code de Poudre pour solution � diluer pour solution injectable/pour perfusion</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_CONCENTRATE_FOR_SOLUTION_FOR_INJECTION_INFUSION_CODE = "50049250";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for cutaneous solution</div>
	 * <div class="de">Code für Pulver zur Herstellung einer L�sung zur Anwendung auf der Haut</div>
	 * <div class="fr">Code de Poudre pour solution cutan�e</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_CUTANEOUS_SOLUTION_CODE = "10514500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for dental cement</div>
	 * <div class="de">Code für Pulver zur Herstellung eines Dentalzements</div>
	 * <div class="fr">Code de Poudre pour ciment dentaire</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_DENTAL_CEMENT_CODE = "10413000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for dental gel</div>
	 * <div class="de">Code für Pulver zur Herstellung eines Dentalgels</div>
	 * <div class="fr">Code de Poudre pour gel dentaire</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_DENTAL_GEL_CODE = "13022000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for dental solution</div>
	 * <div class="de">Code für Pulver zur Herstellung einer Dentall�sung</div>
	 * <div class="fr">Code de Poudre pour solution dentaire</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_DENTAL_SOLUTION_CODE = "50049270";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for dispersion for infusion</div>
	 * <div class="de">Code für Pulver zur Herstellung einer Infusionsdispersion</div>
	 * <div class="fr">Code de Poudre pour dispersion pour perfusion</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_DISPERSION_FOR_INFUSION_CODE = "11211500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for dispersion for injection</div>
	 * <div class="de">Code für Pulver zur Herstellung einer Injektionsdispersion</div>
	 * <div class="fr">Code de Poudre pour dispersion injectable</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_DISPERSION_FOR_INJECTION_CODE = "13023000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for emulsion for injection</div>
	 * <div class="de">Code für Pulver zur Herstellung einer Emulsion zur Injektion</div>
	 * <div class="fr">Code de Poudre pour �mulsion injectable</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_EMULSION_FOR_INJECTION_CODE = "13040000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for endocervical gel</div>
	 * <div class="de">Code für Pulver zur Herstellung eines Gels zur endozervikalen Anwendung</div>
	 * <div class="fr">Code de Poudre pour gel endocervical</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_ENDOCERVICAL_GEL_CODE = "13024000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for endosinusial solution</div>
	 * <div class="de">Code für Pulver zur Herstellung einer L�sung zur Anwendung in den Nasennebenh�hlen</div>
	 * <div class="fr">Code de Poudre pour solution endosinusale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_ENDOSINUSIAL_SOLUTION_CODE = "13025000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for epilesional solution</div>
	 * <div class="de">Code für Pulver zur Herstellung einer L�sung zum Auftragen auf die Wunde</div>
	 * <div class="fr">Code de Poudre pour solution �pil�sionnelle</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_EPILESIONAL_SOLUTION_CODE = "50049300";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for gel</div>
	 * <div class="de">Code für Pulver zur Herstellung eines Gels</div>
	 * <div class="fr">Code de Poudre pour gel</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_GEL_CODE = "13021000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for gingival gel</div>
	 * <div class="de">Code für Pulver zur Herstellung eines Gels zur Anwendung am Zahnfleisch</div>
	 * <div class="fr">Code de Poudre pour gel gingival</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_GINGIVAL_GEL_CODE = "13026000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for implantation matrix</div>
	 * <div class="de">Code für Pulver f�r Matrix zur Implantation</div>
	 * <div class="fr">Code de Poudre pour matrice pour implantation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_IMPLANTATION_MATRIX_CODE = "13027000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for implantation paste</div>
	 * <div class="de">Code für Pulver zur Herstellung einer Paste f�r ein Implantat</div>
	 * <div class="fr">Code de Poudre pour p�te pour implantation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_IMPLANTATION_PASTE_CODE = "13028000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for implantation suspension</div>
	 * <div class="de">Code für Pulver zur Herstellung einer Suspension zur Implantation</div>
	 * <div class="fr">Code de Poudre pour suspension pour implantation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_IMPLANTATION_SUSPENSION_CODE = "50049500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for intraocular instillation solution</div>
	 * <div class="de">Code für Pulver zur Herstellung einer Instillationsl�sung zur intraokularen Anwendung</div>
	 * <div class="fr">Code de Poudre pour solution pour instillation intraoculaire</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_INTRAOCULAR_INSTILLATION_SOLUTION_CODE = "13029000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for intravesical solution</div>
	 * <div class="de">Code für Pulver zur Herstellung einer L�sung zur intravesikalen Anwendung</div>
	 * <div class="fr">Code de Poudre pour solution intrav�sicale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_INTRAVESICAL_SOLUTION_CODE = "50050000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for intravesical solution/solution for injection</div>
	 * <div class="de">Code für Pulver zur Herstellung einer L�sung zur intravesikalen Anwendung / Injektionsl�sung</div>
	 * <div class="fr">Code de Poudre pour solution intrav�sicale/injectable</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_INTRAVESICAL_SOLUTION_SOLUTION_FOR_INJECTION_CODE = "50050500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for intravesical suspension</div>
	 * <div class="de">Code für Pulver zur Herstellung einer Suspensionen zur intravesikalen Anwendung</div>
	 * <div class="fr">Code de Poudre pour suspension intrav�sicale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_INTRAVESICAL_SUSPENSION_CODE = "50051000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for nebuliser solution</div>
	 * <div class="de">Code für Pulver zur Herstellung einer L�sung f�r einen Vernebler</div>
	 * <div class="fr">Code de Poudre pour solution pour inhalation par n�buliseur</div>
	 * <div class="it">Code per Polvere per soluzione per nebulizzatore</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_NEBULISER_SOLUTION_CODE = "11104000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for nebuliser suspension</div>
	 * <div class="de">Code für Pulver zur Herstellung einer Suspension f�r einen Vernebler</div>
	 * <div class="fr">Code de Poudre pour suspension pour inhalation par n�buliseur</div>
	 * <div class="it">Code per Polvere per sospensione per nebulizzatore</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_NEBULISER_SUSPENSION_CODE = "11103000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for oral/rectal suspension</div>
	 * <div class="de">Code für Pulver zur Herstellung einer Suspension zum Einnehmen/Rektalsuspension</div>
	 * <div class="fr">Code de Poudre pour suspension oral/rectal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_ORAL_RECTAL_SUSPENSION_CODE = "50052000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for oral solution</div>
	 * <div class="de">Code für Pulver zur Herstellung einer L�sung zum Einnehmen</div>
	 * <div class="fr">Code de Poudre pour solution buvable</div>
	 * <div class="it">Code per Polvere per soluzione orale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_ORAL_SOLUTION_CODE = "10110000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for oral suspension</div>
	 * <div class="de">Code für Pulver zur Herstellung einer Suspension zum Einnehmen</div>
	 * <div class="fr">Code de Poudre pour suspension buvable</div>
	 * <div class="it">Code per Polvere per sospensione orale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_ORAL_SUSPENSION_CODE = "10111000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for prolonged-release suspension for injection</div>
	 * <div class="de">Code für Pulver zur Herstellung einer Depot-Injektionssuspension</div>
	 * <div class="fr">Code de Poudre pour suspension injectable � lib�ration prolong�e</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_PROLONGED_RELEASE_SUSPENSION_FOR_INJECTION_CODE = "11208400";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for rectal solution</div>
	 * <div class="de">Code für Pulver zur Herstellung einer Rektall�sung</div>
	 * <div class="fr">Code de Poudre pour solution rectale</div>
	 * <div class="it">Code per Polvere per soluzione rettale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_RECTAL_SOLUTION_CODE = "11009000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for rectal suspension</div>
	 * <div class="de">Code für Pulver zur Herstellung einer Rektalsuspension</div>
	 * <div class="fr">Code de Poudre pour suspension rectale</div>
	 * <div class="it">Code per Polvere per sospensione rettale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_RECTAL_SUSPENSION_CODE = "11010000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for sealant</div>
	 * <div class="de">Code für Pulver f�r einen Gewebekleber</div>
	 * <div class="fr">Code de Poudre pour colle</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_SEALANT_CODE = "13031000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for solution for infusion</div>
	 * <div class="de">Code für Pulver zur Herstellung einer Infusionsl�sung</div>
	 * <div class="fr">Code de Poudre pour solution pour perfusion</div>
	 * <div class="it">Code per Polvere per soluzione per infusione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_SOLUTION_FOR_INFUSION_CODE = "11212000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for solution for injection</div>
	 * <div class="de">Code für Pulver zur Herstellung einer Injektionsl�sung</div>
	 * <div class="fr">Code de Poudre pour solution injectable</div>
	 * <div class="it">Code per Polvere per soluzione iniettabile</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_SOLUTION_FOR_INJECTION_CODE = "11205000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for solution for injection/infusion</div>
	 * <div class="de">Code für Pulver zur Herstellung einer Injektions-/Infusionsl�sung</div>
	 * <div class="fr">Code de Poudre pour solution injectable/pour perfusion</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_SOLUTION_FOR_INJECTION_INFUSION_CODE = "50053500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for solution for injection/skin-prick test</div>
	 * <div class="de">Code für Pulver zur Herstellung einer Injektionsl�sung/Pricktestl�sung</div>
	 * <div class="fr">Code de Poudre pour solution injectable/ pour prick-test</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_SOLUTION_FOR_INJECTION_SKIN_PRICK_TEST_CODE = "13052000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for solution for intraocular irrigation</div>
	 * <div class="de">Code für Pulver zur Herstellung einer L�sung zur intraokularen Anwendung</div>
	 * <div class="fr">Code de Poudre pour solution pour irrigation intraoculaire</div>
	 * <div class="it">Code per Polvere per soluzione per irrigazione intraoculare</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_SOLUTION_FOR_INTRAOCULAR_IRRIGATION_CODE = "50073000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for solution for iontophoresis</div>
	 * <div class="de">Code für Pulver zur Herstellung einer L�sung zur Iontophorese</div>
	 * <div class="fr">Code de Poudre pour solution pour iontoph�r�se</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_SOLUTION_FOR_IONTOPHORESIS_CODE = "10518500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for solution for skin-prick test</div>
	 * <div class="de">Code für Pulver zur Herstellung einer Pricktestl�sung</div>
	 * <div class="fr">Code de Poudre pour solution pour prick-test</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_SOLUTION_FOR_SKIN_PRICK_TEST_CODE = "13032000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for suspension for injection</div>
	 * <div class="de">Code für Pulver zur Herstellung einer Injektionssuspension</div>
	 * <div class="fr">Code de Poudre pour suspension injectable</div>
	 * <div class="it">Code per Polvere per sospensione iniettabile</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_SUSPENSION_FOR_INJECTION_CODE = "11206000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Powder for syrup</div>
	 * <div class="de">Code für Pulver zur Herstellung eines Sirups</div>
	 * <div class="fr">Code de Poudre pour sirop</div>
	 * <div class="it">Code per Polvere per sciroppo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POWDER_FOR_SYRUP_CODE = "10118000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pressurised inhalation, emulsion</div>
	 * <div class="de">Code für Druckgasinhalation, Emulsion</div>
	 * <div class="fr">Code de Emulsion pour inhalation en flacon pressuris�</div>
	 * <div class="it">Code per Emulsione pressurizzata per inalazione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PRESSURISED_INHALATION_EMULSION_CODE = "11108000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pressurised inhalation, solution</div>
	 * <div class="de">Code für Druckgasinhalation, L�sung</div>
	 * <div class="fr">Code de Solution pour inhalation en flacon pressuris�</div>
	 * <div class="it">Code per Soluzione pressurizzata per inalazione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PRESSURISED_INHALATION_SOLUTION_CODE = "11106000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pressurised inhalation, suspension</div>
	 * <div class="de">Code für Druckgasinhalation, Suspension</div>
	 * <div class="fr">Code de Suspension pour inhalation en flacon pressuris�</div>
	 * <div class="it">Code per Sospensione pressurizzata per inalazione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PRESSURISED_INHALATION_SUSPENSION_CODE = "11107000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Prolonged-release capsule, hard</div>
	 * <div class="de">Code für Hartkapsel, retardiert</div>
	 * <div class="fr">Code de G�lule � lib�ration prolong�e</div>
	 * <div class="it">Code per Capsula rigida a rilascio prolungato</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PROLONGED_RELEASE_CAPSULE_HARD_CODE = "10215000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Prolonged-release capsule, soft</div>
	 * <div class="de">Code für Weichkapsel, retardiert</div>
	 * <div class="fr">Code de Capsule molle � lib�ration prolong�e</div>
	 * <div class="it">Code per Capsula molle a rilascio prolungato</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PROLONGED_RELEASE_CAPSULE_SOFT_CODE = "10216000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Prolonged-release granules</div>
	 * <div class="de">Code für Retardgranulat</div>
	 * <div class="fr">Code de Granul�s � lib�ration prolong�e</div>
	 * <div class="it">Code per Granulato a rilascio prolungato</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PROLONGED_RELEASE_GRANULES_CODE = "10207000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Prolonged-release granules for oral suspension</div>
	 * <div class="de">Code für Retardgranulat zur Herstellung einer Suspension zum Einnehmen</div>
	 * <div class="fr">Code de Granul�s � lib�ration prolong�e pour suspension buvable</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PROLONGED_RELEASE_GRANULES_FOR_ORAL_SUSPENSION_CODE = "50056000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Prolonged-release solution for injection</div>
	 * <div class="de">Code für 0</div>
	 * <div class="fr">Code de Solution injectable � lib�ration prolong�e</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PROLONGED_RELEASE_SOLUTION_FOR_INJECTION_CODE = "13076000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Prolonged-release suspension for injection</div>
	 * <div class="de">Code für Depot-Injektionssuspension</div>
	 * <div class="fr">Code de Suspension injectable � lib�ration prolong�e</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PROLONGED_RELEASE_SUSPENSION_FOR_INJECTION_CODE = "11208500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Prolonged-release tablet</div>
	 * <div class="de">Code für Retardtablette</div>
	 * <div class="fr">Code de Comprim� � lib�ration prolong�e</div>
	 * <div class="it">Code per Compressa a rilascio prolungato</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PROLONGED_RELEASE_TABLET_CODE = "10226000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Radionuclide generator</div>
	 * <div class="de">Code für Radionuklidgenerator</div>
	 * <div class="fr">Code de G�n�rateur radiopharmaceutique</div>
	 * <div class="it">Code per Generatore di radionuclidi</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RADIONUCLIDE_GENERATOR_CODE = "12106000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Radiopharmaceutical precursor</div>
	 * <div class="de">Code für Markerzubereitung</div>
	 * <div class="fr">Code de Pr�curseur radiopharmaceutique</div>
	 * <div class="it">Code per Precursore radiofarmaceutico</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RADIOPHARMACEUTICAL_PRECURSOR_CODE = "12105000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Radiopharmaceutical precursor, solution</div>
	 * <div class="de">Code für Markerzubereitung, L�sung</div>
	 * <div class="fr">Code de Solution de pr�curseur radiopharmaceutique</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RADIOPHARMACEUTICAL_PRECURSOR_SOLUTION_CODE = "50056500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Rectal capsule</div>
	 * <div class="de">Code für Rektalkapsel</div>
	 * <div class="fr">Code de Capsule  rectale</div>
	 * <div class="it">Code per Capsula rettale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RECTAL_CAPSULE_CODE = "11014000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Rectal cream</div>
	 * <div class="de">Code für Rektalcreme</div>
	 * <div class="fr">Code de Cr�me rectale</div>
	 * <div class="it">Code per Crema rettale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RECTAL_CREAM_CODE = "11001000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Rectal emulsion</div>
	 * <div class="de">Code für Rektalemulsion</div>
	 * <div class="fr">Code de Emulsion rectale</div>
	 * <div class="it">Code per Emulsione rettale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RECTAL_EMULSION_CODE = "11007000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Rectal foam</div>
	 * <div class="de">Code für Rektalschaum</div>
	 * <div class="fr">Code de Mousse rectale</div>
	 * <div class="it">Code per Schiuma rettale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RECTAL_FOAM_CODE = "11004000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Rectal gel</div>
	 * <div class="de">Code für Rektalgel</div>
	 * <div class="fr">Code de Gel rectal</div>
	 * <div class="it">Code per Gel rettale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RECTAL_GEL_CODE = "11002000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Rectal ointment</div>
	 * <div class="de">Code für Rektalsalbe</div>
	 * <div class="fr">Code de Pommade rectale</div>
	 * <div class="it">Code per Unguento rettale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RECTAL_OINTMENT_CODE = "11003000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Rectal solution</div>
	 * <div class="de">Code für Rektall�sung</div>
	 * <div class="fr">Code de Solution rectale</div>
	 * <div class="it">Code per Soluzione rettale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RECTAL_SOLUTION_CODE = "11005000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Rectal suspension</div>
	 * <div class="de">Code für Rektalsuspension</div>
	 * <div class="fr">Code de Suspension rectale</div>
	 * <div class="it">Code per Sospensione rettale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RECTAL_SUSPENSION_CODE = "11006000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Rectal tampon</div>
	 * <div class="de">Code für Rektaltampon</div>
	 * <div class="fr">Code de Tampon rectal</div>
	 * <div class="it">Code per Tampone rettale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RECTAL_TAMPON_CODE = "11015000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Sealant</div>
	 * <div class="de">Code für Gewebekleber</div>
	 * <div class="fr">Code de Colle</div>
	 * <div class="it">Code per Adesivo tissutale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SEALANT_CODE = "12115000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Sealant matrix</div>
	 * <div class="de">Code für Versiegelungsmatrix</div>
	 * <div class="fr">Code de Matrice pour colle</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SEALANT_MATRIX_CODE = "12115100";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Sealant powder</div>
	 * <div class="de">Code für Gewebekleber</div>
	 * <div class="fr">Code de Poudre pour colle</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SEALANT_POWDER_CODE = "12115200";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Shampoo</div>
	 * <div class="de">Code für Shampoo</div>
	 * <div class="fr">Code de Shampoing</div>
	 * <div class="it">Code per Shampoo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SHAMPOO_CODE = "10508000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Soluble tablet</div>
	 * <div class="de">Code für Tablette zur Herstellung einer L�sung zum Einnehmen</div>
	 * <div class="fr">Code de Comprim� pour solution buvable</div>
	 * <div class="it">Code per Compressa solubile</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLUBLE_TABLET_CODE = "10120000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Solution for blood fraction modification</div>
	 * <div class="de">Code für L�sung zur Modifikation einer Blutfraktion</div>
	 * <div class="fr">Code de Solution pour la pr�paration ex vivo de fractions sanguines</div>
	 * <div class="it">Code per Soluzione per la modifica di frazione ematica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLUTION_FOR_BLOOD_FRACTION_MODIFICATION_CODE = "12103000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Solution for cardioplegia</div>
	 * <div class="de">Code für Kardioplege L�sung</div>
	 * <div class="fr">Code de Solution de cardiopl�gie</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLUTION_FOR_CARDIOPLEGIA_CODE = "11209500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Solution for cardioplegia/organ preservation</div>
	 * <div class="de">Code für 0</div>
	 * <div class="fr">Code de 0</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLUTION_FOR_CARDIOPLEGIA_ORGAN_PRESERVATION_CODE = "13107000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Solution for dental cement</div>
	 * <div class="de">Code für L�sung zur Herstellung eines Dentalzements</div>
	 * <div class="fr">Code de Solution pour ciment dentaire</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLUTION_FOR_DENTAL_CEMENT_CODE = "10414000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Solution for haemodiafiltration</div>
	 * <div class="de">Code für H�modiafiltrationsl�sung</div>
	 * <div class="fr">Code de Solution pour h�modiafiltration</div>
	 * <div class="it">Code per Soluzione per emofiltrazione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLUTION_FOR_HAEMODIAFILTRATION_CODE = "11403000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Solution for haemodialysis</div>
	 * <div class="de">Code für H�modialysel�sung</div>
	 * <div class="fr">Code de Solution pour h�modialyse</div>
	 * <div class="it">Code per Soluzione per emodialisi</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLUTION_FOR_HAEMODIALYSIS_CODE = "11404000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Solution for haemodialysis/haemofiltration</div>
	 * <div class="de">Code für H�modialysel�sung/H�mofiltrationsl�sung</div>
	 * <div class="fr">Code de Solution pour h�modialyse/h�mofiltration</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLUTION_FOR_HAEMODIALYSIS_HAEMOFILTRATION_CODE = "50057000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Solution for haemofiltration</div>
	 * <div class="de">Code für H�mofiltrationsl�sung</div>
	 * <div class="fr">Code de Solution pour h�mofiltration</div>
	 * <div class="it">Code per Soluzione per emofiltrazione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLUTION_FOR_HAEMOFILTRATION_CODE = "11402000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Solution for infusion</div>
	 * <div class="de">Code für Infusionsl�sung</div>
	 * <div class="fr">Code de Solution pour perfusion</div>
	 * <div class="it">Code per Soluzione per infusione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLUTION_FOR_INFUSION_CODE = "11210000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Solution for injection</div>
	 * <div class="de">Code für Injektionsl�sung</div>
	 * <div class="fr">Code de Solution injectable</div>
	 * <div class="it">Code per Soluzione iniettabile</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLUTION_FOR_INJECTION_CODE = "11201000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Solution for injection/infusion</div>
	 * <div class="de">Code für Injektions-/Infusionsl�sung</div>
	 * <div class="fr">Code de Solution injectable/pour perfusion</div>
	 * <div class="it">Code per Soluzione iniettabile o per infusione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLUTION_FOR_INJECTION_INFUSION_CODE = "50060000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Solution for injection/skin-prick test</div>
	 * <div class="de">Code für Injektionsl�sung/ Pricktestl�sung</div>
	 * <div class="fr">Code de Solution injectable/ pour prick-test</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLUTION_FOR_INJECTION_SKIN_PRICK_TEST_CODE = "13051000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Solution for intraocular irrigation</div>
	 * <div class="de">Code für L�sung zur intraokularen Anwendung</div>
	 * <div class="fr">Code de Solution pour irrigation intraoculaire</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLUTION_FOR_INTRAOCULAR_IRRIGATION_CODE = "50073500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Solution for iontophoresis</div>
	 * <div class="de">Code für L�sung zur Iontophorese</div>
	 * <div class="fr">Code de Solution pour iontophor�se</div>
	 * <div class="it">Code per Soluzione per iontoforesi</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLUTION_FOR_IONTOPHORESIS_CODE = "10518000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Solution for organ preservation</div>
	 * <div class="de">Code für Organkonservierungsl�sung</div>
	 * <div class="fr">Code de Solution pour conservation d'organe</div>
	 * <div class="it">Code per Soluzione per conservazione di organi</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLUTION_FOR_ORGAN_PRESERVATION_CODE = "12112000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Solution for peritoneal dialysis</div>
	 * <div class="de">Code für Peritonealdialysel�sung</div>
	 * <div class="fr">Code de Solution pour dialyse p�riton�ale</div>
	 * <div class="it">Code per Soluzione per dialisi peritoneale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLUTION_FOR_PERITONEAL_DIALYSIS_CODE = "11401000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Solution for provocation test</div>
	 * <div class="de">Code für Provokationstestl�sung</div>
	 * <div class="fr">Code de solution pour test de provocation</div>
	 * <div class="it">Code per Soluzione per saggio di provocazione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLUTION_FOR_PROVOCATION_TEST_CODE = "12131000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Solution for sealant</div>
	 * <div class="de">Code für L�sung f�r Gewebekleber</div>
	 * <div class="fr">Code de Solution pour colle</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLUTION_FOR_SEALANT_CODE = "50061500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Solution for skin-prick test</div>
	 * <div class="de">Code für Pricktestl�sung</div>
	 * <div class="fr">Code de solution pour prick-test</div>
	 * <div class="it">Code per Soluzione per cutireazione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLUTION_FOR_SKIN_PRICK_TEST_CODE = "10548000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Solution for skin-scratch test</div>
	 * <div class="de">Code für Scratchtestl�sung</div>
	 * <div class="fr">Code de solution pour test intradermique</div>
	 * <div class="it">Code per Soluzione per scarificazione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLUTION_FOR_SKIN_SCRATCH_TEST_CODE = "10549000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Solution for solution for infusion</div>
	 * <div class="de">Code für L�sung zur Herstellung einer Infusionsl�sung</div>
	 * <div class="fr">Code de Solution pour solution pour perfusion</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLUTION_FOR_SOLUTION_FOR_INFUSION_CODE = "13061000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Solution for solution for injection</div>
	 * <div class="de">Code für L�sung zur Herstellung einer Injektionsl�sung</div>
	 * <div class="fr">Code de Solution pour solution injectable</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLUTION_FOR_SOLUTION_FOR_INJECTION_CODE = "13033000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Solution for suspension for injection</div>
	 * <div class="de">Code für L�sung zur Herstellung einer Injektionssuspension</div>
	 * <div class="fr">Code de Solution pour suspension injectable</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLUTION_FOR_SUSPENSION_FOR_INJECTION_CODE = "13047000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Solvent for...</div>
	 * <div class="de">Code für L�sungsmittel zur Herstellung...</div>
	 * <div class="fr">Code de Solvant pour...</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLVENT_FOR_CODE = "13035000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Solvent for parenteral use</div>
	 * <div class="de">Code für L�sungsmittel zur Herstellung von Parenteralia</div>
	 * <div class="fr">Code de Solvant pour pr�paration parent�rale</div>
	 * <div class="it">Code per Solvente per uso parenterale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLVENT_FOR_PARENTERAL_USE_CODE = "11216000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Solvent for solution for infusion</div>
	 * <div class="de">Code für L�sungsmittel zur Herstellung einer Infusionsl�sung</div>
	 * <div class="fr">Code de Solvant pour solution pour perfusion</div>
	 * <div class="it">Code per Solvente per soluzione per infusione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLVENT_FOR_SOLUTION_FOR_INFUSION_CODE = "50076000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Solvent for solution for intraocular irrigation</div>
	 * <div class="de">Code für L�sungsmittel zur Herstellung einer L�sung zur intraokularen Anwendung</div>
	 * <div class="fr">Code de Solvant pour solution pour irrigation intraoculaire</div>
	 * <div class="it">Code per Solvente per soluzione per irrigazione intraoculare</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOLVENT_FOR_SOLUTION_FOR_INTRAOCULAR_IRRIGATION_CODE = "50074000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Stomach irrigation</div>
	 * <div class="de">Code für Magensp�lfl�ssigkeit</div>
	 * <div class="fr">Code de Solution pour irrigation stomacale</div>
	 * <div class="it">Code per Liquido per lavanda gastrica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String STOMACH_IRRIGATION_CODE = "12114000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Sublingual film</div>
	 * <div class="de">Code für Schmelzfilm zur sublingualen Anwendung</div>
	 * <div class="fr">Code de Film sublinguale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUBLINGUAL_FILM_CODE = "10317500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Sublingual powder</div>
	 * <div class="de">Code für 0</div>
	 * <div class="fr">Code de 0</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUBLINGUAL_POWDER_CODE = "13105000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Sublingual spray, emulsion</div>
	 * <div class="de">Code für Sublingualspray, Emulsion</div>
	 * <div class="fr">Code de Emulsion pour pulv�risation sublinguale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUBLINGUAL_SPRAY_EMULSION_CODE = "10309100";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Sublingual spray, solution</div>
	 * <div class="de">Code für Sublingualspray, L�sung</div>
	 * <div class="fr">Code de Solution pour pulv�risation sublinguale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUBLINGUAL_SPRAY_SOLUTION_CODE = "10309200";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Sublingual spray, suspension</div>
	 * <div class="de">Code für Sublingualspray, Suspension</div>
	 * <div class="fr">Code de Suspension pour pulv�risation sublinguale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUBLINGUAL_SPRAY_SUSPENSION_CODE = "10309300";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Sublingual tablet</div>
	 * <div class="de">Code für Sublingualtablette</div>
	 * <div class="fr">Code de Comprim� sublingual</div>
	 * <div class="it">Code per Compressa sublinguale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUBLINGUAL_TABLET_CODE = "10318000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Suppository</div>
	 * <div class="de">Code für Z�pfchen</div>
	 * <div class="fr">Code de Suppositoire</div>
	 * <div class="it">Code per Supposta</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUPPOSITORY_CODE = "11013000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Suspension for emulsion for injection</div>
	 * <div class="de">Code für Suspension zur Herstellung einer Emulsion zur Injektion</div>
	 * <div class="fr">Code de Suspension pour �mulsion injectable</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUSPENSION_FOR_EMULSION_FOR_INJECTION_CODE = "13036000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Suspension for injection</div>
	 * <div class="de">Code für Injektionssuspension</div>
	 * <div class="fr">Code de Suspension injectable</div>
	 * <div class="it">Code per Sospensione iniettabile</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUSPENSION_FOR_INJECTION_CODE = "11202000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Suspension for oral suspension</div>
	 * <div class="de">Code für Suspension zur Herstellung einer Suspension zum Einnehmen</div>
	 * <div class="fr">Code de Suspension pour suspension buvable</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUSPENSION_FOR_ORAL_SUSPENSION_CODE = "13037000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Suspension for suspension for injection</div>
	 * <div class="de">Code für Suspension zur Herstellung einer Injektionssuspension</div>
	 * <div class="fr">Code de Suspension pour suspension injectable</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUSPENSION_FOR_SUSPENSION_FOR_INJECTION_CODE = "13039000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Syrup</div>
	 * <div class="de">Code für Sirup</div>
	 * <div class="fr">Code de Sirop</div>
	 * <div class="it">Code per Sciroppo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SYRUP_CODE = "10117000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Tablet</div>
	 * <div class="de">Code für Tablette</div>
	 * <div class="fr">Code de Comprim�</div>
	 * <div class="it">Code per Compressa</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TABLET_CODE = "10219000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Tablet for cutaneous solution</div>
	 * <div class="de">Code für Tablette zur Herstellung einer L�sung zur Anwendung auf der Haut</div>
	 * <div class="fr">Code de Comprim� pour solution cutan�e</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TABLET_FOR_CUTANEOUS_SOLUTION_CODE = "13066000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Tablet for rectal solution</div>
	 * <div class="de">Code für Tablette zur Herstellung einer Rektall�sung</div>
	 * <div class="fr">Code de Comprim� pour solution rectale</div>
	 * <div class="it">Code per Compressa per soluzione rettale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TABLET_FOR_RECTAL_SOLUTION_CODE = "11011000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Tablet for rectal suspension</div>
	 * <div class="de">Code für Tablette zur Herstellung einer Rektalsuspension</div>
	 * <div class="fr">Code de Comprim� pour suspension rectale</div>
	 * <div class="it">Code per Compressa per sospensione rettale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TABLET_FOR_RECTAL_SUSPENSION_CODE = "11012000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Tablet for vaginal solution</div>
	 * <div class="de">Code für Tablette zur Herstellung einer Vaginall�sung</div>
	 * <div class="fr">Code de Comprim� pour solution vaginale</div>
	 * <div class="it">Code per Compressa per soluzione vaginale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TABLET_FOR_VAGINAL_SOLUTION_CODE = "10908000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Toothpaste</div>
	 * <div class="de">Code für Zahnpaste</div>
	 * <div class="fr">Code de P�te dentifrice</div>
	 * <div class="it">Code per Pasta dentifricia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOOTHPASTE_CODE = "10409000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Transdermal gel</div>
	 * <div class="de">Code für Transdermales Gel</div>
	 * <div class="fr">Code de Gel transdermique</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TRANSDERMAL_GEL_CODE = "10546250";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Transdermal ointment</div>
	 * <div class="de">Code für 0</div>
	 * <div class="fr">Code de Pommade transdermique</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TRANSDERMAL_OINTMENT_CODE = "13102000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Transdermal patch</div>
	 * <div class="de">Code für transdermales Pflaster</div>
	 * <div class="fr">Code de Dispositif transdermique</div>
	 * <div class="it">Code per Cerotto transdermico</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TRANSDERMAL_PATCH_CODE = "10519000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Transdermal solution</div>
	 * <div class="de">Code für transdermale L�sung</div>
	 * <div class="fr">Code de Solution transdermique</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TRANSDERMAL_SOLUTION_CODE = "10546400";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Transdermal spray, solution</div>
	 * <div class="de">Code für transdermales Spray, L�sung</div>
	 * <div class="fr">Code de Solution pour pulv�risation transdermique</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TRANSDERMAL_SPRAY_SOLUTION_CODE = "10546500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Transdermal system</div>
	 * <div class="de">Code für transdermales System</div>
	 * <div class="fr">Code de syst�me transdermique</div>
	 * <div class="it">Code per Sistema transdermico</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TRANSDERMAL_SYSTEM_CODE = "10547000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Urethral emulsion</div>
	 * <div class="de">Code für Emulsion zur Anwendung in der Harnr�hre</div>
	 * <div class="fr">Code de Emulsion ur�trale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String URETHRAL_EMULSION_CODE = "13077000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Urethral gel</div>
	 * <div class="de">Code für Gel zur Anwendung in der Harnr�hre</div>
	 * <div class="fr">Code de Gel ur�tral</div>
	 * <div class="it">Code per Gel uretrale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String URETHRAL_GEL_CODE = "11504000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Urethral stick</div>
	 * <div class="de">Code für St�bchen zur Anwendung in der Harnr�hre</div>
	 * <div class="fr">Code de B�ton pour usage ur�tral</div>
	 * <div class="it">Code per Bastoncino uretrale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String URETHRAL_STICK_CODE = "11505000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Vaginal capsule, hard</div>
	 * <div class="de">Code für Hartkapsel zur vaginalen Anwendung</div>
	 * <div class="fr">Code de G�lule vaginale</div>
	 * <div class="it">Code per Capsula rigida vaginale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VAGINAL_CAPSULE_HARD_CODE = "10910000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Vaginal capsule, soft</div>
	 * <div class="de">Code für Weichkapsel zur vaginalen Anwendung</div>
	 * <div class="fr">Code de Capsule molle vaginale</div>
	 * <div class="it">Code per Capsula molle vaginale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VAGINAL_CAPSULE_SOFT_CODE = "10911000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Vaginal cream</div>
	 * <div class="de">Code für Vaginalcreme</div>
	 * <div class="fr">Code de Cr�me vaginale</div>
	 * <div class="it">Code per Crema vaginale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VAGINAL_CREAM_CODE = "10901000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Vaginal delivery system</div>
	 * <div class="de">Code für vaginales Wirkstofffreisetzungssystem</div>
	 * <div class="fr">Code de Syst�me de diffusion vaginal</div>
	 * <div class="it">Code per Dispositivo vaginale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VAGINAL_DELIVERY_SYSTEM_CODE = "10915000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Vaginal emulsion</div>
	 * <div class="de">Code für Vaginalemulsion</div>
	 * <div class="fr">Code de Emulsion vaginale</div>
	 * <div class="it">Code per Emulsione vaginale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VAGINAL_EMULSION_CODE = "10907000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Vaginal foam</div>
	 * <div class="de">Code für Vaginalschaum</div>
	 * <div class="fr">Code de Mousse vaginale</div>
	 * <div class="it">Code per Schiuma vaginale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VAGINAL_FOAM_CODE = "10904000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Vaginal gel</div>
	 * <div class="de">Code für Vaginalgel</div>
	 * <div class="fr">Code de Gel vaginal</div>
	 * <div class="it">Code per Gel vaginale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VAGINAL_GEL_CODE = "10902000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Vaginal ointment</div>
	 * <div class="de">Code für Vaginalsalbe</div>
	 * <div class="fr">Code de Pommade vaginale</div>
	 * <div class="it">Code per Unguento vaginale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VAGINAL_OINTMENT_CODE = "10903000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Vaginal solution</div>
	 * <div class="de">Code für Vaginall�sung</div>
	 * <div class="fr">Code de Solution vaginale</div>
	 * <div class="it">Code per Soluzione vaginale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VAGINAL_SOLUTION_CODE = "10905000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Vaginal suspension</div>
	 * <div class="de">Code für Vaginalsuspension</div>
	 * <div class="fr">Code de Suspension vaginale</div>
	 * <div class="it">Code per Sospensione vaginale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VAGINAL_SUSPENSION_CODE = "10906000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Vaginal tablet</div>
	 * <div class="de">Code für Vaginaltablette</div>
	 * <div class="fr">Code de Comprim� vaginal</div>
	 * <div class="it">Code per Compressa vaginale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VAGINAL_TABLET_CODE = "10912000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Wound stick</div>
	 * <div class="de">Code für Wundst�bchen</div>
	 * <div class="fr">Code de B�ton intral�sionnel</div>
	 * <div class="it">Code per Matita emostatica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String WOUND_STICK_CODE = "12104000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator fÃ¼r das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.1.11.3";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "PharmaceuticalDoseFormEDQM";

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
	public static PharmaceuticalDoseFormEdqm getEnum(String code) {
		for (final PharmaceuticalDoseFormEdqm x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">PrÃ¼ft, ob der angegebene enum Teil dieses Value Sets ist.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param enumName
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(PharmaceuticalDoseFormEdqm.class, enumName);
			return true;
		} catch (final IllegalArgumentException ex) {
			return false;
		}
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">PrÃ¼ft, ob der angegebene code in diesem Value Set vorhanden ist.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param codeValue
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final PharmaceuticalDoseFormEdqm x : values()) {
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
	PharmaceuticalDoseFormEdqm(String code, String codeSystem, String displayName, String displayNameEn, String displayNameDe, String displayNameFr, String displayNameIt) {
		this.code = code;
		this.codeSystem = codeSystem;
		displayNames = new HashMap<>();
		displayNames.put(null, displayName);
		displayNames.put(LanguageCode.ENGLISH, displayNameEn);
		displayNames.put(LanguageCode.GERMAN, displayNameDe);
		displayNames.put(LanguageCode.FRENCH, displayNameFr);
		displayNames.put(LanguageCode.ITALIAN, displayNameIt);
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
	 * <div class="de">Liefert display name gemÃ¤ss Parameter, falls es keine
	 * Englische Ãœbersetzung gibt, wird der default-Name zurÃ¼ckgegeben.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param languageCode
	 *            the language code to get the display name for
	 * @return returns the display name in the desired language. if language not
	 *         found, display name in german will returned
	 */
	@Override
	public String getDisplayName(LanguageCode languageCode) {
		String displayName = displayNames.get(languageCode);
		if (displayName == null && languageCode == LanguageCode.ENGLISH) {
			return displayNames.get(null);
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
