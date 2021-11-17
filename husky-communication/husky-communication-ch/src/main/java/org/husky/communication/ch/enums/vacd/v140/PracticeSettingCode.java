/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
package org.husky.communication.ch.enums.vacd.v140;

import org.husky.common.enums.LanguageCode;
import org.husky.common.enums.ValueSetEnumInterface;
import org.husky.common.model.Code;
import org.husky.common.utils.XdsMetadataUtil;

/**
 * <div class="de">Dieses Attribut soll den Inhalt eines Dokumentes einer
 * medizinischen Fachrichtung zuordnen. Es ist denkbar, dass der Patient mit
 * dieser In-formation eine Hilfestellung erhält zum Setzen oder Verändern der
 * Vertraulichkeitsstufe von Dokumenten, welche relevant ist für die
 * Zugriffs-steuerung. Passende internationale Codes werden in einem nächsten
 * Schritt definiert und können später in den IT-Systemen entsprechend
 * abgeglichen werden.</div> <div class="fr"></div>
 */
public enum PracticeSettingCode implements ValueSetEnumInterface {

	/**
	 * <div class="de">Allergologie</div> <div class="fr">Allergologie</div>
	 * <div class="it">Allergologia</div>
	 */
	ALLERGOLOGIE("10001", "Allergologie"),
	/**
	 * <div class="de">Allgemeinmedizin </div> <div class="fr">Médecine
	 * générale </div> <div class="it">Medicina generale </div>
	 */
	ALLGEMEINMEDIZIN("10002", "Allgemeinmedizin"),
	/**
	 * <div class="de">Andere nicht näher spezifizierte medzinische
	 * Fachrichtung</div> <div class="fr">Autres sans spécification</div>
	 * <div class="it">Altri rami specialistici della medicina non meglio
	 * precisati</div>
	 */
	ANDERE_NICHT_NAHER_SPEZIFIZIERTE_MEDZINISCHE_FACHRICHTUNG("10999",
			"Andere nicht näher spezifizierte medzinische Fachrichtung"),
	/**
	 * <div class = "de"> Angiologie </div> <div class = "fr"> Angiologie </div>
	 * <div class = "it"> Angiologia </div>
	 */
	ANGIOLOGIE("10004", "Angiologie"),
	/**
	 * <div class="de">Anästhesiologie</div>
	 * <div class="fr">Anesthésiologie</div>
	 * <div class="it">Anestesiologia</div>
	 */
	ANASTHESIOLOGIE("10003", "Anästhesiologie"),
	/**
	 * <div class="de">Arbeitsmedizin</div> <div class="fr">Médecine du
	 * travail</div> <div class="it">Medicina del lavoro</div>
	 */
	ARBEITSMEDIZIN("10006", "Arbeitsmedizin"),
	/**
	 * <div class="de">Chiropraktik</div> <div class="fr">Chiropractie</div>
	 * <div class="it">Chiropratica</div>
	 */
	CHIROPRAKTIK("10007", "Chiropraktik"),
	/**
	 * <div class="de">Chirurgie</div> <div class="fr">Chirurgie</div>
	 * <div class="it">Chirurgia</div>
	 */
	CHIRURGIE("10008", "Chirurgie"),
	/**
	 * <div class="de">Dermatologie und Venerologie</div>
	 * <div class="fr">Dermatologie et vénéréologie</div>
	 * <div class="it">Dermatologia e venereologia</div>
	 */
	DERMATOLOGIE_UND_VENEROLOGIE("10009", "Dermatologie und Venerologie"),
	/**
	 * <div class="de"> Endokrinologie/Diabetologie </div> <div class="fr">
	 * Endocrinologie/diabétologie </div> <div class="it">
	 * Endocrinologia/diabetologia </div>
	 */
	ENDOKRINOLOGIEDIABETOLOGIE("10010", "Endokrinologie/Diabetologie"),
	/**
	 * <div class="de">Ergotherapie </div> <div class="fr">Ergothérapie </div>
	 * <div class="it">Ergoterapia</div>
	 */
	ERGOTHERAPIE("10011", "Ergotherapie"),
	/**
	 * <div class="de">Ernährungsberatung</div> <div class="fr">Conseil en
	 * nutrition</div> <div class="it">Dietetica</div>
	 */
	ERNAHRUNGSBERATUNG("10012", "Ernährungsberatung"),
	/**
	 * <div class="de">Gastroenterologie</div>
	 * <div class="fr">Gastroentérologie</div>
	 * <div class="it">Gastroenterologia</div>
	 */
	GASTROENTEROLOGIE("10014", "Gastroenterologie"),
	/**
	 * <div class="de">Geriatrie</div> <div class="fr">Gériatrie</div>
	 * <div class="it">Geriatria</div>
	 */
	GERIATRIE("10013", "Geriatrie"),
	/**
	 * <div class="de">Gynäkologie und Geburtshilfe</div>
	 * <div class="fr">Gynécologie et obstétrique</div>
	 * <div class="it">Ginecologia e ostetricia</div>
	 */
	GYNAKOLOGIE_UND_GEBURTSHILFE("10015", "Gynäkologie und Geburtshilfe"),
	/**
	 * <div class="de">Herz- und Gefässchirurgie</div> <div class="fr">Chirurgie
	 * cardiovasculaire</div> <div class="it">Chirurgia cardiovascolare</div>
	 */
	HERZ_UND_GEFASSCHIRURGIE("10016", "Herz- und Gefässchirurgie"),
	/**
	 * <div class="de">Hämatologie</div> <div class="fr">Hématologie</div>
	 * <div class="it">Ematologia</div>
	 */
	HAMATOLOGIE("10058", "Hämatologie"),
	/**
	 * <div class="de">Immunologie</div> <div class="fr">Immunologie</div>
	 * <div class="it">Immunologia</div>
	 */
	IMMUNOLOGIE("10059", "Immunologie"),
	/**
	 * <div class="de">Infektiologie</div> <div class="fr">Infectiologie</div>
	 * <div class="it">Infettivologia</div>
	 */
	INFEKTIOLOGIE("10017", "Infektiologie"),
	/**
	 * <div class="de">Innere Medizin</div> <div class="fr">Médecine
	 * interne</div> <div class="it">Medicina interna</div>
	 */
	INNERE_MEDIZIN("10018", "Innere Medizin"),
	/**
	 * <div class="de">Intensivmedizin</div> <div class="fr">Médecine
	 * intensive</div> <div class="it">Medicina intensiva</div>
	 */
	INTENSIVMEDIZIN("10019", "Intensivmedizin"),
	/**
	 * <div class="de">Kardiologie</div> <div class="fr">Cardiologie</div>
	 * <div class="it">Cardiologia</div>
	 */
	KARDIOLOGIE("10020", "Kardiologie"),
	/**
	 * <div class="de">Komplementärmedizin</div> <div class="fr">Médecine
	 * alternative et complémentaire</div> <div class="it">Medicina
	 * complementare</div>
	 */
	KOMPLEMENTARMEDIZIN("10021", "Komplementärmedizin"),
	/**
	 * <div class="de">Labormedizin</div> <div class="fr">Diagnostic de
	 * laboratoire</div> <div class="it">Medicina di laboratorio</div>
	 */
	LABORMEDIZIN("10024", "Labormedizin"),
	/**
	 * <div class="de">Logopädie</div> <div class="fr">Orthophonie</div>
	 * <div class="it">Logopedia</div>
	 */
	LOGOPADIE("10025", "Logopädie"),
	/**
	 * <div class="de">Medizinische Genetik</div> <div class="fr">Génétique
	 * médicale</div> <div class="it">Genetica medica</div>
	 */
	MEDIZINISCHE_GENETIK("10026", "Medizinische Genetik"),
	/**
	 * <div class="de">Mund-, Kiefer- und Gesichtschirurgie</div>
	 * <div class="fr">Chirurgie dento-maxillo-faciale</div>
	 * <div class="it">Chirurgia maxillo-facciale</div>
	 */
	MUND_KIEFER_UND_GESICHTSCHIRURGIE("10027", "Mund-, Kiefer- und Gesichtschirurgie"),
	/**
	 * <div class="de"> Nephrologie</div> <div class="fr"> Néphrologie</div>
	 * <div class="it"> Nefrologia</div>
	 */
	NEPHROLOGIE("10028", "Nephrologie"),
	/**
	 * <div class="de">Neurochirurgie</div> <div class="fr">Neurochirurgie</div>
	 * <div class="it">Neurochirurgia</div>
	 */
	NEUROCHIRURGIE("10029", "Neurochirurgie"),
	/**
	 * <div class="de">Neurologie</div> <div class="fr">Neurologie</div>
	 * <div class="it">Neurologia</div>
	 */
	NEUROLOGIE("10030", "Neurologie"),
	/**
	 * <div class="de">Notfall und Rettungsmedizin</div>
	 * <div class="fr">Médecine d'urgence</div> <div class="it">Medicina
	 * d'urgenza e di salvataggio</div>
	 */
	NOTFALL_UND_RETTUNGSMEDIZIN("10051", "Notfall und Rettungsmedizin"),
	/**
	 * <div class="de">Nuklearmedizin </div> <div class="fr">Médecine
	 * nucléaire</div> <div class="it">Medicina nucleare</div>
	 */
	NUKLEARMEDIZIN("10031", "Nuklearmedizin"),
	/**
	 * <div class="de">Ophthalmologie</div> <div class="fr">Ophtalmologie</div>
	 * <div class="it">Oftalmologia</div>
	 */
	OPHTHALMOLOGIE("10032", "Ophthalmologie"),
	/**
	 * <div class="de">Orthopädie und Traumatologie</div>
	 * <div class="fr">Chirurgie orthopédique et traumatologie de l'appareil
	 * locomoteur</div> <div class="it">Chirurgia ortopedica e traumatologia
	 * dell'apparato locomotore</div>
	 */
	ORTHOPADIE_UND_TRAUMATOLOGIE("10033", "Orthopädie und Traumatologie"),
	/**
	 * <div class="de">Osteopathie </div> <div class="fr">Ostéopathie </div>
	 * <div class="it">Osteopatia </div>
	 */
	OSTEOPATHIE("10034", "Osteopathie"),
	/**
	 * <div class="de">Oto-Rhino-Laryngologie</div>
	 * <div class="fr">Oto-Rhino-Laryngologie</div>
	 * <div class="it">Otorinolaringoiatria</div>
	 */
	OTO_RHINO_LARYNGOLOGIE("10035", "Oto-Rhino-Laryngologie"),
	/**
	 * <div class="de">Palliativmedizin </div> <div class="fr">Médecine
	 * palliative</div> <div class="it">Medicina palliativa</div>
	 */
	PALLIATIVMEDIZIN("10036", "Palliativmedizin"),
	/**
	 * <div class="de">Pathologie </div> <div class="fr">Pathologie</div>
	 * <div class="it">Patologia </div>
	 */
	PATHOLOGIE("10037", "Pathologie"),
	/**
	 * <div class="de">Pflege</div> <div class="fr">Soins</div>
	 * <div class="it">Cure</div>
	 */
	PFLEGE("10038", "Pflege"),
	/**
	 * <div class="de">Pharmakologie</div> <div class="fr">Pharmacologie</div>
	 * <div class="it">Farmacologia</div>
	 */
	PHARMAKOLOGIE("10005", "Pharmakologie"),
	/**
	 * <div class="de">Physikalische Medizin </div>
	 * <div class="fr">Kinésithérapie </div> <div class="it">Medicina fisica
	 * </div>
	 */
	PHYSIKALISCHE_MEDIZIN("10039", "Physikalische Medizin"),
	/**
	 * <div class="de">Physiotherapie</div> <div class="fr">Physiothérapie</div>
	 * <div class="it">Fisioterapia</div>
	 */
	PHYSIOTHERAPIE("10040", "Physiotherapie"),
	/**
	 * <div class="de">Plastische, Rekonstruktive und Asthetische
	 * Chirurgie</div> <div class="fr">Chirurgie plastique, reconstructrice et
	 * esthétique</div> <div class="it">Chirurgia plastica, ricostruttiva ed
	 * estetica</div>
	 */
	PLASTISCHE_REKONSTRUKTIVE_UND_ASTHETISCHE_CHIRURGIE("10041",
			"Plastische, Rekonstruktive und Asthetische Chirurgie"),
	/**
	 * <div class = "de"> Pneumologie </div> <div class = "fr"> Pneumologie
	 * </div> <div class = "it"> Pneumologia </div>
	 */
	PNEUMOLOGIE("10042", "Pneumologie"),
	/**
	 * <div class="de">Podologie</div> <div class="fr">Podologie</div>
	 * <div class="it">Podologia</div>
	 */
	PODOLOGIE("10043", "Podologie"),
	/**
	 * <div class="de">Prävention </div> <div class="fr">Prévention </div>
	 * <div class="it">Prevenzione </div>
	 */
	PRAVENTION("10044", "Prävention"),
	/**
	 * <div class="de">Psychiatrie und Psychotherapie</div>
	 * <div class="fr">Psychiatrie et psychothérapie</div>
	 * <div class="it">Psichiatria e psicoterapia</div>
	 */
	PSYCHIATRIE_UND_PSYCHOTHERAPIE("10045", "Psychiatrie und Psychotherapie"),
	/**
	 * <div class="de">Psychologie </div> <div class="fr">Psychologie </div>
	 * <div class="it">Psicologia </div>
	 */
	PSYCHOLOGIE("10023", "Psychologie"),
	/**
	 * <div class="de">Psychosomatik</div> <div class="fr">Psychosomatique</div>
	 * <div class="it">Psicosomatica</div>
	 */
	PSYCHOSOMATIK("10046", "Psychosomatik"),
	/**
	 * <div class="de">Pädiatrie</div> <div class="fr">Pédiatrie</div>
	 * <div class="it">Pediatria</div>
	 */
	PADIATRIE("10022", "Pädiatrie"),
	/**
	 * <div class="de">Radiologie</div> <div class="fr">Radiologie</div>
	 * <div class="it">Radiologia</div>
	 */
	RADIOLOGIE("10047", "Radiologie"),
	/**
	 * <div class="de">Radio-Onkologie/Strahlentherapie </div>
	 * <div class="fr">Radio-oncologie / radiothérapie </div>
	 * <div class="it">Radio-oncologia / radioterapia</div>
	 */
	RADIO_ONKOLOGIESTRAHLENTHERAPIE("10048", "Radio-Onkologie/Strahlentherapie"),
	/**
	 * <div class="de"> Rechtsmedizin</div> <div class="fr">Médecine
	 * légale</div> <div class="it">Medicina legale</div>
	 */
	RECHTSMEDIZIN("10049", "Rechtsmedizin"),
	/**
	 * <div class="de">Rehabilitation</div> <div class="fr">Réhabilitation</div>
	 * <div class="it">Riabilitazione</div>
	 */
	REHABILITATION("10050", "Rehabilitation"),
	/**
	 * <div class="de">Rheumatologie</div> <div class="fr">Rhumatologie</div>
	 * <div class="it">Reumatologia</div>
	 */
	RHEUMATOLOGIE("10052", "Rheumatologie"),
	/**
	 * <div class="de">Thoraxchirurgie</div> <div class="fr">Chirurgie
	 * thoracique</div> <div class="it">Chirurgia toracica</div>
	 */
	THORAXCHIRURGIE("10053", "Thoraxchirurgie"),
	/**
	 * <div class="de">Transfusionsmedizin</div> <div class="fr">Médecine
	 * transfusionnelle</div> <div class="it">Medicina trasfusionale</div>
	 */
	TRANSFUSIONSMEDIZIN("10054", "Transfusionsmedizin"),
	/**
	 * <div class="de">Tropen- und Reisemedizin</div> <div class="fr">Médecine
	 * tropicale et des voyages</div> <div class="it">Medicina tropicale e di
	 * viaggio</div>
	 */
	TROPEN_UND_REISEMEDIZIN("10055", "Tropen- und Reisemedizin"),
	/**
	 * <div class="de">Unbekannt</div> <div class="fr">Inconnu</div>
	 * <div class="it">Ignoto</div>
	 */
	UNBEKANNT("10900", "Unbekannt"),
	/**
	 * <div class="de">Urologie</div> <div class="fr">Urologie</div>
	 * <div class="it">Urologia</div>
	 */
	UROLOGIE("10056", "Urologie"),
	/**
	 * <div class="de">Zahnheilkunde</div> <div class="fr">Odontologie</div>
	 * <div class="it">Odontoiatria</div>
	 */
	ZAHNHEILKUNDE("10057", "Zahnheilkunde");

