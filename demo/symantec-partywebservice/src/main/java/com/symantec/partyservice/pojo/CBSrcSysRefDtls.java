package com.symantec.partyservice.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the C_B_SRC_SYS_REF_DTLS database table.
 * 
 */

public class CBSrcSysRefDtls extends SiperianSystemObjects implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private String erpCustActId;
	private String erpCustActSiteId;
	private String erpCustActSiteOrgId;
	private String erpCustActSiteStsCd;
	private String erpLocationId;
	private String erpPrtyId;
	private String erpPrtySiteId;
	private String erpPrtySiteNum;
	private String erpPrtySiteStsCd;
	private String primFlg;
	private String prtyRowid;
	private String sfdcActId;
	private String sfdcActStsCd;
	private String sfdcAxaptaId;
	private String sfdcCntctId;
	private String sfdcRecType;
	private String sfdcSobjectType;
	private String srcPkId;
	private String srcSystem;
	private String erpSlsChnlCd;

	
	public CBSrcSysRefDtls() {
    }


	public String getErpCustActId() {
		return erpCustActId;
	}


	public void setErpCustActId(String erpCustActId) {
		this.erpCustActId = erpCustActId;
	}


	public String getErpCustActSiteId() {
		return erpCustActSiteId;
	}


	public void setErpCustActSiteId(String erpCustActSiteId) {
		this.erpCustActSiteId = erpCustActSiteId;
	}


	public String getErpCustActSiteOrgId() {
		return erpCustActSiteOrgId;
	}


	public void setErpCustActSiteOrgId(String erpCustActSiteOrgId) {
		this.erpCustActSiteOrgId = erpCustActSiteOrgId;
	}


	public String getErpCustActSiteStsCd() {
		return erpCustActSiteStsCd;
	}


	public void setErpCustActSiteStsCd(String erpCustActSiteStsCd) {
		this.erpCustActSiteStsCd = erpCustActSiteStsCd;
	}


	public String getErpLocationId() {
		return erpLocationId;
	}


	public void setErpLocationId(String erpLocationId) {
		this.erpLocationId = erpLocationId;
	}


	public String getErpPrtyId() {
		return erpPrtyId;
	}


	public void setErpPrtyId(String erpPrtyId) {
		this.erpPrtyId = erpPrtyId;
	}


	public String getErpPrtySiteId() {
		return erpPrtySiteId;
	}


	public void setErpPrtySiteId(String erpPrtySiteId) {
		this.erpPrtySiteId = erpPrtySiteId;
	}


	public String getErpPrtySiteNum() {
		return erpPrtySiteNum;
	}


	public void setErpPrtySiteNum(String erpPrtySiteNum) {
		this.erpPrtySiteNum = erpPrtySiteNum;
	}


	public String getErpPrtySiteStsCd() {
		return erpPrtySiteStsCd;
	}


	public void setErpPrtySiteStsCd(String erpPrtySiteStsCd) {
		this.erpPrtySiteStsCd = erpPrtySiteStsCd;
	}


	public String getPrimFlg() {
		return primFlg;
	}


	public void setPrimFlg(String primFlg) {
		this.primFlg = primFlg;
	}


	public String getPrtyRowid() {
		return prtyRowid;
	}


	public void setPrtyRowid(String prtyRowid) {
		this.prtyRowid = prtyRowid;
	}


	public String getSfdcActId() {
		return sfdcActId;
	}


	public void setSfdcActId(String sfdcActId) {
		this.sfdcActId = sfdcActId;
	}


	public String getSfdcActStsCd() {
		return sfdcActStsCd;
	}


	public void setSfdcActStsCd(String sfdcActStsCd) {
		this.sfdcActStsCd = sfdcActStsCd;
	}


	public String getSfdcAxaptaId() {
		return sfdcAxaptaId;
	}


	public void setSfdcAxaptaId(String sfdcAxaptaId) {
		this.sfdcAxaptaId = sfdcAxaptaId;
	}


	public String getSfdcCntctId() {
		return sfdcCntctId;
	}


	public void setSfdcCntctId(String sfdcCntctId) {
		this.sfdcCntctId = sfdcCntctId;
	}


	public String getSfdcRecType() {
		return sfdcRecType;
	}


	public void setSfdcRecType(String sfdcRecType) {
		this.sfdcRecType = sfdcRecType;
	}


	public String getSfdcSobjectType() {
		return sfdcSobjectType;
	}


	public void setSfdcSobjectType(String sfdcSobjectType) {
		this.sfdcSobjectType = sfdcSobjectType;
	}


	public String getSrcPkId() {
		return srcPkId;
	}


	public void setSrcPkId(String srcPkId) {
		this.srcPkId = srcPkId;
	}


	public String getSrcSystem() {
		return srcSystem;
	}


	public void setSrcSystem(String srcSystem) {
		this.srcSystem = srcSystem;
	}


	public String getErpSlsChnlCd() {
		return erpSlsChnlCd;
	}


	public void setErpSlsChnlCd(String erpSlsChnlCd) {
		this.erpSlsChnlCd = erpSlsChnlCd;
	}


	@Override
	public String toString() {
		return "CBSrcSysRefDtls [erpCustActId=" + erpCustActId
				+ ", erpCustActSiteId=" + erpCustActSiteId
				+ ", erpCustActSiteOrgId=" + erpCustActSiteOrgId
				+ ", erpCustActSiteStsCd=" + erpCustActSiteStsCd
				+ ", erpLocationId=" + erpLocationId + ", erpPrtyId="
				+ erpPrtyId + ", erpPrtySiteId=" + erpPrtySiteId
				+ ", erpPrtySiteNum=" + erpPrtySiteNum + ", erpPrtySiteStsCd="
				+ erpPrtySiteStsCd + ", primFlg=" + primFlg + ", prtyRowid="
				+ prtyRowid + ", sfdcActId=" + sfdcActId + ", sfdcActStsCd="
				+ sfdcActStsCd + ", sfdcAxaptaId=" + sfdcAxaptaId
				+ ", sfdcCntctId=" + sfdcCntctId + ", sfdcRecType="
				+ sfdcRecType + ", sfdcSobjectType=" + sfdcSobjectType
				+ ", srcPkId=" + srcPkId + ", srcSystem=" + srcSystem
				+ ", erpSlsChnlCd=" + erpSlsChnlCd + "]";
	}


}