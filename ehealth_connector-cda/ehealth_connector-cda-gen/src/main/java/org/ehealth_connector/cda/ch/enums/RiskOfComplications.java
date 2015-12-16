/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/
package org.ehealth_connector.cda.ch.enums;

import java.util.Arrays;
import java.util.Date;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.utils.DateUtil;

/**
 * Value Set valid from 20150101 Value-Set: CDA-CH-VACD copml-risks (OID:
 * 2.16.756.5.30.1.127.3.3.1)
 */
public enum RiskOfComplications {

	/**
	 * <div class="de"> Anatomische oder funktionelle Asplenie</div>
	 * <div class="fr">Asplénie anatomique ou fonctionnelle</div>
	 * <div class="it">Asplenia anatomica o funzionale</div>
	 */
	ANATOMISCHE_ODER_FUNKTIONELLE_ASPLENIE("113001", "Anatomische oder funktionelle Asplenie",
			"Asplénie anatomique ou fonctionnelle", "Asplenia anatomica o funzionale", "20130101",
			""),

	/**
	 * <div class="de"> Andere Lungenerkrankungen (z.B. Mukoviszidose, Asthma
	 * bronchiale, etc.)</div> <div class="fr">Autres maladies pulmonaires (ex :
	 * mucoviscidose, asthme traité par aérosols, etc)</div>
	 * <div class="it">Altre malattie polmonari (p.es. mucoviscidosi, asma
	 * trattata con aerosol, ecc.)</div>
	 */
	ANDERE_LUNGENERKRANKUNGEN_ZB_MUKOVISZIDOSE_ASTHMA_BRONCHIALE_ETC("114006",
			"Andere Lungenerkrankungen (z.B. Mukoviszidose, Asthma bronchiale, etc.)",
			"Autres maladies pulmonaires (ex : mucoviscidose, asthme traité par aérosols, etc)",
			"Altre malattie polmonari (p.es. mucoviscidosi, asma trattata con aerosol, ecc.)",
			"20140101", ""),

	/**
	 * <div class="de"> Angeborene Immundefizienz, variables Immundefektsyndrom,
	 * defizitäre Antwort auf Polysaccharide</div>
	 * <div class="fr">Immunodéficience congénitale, immunodéficience commune
	 * variable, déficit réponse aux polysaccharidiques</div>
	 * <div class="it">Immunodeficienza congenita, immunodeficienza comune
	 * variabile, deficit di risposta ai polisaccaridi</div>
	 */
	ANGEBORENE_IMMUNDEFIZIENZ_VARIABLES_IMMUNDEFEKTSYNDROM_DEFIZITÄRE_ANTWORT_AUF_POLYSACCHARIDE(
			"114025",
			"Angeborene Immundefizienz, variables Immundefektsyndrom, defizitäre Antwort auf Polysaccharide",
			"Immunodéficience congénitale, immunodéficience commune variable, déficit réponse aux polysaccharidiques",
			"Immunodeficienza congenita, immunodeficienza comune variabile, deficit di risposta ai polisaccaridi",
			"20140101", ""),

	/**
	 * <div class="de"> Autoimmunkrankheit, welche eine Immunsuppression
	 * erfordert</div><div class="fr">Maladie auto-immune exigeant
	 * vraisemblablement une immunosuppression</div><div class="it">Malattia
	 * autoimmune che richiede probabilmente una immunosoppressione</div>
	 */
	AUTOIMMUNKRANKHEIT_WELCHE_EINE_IMMUNSUPPRESSION_ERFORDERT("114021",
			"Autoimmunkrankheit, welche eine Immunsuppression erfordert",
			"Maladie auto-immune exigeant vraisemblablement une immunosuppression",
			"Malattia autoimmune che richiede probabilmente una immunosoppressione", "20140101",
			""),

	/**
	 * <div class="de"> Bronchiektasen durch Antikörpermangel</div>
	 * <div class="fr">Bronchiectasies sur carence en anticorps</div>
	 * <div class="it">Bronchiettasie su carenza in anticorpi</div>
	 */
	BRONCHIEKTASEN_DURCH_ANTIKÖRPERMANGEL("114005", "Bronchiektasen durch Antikörpermangel",
			"Bronchiectasies sur carence en anticorps", "Bronchiettasie su carenza in anticorpi",
			"20140101", ""),

	/**
	 * <div class="de"> Chronisch obstruktive Pneumopathie</div>
	 * <div class="fr">Pneumopathie chronique obstructive</div>
	 * <div class="it">Pneumopatia cronica ostruttiva</div>
	 */
	CHRONISCH_OBSTRUKTIVE_PNEUMOPATHIE("114003", "Chronisch obstruktive Pneumopathie",
			"Pneumopathie chronique obstructive", "Pneumopatia cronica ostruttiva", "20140101", ""),