	/**
	 * <div class="de">Code für Allergologie</div> <div class="fr">Code de
	 * Allergologie</div> <div class="it">Code per Allergologia</div>
	 */
	public static final String ALLERGOLOGIE_CODE = "10001";

	/**
	 * <div class="de">Code für Allgemeinmedizin </div> <div class="fr">Code de
	 * Médecine générale </div> <div class="it">Code per Medicina generale
	 * </div>
	 */
	public static final String ALLGEMEINMEDIZIN_CODE = "10002";

	/**
	 * <div class="de">Code für Andere nicht näher spezifizierte medzinische
	 * Fachrichtung</div> <div class="fr">Code de Autres sans
	 * spécification</div> <div class="it">Code per Altri rami specialistici
	 * della medicina non meglio precisati</div>
	 */
	public static final String ANDERE_NICHT_NAHER_SPEZIFIZIERTE_MEDZINISCHE_FACHRICHTUNG_CODE = "10999";

	/**
	 * <div class="de">Code für Angiologie</div> <div class="fr">Code de
	 * Angiologie</div> <div class="it">Code per Angiologia</div>
	 */
	public static final String ANGIOLOGIE_CODE = "10004";

	/**
	 * <div class="de">Code für Anästhesiologie</div> <div class="fr">Code de
	 * Anesthésiologie</div> <div class="it">Code per Anestesiologia</div>
	 */
	public static final String ANASTHESIOLOGIE_CODE = "10003";

