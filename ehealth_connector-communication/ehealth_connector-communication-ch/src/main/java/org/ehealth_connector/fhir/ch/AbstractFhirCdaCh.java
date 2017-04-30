/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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

package org.ehealth_connector.fhir.ch;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.AbstractVitalSignObservation;
import org.ehealth_connector.cda.AssociatedEntity;
import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.ch.AllergyConcern;
import org.ehealth_connector.cda.ch.ParticipantClaimer;
import org.ehealth_connector.cda.ch.PastProblemConcern;
import org.ehealth_connector.cda.ch.PregnancyHistory;
import org.ehealth_connector.cda.ch.edes.enums.ObservationInterpretationForVitalSign;
import org.ehealth_connector.cda.ch.lab.BloodGroupObservation;
import org.ehealth_connector.cda.ch.lab.SpecimenCollectionEntry;
import org.ehealth_connector.cda.ch.lab.lrtp.enums.VitalSignList;
import org.ehealth_connector.cda.ch.vacd.GestationalAge;
import org.ehealth_connector.cda.enums.AllergiesAndIntolerances;
import org.ehealth_connector.cda.enums.ProblemConcernStatusCode;
import org.ehealth_connector.cda.enums.ProblemType;
import org.ehealth_connector.cda.enums.epsos.BloodGroup;
import org.ehealth_connector.cda.ihe.lab.LaboratoryBatteryOrganizer;
import org.ehealth_connector.cda.ihe.lab.LaboratoryIsolateOrganizer;
import org.ehealth_connector.cda.ihe.lab.LaboratoryObservation;
import org.ehealth_connector.cda.ihe.lab.LaboratoryReportDataProcessingEntry;
import org.ehealth_connector.cda.ihe.lab.LaboratorySpecialtySection;
import org.ehealth_connector.cda.ihe.lab.NonHumanSubject;
import org.ehealth_connector.cda.ihe.lab.ReferralOrderingPhysician;
import org.ehealth_connector.cda.ihe.lab.SpecimenAct;
import org.ehealth_connector.cda.ihe.lab.SpecimenReceivedEntry;
import org.ehealth_connector.cda.ihe.lab.VitalSignsOrganizer;
import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.IntendedRecipient;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Telecoms;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.Confidentiality;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.enums.ObservationInterpretation;
import org.ehealth_connector.common.enums.StatusCode;
import org.ehealth_connector.common.enums.Ucum;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Util;
import org.ehealth_connector.fhir.FhirCommon;
import org.hl7.fhir.dstu3.model.Basic;
import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.Condition;
import org.hl7.fhir.dstu3.model.Condition.ConditionClinicalStatus;
import org.hl7.fhir.dstu3.model.DateTimeType;
import org.hl7.fhir.dstu3.model.DateType;
import org.hl7.fhir.dstu3.model.DocumentManifest;
import org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestContentComponent;
import org.hl7.fhir.dstu3.model.Extension;
import org.hl7.fhir.dstu3.model.Identifier;
import org.hl7.fhir.dstu3.model.ListResource;
import org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent;
import org.hl7.fhir.dstu3.model.MedicationStatement;
import org.hl7.fhir.dstu3.model.Narrative;
import org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus;
import org.hl7.fhir.dstu3.model.Observation;
import org.hl7.fhir.dstu3.model.Observation.ObservationComponentComponent;
import org.hl7.fhir.dstu3.model.Observation.ObservationRelatedComponent;
import org.hl7.fhir.dstu3.model.Observation.ObservationStatus;
import org.hl7.fhir.dstu3.model.Organization;
import org.hl7.fhir.dstu3.model.Person;
import org.hl7.fhir.dstu3.model.Practitioner;
import org.hl7.fhir.dstu3.model.Quantity;
import org.hl7.fhir.dstu3.model.Ratio;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.dstu3.model.StringType;
import org.hl7.fhir.dstu3.model.TimeType;
import org.hl7.fhir.dstu3.model.Type;
import org.hl7.fhir.exceptions.FHIRException;
import org.openhealthtools.mdht.uml.hl7.datatypes.BL;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.INT;
import org.openhealthtools.mdht.uml.hl7.datatypes.PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.ST;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.FhirVersionEnum;

public abstract class AbstractFhirCdaCh {

	/**
	 * <div class="en">uniform resource name (urn) of this OID</div>
	 * <div class="de"></div><div class="fr"></div>
	 */
	public static final String OID_CONFIDENTIALITY_CODE = FhirCommon
			.addUrnOid(CodeSystems.ConfidentialityCode.getCodeSystemId());

	protected final FhirContext fhirCtx = new FhirContext(FhirVersionEnum.DSTU3);

	/**
	 * Creates a Comment Observation
	 *
	 * @param comment
	 *            the comment to be used
	 * @return the Comment Observation
	 */
	public Observation createComment(String comment) {

		final Observation fhirObservation = new Observation();
		fhirObservation.setStatus(ObservationStatus.UNKNOWN);

		final CodeableConcept fhirCode = new CodeableConcept();
		fhirCode.addCoding().setSystem(FhirCommon.addUrnOid("2.16.840.1.113883.6.1"))
				.setCode("48767-8");
		fhirObservation.setCode(fhirCode);
		fhirObservation.setComment(comment);

		return fhirObservation;
	}

	/**
	 * Creates a narrative text
	 *
	 * @param text
	 *            the text to be used
	 * @return the narrative text
	 */
	public Narrative createText(String text) {
		Narrative retVal = new Narrative();
		retVal.setStatus(NarrativeStatus.ADDITIONAL);
		retVal.setDivAsString(text);
		return retVal;
	}

	/**
	 * Gets a Active Problem Concern
	 *
	 * @param fhirCondition
	 *            the FHIR resource
	 * @param id
	 *            the id to be assigned
	 * @return the Active Problem Concern
	 */
	private org.ehealth_connector.cda.ch.ActiveProblemConcern getActiveProblemConcern(
			Condition fhirCondition, String id) {

		final String concern = fhirCondition.getNoteFirstRep().getText();
		final Date date = fhirCondition.getAssertedDate();

		final org.ehealth_connector.cda.Problem problemEntry = getProblemEntry(fhirCondition);
		final org.ehealth_connector.cda.enums.ProblemConcernStatusCode problemStatusCode = getProblemConcernStatusCode(
				fhirCondition);

		// Create the ActiveProblemConcern
		final org.ehealth_connector.cda.ch.ActiveProblemConcern retVal = new org.ehealth_connector.cda.ch.ActiveProblemConcern(
				concern, date, problemEntry, problemStatusCode);
		retVal.getMdht().getIds().clear();
		retVal.addId(new Identificator(id, null));
		return retVal;

	}

	/**
	 * <div class="en">Gets a list of eHC ActiveProblemConcerns from the given
	 * FHIR resource
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return list of eHC ActiveProblemConcerns </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public List<org.ehealth_connector.cda.ch.ActiveProblemConcern> getActiveProblemConcernEntries(
			DocumentManifest docManifest) {
		final List<org.ehealth_connector.cda.ch.ActiveProblemConcern> retVal = new ArrayList<org.ehealth_connector.cda.ch.ActiveProblemConcern>();
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			final List<Extension> extensions = entry
					.getExtensionsByUrl(FhirCommon.urnUseAsActiveProblemConcern);
			if (!extensions.isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					final String id = ((StringType) extensions.get(0).getValue()).toString();
					retVal.add(getActiveProblemConcern((Condition) ref.getResource(), id));
				}
			}
		}
		return retVal;
	}

	/**
	 * Gets a Allergy Problem Concern
	 *
	 * @param fhirCondition
	 *            the FHIR resource
	 * @return the Allergy Problem Concern
	 */
	private org.ehealth_connector.cda.ch.AllergyConcern getAllergyProblemConcern(
			Condition fhirCondition) {

		final String concern = fhirCondition.getNoteFirstRep().getText();
		final org.ehealth_connector.cda.ch.AllergyProblem problemEntry = getAllergyProblemEntry(
				fhirCondition);

		final org.ehealth_connector.cda.enums.ProblemConcernStatusCode problemStatusCode = getProblemConcernStatusCode(
				fhirCondition);

		final org.ehealth_connector.cda.ch.AllergyConcern retVal = new org.ehealth_connector.cda.ch.AllergyConcern(
				concern, fhirCondition.getAssertedDate(), null, problemEntry, problemStatusCode);

		return retVal;

	}

