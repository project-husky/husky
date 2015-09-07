package org.ehealth_connector.communication.ch.enums;

import java.util.Arrays;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.XdsUtil;
import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;
import org.openhealthtools.ihe.xds.metadata.MetadataFactory;

/*
*<div class="de">Dieses Attribut ist ein beschreibendes Sub-Attribut von author" und dient der Beschreibung der Medizinischen Fachrichtung der Person, welche ein Dokument verfasst hat. Diese Information kann für die Suche und Filterung benutzt werden. Es ist denkbar, dass der Patient mit dieser Information eine Hilfestellung erhält zum Setzen oder Verändern der Vertraulichkeitsstufe von Dokumenten, welche relevant ist für die Zugriffssteuerung. Passende internationale Codes werden in einem nächsten Schritt definiert und können später in den IT-Systemen entsprechend abgeglichen werden.</div>
*<div class="fr"></div>
*/
public enum AuthorSpeciality implements CodedMetadataEnumInterface {

	/** 
	*<div class="de">Fachärztin/Facharzt für Allgemeine Innere Medizin</div>
	*<div class="fr">Médecin spécialiste en médecine interne générale</div>
	*<div class="it">Medico specializzato/a in medicina generale e interna</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_ALLGEMEINE_INNERE_MEDIZIN ("50001", "Fachärztin/Facharzt für Allgemeine Innere Medizin"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Anästhesiologie</div>
	*<div class="fr">Médecin spécialiste en anesthésiologie</div>
	*<div class="it">Medico specializzato/a in anestesiologia</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_ANÄSTHESIOLOGIE ("50002", "Fachärztin/Facharzt für Anästhesiologie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Arbeitsmedizin</div>
	*<div class="fr">Médecin spécialiste en médecine du travail</div>
	*<div class="it">Medico specializzato/a in medicina del lavoro</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_ARBEITSMEDIZIN ("50003", "Fachärztin/Facharzt für Arbeitsmedizin"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Chirurgie</div>
	*<div class="fr">Médecin spécialiste en chirurgie</div>
	*<div class="it">Medico specializzato/a in chirurgia</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_CHIRURGIE ("50004", "Fachärztin/Facharzt für Chirurgie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Dermatologie und Venerologie</div>
	*<div class="fr">Médecin spécialiste en dermatologie et vénéréologie</div>
	*<div class="it">Medico specializzato/a in dermatologia e venereologia</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_DERMATOLOGIE_UND_VENEROLOGIE ("50005", "Fachärztin/Facharzt für Dermatologie und Venerologie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Endokrinologie / Diabetologie</div>
	*<div class="fr">Médecin spécialiste en endocrinologie / diabétologie</div>
	*<div class="it">Medico specializzato/a in endocrinologia / diabetologia</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_ENDOKRINOLOGIE__DIABETOLOGIE ("50006", "Fachärztin/Facharzt für Endokrinologie / Diabetologie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Gastroenterologie</div>
	*<div class="fr">Médecin spécialiste en gastroentérologie</div>
	*<div class="it">Medico specializzato/a in gastroenterologia</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_GASTROENTEROLOGIE ("50007", "Fachärztin/Facharzt für Gastroenterologie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Gynäkologie und Geburtshilfe</div>
	*<div class="fr">Médecin spécialiste en gynécologie et obstétrique</div>
	*<div class="it">Medico specializzato/a in ginecologia e ostetricia</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_GYNÄKOLOGIE_UND_GEBURTSHILFE ("50008", "Fachärztin/Facharzt für Gynäkologie und Geburtshilfe"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Hämatologie</div>
	*<div class="fr">Médecin spécialiste en hématologie</div>
	*<div class="it">Medico specializzato/a in ematologia</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_HÄMATOLOGIE ("50009", "Fachärztin/Facharzt für Hämatologie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Herz- und thorakale Gefässchirurgie</div>
	*<div class="fr">Médecin spécialiste en chirurgie cardio-vasculaire et thoracique</div>
	*<div class="it">Medico specializzato/a in chirurgia toracica e cardiovascolare</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_HERZ__UND_THORAKALE_GEFÄSSCHIRURGIE ("50010", "Fachärztin/Facharzt für Herz- und thorakale Gefässchirurgie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Infektiologie</div>
	*<div class="fr">Médecin spécialiste en infectiologie</div>
	*<div class="it">Medico specializzato/a in infeziologia</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_INFEKTIOLOGIE ("50011", "Fachärztin/Facharzt für Infektiologie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Kardiologie</div>
	*<div class="fr">Médecin spécialiste en cardiologie</div>
	*<div class="it">Medico specializzato/a in cardiologia</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_KARDIOLOGIE ("50012", "Fachärztin/Facharzt für Kardiologie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Kinder- und Jugendmedizin</div>
	*<div class="fr">Médecin spécialiste en pédiatrie</div>
	*<div class="it">Medico specializzato/a in pediatria</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_KINDER__UND_JUGENDMEDIZIN ("50013", "Fachärztin/Facharzt für Kinder- und Jugendmedizin"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Kinder- und Jugendpsychiatrie und -psychotherapie</div>
	*<div class="fr">Médecin spécialiste en pédopsychiatrie et pédopsychothérapie</div>
	*<div class="it">Medico specializzato/a in pedopsichiatria e pedopsicoterapia</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_KINDER__UND_JUGENDPSYCHIATRIE_UND__PSYCHOTHERAPIE ("50014", "Fachärztin/Facharzt für Kinder- und Jugendpsychiatrie und -psychotherapie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Kinderchirurgie</div>
	*<div class="fr">Médecin spécialiste en pédochirurgie</div>
	*<div class="it">Medico specializzato/a in cardiologia pediatrica</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_KINDERCHIRURGIE ("50015", "Fachärztin/Facharzt für Kinderchirurgie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Klinische Pharmakologie und Toxikologie</div>
	*<div class="fr">Médecin spécialiste en pharmacologie clinique et toxicologie</div>
	*<div class="it">Medico specializzato/a in farmacologia clinica e tossicologica</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_KLINISCHE_PHARMAKOLOGIE_UND_TOXIKOLOGIE ("50016", "Fachärztin/Facharzt für Klinische Pharmakologie und Toxikologie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Mund-, Kiefer- und Gesichtschirurgie</div>
	*<div class="fr">Médecin spécialiste en chirurgie dento-maxillo-faciale</div>
	*<div class="it">Medico specializzato/a in chirurgia maxillo-facciale</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_MUND__KIEFER__UND_GESICHTSCHIRURGIE ("50017", "Fachärztin/Facharzt für Mund-, Kiefer- und Gesichtschirurgie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Nephrologie</div>
	*<div class="fr">Médecin spécialiste en néphrologie</div>
	*<div class="it">Medico specializzato/a in nefrologia</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_NEPHROLOGIE ("50018", "Fachärztin/Facharzt für Nephrologie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Neurochirurgie</div>
	*<div class="fr">Médecin spécialiste en neurochirurgie</div>
	*<div class="it">Medico specializzato/a in neurochirurgia</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_NEUROCHIRURGIE ("50019", "Fachärztin/Facharzt für Neurochirurgie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Neurologie</div>
	*<div class="fr">Médecin spécialiste en neurologie</div>
	*<div class="it">Medico specializzato/a in neurologia</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_NEUROLOGIE ("50020", "Fachärztin/Facharzt für Neurologie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Nuklearmedizin</div>
	*<div class="fr">Médecin spécialiste en médecine nucléaire</div>
	*<div class="it">Medico specializzato/a in medicina nucleare</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_NUKLEARMEDIZIN ("50021", "Fachärztin/Facharzt für Nuklearmedizin"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Ophthalmologie</div>
	*<div class="fr">Médecin spécialiste en ophtalmologie</div>
	*<div class="it">Medico specializzato/a in oftalmologia</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_OPHTHALMOLOGIE ("50022", "Fachärztin/Facharzt für Ophthalmologie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Orthopädische Chirurgie und Traumatologie des Bewegungsapparates</div>
	*<div class="fr">Médecin spécialiste en chirurgie orthopédique et traumatologie de l'appareil locomoteur</div>
	*<div class="it">Medico specializzato/a in chirurgia ortopedica e traumatologia dell'apparato motorio</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_ORTHOPÄDISCHE_CHIRURGIE_UND_TRAUMATOLOGIE_DES_BEWEGUNGSAPPARATES ("50023", "Fachärztin/Facharzt für Orthopädische Chirurgie und Traumatologie des Bewegungsapparates"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Oto-Rhino-Laryngologie</div>
	*<div class="fr">Médecin spécialiste en oto-rhino-laryngologie</div>
	*<div class="it">Medico specializzato/a in otorinolaringoiatria</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_OTO_RHINO_LARYNGOLOGIE ("50024", "Fachärztin/Facharzt für Oto-Rhino-Laryngologie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Pathologie</div>
	*<div class="fr">Médecin spécialiste en pathologie</div>
	*<div class="it">Medico specializzato/a in patologia</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_PATHOLOGIE ("50025", "Fachärztin/Facharzt für Pathologie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Physikalische Medizin und Rehabiliation</div>
	*<div class="fr">Médecin spécialiste en kinésithérapie et réhabilitation</div>
	*<div class="it">Medico specializzato/a in medicina fisica e in riabilitazione</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_PHYSIKALISCHE_MEDIZIN_UND_REHABILIATION ("50026", "Fachärztin/Facharzt für Physikalische Medizin und Rehabiliation"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Plastische, Rekonstruktive und Ästhetische Chirurgie</div>
	*<div class="fr">Médecin spécialiste en chirurgie plastique, reconstructrice et esthétique</div>
	*<div class="it">Medico specializzato/a in chirurgia plastica, ricostruttiva ed estetica</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_PLASTISCHE_REKONSTRUKTIVE_UND_ÄSTHETISCHE_CHIRURGIE ("50027", "Fachärztin/Facharzt für Plastische, Rekonstruktive und Ästhetische Chirurgie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Pneumologie</div>
	*<div class="fr">Médecin spécialiste en pneumologie</div>
	*<div class="it">Medico specializzato/a in pneumologia</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_PNEUMOLOGIE ("50028", "Fachärztin/Facharzt für Pneumologie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Prävention und Gesundheitswesen</div>
	*<div class="fr">Médecin spécialiste en prévention et santé</div>
	*<div class="it">Medico specializzato/a in medicina preventiva e in sanità pubblica</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_PRÄVENTION_UND_GESUNDHEITSWESEN ("50029", "Fachärztin/Facharzt für Prävention und Gesundheitswesen"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Psychiatrie und Psychotherapie</div>
	*<div class="fr">Médecin spécialiste en psychiatrie et psychothérapie</div>
	*<div class="it">Medico specializzato/a in psichiatria e in psicoterapia</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_PSYCHIATRIE_UND_PSYCHOTHERAPIE ("50030", "Fachärztin/Facharzt für Psychiatrie und Psychotherapie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Radiologie</div>
	*<div class="fr">Médecin spécialiste en radiologie</div>
	*<div class="it">Medico specializzato/a in radiologia</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_RADIOLOGIE ("50031", "Fachärztin/Facharzt für Radiologie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Radio-Onkologie / Strahlentherapie</div>
	*<div class="fr">Médecin spécialiste en radio-oncologie/ radiothérapie</div>
	*<div class="it">Medico specializzato/a in radio-oncologia / radioterapia</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_RADIO_ONKOLOGIE__STRAHLENTHERAPIE ("50032", "Fachärztin/Facharzt für Radio-Onkologie / Strahlentherapie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Rheumatologie</div>
	*<div class="fr">Médecin spécialiste en rhumatologie</div>
	*<div class="it">Medico specializzato/a in reumatologia</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_RHEUMATOLOGIE ("50033", "Fachärztin/Facharzt für Rheumatologie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Tropen- und Reisemedizin</div>
	*<div class="fr">Médecin spécialiste en médecine tropicale et des voyages</div>
	*<div class="it">Medico specializzato/a in medicina tropicale e di viaggio</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_TROPEN__UND_REISEMEDIZIN ("50034", "Fachärztin/Facharzt für Tropen- und Reisemedizin"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Urologie</div>
	*<div class="fr">Médecin spécialiste en urologie</div>
	*<div class="it">Medico specializzato/a in urologia</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_UROLOGIE ("50035", "Fachärztin/Facharzt für Urologie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Angiologie</div>
	*<div class="fr">Médecin spécialiste en angiologie</div>
	*<div class="it">Medico specializzato/a in angiologia</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_ANGIOLOGIE ("50036", "Fachärztin/Facharzt für Angiologie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Intensivmedizin</div>
	*<div class="fr">Médecin spécialiste en médecine intensive</div>
	*<div class="it">Medico specializzato/a in medicina intensiva</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_INTENSIVMEDIZIN ("50037", "Fachärztin/Facharzt für Intensivmedizin"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Medizinische Genetik</div>
	*<div class="fr">Médecin spécialiste en médecine génétique</div>
	*<div class="it">Medico specializzato/a in genetica medica</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_MEDIZINISCHE_GENETIK ("50038", "Fachärztin/Facharzt für Medizinische Genetik"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Medizinische Onkologie</div>
	*<div class="fr">Médecin spécialiste en oncologie médicale</div>
	*<div class="it">Medico specializzato/a in oncologia</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_MEDIZINISCHE_ONKOLOGIE ("50039", "Fachärztin/Facharzt für Medizinische Onkologie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Pharmazeutische Medizin</div>
	*<div class="fr">Médecin spécialiste en médecine pharmaceutique</div>
	*<div class="it">Medico specializzato/a in medicina farmaceutica</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_PHARMAZEUTISCHE_MEDIZIN ("50040", "Fachärztin/Facharzt für Pharmazeutische Medizin"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Rechtsmedizin</div>
	*<div class="fr">Médecin spécialiste en médecine légale</div>
	*<div class="it">Medico specializzato/a in medicina legale</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_RECHTSMEDIZIN ("50041", "Fachärztin/Facharzt für Rechtsmedizin"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Handchirurgie</div>
	*<div class="fr">Médecin spécialiste en chirurgie de la main</div>
	*<div class="it">Medico specializzato/a in chirurgia della mano</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_HANDCHIRURGIE ("50042", "Fachärztin/Facharzt für Handchirurgie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Neuropathologie</div>
	*<div class="fr">Médecin spécialiste en neuropathologie</div>
	*<div class="it">Medico specializzato/a in neuropatologia</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_NEUROPATHOLOGIE ("50043", "Fachärztin/Facharzt für Neuropathologie"),
	/** 
	*<div class="de">Zahnärztin/Zahnarzt</div>
	*<div class="fr">Dentiste</div>
	*<div class="it">Dentista</div>
	*/
	ZAHNÄRZTINZAHNARZT ("50044", "Zahnärztin/Zahnarzt"),
	/** 
	*<div class="de">Apothekerin/Apotheker in Offizinpharmazie </div>
	*<div class="fr">Pharmacien d’officine </div>
	*<div class="it">Farmacista in una farmacia d’officina</div>
	*/
	APOTHEKERINAPOTHEKER_IN_OFFIZINPHARMAZIE ("50045", "Apothekerin/Apotheker in Offizinpharmazie "),
	/** 
	*<div class="de">Apothekerin/Apotheker in Spitalpharmazie</div>
	*<div class="fr">Pharmacien d’officine en hôpital</div>
	*<div class="it">Farmacista in una farmacia d'ospedale</div>
	*/
	APOTHEKERINAPOTHEKER_IN_SPITALPHARMAZIE ("50046", "Apothekerin/Apotheker in Spitalpharmazie"),
	/** 
	*<div class="de">Ernährungsberaterin/Ernährungsberater</div>
	*<div class="fr">Nutritionniste</div>
	*<div class="it">Dietista</div>
	*/
	ERNÄHRUNGSBERATERINERNÄHRUNGSBERATER ("50047", "Ernährungsberaterin/Ernährungsberater"),
	/** 
	*<div class="de">Rettungssanitäterin/Rettungssanitäter</div>
	*<div class="fr">Urgentiste</div>
	*<div class="it">Soccorritore/trice</div>
	*/
	RETTUNGSSANITÄTERINRETTUNGSSANITÄTER ("50048", "Rettungssanitäterin/Rettungssanitäter"),
	/** 
	*<div class="de">Chiropraktorin/Chiropraktiker</div>
	*<div class="fr">Chiropracteur</div>
	*<div class="it">Chiropratico/a</div>
	*/
	CHIROPRAKTORINCHIROPRAKTIKER ("50049", "Chiropraktorin/Chiropraktiker"),
	/** 
	*<div class="de">Psychotherapeutin/Psychotherapeut</div>
	*<div class="fr">Psychothérapeute</div>
	*<div class="it">Psicoterapeuta</div>
	*/
	PSYCHOTHERAPEUTINPSYCHOTHERAPEUT ("50050", "Psychotherapeutin/Psychotherapeut"),
	/** 
	*<div class="de">Klinischer Psychologe/Klinische Psychologin</div>
	*<div class="fr">Psychologue clinicien</div>
	*<div class="it">Psicologo/a clinico/a</div>
	*/
	KLINISCHER_PSYCHOLOGEKLINISCHE_PSYCHOLOGIN ("50051", "Klinischer Psychologe/Klinische Psychologin"),
	/** 
	*<div class="de">Gesundheitspsychologin/Gesundheitspsychologe</div>
	*<div class="fr">Psychologue de la santé</div>
	*<div class="it">Psicologo/a della salute</div>
	*/
	GESUNDHEITSPSYCHOLOGINGESUNDHEITSPSYCHOLOGE ("50052", "Gesundheitspsychologin/Gesundheitspsychologe"),
	/** 
	*<div class="de">Musiktherapeutin/Musiktherapeut</div>
	*<div class="fr">Musicothérapeute</div>
	*<div class="it">Musicoterapeuta</div>
	*/
	MUSIKTHERAPEUTINMUSIKTHERAPEUT ("50053", "Musiktherapeutin/Musiktherapeut"),
	/** 
	*<div class="de">Hebamme</div>
	*<div class="fr">Sage-femme</div>
	*<div class="it">Ostetrico/a / levatrice</div>
	*/
	HEBAMME ("50054", "Hebamme"),
	/** 
	*<div class="de">Physiotherapeutin/Physiotherapeut</div>
	*<div class="fr">Physiothérapeute</div>
	*<div class="it">Psicoterapeuta</div>
	*/
	PHYSIOTHERAPEUTINPHYSIOTHERAPEUT ("50055", "Physiotherapeutin/Physiotherapeut"),
	/** 
	*<div class="de">Biomedizinische Analytikerin/Biomedizinischer Analytiker</div>
	*<div class="fr">Analyste biomédical</div>
	*<div class="it">Tecnico in analisi biomediche </div>
	*/
	BIOMEDIZINISCHE_ANALYTIKERINBIOMEDIZINISCHER_ANALYTIKER ("50056", "Biomedizinische Analytikerin/Biomedizinischer Analytiker"),
	/** 
	*<div class="de">Radiologietechnologin/Radiologietechnologe</div>
	*<div class="fr">Technicien en radiologie</div>
	*<div class="it">Tecnico in radiologia</div>
	*/
	RADIOLOGIETECHNOLOGINRADIOLOGIETECHNOLOGE ("50057", "Radiologietechnologin/Radiologietechnologe"),
	/** 
	*<div class="de">Diätologin/Diätologe</div>
	*<div class="fr">Diabétologue</div>
	*<div class="it">Dietologo/a</div>
	*/
	DIÄTOLOGINDIÄTOLOGE ("50058", "Diätologin/Diätologe"),
	/** 
	*<div class="de">Ergotherapeutin/Ergotherapeut</div>
	*<div class="fr">Ergothérapeute</div>
	*<div class="it">Ergoterapista</div>
	*/
	ERGOTHERAPEUTINERGOTHERAPEUT ("50059", "Ergotherapeutin/Ergotherapeut"),
	/** 
	*<div class="de">Logopädin/Logopäde</div>
	*<div class="fr">Orthophoniste</div>
	*<div class="it">Logopedista</div>
	*/
	LOGOPÄDINLOGOPÄDE ("50060", "Logopädin/Logopäde"),
	/** 
	*<div class="de">Orthoptistin/Orthoptist</div>
	*<div class="fr">Orthoptiste</div>
	*<div class="it">Ortottista</div>
	*/
	ORTHOPTISTINORTHOPTIST ("50061", "Orthoptistin/Orthoptist"),
	/** 
	*<div class="de">diplomierte Pflegefachfrau/diplomierter Pflegefachmann</div>
	*<div class="fr">Infirmière diplômée / Infirmier diplômé</div>
	*<div class="it">Infermiere/a diplomato/a</div>
	*/
	DIPLOMIERTE_PFLEGEFACHFRAUDIPLOMIERTER_PFLEGEFACHMANN ("50062", "diplomierte Pflegefachfrau/diplomierter Pflegefachmann"),
	/** 
	*<div class="de">diplomierte Pflegefachfrau/diplomierter Pflegefachmann mit akademischem pflegefachlichem Abschluss (Bachelor)</div>
	*<div class="fr">Infirmière diplômée / Infirmier diplômé avec un Bachelor de Science en soins infirmiers</div>
	*<div class="it">Infermiere/a con titolo accademico (Bachelor)</div>
	*/
	DIPLOMIERTE_PFLEGEFACHFRAUDIPLOMIERTER_PFLEGEFACHMANN_MIT_AKADEMISCHEM_PFLEGEFACHLICHEM_ABSCHLUSS_BACHELOR ("50063", "diplomierte Pflegefachfrau/diplomierter Pflegefachmann mit akademischem pflegefachlichem Abschluss (Bachelor)"),
	/** 
	*<div class="de">diplomierte Pflegefachfrau/diplomierter Pflegefachmann mit akademischem pflegefachlichem Abschluss (Master)</div>
	*<div class="fr">Infirmière diplômée / Infirmier diplômé avec un Master de Science en soins infirmiers</div>
	*<div class="it">Infermiere/a con titolo accademico (Master)</div>
	*/
	DIPLOMIERTE_PFLEGEFACHFRAUDIPLOMIERTER_PFLEGEFACHMANN_MIT_AKADEMISCHEM_PFLEGEFACHLICHEM_ABSCHLUSS_MASTER ("50064", "diplomierte Pflegefachfrau/diplomierter Pflegefachmann mit akademischem pflegefachlichem Abschluss (Master)"),
	/** 
	*<div class="de">diplomierte Pflegefachfrau/diplomierter Pflegefachmann mit Zusatz- oder Spezialfunktion, z.B. IPS, Anästhesie (NDS)</div>
	*<div class="fr">Infirmière diplômée / Infirmier diplômé avec une function supplémentaire ou spécial, p.ex. soins intensiv, anesthésie</div>
	*<div class="it">Infermiere/a diplomato/a con funzione supplementare o speciale, p. es. reparto cure intense (RCI), anestesia (SPD)</div>
	*/
	DIPLOMIERTE_PFLEGEFACHFRAUDIPLOMIERTER_PFLEGEFACHMANN_MIT_ZUSATZ__ODER_SPEZIALFUNKTION_Z_B__IPS_ANÄSTHESIE_NDS ("50065", "diplomierte Pflegefachfrau/diplomierter Pflegefachmann mit Zusatz- oder Spezialfunktion, z.B. IPS, Anästhesie (NDS)"),
	/** 
	*<div class="de">diplomierte Pflegefachfrau/diplomierter Pflegefachmann mit fachvertiefendem NDK und weiteren Zusatzausbildungen wie Diabetesberaterin, Stillberaterin etc.</div>
	*<div class="fr">Infirmière diplômée / Infirmier diplômé avec un cours de spécialisation postgrades et des formation spéciale supplémentaires comme Conseiller/Conseillère aux diabétiques, conseiller/Coonseillère en cas d’allaitement</div>
	*<div class="it">Infermiere/a diplomato/a con corso post-diploma di approfondimento della materia e altre formazioni supplementari, come consulente per il diabete, consulente per l'allattamento al seno ecc.</div>
	*/
	DIPLOMIERTE_PFLEGEFACHFRAUDIPLOMIERTER_PFLEGEFACHMANN_MIT_FACHVERTIEFENDEM_NDK_UND_WEITEREN_ZUSATZAUSBILDUNGEN_WIE_DIABETESBERATERIN_STILLBERATERIN_ETC ("50066", "diplomierte Pflegefachfrau/diplomierter Pflegefachmann mit fachvertiefendem NDK und weiteren Zusatzausbildungen wie Diabetesberaterin, Stillberaterin etc."),
	/** 
	*<div class="de">Pflegefachfrau/Pflegefachmann mit Attestabschluss</div>
	*<div class="fr">Infirmière diplômée / Infirmier diplômé avec une attestation de formation</div>
	*<div class="it">Infermiere con attestato</div>
	*/
	PFLEGEFACHFRAUPFLEGEFACHMANN_MIT_ATTESTABSCHLUSS ("50067", "Pflegefachfrau/Pflegefachmann mit Attestabschluss"),
	/** 
	*<div class="de">Fachfrau/Fachmann Gesundheit, FaGe mit eidg. Fähigkeitszeugnis</div>
	*<div class="fr">assistante/assistant en soins et santé communautaire (ASSC) avec certificat fédéral de capacité</div>
	*<div class="it">Operatore/trice sociosanitario AFC con attestato federale di capacità</div>
	*/
	FACHFRAUFACHMANN_GESUNDHEIT_FAGE_MIT_EIDG__FÄHIGKEITSZEUGNIS ("50068", "Fachfrau/Fachmann Gesundheit, FaGe mit eidg. Fähigkeitszeugnis"),
	/** 
	*<div class="de">Heilmasseurin/Heilmasseur</div>
	*<div class="fr">Masseur thérapeute</div>
	*<div class="it">Massaggiatore/trice curativo/a</div>
	*/
	HEILMASSEURINHEILMASSEUR ("50069", "Heilmasseurin/Heilmasseur"),
	/** 
	*<div class="de">Kardiotechnikerin/Kardiotechniker</div>
	*<div class="fr">Technicien en cardiologie</div>
	*<div class="it">Cardiotecnico</div>
	*/
	KARDIOTECHNIKERINKARDIOTECHNIKER ("50070", "Kardiotechnikerin/Kardiotechniker"),
	/** 
	*<div class="de">Gesundheits- und Sozialberatung</div>
	*<div class="fr">Conseiller sanitaire et social</div>
	*<div class="it">Consulenza sociosanitaria</div>
	*/
	GESUNDHEITS__UND_SOZIALBERATUNG ("50071", "Gesundheits- und Sozialberatung"),
	/** 
	*<div class="de">Hörgeräteakustiker/in</div>
	*<div class="fr">Audioprothésiste</div>
	*<div class="it">Specialista di apparecchi acustici</div>
	*/
	HÖRGERÄTEAKUSTIKERIN ("50072", "Hörgeräteakustiker/in"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Allergologie und Immunologie</div>
	*<div class="fr">Médecin spécialiste en allergologie et immunologie</div>
	*<div class="it">Medico specializzato/a in allergologia e immunologia</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_ALLERGOLOGIE_UND_IMMUNOLOGIE ("50073", "Fachärztin/Facharzt für Allergologie und Immunologie"),
	/** 
	*<div class="de">Fachärztin/Facharzt für Allergologie</div>
	*<div class="fr">Médecin spécialiste en allergologie</div>
	*<div class="it">Medico specializzato/a in allergologia</div>
	*/
	FACHÄRZTINFACHARZT_FÜR_ALLERGOLOGIE ("50074", "Fachärztin/Facharzt für Allergologie"),
	/** 
	*<div class="de">Pharma-Assistentin / Pharma-Assistent</div>
	*<div class="fr">Assistant en pharmacie</div>
	*<div class="it">assistente di farmacia</div>
	*/
	PHARMA_ASSISTENTIN__PHARMA_ASSISTENT ("50075", "Pharma-Assistentin / Pharma-Assistent"),
	/** 
	*<div class="de">Unbekannt</div>
	*<div class="fr">Inconnu</div>
	*<div class="it">Ignoto</div>
	*/
	UNBEKANNT ("50900", "Unbekannt"),
	/** 
	*<div class="de">andere Gesundheitsbezogene Fachrichtung</div>
	*<div class="fr">autre spécialisation du domaine de la santé</div>
	*<div class="it">Altri rami specialistici in ambito sanitario</div>
	*/
	ANDERE_GESUNDHEITSBEZOGENE_FACHRICHTUNG ("50999", "andere Gesundheitsbezogene Fachrichtung");
	public static final String FACHÄRZTINFACHARZT_FÜR_ALLGEMEINE_INNERE_MEDIZIN_CODE="50001";
	public static final String FACHÄRZTINFACHARZT_FÜR_ANÄSTHESIOLOGIE_CODE="50002";
	public static final String FACHÄRZTINFACHARZT_FÜR_ARBEITSMEDIZIN_CODE="50003";
	public static final String FACHÄRZTINFACHARZT_FÜR_CHIRURGIE_CODE="50004";
	public static final String FACHÄRZTINFACHARZT_FÜR_DERMATOLOGIE_UND_VENEROLOGIE_CODE="50005";
	public static final String FACHÄRZTINFACHARZT_FÜR_ENDOKRINOLOGIE__DIABETOLOGIE_CODE="50006";
	public static final String FACHÄRZTINFACHARZT_FÜR_GASTROENTEROLOGIE_CODE="50007";
	public static final String FACHÄRZTINFACHARZT_FÜR_GYNÄKOLOGIE_UND_GEBURTSHILFE_CODE="50008";
	public static final String FACHÄRZTINFACHARZT_FÜR_HÄMATOLOGIE_CODE="50009";
	public static final String FACHÄRZTINFACHARZT_FÜR_HERZ__UND_THORAKALE_GEFÄSSCHIRURGIE_CODE="50010";
	public static final String FACHÄRZTINFACHARZT_FÜR_INFEKTIOLOGIE_CODE="50011";
	public static final String FACHÄRZTINFACHARZT_FÜR_KARDIOLOGIE_CODE="50012";
	public static final String FACHÄRZTINFACHARZT_FÜR_KINDER__UND_JUGENDMEDIZIN_CODE="50013";
	public static final String FACHÄRZTINFACHARZT_FÜR_KINDER__UND_JUGENDPSYCHIATRIE_UND__PSYCHOTHERAPIE_CODE="50014";
	public static final String FACHÄRZTINFACHARZT_FÜR_KINDERCHIRURGIE_CODE="50015";
	public static final String FACHÄRZTINFACHARZT_FÜR_KLINISCHE_PHARMAKOLOGIE_UND_TOXIKOLOGIE_CODE="50016";
	public static final String FACHÄRZTINFACHARZT_FÜR_MUND__KIEFER__UND_GESICHTSCHIRURGIE_CODE="50017";
	public static final String FACHÄRZTINFACHARZT_FÜR_NEPHROLOGIE_CODE="50018";
	public static final String FACHÄRZTINFACHARZT_FÜR_NEUROCHIRURGIE_CODE="50019";
	public static final String FACHÄRZTINFACHARZT_FÜR_NEUROLOGIE_CODE="50020";
	public static final String FACHÄRZTINFACHARZT_FÜR_NUKLEARMEDIZIN_CODE="50021";
	public static final String FACHÄRZTINFACHARZT_FÜR_OPHTHALMOLOGIE_CODE="50022";
	public static final String FACHÄRZTINFACHARZT_FÜR_ORTHOPÄDISCHE_CHIRURGIE_UND_TRAUMATOLOGIE_DES_BEWEGUNGSAPPARATES_CODE="50023";
	public static final String FACHÄRZTINFACHARZT_FÜR_OTO_RHINO_LARYNGOLOGIE_CODE="50024";
	public static final String FACHÄRZTINFACHARZT_FÜR_PATHOLOGIE_CODE="50025";
	public static final String FACHÄRZTINFACHARZT_FÜR_PHYSIKALISCHE_MEDIZIN_UND_REHABILIATION_CODE="50026";
	public static final String FACHÄRZTINFACHARZT_FÜR_PLASTISCHE_REKONSTRUKTIVE_UND_ÄSTHETISCHE_CHIRURGIE_CODE="50027";
	public static final String FACHÄRZTINFACHARZT_FÜR_PNEUMOLOGIE_CODE="50028";
	public static final String FACHÄRZTINFACHARZT_FÜR_PRÄVENTION_UND_GESUNDHEITSWESEN_CODE="50029";
	public static final String FACHÄRZTINFACHARZT_FÜR_PSYCHIATRIE_UND_PSYCHOTHERAPIE_CODE="50030";
	public static final String FACHÄRZTINFACHARZT_FÜR_RADIOLOGIE_CODE="50031";
	public static final String FACHÄRZTINFACHARZT_FÜR_RADIO_ONKOLOGIE__STRAHLENTHERAPIE_CODE="50032";
	public static final String FACHÄRZTINFACHARZT_FÜR_RHEUMATOLOGIE_CODE="50033";
	public static final String FACHÄRZTINFACHARZT_FÜR_TROPEN__UND_REISEMEDIZIN_CODE="50034";
	public static final String FACHÄRZTINFACHARZT_FÜR_UROLOGIE_CODE="50035";
	public static final String FACHÄRZTINFACHARZT_FÜR_ANGIOLOGIE_CODE="50036";
	public static final String FACHÄRZTINFACHARZT_FÜR_INTENSIVMEDIZIN_CODE="50037";
	public static final String FACHÄRZTINFACHARZT_FÜR_MEDIZINISCHE_GENETIK_CODE="50038";
	public static final String FACHÄRZTINFACHARZT_FÜR_MEDIZINISCHE_ONKOLOGIE_CODE="50039";
	public static final String FACHÄRZTINFACHARZT_FÜR_PHARMAZEUTISCHE_MEDIZIN_CODE="50040";
	public static final String FACHÄRZTINFACHARZT_FÜR_RECHTSMEDIZIN_CODE="50041";
	public static final String FACHÄRZTINFACHARZT_FÜR_HANDCHIRURGIE_CODE="50042";
	public static final String FACHÄRZTINFACHARZT_FÜR_NEUROPATHOLOGIE_CODE="50043";
	public static final String ZAHNÄRZTINZAHNARZT_CODE="50044";
	public static final String APOTHEKERINAPOTHEKER_IN_OFFIZINPHARMAZIE_CODE="50045";
	public static final String APOTHEKERINAPOTHEKER_IN_SPITALPHARMAZIE_CODE="50046";
	public static final String ERNÄHRUNGSBERATERINERNÄHRUNGSBERATER_CODE="50047";
	public static final String RETTUNGSSANITÄTERINRETTUNGSSANITÄTER_CODE="50048";
	public static final String CHIROPRAKTORINCHIROPRAKTIKER_CODE="50049";
	public static final String PSYCHOTHERAPEUTINPSYCHOTHERAPEUT_CODE="50050";
	public static final String KLINISCHER_PSYCHOLOGEKLINISCHE_PSYCHOLOGIN_CODE="50051";
	public static final String GESUNDHEITSPSYCHOLOGINGESUNDHEITSPSYCHOLOGE_CODE="50052";
	public static final String MUSIKTHERAPEUTINMUSIKTHERAPEUT_CODE="50053";
	public static final String HEBAMME_CODE="50054";
	public static final String PHYSIOTHERAPEUTINPHYSIOTHERAPEUT_CODE="50055";
	public static final String BIOMEDIZINISCHE_ANALYTIKERINBIOMEDIZINISCHER_ANALYTIKER_CODE="50056";
	public static final String RADIOLOGIETECHNOLOGINRADIOLOGIETECHNOLOGE_CODE="50057";
	public static final String DIÄTOLOGINDIÄTOLOGE_CODE="50058";
	public static final String ERGOTHERAPEUTINERGOTHERAPEUT_CODE="50059";
	public static final String LOGOPÄDINLOGOPÄDE_CODE="50060";
	public static final String ORTHOPTISTINORTHOPTIST_CODE="50061";
	public static final String DIPLOMIERTE_PFLEGEFACHFRAUDIPLOMIERTER_PFLEGEFACHMANN_CODE="50062";
	public static final String DIPLOMIERTE_PFLEGEFACHFRAUDIPLOMIERTER_PFLEGEFACHMANN_MIT_AKADEMISCHEM_PFLEGEFACHLICHEM_ABSCHLUSS_BACHELOR_CODE="50063";
	public static final String DIPLOMIERTE_PFLEGEFACHFRAUDIPLOMIERTER_PFLEGEFACHMANN_MIT_AKADEMISCHEM_PFLEGEFACHLICHEM_ABSCHLUSS_MASTER_CODE="50064";
	public static final String DIPLOMIERTE_PFLEGEFACHFRAUDIPLOMIERTER_PFLEGEFACHMANN_MIT_ZUSATZ__ODER_SPEZIALFUNKTION_Z_B__IPS_ANÄSTHESIE_NDS_CODE="50065";
	public static final String DIPLOMIERTE_PFLEGEFACHFRAUDIPLOMIERTER_PFLEGEFACHMANN_MIT_FACHVERTIEFENDEM_NDK_UND_WEITEREN_ZUSATZAUSBILDUNGEN_WIE_DIABETESBERATERIN_STILLBERATERIN_ETC_CODE="50066";
	public static final String PFLEGEFACHFRAUPFLEGEFACHMANN_MIT_ATTESTABSCHLUSS_CODE="50067";
	public static final String FACHFRAUFACHMANN_GESUNDHEIT_FAGE_MIT_EIDG__FÄHIGKEITSZEUGNIS_CODE="50068";
	public static final String HEILMASSEURINHEILMASSEUR_CODE="50069";
	public static final String KARDIOTECHNIKERINKARDIOTECHNIKER_CODE="50070";
	public static final String GESUNDHEITS__UND_SOZIALBERATUNG_CODE="50071";
	public static final String HÖRGERÄTEAKUSTIKERIN_CODE="50072";
	public static final String FACHÄRZTINFACHARZT_FÜR_ALLERGOLOGIE_UND_IMMUNOLOGIE_CODE="50073";
	public static final String FACHÄRZTINFACHARZT_FÜR_ALLERGOLOGIE_CODE="50074";
	public static final String PHARMA_ASSISTENTIN__PHARMA_ASSISTENT_CODE="50075";
	public static final String UNBEKANNT_CODE="50900";
	public static final String ANDERE_GESUNDHEITSBEZOGENE_FACHRICHTUNG_CODE="50999";


	public static final String CODE_SYSTEM_OID="2.16.756.5.30.1.127.3.10.1.1.4";
	public static final String CODE_SYSTEM_NAME="epd_xds_authorSpeciality";


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
	private AuthorSpeciality (String code, String displayName) {
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


	/**
	* <div class="en">Gets the OHT CodedMetadataType Object</div>
	* <div class="de">Liefert das OHT CodedMetadataType Objekt</div>
	*
	* @return <div class="en">the codedMetadataType</div>
	*/
	public CodedMetadataType getCodedMetadataType() {
		CodedMetadataType cmt = MetadataFactory.eINSTANCE.createCodedMetadataType();
		cmt.setSchemeName(CODE_SYSTEM_OID);
		cmt.setCode(this.getCodeValue());
		cmt.setDisplayName(XdsUtil.createInternationalString(this.getdisplayName(), "de-ch"));
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
	public static AuthorSpeciality getEnum(String code) {
		for (AuthorSpeciality x : values()) {
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
		for (AuthorSpeciality x : values()) {
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