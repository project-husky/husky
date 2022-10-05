package org.projecthusky.common.at;

import org.projecthusky.common.basetypes.OrganizationBaseType;
import org.projecthusky.common.hl7cdar2.POCDMT000040Custodian;
import org.projecthusky.common.hl7cdar2.POCDMT000040Organization;
import org.projecthusky.common.model.Organization;

public class OrganizationAt extends Organization {

	public OrganizationAt(OrganizationBaseType baseType) {
		super(baseType);
	}

	public OrganizationAt(POCDMT000040Organization org) {
		super(org);
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