	/**
	 * <div class="de">Code für Arbeitsmedizin</div> <div class="fr">Code de
	 * Médecine du travail</div> <div class="it">Code per Medicina del
	 * lavoro</div>
	 */
	public static final String ARBEITSMEDIZIN_CODE = "10006";

	/**
	 * <div class="de">Code für Chiropraktik</div> <div class="fr">Code de
	 * Chiropractie</div> <div class="it">Code per Chiropratica</div>
	 */
	public static final String CHIROPRAKTIK_CODE = "10007";

	/**
	 * <div class="de">Code für Chirurgie</div> <div class="fr">Code de
	 * Chirurgie</div> <div class="it">Code per Chirurgia</div>
	 */
	public static final String CHIRURGIE_CODE = "10008";

	/**
	 * <div class="de">Code für Dermatologie und Venerologie</div>
	 * <div class="fr">Code de Dermatologie et vénéréologie</div>
	 * <div class="it">Code per Dermatologia e venereologia</div>
	 */
	public static final String DERMATOLOGIE_UND_VENEROLOGIE_CODE = "10009";

	/**
	 * <div class="de">Code für Endokrinologie/Diabetologie</div>
	 * <div class="fr">Code de Endocrinologie/diabétologie</div>
	 * <div class="it">Code per Endocrinologia/diabetologia</div>
	 */
	public static final String ENDOKRINOLOGIEDIABETOLOGIE_CODE = "10010";

