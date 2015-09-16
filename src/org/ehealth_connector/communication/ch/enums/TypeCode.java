package org.ehealth_connector.communication.ch.enums;

import java.util.Arrays;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.XdsUtil;
import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;
import org.openhealthtools.ihe.xds.metadata.MetadataFactory;

/*
 *<div class="de">Der Code definiert den Typ eines Dokuments (z.B.  Austrittsbericht, Labor-Bericht). Jeder Dokumenten-Typ sollte genau einer Dokumentenklasse zugeordnet sein.</div>
 *<div class="fr"></div>
 */
public enum TypeCode implements CodedMetadataEnumInterface {

	/**
	 * <div class="de">Andere nicht näher spezifiziert</div> <div
	 * class="fr">Autres sans spécification</div> <div class="it">Altri non
	 * meglio precisati</div>
	 */
	ANDERE_NICHT_NÄHER_SPEZIFIZIERT("60999", "Andere nicht näher spezifiziert"),
	/**
	 * <div class="de">Anästhesie Bericht</div> <div class="fr"></div> <div
	 * class="it"></div>
	 */
	ANÄSTHESIE_BERICHT("60032", "Anästhesie Bericht"),
	/**
	 * <div class="de">Austrittsbericht (lang-pflegerisch)</div> <div
	 * class="fr"></div> <div class="it"></div>
	 */
	AUSTRITTSBERICHT_LANG_PFLEGERISCH("60012", "Austrittsbericht (lang-pflegerisch)"),
	/**
	 * <div class="de">Austrittsbericht (lang-ärztlich)</div> <div
	 * class="fr">Lettre de sortie</div> <div class="it"></div>
	 */
	AUSTRITTSBERICHT_LANG_ÄRZTLICH("60010", "Austrittsbericht (lang-ärztlich)"),
	/**
	 * <div class="de">Behandlungsschema</div> <div class="fr"></div> <div
	 * class="it"></div>
	 */
	BEHANDLUNGSSCHEMA("60045", "Behandlungsschema"),
	/**
	 * <div class="de">Beschlussprotokoll</div> <div class="fr"></div> <div
	 * class="it"></div>
	 */
	BESCHLUSSPROTOKOLL("60039", "Beschlussprotokoll"),
	/**
	 * <div class="de">Dokument mit Kontraindikationen,
	 * Unverträglichkeiten….</div> <div class="fr"></div> <div class="it"></div>
	 */
	DOKUMENT_MIT_KONTRAINDIKATIONEN_UNVERTRÄGLICHKEITEN("60046",
			"Dokument mit Kontraindikationen, Unverträglichkeiten…."),
	/**
	 * <div class="de">Echokardiographie-Befund</div> <div class="fr"></div>
	 * <div class="it"></div>
	 */
	ECHOKARDIOGRAPHIE_BEFUND("60029", "Echokardiographie-Befund"),
	/**
	 * <div class="de">Eintrittsbericht</div> <div class="fr"></div> <div
	 * class="it"></div>
	 */
	EINTRITTSBERICHT("60008", "Eintrittsbericht"),
	/**
	 * <div class="de">elektronischer Impfausweis</div> <div class="fr"></div>
	 * <div class="it"></div>
	 */
	ELEKTRONISCHER_IMPFAUSWEIS("60043", "elektronischer Impfausweis"),
	/**
	 * <div class="de">elektronisches Rezept</div> <div class="fr">Ordonnance de
	 * médicaments</div> <div class="it"></div>
	 */
	ELEKTRONISCHES_REZEPT("60006", "elektronisches Rezept"),
	/**
	 * <div class="de">Geburtsanzeige</div> <div class="fr"></div> <div
	 * class="it"></div>
	 */
	GEBURTSANZEIGE("60047", "Geburtsanzeige"),
	/**
	 * <div class="de">Herzkatheter-Befund</div> <div class="fr">Rapport de
	 * cathétérisme cardiaque</div> <div class="it"></div>
	 */
	HERZKATHETER_BEFUND("60028", "Herzkatheter-Befund"),
	/**
	 * <div class="de">Histologie-Befund</div> <div class="fr"></div> <div
	 * class="it"></div>
	 */
	HISTOLOGIE_BEFUND("60027", "Histologie-Befund"),
	/**
	 * <div class="de">Kardiologie Verlaufs-Bericht</div> <div class="fr"></div>
	 * <div class="it"></div>
	 */
	KARDIOLOGIE_VERLAUFS_BERICHT("60037", "Kardiologie Verlaufs-Bericht"),
	/**
	 * <div class="de">klinisches Verlaufsblatt</div> <div class="fr"></div>
	 * <div class="it"></div>
	 */
	KLINISCHES_VERLAUFSBLATT("60036", "klinisches Verlaufsblatt"),
	/**
	 * <div class="de">Knochenmark-Biopsie-Befund</div> <div class="fr"></div>
	 * <div class="it"></div>
	 */
	KNOCHENMARK_BIOPSIE_BEFUND("60026", "Knochenmark-Biopsie-Befund"),
	/**
	 * <div class="de">Konsilauftrag (allgemein)</div> <div class="fr">Demande
	 * de consultation</div> <div class="it"></div>
	 */
	KONSILAUFTRAG_ALLGEMEIN("60017", "Konsilauftrag (allgemein)"),
	/**
	 * <div class="de">Konsultationsbericht</div> <div class="fr">Rapport de
	 * consultation</div> <div class="it"></div>
	 */
	KONSULTATIONSBERICHT("60021", "Konsultationsbericht"),
	/**
	 * <div class="de">Kostengutsprache</div> <div class="fr"></div> <div
	 * class="it"></div>
	 */
	KOSTENGUTSPRACHE("60048", "Kostengutsprache"),
	/**
	 * <div class="de">Kurve Intensivstation</div> <div class="fr"></div> <div
	 * class="it"></div>
	 */
	KURVE_INTENSIVSTATION("60038", "Kurve Intensivstation"),
	/**
	 * <div class="de">Kurz-Austrittsbericht (pflegerisch)</div> <div
	 * class="fr"></div> <div class="it"></div>
	 */
	KURZ_AUSTRITTSBERICHT_PFLEGERISCH("60011", "Kurz-Austrittsbericht (pflegerisch)"),
	/**
	 * <div class="de">Kurz-Austrittsbericht (ärztlich)</div> <div
	 * class="fr">Avis de sortie</div> <div class="it"></div>
	 */
	KURZ_AUSTRITTSBERICHT_ÄRZTLICH("60009", "Kurz-Austrittsbericht (ärztlich)"),
	/**
	 * <div class="de">Laborauftrag</div> <div class="fr"></div> <div
	 * class="it"></div>
	 */
	LABORAUFTRAG("60018", "Laborauftrag"),
	/**
	 * <div class="de">Labor-Befund</div> <div class="fr">Résultat de
	 * laboratoire</div> <div class="it"></div>
	 */
	LABOR_BEFUND("60023", "Labor-Befund"),
	/**
	 * <div class="de">Lungenfunktions-Befund</div> <div class="fr"></div> <div
	 * class="it"></div>
	 */
	LUNGENFUNKTIONS_BEFUND("60030", "Lungenfunktions-Befund"),
	/**
	 * <div class="de">Medikamentenliste (aktuell)</div> <div class="fr">Liste
	 * des médicaments</div> <div class="it"></div>
	 */
	MEDIKAMENTENLISTE_AKTUELL("60005", "Medikamentenliste (aktuell)"),
	/**
	 * <div class="de">Meldung übertragbare Erkrankung</div> <div
	 * class="fr"></div> <div class="it"></div>
	 */
	MELDUNG_ÜBERTRAGBARE_ERKRANKUNG("60042", "Meldung übertragbare Erkrankung"),
	/**
	 * <div class="de">Nicht spezifizierte Bilddaten</div> <div
	 * class="fr"></div> <div class="it"></div>
	 */
	NICHT_SPEZIFIZIERTE_BILDDATEN("60040", "Nicht spezifizierte Bilddaten"),
	/**
	 * <div class="de">Notfallbericht</div> <div class="fr">Rapport de
	 * consultation aux urgences</div> <div class="it"></div>
	 */
	NOTFALLBERICHT("60035", "Notfallbericht"),
	/**
	 * <div class="de">Notfall-Ausweis</div> <div class="fr"></div> <div
	 * class="it"></div>
	 */
	NOTFALL_AUSWEIS("60044", "Notfall-Ausweis"),
	/**
	 * <div class="de">OP-Bericht</div> <div class="fr">Protocole
	 * opératoire</div> <div class="it"></div>
	 */
	OP_BERICHT("60033", "OP-Bericht"),
	/**
	 * <div class="de">Pathologieauftrag</div> <div class="fr"></div> <div
	 * class="it"></div>
	 */
	PATHOLOGIEAUFTRAG("60019", "Pathologieauftrag"),
	/**
	 * <div class="de">Pathologie-Befund</div> <div class="fr">Rapport de
	 * pathologie</div> <div class="it"></div>
	 */
	PATHOLOGIE_BEFUND("60025", "Pathologie-Befund"),
	/**
	 * <div class="de">Patienteneinwilligung </div> <div class="fr">Consentement
	 * du patient</div> <div class="it"></div>
	 */
	PATIENTENEINWILLIGUNG("60002", "Patienteneinwilligung "),
	/**
	 * <div class="de">Patienteneinwilligung für die Verwendung der
	 * elektronischen Daten</div> <div class="fr">Consentement du patient au
	 * dossier électronique</div> <div class="it"></div>
	 */
	PATIENTENEINWILLIGUNG_FÜR_DIE_VERWENDUNG_DER_ELEKTRONISCHEN_DATEN("60001",
			"Patienteneinwilligung für die Verwendung der elektronischen Daten"),
	/**
	 * <div class="de">Patientenverfügung</div> <div class="fr"></div> <div
	 * class="it"></div>
	 */
	PATIENTENVERFÜGUNG("60003", "Patientenverfügung"),
	/**
	 * <div class="de">Patient Summary (medizinische Zusammenfassung)</div> <div
	 * class="fr">Résumé d'un patient</div> <div class="it"></div>
	 */
	PATIENT_SUMMARY_MEDIZINISCHE_ZUSAMMENFASSUNG("60004",
			"Patient Summary (medizinische Zusammenfassung)"),
	/**
	 * <div class="de">Pflegebericht</div> <div class="fr"></div> <div
	 * class="it"></div>
	 */
	PFLEGEBERICHT("60016", "Pflegebericht"),
	/**
	 * <div class="de">Pflegeplan (allgemein)</div> <div class="fr"></div> <div
	 * class="it"></div>
	 */
	PFLEGEPLAN_ALLGEMEIN("60015", "Pflegeplan (allgemein)"),
	/**
	 * <div class="de">Physiotherapiebericht</div> <div class="fr"></div> <div
	 * class="it"></div>
	 */
	PHYSIOTHERAPIEBERICHT("60031", "Physiotherapiebericht"),
	/**
	 * <div class="de">Radiologieauftrag</div> <div class="fr"></div> <div
	 * class="it"></div>
	 */
	RADIOLOGIEAUFTRAG("60020", "Radiologieauftrag"),
	/**
	 * <div class="de">Radiologie-Befund</div> <div class="fr">Rapport
	 * d'imagerie</div> <div class="it"></div>
	 */
	RADIOLOGIE_BEFUND("60024", "Radiologie-Befund"),
	/**
	 * <div class="de">Radiologische Bilddaten</div> <div class="fr"></div> <div
	 * class="it"></div>
	 */
	RADIOLOGISCHE_BILDDATEN("60041", "Radiologische Bilddaten"),
	/**
	 * <div class="de">Unbekannt</div> <div class="fr">Inconnu</div> <div
	 * class="it">Ignoto</div>
	 */
	UNBEKANNT("60900", "Unbekannt"),
	/**
	 * <div class="de">Untersuchungsbefund (allgemein)</div> <div
	 * class="fr">Rapport d'examen (non laboratoire)</div> <div
	 * class="it"></div>
	 */
	UNTERSUCHUNGSBEFUND_ALLGEMEIN("60022", "Untersuchungsbefund (allgemein)"),
	/**
	 * <div class="de">Verlaufs- / Austrittsbericht Gynäkologie und
	 * Geburtshilfe</div> <div class="fr"></div> <div class="it"></div>
	 */
	VERLAUFS_AUSTRITTSBERICHT_GYNÄKOLOGIE_UND_GEBURTSHILFE("60014",
			"Verlaufs- / Austrittsbericht Gynäkologie und Geburtshilfe"),
	/**
	 * <div class="de">Verlegungsbericht</div> <div class="fr"></div> <div
	 * class="it"></div>
	 */
	VERLEGUNGSBERICHT("60013", "Verlegungsbericht"),
	/**
	 * <div class="de">Wundbefund</div> <div class="fr"></div> <div
	 * class="it"></div>
	 */
	WUNDBEFUND("60034", "Wundbefund"),
	/**
	 * <div class="de">Zuweisungsschreiben/Einweisungsschreiben</div> <div
	 * class="fr">Demande d’admission</div> <div class="it"></div>
	 */
	ZUWEISUNGSSCHREIBENEINWEISUNGSSCHREIBEN("60007", "Zuweisungsschreiben/Einweisungsschreiben");