	/**
	 * <div class="de"> Chronische Lebererkrankung</div> <div class="fr">Maladie
	 * hépatique chronique</div> <div class="it">Malattia epatica cronica</div>
	 */
	CHRONISCHE_LEBERERKRANKUNG("114007", "Chronische Lebererkrankung",
			"Maladie hépatique chronique", "Malattia epatica cronica", "20140101", ""),

	/**
	 * <div class="de"> Cochleaimplantat, in situ oder geplant</div>
	 * <div class="fr">Implant cochléaire, in situ ou planifié</div>
	 * <div class="it">Impianto cocleare, in situ o pianificato</div>
	 */
	COCHLEAIMPLANTAT_IN_SITU_ODER_GEPLANT("113002", "Cochleaimplantat, in situ oder geplant",
			"Implant cochléaire, in situ ou planifié", "Impianto cocleare, in situ o pianificato",
			"20130101", ""),

	/**
	 * <div class="de"> Defekte bei der Komplementaktivierung des alternativen
	 * Wegs oder Defizite der Terminalfaktoren des Komplementsystems</div>
	 * <div class="fr">Déficit en facteurs de la voie alterne ou terminale du
	 * complément</div><div class="it">Deficit di fattori della via alterna o
	 * terminale del complemento</div>
	 */
	@Deprecated DEFEKTE_BEI_DER_KOMPLEMENTAKTIVIERUNG_DES_ALTERNATIVEN_WEGS_ODER_DEFIZITE_DER_TERMINALFAKTOREN_DES_KOMPLEMENTSYSTEMS(
			"113003",
			"Defekte bei der Komplementaktivierung des alternativen Wegs oder Defizite der Terminalfaktoren des Komplementsystems",
			"Déficit en facteurs de la voie alterne ou terminale du complément",
			"Deficit di fattori della via alterna o terminale del complemento", "20130101",
			"20131231"),

	/**
	 * <div class="de"> Diabetes mit Auswirkung auf die Funktion von Herz,
	 * Lungen oder Nieren</div><div class="fr">Diabète avec répercussion sur la
	 * fonction cardiaque, pulmonaire ou rénale</div><div class="it">Diabete con
	 * ripercussioni sulla funzione cardiopolmonare o renale</div>
	 */
	DIABETES_MIT_AUSWIRKUNG_AUF_DIE_FUNKTION_VON_HERZ_LUNGEN_ODER_NIEREN("114015",
			"Diabetes mit Auswirkung auf die Funktion von Herz, Lungen oder Nieren",
			"Diabète avec répercussion sur la fonction cardiaque, pulmonaire ou rénale",
			"Diabete con ripercussioni sulla funzione cardiopolmonare o renale", "20140101", ""),

	/**
	 * <div class="de"> Empfänger einer Solidorgantransplantation</div>
	 * <div class="fr">Receveurs d'une transplantation d'organe solide</div>
	 * <div class="it">Riceventi di un trapianto d'organo solido</div>
	 */
	EMPFÄNGER_EINER_SOLIDORGANTRANSPLANTATION("114019", "Empfänger einer Solidorgantransplantation",
			"Receveurs d'une transplantation d'organe solide",
			"Riceventi di un trapianto d'organo solido", "20140101", ""),

	/**
	 * <div class="de"> Empfänger einer Stammzelltransplantation</div>
	 * <div class="fr">Receveurs de cellules souches hématopoïétiques</div>
	 * <div class="it">Riceventi di cellule staminali ematopoietiche</div>
	 */
	EMPFÄNGER_EINER_STAMMZELLTRANSPLANTATION("114020", "Empfänger einer Stammzelltransplantation",
			"Receveurs de cellules souches hématopoïétiques",
			"Riceventi di cellule staminali ematopoietiche", "20140101", ""),

	/**
	 * <div class="de"> Geburt vor der 33. Schwangerschaftswoche oder
	 * Geburtsgewicht &lt; 1500g</div><div class="fr">Naissance avant la 33e
	 * semaine de grossesse ou poids de naissance &lt;1500 g</div>
	 * <div class="it">Nascita prima della 33a settimana di gravidanza o peso
	 * alla nascita &lt;1500 g</div>
	 */
	GEBURT_VOR_DER_33_SCHWANGERSCHAFTSWOCHE_ODER_GEBURTSGEWICHT_LT_1500G("113004",
			"Geburt vor der 33. Schwangerschaftswoche oder Geburtsgewicht < 1500g",
			"Naissance avant la 33e semaine de grossesse ou poids de naissance <1500 g",
			"Nascita prima della 33a settimana di gravidanza o peso alla nascita <1500 g",
			"20130101", ""),

