/*******************************************************************************
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 * Year of publication: 2015
 *******************************************************************************/
package org.ehealth_connector.cda.ch.enums;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.utils.DateUtil;

/**
 * Value Set valid from 20160101
 * Value-Set: CDA-CH-VACD copml-risks (OID: 2.16.756.5.30.1.127.3.3.1)
 */
public enum RiskOfComplications {

	/**
	 * <div class="de">Anatomische oder funktionelle Asplenie</div>
	 * <div class="fr">Asplénie anatomique ou fonctionnelle</div>
	 * <div class="it">Asplenia anatomica o funzionale</div>
	 */
	ANATOMISCHE_ODER_FUNKTIONELLE_ASPLENIE("113001", "Anatomische oder funktionelle Asplenie",
			"Asplénie anatomique ou fonctionnelle", "Asplenia anatomica o funzionale", "20130101", ""),
	/**
	 * <div class="de">Cochleaimplantat, in situ oder geplant</div>
	 * <div class="fr">Implant cochléaire, in situ ou planifié</div>
	 * <div class="it">Impianto cocleare, in situ o pianificato</div>
	 */
	COCHLEAIMPLANTAT_IN_SITU_ODER_GEPLANT("113002", "Cochleaimplantat, in situ oder geplant",
			"Implant cochléaire, in situ ou planifié", "Impianto cocleare, in situ o pianificato",
			"20130101", ""),
	/**
	 * <div class="de">Geburt vor der 33. Schwangerschaftswoche oder Geburtsgewicht &lt; 1500g</div>
	 * <div class="fr">Naissance avant la 33e semaine de grossesse ou poids de naissance &lt;1500g</div>
	 * <div class="it">Nascita prima della 33a settimana di gravidanza o peso alla nascita &lt;1500g</div>
	 */
	GEBURT_VOR_DER_33_SCHWANGERSCHAFTSWOCHE_ODER_GEBURTSGEWICHT_GROESSER_1500G("113004",
			"Geburt vor der 33. Schwangerschaftswoche oder Geburtsgewicht &lt; 1500g",
			"Naissance avant la 33e semaine de grossesse ou poids de naissance &lt;1500 g",
			"Nascita prima della 33a settimana di gravidanza o peso alla nascita &lt;1500 g",
			"20130101", ""),
	/**
	 * <div class="de">Herzkrankheiten (chronische, kongenitale Missbildungen)</div>
	 * <div class="fr">Cardiopathies chroniques, malformations congénitales</div>
	 * <div class="it">Cardiopatie croniche, malformazioni congenite</div>
	 */
	HERZKRANKHEITEN_CHRONISCHE_KONGENITALE_MISSBILDUNGEN("113007",
			"Herzkrankheiten (chronische, kongenitale Missbildungen)",
			"Cardiopathies chroniques, malformations congénitales",
			"Cardiopatie croniche, malformazioni congenite", "20130101", ""),
	/**
	 * <div class="de">HIV Infektion mit CD4-Zellen &gt;= 15 % (Erwachsene: &gt;= 200 / µl)</div>
	 * <div class="fr"> Infection à VIH avec CD4 &gt;= 15% (Adultes : &gt;= 200 / µl)</div>
	 * <div class="it">Infezione HIV con CD4 &gt;= 15% (Adulti : &gt;= 200 / µl)</div>
	 */
	HIV_INFEKTION_MIT_CD4_ZELLEN_GROESSER_GLEICH_15_PROZENT_ERWACHSENE_GROESSER_GLEICH_200_PRO_UL(
			"113008",
			"HIV Infektion mit CD4-Zellen &gt;= 15 % (Erwachsene: &gt;= 200 / µl)",
			" Infection à VIH avec CD4 &gt;= 15% (Adultes : &gt;= 200 / µl)",
			"Infezione HIV con CD4 &gt;= 15% (Adulti : &gt;= 200 / µl)", "20130101", ""),
	/**
	 * <div class="de">HIV Infektion mit CD4-Zellen &lt; 15 % (Erwachsene: &lt; 200 / µl)</div>
	 * <div class="fr">Infection à VIH avec CD4 &lt; 15% (Adultes : &lt; 200 / µl)</div>
	 * <div class="it">Infezione HIV con CD4 &lt; 15% (Adulti : &lt; 200 / µl)</div>
	 */
	HIV_INFEKTION_MIT_CD4_ZELLEN_KLEINER_15_PROZENT_ERWACHSENE_KLEINER_200_PRO_UL(
			"113009",
			"HIV Infektion mit CD4-Zellen &lt; 15 % (Erwachsene: &lt; 200 / µl)",
			"Infection à VIH avec CD4 &lt; 15% (Adultes : &lt; 200 / µl)",
			"Infezione HIV con CD4 &lt; 15% (Adulti : &lt; 200 / µl)", "20130101", ""),
	/**
	 * <div class="de">Lymphom, Leukämie, Myelom</div>
	 * <div class="fr">Lymphome, leucémie, myélome</div>
	 * <div class="it">Linfoma, leucemia, mieloma</div>
	 */
	LYMPHOM_LEUKAEMIE_MYELOM("113012", "Lymphom, Leukämie, Myelom",
			"Lymphome, leucémie, myélome", "Linfoma, leucemia, mieloma", "20130101",
			""),
	/**
	 * <div class="de">Mangel an Mannose-bindendem Lektin</div>
	 * <div class="fr">Déficit en lectine liant le mannose</div>
	 * <div class="it">Deficit di lectina legante il mannosio</div>
	 */
	MANGEL_AN_MANNOSE_BINDENDEM_LEKTIN("113014",
			"Mangel an Mannose-bindendem Lektin",
			"Déficit en lectine liant le mannose",
			"Deficit di lectina legante il mannosio", "20130101", ""),
	/**
	 * <div class="de">Nephrotisches Syndrom</div>
	 * <div class="fr">Syndrome néphrotique</div>
	 * <div class="it">Sindrome nefrosica</div>
	 */
	NEPHROTISCHES_SYNDROM("113018", "Nephrotisches Syndrom",
			"Syndrome néphrotique", "Sindrome nefrosica", "20130101", ""),
	/**
	 * <div class="de">Schwere Neurodermitis beim Kind</div>
	 * <div class="fr">Eczema sévère chez l’enfant</div>
	 * <div class="it">Eczema severo nel bambino</div>
	 */
	SCHWERE_NEURODERMITIS_BEIM_KIND("113021",
			"Schwere Neurodermitis beim Kind",
			"Eczema sévère chez l’enfant", "Eczema severo nel bambino",
			"20130101", ""),
	/**
	 * <div class="de">Niereninsuffizienz</div>
	 * <div class="fr">Insuffisance rénale</div>
	 * <div class="it">Insufficienza renale</div>
	 */
	NIERENINSUFFIZIENZ("113023", "Niereninsuffizienz",
			"Insuffisance rénale", "Insufficienza renale",
			"20130101", ""),
	/**
	 * <div class="de">Herzinsuffizienz</div>
	 * <div class="fr">Insuffisance cardiaque</div>
	 * <div class="it">Insufficienza cardiaca</div>
	 */
	HERZINSUFFIZIENZ("114001", "Herzinsuffizienz",
			"Insuffisance cardiaque", "Insufficienza cardiaca",
			"20140101", ""),
	/**
	 * <div class="de">Kardiopathie, angeborene Fehlbildung</div>
	 * <div class="fr">Cardiopathie, malformation congénitale</div>
	 * <div class="it">Cardiopatia, malformazione congenita</div>
	 */
	KARDIOPATHIE("114002",
			"Kardiopathie, angeborene Fehlbildung",
			"Cardiopathie, malformation congénitale",
			"Cardiopatia, malformazione congenita",
			"20140101", ""),
	/**
	 * <div class="de">Chronisch obstruktive Pneumopathie</div>
	 * <div class="fr">Pneumopathie chronique obstructive</div>
	 * <div class="it">Pneumopatia cronica ostruttiva</div>
	 */
	CHRONISCH_OBSTRUKTIVE_PNEUMOPATHIE("114003",
			"Chronisch obstruktive Pneumopathie",
			"Pneumopathie chronique obstructive",
			"Pneumopatia cronica ostruttiva",
			"20140101", ""),
	/**
	 * <div class="de">Schweres Asthma: bei verlängerter oder häufiger Behandlung mit oralen Steroiden</div>
	 * <div class="fr">Asthme sévère : si traitement prolongé ou fréquent par des corticoïdes oraux</div>
	 * <div class="it">Asma severa : se trattamento prolungato o frequente con corticoidi orali</div>
	 */
	SCHWERES_ASTHMA_BEI_VERLAENGERTER_ODER_HAEUFIGER_BEHANDLUNG_MIT_ORALEN_STEROIDEN(
			"114004",
			"Schweres Asthma: bei verlängerter oder häufiger Behandlung mit oralen Steroiden",
			"Asthme sévère : si traitement prolongé ou fréquent par des corticoïdes oraux",
			"Asma severa : se trattamento prolungato o frequente con corticoidi orali",
			"20140101", ""),
	/**
	 * <div class="de">Bronchiektasen durch Antikörpermangel</div>
	 * <div class="fr">Bronchiectasies sur carence en anticorps</div>
	 * <div class="it">Bronchiettasie su carenza in anticorpi</div>
	 */
	BRONCHIEKTASEN_DURCH_ANTIKOERPERMANGEL(
			"114005",
			"Bronchiektasen durch Antikörpermangel",
			"Bronchiectasies sur carence en anticorps",
			"Bronchiettasie su carenza in anticorpi",
			"20140101", ""),
	/**
	 * <div class="de">Andere Lungenerkrankungen (z.B. Mukoviszidose, Asthma bronchiale, etc.)</div>
	 * <div class="fr">Autres maladies pulmonaires (ex : mucoviscidose, asthme traité par aérosols, etc)</div>
	 * <div class="it">Altre malattie polmonari (p.es. mucoviscidosi, asma trattata con aerosol, ecc.)</div>
	 */
	ANDERE_LUNGENERKRANKUNGEN_ZB_MUKOVISZIDOSE_ASTHMA_BRONCHIALE_ETC(
			"114006",
			"Andere Lungenerkrankungen (z.B. Mukoviszidose, Asthma bronchiale, etc.)",
			"Autres maladies pulmonaires (ex : mucoviscidose, asthme traité par aérosols, etc)",
			"Altre malattie polmonari (p.es. mucoviscidosi, asma trattata con aerosol, ecc.)",
			"20140101", ""),
	/**
	 * <div class="de">Chronische Lebererkrankung</div>
	 * <div class="fr">Maladie hépatique chronique</div>
	 * <div class="it">Malattia epatica cronica</div>
	 */
	CHRONISCHE_LEBERERKRANKUNG(
			"114007",
			"Chronische Lebererkrankung",
			"Maladie hépatique chronique",
			"Malattia epatica cronica",
			"20140101", ""),
	/**
	 * <div class="de">Leberzirrhose</div>
	 * <div class="fr">Cirrhose hépatique</div>
	 * <div class="it">Cirrosi epatica</div>
	 */
	LEBERZIRRHOSE("114008",
			"Leberzirrhose",
			"Cirrhose hépatique",
			"Cirrosi epatica",
			"20140101", ""),
	/**
	 * <div class="de">Neuromuskuläre Krankheit (Falls Auswirkungen auf Herz-, Lungen- oder Nierenfunktion)</div>
	 * <div class="fr">Maladie neuromusculaire (Si répercussion sur la fonction cardiaque, pulmonaire ou rénale)</div>
	 * <div class="it">Malattia neuromuscolare (Se ripercussione sulla funzione cardiaca, polmonare o renale)</div>
	 */
	NEUROMUSKULAERE_KRANKHEIT_FALLS_AUSWIRKUNGEN_AUF_HERZ__LUNGEN_ODER_NIERENFUNKTION(
			"114012",
			"Neuromuskuläre Krankheit (Falls Auswirkungen auf Herz-, Lungen- oder Nierenfunktion)",
			"Maladie neuromusculaire (Si répercussion sur la fonction cardiaque, pulmonaire ou rénale)",
			"Malattia neuromuscolare (Se ripercussione sulla funzione cardiaca, polmonare o renale)",
			"20140101", ""),
	/**
	 * <div class="de">Sichelzellanämie</div>
	 * <div class="fr">Anémie falciforme</div>
	 * <div class="it">Anemia falciforme</div>
	 */
	SICHELZELLANAEMIE(
			"114014",
			"Sichelzellanämie",
			"Anémie falciforme",
			"Anemia falciforme",
			"20140101", ""),
	/**
	 * <div class="de">Diabetes mit Auswirkung auf die Funktion von Herz, Lungen oder Nieren</div>
	 * <div class="fr">Diabète avec répercussion sur la fonction cardiaque, pulmonaire ou rénale</div>
	 * <div class="it">Diabete con ripercussioni sulla funzione cardiopolmonare o renale</div>
	 */
	DIABETES_MIT_AUSWIRKUNG_AUF_DIE_FUNKTION_VON_HERZ_LUNGEN_ODER_NIEREN(
			"114015",
			"Diabetes mit Auswirkung auf die Funktion von Herz, Lungen oder Nieren",
			"Diabète avec répercussion sur la fonction cardiaque, pulmonaire ou rénale",
			"Diabete con ripercussioni sulla funzione cardiopolmonare o renale",
			"20140101",
			""),
	/**
	 * <div class="de">Morbide Adipositas (BMI &gt;= 40)</div>
	 * <div class="fr">Obésité morbide (IMC &gt;= 40)</div>
	 * <div class="it">Obesità patologica (IMC &gt;= 40)</div>
	 */
	MORBIDE_ADIPOSITAS_BMI_GROESSER_40(
			"114016",
			"Morbide Adipositas (BMI &gt;= 40)",
			"Obésité morbide (IMC &gt;= 40)",
			"Obesità patologica (IMC &gt;= 40)",
			"20140101",
			""),
	/**
	 * <div class="de">Kandidaten für eine Solidorgantransplantation</div>
	 * <div class="fr">Candidats à une transplantation d'organe solide</div>
	 * <div class="it">Candidati a un trapianto d'organo solido</div>
	 */
	KANDIDATEN_FUER_EINE_SOLIDORGANTRANSPLANTATION(
			"114018",
			"Kandidaten für eine Solidorgantransplantation",
			"Candidats à une transplantation d'organe solide",
			"Candidati a un trapianto d'organo solido",
			"20140101",
			""),
	/**
	 * <div class="de">Empfänger einer Solidorgantransplantation</div>
	 * <div class="fr">Receveurs d'une transplantation d'organe solide</div>
	 * <div class="it">Riceventi di un trapianto d'organo solido</div>
	 */
	EMPFAENGER_EINER_SOLIDORGANTRANSPLANTATION(
			"114019",
			"Empfänger einer Solidorgantransplantation",
			"Receveurs d'une transplantation d'organe solide",
			"Riceventi di un trapianto d'organo solido",
			"20140101",
			""),
	/**
	 * <div class="de">Empfänger einer Stammzelltransplantation</div>
	 * <div class="fr">Receveurs de cellules souches hématopoïétiques</div>
	 * <div class="it">Riceventi di cellule staminali ematopoietiche</div>
	 */
	EMPFAENGER_EINER_STAMMZELLTRANSPLANTATION(
			"114020",
			"Empfänger einer Stammzelltransplantation",
			"Receveurs de cellules souches hématopoïétiques",
			"Riceventi di cellule staminali ematopoietiche",
			"20140101",
			""),
	/**
	 * <div class="de">Autoimmunkrankheit, welche eine Immunsuppression erfordert</div>
	 * <div class="fr">Maladie auto-immune exigeant vraisemblablement une immunosuppression</div>
	 * <div class="it">Malattia autoimmune che richiede probabilmente una immunosoppressione</div>
	 */
	AUTOIMMUNKRANKHEIT_WELCHE_EINE_IMMUNSUPPRESSION_ERFORDERT(
			"114021",
			"Autoimmunkrankheit, welche eine Immunsuppression erfordert",
			"Maladie auto-immune exigeant vraisemblablement une immunosuppression",
			"Malattia autoimmune che richiede probabilmente una immunosoppressione",
			"20140101",
			""),
	/**
	 * <div class="de">Medikamentöse Immunosuppression (inkl. systemische Langzeitkortikoidtherapie und Radiotherapie)</div>
	 * <div class="fr">Immunosuppression médicamenteuse (y c. corticothérapie de longue durée par voie générale et radiothérapie)</div>
	 * <div class="it">Immunosoppressione medicamentosa (compresa una corticoterapia di lunga durata per via generale e una radioterapia)</div>
	 */
	MEDIKAMENTOESE_IMMUNOSUPPRESSION_INKL_SYSTEMISCHE_LANGZEITKORTIKOIDTHERAPIE_UND_RADIOTHERAPIE(
			"114022",
			"Medikamentöse Immunosuppression (inkl. systemische Langzeitkortikoidtherapie und Radiotherapie)",
			"Immunosuppression médicamenteuse (y c. corticothérapie de longue durée par voie générale et radiothérapie)",
			"Immunosoppressione medicamentosa (compresa una corticoterapia di lunga durata per via generale e una radioterapia)",
			"20140101",
			""),
	/**
	 * <div class="de">Angeborene Immundefizienz, variables Immundefektsyndrom, defizitäre Antwort auf Polysaccharide</div>
	 * <div class="fr">Immunodéficience congénitale, immunodéficience commune variable, déficit réponse aux polysaccharidiques</div>
	 * <div class="it">Immunodeficienza congenita, immunodeficienza comune variabile, deficit di risposta ai polisaccaridi</div>
	 */
	ANGEBORENE_IMMUNDEFIZIENZ_VARIABLES_IMMUNDEFEKTSYNDROM_DEFIZITAERE_ANTWORT_AUF_POLYSACCHARIDE(
			"114025",
			"Angeborene Immundefizienz, variables Immundefektsyndrom, defizitäre Antwort auf Polysaccharide",
			"Immunodéficience congénitale, immunodéficience commune variable, déficit réponse aux polysaccharidiques",
			"Immunodeficienza congenita, immunodeficienza comune variabile, deficit di risposta ai polisaccaridi",
			"20140101",
			""),
	/**
	 * <div class="de">Mangel im klassischen oder alternativen Weg der Komplementaktivierung</div>
	 * <div class="fr">Déficit en facteurs de la voie alterne ou terminale du complément</div>
	 * <div class="it">Deficit in fattori della via alterna o terminale del complemento</div>
	 */
	MANGEL_IM_KLASSISCHEN_ODER_ALTERNATIVEN_WEG_DER_KOMPLEMENTAKTIVIERUNG(
			"114026",
			"Mangel im klassischen oder alternativen Weg der Komplementaktivierung",
			"Déficit en facteurs de la voie alterne ou terminale du complément",
			"Deficit in fattori della via alterna o terminale del complemento",
			"20140101",
			""),
	/**
	 * <div class="de">Schwangerschaft und post-partum Periode</div>
	 * <div class="fr">Grossesse et post-partum</div>
	 * <div class="it">Gravidanza e post-parto</div>
	 */
	SCHWANGERSCHAFT_UND_POST_PARTUM_PERIODE(
			"114028",
			"Schwangerschaft und post-partum Periode",
			"Grossesse et post-partum",
			"Gravidanza e post-parto",
			"20140101",
			""),
	/**
	 * <div class="de">Schädelbasisfraktur /-Missbildung, zerebrospinale Liquorfistel</div>
	 * <div class="fr">Fracture ou malformation de la base du crâne, fistule de liquide céphalo-rachidien</div>
	 * <div class="it">Frattura o malformazione della base del cranio, fistola di liquido cerebrospinale</div>
	 */
	SCHAEDELBASISFRAKTUR_MISSBILDUNG_ZEREBROSPINALE_LIQUORFISTEL(
			"114032",
			"Schädelbasisfraktur / -Missbildung, zerebrospinale Liquorfistel",
			"Fracture ou malformation de la base du crâne, fistule de liquide céphalo-rachidien",
			"Frattura o malformazione della base del cranio, fistola di liquido cerebrospinale",
			"20140101",
			""),
	/**
	 * <div class="de">Andere Nierenerkrankung</div>
	 * <div class="fr">autre maladie des reins</div>
	 * <div class="it">altra malattia renale</div>
	 */
	ANDERE_NIERENERKRANKUNG(
			"114033",
			"andere Nierenerkrankung",
			"autre maladie des reins",
			"altra malattia renale",
			"20150101",
			""),
	/**
	 * <div class="de"> Anderer Krebs</div>
	 * <div class="fr">autre cancer</div>
	 * <div class="it">altro cancro</div>
	 */
	ANDERER_KREBS(
			"114034",
			"anderer Krebs",
			"autre cancer",
			"altro cancro",
			"20150101",
			""),
	/**
	 * <div class="de">Protein-S oder Protein-C Defizit</div>
	 * <div class="fr">déficit en protéine S et protéine C </div>
	 * <div class="it">deficit di proteina S e proteina C</div>
	 */
	PROTEIN_S_ODER_PROTEIN_C_DEFIZIT(
			"114035",
			"Protein-S oder Protein-C Defizit",
			"déficit en protéine S et protéine C ",
			"deficit di proteina S e proteina C",
			"20150101",
			""),
	/**
	 * <div class="de"> andere Lebererkrankung</div>
	 * <div class="fr">autre maladie hépatique</div>
	 * <div class="it">altra malattia epatica</div>
	 */
	ANDERE_LEBERERKRANKUNG(
			"114036",
			"andere Lebererkrankung",
			"autre maladie hépatique",
			"altra malattia epatica",
			"20150101",
			""),
	/**
	 * <div class="de">Hämodialysepatient</div>
	 * <div class="fr">Personnes dialysées</div>
	 * <div class="it">Persone in dialisi</div>
	 */
	HAEMODIALYSEPATIENT(
			"114037",
			"Hämodialysepatient",
			"Personnes dialysées",
			"Persone in dialisi",
			"20150101",
			""),
	/**
	 * <div class="de"> Hämophilie Patient</div>
	 * <div class="fr">Personnes hémophiles</div>
	 * <div class="it">Persone affette da emofilia</div>
	 */
	HAEMOPHILIE_PATIENT(
			"114038",
			"hämophilie Patient",
			"Personnes hémophiles",
			"Persone affette da emofilia",
			"20150101",
			"");

