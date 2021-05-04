package basic.rest.getcall;

/**
 * @author kirandalai
 *
 */
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

public class verifyResponceClass {

	@Test
	public static void verifyResponcebody() {
		RestAssured.baseURI = "https://api.trello.com";

		given().param("key", "d1dfe26224effc23c1af7401de92bad3")
				.param("token", "d47bf942eea147803f52866110310bde62c120809ec304b8a2c09b1eb446b5e5").when()
				.get("/1/boards/CeVM9sQI").then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
				.body("name", equalTo("Dashboard"));// to change the type of response we need

		System.out.println("This is first automation call");
		System.out.println("Get call Executed sucessfully");
	}

	@Test
	public static void VerifyHeader() {
		RestAssured.baseURI = "https://api.trello.com";

		given().param("key", "d1dfe26224effc23c1af7401de92bad3")
				.param("token", "d47bf942eea147803f52866110310bde62c120809ec304b8a2c09b1eb446b5e5").when()
				.get("/1/boards/CeVM9sQI").then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
				.header("X-Trello-Environment", equalTo("Production"));

		System.out.println("This is first automation call");
		System.out.println("Get call Executed sucessfully");
	}
}
