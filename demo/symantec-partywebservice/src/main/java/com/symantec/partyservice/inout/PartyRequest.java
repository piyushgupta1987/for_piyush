package com.symantec.partyservice.inout;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;

import com.symantec.partyservice.pojo.CBOutbdRealTrigr;
import com.symantec.partyservice.pojo.CBPrty;
import com.symantec.partyservice.pojo.CBPrtyAddr;
import com.symantec.partyservice.pojo.CBPrtyNm;
import com.symantec.partyservice.pojo.CBSrcSysRefDtls;


public class PartyRequest {

	private CBPrty party;

	private CBPrtyAddr address;

	private CBPrtyNm prtyname;

	private CBSrcSysRefDtls srcsysrefdtls;
	
	//private CBOutbdRealTrigr outbdrealtrigr;
	
	public CBPrty getParty() {
		return party;
	}

	public CBPrtyAddr getAddress() {
		return address;
	}

	public void setAddress(CBPrtyAddr address) {
		this.address = address;
	}

	public CBPrtyNm getPrtyname() {
		return prtyname;
	}

	public void setPrtyname(CBPrtyNm prtyname) {
		this.prtyname = prtyname;
	}

	public CBSrcSysRefDtls getSrcsysrefdtls() {
		return srcsysrefdtls;
	}

	public void setSrcsysrefdtls(CBSrcSysRefDtls srcsysrefdtls) {
		this.srcsysrefdtls = srcsysrefdtls;
	}

	/*public CBOutbdRealTrigr getOutbdrealtrigr() {
		return outbdrealtrigr;
	}

	public void setOutbdrealtrigr(CBOutbdRealTrigr outbdrealtrigr) {
		this.outbdrealtrigr = outbdrealtrigr;
	}*/

	public void setParty(CBPrty party) {
		this.party = party;
	}

	@Override
	public String toString() {
		return "PartyRequest [party=" + party + ", address=" + address
				+ ", prtyname=" + prtyname + ", srcsysrefdtls=" + srcsysrefdtls
				+ "]";
	}

	/*@Override
	public String toString() {
		return "PartyRequest [party=" + party + ", address=" + address
				+ ", prtyname=" + prtyname + ", srcsysrefdtls=" + srcsysrefdtls
				+ ", outbdrealtrigr=" + outbdrealtrigr + "]";
	}*/

	
	
}