	/**
	 * <div class="de">Code für Ergotherapie</div> <div class="fr">Code de
	 * Ergothérapie</div> <div class="it">Code per Ergoterapia</div>
	 */
	public static final String ERGOTHERAPIE_CODE = "10011";

	/**
	 * <div class="de">Code für Ernährungsberatung</div> <div class="fr">Code de
	 * Conseil en nutrition</div> <div class="it">Code per Dietetica</div>
	 */
	public static final String ERNAHRUNGSBERATUNG_CODE = "10012";

	/**
	 * <div class="de">Code für Gastroenterologie</div> <div class="fr">Code de
	 * Gastroentérologie</div> <div class="it">Code per Gastroenterologia</div>
	 */
	public static final String GASTROENTEROLOGIE_CODE = "10014";

	/**
	 * <div class="de">Code für Geriatrie</div> <div class="fr">Code de
	 * Gériatrie</div> <div class="it">Code per Geriatria</div>
	 */
	public static final String GERIATRIE_CODE = "10013";

	/**
	 * <div class="de">Code für Gynäkologie und Geburtshilfe</div>
	 * <div class="fr">Code de Gynécologie et obstétrique</div>
	 * <div class="it">Code per Ginecologia e ostetricia</div>
	 */
	public static final String GYNAKOLOGIE_UND_GEBURTSHILFE_CODE = "10015";

