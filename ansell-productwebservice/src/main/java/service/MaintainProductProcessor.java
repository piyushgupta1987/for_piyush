package service;

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
import com.ansell.partyservice.exception.SiperianConnectionException;
import model.BoProduct;
import model.BoProductOrigin;
import model.BoProductPkg;
import model.BoProductPkgUom;
import model.BoProductRegion;


public class MaintainProductProcessor {
	
	Logger log = Logger.getLogger(getClass().getName());

	public String saveProduct(BoProduct product, SiperianClient sipEjbClient)
			throws SiperianConnectionException {

		log.info("save product method started");
		PutRequest put = new PutRequest();

		RecordKey productkey = null;

		if (product.getRowidObject() != null && !StringUtil.isEmpty(product.getRowidObject())) {
			RecordKey key = new RecordKey();

			key.setSystemName(product.getSrcSystem());
			log.info("party srcsystem: " + key.toString());
			key.setRowid(product.getRowidObject());
			key.setSourceKey(product.getPkeySrcObject());
			put.setRecordKey(key);

		} else {
			RecordKey key = new RecordKey();
			key.setSystemName(party.getSrcSystem());
			put.setRecordKey(key);
			put.setGenerateSourceKey(true);

		}

		Record record = new Record();
		record.setSiperianObjectUid(SiperianObjectType.BASE_OBJECT
				.makeUid("C_BO_PRODUCT"));

		record.setField(new Field("ORACLE_PRDT_ID", product.getOraclePrdtId()));
		record.setField(new Field("MANFACT_PRDT_ID", product.getManfactPrdtId()));
		record.setField(new Field("LAUNCH_YR", product.getLaunchYr()));
		record.setField(new Field("WRKFLOW_APPR_GRP", product.getWrkflowApprGrp()));
		record.setField(new Field("PROD_TYP", product.getProdTyp()));
		record.setField(new Field("CTLG_NUM", product.getCtlgNum()));
		record.setField(new Field("WRKFLOW_STAT", product.getWrkflowStat()));
		record.setField(new Field("DESCRIPTION", product.getDescription()));
		record.setField(new Field("SUB_BRAND", product.getSubBrand()));
		record.setField(new Field("PROD_SIZE", product.getProdSize()));
		record.setField(new Field("BRAND_STGY", product.getBrandStgy()));
		record.setField(new Field("BRAND", product.getBrand()));
		record.setField(new Field("STYLE", product.getStyle()));
		record.setField(new Field("CORP_PROD_CTGY", product.getCorpProdCtgy()));
		record.setField(new Field("PROD_DESC_SFX", product.getProdDescSfx()));
		record.setField(new Field("GBU", product.getGbu()));
		record.setField(new Field("INT_PROD_ID", product.getIntProdId()));
		record.setField(new Field("STERILITY", product.getSterility()));
		record.setField(new Field("M4_CATG", product.getM4Catg()));
		record.setField(new Field("M4_PROD_GRP", product.getM4ProdGrp()));
		record.setField(new Field("M4_FAMILY", product.getM4Family()));
		record.setField(new Field("GNRL_CMTS", product.getGnrlCmts()));
		record.setField(new Field("ANS_STD_UOM", product.getAnsStdUom()));
		record.setField(new Field("ROWID_BO_CLASS", product.getRowidBoClass()));
		record.setField(new Field("VARIANT", product.getVariant()));
		record.setField(new Field("CORP_PROD_FAMILY", product.getCorpProdFamily()));
		record.setField(new Field("PRD_CRT_RESN_CD", product.getPrdCrtResnCd()));
		record.setField(new Field("APS_PSP_PRD_FLG", product.getApsPspPrdFlg()));
		record.setField(new Field("PRODUCT_SBI", product.getProductSbi()));
		record.setField(new Field("PCK_CNT", product.getPckCnt()));
		record.setField(new Field("SHELF_LIFE", product.getShelfLife()));
		record.setField(new Field("PRODUCT_DIVISION", product.getProductDivision()));
		record.setField(new Field("AQSN_NM", product.getAqsnNm()));
		put.setRecord(record);
		log.info("procees the save product to save");
		PutResponse response;
		//System.out.println("put response");

		if (sipEjbClient != null) {

			response = (PutResponse) sipEjbClient.process(put);
		} else {
			throw new SiperianConnectionException(
					"Unable to got the sif connection");
		}

		log.info("done the process for save product");
		productkey = response.getRecordKey();

		log.info("product save with row id :" + productkey.getRowid());

		return productkey.getRowid();

	}

