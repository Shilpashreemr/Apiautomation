package Pack1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


public class TestGetReq
{
	String url="http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02";
	@Test
	void checkSecond() 
	{
		
		given()	.when()
		.get(url)	
		.then()
			.statusCode(200)
			.body("base", equalTo("stations"))
			.body("name", equalTo("London"))
			.log().all();
	}
}
