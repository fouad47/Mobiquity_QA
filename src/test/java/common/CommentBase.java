package common;

import constants.Endpoint;

public enum CommentBase implements Base {

    COMMENTS(Endpoint.GET_COMMENTS);

    private final String basePath;

    CommentBase(String basePath){
        this.basePath = basePath;
    }

    @Override
    public String path() {
        return basePath;
    }

}
