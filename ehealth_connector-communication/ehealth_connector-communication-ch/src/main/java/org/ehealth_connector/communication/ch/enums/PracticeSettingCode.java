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
package org.ehealth_connector.communication.ch.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * <div class="en">Medical specialisation of the data captured in the document as per Annex 3  EPRO-FDHA. <br clear="none"/><br clear="none"/>This attribute assigns the contents of a document to a medical specialisation. It is conceivable that this information will assist the patient with setting or changing the confidentiality level of documents, which is relevant for controlling access. <br clear="none"/></div>
 * <div class="de">Medizinische Fachrichtung der in dem Dokument erfassten Daten gemäss Anhang 3 EPDV-EDI.<br clear="none"/><br clear="none"/>Dieses Attribut soll den Inhalt eines Dokumentes einer medizinischen Fachrichtung zuordnen. Es ist denkbar, dass der Patient mit dieser Information eine Hilfestellung erhält zum Setzen oder Verändern der Vertraulichkeitsstufe von Dokumenten, welche relevant ist für die Zugriffssteuerung. <br clear="none"/></div>
 * <div class="fr">Discipline médicale des données saisies dans le document selon l'annexe 3 ODEP-DFI. <br clear="none"/><br clear="none"/>Cet attribut permet d'indiquer la discipline médicale dont relève le contenu d'un document. Cette information peut guider le patient et l'aider à choisir ou à changer le niveau de confidentialité attribué à ses documents et qui détermine les droits d'accès. <br clear="none"/></div>
 * <div class="it">Specialità medica dei dati inseriti nel documento secondo l'allegato 3 OCIP-DFI. <br clear="none"/><br clear="none"/>Questo attributo intende associare il contenuto di un documento a una specialità medica. È ipotizzabile che questa informazione fornisca un aiuto al paziente per impostare o modificare il grado di riservatezza dei documenti, rilevante per il controllo degli accessi. <br clear="none"/></div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum PracticeSettingCode implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Accident & emergency</div>
	 * <div class="de">Notfall- und Rettungsmedizin</div>
	 * <div class="fr">Médecine d'urgence et de sauvetage</div>
	 * <div class="it">Medicina d'urgenza e di salvataggio</div>
	 * <!-- @formatter:on -->
	 */
	ACCIDENT_EMERGENCY("394576009", "2.16.840.1.113883.6.96",
			"Accident & emergency (qualifier value)", "Accident & emergency",
			"Notfall- und Rettungsmedizin", "Médecine d'urgence et de sauvetage",
			"Medicina d'urgenza e di salvataggio"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Anaesthesiology</div>
	 * <div class="de">Anästhesiologie</div>
	 * <div class="fr">Anesthésiologie</div>
	 * <div class="it">Anestesiologia</div>
	 * <!-- @formatter:on -->
	 */
	ANAESTHESIOLOGY("394577000", "2.16.840.1.113883.6.96", "Anesthetics (qualifier value)",
			"Anaesthesiology", "Anästhesiologie", "Anesthésiologie", "Anestesiologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cardiac surgery</div>
	 * <div class="de">Herzchirurgie</div>
	 * <div class="fr">Chirurgie cardiovasculaire</div>
	 * <div class="it">Chirurgia cardiovascolare</div>
	 * <!-- @formatter:on -->
	 */
	CARDIAC_SURGERY("408466002", "2.16.840.1.113883.6.96", "Cardiac surgery (qualifier value)",
			"Cardiac surgery", "Herzchirurgie", "Chirurgie cardiovasculaire",
			"Chirurgia cardiovascolare"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cardiology</div>
	 * <div class="de">Kardiologie</div>
	 * <div class="fr">Cardiologie</div>
	 * <div class="it">Cardiologia</div>
	 * <!-- @formatter:on -->
	 */
	CARDIOLOGY("394579002", "2.16.840.1.113883.6.96", "Cardiology (qualifier value)", "Cardiology",
			"Kardiologie", "Cardiologie", "Cardiologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Chiropractic service</div>
	 * <div class="de">Chiropraktik</div>
	 * <div class="fr">Chiropractie</div>
	 * <div class="it">Chiropratica</div>
	 * <!-- @formatter:on -->
	 */
	CHIROPRACTIC_SERVICE("722170006", "2.16.840.1.113883.6.96",
			"Chiropractic service (qualifier value)", "Chiropractic service", "Chiropraktik",
			"Chiropractie", "Chiropratica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Clinical genetics</div>
	 * <div class="de">Medizinische Genetik</div>
	 * <div class="fr">Génétique médicale</div>
	 * <div class="it">Genetica medica</div>
	 * <!-- @formatter:on -->
	 */
	CLINICAL_GENETICS("394580004", "2.16.840.1.113883.6.96", "Clinical genetics (qualifier value)",
			"Clinical genetics", "Medizinische Genetik", "Génétique médicale",
			"Genetica medica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Clinical haematology</div>
	 * <div class="de">Hämatologie</div>
	 * <div class="fr">Hématologie</div>
	 * <div class="it">Ematologia</div>
	 * <!-- @formatter:on -->
	 */
	CLINICAL_HAEMATOLOGY("394803006", "2.16.840.1.113883.6.96",
			"Clinical hematology (qualifier value)", "Clinical haematology", "Hämatologie",
			"Hématologie", "Ematologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Clinical immunology</div>
	 * <div class="de">Immunologie</div>
	 * <div class="fr">Immunologie</div>
	 * <div class="it">Immunologia</div>
	 * <!-- @formatter:on -->
	 */
	CLINICAL_IMMUNOLOGY("408480009", "2.16.840.1.113883.6.96",
			"Clinical immunology (qualifier value)", "Clinical immunology", "Immunologie",
			"Immunologie", "Immunologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Clinical immunology/allergy</div>
	 * <div class="de">Immunologie/Allergologie</div>
	 * <div class="fr">Immunologie/Allergologie</div>
	 * <div class="it">Allergologia e immunologia clinica</div>
	 * <!-- @formatter:on -->
	 */
	CLINICAL_IMMUNOLOGY_ALLERGY("394805004", "2.16.840.1.113883.6.96",
			"Clinical immunology/allergy (qualifier value)", "Clinical immunology/allergy",
			"Immunologie/Allergologie", "Immunologie/Allergologie",
			"Allergologia e immunologia clinica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Clinical oncology</div>
	 * <div class="de">Onkologie</div>
	 * <div class="fr">Oncologie</div>
	 * <div class="it">Oncologia medica</div>
	 * <!-- @formatter:on -->
	 */
	CLINICAL_ONCOLOGY("394592004", "2.16.840.1.113883.6.96", "Clinical oncology (qualifier value)",
			"Clinical oncology", "Onkologie", "Oncologie", "Oncologia medica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Clinical pharmacology</div>
	 * <div class="de">Klinische Pharmakologie</div>
	 * <div class="fr">Pharmacologie clinique</div>
	 * <div class="it">Farmacologia clinica</div>
	 * <!-- @formatter:on -->
	 */
	CLINICAL_PHARMACOLOGY("394600006", "2.16.840.1.113883.6.96",
			"Clinical pharmacology (qualifier value)", "Clinical pharmacology",
			"Klinische Pharmakologie", "Pharmacologie clinique", "Farmacologia clinica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Complementary therapy</div>
	 * <div class="de">Komplementärmedizin</div>
	 * <div class="fr">Médecine alternative et complémentaire</div>
	 * <div class="it">Medicina complementare</div>
	 * <!-- @formatter:on -->
	 */
	COMPLEMENTARY_THERAPY("310025004", "2.16.840.1.113883.6.96",
			"Complementary therapy service (qualifier value)", "Complementary therapy",
			"Komplementärmedizin", "Médecine alternative et complémentaire",
			"Medicina complementare"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Critical care medicine</div>
	 * <div class="de">Intensivmedizin</div>
	 * <div class="fr">Médecine intensive</div>
	 * <div class="it">Medicina intensiva</div>
	 * <!-- @formatter:on -->
	 */
	CRITICAL_CARE_MEDICINE("408478003", "2.16.840.1.113883.6.96",
			"Critical care medicine (qualifier value)", "Critical care medicine", "Intensivmedizin",
			"Médecine intensive", "Medicina intensiva"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dental medicine</div>
	 * <div class="de">Zahnheilkunde</div>
	 * <div class="fr">Odontologie</div>
	 * <div class="it">Odontoiatria</div>
	 * <!-- @formatter:on -->
	 */
	DENTAL_MEDICINE("394812008", "2.16.840.1.113883.6.96",
			"Dental medicine specialties (qualifier value)", "Dental medicine", "Zahnheilkunde",
			"Odontologie", "Odontoiatria"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dermatology</div>
	 * <div class="de">Dermatologie und Venerologie</div>
	 * <div class="fr">Dermatologie et vénérologie</div>
	 * <div class="it">Dermatologia e venereologia</div>
	 * <!-- @formatter:on -->
	 */
	DERMATOLOGY("394582007", "2.16.840.1.113883.6.96", "Dermatology (qualifier value)",
			"Dermatology", "Dermatologie und Venerologie", "Dermatologie et vénérologie",
			"Dermatologia e venereologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dietetics and nutrition</div>
	 * <div class="de">Ernährungsberatung</div>
	 * <div class="fr">Conseil en nutrition et diététique</div>
	 * <div class="it">Dietetica</div>
	 * <!-- @formatter:on -->
	 */
	DIETETICS_AND_NUTRITION("722164000", "2.16.840.1.113883.6.96",
			"Dietetics and nutrition (qualifier value)", "Dietetics and nutrition",
			"Ernährungsberatung", "Conseil en nutrition et diététique", "Dietetica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Endocrinology</div>
	 * <div class="de">Endokrinologie/Diabetologie</div>
	 * <div class="fr">Endocrinologie/diabétologie</div>
	 * <div class="it">Endocrinologia/diabetologia</div>
	 * <!-- @formatter:on -->
	 */
	ENDOCRINOLOGY("394583002", "2.16.840.1.113883.6.96", "Endocrinology (qualifier value)",
			"Endocrinology", "Endokrinologie/Diabetologie", "Endocrinologie/diabétologie",
			"Endocrinologia/diabetologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gastroenterology</div>
	 * <div class="de">Gastroenterologie</div>
	 * <div class="fr">Gastroentérologie</div>
	 * <div class="it">Gastroenterologia</div>
	 * <!-- @formatter:on -->
	 */
	GASTROENTEROLOGY("394584008", "2.16.840.1.113883.6.96", "Gastroenterology (qualifier value)",
			"Gastroenterology", "Gastroenterologie", "Gastroentérologie", "Gastroenterologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">General medicine</div>
	 * <div class="de">Allgemeinmedizin</div>
	 * <div class="fr">Médecine générale</div>
	 * <div class="it">Medicina generale</div>
	 * <!-- @formatter:on -->
	 */
	GENERAL_MEDICINE("394802001", "2.16.840.1.113883.6.96", "General medicine (qualifier value)",
			"General medicine", "Allgemeinmedizin", "Médecine générale", "Medicina generale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">General surgery</div>
	 * <div class="de">Chirurgie</div>
	 * <div class="fr">Chirurgie</div>
	 * <div class="it">Chirurgia</div>
	 * <!-- @formatter:on -->
	 */
	GENERAL_SURGERY("394609007", "2.16.840.1.113883.6.96", "General surgery (qualifier value)",
			"General surgery", "Chirurgie", "Chirurgie", "Chirurgia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Geriatric medicine</div>
	 * <div class="de">Geriatrie</div>
	 * <div class="fr">Gériatrie</div>
	 * <div class="it">Geriatria</div>
	 * <!-- @formatter:on -->
	 */
	GERIATRIC_MEDICINE("394811001", "2.16.840.1.113883.6.96",
			"Geriatric medicine (qualifier value)", "Geriatric medicine", "Geriatrie", "Gériatrie",
			"Geriatria"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gynecology and Obstretrics</div>
	 * <div class="de">Gynäkologie und Geburtshilfe</div>
	 * <div class="fr">Gynécologie et obstétrique</div>
	 * <div class="it">Ginecologia e ostetricia</div>
	 * <!-- @formatter:on -->
	 */
	GYNECOLOGY_AND_OBSTRETRICS("394586005", "2.16.840.1.113883.6.96",
			"Gynecology (qualifier value)", "Gynecology and Obstretrics",
			"Gynäkologie und Geburtshilfe", "Gynécologie et obstétrique",
			"Ginecologia e ostetricia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Infectious diseases</div>
	 * <div class="de">Infektionskrankheiten</div>
	 * <div class="fr">Maladies infectieuses</div>
	 * <div class="it">Malattia infettiva</div>
	 * <!-- @formatter:on -->
	 */
	INFECTIOUS_DISEASES("394807007", "2.16.840.1.113883.6.96",
			"Infectious diseases (specialty) (qualifier value)", "Infectious diseases",
			"Infektionskrankheiten", "Maladies infectieuses", "Malattia infettiva"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Internal medicine</div>
	 * <div class="de">Innere Medizin</div>
	 * <div class="fr">Médecine interne</div>
	 * <div class="it">Medicina interna</div>
	 * <!-- @formatter:on -->
	 */
	INTERNAL_MEDICINE("419192003", "2.16.840.1.113883.6.96", "Internal medicine (qualifier value)",
			"Internal medicine", "Innere Medizin", "Médecine interne", "Medicina interna"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Laboratory service</div>
	 * <div class="de">Labormedizin</div>
	 * <div class="fr">Médecin de laboratoire</div>
	 * <div class="it">Medicina di laboratorio</div>
	 * <!-- @formatter:on -->
	 */
	LABORATORY_SERVICE("708184003", "2.16.840.1.113883.6.96",
			"Clinical pathology service (qualifier value)", "Laboratory service", "Labormedizin",
			"Médecin de laboratoire", "Medicina di laboratorio"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Legal medicine</div>
	 * <div class="de">Rechtsmedizin</div>
	 * <div class="fr">Médecine légale</div>
	 * <div class="it">Medicina legale</div>
	 * <!-- @formatter:on -->
	 */
	LEGAL_MEDICINE("722204007", "2.16.840.1.113883.6.96", "Legal medicine (qualifier value)",
			"Legal medicine", "Rechtsmedizin", "Médecine légale", "Medicina legale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nephrology</div>
	 * <div class="de">Nephrologie</div>
	 * <div class="fr">Néphrologie</div>
	 * <div class="it">Nefrologia</div>
	 * <!-- @formatter:on -->
	 */
	NEPHROLOGY("394589003", "2.16.840.1.113883.6.96", "Nephrology (qualifier value)", "Nephrology",
			"Nephrologie", "Néphrologie", "Nefrologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Neurology</div>
	 * <div class="de">Neurologie</div>
	 * <div class="fr">Neurologie</div>
	 * <div class="it">Neurologia</div>
	 * <!-- @formatter:on -->
	 */
	NEUROLOGY("394591006", "2.16.840.1.113883.6.96", "Neurology (qualifier value)", "Neurology",
			"Neurologie", "Neurologie", "Neurologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Neurosurgery</div>
	 * <div class="de">Neurochirurgie</div>
	 * <div class="fr">Neurochirurgie</div>
	 * <div class="it">Neurochirurgia</div>
	 * <!-- @formatter:on -->
	 */
	NEUROSURGERY("394610002", "2.16.840.1.113883.6.96", "Neurosurgery (qualifier value)",
			"Neurosurgery", "Neurochirurgie", "Neurochirurgie", "Neurochirurgia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nuclear medicine</div>
	 * <div class="de">Nuklearmedizin</div>
	 * <div class="fr">Médecine nucléaire</div>
	 * <div class="it">Medicina nucleare</div>
	 * <!-- @formatter:on -->
	 */
	NUCLEAR_MEDICINE("394649004", "2.16.840.1.113883.6.96",
			"Nuclear medicine - specialty (qualifier value)", "Nuclear medicine", "Nuklearmedizin",
			"Médecine nucléaire", "Medicina nucleare"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nursing</div>
	 * <div class="de">Pflege</div>
	 * <div class="fr">Soins</div>
	 * <div class="it">Cure infermieristiche</div>
	 * <!-- @formatter:on -->
	 */
	NURSING("722165004", "2.16.840.1.113883.6.96", "Nursing (qualifier value)", "Nursing", "Pflege",
			"Soins", "Cure infermieristiche"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Occupational therapy service</div>
	 * <div class="de">Ergotherapie</div>
	 * <div class="fr">Ergothérapie</div>
	 * <div class="it">Ergoterapia</div>
	 * <!-- @formatter:on -->
	 */
	OCCUPATIONAL_THERAPY_SERVICE("310093001", "2.16.840.1.113883.6.96",
			"Occupational therapy service (qualifier value)", "Occupational therapy service",
			"Ergotherapie", "Ergothérapie", "Ergoterapia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ophthalmology</div>
	 * <div class="de">Ophthalmologie</div>
	 * <div class="fr">Ophtalmologie</div>
	 * <div class="it">Oftalmologia</div>
	 * <!-- @formatter:on -->
	 */
	OPHTHALMOLOGY("394594003", "2.16.840.1.113883.6.96", "Ophthalmology (qualifier value)",
			"Ophthalmology", "Ophthalmologie", "Ophtalmologie", "Oftalmologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oral and maxillofacial surgery</div>
	 * <div class="de">Mund-, Kiefer- und Gesichtschirurgie</div>
	 * <div class="fr">Chirurgie dento-maxillo-faciale</div>
	 * <div class="it">Chirurgia oro-maxillo-facciale</div>
	 * <!-- @formatter:on -->
	 */
	ORAL_AND_MAXILLOFACIAL_SURGERY("408465003", "2.16.840.1.113883.6.96",
			"Oral and maxillofacial surgery (qualifier value)", "Oral and maxillofacial surgery",
			"Mund-, Kiefer- und Gesichtschirurgie", "Chirurgie dento-maxillo-faciale",
			"Chirurgia oro-maxillo-facciale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Osteopathic manipulative medicine</div>
	 * <div class="de">Osteopathie</div>
	 * <div class="fr">Ostéopathie</div>
	 * <div class="it">Osteopatia</div>
	 * <!-- @formatter:on -->
	 */
	OSTEOPATHIC_MANIPULATIVE_MEDICINE("416304004", "2.16.840.1.113883.6.96",
			"Osteopathic manipulative medicine (qualifier value)",
			"Osteopathic manipulative medicine", "Osteopathie", "Ostéopathie", "Osteopatia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">other Clinical specialty</div>
	 * <div class="de">Andere nicht näher spezifizierte medzinische Fachrichtung</div>
	 * <div class="fr">Autres spécialisations non spécifiées</div>
	 * <div class="it">Altre specialità mediche non meglio precisate</div>
	 * <!-- @formatter:on -->
	 */
	OTHER_CLINICAL_SPECIALTY("394658006", "2.16.840.1.113883.6.96",
			"Clinical specialty (qualifier value)", "other Clinical specialty",
			"Andere nicht näher spezifizierte medzinische Fachrichtung",
			"Autres spécialisations non spécifiées",
			"Altre specialità mediche non meglio precisate"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Otolaryngology</div>
	 * <div class="de">Oto-Rhino-Laryngologie</div>
	 * <div class="fr">Oto-rhino-laryngologie</div>
	 * <div class="it">Otorinolaringoiatria</div>
	 * <!-- @formatter:on -->
	 */
	OTOLARYNGOLOGY("418960008", "2.16.840.1.113883.6.96", "Otolaryngology (qualifier value)",
			"Otolaryngology", "Oto-Rhino-Laryngologie", "Oto-rhino-laryngologie",
			"Otorinolaringoiatria"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Palliative medicine</div>
	 * <div class="de">Palliativmedizin</div>
	 * <div class="fr">Médecine palliative</div>
	 * <div class="it">Medicina palliativa</div>
	 * <!-- @formatter:on -->
	 */
	PALLIATIVE_MEDICINE("394806003", "2.16.840.1.113883.6.96",
			"Palliative medicine (qualifier value)", "Palliative medicine", "Palliativmedizin",
			"Médecine palliative", "Medicina palliativa"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pathology</div>
	 * <div class="de">Pathologie</div>
	 * <div class="fr">Pathologie</div>
	 * <div class="it">Patologia</div>
	 * <!-- @formatter:on -->
	 */
	PATHOLOGY("394595002", "2.16.840.1.113883.6.96", "Pathology (qualifier value)", "Pathology",
			"Pathologie", "Pathologie", "Patologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pediatrics</div>
	 * <div class="de">Pädiatrie</div>
	 * <div class="fr">Pédiatrie</div>
	 * <div class="it">Pediatria</div>
	 * <!-- @formatter:on -->
	 */
	PEDIATRICS("394537008", "2.16.840.1.113883.6.96", "Pediatric specialty (qualifier value)",
			"Pediatrics", "Pädiatrie", "Pédiatrie", "Pediatria"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pharmacy service</div>
	 * <div class="de">Pharmazie-Dienstleistung</div>
	 * <div class="fr">Service pharmaceutique</div>
	 * <div class="it">Farmacia</div>
	 * <!-- @formatter:on -->
	 */
	PHARMACY_SERVICE("310080006", "2.16.840.1.113883.6.96", "Pharmacy service (qualifier value)",
			"Pharmacy service", "Pharmazie-Dienstleistung", "Service pharmaceutique", "Farmacia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Physiotherapy</div>
	 * <div class="de">Physiotherapie</div>
	 * <div class="fr">Physiothérapie</div>
	 * <div class="it">Fisioterapia</div>
	 * <!-- @formatter:on -->
	 */
	PHYSIOTHERAPY("722138006", "2.16.840.1.113883.6.96", "Physiotherapy (qualifier value)",
			"Physiotherapy", "Physiotherapie", "Physiothérapie", "Fisioterapia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Plastic surgery</div>
	 * <div class="de">Plastische, Rekonstruktive und Ästhetische Chirurgie</div>
	 * <div class="fr">Chirurgie plastique, reconstructrice et esthétique</div>
	 * <div class="it">Chirurgia plastica, ricostruttiva ed estetica</div>
	 * <!-- @formatter:on -->
	 */
	PLASTIC_SURGERY("394611003", "2.16.840.1.113883.6.96",
			"Plastic surgery - specialty (qualifier value)", "Plastic surgery",
			"Plastische, Rekonstruktive und Ästhetische Chirurgie",
			"Chirurgie plastique, reconstructrice et esthétique",
			"Chirurgia plastica, ricostruttiva ed estetica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Podiatry service</div>
	 * <div class="de">Podologie</div>
	 * <div class="fr">Podologie</div>
	 * <div class="it">Podologia</div>
	 * <!-- @formatter:on -->
	 */
	PODIATRY_SERVICE("310087009", "2.16.840.1.113883.6.96", "Podiatry service (qualifier value)",
			"Podiatry service", "Podologie", "Podologie", "Podologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Preventive medicine</div>
	 * <div class="de">Präventionsmedizin</div>
	 * <div class="fr">Médecine préventive </div>
	 * <div class="it">Prevenzione</div>
	 * <!-- @formatter:on -->
	 */
	PREVENTIVE_MEDICINE("409968004", "2.16.840.1.113883.6.96",
			"Preventive medicine (qualifier value)", "Preventive medicine", "Präventionsmedizin",
			"Médecine préventive ", "Prevenzione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Psychiatry</div>
	 * <div class="de">Psychiatrie und Psychotherapie</div>
	 * <div class="fr">Psychiatrie et psychothérapie</div>
	 * <div class="it">Psichiatria e psicoterapia</div>
	 * <!-- @formatter:on -->
	 */
	PSYCHIATRY("394587001", "2.16.840.1.113883.6.96", "Psychiatry (qualifier value)", "Psychiatry",
			"Psychiatrie und Psychotherapie", "Psychiatrie et psychothérapie",
			"Psichiatria e psicoterapia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Psychology</div>
	 * <div class="de">Psychologie</div>
	 * <div class="fr">Psychologie</div>
	 * <div class="it">Psicologia</div>
	 * <!-- @formatter:on -->
	 */
	PSYCHOLOGY("722162001", "2.16.840.1.113883.6.96", "Psychology (qualifier value)", "Psychology",
			"Psychologie", "Psychologie", "Psicologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Psycho-Somatic medicine</div>
	 * <div class="de">Psychosomatik</div>
	 * <div class="fr">Psychosomatique</div>
	 * <div class="it">Medicina psicosomatica</div>
	 * <!-- @formatter:on -->
	 */
	PSYCHO_SOMATIC_MEDICINE("721961006", "2.16.840.1.113883.6.96",
			"Psychosomatic medicine (qualifier value)", "Psycho-Somatic medicine", "Psychosomatik",
			"Psychosomatique", "Medicina psicosomatica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pulmonary medicine</div>
	 * <div class="de">Pneumologie</div>
	 * <div class="fr">Pneumologie</div>
	 * <div class="it">Pneumologia</div>
	 * <!-- @formatter:on -->
	 */
	PULMONARY_MEDICINE("418112009", "2.16.840.1.113883.6.96",
			"Pulmonary medicine (qualifier value)", "Pulmonary medicine", "Pneumologie",
			"Pneumologie", "Pneumologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Radiation oncology</div>
	 * <div class="de">Radio-Onkologie/Strahlentherapie</div>
	 * <div class="fr">Radio-oncologie / radiothérapie</div>
	 * <div class="it">Radio-oncologia / radioterapia</div>
	 * <!-- @formatter:on -->
	 */
	RADIATION_ONCOLOGY("419815003", "2.16.840.1.113883.6.96",
			"Radiation oncology (qualifier value)", "Radiation oncology",
			"Radio-Onkologie/Strahlentherapie", "Radio-oncologie / radiothérapie",
			"Radio-oncologia / radioterapia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Radiology</div>
	 * <div class="de">Radiologie</div>
	 * <div class="fr">Radiologie</div>
	 * <div class="it">Radiologia</div>
	 * <!-- @formatter:on -->
	 */
	RADIOLOGY("394914008", "2.16.840.1.113883.6.96", "Radiology - specialty (qualifier value)",
			"Radiology", "Radiologie", "Radiologie", "Radiologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rehabilitation</div>
	 * <div class="de">Rehabilitation</div>
	 * <div class="fr">Réadaptation</div>
	 * <div class="it">Riabilitazione</div>
	 * <!-- @formatter:on -->
	 */
	REHABILITATION("394602003", "2.16.840.1.113883.6.96",
			"Rehabilitation - specialty (qualifier value)", "Rehabilitation", "Rehabilitation",
			"Réadaptation", "Riabilitazione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rheumatology</div>
	 * <div class="de">Rheumatologie</div>
	 * <div class="fr">Rhumatologie</div>
	 * <div class="it">Reumatologia</div>
	 * <!-- @formatter:on -->
	 */
	RHEUMATOLOGY("394810000", "2.16.840.1.113883.6.96", "Rheumatology (qualifier value)",
			"Rheumatology", "Rheumatologie", "Rhumatologie", "Reumatologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Speech and language therapy service</div>
	 * <div class="de">Logopädie</div>
	 * <div class="fr">Logopédie</div>
	 * <div class="it">Logopedia</div>
	 * <!-- @formatter:on -->
	 */
	SPEECH_AND_LANGUAGE_THERAPY_SERVICE("310101009", "2.16.840.1.113883.6.96",
			"Speech and language therapy service (qualifier value)",
			"Speech and language therapy service", "Logopädie", "Logopédie", "Logopedia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Thoracic surgery</div>
	 * <div class="de">Thoraxchirurgie</div>
	 * <div class="fr">Chirurgie thoracique</div>
	 * <div class="it">Chirurgia toracica</div>
	 * <!-- @formatter:on -->
	 */
	THORACIC_SURGERY("408456005", "2.16.840.1.113883.6.96", "Thoracic surgery (qualifier value)",
			"Thoracic surgery", "Thoraxchirurgie", "Chirurgie thoracique", "Chirurgia toracica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Transfusion medicine</div>
	 * <div class="de">Transfusionsmedizin</div>
	 * <div class="fr">Médecine transfusionnelle</div>
	 * <div class="it">Medicina trasfusionale</div>
	 * <!-- @formatter:on -->
	 */
	TRANSFUSION_MEDICINE("394819004", "2.16.840.1.113883.6.96",
			"Blood transfusion (specialty) (qualifier value)", "Transfusion medicine",
			"Transfusionsmedizin", "Médecine transfusionnelle", "Medicina trasfusionale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Transplant surgery</div>
	 * <div class="de">Transplantationsmedizin</div>
	 * <div class="fr">Médecine de la transplantation</div>
	 * <div class="it">Medicina dei trapianti</div>
	 * <!-- @formatter:on -->
	 */
	TRANSPLANT_SURGERY("408477008", "2.16.840.1.113883.6.96",
			"Transplantation surgery (qualifier value)", "Transplant surgery",
			"Transplantationsmedizin", "Médecine de la transplantation", "Medicina dei trapianti"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Trauma and orthopedics</div>
	 * <div class="de">Orthopädie und Traumatologie</div>
	 * <div class="fr">Chirurgie orthopédique et traumatologie de l'appareil locomoteur</div>
	 * <div class="it">Chirurgia ortopedica e traumatologia dell'apparato locomotore</div>
	 * <!-- @formatter:on -->
	 */
	TRAUMA_AND_ORTHOPEDICS("394801008", "2.16.840.1.113883.6.96",
			"Trauma and orthopedics (qualifier value)", "Trauma and orthopedics",
			"Orthopädie und Traumatologie",
			"Chirurgie orthopédique et traumatologie de l'appareil locomoteur",
			"Chirurgia ortopedica e traumatologia dell'apparato locomotore"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Tropical medicine</div>
	 * <div class="de">Tropen- und Reisemedizin</div>
	 * <div class="fr">Médecine tropicale et des voyages</div>
	 * <div class="it">Medicina tropicale e di viaggio</div>
	 * <!-- @formatter:on -->
	 */
	TROPICAL_MEDICINE("408448007", "2.16.840.1.113883.6.96", "Tropical medicine (qualifier value)",
			"Tropical medicine", "Tropen- und Reisemedizin", "Médecine tropicale et des voyages",
			"Medicina tropicale e di viaggio"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Urology</div>
	 * <div class="de">Urologie</div>
	 * <div class="fr">Urologie</div>
	 * <div class="it">Urologia</div>
	 * <!-- @formatter:on -->
	 */
	UROLOGY("394612005", "2.16.840.1.113883.6.96", "Urology (qualifier value)", "Urology",
			"Urologie", "Urologie", "Urologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Vascular medicine</div>
	 * <div class="de">Angiologie</div>
	 * <div class="fr">Angiologie</div>
	 * <div class="it">Angiologia</div>
	 * <!-- @formatter:on -->
	 */
	VASCULAR_MEDICINE("722414000", "2.16.840.1.113883.6.96", "Vascular medicine (qualifier value)",
			"Vascular medicine", "Angiologie", "Angiologie", "Angiologia");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Accident & emergency</div>
	 * <div class="de">Code für Notfall- und Rettungsmedizin</div>
	 * <div class="fr">Code de Médecine d'urgence et de sauvetage</div>
	 * <div class="it">Code per Medicina d'urgenza e di salvataggio</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ACCIDENT_EMERGENCY_CODE = "394576009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Anaesthesiology</div>
	 * <div class="de">Code für Anästhesiologie</div>
	 * <div class="fr">Code de Anesthésiologie</div>
	 * <div class="it">Code per Anestesiologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ANAESTHESIOLOGY_CODE = "394577000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cardiac surgery</div>
	 * <div class="de">Code für Herzchirurgie</div>
	 * <div class="fr">Code de Chirurgie cardiovasculaire</div>
	 * <div class="it">Code per Chirurgia cardiovascolare</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CARDIAC_SURGERY_CODE = "408466002";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cardiology</div>
	 * <div class="de">Code für Kardiologie</div>
	 * <div class="fr">Code de Cardiologie</div>
	 * <div class="it">Code per Cardiologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CARDIOLOGY_CODE = "394579002";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Chiropractic service</div>
	 * <div class="de">Code für Chiropraktik</div>
	 * <div class="fr">Code de Chiropractie</div>
	 * <div class="it">Code per Chiropratica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHIROPRACTIC_SERVICE_CODE = "722170006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Clinical genetics</div>
	 * <div class="de">Code für Medizinische Genetik</div>
	 * <div class="fr">Code de Génétique médicale</div>
	 * <div class="it">Code per Genetica medica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CLINICAL_GENETICS_CODE = "394580004";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Clinical haematology</div>
	 * <div class="de">Code für Hämatologie</div>
	 * <div class="fr">Code de Hématologie</div>
	 * <div class="it">Code per Ematologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CLINICAL_HAEMATOLOGY_CODE = "394803006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Clinical immunology</div>
	 * <div class="de">Code für Immunologie</div>
	 * <div class="fr">Code de Immunologie</div>
	 * <div class="it">Code per Immunologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CLINICAL_IMMUNOLOGY_CODE = "408480009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Clinical immunology/allergy</div>
	 * <div class="de">Code für Immunologie/Allergologie</div>
	 * <div class="fr">Code de Immunologie/Allergologie</div>
	 * <div class="it">Code per Allergologia e immunologia clinica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CLINICAL_IMMUNOLOGY_ALLERGY_CODE = "394805004";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Clinical oncology</div>
	 * <div class="de">Code für Onkologie</div>
	 * <div class="fr">Code de Oncologie</div>
	 * <div class="it">Code per Oncologia medica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CLINICAL_ONCOLOGY_CODE = "394592004";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Clinical pharmacology</div>
	 * <div class="de">Code für Klinische Pharmakologie</div>
	 * <div class="fr">Code de Pharmacologie clinique</div>
	 * <div class="it">Code per Farmacologia clinica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CLINICAL_PHARMACOLOGY_CODE = "394600006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Complementary therapy</div>
	 * <div class="de">Code für Komplementärmedizin</div>
	 * <div class="fr">Code de Médecine alternative et complémentaire</div>
	 * <div class="it">Code per Medicina complementare</div>
	 * <!-- @formatter:on -->
	 */
	public static final String COMPLEMENTARY_THERAPY_CODE = "310025004";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Critical care medicine</div>
	 * <div class="de">Code für Intensivmedizin</div>
	 * <div class="fr">Code de Médecine intensive</div>
	 * <div class="it">Code per Medicina intensiva</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CRITICAL_CARE_MEDICINE_CODE = "408478003";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dental medicine</div>
	 * <div class="de">Code für Zahnheilkunde</div>
	 * <div class="fr">Code de Odontologie</div>
	 * <div class="it">Code per Odontoiatria</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DENTAL_MEDICINE_CODE = "394812008";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dermatology</div>
	 * <div class="de">Code für Dermatologie und Venerologie</div>
	 * <div class="fr">Code de Dermatologie et vénérologie</div>
	 * <div class="it">Code per Dermatologia e venereologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DERMATOLOGY_CODE = "394582007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dietetics and nutrition</div>
	 * <div class="de">Code für Ernährungsberatung</div>
	 * <div class="fr">Code de Conseil en nutrition et diététique</div>
	 * <div class="it">Code per Dietetica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DIETETICS_AND_NUTRITION_CODE = "722164000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Endocrinology</div>
	 * <div class="de">Code für Endokrinologie/Diabetologie</div>
	 * <div class="fr">Code de Endocrinologie/diabétologie</div>
	 * <div class="it">Code per Endocrinologia/diabetologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENDOCRINOLOGY_CODE = "394583002";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gastroenterology</div>
	 * <div class="de">Code für Gastroenterologie</div>
	 * <div class="fr">Code de Gastroentérologie</div>
	 * <div class="it">Code per Gastroenterologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GASTROENTEROLOGY_CODE = "394584008";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for General medicine</div>
	 * <div class="de">Code für Allgemeinmedizin</div>
	 * <div class="fr">Code de Médecine générale</div>
	 * <div class="it">Code per Medicina generale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GENERAL_MEDICINE_CODE = "394802001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for General surgery</div>
	 * <div class="de">Code für Chirurgie</div>
	 * <div class="fr">Code de Chirurgie</div>
	 * <div class="it">Code per Chirurgia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GENERAL_SURGERY_CODE = "394609007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Geriatric medicine</div>
	 * <div class="de">Code für Geriatrie</div>
	 * <div class="fr">Code de Gériatrie</div>
	 * <div class="it">Code per Geriatria</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GERIATRIC_MEDICINE_CODE = "394811001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gynecology and Obstretrics</div>
	 * <div class="de">Code für Gynäkologie und Geburtshilfe</div>
	 * <div class="fr">Code de Gynécologie et obstétrique</div>
	 * <div class="it">Code per Ginecologia e ostetricia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GYNECOLOGY_AND_OBSTRETRICS_CODE = "394586005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Infectious diseases</div>
	 * <div class="de">Code für Infektionskrankheiten</div>
	 * <div class="fr">Code de Maladies infectieuses</div>
	 * <div class="it">Code per Malattia infettiva</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INFECTIOUS_DISEASES_CODE = "394807007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Internal medicine</div>
	 * <div class="de">Code für Innere Medizin</div>
	 * <div class="fr">Code de Médecine interne</div>
	 * <div class="it">Code per Medicina interna</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTERNAL_MEDICINE_CODE = "419192003";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Laboratory service</div>
	 * <div class="de">Code für Labormedizin</div>
	 * <div class="fr">Code de Médecin de laboratoire</div>
	 * <div class="it">Code per Medicina di laboratorio</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LABORATORY_SERVICE_CODE = "708184003";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Legal medicine</div>
	 * <div class="de">Code für Rechtsmedizin</div>
	 * <div class="fr">Code de Médecine légale</div>
	 * <div class="it">Code per Medicina legale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LEGAL_MEDICINE_CODE = "722204007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nephrology</div>
	 * <div class="de">Code für Nephrologie</div>
	 * <div class="fr">Code de Néphrologie</div>
	 * <div class="it">Code per Nefrologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEPHROLOGY_CODE = "394589003";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Neurology</div>
	 * <div class="de">Code für Neurologie</div>
	 * <div class="fr">Code de Neurologie</div>
	 * <div class="it">Code per Neurologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEUROLOGY_CODE = "394591006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Neurosurgery</div>
	 * <div class="de">Code für Neurochirurgie</div>
	 * <div class="fr">Code de Neurochirurgie</div>
	 * <div class="it">Code per Neurochirurgia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEUROSURGERY_CODE = "394610002";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nuclear medicine</div>
	 * <div class="de">Code für Nuklearmedizin</div>
	 * <div class="fr">Code de Médecine nucléaire</div>
	 * <div class="it">Code per Medicina nucleare</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NUCLEAR_MEDICINE_CODE = "394649004";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nursing</div>
	 * <div class="de">Code für Pflege</div>
	 * <div class="fr">Code de Soins</div>
	 * <div class="it">Code per Cure infermieristiche</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NURSING_CODE = "722165004";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Occupational therapy service</div>
	 * <div class="de">Code für Ergotherapie</div>
	 * <div class="fr">Code de Ergothérapie</div>
	 * <div class="it">Code per Ergoterapia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OCCUPATIONAL_THERAPY_SERVICE_CODE = "310093001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ophthalmology</div>
	 * <div class="de">Code für Ophthalmologie</div>
	 * <div class="fr">Code de Ophtalmologie</div>
	 * <div class="it">Code per Oftalmologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OPHTHALMOLOGY_CODE = "394594003";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oral and maxillofacial surgery</div>
	 * <div class="de">Code für Mund-, Kiefer- und Gesichtschirurgie</div>
	 * <div class="fr">Code de Chirurgie dento-maxillo-faciale</div>
	 * <div class="it">Code per Chirurgia oro-maxillo-facciale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORAL_AND_MAXILLOFACIAL_SURGERY_CODE = "408465003";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Osteopathic manipulative medicine</div>
	 * <div class="de">Code für Osteopathie</div>
	 * <div class="fr">Code de Ostéopathie</div>
	 * <div class="it">Code per Osteopatia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OSTEOPATHIC_MANIPULATIVE_MEDICINE_CODE = "416304004";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for other Clinical specialty</div>
	 * <div class="de">Code für Andere nicht näher spezifizierte medzinische Fachrichtung</div>
	 * <div class="fr">Code de Autres spécialisations non spécifiées</div>
	 * <div class="it">Code per Altre specialità mediche non meglio precisate</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OTHER_CLINICAL_SPECIALTY_CODE = "394658006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Otolaryngology</div>
	 * <div class="de">Code für Oto-Rhino-Laryngologie</div>
	 * <div class="fr">Code de Oto-rhino-laryngologie</div>
	 * <div class="it">Code per Otorinolaringoiatria</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OTOLARYNGOLOGY_CODE = "418960008";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Palliative medicine</div>
	 * <div class="de">Code für Palliativmedizin</div>
	 * <div class="fr">Code de Médecine palliative</div>
	 * <div class="it">Code per Medicina palliativa</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PALLIATIVE_MEDICINE_CODE = "394806003";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pathology</div>
	 * <div class="de">Code für Pathologie</div>
	 * <div class="fr">Code de Pathologie</div>
	 * <div class="it">Code per Patologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PATHOLOGY_CODE = "394595002";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pediatrics</div>
	 * <div class="de">Code für Pädiatrie</div>
	 * <div class="fr">Code de Pédiatrie</div>
	 * <div class="it">Code per Pediatria</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PEDIATRICS_CODE = "394537008";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pharmacy service</div>
	 * <div class="de">Code für Pharmazie-Dienstleistung</div>
	 * <div class="fr">Code de Service pharmaceutique</div>
	 * <div class="it">Code per Farmacia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PHARMACY_SERVICE_CODE = "310080006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Physiotherapy</div>
	 * <div class="de">Code für Physiotherapie</div>
	 * <div class="fr">Code de Physiothérapie</div>
	 * <div class="it">Code per Fisioterapia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PHYSIOTHERAPY_CODE = "722138006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Plastic surgery</div>
	 * <div class="de">Code für Plastische, Rekonstruktive und Ästhetische Chirurgie</div>
	 * <div class="fr">Code de Chirurgie plastique, reconstructrice et esthétique</div>
	 * <div class="it">Code per Chirurgia plastica, ricostruttiva ed estetica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PLASTIC_SURGERY_CODE = "394611003";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Podiatry service</div>
	 * <div class="de">Code für Podologie</div>
	 * <div class="fr">Code de Podologie</div>
	 * <div class="it">Code per Podologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PODIATRY_SERVICE_CODE = "310087009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Preventive medicine</div>
	 * <div class="de">Code für Präventionsmedizin</div>
	 * <div class="fr">Code de Médecine préventive </div>
	 * <div class="it">Code per Prevenzione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PREVENTIVE_MEDICINE_CODE = "409968004";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Psychiatry</div>
	 * <div class="de">Code für Psychiatrie und Psychotherapie</div>
	 * <div class="fr">Code de Psychiatrie et psychothérapie</div>
	 * <div class="it">Code per Psichiatria e psicoterapia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PSYCHIATRY_CODE = "394587001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Psychology</div>
	 * <div class="de">Code für Psychologie</div>
	 * <div class="fr">Code de Psychologie</div>
	 * <div class="it">Code per Psicologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PSYCHOLOGY_CODE = "722162001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Psycho-Somatic medicine</div>
	 * <div class="de">Code für Psychosomatik</div>
	 * <div class="fr">Code de Psychosomatique</div>
	 * <div class="it">Code per Medicina psicosomatica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PSYCHO_SOMATIC_MEDICINE_CODE = "721961006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pulmonary medicine</div>
	 * <div class="de">Code für Pneumologie</div>
	 * <div class="fr">Code de Pneumologie</div>
	 * <div class="it">Code per Pneumologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PULMONARY_MEDICINE_CODE = "418112009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Radiation oncology</div>
	 * <div class="de">Code für Radio-Onkologie/Strahlentherapie</div>
	 * <div class="fr">Code de Radio-oncologie / radiothérapie</div>
	 * <div class="it">Code per Radio-oncologia / radioterapia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RADIATION_ONCOLOGY_CODE = "419815003";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Radiology</div>
	 * <div class="de">Code für Radiologie</div>
	 * <div class="fr">Code de Radiologie</div>
	 * <div class="it">Code per Radiologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RADIOLOGY_CODE = "394914008";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Rehabilitation</div>
	 * <div class="de">Code für Rehabilitation</div>
	 * <div class="fr">Code de Réadaptation</div>
	 * <div class="it">Code per Riabilitazione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String REHABILITATION_CODE = "394602003";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Rheumatology</div>
	 * <div class="de">Code für Rheumatologie</div>
	 * <div class="fr">Code de Rhumatologie</div>
	 * <div class="it">Code per Reumatologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RHEUMATOLOGY_CODE = "394810000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Speech and language therapy service</div>
	 * <div class="de">Code für Logopädie</div>
	 * <div class="fr">Code de Logopédie</div>
	 * <div class="it">Code per Logopedia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SPEECH_AND_LANGUAGE_THERAPY_SERVICE_CODE = "310101009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Thoracic surgery</div>
	 * <div class="de">Code für Thoraxchirurgie</div>
	 * <div class="fr">Code de Chirurgie thoracique</div>
	 * <div class="it">Code per Chirurgia toracica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String THORACIC_SURGERY_CODE = "408456005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Transfusion medicine</div>
	 * <div class="de">Code für Transfusionsmedizin</div>
	 * <div class="fr">Code de Médecine transfusionnelle</div>
	 * <div class="it">Code per Medicina trasfusionale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TRANSFUSION_MEDICINE_CODE = "394819004";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Transplant surgery</div>
	 * <div class="de">Code für Transplantationsmedizin</div>
	 * <div class="fr">Code de Médecine de la transplantation</div>
	 * <div class="it">Code per Medicina dei trapianti</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TRANSPLANT_SURGERY_CODE = "408477008";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Trauma and orthopedics</div>
	 * <div class="de">Code für Orthopädie und Traumatologie</div>
	 * <div class="fr">Code de Chirurgie orthopédique et traumatologie de l'appareil locomoteur</div>
	 * <div class="it">Code per Chirurgia ortopedica e traumatologia dell'apparato locomotore</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TRAUMA_AND_ORTHOPEDICS_CODE = "394801008";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Tropical medicine</div>
	 * <div class="de">Code für Tropen- und Reisemedizin</div>
	 * <div class="fr">Code de Médecine tropicale et des voyages</div>
	 * <div class="it">Code per Medicina tropicale e di viaggio</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TROPICAL_MEDICINE_CODE = "408448007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Urology</div>
	 * <div class="de">Code für Urologie</div>
	 * <div class="fr">Code de Urologie</div>
	 * <div class="it">Code per Urologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String UROLOGY_CODE = "394612005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Vascular medicine</div>
	 * <div class="de">Code für Angiologie</div>
	 * <div class="fr">Code de Angiologie</div>
	 * <div class="it">Code per Angiologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VASCULAR_MEDICINE_CODE = "722414000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.18";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "xds-pracSetCo";

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
	public static PracticeSettingCode getEnum(String code) {
		for (final PracticeSettingCode x : values()) {
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
	 * <!-- @formatter:off -->
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der angegebene code in diesem Value Set vorhanden ist.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param codeValue
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
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
	PracticeSettingCode(String code, String codeSystem, String displayName, String displayNameEn,
			String displayNameDe, String displayNameFr, String displayNameIt) {
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