	/**
	 * <div class="de"> Hämoglobinopathie</div>
	 * <div class="fr">Hémoglobinopathie</div>
	 * <div class="it">Emoglobinopatie</div>
	 */
	@Deprecated HÄMOGLOBINOPATHIE("113005", "Hämoglobinopathie", "Hémoglobinopathie",
			"Emoglobinopatie", "20130101", "20131231"),

	/**
	 * <div class="de"> Hepatopathien (chronische)</div>
	 * <div class="fr">Hépatopathies chroniques</div> <div class="it">Epatopatie
	 * croniche</div>
	 */
	@Deprecated HEPATOPATHIEN_CHRONISCHE("113006", "Hepatopathien (chronische)",
			"Hépatopathies chroniques", "Epatopatie croniche", "20130101", "20131231"),

	/**
	 * <div class="de"> Herzinsuffizienz</div> <div class="fr">Insuffisance
	 * cardiaque</div> <div class="it">Insufficienza cardiaca</div>
	 */
	HERZINSUFFIZIENZ("114001", "Herzinsuffizienz", "Insuffisance cardiaque",
			"Insufficienza cardiaca", "20140101", ""),

	/**
	 * <div class="de"> Herzkrankheiten (chronische, kongenitale
	 * Missbildungen)</div> <div class="fr">Cardiopathies chroniques,
	 * malformations congénitales</div> <div class="it">Cardiopatie croniche,
	 * malformazioni congenite</div>
	 */
	@Deprecated HERZKRANKHEITEN_CHRONISCHE_KONGENITALE_MISSBILDUNGEN("113007",
			"Herzkrankheiten (chronische, kongenitale Missbildungen)",
			"Cardiopathies chroniques, malformations congénitales",
			"Cardiopatie croniche, malformazioni congenite", "20130101", "20131231"),

	/**
	 * <div class="de"> HIV Infektion mit CD4-Zellen &gt;= 15 % (Erwachsene:
	 * &gt;= 200 / µl)</div> <div class="fr"> Infection à VIH avec CD4 &gt;= 15%
	 * (Adultes : &gt;= 200 / µl)</div> <div class="it">Infezione HIV con CD4
	 * &gt;= 15% (Adulti : &gt;= 200 / µl)</div>
	 */
	HIV_INFEKTION_MIT_CD4_ZELLEN_GTEQ_15_P_ERWACHSENE_GTEQ_200_µL("113008",
			"HIV Infektion mit CD4-Zellen >= 15 % (Erwachsene: >= 200 / µl)",
			" Infection à VIH avec CD4 >= 15% (Adultes : >= 200 / µl)",
			"Infezione HIV con CD4 >= 15% (Adulti : >= 200 / µl)", "20130101", ""),

	/**
	 * <div class="de"> HIV Infektion mit CD4-Zellen &lt; 15 % (Erwachsene: &lt;
	 * 200 / µl)</div> <div class="fr">Infection à VIH avec CD4 &lt; 15%
	 * (Adultes : &lt; 200 / µl)</div><div class="it">Infezione HIV con CD4 &lt;
	 * 15% (Adulti : &lt; 200 / µl)</div>
	 */
	HIV_INFEKTION_MIT_CD4_ZELLEN_LT_15_P_ERWACHSENE_LT_200_µL("113009",
			"HIV Infektion mit CD4-Zellen < 15 % (Erwachsene: < 200 / µl)",
			"Infection à VIH avec CD4 < 15% (Adultes : < 200 / µl)",
			"Infezione HIV con CD4 < 15% (Adulti : < 200 / µl)", "20130101", ""),

	/**
	 * <div class="de"> Immuninsuffizienz jeder Art (medikamentös,
	 * Transplantation, chron. Erkrankungen)</div>
	 * <div class="fr">Immunodéficiences (toutes situations) y. c.
	 * immunosuppression, immunosuppression médicamenteuse (transplantation,
	 * maladies chroniques) </div> <div class="it">Immunodeficienze (tutte le
	 * situazioni) compreso immunosoppressione e immunosoppressione
	 * medicamentosa (trapianto, malattie croniche)</div>
	 */
	@Deprecated IMMUNINSUFFIZIENZ_JEDER_ART_MEDIKAMENTÖS_TRANSPLANTATION_CHRON_ERKRANKUNGEN(
			"113010",
			"Immuninsuffizienz jeder Art (medikamentös, Transplantation, chron. Erkrankungen)",
			"Immunodéficiences (toutes situations) y. c. immunosuppression, immunosuppression médicamenteuse (transplantation, maladies chroniques) ",
			"Immunodeficienze (tutte le situazioni) compreso immunosoppressione e immunosoppressione medicamentosa (trapianto, malattie croniche)",
			"20130101", "20131231"),