	/**
	 * <div class="de">Code für Andere nicht näher spezifiziert</div> <div
	 * class="fr">Code de Autres sans spécification</div> <div class="it">Code
	 * per Altri non meglio precisati</div>
	 */
	public static final String ANDERE_NICHT_NÄHER_SPEZIFIZIERT_CODE = "60999";

	/**
	 * <div class="de">Code für Anästhesie Bericht</div>
	 */
	public static final String ANÄSTHESIE_BERICHT_CODE = "60032";

	/**
	 * <div class="de">Code für Austrittsbericht (lang-pflegerisch)</div>
	 */
	public static final String AUSTRITTSBERICHT_LANG_PFLEGERISCH_CODE = "60012";

	/**
	 * <div class="de">Code für Austrittsbericht (lang-ärztlich)</div> <div
	 * class="fr">Code de Lettre de sortie</div>
	 */
	public static final String AUSTRITTSBERICHT_LANG_ÄRZTLICH_CODE = "60010";

	/**
	 * <div class="de">Code für Behandlungsschema</div>
	 */
	public static final String BEHANDLUNGSSCHEMA_CODE = "60045";

	/**
	 * <div class="de">Code für Beschlussprotokoll</div>
	 */
	public static final String BESCHLUSSPROTOKOLL_CODE = "60039";

