/*package com.xws.tim12.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.xws.tim12.model.Vehicle;
import com.xws.tim12.wsdl.GetVehicleRequest;
import com.xws.tim12.wsdl.GetVehicleResponse;

public class VehicleClient extends WebServiceGatewaySupport{

	//private static final Logger log = LoggerFactory.getLogger(CountryClient.class);

	  public GetVehicleResponse getVehicle(Vehicle vehicle) {

	    GetVehicleRequest request = new GetVehicleRequest();
	    //request.setName(country);

	    //log.info("Requesting location for " + country);

	    GetVehicleResponse response = (GetVehicleResponse) getWebServiceTemplate()
	        .marshalSendAndReceive("http://localhost:8085/ws/vehicles", request,
	            new SoapActionCallback(
	                "http://localhost:8085/ws/vehicles/GetCountryRequest"));

	    return response;
	  }
}
*/