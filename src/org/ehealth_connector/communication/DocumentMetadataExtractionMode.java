package org.ehealth_connector.communication;

/**
 * The Class MetadataExtractionMode
 *
 */
public enum DocumentMetadataExtractionMode {
	/**
	 * <div class="en">Minimal (secure) metadata will be extracted if set to
	 * default, metadata for the document entries will be extracted as far as
	 * this is possible. if set to false the user of this API has to set all
	 * data by himself. Extraction from CDA Documents to Document Entries uses
	 * the following mapping (for more details see CDAR2Extractor.pdf in
	 * org.openhealthtools.ihe.xds.metadata.extract.cdar2):
	 * <table summary="CDA Metadata to XDS Metadata mapping" width="100%">
	 * <thead>
	 * <tr>
	 * <th width="20%">XDS Metadata Attribute</th>
	 * <th width="80%">XDS Element</th>
	 * </tr>
	 * </thead> <tbody>
	 * <tr>
	 * <td>creationTime</td>
	 * <td>ClinicalDocument/effectiveTime</td>
	 * </tr>
	 * <tr>
	 * <td>languageCode</td>
	 * <td>ClinicalDocument/languageCode/@code</td>
	 * </tr>
	 * <tr>
	 * <td>legalAuthenticator</td>
	 * <td>ClinicalDocument/legalAuthenticator/assignedEntity/id and
	 * ClinicalDocument /legalAuthenticator/assignedEntity/assignedPerson/name</td>
	 * </tr>
	 * <tr>
	 * <td>serviceStartTime</td>
	 * <td>
	 * ClinicalDocument/documentationOf/serviceEvent/effectiveTime This time is
	 * to be in UTC, but without the timezone offset or fractional seconds:
	 * [[[[[YYYY]MM]DD]HH]mm]ss].</td>
	 * </tr>
	 * <tr>
	 * <td>serviceStopTime</td>
	 * <td>
	 * ClinicalDocument/documentationOf/serviceEvent/effectiveTime This time is
	 * to be in UTC, but without the timezone offset or fractional seconds:
	 * [[[[[YYYY]MM]DD]HH]mm]ss]</td>
	 * </tr>
	 * <tr>
	 * <td>sourcePatientId</td>
	 * <td>ClinicalDocument/recordTarget/patientRole/id</td>
	 * </tr>
	 * <tr>
	 * <td>sourcePatientInfo</td>
	 * <td>ClinicalDocument/recordTarget/patientRole</td>
	 * </tr>
	 * <tr>
	 * <td>title</td>
	 * <td>ClinicalDocument/title</td>
	 * </tr>
	 * <tr>
	 * <td>uniqueId</td>
	 * <td>ClinicalDocument/id@extension and ClinicalDocument/id@root</td>
	 * </tr>
	 * </tbody>
	 * </table>
	 * 
	 * <br>
	 * The following attributes will be generated as described, if they are not
	 * present in the document entries:
	 * 
	 * <table summary="Empty document entries attributes generation" width="100%">
	 * <thead>
	 * <tr>
	 * <th width="20%">XDS Metadata Attribute</th>
	 * <th width="80%">Generated from</th>
	 * </tr>
	 * </thead> <tbody>
	 * <tr>
	 * <td>mimeType</td>
	 * <td>the DocumentDescriptor, which has been provided by adding the
	 * document</td>
	 * </tr>
	 * <tr>
	 * <td>creationTime</td>
	 * <td>current time</td>
	 * </tr>
	 * <tr>
	 * <td>uniqueId</td>
	 * <td>the docSourceActorOrgId attribute from the DocumentMetadata</td>
	 * </tr>
	 * </tbody>
	 * </table>
	 * <br>
	 * </div>
	 */
	DEFAULT_EXTRACTION,

	/**
	 * <div class="en">No metadata will be extracted, automatically</div>
	 */
	NO_METADATA_EXTRACTION
}