	/**
	 * <div class="de"> Kandidaten für eine Solidorgantransplantation</div>
	 * <div class="fr">Candidats à une transplantation d'organe solide</div>
	 * <div class="it">Candidati a un trapianto d'organo solido</div>
	 */
	KANDIDATEN_FÜR_EINE_SOLIDORGANTRANSPLANTATION("114018",
			"Kandidaten für eine Solidorgantransplantation",
			"Candidats à une transplantation d'organe solide",
			"Candidati a un trapianto d'organo solido", "20140101", ""),

	/**
	 * <div class="de"> Kardiopathie, angeborene Fehlbildung</div>
	 * <div class="fr">Cardiopathie, malformation congénitale</div>
	 * <div class="it">Cardiopatia, malformazione congenita</div>
	 */
	KARDIOPATHIE_ANGEBORENE_FEHLBILDUNG("114002", "Kardiopathie, angeborene Fehlbildung",
			"Cardiopathie, malformation congénitale", "Cardiopatia, malformazione congenita",
			"20140101", ""),

	/**
	 * <div class="de"> Kongenitales Immunmangelsyndrom (mangelnde Immunantwort
	 * auf Polysaccharide, Antikörpermangel)</div>
	 * <div class="fr">Immunodéficience congénitale (défaut de réponses aux
	 * polysaccharides, déficiences en anticorps)</div>
	 * <div class="it">Immunodeficienza congenita (difetto di risposta ai
	 * polisaccaridi, deficienze in anticorpi)</div>
	 */
	@Deprecated KONGENITALES_IMMUNMANGELSYNDROM_MANGELNDE_IMMUNANTWORT_AUF_POLYSACCHARIDE_ANTIKÖRPERMANGEL(
			"113011",
			"Kongenitales Immunmangelsyndrom (mangelnde Immunantwort auf Polysaccharide, Antikörpermangel)",
			"Immunodéficience congénitale (défaut de réponses aux polysaccharides, déficiences en anticorps)",
			"Immunodeficienza congenita (difetto di risposta ai polisaccaridi, deficienze in anticorpi)",
			"20130101", "20131231"),

	/**
	 * <div class="de"> Leberzirrhose</div><div class="fr">Cirrhose
	 * hépatique</div><div class="it">Cirrosi epatica</div>
	 */
	LEBERZIRRHOSE("114008", "Leberzirrhose", "Cirrhose hépatique", "Cirrosi epatica", "20140101",
			""),

	/**
	 * <div class="de"> Liquorfistel</div><div class="fr">Fistule de LCR</div>
	 * <div class="it">Fistola di LCR</div>
	 */
	@Deprecated LIQUORFISTEL("113013", "Liquorfistel", "Fistule de LCR", "Fistola di LCR",
			"20130101", "20131231"),

	/**
	 * <div class="de"> Lymphom, Leukämie, Myelom</div>
	 * <div class="fr">Lymphome, leucémie, myélome</div>
	 * <div class="it">Linfoma, leucemia, mieloma</div>
	 */
	LYMPHOM_LEUKÄMIE_MYELOM("113012", "Lymphom, Leukämie, Myelom", "Lymphome, leucémie, myélome",
			"Linfoma, leucemia, mieloma", "20130101", ""),

	/**
	 * <div class="de"> Mangel an Mannose-bindendem Lektin</div>
	 * <div class="fr">Déficit en lectine liant le mannose</div>
	 * <div class="it">Deficit di lectina legante il mannosio</div>
	 */
	MANGEL_AN_MANNOSE_BINDENDEM_LEKTIN("113014", "Mangel an Mannose-bindendem Lektin",
			"Déficit en lectine liant le mannose", "Deficit di lectina legante il mannosio",
			"20130101", ""),

	/**
	 * <div class="de"> Mangel im klassischen oder alternativen Weg der
	 * Komplementaktivierung</div><div class="fr">Déficit en facteurs de la voie
	 * alterne ou terminale du complément</div><div class="it">Deficit in
	 * fattori della via alterna o terminale del complemento</div>
	 */
	MANGEL_IM_KLASSISCHEN_ODER_ALTERNATIVEN_WEG_DER_KOMPLEMENTAKTIVIERUNG("114026",
			"Mangel im klassischen oder alternativen Weg der Komplementaktivierung",
			"Déficit en facteurs de la voie alterne ou terminale du complément",
			"Deficit in fattori della via alterna o terminale del complemento", "20140101", ""),

