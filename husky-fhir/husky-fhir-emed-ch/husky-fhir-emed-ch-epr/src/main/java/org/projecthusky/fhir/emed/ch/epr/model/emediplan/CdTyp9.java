package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.common.enums.UnitCode;
import org.projecthusky.fhir.emed.ch.epr.enums.RegularUnitCodeAmbu;

/**
 * HCI INDEX CdTyp9 table.
 */
@Getter
public enum CdTyp9 implements EMediplanEnum<String> {
    PERCENT("%"),
    APPLICATION("Appl"),
    BLISTER("Blist"),
    BECQUEREL("Bq"),
    SACHET("Btl"),
    DOSE("Dos"),
    PIPETTE("Dosierpip"),
    SYRINGE("Dosierspr"),
    UNIT_ALT("E"),
    TABLESPOON("EL"),
    BOTTLE("Fl"),
    GRAM("g"),
    GIGABECQUEREL("GBq"),
    DROP("gtt"),
    HOUR("h"),
    ACTUATION("Hub"),
    YEAR("Jahr"),
    KILOBECQUEREL("kBq"),
    KILOCALORIE("kcal"),
    KILOGRAM("kg"),
    KILOJOULE("kJ"),
    LITRE("L"),
    CUP("MB"),
    MEGABECQUEREL("MBq"),
    MICROGRAM("mcg"),
    MICROLITRE("mcl"),
    MICROMOLE("mcmol"),
    MILLIGRAM("mg"),
    MILLION_UNIT("Mio U"),
    MILLION_INTERNATIONAL_UNIT("Mio UI"),
    MILLILITRE("ml"),
    MILLIMOLE("mmol"),
    MOLE("mol"),
    MONTH("Monat"),
    MILLION_UNIT_ALT("MU"),
    UNKNOWN("N/A"),
    NANOGRAM("ng"),
    SPOONFUL("nML"),
    NANOMOLE("nmol"),
    CARTRIDGE("Patr"),
    PACKAGE("Pck"),
    PLASTER("Pfl"),
    PIECE("Stk"),
    TABLET("tablet"),
    DAY("Tag"),
    TUBE("Tb"),
    INDIVIDUAL_PACKAGE("Teilpck"),
    TEASPOON("TL"),
    THOUSAND_UNIT("TU"),
    UNIT("U"),
    INTERNATIONAL_UNIT("UI");

    @JsonValue
    final String code;

    CdTyp9(final String code) {
        this.code = code;
    }

    /**
     * Converts a {@link RegularUnitCodeAmbu} unit to a {@link CdTyp9} unit, based on the
     * <a href="http://fhir.ch/ig/ch-emed-epr/ConceptMap/CHEMEDEPRAmountQuantityUnitCodeToCdTyp9">
     * CHEMEDEPRAmountQuantityUnitCodeToCdTyp9</a> concept map.
     *
     * @param unit The {@link RegularUnitCodeAmbu} unit to be converted.
     * @return The resulting {@link CdTyp9} unit.
     */
    public static CdTyp9 fromRegularUnitCodeAmbu(final RegularUnitCodeAmbu unit){
        return switch(unit) {
            case AMPULE, APPLICATOR, BARREL, BLOCK, CACHET, CAPSULE, CHEWING_GUM, CFU, CM, CM2, CONTAINER, CYLINDER, DRESSING, FILM,
                 IMPLANT, INHALER, INSERT, JAR, LYOPHILISATE, MATRIX, MEQ, MM2, NL, PAD, PASTILLE, PEN, PESSARY, PILLULE,
                 PLUG, PPM, SPONGE, STICK, STRAW, STRIP, SUPPOSITORY, SYSTEM, TAMPON, THREAD, VESSEL, VIAL -> UNKNOWN;
            case ACTUATION -> ACTUATION;
            case APPLICATION_UNIT_OF_PRODUCT_USAGE_QUALIFIER_VALUE -> APPLICATION;
            case BAG -> SACHET;
            case BQ -> BECQUEREL;
            case BLISTER -> BLISTER;
            case BOTTLE -> BOTTLE;
            case CARTRIDGE -> CARTRIDGE;
            case CM3 -> MILLILITRE;
            case CUP -> CUP;
            case DOSE -> DOSE;
            case DROP -> DROP;
            case G -> GRAM;
            case GBQ -> GIGABECQUEREL;
            case INTERNATIONAL_UNIT -> INTERNATIONAL_UNIT;
            case KBQ -> KILOBECQUEREL;
            case KCAL -> KILOCALORIE;
            case KG -> KILOGRAM;
            case KJ -> KILOJOULE;
            case LT -> LITRE;
            case MBQ -> MEGABECQUEREL;
            case MG -> MILLIGRAM;
            case MILLIONINTERNATIONALUNIT -> MILLION_INTERNATIONAL_UNIT;
            case MIOU -> MILLION_UNIT;
            case ML -> MILLILITRE;
            case MMOL -> MILLIMOLE;
            case MOL -> MOLE;
            case NG -> NANOGRAM;
            case NMOL -> NANOMOLE;
            case PACKAGE -> PACKAGE;
            case PATCH -> PLASTER;
            case PERCENT -> PERCENT;
            case PIECE -> PIECE;
            case PIPETTE -> PIPETTE;
            case PLASTER -> PLASTER;
            case POUCH -> SACHET;
            case SACHET -> SACHET;
            case SPOONFUL -> SPOONFUL;
            case SYRINGE -> SYRINGE;
            case TABLESPOON_METRIC -> TABLESPOON;
            case TABLET -> TABLET;
            case TEASPOON_METRIC -> TEASPOON;
            case THOUSAND_PER_STAR_UNIT -> THOUSAND_UNIT;
            case TUBE -> TUBE;
            case UG -> MICROGRAM;
            case UL -> MICROLITRE;
            case UMOL -> MICROMOLE;
            case UNIT -> UNIT;
        };
    }

