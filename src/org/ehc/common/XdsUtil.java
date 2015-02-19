package org.ehc.common;

import org.openhealthtools.ihe.common.hl7v2.CX;
import org.openhealthtools.ihe.common.hl7v2.Hl7v2Factory;
import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;
import org.openhealthtools.ihe.xds.metadata.LocalizedStringType;
import org.openhealthtools.ihe.xds.metadata.MetadataFactory;

public class XdsUtil {
	public static org.openhealthtools.ihe.xds.metadata.InternationalStringType createInternationalString (String text) {
		org.openhealthtools.ihe.xds.metadata.InternationalStringType ist = MetadataFactory.eINSTANCE.createInternationalStringType();
		LocalizedStringType lst = MetadataFactory.eINSTANCE.createLocalizedStringType();
		lst.setValue(text);
		ist.getLocalizedString().add(lst);
		return ist;
	}
	
	public static CodedMetadataType createCodedMetadata(String code, String displayName, String schemeName, String schemeUuid) {
		CodedMetadataType cmt = MetadataFactory.eINSTANCE.createCodedMetadataType();
		
		cmt.setCode(code);
		cmt.setDisplayName(createInternationalString(displayName));
		if (schemeName != null) {
			cmt.setSchemeName(schemeName);
		}
		if (schemeUuid != null)  {
			cmt.setSchemeUUID(schemeUuid);
		}

		return cmt;
	}
	
	public static CodedMetadataType convertCode (Code code) {
		return createCodedMetadata(code.getCode(), code.getDisplayName(), code.getOid(), null);		
	}
	
	public static CX createCx (String authorityId, String id) {
		CX cx = Hl7v2Factory.eINSTANCE.createCX();
		cx.setAssigningAuthorityUniversalId(authorityId);
		cx.setIdNumber(id);
		cx.setAssigningAuthorityUniversalIdType("ISO");
		return cx;
	}
	
	public static CX convertIdentificator (Identificator id) {
		return createCx(id.getRoot(), id.getExtension());
	}
}
