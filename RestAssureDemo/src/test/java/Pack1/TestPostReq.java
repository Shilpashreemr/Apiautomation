package Pack1;




import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
public class TestPostReq {
	String url="https://countriesnow.space/api/v0.1/countries/population/cities";
	@Test
	void checkFirst() {
		RestAssured.baseURI = "https://countriesnow.space";
		String payload="{\n"
				+ "    \"city\":\"Lagos\"\n"
				+ "}";
		Response post =
                given()
                        .contentType("application/json")
                        .body(payload)
                .when()
                        .post(url)
                .then()
                        .statusCode(301) 
                        .extract().response();
        String redirectUrl = post.getHeader("Location");
        Response response =
                given()
                .when()
                	.get(redirectUrl)
                .then()
                	.statusCode(200)
                	.extract().response();
                	
        response.then()
        		.log().all()
                .body("data.city", equalTo("Lagos"))
                .body("data.country", equalTo("Nigeria"));
        System.out.println(response.getStatusCode());
       
;
		
		
		
		
			
			
		
		
	}
}