    /**
     * Gets the FHIR representation of the unit, if possible, {@code null} otherwise.
     */
    public @Nullable UnitCode toFhir() {
        return switch(this) {
            case PERCENT -> UnitCode.PERCENT;
            case APPLICATION -> UnitCode.APPLICATION_UNIT_OF_PRODUCT_USAGE_QUALIFIER_VALUE;
            case BLISTER -> UnitCode.BLISTER;
            case BECQUEREL -> UnitCode.BQ;
            case SACHET -> UnitCode.BAG;
            case DOSE -> UnitCode.DOSE;
            case PIPETTE -> UnitCode.PIPETTE;
            case SYRINGE -> UnitCode.SYRINGE;
            case UNIT_ALT, UNIT -> UnitCode.UNIT;
            case TABLESPOON -> UnitCode.TABLESPOON_METRIC;
            case BOTTLE -> UnitCode.BOTTLE;
            case GRAM -> UnitCode.G;
            case GIGABECQUEREL -> UnitCode.GBQ;
            case DROP -> UnitCode.DROP;
            case ACTUATION -> UnitCode.ACTUATION;
            case KILOBECQUEREL -> UnitCode.KBQ;
            case KILOCALORIE -> UnitCode.KCAL;
            case KILOGRAM -> UnitCode.KG;
            case KILOJOULE -> UnitCode.KJ;
            case LITRE -> UnitCode.LT;
            case CUP -> UnitCode.CUP;
            case MEGABECQUEREL -> UnitCode.MBQ;
            case MICROGRAM -> UnitCode.UG;
            case MICROLITRE -> UnitCode.UL;
            case MICROMOLE -> UnitCode.UMOL;
            case MILLIGRAM -> UnitCode.MG;
            case MILLION_UNIT, MILLION_UNIT_ALT -> UnitCode.MIOU;
            case MILLION_INTERNATIONAL_UNIT -> UnitCode.MILLIONINTERNATIONALUNIT;
            case MILLILITRE -> UnitCode.ML;
            case MILLIMOLE -> UnitCode.MMOL;
            case MOLE -> UnitCode.MOL;
            case NANOGRAM -> UnitCode.NG;
            case SPOONFUL -> UnitCode.SPOONFUL;
            case NANOMOLE -> UnitCode.NMOL;
            case CARTRIDGE -> UnitCode.CARTRIDGE;
            case PACKAGE, INDIVIDUAL_PACKAGE -> UnitCode.PACKAGE;
            case PLASTER -> UnitCode.PLASTER;
            case PIECE -> UnitCode.PIECE;
            case TABLET -> UnitCode.TABLET;
            case TUBE -> UnitCode.TUBE;
            case TEASPOON -> UnitCode.TEASPOON_METRIC;
            case THOUSAND_UNIT -> UnitCode.THOUSAND_PER_STAR_UNIT;
            case INTERNATIONAL_UNIT -> UnitCode.INTERNATIONAL_UNIT;
            case HOUR -> UnitCode.H;
            case YEAR -> UnitCode.A;
            case MONTH -> UnitCode.MO;
            case DAY -> UnitCode.D;
            case UNKNOWN -> null;
        };
    }
}
