package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// this class is to perform curd operatins 
public class User_Endpoints
{
	public static Response createUser(User payload)
	{
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)

				.when()
				.post(Routes.post_url);

		return response;	
	}

	public static Response readuser(String username)
	{
		Response response=given()
				.pathParam("username", username)
				.when()
				.get (Routes.get_url);

		return response;	
	}

	public static Response updateuser(String username,User payload)
	{
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username", username)

				.when()
				.put(Routes.put_url);

		return response;	
	}

	public static Response deleteuser(String username)
	{
		Response response=given()
				.pathParam("username", username)

				.when()
				.delete(Routes.delete_url);

		return response;	
	}

}
