package org.ehealth_connector.fhir;

import org.ehealth_connector.common.enums.CodeSystems;

/**
 * <div class="en">Common material for Fhir package</div> <div
 * class="de"></div><div class="fr"></div>.
 */
public class FhirCommon {

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsComment = "urn:ehealth_connector:FhirExtension:useAsComment";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsReason = "urn:ehealth_connector:FhirExtension:useAsReason";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsMimeType = "urn:ehealth_connector:FhirExtension:useAsMimeType";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsFormatCode = "urn:ehealth_connector:FhirExtension:useAsFormatCode";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsPracticeSettingCode = "urn:ehealth_connector:FhirExtension:useAsPracticeSettingCode";

	/**
	 * <div class="en">uniform resource name (urn) of this OID</div> <div
	 * class="de"></div><div class="fr"></div>.
	 */
	public static final String oidConfidentialityCode = "urn:oid:"
			+ CodeSystems.ConfidentialityCode.getCodeSystemId();

}