	/**
	 * <div class="de"> Medikamentöse Immunosuppression (inkl. systemische
	 * Langzeitkortikoidtherapie und Radiotherapie)</div>
	 * <div class="fr">Immunosuppression médicamenteuse (y c. corticothérapie de
	 * longue durée par voie générale et radiothérapie)</div>
	 * <div class="it">Immunosoppressione medicamentosa (compresa una
	 * corticoterapia di lunga durata per via generale e una radioterapia)</div>
	 */
	MEDIKAMENTÖSE_IMMUNOSUPPRESSION_INKL_SYSTEMISCHE_LANGZEITKORTIKOIDTHERAPIE_UND_RADIOTHERAPIE(
			"114022",
			"Medikamentöse Immunosuppression (inkl. systemische Langzeitkortikoidtherapie und Radiotherapie)",
			"Immunosuppression médicamenteuse (y c. corticothérapie de longue durée par voie générale et radiothérapie)",
			"Immunosoppressione medicamentosa (compresa una corticoterapia di lunga durata per via generale e una radioterapia)",
			"20140101", ""),

	/**
	 * <div class="de"> Metabolische Erkrankungen mit Auswirkungen auf Herz,
	 * Lungen, Nieren und/oder Immunsystem (Diabetes, morbide Adipositas BMI
	 * &gt;= 40 )</div> <div class="fr">Maladies métaboliques chroniques
	 * affectant coeur, poumons et/ou défenses immunitaires (diabète, obésité
	 * morbide IMC &gt;= 40)</div> <div class="it">Malattie metaboliche croniche
	 * che colpiscono cuore, polmoni e/o difese immunitarie (diabete, obesità
	 * patologica con BMI &gt;= 40) </div>
	 */
	@Deprecated METABOLISCHE_ERKRANKUNGEN_MIT_AUSWIRKUNGEN_AUF_HERZ_LUNGEN_NIEREN_UND_ODER_IMMUNSYSTEM_DIABETES_MORBIDE_ADIPOSITAS_BMI_GTEQ_40_(
			"113015",
			"Metabolische Erkrankungen mit Auswirkungen auf Herz, Lungen, Nieren und/oder Immunsystem (Diabetes, morbide Adipositas BMI >= 40 )",
			"Maladies métaboliques chroniques affectant coeur, poumons et/ou défenses immunitaires (diabète, obésité morbide IMC >= 40)",
			"Malattie metaboliche croniche che colpiscono cuore, polmoni e/o difese immunitarie (diabete, obesità patologica con BMI >= 40) ",
			"20130101", "20131231"),

	/**
	 * <div class="de"> Missbildungen der Schädelbasis</div>
	 * <div class="fr">Malformations de la base du crâne</div>
	 * <div class="it">Malformazioni della base del cranio</div>
	 */
	@Deprecated MISSBILDUNGEN_DER_SCHÄDELBASIS("113016", "Missbildungen der Schädelbasis",
			"Malformations de la base du crâne", "Malformazioni della base del cranio", "20130101",
			"20131231"),

	/**
	 * <div class="de"> Morbide Adipositas (BMI &gt;= 40)</div>
	 * <div class="fr">Obésité morbide (IMC &gt;= 40)</div>
	 * <div class="it">Obesità patologica (IMC &gt;= 40)</div>
	 */
	MORBIDE_ADIPOSITAS_BMI_GTEQ_40("114016", "Morbide Adipositas (BMI >= 40)",
			"Obésité morbide (IMC >= 40)", "Obesità patologica (IMC >= 40)", "20140101", ""),

	/**
	 * <div class="de"> Mutter HBsAg positiv</div> <div class="fr">Mère HBsAg
	 * positive</div> <div class="it">Madre HBsAg positiva</div>
	 */
	MUTTER_HBSAG_POSITIV("114030", "Mutter HBsAg positiv", "Mère HBsAg positive",
			"Madre HBsAg positiva", "20140101", ""),

	/**
	 * <div class="de"> Myelome</div> <div class="fr">Myélome</div>
	 * <div class="it">Mieloma</div>
	 */
	@Deprecated MYELOME("113017", "Myelome", "Myélome", "Mieloma", "20130101", "20131231"),

	/**
	 * <div class="de"> Nephrotisches Syndrom</div> <div class="fr">Syndrome
	 * néphrotique</div> <div class="it">Sindrome nefrosica</div>
	 */
	NEPHROTISCHES_SYNDROM("113018", "Nephrotisches Syndrom", "Syndrome néphrotique",
			"Sindrome nefrosica", "20130101", ""),

