package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.common.enums.RouteOfAdministrationEdqm;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanEnum;

import java.util.Objects;

/**
 * HCI INDEX CdTyp26 table (route of administration).
 */
@Getter
public enum CdTyp26 implements EMediplanEnum<String> {
    INTRAVESICAL_INJECTION("BLADINJ"),
    INTRAVESICAL_INSTILLATION("BLADINSTL"),
    BUCCAL("BUC"),
    CHEW("CHEW"),
    DENTAL("DEN"),
    ENDOSINUSIAL("ENDOSINUS"),
    ENDOCERVICAL("ENDOZERV"),
    EPIDURAL_INFUSION("EPI"),
    EPIDURAL_INJECTION("EPIDURINJ"),
    EPILESIONAL("EPILESION"),
    ENDOTRACHEAL("ET"),
    ENDOTRACHEAL_INSTILLATION("ETINSTL"),
    EXTRAAMNIOTIC_INJECTION("EXTAMNIOINJ"),
    EXTRACORPOREAL("EXTCORP"),
    EXTRACORPOREAL_INJECTION("EXTCORPINJ"),
    EXTRAPLEURAL_INFUSION("EXTPLRINFUS"),
    GARGLE("GARGLE"),
    GINGIVAL("GIN"),
    GINGIVAL_INJECTION("GINGINJ"),
    GASTROINTESTINAL_INSTILLATION("GT"),
    HAEMODIALYSIS("HEMODIFF"),
    INTRAARTERIAL_INFUSION("IA"),
    INTRAARTERIAL_INJECTION("IAINJ"),
    INTRAAMNIOTIC_INJECTION("IAMNIOINJ"),
    INTRAARTICULAR("IARTINJ"),
    INTRABURSAL("IBURSINJ"),
    INTRACARDIAC_INJECTION("ICARDINJ"),
    INTRACEREBRAL("ICEREBRAL"),
    INTRACERVICAL_INJECTION("ICERVICAL"),
    INTRACHOLANGIOPANCREATIC_INJECTION("ICHOLANGIOP"),
    INTRACISTERNAL("ICISTERN"),
    INTRACORNEAL("ICORNEAL"),
    INTRACORONARY_INJECTION("ICORONINJ"),
    INTRACAVERNOUS("ICORPCAVINJ"),
    INTRADERMAL_INJECTION("IDINJ"),
    INTRADISCAL_INJECTION("IDISCINJ"),
    INTRADUODENAL_INSTILLATION("IDUODINSTIL"),
    INTRAEPIDERMAL("IEPIDERMAL"),
    INTRAGASTRIC_INSTILLATION("IGASTINSTIL"),
    INTRAGLANDULAR_INJECTION("IGLANDINJ"),
    INTRACAMERAL("IKAMERAL"),
    INTRACARTILAGINEOUS("IKARTILAG"),
    INTRALESIONAL("ILES"),
    INTRALESIONAL_INJECTION("ILESINJ"),
    INTRALYMPHATIC("ILYMPJINJ"),
    INTRAMUSCULAR_INJECTION("IM"),
    IMPLANTATION("IMPLANTINSE"),
    INFILTRATION_INJECTION("INFILTINJ"),
    INTRAOCULAR_INJECTION("IOINJ"),
    INTRAOCULAR_INSTILLATION("IOINSTIL"),
    IONTOPHORESIS("IONTOPHORES"),
    INTRAOSSEUS_INJECTION("IOSSINJ"),
    INTRAPERITONEAL("IPDP"),
    INTRAPERICARDIAL_INJECTION("IPERICARDIN"),
    INTRAPLEURAL("IPLRINJ"),
    INTRAPORTAL_INFUSION("IPORTAL"),
    INTRAPORTAL_INJECTION("IPORTALINJ"),
    INTRAPROSTATIC("IPROSTAT"),
    INTRAPUTAMINAL("IPUTAMINAL"),
    INTRASTERNAL_INJECTION("ISTERNALINJ"),
    INTRATHECAL_INFUSION("IT"),
    INTRATHECAL_INJECTION("ITINJ"),
    INTRATUMORAL("ITUMINJ"),
    INTRAUTERINE_INSERTION("IU"),
    INTRAUTERINE_INJECTION("IUINJ"),
    INTRAVENOUS_INFUSION("IV"),
    INTRACEREBROVENTRICULAR("IVENTCERE"),
    INTRAVENOUS_CATHETER_FLUSH("INTRAIVFLUSH"),
    INTRAVENOUS_INJECTION("IVINJ"),
    INTRAVITREAL_INJECTION("IVITINJ"),
    LARYNGOPHARYNGEAL("LARYNGOPHAR"),
    NASAL("NASAL"),
    NASAL_INSTILLATION("NASALINSTIL"),
    NASAL_INHALATION("NASINHL"),
    OPHTALMIC("OPTHALTA"),
    ORAL_INHALATION("ORINHL"),
    OROMUCOSAL("ORMUC"),
    OROMUCOSAL_SPRAY("ORMUCSP"),
    OROPHARYNGEAL_SPRAY("OROPHARTA"),
    AURICULAR_INSTILLATION("OT"),
    PERIARTICULAR("PAINJ"),
    PERIODONTAL("PDONTTA"),
    PERIOSSEOUS("PERIOSS"),
    PERINEURAL_INFUSION("PNINFUS"),
    PERINEURAL_INJECTION("PNINJ"),
    PERORAL("PO"),
    POSTERIOR_JUXTASCLERAL("POSTJUXTASC"),
    PERITUMORAL("PTINJ"),
    RETROBULBAR_INJECTION("RBINJ"),
    RECTAL("RECTAL"),
    SCARIFICATION("SCARIFICAT"),
    SUBCONJUNCTIVAL_INJECTION("SCINJ"),
    TOPICAL("SKIN"),
    SUBLINGUAL("SL"),
    SUBCUTANEOUS_INJECTION("SQ"),
    SUBCUTANEOUS_IMPLANTATION("SQIMPLNT"),
    SUBCUTANEOUS_INFUSION("SQINFUS"),
    SUBRETINAL_INJECTION("SRINJ"),
    SUBMUCOSAL_INJECTION("SUBMUCINJ"),
    SUCK("SUCK"),
    TRANSDERMAL("TRNSDERMD"),
    URETHRAL_INJECTION("URETHINJ"),
    URETHRAL_INSTILLATION("URETHINSTL"),
    VAGINAL("VAGINS");

