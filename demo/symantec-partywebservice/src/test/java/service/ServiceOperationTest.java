package service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.symantec.partyservice.exception.SiperianConnectionException;
import com.symantec.partyservice.inout.PartyRequest;
import com.symantec.partyservice.inout.PartyResponse;
import com.symantec.partyservice.pojo.CBOutbdRealTrigr;
import com.symantec.partyservice.pojo.CBPrty;
import com.symantec.partyservice.pojo.CBPrtyAddr;
import com.symantec.partyservice.pojo.CBPrtyNm;
import com.symantec.partyservice.pojo.CBSrcSysRefDtls;
import com.symantec.partyservice.pojo.MdmCredential;
import com.symantec.partyservice.processor.MaintainPartyProcessorHandler;

@Ignore
public class ServiceOperationTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void doPutTest() throws Exception, SiperianConnectionException {

		MaintainPartyProcessorHandler partyhandler = new MaintainPartyProcessorHandler();
		PartyRequest P = new PartyRequest();
		P.setParty(getParty());
		P.setAddress(getPartyAddress());
		P.setPrtyname(getPartyName());
		P.setSrcsysrefdtls(getSrcSysDtls());

		MdmCredential mdmCredential = new MdmCredential();
		mdmCredential.setUsername("admin");
		mdmCredential.setPassword("Vm5as");
		PartyResponse res = partyhandler.doPutV3(P, mdmCredential);
		System.out.println(res.getRowidObject());
	}

	private CBSrcSysRefDtls getSrcSysDtls() {
		CBSrcSysRefDtls srcDtls = new CBSrcSysRefDtls();
		srcDtls.setErpPrtySiteId("76221111");
		srcDtls.setErpPrtySiteNum("76222115");
		srcDtls.setErpPrtySiteStsCd("A");
		srcDtls.setErpPrtyId("80142722");
		srcDtls.setErpLocationId("15355440");
		srcDtls.setErpCustActId("59615380");
		srcDtls.setErpCustActSiteId("76667380");
		srcDtls.setErpCustActSiteOrgId("8");
		srcDtls.setErpCustActSiteStsCd("A");

		return srcDtls;
	}

	private CBOutbdRealTrigr getOutbdRealTrigr() {
		CBOutbdRealTrigr outbdtrigr = new CBOutbdRealTrigr();
		outbdtrigr.setActionType("INSERT");
		outbdtrigr.setSrcSysNm("ERP");
		outbdtrigr.setSysOrig("ERP_UI");

		return outbdtrigr;
	}

	private CBPrty getParty() {
		CBPrty cbParty = new CBPrty();
		// cbParty.setRowidObject("410004");
		cbParty.setSrcSystem("ERP");
		cbParty.setBlklstFlg("Y");
		cbParty.setPrtyDesc("PkeySrcTest");
		cbParty.setPrtyFullNm("PkeySrcTest");
		cbParty.setPartySubtypeClassCd("ORGN");
		cbParty.setPrtyStsCd("A");

		return cbParty;

	}

	private CBPrtyAddr getPartyAddress() {

		CBPrtyAddr cbPrtyAddress = new CBPrtyAddr();
		// cbPrtyAddress.setSrcSystem("ERP");
		cbPrtyAddress.setAddrLine1Txt("1212, EL CAMINO, REAL");
		cbPrtyAddress.setCityNm("SANTA CLARA");
		cbPrtyAddress.setPstlCd("95051");
		cbPrtyAddress.setCtryIso2Cd("US");
		cbPrtyAddress.setStCd("CA");

		return cbPrtyAddress;
	}

	private CBPrtyNm getPartyName() {

		CBPrtyNm cbPartyName = new CBPrtyNm();

		// cbPartyName.setSrcSystem("ERP");
		cbPartyName.setPrtyNm("PkeySrcTest");
		cbPartyName.setRawPrtyNm("PkeySrcTest");
		cbPartyName.setNmTypCd("PARTY_NM");

		return cbPartyName;
	}
}
