package com.symantec.partyservice.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the C_B_PRTY_ADDR database table.
 * 
 */
public class CBPrtyAddr extends SiperianSystemObjects implements Serializable {
	private static final long serialVersionUID = 1L;
	private String addrHashKey;
	private String addrLine1Txt;
	private String addrLine2Txt;
	private String addrLine3Txt;
	private String addrLine4Txt;
	private BigDecimal addrMailablScore;
	private String addrRsdlTxt;
	private String addrVldMsg;
	private String addrVldTypCd;
	private String addrVldTypCdFlg;
	private String carrRteTxt;
	private String cityNm;
	private String cntyNm;
	private String ctryIso2Cd;
	private String dwlngTypCd;
	private String latCd;
	private String locCoordDesc;
	private String lonCd;
	private String prtyRowid;
	private String pstlCd;
	private String pstlCdExtn;
	private String rawAddrPart1Txt;
	private String rawAddrPart2Txt;
	private String regsAddrFlg;
	private String stCd;
	private String stCtryIso2Cd;
	private String timeZnCd;
	private String useForPrtyMtchFlg;
	private String vrfyAddrFlg;
	private String srcSystem;
	private String addrPrtyId;

	public CBPrtyAddr() {
	}

	public String getAddrHashKey() {
		return addrHashKey;
	}

	public void setAddrHashKey(String addrHashKey) {
		this.addrHashKey = addrHashKey;
	}

	public String getAddrLine1Txt() {
		return addrLine1Txt;
	}

	public void setAddrLine1Txt(String addrLine1Txt) {
		this.addrLine1Txt = addrLine1Txt;
	}

	public String getAddrLine2Txt() {
		return addrLine2Txt;
	}

	public void setAddrLine2Txt(String addrLine2Txt) {
		this.addrLine2Txt = addrLine2Txt;
	}

	public String getAddrLine3Txt() {
		return addrLine3Txt;
	}

	public void setAddrLine3Txt(String addrLine3Txt) {
		this.addrLine3Txt = addrLine3Txt;
	}

	public String getAddrLine4Txt() {
		return addrLine4Txt;
	}

	public void setAddrLine4Txt(String addrLine4Txt) {
		this.addrLine4Txt = addrLine4Txt;
	}

	public BigDecimal getAddrMailablScore() {
		return addrMailablScore;
	}

	public void setAddrMailablScore(BigDecimal addrMailablScore) {
		this.addrMailablScore = addrMailablScore;
	}

	public String getAddrRsdlTxt() {
		return addrRsdlTxt;
	}

	public void setAddrRsdlTxt(String addrRsdlTxt) {
		this.addrRsdlTxt = addrRsdlTxt;
	}

	public String getAddrVldMsg() {
		return addrVldMsg;
	}

	public void setAddrVldMsg(String addrVldMsg) {
		this.addrVldMsg = addrVldMsg;
	}

	public String getAddrVldTypCd() {
		return addrVldTypCd;
	}

	public void setAddrVldTypCd(String addrVldTypCd) {
		this.addrVldTypCd = addrVldTypCd;
	}

	public String getAddrVldTypCdFlg() {
		return addrVldTypCdFlg;
	}

	public void setAddrVldTypCdFlg(String addrVldTypCdFlg) {
		this.addrVldTypCdFlg = addrVldTypCdFlg;
	}

	public String getCarrRteTxt() {
		return carrRteTxt;
	}

	public void setCarrRteTxt(String carrRteTxt) {
		this.carrRteTxt = carrRteTxt;
	}

	public String getCityNm() {
		return cityNm;
	}

	public void setCityNm(String cityNm) {
		this.cityNm = cityNm;
	}

	public String getCntyNm() {
		return cntyNm;
	}

	public void setCntyNm(String cntyNm) {
		this.cntyNm = cntyNm;
	}

	public String getCtryIso2Cd() {
		return ctryIso2Cd;
	}

	public void setCtryIso2Cd(String ctryIso2Cd) {
		this.ctryIso2Cd = ctryIso2Cd;
	}

	public String getDwlngTypCd() {
		return dwlngTypCd;
	}

	public void setDwlngTypCd(String dwlngTypCd) {
		this.dwlngTypCd = dwlngTypCd;
	}

	public String getLatCd() {
		return latCd;
	}

	public void setLatCd(String latCd) {
		this.latCd = latCd;
	}

	public String getLocCoordDesc() {
		return locCoordDesc;
	}

	public void setLocCoordDesc(String locCoordDesc) {
		this.locCoordDesc = locCoordDesc;
	}

