package gov.nyc.buildings.strategic.dataanalysis.qmatic.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class RestWebServiceClient {
	private static final Logger logger = LogManager.getLogger(RestWebServiceClient.class);
	private static RestWebServiceClient instance = null;
	private Properties logCredential = null;
	private Client client = null;
	private ClientConfig config = null;
	
	private RestWebServiceClient(){
//		logCredential = new Properties();
//		try {
//			logCredential.load(new FileInputStream("WebContent/WEB-INF/etc/qmatic_orchestra.properties"));
//		} catch (FileNotFoundException e) {
//			logger.error(e.getMessage());
//			e.printStackTrace();
//		} catch (IOException e) {
//			logger.error(e.getMessage());
//			e.printStackTrace();
//		}
		
		this.config = new ClientConfig();
//		HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(logCredential.getProperty("user"), logCredential.getProperty("password"));
		HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("dev", "Buildings2017");
		config.register(feature);
	    this.client = ClientBuilder.newClient(config);
	}
	
	public static RestWebServiceClient getInstance(){
		if (RestWebServiceClient.instance==null){
			RestWebServiceClient.instance = new RestWebServiceClient();
			
		}
		logger.trace("client instance created");
		return RestWebServiceClient.instance;
	}
	
	public Client getClient(){
		return this.client;
	}
	
	
		
	


}
