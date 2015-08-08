package org.ehealth_connector.communication.ch.enums;

import java.util.Arrays;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.XdsUtil;
import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;
import org.openhealthtools.ihe.xds.metadata.MetadataFactory;

/*
*<div class="de">Dieses Attribut soll den Inhalt eines Dokumentes einer medizinischen Fachrichtung zuordnen. Es ist denkbar, dass der Patient mit dieser In-formation eine Hilfestellung erhält zum Setzen oder Verändern der Vertraulichkeitsstufe von Dokumenten, welche relevant ist für die Zugriffs-steuerung. Passende internationale Codes werden in einem nächsten Schritt definiert und können später in den IT-Systemen entsprechend abgeglichen werden.</div>
*<div class="fr"></div>
*/
public enum PracticeSettingCode implements CodedMetadataEnumÎnterface {

	/** 
	*<div class="de">Allergologie</div>
	*<div class="fr">Allergologie</div>
	*<div class="it">Allergologia</div>
	*/
	ALLERGOLOGIE ("10001", "Allergologie"),
	/** 
	*<div class="de">Allgemeinmedizin </div>
	*<div class="fr">Médecine générale </div>
	*<div class="it">Medicina generale </div>
	*/
	ALLGEMEINMEDIZIN ("10002", "Allgemeinmedizin "),
	/** 
	*<div class="de">Anästhesiologie</div>
	*<div class="fr">Anesthésiologie</div>
	*<div class="it">Anestesiologia</div>
	*/
	ANÄSTHESIOLOGIE ("10003", "Anästhesiologie"),
	/** 
	*<div class="de">Angiologie</div>
	*<div class="fr">Angiologie</div>
	*<div class="it">Angiologia</div>
	*/
	ANGIOLOGIE ("10004", "Angiologie"),
	/** 
	*<div class="de">Pharmakologie</div>
	*<div class="fr">Pharmacologie</div>
	*<div class="it">Farmacologia</div>
	*/
	PHARMAKOLOGIE ("10005", "Pharmakologie"),
	/** 
	*<div class="de">Arbeitsmedizin</div>
	*<div class="fr">Médecine du travail</div>
	*<div class="it">Medicina del lavoro</div>
	*/
	ARBEITSMEDIZIN ("10006", "Arbeitsmedizin"),
	/** 
	*<div class="de">Chiropraktik</div>
	*<div class="fr">Chiropractie</div>
	*<div class="it">Chiropratica</div>
	*/
	CHIROPRAKTIK ("10007", "Chiropraktik"),
	/** 
	*<div class="de">Chirurgie</div>
	*<div class="fr">Chirurgie</div>
	*<div class="it">Chirurgia</div>
	*/
	CHIRURGIE ("10008", "Chirurgie"),
	/** 
	*<div class="de">Dermatologie und Venerologie</div>
	*<div class="fr">Dermatologie et vénéréologie</div>
	*<div class="it">Dermatologia e venereologia</div>
	*/
	DERMATOLOGIE_UND_VENEROLOGIE ("10009", "Dermatologie und Venerologie"),
	/** 
	*<div class="de">Endokrinologie/Diabetologie</div>
	*<div class="fr">Endocrinologie/diabétologie</div>
	*<div class="it">Endocrinologia/diabetologia</div>
	*/
	ENDOKRINOLOGIEDIABETOLOGIE ("10010", "Endokrinologie/Diabetologie"),
	/** 
	*<div class="de">Ergotherapie</div>
	*<div class="fr">Ergothérapie</div>
	*<div class="it">Ergoterapia</div>
	*/
	ERGOTHERAPIE ("10011", "Ergotherapie"),
	/** 
	*<div class="de">Ernährungsberatung</div>
	*<div class="fr">Conseil en nutrition</div>
	*<div class="it">Dietetica</div>
	*/
	ERNÄHRUNGSBERATUNG ("10012", "Ernährungsberatung"),
	/** 
	*<div class="de">Geriatrie</div>
	*<div class="fr">Gériatrie</div>
	*<div class="it">Geriatria</div>
	*/
	GERIATRIE ("10013", "Geriatrie"),
	/** 
	*<div class="de">Gastroenterologie</div>
	*<div class="fr">Gastroentérologie</div>
	*<div class="it">Gastroenterologia</div>
	*/
	GASTROENTEROLOGIE ("10014", "Gastroenterologie"),
	/** 
	*<div class="de">Gynäkologie und Geburtshilfe</div>
	*<div class="fr">Gynécologie et obstétrique</div>
	*<div class="it">Ginecologia e ostetricia</div>
	*/
	GYNÄKOLOGIE_UND_GEBURTSHILFE ("10015", "Gynäkologie und Geburtshilfe"),
	/** 
	*<div class="de">Herz- und Gefässchirurgie</div>
	*<div class="fr">Chirurgie cardiovasculaire</div>
	*<div class="it">Chirurgia cardiovascolare</div>
	*/
	HERZ__UND_GEFÄSSCHIRURGIE ("10016", "Herz- und Gefässchirurgie"),
	/** 
	*<div class="de">Infektiologie</div>
	*<div class="fr">Infectiologie</div>
	*<div class="it">Infettivologia</div>
	*/
	INFEKTIOLOGIE ("10017", "Infektiologie"),
	/** 
	*<div class="de">Innere Medizin</div>
	*<div class="fr">Médecine interne</div>
	*<div class="it">Medicina interna</div>
	*/
	INNERE_MEDIZIN ("10018", "Innere Medizin"),
	/** 
	*<div class="de">Intensivmedizin</div>
	*<div class="fr">Médecine intensive</div>
	*<div class="it">Medicina intensiva</div>
	*/
	INTENSIVMEDIZIN ("10019", "Intensivmedizin"),
	/** 
	*<div class="de">Kardiologie</div>
	*<div class="fr">Cardiologie</div>
	*<div class="it">Cardiologia</div>
	*/
	KARDIOLOGIE ("10020", "Kardiologie"),
	/** 
	*<div class="de">Komplementärmedizin</div>
	*<div class="fr">Médecine alternative et complémentaire</div>
	*<div class="it">Medicina complementare</div>
	*/
	KOMPLEMENTÄRMEDIZIN ("10021", "Komplementärmedizin"),
	/** 
	*<div class="de">Pädiatrie</div>
	*<div class="fr">Pédiatrie</div>
	*<div class="it">Pediatria</div>
	*/
	PÄDIATRIE ("10022", "Pädiatrie"),
	/** 
	*<div class="de">Psychologie</div>
	*<div class="fr">Psychologie</div>
	*<div class="it">Psicologia</div>
	*/
	PSYCHOLOGIE ("10023", "Psychologie"),
	/** 
	*<div class="de">Labormedizin</div>
	*<div class="fr">Diagnostic de laboratoire</div>
	*<div class="it">Medicina di laboratorio</div>
	*/
	LABORMEDIZIN ("10024", "Labormedizin"),
	/** 
	*<div class="de">Logopädie</div>
	*<div class="fr">Orthophonie</div>
	*<div class="it">Logopedia</div>
	*/
	LOGOPÄDIE ("10025", "Logopädie"),
	/** 
	*<div class="de">Medizinische Genetik</div>
	*<div class="fr">Génétique médicale</div>
	*<div class="it">Genetica medica</div>
	*/
	MEDIZINISCHE_GENETIK ("10026", "Medizinische Genetik"),
	/** 
	*<div class="de">Mund-, Kiefer- und Gesichtschirurgie</div>
	*<div class="fr">Chirurgie dento-maxillo-faciale</div>
	*<div class="it">Chirurgia maxillo-facciale</div>
	*/
	MUND__KIEFER__UND_GESICHTSCHIRURGIE ("10027", "Mund-, Kiefer- und Gesichtschirurgie"),
	/** 
	*<div class="de">Nephrologie</div>
	*<div class="fr">Néphrologie</div>
	*<div class="it">Nefrologia</div>
	*/
	NEPHROLOGIE ("10028", "Nephrologie"),
	/** 
	*<div class="de">Neurochirurgie</div>
	*<div class="fr">Neurochirurgie</div>
	*<div class="it">Neurochirurgia</div>
	*/
	NEUROCHIRURGIE ("10029", "Neurochirurgie"),
	/** 
	*<div class="de">Neurologie</div>
	*<div class="fr">Neurologie</div>
	*<div class="it">Neurologia</div>
	*/
	NEUROLOGIE ("10030", "Neurologie"),
	/** 
	*<div class="de">Nuklearmedizin</div>
	*<div class="fr">Médecine nucléaire</div>
	*<div class="it">Medicina nucleare</div>
	*/
	NUKLEARMEDIZIN ("10031", "Nuklearmedizin"),
	/** 
	*<div class="de">Ophthalmologie</div>
	*<div class="fr">Ophtalmologie</div>
	*<div class="it">Oftalmologia</div>
	*/
	OPHTHALMOLOGIE ("10032", "Ophthalmologie"),
	/** 
	*<div class="de">Orthopädie und Traumatologie</div>
	*<div class="fr">Chirurgie orthopédique et traumatologie de l'appareil locomoteur</div>
	*<div class="it">Chirurgia ortopedica e traumatologia dell'apparato locomotore</div>
	*/
	ORTHOPÄDIE_UND_TRAUMATOLOGIE ("10033", "Orthopädie und Traumatologie"),
	/** 
	*<div class="de">Osteopathie</div>
	*<div class="fr">Ostéopathie</div>
	*<div class="it">Osteopatia</div>
	*/
	OSTEOPATHIE ("10034", "Osteopathie"),
	/** 
	*<div class="de">Oto-Rhino-Laryngologie</div>
	*<div class="fr">Oto-Rhino-Laryngologie</div>
	*<div class="it">Otorinolaringoiatria</div>
	*/
	OTO_RHINO_LARYNGOLOGIE ("10035", "Oto-Rhino-Laryngologie"),
	/** 
	*<div class="de">Palliativmedizin</div>
	*<div class="fr">Médecine palliative</div>
	*<div class="it">Medicina palliativa</div>
	*/
	PALLIATIVMEDIZIN ("10036", "Palliativmedizin"),
	/** 
	*<div class="de">Pathologie </div>
	*<div class="fr">Pathologie</div>
	*<div class="it">Patologia </div>
	*/
	PATHOLOGIE ("10037", "Pathologie "),
	/** 
	*<div class="de">Pflege</div>
	*<div class="fr">Soins</div>
	*<div class="it">Cure</div>
	*/
	PFLEGE ("10038", "Pflege"),
	/** 
	*<div class="de">Physikalische Medizin </div>
	*<div class="fr">Kinésithérapie </div>
	*<div class="it">Medicina fisica </div>
	*/
	PHYSIKALISCHE_MEDIZIN ("10039", "Physikalische Medizin "),
	/** 
	*<div class="de">Physiotherapie</div>
	*<div class="fr">Physiothérapie</div>
	*<div class="it">Fisioterapia</div>
	*/
	PHYSIOTHERAPIE ("10040", "Physiotherapie"),
	/** 
	*<div class="de">Plastische, Rekonstruktive und Ästhetische Chirurgie</div>
	*<div class="fr">Chirurgie plastique, reconstructrice et esthétique</div>
	*<div class="it">Chirurgia plastica, ricostruttiva ed estetica</div>
	*/
	PLASTISCHE_REKONSTRUKTIVE_UND_ÄSTHETISCHE_CHIRURGIE ("10041", "Plastische, Rekonstruktive und Ästhetische Chirurgie"),
	/** 
	*<div class="de">Pneumologie</div>
	*<div class="fr">Pneumologie</div>
	*<div class="it">Pneumologia</div>
	*/
	PNEUMOLOGIE ("10042", "Pneumologie"),
	/** 
	*<div class="de">Podologie</div>
	*<div class="fr">Podologie</div>
	*<div class="it">Podologia</div>
	*/
	PODOLOGIE ("10043", "Podologie"),
	/** 
	*<div class="de">Prävention </div>
	*<div class="fr">Prévention </div>
	*<div class="it">Prevenzione </div>
	*/
	PRÄVENTION ("10044", "Prävention "),
	/** 
	*<div class="de">Psychiatrie und Psychotherapie</div>
	*<div class="fr">Psychiatrie et psychothérapie</div>
	*<div class="it">Psichiatria e psicoterapia</div>
	*/
	PSYCHIATRIE_UND_PSYCHOTHERAPIE ("10045", "Psychiatrie und Psychotherapie"),
	/** 
	*<div class="de">Psychosomatik</div>
	*<div class="fr">Psychosomatique</div>
	*<div class="it">Psicosomatica</div>
	*/
	PSYCHOSOMATIK ("10046", "Psychosomatik"),
	/** 
	*<div class="de">Radiologie</div>
	*<div class="fr">Radiologie</div>
	*<div class="it">Radiologia</div>
	*/
	RADIOLOGIE ("10047", "Radiologie"),
	/** 
	*<div class="de">Radio-Onkologie/Strahlentherapie</div>
	*<div class="fr">Radio-oncologie / radiothérapie</div>
	*<div class="it">Radio-oncologia / radioterapia</div>
	*/
	RADIO_ONKOLOGIESTRAHLENTHERAPIE ("10048", "Radio-Onkologie/Strahlentherapie"),
	/** 
	*<div class="de">Rechtsmedizin</div>
	*<div class="fr">Médecine légale</div>
	*<div class="it">Medicina legale</div>
	*/
	RECHTSMEDIZIN ("10049", "Rechtsmedizin"),
	/** 
	*<div class="de">Rehabilitation</div>
	*<div class="fr">Réhabilitation</div>
	*<div class="it">Riabilitazione</div>
	*/
	REHABILITATION ("10050", "Rehabilitation"),
	/** 
	*<div class="de">Notfall und Rettungsmedizin</div>
	*<div class="fr">Médecine d'urgence</div>
	*<div class="it">Medicina d'urgenza e di salvataggio</div>
	*/
	NOTFALL_UND_RETTUNGSMEDIZIN ("10051", "Notfall und Rettungsmedizin"),
	/** 
	*<div class="de">Rheumatologie</div>
	*<div class="fr">Rhumatologie</div>
	*<div class="it">Reumatologia</div>
	*/
	RHEUMATOLOGIE ("10052", "Rheumatologie"),
	/** 
	*<div class="de">Thoraxchirurgie</div>
	*<div class="fr">Chirurgie thoracique</div>
	*<div class="it">Chirurgia toracica</div>
	*/
	THORAXCHIRURGIE ("10053", "Thoraxchirurgie"),
	/** 
	*<div class="de">Transfusionsmedizin</div>
	*<div class="fr">Médecine transfusionnelle</div>
	*<div class="it">Medicina trasfusionale</div>
	*/
	TRANSFUSIONSMEDIZIN ("10054", "Transfusionsmedizin"),
	/** 
	*<div class="de">Tropen- und Reisemedizin</div>
	*<div class="fr">Médecine tropicale et des voyages</div>
	*<div class="it">Medicina tropicale e di viaggio</div>
	*/
	TROPEN__UND_REISEMEDIZIN ("10055", "Tropen- und Reisemedizin"),
	/** 
	*<div class="de">Urologie</div>
	*<div class="fr">Urologie</div>
	*<div class="it">Urologia</div>
	*/
	UROLOGIE ("10056", "Urologie"),
	/** 
	*<div class="de">Zahnheilkunde</div>
	*<div class="fr">Odontologie</div>
	*<div class="it">Odontoiatria</div>
	*/
	ZAHNHEILKUNDE ("10057", "Zahnheilkunde"),
	/** 
	*<div class="de">Hämatologie</div>
	*<div class="fr">Hématologie</div>
	*<div class="it">Ematologia</div>
	*/
	HÄMATOLOGIE ("10058", "Hämatologie"),
	/** 
	*<div class="de">Immunologie</div>
	*<div class="fr">Immunologie</div>
	*<div class="it">Immunologia</div>
	*/
	IMMUNOLOGIE ("10059", "Immunologie"),
	/** 
	*<div class="de">Unbekannt</div>
	*<div class="fr">Inconnu</div>
	*<div class="it">Ignoto</div>
	*/
	UNBEKANNT ("10900", "Unbekannt"),
	/** 
	*<div class="de">Andere nicht näher spezifizierte medzinische Fachrichtung</div>
	*<div class="fr">Autres sans spécification</div>
	*<div class="it">Altri rami specialistici della medicina non meglio precisati</div>
	*/
	ANDERE_NICHT_NÄHER_SPEZIFIZIERTE_MEDZINISCHE_FACHRICHTUNG ("10999", "Andere nicht näher spezifizierte medzinische Fachrichtung");
	public static final String ALLERGOLOGIE_CODE="10001";
	public static final String ALLGEMEINMEDIZIN_CODE="10002";
	public static final String ANÄSTHESIOLOGIE_CODE="10003";
	public static final String ANGIOLOGIE_CODE="10004";
	public static final String PHARMAKOLOGIE_CODE="10005";
	public static final String ARBEITSMEDIZIN_CODE="10006";
	public static final String CHIROPRAKTIK_CODE="10007";
	public static final String CHIRURGIE_CODE="10008";
	public static final String DERMATOLOGIE_UND_VENEROLOGIE_CODE="10009";
	public static final String ENDOKRINOLOGIEDIABETOLOGIE_CODE="10010";
	public static final String ERGOTHERAPIE_CODE="10011";
	public static final String ERNÄHRUNGSBERATUNG_CODE="10012";
	public static final String GERIATRIE_CODE="10013";
	public static final String GASTROENTEROLOGIE_CODE="10014";
	public static final String GYNÄKOLOGIE_UND_GEBURTSHILFE_CODE="10015";
	public static final String HERZ__UND_GEFÄSSCHIRURGIE_CODE="10016";
	public static final String INFEKTIOLOGIE_CODE="10017";
	public static final String INNERE_MEDIZIN_CODE="10018";
	public static final String INTENSIVMEDIZIN_CODE="10019";
	public static final String KARDIOLOGIE_CODE="10020";
	public static final String KOMPLEMENTÄRMEDIZIN_CODE="10021";
	public static final String PÄDIATRIE_CODE="10022";
	public static final String PSYCHOLOGIE_CODE="10023";
	public static final String LABORMEDIZIN_CODE="10024";
	public static final String LOGOPÄDIE_CODE="10025";
	public static final String MEDIZINISCHE_GENETIK_CODE="10026";
	public static final String MUND__KIEFER__UND_GESICHTSCHIRURGIE_CODE="10027";
	public static final String NEPHROLOGIE_CODE="10028";
	public static final String NEUROCHIRURGIE_CODE="10029";
	public static final String NEUROLOGIE_CODE="10030";
	public static final String NUKLEARMEDIZIN_CODE="10031";
	public static final String OPHTHALMOLOGIE_CODE="10032";
	public static final String ORTHOPÄDIE_UND_TRAUMATOLOGIE_CODE="10033";
	public static final String OSTEOPATHIE_CODE="10034";
	public static final String OTO_RHINO_LARYNGOLOGIE_CODE="10035";
	public static final String PALLIATIVMEDIZIN_CODE="10036";
	public static final String PATHOLOGIE_CODE="10037";
	public static final String PFLEGE_CODE="10038";
	public static final String PHYSIKALISCHE_MEDIZIN_CODE="10039";
	public static final String PHYSIOTHERAPIE_CODE="10040";
	public static final String PLASTISCHE_REKONSTRUKTIVE_UND_ÄSTHETISCHE_CHIRURGIE_CODE="10041";
	public static final String PNEUMOLOGIE_CODE="10042";
	public static final String PODOLOGIE_CODE="10043";
	public static final String PRÄVENTION_CODE="10044";
	public static final String PSYCHIATRIE_UND_PSYCHOTHERAPIE_CODE="10045";
	public static final String PSYCHOSOMATIK_CODE="10046";
	public static final String RADIOLOGIE_CODE="10047";
	public static final String RADIO_ONKOLOGIESTRAHLENTHERAPIE_CODE="10048";
	public static final String RECHTSMEDIZIN_CODE="10049";
	public static final String REHABILITATION_CODE="10050";
	public static final String NOTFALL_UND_RETTUNGSMEDIZIN_CODE="10051";
	public static final String RHEUMATOLOGIE_CODE="10052";
	public static final String THORAXCHIRURGIE_CODE="10053";
	public static final String TRANSFUSIONSMEDIZIN_CODE="10054";
	public static final String TROPEN__UND_REISEMEDIZIN_CODE="10055";
	public static final String UROLOGIE_CODE="10056";
	public static final String ZAHNHEILKUNDE_CODE="10057";
	public static final String HÄMATOLOGIE_CODE="10058";
	public static final String IMMUNOLOGIE_CODE="10059";
	public static final String UNBEKANNT_CODE="10900";
	public static final String ANDERE_NICHT_NÄHER_SPEZIFIZIERTE_MEDZINISCHE_FACHRICHTUNG_CODE="10999";


