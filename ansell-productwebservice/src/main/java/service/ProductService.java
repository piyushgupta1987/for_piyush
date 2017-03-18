package service;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import model.ProductServiceRequest;
import model.ProductServiceResponse;

@WebService(endpointInterface="service.ServiceInterface",name = Service.NAME, portName = Service.SERVICE_PORT_NAME, serviceName = Service.SERVICE_NAME)
public class ProductService implements ServiceInterface {
	
	@WebResult(name = "productResponse", targetNamespace=Service.NAME_SPACE)
	public ProductServiceResponse product(@WebParam(name = "getProducrRequest", targetNamespace=Service.NAME_SPACE) ProductServiceRequest productServiceRequest) throws ProductServiceException {
		ProductServiceResponse response = new ProductServiceResponse();
		
		
		//TODO implement the actual logic 
		response.setId(100l);
		return response;
	}

}
