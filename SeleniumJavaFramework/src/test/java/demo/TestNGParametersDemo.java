package demo;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParametersDemo {

	@Test
	@Parameters("MyName")
	public void test(@Optional ("Shanu") String name) {                  // pass the optional value 
		System.out.println("name is :" +name );

	}

}