	/** The Constant CODE_SYSTEM_NAME. */
	public static final String CODE_SYSTEM_NAME = "CDA-CH-VACD compl-risks";

	/** The Constant CODE_SYSTEM_OID. */
	public static final String CODE_SYSTEM_OID = "2.16.756.5.30.1.127.3.3.1";

	/** The code. */
	private String code;

	/** The display names per language */
	private Map<LanguageCode, String> displayNames;

	/** The valid from Date. */
	private Date validFrom;

	/** The valid to Date. */
	private Date validTo;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div>
	 * <div class="de">Instantsiert dieses Enum Object mittels eines Codes und einem Display Name</div>.
	 * @param code
	 * <br>
	 * <div class="de"> code</div>
	 * @param displayNameDe
	 * the display name de
	 * @param displayNameFr
	 * the display name fr
	 * @param displayNameIt
	 * the display name it
	 * @param validFrom
	 * the valid from
	 * @param validTo
	 * the valid to
	 */
	private RiskOfComplications(String code, String displayNameDe, String displayNameFr,
			String displayNameIt, String validFrom, String validTo) {
		this.code = code;

		displayNames = new HashMap<>();
		displayNames.put(LanguageCode.GERMAN, displayNameDe);
		displayNames.put(LanguageCode.FRENCH, displayNameFr);
		displayNames.put(LanguageCode.ITALIAN, displayNameIt);
		if (validFrom != null && !"".equals(validFrom)) {
			this.validFrom = DateUtil.parseDateyyyyMMdd(validFrom);
		}
		if (validTo != null && !"".equals(validTo)) {
			this.validTo = DateUtil.parseDateyyyyMMdd(validTo);
		}
	}

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>.
	 * @param code
	 * <br>
	 * <div class="de"> code</div>
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
	 * @param languageCode
	 * the language code
	 * @return <div class="en">the code</div>
	 */
	public Code getCode(LanguageCode languageCode) {
		String displayName = null;
		if (languageCode != null && displayNames.get(languageCode) != null) {
			displayName = displayNames.get(languageCode);
		} else {
			displayName = displayNames.get(LanguageCode.GERMAN);
		}
		final Code ehcCode = new Code(CODE_SYSTEM_OID, code, displayName);
		return ehcCode;
	}