	/**
	 * <div class="de">Code für Dokument mit Kontraindikationen,
	 * Unverträglichkeiten….</div>
	 */
	public static final String DOKUMENT_MIT_KONTRAINDIKATIONEN_UNVERTRÄGLICHKEITEN_CODE = "60046";

	/**
	 * <div class="de">Code für Echokardiographie-Befund</div>
	 */
	public static final String ECHOKARDIOGRAPHIE_BEFUND_CODE = "60029";

	/**
	 * <div class="de">Code für Eintrittsbericht</div>
	 */
	public static final String EINTRITTSBERICHT_CODE = "60008";

	/**
	 * <div class="de">Code für elektronischer Impfausweis</div>
	 */
	public static final String ELEKTRONISCHER_IMPFAUSWEIS_CODE = "60043";

	/**
	 * <div class="de">Code für elektronisches Rezept</div> <div class="fr">Code
	 * de Ordonnance de médicaments</div>
	 */
	public static final String ELEKTRONISCHES_REZEPT_CODE = "60006";

	/**
	 * <div class="de">Code für Geburtsanzeige</div>
	 */
	public static final String GEBURTSANZEIGE_CODE = "60047";

	/**
	 * <div class="de">Code für Herzkatheter-Befund</div> <div class="fr">Code
	 * de Rapport de cathétérisme cardiaque</div>
	 */
	public static final String HERZKATHETER_BEFUND_CODE = "60028";