	/**
	 * <div class="de">Code für Herz- und Gefässchirurgie</div>
	 * <div class="fr">Code de Chirurgie cardiovasculaire</div>
	 * <div class="it">Code per Chirurgia cardiovascolare</div>
	 */
	public static final String HERZ_UND_GEFASSCHIRURGIE_CODE = "10016";

	/**
	 * <div class="de">Code für Hämatologie</div> <div class="fr">Code de
	 * Hématologie</div> <div class="it">Code per Ematologia</div>
	 */
	public static final String HAMATOLOGIE_CODE = "10058";

	/**
	 * <div class="de">Code für Immunologie</div> <div class="fr">Code de
	 * Immunologie</div> <div class="it">Code per Immunologia</div>
	 */
	public static final String IMMUNOLOGIE_CODE = "10059";

	/**
	 * <div class="de">Code für Infektiologie</div> <div class="fr">Code de
	 * Infectiologie</div> <div class="it">Code per Infettivologia</div>
	 */
	public static final String INFEKTIOLOGIE_CODE = "10017";

	/**
	 * <div class="de">Code für Innere Medizin</div> <div class="fr">Code de
	 * Médecine interne</div> <div class="it">Code per Medicina interna</div>
	 */
	public static final String INNERE_MEDIZIN_CODE = "10018";

	/**
	 * <div class="de">Code für Intensivmedizin</div> <div class="fr">Code de
	 * Médecine intensive</div> <div class="it">Code per Medicina
	 * intensiva</div>
	 */
	public static final String INTENSIVMEDIZIN_CODE = "10019";

	/**
	 * <div class="de">Code für Kardiologie</div> <div class="fr">Code de
	 * Cardiologie</div> <div class="it">Code per Cardiologia</div>
	 */
	public static final String KARDIOLOGIE_CODE = "10020";

