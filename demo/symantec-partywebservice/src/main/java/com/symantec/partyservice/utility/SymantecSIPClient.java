package com.symantec.partyservice.utility;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.siperian.sif.client.SiperianClient;
import com.symantec.partyservice.pojo.MdmCredential;

public class SymantecSIPClient {

	private static final Logger log = Logger.getLogger(SymantecSIPClient.class);

	public static final String SIPERIAN_CONNECTION_PROPERTIES_FILE = "sif-connection.properties";
	private SiperianClient sipClient;
	protected Properties SiperianConnectionProperties;

	public SiperianClient getEjbSiperianClientTEST() throws Exception {
		try {
			Properties sipClientProperties = new Properties();
			log.info("start EJb call");
			sipClientProperties.setProperty("siperian-client.protocol", "ejb");
			sipClientProperties.setProperty("java.naming.provider.url","t3://tus1infappqin03.ges.symantec.com:7003");
			sipClientProperties.setProperty("siperian-client.orsId","MDMMD-SYMC_ORS");
			//sipClientProperties	.setProperty("siperian-client.username", "admin");
			//sipClientProperties	.setProperty("siperian-client.password", "Vm5as");
			sipClientProperties.setProperty("java.naming.security.principal","weblogic");
			sipClientProperties.setProperty("java.naming.security.credentials","n3wp0rt1");
			sipClientProperties.setProperty("java.naming.factory.initial",	"weblogic.jndi.WLInitialContextFactory");
			sipClientProperties.setProperty("java.naming.security.authentication", "strong");
			sipClientProperties.setProperty("weblogic.security.SSL.ignoreHostnameVerification", "true");
			log.info("Ejb property fetch completed");
			return SiperianClient.newSiperianClient(sipClientProperties);

		} catch (Exception e) {
			log.info("error in ejb call");
		}
		return sipClient;
	}
	
	/**
	 * 
	 * @param mdmCredential
	 * @return sifClient
	 * @throws IOException
	 * The method will read the configuration properties for mdm from the src/main/resources/sif-connection.properties file
	 */
	public SiperianClient getEjbSifClient(MdmCredential mdmCredential) throws IOException{
		log.info("getEjbSifClient : initiating the sif connection");
		Properties properties = new Properties();
		log.debug("sif-connection properties file is loading");
		properties.load(getClass().getResourceAsStream("/sif-connection.properties"));
		log.debug("sif-connection properties file is loded");
		log.debug("sif connection is picking based on the user detals : "+mdmCredential);
		properties.setProperty("siperian-client.username", mdmCredential.getUsername());
		properties.setProperty("siperian-client.password", mdmCredential.getPassword());
		log.debug("username/ password injected with property file");
		return SiperianClient.newSiperianClient(properties);
	}

}
