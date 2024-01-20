package api.endpoints;


//This class will contain all Urls 
/* Swagger URL --> https://petstore.swagger.io/
 * Create User --> https://petstore.swagger.io/#/user/createUser
 * Get user --> https://petstore.swagger.io/#/user/{username}
 * update user --> https://petstore.swagger.io/#/user/{username}]
 * Delete user -->https://petstore.swagger.io/#/user/{username}
 * */
public class Routes
{
	public static String base_url="https://petstore.swagger.io/v2";
	
	//User module 
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String put_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/delete/{username}";

}
