package org.ehc.common;

import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/**
 * Utility class for creating StatusCodes.
 * 
 * @author gsc
 */
public class CSUtil {

	private CSUtil() {}
	
	/**
	 * Returns "completed" statusCode.
	 * 
	 * @return CS - statusCode.
	 */
	public static CS completed() {
		return createStatus("completed");
	}
	
	private static CS createStatus(String code) {
		CS cs = DatatypesFactory.eINSTANCE.createCS();
		cs.setCode(code);
		return cs;
	}
	
}

