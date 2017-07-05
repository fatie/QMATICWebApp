package gov.nyc.buildings.strategic.dataanalysis.qmatic.util;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

public class RestWebServiceBaseUri {
	public static URI getBaseURI() {
		return UriBuilder.fromUri("http://mspwva-dobqmt01.csc.nycnet:8080/rest").build();
	}
}
