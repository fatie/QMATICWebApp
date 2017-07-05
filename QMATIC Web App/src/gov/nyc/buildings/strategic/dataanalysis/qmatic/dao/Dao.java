package gov.nyc.buildings.strategic.dataanalysis.qmatic.dao;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

import gov.nyc.buildings.strategic.dataanalysis.qmatic.util.RestWebServiceBaseUri;
import gov.nyc.buildings.strategic.dataanalysis.qmatic.util.RestWebServiceClient;

public abstract class Dao<T, K> implements GenericDao<T, K> {
	private Client client = RestWebServiceClient.getInstance().getClient();
	private URI baseUri = RestWebServiceBaseUri.getBaseURI();
	private WebTarget target = client.target(baseUri);
	
	protected WebTarget getTarget() {
		return target;
	}
	
}
