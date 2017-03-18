package com.symantec.partyservice.inout;

public class PartyResponse {

	private String rowidObject;

	public String getRowidObject() {
		return rowidObject;
	}

	public void setRowidObject(String rowidObject) {
		this.rowidObject = rowidObject;
	}

	@Override
	public String toString() {
		return "PartyResponse [rowidObject=" + rowidObject + "]";
	}
	
	
}