	/**
	 * <div class="en">Gets a list of eHC AllergyConcerns from the given FHIR
	 * resource
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return list of eHC AllergyConcerns </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public List<org.ehealth_connector.cda.ch.AllergyConcern> getAllergyProblemConcernEntries(
			DocumentManifest docManifest) {
		final List<org.ehealth_connector.cda.ch.AllergyConcern> retVal = new ArrayList<org.ehealth_connector.cda.ch.AllergyConcern>();
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			final List<org.hl7.fhir.dstu3.model.Extension> extensions = entry
					.getExtensionsByUrl(FhirCommon.urnUseAsAllergyProblemConcern);
			if (!extensions.isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					if (ref.getResource() instanceof Condition) {
						final Condition fhirCondition = (Condition) ref.getResource();
						final AllergyConcern concern = getAllergyProblemConcern(fhirCondition);
						for (final org.hl7.fhir.dstu3.model.Extension ext : extensions) {
							if (ext.getValue() instanceof DateTimeType) {
								concern.setStart(((DateTimeType) ext.getValue()).getValue());
							}
							if (ext.getValue() instanceof StringType) {
								concern.getMdht().getIds().clear();
								concern.addId(new Identificator(
										((StringType) ext.getValue()).toString(), null));
							}
						}
						retVal.add(concern);
					}
				}
			}
		}
		return retVal;
	}

	/**
	 * Gets a Allergy Problem Entry
	 *
	 * @param fhirCondition
	 *            the FHIR resource
	 *
	 * @return the Allergy Problem Entry
	 */
	private org.ehealth_connector.cda.ch.AllergyProblem getAllergyProblemEntry(
			Condition fhirCondition) {

		final org.ehealth_connector.cda.ch.AllergyProblem retVal = new org.ehealth_connector.cda.ch.AllergyProblem();
		final Coding fhirCode = fhirCondition.getCode().getCodingFirstRep();

		// Add Problem Entry Identifiers
		for (final Identifier id : fhirCondition.getIdentifier()) {
			final String codeSystem = FhirCommon.removeUrnOidPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));
		}

		// currently only Drug intolerances supported
		retVal.setCode(AllergiesAndIntolerances.DRUG_INTOLERANCE);

		// Date
		retVal.setStartDate(fhirCondition.getAssertedDate());

		// Value
		retVal.addValue(new Code(FhirCommon.removeUrnOidPrefix(fhirCode.getSystem()),
				fhirCode.getCode(), fhirCode.getDisplay()));

		return retVal;
	}

	/**
	 * <div class="en">Gets a list of eHC Authors from the given FHIR resource
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return list of eHC Authors </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public List<org.ehealth_connector.common.Author> getAuthors(DocumentManifest docManifest) {
		final List<org.ehealth_connector.common.Author> retVal = new ArrayList<org.ehealth_connector.common.Author>();
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			final List<Extension> extensions = entry.getExtensionsByUrl(FhirCommon.urnUseAsAuthor);
			if (!extensions.isEmpty()) {
				org.ehealth_connector.common.Author author = null;
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					if (ref.getResource() instanceof Person) {
						author = FhirCommon.getAuthor(ref.getResource());
					}
					if (ref.getResource() instanceof Organization) {
						author = FhirCommon.getAuthor(ref.getResource());
					}
				}

				final TimeType timeStamp = ((TimeType) extensions.get(0).getValueAsPrimitive());
				author.setTime(DateUtil.parseDates(timeStamp.getValue()));
				retVal.add(author);
			}
		}

		return retVal;
	}

	/**
	 * Gets the Blood Group Observation
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return the Blood Group Observation
	 */
	protected BloodGroupObservation getBloodGroupObservation(DocumentManifest docManifest) {
		BloodGroupObservation retVal = null;
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			if (!entry.getExtensionsByUrl(FhirCommon.urnUseAsBloodGroup).isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					Observation fObs = (Observation) ref.getResource();
					retVal = new BloodGroupObservation();
					// Value
					BloodGroup bg = BloodGroup
							.getEnum(fObs.getCode().getCodingFirstRep().getCode());
					retVal.setValue(bg);

					// Text reference (inside the observation)
					if (fObs.getComment() != null && !fObs.getComment().isEmpty()) {
						retVal.setTextReference(fObs.getComment());
					}

					// Comments
					for (ObservationRelatedComponent commentRef : fObs.getRelated()) {
						if (commentRef.getTarget().getResource() instanceof Observation) {
							Observation comment = (Observation) commentRef.getTarget()
									.getResource();
							if (comment.getComment() != null) {
								retVal.addCommentEntry(
										new SectionAnnotationCommentEntry(comment.getComment()));
							}
						}
					}

					// Author
					for (Reference fPerfRef : fObs.getPerformer()) {
						Practitioner fPerf = (Practitioner) fPerfRef.getResource();
						// Id
						Author author = new Author();
						author.addId(FhirCommon
								.fhirIdentifierToEhcIdentificator(fPerf.getIdentifierFirstRep()));
					}
				}
			}
		}
		return retVal;
	}

	/**
	 * Gets a list of Claimers
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return the list of Claimers
	 *
	 */
	protected List<ParticipantClaimer> getClaimers(DocumentManifest docManifest) {
		List<ParticipantClaimer> pList = new ArrayList<ParticipantClaimer>();
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			if (!entry.getExtensionsByUrl(FhirCommon.urnUseAsClaimer).isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					final Person fPar = (Person) ref.getResource();
					String gln = null;
					String zsr = null;
					for (Identifier id : fPar.getIdentifier()) {
						String oid;
						oid = id.getSystem().replace(FhirCommon.oidUrn, "");
						if (oid.equals(CodeSystems.GLN.getCodeSystemId()))
							gln = id.getValue();

						oid = id.getSystem().replace(FhirCommon.oidUrn, "");
						if (oid.equals(CodeSystems.SwissZSR.getCodeSystemId()))
							zsr = id.getValue();
					}
					ParticipantClaimer p = new ParticipantClaimer(gln, zsr, true);
					pList.add(p);
				}
			}
		}
		return pList;
	}

	/**
	 * Gets a Coded Vital Sign Organizer
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return Coded Vital Sign Organizer
	 */
	protected VitalSignsOrganizer getCodedVitalSignOrganizer(DocumentManifest docManifest) {

		final VitalSignsOrganizer retVal = new VitalSignsOrganizer();
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			Reference ref = null;
			try {
				ref = entry.getPReference();
			} catch (FHIRException e) {
			}
			if (ref != null) {
				if (ref.getResource() instanceof ListResource) {
					final ListResource list = (ListResource) ref.getResource();
					final List<org.hl7.fhir.dstu3.model.Extension> extensions = list
							.getExtensionsByUrl(FhirCommon.urnUseAsCodedVitalSignList);
					if (!extensions.isEmpty()) {
						final Identifier id = list.getIdentifier().get(0);
						id.setSystem(FhirCommon.removeUrnOidPrefix(id.getSystem()));
						final TimeType timeStamp = ((TimeType) extensions.get(0).getValue());
						retVal.setEffectiveTime(
								DateUtil.parseDateyyyyMMddHHmmssZZZZ(timeStamp.getValue()));
						retVal.addId(new Identificator(id.getSystem(), id.getValue()));
						for (final ListEntryComponent listEntry : list.getEntry()) {
							final List<org.hl7.fhir.dstu3.model.Extension> extensions2 = listEntry
									.getExtensionsByUrl(FhirCommon.urnUseAsAuthor);
							if (!extensions2.isEmpty()
									&& (listEntry.getItem().getResource() instanceof Person)) {
								final org.ehealth_connector.common.Author author = FhirCommon
										.getAuthor((Person) listEntry.getItem().getResource());
								final TimeType timeStamp2 = ((TimeType) extensions2.get(0)
										.getValue());
								author.setTime(DateUtil
										.parseDateyyyyMMddHHmmssZZZZ(timeStamp2.getValue()));
								retVal.addAuthor(author);
							}
						}
					}
				}
			}
		}

		return retVal;
	}

	/**
	 * <div class="en">Gets a list of eHC EDES VitalSignObservation from the
	 * given FHIR resource
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return list of eHC EDES VitalSignObservation </div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	public List<AbstractVitalSignObservation> getCodedVitalSigns(DocumentManifest docManifest) {

		final List<AbstractVitalSignObservation> retVal = new ArrayList<AbstractVitalSignObservation>();
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			Reference ref = null;
			try {
				ref = entry.getPReference();
			} catch (FHIRException e) {
			}
			if (ref != null) {
				if (ref.getResource() instanceof ListResource) {
					final ListResource list = (ListResource) ref.getResource();
					if (!list.getExtensionsByUrl(FhirCommon.urnUseAsCodedVitalSignList).isEmpty()) {
						for (final ListEntryComponent listEntry : list.getEntry()) {
							if (!listEntry.getExtensionsByUrl(
									FhirCommon.urnUseAsCodedVitalSignObservation).isEmpty()
									&& (listEntry.getItem().getResource() instanceof Observation)) {
								final Observation fhirObservation = (Observation) listEntry
										.getItem().getResource();

								final Type fhirEffectiveTime = fhirObservation.getEffective();
								Date effectiveTime = new Date();
								if (fhirEffectiveTime instanceof DateTimeType) {
									effectiveTime = ((DateTimeType) fhirEffectiveTime).getValue();
								}
								final List<ObservationComponentComponent> components = fhirObservation
										.getComponent();
								for (final ObservationComponentComponent component : components) {
									Value value = null;

									final Coding fhirCode = component.getCode().getCodingFirstRep();
									final Type fhirValue = component.getValue();

									final Code code = new Code(
											FhirCommon.removeUrnOidPrefix(fhirCode.getSystem()),
											fhirCode.getCode(), fhirCode.getDisplay());
									if (fhirValue instanceof Quantity) {
										// type PQ
										final Quantity fhirQuantity = (Quantity) fhirValue;
										final PQ pq = DatatypesFactory.eINSTANCE.createPQ();
										pq.setUnit(fhirQuantity.getUnit());
										pq.setValue(fhirQuantity.getValue());
										value = new Value(pq);
									}
									retVal.add(new AbstractVitalSignObservation(code, effectiveTime,
											value));
								}
							}
						}
					}
				}
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the comment from the given FHIR resource
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return eHC Author object </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public String getComment(DocumentManifest docManifest) {
		String retVal = "";
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			if (!entry.getExtensionsByUrl(FhirCommon.urnUseAsComment).isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					if (ref.getResource() instanceof Observation) {
						retVal = ((Observation) ref.getResource()).getComment();
					}
				}
			}
		}
		return retVal;
	}

	/**
	 * Gets a Comment
	 *
	 * @param fhirMedicationStatement
	 *            the FHIR resource
	 * @return the Comment
	 */
	protected String getComment(MedicationStatement fhirMedicationStatement) {
		String retVal = "";
		if (!fhirMedicationStatement.getExtensionsByUrl(FhirCommon.urnUseAsComment).isEmpty()) {
			final StringType comment = (StringType) fhirMedicationStatement
					.getExtensionsByUrl(FhirCommon.urnUseAsComment).get(0).getValue();
			retVal = comment.toString();
		}
		return retVal;
	}

	/**
	 * <div class="en"> Gets the eHC confidentiality code from the given FHIR
	 * resource
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return eHC confidentiality code </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public Confidentiality getConfidentialityCode(DocumentManifest docManifest) {
		Confidentiality retVal = Confidentiality.NORMAL; // default

		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			Reference ref = null;
			try {
				if (entry.hasPReference())
					ref = entry.getPReference();
			} catch (FHIRException e) {
			}
			if (ref != null) {
				if (ref.getResource() instanceof org.hl7.fhir.dstu3.model.Basic) {
					Basic fhirBasic = (org.hl7.fhir.dstu3.model.Basic) ref.getResource();
					final Coding langCode = fhirBasic.getCode().getCodingFirstRep();
					if ((langCode != null) && (langCode.getSystem() != null)
							&& langCode.getSystem().equals(OID_CONFIDENTIALITY_CODE)) {
						if ("veryrestricted".equals(langCode.getCode().toLowerCase())) {
							retVal = Confidentiality.VERY_RESTRICTED;
							break;
						} else if ("restricted".equals(langCode.getCode().toLowerCase())
								|| "r".equals(langCode.getCode().toLowerCase())) {
							retVal = Confidentiality.RESTRICTED;
							break;
						} else if ("normal".equals(langCode.getCode().toLowerCase())) {
							retVal = Confidentiality.NORMAL;
							break;
						}
					}
				}
			}
		}
		return retVal;
	};

	/**
	 * <div class="en">Gets the eHC Custodian from the given FHIR resource
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return eHC Custodian</div> <div class="de"></div> <div class="fr"></div>
	 */
	public org.ehealth_connector.common.Organization getCustodian(DocumentManifest docManifest) {
		org.ehealth_connector.common.Organization retVal = null;

		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			if (!entry.getExtensionsByUrl(FhirCommon.urnUseAsCustodian).isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					if (ref.getResource() instanceof Organization) {
						retVal = FhirCommon.getOrganization(ref.getResource());
					}
				}
			}
		}

		return retVal;
	}

	/**
	 * <div class="en"> Gets the eHC document language code from the given FHIR
	 * resource
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return eHC document language </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public LanguageCode getDocLanguage(DocumentManifest docManifest) {
		LanguageCode retVal = LanguageCode.ENGLISH; // default
		String lang = docManifest.getLanguage();
		if (lang != null) {
			if (lang.toLowerCase().startsWith("de")) {
				retVal = LanguageCode.GERMAN;
			} else if (lang.toLowerCase().startsWith("fr")) {
				retVal = LanguageCode.FRENCH;
			} else if (lang.toLowerCase().startsWith("it")) {
				retVal = LanguageCode.ITALIAN;
			} else if (lang.toLowerCase().startsWith("en")) {
				retVal = LanguageCode.ENGLISH;
			}
		}
		return retVal;
	}

	/**
	 * Gets a DocumentationOf element
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return the DocumentationOf element
	 */
	protected String getDocumentationOf(DocumentManifest docManifest) {
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			if (!entry.getExtensionsByUrl(FhirCommon.urnUseAsDocumentationOf).isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					Basic ifo = (Basic) ref.getResource();
					return ifo.getCode().getCodingFirstRep().getCode();
				}
			}
		}
		return null;
	}

	/**
	 * <div class="en"> Gets the document date from the given FHIR resource
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return the document Id
	 */
	public Date getDocumentDate(org.hl7.fhir.dstu3.model.DocumentManifest docManifest) {
		Date retVal = null;
		retVal = docManifest.getCreated();
		return retVal;
	};

	/**
	 * <div class="en"> Gets the document Id from the given FHIR resource
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return the document Id
	 */
	public Identificator getDocumentId(org.hl7.fhir.dstu3.model.DocumentManifest docManifest) {
		Identificator retVal = null;
		final Identifier docId = docManifest.getIdentifier().get(0);
		String oid = docId.getSystem();
		oid = oid.replace(FhirCommon.oidUrn, "");
		retVal = new Identificator(oid, docId.getValue());
		return retVal;
	};

	/**
	 * <div class="en"> Gets the document Set Id from the given FHIR resource
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return the document Set Id
	 */
	public Identificator getDocumentSetId(DocumentManifest docManifest) {
		final Identifier docId = docManifest.getIdentifier().get(1);
		return new Identificator(docId.getSystem(), docId.getValue());
	}

	/**
	 * Gets the document version
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return the document version
	 */
	protected Integer getDocVersion(DocumentManifest docManifest) {
		return Integer.parseInt(docManifest.getMeta().getVersionId());
	}

	/**
	 * Gets a Problem Concern
	 *
	 * @param fhirCondition
	 *            the FHIR resource
	 * @param id
	 *            the id to be used
	 * @param timeStamp
	 *            the timestamp to be used
	 * @return the Problem Concern
	 */
	private org.ehealth_connector.cda.ch.ProblemConcern getEdDiagnoses(Condition fhirCondition,
			Identificator id, Date timeStamp) {

		final String concern = fhirCondition.getNoteFirstRep().getText();
		// final Date date = fhirCondition.getAssertedDate();

		final org.ehealth_connector.cda.Problem problemEntry = getProblemEntry(fhirCondition);
		final org.ehealth_connector.cda.enums.ProblemConcernStatusCode problemStatusCode = getProblemConcernStatusCode(
				fhirCondition);

		// Create the ActiveProblemConcern
		final org.ehealth_connector.cda.ch.ProblemConcern retVal = new org.ehealth_connector.cda.ch.ProblemConcern(
				concern, problemEntry, problemStatusCode);
		retVal.getMdht().getIds().clear();
		retVal.addId(id);
		if (timeStamp != null)
			retVal.setStart(timeStamp);

		return retVal;

	}

	/**
	 * <div class="en">Gets a list of eHC ActiveProblemConcerns from the given
	 * FHIR resource
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return list of eHC ActiveProblemConcerns </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public List<org.ehealth_connector.cda.ch.ProblemConcern> getEdDiagnoses(
			DocumentManifest docManifest) {
		final List<org.ehealth_connector.cda.ch.ProblemConcern> retVal = new ArrayList<org.ehealth_connector.cda.ch.ProblemConcern>();
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			final List<org.hl7.fhir.dstu3.model.Extension> extensions = entry
					.getExtensionsByUrl(FhirCommon.urnUseAsEdDiagnosis);
			if (!extensions.isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					if (ref.getResource() instanceof Condition) {
						Identificator id = null;
						Date timestamp = null;
						for (final org.hl7.fhir.dstu3.model.Extension ext : extensions) {
							if (ext.getValue() instanceof DateType) {
								timestamp = ((DateType) ext.getValue()).getValue();
							}
							if (ext.getValue() instanceof StringType) {
								id = new Identificator(((StringType) ext.getValue()).toString(),
										null);
							}
						}
						retVal.add(getEdDiagnoses((Condition) ref.getResource(), id, timestamp));
					}
				}
			}
		}
		return retVal;
	}

	/**
	 * <div class="en"> Gets the eHC CodedResults object from the given FHIR
	 * resource
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return eHC CodedResults object </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public org.ehealth_connector.cda.ch.CodedResults getGestationalAge(
			DocumentManifest docManifest) {
		GestationalAge retVal = null;
		BigInteger gWeek = BigInteger.valueOf(-1);
		BigInteger gDay = BigInteger.valueOf(-1);
		Identificator idWeek = null;
		Identificator idDay = null;
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			if (!entry.getExtensionsByUrl(FhirCommon.urnUseAsPregnancyObservation).isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					if (ref.getResource() instanceof Observation) {
						final Observation fhirObs = (Observation) ref.getResource();
						final Coding fhirCode = fhirObs.getCode().getCodingFirstRep();
						if ("49051-6".equals(fhirCode.getCode())) {
							gWeek = ((Quantity) fhirObs.getValue()).getValue().toBigInteger();
							if (!fhirObs.getIdentifier().isEmpty()) {
								Identifier idTemp = fhirObs.getIdentifier().get(0);
								final String codeSystem = FhirCommon
										.removeUrnOidPrefix(idTemp.getSystem());
								idWeek = new Identificator(codeSystem, idTemp.getValue());
							}
						}
						if ("49052-4".equals(fhirCode.getCode())) {
							gDay = ((Quantity) fhirObs.getValue()).getValue().toBigInteger();
							if (!fhirObs.getIdentifier().isEmpty()) {
								Identifier idTemp = fhirObs.getIdentifier().get(0);
								final String codeSystem = FhirCommon
										.removeUrnOidPrefix(idTemp.getSystem());
								idDay = new Identificator(codeSystem, idTemp.getValue());
							}
						}
					}
				}
			}
		}
		if ((gDay.intValue() > -1) && (gWeek.intValue() > -1)) {
			retVal = new GestationalAge(gWeek.intValue(), gDay.intValue());
			if (idWeek != null)
				retVal.setGestationalAgeWeeksId(idWeek);
			if (idDay != null)
				retVal.setGestationalAgeDaysId(idDay);
		}
		return retVal;
	}

	/**
	 * Gets a InFulfillmentOf element
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return InFulfillmentOf element
	 */
	protected Identificator getInFulfillmentOf(DocumentManifest docManifest) {
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			if (!entry.getExtensionsByUrl(FhirCommon.urnUseAsInFulfillmentOf).isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					final Basic ifo = (Basic) ref.getResource();
					return FhirCommon.fhirIdentifierToEhcIdentificator(ifo.getIdentifierFirstRep());
				}
			}
		}
		return null;
	}

	/**
	 * <div class="en">Gets the eHC ReferralOrderingPhyscian from the given FHIR
	 * resource
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return eHC Custodian</div> <div class="de"></div> <div class="fr"></div>
	 */
	public IntendedRecipient getIntendedRecipient(DocumentManifest docManifest) {
		IntendedRecipient retVal = null;
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			if (!entry.getExtensionsByUrl(FhirCommon.urnUseAsInformationRecipient).isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					final Organization physician = (Organization) ref.getResource();
					final org.ehealth_connector.common.Organization o = FhirCommon
							.getOrganization(physician);
					retVal = new IntendedRecipient(o);
				}
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets a list of eHC LaboratoryBatteryOrganizers from the
	 * given FHIR resource
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return list of eHC LaboratoryBatteryOrganizers</div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	protected List<LaboratoryBatteryOrganizer> getLaboratoryBatteryOrganizers(
			DocumentManifest docManifest) {
		final List<LaboratoryBatteryOrganizer> retVal = new ArrayList<LaboratoryBatteryOrganizer>();

		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			if (!entry.getExtensionsByUrl(FhirCommon.urnUseAsLaboratoryBatteryOrganizer)
					.isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					final LaboratoryBatteryOrganizer lbo = new LaboratoryBatteryOrganizer();
					final Observation obs = (Observation) ref.getResource();

					// Set the Organizer Attributes
					// Status Code
					final String statusCode = getValueFromKeyValueString(obs, "statusCode");
					if (statusCode != null) {
						lbo.setStatusCode(StatusCode.getEnum(statusCode));
					}

					// Organizer Id
					if (!obs.getIdentifier().isEmpty()) {
						Identificator id = new Identificator(obs.getIdentifierFirstRep());
						id.setRoot(id.getRoot().replace(FhirCommon.oidUrn, ""));
						lbo.getMdht().getIds().add(id.getIi());
					}

					// EffectiveTime
					final DateTimeType fTime = (DateTimeType) obs.getEffective();
					if (fTime != null)
						lbo.setEffectiveTime(fTime.getValue());

					// Authors
					for (Reference perfRef : obs.getPerformer()) {
						Practitioner p = (Practitioner) perfRef.getResource();
						Author author = new Author();
						author.addId(FhirCommon
								.fhirIdentifierToEhcIdentificator(p.getIdentifierFirstRep()));
						final List<org.hl7.fhir.dstu3.model.Extension> extensions = perfRef
								.getExtensionsByUrl(FhirCommon.urnUseAsAuthor);
						if (!extensions.isEmpty()) {
							TimeType t = (TimeType) extensions.get(0).getValue();
							author.setTime(DateUtil.parseDates(t.getValue()));
						}
						lbo.addAuthor(author);
					}

					// Add all LaboratoryObservations
					for (final ObservationRelatedComponent relatedObs : obs.getRelated()) {
						final Observation fhirObs = (org.hl7.fhir.dstu3.model.Observation) relatedObs
								.getTarget().getResource();
						final LaboratoryObservation labObs = getLaboratoryObservation(fhirObs);
						lbo.addLaboratoryObservation(labObs);
					}
					retVal.add(lbo);
				}
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets a list of eHC LRQC LaboratoryBatteryOrganizers from
	 * the given FHIR resource
	 *
	 * @param fhirObs2
	 *            the FHIR resource
	 * @return list of eHC LRQC LaboratoryBatteryOrganizers</div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	private LaboratoryBatteryOrganizer getLaboratoryBatteryOrganizers(Observation labObsList) {
		final LaboratoryBatteryOrganizer lbo = new LaboratoryBatteryOrganizer();

		// Set the Organizer Attributes
		// Status Code
		final String statusCode = getValueFromKeyValueString(labObsList, "statusCode");
		if (statusCode != null) {
			lbo.setStatusCode(StatusCode.getEnum(statusCode));
		}
		// EffectiveTime
		final DateTimeType fTime = (DateTimeType) labObsList.getEffective();
		if (fTime != null)
			lbo.setEffectiveTime(fTime.getValue());

		// Authors
		for (Reference perfRef : labObsList.getPerformer()) {
			Practitioner p = (Practitioner) perfRef.getResource();
			Author author = new Author();
			author.addId(FhirCommon.fhirIdentifierToEhcIdentificator(p.getIdentifierFirstRep()));
			final List<org.hl7.fhir.dstu3.model.Extension> extensions = labObsList
					.getExtensionsByUrl(FhirCommon.urnUseAsAuthor);
			if (!extensions.isEmpty()) {
				TimeType t = (TimeType) extensions.get(0).getValue();
				author.setTime(DateUtil.parseDates(t.getValue()));
			}
			lbo.addAuthor(author);
		}

		// Add all LaboratoryObservations
		for (final ObservationRelatedComponent relatedObs : labObsList.getRelated()) {
			final Observation fhirObs = (Observation) relatedObs.getTarget().getResource();
			final LaboratoryObservation labObs = getLaboratoryObservation(fhirObs);
			lbo.addLaboratoryObservation(labObs);
		}
		return lbo;
	}

	/**
	 * Gets a Laboratory Isolate Organizer
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return Laboratory Isolate Organizer
	 */
	protected LaboratoryIsolateOrganizer getLaboratoryIsolateOrganizer(
			DocumentManifest docManifest) {
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			if (!entry.getExtensionsByUrl(FhirCommon.urnUseAsLaboratoryIsolateOrganizer)
					.isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					final Observation obs = (Observation) ref.getResource();

					final Identificator id = FhirCommon
							.fhirIdentifierToEhcIdentificator(obs.getIdentifierFirstRep());
					final String ref2 = getNarrative(docManifest,
							FhirCommon.urnUseAsLaboratoryIsolateOrganizer);
					final Code code = FhirCommon.fhirCodeToEhcCode(obs.getCode());
					code.setOriginalTextReference(ref2);

					final LaboratoryIsolateOrganizer sce = new LaboratoryIsolateOrganizer(ref2);
					sce.getSpecimen().setCode(code);
					sce.getMdht().getIds().add(id.getIi());

					// EffectiveTime
					final DateTimeType fTime = (DateTimeType) obs.getEffective();
					if (fTime != null)
						sce.setEffectiveTime(fTime.getValue());

					// Authors
					for (Reference perfRef : obs.getPerformer()) {
						Practitioner p = (Practitioner) perfRef.getResource();
						Author author = new Author();
						author.addId(FhirCommon
								.fhirIdentifierToEhcIdentificator(p.getIdentifierFirstRep()));
						final List<org.hl7.fhir.dstu3.model.Extension> extensions = perfRef
								.getExtensionsByUrl(FhirCommon.urnUseAsAuthor);
						if (!extensions.isEmpty()) {
							TimeType t = (TimeType) extensions.get(0).getValue();
							author.setTime(DateUtil.parseDates(t.getValue()));
						}
						sce.addAuthor(author);
					}

					// Add all LaboratoryObservations
					final LaboratoryBatteryOrganizer lbo = new LaboratoryBatteryOrganizer();
					for (final ObservationRelatedComponent relatedObs : obs.getRelated()) {
						final Observation fhirObs = (org.hl7.fhir.dstu3.model.Observation) relatedObs
								.getTarget().getResource();
						final LaboratoryObservation labObs = getLaboratoryObservation(fhirObs);
						lbo.addLaboratoryObservation(labObs);
					}
					sce.addLaboratoryBatteryOrganizer(lbo);
					return sce;
				}
			}
		}
		return null;
	}

	/**
	 * Gets a Laboratory Observation
	 *
	 * @param fhirObservation
	 *            the FHIR resource
	 * @return the Laboratory Observation
	 */
	protected LaboratoryObservation getLaboratoryObservation(Observation fhirObservation) {
		final LaboratoryObservation retVal = new LaboratoryObservation();

		fhirObservation.getCode().getCodingFirstRep();
		retVal.setCode(FhirCommon.fhirCodeToEhcCode(fhirObservation.getCode()));
		if (fhirObservation.getIssued() != null) {
			retVal.setEffectiveTime(fhirObservation.getIssued());
		}
		if (!fhirObservation.getPerformer().isEmpty()) {
			final Reference refPerf = fhirObservation.getPerformer().get(0);
			retVal.setLaboratory(FhirCommon.getOrganization((Organization) refPerf.getResource()),
					fhirObservation.getIssued());
		}
		Value v = null;
		// type PQ
		if (fhirObservation.getValue() instanceof Quantity) {
			final Quantity fhirQuantity = (Quantity) fhirObservation.getValue();
			v = new Value(fhirQuantity.getValue().toString(), Ucum.AHGEquivalentsPerMilliLiter);

			// fix for the bug(?), which ommits the unit when it´s set to
			// "1"
			// Seems to be a bug in the MDHT. Ucum Unit can´t be set to "1".
			// unit = fhirQuantity.getUnit().replace("#", "");
			String unit;
			if (fhirQuantity.getUnit().startsWith("#")) {
				unit = fhirQuantity.getUnit();
			} else {
				unit = fhirQuantity.getUnit();
			}
			v.setUcumUnit(unit);
		}
		// type String
		if (fhirObservation.getValue() instanceof StringType) {
			final StringType fhirString = (StringType) fhirObservation.getValue();
			// type BL
			if (fhirString.getValueAsString().equalsIgnoreCase("false")
					|| fhirString.getValueAsString().equalsIgnoreCase("true")
					|| fhirString.getValueAsString().equalsIgnoreCase("NA")) {
				if (!fhirObservation.getDataAbsentReason().isEmpty()) {
					BL bl = DatatypesFactory.eINSTANCE.createBL();
					bl.setNullFlavor(NullFlavor.NA);
					v = new Value(bl);
				} else {
					if (fhirString.getValueAsString().equalsIgnoreCase("true")) {
						v = new Value(true);
					}
					if (fhirString.getValueAsString().equalsIgnoreCase("false")) {
						v = new Value(false);
					}
					if (fhirString.getValueAsString().equalsIgnoreCase("NA")) {
						BL bl = DatatypesFactory.eINSTANCE.createBL();
						bl.setNullFlavor(NullFlavor.NA);
						v = new Value(bl);
					}
				}
			}
			if (fhirString.getValue().startsWith("INT:")) {
				if (fhirString.getValue().startsWith("INT:NA")) {
					INT intValue = DatatypesFactory.eINSTANCE.createINT();
					intValue.setNullFlavor(NullFlavor.NA);
					v = new Value(intValue);
				} else {
					v = new Value(Integer.parseInt(fhirString.getValue().replace("INT:", "")));
				}
			}
			if (fhirString.getValue().startsWith("ED:")) {
				if (fhirString.getValue().startsWith("ED:#")) {
					ED edValue = Util.createReference(fhirString.getValue().replace("ED:", ""));
					v = new Value(edValue);
				} else {
					v = new Value(Integer.parseInt(fhirString.getValue().replace("INT:", "")));
				}
			}
			if (fhirString.getValue().startsWith("ST:")) {
				if (fhirString.getValue().startsWith("ST:NA")) {
					ST stValue = DatatypesFactory.eINSTANCE.createST();
					stValue.setNullFlavor(NullFlavor.NA);
					v = new Value(stValue);
				} else {
					ST stValue = DatatypesFactory.eINSTANCE
							.createST(fhirString.getValue().replace("ST:", ""));
					v = new Value(stValue);
				}
			}
		}
		// type CD
		if (fhirObservation.getValue() instanceof CodeableConcept)

		{
			final Coding fhirValueCode = ((CodeableConcept) fhirObservation.getValue())
					.getCodingFirstRep();
			retVal.addValue(
					new Code(new Code(FhirCommon.removeUrnOidPrefix(fhirValueCode.getSystem()),
							fhirValueCode.getCode(), fhirValueCode.getDisplay())));
		}
		if (fhirObservation.getValue() instanceof Ratio) {
			// type RTO not yet implemented
		}
		if (v != null) {
			retVal.addValue(v);
		}

		// ReferenceRange
		if (!fhirObservation.getReferenceRange().isEmpty()) {
			org.ehealth_connector.common.ReferenceRange rr = new org.ehealth_connector.common.ReferenceRange();
			// Value
			if (fhirObservation.getReferenceRangeFirstRep().getLow().getUnit() != null
					&& fhirObservation.getReferenceRangeFirstRep().getHigh().getUnit() != null) {
				v = new Value(fhirObservation.getReferenceRangeFirstRep().getLow().getValue(),
						fhirObservation.getReferenceRangeFirstRep().getLow().getUnit(),
						fhirObservation.getReferenceRangeFirstRep().getHigh().getValue(),
						fhirObservation.getReferenceRangeFirstRep().getHigh().getUnit());
			} else {
				v = new Value(fhirObservation.getReferenceRangeFirstRep().getLow().getValue(),
						fhirObservation.getReferenceRangeFirstRep().getHigh().getValue());
			}

			rr.setValue(v);

			// Interpretation of the reference range
			ObservationInterpretation obsInt = null;
			if (fhirObservation.getReferenceRangeFirstRep().getAppliesTo() != null) {
				if (fhirObservation.getReferenceRangeFirstRep().getAppliesTo().size() > 0) {
					if (fhirObservation.getReferenceRangeFirstRep().getAppliesTo().get(0) != null) {
						if (fhirObservation.getReferenceRangeFirstRep().getAppliesTo().get(0)
								.getCodingFirstRep() != null) {
							String code = fhirObservation.getReferenceRangeFirstRep().getAppliesTo()
									.get(0).getCodingFirstRep().getCode();
							obsInt = ObservationInterpretation.getEnum(code);
						}
					}
				}
			}
			if (obsInt != null) {
				rr.setInterpretationCode(obsInt);
			}
			retVal.setReferenceRange(rr);
		}

		// Interpretation of the observation
		final Coding fhirInterpretationCode = fhirObservation.getInterpretation()
				.getCodingFirstRep();
		if (fhirInterpretationCode != null) {
			if (fhirInterpretationCode.getSystem() != null) {
				retVal.addInterpretationCode(new Code(
						FhirCommon.removeUrnOidPrefix(fhirInterpretationCode.getSystem()),
						fhirInterpretationCode.getCode(), fhirInterpretationCode.getDisplay()));
			} else
				retVal.addInterpretationCode(NullFlavor.NA);
		}
		// Text reference (inside the observation)
		if (fhirObservation.getComment() != null && !fhirObservation.getComment().isEmpty())

		{
			retVal.setTextReference(fhirObservation.getComment());
		}
		// Comments
		for (ObservationRelatedComponent commentRef : fhirObservation.getRelated()) {
			if (commentRef.getTarget().getResource() instanceof Observation) {
				Observation comment = (Observation) commentRef.getTarget().getResource();
				if (comment.getComment() != null) {
					retVal.addCommentEntry(new SectionAnnotationCommentEntry(comment.getComment()));
				}
			}
		}

		return retVal;
	}

	/**
	 * <div class="en">Gets a list of eHC LaboratoryObservations from the given
	 * FHIR resource
	 *
	 * @param docManifest
	 *            FHIR resource
	 * @return list of eHC LaboratoryObservations </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public List<LaboratoryObservation> getLaboratoryObservations(DocumentManifest docManifest) {
		final List<LaboratoryObservation> retVal = new ArrayList<LaboratoryObservation>();
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			if (!entry.getExtensionsByUrl(FhirCommon.urnUseAsLaboratoryObservation).isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					if (ref.getResource() instanceof Observation) {
						retVal.add(getLaboratoryObservation((Observation) ref.getResource()));
					}
				}
			}
		}
		return retVal;
	}

	/**
	 * Gets a List of the Laboratory Specialty Sections
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return the Laboratory Specialty Sections
	 */
	protected List<LaboratorySpecialtySection> getLaboratorySpecialtySections(
			DocumentManifest docManifest) {

		final List<LaboratorySpecialtySection> lssList = new ArrayList<LaboratorySpecialtySection>();

		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			final List<org.hl7.fhir.dstu3.model.Extension> extensions = entry
					.getExtensionsByUrl(FhirCommon.urnUseAsLaboratorySpecialtySection);
			if (!extensions.isEmpty()) {
				Reference ref = null;
				try {
					if (entry.hasPReference())
						ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					final Observation obs = (Observation) ref.getResource();

					// SectionCode
					final Code code = FhirCommon.fhirCodeToEhcCode(obs.getCode());
					code.setCodeSystemName("LOINC");
					final LaboratorySpecialtySection lss = new LaboratorySpecialtySection(code,
							LanguageCode.getEnum(docManifest.getLanguage()));

					// Add all LaboratoryBatteryOrganizers
					SpecimenAct spa = new SpecimenAct();
					spa.setCode(code);
					for (final ObservationRelatedComponent relatedObs : obs.getRelated()) {
						final Observation fhirObs = (Observation) relatedObs.getTarget()
								.getResource();
						spa.addLaboratoryBatteryOrganizer(getLaboratoryBatteryOrganizers(fhirObs));
					}
					lss.setLaboratoryReportDataProcessingEntry(
							new LaboratoryReportDataProcessingEntry(spa));

					// NarrativeText
					lss.setText(obs.getCategoryFirstRep().getCodingFirstRep().getDisplay());
					lssList.add(lss);
				}
			}
		}
		return lssList;
	}

	/**
	 * Gets an eHC Author object containing the legal authenticator from the
	 * given FHIR resource
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return eHC Author object containing the legal authenticator
	 */
	public org.ehealth_connector.common.Author getLegalAuthenticator(DocumentManifest docManifest) {
		org.ehealth_connector.common.Author retVal = null;
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			final List<org.hl7.fhir.dstu3.model.Extension> extensions = entry
					.getExtensionsByUrl(FhirCommon.urnUseAsLegalAuthenticator);
			if (!extensions.isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					if (ref.getResource() instanceof Person) {
						retVal = FhirCommon.getAuthor(ref.getResource());
						final TimeType timeStamp = ((TimeType) extensions.get(0)
								.getValueAsPrimitive());
						if (timeStamp.getValue().length() > 8)
							retVal.setTime(
									DateUtil.parseDateyyyyMMddHHmmssZZZZ(timeStamp.getValue()));

						else
							retVal.setTime(DateUtil.parseDateyyyyMMdd(timeStamp.getValue()));
					}
				}
			}
		}

		return retVal;
	}

	/**
	 * Gets the Lot number
	 *
	 * @param fhirMedicationStatement
	 *            the FHIR resource
	 * @return the Lot number
	 */
	protected String getLot(MedicationStatement fhirMedicationStatement) {
		String retVal = "";
		if (!fhirMedicationStatement.getExtensionsByUrl(FhirCommon.urnUseAsLotNumbertext)
				.isEmpty()) {
			final StringType lot = (StringType) fhirMedicationStatement
					.getExtensionsByUrl(FhirCommon.urnUseAsLotNumbertext).get(0).getValue();
			retVal = lot.toString();
		}
		return retVal;
	}

	/**
	 * Gets an eHC Author object containing the legal authenticator from the
	 * given FHIR resource
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return eHC Author object containing the legal authenticator
	 */
	public String getNarrative(DocumentManifest docManifest, String extensionUrl) {
		String retVal = "";

		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {

			if (!entry.getExtensionsByUrl(extensionUrl).isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {

					if (ref.getResource() instanceof Observation) {
						Observation fhirObject = (Observation) ref.getResource();
						retVal = fhirObject.getCategoryFirstRep().getCodingFirstRep().getDisplay();
					} else if (ref.getResource() instanceof Basic) {
						retVal = ((Basic) ref.getResource()).getCode().getCodingFirstRep()
								.getDisplay();
					} else {
						throw new UnsupportedOperationException();
					}
				}
			}
		}

		return retVal;
	}

	/**
	 * Gets an NonLivingSubject
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return The NonLivingSubject
	 */
	protected NonHumanSubject getNonLivingSubject(DocumentManifest docManifest) {
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			if (!entry.getExtensionsByUrl(FhirCommon.urnUseAsNonLivingSubject).isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					final Person obs = (Person) ref.getResource();
					NonHumanSubject nhs = new NonHumanSubject(
							FhirCommon.fhirAddressToEhcAddress(obs.getAddressFirstRep()));
					return nhs;
				}
			}
		}
		return null;
	}

	/**
	 * Gets a Past Problem Concern
	 *
	 * @param fhirCondition
	 *            the FHIR resource
	 * @return the Past Problem Concern
	 */
	private org.ehealth_connector.cda.ch.PastProblemConcern getPastProblemConcern(
			Condition fhirCondition) {
		org.ehealth_connector.cda.ch.PastProblemConcern retVal = null;

		final String concern = fhirCondition.getNoteFirstRep().getText();

		final org.ehealth_connector.cda.Problem problemEntry = getProblemEntry(fhirCondition);

		final org.ehealth_connector.cda.enums.ProblemConcernStatusCode problemStatusCode = getProblemConcernStatusCode(
				fhirCondition);

		// Create the PastProblemConcern
		retVal = new PastProblemConcern(concern, problemEntry, problemStatusCode);
		return retVal;

	}

	/**
	 * <div class="en">Gets a list of eHC PastProblemConcerns from the given
	 * FHIR resource
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return list of eHC PastProblemConcerns </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public List<org.ehealth_connector.cda.ch.PastProblemConcern> getPastProblemConcernEntries(
			DocumentManifest docManifest) {
		final List<org.ehealth_connector.cda.ch.PastProblemConcern> retVal = new ArrayList<org.ehealth_connector.cda.ch.PastProblemConcern>();
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			final List<org.hl7.fhir.dstu3.model.Extension> extensions = entry
					.getExtensionsByUrl(FhirCommon.urnUseAsPastProblemConcern);
			if (!extensions.isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					if (ref.getResource() instanceof Condition) {
						final Condition fhirCondition = (Condition) ref.getResource();
						final PastProblemConcern concern = getPastProblemConcern(fhirCondition);
						for (final org.hl7.fhir.dstu3.model.Extension ext : extensions) {
							if (ext.getValue() instanceof DateType) {
								concern.setStart(((DateType) ext.getValue()).getValue());
							}
							if (ext.getValue() instanceof StringType) {
								concern.getMdht().getIds().clear();
								concern.addId(new Identificator(
										((StringType) ext.getValue()).toString(), null));
							}
						}

						retVal.add(concern);
					}
				}
			}
		}
		return retVal;
	}

	/**
	 * Gets an eHC Author object containing the performer from the given FHIR
	 * MedicationStatement object
	 *
	 * @param fhirMedicationStatement
	 *            the FHIR resource
	 * @return eHC Author object containing the performer
	 */
	public org.ehealth_connector.common.Author getPerformer(
			MedicationStatement fhirMedicationStatement) {
		org.ehealth_connector.common.Author retVal = null;
		for (final Reference ref : fhirMedicationStatement.getDerivedFrom()) {
			List<org.hl7.fhir.dstu3.model.Extension> extensions = ref
					.getExtensionsByUrl(FhirCommon.urnUseAsPerformer);
			if (!extensions.isEmpty() && (ref.getResource() instanceof Person)) {
				retVal = FhirCommon.getAuthor((Person) ref.getResource());
				if (extensions.get(0).getValue() instanceof TimeType) {
					TimeType timeStamp = ((TimeType) extensions.get(0).getValue());
					if (timeStamp.getValue().length() > 8)
						retVal.setTime(DateUtil.parseDateyyyyMMddHHmmssZZZZ(timeStamp.getValue()));

					else
						retVal.setTime(DateUtil.parseDateyyyyMMdd(timeStamp.getValue()));
				}
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the eHC PregnancyHistory object from the given FHIR
	 * resource
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return eHC PregnancyHistory object </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public org.ehealth_connector.cda.ch.PregnancyHistory getPregnancyHistory(
			DocumentManifest docManifest) {
		PregnancyHistory retVal = null;
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			if (!entry.getExtensionsByUrl(FhirCommon.urnUseAsPregnancyObservation).isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					Date deliveryDate = null;
					Identificator id = null;
					if (ref.getResource() instanceof Observation) {
						final Observation fhirObs = (Observation) ref.getResource();
						final Coding fhirCode = fhirObs.getCode().getCodingFirstRep();
						if ("11778-8".equals(fhirCode.getCode())) {
							deliveryDate = ((DateTimeType) fhirObs.getValue()).getValue();
							if (!fhirObs.getIdentifier().isEmpty()) {
								Identifier idTemp = fhirObs.getIdentifier().get(0);
								final String codeSystem = FhirCommon
										.removeUrnOidPrefix(idTemp.getSystem());
								id = new Identificator(codeSystem, idTemp.getValue());
							}
						}
						if (deliveryDate != null) {
							retVal = new PregnancyHistory(deliveryDate);
							if (id != null)
								retVal.setId(id);
							// not yet implemented:
							// retVal.setPerformer(perfomer);
						}
					}
				}
			}
		}
		return retVal;
	}

	/**
	 * Gets the Problem Concern Status Code
	 *
	 * @param condition
	 *            the Condtion
	 * @return the Problem Concern Status Code
	 */
	protected org.ehealth_connector.cda.enums.ProblemConcernStatusCode getProblemConcernStatusCode(
			Condition condition)

	{
		org.ehealth_connector.cda.enums.ProblemConcernStatusCode retVal = ProblemConcernStatusCode.COMPLETED;
		final ConditionClinicalStatus status = condition.getClinicalStatusElement().getValue();
		if (status == ConditionClinicalStatus.RESOLVED) {
			retVal = ProblemConcernStatusCode.COMPLETED;
		} else if (status == ConditionClinicalStatus.ACTIVE) {
			retVal = ProblemConcernStatusCode.ACTIVE;
		}
		return retVal;
	}

	/**
	 * Gets a Problem Entry
	 *
	 * @param fhirCondition
	 *            the FHIR resource
	 * @return the Problem Entry
	 */
	protected org.ehealth_connector.cda.Problem getProblemEntry(Condition fhirCondition) {

		final org.ehealth_connector.cda.Problem retVal = new org.ehealth_connector.cda.Problem();
		final Coding fhirCode = fhirCondition.getCode().getCodingFirstRep();

		// Add Problem Entry Identifiers
		for (final Identifier id : fhirCondition.getIdentifier()) {
			final String codeSystem = FhirCommon.removeUrnOidPrefix(id.getSystem());
			retVal.setId(new Identificator(codeSystem, id.getValue()));
		}

		// currently only Problems supported
		retVal.setCode(ProblemType.PROBLEM);

		// Date
		retVal.setStartDate(fhirCondition.getAssertedDate());

		// Value
		retVal.addValue(new Code(FhirCommon.removeUrnOidPrefix(fhirCode.getSystem()),
				fhirCode.getCode(), fhirCode.getDisplay()));

		return retVal;
	}

	/**
	 * <div class="en">Gets the eHC ReferralOrderingPhyscian from the given FHIR
	 * resource
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return eHC Custodian</div> <div class="de"></div> <div class="fr"></div>
	 */
	protected ReferralOrderingPhysician getReferralOrderingPhysician(DocumentManifest docManifest) {
		ReferralOrderingPhysician retVal = null;

		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			if (!entry.getExtensionsByUrl(FhirCommon.urnUseAsReferralOrderingPhysician).isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					final Person physician = (Person) ref.getResource();

					Name name = null;
					if (physician.getNameFirstRep() != null) {
						name = FhirCommon.fhirNameToEhcName(physician.getNameFirstRep());
					}
					final Address address = FhirCommon
							.fhirAddressToEhcAddress(physician.getAddressFirstRep());
					final Telecoms telecoms = FhirCommon.getTelecoms(physician.getTelecom());

					final AssociatedEntity entity = new AssociatedEntity(name, address, telecoms);
					for (final Identifier id : physician.getIdentifier()) {
						entity.addId(FhirCommon.fhirIdentifierToEhcIdentificator(id));
					}

					Reference ref2 = physician.getManagingOrganization();
					if (ref2 != null) {
						entity.setOrganization(
								FhirCommon.getOrganization((Organization) ref2.getResource()));
					}
					retVal = new ReferralOrderingPhysician(entity);
				}
			}
		}

		return retVal;
	}

	/**
	 * Gets a Related Document
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return the Related Document
	 */
	protected Identificator getRelatedDocument(DocumentManifest docManifest) {
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			final List<Extension> extensions = entry
					.getExtensionsByUrl(FhirCommon.urnUseAsRelatedDocument);
			if (!extensions.isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					Basic ifo = (Basic) ref.getResource();
					return FhirCommon.fhirIdentifierToEhcIdentificator(ifo.getIdentifierFirstRep());
				}
			}
		}
		return null;
	}

	/**
	 * Gets the specimen collection entry.
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return the specimen collection entry
	 */
	protected SpecimenCollectionEntry getSpecimenCollectionEntry(DocumentManifest docManifest) {
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			if (!entry.getExtensionsByUrl(FhirCommon.urnUseAsSpecimenCollection).isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					final Observation obs = (Observation) ref.getResource();

					Identificator id = null;
					if (obs.getIdentifierFirstRep() != null
							&& !obs.getIdentifierFirstRep().isEmpty()) {
						id = FhirCommon
								.fhirIdentifierToEhcIdentificator(obs.getIdentifierFirstRep());
					}
					String ref2 = null;
					if (obs.getComment() != null && !obs.getComment().isEmpty()) {
						ref2 = obs.getComment();
					}
					Date date = null;
					final DateTimeType fdate = (DateTimeType) obs.getEffective();
					if (fdate != null) {
						date = fdate.getValue();
					}

					final SpecimenCollectionEntry sce = new SpecimenCollectionEntry(date, id, ref2);
					return sce;
				}
			}
		}
		return null;
	}

	/**
	 * Gets the specimen received entry.
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return the specimen received entry
	 */
	protected SpecimenReceivedEntry getSpecimenReceivedEntry(DocumentManifest docManifest) {
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			if (!entry.getExtensionsByUrl(FhirCommon.urnUseAsSpecimenReceived).isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					final Observation obs = (Observation) ref.getResource();
					final SpecimenReceivedEntry sce = new SpecimenReceivedEntry();

					final Identificator id = FhirCommon
							.fhirIdentifierToEhcIdentificator(obs.getIdentifierFirstRep());
					if (id != null) {
						sce.addId(id);
					} else {
						org.openhealthtools.mdht.uml.hl7.datatypes.II ii = DatatypesFactory.eINSTANCE
								.createII();
						ii.setNullFlavor(NullFlavor.NA);
						sce.addId(new Identificator(ii));
					}
					final DateTimeType fDate = (DateTimeType) obs.getEffective();
					if (fDate != null) {
						final Date date = fDate.getValue();
						sce.setEffectiveTime(date);
					}

					return sce;
				}
			}
		}

		return null;
	}

	/**
	 * Gets a value by the given key (e.g. used for statuscode=completed)
	 *
	 * @param fhirObject
	 *            the FHIR resource
	 * @param key
	 *            the given key
	 * @return the desired value
	 */
	public String getValueFromKeyValueString(Observation fhirObject, String key) {
		String line = fhirObject.getCategoryFirstRep().getCodingFirstRep().getDisplay();
		if (line != null) {
			if (line.contains(key)) {
				final String[] keyValue = line.split("=");
				return keyValue[1];
			}
		}
		return null;
	}

	/**
	 * Gets a Vital Sign Observation
	 *
	 * @param fhirObs
	 *            the FHIR resource
	 * @return the Vital Sign Observation
	 */
	private AbstractVitalSignObservation getVitalSignObservation(Observation fhirObs) {
		AbstractVitalSignObservation vso = new AbstractVitalSignObservation();
		// Value
		Value v = null;
		if (fhirObs.getValue() instanceof Quantity) {
			Quantity fValue = (Quantity) fhirObs.getValue();
			v = new Value(fValue.getValue().toString(), Ucum.AHGEquivalentsPerMilliLiter);
			v.setUcumUnit(fValue.getUnit());
		}
		if (fhirObs.getValue() instanceof StringType) {
			StringType fValue = (StringType) fhirObs.getValue();
			if (fValue.getValue().startsWith("INT:")) {
				if (fValue.getValue().startsWith("INT:NA")) {
					INT intValue = DatatypesFactory.eINSTANCE.createINT();
					intValue.setNullFlavor(NullFlavor.NA);
					v = new Value(intValue);
				} else {
					v = new Value(Integer.parseInt(fValue.getValue()));
				}
			}
		}
		vso.setValue(v);

		// Code
		VitalSignList codeEnum = VitalSignList
				.getEnum(fhirObs.getCode().getCodingFirstRep().getCode());
		if (codeEnum != null) {
			vso.setCode(codeEnum.getCode());
		}

		// Ids
		for (Identifier fId : fhirObs.getIdentifier()) {
			vso.addId(FhirCommon.fhirIdentifierToEhcIdentificator(fId));
		}

		// ObservationInterpretation
		ObservationInterpretationForVitalSign i = ObservationInterpretationForVitalSign
				.getEnum(fhirObs.getInterpretation().getCodingFirstRep().getCode());
		if (i != null) {
			vso.setInterpretationCode(i.getCode());
		}

		// Text reference (inside the observation)
		if (fhirObs.getComment() != null && !fhirObs.getComment().isEmpty()) {
			vso.setTextReference(fhirObs.getComment());
		}
		// Comments
		for (ObservationRelatedComponent commentRef : fhirObs.getRelated()) {
			if (commentRef.getTarget().getResource() instanceof Observation) {
				Observation comment = (Observation) commentRef.getTarget().getResource();
				if (comment.getComment() != null) {
					vso.addCommentEntry(new SectionAnnotationCommentEntry(comment.getComment()));
				}
			}
		}

		// Method Code Translation
		if (fhirObs.getCode().getCoding().size() > 1) {
			Code translation = new Code(fhirObs.getCode().getCoding().get(1).getSystem(),
					fhirObs.getCode().getCoding().get(1).getCode());
			vso.setMethodCodeTranslation(translation);
		}

		return vso;
	}

	/**
	 * <div class="en">Gets a list of eHC VitalSignsOrganizers from the given
	 * FHIR resource
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return list of eHC VitalSignsOrganizers</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	protected List<VitalSignsOrganizer> getVitalSignsOrganizers(DocumentManifest docManifest) {
		final List<VitalSignsOrganizer> retVal = new ArrayList<VitalSignsOrganizer>();

		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			if (!entry.getExtensionsByUrl(FhirCommon.urnUseAsVitalSignsOrganizer).isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					final VitalSignsOrganizer lbo = new VitalSignsOrganizer();
					final Observation obs = (Observation) ref.getResource();

					// Set the Organizer Attributes
					// Status Code
					final String statusCode = getValueFromKeyValueString(obs, "statusCode");
					if (statusCode != null) {
						lbo.setStatusCode(StatusCode.getEnum(statusCode));
					}

					// Organizer Id
					if (!obs.getIdentifier().isEmpty()) {
						Identificator id = new Identificator(obs.getIdentifierFirstRep());
						id.setRoot(id.getRoot().replace(FhirCommon.oidUrn, ""));
						lbo.getMdht().getIds().add(id.getIi());
					}

					// EffectiveTime
					final DateTimeType fTime = (DateTimeType) obs.getEffective();
					if (fTime != null)
						lbo.setEffectiveTime(fTime.getValue());

					// Add all LaboratoryObservations
					for (final ObservationRelatedComponent relatedObs : obs.getRelated()) {
						final Observation fhirObs = (org.hl7.fhir.dstu3.model.Observation) relatedObs
								.getTarget().getResource();
						final AbstractVitalSignObservation labObs = getVitalSignObservation(
								fhirObs);
						lbo.addVitalSignObservation(labObs);
					}
					retVal.add(lbo);
				}
			}
		}
		return retVal;
	}

	/**
	 * <div class="en"> Checks if a document type code with a matching oid is
	 * present in the given FHIR resource
	 *
	 * @param fhirResource
	 *            the FHIR resource
	 * @param docOid
	 *            the oid of the document
	 * @return eHC document type code (full or masked patient
	 *         demographics)</div> <div class="de"></div> <div class="fr"></div>
	 */
	public boolean isDocType(DocumentManifest docManifest, String docOid) {
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			Reference ref = null;
			try {
				ref = entry.getPReference();
			} catch (FHIRException e) {
			}
			if (ref != null) {
				if (ref.getResource() instanceof org.hl7.fhir.dstu3.model.Basic) {
					Basic fhirObject = (org.hl7.fhir.dstu3.model.Basic) ref.getResource();
					final Coding langCode = fhirObject.getCode().getCodingFirstRep();
					if (FhirCommon.addUrnOid(docOid).equals(langCode.getSystem())) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
