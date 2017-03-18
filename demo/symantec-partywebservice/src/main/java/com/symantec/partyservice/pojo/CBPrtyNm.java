package com.symantec.partyservice.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the C_B_PRTY_NM database table.
 * 
 */
public class CBPrtyNm extends SiperianSystemObjects implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nmTypCd;
	private String prtyMtchKeyAttr;
	private String prtyNm;
	private String prtyRowid;
	private String rawPrtyNm;
	private String srcSystem;
	
	public CBPrtyNm() {
	}

	public String getNmTypCd() {
		return nmTypCd;
	}

	public void setNmTypCd(String nmTypCd) {
		this.nmTypCd = nmTypCd;
	}

	public String getPrtyMtchKeyAttr() {
		return prtyMtchKeyAttr;
	}

	public void setPrtyMtchKeyAttr(String prtyMtchKeyAttr) {
		this.prtyMtchKeyAttr = prtyMtchKeyAttr;
	}

	public String getPrtyNm() {
		return prtyNm;
	}

	public void setPrtyNm(String prtyNm) {
		this.prtyNm = prtyNm;
	}

	public String getPrtyRowid() {
		return prtyRowid;
	}

	public void setPrtyRowid(String prtyRowid) {
		this.prtyRowid = prtyRowid;
	}

	public String getRawPrtyNm() {
		return rawPrtyNm;
	}

	public void setRawPrtyNm(String rawPrtyNm) {
		this.rawPrtyNm = rawPrtyNm;
	}
	public String getSrcSystem() {
		return srcSystem;
	}
	public void setSrcSystem(String srcSystem) {
		this.srcSystem = srcSystem;
	}

	@Override
	public String toString() {
		return "CBPrtyNm [nmTypCd=" + nmTypCd + ", prtyMtchKeyAttr="
				+ prtyMtchKeyAttr + ", prtyNm=" + prtyNm + ", prtyRowid="
				+ prtyRowid + ", rawPrtyNm=" + rawPrtyNm + ", srcSystem="
				+ srcSystem + "]";
	}


}