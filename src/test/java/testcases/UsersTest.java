package testcases;

import common.UserHelper;
import constants.UserControllerConstants;
import io.restassured.response.Response;
import models.Users;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import service.child.User;

import static org.apache.http.HttpStatus.SC_OK;


public class UsersTest {
    private User userService;

    @BeforeClass
    public void setupUserService(){
        userService = new User("https://jsonplaceholder.typicode.com/");
    }

    @Test(description = "User Positive Test: Verify user search by valid username")
    public void testSearchUserByCorrectName(){
        Response response = userService.getUserByUserName(UserControllerConstants.CORRECT_USER_NAME);
        Users[] user = response.as(Users[].class);
        Assert.assertEquals(
                response.statusCode(), SC_OK, "Invalid Status Code");
        Assert.assertNotNull(UserHelper.getUserId(user), "User Id is Null");

    }


}
