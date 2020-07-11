/*package com.xws.tim12.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.xws.tim12.client.VehicleClient;

@Configuration
public class VehicleConfiguration {
	  @Bean
	  public Jaxb2Marshaller marshaller() {
	    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
	    // this package must match the package in the <generatePackage> specified in
	    // pom.xml
	    marshaller.setContextPath("com.xws.tim12.wsdl");
	    return marshaller;
	  }

	  @Bean
	  public VehicleClient vehicleClient(Jaxb2Marshaller marshaller) {
	    VehicleClient client = new VehicleClient();
	    client.setDefaultUri("http://localhost:8086/ws");
	    client.setMarshaller(marshaller);
	    client.setUnmarshaller(marshaller);
	    return client;
	  }
}*/