	/**
	 * <div class="de">Code für Komplementärmedizin</div> <div class="fr">Code
	 * de Médecine alternative et complémentaire</div> <div class="it">Code per
	 * Medicina complementare</div>
	 */
	public static final String KOMPLEMENTARMEDIZIN_CODE = "10021";

	/**
	 * <div class="de">Code für Labormedizin</div> <div class="fr">Code de
	 * Diagnostic de laboratoire</div> <div class="it">Code per Medicina di
	 * laboratorio</div>
	 */
	public static final String LABORMEDIZIN_CODE = "10024";

	/**
	 * <div class="de">Code für Logopädie</div> <div class="fr">Code de
	 * Orthophonie</div> <div class="it">Code per Logopedia</div>
	 */
	public static final String LOGOPADIE_CODE = "10025";

	/**
	 * <div class="de">Code für Medizinische Genetik</div> <div class="fr">Code
	 * de Génétique médicale</div> <div class="it">Code per Genetica
	 * medica</div>
	 */
	public static final String MEDIZINISCHE_GENETIK_CODE = "10026";

	/**
	 * <div class="de">Code für Mund-, Kiefer- und Gesichtschirurgie</div>
	 * <div class="fr">Code de Chirurgie dento-maxillo-faciale</div>
	 * <div class="it">Code per Chirurgia maxillo-facciale</div>
	 */
	public static final String MUND_KIEFER_UND_GESICHTSCHIRURGIE_CODE = "10027";

	/**
	 * <div class="de">Code für Nephrologie</div> <div class="fr">Code de
	 * Néphrologie</div> <div class="it">Code per Nefrologia</div>
	 */
	public static final String NEPHROLOGIE_CODE = "10028";

	/**
	 * <div class="de">Code für Neurochirurgie</div> <div class="fr">Code de
	 * Neurochirurgie</div> <div class="it">Code per Neurochirurgia</div>
	 */
	public static final String NEUROCHIRURGIE_CODE = "10029";

	/**
	 * <div class="de">Code für Neurologie</div> <div class="fr">Code de
	 * Neurologie</div> <div class="it">Code per Neurologia</div>
	 */
	public static final String NEUROLOGIE_CODE = "10030";

	/**
	 * <div class="de">Code für Notfall und Rettungsmedizin</div>
	 * <div class="fr">Code de Médecine d'urgence</div> <div class="it">Code per
	 * Medicina d'urgenza e di salvataggio</div>
	 */
	public static final String NOTFALL_UND_RETTUNGSMEDIZIN_CODE = "10051";

	/**
	 * <div class="de">Code für Nuklearmedizin</div> <div class="fr">Code de
	 * Médecine nucléaire</div> <div class="it">Code per Medicina nucleare</div>
	 */
	public static final String NUKLEARMEDIZIN_CODE = "10031";

	/**
	 * <div class="de">Code für Ophthalmologie</div> <div class="fr">Code de
	 * Ophtalmologie</div> <div class="it">Code per Oftalmologia</div>
	 */
	public static final String OPHTHALMOLOGIE_CODE = "10032";

	/**
	 * <div class="de">Code für Orthopädie und Traumatologie</div>
	 * <div class="fr">Code de Chirurgie orthopédique et traumatologie de
	 * l'appareil locomoteur</div> <div class="it">Code per Chirurgia ortopedica
	 * e traumatologia dell'apparato locomotore</div>
	 */
	public static final String ORTHOPADIE_UND_TRAUMATOLOGIE_CODE = "10033";

	/**
	 * <div class="de">Code für Osteopathie</div> <div class="fr">Code de
	 * Ostéopathie</div> <div class="it">Code per Osteopatia</div>
	 */
	public static final String OSTEOPATHIE_CODE = "10034";

	/**
	 * <div class="de">Code für Oto-Rhino-Laryngologie</div>
	 * <div class="fr">Code de Oto-Rhino-Laryngologie</div> <div class="it">Code
	 * per Otorinolaringoiatria</div>
	 */
	public static final String OTO_RHINO_LARYNGOLOGIE_CODE = "10035";

	/**
	 * <div class="de">Code für Palliativmedizin</div> <div class="fr">Code de
	 * Médecine palliative</div> <div class="it">Code per Medicina
	 * palliativa</div>
	 */
	public static final String PALLIATIVMEDIZIN_CODE = "10036";

	/**
	 * <div class="de">Code für Pathologie </div> <div class="fr">Code de
	 * Pathologie</div> <div class="it">Code per Patologia </div>
	 */
	public static final String PATHOLOGIE_CODE = "10037";

	/**
	 * <div class="de">Code für Pflege</div> <div class="fr">Code de Soins</div>
	 * <div class="it">Code per Cure</div>
	 */
	public static final String PFLEGE_CODE = "10038";

