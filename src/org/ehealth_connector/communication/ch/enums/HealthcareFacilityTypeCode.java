package org.ehealth_connector.communication.ch.enums;

import java.util.Arrays;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.util.XdsUtil;
import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;
import org.openhealthtools.ihe.xds.metadata.MetadataFactory;

/*
 *<div class="de">Dieser Code beschreibt den Typ der Gesundheitseinrichtung, in der das Dokument während des Behandlungsprozesses erstellt wurde. Der Patient kann im Zusammenhang mit der Berechtigungsteuerung diese Information nutzen, um beispielsweise in seinen Rechteattributen allen Dokumenten aus einem bestimmten Gesundheitseinrichtungstyp eine bestimmte Vertraulichkeitsstufe zuzuordnen. Passende interna-tionale Codes werden in einem nächsten Schritt definiert und können später in den IT-Systemen entsprechend abgeglichen werden.</div>
 *<div class="fr"></div>
 */
public enum HealthcareFacilityTypeCode implements CodedMetadataEnumInterface {

	/**
	 * <div class="de">Ambulante Einrichtung, inkl. Ambulatorium</div> <div
	 * class="fr">Cabinet médical</div> <div class="it">Studio medico</div>
	 */
	AMBULANTE_EINRICHTUNG_INKL_AMBULATORIUM("20010", "Ambulante Einrichtung, inkl. Ambulatorium"),
	/**
	 * <div class="de">Andere Gesundheits-Organisation</div> <div
	 * class="fr">Autres prestateurs de soins</div> <div class="it">Altre
	 * organizzazioni sanitarie</div>
	 */
	ANDERE_GESUNDHEITS_ORGANISATION("20999", "Andere Gesundheits-Organisation"),
	/**
	 * <div class="de">Apotheke</div> <div class="fr">Pharmacie</div> <div
	 * class="it">Farmacia</div>
	 */
	APOTHEKE("20009", "Apotheke"),
	/**
	 * <div class="de">Armeeärztliche Dienste</div> <div class="fr">Service
	 * sanitaire </div> <div class="it">Servizio di medicina militare</div>
	 */
	ARMEEÄRZTLICHE_DIENSTE("20006", "Armeeärztliche Dienste"),
	/**
	 * <div class="de">Gesundheitsbehörde</div> <div class="fr">Autorité de
	 * santé</div> <div class="it">Autorità sanitaria</div>
	 */
	GESUNDHEITSBEHÖRDE("20003", "Gesundheitsbehörde"),
	/**
	 * <div class="de">Gesundheitseinrichtung in der Haftanstalt</div> <div
	 * class="fr">Service santé dans la prison</div> <div class="it">Struttura
	 * sanitaria in seno a uno stabilimento carcerario</div>
	 */
	GESUNDHEITSEINRICHTUNG_IN_DER_HAFTANSTALT("20007", "Gesundheitseinrichtung in der Haftanstalt"),
	/**
	 * <div class="de">Institut für medizinische Diagnostik</div> <div
	 * class="fr">Institut d’aide au diagnostic</div> <div class="it">Istituto
	 * di diagnosi medica</div>
	 */
	INSTITUT_FÜR_MEDIZINISCHE_DIAGNOSTIK("20001", "Institut für medizinische Diagnostik"),
	/**
	 * <div class="de">Notfall- / Rettungsdienste</div> <div class="fr">Service
	 * d'urgence et de sauvetage</div> <div class="it">Servizio di pronto
	 * soccorso e di salvataggio</div>
	 */
	NOTFALL_RETTUNGSDIENSTE("20002", "Notfall- / Rettungsdienste"),
	/**
	 * <div class="de">Organisation für Pflege zu Hause</div> <div
	 * class="fr">Soins à domicile</div> <div class="it">Servizio di cura e
	 * assistenza a domicilio</div>
	 */
	ORGANISATION_FÜR_PFLEGE_ZU_HAUSE("20004", "Organisation für Pflege zu Hause"),
	/**
	 * <div class="de">Organisation für stationäre Rehabilitation</div> <div
	 * class="fr">Organisation de réhabilitation stationnaire</div> <div
	 * class="it">Istituto di riabilitazione stazionaria</div>
	 */
	ORGANISATION_FÜR_STATIONÄRE_REHABILITATION("20011",
			"Organisation für stationäre Rehabilitation"),
	/**
	 * <div class="de">Sozio-Medizinische Institution</div> <div
	 * class="fr">Etablissement médico-social</div> <div
	 * class="it">Istituto/casa di cura</div>
	 */
	SOZIO_MEDIZINISCHE_INSTITUTION("20008", "Sozio-Medizinische Institution"),
	/**
	 * <div class="de">stationäre Einrichtung / Spital</div> <div
	 * class="fr">Hôpital</div> <div class="it">Ospedale</div>
	 */
	STATIONÄRE_EINRICHTUNG_SPITAL("20005", "stationäre Einrichtung / Spital"),
	/**
	 * <div class="de">Unbekannt</div> <div class="fr">Inconnu</div> <div
	 * class="it">Ignoto</div>
	 */
	UNBEKANNT("20900", "Unbekannt"),
	/**
	 * <div class="de">zu Hause</div> <div class="fr"> </div> <div class="it">
	 * </div>
	 */
	ZU_HAUSE("20012", "zu Hause");

