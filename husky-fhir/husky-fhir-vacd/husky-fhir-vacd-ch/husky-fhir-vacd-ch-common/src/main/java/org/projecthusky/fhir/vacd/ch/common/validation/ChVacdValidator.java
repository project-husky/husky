package org.projecthusky.fhir.vacd.ch.common.validation;

import java.io.IOException;
import java.util.List;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.validation.impl.HuskyFhirValidatorImpl;

import ca.uhn.fhir.context.FhirContext;

public class ChVacdValidator extends HuskyFhirValidatorImpl {

	private static List<String> packageResourceList = List.of(//
			"/packages/hl7.terminology.r4#7.1.0.tgz", //
			"/packages/hl7.fhir.uv.extensions.r4#5.2.0.tgz", //
			"/packages/ch.fhir.ig.ch-term#3.4.0.tgz", //
			"/packages/ch.fhir.ig.ch-core#7.0.0-ballot.tgz", //
			"/packages/ch.fhir.ig.ch-vacd#7.0.0-ballot.tgz");

	public ChVacdValidator(FhirContext context, @Nullable List<String> resourcePackages,
			@Nullable String txServer) throws IOException {
		super(context, (resourcePackages != null && !resourcePackages.isEmpty()) ? resourcePackages
				: packageResourceList, txServer);
	}

}