	/**
	 * <div class="en">Gets the code system name.</div> <div class="de">Liefert
	 * code system name.</div>
	 * @return <div class="en">the code system name</div>
	 */
	public String getCodeSystemName() {
		return CODE_SYSTEM_NAME;
	}

	/**
	 * <div class="en">Gets the code system id.</div> <div class="de">Liefert
	 * die code system id.</div>
	 * @return <div class="en">the code system id</div>
	 */
	public String getCodeSystemOid() {
		return CODE_SYSTEM_OID;
	}

	/**
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>.
	 * @return <div class="en">the code</div>
	 */
	public String getCodeValue() {
		return code;
	}

	/**
	 * <div class="en">Gets the display name defined by the language param. If
	 * language is unknow, german name is returned</div> 
	 * <div class="de">Liefert display name gemäss Parameter, falls die Sprache unbekannt ist, wird
	 * standartmässig deutsch geliefert.</div> 
	 * 
	 * @param the language code to get the display name for
	 * @return returns the display name in the desired language. if language not found, display name in german will returned
	 */
	public String getDisplayName(LanguageCode languageCode) {
		String displayName = null;
		if (languageCode != null && displayNames.get(languageCode) != null) {
			displayName = displayNames.get(languageCode);
		} else {
			displayName = displayNames.get(LanguageCode.GERMAN);
		}
		return displayName;
	}

	/**
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets ist.</div>
	 * 
	 * @param enumName <br><div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public boolean isEnumOfValueSet(String enumName) {
		return Arrays.asList(values()).contains(enumName);
	}

	/**
 * <div class="en">Checks if a given code value is in this value set.</div>
 * <div class="de">Prüft, ob der gegebene code in diesem Value Sets
 * vorhanden ist.</div>
 * @param codeValue <br><div class="de"> code</div>
 * @return true, if is in value set
 */
	public static boolean isInValueSet(String codeValue) {
		for (final RiskOfComplications x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the code is valid now.
	 * @return true, if is valid
	 */
	public boolean isValid() {
		return isValid(null);
	}

	/**
 * Checks if the code is valid for the specified date.
 * @param date the date
 * @return true, if is valid
 */
	public boolean isValid(Date date) {
		if (date == null) {
			date = new Date();
		}
		if (validFrom != null && validFrom.after(date)) {
			return false;
		}
		if (validTo != null && validTo.before(date)) {
			return false;
		}
		return true;
	}
}
