/**
 * Copyright (c) 2021- by RALY GmbH. All rights reserved.
 */
package org.projecthusky.fhir.vacd.ch.common.narrative;

import java.util.EnumSet;

import org.hl7.fhir.instance.model.api.IBase;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.Composition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.narrative.CustomThymeleafNarrativeGenerator;
import ca.uhn.fhir.narrative2.INarrativeTemplate;
import ca.uhn.fhir.narrative2.TemplateTypeEnum;

/**
 * 
 */
public class ChVacdThymeleafNarrativeGenerator extends CustomThymeleafNarrativeGenerator {

	protected Logger logger;

	public ChVacdThymeleafNarrativeGenerator() {
		logger = LoggerFactory.getLogger(getClass());
		setPropertyFile("classpath:org/projecthusky/fhir/vacd/ch/common/narrative/chvacd-narrative.properties",
				"classpath:ca/uhn/fhir/narrative/narratives.properties",
				"classpath:ca/uhn/fhir/narrative/narratives-hapiserver.properties");
	}

	@Override
	public boolean populateResourceNarrative(FhirContext theFhirContext, IBaseResource theResource) {
		boolean retVal = super.populateResourceNarrative(theFhirContext, theResource);
//		if (logger.isTraceEnabled()) {
			logger.info("Resource: " + theResource + " : " + retVal);
//		}
		return retVal;
	}

	@Override
	protected String applyTemplate(FhirContext theFhirContext, INarrativeTemplate theTemplate, IBase theTargetContext) {
		try {
			return super.applyTemplate(theFhirContext, theTemplate, theTargetContext);
		} catch (Exception e) {
			logger.error("Error applying template", e);
		}
		
//		if (logger.isTraceEnabled()) {
//			logger.info("INarrativeTemplate: " + theTemplate.getTemplateName() + ", IBase: " + theTargetContext
//					+ ", retVal: " + retVal);
//			logger.info("INarrativeTemplate: " + theTemplate.getTemplateName() + ", IBase: " + theTargetContext);
//			if(theTargetContext instanceof Composition) {
//				logger.info("retVal: "+retVal);
//			}
//		}
		return theTargetContext.fhirType();
	}

	@Override
	protected EnumSet<TemplateTypeEnum> getStyle() {
		EnumSet<TemplateTypeEnum> styles = super.getStyle();
		return styles;
	}

}