	/**
	 * <div class="de">Code für Histologie-Befund</div>
	 */
	public static final String HISTOLOGIE_BEFUND_CODE = "60027";

	/**
	 * <div class="de">Code für Kardiologie Verlaufs-Bericht</div>
	 */
	public static final String KARDIOLOGIE_VERLAUFS_BERICHT_CODE = "60037";

	/**
	 * <div class="de">Code für klinisches Verlaufsblatt</div>
	 */
	public static final String KLINISCHES_VERLAUFSBLATT_CODE = "60036";

	/**
	 * <div class="de">Code für Knochenmark-Biopsie-Befund</div>
	 */
	public static final String KNOCHENMARK_BIOPSIE_BEFUND_CODE = "60026";

	/**
	 * <div class="de">Code für Konsilauftrag (allgemein)</div> <div
	 * class="fr">Code de Demande de consultation</div>
	 */
	public static final String KONSILAUFTRAG_ALLGEMEIN_CODE = "60017";

	/**
	 * <div class="de">Code für Konsultationsbericht</div> <div class="fr">Code
	 * de Rapport de consultation</div>
	 */
	public static final String KONSULTATIONSBERICHT_CODE = "60021";

	/**
	 * <div class="de">Code für Kostengutsprache</div>
	 */
	public static final String KOSTENGUTSPRACHE_CODE = "60048";

	/**
	 * <div class="de">Code für Kurve Intensivstation</div>
	 */
	public static final String KURVE_INTENSIVSTATION_CODE = "60038";

