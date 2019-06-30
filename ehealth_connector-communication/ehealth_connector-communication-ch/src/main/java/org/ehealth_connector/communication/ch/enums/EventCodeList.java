/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
import org.ehealth_connector.common.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * <div class="en">no designation found for language ENGLISH</div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum EventCodeList implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Autorefraction</div>
	 * <div class="de">Autorefraktion</div>
	 * <div class="fr">Autoréfraction</div>
	 * <div class="it">Autorifrazione</div>
	 * <!-- @formatter:on -->
	 */
	AUTOREFRACTION("AR", "1.2.840.10008.2.16.4", "Autorefraction", "Autorefraction", "Autorefraktion", "Autoréfraction", "Autorifrazione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Bone Mineral Densitometry</div>
	 * <div class="de">Knochenmineraldensitometrie</div>
	 * <div class="fr">Densitométrie minérale osseuse</div>
	 * <div class="it">Mineralometria ossea computerizzata</div>
	 * <!-- @formatter:on -->
	 */
	BONE_MINERAL_DENSITOMETRY("BMD", "1.2.840.10008.2.16.4", "Bone Mineral Densitometry", "Bone Mineral Densitometry", "Knochenmineraldensitometrie", "Densitométrie minérale osseuse", "Mineralometria ossea computerizzata"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cardiac Electrophysiology</div>
	 * <div class="de">Herz-Elektrophysiologie</div>
	 * <div class="fr">Électrophysiologie cardiaque</div>
	 * <div class="it">Elettrofisiologia cardiaca</div>
	 * <!-- @formatter:on -->
	 */
	CARDIAC_ELECTROPHYSIOLOGY("EPS", "1.2.840.10008.2.16.4", "Cardiac Electrophysiology", "Cardiac Electrophysiology", "Herz-Elektrophysiologie", "Électrophysiologie cardiaque", "Elettrofisiologia cardiaca"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Computed Radiography</div>
	 * <div class="de">Computerradiografie</div>
	 * <div class="fr">Radiographie numérique</div>
	 * <div class="it">Radiografia computerizzata</div>
	 * <!-- @formatter:on -->
	 */
	COMPUTED_RADIOGRAPHY("CR", "1.2.840.10008.2.16.4", "Computed Radiography", "Computed Radiography", "Computerradiografie", "Radiographie numérique", "Radiografia computerizzata"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Computed Tomography</div>
	 * <div class="de">Computertomografie</div>
	 * <div class="fr">Tomographie numérique</div>
	 * <div class="it">Tomografia computerizzata</div>
	 * <!-- @formatter:on -->
	 */
	COMPUTED_TOMOGRAPHY("CT", "1.2.840.10008.2.16.4", "Computed Tomography", "Computed Tomography", "Computertomografie", "Tomographie numérique", "Tomografia computerizzata"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Digital Radiography</div>
	 * <div class="de">Digitales Röntgen</div>
	 * <div class="fr">Radiologie numérique</div>
	 * <div class="it">Radiografia digitale</div>
	 * <!-- @formatter:on -->
	 */
	DIGITAL_RADIOGRAPHY("DX", "1.2.840.10008.2.16.4", "Digital Radiography", "Digital Radiography", "Digitales Röntgen", "Radiologie numérique", "Radiografia digitale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Electrocardiography</div>
	 * <div class="de">Elektrokardiografie</div>
	 * <div class="fr">Électrocardiographie</div>
	 * <div class="it">Elettrocardiografia</div>
	 * <!-- @formatter:on -->
	 */
	ELECTROCARDIOGRAPHY("ECG", "1.2.840.10008.2.16.4", "Electrocardiography", "Electrocardiography", "Elektrokardiografie", "Électrocardiographie", "Elettrocardiografia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Endoscopy</div>
	 * <div class="de">Endoskopie</div>
	 * <div class="fr">Endoscopie</div>
	 * <div class="it">Endoscopia</div>
	 * <!-- @formatter:on -->
	 */
	ENDOSCOPY("ES", "1.2.840.10008.2.16.4", "Endoscopy", "Endoscopy", "Endoskopie", "Endoscopie", "Endoscopia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">External-camera Photography</div>
	 * <div class="de">Fotografie mit externer Kamera</div>
	 * <div class="fr">Photographie par appareil externe</div>
	 * <div class="it">Fotografia con fotocamera esterna</div>
	 * <!-- @formatter:on -->
	 */
	EXTERNAL_CAMERA_PHOTOGRAPHY("XC", "1.2.840.10008.2.16.4", "External-camera Photography", "External-camera Photography", "Fotografie mit externer Kamera", "Photographie par appareil externe", "Fotografia con fotocamera esterna"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">General Microscopy</div>
	 * <div class="de">Allgemeine Mikroskopie</div>
	 * <div class="fr">Microscopie générale</div>
	 * <div class="it">Microscopia generale</div>
	 * <!-- @formatter:on -->
	 */
	GENERAL_MICROSCOPY("GM", "1.2.840.10008.2.16.4", "General Microscopy", "General Microscopy", "Allgemeine Mikroskopie", "Microscopie générale", "Microscopia generale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Hemodynamic Waveform</div>
	 * <div class="de">Hämodynamische Druckkurve</div>
	 * <div class="fr">Courbe hémodynamique</div>
	 * <div class="it">Monitoraggio emodinamico</div>
	 * <!-- @formatter:on -->
	 */
	HEMODYNAMIC_WAVEFORM("HD", "1.2.840.10008.2.16.4", "Hemodynamic Waveform", "Hemodynamic Waveform", "Hämodynamische Druckkurve", "Courbe hémodynamique", "Monitoraggio emodinamico"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intravascular Optical Coherence Tomography</div>
	 * <div class="de">Intravaskuläre optische Kohärenztomografie</div>
	 * <div class="fr">Tomographie en cohérence optique intravasculaire</div>
	 * <div class="it">Tomografia intravascolare a coerenza ottica</div>
	 * <!-- @formatter:on -->
	 */
	INTRAVASCULAR_OPTICAL_COHERENCE_TOMOGRAPHY("IVOCT", "1.2.840.10008.2.16.4", "Intravascular Optical Coherence Tomography", "Intravascular Optical Coherence Tomography", "Intravaskuläre optische Kohärenztomografie", "Tomographie en cohérence optique intravasculaire", "Tomografia intravascolare a coerenza ottica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intravascular Ultrasound</div>
	 * <div class="de">Intravaskulärer Ultraschall</div>
	 * <div class="fr">Ultrason intravasculaire</div>
	 * <div class="it">Ecografia intravascolare</div>
	 * <!-- @formatter:on -->
	 */
	INTRAVASCULAR_ULTRASOUND("IVUS", "1.2.840.10008.2.16.4", "Intravascular Ultrasound", "Intravascular Ultrasound", "Intravaskulärer Ultraschall", "Ultrason intravasculaire", "Ecografia intravascolare"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intra-oral Radiography</div>
	 * <div class="de">Intraorales Röntgen</div>
	 * <div class="fr">Radiographie intra-orale</div>
	 * <div class="it">Radiografia intraorale</div>
	 * <!-- @formatter:on -->
	 */
	INTRA_ORAL_RADIOGRAPHY("IO", "1.2.840.10008.2.16.4", "Intra-oral Radiography", "Intra-oral Radiography", "Intraorales Röntgen", "Radiographie intra-orale", "Radiografia intraorale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Keratometry</div>
	 * <div class="de">Keratometrie</div>
	 * <div class="fr">Kératométrie</div>
	 * <div class="it">Cheratometria</div>
	 * <!-- @formatter:on -->
	 */
	KERATOMETRY("KER", "1.2.840.10008.2.16.4", "Keratometry", "Keratometry", "Keratometrie", "Kératométrie", "Cheratometria"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Lensometry</div>
	 * <div class="de">Linsenmessung</div>
	 * <div class="fr">Lensométrie</div>
	 * <div class="it">Focometria</div>
	 * <!-- @formatter:on -->
	 */
	LENSOMETRY("LEN", "1.2.840.10008.2.16.4", "Lensometry", "Lensometry", "Linsenmessung", "Lensométrie", "Focometria"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Magnetic Resonance</div>
	 * <div class="de">Magnetresonanz</div>
	 * <div class="fr">Résonance magnétique</div>
	 * <div class="it">Risonanza magnetica</div>
	 * <!-- @formatter:on -->
	 */
	MAGNETIC_RESONANCE("MR", "1.2.840.10008.2.16.4", "Magnetic Resonance", "Magnetic Resonance", "Magnetresonanz", "Résonance magnétique", "Risonanza magnetica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Mammography</div>
	 * <div class="de">Mammografie</div>
	 * <div class="fr">Mammographie</div>
	 * <div class="it">Mammografia</div>
	 * <!-- @formatter:on -->
	 */
	MAMMOGRAPHY("MG", "1.2.840.10008.2.16.4", "Mammography", "Mammography", "Mammografie", "Mammographie", "Mammografia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nuclear Medicine</div>
	 * <div class="de">Nuklearmedizin</div>
	 * <div class="fr">Médecine nucléaire</div>
	 * <div class="it">Medicina nucleare</div>
	 * <!-- @formatter:on -->
	 */
	NUCLEAR_MEDICINE("NM", "1.2.840.10008.2.16.4", "Nuclear Medicine", "Nuclear Medicine", "Nuklearmedizin", "Médecine nucléaire", "Medicina nucleare"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ophthalmic Axial Measurements</div>
	 * <div class="de">Augenachsenmessungen</div>
	 * <div class="fr">Mesures axiales ophtalmiques</div>
	 * <div class="it">Misurazioni oftalmiche assiali</div>
	 * <!-- @formatter:on -->
	 */
	OPHTHALMIC_AXIAL_MEASUREMENTS("OAM", "1.2.840.10008.2.16.4", "Ophthalmic Axial Measurements", "Ophthalmic Axial Measurements", "Augenachsenmessungen", "Mesures axiales ophtalmiques", "Misurazioni oftalmiche assiali"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ophthalmic Mapping</div>
	 * <div class="de">Augenkartierung</div>
	 * <div class="fr">Cartographie ophtalmique</div>
	 * <div class="it">Mappatura oftalmica</div>
	 * <!-- @formatter:on -->
	 */
	OPHTHALMIC_MAPPING("OPM", "1.2.840.10008.2.16.4", "Ophthalmic Mapping", "Ophthalmic Mapping", "Augenkartierung", "Cartographie ophtalmique", "Mappatura oftalmica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ophthalmic Photography</div>
	 * <div class="de">Augenfotografie</div>
	 * <div class="fr">Photographie ophtalmique</div>
	 * <div class="it">Fotografia oftalmica</div>
	 * <!-- @formatter:on -->
	 */
	OPHTHALMIC_PHOTOGRAPHY("OP", "1.2.840.10008.2.16.4", "Ophthalmic Photography", "Ophthalmic Photography", "Augenfotografie", "Photographie ophtalmique", "Fotografia oftalmica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ophthalmic Refraction</div>
	 * <div class="de">Augenrefraktion</div>
	 * <div class="fr">Réfraction ophtalmique</div>
	 * <div class="it">Rifrazione oggettiva</div>
	 * <!-- @formatter:on -->
	 */
	OPHTHALMIC_REFRACTION("OPR", "1.2.840.10008.2.16.4", "Ophthalmic Refraction", "Ophthalmic Refraction", "Augenrefraktion", "Réfraction ophtalmique", "Rifrazione oggettiva"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ophthalmic Tomography</div>
	 * <div class="de">Augentomografie</div>
	 * <div class="fr">Tomographie ophtalmique</div>
	 * <div class="it">Tomografia ottica computerizzata</div>
	 * <!-- @formatter:on -->
	 */
	OPHTHALMIC_TOMOGRAPHY("OPT", "1.2.840.10008.2.16.4", "Ophthalmic Tomography", "Ophthalmic Tomography", "Augentomografie", "Tomographie ophtalmique", "Tomografia ottica computerizzata"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ophthalmic Tomography B-scan Volume Analysis</div>
	 * <div class="de">TODO</div>
	 * <div class="fr">TODO</div>
	 * <div class="it">TODO</div>
	 * <!-- @formatter:on -->
	 */
	OPHTHALMIC_TOMOGRAPHY_B_SCAN_VOLUME_ANALYSIS("OPTBSV", "1.2.840.10008.2.16.4", "Ophthalmic Tomography B-scan Volume Analysis", "Ophthalmic Tomography B-scan Volume Analysis", "TODO", "TODO", "TODO"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ophthalmic Tomography En Face</div>
	 * <div class="de">TODO</div>
	 * <div class="fr">TODO</div>
	 * <div class="it">TODO</div>
	 * <!-- @formatter:on -->
	 */
	OPHTHALMIC_TOMOGRAPHY_EN_FACE("OPTENF", "1.2.840.10008.2.16.4", "Ophthalmic Tomography En Face", "Ophthalmic Tomography En Face", "TODO", "TODO", "TODO"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ophthalmic Visual Field</div>
	 * <div class="de">Gesichtsfeld der Augen</div>
	 * <div class="fr">Champ visuel ophtalmique</div>
	 * <div class="it">Perimetria computerizzata</div>
	 * <!-- @formatter:on -->
	 */
	OPHTHALMIC_VISUAL_FIELD("OPV", "1.2.840.10008.2.16.4", "Ophthalmic Visual Field", "Ophthalmic Visual Field", "Gesichtsfeld der Augen", "Champ visuel ophtalmique", "Perimetria computerizzata"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Optical Coherence Tomography</div>
	 * <div class="de">Optische Kohärenztomografie</div>
	 * <div class="fr">Tomographie en cohérence optique</div>
	 * <div class="it">Tomografia a coerenza ottica</div>
	 * <!-- @formatter:on -->
	 */
	OPTICAL_COHERENCE_TOMOGRAPHY("OCT", "1.2.840.10008.2.16.4", "Optical Coherence Tomography", "Optical Coherence Tomography", "Optische Kohärenztomografie", "Tomographie en cohérence optique", "Tomografia a coerenza ottica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Optical Surface Scanner</div>
	 * <div class="de">Optischer Oberflächenscanner</div>
	 * <div class="fr">Scanneur optique de surface</div>
	 * <div class="it">Scanner ottico per superfici</div>
	 * <!-- @formatter:on -->
	 */
	OPTICAL_SURFACE_SCANNER("OSS", "1.2.840.10008.2.16.4", "Optical Surface Scanner", "Optical Surface Scanner", "Optischer Oberflächenscanner", "Scanneur optique de surface", "Scanner ottico per superfici"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Panoramic X-Ray</div>
	 * <div class="de">Panoramaröntgen</div>
	 * <div class="fr">Radiographie panoramique</div>
	 * <div class="it">Radiografia panoramica</div>
	 * <!-- @formatter:on -->
	 */
	PANORAMIC_X_RAY("PX", "1.2.840.10008.2.16.4", "Panoramic X-Ray", "Panoramic X-Ray", "Panoramaröntgen", "Radiographie panoramique", "Radiografia panoramica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Positron emission tomography</div>
	 * <div class="de">Positronen-Emissions-Tomografie</div>
	 * <div class="fr">Tomographie par émission de positons</div>
	 * <div class="it">Tomografia a emissione di positroni</div>
	 * <!-- @formatter:on -->
	 */
	POSITRON_EMISSION_TOMOGRAPHY("PT", "1.2.840.10008.2.16.4", "Positron emission tomography", "Positron emission tomography", "Positronen-Emissions-Tomografie", "Tomographie par émission de positons", "Tomografia a emissione di positroni"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Radiofluoroscopy</div>
	 * <div class="de">Radio-Fluoroskopie</div>
	 * <div class="fr">Radio-fluoroscopie</div>
	 * <div class="it">Radiofluoroscopia</div>
	 * <!-- @formatter:on -->
	 */
	RADIOFLUOROSCOPY("RF", "1.2.840.10008.2.16.4", "Radiofluoroscopy", "Radiofluoroscopy", "Radio-Fluoroskopie", "Radio-fluoroscopie", "Radiofluoroscopia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Radiographic imaging</div>
	 * <div class="de">Röntgenbildgebung</div>
	 * <div class="fr">Imagerie radiographique</div>
	 * <div class="it">Imaging radiografico</div>
	 * <!-- @formatter:on -->
	 */
	RADIOGRAPHIC_IMAGING("RG", "1.2.840.10008.2.16.4", "Radiographic imaging", "Radiographic imaging", "Röntgenbildgebung", "Imagerie radiographique", "Imaging radiografico"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Slide Microscopy</div>
	 * <div class="de">Objektträger Mikroskopie</div>
	 * <div class="fr">Microscopie avec lamelles</div>
	 * <div class="it">Microscopia a vetrini</div>
	 * <!-- @formatter:on -->
	 */
	SLIDE_MICROSCOPY("SM", "1.2.840.10008.2.16.4", "Slide Microscopy", "Slide Microscopy", "Objektträger Mikroskopie", "Microscopie avec lamelles", "Microscopia a vetrini"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Subjective Refraction</div>
	 * <div class="de">Subjektive Refraktion</div>
	 * <div class="fr">Réfraction subjective</div>
	 * <div class="it">Rifrazione soggettiva</div>
	 * <!-- @formatter:on -->
	 */
	SUBJECTIVE_REFRACTION("SRF", "1.2.840.10008.2.16.4", "Subjective Refraction", "Subjective Refraction", "Subjektive Refraktion", "Réfraction subjective", "Rifrazione soggettiva"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ultrasound</div>
	 * <div class="de">Ultraschall</div>
	 * <div class="fr">Ultrason</div>
	 * <div class="it">Ecografia</div>
	 * <!-- @formatter:on -->
	 */
	ULTRASOUND("US", "1.2.840.10008.2.16.4", "Ultrasound", "Ultrasound", "Ultraschall", "Ultrason", "Ecografia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ultrasound Bone Densitometry</div>
	 * <div class="de">Ultraschall-Knochendichtemessung</div>
	 * <div class="fr">Densitométrie osseuse par ultrasons</div>
	 * <div class="it">Densitometria ossea a ultrasuoni</div>
	 * <!-- @formatter:on -->
	 */
	ULTRASOUND_BONE_DENSITOMETRY("BDUS", "1.2.840.10008.2.16.4", "Ultrasound Bone Densitometry", "Ultrasound Bone Densitometry", "Ultraschall-Knochendichtemessung", "Densitométrie osseuse par ultrasons", "Densitometria ossea a ultrasuoni"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Visual Acuity</div>
	 * <div class="de">Sehschärfe</div>
	 * <div class="fr">Acuité visuelle</div>
	 * <div class="it">Acutezza visiva</div>
	 * <!-- @formatter:on -->
	 */
	VISUAL_ACUITY("VA", "1.2.840.10008.2.16.4", "Visual Acuity", "Visual Acuity", "Sehschärfe", "Acuité visuelle", "Acutezza visiva"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">X-Ray Angiography</div>
	 * <div class="de">Röntgen-Angiografie</div>
	 * <div class="fr">Angiographie par rayons X</div>
	 * <div class="it">Angiografia a raggi X</div>
	 * <!-- @formatter:on -->
	 */
	X_RAY_ANGIOGRAPHY("XA", "1.2.840.10008.2.16.4", "X-Ray Angiography", "X-Ray Angiography", "Röntgen-Angiografie", "Angiographie par rayons X", "Angiografia a raggi X");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Autorefraction</div>
	 * <div class="de">Code für Autorefraktion</div>
	 * <div class="fr">Code de Autoréfraction</div>
	 * <div class="it">Code per Autorifrazione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AUTOREFRACTION_CODE = "AR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Bone Mineral Densitometry</div>
	 * <div class="de">Code für Knochenmineraldensitometrie</div>
	 * <div class="fr">Code de Densitométrie minérale osseuse</div>
	 * <div class="it">Code per Mineralometria ossea computerizzata</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BONE_MINERAL_DENSITOMETRY_CODE = "BMD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cardiac Electrophysiology</div>
	 * <div class="de">Code für Herz-Elektrophysiologie</div>
	 * <div class="fr">Code de Électrophysiologie cardiaque</div>
	 * <div class="it">Code per Elettrofisiologia cardiaca</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CARDIAC_ELECTROPHYSIOLOGY_CODE = "EPS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Computed Radiography</div>
	 * <div class="de">Code für Computerradiografie</div>
	 * <div class="fr">Code de Radiographie numérique</div>
	 * <div class="it">Code per Radiografia computerizzata</div>
	 * <!-- @formatter:on -->
	 */
	public static final String COMPUTED_RADIOGRAPHY_CODE = "CR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Computed Tomography</div>
	 * <div class="de">Code für Computertomografie</div>
	 * <div class="fr">Code de Tomographie numérique</div>
	 * <div class="it">Code per Tomografia computerizzata</div>
	 * <!-- @formatter:on -->
	 */
	public static final String COMPUTED_TOMOGRAPHY_CODE = "CT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Digital Radiography</div>
	 * <div class="de">Code für Digitales Röntgen</div>
	 * <div class="fr">Code de Radiologie numérique</div>
	 * <div class="it">Code per Radiografia digitale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DIGITAL_RADIOGRAPHY_CODE = "DX";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Electrocardiography</div>
	 * <div class="de">Code für Elektrokardiografie</div>
	 * <div class="fr">Code de Électrocardiographie</div>
	 * <div class="it">Code per Elettrocardiografia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ELECTROCARDIOGRAPHY_CODE = "ECG";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Endoscopy</div>
	 * <div class="de">Code für Endoskopie</div>
	 * <div class="fr">Code de Endoscopie</div>
	 * <div class="it">Code per Endoscopia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENDOSCOPY_CODE = "ES";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for External-camera Photography</div>
	 * <div class="de">Code für Fotografie mit externer Kamera</div>
	 * <div class="fr">Code de Photographie par appareil externe</div>
	 * <div class="it">Code per Fotografia con fotocamera esterna</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EXTERNAL_CAMERA_PHOTOGRAPHY_CODE = "XC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for General Microscopy</div>
	 * <div class="de">Code für Allgemeine Mikroskopie</div>
	 * <div class="fr">Code de Microscopie générale</div>
	 * <div class="it">Code per Microscopia generale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GENERAL_MICROSCOPY_CODE = "GM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Hemodynamic Waveform</div>
	 * <div class="de">Code für Hämodynamische Druckkurve</div>
	 * <div class="fr">Code de Courbe hémodynamique</div>
	 * <div class="it">Code per Monitoraggio emodinamico</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HEMODYNAMIC_WAVEFORM_CODE = "HD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intravascular Optical Coherence Tomography</div>
	 * <div class="de">Code für Intravaskuläre optische Kohärenztomografie</div>
	 * <div class="fr">Code de Tomographie en cohérence optique intravasculaire</div>
	 * <div class="it">Code per Tomografia intravascolare a coerenza ottica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAVASCULAR_OPTICAL_COHERENCE_TOMOGRAPHY_CODE = "IVOCT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intravascular Ultrasound</div>
	 * <div class="de">Code für Intravaskulärer Ultraschall</div>
	 * <div class="fr">Code de Ultrason intravasculaire</div>
	 * <div class="it">Code per Ecografia intravascolare</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAVASCULAR_ULTRASOUND_CODE = "IVUS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intra-oral Radiography</div>
	 * <div class="de">Code für Intraorales Röntgen</div>
	 * <div class="fr">Code de Radiographie intra-orale</div>
	 * <div class="it">Code per Radiografia intraorale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRA_ORAL_RADIOGRAPHY_CODE = "IO";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Keratometry</div>
	 * <div class="de">Code für Keratometrie</div>
	 * <div class="fr">Code de Kératométrie</div>
	 * <div class="it">Code per Cheratometria</div>
	 * <!-- @formatter:on -->
	 */
	public static final String KERATOMETRY_CODE = "KER";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Lensometry</div>
	 * <div class="de">Code für Linsenmessung</div>
	 * <div class="fr">Code de Lensométrie</div>
	 * <div class="it">Code per Focometria</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LENSOMETRY_CODE = "LEN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Magnetic Resonance</div>
	 * <div class="de">Code für Magnetresonanz</div>
	 * <div class="fr">Code de Résonance magnétique</div>
	 * <div class="it">Code per Risonanza magnetica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MAGNETIC_RESONANCE_CODE = "MR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Mammography</div>
	 * <div class="de">Code für Mammografie</div>
	 * <div class="fr">Code de Mammographie</div>
	 * <div class="it">Code per Mammografia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MAMMOGRAPHY_CODE = "MG";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nuclear Medicine</div>
	 * <div class="de">Code für Nuklearmedizin</div>
	 * <div class="fr">Code de Médecine nucléaire</div>
	 * <div class="it">Code per Medicina nucleare</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NUCLEAR_MEDICINE_CODE = "NM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ophthalmic Axial Measurements</div>
	 * <div class="de">Code für Augenachsenmessungen</div>
	 * <div class="fr">Code de Mesures axiales ophtalmiques</div>
	 * <div class="it">Code per Misurazioni oftalmiche assiali</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OPHTHALMIC_AXIAL_MEASUREMENTS_CODE = "OAM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ophthalmic Mapping</div>
	 * <div class="de">Code für Augenkartierung</div>
	 * <div class="fr">Code de Cartographie ophtalmique</div>
	 * <div class="it">Code per Mappatura oftalmica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OPHTHALMIC_MAPPING_CODE = "OPM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ophthalmic Photography</div>
	 * <div class="de">Code für Augenfotografie</div>
	 * <div class="fr">Code de Photographie ophtalmique</div>
	 * <div class="it">Code per Fotografia oftalmica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OPHTHALMIC_PHOTOGRAPHY_CODE = "OP";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ophthalmic Refraction</div>
	 * <div class="de">Code für Augenrefraktion</div>
	 * <div class="fr">Code de Réfraction ophtalmique</div>
	 * <div class="it">Code per Rifrazione oggettiva</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OPHTHALMIC_REFRACTION_CODE = "OPR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ophthalmic Tomography</div>
	 * <div class="de">Code für Augentomografie</div>
	 * <div class="fr">Code de Tomographie ophtalmique</div>
	 * <div class="it">Code per Tomografia ottica computerizzata</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OPHTHALMIC_TOMOGRAPHY_CODE = "OPT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ophthalmic Tomography B-scan Volume Analysis</div>
	 * <div class="de">Code für TODO</div>
	 * <div class="fr">Code de TODO</div>
	 * <div class="it">Code per TODO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OPHTHALMIC_TOMOGRAPHY_B_SCAN_VOLUME_ANALYSIS_CODE = "OPTBSV";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ophthalmic Tomography En Face</div>
	 * <div class="de">Code für TODO</div>
	 * <div class="fr">Code de TODO</div>
	 * <div class="it">Code per TODO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OPHTHALMIC_TOMOGRAPHY_EN_FACE_CODE = "OPTENF";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ophthalmic Visual Field</div>
	 * <div class="de">Code für Gesichtsfeld der Augen</div>
	 * <div class="fr">Code de Champ visuel ophtalmique</div>
	 * <div class="it">Code per Perimetria computerizzata</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OPHTHALMIC_VISUAL_FIELD_CODE = "OPV";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Optical Coherence Tomography</div>
	 * <div class="de">Code für Optische Kohärenztomografie</div>
	 * <div class="fr">Code de Tomographie en cohérence optique</div>
	 * <div class="it">Code per Tomografia a coerenza ottica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OPTICAL_COHERENCE_TOMOGRAPHY_CODE = "OCT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Optical Surface Scanner</div>
	 * <div class="de">Code für Optischer Oberflächenscanner</div>
	 * <div class="fr">Code de Scanneur optique de surface</div>
	 * <div class="it">Code per Scanner ottico per superfici</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OPTICAL_SURFACE_SCANNER_CODE = "OSS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Panoramic X-Ray</div>
	 * <div class="de">Code für Panoramaröntgen</div>
	 * <div class="fr">Code de Radiographie panoramique</div>
	 * <div class="it">Code per Radiografia panoramica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PANORAMIC_X_RAY_CODE = "PX";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Positron emission tomography</div>
	 * <div class="de">Code für Positronen-Emissions-Tomografie</div>
	 * <div class="fr">Code de Tomographie par émission de positons</div>
	 * <div class="it">Code per Tomografia a emissione di positroni</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POSITRON_EMISSION_TOMOGRAPHY_CODE = "PT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Radiofluoroscopy</div>
	 * <div class="de">Code für Radio-Fluoroskopie</div>
	 * <div class="fr">Code de Radio-fluoroscopie</div>
	 * <div class="it">Code per Radiofluoroscopia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RADIOFLUOROSCOPY_CODE = "RF";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Radiographic imaging</div>
	 * <div class="de">Code für Röntgenbildgebung</div>
	 * <div class="fr">Code de Imagerie radiographique</div>
	 * <div class="it">Code per Imaging radiografico</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RADIOGRAPHIC_IMAGING_CODE = "RG";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Slide Microscopy</div>
	 * <div class="de">Code für Objektträger Mikroskopie</div>
	 * <div class="fr">Code de Microscopie avec lamelles</div>
	 * <div class="it">Code per Microscopia a vetrini</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SLIDE_MICROSCOPY_CODE = "SM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Subjective Refraction</div>
	 * <div class="de">Code für Subjektive Refraktion</div>
	 * <div class="fr">Code de Réfraction subjective</div>
	 * <div class="it">Code per Rifrazione soggettiva</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUBJECTIVE_REFRACTION_CODE = "SRF";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ultrasound</div>
	 * <div class="de">Code für Ultraschall</div>
	 * <div class="fr">Code de Ultrason</div>
	 * <div class="it">Code per Ecografia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ULTRASOUND_CODE = "US";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ultrasound Bone Densitometry</div>
	 * <div class="de">Code für Ultraschall-Knochendichtemessung</div>
	 * <div class="fr">Code de Densitométrie osseuse par ultrasons</div>
	 * <div class="it">Code per Densitometria ossea a ultrasuoni</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ULTRASOUND_BONE_DENSITOMETRY_CODE = "BDUS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Visual Acuity</div>
	 * <div class="de">Code für Sehschärfe</div>
	 * <div class="fr">Code de Acuité visuelle</div>
	 * <div class="it">Code per Acutezza visiva</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VISUAL_ACUITY_CODE = "VA";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for X-Ray Angiography</div>
	 * <div class="de">Code für Röntgen-Angiografie</div>
	 * <div class="fr">Code de Angiographie par rayons X</div>
	 * <div class="it">Code per Angiografia a raggi X</div>
	 * <!-- @formatter:on -->
	 */
	public static final String X_RAY_ANGIOGRAPHY_CODE = "XA";

	/**
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.8";

	/**
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 */
	public static final String VALUE_SET_NAME = "xds-evCoLi";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static EventCodeList getEnum(String code) {
		for (final EventCodeList x : values()) {
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
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(EventCodeList.class, enumName);
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
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final EventCodeList x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <div class="en">Machine interpretable and (inside this class) unique
	 * code</div>
	 * <div class="de">Maschinen interpretierbarer und (innerhalb dieser Klasse)
	 * eindeutiger Code</div>
	 */
	private String code;

	/**
	 * <div class="en">Identifier of the referencing code system.</div>
	 * <div class="de">Identifikator des referenzierende Codesystems.</div>
	 */
	private String codeSystem;

	/**
	 * The display names per language
	 */
	private Map<LanguageCode, String> displayNames;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div>
	 * <div class="de">Instanziiert dieses Enum Object mittels eines Codes
	 * und einem Display Name</div>.
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
	EventCodeList(String code, String codeSystem, String displayName, String displayNameEn, String displayNameDe, String displayNameFr, String displayNameIt) {
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
	 * <div class="en">Gets the code system identifier.</div>
	 * <div class="de">Liefert den Code System Identifikator.</div>
	 *
	 * @return <div class="en">the code system identifier</div>
	 */
	@Override
	public String getCodeSystemId() {
		return this.codeSystem;
	}

	/**
	 * <div class="en">Gets the code system name.</div> <div class="de">Liefert
	 * den Code System Namen.</div>
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
	 * <div class="en">Gets the display name defined by the language param. If
	 * there is no english translation, the default display name is returned.</div>
	 * <div class="de">Liefert display name gemäss Parameter, falls es keine
	 * Englische Übersetzung gibt, wird der default-Name zurückgegeben.</div>
	 *
	 * @param languageCode
	 *            the language code to get the display name for
	 * @return returns the display name in the desired language. if language not
	 *         found, display name in german will returned
	 */
	public String getDisplayName(LanguageCode languageCode) {
		String displayName = displayNames.get(languageCode);
		if (displayName == null && languageCode == LanguageCode.ENGLISH) {
			return displayNames.get(null);
		}
		return displayName;
	}

	/**
	 * <div class="en">Gets the value set identifier.</div> <div class="de">Liefert
	 * den Value Set Identifikator.</div>
	 *
	 * @return <div class="en">the value set identifier</div>
	 */
	@Override
	public String getValueSetId() {
		return VALUE_SET_ID;
	}

	/**
	 * <div class="en">Gets the value set name.</div> <div class="de">Liefert
	 * den Value Set Namen.</div>
	 *
	 * @return <div class="en">the value set name</div>
	 */
	@Override
	public String getValueSetName() {
		return VALUE_SET_NAME;
	}
}