	/**
	 * <div class="de">Code für Pharmakologie</div> <div class="fr">Code de
	 * Pharmacologie</div> <div class="it">Code per Farmacologia</div>
	 */
	public static final String PHARMAKOLOGIE_CODE = "10005";

	/**
	 * <div class="de">Code für Physikalische Medizin </div>
	 * <div class="fr">Code de Kinésithérapie </div> <div class="it">Code per
	 * Medicina fisica </div>
	 */
	public static final String PHYSIKALISCHE_MEDIZIN_CODE = "10039";

	/**
	 * <div class="de">Code für Physiotherapie</div> <div class="fr">Code de
	 * Physiothérapie</div> <div class="it">Code per Fisioterapia</div>
	 */
	public static final String PHYSIOTHERAPIE_CODE = "10040";

	/**
	 * <div class="de">Code für Plastische, Rekonstruktive und Asthetische
	 * Chirurgie</div> <div class="fr">Code de Chirurgie plastique,
	 * reconstructrice et esthétique</div> <div class="it">Code per Chirurgia
	 * plastica, ricostruttiva ed estetica</div>
	 */
	public static final String PLASTISCHE_REKONSTRUKTIVE_UND_ASTHETISCHE_CHIRURGIE_CODE = "10041";

	/**
	 * <div class="de">Code für Pneumologie</div> <div class="fr">Code de
	 * Pneumologie</div> <div class="it">Code per Pneumologia</div>
	 */
	public static final String PNEUMOLOGIE_CODE = "10042";

	/**
	 * <div class="de">Code für Podologie</div> <div class="fr">Code de
	 * Podologie</div> <div class="it">Code per Podologia</div>
	 */
	public static final String PODOLOGIE_CODE = "10043";

	/**
	 * <div class="de">Code für Prävention </div> <div class="fr">Code de
	 * Prévention </div> <div class="it">Code per Prevenzione </div>
	 */
	public static final String PRAVENTION_CODE = "10044";

	/**
	 * <div class="de">Code für Psychiatrie und Psychotherapie</div>
	 * <div class="fr">Code de Psychiatrie et psychothérapie</div>
	 * <div class="it">Code per Psichiatria e psicoterapia</div>
	 */
	public static final String PSYCHIATRIE_UND_PSYCHOTHERAPIE_CODE = "10045";

	/**
	 * <div class="de">Code für Psychologie</div> <div class="fr">Code de
	 * Psychologie</div> <div class="it">Code per Psicologia</div>
	 */
	public static final String PSYCHOLOGIE_CODE = "10023";

	/**
	 * <div class="de">Code für Psychosomatik</div> <div class="fr">Code de
	 * Psychosomatique</div> <div class="it">Code per Psicosomatica</div>
	 */
	public static final String PSYCHOSOMATIK_CODE = "10046";

	/**
	 * <div class="de">Code für Pädiatrie</div> <div class="fr">Code de
	 * Pédiatrie</div> <div class="it">Code per Pediatria</div>
	 */
	public static final String PADIATRIE_CODE = "10022";

	/**
	 * <div class="de">Code für Radiologie</div> <div class="fr">Code de
	 * Radiologie</div> <div class="it">Code per Radiologia</div>
	 */
	public static final String RADIOLOGIE_CODE = "10047";

	/**
	 * <div class="de">Code für Radio-Onkologie/Strahlentherapie</div>
	 * <div class="fr">Code de Radio-oncologie / radiothérapie</div>
	 * <div class="it">Code per Radio-oncologia / radioterapia</div>
	 */
	public static final String RADIO_ONKOLOGIESTRAHLENTHERAPIE_CODE = "10048";

	/**
	 * <div class="de">Code für Rechtsmedizin</div> <div class="fr">Code de
	 * Médecine légale</div> <div class="it">Code per Medicina legale</div>
	 */
	public static final String RECHTSMEDIZIN_CODE = "10049";

	/**
	 * <div class="de">Code für Rehabilitation</div> <div class="fr">Code de
	 * Réhabilitation</div> <div class="it">Code per Riabilitazione</div>
	 */
	public static final String REHABILITATION_CODE = "10050";

	/**
	 * <div class="de">Code für Rheumatologie</div> <div class="fr">Code de
	 * Rhumatologie</div> <div class="it">Code per Reumatologia</div>
	 */
	public static final String RHEUMATOLOGIE_CODE = "10052";

	/**
	 * <div class="de">Code für Thoraxchirurgie</div> <div class="fr">Code de
	 * Chirurgie thoracique</div> <div class="it">Code per Chirurgia
	 * toracica</div>
	 */
	public static final String THORAXCHIRURGIE_CODE = "10053";

