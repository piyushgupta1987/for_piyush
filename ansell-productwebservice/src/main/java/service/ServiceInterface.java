package service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.WebFault;

import model.ProductServiceRequest;
import model.ProductServiceResponse;

@WebService(targetNamespace = Service.NAME_SPACE)
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.BARE)
@WebFault(faultBean = Service.EXCEPTION_BEAN_NAME, messageName = Service.EXCEPTION_MESSAGE, name = Service.EXCEPTION_BEAN_NAME, targetNamespace = Service.NAME_SPACE)
public interface ServiceInterface {

	@WebMethod(action = "GET", operationName = Service.OPERATION_NAME)
	public ProductServiceResponse product(ProductServiceRequest productServiceRequest) throws ProductServiceException;
}
