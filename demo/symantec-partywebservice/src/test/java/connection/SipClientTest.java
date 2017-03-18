package connection;

import static org.junit.Assert.assertNotNull;

import java.io.FileInputStream;
import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.siperian.sif.client.SiperianClient;
import com.symantec.partyservice.pojo.MdmCredential;
import com.symantec.partyservice.utility.SymantecSIPClient;
@Ignore
public class SipClientTest {
	
	private SiperianClient sifClient;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		try {
			sifClient =new SymantecSIPClient().getEjbSiperianClientTEST();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void connTest(){
		assertNotNull(sifClient);
	}
	
	@Test
	public void propertyFileTest() throws Exception{
		MdmCredential mdmCredential = new MdmCredential();
		mdmCredential.setUsername("admin");
		mdmCredential.setPassword("mypassword");
		
		Properties prop = new Properties();
		prop.load(new FileInputStream("./src/test/resources/sif-connection.properties"));
		prop.setProperty("siperian-client.username", mdmCredential.getUsername());
		prop.setProperty("siperian-client.password", mdmCredential.getPassword());
		
		assertNotNull(prop);
		
	}

}
