package common;

import constants.Endpoint;

public enum UserBase implements Base {
    USER(Endpoint.GET_USERS);

    private final String basePath;

    UserBase(String basePath){
        this.basePath = basePath;
    }

    @Override
    public String path() {
        return basePath;
    }
}