	/**
	 * <div class="de"> Neugeborene und Säuglinge unter 12 Monaten aus Ländern
	 * mit hoher Tuberkulose prävalenz, die wahrscheinlich wieder dorthin
	 * zurückkehren (in ihrem ersten Lebensjahr)</div>
	 * <div class="fr">Nouveau-nés ou nourrissons &lt; 12 mois originaire d’un
	 * pays à haute endémie et susceptibles d’y retourner dans leur 1ère année
	 * de vie</div><div class="it">Neonati o lattanti &lt; 12 mesi originari di
	 * un paese a elevata endemia e suscettibili di ritornarci nel loro primo
	 * anno di vita </div>
	 */
	@Deprecated NEUGEBORENE_UND_SÄUGLINGE_UNTER_12_MONATEN_AUS_LÄNDERN_MIT_HOHER_TUBERKULOSE_PRÄVALENZ_DIE_WAHRSCHEINLICH_WIEDER_DORTHIN_ZURÜCKKEHREN_IN_IHREM_ERSTEN_LEBENSJAHR(
			"113019",
			"Neugeborene und Säuglinge unter 12 Monaten aus Ländern mit hoher Tuberkulose prävalenz, die wahrscheinlich wieder dorthin zurückkehren (in ihrem ersten Lebensjahr)",
			"Nouveau-nés ou nourrissons < 12 mois originaire d’un pays à haute endémie et susceptibles d’y retourner dans leur 1ère année de vie",
			"Neonati o lattanti < 12 mesi originari di un paese a elevata endemia e suscettibili di ritornarci nel loro primo anno di vita ",
			"20130101", "20131231"),

	/**
	 * <div class="de"> Neugeborene von HBsAg-positiven Müttern</div>
	 * <div class="fr">Nouveau-nés de mères HBsAg positives</div>
	 * <div class="it">Neonati di madri HBsAg positive</div>
	 */
	@Deprecated NEUGEBORENE_VON_HBSAG_POSITIVEN_MÜTTERN("113020",
			"Neugeborene von HBsAg-positiven Müttern", "Nouveau-nés de mères HBsAg positives",
			"Neonati di madri HBsAg positive", "20130101", "20131231"),

	/**
	 * <div class="de"> Neurologische oder muskuloskelettale Erkrankung mit
	 * Auswirkung auf die Funktion von Herz, Lungen oder Nieren</div>
	 * <div class="fr">Affection neurologique ou musculo-squelettique avec
	 * répercussion sur la fonction cardiaque, pulmonaire ou rénale</div>
	 * <div class="it">Affezione neurologica o muscolo-scheletrica con
	 * ripercussioni sulla funzione cardiaca, polmonare o renale</div>
	 */
	@Deprecated NEUROLOGISCHE_ODER_MUSKULOSKELETTALE_ERKRANKUNG_MIT_AUSWIRKUNG_AUF_DIE_FUNKTION_VON_HERZ_LUNGEN_ODER_NIEREN(
			"113022",
			"Neurologische oder muskuloskelettale Erkrankung mit Auswirkung auf die Funktion von Herz, Lungen oder Nieren",
			"Affection neurologique ou musculo-squelettique avec répercussion sur la fonction cardiaque, pulmonaire ou rénale",
			"Affezione neurologica o muscolo-scheletrica con ripercussioni sulla funzione cardiaca, polmonare o renale",
			"20130101", "20131231"),

	/**
	 * <div class="de"> Neuromuskuläre Krankheit (Falls Auswirkungen auf Herz-,
	 * Lungen- oder Nierenfunktion)</div><div class="fr">Maladie neuromusculaire
	 * (Si répercussion sur la fonction cardiaque, pulmonaire ou rénale)</div>
	 * <div class="it">Malattia neuromuscolare (Se ripercussione sulla funzione
	 * cardiaca, polmonare o renale)</div>
	 */
	NEUROMUSKULÄRE_KRANKHEIT_FALLS_AUSWIRKUNGEN_AUF_HERZ_LUNGEN_ODER_NIERENFUNKTION("114012",
			"Neuromuskuläre Krankheit (Falls Auswirkungen auf Herz-, Lungen- oder Nierenfunktion)",
			"Maladie neuromusculaire (Si répercussion sur la fonction cardiaque, pulmonaire ou rénale)",
			"Malattia neuromuscolare (Se ripercussione sulla funzione cardiaca, polmonare o renale)",
			"20140101", ""),

	/**
	 * <div class="de"> Niereninsuffizienz</div> <div class="fr">Insuffisance
	 * rénale</div> <div class="it">Insufficienza renale</div>
	 */
	NIERENINSUFFIZIENZ("113023", "Niereninsuffizienz", "Insuffisance rénale",
			"Insufficienza renale", "20130101", ""),

