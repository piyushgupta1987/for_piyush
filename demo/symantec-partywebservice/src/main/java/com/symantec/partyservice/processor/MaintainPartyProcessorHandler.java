//================================================
//Project: MDM Create Service
// By:  Piyush Gupta (Informatica Corp.)
//================================================

package com.symantec.partyservice.processor;

import org.apache.log4j.Logger;

import com.siperian.common.util.StringUtil;
import com.siperian.sif.client.SiperianClient;
import com.siperian.sif.message.Field;
import com.symantec.partyservice.exception.IncorrectRequest;
import com.symantec.partyservice.exception.PersistanceException;
import com.symantec.partyservice.exception.SiperianConnectionException;
import com.symantec.partyservice.inout.PartyRequest;
import com.symantec.partyservice.inout.PartyResponse;
import com.symantec.partyservice.pojo.CBOutbdRealTrigr;
import com.symantec.partyservice.pojo.CBPrty;
import com.symantec.partyservice.pojo.CBPrtyAddr;
import com.symantec.partyservice.pojo.CBPrtyNm;
import com.symantec.partyservice.pojo.CBSrcSysRefDtls;
import com.symantec.partyservice.pojo.MdmCredential;
import com.symantec.partyservice.pojo.UserDefinedSrckey;
import com.symantec.partyservice.utility.SymantecSIPClient;

public class MaintainPartyProcessorHandler {
	MaintainPartyProcessor processor;
	SiperianClient sc;
	Logger log = Logger.getLogger(getClass().getName());
	//constructor
	public MaintainPartyProcessorHandler() {
	}
	/**
	 * 
	 * @param partyRequest
	 * @return
	 * @throws PersistanceException
	 * @throws SiperianConnectionException
	 * depricated this because doPutV2(arg) is covering all the functionality
	 */
	@Deprecated
	public PartyResponse doPut(PartyRequest partyRequest)
			throws PersistanceException, SiperianConnectionException {
		try {
			processor = new MaintainPartyProcessor();
			sc = new SymantecSIPClient().getEjbSiperianClientTEST();
		} catch (Exception e) {
			throw new SiperianConnectionException("not got the sif connection");
		}
		CBPrty party = partyRequest.getParty();
		CBPrtyAddr address = partyRequest.getAddress();
		CBPrtyNm partyNames = partyRequest.getPrtyname();
		log.info("Going to start saveParty");
		String partyRowIdObj = processor.saveParty(party, sc);
		if (partyRowIdObj != null) {
			address.setPrtyRowid(partyRowIdObj);
			address.setSrcSystem(party.getSrcSystem());
			log.info("Going to start saveAddress");
			processor.saveAddress(address, sc);
			partyNames.setPrtyRowid(partyRowIdObj);
			partyNames.setSrcSystem(party.getSrcSystem());
			log.info("Going to start savepartyName");
			processor.savePartyName(partyNames, sc);
		} else {
			throw new PersistanceException("Party is not able to save");
		}
		PartyResponse res = new PartyResponse();
		res.setRowidObject(partyRowIdObj);
		return res;
	}
	
	/**
	 * 
	 * @param partyRequest
	 * @return
	 * @throws SiperianConnectionException
	 * 
	 * depricated this because doPutV3(arg0, arg1) is covering all the functionality
	 */
	@Deprecated
	public PartyResponse doPutV2(PartyRequest partyRequest)
			throws SiperianConnectionException {
		try {
			processor = new MaintainPartyProcessor();
			sc = new SymantecSIPClient().getEjbSiperianClientTEST();
		} catch (Exception e) {
			throw new SiperianConnectionException("not got the sif connection");
		}
		PartyResponse res = new PartyResponse();
		CBPrty party = partyRequest.getParty();
		CBPrtyAddr address = partyRequest.getAddress();
		CBPrtyNm partyNames = partyRequest.getPrtyname();
		CBSrcSysRefDtls srcSysRefDtls = partyRequest.getSrcsysrefdtls();
		if (party.getRowidObject() != null
				&& !StringUtil.isEmpty(party.getRowidObject())) {
			processor.saveParty(party, sc);
			address.setPrtyRowid(party.getRowidObject());
			address.setSrcSystem(party.getSrcSystem());
			processor.saveAddress(address, sc);
			partyNames.setPrtyRowid(party.getRowidObject());
			partyNames.setSrcSystem(party.getSrcSystem());
			processor.savePartyName(partyNames, sc);
			srcSysRefDtls.setPrtyRowid(party.getRowidObject());
			srcSysRefDtls.setSrcSystem(party.getSrcSystem());
			processor.saveSrcSysRefDtls(srcSysRefDtls, sc);
			res.setRowidObject(party.getRowidObject());
		} else {
			String partyRowIdObj = processor.saveParty(party, sc);
			address.setPrtyRowid(partyRowIdObj);
			address.setSrcSystem(party.getSrcSystem());
			processor.saveAddress(address, sc);
			partyNames.setPrtyRowid(partyRowIdObj);
			partyNames.setSrcSystem(party.getSrcSystem());
			processor.savePartyName(partyNames, sc);
			res.setRowidObject(partyRowIdObj);
		}
		return res;
	}

