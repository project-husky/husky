package org.ehealth_connector.cda.ch.mtps;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.AssignedEntity;
import org.openhealthtools.mdht.uml.cda.Author;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.ClinicalStatement;
import org.openhealthtools.mdht.uml.cda.Consumable;
import org.openhealthtools.mdht.uml.cda.Encounter;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.Informant12;
import org.openhealthtools.mdht.uml.cda.InfrastructureRootTypeId;
import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.cda.ObservationMedia;
import org.openhealthtools.mdht.uml.cda.Organizer;
import org.openhealthtools.mdht.uml.cda.Participant2;
import org.openhealthtools.mdht.uml.cda.ParticipantRole;
import org.openhealthtools.mdht.uml.cda.Performer2;
import org.openhealthtools.mdht.uml.cda.Precondition;
import org.openhealthtools.mdht.uml.cda.Procedure;
import org.openhealthtools.mdht.uml.cda.Reference;
import org.openhealthtools.mdht.uml.cda.RegionOfInterest;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.cda.Specimen;
import org.openhealthtools.mdht.uml.cda.Subject;
import org.openhealthtools.mdht.uml.cda.Supply;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_INT;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.RTO_PQ_PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.SXCM_TS;
import org.openhealthtools.mdht.uml.hl7.rim.ActRelationship;
import org.openhealthtools.mdht.uml.hl7.rim.Participation;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClass;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentSubstanceMood;

public class SubstanceAdministration
		implements org.openhealthtools.mdht.uml.cda.SubstanceAdministration {

	@Override
	public void addAct(Act act) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEncounter(Encounter encounter) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addObservation(Observation observation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addObservationMedia(ObservationMedia observationMedia) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addOrganizer(Organizer organizer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addProcedure(Procedure procedure) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRegionOfInterest(RegionOfInterest regionOfInterest) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSubstanceAdministration(
			org.openhealthtools.mdht.uml.cda.SubstanceAdministration substanceAdministration) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSupply(Supply supply) {
		// TODO Auto-generated method stub

	}

	@Override
	public EList<Act> getActs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClinicalDocument getClinicalDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<Encounter> getEncounters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<ClinicalStatement> getEntryRelationshipTargets(
			x_ActRelationshipEntryRelationship typeCode, Object targetClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<ClinicalStatement> getEntryRelationshipTargets(Object targetClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<Observation> getObservations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<ObservationMedia> getObservationMedia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<Organizer> getOrganizers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<Procedure> getProcedures() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<RegionOfInterest> getRegionsOfInterest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Section getSection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<org.openhealthtools.mdht.uml.cda.SubstanceAdministration> getSubstanceAdministrations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<Supply> getSupplies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasActTemplate(String templateId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasCode(String code, String codeSystem, String codeSystemName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasEncounterTemplate(String templateId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasObservationMediaTemplate(String templateId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasObservationTemplate(String templateId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasOrganizerTemplate(String templateId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasProcedureTemplate(String templateId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasRegionOfInterestTemplate(String templateId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasSubstanceAdministrationTemplate(String templateId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasSupplyTemplate(String templateId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasTemplateId(String templateId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EList<ParticipantRole> getParticipantRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<AssignedEntity> getAssignedEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<ActRelationship> getInboundRelationships() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<ActRelationship> getOutboundRelationships() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<Participation> getParticipations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isClassCodeDefined() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMoodCodeDefined() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasContent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDefined(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNullFlavorDefined() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNullFlavorUndefined() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TreeIterator<EObject> eAllContents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EClass eClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EObject eContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EStructuralFeature eContainingFeature() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EReference eContainmentFeature() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<EObject> eContents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<EObject> eCrossReferences() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object eGet(EStructuralFeature arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object eGet(EStructuralFeature arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object eInvoke(EOperation arg0, EList<?> arg1) throws InvocationTargetException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eIsProxy() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eIsSet(EStructuralFeature arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Resource eResource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eSet(EStructuralFeature arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eUnset(EStructuralFeature arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public EList<Adapter> eAdapters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eDeliver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eNotify(Notification arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eSetDeliver(boolean arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public EList<CS> getRealmCodes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InfrastructureRootTypeId getTypeId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTypeId(InfrastructureRootTypeId value) {
		// TODO Auto-generated method stub

	}

	@Override
	public EList<II> getTemplateIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<II> getIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CD getCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCode(CD value) {
		// TODO Auto-generated method stub

	}

	@Override
	public ED getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setText(ED value) {
		// TODO Auto-generated method stub

	}

	@Override
	public CS getStatusCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setStatusCode(CS value) {
		// TODO Auto-generated method stub

	}

	@Override
	public EList<SXCM_TS> getEffectiveTimes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CE getPriorityCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPriorityCode(CE value) {
		// TODO Auto-generated method stub

	}

	@Override
	public IVL_INT getRepeatNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRepeatNumber(IVL_INT value) {
		// TODO Auto-generated method stub

	}

	@Override
	public CE getRouteCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRouteCode(CE value) {
		// TODO Auto-generated method stub

	}

	@Override
	public EList<CD> getApproachSiteCodes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IVL_PQ getDoseQuantity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDoseQuantity(IVL_PQ value) {
		// TODO Auto-generated method stub

	}

	@Override
	public IVL_PQ getRateQuantity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRateQuantity(IVL_PQ value) {
		// TODO Auto-generated method stub

	}

	@Override
	public RTO_PQ_PQ getMaxDoseQuantity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMaxDoseQuantity(RTO_PQ_PQ value) {
		// TODO Auto-generated method stub

	}

	@Override
	public CE getAdministrationUnitCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAdministrationUnitCode(CE value) {
		// TODO Auto-generated method stub

	}

	@Override
	public Subject getSubject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSubject(Subject value) {
		// TODO Auto-generated method stub

	}

	@Override
	public EList<Specimen> getSpecimens() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Consumable getConsumable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setConsumable(Consumable value) {
		// TODO Auto-generated method stub

	}

	@Override
	public EList<Performer2> getPerformers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<Author> getAuthors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<Informant12> getInformants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<Reference> getReferences() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<Participant2> getParticipants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<EntryRelationship> getEntryRelationships() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<Precondition> getPreconditions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NullFlavor getNullFlavor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNullFlavor(NullFlavor value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unsetNullFlavor() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isSetNullFlavor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ActClass getClassCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setClassCode(ActClass value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unsetClassCode() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isSetClassCode() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public x_DocumentSubstanceMood getMoodCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMoodCode(x_DocumentSubstanceMood value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unsetMoodCode() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isSetMoodCode() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean getNegationInd() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNegationInd(Boolean value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unsetNegationInd() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isSetNegationInd() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateClassCode(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO Auto-generated method stub
		return false;
	}

}