	/**
	 * <div class="de"> Pneumopathien (chronische)</div>
	 * <div class="fr">Pneumopathies chroniques</div>
	 * <div class="it">Pneumopatie croniche</div>
	 */
	@Deprecated PNEUMOPATHIEN_CHRONISCHE("113024", "Pneumopathien (chronische)",
			"Pneumopathies chroniques", "Pneumopatie croniche", "20130101", "20131231"),

	/**
	 * <div class="de"> Schädelbasisfraktur / -Missbildung, zerebrospinale
	 * Liquorfistel</div><div class="fr">Fracture ou malformation de la base du
	 * crâne, fistule de liquide céphalo-rachidien</div><div class="it">Frattura
	 * o malformazione della base del cranio, fistola di liquido
	 * cerebrospinale</div>
	 */
	SCHÄDELBASISFRAKTUR_MISSBILDUNG_ZEREBROSPINALE_LIQUORFISTEL("114032",
			"Schädelbasisfraktur / -Missbildung, zerebrospinale Liquorfistel",
			"Fracture ou malformation de la base du crâne, fistule de liquide céphalo-rachidien",
			"Frattura o malformazione della base del cranio, fistola di liquido cerebrospinale",
			"20140101", ""),

	/**
	 * <div class="de"> Schwangere Frauen und Frauen, die in den letzten 4
	 * Wochen entbunden haben </div> <div class="fr">Femmes enceintes ou ayant
	 * accouchées au cours des 4 semaines précédentes</div><div class="it">Donne
	 * incite o che hanno partorito nelle 4 settimane precedenti</div>
	 */
	@Deprecated SCHWANGERE_FRAUEN_UND_FRAUEN_DIE_IN_DEN_LETZTEN_4_WOCHEN_ENTBUNDEN_HABEN_("113025",
			"Schwangere Frauen und Frauen, die in den letzten 4 Wochen entbunden haben ",
			"Femmes enceintes ou ayant accouchées au cours des 4 semaines précédentes",
			"Donne incite o che hanno partorito nelle 4 settimane precedenti", "20130101",
			"20131231"),

	/**
	 * <div class="de"> Schwangerschaft und post-partum Periode</div>
	 * <div class="fr">Grossesse et post-partum</div><div class="it">Gravidanza
	 * e post-parto</div>
	 */
	SCHWANGERSCHAFT_UND_POST_PARTUM_PERIODE("114028", "Schwangerschaft und post-partum Periode",
			"Grossesse et post-partum", "Gravidanza e post-parto", "20140101", ""),

	/**
	 * <div class="de"> Schwere Neurodermitis beim Kind</div>
	 * <div class="fr">Eczema sévère chez l’enfant</div><div class="it">Eczema
	 * severo nel bambino</div>
	 */
	SCHWERE_NEURODERMITIS_BEIM_KIND("113021", "Schwere Neurodermitis beim Kind",
			"Eczema sévère chez l’enfant", "Eczema severo nel bambino", "20130101", ""),

	/**
	 * <div class="de"> Schweres Asthma: bei verlängerter oder häufiger
	 * Behandlung mit oralen Steroiden</div> <div class="fr">Asthme sévère : si
	 * traitement prolongé ou fréquent par des corticoïdes oraux</div>
	 * <div class="it">Asma severa : se trattamento prolungato o frequente con
	 * corticoidi orali</div>
	 */
	SCHWERES_ASTHMA_BEI_VERLÄNGERTER_ODER_HÄUFIGER_BEHANDLUNG_MIT_ORALEN_STEROIDEN("114004",
			"Schweres Asthma: bei verlängerter oder häufiger Behandlung mit oralen Steroiden",
			"Asthme sévère : si traitement prolongé ou fréquent par des corticoïdes oraux",
			"Asma severa : se trattamento prolungato o frequente con corticoidi orali", "20140101",
			""),

	/**
	 * <div class="de"> Sichelzellanämie</div> <div class="fr">Anémie
	 * falciforme</div> <div class="it">Anemia falciforme</div>
	 */
	SICHELZELLANÄMIE("114014", "Sichelzellanämie", "Anémie falciforme", "Anemia falciforme",
			"20140101", "");

	/** The Constant CODE_SYSTEM_NAME. */
	public static final String CODE_SYSTEM_NAME = "CDA-CH-VACD compl-risks";

	/** The Constant CODE_SYSTEM_OID. */
	public static final String CODE_SYSTEM_OID = "2.16.756.5.30.1.127.3.3.1";

	/** The code. */
	private String code;

	/** The display name. */
	private String displayNameDe;

