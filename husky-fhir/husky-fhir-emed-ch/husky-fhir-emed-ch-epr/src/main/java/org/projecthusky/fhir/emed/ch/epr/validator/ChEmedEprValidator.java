package org.projecthusky.fhir.emed.ch.epr.validator;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocument;
import org.projecthusky.fhir.validation.HuskyFhirValidator;
import org.projecthusky.fhir.validation.model.ValidationResult;

/**
 * A CH-EMED-EPR validator. It doesn't use the Schema or Schematron validators
 * but only the Instance one, which is built upon the CH-EMED-EPR IG.
 * <p>
 * This interface should be independent of the actual validation engine being
 * used. Engine-specific implementations of this interface should cover their
 * specifics.
 * </p>
 *
 * @author Quentin Ligier
 **/
public interface ChEmedEprValidator extends HuskyFhirValidator {
	List<String> packageResourceList = List.of("/package/ihe.formatcode.fhir#1.4.0.tgz",
			"/package/ch.fhir.ig.ch-term#3.3.0.tgz", "/package/ch.fhir.ig.ch-core#6.0.0.tgz",
			"/package/ch.fhir.ig.ch-emed#6.0.0.tgz", "/package/ch.fhir.ig.ch-emed-epr#3.0.0.tgz",
			"/package/ch.fhir.ig.ch-epr-fhir#5.0.0.tgz", "/package/ihe.iti.mhd#4.2.3.tgz");

	/**
	 * Validates a CH-EMED-EPR document Bundle AND performs a logic validation
	 * of the content as well.
	 *
	 * @param documentStream
	 *            The document Bundle to validate as a stream.
	 * @param document
	 *            The parsed CH EMED EPR document, for the logic validator.
	 * @return the validation result.
	 * @implNote We need the parsed document for the logical validator and the
	 *           serialized document for the instance validator, because HAPI's
	 *           parser messes with resource IDs.
	 */
	ValidationResult validateDocumentBundle(final InputStream documentStream,
			final ChEmedEprDocument document) throws IOException;
	
	/**
	 * Returns the profile URL from the eMed type.
	 *
	 * @deprecated Deprecated and marked for removal since Husky 3.2.2. Use
	 *             {@link EmedDocumentType#getProfileEpr()} instead.
	 *
	 * @param type
	 *            The eMed type.
	 * @return the profile URL.
	 */
	@Deprecated(since = "3.2.2", forRemoval = true)
	static String getProfileUrl(final EmedDocumentType type) {
		return type.getProfileEpr();
	}
}
