package testcases;

import base.BaseTest;
import common.UserHelper;
import constants.UserControllerConstants;
import io.restassured.response.Response;
import models.Posts;
import models.Users;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import service.child.Post;
import service.child.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.http.HttpStatus.SC_OK;

public class PostsTest extends BaseTest {

    private User userService;
    private Post postsService;

    @BeforeClass
    public void setupUserService(){

        userService = new User("https://jsonplaceholder.typicode.com");
        postsService = new Post("https://jsonplaceholder.typicode.com");

    }

    @Test(description = "Verify fetch all posts by userid")
    public void testFetchAllPostsByUserId(){

        Response response = postsService.getPostByUserId(String.valueOf(getUserId()));
        Assert.assertEquals(
                response.statusCode(), SC_OK, "Invalid Status Code"
        );

    }

    @Test(description = "Verify posts count is greater than zero for user Delphine")
    public void testPostsCountByUserId(){

        Posts[] posts = postsService.getPostByUserId(String.valueOf(getUserId())).as(Posts[].class);
        Assert.assertTrue(
                posts.length>0, "No Post Found for User"
        );

    }

    @Test(description = "Verify that none of the post titles are blank for a valid user")
    public void testPostTitlesAreNotBlank(){

        int userId =
                UserHelper.getUserId(
                        userService.getUserByUserName(UserControllerConstants.CORRECT_USER_NAME).as(Users[].class)
                );

        List<String> postTitles = getPostTitles(String.valueOf(userId));
        for(String title : postTitles){
            softAssert.assertTrue(title != null && !title.isEmpty(), "Blank Title Found");
        }

    }

    private int getUserId() {
        return UserHelper.getUserId(
                userService.getUserByUserName(UserControllerConstants.CORRECT_USER_NAME).as(Users[].class)
        );
    }

    private List<String> getPostTitles(String userId){

        Response response = postsService.getPostByUserId(userId);
        Posts[] posts = response.as(Posts[].class);
        return Arrays.stream(posts).map(Posts::getTitle).collect(Collectors.toList());

    }

    private List<String> getPostBody(String userId){

        Response response = postsService.getPostByUserId(userId);
        Posts[] posts = response.as(Posts[].class);
        return Arrays.stream(posts).map(Posts::getBody).collect(Collectors.toList());

    }


}
