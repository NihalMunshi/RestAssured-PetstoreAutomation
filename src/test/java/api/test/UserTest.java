package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.User_Endpoints;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTest 
{
	Faker faker;
	User payload;
	
	@BeforeClass
	public void setup()
	{
		faker=new Faker();
		payload= new User();
		payload.setId(faker.idNumber().hashCode());
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setUsername(faker.name().username());
		payload.setEmail(faker.internet().emailAddress());
		payload.setPassword(faker.internet().password(5,10));
		payload.setPhone(faker.phoneNumber().cellPhone());
	}
	
	@Test(priority =1)
	public void testPostUser()
	{
		Response response=User_Endpoints.createUser(payload);
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority =2)
	public void getUser()
	{
		Response response=User_Endpoints.readuser(this.payload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);	
	}
	
	@Test(priority =3)
	public void UpdateUserByUsername()
	{
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setEmail(faker.internet().emailAddress());
		
		Response response=User_Endpoints.updateuser(this.payload.getUsername(),payload);
		Assert.assertEquals(response.getStatusCode(), 200);
		//checking data after update
		
		Response response_after_update=User_Endpoints.readuser(this.payload.getUsername());
		Assert.assertEquals(response_after_update.getStatusCode(), 200);	
	}
	
	@Test(priority =4)
	public void DeleteByUsername()
	{
		Response response = User_Endpoints.deleteuser(this.payload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 404);
	}

}
