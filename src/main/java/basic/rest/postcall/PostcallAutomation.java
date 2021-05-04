package basic.rest.postcall;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

/**
 * @author kiran dalai
 *
 */
public class PostcallAutomation {
	@Test
	public static void Createboard() {
		RestAssured.baseURI = "https://api.trello.com";
		String board_name = "Dashboard" + (int)(Math.random()*100);  // type casted to int
		System.out.println(board_name);

		given().queryParam("key", "d1dfe26224effc23c1af7401de92bad3")
				.queryParam("token", "d47bf942eea147803f52866110310bde62c120809ec304b8a2c09b1eb446b5e5")
				.queryParam("name", board_name)
				.header("Content-Type","application/json").
				
		when()
				.post("/1/boards").
		
		then()
				.assertThat().statusCode(200).and().
				contentType(ContentType.JSON).and().
				body("name",equalTo(board_name));
	}

}