	public String getLonCd() {
		return lonCd;
	}

	public void setLonCd(String lonCd) {
		this.lonCd = lonCd;
	}

	public String getPrtyRowid() {
		return prtyRowid;
	}

	public void setPrtyRowid(String prtyRowid) {
		this.prtyRowid = prtyRowid;
	}

	public String getPstlCd() {
		return pstlCd;
	}

	public void setPstlCd(String pstlCd) {
		this.pstlCd = pstlCd;
	}

	public String getPstlCdExtn() {
		return pstlCdExtn;
	}

	public void setPstlCdExtn(String pstlCdExtn) {
		this.pstlCdExtn = pstlCdExtn;
	}

	public String getRawAddrPart1Txt() {
		return rawAddrPart1Txt;
	}

	public void setRawAddrPart1Txt(String rawAddrPart1Txt) {
		this.rawAddrPart1Txt = rawAddrPart1Txt;
	}

	public String getRawAddrPart2Txt() {
		return rawAddrPart2Txt;
	}

	public void setRawAddrPart2Txt(String rawAddrPart2Txt) {
		this.rawAddrPart2Txt = rawAddrPart2Txt;
	}

	public String getRegsAddrFlg() {
		return regsAddrFlg;
	}

	public void setRegsAddrFlg(String regsAddrFlg) {
		this.regsAddrFlg = regsAddrFlg;
	}

	public String getStCd() {
		return stCd;
	}

	public void setStCd(String stCd) {
		this.stCd = stCd;
	}

	public String getStCtryIso2Cd() {
		return stCtryIso2Cd;
	}

	public void setStCtryIso2Cd(String stCtryIso2Cd) {
		this.stCtryIso2Cd = stCtryIso2Cd;
	}

	public String getTimeZnCd() {
		return timeZnCd;
	}

	public void setTimeZnCd(String timeZnCd) {
		this.timeZnCd = timeZnCd;
	}

	public String getUseForPrtyMtchFlg() {
		return useForPrtyMtchFlg;
	}

	public void setUseForPrtyMtchFlg(String useForPrtyMtchFlg) {
		this.useForPrtyMtchFlg = useForPrtyMtchFlg;
	}

	public String getVrfyAddrFlg() {
		return vrfyAddrFlg;
	}

	public void setVrfyAddrFlg(String vrfyAddrFlg) {
		this.vrfyAddrFlg = vrfyAddrFlg;
	}

	public String getSrcSystem() {
		return srcSystem;
	}

	public void setSrcSystem(String srcSystem) {
		this.srcSystem = srcSystem;
	}

	public String getAddrPrtyId() {
		return addrPrtyId;
	}

	public void setAddrPrtyId(String addrPrtyId) {
		this.addrPrtyId = addrPrtyId;
	}

	@Override
	public String toString() {
		return "CBPrtyAddr [addrHashKey=" + addrHashKey + ", addrLine1Txt="
				+ addrLine1Txt + ", addrLine2Txt=" + addrLine2Txt
				+ ", addrLine3Txt=" + addrLine3Txt + ", addrLine4Txt="
				+ addrLine4Txt + ", addrMailablScore=" + addrMailablScore
				+ ", addrRsdlTxt=" + addrRsdlTxt + ", addrVldMsg=" + addrVldMsg
				+ ", addrVldTypCd=" + addrVldTypCd + ", addrVldTypCdFlg="
				+ addrVldTypCdFlg + ", carrRteTxt=" + carrRteTxt + ", cityNm="
				+ cityNm + ", cntyNm=" + cntyNm + ", ctryIso2Cd=" + ctryIso2Cd
				+ ", dwlngTypCd=" + dwlngTypCd + ", latCd=" + latCd
				+ ", locCoordDesc=" + locCoordDesc + ", lonCd=" + lonCd
				+ ", prtyRowid=" + prtyRowid + ", pstlCd=" + pstlCd
				+ ", pstlCdExtn=" + pstlCdExtn + ", rawAddrPart1Txt="
				+ rawAddrPart1Txt + ", rawAddrPart2Txt=" + rawAddrPart2Txt
				+ ", regsAddrFlg=" + regsAddrFlg + ", stCd=" + stCd
				+ ", stCtryIso2Cd=" + stCtryIso2Cd + ", timeZnCd=" + timeZnCd
				+ ", useForPrtyMtchFlg=" + useForPrtyMtchFlg + ", vrfyAddrFlg="
				+ vrfyAddrFlg + ", srcSystem=" + srcSystem + ", addrPrtyId="
				+ addrPrtyId + "]";
	}

	
}