	/**
	 * <div class="de">Code für Ambulante Einrichtung, inkl. Ambulatorium</div>
	 * <div class="fr">Code de Cabinet médical</div> <div class="it">Code per
	 * Studio medico</div>
	 */
	public static final String AMBULANTE_EINRICHTUNG_INKL_AMBULATORIUM_CODE = "20010";

	/**
	 * <div class="de">Code für Andere Gesundheits-Organisation</div> <div
	 * class="fr">Code de Autres prestateurs de soins</div> <div class="it">Code
	 * per Altre organizzazioni sanitarie</div>
	 */
	public static final String ANDERE_GESUNDHEITS_ORGANISATION_CODE = "20999";

	/**
	 * <div class="de">Code für Apotheke</div> <div class="fr">Code de
	 * Pharmacie</div> <div class="it">Code per Farmacia</div>
	 */
	public static final String APOTHEKE_CODE = "20009";

	/**
	 * <div class="de">Code für Armeeärztliche Dienste</div> <div
	 * class="fr">Code de Service sanitaire </div> <div class="it">Code per
	 * Servizio di medicina militare</div>
	 */
	public static final String ARMEEÄRZTLICHE_DIENSTE_CODE = "20006";

	/**
	 * <div class="de">Code für Gesundheitsbehörde</div> <div class="fr">Code de
	 * Autorité de santé</div> <div class="it">Code per Autorità sanitaria</div>
	 */
	public static final String GESUNDHEITSBEHÖRDE_CODE = "20003";

	/**
	 * <div class="de">Code für Gesundheitseinrichtung in der Haftanstalt</div>
	 * <div class="fr">Code de Service santé dans la prison</div> <div
	 * class="it">Code per Struttura sanitaria in seno a uno stabilimento
	 * carcerario</div>
	 */
	public static final String GESUNDHEITSEINRICHTUNG_IN_DER_HAFTANSTALT_CODE = "20007";

	/**
	 * <div class="de">Code für Institut für medizinische Diagnostik</div> <div
	 * class="fr">Code de Institut d’aide au diagnostic</div> <div
	 * class="it">Code per Istituto di diagnosi medica</div>
	 */
	public static final String INSTITUT_FÜR_MEDIZINISCHE_DIAGNOSTIK_CODE = "20001";

	/**
	 * <div class="de">Code für Notfall- / Rettungsdienste</div> <div
	 * class="fr">Code de Service d'urgence et de sauvetage</div> <div
	 * class="it">Code per Servizio di pronto soccorso e di salvataggio</div>
	 */
	public static final String NOTFALL_RETTUNGSDIENSTE_CODE = "20002";

	/**
	 * <div class="de">Code für Organisation für Pflege zu Hause</div> <div
	 * class="fr">Code de Soins à domicile</div> <div class="it">Code per
	 * Servizio di cura e assistenza a domicilio</div>
	 */
	public static final String ORGANISATION_FÜR_PFLEGE_ZU_HAUSE_CODE = "20004";

	/**
	 * <div class="de">Code für Organisation für stationäre Rehabilitation</div>
	 * <div class="fr">Code de Organisation de réhabilitation stationnaire</div>
	 * <div class="it">Code per Istituto di riabilitazione stazionaria</div>
	 */
	public static final String ORGANISATION_FÜR_STATIONÄRE_REHABILITATION_CODE = "20011";

	/**
	 * <div class="de">Code für Sozio-Medizinische Institution</div> <div
	 * class="fr">Code de Etablissement médico-social</div> <div class="it">Code
	 * per Istituto/casa di cura</div>
	 */
	public static final String SOZIO_MEDIZINISCHE_INSTITUTION_CODE = "20008";

	/**
	 * <div class="de">Code für stationäre Einrichtung / Spital</div> <div
	 * class="fr">Code de Hôpital</div> <div class="it">Code per Ospedale</div>
	 */
	public static final String STATIONÄRE_EINRICHTUNG_SPITAL_CODE = "20005";

	/**
	 * <div class="de">Code für Unbekannt</div> <div class="fr">Code de
	 * Inconnu</div> <div class="it">Code per Ignoto</div>
	 */
	public static final String UNBEKANNT_CODE = "20900";

	/**
	 * <div class="de">Code für zu Hause</div> <div class="fr">Code de </div>
	 * <div class="it">Code per </div>
	 */
	public static final String ZU_HAUSE_CODE = "20012";

	/**
	 * <div class="en">Identifier of the Code System</div> <div
	 * class="de">Identifikator für das Code System</div>
	 */
	public static final String CODE_SYSTEM_OID = "2.16.756.5.30.1.127.3.10.1.11";

	/**
	 * <div class="en">Name of the Code System</div> <div class="de">Name des
	 * Codes Systems</div>
	 */
	public static final String CODE_SYSTEM_NAME = "epd_xds_healthcareFacilityTypeCode";

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
	private HealthcareFacilityTypeCode(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
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
	public static HealthcareFacilityTypeCode getEnum(String code) {
		for (HealthcareFacilityTypeCode x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
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
	@Override
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
		for (HealthcareFacilityTypeCode x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}

}