	public void saveProductRegion(BoProductRegion productregion, SiperianClient sipEjbClient) {

		log.info("save product region process start");
		PutRequest put = new PutRequest();
		RecordKey key = new RecordKey();

		key.setSystemName(productregion.getSrcSystem());
		key.setSourceKey(productregion.getPkeySrcObject());

		if (productregion.getPkeySrcObject() != null) {
			put.setRecordKey(key);
		} else {
			put.setRecordKey(key);
			put.setGenerateSourceKey(true);
		}

		Record record = new Record();
		record.setSiperianObjectUid(SiperianObjectType.BASE_OBJECT
				.makeUid("C_BO_PRODUCT_REGION"));
		record.setField(new Field("REPKG_ORGN_CD", productregion.getRepkgOrgnCd()));
		record.setField(new Field("RUSS_LBL_IND", productregion.getRussLblInd()));
		record.setField(new Field("RUSS_LBL_CD", productregion.getRussLblCd()));
		record.setField(new Field("GNRL_CMTS", productregion.getGnrlCmts()));
		record.setField(new Field("PRODUCT_STATUS", productregion.getProductStatus()));
		record.setField(new Field("SHIPPING_UOM", productregion.getShippingUom()));
		record.setField(new Field("REGION_CD", productregion.getRegionCd()));
		record.setField(new Field("PRI_SELLING_UOM", productregion.getPriSellingUom()));
		record.setField(new Field("SEC_SELLING_UOM", productregion.getSecSellingUom()));
		record.setField(new Field("LWST_SHPBL_UOM", productregion.getLwstShpblUom()));
		record.setField(new Field("ROWID_PROD", productregion.getRowidProd()));
		record.setField(new Field("COGS_ACC_ORG_325", productregion.getCogsAccOrg325()));
		record.setField(new Field("COGS_ACC_ORG_355", productregion.getCogsAccOrg355()));
		record.setField(new Field("DIV_TRANSF_PRICE_CAT", productregion.getDivTransfPriceCat()));
		record.setField(new Field("EXP_ACC_ORG_325", productregion.getExpAccOrg325()));
		record.setField(new Field("EXP_ACC_ORG_355", productregion.getExpAccOrg355()));
		record.setField(new Field("ROWID_GLBL_PROC_FMLY", productregion.getRowidGlblProcFmly()));
		record.setField(new Field("ROWID_GLBL_PROC_GRP", productregion.getRowidGlblProcGrp()));
		record.setField(new Field("ROWID_GLBL_PROC_SGRP", productregion.getRowidGlblProcSgrp()));
		record.setField(new Field("ROWID_GLBL_PROC_SGRP_TYP", productregion.getRowidGlblProcSgrpTyp()));
		record.setField(new Field("SALES_ACC_ORG_325", productregion.getSalesAccOrg325()));
		record.setField(new Field("SALES_ACC_ORG_355", productregion.getSalesAccOrg355()));
		record.setField(new Field("SOLD_IN_NORTH_AMERICA", productregion.getSoldInNorthAmerica()));
		record.setField(new Field("ROWID_MAT_GROUP_2", productregion.getRowidMatGroup2()));
		
		put.setRecord(record);

		PutResponse response = (PutResponse) sipEjbClient.process(put);
		RecordKey productregionKey = response.getRecordKey();
		log.info("productregion put end" + productregionKey);
		//System.out.println("address put end" + addrKey);
		TokenizeRequest tokenize = new TokenizeRequest();
		tokenize.setRecordKey(productregionKey);
		tokenize.setActionType(response.getActionType());
		tokenize.setSiperianObjectUid(put.getSiperianObjectUid());
		sipEjbClient.process(tokenize);
		log.info("save productregion process end");
	}

	public void saveProductOrigin(BoProductOrigin productorigin, SiperianClient sipEjbClient) {

		log.info("save product origin process start");

		PutRequest put = new PutRequest();
		RecordKey key = new RecordKey();
		key.setSystemName(productorigin.getSrcSystem());
		key.setSourceKey(productorigin.getPkeySrcObject());

		if (productorigin.getPkeySrcObject() != null) {
			put.setRecordKey(key);
		} else {
			put.setRecordKey(key);
			put.setGenerateSourceKey(true);
		}

		Record record = new Record();
		record.setSiperianObjectUid(SiperianObjectType.BASE_OBJECT
				.makeUid("C_BO_PRODUCT_ORIGIN"));
		record.setField(new Field("SRC_STATUS", productorigin.getSrcStatus()));
		record.setField(new Field("ORGN_CNTRY", productorigin.getOrgnCntry()));
		record.setField(new Field("PRIM_ORGN", productorigin.getPrimOrgn()));
		record.setField(new Field("ROWID_PROD", productorigin.getRowidProd()));
		record.setField(new Field("ORGN_CD", productorigin.getOrgnCd()));
		record.setField(new Field("MED_DEV_LISTING", productorigin.getMedDevListing()));
		record.setField(new Field("SOURCE_FROM_GTC", productorigin.getSourceFromGtc()));
		record.setField(new Field("ANSELL_PLANT", productorigin.getAnsellPlant()));
		record.setField(new Field("ESTAB_FACILITY_ID", productorigin.getEstabFacilityId()));
		record.setField(new Field("CODE_510K", productorigin.getCode510K()));
				
		put.setRecord(record);
		PutResponse response = (PutResponse) sipEjbClient.process(put);

		log.info("save product origin process end");
	}

