package com.symantec.partyservice.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the C_O_OUTBD_REAL_TRIGR database table.
 * 
 */
public class CBOutbdRealTrigr extends SiperianSystemObjects implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String srcSysNm;
	private String actionType;
	private String sysOrig;
	private String prtyCrId;
	
	
	public CBOutbdRealTrigr() {
	}

	
	public String getSrcSysNm() {
		return srcSysNm;
	}


	public void setSrcSysNm(String srcSysNm) {
		this.srcSysNm = srcSysNm;
	}


	public String getActionType() {
		return actionType;
	}


	public void setActionType(String actionType) {
		this.actionType = actionType;
	}


	public String getSysOrig() {
		return sysOrig;
	}


	public void setSysOrig(String sysOrig) {
		this.sysOrig = sysOrig;
	}


	public String getPrtyCrId() {
		return prtyCrId;
	}


	public void setPrtyCrId(String prtyCrId) {
		this.prtyCrId = prtyCrId;
	}


	@Override
	public String toString() {
		return "CBOutbdRealTrigr [srcSysNm=" + srcSysNm + ", actionType="
				+ actionType + ", sysOrig=" + sysOrig + ", prtyCrId="
				+ prtyCrId + "]";
	}


	


}