package org.ehc.cda;

/**
 * Defines allowed route codes in an eVACDOC.
 * 
 * @see cda-ch-vacd-voc.xml from Schematron validation.
 * 
 * @author gsc
 */
public enum RouteCode {

	IDINJ("Injection, intradermal/Injektion, intradermal"),
	NASNEB("Inhalation, nebulization, nasal/Inhalation, Vernebelung, nasal"),
	PO("Swallow, oral/Schlucken, oral"),
	SQ("Injection, subcutaneous/Injektion, subkutan"),
	TRNSDERMD("Diffusion, transdermal/Diffusion, transdermal"),
	IM("Injection, intramuscular/Injektion, intramuskulär");
	
	private String displayName;
	
	private RouteCode(String value) {
		this.displayName = value;
	}
	
	public String getDisplayName() {
		return this.displayName;
	}
}