	public void saveProductPkg(BoProductPkg productpkg, SiperianClient sipEjbClient) {

		log.info("save product pkg process start");

		PutRequest put = new PutRequest();
		RecordKey key = new RecordKey();
		key.setSystemName(productpkg.getSrcSystem());
		key.setSourceKey(productpkg.getPkeySrcObject());

		if (productpkg.getPkeySrcObject() != null) {
			put.setRecordKey(key);
		} else {
			put.setRecordKey(key);
			put.setGenerateSourceKey(true);
		}

		Record record = new Record();
		record.setSiperianObjectUid(SiperianObjectType.BASE_OBJECT
				.makeUid("C_BO_PRODUCT_PKG"));
		record.setField(new Field("EXT_CASE_NET_WT", productpkg.getExtCaseNetWt()));
		record.setField(new Field("GTIN_INNER", productpkg.getGtinInner()));
		record.setField(new Field("EXT_CASE_GROSS_WT", productpkg.getExtCaseGrossWt()));
		record.setField(new Field("ROWID_PROD", productpkg.getRowidProd()));
		record.setField(new Field("EXT_CASE_WIDTH", productpkg.getExtCaseWidth()));
		record.setField(new Field("EXT_CASE_HEIGHT", productpkg.getExtCaseHeight()));
		record.setField(new Field("EXT_CASE_LENGTH", productpkg.getExtCaseLength()));
		record.setField(new Field("EXT_CASE_VOLUME", productpkg.getExtCaseVolume()));
		record.setField(new Field("GTIN_UNIT", productpkg.getGtinUnit()));
		record.setField(new Field("EAN_OUTER", productpkg.getEanOuter()));
		record.setField(new Field("GTIN_OUTER", productpkg.getGtinOuter()));
		record.setField(new Field("EAN_INNER", productpkg.getEanInner()));
		record.setField(new Field("EAN_UNIT", productpkg.getEanUnit()));
				
		put.setRecord(record);
		PutResponse response = (PutResponse) sipEjbClient.process(put);

		log.info("save product pkg process end");
	}

	
	public void saveProductPkgUom(BoProductPkgUom productpkguom, SiperianClient sipEjbClient) {

		log.info("save product pkg process start");

		PutRequest put = new PutRequest();
		RecordKey key = new RecordKey();
		key.setSystemName(productpkguom.getSrcSystem());
		key.setSourceKey(productpkguom.getPkeySrcObject());

		if (productpkguom.getPkeySrcObject() != null) {
			put.setRecordKey(key);
		} else {
			put.setRecordKey(key);
			put.setGenerateSourceKey(true);
		}

		Record record = new Record();
		record.setSiperianObjectUid(SiperianObjectType.BASE_OBJECT
				.makeUid("C_BO_PRODUCT_PKG_UOM"));
		record.setField(new Field("ROWID_PROD", productpkguom.getRowidProd()));
		record.setField(new Field("PKG_CONFIG_PCS", productpkguom.getPkgConfigPcs()));
		record.setField(new Field("PCS_IN_CASE_CARTON", productpkguom.getPcsInCaseCarton()));
		record.setField(new Field("PCS_IN_BAG", productpkguom.getPcsInBag()));
		record.setField(new Field("PCS_IN_BOX", productpkguom.getPcsInBox()));
		record.setField(new Field("PCS_IN_BUNDLE", productpkguom.getPcsInBundle()));
		record.setField(new Field("PCS_IN_DD", productpkguom.getPcsInDd()));
		record.setField(new Field("PCS_IN_DOZEN", productpkguom.getPcsInDozen()));
		record.setField(new Field("PCS_IN_GROSS", productpkguom.getPcsInGross()));
		record.setField(new Field("PCS_IN_KIT", productpkguom.getPcsInKit()));
		record.setField(new Field("PCS_IN_PACK", productpkguom.getPcsInPack()));
		record.setField(new Field("PCS_IN_RTL_PACK", productpkguom.getPcsInRtlPack()));
					
		put.setRecord(record);
		PutResponse response = (PutResponse) sipEjbClient.process(put);

		log.info("save product pkg uom process end");
	}


}