	/**
	 * <div class="de">Code für Transfusionsmedizin</div> <div class="fr">Code
	 * de Médecine transfusionnelle</div> <div class="it">Code per Medicina
	 * trasfusionale</div>
	 */
	public static final String TRANSFUSIONSMEDIZIN_CODE = "10054";

	/**
	 * <div class="de">Code für Tropen- und Reisemedizin</div>
	 * <div class="fr">Code de Médecine tropicale et des voyages</div>
	 * <div class="it">Code per Medicina tropicale e di viaggio</div>
	 */
	public static final String TROPEN_UND_REISEMEDIZIN_CODE = "10055";

	/**
	 * <div class="de">Code für Unbekannt</div> <div class="fr">Code de
	 * Inconnu</div> <div class="it">Code per Ignoto</div>
	 */
	public static final String UNBEKANNT_CODE = "10900";

	/**
	 * <div class="de">Code für Urologie</div> <div class="fr">Code de
	 * Urologie</div> <div class="it">Code per Urologia</div>
	 */
	public static final String UROLOGIE_CODE = "10056";

	/**
	 * <div class="de">Code für Zahnheilkunde</div> <div class="fr">Code de
	 * Odontologie</div> <div class="it">Code per Odontoiatria</div>
	 */
	public static final String ZAHNHEILKUNDE_CODE = "10057";

	/**
	 * <div class="en">Identifier of the Code System</div>
	 * <div class="de">Identifikator für das Code System</div>
	 */
	public static final String CODE_SYSTEM_OID = "2.16.756.5.30.1.127.3.10.1.18";

	/**
	 * <div class="en">Name of the Code System</div> <div class="de">Name des
	 * Codes Systems</div>
	 */
	public static final String CODE_SYSTEM_NAME = "epd_xds_practiceSettingCode";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static PracticeSettingCode getEnum(String code) {
		for (final PracticeSettingCode x : values()) {
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
	 * @param enumName
	 *            <br>
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(PracticeSettingCode.class, enumName);
			return true;
		} catch (final IllegalArgumentException ex) {
			return false;
		}
	}

	/**
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der gegebene code in diesem Value Set vorhanden
	 * ist.</div>
	 *
	 * @param codeValue
	 *            <div class="de">code</div>
	 * @return true, if one enum of this valueset contains the given code
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final PracticeSettingCode x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <div class="en">Machine interpretable and (inside this class) unique
	 * code</div> <div class="de">Maschinen interpretierbarer und (innerhalb
	 * dieser Klasse) eindeutiger Code</div>
	 */
	private String code;

	/**
	 * <div class="en">Human readable name</div>
	 * <div class="de">Menschenlesbarer Name</div>
	 */
	private String displayName;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instantiiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @param displayName
	 *            <br>
	 *            <div class="de"> display name</div>
	 */
	private PracticeSettingCode(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div>
	 * <div class="de">Liefert das ehealthconnector Code Objekt</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	@Override
	public Code getCode() {
		return new Code(CODE_SYSTEM_OID, code, displayName);
	}

	/**
	 * <div class="en">Gets the IPF Code Object</div> <div class="de">Liefert das
	 * IPF Code Objekt</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	@Override
	public org.openehealth.ipf.commons.ihe.xds.core.metadata.Code getIpfCode() {
		final var cmt = new org.openehealth.ipf.commons.ihe.xds.core.metadata.Code();
		cmt.setSchemeName(getCodeSystemId());
		cmt.setCode(getCodeValue());
		cmt.setDisplayName(XdsMetadataUtil.createInternationalString(getDisplayName(), "de-ch"));
		return cmt;
	}

	@Override
	public String getCodeSystemId() {
		return CODE_SYSTEM_OID;
	}

	/**
	 * <div class="en">Gets the code system name.</div> <div class="de">Liefert
	 * code system name.</div>
	 *
	 * @return <div class="en">the code system name</div>
	 */
	@Override
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
	 * <div class="de">Liefert den eigentlichen Code als String</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	@Override
	public String getCodeValue() {
		return this.code;
	}

	/**
	 * <div class="en">Gets the display name.</div> <div class="de">Liefert
	 * display name.</div>
	 *
	 * @return <div class="en">the display name</div>
	 */
	@Override
	public String getDisplayName() {
		return this.displayName;
	}

	@Override
	public String getDisplayName(LanguageCode languageCode) {
		return this.displayName;
	}

	@Override
	public String getValueSetId() {
		return null;
	}

	@Override
	public String getValueSetName() {
		return null;
	}
}
