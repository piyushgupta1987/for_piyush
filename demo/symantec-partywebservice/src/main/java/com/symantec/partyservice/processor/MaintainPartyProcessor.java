//================================================
//Project: MDM Create Service
// By:  Piyush Gupta (Informatica Corp.)
//================================================


package com.symantec.partyservice.processor;

import org.apache.log4j.Logger;

import com.siperian.common.util.StringUtil;
import com.siperian.sif.client.SiperianClient;
import com.siperian.sif.message.Field;
import com.siperian.sif.message.Record;
import com.siperian.sif.message.RecordKey;
import com.siperian.sif.message.SiperianObjectType;
import com.siperian.sif.message.mrm.PutRequest;
import com.siperian.sif.message.mrm.PutResponse;
import com.siperian.sif.message.mrm.TokenizeRequest;
import com.symantec.partyservice.exception.SiperianConnectionException;
import com.symantec.partyservice.inout.PartyRequest;
import com.symantec.partyservice.pojo.CBOutbdRealTrigr;
import com.symantec.partyservice.pojo.CBPrty;
import com.symantec.partyservice.pojo.CBPrtyAddr;
import com.symantec.partyservice.pojo.CBPrtyNm;
import com.symantec.partyservice.pojo.CBSrcSysRefDtls;

public class MaintainPartyProcessor {
	Logger log = Logger.getLogger(getClass().getName());

	public String saveParty(CBPrty party, SiperianClient sipEjbClient)
			throws SiperianConnectionException {

		log.info("save party method started");
		PutRequest put = new PutRequest();

		RecordKey partykey = null;

		if (party.getRowidObject() != null && !StringUtil.isEmpty(party.getRowidObject())) {
			RecordKey key = new RecordKey();

			key.setSystemName(party.getSrcSystem());
			log.info("party srcsystem: " + key.toString());
			key.setRowid(party.getRowidObject());
			key.setSourceKey(party.getPkeySrcObject());
			put.setRecordKey(key);

		} else {
			RecordKey key = new RecordKey();
			key.setSystemName(party.getSrcSystem());
			put.setRecordKey(key);
			put.setGenerateSourceKey(true);

		}

		Record record = new Record();
		record.setSiperianObjectUid(SiperianObjectType.BASE_OBJECT
				.makeUid("C_B_PRTY"));

		record.setField(new Field("BLKLST_FLG", party.getBlklstFlg()));
		record.setField(new Field("DONT_SHR_INTRNL_FLG", party
				.getDontShrIntrnlFlg()));
		record.setField(new Field("RECV_PTNR_CNTCT_FLG", party
				.getRecvPtnrCntctFlg()));
		record.setField(new Field("PRTY_STS_CD", party.getPrtyStsCd()));
		record.setField(new Field("MBR_CNT", party.getMbrCnt()));
		record.setField(new Field("PRTY_DESC", party.getPrtyFullNm()));
		record.setField(new Field("IM_PRTY_FLG", party.getImPrtyFlg()));
		record.setField(new Field("PARTY_SUBTYPE_CLASS_CD", party
				.getPartySubtypeClassCd()));
		record.setField(new Field("PRTY_FDTN_DT", party.getPrtyFdtnDt()));
		record.setField(new Field("PRTY_FULL_NM", party.getPrtyFullNm()));
		record.setField(new Field("CREDIT_RATING_CD", party.getCreditRatingCd()));
		record.setField(new Field("OUT_OF_BUSN_FLG", party.getOutOfBusnFlg()));
		record.setField(new Field("PRTY_FST_PRCH_DT", party.getPrtyFstPrchDt()));
		record.setField(new Field("OPT_OUT_FLG", party.getOptOutFlg()));
		record.setField(new Field("PRTY_NUM", party.getPrtyNum()));
		record.setField(new Field("IS_PRTY_FLG", party.getIsPrtyFlg()));
		record.setField(new Field("DONT_SHR_EXTR_FLG", party
				.getDontShrExtrFlg()));
		put.setRecord(record);
		log.info("procees the save party to save");
		PutResponse response;
		//System.out.println("put response");

		if (sipEjbClient != null) {

			response = (PutResponse) sipEjbClient.process(put);
		} else {
			throw new SiperianConnectionException(
					"Unable to got the sif connection");
		}

		log.info("done the process for save party");
		partykey = response.getRecordKey();

		TokenizeRequest tokenize = new TokenizeRequest();
		tokenize.setRecordKey(partykey);
		tokenize.setActionType(response.getActionType());
		tokenize.setSiperianObjectUid(put.getSiperianObjectUid());
		sipEjbClient.process(tokenize);
		log.info("party save with row id :" + partykey.getRowid());

		return partykey.getRowid();

	}

