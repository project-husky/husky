package org.ehealth_connector.common;

import org.openhealthtools.ihe.common.hl7v2.CX;
import org.openhealthtools.ihe.common.hl7v2.Hl7v2Factory;
import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;
import org.openhealthtools.ihe.xds.metadata.LocalizedStringType;
import org.openhealthtools.ihe.xds.metadata.MetadataFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;

public class XdsUtil {
	public static CodedMetadataType convertCode (Code code) {
		return createCodedMetadata(code.getCodeSystem(), code.getCode(), code.getDisplayName(), null);		
	}

	public static CX convertIdentificator (Identificator id) {
		return createCx(id.getRoot(), id.getExtension());
	}

	public static CX convertII (II ii) {
		return createCx(ii.getRoot(), ii.getExtension());
	}

	public static CodedMetadataType createCodedMetadata(String schemeName, String code, String displayName, String schemeUuid) {
		CodedMetadataType cmt = MetadataFactory.eINSTANCE.createCodedMetadataType();

		cmt.setCode(code);
		if (displayName != null) {
			cmt.setDisplayName(createInternationalString(displayName));
		}
		if (schemeName != null) {
			cmt.setSchemeName(schemeName);
		}
		if (schemeUuid != null)  {
			cmt.setSchemeUUID(schemeUuid);
		}

		return cmt;
	}

	public static CX createCx (String authorityId, String id) {
		CX cx = Hl7v2Factory.eINSTANCE.createCX();
		cx.setAssigningAuthorityUniversalId(authorityId);
		cx.setIdNumber(id);
		cx.setAssigningAuthorityUniversalIdType("ISO");
		return cx;
	}

	public static org.openhealthtools.ihe.xds.metadata.InternationalStringType createInternationalString (String text) {
		org.openhealthtools.ihe.xds.metadata.InternationalStringType ist = MetadataFactory.eINSTANCE.createInternationalStringType();
		LocalizedStringType lst = MetadataFactory.eINSTANCE.createLocalizedStringType();
		lst.setValue(text);
		ist.getLocalizedString().add(lst);
		return ist;
	}
}