    @JsonValue
    final String code;

    CdTyp26(final String code) {
        this.code = code;
    }

    /**
     * Gets the <a href="http://fhir.ch/ig/ch-term/ValueSet/edqm-routeofadministration">EDQM route of administration</a>
     * code equivalent to this CdTyp26 code, based on the
     * <a href="http://fhir.ch/ig/ch-emed-epr/ConceptMap/CdTyp26ToRouteOfAdministrationEDQM">CH EMED EPR concept map</a>.
     *
     * @return The equivalent EDQM route of administration code, if there is one, otherwise {@code null}.
     */
    public @Nullable RouteOfAdministrationEdqm toEdqm() {
        return switch(this) {
            case AURICULAR_INSTILLATION -> RouteOfAdministrationEdqm.AURICULAR_USE;
            case BUCCAL -> RouteOfAdministrationEdqm.BUCCAL_USE;
            case CHEW -> RouteOfAdministrationEdqm.ORAL_USE;
            case DENTAL -> RouteOfAdministrationEdqm.DENTAL_USE;
            case ENDOSINUSIAL -> RouteOfAdministrationEdqm.ENDOSINUSIAL_USE;
            case ENDOCERVICAL -> RouteOfAdministrationEdqm.ENDOCERVICAL_USE;
            case ENDOTRACHEAL, ENDOTRACHEAL_INSTILLATION -> RouteOfAdministrationEdqm.ENDOTRACHEOPULMONARY_USE;
            case EPIDURAL_INFUSION, EPIDURAL_INJECTION -> RouteOfAdministrationEdqm.EPIDURAL_USE;
            case EPILESIONAL -> RouteOfAdministrationEdqm.EPILESIONAL_USE;
            case EXTRAAMNIOTIC_INJECTION -> RouteOfAdministrationEdqm.EXTRAAMNIOTIC_USE;
            case EXTRACORPOREAL, EXTRACORPOREAL_INJECTION -> RouteOfAdministrationEdqm.EXTRACORPOREAL_USE;
            case EXTRAPLEURAL_INFUSION -> RouteOfAdministrationEdqm.EXTRAPLEURAL_USE;
            case GARGLE -> RouteOfAdministrationEdqm.OROPHARYNGEAL_USE;
            case GASTROINTESTINAL_INSTILLATION -> RouteOfAdministrationEdqm.GASTROENTERAL_USE;
            case GINGIVAL, GINGIVAL_INJECTION -> RouteOfAdministrationEdqm.GINGIVAL_USE;
            case HAEMODIALYSIS -> RouteOfAdministrationEdqm.HAEMODIALYSIS;
            case IMPLANTATION -> RouteOfAdministrationEdqm.IMPLANTATION;
            case INFILTRATION_INJECTION -> RouteOfAdministrationEdqm.INFILTRATION;
            case INTRAAMNIOTIC_INJECTION -> RouteOfAdministrationEdqm.INTRAAMNIOTIC_USE;
            case INTRAARTERIAL_INFUSION, INTRAARTERIAL_INJECTION -> RouteOfAdministrationEdqm.INTRAARTERIAL_USE;
            case INTRAARTICULAR -> RouteOfAdministrationEdqm.INTRAARTICULAR_USE;
            case INTRABURSAL -> RouteOfAdministrationEdqm.INTRABURSAL_USE;
            case INTRACAMERAL -> RouteOfAdministrationEdqm.INTRACAMERAL_USE;
            case INTRACARDIAC_INJECTION -> RouteOfAdministrationEdqm.INTRACARDIAC_USE;
            case INTRACAVERNOUS -> RouteOfAdministrationEdqm.INTRACAVERNOUS_USE;
            case INTRACEREBRAL -> RouteOfAdministrationEdqm.INTRACEREBRAL_USE;
            case INTRACEREBROVENTRICULAR -> RouteOfAdministrationEdqm.INTRACEREBROVENTRICULAR_USE;
            case INTRACERVICAL_INJECTION -> RouteOfAdministrationEdqm.INTRACERVICAL_USE;
            case INTRACHOLANGIOPANCREATIC_INJECTION -> RouteOfAdministrationEdqm.INTRACHOLANGIOPANCREATIC_USE;
            case INTRACISTERNAL -> RouteOfAdministrationEdqm.INTRACISTERNAL_USE;
            case INTRACORNEAL -> RouteOfAdministrationEdqm.INTRACORNEAL_USE;
            case INTRACORONARY_INJECTION -> RouteOfAdministrationEdqm.INTRACORONARY_USE;
            case INTRADERMAL_INJECTION -> RouteOfAdministrationEdqm.INTRADERMAL_USE;
            case INTRADISCAL_INJECTION -> RouteOfAdministrationEdqm.INTRADISCAL_USE;
            case INTRADUODENAL_INSTILLATION -> RouteOfAdministrationEdqm.INTESTINAL_USE;
            case INTRAEPIDERMAL -> RouteOfAdministrationEdqm.INTRAEPIDERMAL_USE;
            case INTRAGASTRIC_INSTILLATION -> RouteOfAdministrationEdqm.GASTRIC_USE;
            case INTRAGLANDULAR_INJECTION -> RouteOfAdministrationEdqm.INTRAGLANDULAR_USE;
            case INTRACARTILAGINEOUS -> RouteOfAdministrationEdqm.INTRACARTILAGINOUS_USE;
            case INTRALESIONAL, INTRALESIONAL_INJECTION -> RouteOfAdministrationEdqm.INTRALESIONAL_USE;
            case INTRALYMPHATIC -> RouteOfAdministrationEdqm.INTRALYMPHATIC_USE;
            case INTRAMUSCULAR_INJECTION -> RouteOfAdministrationEdqm.INTRAMUSCULAR_USE;
            case INTRAOCULAR_INJECTION, INTRAOCULAR_INSTILLATION -> RouteOfAdministrationEdqm.INTRAOCULAR_USE;
            case INTRAOSSEUS_INJECTION -> RouteOfAdministrationEdqm.INTRAOSSEOUS_USE;
            case INTRAPERICARDIAL_INJECTION -> RouteOfAdministrationEdqm.INTRAPERICARDIAL_USE;
            case INTRAPERITONEAL -> RouteOfAdministrationEdqm.INTRAPERITONEAL_USE;
            case INTRAPLEURAL -> RouteOfAdministrationEdqm.INTRAPLEURAL_USE;
            case INTRAPORTAL_INFUSION, INTRAPORTAL_INJECTION -> RouteOfAdministrationEdqm.INTRAPORTAL_USE;
            case INTRAPROSTATIC -> RouteOfAdministrationEdqm.INTRAPROSTATIC_USE;
            case INTRAPUTAMINAL -> RouteOfAdministrationEdqm.INTRAPUTAMINAL_USE;
            case INTRASTERNAL_INJECTION -> RouteOfAdministrationEdqm.INTRASTERNAL_USE;
            case INTRATHECAL_INFUSION, INTRATHECAL_INJECTION -> RouteOfAdministrationEdqm.INTRATHECAL_USE;
            case INTRATUMORAL -> RouteOfAdministrationEdqm.INTRATUMORAL_USE;
            case INTRAUTERINE_INSERTION, INTRAUTERINE_INJECTION -> RouteOfAdministrationEdqm.INTRAUTERINE_USE;
            case INTRAVESICAL_INJECTION, INTRAVESICAL_INSTILLATION -> RouteOfAdministrationEdqm.INTRAVESICAL_USE;
            case INTRAVENOUS_INFUSION, INTRAVENOUS_INJECTION -> RouteOfAdministrationEdqm.INTRAVENOUS_USE;
            case INTRAVENOUS_CATHETER_FLUSH -> RouteOfAdministrationEdqm.ROUTE_OF_ADMINISTRATION_NOT_APPLICABLE;
            case INTRAVITREAL_INJECTION -> RouteOfAdministrationEdqm.INTRAVITREAL_USE;
            case IONTOPHORESIS -> RouteOfAdministrationEdqm.IONTOPHORESIS;
            case LARYNGOPHARYNGEAL -> RouteOfAdministrationEdqm.LARYNGOPHARYNGEAL_USE;
            case NASAL, NASAL_INSTILLATION, NASAL_INHALATION -> RouteOfAdministrationEdqm.NASAL_USE;
            case OPHTALMIC -> RouteOfAdministrationEdqm.OCULAR_USE;
            case ORAL_INHALATION -> RouteOfAdministrationEdqm.INHALATION_USE;
            case OROMUCOSAL, OROMUCOSAL_SPRAY -> RouteOfAdministrationEdqm.OROMUCOSAL_USE;
            case OROPHARYNGEAL_SPRAY -> RouteOfAdministrationEdqm.OROPHARYNGEAL_USE;
            case PERIARTICULAR -> RouteOfAdministrationEdqm.PERIARTICULAR_USE;
            case PERINEURAL_INFUSION, PERINEURAL_INJECTION -> RouteOfAdministrationEdqm.PERINEURAL_USE;
            case PERIODONTAL -> RouteOfAdministrationEdqm.PERIODONTAL_USE;
            case PERIOSSEOUS -> RouteOfAdministrationEdqm.PERIOSSEOUS_USE;
            case PERITUMORAL -> RouteOfAdministrationEdqm.PERITUMORAL_USE;
            case PERORAL -> RouteOfAdministrationEdqm.ORAL_USE;
            case POSTERIOR_JUXTASCLERAL -> RouteOfAdministrationEdqm.POSTERIOR_JUXTASCLERAL_USE;
            case RECTAL -> RouteOfAdministrationEdqm.RECTAL_USE;
            case RETROBULBAR_INJECTION -> RouteOfAdministrationEdqm.RETROBULBAR_USE;
            case SCARIFICATION -> RouteOfAdministrationEdqm.SKIN_SCARIFICATION;
            case SUBCONJUNCTIVAL_INJECTION -> RouteOfAdministrationEdqm.SUBCONJUNCTIVAL_USE;
            case SUBCUTANEOUS_IMPLANTATION  -> RouteOfAdministrationEdqm.IMPLANTATION;
            case SUBCUTANEOUS_INFUSION, SUBCUTANEOUS_INJECTION -> RouteOfAdministrationEdqm.SUBCUTANEOUS_USE;
            case SUBLINGUAL -> RouteOfAdministrationEdqm.SUBLINGUAL_USE;
            case SUBMUCOSAL_INJECTION -> RouteOfAdministrationEdqm.SUBMUCOSAL_USE;
            case SUBRETINAL_INJECTION -> RouteOfAdministrationEdqm.SUBRETINAL_USE;
            case SUCK -> RouteOfAdministrationEdqm.OROMUCOSAL_USE;
            case TOPICAL -> RouteOfAdministrationEdqm.CUTANEOUS_USE;
            case TRANSDERMAL -> RouteOfAdministrationEdqm.TRANSDERMAL_USE;
            case URETHRAL_INJECTION, URETHRAL_INSTILLATION -> RouteOfAdministrationEdqm.URETHRAL_USE;
            case VAGINAL -> RouteOfAdministrationEdqm.VAGINAL_USE;
        };
    }