	public void saveAddress(CBPrtyAddr address, SiperianClient sipEjbClient) {

		log.info("save address process start");
		PutRequest put = new PutRequest();
		RecordKey key = new RecordKey();

		key.setSystemName(address.getSrcSystem());
		key.setSourceKey(address.getPkeySrcObject());

		if (address.getPkeySrcObject() != null) {
			put.setRecordKey(key);
		} else {
			put.setRecordKey(key);
			put.setGenerateSourceKey(true);
		}

		Record record = new Record();
		record.setSiperianObjectUid(SiperianObjectType.BASE_OBJECT
				.makeUid("C_B_PRTY_ADDR"));
		record.setField(new Field("ADDR_LINE_1_TXT", address.getAddrLine1Txt()));
		record.setField(new Field("ADDR_LINE_2_TXT", address.getAddrLine2Txt()));
		record.setField(new Field("ADDR_LINE_3_TXT", address.getAddrLine3Txt()));
		record.setField(new Field("ADDR_LINE_4_TXT", address.getAddrLine4Txt()));
		record.setField(new Field("CITY_NM", address.getCityNm()));
		record.setField(new Field("ST_CD", address.getStCd()));
		record.setField(new Field("CNTY_NM", address.getCntyNm()));
		record.setField(new Field("PSTL_CD", address.getPstlCd()));
		record.setField(new Field("PSTL_CD_EXTN", address.getPstlCdExtn()));
		record.setField(new Field("CTRY_ISO2_CD", address.getCtryIso2Cd()));
		record.setField(new Field("LAT_CD", address.getLatCd()));
		record.setField(new Field("LON_CD", address.getLonCd()));
		record.setField(new Field("RAW_ADDR_PART1_TXT", address
				.getRawAddrPart1Txt()));
		record.setField(new Field("RAW_ADDR_PART2_TXT", address
				.getRawAddrPart2Txt()));
		record.setField(new Field("ST_CTRY_ISO2_CD", address.getStCtryIso2Cd()));
		record.setField(new Field("TIME_ZN_CD", address.getTimeZnCd()));
		record.setField(new Field("LOC_COORD_DESC", address.getLocCoordDesc()));
		record.setField(new Field("REGS_ADDR_FLG", address.getRegsAddrFlg()));
		record.setField(new Field("PRTY_ROWID", address.getPrtyRowid()));
		record.setField(new Field("DWLNG_TYP_CD", address.getDwlngTypCd()));
		record.setField(new Field("ADDR_VLD_MSG", address.getAddrVldMsg()));
		record.setField(new Field("ADDR_HASH_KEY", address.getAddrHashKey()));
		record.setField(new Field("ADDR_VLD_TYP_CD", address.getAddrVldTypCd()));
		record.setField(new Field("CARR_RTE_TXT", address.getCarrRteTxt()));
		record.setField(new Field("ADDR_MAILABL_SCORE", address
				.getAddrMailablScore()));
		record.setField(new Field("VRFY_ADDR_FLG", address.getVrfyAddrFlg()));
		record.setField(new Field("ADDR_RSDL_TXT", address.getAddrRsdlTxt()));
		record.setField(new Field("USE_FOR_PRTY_MTCH_FLG", address
				.getUseForPrtyMtchFlg()));
		record.setField(new Field("ADDR_VLD_TYP_CD_FLG", address
				.getAddrVldTypCdFlg()));

		put.setRecord(record);

		PutResponse response = (PutResponse) sipEjbClient.process(put);
		RecordKey addrKey = response.getRecordKey();
		log.info("address put end" + addrKey);
		//System.out.println("address put end" + addrKey);
		TokenizeRequest tokenize = new TokenizeRequest();
		tokenize.setRecordKey(addrKey);
		tokenize.setActionType(response.getActionType());
		tokenize.setSiperianObjectUid(put.getSiperianObjectUid());
		sipEjbClient.process(tokenize);
		log.info("save address process end");
	}

	public void savePartyName(CBPrtyNm partyName, SiperianClient sipEjbClient) {

		log.info("save party name process start");

		PutRequest put = new PutRequest();
		RecordKey key = new RecordKey();
		key.setSystemName(partyName.getSrcSystem());
		key.setSourceKey(partyName.getPkeySrcObject());

		if (partyName.getPkeySrcObject() != null) {
			put.setRecordKey(key);
		} else {
			put.setRecordKey(key);
			put.setGenerateSourceKey(true);
		}

		Record record = new Record();
		record.setSiperianObjectUid(SiperianObjectType.BASE_OBJECT
				.makeUid("C_B_PRTY_NM"));
		record.setField(new Field("PRTY_NM", partyName.getPrtyNm()));
		record.setField(new Field("NM_TYP_CD", "PARTY_NM"));
		record.setField(new Field("RAW_PRTY_NM", partyName.getRawPrtyNm()));
		record.setField(new Field("PRTY_ROWID", partyName.getPrtyRowid()));
		record.setField(new Field("VLD_PRTY_NM_FLG", "N"));
		put.setRecord(record);
		PutResponse response = (PutResponse) sipEjbClient.process(put);

		log.info("save party name process end");
	}

