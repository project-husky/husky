package org.ehealth_connector.communication;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.XdsUtil;
import org.ehealth_connector.communication.ch.enums.AvailabilityStatus;
import org.openhealthtools.ihe.common.hl7v2.XCN;
import org.openhealthtools.ihe.xds.metadata.AuthorType;
import org.openhealthtools.ihe.xds.metadata.MetadataFactory;
import org.openhealthtools.ihe.xds.metadata.SubmissionSetType;
import org.openhealthtools.ihe.xds.metadata.extract.cdar2.CDAR2Extractor;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;

public class SubmissionSetMetadata {
	/** The cda. */
	private final ClinicalDocument cda;
	private SubmissionSetType s;
	
	public SubmissionSetMetadata() {
		s = MetadataFactory.eINSTANCE.createSubmissionSetType();
		cda = CDAFactory.eINSTANCE.createClinicalDocument();
	}
	
	public SubmissionSetMetadata(SubmissionSetType ohtSubmissionSet) {
		this.s = ohtSubmissionSet;
		cda = CDAFactory.eINSTANCE.createClinicalDocument();
	}
	
	public SubmissionSetType getOhtSubmissionSetType() {
		return s;
	}
	
	public void setAuthor(Author author) {
		// Workaround for a Bug in the CDAR2Extractor, which causes a
		// NullpointerException, if no Telecom value is inserted and
		// logger.Debug is set to true
		if (author.getAuthorMdht().getAssignedAuthor().getTelecoms() == null
				|| author.getAuthorMdht().getAssignedAuthor().getTelecoms().isEmpty()) {
			TEL tel = DatatypesFactory.eINSTANCE.createTEL();
			author.getAuthorMdht().getAssignedAuthor().getTelecoms().add(tel);
		}

		cda.getAuthors().clear();
		cda.getAuthors().add(author.copyMdhtAuthor());
		CDAR2Extractor extractor = new CDAR2Extractor(cda);
		AuthorType xAuthor = extractor.extractAuthors().get(0);
		
		//Set the extracted author person object
		s.setAuthor(xAuthor);
	}
	
	public Author getAuthor() {
		return XdsUtil.convertOhtAuthorType(s.getAuthor());
	}
	
	public void setAvailabilityStatus(AvailabilityStatus status) {
		s.setAvailabilityStatus(status.getAsOhtAvailabilityStatusType());
	}
	
	public AvailabilityStatus getAvailabilityStatus() {
		return AvailabilityStatus.getByOhtAvailabilityStatusType(s.getAvailabilityStatus());
	}
	
	public void setComments(String comments) {
		s.setComments(XdsUtil.createInternationalString(comments));
	}
	
	public String getComments() {
		return XdsUtil.convertInternationalStringType(s.getComments());
	}
	
	public void setContentTypeCode(Code code) {
		s.setContentTypeCode(XdsUtil.convertCode(code));
	}
	
	public Code getContentTypeCode() {
		return XdsUtil.convertOhtCodedMetadataType(s.getContentTypeCode());
	}
	
	public void setPatientId(Identificator id) {
		s.setPatientId(XdsUtil.convertEhcIdentificator(id));
	}
	
	public Identificator getPatientId() {
		return XdsUtil.convertOhtCx(s.getPatientId());
	}
	
	public void setSourceId(String id) {
		s.setSourceId(id);
	}
	
	public String getSourceId() {
		return s.getSourceId();
	}
	
	public void setTitle(String title) {
		s.setTitle(XdsUtil.createInternationalString(title));
	}
	
	public String getTitle() {
		return XdsUtil.convertInternationalStringType(s.getTitle());
	}
	
	public SubmissionSetType toOhtSubmissionSetType(SubmissionSetType b) {
		b.setAuthor(EcoreUtil.copy(s.getAuthor()));
		b.setAvailabilityStatus(s.getAvailabilityStatus());
		b.setComments(EcoreUtil.copy(s.getComments()));
		b.setContentTypeCode(EcoreUtil.copy(s.getContentTypeCode()));
		b.setPatientId(s.getPatientId());
		b.setSourceId(s.getSourceId());
		b.setTitle(EcoreUtil.copy(s.getTitle()));
		b.setUniqueId(s.getUniqueId());
		b.getIntendedRecipient().clear(); b.getIntendedRecipient().addAll(s.getIntendedRecipient());
		return b;
	}
}