	/**
	 * <div class="de">Code für Kurz-Austrittsbericht (pflegerisch)</div>
	 */
	public static final String KURZ_AUSTRITTSBERICHT_PFLEGERISCH_CODE = "60011";

	/**
	 * <div class="de">Code für Kurz-Austrittsbericht (ärztlich)</div> <div
	 * class="fr">Code de Avis de sortie</div>
	 */
	public static final String KURZ_AUSTRITTSBERICHT_ÄRZTLICH_CODE = "60009";

	/**
	 * <div class="de">Code für Laborauftrag</div>
	 */
	public static final String LABORAUFTRAG_CODE = "60018";

	/**
	 * <div class="de">Code für Labor-Befund</div> <div class="fr">Code de
	 * Résultat de laboratoire</div>
	 */
	public static final String LABOR_BEFUND_CODE = "60023";

	/**
	 * <div class="de">Code für Lungenfunktions-Befund</div>
	 */
	public static final String LUNGENFUNKTIONS_BEFUND_CODE = "60030";

	/**
	 * <div class="de">Code für Medikamentenliste (aktuell)</div> <div
	 * class="fr">Code de Liste des médicaments</div>
	 */
	public static final String MEDIKAMENTENLISTE_AKTUELL_CODE = "60005";

	/**
	 * <div class="de">Code für Meldung übertragbare Erkrankung</div>
	 */
	public static final String MELDUNG_ÜBERTRAGBARE_ERKRANKUNG_CODE = "60042";

	/**
	 * <div class="de">Code für Nicht spezifizierte Bilddaten</div>
	 */
	public static final String NICHT_SPEZIFIZIERTE_BILDDATEN_CODE = "60040";

	/**
	 * <div class="de">Code für Notfallbericht</div> <div class="fr">Code de
	 * Rapport de consultation aux urgences</div>
	 */
	public static final String NOTFALLBERICHT_CODE = "60035";

	/**
	 * <div class="de">Code für Notfall-Ausweis</div>
	 */
	public static final String NOTFALL_AUSWEIS_CODE = "60044";

	/**
	 * <div class="de">Code für OP-Bericht</div> <div class="fr">Code de
	 * Protocole opératoire</div>
	 */
	public static final String OP_BERICHT_CODE = "60033";

	/**
	 * <div class="de">Code für Pathologieauftrag</div>
	 */
	public static final String PATHOLOGIEAUFTRAG_CODE = "60019";

	/**
	 * <div class="de">Code für Pathologie-Befund</div> <div class="fr">Code de
	 * Rapport de pathologie</div>
	 */
	public static final String PATHOLOGIE_BEFUND_CODE = "60025";

	/**
	 * <div class="de">Code für Patienteneinwilligung </div> <div
	 * class="fr">Code de Consentement du patient</div>
	 */
	public static final String PATIENTENEINWILLIGUNG_CODE = "60002";

	/**
	 * <div class="de">Code für Patienteneinwilligung für die Verwendung der
	 * elektronischen Daten</div> <div class="fr">Code de Consentement du
	 * patient au dossier électronique</div>
	 */
	public static final String PATIENTENEINWILLIGUNG_FÜR_DIE_VERWENDUNG_DER_ELEKTRONISCHEN_DATEN_CODE = "60001";

	/**
	 * <div class="de">Code für Patientenverfügung</div>
	 */
	public static final String PATIENTENVERFÜGUNG_CODE = "60003";

	/**
	 * <div class="de">Code für Patient Summary (medizinische
	 * Zusammenfassung)</div> <div class="fr">Code de Résumé d'un patient</div>
	 */
	public static final String PATIENT_SUMMARY_MEDIZINISCHE_ZUSAMMENFASSUNG_CODE = "60004";

	/**
	 * <div class="de">Code für Pflegebericht</div>
	 */
	public static final String PFLEGEBERICHT_CODE = "60016";

	/**
	 * <div class="de">Code für Pflegeplan (allgemein)</div>
	 */
	public static final String PFLEGEPLAN_ALLGEMEIN_CODE = "60015";

	/**
	 * <div class="de">Code für Physiotherapiebericht</div>
	 */
	public static final String PHYSIOTHERAPIEBERICHT_CODE = "60031";

	/**
	 * <div class="de">Code für Radiologieauftrag</div>
	 */
	public static final String RADIOLOGIEAUFTRAG_CODE = "60020";

