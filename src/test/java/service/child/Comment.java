package service.child;

import common.CommentBase;
import io.restassured.response.Response;
import service.ResponseService;

import java.util.HashMap;
import java.util.Map;

public class Comment extends ResponseService {
    public Comment(String hostUrl){
        super(hostUrl);
    }

    public Response getPostsCommentsByPostId(String postId){
        return get(CommentBase.COMMENTS, getQueryParams(postId) );
    }

    private static Map<String, String> getQueryParams(String id) {

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("postId", id);
        return queryParams;

    }




}
