package service.child;


import common.PostBase;
import common.UserBase;
import io.restassured.response.Response;
import service.ResponseService;

import java.util.HashMap;
import java.util.Map;

public class Post extends ResponseService {
    public Post(String hostUrl){
        super(hostUrl);
    }

    public Response getPostByUserId(String userId){
        return get(PostBase.POST, getQueryParams(userId) );
    }

    private Map<String, String> getQueryParams(String id) {

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("userId", id);
        return queryParams;

    }
}
