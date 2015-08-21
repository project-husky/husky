/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.common;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.ehealth_connector.communication.ch.enums.CodedMetadataEnumInterface;
import org.openhealthtools.ihe.common.hl7v2.CX;
import org.openhealthtools.ihe.common.hl7v2.Hl7v2Factory;
import org.openhealthtools.ihe.common.hl7v2.XON;
import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;
import org.openhealthtools.ihe.xds.metadata.InternationalStringType;
import org.openhealthtools.ihe.xds.metadata.LocalizedStringType;
import org.openhealthtools.ihe.xds.metadata.MetadataFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;

/**
 * <div class="de">Class XdsUtil.</div> <div class="fr"></div> <div
 * class="it"></div>
 */
public class XdsUtil {

	/**
	 * <div class="en">Convert code.</div> <div class="de"></div> <div
	 * class="fr"></div> <div class="it"></div>
	 * 
	 * @param code
	 * <br>
	 *          <div class="de"> code</div> <div class="fr"></div> <div
	 *          class="it"></div>
	 * @return the coded metadata type
	 */
	public static CodedMetadataType convertCode(Code code) {
		return createCodedMetadata(code.getCodeSystem(), code.getCode(), code.getDisplayName(), null);
	}

	/**
	 * <div class="en">Convert identificator.</div> <div class="de"></div> <div
	 * class="fr"></div> <div class="it"></div>
	 * 
	 * @param id
	 * <br>
	 *          <div class="de"> id</div> <div class="fr"></div> <div
	 *          class="it"></div>
	 * @return the cx
	 */
	public static CX convertIdentificator(Identificator id) {
		return createCx(id.getRoot(), id.getExtension());
	}

	/**
	 * <div class="en">Convert ii.</div> <div class="de"></div> <div
	 * class="fr"></div> <div class="it"></div>
	 * 
	 * @param ii
	 * <br>
	 *          <div class="de"> ii</div> <div class="fr"></div> <div
	 *          class="it"></div>
	 * @return the cx
	 */
	public static CX convertII(II ii) {
		return createCx(ii.getRoot(), ii.getExtension());
	}

	/**
	 * <div class="en">Creates the coded metadata.</div> <div class="de"></div>
	 * <div class="fr"></div> <div class="it"></div>
	 * 
	 * @param schemeName
	 * <br>
	 *          <div class="de"> scheme name</div> <div class="fr"></div> <div
	 *          class="it"> scheme name</div>
	 * @param code
	 * <br>
	 *          <div class="de"> code</div> <div class="fr"></div> <div
	 *          class="it"></div>
	 * @param displayName
	 * <br>
	 *          <div class="de"> display name</div> <div class="fr"></div> <div
	 *          class="it"></div>
	 * @param schemeUuid
	 * <br>
	 *          <div class="de"> scheme uuid</div> <div class="fr"></div> <div
	 *          class="it"></div>
	 * @return the coded metadata type
	 */
	public static CodedMetadataType createCodedMetadata(String schemeName, String code,
			String displayName, String schemeUuid) {
		CodedMetadataType cmt = MetadataFactory.eINSTANCE.createCodedMetadataType();

		cmt.setCode(code);
		if (displayName != null) {
			cmt.setDisplayName(createInternationalString(displayName));
		}
		if (schemeName != null) {
			cmt.setSchemeName(schemeName);
		}
		if (schemeUuid != null) {
			cmt.setSchemeUUID(schemeUuid);
		}

		return cmt;
	}

	/**
	 * <div class="en">Creates the cx.</div> <div class="de"></div> <div
	 * class="fr"></div> <div class="it"></div>
	 * 
	 * @param authorityId
	 * <br>
	 *          <div class="de"> authority id</div> <div class="fr"> authority
	 *          id</div> <div class="it"> authority id</div>
	 * @param id
	 * <br>
	 *          <div class="de"> id</div> <div class="fr"> id</div> <div
	 *          class="it"> id</div>
	 * @return the cx
	 */
	public static CX createCx(String authorityId, String id) {
		CX cx = Hl7v2Factory.eINSTANCE.createCX();
		cx.setAssigningAuthorityUniversalId(authorityId);
		cx.setIdNumber(id);
		cx.setAssigningAuthorityUniversalIdType("ISO");
		return cx;
	}

	/**
	 * <div class="en">Creates the international string.</div> <div
	 * class="de"></div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @param text
	 * <br>
	 *          <div class="de"> text</div> <div class="fr"> text</div> <div
	 *          class="it"> text</div>
	 * @return the org.openhealthtools.ihe.xds.metadata. international string type
	 */
	@SuppressWarnings("unchecked")
	public static org.openhealthtools.ihe.xds.metadata.InternationalStringType createInternationalString(
			String text) {
		org.openhealthtools.ihe.xds.metadata.InternationalStringType ist = MetadataFactory.eINSTANCE
				.createInternationalStringType();
		LocalizedStringType lst = MetadataFactory.eINSTANCE.createLocalizedStringType();
		lst.setValue(text);
		ist.getLocalizedString().add(lst);
		return ist;
	}
	
	public static  CodedMetadataType[] convertEhcCodeToCodedMetadataType(Code[] codeList) {
		if (codeList == null) return null;
		else {
			CodedMetadataType[] cmtArray = new CodedMetadataType[codeList.length];
			
			int i = 0;
			for (Code cme : codeList) {
				cmtArray[i] = XdsUtil.convertCode(cme);
				i++;
			}
			
			return cmtArray;
		}
	}
	
	public static CodedMetadataType[] convertEhcEnumToCodedMetadataType(CodedMetadataEnumInterface[] codedMetadataEnum) {
		if (codedMetadataEnum == null) return null;
		else {
			CodedMetadataType[] cmtArray = new CodedMetadataType[codedMetadataEnum.length];
			
			int i = 0;
			for (CodedMetadataEnumInterface cme : codedMetadataEnum) {
				cmtArray[i] = cme.getCodedMetadataType();
				i++;
			}
			
			return cmtArray;
		}
	}
	
	public static org.openhealthtools.ihe.xds.consumer.query.DateTimeRange[] convertEhcDateTimeRangeToOht(org.ehealth_connector.communication.storedquery.DateTimeRange[] dtr) {
		if (dtr == null) return null;
		else {
			org.openhealthtools.ihe.xds.consumer.query.DateTimeRange[] dtrArray = new org.openhealthtools.ihe.xds.consumer.query.DateTimeRange[dtr.length];
			
			int i = 0;
			for (org.ehealth_connector.communication.storedquery.DateTimeRange dt : dtr) {
				dtrArray[i] = dt.getOhtDateTimeRange();
				i++;
			}
			
			return dtrArray;
		}
	}
	
	public static XON convertEhcOrganization(Organization o) {
		XON xon = Hl7v2Factory.eINSTANCE.createXON();
		xon.setIdNumber(o.getId());
		xon.setOrganizationName(o.getName());
		return xon;
	}
}
