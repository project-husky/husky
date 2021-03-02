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
package org.ehealth_connector.cda.ch.emed.v097.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * <div class="en">no designation found for language ENGLISH</div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-03-02")
public enum UnitsOfPresentation implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Actuation</div>
	 * <div class="de">Betätigung (Sprühstoss)</div>
	 * <div class="fr">bouffée</div>
	 * <div class="it">Erogazione</div>
	 * <!-- @formatter:on -->
	 */
	ACTUATION("732981002", "2.16.840.1.113883.6.96", "Actuation (unit of presentation)",
			"Actuation", "Betätigung (Sprühstoss)", "bouffée", "Erogazione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ampule</div>
	 * <div class="de">Ampulle</div>
	 * <div class="fr">ampoule</div>
	 * <div class="it">Fiala</div>
	 * <!-- @formatter:on -->
	 */
	AMPULE("732978007", "2.16.840.1.113883.6.96", "Ampule (unit of presentation)", "Ampule",
			"Ampulle", "ampoule", "Fiala"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Applicator</div>
	 * <div class="de">Applikator</div>
	 * <div class="fr">applicateur</div>
	 * <div class="it">Applicatore</div>
	 * <!-- @formatter:on -->
	 */
	APPLICATOR("732980001", "2.16.840.1.113883.6.96", "Applicator (unit of presentation)",
			"Applicator", "Applikator", "applicateur", "Applicatore"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Bag</div>
	 * <div class="de">Tasche</div>
	 * <div class="fr">poche</div>
	 * <div class="it">Sacca</div>
	 * <!-- @formatter:on -->
	 */
	BAG("732982009", "2.16.840.1.113883.6.96", "Bag (unit of presentation)", "Bag", "Tasche",
			"poche", "Sacca"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Barrel</div>
	 * <div class="de">Kanister</div>
	 * <div class="fr">fût</div>
	 * <div class="it">Fusto</div>
	 * <!-- @formatter:on -->
	 */
	BARREL("732983004", "2.16.840.1.113883.6.96", "Barrel (unit of presentation)", "Barrel",
			"Kanister", "fût", "Fusto"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Blister</div>
	 * <div class="de">Blisterpackung</div>
	 * <div class="fr">plaquette</div>
	 * <div class="it">Blister</div>
	 * <!-- @formatter:on -->
	 */
	BLISTER("732984005", "2.16.840.1.113883.6.96", "Blister (unit of presentation)", "Blister",
			"Blisterpackung", "plaquette", "Blister"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Block</div>
	 * <div class="de">Stein</div>
	 * <div class="fr">bloc</div>
	 * <div class="it">Blocco</div>
	 * <!-- @formatter:on -->
	 */
	BLOCK("732985006", "2.16.840.1.113883.6.96", "Block (unit of presentation)", "Block", "Stein",
			"bloc", "Blocco"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Bottle</div>
	 * <div class="de">Flasche</div>
	 * <div class="fr">flacon</div>
	 * <div class="it">Flacone</div>
	 * <!-- @formatter:on -->
	 */
	BOTTLE("732986007", "2.16.840.1.113883.6.96", "Bottle (unit of presentation)", "Bottle",
			"Flasche", "flacon", "Flacone"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Bq</div>
	 * <div class="de">Bq</div>
	 * <div class="fr">Bq</div>
	 * <div class="it">Bq</div>
	 * <!-- @formatter:on -->
	 */
	BQ("Bq", "2.16.840.1.113883.6.8", "Becquerel", "Bq", "Bq", "Bq", "Bq"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cachet</div>
	 * <div class="de">Oblatenkapsel</div>
	 * <div class="fr">cachet</div>
	 * <div class="it">Cachet</div>
	 * <!-- @formatter:on -->
	 */
	CACHET("732987003", "2.16.840.1.113883.6.96", "Cachet (unit of presentation)", "Cachet",
			"Oblatenkapsel", "cachet", "Cachet"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Capsule</div>
	 * <div class="de">Kapsel</div>
	 * <div class="fr">capsule</div>
	 * <div class="it">Capsula</div>
	 * <!-- @formatter:on -->
	 */
	CAPSULE("732937005", "2.16.840.1.113883.6.96", "Capsule (unit of presentation)", "Capsule",
			"Kapsel", "capsule", "Capsula"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cartridge</div>
	 * <div class="de">Patrone</div>
	 * <div class="fr">cartouche</div>
	 * <div class="it">Cartuccia</div>
	 * <!-- @formatter:on -->
	 */
	CARTRIDGE("732988008", "2.16.840.1.113883.6.96", "Cartridge (unit of presentation)",
			"Cartridge", "Patrone", "cartouche", "Cartuccia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">CFU</div>
	 * <div class="de">CFU</div>
	 * <div class="fr">CFU</div>
	 * <div class="it">CFU</div>
	 * <!-- @formatter:on -->
	 */
	CFU("CFU", "2.16.840.1.113883.6.8", "Colony Forming Units", "CFU", "CFU", "CFU", "CFU"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Chewing gum</div>
	 * <div class="de">Kaugummi</div>
	 * <div class="fr">gomme à mâcher</div>
	 * <div class="it">Gomma da masticare</div>
	 * <!-- @formatter:on -->
	 */
	CHEWING_GUM("732989000", "2.16.840.1.113883.6.96", "Chewing gum (unit of presentation)",
			"Chewing gum", "Kaugummi", "gomme à mâcher", "Gomma da masticare"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">cm</div>
	 * <div class="de">cm</div>
	 * <div class="fr">cm</div>
	 * <div class="it">cm</div>
	 * <!-- @formatter:on -->
	 */
	CM("cm", "2.16.840.1.113883.6.8", "centimeter", "cm", "cm", "cm", "cm"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">cm2</div>
	 * <div class="de">cm2</div>
	 * <div class="fr">cm2</div>
	 * <div class="it">cm2</div>
	 * <!-- @formatter:on -->
	 */
	CM2("cm2", "2.16.840.1.113883.6.8", "square centimeter", "cm2", "cm2", "cm2", "cm2"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">cm3</div>
	 * <div class="de">cm3</div>
	 * <div class="fr">cm3</div>
	 * <div class="it">cm3</div>
	 * <!-- @formatter:on -->
	 */
	CM3("cm3", "2.16.840.1.113883.6.8", "cubic centimeter", "cm3", "cm3", "cm3", "cm3"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Container</div>
	 * <div class="de">Behältnis</div>
	 * <div class="fr">récipient</div>
	 * <div class="it">Contenitore</div>
	 * <!-- @formatter:on -->
	 */
	CONTAINER("732990009", "2.16.840.1.113883.6.96", "Container (unit of presentation)",
			"Container", "Behältnis", "récipient", "Contenitore"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cup</div>
	 * <div class="de">Messbecher</div>
	 * <div class="fr">godet</div>
	 * <div class="it">Bicchiere dosatore</div>
	 * <!-- @formatter:on -->
	 */
	CUP("732991008", "2.16.840.1.113883.6.96", "Cup (unit of presentation)", "Cup", "Messbecher",
			"godet", "Bicchiere dosatore"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cylinder</div>
	 * <div class="de">Zylinder</div>
	 * <div class="fr">cylindre</div>
	 * <div class="it">Cilindro</div>
	 * <!-- @formatter:on -->
	 */
	CYLINDER("732992001", "2.16.840.1.113883.6.96", "Cylinder (unit of presentation)", "Cylinder",
			"Zylinder", "cylindre", "Cilindro"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">d</div>
	 * <div class="de">d</div>
	 * <div class="fr">d</div>
	 * <div class="it">d</div>
	 * <!-- @formatter:on -->
	 */
	D("D", "2.16.840.1.113883.6.8", "Day", "d", "d", "d", "d"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dose</div>
	 * <div class="de">Dos</div>
	 * <div class="fr">dose</div>
	 * <div class="it">dose</div>
	 * <!-- @formatter:on -->
	 */
	DOSE("{Dose}", "2.16.840.1.113883.6.8", "Dose", "Dose", "Dos", "dose", "dose"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dressing</div>
	 * <div class="de">Verband</div>
	 * <div class="fr">compresse</div>
	 * <div class="it">Garza</div>
	 * <!-- @formatter:on -->
	 */
	DRESSING("732993006", "2.16.840.1.113883.6.96", "Dressing (unit of presentation)", "Dressing",
			"Verband", "compresse", "Garza"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Drop</div>
	 * <div class="de">Tropfen</div>
	 * <div class="fr">goutte</div>
	 * <div class="it">Goccia</div>
	 * <!-- @formatter:on -->
	 */
	DROP("732994000", "2.16.840.1.113883.6.96", "Drop (unit of presentation)", "Drop", "Tropfen",
			"goutte", "Goccia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Film</div>
	 * <div class="de">Film</div>
	 * <div class="fr">film</div>
	 * <div class="it">Film</div>
	 * <!-- @formatter:on -->
	 */
	FILM("732995004", "2.16.840.1.113883.6.96", "Film (unit of presentation)", "Film", "Film",
			"film", "Film"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">g</div>
	 * <div class="de">g</div>
	 * <div class="fr">g</div>
	 * <div class="it">g</div>
	 * <!-- @formatter:on -->
	 */
	G("g", "2.16.840.1.113883.6.8", "gram", "g", "g", "g", "g"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">GBq</div>
	 * <div class="de">GBq</div>
	 * <div class="fr">GBq</div>
	 * <div class="it">GBq</div>
	 * <!-- @formatter:on -->
	 */
	GBQ("GBq", "2.16.840.1.113883.6.8", "gigaBecquerel", "GBq", "GBq", "GBq", "GBq"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">h</div>
	 * <div class="de">h</div>
	 * <div class="fr">h</div>
	 * <div class="it">h</div>
	 * <!-- @formatter:on -->
	 */
	H("HR", "2.16.840.1.113883.6.8", "Hour", "h", "h", "h", "h"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Implant</div>
	 * <div class="de">Implantat</div>
	 * <div class="fr">implant</div>
	 * <div class="it">Impianto</div>
	 * <!-- @formatter:on -->
	 */
	IMPLANT("732996003", "2.16.840.1.113883.6.96", "Implant (unit of presentation)", "Implant",
			"Implantat", "implant", "Impianto"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhaler</div>
	 * <div class="de">Inhalator</div>
	 * <div class="fr">inhalateur</div>
	 * <div class="it">Inalatore</div>
	 * <!-- @formatter:on -->
	 */
	INHALER("732997007", "2.16.840.1.113883.6.96", "Inhaler (unit of presentation)", "Inhaler",
			"Inhalator", "inhalateur", "Inalatore"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Insert</div>
	 * <div class="de">Insert</div>
	 * <div class="fr">insert</div>
	 * <div class="it">Inserto</div>
	 * <!-- @formatter:on -->
	 */
	INSERT("732998002", "2.16.840.1.113883.6.96", "Insert (unit of presentation)", "Insert",
			"Insert", "insert", "Inserto"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">international unit</div>
	 * <div class="de">Internationale Einheit</div>
	 * <div class="fr">unité(s) internationale(s)</div>
	 * <div class="it">unità internazionale(i)</div>
	 * <!-- @formatter:on -->
	 */
	INTERNATIONAL_UNIT("iU", "2.16.840.1.113883.6.8", "international unit", "international unit",
			"Internationale Einheit", "unité(s) internationale(s)", "unità internazionale(i)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Jar</div>
	 * <div class="de">Weithalsgefäss</div>
	 * <div class="fr">pot</div>
	 * <div class="it">Vasetto</div>
	 * <!-- @formatter:on -->
	 */
	JAR("732999005", "2.16.840.1.113883.6.96", "Jar (unit of presentation)", "Jar",
			"Weithalsgefäss", "pot", "Vasetto"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">kBq</div>
	 * <div class="de">kBq</div>
	 * <div class="fr">kBq</div>
	 * <div class="it">kBq</div>
	 * <!-- @formatter:on -->
	 */
	KBQ("kBq", "2.16.840.1.113883.6.8", "kiloBecquerel", "kBq", "kBq", "kBq", "kBq"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">kcal</div>
	 * <div class="de">kcal</div>
	 * <div class="fr">kcal</div>
	 * <div class="it">kcal</div>
	 * <!-- @formatter:on -->
	 */
	KCAL("kcal", "2.16.840.1.113883.6.8", "kilocalorie", "kcal", "kcal", "kcal", "kcal"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">kg</div>
	 * <div class="de">kg</div>
	 * <div class="fr">kg</div>
	 * <div class="it">kg</div>
	 * <!-- @formatter:on -->
	 */
	KG("kg", "2.16.840.1.113883.6.8", "kilogram", "kg", "kg", "kg", "kg"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">kJ</div>
	 * <div class="de">kJ</div>
	 * <div class="fr">kJ</div>
	 * <div class="it">kJ</div>
	 * <!-- @formatter:on -->
	 */
	KJ("kJ", "2.16.840.1.113883.6.8", "kilojoule", "kJ", "kJ", "kJ", "kJ"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Lozenge</div>
	 * <div class="de">Lutschtablette</div>
	 * <div class="fr">pastille dure</div>
	 * <div class="it">Pastiglia</div>
	 * <!-- @formatter:on -->
	 */
	LOZENGE("733000006", "2.16.840.1.113883.6.96", "Lozenge (unit of presentation)", "Lozenge",
			"Lutschtablette", "pastille dure", "Pastiglia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">lt</div>
	 * <div class="de">lt</div>
	 * <div class="fr">lt</div>
	 * <div class="it">l</div>
	 * <!-- @formatter:on -->
	 */
	LT("L", "2.16.840.1.113883.6.8", "liter", "lt", "lt", "lt", "l"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Lyophilisate</div>
	 * <div class="de">Lyophilisat</div>
	 * <div class="fr">lyophilisat</div>
	 * <div class="it">Liofilizzato</div>
	 * <!-- @formatter:on -->
	 */
	LYOPHILISATE("733001005", "2.16.840.1.113883.6.96", "Lyophilisate (unit of presentation)",
			"Lyophilisate", "Lyophilisat", "lyophilisat", "Liofilizzato"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Matrix</div>
	 * <div class="de">Matrix</div>
	 * <div class="fr">matrice</div>
	 * <div class="it">Matrice</div>
	 * <!-- @formatter:on -->
	 */
	MATRIX("733002003", "2.16.840.1.113883.6.96", "Matrix (unit of presentation)", "Matrix",
			"Matrix", "matrice", "Matrice"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">MBq</div>
	 * <div class="de">MBq</div>
	 * <div class="fr">MBq</div>
	 * <div class="it">MBq</div>
	 * <!-- @formatter:on -->
	 */
	MBQ("MBq", "2.16.840.1.113883.6.8", "megaBecquerel", "MBq", "MBq", "MBq", "MBq"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">meq</div>
	 * <div class="de">meq</div>
	 * <div class="fr">mEq</div>
	 * <div class="it">mEq</div>
	 * <!-- @formatter:on -->
	 */
	MEQ("meq", "2.16.840.1.113883.6.8", "milliequivalent", "meq", "meq", "mEq", "mEq"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">mg</div>
	 * <div class="de">mg</div>
	 * <div class="fr">mg</div>
	 * <div class="it">mg</div>
	 * <!-- @formatter:on -->
	 */
	MG("mg", "2.16.840.1.113883.6.8", "milligram", "mg", "mg", "mg", "mg"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">MillionInternationalUnit</div>
	 * <div class="de">MioUI</div>
	 * <div class="fr">MioUI</div>
	 * <div class="it">MioUI</div>
	 * <!-- @formatter:on -->
	 */
	MILLIONINTERNATIONALUNIT("10*6.iU", "2.16.840.1.113883.6.8", "MillionInternationalUnit",
			"MillionInternationalUnit", "MioUI", "MioUI", "MioUI"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">min</div>
	 * <div class="de">min</div>
	 * <div class="fr">min</div>
	 * <div class="it">min</div>
	 * <!-- @formatter:on -->
	 */
	MIN("MIN", "2.16.840.1.113883.6.8", "Minute", "min", "min", "min", "min"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">MioU</div>
	 * <div class="de">MioU</div>
	 * <div class="fr">MioU</div>
	 * <div class="it">MioU</div>
	 * <!-- @formatter:on -->
	 */
	MIOU("10*6.U", "2.16.840.1.113883.6.8", "(the number ten for arbitrary powers ^ 6) * Unit",
			"MioU", "MioU", "MioU", "MioU"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ml</div>
	 * <div class="de">ml</div>
	 * <div class="fr">ml</div>
	 * <div class="it">ml</div>
	 * <!-- @formatter:on -->
	 */
	ML("mL", "2.16.840.1.113883.6.8", "milliliter", "ml", "ml", "ml", "ml"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">mm2</div>
	 * <div class="de">mm2</div>
	 * <div class="fr">mm2</div>
	 * <div class="it">mm2</div>
	 * <!-- @formatter:on -->
	 */
	MM2("mm2", "2.16.840.1.113883.6.8", "square millimeter", "mm2", "mm2", "mm2", "mm2"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">mmol</div>
	 * <div class="de">mmol</div>
	 * <div class="fr">mmol</div>
	 * <div class="it">mmol</div>
	 * <!-- @formatter:on -->
	 */
	MMOL("mmol", "2.16.840.1.113883.6.8", "millimole", "mmol", "mmol", "mmol", "mmol"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">mol</div>
	 * <div class="de">mol</div>
	 * <div class="fr">mol</div>
	 * <div class="it">mol</div>
	 * <!-- @formatter:on -->
	 */
	MOL("mol", "2.16.840.1.113883.6.8", "mole", "mol", "mol", "mol", "mol"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ng</div>
	 * <div class="de">ng</div>
	 * <div class="fr">ng</div>
	 * <div class="it">ng</div>
	 * <!-- @formatter:on -->
	 */
	NG("ng", "2.16.840.1.113883.6.8", "nanogram", "ng", "ng", "ng", "ng"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">nl</div>
	 * <div class="de">nl</div>
	 * <div class="fr">nl</div>
	 * <div class="it">nl</div>
	 * <!-- @formatter:on -->
	 */
	NL("nL", "2.16.840.1.113883.6.8", "nanoliter", "nl", "nl", "nl", "nl"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Package</div>
	 * <div class="de">Packung</div>
	 * <div class="fr">emballage</div>
	 * <div class="it">confezione</div>
	 * <!-- @formatter:on -->
	 */
	PACKAGE("{Package}", "2.16.840.1.113883.6.8", "Package", "Package", "Packung", "emballage",
			"confezione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pad</div>
	 * <div class="de">Pad</div>
	 * <div class="fr">tampon applicateur</div>
	 * <div class="it">Tampone</div>
	 * <!-- @formatter:on -->
	 */
	PAD("733003008", "2.16.840.1.113883.6.96", "Pad (unit of presentation)", "Pad", "Pad",
			"tampon applicateur", "Tampone"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pastille</div>
	 * <div class="de">Pastille</div>
	 * <div class="fr">pastille molle</div>
	 * <div class="it">Pastiglia molle</div>
	 * <!-- @formatter:on -->
	 */
	PASTILLE("733004002", "2.16.840.1.113883.6.96", "Pastille (unit of presentation)", "Pastille",
			"Pastille", "pastille molle", "Pastiglia molle"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Patch</div>
	 * <div class="de">Pflaster</div>
	 * <div class="fr">patch</div>
	 * <div class="it">Cerotto</div>
	 * <!-- @formatter:on -->
	 */
	PATCH("733005001", "2.16.840.1.113883.6.96", "Patch (unit of presentation)", "Patch",
			"Pflaster", "patch", "Cerotto"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pen</div>
	 * <div class="de">Pen</div>
	 * <div class="fr">stylo</div>
	 * <div class="it">Penna</div>
	 * <!-- @formatter:on -->
	 */
	PEN("733006000", "2.16.840.1.113883.6.96", "Pen (unit of presentation)", "Pen", "Pen", "stylo",
			"Penna"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">%</div>
	 * <div class="de">%</div>
	 * <div class="fr">%</div>
	 * <div class="it">%</div>
	 * <!-- @formatter:on -->
	 */
	PERCENT("%", "2.16.840.1.113883.6.8", "percent", "%", "%", "%", "%"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pessary</div>
	 * <div class="de">Pessar</div>
	 * <div class="fr">ovule</div>
	 * <div class="it">Ovulo</div>
	 * <!-- @formatter:on -->
	 */
	PESSARY("733007009", "2.16.840.1.113883.6.96", "Pessary (unit of presentation)", "Pessary",
			"Pessar", "ovule", "Ovulo"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Piece(s)</div>
	 * <div class="de">Stk</div>
	 * <div class="fr">pce</div>
	 * <div class="it">pz</div>
	 * <!-- @formatter:on -->
	 */
	PIECE("U{PIECE(S)}", "2.16.840.1.113883.6.8", "Piece(s)", "Piece(s)", "Stk", "pce", "pz"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pillule</div>
	 * <div class="de">Streukügelchen</div>
	 * <div class="fr">granule</div>
	 * <div class="it">Granuli</div>
	 * <!-- @formatter:on -->
	 */
	PILLULE("733008004", "2.16.840.1.113883.6.96", "Pillule (unit of presentation)", "Pillule",
			"Streukügelchen", "granule", "Granuli"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pipette</div>
	 * <div class="de">Pipette</div>
	 * <div class="fr">pipette</div>
	 * <div class="it">Pipetta</div>
	 * <!-- @formatter:on -->
	 */
	PIPETTE("733009007", "2.16.840.1.113883.6.96", "Pipette (unit of presentation)", "Pipette",
			"Pipette", "pipette", "Pipetta"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Plaster</div>
	 * <div class="de">Pflaster</div>
	 * <div class="fr">emplâtre</div>
	 * <div class="it">Cerotto</div>
	 * <!-- @formatter:on -->
	 */
	PLASTER("733010002", "2.16.840.1.113883.6.96", "Plaster (unit of presentation)", "Plaster",
			"Pflaster", "emplâtre", "Cerotto"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Plug</div>
	 * <div class="de">Einsatz</div>
	 * <div class="fr">support poreux</div>
	 * <div class="it">Supporto</div>
	 * <!-- @formatter:on -->
	 */
	PLUG("733011003", "2.16.840.1.113883.6.96", "Plug (unit of presentation)", "Plug", "Einsatz",
			"support poreux", "Supporto"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pouch</div>
	 * <div class="de">Beutelchen</div>
	 * <div class="fr">petit sachet</div>
	 * <div class="it">Sachetta</div>
	 * <!-- @formatter:on -->
	 */
	POUCH("733012005", "2.16.840.1.113883.6.96", "Pouch (unit of presentation)", "Pouch",
			"Beutelchen", "petit sachet", "Sachetta"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ppm</div>
	 * <div class="de">ppm</div>
	 * <div class="fr">ppm</div>
	 * <div class="it">ppm</div>
	 * <!-- @formatter:on -->
	 */
	PPM("PPM ", "2.16.840.1.113883.6.8", "Parts Per Million", "ppm", "ppm", "ppm", "ppm"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Sachet</div>
	 * <div class="de">Beutel</div>
	 * <div class="fr">sachet</div>
	 * <div class="it">Bustina</div>
	 * <!-- @formatter:on -->
	 */
	SACHET("733013000", "2.16.840.1.113883.6.96", "Sachet (unit of presentation)", "Sachet",
			"Beutel", "sachet", "Bustina"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">sec</div>
	 * <div class="de">sec</div>
	 * <div class="fr">sec</div>
	 * <div class="it">sec</div>
	 * <!-- @formatter:on -->
	 */
	SEC("S", "2.16.840.1.113883.6.8", "Second", "sec", "sec", "sec", "sec"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Sponge</div>
	 * <div class="de">Schwämmchen</div>
	 * <div class="fr">eponge</div>
	 * <div class="it">Spugna</div>
	 * <!-- @formatter:on -->
	 */
	SPONGE("733014006", "2.16.840.1.113883.6.96", "Sponge (unit of presentation)", "Sponge",
			"Schwämmchen", "eponge", "Spugna"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Spoonful</div>
	 * <div class="de">ein Löffel voll</div>
	 * <div class="fr">cuillerée</div>
	 * <div class="it">Cucciaio</div>
	 * <!-- @formatter:on -->
	 */
	SPOONFUL("733015007", "2.16.840.1.113883.6.96", "Spoonful (unit of presentation)", "Spoonful",
			"ein Löffel voll", "cuillerée", "Cucciaio"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Stick</div>
	 * <div class="de">Stäbchen</div>
	 * <div class="fr">bâton</div>
	 * <div class="it">Stick</div>
	 * <!-- @formatter:on -->
	 */
	STICK("733016008", "2.16.840.1.113883.6.96", "Stick (unit of presentation)", "Stick",
			"Stäbchen", "bâton", "Stick"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Straw</div>
	 * <div class="de">Trinkhalm</div>
	 * <div class="fr">paille</div>
	 * <div class="it">Cannuccia</div>
	 * <!-- @formatter:on -->
	 */
	STRAW("733017004", "2.16.840.1.113883.6.96", "Straw (unit of presentation)", "Straw",
			"Trinkhalm", "paille", "Cannuccia"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Strip</div>
	 * <div class="de">Streifen</div>
	 * <div class="fr">bandelette</div>
	 * <div class="it">Strip</div>
	 * <!-- @formatter:on -->
	 */
	STRIP("733018009", "2.16.840.1.113883.6.96", "Strip (unit of presentation)", "Strip",
			"Streifen", "bandelette", "Strip"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Suppository</div>
	 * <div class="de">Zäpfchen</div>
	 * <div class="fr">suppositoire</div>
	 * <div class="it">Supposta</div>
	 * <!-- @formatter:on -->
	 */
	SUPPOSITORY("733019001", "2.16.840.1.113883.6.96", "Suppository (unit of presentation)",
			"Suppository", "Zäpfchen", "suppositoire", "Supposta"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Syringe</div>
	 * <div class="de">Spritze</div>
	 * <div class="fr">seringue</div>
	 * <div class="it">Siringa</div>
	 * <!-- @formatter:on -->
	 */
	SYRINGE("733020007", "2.16.840.1.113883.6.96", "Syringe (unit of presentation)", "Syringe",
			"Spritze", "seringue", "Siringa"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">System</div>
	 * <div class="de">System</div>
	 * <div class="fr">système</div>
	 * <div class="it">Sistema</div>
	 * <!-- @formatter:on -->
	 */
	SYSTEM("733021006", "2.16.840.1.113883.6.96", "System (unit of presentation)", "System",
			"System", "système", "Sistema"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">tablespoon - metric</div>
	 * <div class="de">Esslöffel</div>
	 * <div class="fr">c. à soupe</div>
	 * <div class="it">cucchiaio da minestra</div>
	 * <!-- @formatter:on -->
	 */
	TABLESPOON_METRIC("tbs_m", "2.16.840.1.113883.6.8", "tablespoon - metric",
			"tablespoon - metric", "Esslöffel", "c. à soupe", "cucchiaio da minestra"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Tablet</div>
	 * <div class="de">Tablette</div>
	 * <div class="fr">comprimé</div>
	 * <div class="it">Compressa</div>
	 * <!-- @formatter:on -->
	 */
	TABLET("732936001", "2.16.840.1.113883.6.96", "Tablet (unit of presentation)", "Tablet",
			"Tablette", "comprimé", "Compressa"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Tampon</div>
	 * <div class="de">Tampon</div>
	 * <div class="fr">tampon diffuseur</div>
	 * <div class="it">Tampone</div>
	 * <!-- @formatter:on -->
	 */
	TAMPON("733022004", "2.16.840.1.113883.6.96", "Tampon (unit of presentation)", "Tampon",
			"Tampon", "tampon diffuseur", "Tampone"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">teaspoon - metric</div>
	 * <div class="de">Teelöffel</div>
	 * <div class="fr">c. à café</div>
	 * <div class="it">cucchiaino da caffè</div>
	 * <!-- @formatter:on -->
	 */
	TEASPOON_METRIC("tsp_m", "2.16.840.1.113883.6.8", "teaspoon - metric", "teaspoon - metric",
			"Teelöffel", "c. à café", "cucchiaino da caffè"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Thousand Per * Unit</div>
	 * <div class="de">Tausend Einheiten</div>
	 * <div class="fr">millier d'unités</div>
	 * <div class="it">mille per unità *</div>
	 * <!-- @formatter:on -->
	 */
	THOUSAND_PER_STAR_UNIT("10*3.U", "2.16.840.1.113883.6.8", "Thousand Per * Unit",
			"Thousand Per * Unit", "Tausend Einheiten", "millier d'unités", "mille per unità *"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Thread</div>
	 * <div class="de">Faden</div>
	 * <div class="fr">fil</div>
	 * <div class="it">Filo</div>
	 * <!-- @formatter:on -->
	 */
	THREAD("733023009", "2.16.840.1.113883.6.96", "Thread (unit of presentation)", "Thread",
			"Faden", "fil", "Filo"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Tube</div>
	 * <div class="de">Tube</div>
	 * <div class="fr">tube</div>
	 * <div class="it">Tubo</div>
	 * <!-- @formatter:on -->
	 */
	TUBE("733024003", "2.16.840.1.113883.6.96", "Tube (unit of presentation)", "Tube", "Tube",
			"tube", "Tubo"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">unit</div>
	 * <div class="de">Einheit</div>
	 * <div class="fr">unité(s)</div>
	 * <div class="it">unità</div>
	 * <!-- @formatter:on -->
	 */
	UNIT("U", "2.16.840.1.113883.6.8", "Unit", "unit", "Einheit", "unité(s)", "unità"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Vessel</div>
	 * <div class="de">Gefäss</div>
	 * <div class="fr">récipient étanche</div>
	 * <div class="it">Recipiente a tenuta</div>
	 * <!-- @formatter:on -->
	 */
	VESSEL("733025002", "2.16.840.1.113883.6.96", "Vessel (unit of presentation)", "Vessel",
			"Gefäss", "récipient étanche", "Recipiente a tenuta"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Vial</div>
	 * <div class="de">Durchstechflasche</div>
	 * <div class="fr">petit flacon</div>
	 * <div class="it">Flaconcino</div>
	 * <!-- @formatter:on -->
	 */
	VIAL("733026001", "2.16.840.1.113883.6.96", "Vial (unit of presentation)", "Vial",
			"Durchstechflasche", "petit flacon", "Flaconcino"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">µg</div>
	 * <div class="de">µg</div>
	 * <div class="fr">µg</div>
	 * <div class="it">µg</div>
	 * <!-- @formatter:on -->
	 */
	_G("ug", "2.16.840.1.113883.6.8", "microgram", "µg", "µg", "µg", "µg"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">µl</div>
	 * <div class="de">µl</div>
	 * <div class="fr">µl</div>
	 * <div class="it">µl</div>
	 * <!-- @formatter:on -->
	 */
	_L("uL", "2.16.840.1.113883.6.8", "microliter", "µl", "µl", "µl", "µl"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">µmol</div>
	 * <div class="de">µmol</div>
	 * <div class="fr">µmol</div>
	 * <div class="it">µmol</div>
	 * <!-- @formatter:on -->
	 */
	_MOL("umol", "2.16.840.1.113883.6.8", "micromol", "µmol", "µmol", "µmol", "µmol");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Actuation</div>
	 * <div class="de">Code für Betätigung (Sprühstoss)</div>
	 * <div class="fr">Code de bouffée</div>
	 * <div class="it">Code per Erogazione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ACTUATION_CODE = "732981002";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ampule</div>
	 * <div class="de">Code für Ampulle</div>
	 * <div class="fr">Code de ampoule</div>
	 * <div class="it">Code per Fiala</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AMPULE_CODE = "732978007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Applicator</div>
	 * <div class="de">Code für Applikator</div>
	 * <div class="fr">Code de applicateur</div>
	 * <div class="it">Code per Applicatore</div>
	 * <!-- @formatter:on -->
	 */
	public static final String APPLICATOR_CODE = "732980001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Bag</div>
	 * <div class="de">Code für Tasche</div>
	 * <div class="fr">Code de poche</div>
	 * <div class="it">Code per Sacca</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BAG_CODE = "732982009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Barrel</div>
	 * <div class="de">Code für Kanister</div>
	 * <div class="fr">Code de fût</div>
	 * <div class="it">Code per Fusto</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BARREL_CODE = "732983004";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Blister</div>
	 * <div class="de">Code für Blisterpackung</div>
	 * <div class="fr">Code de plaquette</div>
	 * <div class="it">Code per Blister</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BLISTER_CODE = "732984005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Block</div>
	 * <div class="de">Code für Stein</div>
	 * <div class="fr">Code de bloc</div>
	 * <div class="it">Code per Blocco</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BLOCK_CODE = "732985006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Bottle</div>
	 * <div class="de">Code für Flasche</div>
	 * <div class="fr">Code de flacon</div>
	 * <div class="it">Code per Flacone</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BOTTLE_CODE = "732986007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Bq</div>
	 * <div class="de">Code für Bq</div>
	 * <div class="fr">Code de Bq</div>
	 * <div class="it">Code per Bq</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BQ_CODE = "Bq";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cachet</div>
	 * <div class="de">Code für Oblatenkapsel</div>
	 * <div class="fr">Code de cachet</div>
	 * <div class="it">Code per Cachet</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CACHET_CODE = "732987003";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Capsule</div>
	 * <div class="de">Code für Kapsel</div>
	 * <div class="fr">Code de capsule</div>
	 * <div class="it">Code per Capsula</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CAPSULE_CODE = "732937005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cartridge</div>
	 * <div class="de">Code für Patrone</div>
	 * <div class="fr">Code de cartouche</div>
	 * <div class="it">Code per Cartuccia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CARTRIDGE_CODE = "732988008";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for CFU</div>
	 * <div class="de">Code für CFU</div>
	 * <div class="fr">Code de CFU</div>
	 * <div class="it">Code per CFU</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CFU_CODE = "CFU";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Chewing gum</div>
	 * <div class="de">Code für Kaugummi</div>
	 * <div class="fr">Code de gomme à mâcher</div>
	 * <div class="it">Code per Gomma da masticare</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHEWING_GUM_CODE = "732989000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for cm</div>
	 * <div class="de">Code für cm</div>
	 * <div class="fr">Code de cm</div>
	 * <div class="it">Code per cm</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CM_CODE = "cm";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for cm2</div>
	 * <div class="de">Code für cm2</div>
	 * <div class="fr">Code de cm2</div>
	 * <div class="it">Code per cm2</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CM2_CODE = "cm2";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for cm3</div>
	 * <div class="de">Code für cm3</div>
	 * <div class="fr">Code de cm3</div>
	 * <div class="it">Code per cm3</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CM3_CODE = "cm3";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Container</div>
	 * <div class="de">Code für Behältnis</div>
	 * <div class="fr">Code de récipient</div>
	 * <div class="it">Code per Contenitore</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONTAINER_CODE = "732990009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cup</div>
	 * <div class="de">Code für Messbecher</div>
	 * <div class="fr">Code de godet</div>
	 * <div class="it">Code per Bicchiere dosatore</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CUP_CODE = "732991008";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cylinder</div>
	 * <div class="de">Code für Zylinder</div>
	 * <div class="fr">Code de cylindre</div>
	 * <div class="it">Code per Cilindro</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CYLINDER_CODE = "732992001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for d</div>
	 * <div class="de">Code für d</div>
	 * <div class="fr">Code de d</div>
	 * <div class="it">Code per d</div>
	 * <!-- @formatter:on -->
	 */
	public static final String D_CODE = "D";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dose</div>
	 * <div class="de">Code für Dos</div>
	 * <div class="fr">Code de dose</div>
	 * <div class="it">Code per dose</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DOSE_CODE = "{Dose}";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dressing</div>
	 * <div class="de">Code für Verband</div>
	 * <div class="fr">Code de compresse</div>
	 * <div class="it">Code per Garza</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DRESSING_CODE = "732993006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Drop</div>
	 * <div class="de">Code für Tropfen</div>
	 * <div class="fr">Code de goutte</div>
	 * <div class="it">Code per Goccia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DROP_CODE = "732994000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Film</div>
	 * <div class="de">Code für Film</div>
	 * <div class="fr">Code de film</div>
	 * <div class="it">Code per Film</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FILM_CODE = "732995004";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for g</div>
	 * <div class="de">Code für g</div>
	 * <div class="fr">Code de g</div>
	 * <div class="it">Code per g</div>
	 * <!-- @formatter:on -->
	 */
	public static final String G_CODE = "g";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for GBq</div>
	 * <div class="de">Code für GBq</div>
	 * <div class="fr">Code de GBq</div>
	 * <div class="it">Code per GBq</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GBQ_CODE = "GBq";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for h</div>
	 * <div class="de">Code für h</div>
	 * <div class="fr">Code de h</div>
	 * <div class="it">Code per h</div>
	 * <!-- @formatter:on -->
	 */
	public static final String H_CODE = "HR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Implant</div>
	 * <div class="de">Code für Implantat</div>
	 * <div class="fr">Code de implant</div>
	 * <div class="it">Code per Impianto</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMPLANT_CODE = "732996003";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhaler</div>
	 * <div class="de">Code für Inhalator</div>
	 * <div class="fr">Code de inhalateur</div>
	 * <div class="it">Code per Inalatore</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALER_CODE = "732997007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Insert</div>
	 * <div class="de">Code für Insert</div>
	 * <div class="fr">Code de insert</div>
	 * <div class="it">Code per Inserto</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSERT_CODE = "732998002";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for international unit</div>
	 * <div class="de">Code für Internationale Einheit</div>
	 * <div class="fr">Code de unité(s) internationale(s)</div>
	 * <div class="it">Code per unità internazionale(i)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTERNATIONAL_UNIT_CODE = "iU";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Jar</div>
	 * <div class="de">Code für Weithalsgefäss</div>
	 * <div class="fr">Code de pot</div>
	 * <div class="it">Code per Vasetto</div>
	 * <!-- @formatter:on -->
	 */
	public static final String JAR_CODE = "732999005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for kBq</div>
	 * <div class="de">Code für kBq</div>
	 * <div class="fr">Code de kBq</div>
	 * <div class="it">Code per kBq</div>
	 * <!-- @formatter:on -->
	 */
	public static final String KBQ_CODE = "kBq";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for kcal</div>
	 * <div class="de">Code für kcal</div>
	 * <div class="fr">Code de kcal</div>
	 * <div class="it">Code per kcal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String KCAL_CODE = "kcal";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for kg</div>
	 * <div class="de">Code für kg</div>
	 * <div class="fr">Code de kg</div>
	 * <div class="it">Code per kg</div>
	 * <!-- @formatter:on -->
	 */
	public static final String KG_CODE = "kg";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for kJ</div>
	 * <div class="de">Code für kJ</div>
	 * <div class="fr">Code de kJ</div>
	 * <div class="it">Code per kJ</div>
	 * <!-- @formatter:on -->
	 */
	public static final String KJ_CODE = "kJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Lozenge</div>
	 * <div class="de">Code für Lutschtablette</div>
	 * <div class="fr">Code de pastille dure</div>
	 * <div class="it">Code per Pastiglia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LOZENGE_CODE = "733000006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for lt</div>
	 * <div class="de">Code für lt</div>
	 * <div class="fr">Code de lt</div>
	 * <div class="it">Code per l</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LT_CODE = "L";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Lyophilisate</div>
	 * <div class="de">Code für Lyophilisat</div>
	 * <div class="fr">Code de lyophilisat</div>
	 * <div class="it">Code per Liofilizzato</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LYOPHILISATE_CODE = "733001005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Matrix</div>
	 * <div class="de">Code für Matrix</div>
	 * <div class="fr">Code de matrice</div>
	 * <div class="it">Code per Matrice</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MATRIX_CODE = "733002003";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for MBq</div>
	 * <div class="de">Code für MBq</div>
	 * <div class="fr">Code de MBq</div>
	 * <div class="it">Code per MBq</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MBQ_CODE = "MBq";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for meq</div>
	 * <div class="de">Code für meq</div>
	 * <div class="fr">Code de mEq</div>
	 * <div class="it">Code per mEq</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MEQ_CODE = "meq";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for mg</div>
	 * <div class="de">Code für mg</div>
	 * <div class="fr">Code de mg</div>
	 * <div class="it">Code per mg</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MG_CODE = "mg";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for MillionInternationalUnit</div>
	 * <div class="de">Code für MioUI</div>
	 * <div class="fr">Code de MioUI</div>
	 * <div class="it">Code per MioUI</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MILLIONINTERNATIONALUNIT_CODE = "10*6.iU";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for min</div>
	 * <div class="de">Code für min</div>
	 * <div class="fr">Code de min</div>
	 * <div class="it">Code per min</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MIN_CODE = "MIN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for MioU</div>
	 * <div class="de">Code für MioU</div>
	 * <div class="fr">Code de MioU</div>
	 * <div class="it">Code per MioU</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MIOU_CODE = "10*6.U";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ml</div>
	 * <div class="de">Code für ml</div>
	 * <div class="fr">Code de ml</div>
	 * <div class="it">Code per ml</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ML_CODE = "mL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for mm2</div>
	 * <div class="de">Code für mm2</div>
	 * <div class="fr">Code de mm2</div>
	 * <div class="it">Code per mm2</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MM2_CODE = "mm2";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for mmol</div>
	 * <div class="de">Code für mmol</div>
	 * <div class="fr">Code de mmol</div>
	 * <div class="it">Code per mmol</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MMOL_CODE = "mmol";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for mol</div>
	 * <div class="de">Code für mol</div>
	 * <div class="fr">Code de mol</div>
	 * <div class="it">Code per mol</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MOL_CODE = "mol";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ng</div>
	 * <div class="de">Code für ng</div>
	 * <div class="fr">Code de ng</div>
	 * <div class="it">Code per ng</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NG_CODE = "ng";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for nl</div>
	 * <div class="de">Code für nl</div>
	 * <div class="fr">Code de nl</div>
	 * <div class="it">Code per nl</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NL_CODE = "nL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Package</div>
	 * <div class="de">Code für Packung</div>
	 * <div class="fr">Code de emballage</div>
	 * <div class="it">Code per confezione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PACKAGE_CODE = "{Package}";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pad</div>
	 * <div class="de">Code für Pad</div>
	 * <div class="fr">Code de tampon applicateur</div>
	 * <div class="it">Code per Tampone</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PAD_CODE = "733003008";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pastille</div>
	 * <div class="de">Code für Pastille</div>
	 * <div class="fr">Code de pastille molle</div>
	 * <div class="it">Code per Pastiglia molle</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PASTILLE_CODE = "733004002";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Patch</div>
	 * <div class="de">Code für Pflaster</div>
	 * <div class="fr">Code de patch</div>
	 * <div class="it">Code per Cerotto</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PATCH_CODE = "733005001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pen</div>
	 * <div class="de">Code für Pen</div>
	 * <div class="fr">Code de stylo</div>
	 * <div class="it">Code per Penna</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PEN_CODE = "733006000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for %</div>
	 * <div class="de">Code für %</div>
	 * <div class="fr">Code de %</div>
	 * <div class="it">Code per %</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PERCENT_CODE = "%";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pessary</div>
	 * <div class="de">Code für Pessar</div>
	 * <div class="fr">Code de ovule</div>
	 * <div class="it">Code per Ovulo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PESSARY_CODE = "733007009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Piece(s)</div>
	 * <div class="de">Code für Stk</div>
	 * <div class="fr">Code de pce</div>
	 * <div class="it">Code per pz</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PIECE_CODE = "U{PIECE(S)}";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pillule</div>
	 * <div class="de">Code für Streukügelchen</div>
	 * <div class="fr">Code de granule</div>
	 * <div class="it">Code per Granuli</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PILLULE_CODE = "733008004";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pipette</div>
	 * <div class="de">Code für Pipette</div>
	 * <div class="fr">Code de pipette</div>
	 * <div class="it">Code per Pipetta</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PIPETTE_CODE = "733009007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Plaster</div>
	 * <div class="de">Code für Pflaster</div>
	 * <div class="fr">Code de emplâtre</div>
	 * <div class="it">Code per Cerotto</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PLASTER_CODE = "733010002";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Plug</div>
	 * <div class="de">Code für Einsatz</div>
	 * <div class="fr">Code de support poreux</div>
	 * <div class="it">Code per Supporto</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PLUG_CODE = "733011003";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pouch</div>
	 * <div class="de">Code für Beutelchen</div>
	 * <div class="fr">Code de petit sachet</div>
	 * <div class="it">Code per Sachetta</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POUCH_CODE = "733012005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ppm</div>
	 * <div class="de">Code für ppm</div>
	 * <div class="fr">Code de ppm</div>
	 * <div class="it">Code per ppm</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PPM_CODE = "PPM ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Sachet</div>
	 * <div class="de">Code für Beutel</div>
	 * <div class="fr">Code de sachet</div>
	 * <div class="it">Code per Bustina</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SACHET_CODE = "733013000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for sec</div>
	 * <div class="de">Code für sec</div>
	 * <div class="fr">Code de sec</div>
	 * <div class="it">Code per sec</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SEC_CODE = "S";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Sponge</div>
	 * <div class="de">Code für Schwämmchen</div>
	 * <div class="fr">Code de eponge</div>
	 * <div class="it">Code per Spugna</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SPONGE_CODE = "733014006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Spoonful</div>
	 * <div class="de">Code für ein Löffel voll</div>
	 * <div class="fr">Code de cuillerée</div>
	 * <div class="it">Code per Cucciaio</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SPOONFUL_CODE = "733015007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Stick</div>
	 * <div class="de">Code für Stäbchen</div>
	 * <div class="fr">Code de bâton</div>
	 * <div class="it">Code per Stick</div>
	 * <!-- @formatter:on -->
	 */
	public static final String STICK_CODE = "733016008";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Straw</div>
	 * <div class="de">Code für Trinkhalm</div>
	 * <div class="fr">Code de paille</div>
	 * <div class="it">Code per Cannuccia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String STRAW_CODE = "733017004";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Strip</div>
	 * <div class="de">Code für Streifen</div>
	 * <div class="fr">Code de bandelette</div>
	 * <div class="it">Code per Strip</div>
	 * <!-- @formatter:on -->
	 */
	public static final String STRIP_CODE = "733018009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Suppository</div>
	 * <div class="de">Code für Zäpfchen</div>
	 * <div class="fr">Code de suppositoire</div>
	 * <div class="it">Code per Supposta</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUPPOSITORY_CODE = "733019001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Syringe</div>
	 * <div class="de">Code für Spritze</div>
	 * <div class="fr">Code de seringue</div>
	 * <div class="it">Code per Siringa</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SYRINGE_CODE = "733020007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for System</div>
	 * <div class="de">Code für System</div>
	 * <div class="fr">Code de système</div>
	 * <div class="it">Code per Sistema</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SYSTEM_CODE = "733021006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for tablespoon - metric</div>
	 * <div class="de">Code für Esslöffel</div>
	 * <div class="fr">Code de c. à soupe</div>
	 * <div class="it">Code per cucchiaio da minestra</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TABLESPOON_METRIC_CODE = "tbs_m";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Tablet</div>
	 * <div class="de">Code für Tablette</div>
	 * <div class="fr">Code de comprimé</div>
	 * <div class="it">Code per Compressa</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TABLET_CODE = "732936001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Tampon</div>
	 * <div class="de">Code für Tampon</div>
	 * <div class="fr">Code de tampon diffuseur</div>
	 * <div class="it">Code per Tampone</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TAMPON_CODE = "733022004";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for teaspoon - metric</div>
	 * <div class="de">Code für Teelöffel</div>
	 * <div class="fr">Code de c. à café</div>
	 * <div class="it">Code per cucchiaino da caffè</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TEASPOON_METRIC_CODE = "tsp_m";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Thousand Per * Unit</div>
	 * <div class="de">Code für Tausend Einheiten</div>
	 * <div class="fr">Code de millier d'unités</div>
	 * <div class="it">Code per mille per unità *</div>
	 * <!-- @formatter:on -->
	 */
	public static final String THOUSAND_PER_STAR_UNIT_CODE = "10*3.U";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Thread</div>
	 * <div class="de">Code für Faden</div>
	 * <div class="fr">Code de fil</div>
	 * <div class="it">Code per Filo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String THREAD_CODE = "733023009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Tube</div>
	 * <div class="de">Code für Tube</div>
	 * <div class="fr">Code de tube</div>
	 * <div class="it">Code per Tubo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TUBE_CODE = "733024003";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for unit</div>
	 * <div class="de">Code für Einheit</div>
	 * <div class="fr">Code de unité(s)</div>
	 * <div class="it">Code per unità</div>
	 * <!-- @formatter:on -->
	 */
	public static final String UNIT_CODE = "U";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Vessel</div>
	 * <div class="de">Code für Gefäss</div>
	 * <div class="fr">Code de récipient étanche</div>
	 * <div class="it">Code per Recipiente a tenuta</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VESSEL_CODE = "733025002";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Vial</div>
	 * <div class="de">Code für Durchstechflasche</div>
	 * <div class="fr">Code de petit flacon</div>
	 * <div class="it">Code per Flaconcino</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VIAL_CODE = "733026001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for µg</div>
	 * <div class="de">Code für µg</div>
	 * <div class="fr">Code de µg</div>
	 * <div class="it">Code per µg</div>
	 * <!-- @formatter:on -->
	 */
	public static final String _G_CODE = "ug";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for µl</div>
	 * <div class="de">Code für µl</div>
	 * <div class="fr">Code de µl</div>
	 * <div class="it">Code per µl</div>
	 * <!-- @formatter:on -->
	 */
	public static final String _L_CODE = "uL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for µmol</div>
	 * <div class="de">Code für µmol</div>
	 * <div class="fr">Code de µmol</div>
	 * <div class="it">Code per µmol</div>
	 * <!-- @formatter:on -->
	 */
	public static final String _MOL_CODE = "umol";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.1.11.83";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "UnitsOfPresentation";

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
	public static UnitsOfPresentation getEnum(final String code) {
		for (final UnitsOfPresentation x : values()) {
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
			Enum.valueOf(UnitsOfPresentation.class, enumName);
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
		for (final UnitsOfPresentation x : values()) {
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
	UnitsOfPresentation(final String code, final String codeSystem, final String displayName,
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
