package service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.symantec.partyservice.inout.PartyRequest;
import com.symantec.partyservice.pojo.CBPrty;
import com.symantec.partyservice.pojo.CBPrtyAddr;
import com.symantec.partyservice.pojo.CBPrtyNm;
import com.symantec.partyservice.pojo.CBSrcSysRefDtls;
import com.symantec.partyservice.pojo.UserDefinedSrckey;
import com.symantec.partyservice.processor.MaintainPartyProcessorHandler;
@Ignore
public class AutoPkeySrcGenTest {

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
	public void genSrcTest() throws Exception {

		MaintainPartyProcessorHandler maintainPartyProcessorHandler = new MaintainPartyProcessorHandler();
		
		PartyRequest partyRequest =  new PartyRequest();
		partyRequest.setParty(getParty());
		partyRequest.setSrcsysrefdtls(getSrcSysDtls());
		
		UserDefinedSrckey userDefinedSrcKey = maintainPartyProcessorHandler.genSrckey(partyRequest);
				
		System.out.println("Party:" + userDefinedSrcKey.getPrtySrcKey() );
		System.out.println("addr:" + userDefinedSrcKey.getAddrSrcKey() );
		System.out.println("name:" + userDefinedSrcKey.getPrtyNmSrcKey() );
		System.out.println("srcsysdtls:" + userDefinedSrcKey.getSrcSysRefSrcKey());
	}

	private CBPrty getParty() {
		CBPrty cbParty = new CBPrty();
		cbParty.setRowidObject("410004");
		cbParty.setSrcSystem("SFDC");
		cbParty.setBlklstFlg("Y");
		cbParty.setPrtyDesc("NewTest");
		cbParty.setPrtyFullNm("NewTest");
		cbParty.setPartySubtypeClassCd("ORGN");
		cbParty.setPrtyStsCd("A");
		
		
	return cbParty;

	}

	
	private CBPrtyAddr getPartyAddress() {
		
		CBPrtyAddr cbPrtyAddress = new CBPrtyAddr();
		cbPrtyAddress.setSrcSystem("ERP");
		cbPrtyAddress.setAddrLine1Txt("125, EL CAMINO, REAL");
		cbPrtyAddress.setCityNm("SANTA CLARA");
		cbPrtyAddress.setPstlCd("95051");
		cbPrtyAddress.setCtryIso2Cd("US");
		cbPrtyAddress.setStCd("CA");
	
		return cbPrtyAddress;
	}
	
	private CBPrtyNm getPartyName() {
		
		CBPrtyNm cbPartyName = new CBPrtyNm();
		
		cbPartyName.setSrcSystem("ERP");
		cbPartyName.setPrtyNm("NewTest");
		cbPartyName.setRawPrtyNm("NewTest");
		cbPartyName.setNmTypCd("PARTY_NM");
		
		return cbPartyName;
	}

	private CBSrcSysRefDtls getSrcSysDtls() {
		CBSrcSysRefDtls srcDtls = new CBSrcSysRefDtls();
		srcDtls.setErpPrtySiteId("76221684");
		srcDtls.setErpPrtySiteNum("76222915");
		srcDtls.setErpPrtySiteStsCd("A");
		srcDtls.setErpPrtyId("80142713");
		srcDtls.setErpLocationId("15355300");
		srcDtls.setErpCustActId("59615380");
		srcDtls.setErpCustActSiteId("76057380");
		srcDtls.setErpCustActSiteOrgId("889");
		srcDtls.setErpCustActSiteStsCd("A");
		
		return srcDtls;
	}
	
}