	public static final String CODE_SYSTEM_OID="2.16.756.5.30.1.127.3.10.1.18";
	public static final String CODE_SYSTEM_NAME="epd_xds_practiceSettingCode";


	protected String code;
	protected String displayName;

	
	/**
	* <div class="en">Instantiates this Enum Object with a given Code and Display Name</div>
	* <div class="de">Instantiiert dieses Enum Object mittels eines Codes und einem Display Name</div>
	*
	*@param code <br>
	*	<div class="de"> code</div>
	* @param displayName <br>
	*	<div class="de"> display name</div>
	*/
	private PracticeSettingCode (String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

 
	/**
	* <div class="en">Gets the actual Code as string</div>
	* <div class="de">Liefert den eigentlichen Code als String</div>
	*
	* @return <div class="en">the code</div>
	*/
	public String getCodeValue() {
		return this.code;
	}


	/**
	* <div class="en">Gets the display name.</div>
	* <div class="de">Liefert display name.</div>
	*
	* @return <div class="en">the display name</div>
	*/
	public String getdisplayName() {
		return this.displayName;
	}


	/**
	* <div class="en">Gets the ehealthconnector Code Object</div>
	* <div class="de">Liefert das ehealthconnector Code Objekt</div>
	*
	* @return <div class="en">the code</div>
	*/
	public Code getCode() {
		Code ehcCode = new Code(CODE_SYSTEM_OID, code, displayName);
		return ehcCode;
	}

	public CodedMetadataType getCodedMetadataType() {
		CodedMetadataType cmt = MetadataFactory.eINSTANCE.createCodedMetadataType();
		cmt.setSchemeUUID(CODE_SYSTEM_OID);
		cmt.setSchemeName(CODE_SYSTEM_NAME);
		cmt.setCode(this.getCodeValue());
		cmt.setDisplayName(XdsUtil.createInternationalString(this.getdisplayName()));
		return cmt;
	}

 
	/**
	* <div class="en">Gets the Enum with a given code</div>
	* <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	*
	* @param code <br>
	*      <div class="de"> code</div>
	* @return <div class="en">the enum</div>
	*/
	public static PracticeSettingCode getEnum(String code) {
		for (PracticeSettingCode x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

  
	/**
	* <div class="en">Checks if a given enum is part of this value set.</div>
	* <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets ist.</div>
	*
	*
	* @param enumName <br>
	*      <div class="de"> enumName</div>
	* @return true, if enum is in this value set
	*/
	public boolean isEnumOfValueSet(String enumName) {
		return Arrays.asList(values()).contains(enumName);
	}


	/**
	* <div class="en">Checks if a given code value is in this value set.</div>
	* <div class="de">Prüft, ob der gegebene code in diesem Value Sets vorhanden ist.</div>
	*
	* @param codeValue <br>
	*      <div class="de"> code</div>
	* @return true, if is in value set
	*/
	public boolean isInValueSet(String codeValue) {
		for (PracticeSettingCode x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}


	/**
	* <div class="en">Gets the code system id.</div>
	* <div class="de">Liefert die code system id.</div>
	*
	* @return <div class="en">the code system id</div>
	*/
	public String getCodeSystemOid() {
		return CODE_SYSTEM_OID;
	}

	/**
	* <div class="en">Gets the code system name.</div>
	* <div class="de">Liefert code system name.</div>
	*
	* @return <div class="en">the code system name</div>
	*/
	public String getCodeSystemName() {
		return CODE_SYSTEM_NAME;
	}

}