	/**
	 * <div class="de">Code für Radiologie-Befund</div> <div class="fr">Code de
	 * Rapport d'imagerie</div>
	 */
	public static final String RADIOLOGIE_BEFUND_CODE = "60024";

	/**
	 * <div class="de">Code für Radiologische Bilddaten</div>
	 */
	public static final String RADIOLOGISCHE_BILDDATEN_CODE = "60041";

	/**
	 * <div class="de">Code für Unbekannt</div> <div class="fr">Code de
	 * Inconnu</div> <div class="it">Code per Ignoto</div>
	 */
	public static final String UNBEKANNT_CODE = "60900";

	/**
	 * <div class="de">Code für Untersuchungsbefund (allgemein)</div> <div
	 * class="fr">Code de Rapport d'examen (non laboratoire)</div>
	 */
	public static final String UNTERSUCHUNGSBEFUND_ALLGEMEIN_CODE = "60022";

	/**
	 * <div class="de">Code für Verlaufs- / Austrittsbericht Gynäkologie und
	 * Geburtshilfe</div>
	 */
	public static final String VERLAUFS_AUSTRITTSBERICHT_GYNÄKOLOGIE_UND_GEBURTSHILFE_CODE = "60014";

	/**
	 * <div class="de">Code für Verlegungsbericht</div>
	 */
	public static final String VERLEGUNGSBERICHT_CODE = "60013";

	/**
	 * <div class="de">Code für Wundbefund</div>
	 */
	public static final String WUNDBEFUND_CODE = "60034";

	/**
	 * <div class="de">Code für Zuweisungsschreiben/Einweisungsschreiben</div>
	 * <div class="fr">Code de Demande d’admission</div>
	 */
	public static final String ZUWEISUNGSSCHREIBENEINWEISUNGSSCHREIBEN_CODE = "60007";

	/**
	 * <div class="en">Identifier of the Code System</div> <div
	 * class="de">Identifikator für das Code System</div>
	 */
	public static final String CODE_SYSTEM_OID = "2.16.756.5.30.1.127.3.10.1.27";

	/**
	 * <div class="en">Name of the Code System</div> <div class="de">Name des
	 * Codes Systems</div>
	 */
	public static final String CODE_SYSTEM_NAME = "epd_xds_typeCode";

	/**
	 * <div class="en">Machine interpretable and (inside this class) unique
	 * code</div> <div class="de">Maschinen interpretierbarer und (innerhalb
	 * dieser Klasse) eindeutiger Code</div>
	 */
	protected String code;

	/**
	 * <div class="en">Human readable name</div> <div
	 * class="de">Menschenlesbarer Name</div>
	 */
	protected String displayName;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instantiiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>
	 *
	 * @param code
	 * <br>
	 *            <div class="de"> code</div>
	 * @param displayName
	 * <br>
	 *            <div class="de"> display name</div>
	 */
	private TypeCode(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div> <div
	 * class="de">Liefert das ehealthconnector Code Objekt</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public Code getCode() {
		Code ehcCode = new Code(CODE_SYSTEM_OID, code, displayName);
		return ehcCode;
	}

	/**
	 * <div class="en">Gets the OHT CodedMetadataType Object</div> <div
	 * class="de">Liefert das OHT CodedMetadataType Objekt</div>
	 *
	 * @return <div class="en">the codedMetadataType</div>
	 */
	public CodedMetadataType getCodedMetadataType() {
		CodedMetadataType cmt = MetadataFactory.eINSTANCE.createCodedMetadataType();
		cmt.setSchemeName(CODE_SYSTEM_OID);
		cmt.setCode(this.getCodeValue());
		cmt.setDisplayName(XdsUtil.createInternationalString(this.getDisplayName(), "de-ch"));
		return cmt;
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
	 * <div class="en">Gets the actual Code as string</div> <div
	 * class="de">Liefert den eigentlichen Code als String</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public String getCodeValue() {
		return this.code;
	}

	/**
	 * <div class="en">Gets the display name.</div> <div class="de">Liefert
	 * display name.</div>
	 *
	 * @return <div class="en">the display name</div>
	 */
	public String getDisplayName() {
		return this.displayName;
	}

	/**
	 * <div class="en">Gets the Enum with a given code</div> <div
	 * class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 * <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static TypeCode getEnum(String code) {
		for (TypeCode x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets
	 * ist.</div>
	 *
	 *
	 * @param enumName
	 * <br>
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
	 * <br>
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public boolean isInValueSet(String codeValue) {
		for (TypeCode x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}

}