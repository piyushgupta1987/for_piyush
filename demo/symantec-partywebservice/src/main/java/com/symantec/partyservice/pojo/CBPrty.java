package com.symantec.partyservice.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the C_B_PRTY database table.
 * 
 */
public class CBPrty extends SiperianSystemObjects implements Serializable {
	private static final long serialVersionUID = 1L;
	private String rowidObject;
	private String blklstFlg;
	private String creditRatingCd;
	private String dnbFlg;
	private String dontShrExtrFlg;
	private String dontShrIntrnlFlg;
	private String imPrtyFlg;
	private String isPrtyFlg;
	private BigDecimal mbrCnt;
	private String optOutFlg;
	private String outOfBusnFlg;
	private String partySubtypeClassCd;
	private String prtyDesc;
	private String prtyFullNm;
	private String prtyNum;
	private String prtyStsCd;
	private String recvPtnrCntctFlg;
	private String prtyFdtnDt;
	private String prtyFstPrchDt;
	private String srcSystem;

	public CBPrty() {
	}

	public String getRowidObject() {
		return rowidObject;
	}

	public void setRowidObject(String rowidObject) {
		this.rowidObject = rowidObject;
	}

	public String getBlklstFlg() {
		return blklstFlg;
	}

	public void setBlklstFlg(String blklstFlg) {
		this.blklstFlg = blklstFlg;
	}

	public String getCreditRatingCd() {
		return creditRatingCd;
	}

	public void setCreditRatingCd(String creditRatingCd) {
		this.creditRatingCd = creditRatingCd;
	}

	public String getDnbFlg() {
		return dnbFlg;
	}

	public void setDnbFlg(String dnbFlg) {
		this.dnbFlg = dnbFlg;
	}

	public String getDontShrExtrFlg() {
		return dontShrExtrFlg;
	}

	public void setDontShrExtrFlg(String dontShrExtrFlg) {
		this.dontShrExtrFlg = dontShrExtrFlg;
	}

	public String getDontShrIntrnlFlg() {
		return dontShrIntrnlFlg;
	}

	public void setDontShrIntrnlFlg(String dontShrIntrnlFlg) {
		this.dontShrIntrnlFlg = dontShrIntrnlFlg;
	}

	public String getImPrtyFlg() {
		return imPrtyFlg;
	}

	public void setImPrtyFlg(String imPrtyFlg) {
		this.imPrtyFlg = imPrtyFlg;
	}

	public String getIsPrtyFlg() {
		return isPrtyFlg;
	}

	public void setIsPrtyFlg(String isPrtyFlg) {
		this.isPrtyFlg = isPrtyFlg;
	}

	public BigDecimal getMbrCnt() {
		return mbrCnt;
	}

	public void setMbrCnt(BigDecimal mbrCnt) {
		this.mbrCnt = mbrCnt;
	}

	public String getOptOutFlg() {
		return optOutFlg;
	}

	public void setOptOutFlg(String optOutFlg) {
		this.optOutFlg = optOutFlg;
	}

	public String getOutOfBusnFlg() {
		return outOfBusnFlg;
	}

	public void setOutOfBusnFlg(String outOfBusnFlg) {
		this.outOfBusnFlg = outOfBusnFlg;
	}

	public String getPartySubtypeClassCd() {
		return partySubtypeClassCd;
	}

	public void setPartySubtypeClassCd(String partySubtypeClassCd) {
		this.partySubtypeClassCd = partySubtypeClassCd;
	}

	public String getPrtyDesc() {
		return prtyDesc;
	}

	public void setPrtyDesc(String prtyDesc) {
		this.prtyDesc = prtyDesc;
	}

	public String getPrtyFullNm() {
		return prtyFullNm;
	}

	public void setPrtyFullNm(String prtyFullNm) {
		this.prtyFullNm = prtyFullNm;
	}

	public String getPrtyNum() {
		return prtyNum;
	}

	public void setPrtyNum(String prtyNum) {
		this.prtyNum = prtyNum;
	}

	public String getPrtyStsCd() {
		return prtyStsCd;
	}

	public void setPrtyStsCd(String prtyStsCd) {
		this.prtyStsCd = prtyStsCd;
	}

	public String getRecvPtnrCntctFlg() {
		return recvPtnrCntctFlg;
	}

	public void setRecvPtnrCntctFlg(String recvPtnrCntctFlg) {
		this.recvPtnrCntctFlg = recvPtnrCntctFlg;
	}

	public String getPrtyFdtnDt() {
		return prtyFdtnDt;
	}

	public void setPrtyFdtnDt(String prtyFdtnDt) {
		this.prtyFdtnDt = prtyFdtnDt;
	}

	public String getPrtyFstPrchDt() {
		return prtyFstPrchDt;
	}

	public void setPrtyFstPrchDt(String prtyFstPrchDt) {
		this.prtyFstPrchDt = prtyFstPrchDt;
	}

	public String getSrcSystem() {
		return srcSystem;
	}
	public void setSrcSystem(String srcSystem) {
		this.srcSystem = srcSystem;
	}

	@Override
	public String toString() {
		return "CBPrty [rowidObject=" + rowidObject + ", blklstFlg="
				+ blklstFlg + ", creditRatingCd=" + creditRatingCd
				+ ", dnbFlg=" + dnbFlg + ", dontShrExtrFlg=" + dontShrExtrFlg
				+ ", dontShrIntrnlFlg=" + dontShrIntrnlFlg + ", imPrtyFlg="
				+ imPrtyFlg + ", isPrtyFlg=" + isPrtyFlg + ", mbrCnt=" + mbrCnt
				+ ", optOutFlg=" + optOutFlg + ", outOfBusnFlg=" + outOfBusnFlg
				+ ", partySubtypeClassCd=" + partySubtypeClassCd
				+ ", prtyDesc=" + prtyDesc + ", prtyFullNm=" + prtyFullNm
				+ ", prtyNum=" + prtyNum + ", prtyStsCd=" + prtyStsCd
				+ ", recvPtnrCntctFlg=" + recvPtnrCntctFlg + ", prtyFdtnDt="
				+ prtyFdtnDt + ", prtyFstPrchDt=" + prtyFstPrchDt
				+ ", srcSystem=" + srcSystem + "]";
	}
}