	public void saveSrcSysRefDtls(CBSrcSysRefDtls srcsysrefdtls,
			SiperianClient sipEjbClient) {
		
		log.info("save SrcSysRefDtls process start");

		PutRequest put = new PutRequest();
		RecordKey key = new RecordKey();
		key.setSystemName(srcsysrefdtls.getSrcSystem());
		key.setSourceKey(srcsysrefdtls.getPkeySrcObject());
		put.setRecordKey(key);
		Record record = new Record();
		record.setSiperianObjectUid(SiperianObjectType.BASE_OBJECT
				.makeUid("C_B_SRC_SYS_REF_DTLS"));
		record.setField(new Field("SRC_PK_ID", srcsysrefdtls.getSrcPkId()));
		record.setField(new Field("PRTY_ROWID", srcsysrefdtls.getPrtyRowid()));
		record.setField(new Field("ERP_PRTY_SITE_ID", srcsysrefdtls
				.getErpPrtySiteId()));
		record.setField(new Field("ERP_PRTY_SITE_NUM", srcsysrefdtls
				.getErpPrtySiteNum()));
		record.setField(new Field("ERP_PRTY_SITE_STS_CD", srcsysrefdtls
				.getErpPrtySiteStsCd()));
		record.setField(new Field("ERP_PRTY_ID", srcsysrefdtls.getErpPrtyId()));
		record.setField(new Field("ERP_LOCATION_ID", srcsysrefdtls
				.getErpLocationId()));
		record.setField(new Field("ERP_CUST_ACT_ID", srcsysrefdtls
				.getErpCustActId()));
		record.setField(new Field("ERP_CUST_ACT_SITE_ID", srcsysrefdtls
				.getErpCustActSiteId()));
		record.setField(new Field("ERP_CUST_ACT_SITE_ORG_ID", srcsysrefdtls
				.getErpCustActSiteOrgId()));
		record.setField(new Field("ERP_CUST_ACT_SITE_STS_CD", srcsysrefdtls
				.getErpCustActSiteStsCd()));
		record.setField(new Field("ERP_SLS_CHNL_CD", srcsysrefdtls
				.getErpSlsChnlCd()));
		record.setField(new Field("SFDC_REC_TYPE", srcsysrefdtls
				.getSfdcRecType()));
		record.setField(new Field("SFDC_AXAPTA_ID", srcsysrefdtls
				.getSfdcAxaptaId()));
		record.setField(new Field("SFDC_ACT_ID", srcsysrefdtls.getSfdcActId()));
		record.setField(new Field("SFDC_ACT_STS_CD", srcsysrefdtls
				.getSfdcActStsCd()));
		record.setField(new Field("SFDC_CNTCT_ID", srcsysrefdtls
				.getSfdcCntctId()));
		record.setField(new Field("PRIM_FLG", srcsysrefdtls.getPrimFlg()));
		record.setField(new Field("SFDC_SOBJECT_TYPE", srcsysrefdtls
				.getSfdcSobjectType()));
		put.setRecord(record);
		PutResponse response = (PutResponse) sipEjbClient.process(put);
		
		log.info("save SrcSysRefDtls process start");
	}

	public void saveOutbdRealTrigr(CBOutbdRealTrigr outbdrealtrigr,
			SiperianClient sipEjbClient) {

		PutRequest put = new PutRequest();
		RecordKey key = new RecordKey();
		key.setSystemName("Admin");
		put.setRecordKey(key);
		put.setGenerateSourceKey(true);
		Record record = new Record();

		record.setSiperianObjectUid(SiperianObjectType.BASE_OBJECT
				.makeUid("C_O_OUTBD_REAL_TRIGR"));
		record.setField(new Field("SRC_SYS_NM", outbdrealtrigr.getSrcSysNm()));
		record.setField(new Field("ACTION_TYPE", outbdrealtrigr.getActionType()));
		record.setField(new Field("SYS_ORIG", outbdrealtrigr.getSysOrig()));
		record.setField(new Field("PRTY_CR_ID", outbdrealtrigr.getPrtyCrId()));

		put.setRecord(record);
		PutResponse response = (PutResponse) sipEjbClient.process(put);
	}
}
