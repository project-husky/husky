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
package org.ehealth_connector.common.ch.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * Enumeration of HCProfessional.hcSpecialisation values
 *
 * <div class="en">no designation found for language ENGLISH</div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 *
 * Identifier: 2.16.756.5.30.1.127.3.10.8.2
 * Effective date: 2020-05-18 19:54
 * Version: 202004.1-stable
 * Status: FINAL
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-04-22")
public enum HcpSpecialisation implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Allergology and clinical immunology</div>
	 * <div class="de">Allergologie und klinische Immunologie</div>
	 * <div class="fr">Allergologie et immunologie clinique</div>
	 * <div class="it">Allergologia e immunologia clinica</div>
	 * <!-- @formatter:on -->
	 */
	ALLERGOLOGY_AND_CLINICAL_IMMUNOLOGY("1019", "2.16.756.5.30.1.127.3.5",
			"Allergology and clinical immunology", "Allergology and clinical immunology",
			"Allergologie und klinische Immunologie", "Allergologie et immunologie clinique",
			"Allergologia e immunologia clinica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Anaesthesiology</div>
	 * <div class="de">Anästhesiologie</div>
	 * <div class="fr">Anesthésiologie</div>
	 * <div class="it">Anestesiologia</div>
	 * <!-- @formatter:on -->
	 */
	ANAESTHESIOLOGY("1012", "2.16.756.5.30.1.127.3.5", "Anaesthesiology", "Anaesthesiology",
			"Anästhesiologie", "Anesthésiologie", "Anestesiologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Angiology</div>
	 * <div class="de">Angiologie</div>
	 * <div class="fr">Angiologie</div>
	 * <div class="it">Angiologia</div>
	 * <!-- @formatter:on -->
	 */
	ANGIOLOGY("1041", "2.16.756.5.30.1.127.3.5", "Angiology", "Angiology", "Angiologie",
			"Angiologie", "Angiologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cardiac and thoracic vascular surgery</div>
	 * <div class="de">Herz- und thorakale Gefässchirurgie</div>
	 * <div class="fr">Chirurgie cardiaque et vasculaire thoracique</div>
	 * <div class="it">Chirurgia del cuore e dei vasi toracici</div>
	 * <!-- @formatter:on -->
	 */
	CARDIAC_AND_THORACIC_VASCULAR_SURGERY("1004", "2.16.756.5.30.1.127.3.5",
			"Cardiac and thoracic vascular surgery", "Cardiac and thoracic vascular surgery",
			"Herz- und thorakale Gefässchirurgie", "Chirurgie cardiaque et vasculaire thoracique",
			"Chirurgia del cuore e dei vasi toracici"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cardiology</div>
	 * <div class="de">Kardiologie</div>
	 * <div class="fr">Cardiologie</div>
	 * <div class="it">Cardiologia</div>
	 * <!-- @formatter:on -->
	 */
	CARDIOLOGY("1025", "2.16.756.5.30.1.127.3.5", "Cardiology", "Cardiology", "Kardiologie",
			"Cardiologie", "Cardiologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Child and adolescent psychiatry and psychotherapy</div>
	 * <div class="de">Kinder- und Jugendpsychiatrie und -psychotherapie</div>
	 * <div class="fr">Psychiatrie et psychothérapie d’enfants et d’adolescents</div>
	 * <div class="it">Psichiatria e psicoterapia infantile e dell’adolescenza</div>
	 * <!-- @formatter:on -->
	 */
	CHILD_AND_ADOLESCENT_PSYCHIATRY_AND_PSYCHOTHERAPY("1027", "2.16.756.5.30.1.127.3.5",
			"Child and adolescent psychiatry and psychotherapy",
			"Child and adolescent psychiatry and psychotherapy",
			"Kinder- und Jugendpsychiatrie und -psychotherapie",
			"Psychiatrie et psychothérapie d’enfants et d’adolescents",
			"Psichiatria e psicoterapia infantile e dell’adolescenza"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Child and adolescent psychology</div>
	 * <div class="de">Kinder- und Jugendpsychologie</div>
	 * <div class="fr">psychologie des enfants et des adolescents</div>
	 * <div class="it">psicologia dell’età evolutiva</div>
	 * <!-- @formatter:on -->
	 */
	CHILD_AND_ADOLESCENT_PSYCHOLOGY("1055", "2.16.756.5.30.1.127.3.5",
			"Child and adolescent psychology", "Child and adolescent psychology",
			"Kinder- und Jugendpsychologie", "psychologie des enfants et des adolescents",
			"psicologia dell’età evolutiva"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Chiropractic specialist</div>
	 * <div class="de">Fachchiropraktik</div>
	 * <div class="fr">Chiropratique spécialisée</div>
	 * <div class="it">Chiropratica specialistica</div>
	 * <!-- @formatter:on -->
	 */
	CHIROPRACTIC_SPECIALIST("1011", "2.16.756.5.30.1.127.3.5", "Chiropractic specialist",
			"Chiropractic specialist", "Fachchiropraktik", "Chiropratique spécialisée",
			"Chiropratica specialistica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Clinical pharmacology and toxicology</div>
	 * <div class="de">Klinische Pharmakologie und Toxikologie</div>
	 * <div class="fr">Pharmacologie et toxicologie cliniques</div>
	 * <div class="it">Farmacologia e tossicologia cliniche</div>
	 * <!-- @formatter:on -->
	 */
	CLINICAL_PHARMACOLOGY_AND_TOXICOLOGY("1029", "2.16.756.5.30.1.127.3.5",
			"Clinical pharmacology and toxicology", "Clinical pharmacology and toxicology",
			"Klinische Pharmakologie und Toxikologie", "Pharmacologie et toxicologie cliniques",
			"Farmacologia e tossicologia cliniche"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Clinical psychology</div>
	 * <div class="de">Klinische Psychologie</div>
	 * <div class="fr">psychologie clinique</div>
	 * <div class="it">psicologia clinica</div>
	 * <!-- @formatter:on -->
	 */
	CLINICAL_PSYCHOLOGY("1056", "2.16.756.5.30.1.127.3.5", "Clinical psychology",
			"Clinical psychology", "Klinische Psychologie", "psychologie clinique",
			"psicologia clinica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Community pharmacy</div>
	 * <div class="de">Offizinpharmazie</div>
	 * <div class="fr">Pharmacie d’officine</div>
	 * <div class="it">Farmacia d’officina</div>
	 * <!-- @formatter:on -->
	 */
	COMMUNITY_PHARMACY("1052", "2.16.756.5.30.1.127.3.5", "Community pharmacy",
			"Community pharmacy", "Offizinpharmazie", "Pharmacie d’officine",
			"Farmacia d’officina"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dermatology and venereology</div>
	 * <div class="de">Dermatologie und Venerologie</div>
	 * <div class="fr">Dermatologie et vénéréologie</div>
	 * <div class="it">Dermatologia e venereologia</div>
	 * <!-- @formatter:on -->
	 */
	DERMATOLOGY_AND_VENEREOLOGY("1021", "2.16.756.5.30.1.127.3.5", "Dermatology and venereology",
			"Dermatology and venereology", "Dermatologie und Venerologie",
			"Dermatologie et vénéréologie", "Dermatologia e venereologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Endocrinology – Diabetology</div>
	 * <div class="de">Endokrinologie-Diabetologie</div>
	 * <div class="fr">Endocrinologie-diabétologie</div>
	 * <div class="it">Endocrinologia e diabetologia</div>
	 * <!-- @formatter:on -->
	 */
	ENDOCRINOLOGY_DIABETOLOGY("1022", "2.16.756.5.30.1.127.3.5", "Endocrinology – Diabetology",
			"Endocrinology – Diabetology", "Endokrinologie-Diabetologie",
			"Endocrinologie-diabétologie", "Endocrinologia e diabetologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Forensic medicine</div>
	 * <div class="de">Rechtsmedizin</div>
	 * <div class="fr">Médecine légale</div>
	 * <div class="it">Medicina legale</div>
	 * <!-- @formatter:on -->
	 */
	FORENSIC_MEDICINE("1046", "2.16.756.5.30.1.127.3.5", "Forensic medicine", "Forensic medicine",
			"Rechtsmedizin", "Médecine légale", "Medicina legale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gastroenterology</div>
	 * <div class="de">Gastroenterologie</div>
	 * <div class="fr">Gastroentérologie</div>
	 * <div class="it">Gastroenterologia</div>
	 * <!-- @formatter:on -->
	 */
	GASTROENTEROLOGY("1023", "2.16.756.5.30.1.127.3.5", "Gastroenterology", "Gastroenterology",
			"Gastroenterologie", "Gastroentérologie", "Gastroenterologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">General internal medicine</div>
	 * <div class="de">Allgemeine Innere Medizin</div>
	 * <div class="fr">Médecine interne générale</div>
	 * <div class="it">Medicina interna generale</div>
	 * <!-- @formatter:on -->
	 */
	GENERAL_INTERNAL_MEDICINE("1051", "2.16.756.5.30.1.127.3.5", "General internal medicine",
			"General internal medicine", "Allgemeine Innere Medizin",
			"Médecine interne générale", "Medicina interna generale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">General medical practitioner</div>
	 * <div class="de">Praktische Ärztin _ Praktischer Arzt</div>
	 * <div class="fr">Médecin praticien</div>
	 * <div class="it">Medico generico</div>
	 * <!-- @formatter:on -->
	 */
	GENERAL_MEDICAL_PRACTITIONER("1040", "2.16.756.5.30.1.127.3.5", "General medical practitioner",
			"General medical practitioner", "Praktische Ärztin _ Praktischer Arzt",
			"Médecin praticien", "Medico generico"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gynaecology and obstetrics</div>
	 * <div class="de">Gynäkologie und Geburtshilfe</div>
	 * <div class="fr">Gynécologie et obstétrique</div>
	 * <div class="it">Ginecologia e ostetricia</div>
	 * <!-- @formatter:on -->
	 */
	GYNAECOLOGY_AND_OBSTETRICS("1003", "2.16.756.5.30.1.127.3.5", "Gynaecology and obstetrics",
			"Gynaecology and obstetrics", "Gynäkologie und Geburtshilfe",
			"Gynécologie et obstétrique", "Ginecologia e ostetricia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Haematology</div>
	 * <div class="de">Hämatologie</div>
	 * <div class="fr">Hématologie</div>
	 * <div class="it">Ematologia</div>
	 * <!-- @formatter:on -->
	 */
	HAEMATOLOGY("1024", "2.16.756.5.30.1.127.3.5", "Haematology", "Haematology", "Hämatologie",
			"Hématologie", "Ematologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Hand surgery</div>
	 * <div class="de">Handchirurgie</div>
	 * <div class="fr">Chirurgie de la main</div>
	 * <div class="it">Chirurgia della mano</div>
	 * <!-- @formatter:on -->
	 */
	HAND_SURGERY("1059", "2.16.756.5.30.1.127.3.5", "Hand surgery", "Hand surgery", "Handchirurgie",
			"Chirurgie de la main", "Chirurgia della mano"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Health psychology</div>
	 * <div class="de">Gesundheitspsychologie</div>
	 * <div class="fr">psychologie de la santé</div>
	 * <div class="it">psicologia della salute</div>
	 * <!-- @formatter:on -->
	 */
	HEALTH_PSYCHOLOGY("1058", "2.16.756.5.30.1.127.3.5", "Health psychology", "Health psychology",
			"Gesundheitspsychologie", "psychologie de la santé", "psicologia della salute"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Hospital pharmacy</div>
	 * <div class="de">Spitalpharmazie</div>
	 * <div class="fr">Pharmacie hospitalière</div>
	 * <div class="it">Farmacia d’ospedale</div>
	 * <!-- @formatter:on -->
	 */
	HOSPITAL_PHARMACY("1053", "2.16.756.5.30.1.127.3.5", "Hospital pharmacy", "Hospital pharmacy",
			"Spitalpharmazie", "Pharmacie hospitalière", "Farmacia d’ospedale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Infectology</div>
	 * <div class="de">Infektiologie</div>
	 * <div class="fr">Infectiologie</div>
	 * <div class="it">Malattie infettive</div>
	 * <!-- @formatter:on -->
	 */
	INFECTOLOGY("1039", "2.16.756.5.30.1.127.3.5", "Infectology", "Infectology", "Infektiologie",
			"Infectiologie", "Malattie infettive"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intensive care medicine</div>
	 * <div class="de">Intensivmedizin</div>
	 * <div class="fr">Médecine intensive</div>
	 * <div class="it">Medicina intensiva</div>
	 * <!-- @formatter:on -->
	 */
	INTENSIVE_CARE_MEDICINE("1042", "2.16.756.5.30.1.127.3.5", "Intensive care medicine",
			"Intensive care medicine", "Intensivmedizin", "Médecine intensive",
			"Medicina intensiva"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Medical genetics</div>
	 * <div class="de">Medizinische Genetik</div>
	 * <div class="fr">Génétique médicale</div>
	 * <div class="it">Genetica medica</div>
	 * <!-- @formatter:on -->
	 */
	MEDICAL_GENETICS("1043", "2.16.756.5.30.1.127.3.5", "Medical genetics", "Medical genetics",
			"Medizinische Genetik", "Génétique médicale", "Genetica medica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Medical oncology</div>
	 * <div class="de">Medizinische Onkologie</div>
	 * <div class="fr">Oncologie médicale</div>
	 * <div class="it">Oncologia medica</div>
	 * <!-- @formatter:on -->
	 */
	MEDICAL_ONCOLOGY("1044", "2.16.756.5.30.1.127.3.5", "Medical oncology", "Medical oncology",
			"Medizinische Onkologie", "Oncologie médicale", "Oncologia medica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nephrology</div>
	 * <div class="de">Nephrologie</div>
	 * <div class="fr">Néphrologie</div>
	 * <div class="it">Nefrologia</div>
	 * <!-- @formatter:on -->
	 */
	NEPHROLOGY("1033", "2.16.756.5.30.1.127.3.5", "Nephrology", "Nephrology", "Nephrologie",
			"Néphrologie", "Nefrologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Neurology</div>
	 * <div class="de">Neurologie</div>
	 * <div class="fr">Neurologie</div>
	 * <div class="it">Neurologia</div>
	 * <!-- @formatter:on -->
	 */
	NEUROLOGY("1014", "2.16.756.5.30.1.127.3.5", "Neurology", "Neurology", "Neurologie",
			"Neurologie", "Neurologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Neuropsychology</div>
	 * <div class="de">Neuropsychologie</div>
	 * <div class="fr">neuropsychologie</div>
	 * <div class="it">neuropsicologia</div>
	 * <!-- @formatter:on -->
	 */
	NEUROPSYCHOLOGY("1057", "2.16.756.5.30.1.127.3.5", "Neuropsychology", "Neuropsychology",
			"Neuropsychologie", "neuropsychologie", "neuropsicologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Neurosurgery</div>
	 * <div class="de">Neurochirurgie</div>
	 * <div class="fr">Neurochirurgie</div>
	 * <div class="it">Neurochirurgia</div>
	 * <!-- @formatter:on -->
	 */
	NEUROSURGERY("1013", "2.16.756.5.30.1.127.3.5", "Neurosurgery", "Neurosurgery",
			"Neurochirurgie", "Neurochirurgie", "Neurochirurgia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nuclear medicine</div>
	 * <div class="de">Nuklearmedizin</div>
	 * <div class="fr">Médecine nucléaire</div>
	 * <div class="it">Medicina nucleare</div>
	 * <!-- @formatter:on -->
	 */
	NUCLEAR_MEDICINE("1031", "2.16.756.5.30.1.127.3.5", "Nuclear medicine", "Nuclear medicine",
			"Nuklearmedizin", "Médecine nucléaire", "Medicina nucleare"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Occupational medicine</div>
	 * <div class="de">Arbeitsmedizin</div>
	 * <div class="fr">Médecine du travail</div>
	 * <div class="it">Medicina del lavoro</div>
	 * <!-- @formatter:on -->
	 */
	OCCUPATIONAL_MEDICINE("1020", "2.16.756.5.30.1.127.3.5", "Occupational medicine",
			"Occupational medicine", "Arbeitsmedizin", "Médecine du travail",
			"Medicina del lavoro"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ophthalmology</div>
	 * <div class="de">Ophthalmologie</div>
	 * <div class="fr">Ophtalmologie</div>
	 * <div class="it">Oftalmologia</div>
	 * <!-- @formatter:on -->
	 */
	OPHTHALMOLOGY("1007", "2.16.756.5.30.1.127.3.5", "Ophthalmology", "Ophthalmology",
			"Ophthalmologie", "Ophtalmologie", "Oftalmologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oral and maxillofacial surgery</div>
	 * <div class="de">Mund-, Kiefer- und Gesichtschirurgie</div>
	 * <div class="fr">Chirurgie orale et maxillo-faciale</div>
	 * <div class="it">Chirurgia oro-maxillo-facciale</div>
	 * <!-- @formatter:on -->
	 */
	ORAL_AND_MAXILLOFACIAL_SURGERY("1026", "2.16.756.5.30.1.127.3.5",
			"Oral and maxillofacial surgery", "Oral and maxillofacial surgery",
			"Mund-, Kiefer- und Gesichtschirurgie", "Chirurgie orale et maxillo-faciale",
			"Chirurgia oro-maxillo-facciale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oral surgery</div>
	 * <div class="de">Oralchirurgie</div>
	 * <div class="fr">Chirurgie orale</div>
	 * <div class="it">Chirurgia orale</div>
	 * <!-- @formatter:on -->
	 */
	ORAL_SURGERY("1047", "2.16.756.5.30.1.127.3.5", "Oral surgery", "Oral surgery", "Oralchirurgie",
			"Chirurgie orale", "Chirurgia orale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Orthodontics</div>
	 * <div class="de">Kieferorthopädie</div>
	 * <div class="fr">Orthodontie</div>
	 * <div class="it">Ortodonzia</div>
	 * <!-- @formatter:on -->
	 */
	ORTHODONTICS("1010", "2.16.756.5.30.1.127.3.5", "Orthodontics", "Orthodontics",
			"Kieferorthopädie", "Orthodontie", "Ortodonzia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Orthopaedic surgery and traumatology of the locomotor apparatus</div>
	 * <div class="de">Orthopädische Chirurgie und Traumatologie des Bewegungsapparates</div>
	 * <div class="fr">Chirurgie orthopédique et traumatologie de l’appareil locomoteur</div>
	 * <div class="it">Chirurgia ortopedica e traumatologia dell’apparato locomotore</div>
	 * <!-- @formatter:on -->
	 */
	ORTHOPAEDIC_SURGERY_AND_TRAUMATOLOGY_OF_THE_LOCOMOTOR_APPARATUS("1015",
			"2.16.756.5.30.1.127.3.5",
			"Orthopaedic surgery and traumatology of the locomotor apparatus",
			"Orthopaedic surgery and traumatology of the locomotor apparatus",
			"Orthopädische Chirurgie und Traumatologie des Bewegungsapparates",
			"Chirurgie orthopédique et traumatologie de l’appareil locomoteur",
			"Chirurgia ortopedica e traumatologia dell’apparato locomotore"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Other</div>
	 * <div class="de">Andere</div>
	 * <div class="fr">Autre</div>
	 * <div class="it">Altre</div>
	 * <!-- @formatter:on -->
	 */
	OTHER("1050", "2.16.756.5.30.1.127.3.5", "Other", "Other", "Andere", "Autre", "Altre"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Otorhinolaryngology</div>
	 * <div class="de">Oto-Rhino-Laryngologie</div>
	 * <div class="fr">Oto-rhino-laryngologie</div>
	 * <div class="it">Otorinolaringoiatria</div>
	 * <!-- @formatter:on -->
	 */
	OTORHINOLARYNGOLOGY("1008", "2.16.756.5.30.1.127.3.5", "Otorhinolaryngology",
			"Otorhinolaryngology", "Oto-Rhino-Laryngologie", "Oto-rhino-laryngologie",
			"Otorinolaringoiatria"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Paediatrics</div>
	 * <div class="de">Kinder- und Jugendmedizin</div>
	 * <div class="fr">Pédiatrie</div>
	 * <div class="it">Pediatria</div>
	 * <!-- @formatter:on -->
	 */
	PAEDIATRICS("1006", "2.16.756.5.30.1.127.3.5", "Paediatrics", "Paediatrics",
			"Kinder- und Jugendmedizin", "Pédiatrie", "Pediatria"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Paediatric surgery</div>
	 * <div class="de">Kinderchirurgie</div>
	 * <div class="fr">Chirurgie pédiatrique</div>
	 * <div class="it">Chirurgia pediatrica</div>
	 * <!-- @formatter:on -->
	 */
	PAEDIATRIC_SURGERY("1028", "2.16.756.5.30.1.127.3.5", "Paediatric surgery",
			"Paediatric surgery", "Kinderchirurgie", "Chirurgie pédiatrique",
			"Chirurgia pediatrica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Paradontology</div>
	 * <div class="de">Parodontologie</div>
	 * <div class="fr">Parodontologie</div>
	 * <div class="it">Parodontologia</div>
	 * <!-- @formatter:on -->
	 */
	PARADONTOLOGY("1048", "2.16.756.5.30.1.127.3.5", "Paradontology", "Paradontology",
			"Parodontologie", "Parodontologie", "Parodontologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pathology</div>
	 * <div class="de">Pathologie</div>
	 * <div class="fr">Pathologie</div>
	 * <div class="it">Patologia</div>
	 * <!-- @formatter:on -->
	 */
	PATHOLOGY("1009", "2.16.756.5.30.1.127.3.5", "Pathology", "Pathology", "Pathologie",
			"Pathologie", "Patologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pharmaceutical medicine</div>
	 * <div class="de">Pharmazeutische Medizin</div>
	 * <div class="fr">Médecine pharmaceutique</div>
	 * <div class="it">Medicina farmacologica</div>
	 * <!-- @formatter:on -->
	 */
	PHARMACEUTICAL_MEDICINE("1045", "2.16.756.5.30.1.127.3.5", "Pharmaceutical medicine",
			"Pharmaceutical medicine", "Pharmazeutische Medizin", "Médecine pharmaceutique",
			"Medicina farmacologica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Physical medicine and rehabilitation</div>
	 * <div class="de">Physikalische Medizin und Rehabilitation</div>
	 * <div class="fr">Médecine physique et réadaptation</div>
	 * <div class="it">Medicina fisica e riabilitazione</div>
	 * <!-- @formatter:on -->
	 */
	PHYSICAL_MEDICINE_AND_REHABILITATION("1034", "2.16.756.5.30.1.127.3.5",
			"Physical medicine and rehabilitation", "Physical medicine and rehabilitation",
			"Physikalische Medizin und Rehabilitation", "Médecine physique et réadaptation",
			"Medicina fisica e riabilitazione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Plastic, reconstructive and aesthetic surgery</div>
	 * <div class="de">Plastische, Rekonstruktive und Ästhetische Chirurgie</div>
	 * <div class="fr">Chirurgie plastique, reconstructive et esthétique</div>
	 * <div class="it">Chirurgia plastica, ricostruttiva ed estetica</div>
	 * <!-- @formatter:on -->
	 */
	PLASTIC_RECONSTRUCTIVE_AND_AESTHETIC_SURGERY("1035", "2.16.756.5.30.1.127.3.5",
			"Plastic, reconstructive and aesthetic surgery",
			"Plastic, reconstructive and aesthetic surgery",
			"Plastische, Rekonstruktive und Ästhetische Chirurgie",
			"Chirurgie plastique, reconstructive et esthétique",
			"Chirurgia plastica, ricostruttiva ed estetica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pneumology</div>
	 * <div class="de">Pneumologie</div>
	 * <div class="fr">Pneumologie</div>
	 * <div class="it">Pneumologia</div>
	 * <!-- @formatter:on -->
	 */
	PNEUMOLOGY("1016", "2.16.756.5.30.1.127.3.5", "Pneumology", "Pneumology", "Pneumologie",
			"Pneumologie", "Pneumologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Prevention and public health</div>
	 * <div class="de">Prävention und Gesundheitswesen</div>
	 * <div class="fr">Prévention et santé publique</div>
	 * <div class="it">Prevenzione e salute pubblica</div>
	 * <!-- @formatter:on -->
	 */
	PREVENTION_AND_PUBLIC_HEALTH("1036", "2.16.756.5.30.1.127.3.5", "Prevention and public health",
			"Prevention and public health", "Prävention und Gesundheitswesen",
			"Prévention et santé publique", "Prevenzione e salute pubblica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Psychiatry and psychotherapy</div>
	 * <div class="de">Psychiatrie und Psychotherapie</div>
	 * <div class="fr">Psychiatrie et psychothérapie</div>
	 * <div class="it">Psichiatria e psicoterapia</div>
	 * <!-- @formatter:on -->
	 */
	PSYCHIATRY_AND_PSYCHOTHERAPY("1017", "2.16.756.5.30.1.127.3.5", "Psychiatry and psychotherapy",
			"Psychiatry and psychotherapy", "Psychiatrie und Psychotherapie",
			"Psychiatrie et psychothérapie", "Psichiatria e psicoterapia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Psychotherapy</div>
	 * <div class="de">Psychotherapie</div>
	 * <div class="fr">psychothérapie</div>
	 * <div class="it">psicoterapia</div>
	 * <!-- @formatter:on -->
	 */
	PSYCHOTHERAPY("1054", "2.16.756.5.30.1.127.3.5", "Psychotherapy", "Psychotherapy",
			"Psychotherapie", "psychothérapie", "psicoterapia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Radiology</div>
	 * <div class="de">Radiologie</div>
	 * <div class="fr">Radiologie</div>
	 * <div class="it">Radiologia</div>
	 * <!-- @formatter:on -->
	 */
	RADIOLOGY("1030", "2.16.756.5.30.1.127.3.5", "Radiology", "Radiology", "Radiologie",
			"Radiologie", "Radiologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Radio-oncology / radiotherapy</div>
	 * <div class="de">Radio-Onkologie_Strahlentherapie</div>
	 * <div class="fr">Radio-oncologie_radiothérapie</div>
	 * <div class="it">Radio-oncologia_radioterapia</div>
	 * <!-- @formatter:on -->
	 */
	RADIO_ONCOLOGY_RADIOTHERAPY("1032", "2.16.756.5.30.1.127.3.5", "Radio-oncology / radiotherapy",
			"Radio-oncology / radiotherapy", "Radio-Onkologie_Strahlentherapie",
			"Radio-oncologie_radiothérapie", "Radio-oncologia_radioterapia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Reconstructive dentistry</div>
	 * <div class="de">Rekonstruktive Zahnmedizin</div>
	 * <div class="fr">Médecine dentaire reconstructive</div>
	 * <div class="it">Medicina dentaria riconstruttiva</div>
	 * <!-- @formatter:on -->
	 */
	RECONSTRUCTIVE_DENTISTRY("1049", "2.16.756.5.30.1.127.3.5", "Reconstructive dentistry",
			"Reconstructive dentistry", "Rekonstruktive Zahnmedizin",
			"Médecine dentaire reconstructive", "Medicina dentaria riconstruttiva"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rheumatology</div>
	 * <div class="de">Rheumatologie</div>
	 * <div class="fr">Rhumatologie</div>
	 * <div class="it">Reumatologia</div>
	 * <!-- @formatter:on -->
	 */
	RHEUMATOLOGY("1037", "2.16.756.5.30.1.127.3.5", "Rheumatology", "Rheumatology", "Rheumatologie",
			"Rhumatologie", "Reumatologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Surgery</div>
	 * <div class="de">Chirurgie</div>
	 * <div class="fr">Chirurgie</div>
	 * <div class="it">Chirurgia</div>
	 * <!-- @formatter:on -->
	 */
	SURGERY("1002", "2.16.756.5.30.1.127.3.5", "Surgery", "Surgery", "Chirurgie", "Chirurgie",
			"Chirurgia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Thoracic surgery</div>
	 * <div class="de">Thoraxchirurgie</div>
	 * <div class="fr">Chirurgie thoracique</div>
	 * <div class="it">Chirurgia toracica</div>
	 * <!-- @formatter:on -->
	 */
	THORACIC_SURGERY("1061", "2.16.756.5.30.1.127.3.5", "Thoracic surgery", "Thoracic surgery",
			"Thoraxchirurgie", "Chirurgie thoracique", "Chirurgia toracica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Tropical and travel medicine</div>
	 * <div class="de">Tropen- und Reisemedizin</div>
	 * <div class="fr">Médecine tropicale et médecine des voyages</div>
	 * <div class="it">Medicina tropicale e medicina di viaggio</div>
	 * <!-- @formatter:on -->
	 */
	TROPICAL_AND_TRAVEL_MEDICINE("1038", "2.16.756.5.30.1.127.3.5", "Tropical and travel medicine",
			"Tropical and travel medicine", "Tropen- und Reisemedizin",
			"Médecine tropicale et médecine des voyages",
			"Medicina tropicale e medicina di viaggio"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Urology</div>
	 * <div class="de">Urologie</div>
	 * <div class="fr">Urologie</div>
	 * <div class="it">Urologia</div>
	 * <!-- @formatter:on -->
	 */
	UROLOGY("1018", "2.16.756.5.30.1.127.3.5", "Urology", "Urology", "Urologie", "Urologie",
			"Urologia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Vascular surgery</div>
	 * <div class="de">Gefässchirurgie</div>
	 * <div class="fr">Chirurgie vasculaire</div>
	 * <div class="it">Chirurgia vascolare</div>
	 * <!-- @formatter:on -->
	 */
	VASCULAR_SURGERY("1060", "2.16.756.5.30.1.127.3.5", "Vascular surgery", "Vascular surgery",
			"Gefässchirurgie", "Chirurgie vasculaire", "Chirurgia vascolare");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Allergology and clinical immunology</div>
	 * <div class="de">Code für Allergologie und klinische Immunologie</div>
	 * <div class="fr">Code de Allergologie et immunologie clinique</div>
	 * <div class="it">Code per Allergologia e immunologia clinica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ALLERGOLOGY_AND_CLINICAL_IMMUNOLOGY_CODE = "1019";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Anaesthesiology</div>
	 * <div class="de">Code für Anästhesiologie</div>
	 * <div class="fr">Code de Anesthésiologie</div>
	 * <div class="it">Code per Anestesiologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ANAESTHESIOLOGY_CODE = "1012";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Angiology</div>
	 * <div class="de">Code für Angiologie</div>
	 * <div class="fr">Code de Angiologie</div>
	 * <div class="it">Code per Angiologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ANGIOLOGY_CODE = "1041";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cardiac and thoracic vascular surgery</div>
	 * <div class="de">Code für Herz- und thorakale Gefässchirurgie</div>
	 * <div class="fr">Code de Chirurgie cardiaque et vasculaire thoracique</div>
	 * <div class="it">Code per Chirurgia del cuore e dei vasi toracici</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CARDIAC_AND_THORACIC_VASCULAR_SURGERY_CODE = "1004";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cardiology</div>
	 * <div class="de">Code für Kardiologie</div>
	 * <div class="fr">Code de Cardiologie</div>
	 * <div class="it">Code per Cardiologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CARDIOLOGY_CODE = "1025";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Child and adolescent psychiatry and psychotherapy</div>
	 * <div class="de">Code für Kinder- und Jugendpsychiatrie und -psychotherapie</div>
	 * <div class="fr">Code de Psychiatrie et psychothérapie d’enfants et d’adolescents</div>
	 * <div class="it">Code per Psichiatria e psicoterapia infantile e dell’adolescenza</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHILD_AND_ADOLESCENT_PSYCHIATRY_AND_PSYCHOTHERAPY_CODE = "1027";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Child and adolescent psychology</div>
	 * <div class="de">Code für Kinder- und Jugendpsychologie</div>
	 * <div class="fr">Code de psychologie des enfants et des adolescents</div>
	 * <div class="it">Code per psicologia dell’età evolutiva</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHILD_AND_ADOLESCENT_PSYCHOLOGY_CODE = "1055";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Chiropractic specialist</div>
	 * <div class="de">Code für Fachchiropraktik</div>
	 * <div class="fr">Code de Chiropratique spécialisée</div>
	 * <div class="it">Code per Chiropratica specialistica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHIROPRACTIC_SPECIALIST_CODE = "1011";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Clinical pharmacology and toxicology</div>
	 * <div class="de">Code für Klinische Pharmakologie und Toxikologie</div>
	 * <div class="fr">Code de Pharmacologie et toxicologie cliniques</div>
	 * <div class="it">Code per Farmacologia e tossicologia cliniche</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CLINICAL_PHARMACOLOGY_AND_TOXICOLOGY_CODE = "1029";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Clinical psychology</div>
	 * <div class="de">Code für Klinische Psychologie</div>
	 * <div class="fr">Code de psychologie clinique</div>
	 * <div class="it">Code per psicologia clinica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CLINICAL_PSYCHOLOGY_CODE = "1056";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Community pharmacy</div>
	 * <div class="de">Code für Offizinpharmazie</div>
	 * <div class="fr">Code de Pharmacie d’officine</div>
	 * <div class="it">Code per Farmacia d’officina</div>
	 * <!-- @formatter:on -->
	 */
	public static final String COMMUNITY_PHARMACY_CODE = "1052";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dermatology and venereology</div>
	 * <div class="de">Code für Dermatologie und Venerologie</div>
	 * <div class="fr">Code de Dermatologie et vénéréologie</div>
	 * <div class="it">Code per Dermatologia e venereologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DERMATOLOGY_AND_VENEREOLOGY_CODE = "1021";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Endocrinology – Diabetology</div>
	 * <div class="de">Code für Endokrinologie-Diabetologie</div>
	 * <div class="fr">Code de Endocrinologie-diabétologie</div>
	 * <div class="it">Code per Endocrinologia e diabetologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENDOCRINOLOGY_DIABETOLOGY_CODE = "1022";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Forensic medicine</div>
	 * <div class="de">Code für Rechtsmedizin</div>
	 * <div class="fr">Code de Médecine légale</div>
	 * <div class="it">Code per Medicina legale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FORENSIC_MEDICINE_CODE = "1046";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gastroenterology</div>
	 * <div class="de">Code für Gastroenterologie</div>
	 * <div class="fr">Code de Gastroentérologie</div>
	 * <div class="it">Code per Gastroenterologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GASTROENTEROLOGY_CODE = "1023";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for General internal medicine</div>
	 * <div class="de">Code für Allgemeine Innere Medizin</div>
	 * <div class="fr">Code de Médecine interne générale</div>
	 * <div class="it">Code per Medicina interna generale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GENERAL_INTERNAL_MEDICINE_CODE = "1051";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for General medical practitioner</div>
	 * <div class="de">Code für Praktische Ärztin _ Praktischer Arzt</div>
	 * <div class="fr">Code de Médecin praticien</div>
	 * <div class="it">Code per Medico generico</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GENERAL_MEDICAL_PRACTITIONER_CODE = "1040";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gynaecology and obstetrics</div>
	 * <div class="de">Code für Gynäkologie und Geburtshilfe</div>
	 * <div class="fr">Code de Gynécologie et obstétrique</div>
	 * <div class="it">Code per Ginecologia e ostetricia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GYNAECOLOGY_AND_OBSTETRICS_CODE = "1003";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Haematology</div>
	 * <div class="de">Code für Hämatologie</div>
	 * <div class="fr">Code de Hématologie</div>
	 * <div class="it">Code per Ematologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HAEMATOLOGY_CODE = "1024";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Hand surgery</div>
	 * <div class="de">Code für Handchirurgie</div>
	 * <div class="fr">Code de Chirurgie de la main</div>
	 * <div class="it">Code per Chirurgia della mano</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HAND_SURGERY_CODE = "1059";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Health psychology</div>
	 * <div class="de">Code für Gesundheitspsychologie</div>
	 * <div class="fr">Code de psychologie de la santé</div>
	 * <div class="it">Code per psicologia della salute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HEALTH_PSYCHOLOGY_CODE = "1058";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Hospital pharmacy</div>
	 * <div class="de">Code für Spitalpharmazie</div>
	 * <div class="fr">Code de Pharmacie hospitalière</div>
	 * <div class="it">Code per Farmacia d’ospedale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HOSPITAL_PHARMACY_CODE = "1053";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Infectology</div>
	 * <div class="de">Code für Infektiologie</div>
	 * <div class="fr">Code de Infectiologie</div>
	 * <div class="it">Code per Malattie infettive</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INFECTOLOGY_CODE = "1039";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intensive care medicine</div>
	 * <div class="de">Code für Intensivmedizin</div>
	 * <div class="fr">Code de Médecine intensive</div>
	 * <div class="it">Code per Medicina intensiva</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTENSIVE_CARE_MEDICINE_CODE = "1042";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Medical genetics</div>
	 * <div class="de">Code für Medizinische Genetik</div>
	 * <div class="fr">Code de Génétique médicale</div>
	 * <div class="it">Code per Genetica medica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MEDICAL_GENETICS_CODE = "1043";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Medical oncology</div>
	 * <div class="de">Code für Medizinische Onkologie</div>
	 * <div class="fr">Code de Oncologie médicale</div>
	 * <div class="it">Code per Oncologia medica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MEDICAL_ONCOLOGY_CODE = "1044";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nephrology</div>
	 * <div class="de">Code für Nephrologie</div>
	 * <div class="fr">Code de Néphrologie</div>
	 * <div class="it">Code per Nefrologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEPHROLOGY_CODE = "1033";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Neurology</div>
	 * <div class="de">Code für Neurologie</div>
	 * <div class="fr">Code de Neurologie</div>
	 * <div class="it">Code per Neurologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEUROLOGY_CODE = "1014";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Neuropsychology</div>
	 * <div class="de">Code für Neuropsychologie</div>
	 * <div class="fr">Code de neuropsychologie</div>
	 * <div class="it">Code per neuropsicologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEUROPSYCHOLOGY_CODE = "1057";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Neurosurgery</div>
	 * <div class="de">Code für Neurochirurgie</div>
	 * <div class="fr">Code de Neurochirurgie</div>
	 * <div class="it">Code per Neurochirurgia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEUROSURGERY_CODE = "1013";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nuclear medicine</div>
	 * <div class="de">Code für Nuklearmedizin</div>
	 * <div class="fr">Code de Médecine nucléaire</div>
	 * <div class="it">Code per Medicina nucleare</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NUCLEAR_MEDICINE_CODE = "1031";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Occupational medicine</div>
	 * <div class="de">Code für Arbeitsmedizin</div>
	 * <div class="fr">Code de Médecine du travail</div>
	 * <div class="it">Code per Medicina del lavoro</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OCCUPATIONAL_MEDICINE_CODE = "1020";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ophthalmology</div>
	 * <div class="de">Code für Ophthalmologie</div>
	 * <div class="fr">Code de Ophtalmologie</div>
	 * <div class="it">Code per Oftalmologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OPHTHALMOLOGY_CODE = "1007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oral and maxillofacial surgery</div>
	 * <div class="de">Code für Mund-, Kiefer- und Gesichtschirurgie</div>
	 * <div class="fr">Code de Chirurgie orale et maxillo-faciale</div>
	 * <div class="it">Code per Chirurgia oro-maxillo-facciale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORAL_AND_MAXILLOFACIAL_SURGERY_CODE = "1026";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oral surgery</div>
	 * <div class="de">Code für Oralchirurgie</div>
	 * <div class="fr">Code de Chirurgie orale</div>
	 * <div class="it">Code per Chirurgia orale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORAL_SURGERY_CODE = "1047";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Orthodontics</div>
	 * <div class="de">Code für Kieferorthopädie</div>
	 * <div class="fr">Code de Orthodontie</div>
	 * <div class="it">Code per Ortodonzia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORTHODONTICS_CODE = "1010";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Orthopaedic surgery and traumatology of the locomotor apparatus</div>
	 * <div class="de">Code für Orthopädische Chirurgie und Traumatologie des Bewegungsapparates</div>
	 * <div class="fr">Code de Chirurgie orthopédique et traumatologie de l’appareil locomoteur</div>
	 * <div class="it">Code per Chirurgia ortopedica e traumatologia dell’apparato locomotore</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORTHOPAEDIC_SURGERY_AND_TRAUMATOLOGY_OF_THE_LOCOMOTOR_APPARATUS_CODE = "1015";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Other</div>
	 * <div class="de">Code für Andere</div>
	 * <div class="fr">Code de Autre</div>
	 * <div class="it">Code per Altre</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OTHER_CODE = "1050";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Otorhinolaryngology</div>
	 * <div class="de">Code für Oto-Rhino-Laryngologie</div>
	 * <div class="fr">Code de Oto-rhino-laryngologie</div>
	 * <div class="it">Code per Otorinolaringoiatria</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OTORHINOLARYNGOLOGY_CODE = "1008";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Paediatrics</div>
	 * <div class="de">Code für Kinder- und Jugendmedizin</div>
	 * <div class="fr">Code de Pédiatrie</div>
	 * <div class="it">Code per Pediatria</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PAEDIATRICS_CODE = "1006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Paediatric surgery</div>
	 * <div class="de">Code für Kinderchirurgie</div>
	 * <div class="fr">Code de Chirurgie pédiatrique</div>
	 * <div class="it">Code per Chirurgia pediatrica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PAEDIATRIC_SURGERY_CODE = "1028";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Paradontology</div>
	 * <div class="de">Code für Parodontologie</div>
	 * <div class="fr">Code de Parodontologie</div>
	 * <div class="it">Code per Parodontologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PARADONTOLOGY_CODE = "1048";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pathology</div>
	 * <div class="de">Code für Pathologie</div>
	 * <div class="fr">Code de Pathologie</div>
	 * <div class="it">Code per Patologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PATHOLOGY_CODE = "1009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pharmaceutical medicine</div>
	 * <div class="de">Code für Pharmazeutische Medizin</div>
	 * <div class="fr">Code de Médecine pharmaceutique</div>
	 * <div class="it">Code per Medicina farmacologica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PHARMACEUTICAL_MEDICINE_CODE = "1045";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Physical medicine and rehabilitation</div>
	 * <div class="de">Code für Physikalische Medizin und Rehabilitation</div>
	 * <div class="fr">Code de Médecine physique et réadaptation</div>
	 * <div class="it">Code per Medicina fisica e riabilitazione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PHYSICAL_MEDICINE_AND_REHABILITATION_CODE = "1034";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Plastic, reconstructive and aesthetic surgery</div>
	 * <div class="de">Code für Plastische, Rekonstruktive und Ästhetische Chirurgie</div>
	 * <div class="fr">Code de Chirurgie plastique, reconstructive et esthétique</div>
	 * <div class="it">Code per Chirurgia plastica, ricostruttiva ed estetica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PLASTIC_RECONSTRUCTIVE_AND_AESTHETIC_SURGERY_CODE = "1035";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pneumology</div>
	 * <div class="de">Code für Pneumologie</div>
	 * <div class="fr">Code de Pneumologie</div>
	 * <div class="it">Code per Pneumologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PNEUMOLOGY_CODE = "1016";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Prevention and public health</div>
	 * <div class="de">Code für Prävention und Gesundheitswesen</div>
	 * <div class="fr">Code de Prévention et santé publique</div>
	 * <div class="it">Code per Prevenzione e salute pubblica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PREVENTION_AND_PUBLIC_HEALTH_CODE = "1036";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Psychiatry and psychotherapy</div>
	 * <div class="de">Code für Psychiatrie und Psychotherapie</div>
	 * <div class="fr">Code de Psychiatrie et psychothérapie</div>
	 * <div class="it">Code per Psichiatria e psicoterapia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PSYCHIATRY_AND_PSYCHOTHERAPY_CODE = "1017";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Psychotherapy</div>
	 * <div class="de">Code für Psychotherapie</div>
	 * <div class="fr">Code de psychothérapie</div>
	 * <div class="it">Code per psicoterapia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PSYCHOTHERAPY_CODE = "1054";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Radiology</div>
	 * <div class="de">Code für Radiologie</div>
	 * <div class="fr">Code de Radiologie</div>
	 * <div class="it">Code per Radiologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RADIOLOGY_CODE = "1030";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Radio-oncology / radiotherapy</div>
	 * <div class="de">Code für Radio-Onkologie_Strahlentherapie</div>
	 * <div class="fr">Code de Radio-oncologie_radiothérapie</div>
	 * <div class="it">Code per Radio-oncologia_radioterapia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RADIO_ONCOLOGY_RADIOTHERAPY_CODE = "1032";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Reconstructive dentistry</div>
	 * <div class="de">Code für Rekonstruktive Zahnmedizin</div>
	 * <div class="fr">Code de Médecine dentaire reconstructive</div>
	 * <div class="it">Code per Medicina dentaria riconstruttiva</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RECONSTRUCTIVE_DENTISTRY_CODE = "1049";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Rheumatology</div>
	 * <div class="de">Code für Rheumatologie</div>
	 * <div class="fr">Code de Rhumatologie</div>
	 * <div class="it">Code per Reumatologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RHEUMATOLOGY_CODE = "1037";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Surgery</div>
	 * <div class="de">Code für Chirurgie</div>
	 * <div class="fr">Code de Chirurgie</div>
	 * <div class="it">Code per Chirurgia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SURGERY_CODE = "1002";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Thoracic surgery</div>
	 * <div class="de">Code für Thoraxchirurgie</div>
	 * <div class="fr">Code de Chirurgie thoracique</div>
	 * <div class="it">Code per Chirurgia toracica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String THORACIC_SURGERY_CODE = "1061";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Tropical and travel medicine</div>
	 * <div class="de">Code für Tropen- und Reisemedizin</div>
	 * <div class="fr">Code de Médecine tropicale et médecine des voyages</div>
	 * <div class="it">Code per Medicina tropicale e medicina di viaggio</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TROPICAL_AND_TRAVEL_MEDICINE_CODE = "1038";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Urology</div>
	 * <div class="de">Code für Urologie</div>
	 * <div class="fr">Code de Urologie</div>
	 * <div class="it">Code per Urologia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String UROLOGY_CODE = "1018";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Vascular surgery</div>
	 * <div class="de">Code für Gefässchirurgie</div>
	 * <div class="fr">Code de Chirurgie vasculaire</div>
	 * <div class="it">Code per Chirurgia vascolare</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VASCULAR_SURGERY_CODE = "1060";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.8.2";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "HCProfessional.hcSpecialisation";

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
	public static HcpSpecialisation getEnum(final String code) {
		for (final HcpSpecialisation x : values()) {
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
			Enum.valueOf(HcpSpecialisation.class, enumName);
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
		for (final HcpSpecialisation x : values()) {
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
	HcpSpecialisation(final String code, final String codeSystem, final String displayName,
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
