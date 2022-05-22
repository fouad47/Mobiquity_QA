package testcases;

import base.BaseTest;
import common.UserHelper;
import constants.UserControllerConstants;
import io.restassured.response.Response;
import models.Users;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import service.child.User;

import java.util.Locale;

import static org.apache.http.HttpStatus.SC_NO_CONTENT;
import static org.apache.http.HttpStatus.SC_OK;


public class UsersTest extends BaseTest {
    private User userService;

    @BeforeClass
    public void setupUserService(){
        userService = new User("https://jsonplaceholder.typicode.com");
    }

    @Test(description = "User Positive Test: Verify user search by valid username")
    public void testSearchUserByCorrectName(){
        Response response = userService.getUserByUserName(UserControllerConstants.CORRECT_USER_NAME);
        Users[] user = response.as(Users[].class);
        Assert.assertEquals(
                response.statusCode(), SC_OK, "Invalid Status Code");
        Assert.assertNotNull(UserHelper.getUserId(user), "User Id is Null");
    }

    @Test(description = "User Negative Test: Verify user search by invalid username")
    public void testSearchUserByIncorrectName(){
        Response response = userService.getUserByUserName(UserControllerConstants.INCORRECT_USER_NAME);
        Assert.assertTrue(response.getBody().print().contentEquals("[]"), "No body returned");
        Assert.assertEquals(
                response.statusCode(), SC_NO_CONTENT, "Invalid Status Code");
    }

    @Test(description = "User Negative Test: Verify user search by Normalized i.e lowercase username which does not exist")
    public void testSearchUserByNormalizedUserName(){
        Response response = userService.getUserByUserName(UserControllerConstants.CORRECT_USER_NAME.toLowerCase());
        Assert.assertTrue(response.getBody().print().contentEquals("[]"), "No body returned");
        Assert.assertEquals(
                response.statusCode(), SC_NO_CONTENT, "Invalid Status Code");
    }


}
