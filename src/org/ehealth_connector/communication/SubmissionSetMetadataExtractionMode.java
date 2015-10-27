package org.ehealth_connector.communication;

/**
 * The Class MetadataExtractionMode
 *
 */
public enum SubmissionSetMetadataExtractionMode {
	/**
	 * <div class="en">Minimal (secure) metadata will be extracted * Extraction
	 * from the first Document Entry to the Submission Set uses the following
	 * mapping:
	 * 
	 * <table summary="Submission set attributes generation" width="100%">
	 * <thead>
	 * <tr>
	 * <th width="20%">Submission set attribute</th>
	 * <th width="80%">Generated from</th>
	 * </tr>
	 * </thead><tbody>
	 * <tr>
	 * <td>uniqueId</td>
	 * <td>the eHealthConnector OID as base and a random part</td>
	 * </tr>
	 * <tr>
	 * <td>sourceId</td>
	 * <td>DocumentEntry/Patient/AssigningAuthorityUniversalId or (if empty)
	 * from the eHealthConnector OID as base and a random part</td>
	 * </tr>
	 * <tr>
	 * <td>submissionTime</td>
	 * <td>current time</td>
	 * </tr>
	 * <tr>
	 * <td>patientId</td>
	 * <td>DocumentEntry/PatientId</td>
	 * </tr>
	 * <tr>
	 * <td>contentTypeCode</td>
	 * <td>DocumentEntry/TypeCode</td>
	 * </tr>
	 * </tbody>
	 * </table>
	 * </div>
	 */
	DEFAULT_EXTRACTION,

	/**
	 * <div class="en">No metadata will be extracted, automatically</div>
	 */
	NO_METADATA_EXTRACTION
}