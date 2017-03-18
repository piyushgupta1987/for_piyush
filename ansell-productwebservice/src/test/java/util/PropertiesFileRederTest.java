package util;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PropertiesFileRederTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Properties prop = PropertiesReaderUtil.readProperties("testapp.properties");
		assertNotNull("prop should not be null",prop);
		assertEquals("ansell", prop.getProperty("name"));
	}
	
	@Test(expected=Exception.class)
	public void testException() {
		Properties prop = PropertiesReaderUtil.readProperties(null);
		assertNotNull("prop should not be null",prop);
		assertEquals("ansell", prop.getProperty("name"));
	}

}
