package service.child;

import common.UserBase;
import io.restassured.response.Response;
import service.ResponseService;

import java.util.HashMap;
import java.util.Map;

public class User extends ResponseService {
    public User(String hostUrl){
        super(hostUrl);
    }

    public Response getUserByUserName(String name){
        return get(UserBase.USER, getQueryParams(name));
    }

    private static Map<String, String> getQueryParams(String name) {

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("username", name);
        return queryParams;

    }


}
