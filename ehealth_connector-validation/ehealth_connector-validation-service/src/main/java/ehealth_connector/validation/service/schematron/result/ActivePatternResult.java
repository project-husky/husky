package ehealth_connector.validation.service.schematron.result;

import java.util.ArrayList;
import java.util.List;

import ehealth_connector.validation.service.schematron.bind.ActivePattern;

public class ActivePatternResult {
	
	private ActivePattern ap;
	//private String id;
	//private String name;
	private List<FiredRuleResult> firedRuleList;
	
	public ActivePatternResult() {
		firedRuleList = new ArrayList<FiredRuleResult>(); 
	}
	public ActivePattern getAp() {
		return ap;
	}
	public void setAp(ActivePattern ap) {
		this.ap = ap;
	}
	public String getId() {
		return ap.getId();
	}
	public void setId(String id) {
		ap.setId(id);
	}
	public String getName() {
		return ap.getName();
	}
	public void setName(String name) {
		ap.setName(name);
	}
	public List<FiredRuleResult> getFiredRileList() {
		return firedRuleList;
	}
	public void setFiredRileList(List<FiredRuleResult> firedRuleList) {
		this.firedRuleList = firedRuleList;
	}


}
