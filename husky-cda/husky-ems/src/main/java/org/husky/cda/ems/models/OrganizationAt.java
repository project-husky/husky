package org.husky.cda.ems.models;

import org.husky.common.basetypes.OrganizationBaseType;
import org.husky.common.hl7cdar2.POCDMT000040Custodian;
import org.husky.common.model.Organization;

public class OrganizationAt extends Organization {

	public OrganizationAt(OrganizationBaseType baseType) {
		super(baseType);
	}

	public POCDMT000040Custodian createHeaderCustodian() {
		POCDMT000040Custodian cust = getHl7CdaR2Pocdmt000040Custodian();
		cust.getTypeCode().add("CST");
		cust.getAssignedCustodian().setClassCode("ASSIGNED");
		cust.getAssignedCustodian().getRepresentedCustodianOrganization().setClassCode("ORG");
		cust.getAssignedCustodian().getRepresentedCustodianOrganization().setDeterminerCode("INSTANCE");

		return cust;
	}

}
