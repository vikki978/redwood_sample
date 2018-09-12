import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.*;

public class TestNgTestCase {
	
	
	@BeforeMethod
	public void setUp()
	{
		System.out.println("inside setup");
	}
	@Test
	public void test1()
	{
		System.out.println("inside test method");
	}
	@AfterMethod
	public void tearDown()
	{
		System.out.println("inside teardown");
	}

}