    /**
     * Gets the CdTyp26 code equivalent to the specified
     * <a href="http://fhir.ch/ig/ch-term/ValueSet/edqm-routeofadministration">EDQM route of administration</a> code,
     * based on the
     * <a href="http://fhir.ch/ig/ch-emed-epr/ConceptMap/RouteOfAdministrationEDQMToCdTyp26">CH EMED EPR concept map</a>.
     *
     * @param roa The EDQM route of administration code.
     * @return The equivalent CdTyp26 code, if there is one, otherwise {@code null}.
     */
    public static @Nullable CdTyp26 fromEdqm(final RouteOfAdministrationEdqm roa) {
        return switch(Objects.requireNonNull(roa)) {
            case AURICULAR_USE -> null;
            case BUCCAL_USE -> BUCCAL;
            case CUTANEOUS_USE -> TOPICAL;
            case DENTAL_USE -> DENTAL;
            case ENDOCERVICAL_USE -> ENDOCERVICAL;
            case ENDOSINUSIAL_USE -> ENDOSINUSIAL;
            case ENDOTRACHEOPULMONARY_USE -> ENDOTRACHEAL;
            case EPIDURAL_USE -> null;
            case EPILESIONAL_USE -> EPILESIONAL;
            case EXTRAAMNIOTIC_USE -> EXTRAAMNIOTIC_INJECTION;
            case EXTRACORPOREAL_USE -> EXTRACORPOREAL;
            case EXTRAPLEURAL_USE -> null;
            case GASTRIC_USE -> null;
            case GASTROENTERAL_USE -> null;
            case GINGIVAL_USE -> GINGIVAL;
            case HAEMODIALYSIS -> HAEMODIALYSIS;
            case IMPLANTATION -> IMPLANTATION;
            case INFILTRATION -> INFILTRATION_INJECTION;
            case INHALATION_USE -> ORAL_INHALATION;
            case INTESTINAL_USE -> null;
            case INTRAAMNIOTIC_USE -> INTRAAMNIOTIC_INJECTION;
            case INTRAARTERIAL_USE -> null;
            case INTRAARTICULAR_USE -> INTRAARTICULAR;
            case INTRABURSAL_USE -> INTRABURSAL;
            case INTRACAMERAL_USE -> INTRACAMERAL;
            case INTRACARDIAC_USE -> INTRACARDIAC_INJECTION;
            case INTRACARTILAGINOUS_USE -> INTRACARTILAGINEOUS;
            case INTRACAVERNOUS_USE -> INTRACAVERNOUS;
            case INTRACEREBRAL_USE -> INTRACEREBRAL;
            case INTRACEREBROVENTRICULAR_USE -> INTRACEREBROVENTRICULAR;
            case INTRACERVICAL_USE -> INTRACERVICAL_INJECTION;
            case INTRACISTERNAL_USE -> INTRACISTERNAL;
            case INTRACHOLANGIOPANCREATIC_USE -> INTRACHOLANGIOPANCREATIC_INJECTION;
            case INTRACORNEAL_USE -> INTRACORNEAL;
            case INTRACORONARY_USE -> INTRACORONARY_INJECTION;
            case INTRADERMAL_USE -> INTRADERMAL_INJECTION;
            case INTRADISCAL_USE -> INTRADISCAL_INJECTION;
            case INTRAEPIDERMAL_USE -> INTRAEPIDERMAL;
            case INTRAGLANDULAR_USE -> INTRAGLANDULAR_INJECTION;
            case INTRALESIONAL_USE -> INTRALESIONAL;
            case INTRALYMPHATIC_USE -> INTRALYMPHATIC;
            case INTRAMUSCULAR_USE -> INTRAMUSCULAR_INJECTION;
            case INTRAOCULAR_USE -> null;
            case INTRAOSSEOUS_USE -> INTRAOSSEUS_INJECTION;
            case INTRAPERICARDIAL_USE -> INTRAPERICARDIAL_INJECTION;
            case INTRAPERITONEAL_USE -> INTRAPERITONEAL;
            case INTRAPLEURAL_USE -> INTRAPLEURAL;
            case INTRAPORTAL_USE -> null;
            case INTRAPROSTATIC_USE -> INTRAPROSTATIC;
            case INTRAPUTAMINAL_USE -> INTRAPUTAMINAL;
            case INTRASTERNAL_USE -> INTRASTERNAL_INJECTION;
            case INTRATHECAL_USE -> null;
            case INTRATUMORAL_USE -> INTRATUMORAL;
            case INTRAUTERINE_USE -> INTRAUTERINE_INJECTION;
            case INTRAVENOUS_USE -> null;
            case INTRAVESICAL_USE -> null;
            case INTRAVITREAL_USE -> INTRAVITREAL_INJECTION;
            case IONTOPHORESIS -> IONTOPHORESIS;
            case LARYNGOPHARYNGEAL_USE -> LARYNGOPHARYNGEAL;
            case NASAL_USE -> NASAL;
            case OCULAR_USE -> OPHTALMIC;
            case ORAL_USE -> PERORAL;
            case OROMUCOSAL_USE -> OROMUCOSAL;
            case OROPHARYNGEAL_USE -> null;
            case PERIARTICULAR_USE -> PERIARTICULAR;
            case PERINEURAL_USE -> null;
            case PERIODONTAL_USE -> PERIODONTAL;
            case PERIOSSEOUS_USE -> PERIOSSEOUS;
            case PERITUMORAL_USE -> PERITUMORAL;
            case POSTERIOR_JUXTASCLERAL_USE -> POSTERIOR_JUXTASCLERAL;
            case RECTAL_USE -> RECTAL;
            case RETROBULBAR_USE -> RETROBULBAR_INJECTION;
            case ROUTE_OF_ADMINISTRATION_NOT_APPLICABLE -> null;
            case SKIN_SCARIFICATION -> SCARIFICATION;
            case SUBCONJUNCTIVAL_USE -> SUBCONJUNCTIVAL_INJECTION;
            case SUBCUTANEOUS_USE -> null;
            case SUBLINGUAL_USE -> SUBLINGUAL;
            case SUBMUCOSAL_USE -> SUBMUCOSAL_INJECTION;
            case SUBRETINAL_USE -> SUBRETINAL_INJECTION;
            case TRANSDERMAL_USE -> TRANSDERMAL;
            case URETHRAL_USE -> null;
            case VAGINAL_USE -> VAGINAL;
        };
    }
}
