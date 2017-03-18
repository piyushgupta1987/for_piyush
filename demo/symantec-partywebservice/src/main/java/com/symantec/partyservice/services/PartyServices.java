//================================================
//Project: MDM Create Service
// By:  Piyush Gupta (Informatica Corp.)
//================================================

package com.symantec.partyservice.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.Holder;
import javax.xml.ws.WebFault;

import org.apache.log4j.Logger;

import com.symantec.partyservice.exception.SiperianConnectionException;
import com.symantec.partyservice.exception.SoapUserdefineException;
import com.symantec.partyservice.inout.PartyRequest;
import com.symantec.partyservice.inout.PartyResponse;
import com.symantec.partyservice.pojo.MdmCredential;
import com.symantec.partyservice.processor.MaintainPartyProcessorHandler;
/**
 * 
 * @author 
 *
 */
@WebService(name = "PartyServices", serviceName = "SymantecPartyServices", portName = "SymantecPartyServicesPort")
@SOAPBinding(parameterStyle = ParameterStyle.WRAPPED, style = Style.DOCUMENT, use = Use.LITERAL)
@WebFault
public class PartyServices {
	Logger log = Logger.getLogger(this.getClass());

	MaintainPartyProcessorHandler handler = new MaintainPartyProcessorHandler();
	
	/**
	 * 
	 * @param partyRequest
	 * @param mdmCredential
	 * @return
	 * @throws SoapUserdefineException
	 * This method is exposing as a service
	 */
	@WebMethod(operationName = "maintainParty")
	@WebResult(name = "partyResponse")
	public PartyResponse maintainParty(
			@WebParam(name = "partyRequest") PartyRequest partyRequest,
			@WebParam(name = "mdmCredential", header = true, mode = Mode.INOUT) Holder<MdmCredential> mdmCredential)
			throws SoapUserdefineException {
		PartyResponse partyResponse = new PartyResponse();
		try {
			if (partyRequest != null) {
				log.info("Entered Partyservices" + partyRequest.toString());

				//getting the mdmCredential details from Header
				MdmCredential mdmCredential2 = new MdmCredential();
				mdmCredential2.setUsername(mdmCredential.value.getUsername());
				mdmCredential2.setPassword(mdmCredential.value.getPassword());
				
				partyResponse = handler.doPutV3(partyRequest, mdmCredential2);
				
				return partyResponse;
			} else {
				throw new SoapUserdefineException("Request parameter are missing");
			}
		} catch (SiperianConnectionException e) {
			log.error("SiperianConnectionException occured :" + e.getMessage());
			throw new SoapUserdefineException(e.getMessage());
		} catch (Exception e) {
			log.error("Other Exception :" + e.getMessage());
			throw new SoapUserdefineException(e.getMessage());
		}//catch
	}
}