	/** The display name. */
	private String displayNameFr;

	/** The display name. */
	private String displayNameIt;

	/** The valid from Date. */
	private Date validFrom;

	/** The valid to Date. */
	private Date validTo;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instantsiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>.
	 * 
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @param displayNameDe
	 *            the display name de
	 * @param displayNameFr
	 *            the display name fr
	 * @param displayNameIt
	 *            the display name it
	 * @param validFrom
	 *            the valid from
	 * @param validTo
	 *            the valid to
	 */
	private RiskOfComplications(String code, String displayNameDe, String displayNameFr,
			String displayNameIt, String validFrom, String validTo) {
		this.code = code;
		this.displayNameDe = displayNameDe;
		this.displayNameFr = displayNameFr;
		this.displayNameIt = displayNameIt;
		if ((validFrom != null) && !"".equals(validFrom)) {
			this.validFrom = DateUtil.parseDateyyyyMMdd(validFrom);
		}
		if ((validTo != null) && !"".equals(validTo)) {
			this.validTo = DateUtil.parseDateyyyyMMdd(validTo);
		}
	}

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>.
	 * 
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static RiskOfComplications getEnum(String code) {
		for (final RiskOfComplications x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div>
	 * <div class="de">Liefert das ehealthconnector Code Objekt</div>.
	 * 
	 * @param languageCode
	 *            the language code
	 * @return <div class="en">the code</div>
	 */
	public Code getCode(LanguageCode languageCode) {
		String displayName = null;
		if (languageCode != null) {
			switch (languageCode) {
			case GERMAN:
				displayName = displayNameDe;
				break;
			case FRENCH:
				displayName = displayNameFr;
				break;
			case ITALIAN:
				displayName = displayNameIt;
				break;
			}
		}
		final Code ehcCode = new Code(CODE_SYSTEM_OID, code, displayName);
		return ehcCode;
	}

	/**
	 * <div class="en">Gets the code system name.</div> <div class="de">Liefert
	 * code system name.</div>
	 * 
	 * @return <div class="en">the code system name</div>
	 */
	public String getCodeSystemName() {
		return CODE_SYSTEM_NAME;
	}

	/**
	 * <div class="en">Gets the code system id.</div> <div class="de">Liefert
	 * die code system id.</div>
	 * 
	 * @return <div class="en">the code system id</div>
	 */
	public String getCodeSystemOid() {
		return CODE_SYSTEM_OID;
	}

	/**
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>.
	 * 
	 * @return <div class="en">the code</div>
	 */
	public String getCodeValue() {
		return code;
	}

	/**
	 * <div class="en">Gets the german display name.</div>
	 * <div class="de">Liefert display name in deutscher Sprache.</div>
	 * 
	 * @return <div class="en">the display name</div>
	 */
	public String getDisplayName() {
		return displayNameDe;
	}

	/**
	 * <div class="en">Gets the german display name.</div>
	 * <div class="de">Liefert display name in deutscher Sprache.</div>
	 * 
	 * @return <div class="en">the display name</div>
	 */
	public String getDisplayNameDe() {
		return displayNameDe;
	}

	/**
	 * <div class="en">Gets the french display name.</div>
	 * <div class="de">Liefert display name in französischer Sprache.</div>
	 * 
	 * @return <div class="en">the display name</div>
	 */
	public String getDisplayNameFr() {
		return displayNameFr;
	}

	/**
	 * <div class="en">Gets the italian display name.</div>
	 * <div class="de">Liefert display name in italienischer Sprache.</div>
	 * 
	 * @return <div class="en">the display name</div>
	 */
	public String getDisplayNameIt() {
		return displayNameIt;
	}

	/**
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets
	 * ist.</div>
	 * 
	 * 
	 * @param enumName
	 *            <br>
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public boolean isEnumOfValueSet(String enumName) {
		return Arrays.asList(values()).contains(enumName);
	}

	/**
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der gegebene code in diesem Value Sets
	 * vorhanden ist.</div>
	 * 
	 * @param codeValue
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public boolean isInValueSet(String codeValue) {
		for (final RiskOfComplications x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the code is valid now.
	 * 
	 * @return true, if is valid
	 */
	public boolean isValid() {
		return isValid(null);
	}

	/**
	 * Checks if the code is valid for the specified date.
	 * 
	 * @param date
	 *            the date
	 * @return true, if is valid
	 */
	public boolean isValid(Date date) {
		if (date == null) {
			date = new Date();
		}
		if ((this.validFrom != null) && validFrom.after(date)) {
			return false;
		}
		if ((this.validTo != null) && validTo.before(date)) {
			return false;
		}
		return true;
	}

}