	/**
	 * 
	 * @param partyRequest
	 * @param mdmCredential
	 * @return
	 * @throws SiperianConnectionException
	 * @throws IncorrectRequest
	 * 
	 * This method is handling the mdmhub credential, and fulfilling the further req for this service 
	 */
	public PartyResponse doPutV3(PartyRequest partyRequest, MdmCredential mdmCredential)
			throws SiperianConnectionException, IncorrectRequest {
		log.info("entering doPut3");
		try {
			processor = new MaintainPartyProcessor();
			//sc = new SymantecSIPClient().getEjbSiperianClientTEST();
			log.debug("Trying to get the sif object");
			sc = new SymantecSIPClient().getEjbSifClient(mdmCredential);
			log.debug("GOT the sif object");
		} catch (Exception e) {
			log.error("Exception occur during invocking the sif connection ");
			throw new SiperianConnectionException("not got the sif connection");
		}

		PartyResponse res = new PartyResponse();
		CBPrty party = partyRequest.getParty();
		CBPrtyAddr address = partyRequest.getAddress();
		CBPrtyNm partyNames = partyRequest.getPrtyname();
		CBSrcSysRefDtls srcSysRefDtls = partyRequest.getSrcsysrefdtls();

		if (party.getRowidObject() != null
				&& !StringUtil.isEmpty(party.getRowidObject()) && !"".equals(party.getRowidObject())) {
			log.info("entered if loop for record with rowid_object");
			UserDefinedSrckey userDefSrcKey = genSrckey(partyRequest);
			party.setPkeySrcObject(userDefSrcKey.getPrtySrcKey());
			processor.saveParty(party, sc);
			address.setPrtyRowid(party.getRowidObject());
			address.setSrcSystem(party.getSrcSystem());
			address.setPkeySrcObject(userDefSrcKey.getAddrSrcKey());
			processor.saveAddress(address, sc);
			partyNames.setPrtyRowid(party.getRowidObject());
			partyNames.setSrcSystem(party.getSrcSystem());
			partyNames.setPkeySrcObject(userDefSrcKey.getPrtyNmSrcKey());
			processor.savePartyName(partyNames, sc);
			srcSysRefDtls.setPrtyRowid(party.getRowidObject());
			srcSysRefDtls.setSrcSystem(party.getSrcSystem());
			srcSysRefDtls.setPkeySrcObject(userDefSrcKey.getSrcSysRefSrcKey());
			processor.saveSrcSysRefDtls(srcSysRefDtls, sc);
			
			CBOutbdRealTrigr cbOutbdRealTrigr=new CBOutbdRealTrigr();
			//cbOutbdRealTrigr.
			cbOutbdRealTrigr.setSrcSysNm(party.getSrcSystem());
			cbOutbdRealTrigr.setActionType("UPDATE");
			cbOutbdRealTrigr.setSysOrig("UI");
			cbOutbdRealTrigr.setPrtyCrId(party.getRowidObject());
			
			processor.saveOutbdRealTrigr(cbOutbdRealTrigr, sc);
			
			res.setRowidObject(party.getRowidObject());
		} else {
			log.info("entered else loop for record without rowid_object");
			party.setPkeySrcObject(null);
			String partyRowIdObj = processor.saveParty(party, sc);
			address.setPrtyRowid(partyRowIdObj);
			address.setSrcSystem(party.getSrcSystem());
			address.setPkeySrcObject(null);
			processor.saveAddress(address, sc);
			partyNames.setPrtyRowid(partyRowIdObj);
			partyNames.setSrcSystem(party.getSrcSystem());
			partyNames.setPkeySrcObject(null);
			processor.savePartyName(partyNames, sc);
			res.setRowidObject(partyRowIdObj);
		}
		return res;
	}

	public UserDefinedSrckey genSrckey(PartyRequest partyrequest)
			throws IncorrectRequest {

		UserDefinedSrckey userDefinedSrckey = new UserDefinedSrckey();

		CBPrty prty = partyrequest.getParty();
		CBPrtyAddr addr = partyrequest.getAddress();
		CBSrcSysRefDtls srcsysdtls = partyrequest.getSrcsysrefdtls();

		String source = prty.getSrcSystem();
		String class_cd = prty.getPartySubtypeClassCd();
		String sfdc_id = srcsysdtls.getSfdcActId();
		String erp_id = srcsysdtls.getErpCustActSiteId();
		String erp_addr_prty_id = addr.getAddrPrtyId();

		String prtySrcKey = "";
		String sFDC_Addr_Cont = "Y|BILL_TO";

		String src_Sys_Cont = "PRTY_SRS_SYS_REF";
		String prty_Nm_Cont = "PARTY_NM";

		String addrSrcKey = "";
		String prtyNmSrcKey = "";
		String srcSysRefSrcKey = "";

		if ("ERP".equals(source) && class_cd != null && erp_id != null) {
			userDefinedSrckey.setPrtySrcKey(source + "|" + class_cd + "|"
					+ erp_id);
			userDefinedSrckey.setAddrSrcKey(userDefinedSrckey.getPrtySrcKey()
					+ "|Y|" + erp_addr_prty_id);
			userDefinedSrckey.setPrtyNmSrcKey(userDefinedSrckey.getPrtySrcKey()
					+ "|" + prty_Nm_Cont);
			userDefinedSrckey.setSrcSysRefSrcKey(userDefinedSrckey
					.getPrtySrcKey() + "|" + src_Sys_Cont);
		} else if ("SFDC".equals(source) && class_cd != null && sfdc_id != null) {
			userDefinedSrckey.setPrtySrcKey(source + "|" + class_cd + "|"
					+ sfdc_id);
			userDefinedSrckey.setAddrSrcKey(userDefinedSrckey.getPrtySrcKey()
					+ "|" + sFDC_Addr_Cont);
			userDefinedSrckey.setPrtyNmSrcKey(userDefinedSrckey.getPrtySrcKey()
					+ "|" + prty_Nm_Cont);
			userDefinedSrckey.setSrcSysRefSrcKey(userDefinedSrckey
					.getPrtySrcKey() + "|" + src_Sys_Cont);
		} else {
			throw new IncorrectRequest("Sourcekey not found");
		}
		return userDefinedSrckey;
	}
}
