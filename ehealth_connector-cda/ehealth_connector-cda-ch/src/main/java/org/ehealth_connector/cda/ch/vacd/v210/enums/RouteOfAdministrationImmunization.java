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
package org.ehealth_connector.cda.ch.vacd.v210.enums;

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
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum RouteOfAdministrationImmunization implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">AmnioticFluidSacRoute</div>
	 * <!-- @formatter:on -->
	 */
	AMNIOTICFLUIDSACROUTE_L1("_AmnioticFluidSacRoute", "2.16.840.1.113883.5.112",
			"AmnioticFluidSacRoute", "AmnioticFluidSacRoute", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">BiliaryRoute</div>
	 * <!-- @formatter:on -->
	 */
	BILIARYROUTE_L1("_BiliaryRoute", "2.16.840.1.113883.5.112", "BiliaryRoute", "BiliaryRoute",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">BodySurfaceRoute</div>
	 * <!-- @formatter:on -->
	 */
	BODYSURFACEROUTE_L1("_BodySurfaceRoute", "2.16.840.1.113883.5.112", "BodySurfaceRoute",
			"BodySurfaceRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">BuccalMucosaRoute</div>
	 * <!-- @formatter:on -->
	 */
	BUCCALMUCOSAROUTE_L1("_BuccalMucosaRoute", "2.16.840.1.113883.5.112", "BuccalMucosaRoute",
			"BuccalMucosaRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">CecostomyRoute</div>
	 * <!-- @formatter:on -->
	 */
	CECOSTOMYROUTE_L1("_CecostomyRoute", "2.16.840.1.113883.5.112", "CecostomyRoute",
			"CecostomyRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">CervicalRoute</div>
	 * <!-- @formatter:on -->
	 */
	CERVICALROUTE_L1("_CervicalRoute", "2.16.840.1.113883.5.112", "CervicalRoute", "CervicalRoute",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Chew</div>
	 * <!-- @formatter:on -->
	 */
	CHEW_L1("_Chew", "2.16.840.1.113883.5.112", "Chew", "Chew", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Chew, oral</div>
	 * <!-- @formatter:on -->
	 */
	CHEW_ORAL_L2("CHEW", "2.16.840.1.113883.5.112", "Chew, oral", "Chew, oral", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Diffusion, extracorporeal</div>
	 * <!-- @formatter:on -->
	 */
	DIFFUSION_EXTRACORPOREAL_L2("EXTCORPDIF", "2.16.840.1.113883.5.112",
			"Diffusion, extracorporeal", "Diffusion, extracorporeal", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Diffusion, hemodialysis</div>
	 * <!-- @formatter:on -->
	 */
	DIFFUSION_HEMODIALYSIS_L2("HEMODIFF", "2.16.840.1.113883.5.112", "Diffusion, hemodialysis",
			"Diffusion, hemodialysis", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Diffusion</div>
	 * <!-- @formatter:on -->
	 */
	DIFFUSION_L1("_Diffusion", "2.16.840.1.113883.5.112", "Diffusion", "Diffusion", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Diffusion, transdermal</div>
	 * <!-- @formatter:on -->
	 */
	DIFFUSION_TRANSDERMAL_L2("TRNSDERMD", "2.16.840.1.113883.5.112", "Diffusion, transdermal",
			"Diffusion, transdermal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dissolve</div>
	 * <!-- @formatter:on -->
	 */
	DISSOLVE_L1("_Dissolve", "2.16.840.1.113883.5.112", "Dissolve", "Dissolve", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dissolve, oral</div>
	 * <!-- @formatter:on -->
	 */
	DISSOLVE_ORAL_L2("DISSOLVE", "2.16.840.1.113883.5.112", "Dissolve, oral", "Dissolve, oral",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dissolve, sublingual</div>
	 * <!-- @formatter:on -->
	 */
	DISSOLVE_SUBLINGUAL_L2("SL", "2.16.840.1.113883.5.112", "Dissolve, sublingual",
			"Dissolve, sublingual", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Douche</div>
	 * <!-- @formatter:on -->
	 */
	DOUCHE_L1("_Douche", "2.16.840.1.113883.5.112", "Douche", "Douche", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Douche, vaginal</div>
	 * <!-- @formatter:on -->
	 */
	DOUCHE_VAGINAL_L2("DOUCHE", "2.16.840.1.113883.5.112", "Douche, vaginal", "Douche, vaginal",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ElectroOsmosisRoute</div>
	 * <!-- @formatter:on -->
	 */
	ELECTROOSMOSISROUTE_L1("_ElectroOsmosisRoute", "2.16.840.1.113883.5.112", "ElectroOsmosisRoute",
			"ElectroOsmosisRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Electro-osmosis</div>
	 * <!-- @formatter:on -->
	 */
	ELECTRO_OSMOSIS_L2("ELECTOSMOS", "2.16.840.1.113883.5.112", "Electro-osmosis",
			"Electro-osmosis", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">EndocervicalRoute</div>
	 * <!-- @formatter:on -->
	 */
	ENDOCERVICALROUTE_L1("_EndocervicalRoute", "2.16.840.1.113883.5.112", "EndocervicalRoute",
			"EndocervicalRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Enema</div>
	 * <!-- @formatter:on -->
	 */
	ENEMA_L1("_Enema", "2.16.840.1.113883.5.112", "Enema", "Enema", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Enema, rectal</div>
	 * <!-- @formatter:on -->
	 */
	ENEMA_RECTAL_L2("ENEMA", "2.16.840.1.113883.5.112", "Enema, rectal", "Enema, rectal",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Enema, rectal retention</div>
	 * <!-- @formatter:on -->
	 */
	ENEMA_RECTAL_RETENTION_L2("RETENEMA", "2.16.840.1.113883.5.112", "Enema, rectal retention",
			"Enema, rectal retention", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">EnteralRoute</div>
	 * <!-- @formatter:on -->
	 */
	ENTERALROUTE_L1("_EnteralRoute", "2.16.840.1.113883.5.112", "EnteralRoute", "EnteralRoute",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">EpiduralRoute</div>
	 * <!-- @formatter:on -->
	 */
	EPIDURALROUTE_L1("_EpiduralRoute", "2.16.840.1.113883.5.112", "EpiduralRoute", "EpiduralRoute",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ExtraAmnioticRoute</div>
	 * <!-- @formatter:on -->
	 */
	EXTRAAMNIOTICROUTE_L1("_ExtraAmnioticRoute", "2.16.840.1.113883.5.112", "ExtraAmnioticRoute",
			"ExtraAmnioticRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ExtracorporealCirculationRoute</div>
	 * <!-- @formatter:on -->
	 */
	EXTRACORPOREALCIRCULATIONROUTE_L1("_ExtracorporealCirculationRoute", "2.16.840.1.113883.5.112",
			"ExtracorporealCirculationRoute", "ExtracorporealCirculationRoute", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Flush, intravenous catheter</div>
	 * <!-- @formatter:on -->
	 */
	FLUSH_INTRAVENOUS_CATHETER_L2("IVFLUSH", "2.16.840.1.113883.5.112",
			"Flush, intravenous catheter", "Flush, intravenous catheter", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Flush</div>
	 * <!-- @formatter:on -->
	 */
	FLUSH_L1("_Flush", "2.16.840.1.113883.5.112", "Flush", "Flush", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gargle</div>
	 * <!-- @formatter:on -->
	 */
	GARGLE_L1("GARGLE", "2.16.840.1.113883.5.112", "Gargle", "Gargle", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gargle</div>
	 * <!-- @formatter:on -->
	 */
	GARGLE_L2("GARGLE", "2.16.840.1.113883.5.112", "Gargle", "Gargle", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">GastricRoute</div>
	 * <!-- @formatter:on -->
	 */
	GASTRICROUTE_L1("_GastricRoute", "2.16.840.1.113883.5.112", "GastricRoute", "GastricRoute",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">GenitourinaryRoute</div>
	 * <!-- @formatter:on -->
	 */
	GENITOURINARYROUTE_L1("_GenitourinaryRoute", "2.16.840.1.113883.5.112", "GenitourinaryRoute",
			"GenitourinaryRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">GingivalRoute</div>
	 * <!-- @formatter:on -->
	 */
	GINGIVALROUTE_L1("_GingivalRoute", "2.16.840.1.113883.5.112", "GingivalRoute", "GingivalRoute",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">HairRoute</div>
	 * <!-- @formatter:on -->
	 */
	HAIRROUTE_L1("_HairRoute", "2.16.840.1.113883.5.112", "HairRoute", "HairRoute", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Immersion (soak)</div>
	 * <!-- @formatter:on -->
	 */
	IMMERSION_SOAK_L1("SOAK", "2.16.840.1.113883.5.112", "Immersion (soak)", "Immersion (soak)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Immersion (soak)</div>
	 * <!-- @formatter:on -->
	 */
	IMMERSION_SOAK_L2("SOAK", "2.16.840.1.113883.5.112", "Immersion (soak)", "Immersion (soak)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Implantation, intradermal</div>
	 * <!-- @formatter:on -->
	 */
	IMPLANTATION_INTRADERMAL_L2("IDIMPLNT", "2.16.840.1.113883.5.112", "Implantation, intradermal",
			"Implantation, intradermal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Implantation, intravitreal</div>
	 * <!-- @formatter:on -->
	 */
	IMPLANTATION_INTRAVITREAL_L2("IVITIMPLNT", "2.16.840.1.113883.5.112",
			"Implantation, intravitreal", "Implantation, intravitreal", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Implantation</div>
	 * <!-- @formatter:on -->
	 */
	IMPLANTATION_L1("_Implantation", "2.16.840.1.113883.5.112", "Implantation", "Implantation",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Implantation, subcutaneous</div>
	 * <!-- @formatter:on -->
	 */
	IMPLANTATION_SUBCUTANEOUS_L2("SQIMPLNT", "2.16.840.1.113883.5.112",
			"Implantation, subcutaneous", "Implantation, subcutaneous", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Infusion, epidural</div>
	 * <!-- @formatter:on -->
	 */
	INFUSION_EPIDURAL_L2("EPI", "2.16.840.1.113883.5.112", "Infusion, epidural",
			"Infusion, epidural", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Infusion, intraarterial catheter</div>
	 * <!-- @formatter:on -->
	 */
	INFUSION_INTRAARTERIAL_CATHETER_L2("IA", "2.16.840.1.113883.5.112",
			"Infusion, intraarterial catheter", "Infusion, intraarterial catheter", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Infusion, intracardiac</div>
	 * <!-- @formatter:on -->
	 */
	INFUSION_INTRACARDIAC_L2("IC", "2.16.840.1.113883.5.112", "Infusion, intracardiac",
			"Infusion, intracardiac", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Infusion, intracoronary</div>
	 * <!-- @formatter:on -->
	 */
	INFUSION_INTRACORONARY_L2("ICOR", "2.16.840.1.113883.5.112", "Infusion, intracoronary",
			"Infusion, intracoronary", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Infusion, intraosseous, continuous</div>
	 * <!-- @formatter:on -->
	 */
	INFUSION_INTRAOSSEOUS_CONTINUOUS_L2("IOSSC", "2.16.840.1.113883.5.112",
			"Infusion, intraosseous, continuous", "Infusion, intraosseous, continuous",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Infusion, intrathecal</div>
	 * <!-- @formatter:on -->
	 */
	INFUSION_INTRATHECAL_L2("IT", "2.16.840.1.113883.5.112", "Infusion, intrathecal",
			"Infusion, intrathecal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Infusion, intravascular</div>
	 * <!-- @formatter:on -->
	 */
	INFUSION_INTRAVASCULAR_L2("IVASCINFUS", "2.16.840.1.113883.5.112", "Infusion, intravascular",
			"Infusion, intravascular", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Infusion, intravenous catheter, continuous</div>
	 * <!-- @formatter:on -->
	 */
	INFUSION_INTRAVENOUS_CATHETER_CONTINUOUS_L3("IVCC", "2.16.840.1.113883.5.112",
			"Infusion, intravenous catheter, continuous",
			"Infusion, intravenous catheter, continuous", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Infusion, intravenous catheter, intermittent</div>
	 * <!-- @formatter:on -->
	 */
	INFUSION_INTRAVENOUS_CATHETER_INTERMITTENT_L3("IVCI", "2.16.840.1.113883.5.112",
			"Infusion, intravenous catheter, intermittent",
			"Infusion, intravenous catheter, intermittent", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Infusion, intravenous catheter</div>
	 * <!-- @formatter:on -->
	 */
	INFUSION_INTRAVENOUS_CATHETER_L3("IVC", "2.16.840.1.113883.5.112",
			"Infusion, intravenous catheter", "Infusion, intravenous catheter", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Infusion, intravenous catheter, pca pump</div>
	 * <!-- @formatter:on -->
	 */
	INFUSION_INTRAVENOUS_CATHETER_PCA_PUMP_L3("PCA", "2.16.840.1.113883.5.112",
			"Infusion, intravenous catheter, pca pump", "Infusion, intravenous catheter, pca pump",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Infusion, intravenous</div>
	 * <!-- @formatter:on -->
	 */
	INFUSION_INTRAVENOUS_L2("IV", "2.16.840.1.113883.5.112", "Infusion, intravenous",
			"Infusion, intravenous", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Infusion</div>
	 * <!-- @formatter:on -->
	 */
	INFUSION_L1("_Infusion", "2.16.840.1.113883.5.112", "Infusion", "Infusion", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Infusion, subcutaneous</div>
	 * <!-- @formatter:on -->
	 */
	INFUSION_SUBCUTANEOUS_L2("SQINFUS", "2.16.840.1.113883.5.112", "Infusion, subcutaneous",
			"Infusion, subcutaneous", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation, intermittent positive pressure breathing (ippb)</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_INTERMITTENT_POSITIVE_PRESSURE_BREATHING_IPPB_L2("IPPB", "2.16.840.1.113883.5.112",
			"Inhalation, intermittent positive pressure breathing (ippb)",
			"Inhalation, intermittent positive pressure breathing (ippb)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_L1("_Inhalation", "2.16.840.1.113883.5.112", "Inhalation", "Inhalation",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation, nasal cannula Inhalation, nasal, prongs</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_NASAL_CANNULA_INHALATION_NASAL_PRONGS_L3("NASINHLC", "2.16.840.1.113883.5.112",
			"Inhalation, nasal cannula Inhalation, nasal, prongs",
			"Inhalation, nasal cannula Inhalation, nasal, prongs", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation, nasal</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_NASAL_L2("NASINHL", "2.16.840.1.113883.5.112", "Inhalation, nasal",
			"Inhalation, nasal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation, nebulization</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_NEBULIZATION_L2("NEB", "2.16.840.1.113883.5.112", "Inhalation, nebulization",
			"Inhalation, nebulization", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation, nebulization, nasal</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_NEBULIZATION_NASAL_L3("NASNEB", "2.16.840.1.113883.5.112",
			"Inhalation, nebulization, nasal", "Inhalation, nebulization, nasal", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation, nebulization, oral</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_NEBULIZATION_ORAL_L3("ORNEB", "2.16.840.1.113883.5.112",
			"Inhalation, nebulization, oral", "Inhalation, nebulization, oral", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation, oral intermittent flow</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_ORAL_INTERMITTENT_FLOW_L3("ORIFINHL", "2.16.840.1.113883.5.112",
			"Inhalation, oral intermittent flow", "Inhalation, oral intermittent flow",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation, oral rebreather mask</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_ORAL_REBREATHER_MASK_L3("REBREATH", "2.16.840.1.113883.5.112",
			"Inhalation, oral rebreather mask", "Inhalation, oral rebreather mask", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation, respiratory Inhalation, intrapulmonary Inhalation, oral</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_RESPIRATORY_INHALATION_INTRAPULMONARY_INHALATION_ORAL_L2("IPINHL",
			"2.16.840.1.113883.5.112",
			"Inhalation, respiratory Inhalation, intrapulmonary Inhalation, oral",
			"Inhalation, respiratory Inhalation, intrapulmonary Inhalation, oral", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation, tracheostomy</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_TRACHEOSTOMY_L2("TRACH", "2.16.840.1.113883.5.112", "Inhalation, tracheostomy",
			"Inhalation, tracheostomy", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation, ventilator</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_VENTILATOR_L2("VENT", "2.16.840.1.113883.5.112", "Inhalation, ventilator",
			"Inhalation, ventilator", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Inhalation, ventimask</div>
	 * <!-- @formatter:on -->
	 */
	INHALATION_VENTIMASK_L2("VENTMASK", "2.16.840.1.113883.5.112", "Inhalation, ventimask",
			"Inhalation, ventimask", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, amniotic fluid</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_AMNIOTIC_FLUID_L2("AMNINJ", "2.16.840.1.113883.5.112", "Injection, amniotic fluid",
			"Injection, amniotic fluid", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, biliary tract</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_BILIARY_TRACT_L2("BILINJ", "2.16.840.1.113883.5.112", "Injection, biliary tract",
			"Injection, biliary tract", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, cervical</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_CERVICAL_L2("CERVINJ", "2.16.840.1.113883.5.112", "Injection, cervical",
			"Injection, cervical", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, endosinusial</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_ENDOSINUSIAL_L2("ENDOSININJ", "2.16.840.1.113883.5.112", "Injection, endosinusial",
			"Injection, endosinusial", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, epidural</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_EPIDURAL_L2("EPIDURINJ", "2.16.840.1.113883.5.112", "Injection, epidural",
			"Injection, epidural", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, epidural, push</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_EPIDURAL_PUSH_L2("EPIINJ", "2.16.840.1.113883.5.112", "Injection, epidural, push",
			"Injection, epidural, push", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, epidural, slow push</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_EPIDURAL_SLOW_PUSH_L2("EPINJSP", "2.16.840.1.113883.5.112",
			"Injection, epidural, slow push", "Injection, epidural, slow push", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, extracorporeal</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_EXTRACORPOREAL_L2("EXTCORPINJ", "2.16.840.1.113883.5.112",
			"Injection, extracorporeal", "Injection, extracorporeal", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, extra-amniotic</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_EXTRA_AMNIOTIC_L2("EXTRAMNINJ", "2.16.840.1.113883.5.112",
			"Injection, extra-amniotic", "Injection, extra-amniotic", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, for cholangiography</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_FOR_CHOLANGIOGRAPHY_L2("CHOLINJ", "2.16.840.1.113883.5.112",
			"Injection, for cholangiography", "Injection, for cholangiography", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, gastric button</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_GASTRIC_BUTTON_L2("GBINJ", "2.16.840.1.113883.5.112", "Injection, gastric button",
			"Injection, gastric button", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, gingival</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_GINGIVAL_L2("GINGINJ", "2.16.840.1.113883.5.112", "Injection, gingival",
			"Injection, gingival", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, hemodialysis port</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_HEMODIALYSIS_PORT_L2("HEMOPORT", "2.16.840.1.113883.5.112",
			"Injection, hemodialysis port", "Injection, hemodialysis port", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, insulin pump</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INSULIN_PUMP_L2("IPUMPINJ", "2.16.840.1.113883.5.112", "Injection, insulin pump",
			"Injection, insulin pump", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, interameningeal</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTERAMENINGEAL_L2("INTERMENINJ", "2.16.840.1.113883.5.112",
			"Injection, interameningeal", "Injection, interameningeal", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, interstitial</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTERSTITIAL_L2("INTERSTITINJ", "2.16.840.1.113883.5.112", "Injection, interstitial",
			"Injection, interstitial", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intraarterial</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAARTERIAL_L2("IAINJ", "2.16.840.1.113883.5.112", "Injection, intraarterial",
			"Injection, intraarterial", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intraarterial, push</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAARTERIAL_PUSH_L3("IAINJP", "2.16.840.1.113883.5.112",
			"Injection, intraarterial, push", "Injection, intraarterial, push", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intraarterial, slow push</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAARTERIAL_SLOW_PUSH_L3("IAINJSP", "2.16.840.1.113883.5.112",
			"Injection, intraarterial, slow push", "Injection, intraarterial, slow push",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intraarticular</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAARTICULAR_L2("IARTINJ", "2.16.840.1.113883.5.112", "Injection, intraarticular",
			"Injection, intraarticular", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intrabursal</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRABURSAL_L2("IBURSINJ", "2.16.840.1.113883.5.112", "Injection, intrabursal",
			"Injection, intrabursal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intracardiac</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRACARDIAC_L2("ICARDINJ", "2.16.840.1.113883.5.112", "Injection, intracardiac",
			"Injection, intracardiac", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intracardiac, push</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRACARDIAC_PUSH_L3("ICARINJP", "2.16.840.1.113883.5.112",
			"Injection, intracardiac, push", "Injection, intracardiac, push", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intracardiac, rapid push</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRACARDIAC_RAPID_PUSH_L3("ICARDINJRP", "2.16.840.1.113883.5.112",
			"Injection, intracardiac, rapid push", "Injection, intracardiac, rapid push",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intracardiac, slow push</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRACARDIAC_SLOW_PUSH_L3("ICARDINJSP", "2.16.840.1.113883.5.112",
			"Injection, intracardiac, slow push", "Injection, intracardiac, slow push",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intracartilaginous</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRACARTILAGINOUS_L2("ICARTINJ", "2.16.840.1.113883.5.112",
			"Injection, intracartilaginous", "Injection, intracartilaginous", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intracaudal</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRACAUDAL_L2("ICAUDINJ", "2.16.840.1.113883.5.112", "Injection, intracaudal",
			"Injection, intracaudal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intracavernous</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRACAVERNOUS_L2("ICAVINJ", "2.16.840.1.113883.5.112", "Injection, intracavernous",
			"Injection, intracavernous", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intracavitary</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRACAVITARY_L2("ICAVITINJ", "2.16.840.1.113883.5.112", "Injection, intracavitary",
			"Injection, intracavitary", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intracerebral</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRACEREBRAL_L2("ICEREBINJ", "2.16.840.1.113883.5.112", "Injection, intracerebral",
			"Injection, intracerebral", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intracervical (uterus)</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRACERVICAL_UTERUS_L2("IUINJC", "2.16.840.1.113883.5.112",
			"Injection, intracervical (uterus)", "Injection, intracervical (uterus)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intracisternal</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRACISTERNAL_L2("ICISTERNINJ", "2.16.840.1.113883.5.112",
			"Injection, intracisternal", "Injection, intracisternal", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intracoronary</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRACORONARY_L2("ICORONINJ", "2.16.840.1.113883.5.112", "Injection, intracoronary",
			"Injection, intracoronary", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intracoronary, push</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRACORONARY_PUSH_L3("ICORONINJP", "2.16.840.1.113883.5.112",
			"Injection, intracoronary, push", "Injection, intracoronary, push", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intracorpus cavernosum</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRACORPUS_CAVERNOSUM_L2("ICORPCAVINJ", "2.16.840.1.113883.5.112",
			"Injection, intracorpus cavernosum", "Injection, intracorpus cavernosum", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intradermal</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRADERMAL_L2("IDINJ", "2.16.840.1.113883.5.112", "Injection, intradermal",
			"Injection, intradermal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intradiscal</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRADISCAL_L2("IDISCINJ", "2.16.840.1.113883.5.112", "Injection, intradiscal",
			"Injection, intradiscal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intraductal</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRADUCTAL_L2("IDUCTINJ", "2.16.840.1.113883.5.112", "Injection, intraductal",
			"Injection, intraductal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intradural</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRADURAL_L2("IDURINJ", "2.16.840.1.113883.5.112", "Injection, intradural",
			"Injection, intradural", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intraepidermal</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAEPIDERMAL_L2("IEPIDINJ", "2.16.840.1.113883.5.112", "Injection, intraepidermal",
			"Injection, intraepidermal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intraepithelial</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAEPITHELIAL_L2("IEPITHINJ", "2.16.840.1.113883.5.112",
			"Injection, intraepithelial", "Injection, intraepithelial", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intralesional</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRALESIONAL_L2("ILESINJ", "2.16.840.1.113883.5.112", "Injection, intralesional",
			"Injection, intralesional", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intraluminal</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRALUMINAL_L2("ILUMINJ", "2.16.840.1.113883.5.112", "Injection, intraluminal",
			"Injection, intraluminal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intralymphatic</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRALYMPHATIC_L2("ILYMPJINJ", "2.16.840.1.113883.5.112", "Injection, intralymphatic",
			"Injection, intralymphatic", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intramedullary</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAMEDULLARY_L2("IMEDULINJ", "2.16.840.1.113883.5.112", "Injection, intramedullary",
			"Injection, intramedullary", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intramuscular, deep</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAMUSCULAR_DEEP_L3("IMD", "2.16.840.1.113883.5.112",
			"Injection, intramuscular, deep", "Injection, intramuscular, deep", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intramuscular</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAMUSCULAR_L2("IM", "2.16.840.1.113883.5.112", "Injection, intramuscular",
			"Injection, intramuscular", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intramuscular, z track</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAMUSCULAR_Z_TRACK_L3("IMZ", "2.16.840.1.113883.5.112",
			"Injection, intramuscular, z track", "Injection, intramuscular, z track", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intraocular</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAOCULAR_L2("IOINJ", "2.16.840.1.113883.5.112", "Injection, intraocular",
			"Injection, intraocular", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intraosseous</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAOSSEOUS_L2("IOSSINJ", "2.16.840.1.113883.5.112", "Injection, intraosseous",
			"Injection, intraosseous", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intraovarian</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAOVARIAN_L2("IOVARINJ", "2.16.840.1.113883.5.112", "Injection, intraovarian",
			"Injection, intraovarian", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intrapericardial</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAPERICARDIAL_L2("IPCARDINJ", "2.16.840.1.113883.5.112",
			"Injection, intrapericardial", "Injection, intrapericardial", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intraperitoneal</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAPERITONEAL_L2("IPERINJ", "2.16.840.1.113883.5.112", "Injection, intraperitoneal",
			"Injection, intraperitoneal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intrapleural</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAPLEURAL_L2("IPLRINJ", "2.16.840.1.113883.5.112", "Injection, intrapleural",
			"Injection, intrapleural", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intraprostatic</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAPROSTATIC_L2("IPROSTINJ", "2.16.840.1.113883.5.112", "Injection, intraprostatic",
			"Injection, intraprostatic", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intrapulmonary</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAPULMONARY_L2("IPINJ", "2.16.840.1.113883.5.112", "Injection, intrapulmonary",
			"Injection, intrapulmonary", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intraspinal</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRASPINAL_L2("ISINJ", "2.16.840.1.113883.5.112", "Injection, intraspinal",
			"Injection, intraspinal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intrasternal</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRASTERNAL_L2("ISTERINJ", "2.16.840.1.113883.5.112", "Injection, intrasternal",
			"Injection, intrasternal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intrasynovial</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRASYNOVIAL_L2("ISYNINJ", "2.16.840.1.113883.5.112", "Injection, intrasynovial",
			"Injection, intrasynovial", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intratendinous</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRATENDINOUS_L2("ITENDINJ", "2.16.840.1.113883.5.112", "Injection, intratendinous",
			"Injection, intratendinous", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intratesticular</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRATESTICULAR_L2("ITESTINJ", "2.16.840.1.113883.5.112",
			"Injection, intratesticular", "Injection, intratesticular", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intrathecal</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRATHECAL_L2("ITINJ", "2.16.840.1.113883.5.112", "Injection, intrathecal",
			"Injection, intrathecal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intrathoracic</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRATHORACIC_L2("ITHORINJ", "2.16.840.1.113883.5.112", "Injection, intrathoracic",
			"Injection, intrathoracic", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intratubular</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRATUBULAR_L2("ITUBINJ", "2.16.840.1.113883.5.112", "Injection, intratubular",
			"Injection, intratubular", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intratumor</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRATUMOR_L2("ITUMINJ", "2.16.840.1.113883.5.112", "Injection, intratumor",
			"Injection, intratumor", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intratympanic</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRATYMPANIC_L2("ITYMPINJ", "2.16.840.1.113883.5.112", "Injection, intratympanic",
			"Injection, intratympanic", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intraureteral, retrograde</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAURETERAL_RETROGRADE_L2("IURETINJ", "2.16.840.1.113883.5.112",
			"Injection, intraureteral, retrograde", "Injection, intraureteral, retrograde",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intrauterine</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAUTERINE_L2("IUINJ", "2.16.840.1.113883.5.112", "Injection, intrauterine",
			"Injection, intrauterine", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intravascular</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAVASCULAR_L2("IVASCINJ", "2.16.840.1.113883.5.112", "Injection, intravascular",
			"Injection, intravascular", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intravenous, bolus</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAVENOUS_BOLUS_L3("IVINJBOL", "2.16.840.1.113883.5.112",
			"Injection, intravenous, bolus", "Injection, intravenous, bolus", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intravenous</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAVENOUS_L2("IVINJ", "2.16.840.1.113883.5.112", "Injection, intravenous",
			"Injection, intravenous", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intravenous, push</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAVENOUS_PUSH_L3("IVPUSH", "2.16.840.1.113883.5.112",
			"Injection, intravenous, push", "Injection, intravenous, push", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intravenous, rapid push</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAVENOUS_RAPID_PUSH_L3("IVRPUSH", "2.16.840.1.113883.5.112",
			"Injection, intravenous, rapid push", "Injection, intravenous, rapid push",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intravenous, slow push</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAVENOUS_SLOW_PUSH_L3("IVSPUSH", "2.16.840.1.113883.5.112",
			"Injection, intravenous, slow push", "Injection, intravenous, slow push", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intraventricular (heart)</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAVENTRICULAR_HEART_L2("IVENTINJ", "2.16.840.1.113883.5.112",
			"Injection, intraventricular (heart)", "Injection, intraventricular (heart)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intravesicle</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAVESICLE_L2("IVESINJ", "2.16.840.1.113883.5.112", "Injection, intravesicle",
			"Injection, intravesicle", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intravitreal</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRAVITREAL_L2("IVITINJ", "2.16.840.1.113883.5.112", "Injection, intravitreal",
			"Injection, intravitreal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, intra-abdominal</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_INTRA_ABDOMINAL_L2("IABDINJ", "2.16.840.1.113883.5.112", "Injection, intra-abdominal",
			"Injection, intra-abdominal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_L1("_Injection", "2.16.840.1.113883.5.112", "Injection", "Injection", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, paranasal sinuses</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_PARANASAL_SINUSES_L2("PNSINJ", "2.16.840.1.113883.5.112",
			"Injection, paranasal sinuses", "Injection, paranasal sinuses", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, parenteral</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_PARENTERAL_L2("PARENTINJ", "2.16.840.1.113883.5.112", "Injection, parenteral",
			"Injection, parenteral", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, periarticular</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_PERIARTICULAR_L2("PAINJ", "2.16.840.1.113883.5.112", "Injection, periarticular",
			"Injection, periarticular", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, peridural</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_PERIDURAL_L2("PDURINJ", "2.16.840.1.113883.5.112", "Injection, peridural",
			"Injection, peridural", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, perineural</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_PERINEURAL_L2("PNINJ", "2.16.840.1.113883.5.112", "Injection, perineural",
			"Injection, perineural", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, periodontal</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_PERIODONTAL_L2("PDONTINJ", "2.16.840.1.113883.5.112", "Injection, periodontal",
			"Injection, periodontal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, peritoneal dialysis port</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_PERITONEAL_DIALYSIS_PORT_L2("PDPINJ", "2.16.840.1.113883.5.112",
			"Injection, peritoneal dialysis port", "Injection, peritoneal dialysis port",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, retrobulbar</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_RETROBULBAR_L2("RBINJ", "2.16.840.1.113883.5.112", "Injection, retrobulbar",
			"Injection, retrobulbar", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, soft tissue</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_SOFT_TISSUE_L2("SOFTISINJ", "2.16.840.1.113883.5.112", "Injection, soft tissue",
			"Injection, soft tissue", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, subarachnoid</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_SUBARACHNOID_L2("SUBARACHINJ", "2.16.840.1.113883.5.112", "Injection, subarachnoid",
			"Injection, subarachnoid", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, subconjunctival</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_SUBCONJUNCTIVAL_L2("SCINJ", "2.16.840.1.113883.5.112", "Injection, subconjunctival",
			"Injection, subconjunctival", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, subcutaneous</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_SUBCUTANEOUS_L2("SQ", "2.16.840.1.113883.5.112", "Injection, subcutaneous",
			"Injection, subcutaneous", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, sublesional</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_SUBLESIONAL_L2("SLESINJ", "2.16.840.1.113883.5.112", "Injection, sublesional",
			"Injection, sublesional", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, submucosal</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_SUBMUCOSAL_L2("SUBMUCINJ", "2.16.840.1.113883.5.112", "Injection, submucosal",
			"Injection, submucosal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, transplacental</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_TRANSPLACENTAL_L2("TRPLACINJ", "2.16.840.1.113883.5.112", "Injection, transplacental",
			"Injection, transplacental", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, transtracheal</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_TRANSTRACHEAL_L2("TRTRACHINJ", "2.16.840.1.113883.5.112", "Injection, transtracheal",
			"Injection, transtracheal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, ureteral</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_URETERAL_L2("URETINJ", "2.16.840.1.113883.5.112", "Injection, ureteral",
			"Injection, ureteral", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, urethral</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_URETHRAL_L2("URETHINJ", "2.16.840.1.113883.5.112", "Injection, urethral",
			"Injection, urethral", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Injection, urinary bladder</div>
	 * <!-- @formatter:on -->
	 */
	INJECTION_URINARY_BLADDER_L2("BLADINJ", "2.16.840.1.113883.5.112", "Injection, urinary bladder",
			"Injection, urinary bladder", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Insertion, cervical (uterine)</div>
	 * <!-- @formatter:on -->
	 */
	INSERTION_CERVICAL_UTERINE_L2("CERVINS", "2.16.840.1.113883.5.112",
			"Insertion, cervical (uterine)", "Insertion, cervical (uterine)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Insertion, intraocular, surgical</div>
	 * <!-- @formatter:on -->
	 */
	INSERTION_INTRAOCULAR_SURGICAL_L2("IOSURGINS", "2.16.840.1.113883.5.112",
			"Insertion, intraocular, surgical", "Insertion, intraocular, surgical", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Insertion, intrauterine</div>
	 * <!-- @formatter:on -->
	 */
	INSERTION_INTRAUTERINE_L2("IU", "2.16.840.1.113883.5.112", "Insertion, intrauterine",
			"Insertion, intrauterine", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Insertion</div>
	 * <!-- @formatter:on -->
	 */
	INSERTION_L1("_Insertion", "2.16.840.1.113883.5.112", "Insertion", "Insertion", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Insertion, lacrimal puncta</div>
	 * <!-- @formatter:on -->
	 */
	INSERTION_LACRIMAL_PUNCTA_L2("LPINS", "2.16.840.1.113883.5.112", "Insertion, lacrimal puncta",
			"Insertion, lacrimal puncta", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Insertion, rectal</div>
	 * <!-- @formatter:on -->
	 */
	INSERTION_RECTAL_L2("PR", "2.16.840.1.113883.5.112", "Insertion, rectal", "Insertion, rectal",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Insertion, subcutaneous, surgical</div>
	 * <!-- @formatter:on -->
	 */
	INSERTION_SUBCUTANEOUS_SURGICAL_L2("SQSURGINS", "2.16.840.1.113883.5.112",
			"Insertion, subcutaneous, surgical", "Insertion, subcutaneous, surgical", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Insertion, urethral</div>
	 * <!-- @formatter:on -->
	 */
	INSERTION_URETHRAL_L2("URETHINS", "2.16.840.1.113883.5.112", "Insertion, urethral",
			"Insertion, urethral", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Insertion, vaginal</div>
	 * <!-- @formatter:on -->
	 */
	INSERTION_VAGINAL_L2("VAGINSI", "2.16.840.1.113883.5.112", "Insertion, vaginal",
			"Insertion, vaginal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, cecostomy</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_CECOSTOMY_L2("CECINSTL", "2.16.840.1.113883.5.112", "Instillation, cecostomy",
			"Instillation, cecostomy", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, chest tube</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_CHEST_TUBE_L2("CTINSTL", "2.16.840.1.113883.5.112", "Instillation, chest tube",
			"Instillation, chest tube", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, continuous ambulatory peritoneal dialysis port</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_CONTINUOUS_AMBULATORY_PERITONEAL_DIALYSIS_PORT_L2("CAPDINSTL",
			"2.16.840.1.113883.5.112",
			"Instillation, continuous ambulatory peritoneal dialysis port",
			"Instillation, continuous ambulatory peritoneal dialysis port", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, endotracheal tube</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_ENDOTRACHEAL_TUBE_L2("ETINSTL", "2.16.840.1.113883.5.112",
			"Instillation, endotracheal tube", "Instillation, endotracheal tube", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, enteral feeding tube</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_ENTERAL_FEEDING_TUBE_L2("EFT", "2.16.840.1.113883.5.112",
			"Instillation, enteral feeding tube", "Instillation, enteral feeding tube",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, enteral</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_ENTERAL_L2("ENTINSTL", "2.16.840.1.113883.5.112", "Instillation, enteral",
			"Instillation, enteral", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, gastrostomy tube</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_GASTROSTOMY_TUBE_L2("GT", "2.16.840.1.113883.5.112",
			"Instillation, gastrostomy tube", "Instillation, gastrostomy tube", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, gastro-jejunostomy tube</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_GASTRO_JEJUNOSTOMY_TUBE_L2("GJT", "2.16.840.1.113883.5.112",
			"Instillation, gastro-jejunostomy tube", "Instillation, gastro-jejunostomy tube",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, intrabronchial</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_INTRABRONCHIAL_L2("IBRONCHINSTIL", "2.16.840.1.113883.5.112",
			"Instillation, intrabronchial", "Instillation, intrabronchial", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, intraduodenal</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_INTRADUODENAL_L2("IDUODINSTIL", "2.16.840.1.113883.5.112",
			"Instillation, intraduodenal", "Instillation, intraduodenal", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, intraesophageal</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_INTRAESOPHAGEAL_L2("IESOPHINSTIL", "2.16.840.1.113883.5.112",
			"Instillation, intraesophageal", "Instillation, intraesophageal", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, intragastric</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_INTRAGASTRIC_L2("IGASTINSTIL", "2.16.840.1.113883.5.112",
			"Instillation, intragastric", "Instillation, intragastric", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, intraileal</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_INTRAILEAL_L2("IILEALINJ", "2.16.840.1.113883.5.112", "Instillation, intraileal",
			"Instillation, intraileal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, intraocular</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_INTRAOCULAR_L2("IOINSTL", "2.16.840.1.113883.5.112", "Instillation, intraocular",
			"Instillation, intraocular", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, intrasinal</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_INTRASINAL_L2("ISININSTIL", "2.16.840.1.113883.5.112", "Instillation, intrasinal",
			"Instillation, intrasinal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, intratracheal</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_INTRATRACHEAL_L2("ITRACHINSTIL", "2.16.840.1.113883.5.112",
			"Instillation, intratracheal", "Instillation, intratracheal", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, intrauterine</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_INTRAUTERINE_L2("IUINSTL", "2.16.840.1.113883.5.112", "Instillation, intrauterine",
			"Instillation, intrauterine", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, jejunostomy tube</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_JEJUNOSTOMY_TUBE_L2("JJTINSTL", "2.16.840.1.113883.5.112",
			"Instillation, jejunostomy tube", "Instillation, jejunostomy tube", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_L1("_Instillation", "2.16.840.1.113883.5.112", "Instillation", "Instillation",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, laryngeal</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_LARYNGEAL_L2("LARYNGINSTIL", "2.16.840.1.113883.5.112", "Instillation, laryngeal",
			"Instillation, laryngeal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, nasal</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_NASAL_L2("NASALINSTIL", "2.16.840.1.113883.5.112", "Instillation, nasal",
			"Instillation, nasal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, nasogastric</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_NASOGASTRIC_L2("NASOGASINSTIL", "2.16.840.1.113883.5.112",
			"Instillation, nasogastric", "Instillation, nasogastric", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, nasogastric tube</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_NASOGASTRIC_TUBE_L2("NGT", "2.16.840.1.113883.5.112",
			"Instillation, nasogastric tube", "Instillation, nasogastric tube", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, nasotracheal tube</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_NASOTRACHEAL_TUBE_L2("NTT", "2.16.840.1.113883.5.112",
			"Instillation, nasotracheal tube", "Instillation, nasotracheal tube", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, orogastric tube</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_OROGASTRIC_TUBE_L2("OGT", "2.16.840.1.113883.5.112",
			"Instillation, orogastric tube", "Instillation, orogastric tube", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, orojejunum tube</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_OROJEJUNUM_TUBE_L2("OJJ", "2.16.840.1.113883.5.112",
			"Instillation, orojejunum tube", "Instillation, orojejunum tube", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, otic</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_OTIC_L2("OT", "2.16.840.1.113883.5.112", "Instillation, otic",
			"Instillation, otic", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, paranasal sinuses</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_PARANASAL_SINUSES_L2("PNSINSTL", "2.16.840.1.113883.5.112",
			"Instillation, paranasal sinuses", "Instillation, paranasal sinuses", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, peritoneal dialysis port</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_PERITONEAL_DIALYSIS_PORT_L2("PDPINSTL", "2.16.840.1.113883.5.112",
			"Instillation, peritoneal dialysis port", "Instillation, peritoneal dialysis port",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, rectal</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_RECTAL_L2("RECINSTL", "2.16.840.1.113883.5.112", "Instillation, rectal",
			"Instillation, rectal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, rectal tube</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_RECTAL_TUBE_L3("RECTINSTL", "2.16.840.1.113883.5.112", "Instillation, rectal tube",
			"Instillation, rectal tube", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, sinus, unspecified</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_SINUS_UNSPECIFIED_L2("SININSTIL", "2.16.840.1.113883.5.112",
			"Instillation, sinus, unspecified", "Instillation, sinus, unspecified", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, soft tissue</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_SOFT_TISSUE_L2("SOFTISINSTIL", "2.16.840.1.113883.5.112",
			"Instillation, soft tissue", "Instillation, soft tissue", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, tracheostomy</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_TRACHEOSTOMY_L2("TRACHINSTL", "2.16.840.1.113883.5.112",
			"Instillation, tracheostomy", "Instillation, tracheostomy", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, transtympanic</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_TRANSTYMPANIC_L2("TRTYMPINSTIL", "2.16.840.1.113883.5.112",
			"Instillation, transtympanic", "Instillation, transtympanic", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">instillation, urethral</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_URETHRAL_L2("URETHINSTL", "2.16.840.1.113883.5.112", "instillation, urethral",
			"instillation, urethral", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instillation, urinary catheter</div>
	 * <!-- @formatter:on -->
	 */
	INSTILLATION_URINARY_CATHETER_L2("BLADINSTL", "2.16.840.1.113883.5.112",
			"Instillation, urinary catheter", "Instillation, urinary catheter", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Insufflation</div>
	 * <!-- @formatter:on -->
	 */
	INSUFFLATION_L1("INSUF", "2.16.840.1.113883.5.112", "Insufflation", "Insufflation",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">InterameningealRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTERAMENINGEALROUTE_L1("_InterameningealRoute", "2.16.840.1.113883.5.112",
			"InterameningealRoute", "InterameningealRoute", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">InterstitialRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTERSTITIALROUTE_L1("_InterstitialRoute", "2.16.840.1.113883.5.112", "InterstitialRoute",
			"InterstitialRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntraabdominalRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRAABDOMINALROUTE_L1("_IntraabdominalRoute", "2.16.840.1.113883.5.112", "IntraabdominalRoute",
			"IntraabdominalRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntraarterialRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRAARTERIALROUTE_L1("_IntraarterialRoute", "2.16.840.1.113883.5.112", "IntraarterialRoute",
			"IntraarterialRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntraarticularRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRAARTICULARROUTE_L1("_IntraarticularRoute", "2.16.840.1.113883.5.112", "IntraarticularRoute",
			"IntraarticularRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntrabronchialRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRABRONCHIALROUTE_L1("_IntrabronchialRoute", "2.16.840.1.113883.5.112", "IntrabronchialRoute",
			"IntrabronchialRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntrabursalRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRABURSALROUTE_L1("_IntrabursalRoute", "2.16.840.1.113883.5.112", "IntrabursalRoute",
			"IntrabursalRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntracardiacRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRACARDIACROUTE_L1("_IntracardiacRoute", "2.16.840.1.113883.5.112", "IntracardiacRoute",
			"IntracardiacRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntracartilaginousRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRACARTILAGINOUSROUTE_L1("_IntracartilaginousRoute", "2.16.840.1.113883.5.112",
			"IntracartilaginousRoute", "IntracartilaginousRoute", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntracaudalRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRACAUDALROUTE_L1("_IntracaudalRoute", "2.16.840.1.113883.5.112", "IntracaudalRoute",
			"IntracaudalRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntracavernosalRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRACAVERNOSALROUTE_L1("_IntracavernosalRoute", "2.16.840.1.113883.5.112",
			"IntracavernosalRoute", "IntracavernosalRoute", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntracavitaryRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRACAVITARYROUTE_L1("_IntracavitaryRoute", "2.16.840.1.113883.5.112", "IntracavitaryRoute",
			"IntracavitaryRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntracerebralRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRACEREBRALROUTE_L1("_IntracerebralRoute", "2.16.840.1.113883.5.112", "IntracerebralRoute",
			"IntracerebralRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntracervicalRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRACERVICALROUTE_L1("_IntracervicalRoute", "2.16.840.1.113883.5.112", "IntracervicalRoute",
			"IntracervicalRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntracisternalRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRACISTERNALROUTE_L1("_IntracisternalRoute", "2.16.840.1.113883.5.112", "IntracisternalRoute",
			"IntracisternalRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntracornealRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRACORNEALROUTE_L1("_IntracornealRoute", "2.16.840.1.113883.5.112", "IntracornealRoute",
			"IntracornealRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntracoronalRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRACORONALROUTE_L1("_IntracoronalRoute", "2.16.840.1.113883.5.112", "IntracoronalRoute",
			"IntracoronalRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntracoronaryRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRACORONARYROUTE_L1("_IntracoronaryRoute", "2.16.840.1.113883.5.112", "IntracoronaryRoute",
			"IntracoronaryRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntracorpusCavernosumRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRACORPUSCAVERNOSUMROUTE_L1("_IntracorpusCavernosumRoute", "2.16.840.1.113883.5.112",
			"IntracorpusCavernosumRoute", "IntracorpusCavernosumRoute", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntradermalRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRADERMALROUTE_L1("_IntradermalRoute", "2.16.840.1.113883.5.112", "IntradermalRoute",
			"IntradermalRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntradiscalRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRADISCALROUTE_L1("_IntradiscalRoute", "2.16.840.1.113883.5.112", "IntradiscalRoute",
			"IntradiscalRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntraductalRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRADUCTALROUTE_L1("_IntraductalRoute", "2.16.840.1.113883.5.112", "IntraductalRoute",
			"IntraductalRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntraduodenalRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRADUODENALROUTE_L1("_IntraduodenalRoute", "2.16.840.1.113883.5.112", "IntraduodenalRoute",
			"IntraduodenalRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntraduralRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRADURALROUTE_L1("_IntraduralRoute", "2.16.840.1.113883.5.112", "IntraduralRoute",
			"IntraduralRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntraepidermalRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRAEPIDERMALROUTE_L1("_IntraepidermalRoute", "2.16.840.1.113883.5.112", "IntraepidermalRoute",
			"IntraepidermalRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntraepithelialRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRAEPITHELIALROUTE_L1("_IntraepithelialRoute", "2.16.840.1.113883.5.112",
			"IntraepithelialRoute", "IntraepithelialRoute", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntraesophagealRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRAESOPHAGEALROUTE_L1("_IntraesophagealRoute", "2.16.840.1.113883.5.112",
			"IntraesophagealRoute", "IntraesophagealRoute", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntragastricRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRAGASTRICROUTE_L1("_IntragastricRoute", "2.16.840.1.113883.5.112", "IntragastricRoute",
			"IntragastricRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntrailealRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRAILEALROUTE_L1("_IntrailealRoute", "2.16.840.1.113883.5.112", "IntrailealRoute",
			"IntrailealRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntralesionalRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRALESIONALROUTE_L1("_IntralesionalRoute", "2.16.840.1.113883.5.112", "IntralesionalRoute",
			"IntralesionalRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntraluminalRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRALUMINALROUTE_L1("_IntraluminalRoute", "2.16.840.1.113883.5.112", "IntraluminalRoute",
			"IntraluminalRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntralymphaticRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRALYMPHATICROUTE_L1("_IntralymphaticRoute", "2.16.840.1.113883.5.112", "IntralymphaticRoute",
			"IntralymphaticRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntramedullaryRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRAMEDULLARYROUTE_L1("_IntramedullaryRoute", "2.16.840.1.113883.5.112", "IntramedullaryRoute",
			"IntramedullaryRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntramuscularRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRAMUSCULARROUTE_L1("_IntramuscularRoute", "2.16.840.1.113883.5.112", "IntramuscularRoute",
			"IntramuscularRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntraocularRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRAOCULARROUTE_L1("_IntraocularRoute", "2.16.840.1.113883.5.112", "IntraocularRoute",
			"IntraocularRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntraosseousRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRAOSSEOUSROUTE_L1("_IntraosseousRoute", "2.16.840.1.113883.5.112", "IntraosseousRoute",
			"IntraosseousRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntraovarianRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRAOVARIANROUTE_L1("_IntraovarianRoute", "2.16.840.1.113883.5.112", "IntraovarianRoute",
			"IntraovarianRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntrapericardialRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRAPERICARDIALROUTE_L1("_IntrapericardialRoute", "2.16.840.1.113883.5.112",
			"IntrapericardialRoute", "IntrapericardialRoute", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntraperitonealRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRAPERITONEALROUTE_L1("_IntraperitonealRoute", "2.16.840.1.113883.5.112",
			"IntraperitonealRoute", "IntraperitonealRoute", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntrapleuralRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRAPLEURALROUTE_L1("_IntrapleuralRoute", "2.16.840.1.113883.5.112", "IntrapleuralRoute",
			"IntrapleuralRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntraprostaticRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRAPROSTATICROUTE_L1("_IntraprostaticRoute", "2.16.840.1.113883.5.112", "IntraprostaticRoute",
			"IntraprostaticRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntrapulmonaryRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRAPULMONARYROUTE_L1("_IntrapulmonaryRoute", "2.16.840.1.113883.5.112", "IntrapulmonaryRoute",
			"IntrapulmonaryRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntrasinalRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRASINALROUTE_L1("_IntrasinalRoute", "2.16.840.1.113883.5.112", "IntrasinalRoute",
			"IntrasinalRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntraspinalRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRASPINALROUTE_L1("_IntraspinalRoute", "2.16.840.1.113883.5.112", "IntraspinalRoute",
			"IntraspinalRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntrasternalRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRASTERNALROUTE_L1("_IntrasternalRoute", "2.16.840.1.113883.5.112", "IntrasternalRoute",
			"IntrasternalRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntrasynovialRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRASYNOVIALROUTE_L1("_IntrasynovialRoute", "2.16.840.1.113883.5.112", "IntrasynovialRoute",
			"IntrasynovialRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntratendinousRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRATENDINOUSROUTE_L1("_IntratendinousRoute", "2.16.840.1.113883.5.112", "IntratendinousRoute",
			"IntratendinousRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntratesticularRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRATESTICULARROUTE_L1("_IntratesticularRoute", "2.16.840.1.113883.5.112",
			"IntratesticularRoute", "IntratesticularRoute", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntrathecalRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRATHECALROUTE_L1("_IntrathecalRoute", "2.16.840.1.113883.5.112", "IntrathecalRoute",
			"IntrathecalRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntrathoracicRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRATHORACICROUTE_L1("_IntrathoracicRoute", "2.16.840.1.113883.5.112", "IntrathoracicRoute",
			"IntrathoracicRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntratrachealRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRATRACHEALROUTE_L1("_IntratrachealRoute", "2.16.840.1.113883.5.112", "IntratrachealRoute",
			"IntratrachealRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntratubularRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRATUBULARROUTE_L1("_IntratubularRoute", "2.16.840.1.113883.5.112", "IntratubularRoute",
			"IntratubularRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntratumorRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRATUMORROUTE_L1("_IntratumorRoute", "2.16.840.1.113883.5.112", "IntratumorRoute",
			"IntratumorRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntratympanicRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRATYMPANICROUTE_L1("_IntratympanicRoute", "2.16.840.1.113883.5.112", "IntratympanicRoute",
			"IntratympanicRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntrauterineRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRAUTERINEROUTE_L1("_IntrauterineRoute", "2.16.840.1.113883.5.112", "IntrauterineRoute",
			"IntrauterineRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntravascularRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRAVASCULARROUTE_L1("_IntravascularRoute", "2.16.840.1.113883.5.112", "IntravascularRoute",
			"IntravascularRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntravenousRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRAVENOUSROUTE_L1("_IntravenousRoute", "2.16.840.1.113883.5.112", "IntravenousRoute",
			"IntravenousRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntraventricularRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRAVENTRICULARROUTE_L1("_IntraventricularRoute", "2.16.840.1.113883.5.112",
			"IntraventricularRoute", "IntraventricularRoute", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntravesicleRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRAVESICLEROUTE_L1("_IntravesicleRoute", "2.16.840.1.113883.5.112", "IntravesicleRoute",
			"IntravesicleRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IntravitrealRoute</div>
	 * <!-- @formatter:on -->
	 */
	INTRAVITREALROUTE_L1("_IntravitrealRoute", "2.16.840.1.113883.5.112", "IntravitrealRoute",
			"IntravitrealRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IontophoresisRoute</div>
	 * <!-- @formatter:on -->
	 */
	IONTOPHORESISROUTE_L1("_IontophoresisRoute", "2.16.840.1.113883.5.112", "IontophoresisRoute",
			"IontophoresisRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Irrigation, genitourinary</div>
	 * <!-- @formatter:on -->
	 */
	IRRIGATION_GENITOURINARY_L2("GUIRR", "2.16.840.1.113883.5.112", "Irrigation, genitourinary",
			"Irrigation, genitourinary", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Irrigation, intragastric</div>
	 * <!-- @formatter:on -->
	 */
	IRRIGATION_INTRAGASTRIC_L2("IGASTIRR", "2.16.840.1.113883.5.112", "Irrigation, intragastric",
			"Irrigation, intragastric", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Irrigation, intralesional</div>
	 * <!-- @formatter:on -->
	 */
	IRRIGATION_INTRALESIONAL_L2("ILESIRR", "2.16.840.1.113883.5.112", "Irrigation, intralesional",
			"Irrigation, intralesional", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Irrigation, intraocular</div>
	 * <!-- @formatter:on -->
	 */
	IRRIGATION_INTRAOCULAR_L2("IOIRR", "2.16.840.1.113883.5.112", "Irrigation, intraocular",
			"Irrigation, intraocular", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Irrigation</div>
	 * <!-- @formatter:on -->
	 */
	IRRIGATION_L1("_Irrigation", "2.16.840.1.113883.5.112", "Irrigation", "Irrigation",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Irrigation, rectal</div>
	 * <!-- @formatter:on -->
	 */
	IRRIGATION_RECTAL_L2("RECIRR", "2.16.840.1.113883.5.112", "Irrigation, rectal",
			"Irrigation, rectal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Irrigation, urinary bladder, continuous</div>
	 * <!-- @formatter:on -->
	 */
	IRRIGATION_URINARY_BLADDER_CONTINUOUS_L3("BLADIRRC", "2.16.840.1.113883.5.112",
			"Irrigation, urinary bladder, continuous", "Irrigation, urinary bladder, continuous",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Irrigation, urinary bladder</div>
	 * <!-- @formatter:on -->
	 */
	IRRIGATION_URINARY_BLADDER_L2("BLADIRR", "2.16.840.1.113883.5.112",
			"Irrigation, urinary bladder", "Irrigation, urinary bladder", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Irrigation, urinary bladder, tidal</div>
	 * <!-- @formatter:on -->
	 */
	IRRIGATION_URINARY_BLADDER_TIDAL_L3("BLADIRRT", "2.16.840.1.113883.5.112",
			"Irrigation, urinary bladder, tidal", "Irrigation, urinary bladder, tidal",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">JejunumRoute</div>
	 * <!-- @formatter:on -->
	 */
	JEJUNUMROUTE_L1("_JejunumRoute", "2.16.840.1.113883.5.112", "JejunumRoute", "JejunumRoute",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">LacrimalPunctaRoute</div>
	 * <!-- @formatter:on -->
	 */
	LACRIMALPUNCTAROUTE_L1("_LacrimalPunctaRoute", "2.16.840.1.113883.5.112", "LacrimalPunctaRoute",
			"LacrimalPunctaRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">LaryngealRoute</div>
	 * <!-- @formatter:on -->
	 */
	LARYNGEALROUTE_L1("_LaryngealRoute", "2.16.840.1.113883.5.112", "LaryngealRoute",
			"LaryngealRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">LavageRoute</div>
	 * <!-- @formatter:on -->
	 */
	LAVAGEROUTE_L1("_LavageRoute", "2.16.840.1.113883.5.112", "LavageRoute", "LavageRoute",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Lavage, intragastric</div>
	 * <!-- @formatter:on -->
	 */
	LAVAGE_INTRAGASTRIC_L2("IGASTLAV", "2.16.840.1.113883.5.112", "Lavage, intragastric",
			"Lavage, intragastric", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">LingualRoute</div>
	 * <!-- @formatter:on -->
	 */
	LINGUALROUTE_L1("_LingualRoute", "2.16.840.1.113883.5.112", "LingualRoute", "LingualRoute",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">MucosalAbsorptionRoute</div>
	 * <!-- @formatter:on -->
	 */
	MUCOSALABSORPTIONROUTE_L1("_MucosalAbsorptionRoute", "2.16.840.1.113883.5.112",
			"MucosalAbsorptionRoute", "MucosalAbsorptionRoute", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Mucosal absorption, intraduodenal</div>
	 * <!-- @formatter:on -->
	 */
	MUCOSAL_ABSORPTION_INTRADUODENAL_L2("IDOUDMAB", "2.16.840.1.113883.5.112",
			"Mucosal absorption, intraduodenal", "Mucosal absorption, intraduodenal", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Mucosal absorption, intratracheal</div>
	 * <!-- @formatter:on -->
	 */
	MUCOSAL_ABSORPTION_INTRATRACHEAL_L2("ITRACHMAB", "2.16.840.1.113883.5.112",
			"Mucosal absorption, intratracheal", "Mucosal absorption, intratracheal", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Mucosal absorption, submucosal</div>
	 * <!-- @formatter:on -->
	 */
	MUCOSAL_ABSORPTION_SUBMUCOSAL_L2("SMUCMAB", "2.16.840.1.113883.5.112",
			"Mucosal absorption, submucosal", "Mucosal absorption, submucosal", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">MucousMembraneRoute</div>
	 * <!-- @formatter:on -->
	 */
	MUCOUSMEMBRANEROUTE_L1("_MucousMembraneRoute", "2.16.840.1.113883.5.112", "MucousMembraneRoute",
			"MucousMembraneRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">NailRoute</div>
	 * <!-- @formatter:on -->
	 */
	NAILROUTE_L1("_NailRoute", "2.16.840.1.113883.5.112", "NailRoute", "NailRoute", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">NasalRoute</div>
	 * <!-- @formatter:on -->
	 */
	NASALROUTE_L1("_NasalRoute", "2.16.840.1.113883.5.112", "NasalRoute", "NasalRoute",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nebulization, endotracheal tube</div>
	 * <!-- @formatter:on -->
	 */
	NEBULIZATION_ENDOTRACHEAL_TUBE_L2("ETNEB", "2.16.840.1.113883.5.112",
			"Nebulization, endotracheal tube", "Nebulization, endotracheal tube", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nebulization</div>
	 * <!-- @formatter:on -->
	 */
	NEBULIZATION_L1("_Nebulization", "2.16.840.1.113883.5.112", "Nebulization", "Nebulization",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Occlusive dressing technique</div>
	 * <!-- @formatter:on -->
	 */
	OCCLUSIVE_DRESSING_TECHNIQUE_L2("OCDRESTA", "2.16.840.1.113883.5.112",
			"Occlusive dressing technique", "Occlusive dressing technique", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">OphthalmicRoute</div>
	 * <!-- @formatter:on -->
	 */
	OPHTHALMICROUTE_L1("_OphthalmicRoute", "2.16.840.1.113883.5.112", "OphthalmicRoute",
			"OphthalmicRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">OralRoute</div>
	 * <!-- @formatter:on -->
	 */
	ORALROUTE_L1("_OralRoute", "2.16.840.1.113883.5.112", "OralRoute", "OralRoute", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">OromucosalRoute</div>
	 * <!-- @formatter:on -->
	 */
	OROMUCOSALROUTE_L1("_OromucosalRoute", "2.16.840.1.113883.5.112", "OromucosalRoute",
			"OromucosalRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">OropharyngealRoute</div>
	 * <!-- @formatter:on -->
	 */
	OROPHARYNGEALROUTE_L1("_OropharyngealRoute", "2.16.840.1.113883.5.112", "OropharyngealRoute",
			"OropharyngealRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">OticRoute</div>
	 * <!-- @formatter:on -->
	 */
	OTICROUTE_L1("_OticRoute", "2.16.840.1.113883.5.112", "OticRoute", "OticRoute", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ParanasalSinusesRoute</div>
	 * <!-- @formatter:on -->
	 */
	PARANASALSINUSESROUTE_L1("_ParanasalSinusesRoute", "2.16.840.1.113883.5.112",
			"ParanasalSinusesRoute", "ParanasalSinusesRoute", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ParenteralRoute</div>
	 * <!-- @formatter:on -->
	 */
	PARENTERALROUTE_L1("_ParenteralRoute", "2.16.840.1.113883.5.112", "ParenteralRoute",
			"ParenteralRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">PerianalRoute</div>
	 * <!-- @formatter:on -->
	 */
	PERIANALROUTE_L1("_PerianalRoute", "2.16.840.1.113883.5.112", "PerianalRoute", "PerianalRoute",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">PeriarticularRoute</div>
	 * <!-- @formatter:on -->
	 */
	PERIARTICULARROUTE_L1("_PeriarticularRoute", "2.16.840.1.113883.5.112", "PeriarticularRoute",
			"PeriarticularRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">PeriduralRoute</div>
	 * <!-- @formatter:on -->
	 */
	PERIDURALROUTE_L1("_PeriduralRoute", "2.16.840.1.113883.5.112", "PeriduralRoute",
			"PeriduralRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">PerinealRoute</div>
	 * <!-- @formatter:on -->
	 */
	PERINEALROUTE_L1("_PerinealRoute", "2.16.840.1.113883.5.112", "PerinealRoute", "PerinealRoute",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">PerineuralRoute</div>
	 * <!-- @formatter:on -->
	 */
	PERINEURALROUTE_L1("_PerineuralRoute", "2.16.840.1.113883.5.112", "PerineuralRoute",
			"PerineuralRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">PeriodontalRoute</div>
	 * <!-- @formatter:on -->
	 */
	PERIODONTALROUTE_L1("_PeriodontalRoute", "2.16.840.1.113883.5.112", "PeriodontalRoute",
			"PeriodontalRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">PulmonaryRoute</div>
	 * <!-- @formatter:on -->
	 */
	PULMONARYROUTE_L1("_PulmonaryRoute", "2.16.840.1.113883.5.112", "PulmonaryRoute",
			"PulmonaryRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">RectalRoute</div>
	 * <!-- @formatter:on -->
	 */
	RECTALROUTE_L1("_RectalRoute", "2.16.840.1.113883.5.112", "RectalRoute", "RectalRoute",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">RespiratoryTractRoute</div>
	 * <!-- @formatter:on -->
	 */
	RESPIRATORYTRACTROUTE_L1("_RespiratoryTractRoute", "2.16.840.1.113883.5.112",
			"RespiratoryTractRoute", "RespiratoryTractRoute", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">RetrobulbarRoute</div>
	 * <!-- @formatter:on -->
	 */
	RETROBULBARROUTE_L1("_RetrobulbarRoute", "2.16.840.1.113883.5.112", "RetrobulbarRoute",
			"RetrobulbarRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rinse, dental</div>
	 * <!-- @formatter:on -->
	 */
	RINSE_DENTAL_L2("DENRINSE", "2.16.840.1.113883.5.112", "Rinse, dental", "Rinse, dental",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rinse</div>
	 * <!-- @formatter:on -->
	 */
	RINSE_L1("_Rinse", "2.16.840.1.113883.5.112", "Rinse", "Rinse", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rinse, oral</div>
	 * <!-- @formatter:on -->
	 */
	RINSE_ORAL_L2("ORRINSE", "2.16.840.1.113883.5.112", "Rinse, oral", "Rinse, oral", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ScalpRoute</div>
	 * <!-- @formatter:on -->
	 */
	SCALPROUTE_L1("_ScalpRoute", "2.16.840.1.113883.5.112", "ScalpRoute", "ScalpRoute",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Shampoo</div>
	 * <!-- @formatter:on -->
	 */
	SHAMPOO_L1("SHAMPOO", "2.16.840.1.113883.5.112", "Shampoo", "Shampoo", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Shampoo</div>
	 * <!-- @formatter:on -->
	 */
	SHAMPOO_L2("SHAMPOO", "2.16.840.1.113883.5.112", "Shampoo", "Shampoo", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">SinusUnspecifiedRoute</div>
	 * <!-- @formatter:on -->
	 */
	SINUSUNSPECIFIEDROUTE_L1("_SinusUnspecifiedRoute", "2.16.840.1.113883.5.112",
			"SinusUnspecifiedRoute", "SinusUnspecifiedRoute", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">SkinRoute</div>
	 * <!-- @formatter:on -->
	 */
	SKINROUTE_L1("_SkinRoute", "2.16.840.1.113883.5.112", "SkinRoute", "SkinRoute", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">SoftTissueRoute</div>
	 * <!-- @formatter:on -->
	 */
	SOFTTISSUEROUTE_L1("_SoftTissueRoute", "2.16.840.1.113883.5.112", "SoftTissueRoute",
			"SoftTissueRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">SubarachnoidRoute</div>
	 * <!-- @formatter:on -->
	 */
	SUBARACHNOIDROUTE_L1("_SubarachnoidRoute", "2.16.840.1.113883.5.112", "SubarachnoidRoute",
			"SubarachnoidRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">SubconjunctivalRoute</div>
	 * <!-- @formatter:on -->
	 */
	SUBCONJUNCTIVALROUTE_L1("_SubconjunctivalRoute", "2.16.840.1.113883.5.112",
			"SubconjunctivalRoute", "SubconjunctivalRoute", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Subconjunctival</div>
	 * <!-- @formatter:on -->
	 */
	SUBCONJUNCTIVAL_L2("SUBCONJTA", "2.16.840.1.113883.5.112", "Subconjunctival", "Subconjunctival",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">SubcutaneousRoute</div>
	 * <!-- @formatter:on -->
	 */
	SUBCUTANEOUSROUTE_L1("_SubcutaneousRoute", "2.16.840.1.113883.5.112", "SubcutaneousRoute",
			"SubcutaneousRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">SublesionalRoute</div>
	 * <!-- @formatter:on -->
	 */
	SUBLESIONALROUTE_L1("_SublesionalRoute", "2.16.840.1.113883.5.112", "SublesionalRoute",
			"SublesionalRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">SublingualRoute</div>
	 * <!-- @formatter:on -->
	 */
	SUBLINGUALROUTE_L1("_SublingualRoute", "2.16.840.1.113883.5.112", "SublingualRoute",
			"SublingualRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">SubmucosalRoute</div>
	 * <!-- @formatter:on -->
	 */
	SUBMUCOSALROUTE_L1("_SubmucosalRoute", "2.16.840.1.113883.5.112", "SubmucosalRoute",
			"SubmucosalRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Suck, oromucosal</div>
	 * <!-- @formatter:on -->
	 */
	SUCK_OROMUCOSAL_L1("SUCK", "2.16.840.1.113883.5.112", "Suck, oromucosal", "Suck, oromucosal",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Suck, oromucosal</div>
	 * <!-- @formatter:on -->
	 */
	SUCK_OROMUCOSAL_L2("SUCK", "2.16.840.1.113883.5.112", "Suck, oromucosal", "Suck, oromucosal",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">SuppositoryRoute</div>
	 * <!-- @formatter:on -->
	 */
	SUPPOSITORYROUTE_L1("_SuppositoryRoute", "2.16.840.1.113883.5.112", "SuppositoryRoute",
			"SuppositoryRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Suppository, urethral</div>
	 * <!-- @formatter:on -->
	 */
	SUPPOSITORY_URETHRAL_L2("URETHSUP", "2.16.840.1.113883.5.112", "Suppository, urethral",
			"Suppository, urethral", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Swallow, oral</div>
	 * <!-- @formatter:on -->
	 */
	SWALLOW_ORAL_L1("PO", "2.16.840.1.113883.5.112", "Swallow, oral", "Swallow, oral",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Swallow, oral</div>
	 * <!-- @formatter:on -->
	 */
	SWALLOW_ORAL_L2("PO", "2.16.840.1.113883.5.112", "Swallow, oral", "Swallow, oral",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Swish and spit out, oromucosal</div>
	 * <!-- @formatter:on -->
	 */
	SWISH_AND_SPIT_OUT_OROMUCOSAL_L2("SWISHSPIT", "2.16.840.1.113883.5.112",
			"Swish and spit out, oromucosal", "Swish and spit out, oromucosal", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Swish and swallow, oromucosal</div>
	 * <!-- @formatter:on -->
	 */
	SWISH_AND_SWALLOW_OROMUCOSAL_L2("SWISHSWAL", "2.16.840.1.113883.5.112",
			"Swish and swallow, oromucosal", "Swish and swallow, oromucosal", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Swish</div>
	 * <!-- @formatter:on -->
	 */
	SWISH_L1("_Swish", "2.16.840.1.113883.5.112", "Swish", "Swish", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">TopicalAbsorptionRoute</div>
	 * <!-- @formatter:on -->
	 */
	TOPICALABSORPTIONROUTE_L1("_TopicalAbsorptionRoute", "2.16.840.1.113883.5.112",
			"TopicalAbsorptionRoute", "TopicalAbsorptionRoute", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">TopicalApplication</div>
	 * <!-- @formatter:on -->
	 */
	TOPICALAPPLICATION_L1("_TopicalApplication", "2.16.840.1.113883.5.112", "TopicalApplication",
			"TopicalApplication", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical absorption, transtympanic</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_ABSORPTION_TRANSTYMPANIC_L2("TTYMPTABSORP", "2.16.840.1.113883.5.112",
			"Topical absorption, transtympanic", "Topical absorption, transtympanic", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, buccal</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_BUCCAL_L2("BUC", "2.16.840.1.113883.5.112", "Topical application, buccal",
			"Topical application, buccal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, cervical</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_CERVICAL_L2("CERV", "2.16.840.1.113883.5.112",
			"Topical application, cervical", "Topical application, cervical", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, dental</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_DENTAL_L2("DEN", "2.16.840.1.113883.5.112", "Topical application, dental",
			"Topical application, dental", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, gingival</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_GINGIVAL_L2("GIN", "2.16.840.1.113883.5.112",
			"Topical application, gingival", "Topical application, gingival", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, hair</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_HAIR_L2("HAIR", "2.16.840.1.113883.5.112", "Topical application, hair",
			"Topical application, hair", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, intracorneal</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_INTRACORNEAL_L2("ICORNTA", "2.16.840.1.113883.5.112",
			"Topical application, intracorneal", "Topical application, intracorneal", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, intracoronal (dental)</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_INTRACORONAL_DENTAL_L2("ICORONTA", "2.16.840.1.113883.5.112",
			"Topical application, intracoronal (dental)",
			"Topical application, intracoronal (dental)", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, intraesophageal</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_INTRAESOPHAGEAL_L2("IESOPHTA", "2.16.840.1.113883.5.112",
			"Topical application, intraesophageal", "Topical application, intraesophageal",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, intraileal</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_INTRAILEAL_L2("IILEALTA", "2.16.840.1.113883.5.112",
			"Topical application, intraileal", "Topical application, intraileal", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, intralesional</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_INTRALESIONAL_L2("ILTOP", "2.16.840.1.113883.5.112",
			"Topical application, intralesional", "Topical application, intralesional",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, intraluminal</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_INTRALUMINAL_L2("ILUMTA", "2.16.840.1.113883.5.112",
			"Topical application, intraluminal", "Topical application, intraluminal", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, intraocular</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_INTRAOCULAR_L2("IOTOP", "2.16.840.1.113883.5.112",
			"Topical application, intraocular", "Topical application, intraocular", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, iontophoresis</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_IONTOPHORESIS_L2("IONTO", "2.16.840.1.113883.5.112",
			"Topical application, iontophoresis", "Topical application, iontophoresis",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, laryngeal</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_LARYNGEAL_L2("LARYNGTA", "2.16.840.1.113883.5.112",
			"Topical application, laryngeal", "Topical application, laryngeal", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, mucous membrane</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_MUCOUS_MEMBRANE_L2("MUC", "2.16.840.1.113883.5.112",
			"Topical application, mucous membrane", "Topical application, mucous membrane",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, nail</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_NAIL_L2("NAIL", "2.16.840.1.113883.5.112", "Topical application, nail",
			"Topical application, nail", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, nasal</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_NASAL_L2("NASAL", "2.16.840.1.113883.5.112", "Topical application, nasal",
			"Topical application, nasal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, ophthalmic</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_OPHTHALMIC_L2("OPTHALTA", "2.16.840.1.113883.5.112",
			"Topical application, ophthalmic", "Topical application, ophthalmic", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, oral</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_ORAL_L2("ORALTA", "2.16.840.1.113883.5.112", "Topical application, oral",
			"Topical application, oral", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, oromucosal</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_OROMUCOSAL_L2("ORMUC", "2.16.840.1.113883.5.112",
			"Topical application, oromucosal", "Topical application, oromucosal", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, oropharyngeal</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_OROPHARYNGEAL_L2("OROPHARTA", "2.16.840.1.113883.5.112",
			"Topical application, oropharyngeal", "Topical application, oropharyngeal",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, perianal</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_PERIANAL_L2("PERIANAL", "2.16.840.1.113883.5.112",
			"Topical application, perianal", "Topical application, perianal", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, perineal</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_PERINEAL_L2("PERINEAL", "2.16.840.1.113883.5.112",
			"Topical application, perineal", "Topical application, perineal", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, periodontal</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_PERIODONTAL_L2("PDONTTA", "2.16.840.1.113883.5.112",
			"Topical application, periodontal", "Topical application, periodontal", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, rectal</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_RECTAL_L2("RECTAL", "2.16.840.1.113883.5.112",
			"Topical application, rectal", "Topical application, rectal", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, scalp</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_SCALP_L2("SCALP", "2.16.840.1.113883.5.112", "Topical application, scalp",
			"Topical application, scalp", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, skin</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_SKIN_L2("SKIN", "2.16.840.1.113883.5.112", "Topical application, skin",
			"Topical application, skin", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, soaked dressing</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_SOAKED_DRESSING_L2("DRESS", "2.16.840.1.113883.5.112",
			"Topical application, soaked dressing", "Topical application, soaked dressing",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, swab</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_SWAB_L2("SWAB", "2.16.840.1.113883.5.112", "Topical application, swab",
			"Topical application, swab", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, transmucosal</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_TRANSMUCOSAL_L2("TMUCTA", "2.16.840.1.113883.5.112",
			"Topical application, transmucosal", "Topical application, transmucosal", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical application, vaginal</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_APPLICATION_VAGINAL_L2("VAGINS", "2.16.840.1.113883.5.112",
			"Topical application, vaginal", "Topical application, vaginal", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Topical</div>
	 * <!-- @formatter:on -->
	 */
	TOPICAL_L2("TOPICAL", "2.16.840.1.113883.5.112", "Topical", "Topical", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">TracheostomyRoute</div>
	 * <!-- @formatter:on -->
	 */
	TRACHEOSTOMYROUTE_L1("_TracheostomyRoute", "2.16.840.1.113883.5.112", "TracheostomyRoute",
			"TracheostomyRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Transdermal</div>
	 * <!-- @formatter:on -->
	 */
	TRANSDERMAL_L1("TRNSDERM", "2.16.840.1.113883.5.112", "Transdermal", "Transdermal",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Translingual</div>
	 * <!-- @formatter:on -->
	 */
	TRANSLINGUAL_L1("TRNSLING", "2.16.840.1.113883.5.112", "Translingual", "Translingual",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Translingual</div>
	 * <!-- @formatter:on -->
	 */
	TRANSLINGUAL_L2("TRNSLING", "2.16.840.1.113883.5.112", "Translingual", "Translingual",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">TransmucosalRoute</div>
	 * <!-- @formatter:on -->
	 */
	TRANSMUCOSALROUTE_L1("_TransmucosalRoute", "2.16.840.1.113883.5.112", "TransmucosalRoute",
			"TransmucosalRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">TransplacentalRoute</div>
	 * <!-- @formatter:on -->
	 */
	TRANSPLACENTALROUTE_L1("_TransplacentalRoute", "2.16.840.1.113883.5.112", "TransplacentalRoute",
			"TransplacentalRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">TranstrachealRoute</div>
	 * <!-- @formatter:on -->
	 */
	TRANSTRACHEALROUTE_L1("_TranstrachealRoute", "2.16.840.1.113883.5.112", "TranstrachealRoute",
			"TranstrachealRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">TranstympanicRoute</div>
	 * <!-- @formatter:on -->
	 */
	TRANSTYMPANICROUTE_L1("_TranstympanicRoute", "2.16.840.1.113883.5.112", "TranstympanicRoute",
			"TranstympanicRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">UreteralRoute</div>
	 * <!-- @formatter:on -->
	 */
	URETERALROUTE_L1("_UreteralRoute", "2.16.840.1.113883.5.112", "UreteralRoute", "UreteralRoute",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">UrethralRoute</div>
	 * <!-- @formatter:on -->
	 */
	URETHRALROUTE_L1("_UrethralRoute", "2.16.840.1.113883.5.112", "UrethralRoute", "UrethralRoute",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">UrinaryBladderRoute</div>
	 * <!-- @formatter:on -->
	 */
	URINARYBLADDERROUTE_L1("_UrinaryBladderRoute", "2.16.840.1.113883.5.112", "UrinaryBladderRoute",
			"UrinaryBladderRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">UrinaryTractRoute</div>
	 * <!-- @formatter:on -->
	 */
	URINARYTRACTROUTE_L1("_UrinaryTractRoute", "2.16.840.1.113883.5.112", "UrinaryTractRoute",
			"UrinaryTractRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">VaginalRoute</div>
	 * <!-- @formatter:on -->
	 */
	VAGINALROUTE_L1("_VaginalRoute", "2.16.840.1.113883.5.112", "VaginalRoute", "VaginalRoute",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">VitreousHumourRoute</div>
	 * <!-- @formatter:on -->
	 */
	VITREOUSHUMOURROUTE_L1("_VitreousHumourRoute", "2.16.840.1.113883.5.112", "VitreousHumourRoute",
			"VitreousHumourRoute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for AmnioticFluidSacRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AMNIOTICFLUIDSACROUTE_L1_CODE = "_AmnioticFluidSacRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for BiliaryRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BILIARYROUTE_L1_CODE = "_BiliaryRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for BodySurfaceRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BODYSURFACEROUTE_L1_CODE = "_BodySurfaceRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for BuccalMucosaRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BUCCALMUCOSAROUTE_L1_CODE = "_BuccalMucosaRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for CecostomyRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CECOSTOMYROUTE_L1_CODE = "_CecostomyRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for CervicalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CERVICALROUTE_L1_CODE = "_CervicalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Chew</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHEW_L1_CODE = "_Chew";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Chew, oral</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHEW_ORAL_L2_CODE = "CHEW";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Diffusion, extracorporeal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DIFFUSION_EXTRACORPOREAL_L2_CODE = "EXTCORPDIF";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Diffusion, hemodialysis</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DIFFUSION_HEMODIALYSIS_L2_CODE = "HEMODIFF";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Diffusion</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DIFFUSION_L1_CODE = "_Diffusion";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Diffusion, transdermal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DIFFUSION_TRANSDERMAL_L2_CODE = "TRNSDERMD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dissolve</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DISSOLVE_L1_CODE = "_Dissolve";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dissolve, oral</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DISSOLVE_ORAL_L2_CODE = "DISSOLVE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dissolve, sublingual</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DISSOLVE_SUBLINGUAL_L2_CODE = "SL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Douche</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DOUCHE_L1_CODE = "_Douche";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Douche, vaginal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DOUCHE_VAGINAL_L2_CODE = "DOUCHE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ElectroOsmosisRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ELECTROOSMOSISROUTE_L1_CODE = "_ElectroOsmosisRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Electro-osmosis</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ELECTRO_OSMOSIS_L2_CODE = "ELECTOSMOS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for EndocervicalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENDOCERVICALROUTE_L1_CODE = "_EndocervicalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Enema</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENEMA_L1_CODE = "_Enema";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Enema, rectal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENEMA_RECTAL_L2_CODE = "ENEMA";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Enema, rectal retention</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENEMA_RECTAL_RETENTION_L2_CODE = "RETENEMA";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for EnteralRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENTERALROUTE_L1_CODE = "_EnteralRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for EpiduralRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EPIDURALROUTE_L1_CODE = "_EpiduralRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ExtraAmnioticRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EXTRAAMNIOTICROUTE_L1_CODE = "_ExtraAmnioticRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ExtracorporealCirculationRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EXTRACORPOREALCIRCULATIONROUTE_L1_CODE = "_ExtracorporealCirculationRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Flush, intravenous catheter</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FLUSH_INTRAVENOUS_CATHETER_L2_CODE = "IVFLUSH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Flush</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FLUSH_L1_CODE = "_Flush";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gargle</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GARGLE_L1_CODE = "GARGLE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gargle</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GARGLE_L2_CODE = "GARGLE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for GastricRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GASTRICROUTE_L1_CODE = "_GastricRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for GenitourinaryRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GENITOURINARYROUTE_L1_CODE = "_GenitourinaryRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for GingivalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GINGIVALROUTE_L1_CODE = "_GingivalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for HairRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HAIRROUTE_L1_CODE = "_HairRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Immersion (soak)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMMERSION_SOAK_L1_CODE = "SOAK";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Immersion (soak)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMMERSION_SOAK_L2_CODE = "SOAK";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Implantation, intradermal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMPLANTATION_INTRADERMAL_L2_CODE = "IDIMPLNT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Implantation, intravitreal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMPLANTATION_INTRAVITREAL_L2_CODE = "IVITIMPLNT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Implantation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMPLANTATION_L1_CODE = "_Implantation";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Implantation, subcutaneous</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMPLANTATION_SUBCUTANEOUS_L2_CODE = "SQIMPLNT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Infusion, epidural</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INFUSION_EPIDURAL_L2_CODE = "EPI";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Infusion, intraarterial catheter</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INFUSION_INTRAARTERIAL_CATHETER_L2_CODE = "IA";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Infusion, intracardiac</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INFUSION_INTRACARDIAC_L2_CODE = "IC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Infusion, intracoronary</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INFUSION_INTRACORONARY_L2_CODE = "ICOR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Infusion, intraosseous, continuous</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INFUSION_INTRAOSSEOUS_CONTINUOUS_L2_CODE = "IOSSC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Infusion, intrathecal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INFUSION_INTRATHECAL_L2_CODE = "IT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Infusion, intravascular</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INFUSION_INTRAVASCULAR_L2_CODE = "IVASCINFUS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Infusion, intravenous catheter, continuous</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INFUSION_INTRAVENOUS_CATHETER_CONTINUOUS_L3_CODE = "IVCC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Infusion, intravenous catheter, intermittent</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INFUSION_INTRAVENOUS_CATHETER_INTERMITTENT_L3_CODE = "IVCI";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Infusion, intravenous catheter</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INFUSION_INTRAVENOUS_CATHETER_L3_CODE = "IVC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Infusion, intravenous catheter, pca pump</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INFUSION_INTRAVENOUS_CATHETER_PCA_PUMP_L3_CODE = "PCA";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Infusion, intravenous</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INFUSION_INTRAVENOUS_L2_CODE = "IV";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Infusion</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INFUSION_L1_CODE = "_Infusion";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Infusion, subcutaneous</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INFUSION_SUBCUTANEOUS_L2_CODE = "SQINFUS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation, intermittent positive pressure breathing (ippb)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_INTERMITTENT_POSITIVE_PRESSURE_BREATHING_IPPB_L2_CODE = "IPPB";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_L1_CODE = "_Inhalation";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation, nasal cannula Inhalation, nasal, prongs</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_NASAL_CANNULA_INHALATION_NASAL_PRONGS_L3_CODE = "NASINHLC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation, nasal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_NASAL_L2_CODE = "NASINHL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation, nebulization</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_NEBULIZATION_L2_CODE = "NEB";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation, nebulization, nasal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_NEBULIZATION_NASAL_L3_CODE = "NASNEB";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation, nebulization, oral</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_NEBULIZATION_ORAL_L3_CODE = "ORNEB";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation, oral intermittent flow</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_ORAL_INTERMITTENT_FLOW_L3_CODE = "ORIFINHL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation, oral rebreather mask</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_ORAL_REBREATHER_MASK_L3_CODE = "REBREATH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation, respiratory Inhalation, intrapulmonary Inhalation, oral</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_RESPIRATORY_INHALATION_INTRAPULMONARY_INHALATION_ORAL_L2_CODE = "IPINHL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation, tracheostomy</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_TRACHEOSTOMY_L2_CODE = "TRACH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation, ventilator</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_VENTILATOR_L2_CODE = "VENT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Inhalation, ventimask</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INHALATION_VENTIMASK_L2_CODE = "VENTMASK";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, amniotic fluid</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_AMNIOTIC_FLUID_L2_CODE = "AMNINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, biliary tract</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_BILIARY_TRACT_L2_CODE = "BILINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, cervical</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_CERVICAL_L2_CODE = "CERVINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, endosinusial</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_ENDOSINUSIAL_L2_CODE = "ENDOSININJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, epidural</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_EPIDURAL_L2_CODE = "EPIDURINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, epidural, push</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_EPIDURAL_PUSH_L2_CODE = "EPIINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, epidural, slow push</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_EPIDURAL_SLOW_PUSH_L2_CODE = "EPINJSP";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, extracorporeal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_EXTRACORPOREAL_L2_CODE = "EXTCORPINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, extra-amniotic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_EXTRA_AMNIOTIC_L2_CODE = "EXTRAMNINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, for cholangiography</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_FOR_CHOLANGIOGRAPHY_L2_CODE = "CHOLINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, gastric button</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_GASTRIC_BUTTON_L2_CODE = "GBINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, gingival</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_GINGIVAL_L2_CODE = "GINGINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, hemodialysis port</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_HEMODIALYSIS_PORT_L2_CODE = "HEMOPORT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, insulin pump</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INSULIN_PUMP_L2_CODE = "IPUMPINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, interameningeal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTERAMENINGEAL_L2_CODE = "INTERMENINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, interstitial</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTERSTITIAL_L2_CODE = "INTERSTITINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intraarterial</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAARTERIAL_L2_CODE = "IAINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intraarterial, push</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAARTERIAL_PUSH_L3_CODE = "IAINJP";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intraarterial, slow push</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAARTERIAL_SLOW_PUSH_L3_CODE = "IAINJSP";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intraarticular</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAARTICULAR_L2_CODE = "IARTINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intrabursal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRABURSAL_L2_CODE = "IBURSINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intracardiac</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRACARDIAC_L2_CODE = "ICARDINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intracardiac, push</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRACARDIAC_PUSH_L3_CODE = "ICARINJP";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intracardiac, rapid push</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRACARDIAC_RAPID_PUSH_L3_CODE = "ICARDINJRP";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intracardiac, slow push</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRACARDIAC_SLOW_PUSH_L3_CODE = "ICARDINJSP";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intracartilaginous</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRACARTILAGINOUS_L2_CODE = "ICARTINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intracaudal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRACAUDAL_L2_CODE = "ICAUDINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intracavernous</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRACAVERNOUS_L2_CODE = "ICAVINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intracavitary</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRACAVITARY_L2_CODE = "ICAVITINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intracerebral</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRACEREBRAL_L2_CODE = "ICEREBINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intracervical (uterus)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRACERVICAL_UTERUS_L2_CODE = "IUINJC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intracisternal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRACISTERNAL_L2_CODE = "ICISTERNINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intracoronary</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRACORONARY_L2_CODE = "ICORONINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intracoronary, push</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRACORONARY_PUSH_L3_CODE = "ICORONINJP";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intracorpus cavernosum</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRACORPUS_CAVERNOSUM_L2_CODE = "ICORPCAVINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intradermal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRADERMAL_L2_CODE = "IDINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intradiscal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRADISCAL_L2_CODE = "IDISCINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intraductal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRADUCTAL_L2_CODE = "IDUCTINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intradural</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRADURAL_L2_CODE = "IDURINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intraepidermal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAEPIDERMAL_L2_CODE = "IEPIDINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intraepithelial</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAEPITHELIAL_L2_CODE = "IEPITHINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intralesional</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRALESIONAL_L2_CODE = "ILESINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intraluminal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRALUMINAL_L2_CODE = "ILUMINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intralymphatic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRALYMPHATIC_L2_CODE = "ILYMPJINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intramedullary</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAMEDULLARY_L2_CODE = "IMEDULINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intramuscular, deep</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAMUSCULAR_DEEP_L3_CODE = "IMD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intramuscular</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAMUSCULAR_L2_CODE = "IM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intramuscular, z track</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAMUSCULAR_Z_TRACK_L3_CODE = "IMZ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intraocular</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAOCULAR_L2_CODE = "IOINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intraosseous</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAOSSEOUS_L2_CODE = "IOSSINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intraovarian</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAOVARIAN_L2_CODE = "IOVARINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intrapericardial</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAPERICARDIAL_L2_CODE = "IPCARDINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intraperitoneal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAPERITONEAL_L2_CODE = "IPERINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intrapleural</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAPLEURAL_L2_CODE = "IPLRINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intraprostatic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAPROSTATIC_L2_CODE = "IPROSTINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intrapulmonary</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAPULMONARY_L2_CODE = "IPINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intraspinal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRASPINAL_L2_CODE = "ISINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intrasternal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRASTERNAL_L2_CODE = "ISTERINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intrasynovial</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRASYNOVIAL_L2_CODE = "ISYNINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intratendinous</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRATENDINOUS_L2_CODE = "ITENDINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intratesticular</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRATESTICULAR_L2_CODE = "ITESTINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intrathecal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRATHECAL_L2_CODE = "ITINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intrathoracic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRATHORACIC_L2_CODE = "ITHORINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intratubular</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRATUBULAR_L2_CODE = "ITUBINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intratumor</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRATUMOR_L2_CODE = "ITUMINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intratympanic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRATYMPANIC_L2_CODE = "ITYMPINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intraureteral, retrograde</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAURETERAL_RETROGRADE_L2_CODE = "IURETINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intrauterine</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAUTERINE_L2_CODE = "IUINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intravascular</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAVASCULAR_L2_CODE = "IVASCINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intravenous, bolus</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAVENOUS_BOLUS_L3_CODE = "IVINJBOL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intravenous</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAVENOUS_L2_CODE = "IVINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intravenous, push</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAVENOUS_PUSH_L3_CODE = "IVPUSH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intravenous, rapid push</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAVENOUS_RAPID_PUSH_L3_CODE = "IVRPUSH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intravenous, slow push</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAVENOUS_SLOW_PUSH_L3_CODE = "IVSPUSH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intraventricular (heart)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAVENTRICULAR_HEART_L2_CODE = "IVENTINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intravesicle</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAVESICLE_L2_CODE = "IVESINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intravitreal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRAVITREAL_L2_CODE = "IVITINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, intra-abdominal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_INTRA_ABDOMINAL_L2_CODE = "IABDINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_L1_CODE = "_Injection";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, paranasal sinuses</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_PARANASAL_SINUSES_L2_CODE = "PNSINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, parenteral</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_PARENTERAL_L2_CODE = "PARENTINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, periarticular</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_PERIARTICULAR_L2_CODE = "PAINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, peridural</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_PERIDURAL_L2_CODE = "PDURINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, perineural</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_PERINEURAL_L2_CODE = "PNINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, periodontal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_PERIODONTAL_L2_CODE = "PDONTINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, peritoneal dialysis port</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_PERITONEAL_DIALYSIS_PORT_L2_CODE = "PDPINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, retrobulbar</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_RETROBULBAR_L2_CODE = "RBINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, soft tissue</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_SOFT_TISSUE_L2_CODE = "SOFTISINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, subarachnoid</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_SUBARACHNOID_L2_CODE = "SUBARACHINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, subconjunctival</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_SUBCONJUNCTIVAL_L2_CODE = "SCINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, subcutaneous</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_SUBCUTANEOUS_L2_CODE = "SQ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, sublesional</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_SUBLESIONAL_L2_CODE = "SLESINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, submucosal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_SUBMUCOSAL_L2_CODE = "SUBMUCINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, transplacental</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_TRANSPLACENTAL_L2_CODE = "TRPLACINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, transtracheal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_TRANSTRACHEAL_L2_CODE = "TRTRACHINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, ureteral</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_URETERAL_L2_CODE = "URETINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, urethral</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_URETHRAL_L2_CODE = "URETHINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Injection, urinary bladder</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INJECTION_URINARY_BLADDER_L2_CODE = "BLADINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Insertion, cervical (uterine)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSERTION_CERVICAL_UTERINE_L2_CODE = "CERVINS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Insertion, intraocular, surgical</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSERTION_INTRAOCULAR_SURGICAL_L2_CODE = "IOSURGINS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Insertion, intrauterine</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSERTION_INTRAUTERINE_L2_CODE = "IU";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Insertion</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSERTION_L1_CODE = "_Insertion";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Insertion, lacrimal puncta</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSERTION_LACRIMAL_PUNCTA_L2_CODE = "LPINS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Insertion, rectal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSERTION_RECTAL_L2_CODE = "PR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Insertion, subcutaneous, surgical</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSERTION_SUBCUTANEOUS_SURGICAL_L2_CODE = "SQSURGINS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Insertion, urethral</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSERTION_URETHRAL_L2_CODE = "URETHINS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Insertion, vaginal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSERTION_VAGINAL_L2_CODE = "VAGINSI";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, cecostomy</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_CECOSTOMY_L2_CODE = "CECINSTL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, chest tube</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_CHEST_TUBE_L2_CODE = "CTINSTL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, continuous ambulatory peritoneal dialysis port</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_CONTINUOUS_AMBULATORY_PERITONEAL_DIALYSIS_PORT_L2_CODE = "CAPDINSTL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, endotracheal tube</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_ENDOTRACHEAL_TUBE_L2_CODE = "ETINSTL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, enteral feeding tube</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_ENTERAL_FEEDING_TUBE_L2_CODE = "EFT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, enteral</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_ENTERAL_L2_CODE = "ENTINSTL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, gastrostomy tube</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_GASTROSTOMY_TUBE_L2_CODE = "GT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, gastro-jejunostomy tube</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_GASTRO_JEJUNOSTOMY_TUBE_L2_CODE = "GJT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, intrabronchial</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_INTRABRONCHIAL_L2_CODE = "IBRONCHINSTIL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, intraduodenal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_INTRADUODENAL_L2_CODE = "IDUODINSTIL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, intraesophageal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_INTRAESOPHAGEAL_L2_CODE = "IESOPHINSTIL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, intragastric</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_INTRAGASTRIC_L2_CODE = "IGASTINSTIL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, intraileal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_INTRAILEAL_L2_CODE = "IILEALINJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, intraocular</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_INTRAOCULAR_L2_CODE = "IOINSTL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, intrasinal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_INTRASINAL_L2_CODE = "ISININSTIL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, intratracheal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_INTRATRACHEAL_L2_CODE = "ITRACHINSTIL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, intrauterine</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_INTRAUTERINE_L2_CODE = "IUINSTL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, jejunostomy tube</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_JEJUNOSTOMY_TUBE_L2_CODE = "JJTINSTL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_L1_CODE = "_Instillation";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, laryngeal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_LARYNGEAL_L2_CODE = "LARYNGINSTIL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, nasal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_NASAL_L2_CODE = "NASALINSTIL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, nasogastric</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_NASOGASTRIC_L2_CODE = "NASOGASINSTIL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, nasogastric tube</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_NASOGASTRIC_TUBE_L2_CODE = "NGT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, nasotracheal tube</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_NASOTRACHEAL_TUBE_L2_CODE = "NTT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, orogastric tube</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_OROGASTRIC_TUBE_L2_CODE = "OGT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, orojejunum tube</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_OROJEJUNUM_TUBE_L2_CODE = "OJJ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, otic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_OTIC_L2_CODE = "OT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, paranasal sinuses</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_PARANASAL_SINUSES_L2_CODE = "PNSINSTL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, peritoneal dialysis port</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_PERITONEAL_DIALYSIS_PORT_L2_CODE = "PDPINSTL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, rectal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_RECTAL_L2_CODE = "RECINSTL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, rectal tube</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_RECTAL_TUBE_L3_CODE = "RECTINSTL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, sinus, unspecified</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_SINUS_UNSPECIFIED_L2_CODE = "SININSTIL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, soft tissue</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_SOFT_TISSUE_L2_CODE = "SOFTISINSTIL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, tracheostomy</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_TRACHEOSTOMY_L2_CODE = "TRACHINSTL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, transtympanic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_TRANSTYMPANIC_L2_CODE = "TRTYMPINSTIL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for instillation, urethral</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_URETHRAL_L2_CODE = "URETHINSTL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Instillation, urinary catheter</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSTILLATION_URINARY_CATHETER_L2_CODE = "BLADINSTL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Insufflation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INSUFFLATION_L1_CODE = "INSUF";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for InterameningealRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTERAMENINGEALROUTE_L1_CODE = "_InterameningealRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for InterstitialRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTERSTITIALROUTE_L1_CODE = "_InterstitialRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntraabdominalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAABDOMINALROUTE_L1_CODE = "_IntraabdominalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntraarterialRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAARTERIALROUTE_L1_CODE = "_IntraarterialRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntraarticularRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAARTICULARROUTE_L1_CODE = "_IntraarticularRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntrabronchialRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRABRONCHIALROUTE_L1_CODE = "_IntrabronchialRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntrabursalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRABURSALROUTE_L1_CODE = "_IntrabursalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntracardiacRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRACARDIACROUTE_L1_CODE = "_IntracardiacRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntracartilaginousRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRACARTILAGINOUSROUTE_L1_CODE = "_IntracartilaginousRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntracaudalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRACAUDALROUTE_L1_CODE = "_IntracaudalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntracavernosalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRACAVERNOSALROUTE_L1_CODE = "_IntracavernosalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntracavitaryRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRACAVITARYROUTE_L1_CODE = "_IntracavitaryRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntracerebralRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRACEREBRALROUTE_L1_CODE = "_IntracerebralRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntracervicalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRACERVICALROUTE_L1_CODE = "_IntracervicalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntracisternalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRACISTERNALROUTE_L1_CODE = "_IntracisternalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntracornealRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRACORNEALROUTE_L1_CODE = "_IntracornealRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntracoronalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRACORONALROUTE_L1_CODE = "_IntracoronalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntracoronaryRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRACORONARYROUTE_L1_CODE = "_IntracoronaryRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntracorpusCavernosumRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRACORPUSCAVERNOSUMROUTE_L1_CODE = "_IntracorpusCavernosumRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntradermalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRADERMALROUTE_L1_CODE = "_IntradermalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntradiscalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRADISCALROUTE_L1_CODE = "_IntradiscalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntraductalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRADUCTALROUTE_L1_CODE = "_IntraductalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntraduodenalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRADUODENALROUTE_L1_CODE = "_IntraduodenalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntraduralRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRADURALROUTE_L1_CODE = "_IntraduralRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntraepidermalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAEPIDERMALROUTE_L1_CODE = "_IntraepidermalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntraepithelialRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAEPITHELIALROUTE_L1_CODE = "_IntraepithelialRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntraesophagealRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAESOPHAGEALROUTE_L1_CODE = "_IntraesophagealRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntragastricRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAGASTRICROUTE_L1_CODE = "_IntragastricRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntrailealRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAILEALROUTE_L1_CODE = "_IntrailealRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntralesionalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRALESIONALROUTE_L1_CODE = "_IntralesionalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntraluminalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRALUMINALROUTE_L1_CODE = "_IntraluminalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntralymphaticRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRALYMPHATICROUTE_L1_CODE = "_IntralymphaticRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntramedullaryRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAMEDULLARYROUTE_L1_CODE = "_IntramedullaryRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntramuscularRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAMUSCULARROUTE_L1_CODE = "_IntramuscularRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntraocularRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAOCULARROUTE_L1_CODE = "_IntraocularRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntraosseousRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAOSSEOUSROUTE_L1_CODE = "_IntraosseousRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntraovarianRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAOVARIANROUTE_L1_CODE = "_IntraovarianRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntrapericardialRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAPERICARDIALROUTE_L1_CODE = "_IntrapericardialRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntraperitonealRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAPERITONEALROUTE_L1_CODE = "_IntraperitonealRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntrapleuralRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAPLEURALROUTE_L1_CODE = "_IntrapleuralRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntraprostaticRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAPROSTATICROUTE_L1_CODE = "_IntraprostaticRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntrapulmonaryRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAPULMONARYROUTE_L1_CODE = "_IntrapulmonaryRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntrasinalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRASINALROUTE_L1_CODE = "_IntrasinalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntraspinalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRASPINALROUTE_L1_CODE = "_IntraspinalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntrasternalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRASTERNALROUTE_L1_CODE = "_IntrasternalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntrasynovialRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRASYNOVIALROUTE_L1_CODE = "_IntrasynovialRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntratendinousRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRATENDINOUSROUTE_L1_CODE = "_IntratendinousRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntratesticularRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRATESTICULARROUTE_L1_CODE = "_IntratesticularRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntrathecalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRATHECALROUTE_L1_CODE = "_IntrathecalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntrathoracicRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRATHORACICROUTE_L1_CODE = "_IntrathoracicRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntratrachealRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRATRACHEALROUTE_L1_CODE = "_IntratrachealRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntratubularRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRATUBULARROUTE_L1_CODE = "_IntratubularRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntratumorRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRATUMORROUTE_L1_CODE = "_IntratumorRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntratympanicRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRATYMPANICROUTE_L1_CODE = "_IntratympanicRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntrauterineRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAUTERINEROUTE_L1_CODE = "_IntrauterineRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntravascularRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAVASCULARROUTE_L1_CODE = "_IntravascularRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntravenousRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAVENOUSROUTE_L1_CODE = "_IntravenousRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntraventricularRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAVENTRICULARROUTE_L1_CODE = "_IntraventricularRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntravesicleRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAVESICLEROUTE_L1_CODE = "_IntravesicleRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IntravitrealRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTRAVITREALROUTE_L1_CODE = "_IntravitrealRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IontophoresisRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IONTOPHORESISROUTE_L1_CODE = "_IontophoresisRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Irrigation, genitourinary</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IRRIGATION_GENITOURINARY_L2_CODE = "GUIRR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Irrigation, intragastric</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IRRIGATION_INTRAGASTRIC_L2_CODE = "IGASTIRR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Irrigation, intralesional</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IRRIGATION_INTRALESIONAL_L2_CODE = "ILESIRR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Irrigation, intraocular</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IRRIGATION_INTRAOCULAR_L2_CODE = "IOIRR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Irrigation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IRRIGATION_L1_CODE = "_Irrigation";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Irrigation, rectal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IRRIGATION_RECTAL_L2_CODE = "RECIRR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Irrigation, urinary bladder, continuous</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IRRIGATION_URINARY_BLADDER_CONTINUOUS_L3_CODE = "BLADIRRC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Irrigation, urinary bladder</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IRRIGATION_URINARY_BLADDER_L2_CODE = "BLADIRR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Irrigation, urinary bladder, tidal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IRRIGATION_URINARY_BLADDER_TIDAL_L3_CODE = "BLADIRRT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for JejunumRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String JEJUNUMROUTE_L1_CODE = "_JejunumRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for LacrimalPunctaRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LACRIMALPUNCTAROUTE_L1_CODE = "_LacrimalPunctaRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for LaryngealRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LARYNGEALROUTE_L1_CODE = "_LaryngealRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for LavageRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LAVAGEROUTE_L1_CODE = "_LavageRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Lavage, intragastric</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LAVAGE_INTRAGASTRIC_L2_CODE = "IGASTLAV";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for LingualRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LINGUALROUTE_L1_CODE = "_LingualRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for MucosalAbsorptionRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MUCOSALABSORPTIONROUTE_L1_CODE = "_MucosalAbsorptionRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Mucosal absorption, intraduodenal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MUCOSAL_ABSORPTION_INTRADUODENAL_L2_CODE = "IDOUDMAB";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Mucosal absorption, intratracheal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MUCOSAL_ABSORPTION_INTRATRACHEAL_L2_CODE = "ITRACHMAB";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Mucosal absorption, submucosal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MUCOSAL_ABSORPTION_SUBMUCOSAL_L2_CODE = "SMUCMAB";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for MucousMembraneRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MUCOUSMEMBRANEROUTE_L1_CODE = "_MucousMembraneRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for NailRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NAILROUTE_L1_CODE = "_NailRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for NasalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NASALROUTE_L1_CODE = "_NasalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nebulization, endotracheal tube</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEBULIZATION_ENDOTRACHEAL_TUBE_L2_CODE = "ETNEB";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nebulization</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEBULIZATION_L1_CODE = "_Nebulization";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Occlusive dressing technique</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OCCLUSIVE_DRESSING_TECHNIQUE_L2_CODE = "OCDRESTA";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for OphthalmicRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OPHTHALMICROUTE_L1_CODE = "_OphthalmicRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for OralRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORALROUTE_L1_CODE = "_OralRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for OromucosalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OROMUCOSALROUTE_L1_CODE = "_OromucosalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for OropharyngealRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OROPHARYNGEALROUTE_L1_CODE = "_OropharyngealRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for OticRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OTICROUTE_L1_CODE = "_OticRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ParanasalSinusesRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PARANASALSINUSESROUTE_L1_CODE = "_ParanasalSinusesRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ParenteralRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PARENTERALROUTE_L1_CODE = "_ParenteralRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for PerianalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PERIANALROUTE_L1_CODE = "_PerianalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for PeriarticularRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PERIARTICULARROUTE_L1_CODE = "_PeriarticularRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for PeriduralRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PERIDURALROUTE_L1_CODE = "_PeriduralRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for PerinealRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PERINEALROUTE_L1_CODE = "_PerinealRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for PerineuralRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PERINEURALROUTE_L1_CODE = "_PerineuralRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for PeriodontalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PERIODONTALROUTE_L1_CODE = "_PeriodontalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for PulmonaryRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PULMONARYROUTE_L1_CODE = "_PulmonaryRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for RectalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RECTALROUTE_L1_CODE = "_RectalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for RespiratoryTractRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RESPIRATORYTRACTROUTE_L1_CODE = "_RespiratoryTractRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for RetrobulbarRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RETROBULBARROUTE_L1_CODE = "_RetrobulbarRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Rinse, dental</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RINSE_DENTAL_L2_CODE = "DENRINSE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Rinse</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RINSE_L1_CODE = "_Rinse";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Rinse, oral</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RINSE_ORAL_L2_CODE = "ORRINSE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ScalpRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SCALPROUTE_L1_CODE = "_ScalpRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Shampoo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SHAMPOO_L1_CODE = "SHAMPOO";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Shampoo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SHAMPOO_L2_CODE = "SHAMPOO";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for SinusUnspecifiedRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SINUSUNSPECIFIEDROUTE_L1_CODE = "_SinusUnspecifiedRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for SkinRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SKINROUTE_L1_CODE = "_SkinRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for SoftTissueRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOFTTISSUEROUTE_L1_CODE = "_SoftTissueRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for SubarachnoidRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUBARACHNOIDROUTE_L1_CODE = "_SubarachnoidRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for SubconjunctivalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUBCONJUNCTIVALROUTE_L1_CODE = "_SubconjunctivalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Subconjunctival</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUBCONJUNCTIVAL_L2_CODE = "SUBCONJTA";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for SubcutaneousRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUBCUTANEOUSROUTE_L1_CODE = "_SubcutaneousRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for SublesionalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUBLESIONALROUTE_L1_CODE = "_SublesionalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for SublingualRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUBLINGUALROUTE_L1_CODE = "_SublingualRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for SubmucosalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUBMUCOSALROUTE_L1_CODE = "_SubmucosalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Suck, oromucosal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUCK_OROMUCOSAL_L1_CODE = "SUCK";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Suck, oromucosal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUCK_OROMUCOSAL_L2_CODE = "SUCK";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for SuppositoryRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUPPOSITORYROUTE_L1_CODE = "_SuppositoryRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Suppository, urethral</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUPPOSITORY_URETHRAL_L2_CODE = "URETHSUP";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Swallow, oral</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SWALLOW_ORAL_L1_CODE = "PO";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Swallow, oral</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SWALLOW_ORAL_L2_CODE = "PO";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Swish and spit out, oromucosal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SWISH_AND_SPIT_OUT_OROMUCOSAL_L2_CODE = "SWISHSPIT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Swish and swallow, oromucosal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SWISH_AND_SWALLOW_OROMUCOSAL_L2_CODE = "SWISHSWAL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Swish</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SWISH_L1_CODE = "_Swish";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for TopicalAbsorptionRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICALABSORPTIONROUTE_L1_CODE = "_TopicalAbsorptionRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for TopicalApplication</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICALAPPLICATION_L1_CODE = "_TopicalApplication";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical absorption, transtympanic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_ABSORPTION_TRANSTYMPANIC_L2_CODE = "TTYMPTABSORP";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, buccal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_BUCCAL_L2_CODE = "BUC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, cervical</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_CERVICAL_L2_CODE = "CERV";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, dental</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_DENTAL_L2_CODE = "DEN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, gingival</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_GINGIVAL_L2_CODE = "GIN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, hair</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_HAIR_L2_CODE = "HAIR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, intracorneal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_INTRACORNEAL_L2_CODE = "ICORNTA";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, intracoronal (dental)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_INTRACORONAL_DENTAL_L2_CODE = "ICORONTA";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, intraesophageal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_INTRAESOPHAGEAL_L2_CODE = "IESOPHTA";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, intraileal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_INTRAILEAL_L2_CODE = "IILEALTA";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, intralesional</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_INTRALESIONAL_L2_CODE = "ILTOP";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, intraluminal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_INTRALUMINAL_L2_CODE = "ILUMTA";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, intraocular</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_INTRAOCULAR_L2_CODE = "IOTOP";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, iontophoresis</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_IONTOPHORESIS_L2_CODE = "IONTO";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, laryngeal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_LARYNGEAL_L2_CODE = "LARYNGTA";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, mucous membrane</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_MUCOUS_MEMBRANE_L2_CODE = "MUC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, nail</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_NAIL_L2_CODE = "NAIL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, nasal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_NASAL_L2_CODE = "NASAL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, ophthalmic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_OPHTHALMIC_L2_CODE = "OPTHALTA";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, oral</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_ORAL_L2_CODE = "ORALTA";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, oromucosal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_OROMUCOSAL_L2_CODE = "ORMUC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, oropharyngeal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_OROPHARYNGEAL_L2_CODE = "OROPHARTA";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, perianal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_PERIANAL_L2_CODE = "PERIANAL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, perineal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_PERINEAL_L2_CODE = "PERINEAL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, periodontal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_PERIODONTAL_L2_CODE = "PDONTTA";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, rectal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_RECTAL_L2_CODE = "RECTAL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, scalp</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_SCALP_L2_CODE = "SCALP";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, skin</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_SKIN_L2_CODE = "SKIN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, soaked dressing</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_SOAKED_DRESSING_L2_CODE = "DRESS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, swab</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_SWAB_L2_CODE = "SWAB";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, transmucosal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_TRANSMUCOSAL_L2_CODE = "TMUCTA";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical application, vaginal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_APPLICATION_VAGINAL_L2_CODE = "VAGINS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Topical</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOPICAL_L2_CODE = "TOPICAL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for TracheostomyRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TRACHEOSTOMYROUTE_L1_CODE = "_TracheostomyRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Transdermal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TRANSDERMAL_L1_CODE = "TRNSDERM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Translingual</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TRANSLINGUAL_L1_CODE = "TRNSLING";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Translingual</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TRANSLINGUAL_L2_CODE = "TRNSLING";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for TransmucosalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TRANSMUCOSALROUTE_L1_CODE = "_TransmucosalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for TransplacentalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TRANSPLACENTALROUTE_L1_CODE = "_TransplacentalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for TranstrachealRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TRANSTRACHEALROUTE_L1_CODE = "_TranstrachealRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for TranstympanicRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TRANSTYMPANICROUTE_L1_CODE = "_TranstympanicRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for UreteralRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String URETERALROUTE_L1_CODE = "_UreteralRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for UrethralRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String URETHRALROUTE_L1_CODE = "_UrethralRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for UrinaryBladderRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String URINARYBLADDERROUTE_L1_CODE = "_UrinaryBladderRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for UrinaryTractRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String URINARYTRACTROUTE_L1_CODE = "_UrinaryTractRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for VaginalRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VAGINALROUTE_L1_CODE = "_VaginalRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for VitreousHumourRoute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VITREOUSHUMOURROUTE_L1_CODE = "_VitreousHumourRoute";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.1.11.79";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "RouteOfAdministrationImmunization";

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
	public static RouteOfAdministrationImmunization getEnum(String code) {
		for (final RouteOfAdministrationImmunization x : values()) {
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
			Enum.valueOf(RouteOfAdministrationImmunization.class, enumName);
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
		for (final RouteOfAdministrationImmunization x : values()) {
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
	RouteOfAdministrationImmunization(String code, String codeSystem, String displayName,
			String displayNameEn, String displayNameDe, String displayNameFr,
			String displayNameIt) {
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
